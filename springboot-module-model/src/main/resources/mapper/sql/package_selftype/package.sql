--------------------------------------------------------
--  文件已创建 - 星期六-四月-27-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_TYPETEST
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "CCH"."PKG_TYPETEST" 
AS
  /* TODO enter package declarations (types, exceptions, methods etc) here */
  ---自定义数据类型self_user
TYPE s_u
IS
  RECORD
  (
    id   NUMBER,
    name VARCHAR2(30) );
  ---根据自定义数据类型self_user创建一个集合self_user_array
TYPE s_u_ary
IS
  TABLE OF s_u INDEX BY BINARY_INTEGER;
  --array(20) OF self_user;
  --定义一个存储过程
  PROCEDURE sp_batch_add(
      i_users IN s_u_ary,
      v_num OUT INTEGER);
  --定义一个测试的存储过程
  PROCEDURE sp_batch_add_test(
      i_num IN INTEGER);
END PKG_typetest;

/
