/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-05-27 21:43:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookID` varchar(7) NOT NULL,
  `bookName` varchar(20) NOT NULL,
  `borrowerID` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('13001', '13001', null);
INSERT INTO `books` VALUES ('13002', '13002', null);
INSERT INTO `books` VALUES ('13003', '13003', null);
INSERT INTO `books` VALUES ('13004', '13004', null);
INSERT INTO `books` VALUES ('13005', '13005', null);
INSERT INTO `books` VALUES ('13006', '13006', null);
INSERT INTO `books` VALUES ('13007', '13007', null);
INSERT INTO `books` VALUES ('13008', '13008', null);
INSERT INTO `books` VALUES ('13009', '13009', null);
INSERT INTO `books` VALUES ('13010', '13010', null);

-- ----------------------------
-- Table structure for borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `borrow_record`;
CREATE TABLE `borrow_record` (
  `recordID` varchar(20) NOT NULL,
  `bookID` varchar(7) NOT NULL,
  `borrowerID` varchar(7) NOT NULL,
  PRIMARY KEY (`recordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_record
-- ----------------------------
INSERT INTO `borrow_record` VALUES ('123', '007', '1');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `userName` varchar(20) NOT NULL,
  `passward` varchar(20) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', '1234');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuID` varchar(7) NOT NULL DEFAULT '',
  `stuName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1');
INSERT INTO `student` VALUES ('2', '2');
INSERT INTO `student` VALUES ('3', '3');
INSERT INTO `student` VALUES ('4', '4');
INSERT INTO `student` VALUES ('5', '5');
INSERT INTO `student` VALUES ('6', '6');
