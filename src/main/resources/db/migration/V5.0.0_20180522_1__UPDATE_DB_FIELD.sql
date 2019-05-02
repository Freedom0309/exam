


DROP TABLE IF EXISTS `requirement`;
CREATE TABLE `requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_num` int(11) NOT NULL,
  `college_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `description` text NOT NULL,
  `req_status` int(1) NOT NULL DEFAULT '0',
  `create_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rq_college_id` (`college_id`),
  CONSTRAINT `rq_college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;