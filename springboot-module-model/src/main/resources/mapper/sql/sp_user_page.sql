create or replace PROCEDURE sp_user_page(
    p_index IN NUMBER DEFAULT 1 ,
    p_size  IN NUMBER DEFAULT 5 ,
    p_count OUT NUMBER ,
    users OUT sys_refcursor )
AS
  p_start NUMBER;
  p_end   NUMBER;
BEGIN
  SELECT COUNT(1)
  INTO P_COUNT
  FROM T_USER;
  p_start := (P_Index   -1) * p_size;
  p_end   := p_start    + p_size;
  OPEN users FOR SELECT * FROM
  (SELECT ROWNUM rn, a.* FROM T_USER a WHERE ROWNUM <= p_end
  ) WHERE rn > p_start;
END SP_USER_PAGE;