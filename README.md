## TODO

- Implement TODOs using redis repository: https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
  - or you can create implementation using the elastic search client: https://www.elastic.co/guide/en/elasticsearch/client/index.html

- Introduction to s3
  - see how range is implemented, why we are able to stream videos: https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectGET.html
  - not also ETag support in S3

## Instructions

- Download and run elastic search on local machine: https://www.elastic.co/downloads/elasticsearch
- Optionally download Kibana: https://www.elastic.co/downloads/kibana

### Web App
- you have to install npm to run web app from: https://www.npmjs.com/get-npm
- run 'npm install' when you in 'webapp' directory 
- after that you can start the development mode with 'npm start'
- (install also angular-cli if required)


ELK Help:
- erase all data from elastic search: curl -XDELETE localhost:9200/*