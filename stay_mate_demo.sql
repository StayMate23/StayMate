-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: stay_mate_demo
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `bar`
--

DROP TABLE IF EXISTS `bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bar`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    `photo`       varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FKkb5w8h7o6pdfafk1vwypkuoul` (`partner_id`),
    CONSTRAINT `FKkb5w8h7o6pdfafk1vwypkuoul` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bar`
--

LOCK
TABLES `bar` WRITE;
/*!40000 ALTER TABLE `bar` DISABLE KEYS */;
INSERT INTO `bar`
VALUES (5, 'Serving those that live the vacation lifestyle with diverse, high quality experiences around the world.',
        'Marriott Vacation Club', 13, 'bar.jpg'),
       (6,
        N'Napközben a Sky Bar maga a nyugalom oázisa: üzleti találkozók vagy akár barátokkal együtt töltött idő ideális helyszíne a város felett, zavartalan légkörben.',
        N'SkyBar – A város felett!', 15, 'skybar-a-varos-felett-normal10575.jpg'),
       (7, '', 'Elit Bar', 21, 'elit.jpg');
/*!40000 ALTER TABLE `bar` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `price` double NOT NULL,
    `hotel_id`    int          DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FKeye13xdpn0stvtejuu35pt2qh` (`hotel_id`),
    KEY           `FKr4g50rgjpwi8wohs6r8ggu30y` (`partner_id`),
    CONSTRAINT `FKeye13xdpn0stvtejuu35pt2qh` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FKr4g50rgjpwi8wohs6r8ggu30y` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK
TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities`
VALUES (1, 'Jacuzzis use hydromassage to stimulate muscles.', 'Jacuzzi', 50, 7, 13),
       (2,
        'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.',
        'Wellness', 250, 9, 14);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    `photo`       varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FKdd651in0b4td05jlgffo904bs` (`partner_id`),
    CONSTRAINT `FKdd651in0b4td05jlgffo904bs` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK
TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel`
VALUES (7, 'Enriching experiences thoughtfully crafted by associates who truly love what they do.', 'JW Marriott', 13,
        'jw-marriott-hotel-mumbai.jpg'),
       (8, 'Rare estates, set apart from the world, where heartfelt care is felt at every turn', 'Ritz-Carlton Reserve',
        13, 'phulay_bay_ritz_carlton_hotel_review-56.jpg'),
       (9, '', 'Silver Garden ', 14, 'IMG_1836-másolat-2.jpg');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `hotel_bar`
--

DROP TABLE IF EXISTS `hotel_bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_bar`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `hotel_id`    int          DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    `photo`       varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FK5k0ohtuh1gg692ie07x434361` (`hotel_id`),
    KEY           `FKpg1obceu33rf9h3245wnq5feh` (`partner_id`),
    CONSTRAINT `FK5k0ohtuh1gg692ie07x434361` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FKpg1obceu33rf9h3245wnq5feh` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_bar`
--

LOCK
TABLES `hotel_bar` WRITE;
/*!40000 ALTER TABLE `hotel_bar` DISABLE KEYS */;
INSERT INTO `hotel_bar`
VALUES (2, '', '523 Bar', 7, 13, 'our-restaurant-with-big.jpg');
/*!40000 ALTER TABLE `hotel_bar` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `hotel_restaurant`
--

DROP TABLE IF EXISTS `hotel_restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_restaurant`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `hotel_id`    int          DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    `photo`       varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FK4k6s7bvahilfk6mjbectmlofd` (`hotel_id`),
    KEY           `FK51m9567xuwfx23344h7e4xx78` (`partner_id`),
    CONSTRAINT `FK4k6s7bvahilfk6mjbectmlofd` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FK51m9567xuwfx23344h7e4xx78` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_restaurant`
--

LOCK
TABLES `hotel_restaurant` WRITE;
/*!40000 ALTER TABLE `hotel_restaurant` DISABLE KEYS */;
INSERT INTO `hotel_restaurant`
VALUES (1,
        ' Above the city! Is the first roof bar in Romania, based on a new concept that will impress you with the unique design and the special atmosphere.',
        'SkyBar', 7, 13, '0-big.jpg');
