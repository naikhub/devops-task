# docker-nginx-load-balancer
A simple docker nginx load balancer example

```sh
git clone https://github.com/zsiegel/docker-nginx-load-balancer.git
cd docker-nginx-load-balancer

docker-compose up --build --remove-orphans -d
docker ps

Open Browser:
http://localhost/ : Request served by (www01 container)

docker stop any container

Open Browser:
http://localhost/ : Request served by (www02 container)

```
