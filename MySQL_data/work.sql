/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : work

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2021-12-11 10:58:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` varchar(50) NOT NULL COMMENT '管理员id',
  `adminname` varchar(255) NOT NULL COMMENT '管理员名',
  `password` varchar(255) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', '李家林', '123');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `houseId` varchar(50) NOT NULL COMMENT '房间号',
  `floor` varchar(255) DEFAULT NULL COMMENT '楼层',
  `building` varchar(255) DEFAULT NULL COMMENT '楼号',
  `developer` varchar(255) DEFAULT NULL COMMENT '所属社区',
  `reservation` int(255) DEFAULT '0' COMMENT '预购状态：被预购是为1\r\n默认为0',
  PRIMARY KEY (`houseId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('001102', '1层', '1号楼', '沁园花苑', '1');
INSERT INTO `house` VALUES ('001202', '2层', '1号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('001302', '3层', '1号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('001502', '5层', '1号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('002102', '1层', '2号楼', '沁园花苑', '1');
INSERT INTO `house` VALUES ('002202', '2层', '2号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('002302', '3层', '2号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('002402', '4层', '2号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('002502', '5层', '2号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('002602', '6层', '2号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003102', '1层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003202', '2层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003302', '3层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003402', '4层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003502', '5层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('003602', '6层', '3号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004102', '1层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004202', '2层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004302', '3层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004402', '4层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004502', '5层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('004602', '6层', '4号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005102', '1层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005202', '2层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005302', '3层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005402', '4层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005502', '5层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('005602', '6层', '5号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006102', '1层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006202', '2层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006302', '3层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006402', '4层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006502', '5层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('006602', '6层', '6号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007102', '1层', '7号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007202', '2层', '7号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007302', '3层', '7号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007402', '4层', '7号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007502', '5层', '7号楼', '沁园花苑', '0');
INSERT INTO `house` VALUES ('007602', '6层', '7号楼', '沁园花苑', '0');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(20) NOT NULL AUTO_INCREMENT COMMENT '预定记录id',
  `userId` varchar(20) DEFAULT NULL COMMENT '用户id',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `houseId` varchar(20) DEFAULT NULL COMMENT '门牌号',
  `floor` varchar(255) DEFAULT NULL COMMENT '楼层',
  `back` int(50) DEFAULT NULL COMMENT '是否取消预定是为1默认为0',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1234', '张三', '002102', '1层', '1');
INSERT INTO `record` VALUES ('2', '123', '李四', '001102', '1层', '1');
INSERT INTO `record` VALUES ('3', '1234', '张三', '001402', '4层', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(50) NOT NULL COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1234', '张三', '1234');
