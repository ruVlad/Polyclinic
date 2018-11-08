CREATE DATABASE IF NOT EXISTS `polyclinicdb` /*!40100 DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci */;
USE `polyclinicdb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: polyclinicdb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
SET NAMES utf8;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `diseases`
--

DROP TABLE IF EXISTS `diseases`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `diseases` (
  `id`      int(11)          NOT NULL AUTO_INCREMENT,
  `name`    varchar(45) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comment` varchar(45) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseases`
--

LOCK TABLES `diseases` WRITE;
/*!40000 ALTER TABLE `diseases`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `diseases`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `doctor` (
  `id`    int(11)            NOT NULL AUTO_INCREMENT,
  `name`  varchar(45) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age`   int(3)             NOT NULL,
  `email` varchar(64) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 18
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_sertificate`
--

DROP TABLE IF EXISTS `health_sertificate`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `health_sertificate` (
  `id`            int(11)    NOT NULL AUTO_INCREMENT,
  `id_diseases`   int(11)    NOT NULL,
  `id_doctor`     int(11)    NOT NULL,
  `id_patient`    int(11)    NOT NULL,
  `date_of_issue` varchar(45) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `expiry_date`   varchar(45) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_doctor_idx` (`id_doctor`),
  KEY `id_diseases_idx` (`id_diseases`),
  KEY `id_patient_idx` (`id_patient`),
  CONSTRAINT `id_diseases` FOREIGN KEY (`id_diseases`) REFERENCES `diseases` (`id`),
  CONSTRAINT `id_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`),
  CONSTRAINT `id_patient` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_sertificate`
--

LOCK TABLES `health_sertificate` WRITE;
/*!40000 ALTER TABLE `health_sertificate`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `health_sertificate`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `patient` (
  `id`   int(11)             NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age`  int(3)              NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `patient`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `salary` (
  `id_doctor` int(11) NOT NULL,
  `sum`       int(11) NOT NULL,
  `id`        int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_doctor_UNIQUE` (`id_doctor`),
  CONSTRAINT `id_doctor2` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `salary`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2018-11-08  7:35:17
