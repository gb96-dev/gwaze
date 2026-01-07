🚀 Spring Boot JPA 연관관계 과제

Spring Boot와 JPA를 사용하여 Member(회원) 와 Gwaze(과제) 간의 연관관계를 설정하고,
지연 로딩(Lazy Loading) 동작 시 실행되는 SQL 쿼리를 직접 확인하는 과제입니다.

🛠️ 개발 환경
항목	내용
Java	17
Spring Boot	3.5.9
Database	MySQL 8.0
ORM	Spring Data JPA
기타	Lombok, Spring Web, MySQL Driver
📌 핵심 구현 내용
1️⃣ 엔티티 연관관계 설정

Gwaze → Member 단방향 다대일(@ManyToOne) 관계

외래 키(member_id)는 Gwaze 테이블에서 관리

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "member_id")
private Member member;

2️⃣ 지연 로딩(Lazy Loading) 적용

성능 최적화를 위해 FetchType.LAZY 사용

연관된 Member 엔티티는 실제 접근 시점에 조회되도록 설정

3️⃣ 단건 조회 API 구현

과제 ID로 Gwaze 단건 조회

응답에 과제 내용 + 작성자(Member) 이름 함께 반환

GET /gwazes/{id}

✅ 실행 결과
1️⃣ Postman 단건 조회 성공

요청

GET http://localhost:8080/gwazes/1


결과

과제(Gwaze) 정보 정상 조회

연관된 회원(Member) 이름 정상 포함

📸 Postman 단건 조회 결과 스크린샷 첨부
<img width="600" height="400" alt="Postman 단건 조회 결과" src="https://github.com/user-attachments/assets/7c20f4ac-fb1f-457b-9529-1f15230c505b" />

2️⃣ Hibernate SQL 쿼리 2개 실행 확인 (Lazy Loading)

지연 로딩 설정에 따라 총 2개의 SELECT 쿼리가 실행되는 것을 확인했습니다.

🔹 1번째 쿼리: Gwaze 조회
Hibernate: 
    select g1_0.id, g1_0.content, g1_0.member_id 
    from gwazes g1_0 
    where g1_0.id=?

🔹 2번째 쿼리: 연관된 Member 조회
Hibernate: 
    select m1_0.id, m1_0.name 
    from members m1_0 
    where m1_0.id=?


📸 IntelliJ 콘솔에 출력된 Hibernate 쿼리 로그 스크린샷 첨부

📝 정리

JPA @ManyToOne 연관관계를 통해 엔티티 간 관계를 설정함

FetchType.LAZY 적용으로 연관 엔티티가 실제 접근 시점에 조회됨을 SQL 로그로 확인

단건 조회 API를 통해 연관 엔티티 데이터가 정상적으로 반환됨

➡️ JPA 지연 로딩 동작 원리를 실습하고 검증한 과제
