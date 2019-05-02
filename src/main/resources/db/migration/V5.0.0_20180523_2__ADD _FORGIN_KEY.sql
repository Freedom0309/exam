

ALTER TABLE `job` ADD  `reqiured_id`  int(11) NULL DEFAULT NULL;

ALTER TABLE `job` ADD CONSTRAINT `job_required_id` FOREIGN KEY (`reqiured_id`) REFERENCES `requirement` (`id`);
