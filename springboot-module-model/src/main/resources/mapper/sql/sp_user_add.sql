CREATE OR REPLACE PROCEDURE sp_user_add(
    iv_id       IN VARCHAR2,
    iv_name     IN VARCHAR2,
    iv_password IN VARCHAR2,
    iv_phone    IN VARCHAR,
    iv_address  IN VARCHAR2,
    iv_birthday IN TIMESTAMP)
IS
BEGIN
  INSERT
  INTO CCH.T_USER
    (
      user_id,
      user_name,
      password,
      phone,
      address,
      birthday
    )
    VALUES
    (
      iv_id,
      iv_name,
      iv_password,
      iv_phone,
      iv_address,
      iv_birthday
    );
  COMMIT;
END;