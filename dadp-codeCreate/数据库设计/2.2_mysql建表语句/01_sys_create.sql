/**【T_SYS_CONFIG】开始**/
drop table if exists T_SYS_CONFIG;
CREATE TABLE T_SYS_CONFIG
(
    CONFIG_ID    varchar(32)  NOT NULL COMMENT '系统参数ID',
    CONFIG_NAME  varchar(100) NOT NULL COMMENT '系统参数名称',
    CONFIG_VALUE varchar(400) NOT NULL COMMENT '系统参数值',
    SORT_NO      int(4) NOT NULL COMMENT '排序号',
    REMARK       varchar(400) NULL COMMENT '备注',
    VER          int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (CONFIG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_01_系统参数表';
/**【T_SYS_CONFIG】结束**/

/**【T_SYS_CODE_TYPE】开始**/
drop table if exists T_SYS_CODE_TYPE;
CREATE TABLE T_SYS_CODE_TYPE
(
    CODE_TYPE_ID   varchar(32)  NOT NULL COMMENT '代码类别ID',
    CODE_TYPE_NAME varchar(100) NOT NULL COMMENT '代码类别名称',
    SORT_NO        int(4) NOT NULL COMMENT '排序号',
    IS_PINYIN      varchar(32)  NOT NULL COMMENT '是否拼音排序',
    REMARK         varchar(400) NULL COMMENT '备注',
    VER            int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (CODE_TYPE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_02_代码类别表';
/**【T_SYS_CODE_TYPE】结束**/

/**【T_SYS_CODE_INFO】开始**/
drop table if exists T_SYS_CODE_INFO;
CREATE TABLE T_SYS_CODE_INFO
(
    CODE_INFO_ID varchar(19)  NOT NULL COMMENT '代码信息ID',
    CODE_TYPE_ID varchar(32)  NOT NULL COMMENT '代码类别ID',
    VALUE        varchar(100) NOT NULL COMMENT '下拉框值',
    CONTENT      varchar(100) NOT NULL COMMENT '下拉框内容',
    PARENT_VALUE varchar(100) NULL COMMENT '上级联动下拉框值',
    SORT_NO      int(4) NOT NULL COMMENT '排序号',
    REMARK       varchar(400) NULL COMMENT '备注',
    VER          int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (CODE_INFO_ID),
    UNIQUE KEY `IDX_SYS_CODE_INFO_1` (`CODE_TYPE_ID`,`VALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_03_代码信息表';
/**【T_SYS_CODE_INFO】结束**/

/**【T_SYS_MENU】开始**/
drop table if exists T_SYS_MENU;
CREATE TABLE T_SYS_MENU
(
    MENU_ID        varchar(32)  NOT NULL COMMENT '菜单ID',
    MENU_NAME      varchar(100) NOT NULL COMMENT '菜单名称',
    PARENT_MENU_ID varchar(32) NULL COMMENT '上级菜单ID',
    MENU_URL       varchar(400) NULL COMMENT '菜单URL',
    IS_ALL_PATH    varchar(1)   NOT NULL COMMENT '是否绝对路径',
    IMAGE_URL      varchar(200) NULL COMMENT '图标地址',
    IS_SHOW        varchar(1)   NOT NULL COMMENT '是否显示',
    SORT_NO        int(4) NOT NULL COMMENT '排序号',
    REMARK         varchar(400) NULL COMMENT '备注',
    VER            int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (MENU_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_04_菜单表';
/**【T_SYS_MENU】结束**/

/**【T_SYS_FUNC】开始**/
drop table if exists T_SYS_FUNC;
CREATE TABLE T_SYS_FUNC
(
    FUNC_ID   varchar(32)  NOT NULL COMMENT '功能ID',
    FUNC_NAME varchar(100) NOT NULL COMMENT '功能名称',
    MENU_ID   varchar(32)  NOT NULL COMMENT '菜单ID',
    VER       int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (FUNC_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_05_功能表';
/**【T_SYS_FUNC】结束**/

/**【T_SYS_ORG】开始**/
drop table if exists T_SYS_ORG;
CREATE TABLE T_SYS_ORG
(
    ORG_ID         varchar(32)  NOT NULL COMMENT '机构ID',
    ORG_NAME       varchar(100) NOT NULL COMMENT '机构名称',
    PARENT_ORG_ID  varchar(32) NULL COMMENT '上级机构ID',
    ORG_LEVEL      int(1) NOT NULL COMMENT '机构级次',
    ORG_LEVEL_CODE varchar(100) NOT NULL COMMENT '机构级次码',
    SORT_NO        int(4) NOT NULL COMMENT '排序号',
    REMARK         varchar(400) NULL COMMENT '备注',
    VER            int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (ORG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_06_机构表';
/**【T_SYS_ORG】结束**/

/**【T_SYS_ROLE】开始**/
drop table if exists T_SYS_ROLE;
CREATE TABLE T_SYS_ROLE
(
    ROLE_ID   varchar(32)  NOT NULL COMMENT '角色ID',
    ROLE_NAME varchar(100) NOT NULL COMMENT '角色名称',
    HOME_URL  varchar(50)  NOT NULL COMMENT '登录后首页',
    SORT_NO   int(4) NOT NULL COMMENT '排序号',
    REMARK    varchar(400) NULL COMMENT '备注',
    VER       int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (ROLE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_07_角色表';
/**【T_SYS_ROLE】结束**/

/**【T_SYS_ROLE_AUTH】开始**/
drop table if exists T_SYS_ROLE_AUTH;
CREATE TABLE T_SYS_ROLE_AUTH
(
    ROLE_AUTH_ID    varchar(32) NOT NULL COMMENT '操作权限ID',
    ROLE_ID         varchar(32) NOT NULL COMMENT '角色ID',
    AUTH_TYPE       varchar(1)  NOT NULL COMMENT '权限类型',
    MENU_OR_FUNC_ID varchar(32) NOT NULL COMMENT '菜单或功能ID',
    PRIMARY KEY (ROLE_AUTH_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_08_操作权限表';
/**【T_SYS_ROLE_AUTH】结束**/

/**【T_SYS_ROLE_DATA】开始**/
drop table if exists T_SYS_ROLE_DATA;
CREATE TABLE T_SYS_ROLE_DATA
(
    ROLE_DATA_ID    varchar(32)  NOT NULL COMMENT '数据权限ID',
    ROLE_ID         varchar(32)  NOT NULL COMMENT '角色ID',
    TABLE_NAME      varchar(100) NOT NULL COMMENT '业务表名',
    AUTH_TYPE       varchar(1)   NOT NULL COMMENT '权限类型',
    AUTH_SCOPE_ID   varchar(32)  NOT NULL COMMENT '权限范围ID',
    AUTH_SCOPE_NAME varchar(100) NOT NULL COMMENT '数据范围名',
    IS_INCLUDE_SUB  varchar(1)   NOT NULL COMMENT '是否含下级',
    VER             int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (ROLE_DATA_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_09_数据权限表';
/**【T_SYS_ROLE_DATA】结束**/

/**【T_SYS_USER】开始**/
drop table if exists T_SYS_USER;
CREATE TABLE T_SYS_USER
(
    USER_ID    varchar(32)  NOT NULL COMMENT '用户ID',
    USER_NAME  varchar(100) NOT NULL COMMENT '用户姓名',
    LOGIN_NAME varchar(100) NOT NULL COMMENT '登陆名',
    TEL        varchar(50)  NOT NULL COMMENT '手机号',
    PASSWORD   varchar(100) NOT NULL COMMENT '密码',
    SEX        varchar(1)   NOT NULL COMMENT '性别',
    ORG_ID     varchar(32)  NOT NULL COMMENT '所属机构',
    ROLE_ID    varchar(32)  NOT NULL COMMENT '当前角色',
    ROLE_IDS   varchar(320) NOT NULL COMMENT '拥有的全部角色',
    STATUS     varchar(1)   NOT NULL COMMENT '用户状态',
    SORT_NO    int(6) NOT NULL COMMENT '排序号',
    REMARK     varchar(400) NULL COMMENT '备注',
    VER        int(5) NOT NULL COMMENT '数据版本',
    PRIMARY KEY (USER_ID),
    UNIQUE KEY `IDX_SYS_USER_1` (`LOGIN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_10_用户表';
/**【T_SYS_USER】结束**/

/**【T_SYS_LOG】开始**/
drop table if exists T_SYS_LOG;
CREATE TABLE T_SYS_LOG
(
    LOG_ID    varchar(32)  NOT NULL COMMENT '日志ID',
    USER_ID   varchar(32)  NOT NULL COMMENT '用户ID',
    USER_NAME varchar(100) NOT NULL COMMENT '用户姓名',
    LOG_INFO  varchar(100) NOT NULL COMMENT '日志内容',
    IP_ADDR   varchar(40)  NOT NULL COMMENT 'IP地址',
    LOG_TIME  datetime     NOT NULL COMMENT '发生时间',
    PRIMARY KEY (LOG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_11_登录日志表';
/**【T_SYS_LOG】结束**/

/**【T_SYS_OPER_LOG】开始**/
drop table if exists T_SYS_OPER_LOG;
CREATE TABLE T_SYS_OPER_LOG
(
    OPER_LOG_ID varchar(32)  NOT NULL COMMENT '日志ID',
    MODULE_NAME varchar(60)  NOT NULL COMMENT '模块名称',
    OPER_TYPE   varchar(32)  NOT NULL COMMENT '操作类型',
    OPER_SOURCE varchar(32)  NOT NULL COMMENT '操作来源',
    USER_ID     varchar(32) NULL COMMENT '用户ID',
    ORG_ID      varchar(32) NULL COMMENT '机构ID',
    REQ_URL     varchar(200) NOT NULL COMMENT '请求URL',
    REQ_METHOD  varchar(200) NOT NULL COMMENT '方法名称',
    REQ_MODE    varchar(32)  NOT NULL COMMENT '请求方式',
    IP_ADDR     varchar(40)  NOT NULL COMMENT 'IP地址',
    REQ_PARAM   varchar(2000) NULL COMMENT '请求参数',
    RESULT      varchar(2000) NULL COMMENT '返回结果',
    IS_OK       varchar(32)  NOT NULL COMMENT '是否操作成功',
    LOG_TIME    datetime     NOT NULL COMMENT '发生时间',
    PRIMARY KEY (OPER_LOG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_12_操作日志表';
/**【T_SYS_OPER_LOG】结束**/

/**【T_SYS_PK】开始**/
drop table if exists T_SYS_PK;
CREATE TABLE T_SYS_PK
(
    PK_ID     varchar(19) NOT NULL COMMENT '自定义主键ID',
    PK_PREFIX varchar(20) NOT NULL COMMENT '主键前缀',
    PK_DATE   varchar(8) NULL COMMENT '主键日期',
    PK_MAX    int(8) NOT NULL COMMENT '最大值',
    PRIMARY KEY (PK_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SYS_13_流水号主键';
/**【T_SYS_PK】结束**/

