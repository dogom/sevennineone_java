--  用户表
create table sno_user(
	id varchar(32) primary key comment '用户id',
    nickname varchar(32) comment '用户昵称',
    realname varchar(16) comment '真名',
    mobile varchar(32) comment '电话号码',
    avatar varchar(1024) comment '头像',
    openid varchar(32) comment 'openid',
    union_id varchar(32) comment 'unionid',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '用户表';

-- 小孩表
create table sno_child(
	id varchar(32) primary key comment 'id',
    parent_id varchar(32) comment 'sno_user主键，家长id',
    name varchar(16) comment '姓名',
    age int(11) comment '年龄',
    sex int(11) comment '性别，1男2女',
    avatar varchar(1024) comment '头像',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '小孩表';

-- 培训商户表
create table sno_merchant(
	id int(11) primary key auto_increment comment 'id',
    user_id varchar(32) comment '用户id',
    name varchar(64) comment '机构名称',
    description varchar(1024) comment '机构简介',
    bmap_loca varchar(32) comment '百度地图坐标',
    address varchar(64) comment '地址',
    logo varchar(1024) comment 'logo',
    tel varchar(16) comment '联系电话',
    vip_level int(11) comment 'vip等级',
    id_card_front varchar(1024) comment '身份证人像面',
    id_card_back varchar(1024) comment '身份证国徽面',
    business_license varchar(1024) comment '营业执照',
    audit_status int(11) default 1 comment '审核状态，1待审核，2审核通过，3审核未通过',
    audit_fail_msg varchar(32) comment '审核未通过留言',
    create_time datetime default now() comment '创建时间',
    is_deposit int(11) default 0 comment '是否交押金,0否1是',
    deposit_fee int(11) default 0 comment '押金金额，单位：分',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '机构表';

-- 机构师资表
create table sno_merchant_teacher(
	id int(11) primary key auto_increment comment 'id',
    user_id varchar(32) comment '用户id',
    merchat_id int(11) comment '培训商户id',
    name varchar(16) comment '教师名称',
    category varchar(16) comment '教师类型,如舞蹈教师',
    img varchar(1024) comment '教师图片',
    head_title varchar(64) comment '头衔',
    description varchar(1024) comment '教师简介',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '机构师资表';

-- 机构课程表
create table sno_merchant_subject (
	id int(11) primary key auto_increment comment 'id',
    user_id varchar(32) comment '用户id',
	merchat_id int(11) comment '培训商户id',
    teacher_id int(11) comment '教师id',
    name varchar(16) comment '课程名称',
    start_date date comment '课程开始日期',
    end_date date comment '课程结束日期',
	start_time time comment '上课时间',
    end_time time comment '下课时间',
    during int(11) comment '时长，单位：分钟',
    price int(11) comment '课程价格，单位分',
    total int(11) comment '总节数',
    max_students int(11) comment '最大学生数',
    real_students int(11) comment '已有学生数',
    suitable_age varchar(16) comment '合适年龄段',
    adv_img varchar(1024) comment '广告图片',
    status int(11) default 1 comment '1正常状态，2已过期',
    rate_type int(11) comment '频率类型，1每天2每周3每月4每季5每半年6每年7每三年',
    rate_num int(11) comment '频率次数，如每周2节',
    description varchar(64) comment '课程说明',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '机构课程表';

-- 联盟活动表
create table sno_alliance_activtity (
	id int(11) primary key auto_increment comment 'id',
	user_id varchar(32) comment '用户id',
    name varchar(64) comment '活动名称', 
    logo varchar(1024) comment 'logo',
    start_date date comment '活动开始时间',
    end_date date comment '活动结束时间',
    city varchar(16) comment '城市',
    status int(11) default 1 comment '0审核中，1正常状态，2已过期',
	audit_status int(11) default 1 comment '审核状态，1待审核，2审核通过，3审核未通过',
    audit_fail_msg varchar(32) comment '审核未通过留言',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是',
) comment '联盟活动表';


-- 联盟活动商家表
create table sno_alliance_merchat(
	id int(11) primary key auto_increment comment 'id',
    merchat_id int(11) comment '培训商家id',
    activity_id int(11) comment '联盟活动id',
    status int(11) comment '状态，0审核中1审核通过2审核拒绝',
    experience_num int(11) comment '联盟卡体验次数',
	create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是',
) comment '联盟活动商家表';

-- 报名表
create table sno_reply(
	id int(11) primary key auto_increment comment 'id',
    user_id varchar(32) comment '用户id',
	child_id varchar(32) comment '小孩id',
    merchat_id int(11) comment '培训商家id',
    activity_id int(11) comment '联盟活动id',
    paid_fee int(11) comment '已支付金额',
	progress int(11) default 1 comment '报名进度，1:0-99，2:99-mid,3:mid-end',
    total_fee int(11) comment '报名总金额',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '报名表';

-- 礼物表
create table sno_gift (
	id int(11) primary key auto_increment comment 'id',
    name varchar(32) comment '礼物名称',
    img varchar(1024) comment '礼物图片',
    worth int(11) comment '礼物价值,单位:分，如10表示1个礼物1毛钱',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '礼物表';

-- 报名助学表
create table sno_reply_donation (
	id int(11) primary key auto_increment comment 'id',
    reply_id int(11) comment '报名id',
    user_id varchar(32) comment '助学人id',
    nickname varchar(11) comment '助学人名称',
    avatar varchar(1024) comment '助学人头像',
    gift_id int(11) comment '礼物id',
    gift_name varchar(11) comment '礼物名称',
    gift_num int(11) comment '礼物数量',
    gift_img varchar(1024) comment '礼物图片',
    total_fee int(11) comment '礼物折算费用,分',
    create_time datetime default now() comment '创建时间',
    is_delete int(11) default 0 comment '是否删除,0否1是'
) comment '报名助学表';

-- 首页菜单表
CREATE TABLE `sno_home_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(16) DEFAULT NULL COMMENT '名称',
  `url` varchar(1024) DEFAULT NULL COMMENT '图片地址',
  `sort` int(11) DEFAULT NULL COMMENT '排序，越大越靠前',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除,0否1是',
  PRIMARY KEY (`id`)
) COMMENT='首页分类表';














































































