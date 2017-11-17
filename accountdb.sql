-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17 Nov 2017 pada 11.23
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accountdb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `driver` tinyint(1) NOT NULL,
  `image` varchar(50) NOT NULL DEFAULT './img/profile-placeholder.png'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`ID`, `name`, `username`, `email`, `password`, `phone_number`, `driver`, `image`) VALUES
(1, 'Bocan', 'bocan', 'bocan@gmail.com', '123', '081123456789', 0, '25'),
(2, 'Hesen', 'hesen', 'hesen@gmail.com', '111', '081987654321', 1, '30'),
(3, 'Adya Naufal Fikri', 'adyanf', 'adyanf@gmail.com', 'test123', '082127896113', 1, './img/profile-placeholder.png'),
(4, 'Adya Naufal Fikri', 'adyanaufalfikri', 'test123@gmail.com', 'test123', '098817873111', 0, './img/profile-placeholder.png'),
(6, 'Adya1019', 'adyanaufalF', 'adyanf1019@gmail.com', 'test123', '09791873111', 1, './img/profile-placeholder.png'),
(7, 'test', 'test1231', 'test@gmail.com', 'test123', '02817216612', 1, './img/profile-placeholder.png'),
(8, 'Adya Naufal', 'adyanf222', '1212dya@gmail.com', 'adya1019', '01287168721', 1, './img/profile-placeholder.png'),
(9, 'Mim', 'mimimim', 'mimim@gmail.com', 'test123', '0181782121111', 1, './img/profile-placeholder.png'),
(10, 'Test1234', 'adyananana', 'adyananaa@gmail.com', 'test123', '0981928912', 0, './img/profile-placeholder.png'),
(11, 'Test123', 'test12345', 'adtajadb@gmail.com', 'test123', '108789381962', 0, './img/profile-placeholder.png'),
(12, 'Test', 'teteteetetet12', 'aaaad@gmail.com', 'test123', '08212789611', 0, './img/profile-placeholder.png'),
(13, 'Adya Naufal Fikri', 'teysey123', 'gageh@gamil.com', '654321', '123456789', 0, './img/profile-placeholder.png'),
(14, 'Adya Naufal Fik', 'adyan2191', 'adyaNNl@gmail.com', 'test123', '111928172903', 0, './img/profile-placeholder.png'),
(15, 'Nofandi Surya', 'nofandi', 'nofandi@gmail.com', 'nofandi', '02789715291', 1, './img/profile-placeholder.png'),
(16, 'Vigor Akbar', 'vigorakbar', 'adyan12@gail.com', 'test123', '01729192017', 1, './img/profile-placeholder.png'),
(17, 'Candra Hesen', 'heecahesen', 'heecahesen@gmail.com', 'test123', '09819212897', 1, './img/profile-placeholder.png'),
(18, 'Test Hello', 'testhellohehe', 'hehehe@gmail.coco', 'test123', '09182715820', 1, './img/profile-placeholder.png'),
(19, 'Test Beheheh', 'Bebebe', 'adahe@gmail.com', 'test123', '09182763719', 0, './img/profile-placeholder.png'),
(20, 'Test1234', 'Test1234567', 'Test1234@kmail.com', 'Test1234', '098765431234', 0, './img/profile-placeholder.png'),
(21, 'Test1234', 'Test123455', 'Test123455@email.com', 'Test1234', '09861868821', 1, './img/profile-placeholder.png'),
(22, 'twice', 'twice', 'twice@gmail.com', '123456', '087098098098', 0, './img/profile-placeholder.png'),
(23, 'Adya N.F.', 'btbtbtbtbt', 'btbtbt@gmail.com', 'test123', '0987654321', 1, './img/profile-placeholder.png'),
(36, 'irfanmim', 'irfanmim', 'mim@gmail.com', 'password', '098768765', 1, './img/profile-placeholder.png'),
(37, 'mim', 'mimmim', 'email@gmail.com', 'password', '098765432', 0, './img/profile-placeholder.png'),
(38, 'yuhuu', 'yuhuyuhu', 'yuhu@gmail.com', 'password', '09876543234', 0, './img/profile-placeholder.png'),
(39, 'yuhu2', 'yuhu2', 'yuhu2@gmail.com', 'password', '987654098', 0, './img/profile-placeholder.png'),
(40, 'yuhuuuu', 'usertest1', 'usertest1@gmail.com', 'password', '09876543298', 0, './img/profile-placeholder.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `token`
--

CREATE TABLE `token` (
  `ID` smallint(6) NOT NULL,
  `access_token` varchar(30) NOT NULL,
  `expiry_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `token`
--

INSERT INTO `token` (`ID`, `access_token`, `expiry_time`) VALUES
(12, '[B@61574e34', 1509970057375),
(13, 'LVhCJKQLuQKHYWzN9NhU', 1509970413221),
(14, '7jNV2ifyYZwzJoR2NL7c', 0),
(15, 'rbhxqx7O5DJ4MPlJHadR', 1510039849843),
(16, 'GszHAhmKEoAhU8tdQziX', 1510040444804),
(17, 'lj0qovRCM6IBtb8AxPc1', 0),
(18, 'E3V6IFE5hwQKnD2ZMOXU', 0),
(19, '0SEWp6B9MaJN5bTgO9aw', 1510087266494),
(20, '3T35P8P4R2VsyDDfbMuP', 0),
(21, 'cOiovjFHmaC8CVJnRJHw', 1510144147100),
(22, 'tn3YVCsngGD9j3hknZlW', 1510157652042),
(23, '1o2LqD41ivXY4EjCxJUZ', 0),
(36, 'ywuISQq7BoAvmASncaPY', 1510909127357),
(37, 'ZymUobZTeUo5L3Qm8qp5', 1510909308320),
(38, 'YMvmoIxhsV3TF0ob5YUB', 1510909994061),
(39, 'yDgtCrcxGBjDDSktJTda', 1510910163309),
(40, '9sx73KylFsR4T5tkf3Vv', 1510910902414);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone_number` (`phone_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
