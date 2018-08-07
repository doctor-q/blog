DROP TABLE if EXISTS comment_source;
CREATE TABLE comment_source (
  id int(11) UNSIGNED NOT NULL auto_increment COMMENT '主键',
  name varchar(255) NOT NULL COMMENT '评论',
  access_token VARCHAR(128) NOT NULL COMMENT '访问token',
  token_expired DATETIME NOT NULL COMMENT '访问token过期时间',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '点评源表，外部接入评论系统';


DROP TABLE if EXISTS comment;
CREATE TABLE comment (
  id int(11) UNSIGNED NOT NULL auto_increment COMMENT '主键',
  comment varchar(255) NOT NULL COMMENT '评论',
  comment_type TINYINT NOT NULL DEFAULT 0 COMMENT '评论类型，0：源评论，1：评论回复',
  source_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论源',
  comment_ref_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论对象id',
  user_id INT UNSIGNED NOT NULL COMMENT '评论人id',
  `username` VARCHAR(50) NOT NULL COMMENT '作者名字，冗余',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '评论表';

DROP TABLE if EXISTS approval;
CREATE TABLE approval (
  id int(11) UNSIGNED NOT NULL auto_increment COMMENT '主键',
  approval TINYINT NOT NULL DEFAULT 0 COMMENT '0：喜欢，1：不喜欢',
  source_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞源',
  approval_ref_id INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞对象id',
  user_id INT UNSIGNED NOT NULL COMMENT '评论人id',
  `username` VARCHAR(50) NOT NULL COMMENT '作者名字，冗余',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '评论表';

