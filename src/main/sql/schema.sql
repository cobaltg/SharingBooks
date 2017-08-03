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
-- 初始化数据
insert into
	book(book_name,book_description,master_phone,release_time)
values
	('《算法导论》','Stein，机械工业出版社','13476587398','2017-05-23 00:00:00'),
	('《Think in Java》','Eckel，机械工业出版社','18716576483','2017-05-23 00:00:00'),
	('《深入理解Java Web技术内幕》','许令波，电子工业出版社','18775367896','2017-05-23 00:00:00'),
	('《Java核心技术卷一》','Horstmann，机械工业出版社','13748475873','2017-05-23 00:00:00'),
	('《编译原理》','张素琴，清华大学出版社','13878759873','2017-05-23 00:00:00'),
	('《计算机操作系统》','汤小丹，西安电子科技大学出版社','18777837798','2017-05-23 00:00:00');

-- 创建借阅/借出书籍成功明细表
create table success_borrowed_shared(
borrow_id bigint NOT NULL COMMENT '明细表编号',
book_name bigint NOT NULL COMMENT '借阅/借出图书名称',
book_master varchar(64) NOT NULL COMMENT '书籍主人',
user_name varchar(64) NOT NULL COMMENT '借阅/借出用户',
state tinyint NOT NULL DEFAULT 0 COMMENT '状态标示：1:成功 0:失败',
create_time timestamp  NOT NULL COMMENT '创建时间',
PRIMARY KEY(borrow_id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='借阅/借出书籍成功明细表';
	