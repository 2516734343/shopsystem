var data = [];
function bindEvent() {
    // 切换左侧导航事件
    $('#menu-list').on('click', 'li', function() {
        // 切换左侧导航样式
        $('.active').removeClass('active');
        $(this).addClass('active');
        // 获取导航对应的内容元素
        var id = $(this).data('id');
        // 切换右侧内容区
        $('.content').fadeOut();
        $('#' + id).fadeIn();
    });
}
bindEvent();


//获取商品数据
function getGoodsData(){
    $.ajax({
        url:'/goodsInfo/selectAll',
        type:'post',
        success:function (res) {
            data = res;
            console.log('goods',res);
            renderGoods(res);
        }
    })
}
function renderGoods(res) {
    console.log(res);
    var str = "";
    res.forEach(function (item, index) {
        str += " <tr>\
            <td>" + item.goodsid + "</td>\
            <td>" + item.goodsname+ "</td>\
            <td>" + item.goodstype + "</td>\
            <td>" + item.goodssellprice + "</td>\
            <td>" + item.goodsinputprice + "</td>\
            <td>" + item.goodsallnumber + "</td>\
            <td>" + item.goodsleftnumber+ "</td>\
            <td>\
                <button class='btn edit' data-index=" + index + ">修改</button>\
                <button class='btn del' data-index=" + index + ">删除</button>\
                <button class='btn addToCar' data-index=" + index + ">加入购物车</button>\
            </td>\
        </tr>";
    })
    $('#tbody').html(str);
}
// 增加商品
function insertGoodsInfo() {
    $('.addBtn').click(function () {
        $('.add-modal').slideDown();
        $('#add-submit-btn').click(function (e) {
            e.preventDefault();
            var data = $('.add-form-1').serializeArray();
            data = formatData(data);
            console.log('59',data);
            if(!data) {
                alert('请将信息填写完全后提交');
            } else {
                $.ajax({
                    url:'/goodsInfo/insert',
                    type:'post',
                    data:data,
                    success:function (res) {
                        alert('添加成功');
                        $('.add-modal').slideUp();
                        getGoodsData();
                        // console.log('update',res);
                    }
                })
            }
        });
        // 点击遮罩层编辑弹框消失
        $('.add-mask').click(function() {
            $('.add-modal').slideUp();
        });

    })
}

//修改商品信息
function updateGoodsInfo() {
    var index;
    $('#tbody').on('click', '.edit',  function (e) {
        // 编辑弹框显示
        $('.modal').slideDown();
        // 回填编辑弹框内表单数据
        index = $(this).parents('tr').index();
        renderEditForm(data[index]);
        // 删除按钮点击事件
    })
    // 点击遮罩层编辑弹框消失
    $('.mask').click(function() {
        $('.modal').slideUp();
    });
    // 编辑表单提交
    $('#edit-submit-btn').click(function (e) {
        e.preventDefault();
        var data = $('.edit-form').serializeArray();
        data = formatData(data);
        // console.log('54',data);
        if(!data) {
            alert('请将信息填写完全后提交');
        } else {
            $.ajax({
                url:'/goodsInfo/updateByPrimaryKey',
                type:'post',
                data:data,
                success:function (res) {
                    alert('提交成功');
                    $('.modal').slideUp();
                    getGoodsData();
                    // console.log('update',res);
                }
            })
        }
    });
}
//删除商品信息
function deleteGoods() {
    $('#tbody').on('click', '.del',  function (e) {
        // 删除的索引
        var index = $(this).parents('tr').index();
        console.log('删除是的数据',data[index]);
        // 确认删除弹框
        var isDel = confirm('确认删除'  + data[index].goodsname + '商品信息?');
        if(isDel) {
            // 删除信息
            $.ajax({
                url: '/goodsInfo/deleteByPrimaryKey',
                type: 'post',
                data: {
                    pro_id:data[index].goodsid
                },
                success: function (res) {
                    console.log(res);
                    alert('删除成功');
                    getGoodsData();
                }
            })
        }
    });
}
//根据商品id搜索商品信息
// function searchGoodsInfo(){
//     var val = document.getElementById('search').value;
//     console.log('117',val);
//     $('#searchBtn').click(function () {
//         console.log(val);
//         $.ajax({
//             url: '/goodsInfo/selectByPrimaryKey',
//             type: 'post',
//             dataType: 'json',
//             data: {
//                pro_id:val
//             },
//             async: true, //异步   
//             error: function (res) {
//                 alert('error');
//             },
//             success: function (jsonData) {
//                 var c = JSON.stringify(jsonData)
//                 // alert(c);
//                 console.log('1111', c);
//             }
//         })
//     })
//
// }
// searchGoodsInfo();
//加入购物车
$('#tbody').on('click', '.addToCar',  function (e) {
    //加入购物车商品的索引
    var index = $(this).parents('tr').index();
    $.ajax({
        url:'/shoppingcar/insert',
        type:'post',
        data:data[index],
        success:function (res) {
            console.log(res);
            alert('加入购物车成功');
        }
    })
})
getGoodsData();
insertGoodsInfo();
updateGoodsInfo();
deleteGoods();

