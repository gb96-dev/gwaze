🚀 Spring Boot JPA 연관관계 과제
이 프로젝트는 Spring Boot와 JPA를 사용하여 **Member(회원)**와 Gwaze(과제) 간의 연관관계를 설정하고, 데이터를 조회할 때 발생하는 SQL 쿼리를 확인하는 과제입니다.

🛠️ 개발 환경
Java: 17

Spring Boot: 3.5.9

Database: MySQL 8.0

Library: Spring Data JPA, Lombok, Spring Web, MySQL Driver

📌 핵심 구현 사항
연관관계 설정: Gwaze 엔티티에서 Member 엔티티를 @ManyToOne (다대일) 관계로 연결했습니다.

지연 로딩(Lazy Loading): 성능 최적화를 위해 FetchType을 LAZY로 설정했습니다.

단건 조회 API: 과제 ID로 조회 시 작성자(Member)의 이름까지 함께 반환하도록 구현했습니다.

✅ 과제 수행 결과 (스크린샷)
1. Postman 단건 조회 성공
GET http://localhost:8080/gwazes/1 호출 시 과제 내용과 회원 이름이 정상적으로 반환됩니다.

<img width="600" height="400" alt="image" src="https://github.com/user-attachments/assets/d6fa0bb4-bb54-4079-a72e-091156a3ddb0" />


2. Hibernate SELECT 쿼리 2개 확인
과제(Gwaze)를 조회할 때 한 번, 연관된 회원(Member) 정보를 가져올 때 한 번, 총 2개의 SELECT 쿼리가 실행되는 것을 확인했습니다.

SQL

-- 1번째: 과제(Gwaze) 조회 쿼리
Hibernate: 
    select g1_0.id, g1_0.content, g1_0.member_id 
    from gwazes g1_0 
    where g1_0.id=?

-- 2번째: 연관된 회원(Member) 조회 쿼리 (지연 로딩 동작)
Hibernate: 
    select m1_0.id, m1_0.name 
    from members m1_0 
    where m1_0.id=?
<img width="600" height="400" alt="image" src="https://github.com/user-attachments/assets/de39340d-dae2-4c1c-a169-88b73df2d62d" />


💡 분석 내용
현상: 과제 단건 조회 시 SQL 쿼리가 2번 발생함.

원인: Gwaze 엔티티가 Member를 참조하고 있으며, DTO로 변환하는 과정에서 member.getName()을 호출했기 때문입니다.

해결 방안 (선택): 만약 쿼리를 한 번(한 줄)으로 줄이고 싶다면, Repository에서 fetch join을 사용하여 한 번에 데이터를 가져오도록 개선할 수 있습니다.
