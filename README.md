# 🏫 examsite

> 대중소상생아카데미 백엔드과정 개인 과제  
> **Spring Boot + Mustache + JPA + Gradle + H2** 기반 예시 사이트

---

## 📋 프로젝트 개요
간단한 웹사이트 예시입니다.  
공지사항, 게시판, 오시는길 페이지를 포함하며 Mustache 템플릿으로 화면을 구성했습니다.

---

## ⚙️ 기술 스택
| 구분 | 사용 기술 |
|------|------------|
| 언어 | Java 17 |
| 프레임워크 | Spring Boot 3.5.7 |
| 템플릿 엔진 | Mustache |
| ORM / DB | Spring Data JPA, H2 (인메모리) |
| 빌드 도구 | Gradle (Kotlin DSL) |
| UI | Bootstrap 5.3 |

---

## 🧱 주요 기능
- 공지사항 CRUD  
- 게시판 CRUD  
- 오시는 길 페이지 (지도 포함)  
- Mustache 기반 화면 분리 (`_header`, `_footer` 등 공통 템플릿)

---

## ▶️ 실행 방법

### 1. 프로젝트 클론
```bash
git clone https://github.com/Mincheol-P/examsite.git
cd examsite
2. 애플리케이션 실행
bash
코드 복사
gradlew.bat bootRun   # Windows
./gradlew bootRun     # Mac/Linux
3. 접속
브라우저에서 http://localhost:8080 접속

📁 주요 경로 구조
bash
코드 복사
src
 ├─ main
 │   ├─ java/com/examsite
 │   │   ├─ domain/       # Entity
 │   │   ├─ repo/         # Repository (JPA)
 │   │   ├─ web/          # Controller
 │   │   └─ config/       # 설정 및 예시 데이터
 │   └─ resources/
 │       ├─ templates/    # Mustache 템플릿
 │       └─ application.yml
📄 라이선스
이 프로젝트는 학습용으로 자유롭게 수정 및 배포할 수 있습니다.
