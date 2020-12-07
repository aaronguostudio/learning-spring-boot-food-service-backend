-- MySQL 5.7
-- key vs index, https://stackoverflow.com/questions/1401572/whats-the-difference-between-using-index-vs-key-in-mysql

create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment 'category name',
    `category_type` int not null comment 'category number',
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`category_id`),
    UNIQUE KEY `uqe_category_type` (`category_type`)
);

create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment 'product name',
    `product_price` decimal(8,2) not null comment 'product price',
    `product_stock` int not null comment 'stock',
    `product_description` varchar(64) comment 'description',
    `product_icon` varchar(512) comment 'thumbnail',
    `product_status` tinyint(3) DEFAULT '0' COMMENT 'product status, 0 is on, 1 is off',
    `category_type` int not null comment 'category type number',
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`product_id`)
);

create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment 'buyer name',
    `buyer_phone` varchar(32) not null comment 'buyer phone number',
    `buyer_address` varchar(128) not null comment 'buyer address',
    `buyer_openid` varchar(64) not null comment 'buyer wechat openid',
    `order_amount` decimal(8,2) not null comment 'order amount',
    `order_status` tinyint(3) not null default '0' comment 'order status, default is newOrder',
    `pay_status` tinyint(3) not null default '0' comment 'payment status, default is unpaied',
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment 'product name',
    `product_price` decimal(8,2) not null comment 'product price',
    `product_quantity` int not null comment 'quantity',
    `product_icon` varchar(512) comment 'thumbnail',
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

create table `seller_info` (
    `seller_id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment 'wechat openid',
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`seller_id`)
) comment 'seller info';
