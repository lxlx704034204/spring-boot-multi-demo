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
--------------------------------------------------------
--  DDL for Package Body PKG_TYPETEST
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "CCH"."PKG_TYPETEST" 
AS
PROCEDURE sp_batch_add(
    i_users IN s_u_ary,
    v_num OUT INTEGER)
AS
BEGIN
  -- TODO: PROCEDURE PKG_SEFTTYPE_TEST.sp_batch_add所需的实施
  IF i_users IS NULL THEN
    v_num    :=0;
    Dbms_Output.Put_Line('i_user is null');
  ELSE
    v_num := i_users.count;
    Dbms_Output.Put_Line('i_user size is:'||i_users.count);
    FOR idx IN 1..v_num
    LOOP
      DBMS_OUTPUT.put_line('user_id:'||i_users(idx).id||' ... user_name:'||i_users(idx).name);
    END LOOP;
  END IF;
END sp_batch_add;
PROCEDURE sp_batch_add_test(
    I_Num IN INTEGER)
AS
  total   NUMBER;
  out_num NUMBER;
  userEntity s_u;
  userlist s_u_ary;
BEGIN
  IF i_num IS NULL THEN
    total  :=2;
  ELSE
    total:=I_Num;
  END IF;
  FOR idx IN 1..total
  LOOP
    DBMS_OUTPUT.put_line(idx||'...user add');
    Userentity.id  :=idx;
    Userentity.name:='cgycch'||idx;
    userlist(idx)  :=userentity;
  END LOOP;
  DBMS_OUTPUT.put_line('out num1:'||Out_Num);
  sp_batch_add(userlist,Out_Num);
  DBMS_OUTPUT.put_line('out num2:'||Out_Num);
END sp_batch_add_test;
END PKG_typetest;

/
--------------------------------------------------------
--  DDL for Synonymn DBMS_OUTPUT
--------------------------------------------------------

  CREATE OR REPLACE PUBLIC SYNONYM "DBMS_OUTPUT" FOR "SYS"."DBMS_OUTPUT";
--------------------------------------------------------
--  DDL for Synonymn PLITBLM
--------------------------------------------------------

  CREATE OR REPLACE PUBLIC SYNONYM "PLITBLM" FOR "SYS"."PLITBLM";
