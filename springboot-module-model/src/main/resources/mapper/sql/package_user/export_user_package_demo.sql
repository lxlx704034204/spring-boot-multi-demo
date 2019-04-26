--------------------------------------------------------
--  文件已创建 - 星期五-四月-26-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_USER
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "CCH"."PKG_USER" 
AS
  /* TODO enter package declarations (types, exceptions, methods etc) here */
type userListCursor
IS
  ref
  CURSOR;
    PROCEDURE listUsers(
        uId IN VARCHAR2,
        total OUT INTEGER,
        userList OUT userListCursor);
  END PKG_USER;

/