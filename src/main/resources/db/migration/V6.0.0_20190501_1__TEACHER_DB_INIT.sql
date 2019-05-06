/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-05-06 14:59:03
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
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '110', 'jc', '女', '1993-10-09 00:00:00', '123456', 'qqq.11', '123', '2018-05-02 23:53:49');

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `arts_science` varchar(20) DEFAULT NULL COMMENT '文理科',
  `year` int(10) DEFAULT NULL COMMENT '年份',
  `batch_number` int(10) DEFAULT NULL COMMENT '学校批次',
  `low_batch` int(10) DEFAULT NULL COMMENT '最低录取位次',
  `avg_batch` int(10) DEFAULT NULL COMMENT '平均录取位次',
  `low_score` int(10) DEFAULT NULL COMMENT '最低录取分数',
  `avg_score` int(10) DEFAULT NULL COMMENT '平均录取分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='批次表';

-- ----------------------------
-- Records of batch
-- ----------------------------
INSERT INTO `batch` VALUES ('1', '1223', '2012', '12', '1', '1', '23', '23');
INSERT INTO `batch` VALUES ('2', '文科', '2013', '2', '2', '2', '2', '2');

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
  `status` int(1) DEFAULT '0',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '2130609', '计算机学院', '贾超', '01089898989', '牛逼', '123456', 'jiahao@qq.com', '0', '2018-05-02 16:36:47');
INSERT INTO `college` VALUES ('2', '2130708', '电信学院', '贾智商', '01089898989', '牛逼', '123456', 'jiahqqao@qq.com', '0', '2018-05-03 10:33:05');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `time` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言板表';

-- ----------------------------
-- Records of comment
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
  `delivery_time` datetime NOT NULL,
  `delivery_status` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_job_id` (`job_id`),
  KEY `fk_seeker_id` (`job_seeker_id`),
  CONSTRAINT `fk_job_id` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `fk_seeker_id` FOREIGN KEY (`job_seeker_id`) REFERENCES `job_seeker` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_record
-- ----------------------------
INSERT INTO `delivery_record` VALUES ('1', '1', '1', '1', '1', '2', '2018-05-03 00:00:00', '1');

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
  `job_status` int(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reqiured_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_college_id` (`college_id`),
  KEY `job_required_id` (`reqiured_id`),
  CONSTRAINT `fk_college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`),
  CONSTRAINT `job_required_id` FOREIGN KEY (`reqiured_id`) REFERENCES `requirement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('2', '101', '1', '人工智能专家', '教授', '北京', '5', '5年', '老牛逼了', '30k', '1', '2018-05-02 16:44:53', null);

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
  `status` int(1) DEFAULT '0',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_resume_id` (`resume_id`),
  CONSTRAINT `fk_resume_id` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_seeker
-- ----------------------------
INSERT INTO `job_seeker` VALUES ('1', '2130609', '贾超', '01089898989', '女', '1999-04-20 18:24:06', '123456', 'aaa@aa.com', '1', '0', '2018-05-03 10:37:12');
INSERT INTO `job_seeker` VALUES ('2', '123', 'zz', '15399422222', null, null, '123456', null, null, null, '2019-05-01 18:57:22');
INSERT INTO `job_seeker` VALUES ('3', '111', '123', '12312312312', null, null, '123', null, null, null, '2019-05-03 22:20:16');

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '专业名',
  `description` varchar(100) DEFAULT NULL COMMENT '专业描述',
  `future` varchar(100) DEFAULT NULL COMMENT '前景',
  `compensation` int(10) DEFAULT NULL COMMENT '平均薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('17', '计算机科学与技术', '理工类', '还不错', '123');

-- ----------------------------
-- Table structure for requirement
-- ----------------------------
DROP TABLE IF EXISTS `requirement`;
CREATE TABLE `requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_num` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `description` text NOT NULL,
  `req_status` int(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `rq_college_id` (`college_id`),
  CONSTRAINT `rq_college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requirement
-- ----------------------------

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resume_num` int(11) NOT NULL,
  `resume_status` int(1) DEFAULT '0',
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `id_no` varchar(50) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(2) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `education_experience` text NOT NULL,
  `work_experience` text NOT NULL,
  `personal_evaluation` text,
  `annex_url` varchar(50) DEFAULT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '2130609', '1', '贾超', '119', '111111111111111111', '女', '40', '2018-05-21 10:35:14', 'aaa.aa', '哦i分覅死哦分', '违法', '方式', '人人', '2018-05-03 10:35:42');

