CREATE DATABASE  IF NOT EXISTS `myblog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `myblog`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: myblog
-- ------------------------------------------------------
-- Server version	5.6.25-log

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

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `subtitle` varchar(225) DEFAULT NULL,
  `writer` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `hits` int(11) NOT NULL DEFAULT '0',
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `mod_date` datetime DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,NULL,'asdf','asff3f3f','ㅁㄴㅇㄻㅇ','ㅁㄴㅇㄻㅁ',1,'2015-09-21 09:39:22',NULL),(2,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:28',NULL),(3,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(4,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(5,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(6,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(7,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(8,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(9,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(10,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(11,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(12,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(13,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(14,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(15,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(16,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(17,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(18,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(19,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(20,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(21,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(22,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(23,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(24,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(25,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(26,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(27,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(28,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(29,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(30,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(31,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(32,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(33,NULL,'제목','부제목','글쓴이','컨텐츠',1,'2015-09-21 17:30:29',NULL),(34,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(35,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(37,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(38,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(39,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(40,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(41,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(42,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(43,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(44,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(45,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(46,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(47,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(48,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(49,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(50,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(51,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(52,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(53,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(54,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(55,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(56,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(57,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(58,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(59,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(60,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(61,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(62,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(63,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(64,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(65,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(66,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(67,NULL,'제목','부제목','글쓴이','컨텐츠',0,'2015-09-21 17:30:29',NULL),(68,NULL,'제목','부제목','글쓴이','컨텐츠',68,'2015-09-21 17:30:29',NULL);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-21 18:36:01
CREATE DATABASE  IF NOT EXISTS `myblogtest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `myblogtest`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: myblogtest
-- ------------------------------------------------------
-- Server version	5.6.25-log

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

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `subtitle` varchar(225) DEFAULT NULL,
  `writer` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `hits` int(11) NOT NULL DEFAULT '0',
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `mod_date` datetime DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-21 18:36:01
