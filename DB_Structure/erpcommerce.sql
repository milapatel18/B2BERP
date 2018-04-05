/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.21-MariaDB : Database - erpcommerce
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`erpcommerce` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `erpcommerce`;

/*Table structure for table `addresses` */

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `addr_title` varchar(255) DEFAULT NULL,
  `addr_line1` varchar(255) DEFAULT NULL,
  `addr_line2` varchar(255) DEFAULT NULL,
  `addr_line3` varchar(255) DEFAULT NULL,
  `addr_city` varchar(255) DEFAULT NULL,
  `addr_state` varchar(255) DEFAULT NULL,
  `addr_zip` varchar(25) DEFAULT NULL,
  `addr_country` varchar(255) DEFAULT NULL,
  `addr_lat` varchar(15) DEFAULT NULL,
  `addr_long` varchar(15) DEFAULT NULL,
  `addr_email1` varchar(255) DEFAULT NULL,
  `addr_email2` varchar(255) DEFAULT NULL,
  `addr_phone1` varchar(50) DEFAULT NULL,
  `addr_phone2` varchar(50) DEFAULT NULL,
  `users_id` bigint(10) unsigned DEFAULT NULL,
  `clients_id` bigint(10) unsigned DEFAULT NULL,
  `business_id` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clients_id` (`clients_id`),
  KEY `business_id` (`business_id`),
  KEY `addresses_ibfk_1` (`users_id`),
  KEY `addr_city` (`addr_city`),
  KEY `addr_state` (`addr_state`),
  KEY `addr_zip` (`addr_zip`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `addresses_ibfk_2` FOREIGN KEY (`clients_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `addresses_ibfk_3` FOREIGN KEY (`business_id`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `addresses_ibfk_4` FOREIGN KEY (`addr_city`) REFERENCES `city` (`city_name`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `addresses_ibfk_5` FOREIGN KEY (`addr_state`) REFERENCES `state` (`state_name`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `addresses_ibfk_6` FOREIGN KEY (`addr_zip`) REFERENCES `country` (`country_name`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `attribute_types` */

DROP TABLE IF EXISTS `attribute_types`;

CREATE TABLE `attribute_types` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '0',
  `attr_name` varchar(255) NOT NULL,
  `isMarker` int(1) NOT NULL DEFAULT '1',
  `hasValues` int(1) DEFAULT '0',
  `parent` bigint(10) unsigned DEFAULT NULL,
  `isGlobal` int(1) NOT NULL DEFAULT '1',
  `user_id` bigint(10) unsigned DEFAULT NULL,
  `business_id` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `business_id` (`business_id`),
  KEY `attribute_types_ibfk_1` (`user_id`),
  CONSTRAINT `attribute_types_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `attribute_types` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `attribute_types_ibfk_2` FOREIGN KEY (`business_id`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `attributes_data` */

DROP TABLE IF EXISTS `attributes_data`;

CREATE TABLE `attributes_data` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '0',
  `attribute_types_id` bigint(10) NOT NULL,
  `attribute_name` varchar(255) DEFAULT NULL,
  `attribute_title` varchar(255) DEFAULT NULL,
  `attribute_valtype` varchar(255) DEFAULT NULL,
  `user_id` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `attributes_data_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `business_company` */

DROP TABLE IF EXISTS `business_company`;

CREATE TABLE `business_company` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `business_name` varchar(255) NOT NULL,
  `business_id` varchar(100) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `ACTIVE` int(1) NOT NULL,
  `CREATED_AT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_AT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(10) unsigned DEFAULT NULL,
  `parent` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_id` (`user_id`),
  KEY `parent` (`parent`),
  CONSTRAINT `business_company_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `business_company_ibfk_2` FOREIGN KEY (`parent`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `business_modules` */

DROP TABLE IF EXISTS `business_modules`;

CREATE TABLE `business_modules` (
  `business_company_id` bigint(10) unsigned NOT NULL,
  `modules_id` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`business_company_id`,`modules_id`),
  KEY `modules_id` (`modules_id`),
  CONSTRAINT `business_modules_ibfk_1` FOREIGN KEY (`business_company_id`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `business_modules_ibfk_2` FOREIGN KEY (`modules_id`) REFERENCES `modules` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `business_users` */

DROP TABLE IF EXISTS `business_users`;

CREATE TABLE `business_users` (
  `BUSINESS_COMPANY_ID` bigint(10) unsigned NOT NULL,
  `USER_ID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`BUSINESS_COMPANY_ID`,`USER_ID`),
  KEY `business_users_ibfk_2` (`USER_ID`),
  CONSTRAINT `business_users_ibfk_1` FOREIGN KEY (`BUSINESS_COMPANY_ID`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `business_users_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_name` varchar(255) NOT NULL,
  `state_name` varchar(255) NOT NULL COMMENT 'FK',
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`city_name`),
  KEY `state_name` (`state_name`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`state_name`) REFERENCES `state` (`state_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '0',
  `client_name` varchar(255) DEFAULT NULL,
  `client_company` varchar(255) NOT NULL,
  `client_phone` varchar(255) DEFAULT NULL,
  `client_email` varchar(255) DEFAULT NULL,
  `client_type` varchar(255) DEFAULT NULL,
  `credit_limit` decimal(10,2) DEFAULT '0.00',
  `debit_limit` decimal(10,2) DEFAULT '0.00',
  `parent` bigint(10) DEFAULT NULL,
  `checklimit` int(1) DEFAULT '0',
  `user_id` bigint(10) unsigned DEFAULT NULL,
  `business_id` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `clients_ibfk_2` (`business_id`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `clients_ibfk_2` FOREIGN KEY (`business_id`) REFERENCES `business_company` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `country_name` varchar(255) NOT NULL,
  `country_iso_alpha2` varchar(2) DEFAULT NULL,
  `country_iso_alpha3` varchar(3) DEFAULT NULL,
  `country_iso_numeric` int(5) DEFAULT NULL,
  `country_flag` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `mediaformat` */

DROP TABLE IF EXISTS `mediaformat`;

CREATE TABLE `mediaformat` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `mediaformat_name` varchar(255) DEFAULT NULL,
  `folder_name` varchar(50) NOT NULL DEFAULT 'images',
  `width` int(5) unsigned NOT NULL DEFAULT '0',
  `height` int(5) unsigned NOT NULL DEFAULT '0',
  `comments` varchar(500) DEFAULT NULL,
  `mediaformat_id` bigint(10) unsigned DEFAULT NULL,
  `isParent` char(1) NOT NULL DEFAULT 'Y',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `users_id` bigint(10) unsigned DEFAULT NULL,
  `modules_id` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `media_format_name` (`mediaformat_name`),
  KEY `mediaformat_id` (`mediaformat_id`),
  KEY `users_id` (`users_id`),
  KEY `modules_id` (`modules_id`),
  CONSTRAINT `mediaformat_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `mediaformat_ibfk_2` FOREIGN KEY (`modules_id`) REFERENCES `modules` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `mediaformat_ibfk_3` FOREIGN KEY (`mediaformat_id`) REFERENCES `mediaformat` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Core Platform';

/*Table structure for table `modules` */

DROP TABLE IF EXISTS `modules`;

CREATE TABLE `modules` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) NOT NULL DEFAULT '0',
  `module_name` varchar(255) NOT NULL,
  `module_title` varchar(255) NOT NULL,
  `module_desc` varchar(255) DEFAULT NULL,
  `module_image` varchar(255) DEFAULT NULL,
  `module_type` varchar(255) NOT NULL,
  `priority_index` int(4) NOT NULL DEFAULT '1',
  `parent` bigint(10) unsigned DEFAULT NULL,
  `module_url` varchar(255) DEFAULT NULL,
  `module_css` varchar(255) DEFAULT NULL,
  `module_icon_class` varchar(255) DEFAULT NULL,
  `user_id` bigint(10) unsigned DEFAULT NULL,
  `hasChildren` int(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `modules_ibfk_1` (`user_id`),
  KEY `modules_ibfk_2` (`parent`),
  CONSTRAINT `modules_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `modules_ibfk_2` FOREIGN KEY (`parent`) REFERENCES `modules` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

/*Table structure for table `prototype` */

DROP TABLE IF EXISTS `prototype`;

CREATE TABLE `prototype` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `prototype_1` */

DROP TABLE IF EXISTS `prototype_1`;

CREATE TABLE `prototype_1` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '0',
  `user_id` bigint(10) unsigned DEFAULT NULL,
  `business_company_id` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `business_company_id` (`business_company_id`),
  CONSTRAINT `prototype_1_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `prototype_1_ibfk_2` FOREIGN KEY (`business_company_id`) REFERENCES `business_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `ID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(255) NOT NULL,
  `ROLE_DESC` varchar(255) NOT NULL,
  `ROLE_PARENT` bigint(10) DEFAULT NULL,
  `ACTIVE` int(11) NOT NULL,
  `CREATED_AT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_AT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USERS_ID` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USERS_ID` (`USERS_ID`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`USERS_ID`) REFERENCES `user` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `state_name` varchar(255) NOT NULL,
  `country_name` varchar(255) NOT NULL,
  `state_code2` varchar(2) DEFAULT NULL,
  `state_code3` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`state_name`),
  KEY `country_name` (`country_name`),
  CONSTRAINT `state_ibfk_1` FOREIGN KEY (`country_name`) REFERENCES `country` (`country_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `FNAME` varchar(111) NOT NULL,
  `LNAME` varchar(111) NOT NULL,
  `EMAIL` varchar(150) DEFAULT NULL,
  `LOGINID` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `PHONE_HOME` varchar(15) DEFAULT NULL,
  `PHONE_PERSONAL` varchar(15) DEFAULT NULL,
  `USER_TYPE` varchar(20) NOT NULL,
  `DESIGNATION` varchar(255) DEFAULT NULL,
  `ACTIVE` int(1) NOT NULL,
  `CREATED_AT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_AT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `USER_ID` bigint(10) unsigned NOT NULL,
  `ROLE_ID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
