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

 Date: 29/08/2019 21:22:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
