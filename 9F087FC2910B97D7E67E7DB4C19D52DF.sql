-- MySQL dump 10.13  Distrib 5.5.56, for Linux (x86_64)
--
-- Host: localhost    Database: heroku_b0965c26597b33a
-- ------------------------------------------------------
-- Server version	5.5.56-log

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `chat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `processo_id` int(10) unsigned NOT NULL,
  `chat_mensagem` varchar(100) DEFAULT NULL,
  `conta_id` int(11) NOT NULL,
  `chat_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`chat_id`),
  KEY `processo_id` (`processo_id`),
  KEY `conta_id` (`conta_id`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`processo_id`) REFERENCES `processo` (`processo_id`),
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=282 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,1,'ola',1,'2018-11-17 13:30:03'),(11,1,'tudo bem?',1,'2018-11-17 13:30:33'),(21,11,'asdasd',1,'2018-11-17 13:36:37'),(31,11,'aaaa',1,'2018-11-17 13:36:38'),(41,21,'aaaaa',1,'2018-11-17 13:37:37'),(51,21,'ssssssss',1,'2018-11-17 13:37:39'),(61,31,'asda',1,'2018-11-17 13:42:51'),(71,31,'asdasd',1,'2018-11-17 13:42:52'),(81,41,'alou ',1,'2018-11-17 14:06:58'),(82,41,'1111',1,'2018-11-17 14:07:00'),(83,42,'aaaaaaaaa',1,'2018-11-17 14:11:45'),(84,42,'ssssssssss',1,'2018-11-17 14:11:47'),(85,42,'dddddddddddddd',1,'2018-11-17 14:11:50'),(86,42,'asdasdasdasdasd',1,'2018-11-17 14:11:53'),(87,43,'asdasd',1,'2018-11-17 14:13:13'),(88,43,'nao',1,'2018-11-17 14:13:16'),(89,43,'sim',1,'2018-11-17 14:13:18'),(91,43,'aa',1,'2018-11-17 14:22:38'),(101,44,'asadasda',1,'2018-11-17 14:29:43'),(102,44,'nao',1,'2018-11-17 14:30:10'),(103,45,'asdasda',1,'2018-11-17 14:33:54'),(104,46,'asdasda',1,'2018-11-17 15:05:31'),(105,47,'asdasd',1,'2018-11-17 15:08:27'),(106,45,'Ola meu mano',1,'2018-11-17 15:52:32'),(107,45,'isso',1,'2018-11-17 16:02:57'),(108,41,'ola',1,'2018-11-18 02:19:01'),(109,41,'tuduu boumm ?',1,'2018-11-18 02:19:53'),(110,48,'ja solicitei',1,'2018-11-18 02:20:42'),(111,43,'sdsd',1,'2018-11-18 02:37:32'),(121,21,'quero um garçom bom',1,'2018-11-18 02:39:00'),(131,51,'quero um dev pf',1,'2018-11-18 02:40:46'),(141,51,'pode pa',11,'2018-11-18 02:50:10'),(142,46,'é isso',11,'2018-11-18 02:57:18'),(143,21,'manda uma msg aii',1,'2018-11-18 03:23:03'),(144,21,'Ae porra',11,'2018-11-18 03:23:10'),(145,21,'niceee',1,'2018-11-18 03:23:20'),(146,21,'asd',1,'2018-11-18 03:23:29'),(151,21,'teste',1,'2018-11-18 03:26:19'),(152,21,'1',1,'2018-11-18 03:28:27'),(153,21,'2',11,'2018-11-18 03:28:33'),(154,21,'3',1,'2018-11-18 03:28:36'),(155,21,'4',11,'2018-11-18 03:28:40'),(156,21,'5',1,'2018-11-18 03:28:46'),(157,21,'6',11,'2018-11-18 03:28:48'),(158,21,'7',11,'2018-11-18 03:53:12'),(159,21,'8',11,'2018-11-18 03:53:30'),(160,21,'9',11,'2018-11-18 04:05:57'),(161,21,'10',11,'2018-11-18 04:06:02'),(162,21,'ola',1,'2018-11-18 04:16:44'),(163,21,'Opa',11,'2018-11-18 04:16:49'),(164,21,'Que delicia',11,'2018-11-18 04:16:54'),(165,21,'aaa',11,'2018-11-18 04:17:14'),(166,21,'foi',1,'2018-11-18 04:17:18'),(167,21,'Fechou',11,'2018-11-18 04:17:24'),(168,21,'testando',1,'2018-11-18 04:17:26'),(169,21,'aaaaa',1,'2018-11-18 04:18:02'),(170,48,'Opa',11,'2018-11-18 05:13:07'),(171,61,'Ola meu mano, quanto custa?',1,'2018-11-18 05:16:52'),(172,61,'pra vc nada',11,'2018-11-18 05:17:11'),(173,61,'Ue',1,'2018-11-18 05:17:33'),(174,61,'que ?',11,'2018-11-18 05:17:39'),(175,61,'Bugou? rs',1,'2018-11-18 05:17:45'),(176,61,'nem vi , vc viu ?',11,'2018-11-18 05:17:52'),(177,61,'viu o q? kkkkkkkkk',1,'2018-11-18 05:18:00'),(178,61,'O dia ta ruim pra vc?',1,'2018-11-18 05:19:18'),(179,61,'ta bom agora',11,'2018-11-18 05:19:25'),(180,62,'Opa',1,'2018-11-18 05:24:35'),(181,62,'msg 1 do trabalhador',11,'2018-11-18 05:24:47'),(182,62,'Top',1,'2018-11-18 05:24:54'),(183,62,'msg 2 do trabalhador',11,'2018-11-18 05:25:09'),(184,62,'Duplicou',1,'2018-11-18 05:25:11'),(185,62,'putz',1,'2018-11-18 05:25:23'),(186,62,'anao',1,'2018-11-18 05:25:29'),(187,62,'Grande',1,'2018-11-18 05:27:27'),(188,62,'sera q foi?',1,'2018-11-18 05:27:35'),(189,63,'xD',1,'2018-11-18 05:27:48'),(190,63,'bug? cade tu?',1,'2018-11-18 05:27:58'),(191,63,'sou garçom',11,'2018-11-18 05:28:01'),(192,63,'teste',11,'2018-11-18 05:28:55'),(193,63,'Boa',1,'2018-11-18 05:29:04'),(194,63,'aa',1,'2018-11-18 05:29:06'),(195,63,'bb',1,'2018-11-18 05:29:10'),(196,63,'bb',1,'2018-11-18 05:29:13'),(197,63,'bb',1,'2018-11-18 05:29:16'),(198,63,'123',11,'2018-11-18 05:29:23'),(199,63,'321',11,'2018-11-18 05:29:28'),(200,63,'1',11,'2018-11-18 05:29:32'),(201,63,'1',11,'2018-11-18 05:29:34'),(202,63,'2',11,'2018-11-18 05:29:36'),(203,63,'3',11,'2018-11-18 05:29:38'),(204,63,'cc',1,'2018-11-18 05:29:52'),(205,63,'dd',1,'2018-11-18 05:29:57'),(206,63,'ee',1,'2018-11-18 05:30:01'),(207,63,'teste',11,'2018-11-18 05:30:02'),(208,63,'ff',1,'2018-11-18 05:30:27'),(209,62,'a',11,'2018-11-18 05:31:27'),(210,62,'b',11,'2018-11-18 05:31:30'),(211,62,'c',11,'2018-11-18 05:31:32'),(212,62,'1',11,'2018-11-18 05:31:36'),(213,62,'2',11,'2018-11-18 05:31:38'),(214,62,'3',11,'2018-11-18 05:31:42'),(215,62,'asd',11,'2018-11-18 05:31:52'),(216,63,'aa',11,'2018-11-18 05:32:02'),(217,63,'a',11,'2018-11-18 05:33:44'),(218,63,'v',11,'2018-11-18 05:33:47'),(219,63,'s',11,'2018-11-18 05:33:53'),(220,63,'teste',11,'2018-11-18 05:33:55'),(221,63,'a',11,'2018-11-18 05:39:24'),(222,63,'b',11,'2018-11-18 05:39:26'),(223,63,'v',11,'2018-11-18 05:39:28'),(224,63,'c',11,'2018-11-18 05:39:30'),(225,63,'1',11,'2018-11-18 05:39:34'),(226,63,'2',11,'2018-11-18 05:39:36'),(227,63,'3',11,'2018-11-18 05:39:38'),(228,63,'4',11,'2018-11-18 05:39:40'),(229,63,'5',11,'2018-11-18 05:39:43'),(230,63,'6',11,'2018-11-18 05:39:45'),(231,63,'7',11,'2018-11-18 05:39:47'),(232,63,'8',11,'2018-11-18 05:39:49'),(233,63,'9',11,'2018-11-18 05:39:52'),(234,63,'10',11,'2018-11-18 05:39:55'),(235,63,'11',11,'2018-11-18 05:39:57'),(236,63,'12',11,'2018-11-18 05:39:59'),(237,63,'13',11,'2018-11-18 05:40:04'),(238,63,'14',11,'2018-11-18 05:40:08'),(239,63,'15',11,'2018-11-18 05:40:12'),(240,63,'16',11,'2018-11-18 05:40:15'),(241,63,'17',11,'2018-11-18 05:40:18'),(242,63,'',11,'2018-11-18 05:40:21'),(243,63,'20',11,'2018-11-18 05:40:26'),(244,63,'21',11,'2018-11-18 05:40:30'),(245,63,'22',11,'2018-11-18 05:40:32'),(246,63,'23',11,'2018-11-18 05:40:34'),(247,63,'25',11,'2018-11-18 05:40:40'),(248,64,'1',11,'2018-11-18 05:43:46'),(249,64,'2',1,'2018-11-18 05:43:50'),(250,64,'3',11,'2018-11-18 05:43:52'),(251,64,'4',1,'2018-11-18 05:43:56'),(252,64,'5',11,'2018-11-18 05:44:00'),(253,64,'6',1,'2018-11-18 05:44:03'),(254,64,'7',11,'2018-11-18 05:44:06'),(255,64,'8',1,'2018-11-18 05:44:09'),(256,64,'a',11,'2018-11-18 05:44:10'),(257,64,'b',11,'2018-11-18 05:44:13'),(258,64,'b',1,'2018-11-18 05:44:16'),(259,64,'9',1,'2018-11-18 05:44:21'),(260,64,'teste',11,'2018-11-18 05:44:37'),(261,64,'sdasd',1,'2018-11-18 05:44:37'),(262,65,'Ola, qual o preço?',1,'2018-11-18 05:48:38'),(263,65,'R$250,00 a hora',11,'2018-11-18 05:48:43'),(264,65,'Olco, bem caro',1,'2018-11-18 05:48:52'),(265,65,'150,00',11,'2018-11-18 05:49:02'),(266,65,'faz por 20tao?',1,'2018-11-18 05:49:05'),(267,65,'kkkkkkkkkkkkkk',1,'2018-11-18 05:49:09'),(268,65,'dmr',11,'2018-11-18 05:49:10'),(271,65,'20 eh mt barato, pode ser 21,80 ?',11,'2018-11-18 05:51:22'),(272,65,'Pode sim',1,'2018-11-18 05:51:28'),(273,65,'Vou solicitar',1,'2018-11-18 05:51:34'),(281,65,'feshow',11,'2018-11-18 05:51:37');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat1`
--

DROP TABLE IF EXISTS `chat1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat1` (
  `chat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `processo_id` int(10) unsigned NOT NULL,
  `chat_mensagem` varchar(100) DEFAULT NULL,
  `conta_id` int(11) NOT NULL,
  `chat_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`chat_id`),
  KEY `processo_id` (`processo_id`),
  KEY `conta_id` (`conta_id`),
  CONSTRAINT `chat1_ibfk_1` FOREIGN KEY (`processo_id`) REFERENCES `processo1` (`processo_id`),
  CONSTRAINT `chat1_ibfk_2` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat1`
