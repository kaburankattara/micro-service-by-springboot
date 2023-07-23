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
    , CONSTRAINT pk1 PRIMARY KEY(stock_id)
 )
;

-- シーケンスを設定
-- CACHEはパフォーマンスを向上させるために使用されるオプション。必須ではない。
CREATE SEQUENCE stock_id_sequence
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

COMMIT;