/*!40000 ALTER TABLE `hotel_restaurant` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `menu_book`
--

DROP TABLE IF EXISTS `menu_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_book`
(
    `id`                  int NOT NULL AUTO_INCREMENT,
    `description`         varchar(255) DEFAULT NULL,
    `name`                varchar(255) DEFAULT NULL,
    `price` double NOT NULL,
    `bar_id`              int          DEFAULT NULL,
    `hotel_id`            int          DEFAULT NULL,
    `hotel_bar_id`        int          DEFAULT NULL,
    `hotel_restaurant_id` int          DEFAULT NULL,
    `partner_id`          int          DEFAULT NULL,
    `reservation_id`      int          DEFAULT NULL,
    `restaurant_id`       int          DEFAULT NULL,
    `photo`               varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                   `FK6dlwl3pd5o1hpb0atp9t728lq` (`bar_id`),
    KEY                   `FK548niqfi53glw9hdy8afinf8x` (`hotel_id`),
    KEY                   `FKa317cy1i50tgpltj1bhdw88fu` (`hotel_bar_id`),
    KEY                   `FKaeo5vidgu5sw6j1pyahdt70j7` (`hotel_restaurant_id`),
    KEY                   `FKnux2jw2wl3wxewnl4r5qaa8wo` (`partner_id`),
    KEY                   `FKngeoe46wuissdq7oe6hqad706` (`reservation_id`),
    KEY                   `FK1929en5cm2w0dj7gd1ijobdo1` (`restaurant_id`),
    CONSTRAINT `FK1929en5cm2w0dj7gd1ijobdo1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`),
    CONSTRAINT `FK548niqfi53glw9hdy8afinf8x` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FK6dlwl3pd5o1hpb0atp9t728lq` FOREIGN KEY (`bar_id`) REFERENCES `bar` (`id`),
    CONSTRAINT `FKa317cy1i50tgpltj1bhdw88fu` FOREIGN KEY (`hotel_bar_id`) REFERENCES `hotel_bar` (`id`),
    CONSTRAINT `FKaeo5vidgu5sw6j1pyahdt70j7` FOREIGN KEY (`hotel_restaurant_id`) REFERENCES `hotel_restaurant` (`id`),
    CONSTRAINT `FKngeoe46wuissdq7oe6hqad706` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`),
    CONSTRAINT `FKnux2jw2wl3wxewnl4r5qaa8wo` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_book`
--

LOCK
TABLES `menu_book` WRITE;
/*!40000 ALTER TABLE `menu_book` DISABLE KEYS */;
INSERT INTO `menu_book`
VALUES (4,
        ' Above the city! Is the first roof bar in Romania, based on a new concept that will impress you with the unique design and the special atmosphere.',
        'Mojito', 25, NULL, 7, 2, NULL, 13, NULL, NULL, 'mojito.jpg'),
       (5, 'vodka, peach schnapps, orange juice, and cranberry juice', 'SexOnTheBeach', 27, NULL, 7, 2, NULL, 13, NULL,
        NULL, 'sex-on-the-beach.jpg'),
       (6,
        'Big juicy hamburger patties don’t need a lot of ingredients or extras. With just a few great tips, these patties are perfect for cookouts all year ’round!',
        'Hamburger', 90, NULL, 7, NULL, 1, 13, NULL, NULL, 'hamburger.jpg'),
       (7, 'A creamy soup with langoustines, mussels scallops and fennel', 'SEAFOOD SOUP', 110, NULL, NULL, NULL, NULL,
        16, NULL, 5, NULL);
