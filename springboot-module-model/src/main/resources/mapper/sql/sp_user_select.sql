CREATE OR REPLACE PROCEDURE sp_user_select(
    cur_sys OUT sys_refcursor)
AS
BEGIN
  OPEN cur_sys FOR SELECT USER_ID , USER_NAME ,PASSWORD , PHONE , ADDRESS , BIRTHDAY FROM t_user ;
END sp_user_select;