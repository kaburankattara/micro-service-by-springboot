echo 作業ディレクトリに移動
cd ~/workspace/micro-service-by-springboot/docker/

echo データディレクトリを削除
# rm -rf volumes/bitnami/kafka
rm -rf order-received-db/volumes/opt/oracle/oradata
rm -rf stock-db/volumes/opt/oracle/oradata

echo dockerを起動
docker-compose -f docker-compose.yml -p micro-service-by-springboot up --build -d
