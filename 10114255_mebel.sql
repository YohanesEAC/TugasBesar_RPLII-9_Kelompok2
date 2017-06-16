-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 29, 2016 at 10:29 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `10114255_mebel`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(70) NOT NULL,
  `level` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `level`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', 'Admin'),
('pegawai', '047aeeb234644b9e2d4138ed3bc7976a', 'Pegawai'),
('user', 'ee11cbb19052e40b07aac0ca060c23ee', 'Pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_barang`
--

CREATE TABLE IF NOT EXISTS `tabel_barang` (
  `kode_barang` varchar(18) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jenis_barang` varchar(30) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga_satuan` double DEFAULT NULL,
  `tanggal_barang_masuk` varchar(40) NOT NULL,
  PRIMARY KEY (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_barang`
--

INSERT INTO `tabel_barang` (`kode_barang`, `nama_barang`, `jenis_barang`, `jumlah`, `harga_satuan`, `tanggal_barang_masuk`) VALUES
('KB-000001', 'Sopa', 'Kayu Jati', 3, 900000, '28 Juli 2016'),
('KB-000002', 'Kusri', 'Kayu Jati', 5, 500000, '28 Juli 2016'),
('KB-000003', 'Meja', 'Kayu Borneo', 9, 550000, '28 Juli 2016'),
('KB-000004', 'Pintu', 'Kayu Jati', 97, 300000, '29 Juli 2016'),
('KB-000005', 'Lemari', 'Kayu Borneo', 15, 200000, '29 Juli 2016'),
('KB-000006', 'Meja Makan', 'Kayu Jati', 87, 900000, '29 Juli 2016'),
('KB-000007', 'Bangku', 'Kayu Alba', 10, 150000, '29 Juli 2016');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_detail_transaksi_cicil`
--

CREATE TABLE IF NOT EXISTS `tabel_detail_transaksi_cicil` (
  `id_detail_transaksi_cicil` int(8) NOT NULL,
  `kode_pembeli_cicil` varchar(13) DEFAULT NULL,
  `tanggal_pembeli` varchar(20) DEFAULT NULL,
  `nama_pembeli` varchar(50) DEFAULT NULL,
  `alamat_pembeli` varchar(50) DEFAULT NULL,
  `tenggang_waktu` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(18) DEFAULT NULL,
  `nama_barang` varchar(20) DEFAULT NULL,
  `banyak_barang` varchar(8) DEFAULT NULL,
  `harga_satuan` double DEFAULT NULL,
  `harga_total` double DEFAULT NULL,
  `uang_muka` double DEFAULT NULL,
  `sisa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_detail_transaksi_cicil`),
  KEY `tabel_detail_transaksi_cicil_ibfk_2` (`kode_barang`),
  KEY `tabel_detail_transaksi_cicil_ibfk_1` (`kode_pembeli_cicil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_detail_transaksi_cicil`
--

INSERT INTO `tabel_detail_transaksi_cicil` (`id_detail_transaksi_cicil`, `kode_pembeli_cicil`, `tanggal_pembeli`, `nama_pembeli`, `alamat_pembeli`, `tenggang_waktu`, `kode_barang`, `nama_barang`, `banyak_barang`, `harga_satuan`, `harga_total`, `uang_muka`, `sisa`) VALUES
(1, 'FKC-000001', '28 Juli 2016', 'Cecillia Cheunng', 'Jl. Cimindi No 54 Rt 01 / Rw 05', '2016-08-04', 'KB-000001', 'Sopa', '2', 900000, 1800000, 900000, '900000'),
(2, 'FKC-000002', '28 Juli 2016', 'Sopiala Cuba', 'Jl. Jakarta No. 22 RT 06 / RW 04', '2016-08-04', 'KB-000002', 'Kusri', '1', 500000, 500000, 1150000, '1150000'),
(3, 'FKC-000003', '28 Juli 2016', 'Raisa', 'Jl. Jakarta No. 22 RT 03 /  RW 02', '2016-08-04', 'KB-000001', 'Sopa', '3', 900000, 2700000, 2750000, 'Lunas'),
(4, 'FKC-000003', '28 Juli 2016', 'Raisa', 'Jl. Jakarta No. 22 RT 03 /  RW 02', '2016-08-04', 'KB-000002', 'Kusri', '1', 500000, 500000, 2750000, 'Lunas'),
(5, 'FKC-000004', '29 Juli 2016', 'Wildan ', 'Jl. Cimindi No. 33 RT 12 / RW 02', '2016-08-05', 'KB-000003', 'Meja', '1', 550000, 550000, 275000, 'Lunas'),
(6, 'FKC-000005', '29 Juli 2016', 'Boy', 'Jl.Terserah Boy', '2016-07-31', 'KB-000001', 'Sopa', '2', 900000, 1800000, 2850000, '2850000.0'),
(7, 'FKC-000005', '29 Juli 2016', 'Boy', 'Jl.Terserah Boy', '2016-07-31', 'KB-000002', 'Kusri', '3', 500000, 1500000, 2850000, '2850000.0'),
(8, 'FKC-000005', '29 Juli 2016', 'Boy', 'Jl.Terserah Boy', '2016-07-31', 'KB-000006', 'Meja Makan', '2', 900000, 1800000, 2850000, '2850000.0'),
(9, 'FKC-000005', '29 Juli 2016', 'Boy', 'Jl.Terserah Boy', '2016-07-31', 'KB-000004', 'Pintu', '2', 300000, 600000, 2850000, '2850000.0');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_detail_transaksi_tunai`
--

CREATE TABLE IF NOT EXISTS `tabel_detail_transaksi_tunai` (
  `id_detail_transaksi_tunai` int(8) NOT NULL,
  `kode_pembeli_tunai` varchar(18) DEFAULT NULL,
  `tanggal_pembeli` varchar(20) DEFAULT NULL,
  `nama_pembeli` varchar(50) DEFAULT NULL,
  `alamat_pembeli` varchar(50) DEFAULT NULL,
  `kode_barang` varchar(18) DEFAULT NULL,
  `nama_barang` varchar(20) DEFAULT NULL,
  `banyak_barang` int(8) DEFAULT NULL,
  `harga_satuan` double DEFAULT NULL,
  `harga_total` double DEFAULT NULL,
  PRIMARY KEY (`id_detail_transaksi_tunai`),
  KEY `tabel_detail_transaksi_tunai_ibfk_1` (`kode_pembeli_tunai`),
  KEY `tabel_detail_transaksi_tunai_ibfk_2` (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_detail_transaksi_tunai`
--

INSERT INTO `tabel_detail_transaksi_tunai` (`id_detail_transaksi_tunai`, `kode_pembeli_tunai`, `tanggal_pembeli`, `nama_pembeli`, `alamat_pembeli`, `kode_barang`, `nama_barang`, `banyak_barang`, `harga_satuan`, `harga_total`) VALUES
(1, 'FKT-000001', '28 Juli 2016', 'Isyana', 'Jl. Bandung No.5 RT 01 / RW 07', 'KB-000002', 'Kusri', 1, 500000, 500000),
(2, 'FKT-000001', '28 Juli 2016', 'Isyana', 'Jl. Bandung No.5 RT 01 / RW 07', 'KB-000003', 'Meja', 2, 550000, 1100000),
(3, 'FKT-000001', '28 Juli 2016', 'Isyana', 'Jl. Bandung No.5 RT 01 / RW 07', 'KB-000002', 'Kusri', 1, 500000, 500000),
(4, 'FKT-000002', '28 Juli 2016', '3UOW4IFHJ', 'R3JOTR32OP', 'KB-000002', 'Kusri', 0, 500000, 0),
(5, 'FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang', 'KB-000001', 'Sopa', 1, 900000, 900000),
(6, 'FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang', 'KB-000002', 'Kusri', 1, 500000, 500000),
(7, 'FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang', 'KB-000003', 'Meja', 1, 550000, 550000),
(8, 'FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang', 'KB-000004', 'Pintu', 1, 300000, 300000),
(9, 'FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang', 'KB-000005', 'Lemari', 1, 200000, 200000),
(10, 'FKT-000004', '29 Juli 2016', 'Suep', 'jl.Cimahi RT2 NO56', 'KB-000001', 'Sopa', 3, 900000, 2700000),
(11, 'FKT-000005', '29 Juli 2016', 'Saepul', 'Jln.Bandung Barat', 'KB-000005', 'Lemari', 4, 200000, 800000),
(12, 'FKT-000006', '29 Juli 2016', 'Cinta', 'JL.setiabudi', 'KB-000002', 'Kusri', 1, 500000, 500000),
(13, 'FKT-000007', '29 Juli 2016', 'Bayu', 'Jln. Dipatiukur', 'KB-000006', 'Meja Makan', 1, 900000, 900000);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pegawai`
--

CREATE TABLE IF NOT EXISTS `tabel_pegawai` (
  `kode_pegawai` varchar(8) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `alamat` varchar(90) DEFAULT NULL,
  `level` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`kode_pegawai`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pegawai`
--

INSERT INTO `tabel_pegawai` (`kode_pegawai`, `username`, `jenis_kelamin`, `alamat`, `level`) VALUES
('5', 'admin', 'Pria', 'Tasikmalaya', 'Admin'),
('6', 'user', 'Wanita', 'user', 'Pegawai'),
('7', 'pegawai', 'Pria', 'pegawai', 'Pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_transaksi_cicil`
--

CREATE TABLE IF NOT EXISTS `tabel_transaksi_cicil` (
  `kode_pembeli_cicil` varchar(13) NOT NULL,
  `tanggal_pembeli` varchar(20) DEFAULT NULL,
  `nama_pembeli` varchar(46) DEFAULT NULL,
  `alamat_pembeli` varchar(90) DEFAULT NULL,
  `keterangan` varchar(12) NOT NULL,
  PRIMARY KEY (`kode_pembeli_cicil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_transaksi_cicil`
--

INSERT INTO `tabel_transaksi_cicil` (`kode_pembeli_cicil`, `tanggal_pembeli`, `nama_pembeli`, `alamat_pembeli`, `keterangan`) VALUES
('FKC-000001', '28 Juli 2016', 'Cecillia Cheunng', 'Jl. Cimindi No 54 Rt 01 / Rw 05', 'Lunas'),
('FKC-000002', '28 Juli 2016', 'Sopiala Cuba', 'Jl. Jakarta No. 22 RT 06 / RW 04', 'Lunas'),
('FKC-000003', '28 Juli 2016', 'Raisa', 'Jl. Jakarta No. 22 RT 03 /  RW 02', 'Lunas'),
('FKC-000004', '29 Juli 2016', 'Wildan ', 'Jl. Cimindi No. 33 RT 12 / RW 02', 'Lunas'),
('FKC-000005', '29 Juli 2016', 'Boy', 'Jl.Terserah Boy', 'Belum Lunas');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_transaksi_tunai`
--

CREATE TABLE IF NOT EXISTS `tabel_transaksi_tunai` (
  `kode_pembeli_tunai` varchar(18) NOT NULL,
  `tanggal_pembeli` varchar(20) DEFAULT NULL,
  `nama_pembeli` varchar(46) DEFAULT NULL,
  `alamat` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`kode_pembeli_tunai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_transaksi_tunai`
--

INSERT INTO `tabel_transaksi_tunai` (`kode_pembeli_tunai`, `tanggal_pembeli`, `nama_pembeli`, `alamat`) VALUES
('FKT-000001', '28 Juli 2016', 'Isyana', 'Jl. Bandung No.5 RT 01 / RW 07'),
('FKT-000002', '28 Juli 2016', '3UOW4IFHJ', 'R3JOTR32OP'),
('FKT-000003', '29 Juli 2016', 'Yohanes', 'JL.Padalarang'),
('FKT-000004', '29 Juli 2016', 'Suep', 'jl.Cimahi RT2 NO56'),
('FKT-000005', '29 Juli 2016', 'Saepul', 'Jln.Bandung Barat'),
('FKT-000006', '29 Juli 2016', 'Cinta', 'JL.setiabudi'),
('FKT-000007', '29 Juli 2016', 'Bayu', 'Jln. Dipatiukur');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`username`) REFERENCES `tabel_pegawai` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `tabel_detail_transaksi_cicil`
--
ALTER TABLE `tabel_detail_transaksi_cicil`
  ADD CONSTRAINT `tabel_detail_transaksi_cicil_ibfk_1` FOREIGN KEY (`kode_pembeli_cicil`) REFERENCES `tabel_transaksi_cicil` (`kode_pembeli_cicil`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tabel_detail_transaksi_cicil_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `tabel_barang` (`kode_barang`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `tabel_detail_transaksi_tunai`
--
ALTER TABLE `tabel_detail_transaksi_tunai`
  ADD CONSTRAINT `tabel_detail_transaksi_tunai_ibfk_1` FOREIGN KEY (`kode_pembeli_tunai`) REFERENCES `tabel_transaksi_tunai` (`kode_pembeli_tunai`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tabel_detail_transaksi_tunai_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `tabel_barang` (`kode_barang`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
