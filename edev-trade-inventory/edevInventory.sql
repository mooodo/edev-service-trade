SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_inventory
-- ----------------------------
DROP TABLE IF EXISTS `t_inventory`;
CREATE TABLE `t_inventory` (
  `id` int(20) NOT NULL,
  `quantity` int(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inventory
-- ----------------------------
INSERT INTO `t_inventory` VALUES ('30001', '9976', '2024-01-23 23:35:58');
INSERT INTO `t_inventory` VALUES ('30002', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30003', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30004', '9970', '2024-01-23 23:35:58');
INSERT INTO `t_inventory` VALUES ('30005', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30006', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30007', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30008', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30009', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30010', '10000', '2022-03-31 02:40:46');
INSERT INTO `t_inventory` VALUES ('30011', '10000', '2022-03-31 02:40:46');
