-- MySQL dump 10.11
--
-- Host: localhost    Database: crm
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
create database if not exists `crm`;
use `crm`;
--
-- Table structure for table `care_activity`
--

DROP TABLE IF EXISTS `care_activity`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `care_activity` (
  `careActivityID` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(45) NOT NULL,
  `decription` text,
  `activityTime` datetime NOT NULL,
  `form` varchar(45) default NULL,
  `customerType` varchar(45) default NULL,
  PRIMARY KEY  (`careActivityID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `care_activity`
--

LOCK TABLES `care_activity` WRITE;
/*!40000 ALTER TABLE `care_activity` DISABLE KEYS */;
INSERT INTO `care_activity` VALUES (1,'端午节活动1+Modified','活动描述','2010-07-23 11:16:31','发邮件','购房用户'),(2,'端午节活动2+Modified','活动描述','2010-07-23 11:16:33','发邮件','购房用户'),(3,'端午节活动3+Modified','活动描述','2010-07-23 11:16:33','发邮件','购房用户'),(4,'端午节活动4+Modified','活动描述','2010-07-23 11:16:33','发邮件','购房用户'),(5,'端午节活动5+Modified','活动描述','2010-07-23 11:16:33','发邮件','购房用户'),(6,'端午节活动1+Modified','活动描述','2010-07-23 13:45:40','发邮件','购房用户'),(7,'端午节活动2+Modified','活动描述','2010-07-23 13:45:41','发邮件','购房用户'),(8,'端午节活动3+Modified','活动描述','2010-07-23 13:45:41','发邮件','购房用户'),(9,'端午节活动4+Modified','活动描述','2010-07-23 13:45:41','发邮件','购房用户'),(10,'端午节活动5+Modified','活动描述','2010-07-23 13:45:41','发邮件','购房用户');
/*!40000 ALTER TABLE `care_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `company` (
  `companyID` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `corporation` varchar(45) default NULL,
  `recordDate` date default NULL,
  `address` varchar(50) default NULL,
  `type` varchar(20) default NULL,
  `homePage` varchar(45) default NULL,
  `telephone` varchar(15) default NULL,
  `postcard` varchar(6) default NULL,
  `history` text,
  PRIMARY KEY  (`companyID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'天辉房地产公司','许润华','2010-07-21','太白路','房地产','http://www.d.com','12312341224','222','历史悠久'),(2,'XX房地产公司2 Modified+Modified',NULL,'2010-07-21',NULL,NULL,NULL,NULL,NULL,NULL),(3,'XX房地产公司3 Modified+Modified',NULL,'2010-07-21',NULL,NULL,NULL,NULL,NULL,NULL),(4,'XX房地产公司4 Modified+Modified',NULL,'2010-07-21',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competitor_info`
--

DROP TABLE IF EXISTS `competitor_info`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `competitor_info` (
  `competitorInfoID` int(10) unsigned NOT NULL auto_increment,
  `marketStrategy` text,
  `companyID` int(10) unsigned NOT NULL,
  `project` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`competitorInfoID`),
  KEY `FK_competitorInfo_1` (`companyID`),
  KEY `FK_competitorInfo_2` (`project`),
  CONSTRAINT `FK_competitorInfo_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_competitorInfo_2` FOREIGN KEY (`project`) REFERENCES `residence_community` (`residenceID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `competitor_info`
--

LOCK TABLES `competitor_info` WRITE;
/*!40000 ALTER TABLE `competitor_info` DISABLE KEYS */;
INSERT INTO `competitor_info` VALUES (1,'某某营销策略1',4,4),(2,'某某营销策略2',4,4),(3,'某某营销策略3',4,4),(4,'某某营销策略4+Modified',4,4);
/*!40000 ALTER TABLE `competitor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `customer` (
  `customerID` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `gender` varchar(2) NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(45) default NULL,
  `isMarried` tinyint(1) default NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `hasHouse` tinyint(1) default NULL,
  `houseID` int(10) unsigned default NULL,
  `houseIntent` varchar(100) default NULL,
  `income` varchar(45) default NULL,
  `job` varchar(45) default NULL,
  `hobby` varchar(100) default NULL,
  PRIMARY KEY  (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'王某1','F','2010-07-22','某某小区+Modified',0,'12345678978','dd@dd.com',0,NULL,'舒适经济房','Level 1','教室','玩玩玩哪玩哪玩哪玩往往能'),(3,'王某3','F','2010-07-22','某某小区+Modified',0,'12345678978','dd@dd.com',0,NULL,'舒适经济房','Level 1','教室','玩玩玩哪玩哪玩哪玩往往能'),(4,'王某4','F','2010-07-22','某某小区+Modified',0,'12345678978','dd@dd.com',0,NULL,'舒适经济房','Level 1','教室','玩玩玩哪玩哪玩哪玩往往能'),(5,'测试级联添加客户','M','2010-07-22',NULL,NULL,'12312341234','xu@xx.com',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_connection`
--

DROP TABLE IF EXISTS `customer_connection`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `customer_connection` (
  `connectionID` int(10) unsigned NOT NULL auto_increment,
  `content` text NOT NULL,
  `recordTime` datetime NOT NULL,
  `reply` varchar(200) default NULL,
  `employeeID` int(10) unsigned NOT NULL,
  `customerID` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`connectionID`),
  KEY `FK_CustomerConnection_1` (`customerID`),
  KEY `FK_CustomerConnection_2` (`employeeID`),
  CONSTRAINT `FK_CustomerConnection_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CustomerConnection_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `customer_connection`
--

LOCK TABLES `customer_connection` WRITE;
/*!40000 ALTER TABLE `customer_connection` DISABLE KEYS */;
INSERT INTO `customer_connection` VALUES (1,'联系内容+Modified','2010-07-23 14:16:30','回复内容',5,5),(2,'联系内容+Modified','2010-07-23 14:16:30','回复内容',5,5),(3,'联系内容+Modified','2010-07-23 14:16:30','回复内容',5,5),(4,'联系内容+Modified','2010-07-23 14:16:30','回复内容',5,5);
/*!40000 ALTER TABLE `customer_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_feedback`
--

DROP TABLE IF EXISTS `customer_feedback`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `customer_feedback` (
  `customerFeedbackID` int(10) unsigned NOT NULL auto_increment,
  `customerID` int(10) unsigned NOT NULL,
  `employeeID` int(10) unsigned NOT NULL,
  `markSeller` int(10) unsigned NOT NULL,
  `adviceSeller` varchar(200) default NULL,
  `markEnvironment` int(10) unsigned NOT NULL,
  `markTenement` int(10) unsigned NOT NULL,
  `markTraffic` int(10) unsigned NOT NULL,
  `markAll` int(10) unsigned NOT NULL,
  `recordTime` datetime default NULL,
  PRIMARY KEY  (`customerFeedbackID`),
  KEY `FK_customerFeedback_1` (`customerID`),
  KEY `FK_customerFeedback_2` (`employeeID`),
  CONSTRAINT `FK_customerFeedback_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customerFeedback_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `customer_feedback`
--

LOCK TABLES `customer_feedback` WRITE;
/*!40000 ALTER TABLE `customer_feedback` DISABLE KEYS */;
INSERT INTO `customer_feedback` VALUES (1,5,5,7,'销售服务态度很好',7,7,6,4,'2010-07-23 13:56:03'),(2,5,5,7,'销售服务态度很好',7,7,6,4,'2010-07-23 13:56:03'),(3,5,5,7,'销售服务态度很好',7,7,6,4,'2010-07-23 13:56:03'),(4,5,5,7,'销售服务态度很好',7,7,6,4,'2010-07-23 13:56:03');
/*!40000 ALTER TABLE `customer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `employee` (
  `employeeID` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `gender` varchar(2) default NULL,
  `birthday` date default NULL,
  `isMarried` tinyint(1) default NULL,
  `address` varchar(50) default NULL,
  `hobby` varchar(45) default NULL,
  `comeTime` date default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `post` varchar(45) default NULL,
  `isManager` tinyint(1) default NULL,
  `password` varchar(45) default NULL,
  PRIMARY KEY  (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'许润华','M','2010-07-28',0,'朝阳小区24','旅游','2010-07-22','12312354321','xx@xx.com','SaleDepartment','720201',0,'aaaa'),(3,'张2','M','2010-07-22',0,'某某小区某某路2#Modified','打球打球打球','2010-07-22','12312354321','xx@xx.com','MarketDepartment','720201',1,'aaaa'),(4,'张3','M','2010-07-22',0,'某某小区某某路3#Modified','打球打球打球','2010-07-22','12312354321','xx@xx.com','ServiceDepartment','720201',0,'aaaa'),(5,'测试级联添加员工',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'aaaa');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_customer_list`
--

DROP TABLE IF EXISTS `employee_customer_list`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `employee_customer_list` (
  `ecListID` int(10) unsigned NOT NULL auto_increment,
  `employeeID` int(10) unsigned NOT NULL,
  `customerID` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`ecListID`),
  KEY `FK_ecList_customer` (`customerID`),
  KEY `FK_ecList_employee` (`employeeID`),
  CONSTRAINT `FK_ecList_customer` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ecList_employee` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `employee_customer_list`
--

LOCK TABLES `employee_customer_list` WRITE;
/*!40000 ALTER TABLE `employee_customer_list` DISABLE KEYS */;
INSERT INTO `employee_customer_list` VALUES (1,5,5),(2,1,1),(3,1,3),(4,1,4);
/*!40000 ALTER TABLE `employee_customer_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `house` (
  `houseID` int(10) unsigned NOT NULL auto_increment,
  `area` double NOT NULL,
  `position` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `isSale` tinyint(1) default NULL,
  `residenceID` int(10) unsigned NOT NULL,
  `customerID` int(10) unsigned default NULL,
  `asEmployee` int(10) unsigned default NULL,
  `saleEmployee` int(10) unsigned default NULL,
  `saleTime` datetime default NULL,
  PRIMARY KEY  (`houseID`),
  KEY `FK_house_1` (`residenceID`),
  KEY `FK_house_2` (`asEmployee`),
  KEY `FK_house_3` (`saleEmployee`),
  CONSTRAINT `FK_house_1` FOREIGN KEY (`residenceID`) REFERENCES `residence_community` (`residenceID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_house_2` FOREIGN KEY (`asEmployee`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_house_3` FOREIGN KEY (`saleEmployee`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (1,129.33,'3d205',4000,1,1,0,4,1,'2010-07-28 18:16:53'),(2,129.33,'3d205',4000,1,1,3,4,1,'2010-07-29 14:08:17'),(3,129.33,'3d205',4000,0,1,0,4,1,NULL),(4,129.33,'3d205',4000,0,1,0,4,1,NULL),(5,123.4,'3栋504',3334.56,0,3,0,4,1,NULL),(6,123.4,'3栋304',3334.56,1,1,4,4,1,'2010-07-29 14:11:32'),(7,123.4,'3栋204',3334.56,0,4,0,4,1,NULL),(8,123.4,'3栋504',3334.56,0,2,0,4,1,NULL),(9,123.4,'3栋504',3334.56,0,4,0,4,1,NULL),(10,123.4,'3栋304',3334.56,0,2,0,4,1,NULL);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `notice` (
  `noticeId` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `recordTime` datetime NOT NULL,
  `classify` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  PRIMARY KEY  (`noticeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'开会通知1','2010.7.29下午开会,119会议室','2010-07-28 18:16:53','Manager','市场主管'),(2,'开会通知2','2010.7.29下午开会,119会议室','2010-07-28 18:16:54','Manager','市场主管'),(3,'开会通知3','2010.7.29下午开会,119会议室','2010-07-28 18:16:54','Manager','市场主管'),(4,'系统通知1','2010.7.29系统更新通知，届时封闭系统','2010-07-28 18:16:54','System','Admin'),(5,'系统通知2','2010.7.29系统更新通知，届时封闭系统','2010-07-28 18:16:54','System','Admin'),(6,'系统通知3','2010.7.29系统更新通知，届时封闭系统','2010-07-28 18:16:54','System','Admin');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair_record`
--

DROP TABLE IF EXISTS `repair_record`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `repair_record` (
  `repairRecordID` int(10) unsigned NOT NULL auto_increment,
  `customerID` int(10) unsigned NOT NULL,
  `employeeID` int(10) unsigned NOT NULL,
  `decription` varchar(500) NOT NULL,
  `handle` varchar(500) NOT NULL,
  `isVerify` tinyint(1) NOT NULL,
  `newHandle` varchar(500) NOT NULL,
  `beginTime` datetime default NULL,
  `endTime` datetime default NULL,
  PRIMARY KEY  (`repairRecordID`),
  KEY `FK_repairRecord_1` (`customerID`),
  KEY `FK_repairRecord_2` (`employeeID`),
  CONSTRAINT `FK_repairRecord_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_repairRecord_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `repair_record`
--

LOCK TABLES `repair_record` WRITE;
/*!40000 ALTER TABLE `repair_record` DISABLE KEYS */;
INSERT INTO `repair_record` VALUES (1,5,5,'水管坏了+Modify','明天拍维修工',0,'同意','2010-07-16 15:11:44','2010-07-30 15:11:46'),(2,5,5,'水管坏了','明天拍维修工',0,'同意','2010-07-16 15:11:46','2010-07-30 15:11:46'),(3,5,5,'水管坏了','明天拍维修工',0,'同意','2010-07-16 15:11:46','2010-07-30 15:11:46'),(4,5,5,'水管坏了','明天拍维修工',0,'同意','2010-07-16 15:11:46','2010-07-30 15:11:46');
/*!40000 ALTER TABLE `repair_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residence_community`
--

DROP TABLE IF EXISTS `residence_community`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `residence_community` (
  `residenceID` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `area` double default NULL,
  `type` varchar(45) default NULL,
  `description` text,
  `company` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`residenceID`),
  KEY `FK_ResidenceCommunity_company` (`company`),
  CONSTRAINT `FK_ResidenceCommunity_company` FOREIGN KEY (`company`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `residence_community`
--

LOCK TABLES `residence_community` WRITE;
/*!40000 ALTER TABLE `residence_community` DISABLE KEYS */;
INSERT INTO `residence_community` VALUES (1,'XX小区1Modified','XX市区XX路1',189.22,'住宅',NULL,1),(2,'XX小区2Modified','XX市区XX路2',189.22,'住宅',NULL,1),(3,'XX小区3Modified','XX市区XX路3',123.22,'商务',NULL,1),(4,'XX小区4Modified','XX市区XX路4',123.22,'商务',NULL,1);
/*!40000 ALTER TABLE `residence_community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `task` (
  `taskID` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(60) NOT NULL,
  `content` text NOT NULL,
  `beginTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `isComplement` tinyint(1) NOT NULL,
  PRIMARY KEY  (`taskID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'任务标题0','任务计划安排0修改测试','2010-07-21 14:41:36','2010-07-21 14:41:36',0),(3,'任务标题1','任务计划安排1修改测试','2010-07-21 14:41:37','2010-07-21 14:41:37',0),(4,'任务标题2','任务计划安排2修改测试','2010-07-21 14:41:37','2010-07-21 14:41:37',0),(5,'任务标题3','任务计划安排3修改测试','2010-07-21 14:41:37','2010-07-21 14:41:37',0),(6,'任务标题4','任务计划安排4修改测试','2010-07-21 14:41:37','2010-07-21 14:41:37',0),(7,'某某营销计划','这是营销计划的内容','2010-07-15 14:07:30','2010-07-29 14:07:30',0),(8,'某某营销计划2','这是营销计划的内容2','2010-07-15 14:08:17','2010-07-29 14:08:17',0);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_participant_list`
--

DROP TABLE IF EXISTS `task_participant_list`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `task_participant_list` (
  `taskEmployeeListID` int(10) unsigned NOT NULL auto_increment,
  `taskID` int(10) unsigned NOT NULL,
  `employeeID` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`taskEmployeeListID`),
  KEY `FK_taskParticipantList_1` (`taskID`),
  KEY `FK_taskParticipantList_2` (`employeeID`),
  CONSTRAINT `FK_taskParticipantList_1` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_taskParticipantList_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `task_participant_list`
--

LOCK TABLES `task_participant_list` WRITE;
/*!40000 ALTER TABLE `task_participant_list` DISABLE KEYS */;
INSERT INTO `task_participant_list` VALUES (1,7,1),(2,8,1);
/*!40000 ALTER TABLE `task_participant_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-07-29  6:30:17
