# README

그냥 스프링쓰면서 기능구현 하는 프로젝트

프로젝트 Teamplate : [Github Link](https://github.com/team-dodn/spring-boot-java-template)



## Message 이슈사항
- Messages는 사용시 properties파일밖에 읽지 못함. 해당 이슈를 해결하기 위해 Dependencies를 추가해서 해결함
- 추가한 의존성 : https://github.com/akkinoc/yaml-resource-bundle/tree/main

## Attach Query
```sql
SELECT * FROM TBL_ATTACH;

SELECT * 
FROM TBL_ATTACH 
WHERE ORIGINAL_FILE_NAME ILIKE '%한국어%';

SELECT * 
FROM TBL_ATTACH 
WHERE ORIGINAL_FILE_NAME ILIKE '%한국어%';
 
```