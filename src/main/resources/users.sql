DROP TABLE if EXISTS user;
CREATE TABLE user (
  id int(11) UNSIGNED NOT NULL auto_increment COMMENT '主键',
  username varchar(255) NOT NULL COMMENT '用户名',
  email varchar(255) NOT NULL COMMENT '邮箱',
  password varchar(255) NOT NULL COMMENT '密码',
  phone varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  header VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
  nick_name VARCHAR(100) NOT NULL DEFAULT '' COMMENT '昵称',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY(id),
  UNIQUE KEY uniq_user_name(username),
  UNIQUE KEY uniq_email(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

DROP TABLE if EXISTS role;
CREATE TABLE role (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  name VARCHAR(50) NOT NULL COMMENT '角色名',
  client_id VARCHAR(255) COMMENT '客户端id',
  description VARCHAR(200) NOT NULL DEFAULT '' COMMENT '角色描述',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_name(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';

DROP TABLE if EXISTS user_role;
CREATE TABLE user_role (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id int(11) UNSIGNED NOT NULL COMMENT '用户表id',
  role_id INT UNSIGNED NOT NULL COMMENT '角色表id',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_user_role(user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色关联表';

DROP TABLE if EXISTS resource;
CREATE TABLE resource (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  name        VARCHAR(200) NOT NULL
  COMMENT '资源名',
  menu_link   VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '菜单链接',
  description VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '角色描述',
  is_deleted  TINYINT      NOT NULL DEFAULT 0
  COMMENT '是否删除，0未删除，1已删除',
  created_at  DATETIME     NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  updated_at  DATETIME     NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
  COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_name(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资源表';

DROP TABLE if EXISTS role_resource;
CREATE TABLE role_resource (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  role_id INT UNSIGNED NOT NULL COMMENT '角色表id',
  resource_id INT UNSIGNED NOT NULL COMMENT '资源表id',
  is_deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0未删除，1已删除',
  created_at DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  updated_at DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_role_resource(role_id, resource_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色资源关联表';
