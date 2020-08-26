CREATE DATABASE typingtest;
CREATE TABLE
    IF
    NOT EXISTS result
(
    id          INT(11) UNSIGNED NOT NULL auto_increment PRIMARY KEY,
    cpm         INT(4),
    accuracy    INT(3),
    score       INT(4) COMMENT 'calculated from cpm amd accuracy',
    test_time   INT(3) COMMENT 'time unit - minute',
    create_time datetime,
    STATUS      INT(3) COMMENT '1-valid 0-invalid'
) ENGINE = INNODB
  DEFAULT charset = utf8;

INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '41', '93', '56', '3', '2020-04-05 06:03:51.070000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '120', '100', '114', '1', '2020-04-05 06:03:51.070000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '80', '96', '84', '1', '2020-04-05 06:06:54.325000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '150', '95', '133', '5', '2020-04-07 04:11:39.214000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '150', '100', '135', '3', '2020-04-07 04:17:12.016000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '134', '86', '119', '1', '2020-04-07 04:18:46.353000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '13', '86', '34', '1', '2020-04-07 04:25:14.975000', '0' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '90', '84', '34', '1', '2020-04-07 05:14:58.070000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '57', '78', '30', '1', '2020-04-07 05:24:55.970000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '134', '90', '120', '1', '2020-04-07 05:26:01.204000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '135', '99', '124', '5', '2020-04-07 05:27:32.907000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '132', '89', '119', '5', '2020-04-07 05:29:46.109000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '120', '90', '111', '3', '2020-04-07 05:48:49.373000', '1' );
INSERT INTO `typingtest`.`result` ( `cpm`, `accuracy`, `score`, `test_time`, `create_time`, `STATUS` )
VALUES
( '57', '96', '68', '1', '2020-04-07 07:02:15.228000', '1' );
