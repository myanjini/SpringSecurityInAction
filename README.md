# SpringSecurityInAction 

## 3장
- Spring Security의 사용자를 설명하는 UserDetails
- 사용자가 실행할 수 있는 작업을 정의하는 GrantedAuthority
- UserDetailsService 계약을 확장하는 UserDetailsManager

## 4장 패스워드 다루기 (Dealing with passwords)
- PasswordEncoder 구현 및 작업
- Spring Security Crypto 모듈에서 제공하는 도구 사용

## 5장 인증 구현 (Implementing authentication)
- 사용자 정의 AuthenticationProvider를 사용한 인증 논리 구현
- HTTP Basic 및 양식 기반(form-based) 로그인 인증 방법 사용
- SecurityContext 컴포넌트의 이해 및 관리

## 6장 실습: A small secured web application 
- 실습 예제에 인증 적용
- UserDetails 인터페이스로 user 정의
- 사용자 정의 UserDetailsService 정의
- 제공된 PasswordEncoder 구현 사용
- AuthenticationProvider를 구현하여 인증 로직 정의
- 폼 로그인 인증 방식 설정 

## 7장 권한 구성: 액세스 제한
- 권한 및 역할 정의
- 엔드포인트에 권한 부여 규칙 적용

## 8장 권한 구성: 제한 적용
- 매처 메서드를 사용하여 제한을 적용할 요청 선택
- 매처 메서드 별 최적의 시나리오 학습

## 9장 필터 구현
- 필터 체인 작업
- 사용자 정의 필터
- Filter 인터페이스를 구현하는 Spring Security 클래스 사용

## 10장 CSRF 보호 및 CORS 적용
- 사이트 간 요청 위변조 방지 구현
- CSRF 보호 사용자 지정
- 교차 출처 자원 공유 구성 적용