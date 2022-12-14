
# 2022년도 2학기 모바일 프로그래밍 개인과제

이름: 이세희 / 학번: 20191987 / 학과: 산림환경시스템학과

## 1. 모바일 프로그래밍 개인프로젝트 Github 저장소

- [https://github.com/Sehee-Lee-01/2022_2_MP](https://github.com/Sehee-Lee-01/2022_2_MP)

## 2. 개인 과제 완료 현황

![모프 개인-1](https://user-images.githubusercontent.com/85275893/199060300-8ea672c1-12e2-4496-8455-38d88a9031f4.png)

### 0. SDK 버전 및 개발언어

- `(구현 완료)` SDK 버전은 **안드로이드 12**를 사용
- 개발언어는 **JAVA**를 사용

### 1. 첫번째 화면 `(Relative Layout, Fragment 사용)`

![모프 개인-2](https://user-images.githubusercontent.com/85275893/199060322-6fddb02c-d720-4403-b63a-873b2897ead0.png)

- java 파일 / layout 파일
  - `MainActivity.java / main.xml`: 메인 액티비티, 인덱스에 따라 프래그먼트 변경
  - `fragments/LogInFragment.java / fragment_login.xml`: 로그인 페이지

- `(구현 완료)` 앱 접속 페이지, 회원 ID/비밀번호(EditView), 로그인/회원가입(Button)

- `(구현 완료)` 첫번째 화면 초기화시에 기존에 저장된 개인정보 읽어 오기

- `(구현 완료)` ID, 비밀번호 입력 시 기존에 가입한 회원 ID, 비밀번호 체크 오류 시 에러 메시지 출력

- `(구현 완료)` ID, 비밀번호 입력이 정상이고 로그인 버튼 클릭 시 세번째 페이지 이동

- `(구현 완료)` 회원가입 없이도 메인 버튼(상품 출력 페이지)을 클릭하면 세번째 화면으로 이동 가능

### 2. 두번째 화면 `(Linear Layout, Fragment 사용)`

![모프 개인-3](https://user-images.githubusercontent.com/85275893/199060358-45c93ed4-689c-49a7-822b-3d8c86dba137.png)

![모프 개인-4](https://user-images.githubusercontent.com/85275893/199060371-47aff37e-9946-4d93-892e-aefd15c8aed9.png)

- java 파일 / layout 파일
  - `MainActivity.java / main.xml`: 메인 액티비티, 인덱스에 따라 프래그먼트 변경
  - `fragments/SignUpFragment.java / fragment_signup.xml`: 회원가입 페이지

- `(구현 완료)` 회원가입 페이지, 첫번째 페이지에서 회원가입 버튼 클릭 시 출력

- `(구현 완료)` ID(EditView, 중복검사), 비밀번호(EditView, 자릿수/특수키 등 규칙 체크)

- `(구현 완료)` 이름/전화번호/주소(EditView)

- `(구현 완료)` 개인정보 사용 동의 간략 약관(TextView), 동의 여부(Radio Button, Decline/Accept)

- `(구현 완료)` 회원정보를 저장하고 첫번째 페이지로 이동

- `(구현 완료)`  회원정보 저장은 `프레퍼런스(Preference)`에 `ArrayList`로 저장

### 3. 세번째 화면 `(Grid Layout 사용)`

![모프 개인-5](https://user-images.githubusercontent.com/85275893/199060383-71b90e9c-f478-4d17-8e37-a5ae83dd1694.png)

![모프 개인-6](https://user-images.githubusercontent.com/85275893/199060397-e8d7d030-d7cc-49d5-b384-937a7ba68d90.png)

- java 파일 / layout 파일
  - `GoodsActivity.java / goods.xml, goods_row.xml`: ListView를 이용한 상품 출력 페이지
  - `SignUpPop.java / pop_signup.xml`: 로그인 안했을 때 회원가입 여부 물어보는 팝업창
  - `InfoPop.java / pop_info.xml`: 로그인 했을 때, 회원 정보 보여주는 팝업창

- `(구현 완료)` 상품명, 상품이미지 리스트를 보여주는 화면 (6개 이미지 출력)

- `(구현 완료: '뷰'만 구현)`  (선택) 화면 아래 부분에서 상품명, 상품이미지를 등록 및 삭제하는 버튼 추가

- `(구현 완료)` 화면 아래 부분에 회원정보 버튼은 회원인 경우는 가입한 회원 정보를 보여주고 회원이 아닌 경우는 회원정보 버튼을 클릭하면 회원가입 여부를 물어보고 원하면 회원가입 페이지인 두번째 화면으로 이동

- `(구현 완료)` View을 상속한 여러가지 위젯을 사용하여 화면을 구성: `ListView`, `CheckBox`, `ImageView`, `ImageButton` 등으로 구현

### 4. 기타 사항

- `git & github`를 이용한 버전관리
