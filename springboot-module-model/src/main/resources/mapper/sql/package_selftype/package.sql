--------------------------------------------------------
--  DDL for Package PKG_SELF_TYPE_DEMO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "CCH"."PKG_SELF_TYPE_DEMO" AS 

    --定义一个测试存储过程
  PROCEDURE sp_batch_add(
      i_users IN SELF_TABLE_TYPE,
      v_num OUT INTEGER,
      v_str OUT VARCHAR,
      v_str2 OUT VARCHAR2
      );
      
END PKG_SELF_TYPE_DEMO;

/
