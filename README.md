客户端练习的测试服务器
============

> 创建 MySQL 容器

```
docker run -d -p 3306:3306 --name sbn -e MYSQL_ROOT_PASSWORD=111111 -e MYSQL_DATABASE=sbn mysql:5.7.16 --character-set-server=utf8 --collation-server=utf8_general_ci --lower-case-table-names=1
```
> 创建博客分类表

```sql
CREATE TABLE `t_category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

> 添加分类数据

```sql
INSERT INTO `sbn`.`t_category` (`ID`, `NAME`) VALUES ('1', 'Android');
INSERT INTO `sbn`.`t_category` (`ID`, `NAME`) VALUES ('2', 'iOS');
INSERT INTO `sbn`.`t_category` (`ID`, `NAME`) VALUES ('3', 'FE');
```
> 创建博客表

```sql
CREATE TABLE `t_blog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) NOT NULL,
  `CONTENT` varchar(255) NOT NULL,
  `CATEGORY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TITLE_UNIQUE` (`TITLE`),
  UNIQUE KEY `CONTENT_UNIQUE` (`CONTENT`),
  KEY `CATEGORY_ID_idx` (`CATEGORY_ID`),
  CONSTRAINT `CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `t_category` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
> 添加博客数据

```sql
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('1', 'Android 标sdf题1', 'Android 内sdfsdfsd容1', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('2', 'Android 标ghj题2', 'Android 内asdasd容2', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('3', 'Android 标asd题3', 'Android 内sdf容3', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('4', 'Android 标题as4', 'Android 内weqwr容4', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('5', 'Android 标sad题5', 'Android 内werwe容5', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('6', 'Android 标wer题6', 'Android 内rtyrt容6', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('7', 'Android 标tyu题7', 'Android 内ryerwetwe容7', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('8', 'Android 标sd题8', 'Android 内iyu容8', '1');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('9', 'Android 标sdf题9', 'Android uttryrty内容9', '1');

INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('10', 'iOS 标adhadrh题1', 'iOS 内asdf容1', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('11', 'iOS 标asdg题2', 'iOS 内adsf容2', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('12', 'iOS 标题afd3', 'iOS 内容qwe3', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('13', 'iOS 标yryti题4', 'iOS 内lyu容4', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('14', 'iOS 标uyit题5', 'iOS 内yfd容5', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('15', 'iOS 标tyur题6', 'iOS 内ndf容6', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('16', 'iOS 标er题7', 'iOS 内容fds7', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('17', 'iOS 标rwe题8', 'iOS 内cxz容8', '2');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('19', 'iOS 标uyt题9', 'iOS 内rew容9', '2');

INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('19', 'FE 标dgd题1', 'FE 内gfd容1', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('20', 'FE 标asdf题2', 'FE 内ygv容2', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('21', 'FE 标sdf题3', 'FE 内jhgf容3', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('22', 'FE 标yr题4', 'FE 内vf容4', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('23', 'FE 标jg题5', 'FE 内容vwt5', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('24', 'FE 标gdf题6', 'FE 内avfa容6', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('25', 'FE 标jgh题7', 'FE 内vw容7', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('26', 'FE 标eqw题8', 'FE 内容mti8', '3');
INSERT INTO `sbn`.`t_blog` (`ID`, `TITLE`, `CONTENT`, `CATEGORY_ID`) VALUES ('27', 'FE 标eqwee题9', 'FE 内bey容9', '3');
```
