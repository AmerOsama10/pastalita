-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2021 at 03:05 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projecth`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`username`, `password`) VALUES
('foash', '9492');

-- --------------------------------------------------------

--
-- Table structure for table `cashiers`
--

CREATE TABLE `cashiers` (
  `cashier_id` int(11) NOT NULL,
  `cashier_name` varchar(100) NOT NULL,
  `cashier_phone` varchar(50) NOT NULL,
  `cashier_address` varchar(200) NOT NULL,
  `cashier_email` varchar(100) NOT NULL,
  `cashier_password` varchar(100) NOT NULL,
  `cashier_state` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashiers`
--

INSERT INTO `cashiers` (`cashier_id`, `cashier_name`, `cashier_phone`, `cashier_address`, `cashier_email`, `cashier_password`, `cashier_state`) VALUES
(1, 'عامر', '01007698027', 'المنوفيه شارع الجلاء', 'amer', 'amer', 0),
(2, 'احمد', '01099921232', 'طنطا شارع عباد الرحمن', 'b', 'b', 0);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL,
  `client_name` varchar(100) NOT NULL,
  `client_phone` varchar(50) NOT NULL,
  `client_address` varchar(200) NOT NULL,
  `client_notes` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `client_name`, `client_phone`, `client_address`, `client_notes`) VALUES
(15, 'محمد زكي عبدالفتاح الدسوقي', '01007698027', 'شارع الجامعه عند السوبر مركت', 'شقه 2 دور 1'),
(16, 'سمير هاني', '015432434592', 'شارع الجلاء المنوفيه', 'دور تاني شقه اتنين '),
(17, 'خالد', '98767', 'نتان', 'ت');

-- --------------------------------------------------------

--
-- Table structure for table `dates`
--

CREATE TABLE `dates` (
  `order_id` int(11) NOT NULL,
  `order_date` varchar(100) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `cashier_id` int(11) NOT NULL,
  `order_egmaly` float NOT NULL DEFAULT 0,
  `order_service` int(11) NOT NULL DEFAULT 0,
  `order_total` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dates`
--

INSERT INTO `dates` (`order_id`, `order_date`, `client_id`, `cashier_id`, `order_egmaly`, `order_service`, `order_total`) VALUES
(1, '05 يناير 2021', NULL, 1, 70, 0, 70),
(2, '05 يناير 2021', 16, 1, 63, 0, 63),
(3, '05 يناير 2021', 15, 1, 395, 0, 395),
(4, '05 يناير 2021', NULL, 1, 70, 0, 70),
(5, '05 يناير 2021', NULL, 2, 1233, 0, 1233),
(6, '05 يناير 2021', NULL, 2, 25, 0, 25),
(7, '05 يناير 2021', NULL, 2, 115, 0, 115),
(8, '05 يناير 2021', NULL, 2, 90, 0, 90),
(9, '05 يناير 2021', NULL, 2, 45, 0, 45),
(10, '05 يناير 2021', NULL, 2, 95, 0, 95),
(11, '05 يناير 2021', 17, 2, 45, 0, 45),
(12, '05 يناير 2021', NULL, 1, 1294, 0, 1294),
(13, '05 يناير 2021', NULL, 1, 3013, 0, 3013),
(14, '05 يناير 2021', NULL, 1, 316, 0, 316),
(15, '05 يناير 2021', NULL, 1, 310, 0, 310),
(16, '05 يناير 2021', NULL, 1, 355, 0, 355),
(17, '05 يناير 2021', NULL, 2, 56, 0, 56),
(18, '05 يناير 2021', NULL, 1, 35, 0, 35),
(19, '05 يناير 2021', NULL, 1, 170, 0, 170),
(20, '05 يناير 2021', 16, 1, 365, 0, 365),
(21, '06 يناير 2021', NULL, 1, 100, 0, 100);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `item_size` varchar(50) NOT NULL DEFAULT '',
  `item_cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `item_name`, `item_size`, `item_cost`) VALUES
