# Web_Project
늘봄 실버타운 & 요양원

# 프로젝트 소개
- 입주자들의 건강, 삶의 질, 사회 참여 등을 증진하기 위한 실버타운과 요양원을 운영
하고, 다양한 서비스와 활동을 제공하기 위해 필요한 기능을 구상한다.
- 이를 위해 효율적인 운영과 관리를 위한 관리자용 그룹웨어와 실버타운 통합 웹 페이지를 구현한다.

# 개발기간
- 2023-05-25 ~ 2023-06-12

# 기술 스택
### Environment
<img src="https://img.shields.io/badge/Eclipse IDE-2c2255?style=for-the-badge&logo=EclipseIDE&logoColor=white"/> <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white"/> <img src="https://img.shields.io/badge/Git-f05032?style=for-the-badge&logo=Git&logoColor=white"/>
<img src="https://img.shields.io/badge/Visual Studio Code-007acc?style=for-the-badge&logo=VisualstudioCode&logoColor=white"/>

### Language & Framework
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>  <img src="https://img.shields.io/badge/JavaScript-f7df1e?style=for-the-badge&logo=JavaScript&logoColor=black"/> <img src="https://img.shields.io/badge/HTML5-e34f26?style=for-the-badge&logo=HTML5&logoColor=white"/> <img src="https://img.shields.io/badge/CSS-1572b6?style=for-the-badge&logo=CSS3&logoColor=white"/> <img src="https://img.shields.io/badge/BootStrap-7952b3?style=for-the-badge&logo=bootstrap&logoColor=white"/>

### Database
<img src="https://img.shields.io/badge/Oracle Database-f80000?style=for-the-badge&logo=Oracle&logoColor=white"/> 

### Server
<img src="https://img.shields.io/badge/Apache Tomcat-f8dc75?style=for-the-badge&logo=Apache Tomcat&logoColor=black"/> 

# 데이터 구조
![늘봄ERD(논리)](https://github.com/HeeYunR/NeulBom_Project/assets/126316288/d124b039-e51e-4a30-8712-a58cd2c6a87e)

<hr>

### 개요
1. 사용자는 관리자, 입주자, 보호자, 비회원으로 구분한다.
2. 관리자 그룹웨어와 입주자/보호자/비회원 클라이언트 페이지를 구분하여 제공한다.
3. 관리자는 계정 관리자, 일반 관리자, 그 외 직원으로 구분하고 권한별로 기능 접근 권한을 다르게 한다.

# 화면 구성
### 📘 메인 화면
- 메인 화면은 로그인과 상세 기능으로 이루어져 있다.
- 로그인을 누르게 되면, 관리자, 입주자, 직원용 로그인으로 나뉘어져 관리자로 로그인하게 될 경우에는 관리자 기능으로 가게된다.
- **늘봄 소개** : 인사말, 시설소개, 오시는길
- **입주안내**
- **알림게시판** : 공지사항, 식단표, 생활게시판
- **커뮤니티** : 입주상담, 문의게시판, 자유게시판

![1-1  메인화면](https://github.com/HeeYunR/NeulBom_Project/assets/126316288/05c56d7d-641f-488e-9ada-aeeca041170d)


### 📘 클라이언트 기능
- 클라이언트는 입주자, 보호자, 비회원으로 구분한다. 각각 회원의 기능은 구분된다
- 입주자와 보호자는 게시판과 같은 모든 기능을 사용할 수 있지만, 비회원은 문의 기능 말고는 사용을 하지 못하여 회원가입을 한 후에 기능을 이용할 수 있다.
- 입주자와 보호자의 차이는 입주자는 관리자가 계정을 부여해주는 방식이지만, 보호자는 입주자의 아이디를 확인한 후 자신이 직접 회원가입을 통해 계정을 만들 수 있다.
#### 커뮤니티
![6-1  자유게시판](https://github.com/HeeYunR/NeulBom_Project/assets/126316288/c34d6c29-7e8a-488d-9ea2-4dbe16a6dcc7)
![6-2  자유게시판](https://github.com/HeeYunR/NeulBom_Project/assets/126316288/dbfd66e0-32d3-4994-9866-03cf9a0e65c1)


### 📘 관리자 기능
- 관리자는 로그인을 하게 되면, 관리자 전용 페이지로 이동한다.
- 관리자는 레벨에 따라서 계정 관리자, 직원으로 나뉘게 된다.
- 두 관리자의 공통 기능은 복지 프로그램 기능, 직원 정보 조회가 있고, 계정 관리자는 공통 기능, 계정에 관한 기능 외 다른 기능을 클릭시 관리자의 레벨을 확인하여 접근할 수 없게 설계하였다. 직원 관리자는 계정 관리자가 접근할 수 없는 기능과 공통 기능을 활용할 수 있다.

#### 계정 관리자 기능
- 관리자 재무관
![3  재무관리](https://github.com/HeeYunR/NeulBom_Project/assets/126316288/525dd402-c15a-40b3-b2be-782c5a47140a)


<hr>

## ❗ 아쉬웠던 점
### 화면 설계에 대한 어려움
- 화면 설계를 하기 전에 협업 프로그램을 정하는데 어려움을 겪었다. 협업 프로그램에는 Figma와 Figjam이 후보로 올라왔다. Figma는 UI/UX 전문 툴로서, 익히는데 시간이 걸리는 만큼 결과물이 보장되었고, Figjam은 Figma와 같이 무거운 프로그램이 아니고 브레인 스토밍을 하는데 쓰이는 도구로서, 익히는데 어려움을 겪지 않는다는 점이 장점으로 다가왔다. 팀원들은 화면설계를 할 떄 제대로 해보자는 목표로를 가지고 Figma를 사용하기로 결정하였다. 하지만 Figma 툴을 익히는데, 너무 오랜 시간을 지체해버렸고, 시간을 투자한만큼의 결과물이 안나와서 너무 아쉬웠다.

## 💡 문제 해결을 위한 노력
### Git 활용 능력
- 초반에 관리자와 클라이언트 부분을 나눠서 팀 협업을 시작하였는데, 관리자 부분은 먼저 Git을 시작하고, 클라이언트 부분은 나중에 Git을 시작하여 서그래서 이 로 다른 기능을 병합할 때 충돌나는 일이 생겼었다. 충돌나는 이유는 관리자 기능 중 삭제하고 난 후 커밋을 하였는데, 이것이 삭제내역이 생겨서 다른 사람이 pull을 할 때, 삭제되어 pull을 하면 그 부분이 충돌나서 문제가 일어났던 것이다. 그래서 이 부분을 다시 분기점을 돌려서 이 문제점을 해결하였고, 이 때 느낀 교훈은 Git을 사용하고 커밋할 때, 신중히 해야겠다고 느꼈다.