--

LOCK TABLES `chat1` WRITE;
/*!40000 ALTER TABLE `chat1` DISABLE KEYS */;
INSERT INTO `chat1` VALUES (1,1,'asd',1,'2018-11-17 12:49:02'),(11,1,'aaaa',1,'2018-11-17 12:49:07'),(21,1,'oi',1,'2018-11-17 12:49:15'),(31,11,'Comecou',1,'2018-11-17 15:20:20');
/*!40000 ALTER TABLE `chat1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `conta_id` int(11) NOT NULL AUTO_INCREMENT,
  `conta_nome` varchar(45) NOT NULL,
  `conta_senha` varchar(45) NOT NULL,
  `conta_email` varchar(45) NOT NULL,
  `conta_tipo` int(11) NOT NULL,
  PRIMARY KEY (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,'Fulano Cliente','123','11',1),(11,'Ze Batalha','123','12',0);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_nota` float NOT NULL,
  `feedback_comentario` varchar(255) NOT NULL,
  `conta_id` int(11) NOT NULL,
  `trabalho_id` int(11) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  UNIQUE KEY `feedback_id_UNIQUE` (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,4.5,'bom serviço',1,61),(11,3.5,'pessimo serviço',1,61),(13,5,'Muito bom',1,51),(14,3.6,'BOA MAMADA GAROTAO',1,1),(15,7,'mamada pro',1,1),(16,11,'Boa',1,41),(17,10,'top1111',1,31),(18,7,'aaaaaa',1,31),(19,9,'àsdasdasd',1,31),(20,10,'asdasd',1,51),(21,1,'',1,61),(22,10,'saaasda',1,61),(23,10,'kkk',1,61);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo`
--

DROP TABLE IF EXISTS `processo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processo` (
  `processo_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `processo_status` int(11) NOT NULL,
  `trabalho_id` int(11) NOT NULL,
  `conta_id` int(11) NOT NULL,
  `processo_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`processo_id`),
  KEY `trabalho_id` (`trabalho_id`),
  KEY `conta_id` (`conta_id`),
  CONSTRAINT `processo_ibfk_1` FOREIGN KEY (`trabalho_id`) REFERENCES `trabalho` (`trabalho_id`),
  CONSTRAINT `processo_ibfk_2` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES (1,6,61,1,'2018-11-17 13:29:59'),(11,5,51,1,'2018-11-17 13:36:34'),(21,5,31,1,'2018-11-17 13:37:34'),(31,6,1,1,'2018-11-17 13:42:49'),(41,6,61,1,'2018-11-17 14:06:52'),(42,6,61,1,'2018-11-17 14:11:43'),(43,6,61,1,'2018-11-17 14:13:11'),(44,6,61,1,'2018-11-17 14:29:40'),(45,6,1,1,'2018-11-17 14:33:52'),(46,5,61,1,'2018-11-17 15:05:28'),(47,5,1,1,'2018-11-17 15:08:24'),(48,5,1,1,'2018-11-17 22:14:16'),(51,5,61,1,'2018-11-18 02:40:37'),(61,5,41,1,'2018-11-18 05:16:32'),(62,5,51,1,'2018-11-18 05:24:28'),(63,5,31,1,'2018-11-18 05:27:45'),(64,5,31,1,'2018-11-18 05:43:34'),(65,5,61,1,'2018-11-18 05:48:20');
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo1`
--

DROP TABLE IF EXISTS `processo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processo1` (
  `processo_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `processo_status` int(11) NOT NULL,
  `trabalho_id` int(11) NOT NULL,
  `conta_id` int(11) NOT NULL,
  `processo_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`processo_id`),
  KEY `trabalho_id` (`trabalho_id`),
  KEY `conta_id` (`conta_id`),
  CONSTRAINT `processo1_ibfk_1` FOREIGN KEY (`trabalho_id`) REFERENCES `trabalho` (`trabalho_id`),
  CONSTRAINT `processo1_ibfk_2` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo1`
--

LOCK TABLES `processo1` WRITE;
/*!40000 ALTER TABLE `processo1` DISABLE KEYS */;
INSERT INTO `processo1` VALUES (1,1,61,1,'0000-00-00 00:00:00'),(11,1,1,1,'2018-11-17 15:20:14');
/*!40000 ALTER TABLE `processo1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalho`
--

DROP TABLE IF EXISTS `trabalho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalho` (
  `trabalho_id` int(11) NOT NULL AUTO_INCREMENT,
  `trabalho_descricao` varchar(255) NOT NULL,
  `trabalho_nome` varchar(50) NOT NULL,
  `trabalho_somaNotaDeFeedback` float DEFAULT '0',
  `conta_id` int(11) NOT NULL,
  `trabalho_qntNotaDeFeedback` int(11) DEFAULT '0',
  PRIMARY KEY (`trabalho_id`),
  KEY `conta_id_idx` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalho`
--

LOCK TABLES `trabalho` WRITE;
/*!40000 ALTER TABLE `trabalho` DISABLE KEYS */;
INSERT INTO `trabalho` VALUES (1,'Mamadas gostosas asdasdasdasdad','Mamador',10.6,11,2),(31,'Faço bicos em qualquer buteco','Garçom',26,11,3),(41,'asdasdasdasd','Faxineiro',11,11,1),(51,'influencio todos','Digital Influencer',15,11,2),(61,'teste','Developer',29,11,5);
/*!40000 ALTER TABLE `trabalho` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-18  5:55:46
