/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : lyj

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/08/2019 21:23:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lyj_advertisement
-- ----------------------------
DROP TABLE IF EXISTS `lyj_advertisement`;
CREATE TABLE `lyj_advertisement`  (
  `lyj_advertisement_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_advertisement_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_advertisement_imageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '广告图片的url',
  `lyj_advertisement_begindatetime` datetime(0) DEFAULT NULL COMMENT '广告投放时间',
  `lyj_advertisement_enddatetime` datetime(0) DEFAULT NULL COMMENT '投放结束时间',
  `lyj_advertisement_page` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '广告存放的页面',
  `lyj_advertisement_pageurl` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '点击图片跳转的URl',
  PRIMARY KEY (`lyj_advertisement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_advertisement
-- ----------------------------
INSERT INTO `lyj_advertisement` VALUES (1, 'homeimg1123', NULL, '2019-08-12 16:06:05', '2019-08-27 16:07:08', 'home', NULL);
INSERT INTO `lyj_advertisement` VALUES (2, 'homeimg2', NULL, '2019-08-12 16:06:05', '2019-08-27 16:07:08', 'home', NULL);
INSERT INTO `lyj_advertisement` VALUES (4, 'storeimg1', NULL, NULL, '2019-08-27 16:07:08', 'store', NULL);
INSERT INTO `lyj_advertisement` VALUES (6, 'requirementimg1', NULL, '2019-08-12 16:06:05', '2019-08-27 16:07:08', 'requirement', NULL);
INSERT INTO `lyj_advertisement` VALUES (9, 'homeimg44444', '', '2019-08-12 16:06:05', '2019-08-27 16:07:08', '', '');
INSERT INTO `lyj_advertisement` VALUES (10, '测试广告名称1', '', '2019-08-12 16:06:05', '2019-08-27 16:07:08', '', '');

-- ----------------------------
-- Table structure for lyj_requirement
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement`;
CREATE TABLE `lyj_requirement`  (
  `lyj_requirement_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_requirement_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '需求名称',
  `lyj_requirement_description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `lyj_requirement_createuser` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `lyj_requirement_applyuser` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中标人',
  `lyj_requirement_isvolunteer` int(255) DEFAULT NULL COMMENT '是否为义工需求',
  `lyj_requirement_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '城市',
  `lyj_requirement_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地区',
  `lyj_requirement_street` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '街道',
  `lyj_requirement_createdatetime` datetime(0) DEFAULT NULL COMMENT '需求创建时间',
  `lyj_requirement_begindatetime` datetime(0) DEFAULT NULL COMMENT '开始时间',
  `lyj_requirement_enddatetime` datetime(0) DEFAULT NULL COMMENT '结束时间',
  `lyj_requirement_rawaddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '大约地址',
  `lyj_requirement_maplocation` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地图位置',
  `lyj_requirement_reward` int(10) DEFAULT NULL COMMENT '积分',
  `lyj_requirement_volunteerperfer` int(5) DEFAULT NULL COMMENT '义工优先性别',
  `lyj_requirement_detailadd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '门牌号',
  PRIMARY KEY (`lyj_requirement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_requirement
-- ----------------------------
INSERT INTO `lyj_requirement` VALUES (1, '家务需求442244', 'dddddd', '13cae96b95ba280b8828b611e9c24c4ad3', '2', NULL, 'cccccc', 'aaaaa', 'sssss', '2019-08-02 23:06:37', '2019-08-01 15:06:42', '2019-07-30 15:06:46', 'rrrrrr', 'urllllll', 200, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (2, '家务需求2', NULL, '13cae96b95ba280b8828b611e9c24c4ad3', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (10, '劳力需求5', NULL, '3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (11, '脑力需求1', NULL, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (34, '家务123123需求5', NULL, '2c144fb70c2ad4efff8f54a1939f6533', '13cae96b95ba280b8828b611e9c24c4ad3', NULL, NULL, NULL, NULL, '2019-08-11 06:00:03', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (36, '测试啊家务需求2', NULL, '2c144fb70c2ad4efff8f54a1939f6533', '2', NULL, NULL, NULL, NULL, '2019-08-13 12:11:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (43, '高级的需求2', NULL, NULL, '2', NULL, NULL, NULL, NULL, '2019-08-23 14:17:54', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lyj_requirement` VALUES (53, '测试需求类型加入', '', NULL, NULL, NULL, '', '', '', '2019-08-27 14:54:44', NULL, NULL, '', NULL, NULL, NULL, '');

-- ----------------------------
-- Table structure for lyj_requirement_apply
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement_apply`;
CREATE TABLE `lyj_requirement_apply`  (
  `lyj_requirement_applyid` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人的UUID',
  `lyj_volunteer_id` int(11) DEFAULT NULL COMMENT '志愿者的ID',
  `lyj_requirement_applystate` int(3) DEFAULT NULL COMMENT '状态',
  `lyj_requirement_applycomment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评价',
  `lyj_requirement_applystar` int(5) DEFAULT NULL COMMENT '星级',
  `lyj_requirement_applyrequirementid` int(255) DEFAULT NULL COMMENT '申请的需求ID',
  `lyj_requirement_applyduration` int(20) DEFAULT NULL COMMENT '持续时间',
  PRIMARY KEY (`lyj_requirement_applyid`) USING BTREE,
  INDEX `fk_apply_requirement`(`lyj_requirement_applyrequirementid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_requirement_apply
-- ----------------------------
INSERT INTO `lyj_requirement_apply` VALUES (1, '2c144fb70c2ad4efff8f54a1939f6533', NULL, 5, NULL, 1, 1, 20);
INSERT INTO `lyj_requirement_apply` VALUES (2, '2c144fb70c2ad4efff8f54a1939f6533', NULL, 5, NULL, NULL, 1, 45);
INSERT INTO `lyj_requirement_apply` VALUES (3, '2c144fb70c2ad4efff8f54a1939f6533', NULL, 5, NULL, 2, 35, NULL);
INSERT INTO `lyj_requirement_apply` VALUES (7, '2c144fb70c2ad4efff8f54a1939f6533', NULL, 2, '继续测试', 4, 42, 111);
INSERT INTO `lyj_requirement_apply` VALUES (8, '2c144fb70c2ad4efff8f54a1939f6533', NULL, NULL, '', NULL, NULL, NULL);
INSERT INTO `lyj_requirement_apply` VALUES (9, '11111111', NULL, 5, '', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for lyj_requirement_type
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement_type`;
CREATE TABLE `lyj_requirement_type`  (
  `lyj_requirement_typeid` int(20) NOT NULL AUTO_INCREMENT,
  `lyj_requirement_typename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_requirement_typeparentid` int(20) DEFAULT NULL COMMENT '上级ID',
  PRIMARY KEY (`lyj_requirement_typeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_requirement_type
-- ----------------------------
INSERT INTO `lyj_requirement_type` VALUES (1, '家务需求类455', NULL);
INSERT INTO `lyj_requirement_type` VALUES (2, '劳力需求类', NULL);
INSERT INTO `lyj_requirement_type` VALUES (3, '脑力需求类', NULL);
INSERT INTO `lyj_requirement_type` VALUES (4, '脚需求类', NULL);
INSERT INTO `lyj_requirement_type` VALUES (5, '手需求类', NULL);
INSERT INTO `lyj_requirement_type` VALUES (7, '家务需求类', 1);

-- ----------------------------
-- Table structure for lyj_requirementtype_relation
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirementtype_relation`;
CREATE TABLE `lyj_requirementtype_relation`  (
  `lyj_requirement_id` int(11) NOT NULL,
  `lyj_requirement_typeid` int(11) NOT NULL,
  PRIMARY KEY (`lyj_requirement_id`, `lyj_requirement_typeid`) USING BTREE,
  INDEX `fk_re_type_relation_type`(`lyj_requirement_typeid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_requirementtype_relation
-- ----------------------------
INSERT INTO `lyj_requirementtype_relation` VALUES (2, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (3, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (4, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (5, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (36, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (53, 1);
INSERT INTO `lyj_requirementtype_relation` VALUES (6, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (7, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (8, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (9, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (10, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (43, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (53, 2);
INSERT INTO `lyj_requirementtype_relation` VALUES (11, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (12, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (13, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (14, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (15, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (34, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (43, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (53, 3);
INSERT INTO `lyj_requirementtype_relation` VALUES (33, 4);
INSERT INTO `lyj_requirementtype_relation` VALUES (33, 5);
INSERT INTO `lyj_requirementtype_relation` VALUES (1, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (37, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (38, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (39, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (40, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (41, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (42, 7);
INSERT INTO `lyj_requirementtype_relation` VALUES (53, 7);

-- ----------------------------
-- Table structure for lyj_user
-- ----------------------------
DROP TABLE IF EXISTS `lyj_user`;
CREATE TABLE `lyj_user`  (
  `lyj_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_openid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_gender` int(5) DEFAULT NULL,
  `lyj_user_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '籍贯',
  `lyj_user_age` int(5) DEFAULT NULL,
  `lyj_user_country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_creditid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机',
  `lyj_user_livingplace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '住址',
  `lyj_user_workplace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_creditpositive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证正面图URL',
  `lyj_user_creditnegative` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证反面图URL',
  `lyj_user_rewards` int(30) DEFAULT NULL COMMENT '个人积分',
  `lyj_user_birthday` date DEFAULT NULL COMMENT '出生日期',
  `lyj_user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `lyj_user_uuid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户唯一标识',
  PRIMARY KEY (`lyj_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_user
-- ----------------------------
INSERT INTO `lyj_user` VALUES (1, 'string', '李四', 1, '广元市', 0, '', '411282199402285074', '18821202289', '佘山102', '佘山101', NULL, NULL, 0, '2011-08-17', '1234567', '13cae96b95ba280b8828b611e9c24c4ad3');
INSERT INTO `lyj_user` VALUES (43, NULL, '123123张23423三', NULL, '牛211111脑', NULL, '新1231231231231西兰', NULL, '18821202388', NULL, NULL, NULL, NULL, NULL, '2013-08-17', '123123', '2c144fb70c2ad4efff8f54a1939f6533');
INSERT INTO `lyj_user` VALUES (44, 'string', '李1111111四', 1, '广元市', 0, '', '411282199402285074', '1111111111', '佘山102', '佘山101', NULL, NULL, 0, '2009-08-17', '99999999', 'asfsdfsdfsdf12312wqwe');
INSERT INTO `lyj_user` VALUES (46, '', '33333333', NULL, '', NULL, '', '', '', '', '', '', '', NULL, NULL, '', 'd41d8cd98f00b204e9800998ecf8427e');
INSERT INTO `lyj_user` VALUES (47, '', '沃尔沃三', NULL, '', 0, '', '', '5651516', '', '', '', '', NULL, NULL, '1111', '9f7437429a674ec54ed04a88284b7f3a');

-- ----------------------------
-- Table structure for lyj_volunteer
-- ----------------------------
DROP TABLE IF EXISTS `lyj_volunteer`;
CREATE TABLE `lyj_volunteer`  (
  `lyj_volunteer_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`lyj_volunteer_id`) USING BTREE,
  INDEX `fk_volunteer_user`(`lyj_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyj_volunteer
-- ----------------------------
INSERT INTO `lyj_volunteer` VALUES (20, '13cae96b95ba280b8828b611e9c24c4ad3');
INSERT INTO `lyj_volunteer` VALUES (25, '2c144fb70c2ad4efff8f54a1939f6533');
INSERT INTO `lyj_volunteer` VALUES (34, '44444444444444');
INSERT INTO `lyj_volunteer` VALUES (30, 'asfsdfsdfsdf12312wqwe');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `sys_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_permission_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`sys_permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `sys_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`sys_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_rolepermission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_rolepermission_relation`;
CREATE TABLE `sys_rolepermission_relation`  (
  `sys_role_id` int(11) NOT NULL COMMENT '角色主键',
  `sys_permission_id` int(11) DEFAULT NULL COMMENT '权限主键',
  PRIMARY KEY (`sys_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_roleuser_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_roleuser_relation`;
CREATE TABLE `sys_roleuser_relation`  (
  `sys_user_id` int(11) NOT NULL COMMENT '用户表主键',
  `sys_role_id` int(11) NOT NULL COMMENT '角色表主键',
  PRIMARY KEY (`sys_user_id`, `sys_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
