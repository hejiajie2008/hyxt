--添加商铺
INSERT INTO `sysshop` ( `ShopName`, `ShopTelephone`, `ShopContactMan`, `ShopAreaID`, `ShopAddress`, `ShopRemark`, `ShopCreateTime`, `ShopState`, `ShopPrintTitle`, `ShopPrintFoot`, `ShopSmsName`, `FatherShopID`, `IsAllianceProgram`, `SettlementInterval`, `ShopProportion`, `PointCount`, `SmsCount`, `PointType`, `SmsType`, `AreaID`) VALUES 
('{shopname}', '{shoptelephone}', '{shopcontactman}', 0, '{shopaddress}', '', now(), 0, '', '', '', 0, 0, 3, 0.01, -199, 0, 3, 1, 1);
--添加用户
INSERT INTO `sysuser` ( `UserAccount`, `UserName`, `UserPassword`, `UserShopID`, `UserGroupID`, `UserLock`, `UserRemark`, `UserCreateTime`, `UserTelephone`, `UserNumber`) VALUES 
('{useraccount}', '{username}', '{userpassword}', {usershopid}, {usergroupid}, 0, '{userremark}', now() , '{usertelephone}', '{usernumber}');
INSERT INTO `sysuser` ( `UserAccount`, `UserName`, `UserPassword`, `UserShopID`, `UserGroupID`, `UserLock`, `UserRemark`, `UserCreateTime`, `UserTelephone`, `UserNumber`) VALUES 
('{ptuseraccount}', '{ptusername}', '{ptuserpassword}', {usershopid}, {ptusergroupid}, 0, '{userremark}', now() , '{usertelephone}', '{usernumber}');