/*
SQLyog Trial v13.1.9 (64 bit)
MySQL - 8.2.0 : Database - management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`management` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `management`;

/*Table structure for table `o_order` */

DROP TABLE IF EXISTS `o_order`;

CREATE TABLE `o_order` (
  `o_id` int NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `information` int NOT NULL COMMENT '商品信息',
  `ordertime` date NOT NULL COMMENT '下单时间',
  `orderprice` double NOT NULL COMMENT '订单价格',
  PRIMARY KEY (`o_id`),
  KEY `fk_information` (`information`),
  CONSTRAINT `fk_information` FOREIGN KEY (`information`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `o_order` */

insert  into `o_order`(`o_id`,`information`,`ordertime`,`orderprice`) values 
(1,1,'2023-12-01',2),
(2,4,'2023-11-16',2999.99),
(3,1,'2023-12-20',3),
(4,2,'2023-12-06',4),
(5,6,'2023-12-04',220),
(6,4,'2023-12-06',2500),
(7,7,'2023-12-28',2.5);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `p_id` int NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(100) NOT NULL COMMENT '商品名',
  `price` double NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

/*Data for the table `product` */

insert  into `product`(`p_id`,`name`,`price`) values 
(1,'鸡蛋',2),
(2,'可乐',3),
(3,'羽绒服',299.99),
(4,'手机',2999.99),
(5,'牛奶',4.5),
(6,'耳机',200),
(7,'扑克牌',2.5),
(8,'苹果',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
