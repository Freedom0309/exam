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
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------

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
  `updatetime` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resume_id` (`resume_id`),
  CONSTRAINT `fk_resume_id` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_seeker
-- ----------------------------

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
  `desc` text NOT NULL,
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
