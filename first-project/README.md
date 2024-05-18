# Build
mvn clean package && docker build -t com.anonymous/first-project .

# RUN

docker rm -f first-project || true && docker run -d -p 8080:8080 -p 4848:4848 --name first-project com.anonymous/first-project 