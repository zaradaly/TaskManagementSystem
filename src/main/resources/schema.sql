DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `t_id` int(11) AUTO_INCREMENT,
  `t_name` varchar(255) NOT NULL,
  `t_group` int(11) NOT NULL,
  `t_assignee` int(11) NOT NULL,
  `t_parent_id` int(11) NOT NULL,
  `t_status` int(11) NOT NULL,
  `t_time_spent` int(11) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;