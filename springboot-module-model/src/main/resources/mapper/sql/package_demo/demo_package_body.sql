--------------------------------------------------------
--  文件已创建 - 星期五-四月-26-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body TEST_LU
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "CCH"."TEST_LU" 
AS
  ---创建一个自定义数据类型
TYPE c_user
IS
  RECORD
  (
    id   NUMBER,
    name VARCHAR2(30) );
  ---根据自定义数据类型创建一个集合
TYPE c_user_array
IS
  TABLE OF c_user INDEX BY BINARY_INTEGER;
  ---集合对象
  user_array c_user_array;
  ---数据对象
  USER c_user;
  ---计数器
  v_counter NUMBER;
PROCEDURE test1
AS
BEGIN
  -- TODO: procedure TEST_LU.test1所需的实施
  user.id            :=1;
  user.name          :='luu';
  user_array(user.id):=USER;
  user.id            :=2;
  user.name          :='lii';
  user_array(user.id):=USER;
END test1;
PROCEDURE test2
AS
BEGIN
  -- TODO: procedure TEST_LU.test2所需的实施
  FOR v_counter IN 1..user_array.count
  LOOP
    DBMS_OUTPUT.put_line(user_array(v_counter).id||'...'||user_array(v_counter).name);
  END LOOP;
END test2;

PROCEDURE test3
AS
BEGIN
  -- TODO: procedure TEST_LU.test3所需的实施
  test1;
  test2;
END test3;

PROCEDURE test4
AS
BEGIN
  -- TODO: procedure TEST_LU.test3所需的实施
DBMS_OUTPUT.put_line('hello world');
END test4;

END TEST_LU;

/
