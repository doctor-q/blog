DROP TABLE IF EXISTS blogger;
CREATE TABLE blogger (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` INT UNSIGNED NOT NULL COMMENT '用户id',
  `username` VARCHAR(50) NOT NULL COMMENT '作者名字，冗余',
  `header` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '头像',
  `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '0：未知，1：男，2：女',
  `birthday` DATE NOT NULL DEFAULT '1970-01-01' COMMENT '出生日期',
  `address` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '居住地址',
  `company` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '公司名称',
  `position` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '职位名称',
  `marriage_status` TINYINT NOT NULL DEFAULT 0 COMMENT '婚姻状况',
  `mobile` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `qq` VARCHAR(15) NOT NULL DEFAULT '' COMMENT 'QQ',
  `github` VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'Github地址',
  `weibo` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '微博地址',
  `facebook` VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'facebook地址',
  `twitter` VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'Twitter地址',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '博主表';

DROP TABLE IF EXISTS blog_category;
CREATE TABLE `blog_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '博客分类名称',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '分类父级',
  PRIMARY KEY (id),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '博客分类表';

DROP TABLE IF EXISTS blog_post;
CREATE TABLE `blog_post` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) unsigned NOT NULL COMMENT '作者',
  `username` VARCHAR(50) NOT NULL COMMENT '作者名字，冗余',
  `type` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0 为文章，1 为页面',
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0 为草稿，1 为待审核，2 为已拒绝，3 为已经发布',
  `title` varchar(255) NOT NULL COMMENT '博客标题',
  `category` INT UNSIGNED NOT NULL COMMENT '博客分类',
  `summary` longtext NOT NULL COMMENT '摘要',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '博客内容',
  `allow_comment` tinyint(11) NOT NULL DEFAULT '1' COMMENT '是否允许评论，1 为允许， 0 为不允许',
  `is_public` tinyint(11) NOT NULL DEFAULT '1' COMMENT '1 为公开，0 为不公开',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '博客表';

DROP TABLE IF EXISTS blog_post_tag; 
CREATE TABLE `blog_post_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `post_id` int(11) NOT NULL COMMENT '博客id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `post_tag` (`post_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '博客标签表';

DROP TABLE IF EXISTS blog_tag;
CREATE TABLE `blog_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '标签表';

CREATE TABLE `attention` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blogger_id` INT UNSIGNED NOT NULL COMMENT '博主id',
  `blogger` VARCHAR(50) NOT NULL COMMENT '博主名字',
  `follower_id` INT UNSIGNED NOT NULL COMMENT '关注人id',
  `follower` VARCHAR(50) NOT NULL COMMENT '关注人名字',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '关注表';
