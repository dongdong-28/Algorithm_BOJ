-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/',f.BOARD_ID,'/',f.FILE_ID,f.FILE_NAME,f.FILE_EXT) as FILE_PATH from USED_GOODS_FILE f 
WHERE BOARD_ID = (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1)

order by f.FILE_ID desc;