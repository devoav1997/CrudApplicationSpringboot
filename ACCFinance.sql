-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: accfinance
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_cust` varchar(255) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `id_kredit` varchar(255) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `nama_cust` varchar(255) DEFAULT NULL,
  `no_ktp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cust`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('001','Jalan Mawar, Cipayung, Jakarta Timur','111','','Imara Acacia','3140987125362876'),('002','Jalan Warga, Bandung, Jawa Barat','112','','Alya Alifia','3287162735827363'),('003','Jalan Margonda, Depok, Jawa Barat','113','','Ronaldo Satria','3267839261738232'),('004','Jalan Mekarsari, Ciledug, Jakarta Barat','114','','Devo','3167829384098273'),('005','Jalan Teratai, CInere, Depok','115','','Hasna','3827364729182374');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `histori`
--

DROP TABLE IF EXISTS `histori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `histori` (
  `no_reff` varchar(255) NOT NULL,
  `denda` int(11) DEFAULT NULL,
  `id_cust` varchar(255) DEFAULT NULL,
  `tanggal_bayar` datetime(6) DEFAULT NULL,
  `total_trx` int(11) DEFAULT NULL,
  PRIMARY KEY (`no_reff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `histori`
--

LOCK TABLES `histori` WRITE;
/*!40000 ALTER TABLE `histori` DISABLE KEYS */;
INSERT INTO `histori` VALUES ('335ebe9b-1729-4541-9063-1679e613e38c',0,'003','2021-02-09 10:43:46.760000',2000),('4664cd0e-13e2-4313-be75-88f215e59e02',0,'001','2021-02-09 10:44:47.707000',300000),('4d20c68d-c885-4583-b210-b1b9bee66cac',0,'004','2021-02-09 10:44:57.114000',200000),('85ba905d-71e8-4625-acb2-14d42aa21626',0,'002','2021-02-09 10:53:43.696000',300000),('86cc235c-5fc6-4263-9c5a-7aa96da288ca',0,'002','2021-02-15 10:29:27.150000',300),('c2391ea9-f843-4856-962d-c4db1e106506',0,'005','2021-02-09 10:45:07.452000',15000000);
/*!40000 ALTER TABLE `histori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kredit`
--

DROP TABLE IF EXISTS `kredit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kredit` (
  `kredit_id` varchar(255) NOT NULL,
  `id_prod` varchar(255) DEFAULT NULL,
  `jatuh_tempo` varchar(255) DEFAULT NULL,
  `sisa_pelunasan` int(11) DEFAULT NULL,
  `sisa_tenor` varchar(255) DEFAULT NULL,
  `tahun_kredit` varchar(255) DEFAULT NULL,
  `tenor` varchar(255) DEFAULT NULL,
  `total_pelunasan` int(11) DEFAULT NULL,
  PRIMARY KEY (`kredit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kredit`
--

LOCK TABLES `kredit` WRITE;
/*!40000 ALTER TABLE `kredit` DISABLE KEYS */;
INSERT INTO `kredit` VALUES ('111','3331','1',9700000,'10','2021','12',13000000),('112','3332','4',3699700,'0','2020','6',12000000),('113','2224','17',199998000,'17','2021','36',350000000),('114','2223','3',49800000,'4','2020','12',190000000),('115','2221','4',135000000,'2','2021','6',300000000);
/*!40000 ALTER TABLE `kredit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produk`
--

DROP TABLE IF EXISTS `produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produk` (
  `id_prod` varchar(255) NOT NULL,
  `discount` float DEFAULT NULL,
  `harga_prod` int(11) DEFAULT NULL,
  `nama_prod` varchar(255) DEFAULT NULL,
  `tahun_pembuatan` varchar(255) DEFAULT NULL,
  `tipe_prod` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produk`
--

LOCK TABLES `produk` WRITE;
/*!40000 ALTER TABLE `produk` DISABLE KEYS */;
INSERT INTO `produk` VALUES ('2221',NULL,300000000,'Fortuner AT','2017','Roda empat'),('2222',NULL,250000000,'CR-V','2018','Roda empat'),('2223',NULL,190000000,'Grand Livina','2014','Roda empat'),('2224',NULL,350000000,'Camry AT','2015','Roda empat'),('3331',NULL,13000000,'Vario','2016','Roda dua'),('3332',NULL,12000000,'Mio','2015','Roda dua');
/*!40000 ALTER TABLE `produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesman`
--

DROP TABLE IF EXISTS `salesman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesman` (
  `id_salesman` int(11) NOT NULL,
  `id_prod` int(11) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `salesman_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_salesman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesman`
--

LOCK TABLES `salesman` WRITE;
/*!40000 ALTER TABLE `salesman` DISABLE KEYS */;
INSERT INTO `salesman` VALUES (5001,2221,'aktif','Bandung','Budi Hardi'),(5002,2222,'aktif','Bali','Dina'),(5003,2222,'aktif','Bandung','Raditya'),(5004,2223,'aktif','Jakarta','Surya');
/*!40000 ALTER TABLE `salesman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tugas`
--

DROP TABLE IF EXISTS `tugas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tugas` (
  `id_salesman` varchar(255) NOT NULL,
  `nama_salesman` varchar(255) DEFAULT NULL,
  `supervisor` varchar(255) DEFAULT NULL,
  `tanggal_tugas` varchar(255) DEFAULT NULL,
  `tugas_harian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_salesman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tugas`
--

LOCK TABLES `tugas` WRITE;
/*!40000 ALTER TABLE `tugas` DISABLE KEYS */;
INSERT INTO `tugas` VALUES ('5001','Budi Hardi','Ratna Adani','2021-01-11','Mencari nasabah baru'),('5002','Dina ','Ratna Adani','2021-02-08','Mencari nasabah baru dan input penjualan'),('5003','Raditya','Ratna Adani','2021-02-09','Mencari nasabah baru'),('5004','surya','kornelius','2021-02-10','mencari nasabah baru');
/*!40000 ALTER TABLE `tugas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 17:36:57
