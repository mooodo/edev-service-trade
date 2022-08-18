/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50635
Source Host           : master:32306
Source Database       : edevProduct

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2022-08-18 15:28:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_classify`;
CREATE TABLE `t_classify` (
  `id` int(6) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `parent_id` int(6) DEFAULT NULL,
  `layer` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classify
-- ----------------------------
INSERT INTO `t_classify` VALUES ('0', '分类产品', null, '0');
INSERT INTO `t_classify` VALUES ('100000', '电子产品', '0', '1');
INSERT INTO `t_classify` VALUES ('100100', '智能手机', '100000', '2');
INSERT INTO `t_classify` VALUES ('100200', '平板电脑', '100000', '2');
INSERT INTO `t_classify` VALUES ('100300', '笔记本电脑', '100000', '2');
INSERT INTO `t_classify` VALUES ('100400', '智能手表', '100000', '2');
INSERT INTO `t_classify` VALUES ('100500', '电纸书', '100000', '2');
INSERT INTO `t_classify` VALUES ('200000', '家用电器', '0', '1');
INSERT INTO `t_classify` VALUES ('200100', '冰箱', '200000', '2');
INSERT INTO `t_classify` VALUES ('200200', '电视', '200000', '2');
INSERT INTO `t_classify` VALUES ('200300', '电饭煲', '200000', '2');
INSERT INTO `t_classify` VALUES ('200400', '洗衣机', '200000', '2');
INSERT INTO `t_classify` VALUES ('300000', '图书', '0', '1');
INSERT INTO `t_classify` VALUES ('300100', '技术书籍', '300000', '2');
INSERT INTO `t_classify` VALUES ('400000', '办公用品', '0', '1');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `supplier_id` int(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `original_price` decimal(10,2) DEFAULT NULL,
  `tip` varchar(20) DEFAULT NULL,
  `classify_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('30001', 'Apple iPhone X 256GB 深空灰色 移动联通电信4G手机', '4000.00', '台', '20004', '/static/img/product1.jpg', '5600.00', '自营', '100100');
INSERT INTO `t_product` VALUES ('30002', 'Apple iPad 平板电脑 2018年新款9.7英寸', '12600.00', '台', '20004', '/static/img/product2.jpg', '13000.00', '优惠', '100200');
INSERT INTO `t_product` VALUES ('30003', 'Apple MacBook Pro 13.3英寸笔记本电脑（2017款Core i5处理器/8GB内存/256GB硬盘 MupxT2CH/A）', '10688.00', '台', '20004', '/static/img/product3.jpg', '12999.00', '特惠', '100300');
INSERT INTO `t_product` VALUES ('30004', 'Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色', '958.00', '个', '20002', '/static/img/product4.jpg', '999.00', '自营', '100500');
INSERT INTO `t_product` VALUES ('30005', '微软（Microsoft）新Surface Pro 二合一平板电脑笔记本 12.3英寸（i5 8G内存 256G存储）', '8288.00', '台', '20005', '/static/img/product5.jpg', '8888.00', null, '100300');
INSERT INTO `t_product` VALUES ('30006', 'Apple Watch Series 3智能手表（GPS款 42毫米 深空灰色铝金属表壳 黑色运动型表带 MQL12CH/A）', '2799.00', '块', '20004', '/static/img/product6.jpg', '2899.00', '优惠', '100400');
INSERT INTO `t_product` VALUES ('30007', '华为 HUAWEI Mate 30E Pro 5G麒麟990E SoC芯片 双4000万徕卡电影影像 8GB+256GB青山黛全网通手机', '5799.00', '台', '20003', '/static/img/HUAWEI_Mate_30E Pro.jpg', '6000.00', '秒杀', '100100');
INSERT INTO `t_product` VALUES ('30008', 'HUAWEI WATCH GT2 华为手表 运动智能手表 两周长续航/蓝牙通话/血氧检测/麒麟芯片 华为gt2 46mm 曜石黑', '1488.00', '块', '20003', '/static/img/WATCH_GT2.jpg', '1500.00', '秒杀', '100400');
INSERT INTO `t_product` VALUES ('30009', '华为平板MatePad Pro【键盘+笔】10.8英寸麒麟990游戏影音娱乐办公学习全面屏平板电脑8G+256G WIFI', '4999.00', '台', '20003', '/static/img/MatePad_Pro.jpg', '5500.00', null, '100200');
INSERT INTO `t_product` VALUES ('30010', '领域驱动设计 软件核心复杂性应对之道 英文版(异步图书出品)', '82.90', '本', '20006', '/static/img/DDD.jpg', '84.00', null, '300100');
INSERT INTO `t_product` VALUES ('30011', '实现领域驱动设计(博文视点出品) [Implementing Domain-Driven Design]', '82.90', '本', '20006', '/static/img/Implementing_Domain-Driven_Design.jpg', '84.00', '自营', '300100');
INSERT INTO `t_product` VALUES ('30012', 'SIEMENS/西门子冰箱双开门家用家电变频风冷无霜保鲜对开门两门618升电冰箱KA61EA66TI 滤膜保鲜', '7799.00', '台', '20007', '/static/img/siemens01.jpg', '8000.00', null, '200100');
INSERT INTO `t_product` VALUES ('30013', 'SIEMENS/西门子冰箱三门家用家电直冷节能多门小冰箱小型三开门232升电冰箱KG23D113EW', '2599.00', '台', '20007', '/static/img/siemens02.jpg', '2799.00', null, '200100');
INSERT INTO `t_product` VALUES ('30014', '荣耀智慧屏X1 65英寸LOK-360 2G+16G 8K解码开关机无广告远场语音4K超清人工智能液晶教育电视全面屏', '3999.00', '台', '20003', '/static/img/tv.jpg', '4200.00', null, '200200');
INSERT INTO `t_product` VALUES ('30015', '万利达 商用电压力锅8L10L12L升大容量电高压锅大电饭锅特大号饭煲双胆酒店饭店食堂单位 8升单胆5-9人份', '238.00', '个', '20008', '/static/img/fff.png', '250.00', '自营', '200300');
