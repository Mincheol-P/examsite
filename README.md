
# examsite

Java 17 / Spring Boot 3.5.7 / Gradle / Mustache / Spring Data JPA / H2(메모리)

## 실행
```bash
./gradlew bootRun
# 또는
./gradlew clean bootJar && java -jar build/libs/*.jar
```

## 로컬 H2 콘솔
- 경로: /h2
- JDBC URL: jdbc:h2:mem:exam;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE
- 사용자: sa
- 비밀번호: 없음
