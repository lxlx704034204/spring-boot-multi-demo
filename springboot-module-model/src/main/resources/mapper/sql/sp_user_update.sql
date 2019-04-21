CREATE OR REPLACE PROCEDURE sp_user_update(
    iv_id       IN VARCHAR2,
    iv_name     IN VARCHAR2,
    iv_password IN VARCHAR2,
    iv_phone    IN VARCHAR,
    iv_address  IN VARCHAR2,
    iv_birthday IN TIMESTAMP)
AS
BEGIN
  UPDATE t_user
  SET User_Name = iv_name,
    Password    =iv_password,
    Phone       =Iv_Phone,
    Address     = Iv_Address,
    Birthday    = Iv_Birthday
  WHERE User_Id = iv_id;
  COMMIT;
END sp_user_update;