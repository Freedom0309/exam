/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-04-10 17:23:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_num` int(11) NOT NULL,
  `admin_name` varchar(50) NOT NULL,
  `admin_sex` varchar(2) DEFAULT NULL,
  `admin_birth` datetime DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '110', 'jc', '女', '1993-10-09 00:00:00', '123456', 'qqq.11', '123', '2018-05-02 23:53:49');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_num` int(11) NOT NULL,
  `college_name` varchar(50) NOT NULL,
  `college_chairman` varchar(50) DEFAULT NULL,
  `college_tel` varchar(50) DEFAULT NULL,
  `college_desc` text,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT 0,
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '2130609', '计算机学院', '贾超', '01089898989', '牛逼', '123456', 'jiahao@qq.com', '0', '2018-05-02 16:36:47');
INSERT INTO `college` VALUES ('2', '2130708', '电信学院', '贾智商', '01089898989', '牛逼', '123456', 'jiahqqao@qq.com', null, '2018-05-03 10:33:05');

-- ----------------------------
-- Table structure for job_seeker
-- ----------------------------
DROP TABLE IF EXISTS `job_seeker`;
CREATE TABLE `job_seeker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_seeker_num` int(11) NOT NULL,
  `job_seeker_name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `job_seeker_sex` varchar(2) DEFAULT NULL,
  `job_seeker_birth` datetime DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT 0,
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resume_id` (`resume_id`),
  CONSTRAINT `fk_resume_id` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_seeker
-- ----------------------------
INSERT INTO `job_seeker` VALUES ('1', '2130609', '贾超', '01089898989', '女', '1999-04-20 18:24:06', '123456', 'aaa@aa.com', '1', '0', '2018-05-03 10:37:12');

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resume_num` int(11) NOT NULL,
  `resume_status` int(1) DEFAULT 1,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `id_no` varchar(50) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(2) NOT NULL,
  `birth` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `education_experience`text NOT NULL,
  `work_experience` text NOT NULL,
  `personal_evaluation` text DEFAULT NULL,
  `annex_url` varchar(50) DEFAULT NULL,
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '2130609', '1', '贾超', '119', '111111111111111111', '女', '40', '2018-05-21 10:35:14', 'aaa.aa', '哦i分覅死哦分', '违法', '方式', '人人', '2018-05-03 10:35:42');


-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_num` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `job_title` varchar(50) NOT NULL,
  `loction` varchar(50) NOT NULL,
  `numbers` varchar(20) NOT NULL,
  `work_experience` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `treatment` varchar(50) NOT NULL,
  `job_status` int(1) DEFAULT 0,
  `create_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_college_id` (`college_id`),
  CONSTRAINT `fk_college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('2', '101', '1', '人工智能专家', '教授', '北京', '5', '5年', '老牛逼了', '30k', '1', '2018-05-02 16:44:53');
INSERT INTO `job` VALUES ('3', '102', '1', '前端专家', '教授', '北京', '5', '5年', '老牛逼了', '1000', null, '2018-05-02 16:40:04');
INSERT INTO `job` VALUES ('4', '103', '1', '算法专家', '教授', '北京', '5', '5年', '老牛逼了', '1000k', null, '2018-05-03 10:33:33');


-- ----------------------------
-- Table structure for delivery_record
-- ----------------------------
DROP TABLE IF EXISTS `delivery_record`;
CREATE TABLE `delivery_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_record_num` int(11) NOT NULL,
  `job_seeker_id` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  `resume_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `delivery_time` timestamp(0) NOT NULL,
  `delivery_status` int(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `fk_job_id` (`job_id`),
  CONSTRAINT `fk_job_id` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  KEY `fk_seeker_id` (`job_seeker_id`),
  CONSTRAINT `fk_seeker_id` FOREIGN KEY (`job_seeker_id`) REFERENCES `job_seeker` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_record
-- ----------------------------
INSERT INTO `delivery_record` VALUES ('1', '1', '1', '1', '1', '2', '2018-05-03 10:39:53', null);
