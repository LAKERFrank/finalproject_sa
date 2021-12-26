-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2021-12-24 08:07:43
-- 伺服器版本： 10.4.14-MariaDB
-- PHP 版本： 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `project_sa`
--

DELIMITER $$
--
-- 程序
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `**modifyId_Members` (IN `inId` INT(100), IN `newId` INT(100))  NO SQL
UPDATE members set members_id=newId WHERE members_id=inId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cancel_Orders` (IN `inMembersId` INT(100))  NO SQL
DELETE FROM orders WHERE members_id=inMembersId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_Managers` (IN `inName` VARCHAR(100), IN `inEmail` VARCHAR(100), IN `inPassword` VARCHAR(100))  NO SQL
INSERT INTO managers(name,email,password) VALUES(inName,inEmail,inPassword)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_Members` (IN `inName` VARCHAR(100), IN `inEmail` VARCHAR(100), IN `inPassword` VARCHAR(100), IN `inPhone` VARCHAR(100))  NO SQL
BEGIN
	IF EXISTS(SELECT email FROM members WHERE email=inEmail LIMIT 1)
    THEN SELECT '此email已註冊過' as '';
    ELSEIF EXISTS(SELECT phone FROM members WHERE phone=inPhone LIMIT 1)
    THEN SELECT '此電話已註冊過' as '';
    ELSE INSERT INTO members(name,email,password,phone,modified,created,login_times,status) VALUES(inName,inEmail,inPassword,inPhone,now(),now(),0,1);
    end IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_Orders` (IN `inMembersId` INT(100), IN `inProductsId` INT(100))  NO SQL
BEGIN
	DECLARE bookPrice int;
	SELECT price into bookPrice FROM products where products_id=inProductsId LIMIT 1;
	INSERT INTO orders(members_id,modified,created,total_price) VALUES(inMembersId,now(),now(),bookPrice);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_Products` (IN `inName` VARCHAR(100), IN `inPrice` INT(100), IN `inImage` VARCHAR(100))  NO SQL
INSERT INTO products(name,price,image) VALUES(inName,inPrice,inImage)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteByID_Members` (IN `inId` INT(100))  NO SQL
DELETE FROM members where members_id=inId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getById_Members` (IN `inId` INT(100))  NO SQL
SELECT * FROM members WHERE members_id=inId LIMIT 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getById_Products` (IN `inId` INT(100))  NO SQL
SELECT * FROM products WHERE products_id=inId LIMIT 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getStock` (IN `inProductsId` INT(100))  NO SQL
SELECT stock FROM products WHERE products_id=inProductsId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginTimes` (IN `inEmail` VARCHAR(100), IN `inPassword` VARCHAR(100))  NO SQL
BEGIN
	DECLARE checkEmail,checkPwd int DEFAULT 0;
	IF EXISTS(SELECT email FROM members where inEmail=email)
    then set checkEmail=1;
    END IF;
    IF EXISTS(SELECT password FROM members where inEmail=email AND inPassword=password)
    then set checkPwd=1;
    END IF;
    IF(checkEmail=1 and checkPwd=1)
    THEN UPDATE members SET login_times=login_times+1 WHERE email=inEmail;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `test` (IN `inEmail` VARCHAR(100))  NO SQL
BEGIN
 IF EXISTS(SELECT email FROM members WHERE email=inEmail LIMIT 1)
 then SELECT 'correct' as '';
 ELSE SELECT 'incorrect' as '';
 end IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_Members` (IN `inEmail` VARCHAR(100), IN `inName` VARCHAR(100), IN `inPassword` VARCHAR(100))  NO SQL
BEGIN
	UPDATE members set name=inName WHERE email=inEmail;
	UPDATE members set password=inPassword WHERE email=inEmail;
    UPDATE members set modified=now() WHERE email=inEmail;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- 資料表結構 `managers`
--

CREATE TABLE `managers` (
  `managers_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `managers`
--

INSERT INTO `managers` (`managers_id`, `name`, `email`, `password`) VALUES
(1, 'host01', 'host01@gmail.com', '123456');

-- --------------------------------------------------------

--
-- 資料表結構 `members`
--

CREATE TABLE `members` (
  `members_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `modified` datetime(6) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  `login_times` int(100) NOT NULL,
  `total_consumption` int(100) NOT NULL DEFAULT 0,
  `status` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `members`
--

INSERT INTO `members` (`members_id`, `name`, `email`, `password`, `phone`, `modified`, `created`, `login_times`, `total_consumption`, `status`) VALUES
(0, 'caleb', 'caleb@gmail.com', '123', '', '2021-12-19 21:13:37.000000', '2021-12-19 21:07:13.000000', 0, 0, 1),
(1, 'test01', 'test01@gmail.com', '123', '', '2021-12-19 20:48:06.000000', '2021-12-19 20:48:06.000000', 2, 0, 1),
(2, 'test02', 'test02@gmail.com', '123', '', '2021-12-19 20:57:27.000000', '2021-12-19 20:57:27.000000', 1, 0, 1),
(3, 'test03', 'test03@gmail.com', '123', '', '2021-12-19 23:22:00.000000', '2021-12-19 23:22:00.000000', 1, 0, 1),
(4, 'test04', 'test04@gmail.com', '123', '', '2021-12-20 21:24:17.000000', '2021-12-20 21:24:17.000000', 0, 0, 1),
(5, 'test05', 'test05@gmail.com', '123', '0912345678', '2021-12-23 21:54:09.000000', '2021-12-23 21:54:09.000000', 0, 0, 1);

-- --------------------------------------------------------

--
-- 資料表結構 `orderitems`
--

CREATE TABLE `orderitems` (
  `orders_id` int(100) NOT NULL,
  `products_id` int(100) NOT NULL,
  `price` int(100) NOT NULL,
  `quantity` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 資料表結構 `orders`
--

CREATE TABLE `orders` (
  `orders_id` int(100) NOT NULL,
  `members_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `modified` datetime(6) DEFAULT NULL,
  `created` datetime(6) NOT NULL,
  `total_price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `orders`
--

INSERT INTO `orders` (`orders_id`, `members_id`, `name`, `phone`, `modified`, `created`, `total_price`) VALUES
(1, 1, '', '', '2021-12-19 23:43:35.000000', '2021-12-19 23:43:35.000000', 500),
(2, 2, '', '', '2021-12-23 21:38:34.000000', '2021-12-23 21:38:34.000000', 300);

-- --------------------------------------------------------

--
-- 資料表結構 `products`
--

CREATE TABLE `products` (
  `products_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` int(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `stock` int(100) NOT NULL,
  `genre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `products`
--

INSERT INTO `products` (`products_id`, `name`, `price`, `image`, `stock`, `genre`) VALUES
(1, '原子習慣', 500, 'C:\\download', 0, ''),
(2, '大家的日本語', 300, 'C:\\download', 0, ''),
(3, '被討厭的勇氣', 500, 'C:\\download', 0, '');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`managers_id`);

--
-- 資料表索引 `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`members_id`);

--
-- 資料表索引 `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orders_id`);

--
-- 資料表索引 `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`products_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `managers`
--
ALTER TABLE `managers`
  MODIFY `managers_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `members`
--
ALTER TABLE `members`
  MODIFY `members_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `orders`
--
ALTER TABLE `orders`
  MODIFY `orders_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `products`
--
ALTER TABLE `products`
  MODIFY `products_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
