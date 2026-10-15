-- ============================================================================
--  tlias 登录用 emp 表  ——  完整重建脚本
--  对应 SQL: <select id="Login">
--              select id,name,username,password from tlias.emp
--              where username=#{username} and password=#{password};
--            </select>
--
--  背景：当前 tlias.emp 只有 7 列
--        (id,name,gender,job,avatar,entry_date,update_time)
--        缺少 username / password，导致登录 SQL 报
--        ERROR 1054 (42S22): Unknown column 'username' in 'field list'
--
--  执行前请确认：已备份数据库（脚本第 1 步会把旧表改名保留，不会直接删）
-- ============================================================================

USE tlias;

-- ----------------------------------------------------------------------------
-- 1. 保底：把现有的残缺 emp 表改名保留，避免直接丢数据
--    如果你确认不需要旧数据，可把这一行删掉，改成 DROP TABLE IF EXISTS emp;
-- ----------------------------------------------------------------------------
RENAME TABLE emp TO emp_bak_old;

-- ----------------------------------------------------------------------------
-- 2. 建标准 emp 表（13 列，与历史 emp.csv 备份一致）
-- ----------------------------------------------------------------------------
CREATE TABLE emp (
    id          INT          NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    username    VARCHAR(50)  NOT NULL                COMMENT '用户名（登录账号）',
    password    VARCHAR(50)  NOT NULL                COMMENT '密码（登录密码）',
    name        VARCHAR(50)  NOT NULL                COMMENT '姓名',
    gender      TINYINT      DEFAULT NULL            COMMENT '性别 1:男 2:女',
    phone       VARCHAR(11)  DEFAULT NULL            COMMENT '手机号',
    job         TINYINT      DEFAULT NULL            COMMENT '职位 1:班主任 2:讲师 3:学工主管 4:教研主管 5:咨询师',
    salary      INT          DEFAULT NULL            COMMENT '薪资',
    image       VARCHAR(300) DEFAULT NULL            COMMENT '头像URL',
    entry_date  DATE         DEFAULT NULL            COMMENT '入职日期',
    dept_id     INT          DEFAULT NULL            COMMENT '部门ID',
    create_time DATETIME     DEFAULT NULL            COMMENT '创建时间',
    update_time DATETIME     DEFAULT NULL            COMMENT '修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_username (username),
    KEY idx_dept_id (dept_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表';

-- ----------------------------------------------------------------------------
-- 3. 初始化账号数据
--    密码统一为 123456（前端校验要求 6~20 位，符合）
--    登录测试账号：songjiang / 123456   （宋江）
-- ----------------------------------------------------------------------------
INSERT INTO emp (id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) VALUES
(1,  'choushabi',   '123456', '施耐庵22', 1, '13390909001', 4, 15000, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2008-01-01', 1, '2026-08-27 17:16:47', '2026-08-27 17:16:47'),
(2,  'songjiang',   '123456', '宋江',     1, '13390909002', 2,  8600, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(3,  'lujunyi',     '123456', '卢俊义',   1, '13390909003', 2,  8900, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(4,  'wuyong',      '123456', '吴用',     1, '13390909004', 2,  8700, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2007-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(5,  'gongsunsheng','123456', '公孙胜',   1, '13309900005', 2,  9500, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2012-12-05', 2, '2023-10-20 16:36:33', '2023-10-20 16:36:33'),
(6,  'huosanniang', '123456', '扈三娘',   2, '13309900006', 3,  6500, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2013-09-05', 1, '2023-10-20 16:36:33', '2023-10-20 16:36:33'),
(7,  'chaijin',     '123456', '柴进',     1, '13309900007', 1,  4700, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2005-08-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(8,  'likui',       '123456', '李逵',     1, '13309900008', 1,  4800, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2014-11-09', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(9,  'wusong',      '123456', '武松',     1, '13309900009', 1,  4900, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2011-03-11', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(10, 'linchong',    '123456', '林冲',     1, '13309900010', 1,  5000, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2013-09-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(11, 'huyanzhuo',   '123456', '呼延灼',   1, '13309900011', 2,  9700, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2007-02-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(12, 'xiaoliugang', '123456', '小李广',   1, '13309900012', 2, 10000, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2008-08-18', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(13, 'yangzhi',     '123456', '杨志',     1, '13309900013', 1,  5300, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2012-11-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(14, 'shijin',      '123456', '史进',     1, '13309900014', 2, 16000, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2002-08-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(15, 'sunrenning',  '123456', '孙二娘',   2, '13309900015', 2, 10900, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2011-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(16, 'luzhishen',   '123456', '鲁智深',   1, '13309900016', 2,  9600, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2010-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(17, 'liying',      '123456', '李应',     1, '13309900017', 1,  5800, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2015-03-21', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(18, 'shiqian',     '123456', '时迁',     1, '13309900018', 2, 10200, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(19, 'gudasao',     '123456', '顾大嫂',   2, '13309900019', 2, 10500, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2008-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(20, 'ruanxiaoer',  '123456', '阮小二',   1, '13309900020', 2, 10800, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2018-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(21, 'ruanxiaoqu',  '123456', '阮小五',   1, '13309900021', 5,  5200, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2015-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(22, 'ruanxiaoqi',  '123456', '阮小七',   1, '13309900022', 5,  5500, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2016-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(23, 'ruanjii',     '123456', '阮籍',     1, '13309900023', 5,  5800, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2002-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(24, 'tongwei',     '123456', '童威',     1, '13309900024', 5,  5000, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2006-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(25, 'tongmeng',    '123456', '童猛',     1, '13309900025', 5,  4800, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2002-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(26, 'yanshun',     '123456', '燕顺',     1, '13309900026', 5,  5400, 'https://p1.ssl.qhimgs1.com/sdr/400__/t01fc7901eb0dd20f17.png', '2011-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33');

-- ----------------------------------------------------------------------------
-- 4. 顺带补上 AOP 日志表
--    登录方法上打了 @Login，OperateLogAspect 会往 operate_log 写日志；
--    你库里只有 emp_log，没有 operate_log，登录成功后这一步会抛异常。
--    若不想建表，也可以直接把 LoginController 上的 @Login 注解删掉。
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS operate_log (
    id             INT UNSIGNED NOT NULL AUTO_INCREMENT,
    operate_emp_id INT          DEFAULT NULL COMMENT '操作人ID',
    operate_time   DATETIME     DEFAULT NULL COMMENT '操作时间',
    class_name     VARCHAR(255) DEFAULT NULL COMMENT '操作类名',
    method_name    VARCHAR(100) DEFAULT NULL COMMENT '操作方法名',
    method_params  VARCHAR(2000)DEFAULT NULL COMMENT '操作方法参数',
    return_value   VARCHAR(2000)DEFAULT NULL COMMENT '操作方法返回值',
    cost_time      BIGINT       DEFAULT NULL COMMENT '操作耗时(ms)',
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '操作日志表';

-- ----------------------------------------------------------------------------
-- 5. 验证
-- ----------------------------------------------------------------------------
-- 5.1 表结构应为 13 列，且包含 username / password
DESC emp;

-- 5.2 直接跑登录那条 SQL，应能查到宋江这一行（= 登录接口能成功）
SELECT id, name, username, password FROM emp WHERE username = 'songjiang' AND password = '123456';

-- 5.3 账号清单
SELECT id, username, password, name FROM emp ORDER BY id;
