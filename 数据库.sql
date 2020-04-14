create database mall_project
use mall_project

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `regdate` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `photo` varchar(100) NULL COMMENT '头像',
  PRIMARY KEY (`id`)
)  COMMENT='用户表';

CREATE TABLE admin(
	id VARCHAR (20) NOT NULL COMMENT'管理员ID',
	admin_name VARCHAR(20) NOT NULL COMMENT '登录名',
	password VARCHAR(100) NOT NULL COMMENT'密码',
	roles VARCHAR(10) NOT NULL COMMENT'管理员角色',
	PRIMARY KEY (id)
)COMMENT '管理员表';

INSERT INTO `admin` VALUES ('699714934900133888', 'SuperAdmin', '$2a$10$6oxwIqmT/pm7yJKztuGVbubGTErAayOYyu/.MUnGMr2LCzxZY9rRi', 'SuperAdmin');


CREATE TABLE comm_sort(
		id int(11) not NULL AUTO_INCREMENT COMMENT '类别Id',
		sort VARCHAR(20) NOT NULL COMMENT '类别Id',
		PRIMARY KEY (id)
)COMMENT'商品类别表'

CREATE TABLE comm_label(
	id int(11) not NULL AUTO_INCREMENT COMMENT '标签ID',
	sort_id int(11) not NULL COMMENT '标签所属类别ID',
	label VARCHAR(20) NOT NULL COMMENT '标签名称',
	PRIMARY KEY(id)
)COMMENT '商品标签表'

CREATE TABLE commodity()COMMENT '商品信息表'