/*!40000 ALTER TABLE `menu_book` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `partner`
--

DROP TABLE IF EXISTS `partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partner`
(
    `id`              int NOT NULL AUTO_INCREMENT,
    `address`         varchar(255) DEFAULT NULL,
    `company_reg_num` varchar(255) DEFAULT NULL,
    `email`           varchar(255) DEFAULT NULL,
    `partner_name`    varchar(255) DEFAULT NULL,
    `password`        varchar(255) DEFAULT NULL,
    `tax_num`         varchar(255) DEFAULT NULL,
    `tel_num`         varchar(255) DEFAULT NULL,
    `photo`           varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner`
--

LOCK
TABLES `partner` WRITE;
/*!40000 ALTER TABLE `partner` DISABLE KEYS */;
INSERT INTO `partner`
VALUES (13, 'St. Regis', '78945', 'meriott@gmail.com', 'Marriott International Inc.',
        '$2a$10$mHsQbl2pL9LezXXwwNvL2u.PRNYTYSf3A0uGCLZXNytZBDDSbIwcu', '2154', '345698746',
        'Marriott-International.jpg'),
       (14, 'Siófok', '62626154', 'info@silvergarden.hu', 'Silver Garden Siófok',
        '$2a$10$BDlWNZPr.7KIcB3oeysI1eA1RD2noOqHsmIdrmRkzTehVVRhQwspy', '6446', '036789546', 'medence-1024x675.jpg'),
       (15, 'Székelyudvarhely', '5444', 'office@kukullo.ro', 'Hotel Küküllő*** ',
        '$2a$10$RI/yxarynrzsUq8bfBV70ufhrWJP8rnJ3pkLeCQHrjwssVOM7qOjy', 'RO15151', '0266213963',
        'nn_kukullo_dron-8.jpg'),
       (16, 'Reykjavik', '650121-1980', 'reception@hotelisland.is', 'Hotel Ísland – Spa & Wellness Hotel',
        '$2a$10$m1zVvIYxYrwxktB014ukZusG6nfVbRJw6n1Fs7GMp9qx7TdTXavTa', '140029', '(+354) 595-7000 ', 'izlandh.jpg'),
       (17, 'Inter Hotel, 4027, Debrecen, Böszörményi út 2.', '09 09 034946', 'info@interhotel.hu',
        'Inter Hotel Debrecen', '$2a$10$EHo0NiFWoSMMrs96n9L5SeEwLfCp9fYhffNCzyTrPfuxNrXLbw9Te', '32228456-2-09',
        '+36 30 293 54 06', 'debrecen.jpg'),
       (21, 'Erdely', '1235456', 'moka@moka.com', 'Moka',
        '$2a$10$yfUSTwqL2.2f5vyTI6NJ/uv7TI/kUCIKho7qxhu7aC3O7.u.PIAf6', '12345', '0747969570', 'moka-logo.png');
/*!40000 ALTER TABLE `partner` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `partner_admin`
--

DROP TABLE IF EXISTS `partner_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partner_admin`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) DEFAULT NULL,
    `pos_rank`   varchar(255) DEFAULT NULL,
    `tel_number` varchar(255) DEFAULT NULL,
    `partner_id` int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `FK5qvwqdmkm9e1qw74ilf31ghh1` (`partner_id`),
    CONSTRAINT `FK5qvwqdmkm9e1qw74ilf31ghh1` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner_admin`
--

LOCK
TABLES `partner_admin` WRITE;
/*!40000 ALTER TABLE `partner_admin` DISABLE KEYS */;
INSERT INTO `partner_admin`
VALUES (3, 'Barbara', 'Reception', '+36 70 4089437', 14),
       (4, 'Krisztina', 'Manager', '0749969578', 15);
