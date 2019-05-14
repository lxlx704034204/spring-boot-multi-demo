--------------------------------------------------------
--  DDL for Package Body PKG_SELF_TYPE_DEMO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "CCH"."PKG_SELF_TYPE_DEMO" 
AS
PROCEDURE sp_batch_add(
    i_users IN SELF_TABLE_TYPE,
    v_num OUT INTEGER,
    v_str OUT VARCHAR,
    v_str2 OUT VARCHAR2,
    --v_bool OUT BOOLEAN,
    v_bool OUT VARCHAR,
    v_timestamp OUT TIMESTAMP,
    --v_time OUT TIME,
    v_date OUT DATE ,
    v_long OUT LONG,
    v_float OUT FLOAT)
AS
BEGIN
  -- TODO: PROCEDURE PKG_SELF_TYPE_DEMO.sp_batch_add所需的实施
  v_str      :='hello_VARCHAR';
  v_str2     :='hello_VARCHAR2';
  v_timestamp:=sysdate;
  --v_time     :=sysdate;
  v_date :=sysdate;
  v_long :=11111111;
  v_float:=1111.22222;
  Dbms_Output.Put_Line(v_str);
  Dbms_Output.Put_Line(v_str2);
  Dbms_Output.Put_Line(v_timestamp);
  -- Dbms_Output.Put_Line(v_time);
  Dbms_Output.Put_Line(v_date);
  Dbms_Output.Put_Line(v_long);
  Dbms_Output.Put_Line(v_float);
  --v_bool :=false;
  --IF v_bool THEN
  v_bool  :='true';
  IF v_bool='true' THEN
    Dbms_Output.Put_Line('true');
  ELSE
    Dbms_Output.Put_Line('false');
  END IF;
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
