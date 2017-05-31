-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 31 May 2017, 15:00:35
-- Sunucu sürümü: 10.1.21-MariaDB
-- PHP Sürümü: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `smart_ticket`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `movies`
--

CREATE TABLE `movies` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `movie_theater` varchar(10) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `session` varchar(10) NOT NULL,
  `image` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `movies`
--

INSERT INTO `movies` (`id`, `name`, `movie_theater`, `from_date`, `to_date`, `session`, `image`) VALUES
(1, 'Sherlock Holmes', 'Theater 1', '2017-03-20', '2017-03-30', '10:00 PM', 'image_1.jpg'),
(2, 'Pirates of the Caribbean: On Stranger Tides', 'Teater 3', '2017-04-18', '2017-04-28', '11:00 PM', 'image_2.jpg'),
(3, 'The Imitation Game', 'Teater 8', '2017-05-22', '2017-05-29', '11:00 PM', 'image_3.jpg'),
(4, 'Sully', 'Teater 4', '2017-06-02', '2017-06-11', '09:30 PM', 'image_4.jpg'),
(5, 'The Hobbit: An Unexpected Journey', 'Teater 7', '2017-07-18', '2017-07-29', '10:30 PM', 'image_5.jpg'),
(6, 'World War Z', 'Teater 2', '2017-08-24', '2017-08-28', '11:45 PM', 'image_6.jpg'),
(7, 'Dag 2', 'Teater 10', '2017-09-01', '2017-09-24', '10:35 PM', 'image_7.jpg'),
(8, 'Bridge of Spies', 'Teater 4', '2017-10-10', '2017-10-19', '09:30 PM', 'image_8.jpg'),
(9, 'Warcraft', 'Teater 1', '2017-11-11', '2017-11-18', '10:00 PM', 'image_9.jpg'),
(10, 'Limitless', 'Teater 3', '2017-12-13', '2017-12-22', '11:55 PM', 'image_10.jpg'),
(11, 'Fury', 'Theater 3', '2017-02-14', '2017-02-18', '11:15 PM', 'image_11.jpg'),
(12, 'Mandra Filozofu', 'Salon 2', '2017-05-20', '2017-05-25', '11:00 PM', 'image_12.jpg');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `orders`
--

CREATE TABLE `orders` (
  `id` int(10) NOT NULL,
  `owner` varchar(30) NOT NULL,
  `movie` varchar(75) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `session` varchar(10) NOT NULL,
  `seat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `orders`
--

INSERT INTO `orders` (`id`, `owner`, `movie`, `date`, `session`, `seat`) VALUES
(1, 'Gorkem Ozturk', 'Pirates of the Caribbean: On Stranger Tides', '2017-05-29 22:59:51', '11:00 PM', 'A1 A2 A3      '),
(2, 'Gorkem Ozturk', 'World War Z', '2017-05-30 13:18:15', '11:45 PM', 'A1    B2    C3');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `seats`
--

CREATE TABLE `seats` (
  `id` int(11) NOT NULL,
  `a1` int(1) NOT NULL,
  `a2` int(1) NOT NULL,
  `a3` int(1) NOT NULL,
  `b1` int(1) NOT NULL,
  `b2` int(1) NOT NULL,
  `b3` int(1) NOT NULL,
  `c1` int(1) NOT NULL,
  `c2` int(1) NOT NULL,
  `c3` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `seats`
--

INSERT INTO `seats` (`id`, `a1`, `a2`, `a3`, `b1`, `b2`, `b3`, `c1`, `c2`, `c3`) VALUES
(1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 1, 1, 1, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 1, 0, 0, 0, 1, 0, 0, 0, 1),
(7, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(11, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(12, 0, 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `seats`
--
ALTER TABLE `seats`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Tablo için AUTO_INCREMENT değeri `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Tablo için AUTO_INCREMENT değeri `seats`
--
ALTER TABLE `seats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