/*!40000 ALTER TABLE `partner_admin` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation`
(
    `id`                  int NOT NULL AUTO_INCREMENT,
    `end_date`            datetime(6) DEFAULT NULL,
    `start_date`          datetime(6) DEFAULT NULL,
    `user_number`         int DEFAULT NULL,
    `bar_id`              int DEFAULT NULL,
    `hotel_id`            int DEFAULT NULL,
    `hotel_bar_id`        int DEFAULT NULL,
    `hotel_restaurant_id` int DEFAULT NULL,
    `partner_id`          int DEFAULT NULL,
    `restaurant_id`       int DEFAULT NULL,
    `room_id`             int DEFAULT NULL,
    `user_id`             int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                   `FKl4e9fqbqv0tth5o8oriwl25yn` (`bar_id`),
    KEY                   `FKkrmw55mlm5an5ca5qnmrs3pbe` (`hotel_id`),
    KEY                   `FK331e4ufpl3lbims8u4oko16c6` (`hotel_bar_id`),
    KEY                   `FKg8og0l628jajqh44b1hse2n2w` (`hotel_restaurant_id`),
    KEY                   `FKrj8mtw265s6682ttbx9wq08j7` (`partner_id`),
    KEY                   `FKbna4xjm3tqln2j6kda3fl2yiy` (`restaurant_id`),
    KEY                   `FKm8xumi0g23038cw32oiva2ymw` (`room_id`),
    KEY                   `FKrea93581tgkq61mdl13hehami` (`user_id`),
    CONSTRAINT `FK331e4ufpl3lbims8u4oko16c6` FOREIGN KEY (`hotel_bar_id`) REFERENCES `hotel_bar` (`id`),
    CONSTRAINT `FKbna4xjm3tqln2j6kda3fl2yiy` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`),
    CONSTRAINT `FKg8og0l628jajqh44b1hse2n2w` FOREIGN KEY (`hotel_restaurant_id`) REFERENCES `hotel_restaurant` (`id`),
    CONSTRAINT `FKkrmw55mlm5an5ca5qnmrs3pbe` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FKl4e9fqbqv0tth5o8oriwl25yn` FOREIGN KEY (`bar_id`) REFERENCES `bar` (`id`),
    CONSTRAINT `FKm8xumi0g23038cw32oiva2ymw` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
    CONSTRAINT `FKrea93581tgkq61mdl13hehami` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FKrj8mtw265s6682ttbx9wq08j7` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK
TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    `partner_id`  int          DEFAULT NULL,
    `photo`       varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY           `FKtm6a3y9xpeobgye0fbt7uf25f` (`partner_id`),
    CONSTRAINT `FKtm6a3y9xpeobgye0fbt7uf25f` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK
TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant`
VALUES (3,
        N'Enabling ambitious travelers to succeed through an environment that inspires creativity and fosters connections.',
        N'Courtyard', 13, N'Restaurant_Näsinneula.jpg'),
       (4, N'Étterem a város szívében', 'Menta Bistro', 15, '23184-menta-bistro-album182.jpg'),
       (5, N'Hekla Restaurant and bar is a fresh, modern restaurant that opened its door in May 2021 at Hótel Ísland. ',
        'Hekla Restaurant', 16, 'izlandre.jpg'),
       (6,
        N'Engedje, hogy elkápráztassuk ízletes ételeinkkel és kellemes környezetünkkel az Inter Hotel Debrecen éttermében!',
        N'ÉTTEREM', 17, 'debetterem.jpg'),
       (7, N' kóstold meg a friss, ropogós ízeket, amelyeket csak a Crispeace tud nyújtani', 'CrisPeace', 21,
        'crispeace.jpg');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room`
(
    `id`            int NOT NULL AUTO_INCREMENT,
    `price_per_day` double DEFAULT NULL,
    `room_capacity` int          DEFAULT NULL,
    `room_number`   varchar(255) DEFAULT NULL,
    `hotel_id`      int          DEFAULT NULL,
    `partner_id`    int          DEFAULT NULL,
    `photo`         varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY             `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`),
    KEY             `FKjbyg7r9i5tjk3i5yfx63pef8j` (`partner_id`),
    CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
    CONSTRAINT `FKjbyg7r9i5tjk3i5yfx63pef8j` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK
TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room`
VALUES (3, 180, 2, 'B5', 7, 13, 'room.jpg'),
       (4, 190, 4, '4', 9, 14, 'cssladi.jpg');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `birth_date`   date         DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `first_name`   varchar(255) DEFAULT NULL,
    `last_name`    varchar(255) DEFAULT NULL,
    `password`     varchar(255) DEFAULT NULL,
    `personal_id`  varchar(255) DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    `sur_name`     varchar(255) DEFAULT NULL,
    `photo`        varchar(64)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK
TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users`
VALUES (1, '2023-11-29', 'makicica22@gmail.com', 'MArika', 'Ambrus',
        '$2a$10$vYiEjaNdwcipJBSQlzPGm.Unn9KKGQ7UB2d3JXfyCMlPT9NgIFZqC', '123456', '0747969570', 'Mr.', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-08  9:35:21
