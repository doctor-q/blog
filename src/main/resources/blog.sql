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
  `type` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0 为文章，1 为页面',
  `status` tinyint(11) NOT NULL DEFAULT '0' COMMENT '0 为草稿，1 为待审核，2 为已拒绝，3 为已经发布',
  `title` varchar(255) NOT NULL COMMENT '博客标题',
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