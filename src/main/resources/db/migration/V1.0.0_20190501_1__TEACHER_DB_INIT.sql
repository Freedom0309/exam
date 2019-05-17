/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-05-15 21:04:40
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
  `school_id` int(10) DEFAULT NULL COMMENT '学校',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='批次表';

-- ----------------------------
-- Records of batch
-- ----------------------------
INSERT INTO `batch` VALUES ('3', '文科', '2019', '1', '1000', '800', '500', '503', '20');
INSERT INTO `batch` VALUES ('4', '理科', '2019', '1', '400', '400', '450', '450', '20');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='留言板表';


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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('17', '计算机科学与技术', '理工类', '还不错', '123');
INSERT INTO `profession` VALUES ('18', '软件工程', '软件', '', '12');
INSERT INTO `profession` VALUES ('19', '物理', '物理', '', '123');
INSERT INTO `profession` VALUES ('20', '化学', '化学', '', '0');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `description` varchar(500) DEFAULT NULL COMMENT '学校简介',
  `address` varchar(100) DEFAULT NULL COMMENT '学校地址',
  `url` varchar(100) DEFAULT NULL COMMENT '招生连接',
  `level` varchar(100) DEFAULT NULL COMMENT '招生层次',
  `type` varchar(100) DEFAULT NULL COMMENT '学校类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('20', '西安工业大学', '西安工业大学（Xi’an Technological University）简称“西安工大”，位于世界历史名城古都西安，是中国西北地区唯一一所以兵工为特色，多学科协调发展的教学研究型大学。原中华人民共和国兵器工业部直属的七所本科院校之一（“兵工七子”）', '西安市未央区', 'http://www.xatu.cn/', '一本', '理工类');
INSERT INTO `school` VALUES ('21', '陕西师范大学', '师范', '西安', 'https://www._.com', '一本', '师范');
INSERT INTO `school` VALUES ('22', '长安大学', '长安', '长安', 'http://www.ca.cn', '一本', '理工类');
INSERT INTO `school` VALUES ('23', '电子科技大学', '电子', '西安', 'http://www.dianzi.com', '一本', '理工');

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
-- Table structure for school_line
-- ----------------------------
DROP TABLE IF EXISTS `school_line`;
CREATE TABLE `school_line` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school_id` int(10) NOT NULL COMMENT '学校id',
  `school_line` int(10) DEFAULT NULL COMMENT '学校分数线',
  `arts_science` varchar(20) DEFAULT NULL COMMENT '文理科',
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校名称',
  `profession_id` int(10) DEFAULT NULL COMMENT '专业id',
  `profession_name` varchar(64) DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_line
-- ----------------------------
INSERT INTO `school_line` VALUES ('5', '21', '123', '理科', null, '17', null);
INSERT INTO `school_line` VALUES ('6', '21', '233', '理科', null, '18', null);
INSERT INTO `school_line` VALUES ('7', '22', '234', '理科', null, '19', null);
INSERT INTO `school_line` VALUES ('8', '20', '450', '理科', null, '18', null);

-- ----------------------------
-- Table structure for school_profession
-- ----------------------------
DROP TABLE IF EXISTS `school_profession`;
CREATE TABLE `school_profession` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school_id` int(10) DEFAULT NULL COMMENT '学校id',
  `profession_id` int(10) DEFAULT NULL COMMENT '专业id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='学校专业表';

-- ----------------------------
-- Records of school_profession
-- ----------------------------
INSERT INTO `school_profession` VALUES ('1', '20', '17');
INSERT INTO `school_profession` VALUES ('2', '20', '18');
INSERT INTO `school_profession` VALUES ('3', '21', '17');
INSERT INTO `school_profession` VALUES ('4', '21', '18');
INSERT INTO `school_profession` VALUES ('5', '22', '19');
INSERT INTO `school_profession` VALUES ('6', '22', '20');
INSERT INTO `school_profession` VALUES ('7', '20', '19');
INSERT INTO `school_profession` VALUES ('8', '20', '20');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='省控线';

-- ----------------------------
-- Records of scoreline
-- ----------------------------
INSERT INTO `scoreline` VALUES ('2', '2019', '1', '500', '理科');
INSERT INTO `scoreline` VALUES ('3', '2019', '1', '506', '文科');
INSERT INTO `scoreline` VALUES ('4', '2019', '2', '480', '理科');
INSERT INTO `scoreline` VALUES ('5', '2019', '2', '498', '文科');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `name` varchar(50) NOT NULL comment '姓名',
  `age` int(11) NOT NULL comment '年龄',
  `phone` varchar(50) NOT NULL comment '手机号',
  `sex` varchar(2) DEFAULT NULL comment '性别',
  `birth` date DEFAULT NULL comment '生日',
  `password` varchar(50) NOT NULL comment '密码',
  `email` varchar(50) DEFAULT NULL comment '邮箱',
  `role` int(11) DEFAULT NULL comment '角色',
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : exam1

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-05-18 01:57:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '城市名称',
  `province_id` int(11) DEFAULT NULL COMMENT '省份id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '西安', '1');
INSERT INTO `city` VALUES ('2', '昆明市', '5');
INSERT INTO `city` VALUES ('3', '北京市', '8');
INSERT INTO `city` VALUES ('4', '铜川市', '1');
INSERT INTO `city` VALUES ('5', '宝鸡市', '1');
INSERT INTO `city` VALUES ('6', '咸阳市', '1');
INSERT INTO `city` VALUES ('7', '渭南市', '1');
INSERT INTO `city` VALUES ('8', '榆林市', '1');
INSERT INTO `city` VALUES ('9', '宝鸡市', '1');
INSERT INTO `city` VALUES ('10', '太原市', '4');
INSERT INTO `city` VALUES ('11', '兰州市', '3');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '省名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '陕西省');
INSERT INTO `province` VALUES ('3', '甘肃省');
INSERT INTO `province` VALUES ('4', '山西省');
INSERT INTO `province` VALUES ('5', '云南省');
INSERT INTO `province` VALUES ('6', '湖南省');
INSERT INTO `province` VALUES ('7', '河南省');
INSERT INTO `province` VALUES ('8', '北京市');

