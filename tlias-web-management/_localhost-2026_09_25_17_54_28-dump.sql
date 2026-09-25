-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tlias
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'学工部','2024-09-25 09:47:40','2026-08-23 19:12:53'),(2,'教研部','2024-09-25 09:47:40','2024-09-25 09:47:40'),(3,'咨询部','2024-09-25 09:47:40','2024-09-25 09:47:40'),(4,'就业部','2024-09-25 09:47:40','2024-09-25 09:47:40'),(5,'人事部','2024-09-25 09:47:40','2024-09-25 09:47:40'),(6,'神经部','2025-09-25 09:47:40','2034-09-02 00:00:00');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性别,1:男,2:女',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位,1:班主任,2:讲师,3:学工主管,4:教研室,5:咨询师',
  `salary` int unsigned DEFAULT NULL COMMENT '薪资',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int unsigned DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'choushabi','123456','施耐庵22',1,'13390909001',4,15000,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2008-01-01',55,'2026-08-27 17:16:47','2029-10-20 16:35:33'),(2,'songjiang','123456','宋江',1,'13390909002',2,8600,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(3,'lujunyi','123456','卢俊义',1,'13390909003',2,8900,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2008-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(4,'wuyong','123456','吴用',1,'13390909004',2,8700,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2007-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(5,'gongsunsheng','123456','公孙胜',1,'13309900005',2,9500,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2012-12-05',2,'2023-10-20 16:36:33','2023-10-20 16:36:33'),(6,'huosanniang','123456','扈三娘',2,'13309900006',3,6500,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2013-09-05',1,'2023-10-20 16:36:33','2023-10-20 16:36:33'),(7,'chaijin','123456','柴进',1,'13309900007',1,4700,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2005-08-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(8,'likui','123456','李逵',1,'13309900008',1,4800,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2014-11-09',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(9,'wusong','123456','武松',1,'13309900009',1,4900,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2011-03-11',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(10,'linchong','123456','林冲',1,'13309900010',1,5000,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(11,'huyanzhuo','123456','呼延灼',1,'13309900011',2,9700,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2007-02-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(12,'xiaoliugang','123456','小李广',1,'13309900012',2,10000,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2008-08-18',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(13,'yangzhi','123456','杨志',1,'13309900013',1,5300,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2012-11-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(14,'shijin','123456','史进',1,'13309900014',2,16000,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2002-08-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(15,'sunrenning','123456','孙二娘',2,'13309900015',2,10900,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2011-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(16,'luzhishen','123456','鲁智深',1,'13309900016',2,9600,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2010-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(17,'liying','12345678','李应',1,'13309900017',1,5800,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2015-03-21',1,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(18,'shiqian','123456','时迁',1,'13309900018',2,10200,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(19,'gudasao','123456','顾大嫂',2,'13309900019',2,10500,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2008-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(20,'ruanxiaoer','123456','阮小二',1,'13309900020',2,10800,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2018-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(21,'ruanxiaoqu','123456','阮小五',1,'13309900021',5,5200,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2015-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(22,'ruanxiaoqi','123456','阮小七',1,'13309900022',5,5500,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2016-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(23,'ruanjii','123456','阮籍',1,'13309900023',5,5800,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(24,'tongwei','123456','童威',1,'13309900024',5,5000,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2006-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(25,'tongmeng','123456','童猛',1,'13309900025',5,4800,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33'),(26,'yanshun','123456','燕顺',1,'13309900026',5,5400,'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png','2011-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:35:33');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `emp_id` int unsigned DEFAULT NULL COMMENT '员工ID',
  `begin` date DEFAULT NULL COMMENT '开始时间',
  `end` date DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` VALUES (47,1,'2010-07-01','2012-06-30','阿里巴巴1',NULL),(48,1,'2012-08-01','2015-12-31','腾讯科技2',NULL),(49,1,'2016-03-01','2020-09-30','字节跳动3',NULL);
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_log`
--

DROP TABLE IF EXISTS `emp_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `info` varchar(2000) DEFAULT NULL COMMENT '日志信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_log`
--

LOCK TABLES `emp_log` WRITE;
/*!40000 ALTER TABLE `emp_log` DISABLE KEYS */;
INSERT INTO `emp_log` VALUES (2,'2026-08-25 19:26:51','新增员工emp(id=73, username=yuebuqun, password=null, name=岳不群, gender=1, phone=1889091236, job=1, salary=8000, image=https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-03-07-37-38222.jpg, entry_date=2022-09-18, dept_id=1, create_time=2026-08-25T19:26:50.663956200, update_time=2026-08-25T19:26:50.663956200, dept_name=null, exprList=[emp_expr(id=null, empId=null, begin=2012-07-01, end=2019-03-03, company=百度科技股份有限公司, job=java开发), emp_expr(id=null, empId=null, begin=2019-03-15, end=2023-03-01, company=阿里巴巴科技股份有限公司, job=架构师)])'),(3,'2026-08-27 18:14:11','新增员工emp(id=1, username=choushabi, password=123456, name=施耐庵22, gender=1, phone=13390909001, job=4, salary=15000, image=https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg, entryDate=2008-01-01, deptId=55, createTime=2026-08-27T18:14:11.272675900, updateTime=2029-10-20T16:35:33, deptName=null, exprList=[emp_expr(id=null, empId=1, begin=2010-07-01, end=2012-06-30, company=阿里巴巴1, job=null), emp_expr(id=null, empId=1, begin=2012-08-01, end=2015-12-31, company=腾讯科技2, job=null), emp_expr(id=null, empId=1, begin=2016-03-01, end=2020-09-30, company=字节跳动3, job=null)])'),(4,'2026-08-27 18:22:18','新增员工emp(id=1, username=choushabi, password=123456, name=施耐庵22, gender=1, phone=13390909001, job=4, salary=15000, image=https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg, entryDate=2008-01-01, deptId=55, createTime=2026-08-27T18:22:17.549024700, updateTime=2029-10-20T16:35:33, deptName=null, exprList=[emp_expr(id=null, empId=1, begin=2010-07-01, end=2012-06-30, company=阿里巴巴1, job=null), emp_expr(id=null, empId=1, begin=2012-08-01, end=2015-12-31, company=腾讯科技2, job=null), emp_expr(id=null, empId=1, begin=2016-03-01, end=2020-09-30, company=字节跳动3, job=null)])'),(5,'2026-08-27 18:22:21','新增员工emp(id=1, username=choushabi, password=123456, name=施耐庵22, gender=1, phone=13390909001, job=4, salary=15000, image=https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg, entryDate=2008-01-01, deptId=55, createTime=2026-08-27T18:22:20.998705600, updateTime=2029-10-20T16:35:33, deptName=null, exprList=[emp_expr(id=null, empId=1, begin=2010-07-01, end=2012-06-30, company=阿里巴巴1, job=null), emp_expr(id=null, empId=1, begin=2012-08-01, end=2015-12-31, company=腾讯科技2, job=null), emp_expr(id=null, empId=1, begin=2016-03-01, end=2020-09-30, company=字节跳动3, job=null)])');
/*!40000 ALTER TABLE `emp_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-25 17:54:28
