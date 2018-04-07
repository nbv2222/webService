SELECT
  APPLICATION_ID,
  order_tbl.CONTACT_ID,
  max(DT_CREATED)
FROM order_tbl
  INNER JOIN account_tbl ON order_tbl.CONTACT_ID = account_tbl.CONTACT_ID
WHERE account_tbl.CONTACT_ID = 1