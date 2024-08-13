# 프리온보딩 백엔드 인턴십 선발과제

# 1. 프로젝트 개요
+ **프로젝트 주제** : 기업의 채용을 위한 웹 서비스
+ **개발 기간** : 2024.08.12 ~ 2024.08.13
+ **주요 기능**
	+ 회사가 채용공고 등록
	+ 회사가 채용공고 수정
	+ 채용공고 삭제
	+ 채용공고 목록 조회
	+ 채용공고 검색 기능
	+ 채용공고 상세 페이지 조회
	+ 사용자의 채용공고 지원
+ **사용 언어 및 프레임워크**
	+ Java 21
	+ Spring boot 3
+ **개발 환경**
	+ JPA
	+ MySQL

# 2. ERD
<img width="1156" alt="image" src="https://github.com/user-attachments/assets/672764ad-a16e-46ee-b4fc-2b567ab3075f">

# 3. 디렉토리 구조
```
/src
  /main
    /domain
      /controller
      /service
      /entity
      /repository
      /dto
    /exception
    /util
  /resource
    application.yml
```

# 4. 기능 구현
## i. 채용공고 등록
### 요구사항
- 회사가 채용공고 등록
- 회사 임의 데이터 추가

### API 명세
**Method** : POST
**경로** : `/api/job`

#### 요청
```json
{
  "companyId": 1,
  "position": "백엔드 주니어 개발자",
  "compensation": 1000000,
  "contents": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skill": "Python"
}
```

#### 응답
##### 201 Created
```json
none
```

<br/>

### 예외 처리

#### 요청 데이터를 제대로 받지 못한 경우
```json
{
  "status": 400,
  "message": "Bad Request"
}
```

## ii. 채용공고 수정
### 요구사항
- 회사가 채용공고 수정
- 회사 id 외에 모두 수정 가능

### API 명세
**Method** : PUT
**경로** : `/api/job/{채용공고 Id}`

#### 요청
```json
{
  "compensation": 1500000
}
```

#### 응답
##### 200 OK
```json
{
  "position": "백엔드 주니어 개발자",
  "compensation": 1500000,
  "contents": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skill": "Python"
}
```

<br/>

### 예외 처리

#### 요청 데이터를 제대로 받지 못한 경우
```json
{
  "status": 400,
  "message": "Bad Request"
}
```

#### 해당 공고 글이 존재하지 않을 경우
```json
{
  "status": 404,
  "message": "Not Found"
}
```

## iii. 채용공고 삭제
### 요구사항
- 채용공고를 DB에서 삭제

### API 명세
**Method** : DELETE
**경로** : `/api/job/{채용공고 Id}`

#### 요청
```json
{
none
}
```

#### 응답
##### 200 OK
```json
{
  none
}
```

<br/>

### 예외 처리

#### 해당 공고 글이 존재하지 않을 경우
```json
{
  "status": 404,
  "message": "Not Found"
}
```


