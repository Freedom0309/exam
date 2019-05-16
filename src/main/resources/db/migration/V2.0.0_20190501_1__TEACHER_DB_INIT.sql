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
