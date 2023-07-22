echo 作業ディレクトリに移動
cd ~/workspace/micro-service-by-springboot/docker/

echo dockerを起動
docker-compose -f docker-compose.yml -p micro-service-by-springboot up --build -d
