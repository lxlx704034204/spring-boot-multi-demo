create or replace PROCEDURE sp_select_user_by_id(
    U_ID IN VARCHAR2 ,
    U_NAME OUT VARCHAR2 ,
    U_PASS OUT VARCHAR2 ,
    PHONE OUT VARCHAR2 ,
    ADDRESS OUT VARCHAR2 ,
    BIRTHDAY OUT DATE )
AS
BEGIN
  SELECT user_name,
    password,
    phone,
    address,
    birthday
  INTO U_name,
    u_pass,
    phone,
    address,
    birthday
  FROM t_user a
  WHERE user_id = u_id;
  COMMIT;
END SP_SELECT_USER_BY_ID;