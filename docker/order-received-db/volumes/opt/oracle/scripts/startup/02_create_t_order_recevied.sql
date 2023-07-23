-- PDBへ切り替え
ALTER SESSION SET CONTAINER=pdb01;

-- テーブル作成するユーザ(変数定義)
DEFINE USER_NAME='hogeuser';

-- テーブル作成
CREATE TABLE &USER_NAME..t_order_recevied
(
    order_received_id NUMBER NOT NULL
    , order_received_count NUMBER NOT NULL
    , CONSTRAINT pk1 PRIMARY KEY(order_received_id)
 )
;

-- シーケンスを設定
-- CACHEはパフォーマンスを向上させるために使用されるオプション。必須ではない。
CREATE SEQUENCE order_received_id_sequence
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

COMMIT;