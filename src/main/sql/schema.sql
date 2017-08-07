-- 数据库初始化脚本

-- 创建数据库
DROP DATABASE if EXISTS SharingBooks;
CREATE DATABASE SharingBooks;
-- 使用数据库
use SharingBooks;
-- 创建用户信息表
CREATE TABLE userinfo(
user_id bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
user_name varchar(64) NOT NULL COMMENT '用户名',
user_pwd varchar(64) NOT NULL COMMENT '用户密码',
user_phone varchar(20) NOT NULL COMMENT '用户联系方式',
PRIMARY KEY(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 初始化数据
insert into 
	userinfo(user_name,user_pwd,user_phone)
values
	('Joey','joey','18176048764'),
	('Vivian','vivian','18179868764'),
	('造福宇','714342','18176048798');
	
-- 创建书籍信息表
CREATE TABLE book(
book_id bigint NOT NULL AUTO_INCREMENT COMMENT '书籍id',
book_name VARCHAR(64) NOT NULL COMMENT '书籍名称',
book_description VARCHAR(128) NOT NULL COMMENT '书籍描述',
master_phone VARCHAR(64) NOT NULL COMMENT '书籍主人联系方式',
release_time timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '书籍发布时间',
PRIMARY KEY (book_id),
key idx_release_tiem(release_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍信息表';

--删除book表格，把书籍表格分为可借图书表和借书信息表
drop table book;

-- 可借书籍表格（字段和书籍表一样）
CREATE TABLE sharedbook(
book_id bigint NOT NULL AUTO_INCREMENT COMMENT '书籍id',
book_name VARCHAR(64) NOT NULL COMMENT '书籍名称',
book_description VARCHAR(128) NOT NULL COMMENT '书籍描述',
master_phone VARCHAR(64) NOT NULL COMMENT '书籍主人联系方式',
release_time timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分享书籍发布时间',
PRIMARY KEY (book_id),
key idx_release_tiem(release_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='可借书籍信息表';
-- 初始化数据
insert into
	sharedbook(book_name,book_description,master_phone,release_time)
values
	('《算法导论》','Stein，机械工业出版社','13476587398','2017-05-23 00:00:00'),
	('《Think in Java》','Eckel，机械工业出版社','18716576483','2017-05-23 00:00:00'),
	('《深入理解Java Web技术内幕》','许令波，电子工业出版社','18775367896','2017-05-23 00:00:00'),
	('《Java核心技术卷一》','Horstmann，机械工业出版社','13748475873','2017-05-23 00:00:00'),
	('《编译原理》','张素琴，清华大学出版社','13878759873','2017-05-23 00:00:00'),
	('《计算机操作系统》','汤小丹，西安电子科技大学出版社','18777837798','2017-05-23 00:00:00');

-- 创建借书登记表
CREATE TABLE borrowedbook(
book_id bigint NOT NULL AUTO_INCREMENT COMMENT '书籍id',
book_name VARCHAR(64) NOT NULL COMMENT '书籍名称',
book_description VARCHAR(128) NOT NULL COMMENT '书籍描述',
borrower_phone VARCHAR(64) NOT NULL COMMENT '借书人联系方式',
release_time timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借书信息发布时间',
PRIMARY KEY (book_id),
key idx_release_tiem(release_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借书信息表';

-- 初始化数据
insert into
	borrowedbook(book_name,book_description,borrower_phone,release_time)
values
	('《算法导论》','Stein，机械工业出版社','13476587398','2017-05-23 00:00:00'),
	('《Think in Java》','Eckel，机械工业出版社','18716576483','2017-05-23 00:00:00'),
	('《深入理解Java Web技术内幕》','许令波，电子工业出版社','18775367896','2017-05-23 00:00:00'),
	('《Java核心技术卷一》','Horstmann，机械工业出版社','13748475873','2017-05-23 00:00:00'),
	('《编译原理》','张素琴，清华大学出版社','13878759873','2017-05-23 00:00:00'),
	('《计算机操作系统》','汤小丹，西安电子科技大学出版社','18777837798','2017-05-23 00:00:00');

-- 创建借阅/借出书籍成功明细表
create table success_borrowed_shared(
list_id bigint NOT NULL AUTO_INCREMENT COMMENT '明细表编号',
book_name bigint NOT NULL COMMENT '借阅/借出图书名称',
book_master varchar(64) NOT NULL COMMENT '书籍主人',
user_name varchar(64) NOT NULL COMMENT '借阅/借出用户',
state tinyint NOT NULL DEFAULT 0 COMMENT '状态标示：1:成功 0:失败',
create_time timestamp  NOT NULL COMMENT '创建时间',
PRIMARY KEY(borrow_id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='借阅/借出书籍成功明细表';

-- 删除借阅/借出书籍成功明细表，把它一分为二，分为借阅成功表，和借出成功表
drop table success_borrowed_shared;

--创建借阅成功明细表
create table success_borrowed(
list_id bigint NOT NULL AUTO_INCREMENT COMMENT '明细表编号',
book_name bigint NOT NULL COMMENT '借阅图书名称',
book_master varchar(64) NOT NULL COMMENT '书籍主人',
state tinyint NOT NULL DEFAULT 0 COMMENT '状态标示：1:成功 0:失败',
create_time timestamp  NOT NULL COMMENT '创建时间',
PRIMARY KEY(list_id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='借阅书籍成功明细表';

-- 创建借出书籍成功明细表
create table success_lended(
list_id bigint NOT NULL AUTO_INCREMENT COMMENT '明细表编号',
book_name bigint NOT NULL COMMENT '借阅图书名称',
book_borrower varchar(64) NOT NULL COMMENT '借书人名字',
state tinyint NOT NULL DEFAULT 0 COMMENT '状态标示：1:成功 0:失败',
create_time timestamp  NOT NULL COMMENT '创建时间',
PRIMARY KEY(list_id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='借出书籍成功明细表';

--修改明细表中的字段
alter table success_borrowed CHANGE state borrower_phone VARCHAR(64) NOT NULL COMMENT '借书人联系方式';
alter table success_lended CHANGE state master_phone VARCHAR(64) NOT NULL COMMENT '书籍主人联系方式';

-- 添加SharedBook表格的测试数据
insert into
	sharedbook(book_name,book_description,master_phone,release_time)
values
	('《算法竞赛入门经典》','刘汝佳，清华大学出版社','13476587387','2017-05-23 00:00:00'),
	('《计算机算法设计与分析》','王晓东，电子工业出版社','18716576498','2017-05-23 00:00:00'),
	('《深入理解Java Web技术内幕》','许令波，电子工业出版社','18715367865','2017-05-23 00:00:00'),
	('《Java核心技术卷一》','Horstmann，机械工业出版社','13748475867','2017-05-23 00:00:00'),
	('《编译原理》','张素琴，清华大学出版社','13878759898','2017-05-23 00:00:00'),
	('《计算机操作系统》','汤小丹，西安电子科技大学出版社','18777837789','2017-05-23 00:00:00'),
	('《汇编语言》','王爽，清华大学出版社','18777837876','2017-05-23 00:00:00'),
	('《数值分析》','李庆杨，清华大学出版社','18777837887','2017-05-23 00:00:00'),
	('《汇编语言》','郑晓薇，机械工业出版社','18777837956','2017-05-23 00:00:00');

-- 添加borrowedbook表的测试数据
	insert into
	borrowedbook(book_name,book_description,borrower_phone,release_time)
values
	('《百年孤独》','加西亚·马尔克斯，南海出版社','13476587398','2017-05-23 00:00:00'),
	('《平凡的世界》','路遥，北京出版集团公司','18716576483','2017-05-23 00:00:00'),
	('《深入理解Java Web技术内幕》','许令波，电子工业出版社','18775367896','2017-05-23 00:00:00'),
	('《Java核心技术卷一》','Horstmann，机械工业出版社','13748475873','2017-05-23 00:00:00'),
	('《编译原理》','张素琴，清华大学出版社','13878759873','2017-05-23 00:00:00'),
	('《计算机操作系统》','汤小丹，西安电子科技大学出版社','18777837798','2017-05-23 00:00:00'),
	('《C++ Primer》','Lippman，人民邮电出版社','18777837798','2017-05-23 00:00:00'),
	('《高等数学》','同济大学数学系，高等教育出版社','18777837798','2017-05-23 00:00:00'),
	('《TCP/IP详细卷一》','斯蒂文斯，机械工业出版社','18777837798','2017-05-23 00:00:00');
	
-- 调整成功借阅书籍表
--把字段list_id 改为字段book_id 
alter table success_borrowed change list_id book_id bigint NOT NULL AUTO_INCREMENT COMMENT '明细表编号';
--删除字段book_name, 字段book_master
alter table success_borrowed drop book_name, drop book_master;

-- 调整成功借出书籍表
--把字段list_id 改为字段book_id 
alter table success_lended change list_id book_id bigint NOT NULL AUTO_INCREMENT COMMENT '明细表编号';
--删除字段book_name, 字段book_master
alter table success_lended drop book_name, drop book_borrower;