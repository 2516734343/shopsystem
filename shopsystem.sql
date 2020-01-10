-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shopsystem
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `goodstype`
--

DROP TABLE IF EXISTS `goodstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodstype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodstype`
--

LOCK TABLES `goodstype` WRITE;
/*!40000 ALTER TABLE `goodstype` DISABLE KEYS */;
INSERT INTO `goodstype` VALUES (1,'数码'),(2,'食品'),(3,'百货'),(4,'男装'),(5,'女装'),(6,'生鲜'),(8,'袜子'),(9,'aaa'),(10,'oko'),(11,'dddddd'),(12,'张钦'),(13,'裤子'),(21,'ddd'),(22,'手机');
/*!40000 ALTER TABLE `goodstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_cart`
--

DROP TABLE IF EXISTS `order_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_cart` (
  `user_Id` int(11) NOT NULL COMMENT '用户id',
  `pro_Id` int(11) NOT NULL COMMENT '商品id',
  `goodsNumber` int(11) NOT NULL COMMENT '购买商品的数量',
  `toCarDate` date NOT NULL COMMENT '商品加入购物车时间',
  KEY `goodid` (`pro_Id`),
  KEY `userid` (`user_Id`),
  CONSTRAINT `order_cart_ibfk_1` FOREIGN KEY (`pro_Id`) REFERENCES `product` (`pro_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_cart_ibfk_2` FOREIGN KEY (`user_Id`) REFERENCES `users` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_cart`
--

LOCK TABLES `order_cart` WRITE;
/*!40000 ALTER TABLE `order_cart` DISABLE KEYS */;
INSERT INTO `order_cart` VALUES (1,1,1,'2019-12-31');
/*!40000 ALTER TABLE `order_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderss`
--

DROP TABLE IF EXISTS `orderss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderss` (
  `orderss_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `orderss_UserId` int(11) NOT NULL COMMENT '订单的用户id',
  `orderss_ReceiveInfo` int(11) NOT NULL COMMENT '订单的收货信息',
  `orderss_BuyDate` date NOT NULL COMMENT '订单下单日期',
  PRIMARY KEY (`orderss_Id`),
  KEY `itemReceiveInfo` (`orderss_ReceiveInfo`),
  CONSTRAINT `orderss_ibfk_1` FOREIGN KEY (`orderss_ReceiveInfo`) REFERENCES `users_addr` (`userAddressId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='订单表信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderss`
--

LOCK TABLES `orderss` WRITE;
/*!40000 ALTER TABLE `orderss` DISABLE KEYS */;
INSERT INTO `orderss` VALUES (3,2,3,'2019-12-21'),(4,3,4,'2018-09-20'),(5,5,5,'2019-12-28'),(15,1,2,'2019-12-25'),(17,2,3,'2019-12-27'),(18,2,3,'2019-12-28'),(19,2,4,'2019-12-28'),(21,1,1,'2019-12-29'),(22,4,11,'2020-01-04');
/*!40000 ALTER TABLE `orderss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderssinfo`
--

DROP TABLE IF EXISTS `orderssinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderssinfo` (
  `orderss_Info` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品订单序号',
  `Orderss_Id` int(11) NOT NULL COMMENT '订单的id',
  `pro_Id` int(11) NOT NULL COMMENT '商品id',
  `orderss_Status` enum('未发货','已发货','已收货','') NOT NULL COMMENT '商品状态',
  `pro_Sell` float NOT NULL COMMENT '售价',
  `pro_Cost` float NOT NULL COMMENT '成本价',
  `orderss_SellNumber` int(11) NOT NULL COMMENT '出售数量',
  PRIMARY KEY (`orderss_Info`),
  KEY `goodsId` (`pro_Id`),
  KEY `ItemId` (`Orderss_Id`),
  CONSTRAINT `orderssinfo_ibfk_1` FOREIGN KEY (`pro_Id`) REFERENCES `product` (`pro_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderssinfo_ibfk_2` FOREIGN KEY (`Orderss_Id`) REFERENCES `orderss` (`orderss_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='订单商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderssinfo`
--

LOCK TABLES `orderssinfo` WRITE;
/*!40000 ALTER TABLE `orderssinfo` DISABLE KEYS */;
INSERT INTO `orderssinfo` VALUES (19,15,1,'未发货',200,225,3),(20,15,2,'未发货',3,1,3),(21,15,3,'已收货',3.1,1.5,3),(23,15,5,'已收货',56,25,3),(24,17,1,'未发货',200,71.4286,3),(25,17,2,'未发货',3,1,3),(26,17,3,'未发货',3.1,1.5,3),(28,17,5,'已收货',56,25,3),(29,21,2,'未发货',3,1,5),(31,21,3,'未发货',3.1,1.5,5),(32,21,1,'未发货',200,71.4286,3),(33,22,1,'未发货',200,71.4286,3),(34,22,2,'未发货',3,1,3),(35,22,3,'未发货',3.1,1.5,3),(37,22,5,'未发货',56,25,4);
/*!40000 ALTER TABLE `orderssinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pro_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `pro_Name` varchar(20) NOT NULL COMMENT '商品名称',
  `goodsType` int(11) NOT NULL COMMENT '商品类别',
  `pro_Sell` float NOT NULL COMMENT '商品售价',
  `pro_Cost` float NOT NULL COMMENT '商品成本',
  `pro_All` int(11) NOT NULL COMMENT '商品总量',
  `pro_Left` int(11) NOT NULL COMMENT '商品余量',
  PRIMARY KEY (`pro_Id`),
  KEY `goodsType` (`goodsType`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`goodsType`) REFERENCES `goodstype` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'短裙',1,200,71.4286,140,173),(2,'水杯',3,3,1,200,669),(3,'鸡蛋',3,3.1,1.5,600,239),(5,'围裙',5,56,25,120,14),(6,'面巾纸',2,30,20,15,300),(8,'糖炒栗子',1,100,50,100,20),(14,'水蜜桃',2,30,30,20,110),(15,'连衣裙',2,30,30,20,100),(16,'餐巾纸',1,12,200,200,200),(30,'哈密瓜',2,20,22,50,50),(31,'电脑',1,200,150,12,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_Name` varchar(20) NOT NULL COMMENT '用户姓名',
  `user_pass` varchar(45) NOT NULL,
  `user_Tel` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `user_Email` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  `user_Sex` enum('男','女') DEFAULT NULL COMMENT '用户性别',
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'小辣椒','9082jkl','19087653890','8793@qq.com','女'),(2,'小仙女','jsk','12367898765','228432687@22.com','女'),(3,'小毛驴','1','12890987654','648754637@163.com','男'),(4,'小米粥','1','16578909876','7443@sina.com','女'),(5,'大米粥','jhkl','17689087654','476547@qq.com','男'),(7,'我没有钱','1111','16547890987','64734@163.com','女'),(10,'买不起','2222','16789098765','7474dbh@163.com','男');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_addr`
--

DROP TABLE IF EXISTS `users_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_addr` (
  `userAddressId` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL COMMENT '用户的id',
  `userReceiveAddress` varchar(200) NOT NULL COMMENT '用户收货地址',
  `userReceiveName` varchar(20) NOT NULL COMMENT '用户收货昵称',
  `userReceivephone` varchar(20) NOT NULL COMMENT '用户收货联系方式',
  PRIMARY KEY (`userAddressId`),
  KEY `userId` (`user_Id`),
  CONSTRAINT `users_addr_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_addr`
--

LOCK TABLES `users_addr` WRITE;
/*!40000 ALTER TABLE `users_addr` DISABLE KEYS */;
INSERT INTO `users_addr` VALUES (1,1,'sss','77','55'),(2,1,'sss','77','ds'),(3,2,'辽宁省','孔令涛','33'),(4,3,'云南省','不知道','44'),(5,5,'黑龙江','老师','88'),(8,1,'11','11','11'),(10,2,'ee','ddd','dd'),(11,4,'新乡市','张钦','188');
/*!40000 ALTER TABLE `users_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopsystem'
--

--
-- Dumping routines for database 'shopsystem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-09 21:34:08
