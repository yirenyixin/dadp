/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : crm_testdb

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 30/06/2023 21:00:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_book
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_book`;
CREATE TABLE `t_sys_book`  (
  `Book_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Book_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AUTHOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime NULL DEFAULT NULL,
  `ROLE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ROLE_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Book_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_book
-- ----------------------------
INSERT INTO `t_sys_book` VALUES ('1', '1', '1', '2023-06-30 14:20:49', 'admin', 'admin');
INSERT INTO `t_sys_book` VALUES ('2', '2', '2', '2023-06-30 17:15:39', 'admin', 'admin');
INSERT INTO `t_sys_book` VALUES ('3', '6', '3', '2023-06-30 20:59:23', 'admin', 'admin');
INSERT INTO `t_sys_book` VALUES ('4', '4', '4', '2023-06-30 20:59:28', 'admin', 'admin');
INSERT INTO `t_sys_book` VALUES ('5', '5', '5', '2023-06-30 20:59:31', 'admin', 'admin');
INSERT INTO `t_sys_book` VALUES ('Test', 'Updated Book', 'Updated Author', '2023-06-30 20:59:34', 'Updated role', 'Updated roleid');

SET FOREIGN_KEY_CHECKS = 1;
