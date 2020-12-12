# Backend Basic Challenge Api
## Run api
Build docker image
1. Generate JAR
```
.\mvnw clean package
```
2. Run Postgresql docker image
```
docker build -t backend-basic-challenge .
```
3. Run api
```
docker run -e "SPRING_PROFILES_ACTIVE=local" -p 9000:9000 -t backend-basic-challenge
```