(1, 'باكت بطاطس', 'كبير', 10),
(2, 'كريب فارم مشروم', 'كبير', 25),
(3, 'كريب فارم رومي', 'كبير', 20),
(4, 'كريب فارم فريتس', 'كبير', 15),
(5, 'كريب كرسبي', 'كبير', 28),
(6, 'كريب بانيه', 'كبير', 28),
(7, 'كريب شاورما لحم ', 'كبير', 28),
(8, 'كريب شاورما فراخ', 'كبير', 28),
(9, 'كريب تشكن استربس', 'كبير', 30),
(10, 'كريب فاهيتا فراخ', 'كبير', 35),
(11, 'كريب شيش طاووق', 'كبير', 30),
(12, 'كريب كوردن بلو', 'كبير', 30),
(13, 'كريب كونو موتزريلا ', 'كبير', 40),
(14, 'كريب سوبر سموك ', 'كبير', 40),
(15, 'كريب سوبر كرانشي', 'كبير', 35),
(16, 'كريب سوبر سوبريم', 'كبير', 40),
(17, 'كريب ميكس سبايسي ', 'كبير', 40),
(18, 'كريب ميكس شاورما', 'كبير', 40),
(19, 'كريب ميكس لحم', 'كبير', 40),
(20, 'كريب ميكس فراخ', 'كبير', 40),
(21, 'مكرونه الفريدو دجاج', 'كبير', 35),
(22, 'مكرونه ميكس سبايسي', 'كبير', 40),
(23, 'مكرونه ستربس حار', 'كبير', 30),
(24, 'مكرونه نجرسكو فراخ', 'كبير', 35),
(25, 'مكرونه تشيكن هوت', 'كبير', 35),
(26, 'مكرونه بانيه', 'كبير', 28),
(27, 'مكرونه شاورما الدجاج', 'كبير', 30),
(28, 'مكرونه نجرسكو لحم ', 'كبير', 35),
(29, 'مكرونه هوت دوج', 'كبير', 30),
(30, 'مكرونه سجق شرقي', 'كبير', 28),
(31, 'مكرونه شيش طاووق', 'كبير', 35),
(32, 'مكرونه بلونيز', 'كبير', 30),
(33, 'مكرونه جمبري', 'كبير', 55),
(34, 'مكرونه اربياتا', 'كبير', 25),
(35, 'مكرونه ميكس جبن', 'كبير', 35),
(36, 'مكرونه ميكس لحوم', 'كبير', 40),
(37, 'بيتزا تشكن باربيكيو كبير', 'كبير', 60),
(38, 'بيتزا تشكن باربيكيو وسط', 'وسط', 50),
(39, 'بيتزا تشكن كبير', 'كبير', 60),
(40, 'بيتزا تشكن وسط', 'وسط', 45),
(41, 'بيتزا بيبروني كبير', 'كبير', 55),
(42, 'بيتزا بيبروني وسط', 'وسط', 40),
(43, 'بيتزا مارجريتا كبير', 'كبير', 40),
(44, 'بيتزا مارجريتا وسط', 'وسط', 30),
(45, 'بيتزا سوبر سوبريم لحم كبير', 'كبير', 65),
(46, 'بيتزا سوبر سوبريم لحم وسط', 'وسط', 50),
(47, 'بيتزا سوبر سوبريم فراخ كبير', 'كبير', 65),
(48, 'بيتزا سوبر سوبريم فراخ وسط', 'وسط', 50),
(49, 'بيتزا  كرسبي / استربس كبير', 'كبير', 55),
(50, 'بيتزا  كرسبي / استربس وسط', 'وسط', 40),
(51, 'بيتزا بانيه كبير', 'كبير', 55),
(52, ' بيتزا بانيه وسط', 'وسط', 40),
(53, 'بيتزا سجق شرقي كبير', 'كبير', 60),
(54, 'بيتزا سجق شرقي وسط', 'وسط', 45),
(55, 'بيتزا شاورما لحم كبير', 'كبير', 60),
(56, 'بيتزا شاورما لحم وسط', 'وسط', 45),
(57, 'بيتزا تونه كبير', 'كبير', 60),
(58, 'بيتزا تونه وسط', 'وسط', 45),
(59, 'بيتزا هوت دوج كبير', 'كبير', 60),
(60, 'بيتزا هوت دوج وسط', 'وسط', 45),
(61, 'بيتزا جمبري كبير', 'كبير', 70),
(62, 'بيتزا جمبري وسط', 'وسط', 55),
(63, 'بيتزا ميكس فراخ كبير', 'كبير', 70),
(64, 'بيتزا ميكس فراخ وسط', 'وسط', 55),
(65, 'بيتزا ميكس لحوم كبير', 'كبير', 70),
(66, 'بيتزا ميكس لحوم وسط', 'وسط', 55),
(67, ' بيتزا ميكس جبن كبير', 'كبير', 60),
(68, 'بيتزا ميكس جبن وسط', 'وسط', 45),
(69, 'اضافه  استربس\r\n', '', 15),
(70, 'اضافه فراخ\r\n', '', 15),
(71, 'حشو اطراف', '', 15),
(72, 'اضافه سلامي\r\n', '', 15),
(73, 'اضافه مشروم', '', 15),
(74, 'اضافه سجق', '', 15),
(75, 'رانش صوص', '', 5),
(76, 'اضافه صوص الباربيكيو', '', 5),
(77, 'اضافه بيبروني', '', 15),
(78, 'اضافه جبن', '', 15),
(79, 'باكيت تشيز فرايز', '', 15);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_quantity` int(11) NOT NULL DEFAULT 1,
  `item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_quantity`, `item_id`) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 1, 3),
(1, 1, 4),
(2, 1, 7),
(2, 1, 10),
(3, 1, 38),
(3, 1, 39),
(3, 1, 49),
(3, 1, 50),
(3, 1, 55),
(3, 1, 61),
(3, 1, 67),
(4, 1, 1),
(4, 3, 78),
(4, 1, 79),
(5, 1, 2),
(5, 1, 12),
(5, 1, 27),
(5, 1, 30),
(5, 1, 48),
(5, 15, 63),
(5, 1, 75),
(5, 1, 79),
(6, 1, 2),
(7, 1, 41),
(7, 1, 64),
(7, 1, 76),
(8, 1, 11),
(8, 1, 40),
(8, 1, 71),
(9, 1, 1),
(9, 1, 73),
(9, 1, 76),
(9, 1, 79),
(10, 1, 23),
(10, 1, 48),
(10, 1, 77),
(11, 1, 60),
(12, 1, 1),
(12, 1, 2),
(12, 1, 5),
(12, 1, 10),
(12, 1, 15),
(12, 1, 17),
(12, 1, 18),
(12, 1, 20),
(12, 1, 22),
(12, 1, 26),
(12, 1, 27),
(12, 1, 30),
(12, 1, 31),
(12, 1, 34),
(12, 1, 35),
(12, 1, 36),
(12, 3, 42),
(12, 1, 46),
(12, 1, 47),
(12, 1, 49),
(12, 1, 54),
(12, 1, 55),
(12, 1, 57),
(12, 1, 59),
(12, 1, 63),
(12, 1, 65),
(12, 1, 67),
(12, 1, 70),
(12, 1, 71),
(12, 1, 73),
(12, 1, 75),
(12, 1, 79),
(13, 1, 1),
(13, 1, 2),
(13, 1, 3),
(13, 1, 4),
(13, 1, 5),
(13, 1, 6),
(13, 1, 7),
(13, 1, 8),
(13, 1, 9),
(13, 1, 10),
(13, 1, 11),
(13, 1, 12),
(13, 1, 13),
(13, 1, 14),
(13, 1, 15),
(13, 1, 16),
(13, 1, 17),
(13, 1, 18),
(13, 1, 19),
(13, 1, 20),
(13, 1, 21),
(13, 1, 22),
(13, 1, 23),
(13, 1, 24),
(13, 1, 25),
(13, 1, 26),
(13, 1, 27),
(13, 1, 28),
(13, 1, 29),
(13, 1, 30),
(13, 1, 31),
(13, 1, 32),
(13, 1, 33),
(13, 1, 34),
(13, 1, 35),
(13, 1, 36),
(13, 1, 37),
(13, 1, 38),
(13, 1, 39),
(13, 1, 40),
(13, 1, 41),
(13, 1, 42),
(13, 1, 43),
(13, 1, 44),
(13, 1, 45),
(13, 1, 46),
(13, 1, 47),
(13, 1, 48),
(13, 1, 49),
(13, 1, 50),
(13, 1, 51),
(13, 1, 52),
(13, 1, 53),
(13, 1, 54),
(13, 1, 55),
(13, 1, 56),
(13, 1, 57),
(13, 1, 58),
(13, 1, 59),
(13, 1, 60),
(13, 1, 61),
(13, 1, 62),
(13, 1, 63),
(13, 1, 64),
(13, 1, 65),
(13, 1, 66),
(13, 1, 67),
(13, 1, 68),
(13, 1, 69),
(13, 1, 70),
(13, 1, 71),
(13, 1, 72),
(13, 1, 73),
(13, 1, 74),
(13, 1, 75),
(13, 1, 76),
(13, 1, 77),
(13, 1, 78),
(13, 1, 79),
(14, 1, 3),
(14, 1, 4),
(14, 1, 6),
(14, 1, 13),
(14, 1, 15),
(14, 1, 22),
(14, 1, 30),
(14, 1, 31),
(14, 1, 35),
(14, 1, 36),
(15, 1, 22),
(15, 1, 24),
(15, 1, 28),
(15, 1, 41),
(15, 1, 56),
(15, 1, 58),
(15, 1, 64),
(16, 1, 3),
(16, 1, 16),
(16, 1, 22),
(16, 1, 31),
(16, 1, 33),
(16, 1, 48),
(16, 1, 50),
(16, 1, 58),
(16, 1, 70),
(16, 1, 71),
(17, 1, 6),
(17, 1, 7),
(18, 1, 3),
(18, 1, 4),
(18, 1, 7),
(19, 1, 41),
(19, 1, 49),
(19, 1, 55),
(20, 1, 2),
(20, 1, 38),
(20, 1, 39),
(20, 1, 41),
(20, 1, 56),
(20, 1, 58),
(20, 1, 64),
(20, 1, 70),
(20, 1, 71),
(21, 1, 41),
(21, 1, 58);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `cashiers`
--
ALTER TABLE `cashiers`
  ADD PRIMARY KEY (`cashier_id`),
  ADD UNIQUE KEY `cashier_email` (`cashier_email`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `dates`
--
ALTER TABLE `dates`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `cashier_id` (`cashier_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`,`item_id`),
  ADD KEY `item_id` (`item_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashiers`
--
ALTER TABLE `cashiers`
  MODIFY `cashier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dates`
--
ALTER TABLE `dates`
  ADD CONSTRAINT `dates_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `dates_ibfk_2` FOREIGN KEY (`cashier_id`) REFERENCES `cashiers` (`cashier_id`),
  ADD CONSTRAINT `dates_ibfk_3` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
