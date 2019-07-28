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

 Date: 28/07/2019 17:44:39
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
  `lyj_advertisement_imageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_advertisement_begindatetime` datetime(0) DEFAULT NULL,
  `lyj_advertisement_enddatetime` datetime(0) DEFAULT NULL,
  `lyj_advertisement_page` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_advertisement_pageurl` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`lyj_advertisement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lyj_requirement
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement`;
CREATE TABLE `lyj_requirement`  (
  `lyj_requirement_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_requirement_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '需求名称',
  `lyj_requirement_description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `lyj_requirement_createuser` int(255) DEFAULT NULL COMMENT '创建人',
  `lyj_requirement_applyuser` int(255) DEFAULT NULL COMMENT '中标人',
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
  PRIMARY KEY (`lyj_requirement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lyj_requirement_apply
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement_apply`;
CREATE TABLE `lyj_requirement_apply`  (
  `lyj_requirement_applyid` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_id` int(11) DEFAULT NULL,
  `lyj_volunteer_id` int(11) DEFAULT NULL,
  `lyj_requirement_applystate` int(3) DEFAULT NULL,
  `lyj_requirement_applycomment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_requirement_applystar` int(2) DEFAULT NULL,
  `lyj_requirement_applyrequirementid` int(255) DEFAULT NULL,
  `lyj_requirement_applyduration` int(20) DEFAULT NULL,
  PRIMARY KEY (`lyj_requirement_applyid`) USING BTREE,
  INDEX `fk_apply_requirement`(`lyj_requirement_applyrequirementid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lyj_requirement_type
-- ----------------------------
DROP TABLE IF EXISTS `lyj_requirement_type`;
CREATE TABLE `lyj_requirement_type`  (
  `lyj_requirement_typeid` int(20) NOT NULL AUTO_INCREMENT,
  `lyj_requirement_typename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_requirement_typeparentid` int(20) DEFAULT NULL COMMENT '上级ID',
  PRIMARY KEY (`lyj_requirement_typeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
-- Table structure for lyj_user
-- ----------------------------
DROP TABLE IF EXISTS `lyj_user`;
CREATE TABLE `lyj_user`  (
  `lyj_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_openid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_gender` int(5) DEFAULT NULL,
  `lyj_user_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_age` int(5) DEFAULT NULL,
  `lyj_user_country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_creditid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_livingplace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_workplace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lyj_user_creditpositive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证正面图URL',
  `lyj_user_creditnegative` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证反面图URL',
  `lyj_user_rewards` int(30) DEFAULT NULL COMMENT '个人积分',
  PRIMARY KEY (`lyj_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lyj_volunteer
-- ----------------------------
DROP TABLE IF EXISTS `lyj_volunteer`;
CREATE TABLE `lyj_volunteer`  (
  `lyj_volunteer_id` int(11) NOT NULL AUTO_INCREMENT,
  `lyj_user_id` int(11) NOT NULL,
  PRIMARY KEY (`lyj_volunteer_id`) USING BTREE,
  INDEX `fk_volunteer_user`(`lyj_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