// 回填表单数据
function renderEditForm(data) {
    var form = $('#edit-form')[0];
    for (var prop in data) {
        form[prop] ? form[prop].value = data[prop] : '';
    }
}
// 将表单数据转换成对象
function formatData(data) {
    var obj = {};
    // for循环的数据可以是数组  也可以是对象（类数组）
    // forEach循环只能是数组
    for (var i = 0; i < data.length; i++) {
        var item = data[i];
        if (!item.value) {
            // 如果是数组的forEach  或者map  filter  方法中return的话  代表的是方法的返回值
            // 否则是最近一层函数的返回值
            return false;
        }
        obj[item.name] = item.value;
    }
    return obj;
}


//获取商品类别数据
function getGoodsType() {
    $.ajax({
        url:'/goodsType/selectAll',
        type:'post',
        success:function (res) {
            console.log('shopType',res);
            renderGoodsType(res);
        }
    })
}
getGoodsType();
function renderGoodsType(res) {
    var str = "";
    res.forEach(function (item,index) {
        str += " <tr>\
            <td>" + item.typeid + "</td>\
            <td>" + item.typename+ "</td>\
            <td>\
                <button class='btn edit' data-index=" + index + ">修改</button>\
                <button class='btn del' data-index=" + index + ">删除</button>\
            </td>\
        </tr>";
    })
    $('#tbody-goodsType').html(str);
}


//获取购物车信息
function getCarData() {
    $.ajax({
        url:'/shoppingcar/selectAll',
        type:'post',
        success:function (res) {
            console.log('car',res);
            renderMyCar(res);
        }
    })
    // $.ajax({
    //     url:'/shoppingcar//selectByUser',
    //     type:'get',
    //     success:function (res) {
    //         console.log('userCar',res);
    //     }
    // })
}
getCarData();
function renderMyCar(res) {
    var str = "";
    res.forEach(function (item,index) {
        str += " <tr>\
            <td>" + item.userid + "</td>\
            <td>" + item.goodid+ "</td>\
            <td>" + item.goodsnumber + "</td>\
            <td>" + item.tocardate + "</td>\
            <td>\
                <button class='btn edit' data-index=" + index + ">修改</button>\
                <button class='btn del' data-index=" + index + ">删除</button>\
                <button class='btn addToCar' data-index=" + index + ">下单</button>\
            </td>\
        </tr>";
    })
    $('#tbody-myCar').html(str);
}


//获取订单信息
function getOrderData() {
    $.ajax({
        url:'/itemInfo/selectAll',
        type:'post',
        success:function (res) {
            console.log('order',res);
            renderOrder(res);
        }
    })
}
getOrderData();
function renderOrder(res) {
    var str = "";
    res.forEach(function (item,index) {
        str += " <tr>\
            <td>" + item.itemid + "</td>\
            <td>" + item.itemuserid+ "</td>\
            <td>" + item.itemreceiveinfo + "</td>\
            <td>" + item.itembuydate + "</td>\
        </tr>";
    })
    $('#order-tbody').html(str);
}

//获取订单状态信息
function getOrderDeatil() {
    $.ajax({
        url:'/itemGoods/selectAll',
        type:'post',
        success:function (res) {
            console.log('orderDetail',res);
            renderOrderDeatil(res);
        }
    })
}
getOrderDeatil();
function renderOrderDeatil(res) {
    var str = "";
    res.forEach(function (item,index) {
        str += " <tr>\
            <td>" + item.itemid + "</td>\
            <td>" + item.goodsid+ "</td>\
            <td>" + item.goodsstatus+ "</td>\
            <td>" + item.goodsinputprice+ "</td>\
            <td>" + item.goodssellprice+ "</td>\
           <td>" + item.goodssellnumber+ "</td>\
            <td>\
                <button class='btn edit' id='updateOrderStatus' data-index=" + index + ">修改订单状态</button>\
            </td>\
        </tr>";
    })
    $('#tbody-orderDeatil').html(str);
}


//用户信息
function getUserData() {
    $.ajax({
        url:'/userInfo/selectAll',
        type:'post',
        success:function (res) {
            console.log('user',res);
            renderUserInfo(res);
        }
    })
}
getUserData();
function renderUserInfo(res) {
    var str = "";
    res.forEach(function (item,index) {
        str += " <tr>\
            <td>" + item.userid + "</td>\
            <td>" + item.username+ "</td>\
            <td>\
                <button class='btn edit' data-index=" + index + ">修改</button>\
                <button class='btn del' data-index=" + index + ">删除</button>\
            </td>\
        </tr>";
    })
    $('#user-tbody').html(str);
}