-- ----------------------------
-- Table structure for schema_version
-- ----------------------------
DROP TABLE IF EXISTS `schema_version`;
CREATE TABLE `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schema_version
-- ----------------------------
INSERT INTO `schema_version` VALUES ('1', '1.0.0.20171229.1', 'TEACHER DB INIT', 'SQL', 'V1.0.0_20171229_1__TEACHER_DB_INIT.sql', '-771315287', 'root', '2019-04-30 23:40:13', '1837', '1');
INSERT INTO `schema_version` VALUES ('2', '2.0.0.20171229.1', 'TEACHER DB INIT', 'SQL', 'V2.0.0_20171229_1__TEACHER_DB_INIT.sql', '1792981726', 'root', '2019-04-30 23:40:16', '3145', '1');
INSERT INTO `schema_version` VALUES ('3', '3.0.0.20171229.1', 'TEACHER DB INIT', 'SQL', 'V3.0.0_20171229_1__TEACHER_DB_INIT.sql', '-2084765895', 'root', '2019-04-30 23:40:19', '3009', '1');
INSERT INTO `schema_version` VALUES ('4', '4.0.0.20171229.1', 'TEACHER DB INIT', 'SQL', 'V4.0.0_20171229_1__TEACHER_DB_INIT.sql', '1268169373', 'root', '2019-04-30 23:40:22', '3109', '1');
INSERT INTO `schema_version` VALUES ('5', '5.0.0.20171229.1', 'TEACHER DB INIT', 'SQL', 'V5.0.0_20171229_1__TEACHER_DB_INIT.sql', '185842543', 'root', '2019-04-30 23:40:26', '4015', '1');
INSERT INTO `schema_version` VALUES ('6', '5.0.0.20180522.1', 'UPDATE DB FIELD', 'SQL', 'V5.0.0_20180522_1__UPDATE_DB_FIELD.sql', '1503879877', 'root', '2019-04-30 23:40:27', '651', '1');
INSERT INTO `schema_version` VALUES ('7', '5.0.0.20180523.2', 'ADD  FORGIN KEY', 'SQL', 'V5.0.0_20180523_2__ADD _FORGIN_KEY.sql', '-1164673608', 'root', '2019-04-30 23:40:28', '1038', '1');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `description` varchar(100) DEFAULT NULL COMMENT '学校简介',
  `address` varchar(100) DEFAULT NULL COMMENT '学校地址',
  `url` varchar(100) DEFAULT NULL COMMENT '招生连接',
  `level` varchar(100) DEFAULT NULL COMMENT '招生层次',
  `type` varchar(100) DEFAULT NULL COMMENT '学校类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('20', '西安工业大学', '西工院', '未央区', 'http://www.xiangongye.com', '一本', '理工类');
INSERT INTO `school` VALUES ('21', '陕西师范大学', '师范', 'dont know', 'https://www._.com', '一本', '师范');

-- ----------------------------
-- Table structure for school_batch
-- ----------------------------
DROP TABLE IF EXISTS `school_batch`;
CREATE TABLE `school_batch` (
  `id` int(10) NOT NULL,
  `school_id` int(10) DEFAULT NULL COMMENT '学校id',
  `batch_id` int(10) DEFAULT NULL COMMENT '批次id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_batch
-- ----------------------------

-- ----------------------------
-- Table structure for school_profession
-- ----------------------------
DROP TABLE IF EXISTS `school_profession`;
CREATE TABLE `school_profession` (
  `id` int(10) NOT NULL,
  `school_id` int(10) DEFAULT NULL COMMENT '学校id',
  `profession_id` int(10) DEFAULT NULL COMMENT '专业id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校专业表';

-- ----------------------------
-- Records of school_profession
-- ----------------------------

-- ----------------------------
-- Table structure for scoreline
-- ----------------------------
DROP TABLE IF EXISTS `scoreline`;
CREATE TABLE `scoreline` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` int(10) DEFAULT NULL COMMENT '年份',
  `batch_number` int(10) DEFAULT NULL COMMENT '批次',
  `score` int(10) DEFAULT NULL COMMENT '分数线',
  `arts_science` varchar(10) DEFAULT NULL COMMENT '文理科',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='省控线';

-- ----------------------------
-- Records of scoreline
-- ----------------------------
INSERT INTO `scoreline` VALUES ('1', '9999', '1', '233', 'wen111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '生日',
  `role` varchar(1) DEFAULT NULL COMMENT '角色',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
