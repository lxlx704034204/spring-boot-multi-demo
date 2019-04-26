--------------------------------------------------------
--  文件已创建 - 星期五-四月-26-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PKG_USER
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "CCH"."PKG_USER" 
AS
PROCEDURE listUsers(
    uId IN INTEGER,
    total OUT INTEGER,
    userList OUT userListCursor)
AS
  -- declare some variables on here if need 
BEGIN
  -- TODO: PROCEDURE PKG_USER.listUsers所需的实施
    total:=0;
   
  IF uId=0 THEN
  	SELECT COUNT(1) INTO total FROM T_User;
    OPEN userList FOR SELECT * FROM T_User;
  ELSE
    OPEN userList FOR SELECT * FROM T_user WHERE user_id = uid;
  END IF;
    Dbms_Output.Put_Line('uId='||uid||' and total='||total);
END listUsers;
END PKG_USER;