-- PDBへ切り替え
ALTER SESSION SET CONTAINER=pdb01;

-- テーブル作成するユーザ(変数定義)
DEFINE USER_NAME='hogeuser';

-- テーブル作成
CREATE TABLE &USER_NAME..t_stock
(
    stock_id NUMBER NOT NULL
    , stock_count_of_init NUMBER NOT NULL
    , stock_count_of_now NUMBER NOT NULL
    , CONSTRAINT t_stock_pk PRIMARY KEY(stock_id)
 )
;

COMMIT;