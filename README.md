
# 2022년도 2학기 모바일 프로그래밍 개인과제

## 1. 모바일 프로그래밍 개인프로젝트 Github 저장소

- [https://github.com/Sehee-Lee-01/2022_2_MP](https://github.com/Sehee-Lee-01/2022_2_MP)

## 2. 개인 과제 완료 현황

![모프 개인](https://user-images.githubusercontent.com/85275893/198891546-0afacf13-b7d9-4284-a781-3b185bc400e3.png)

### 0. SDK 버전 및 개발언어

- `(구현 완료)` SDK 버전은 **안드로이드 12**를 사용
- 개발언어는 JAVA를 사용

### 1. 첫번째 화면 `(Relative Layout, Fragment 사용)`

![모프 개인 (1)](https://user-images.githubusercontent.com/85275893/198891561-e7f44c0a-beb3-48d5-91b3-6481b990ddff.png)

- `(구현 완료)` 앱 접속 페이지, 회원 ID/비밀번호(EditView), 로그인/회원가입(Button)

- `(구현 완료)` 첫번째 화면 초기화시에 기존에 저장된 개인정보 읽어 오기

- `(구현 완료)` ID, 비밀번호 입력 시 기존에 가입한 회원 ID, 비밀번호 체크 오류 시 에러 메시지 출력

- `(구현 완료)` ID, 비밀번호 입력이 정상이고 로그인 버튼 클릭 시 세번째 페이지 이동

- `(구현 완료)` 회원가입 없이도 메인 버튼(상품 출력 페이지)을 클릭하면 세번째 화면으로 이동 가능

### 2. 두번째 화면 `(Linear Layout, Fragment 사용)`

![모프 개인 (2)](https://user-images.githubusercontent.com/85275893/198891569-e05e150d-23bb-4e58-b19a-946d0a53e283.png)

![모프 개인 (3)](https://user-images.githubusercontent.com/85275893/198891574-635d8cf7-e54e-48d0-b2f7-fdfd167c062b.png)

- `(구현 완료)` 회원가입 페이지, 첫번째 페이지에서 회원가입 버튼 클릭 시 출력

- `(구현 완료)` ID(EditView, 중복검사), 비밀번호(EditView, 자릿수/특수키 등 규칙 체크)

- `(구현 완료)` 이름/전화번호/주소(EditView)

- `(구현 완료)` 개인정보 사용 동의 간략 약관(TextView), 동의 여부(Radio Button, Decline/Accept)

- `(구현 완료)` 회원정보를 저장하고 첫번째 페이지로 이동

- `(구현 완료)`  회원정보 저장은 `프레퍼런스(Preference)`를 활용

### 3. 세번째 화면 `(Grid Layout 사용)`

![모프 개인 (4)](https://user-images.githubusercontent.com/85275893/198891582-61d621d4-6800-43f9-8350-ef6060bd62c9.png)

![모프 개인 (6)](https://user-images.githubusercontent.com/85275893/198891592-63c5f687-e45b-4e49-a258-6de44365e0eb.png)

- `(구현 완료)` 상품명, 상품이미지 리스트를 보여주는 화면 (6개 이미지 출력)

- `(구현 완료: 뷰만 구현)`  (선택) 화면 아래 부분에서 상품명, 상품이미지를 등록 및 삭제하는 버튼 추가

- `(구현 완료)` 화면 아래 부분에 회원정보 버튼은 회원인 경우는 가입한 회원 정보를 보여주고 회원이 아닌 경우는 회원정보 버튼을 클릭하면 회원가입 여부를 물어보고 원하면 회원가입 페이지인 두번째 화면으로 이동 (유저관리 - 5점)

- `(구현 완료: ListView, CheckBox, ImageButton)` View을 상속한 여러가지 위젯을 사용하여 화면을 구성(기능에 맞는 위젯 선택하여 구성): ListView, CheckBox, ImageView, ImageButton 등으로 구현
