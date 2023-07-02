INSERT INTO T_SYS_CONFIG
VALUES ('superPassword', '本系统超级密码', 'gientech', 1, '技术人员开发测试用,可以多个密码,用逗号分隔', 123);
INSERT INTO T_SYS_CONFIG
VALUES ('sysName', '本系统名称', 'DADP微服务快速开发平台', 2, '在首页title上显示', 123);
COMMIT;


INSERT INTO T_SYS_CODE_TYPE
VALUES ('authType', '数据权限类型', 9007, '0', '数据权限用', 20007);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('homeUrl', '登录后首页', 9005, '0', '角色管理使用', 20005);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('shiOrFou', '是否', 9002, '0', '通用下拉框-是or否(中文)', 20004);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('tableName', '业务功能', 9006, '0', '数据权限用', 20006);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('userSex', '性别', 9003, '0', '用户管理用', 20001);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('userStatus', '用户状态', 9004, '0', '用户管理用', 20002);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('yesOrNo', '是否', 9001, '1', '通用下拉框-1或0(数字)', 20004);
INSERT INTO T_SYS_CODE_TYPE
VALUES ('operType', '操作类型', 9008, '1', '通用下拉框-1或0(数字)', 20004);
COMMIT;


INSERT INTO T_SYS_CODE_INFO
VALUES ('123456789', 'tableName', 'all_table_name', '所有业务功能', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('authType-1', 'authType', '1', '机构数据', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('authType-2', 'authType', '2', '用户数据', NULL, 2, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('homeUrl-main', 'homeUrl', '1', '横向菜单', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('homeUrl-main2', 'homeUrl', '0', '纵向菜单', NULL, 2, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('shiOrFou-0', 'shiOrFou', '否', '否', NULL, 2, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('shiOrFou-1', 'shiOrFou', '是', '是', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('userSex-0', 'userSex', '0', '女', NULL, 2, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('userSex-1', 'userSex', '1', '男', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('userSex-2', 'userSex', '2', '未知', NULL, 3, '保密或没有数据', 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('userStatus-1', 'userStatus', '1', '在职', NULL, 1, NULL, 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('userStatus-3', 'userStatus', '2', '离职', NULL, 2, '离职不让登陆', 123);
INSERT INTO T_SYS_CODE_INFO
VALUES ('yesOrNo-0', 'yesOrNo', '0', '否', NULL, 1, NULL, 124);
INSERT INTO T_SYS_CODE_INFO
VALUES ('yesOrNo-1', 'yesOrNo', '1', '是', NULL, 2, NULL, 125);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-0', 'operType', '0', '登录', NULL, 1, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-1', 'operType', '1', '查询', NULL, 2, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-2', 'operType', '2', '新增', NULL, 3, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-3', 'operType', '3', '修改', NULL, 4, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-4', 'operType', '4', '删除', NULL, 5, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-5', 'operType', '5', '导出', NULL, 6, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-6', 'operType', '6', '导入', NULL, 7, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-7', 'operType', '7', '审批', NULL, 8, NULL, 1);
INSERT INTO T_SYS_CODE_INFO
VALUES ('operType-8', 'operType', '8', '其它', NULL, 9, NULL, 1);
COMMIT;

INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('demo', '示例页面', NULL, '/demo', '1', 'menu-workbetch', '1', 2, '', 975);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('demoDashboard', '工作台', 'demo', '/demo/dashboard', '1', '', '1', 0, '', 2);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('demoSample', 'CRUD示例', 'demo', '/demo/sample', '1', '', '1', 3, '', 1);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sys', '系统管理', NULL, '/sys', '0', 'menu-marke-mg', '1', 7, NULL, 9);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysCodeInfo', '代码信息', 'sys', '/sys/code-info', '1', NULL, '1', 10, NULL, 3);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysCodeType', '代码类别', 'sys', '/sys/code-type', '0', NULL, '1', 9, 'test', 3);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysConfig', '系统参数', 'sys', '/sys/config', '0', NULL, '1', 8, NULL, 3);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysFunc', '功能管理', 'sys', '/sys/func', '1', NULL, '1', 12, NULL, 2);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysLog', '登录日志', 'sys', '/sys/login-log', '1', NULL, '1', 16, NULL, 3);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysMenu', '菜单管理', 'sys', '/sys/menu', '1', NULL, '1', 11, NULL, 2);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysOperLog', '操作日志', 'sys', '/sys/option-log', '1', NULL, '1', 17, NULL, 5);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysOrg', '机构管理', 'sys', '/sys/org', '1', NULL, '1', 14, NULL, 2);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysRole', '角色管理', 'sys', '/sys/role', '1', NULL, '1', 13, NULL, 2);
INSERT INTO T_SYS_MENU (MENU_ID, MENU_NAME, PARENT_MENU_ID, MENU_URL, IS_ALL_PATH, IMAGE_URL, IS_SHOW, SORT_NO, REMARK,
                        VER)
VALUES ('sysUser', '用户管理', 'sys', '/sys/user', '1', NULL, '1', 15, NULL, 2);


COMMIT;


INSERT INTO T_SYS_FUNC
VALUES ('sysCodeInfo-del', '删除', 'sysCodeInfo', 123);
COMMIT;


INSERT INTO T_SYS_ORG
VALUES ('001', '财务部', '999', 2, '/999/001', 2, NULL, 123);
INSERT INTO T_SYS_ORG
VALUES ('998', '总经理室', '999', 2, '/999/998', 1, NULL, 123);
INSERT INTO T_SYS_ORG
VALUES ('999', 'XX软件有限公司', NULL, 1, '/999', 1, NULL, 123);
COMMIT;


INSERT INTO T_SYS_ROLE
VALUES ('admin', '系统管理员', '0', 1, '拥有所有功能权限', 124);
INSERT INTO T_SYS_ROLE
VALUES ('test', '测试用户', '1', 2, NULL, 124);
COMMIT;


INSERT INTO T_SYS_USER
VALUES ('admin', '中电金信', 'admin', '13666008179', '$2a$10$zkHBLhdm17Vt0sLsWr8eye10Qyz.funA/fu0Lg1oIZ7gMocUSq7I2', '1',
        '999', 'admin', 'admin,test', '1', 1, '超级管理员', 126);
INSERT INTO T_SYS_USER
VALUES ('test', 'test', 'test', '18030051020', '$2a$10$3.a1W1KlrrPe./Sf0C80iOzV9C4FSZCfK0hagi2QkcSGrEfKnkG0i', '1',
        '001', 'test', 'test', '1', 2, NULL, 124);
COMMIT;


INSERT INTO T_SYS_ROLE_AUTH
VALUES ('1373932326907387905', 'test', '1', 'sys');
INSERT INTO T_SYS_ROLE_AUTH
VALUES ('1373932326961913858', 'test', '1', 'sysCodeInfo');
INSERT INTO T_SYS_ROLE_AUTH
VALUES ('1373932326970302465', 'test', '2', 'sysCodeInfo-3');
INSERT INTO T_SYS_ROLE_AUTH
VALUES ('1373932326970302466', 'test', '1', 'sysCodeType');
INSERT INTO T_SYS_ROLE_AUTH
VALUES ('1373932326970302467', 'test', '1', 'sysConfig');
COMMIT;


INSERT INTO T_SYS_ROLE_DATA
VALUES ('4028897272c22cb50172c22fba9a0001', 'admin', 'all_table_name', '1', 'all_org', '所有机构', '1', 123);
COMMIT;