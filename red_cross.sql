/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : red_cross

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 06/09/2020 10:56:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `admin_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `admin_info_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `admin_info_tel` decimal(20, 0) NOT NULL COMMENT '电话',
  `admin_info_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `admin_info_pass` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'MD5加密之后的密码',
  `admin_prohibit` decimal(1, 0) NOT NULL COMMENT '是否禁用 1表示禁用，0表示未禁用',
  `is_top_admin` decimal(1, 0) NOT NULL COMMENT '是否为顶级管理员 1为顶级管理员，0为普通管理员',
  PRIMARY KEY (`admin_info_id`) USING BTREE,
  UNIQUE INDEX `admin_info_login_name`(`admin_info_login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '//管理员  //顶级管理员 //管理员  //顶级管理员 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (1, '吴涛', 13198619896, '15848454515', '25D55AD283AA400AF464C76D713C07AD', 0, 0);
INSERT INTO `admin_info` VALUES (3, '吴涛涛', 13198619896, '1579587634', '3E6E39064886F15C4FA6E3D577FE8B1D', 0, 1);
INSERT INTO `admin_info` VALUES (4, '郭敏', 13165959696, '15454578154', '31944B2250EDB24A5DD534A5D2A0A811', 0, 0);

-- ----------------------------
-- Table structure for donation_goods
-- ----------------------------
DROP TABLE IF EXISTS `donation_goods`;
CREATE TABLE `donation_goods`  (
  `donation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `donation_company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠单位',
  `donation_time` datetime(0) NULL DEFAULT NULL COMMENT '捐赠时间',
  `donation_add` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠单位地址',
  `donation_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠联系人',
  `donation_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠联系人电话',
  `donation_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠联系人邮箱',
  `donation_good` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠物品名称',
  `donation_good_model` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠物品规格型号',
  `donation_good_unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐赠物品单位',
  `donation_good_count` int(11) NULL DEFAULT NULL COMMENT '捐赠数量',
  `donation_good_total_value` int(11) NULL DEFAULT NULL COMMENT '捐赠总价值',
  `donation_purpose_id` int(11) NULL DEFAULT NULL COMMENT '捐赠用途id',
  `donation_type_id` int(11) NULL DEFAULT NULL COMMENT '捐赠分类id',
  `donation_is_secrecy` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否保密 1表示保密，0表示不保密',
  `donation_is_large_money` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否为大金额 1表示为大金额，0表示普通金额',
  `donation_other_explain` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '其他解释说明',
  `donation_good_surplus_count` int(11) NULL DEFAULT NULL COMMENT '该物品剩余数量（捐赠数量 - 接收数量））',
  PRIMARY KEY (`donation_id`) USING BTREE,
  INDEX `donation_purpose_id`(`donation_purpose_id`) USING BTREE,
  INDEX `donation_type_id`(`donation_type_id`) USING BTREE,
  CONSTRAINT `donation_goods_ibfk_1` FOREIGN KEY (`donation_purpose_id`) REFERENCES `donation_purpose` (`donation_purpose_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `donation_goods_ibfk_2` FOREIGN KEY (`donation_type_id`) REFERENCES `donation_type` (`donation_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '接收社会捐赠 // 捐赠表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donation_goods
-- ----------------------------
INSERT INTO `donation_goods` VALUES (1, '上海华东师范大学', '2020-08-31 15:32:27', '上海市中山北路3663号', '侯亮平', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 1000);
INSERT INTO `donation_goods` VALUES (2, '上海交通大学', '2020-08-31 15:32:27', '上海市中山北路3663号', '侯亮平', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 1000);
INSERT INTO `donation_goods` VALUES (3, '复旦大学', '2020-08-31 15:32:27', '上海市中山北路3663号', '侯亮平', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 1000);
INSERT INTO `donation_goods` VALUES (4, '西南财经大学', '2020-09-01 16:56:29', '上海市中山北路3663号', '郭敏仪', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 1000);
INSERT INTO `donation_goods` VALUES (5, '复旦大学', '2020-09-01 00:03:41', '上海市中山北路3663号', '谢金元', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 950);
INSERT INTO `donation_goods` VALUES (6, '中国人民大学', '2020-09-01 00:04:57', '上海市中山北路3663号', '侯亮平', '15785859898', '131986195@qq.com', '一次性医用N95口罩', 'N95', '只', 1000, 20000, 1, 1, 0, 0, '希望可以投入到武汉抗击新冠疫情的行动中', 1000);
INSERT INTO `donation_goods` VALUES (7, '电子科技大学', '2020-09-03 18:40:39', '四川省成都市', '项羽', '15484848989', '15454154541@qq.com', '芯片', 'M85', '台', 15, 4545545, 2, 2, 1, 1, '希望可以用作教学', 5);

-- ----------------------------
-- Table structure for donation_money
-- ----------------------------
DROP TABLE IF EXISTS `donation_money`;
CREATE TABLE `donation_money`  (
  `donation_money_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `donation_money_company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款单位',
  `donation_money_time` datetime(0) NULL DEFAULT NULL COMMENT '捐款时间',
  `donation_money_add` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款单位地址',
  `donation_money_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款联系人',
  `donation_money_tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款联系人电话',
  `donation_money_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款联系人邮箱',
  `donation_money_amount` int(11) NULL DEFAULT NULL COMMENT '捐款金额',
  `donation_is_secrecy` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否保密',
  `donation_is_large_money` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否为大金额',
  `donation_other_explain` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '其他说明',
  PRIMARY KEY (`donation_money_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '捐款表 捐款表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donation_money
-- ----------------------------
INSERT INTO `donation_money` VALUES (1, '东北大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (2, '西南大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (3, '西北大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (4, '中南大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (5, '中北大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (6, '华南理工大学', '2020-09-02 09:58:52', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 1, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (7, '西北工业大学', '2020-09-02 10:39:48', '辽宁省沈阳市和平区文化路三巷11号', '徐佳莹', '18598989696', '1579587634@qq.com', 50000, 0, 0, '希望可以用于我们祖国的建设事业');
INSERT INTO `donation_money` VALUES (8, '西南政法', '2020-09-02 10:38:00', '辽宁省沈阳市和平区文化路三巷11号', '蒋介石', '18598989696', '1579587634@qq.com', 50000, 0, 0, '希望可以用于祖国的建设事业');

-- ----------------------------
-- Table structure for donation_purpose
-- ----------------------------
DROP TABLE IF EXISTS `donation_purpose`;
CREATE TABLE `donation_purpose`  (
  `donation_purpose_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `donation_purpose_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用途名称',
  PRIMARY KEY (`donation_purpose_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '// 用途表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donation_purpose
-- ----------------------------
INSERT INTO `donation_purpose` VALUES (1, '教育');
INSERT INTO `donation_purpose` VALUES (2, '医疗');
INSERT INTO `donation_purpose` VALUES (3, '抗洪');
INSERT INTO `donation_purpose` VALUES (4, '救灾');
INSERT INTO `donation_purpose` VALUES (5, '其他');

-- ----------------------------
-- Table structure for donation_type
-- ----------------------------
DROP TABLE IF EXISTS `donation_type`;
CREATE TABLE `donation_type`  (
  `donation_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `donation_type_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名',
  PRIMARY KEY (`donation_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donation_type
-- ----------------------------
INSERT INTO `donation_type` VALUES (1, '医用物资');
INSERT INTO `donation_type` VALUES (2, '民间捐赠');
INSERT INTO `donation_type` VALUES (3, '政府发放');
INSERT INTO `donation_type` VALUES (4, '国外资助');
INSERT INTO `donation_type` VALUES (5, '其他');

-- ----------------------------
-- Table structure for receiving_good_donation
-- ----------------------------
DROP TABLE IF EXISTS `receiving_good_donation`;
CREATE TABLE `receiving_good_donation`  (
  `receiving_good_donation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `donation_id` int(11) NULL DEFAULT NULL COMMENT '物品id',
  `receiving_good_donation_company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收单位',
  `receiving_good_donation_time` datetime(0) NULL DEFAULT NULL COMMENT '接收时间',
  `receiving_good_donation_add` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收单位地址',
  `receiving_good_donation_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收联系人',
  `receiving_good_donation_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收联系人电话',
  `receiving_good_donation_mail` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收联系人邮箱',
  `receiving_good_donation_good_count` int(11) NULL DEFAULT NULL COMMENT '接收数量',
  `receiving_good_donation_good_total_value` int(11) NULL DEFAULT NULL COMMENT '接收总价值',
  `receiving_good_donation_imag` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片佐证',
  `receiving_good_donation_other_explain` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '其他说明',
  PRIMARY KEY (`receiving_good_donation_id`) USING BTREE,
  INDEX `donation_id`(`donation_id`) USING BTREE,
  CONSTRAINT `receiving_good_donation_ibfk_1` FOREIGN KEY (`donation_id`) REFERENCES `donation_goods` (`donation_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '// 接收物品捐赠的表 // 接收物品捐赠的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receiving_good_donation
-- ----------------------------
INSERT INTO `receiving_good_donation` VALUES (1, 1, '四川长虹', '2020-09-02 11:45:13', '四川省绵阳市', '侯亮平', '15998748585', '1579587634@qq.com', 50, 2000, '', '暂无');
INSERT INTO `receiving_good_donation` VALUES (2, 5, '天府', '2020-09-02 17:27:36', '四川省', '吴涛涛', '13198619896', '1579587634@qq.com', 50, 1000, NULL, '用于成都市的疫情防护');
INSERT INTO `receiving_good_donation` VALUES (3, 7, '深圳华为有限公司', '2020-09-03 16:51:31', '深圳龙岗松山湖', '任正非', '15798989696', '157958634@qq.com', 5, 10000, NULL, '用于芯片的一个研制');
INSERT INTO `receiving_good_donation` VALUES (4, 7, '四川长虹有限公司', '2020-09-03 16:52:59', '四川绵阳', '与董卿', '13198619896', '1579586664@qq.com', 5, 2000, NULL, '用于洗衣机的研发');

-- ----------------------------
-- Table structure for receiving_money_donation
-- ----------------------------
DROP TABLE IF EXISTS `receiving_money_donation`;
CREATE TABLE `receiving_money_donation`  (
  `receiving_money_donation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receiving_money_donation_amount` int(11) NULL DEFAULT NULL COMMENT '接收捐赠的金额',
  `receiving_money_donation_company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收捐赠的单位',
  `receiving_money_donation_time` datetime(0) NULL DEFAULT NULL COMMENT '接收捐赠的时间',
  `receiving_money_donation_add` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收捐赠单位地址',
  `receiving_money_donation_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收捐赠联系人',
  `receiving_money_donation_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收捐赠联系人电话',
  `receiving_money_donation_mail` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收捐赠联系人电话',
  `receiving_money_donation_imag` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片佐证',
  `receiving_money_donation_other_explain` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '其他说明',
  PRIMARY KEY (`receiving_money_donation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '// 接收金钱捐赠的表 // 接收金钱捐赠的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receiving_money_donation
-- ----------------------------
INSERT INTO `receiving_money_donation` VALUES (1, 50000, '电子科技大学', '2020-09-02 18:15:22', '成都省四川市', '郭敏仪', '15795864154', '1579587634@qq.com', NULL, '希望学校越来越好');
INSERT INTO `receiving_money_donation` VALUES (2, 5000, '西南交通大学', '2020-09-02 18:16:11', '四川省成都市天府大道', '张无忌', '131698959595', '1579586541@qq.com', NULL, '暂无');

SET FOREIGN_KEY_CHECKS = 1;
