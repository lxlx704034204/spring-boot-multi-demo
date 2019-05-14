--------------------------------------------------------
--  DDL for Package Body PKG_SELF_TYPE_DEMO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "CCH"."PKG_SELF_TYPE_DEMO" 
AS
PROCEDURE sp_batch_add(
    i_users IN SELF_TABLE_TYPE,
    v_num OUT INTEGER,
    v_str OUT VARCHAR,
    v_str2 OUT VARCHAR2
    )
AS
BEGIN
  -- TODO: PROCEDURE PKG_SELF_TYPE_DEMO.sp_batch_add所需的实施
  v_str:='hello VARCHAR';
   v_str2:='hello VARCHAR2';
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
END PKG_SELF_TYPE_DEMO;

/
