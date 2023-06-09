<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>

<style>

</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/inc/headerclient.jsp" %>
	
	    <div class="introducetitle">커뮤니티</div>


    <div class="mainmenu text-center">
        <span class="sidebar" >
            <div class="bg-light border-right">
                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: #043886;">커뮤니티</a>
                    <a href="#" class="list-group-item list-group-item-action">입주상담 게시판</a>
<<<<<<< HEAD
                    <a href="http://localhost:8090/neulbom/client/board/qna.do" class="list-group-item list-group-item-action">문의 게시판</a>
=======
                    <a href="#" class="list-group-item list-group-item-action">문의 게시판</a>
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
                    <a href="#" class="list-group-item list-group-item-action">자유 게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">문의 게시판</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 문의 게시판
                    </div>
                </div>
            </nav>
            <hr>
            <div style="display: flex; justify-content: end; margin-bottom: 15px;">
<<<<<<< HEAD
                <form class="d-flex" role="search" action="/neulbom/client/board/qna.do" method="GET" style="max-width: 50%;">
                    <select name="column" class="form-select" aria-label="Default select example" style="margin-right: 10px;">
                        <option value="title" selected>제목</option>
                        <option value="content">내용</option>
                        <!-- <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option> -->
                    </select>
        
        			<!-- <form method="GET"> 사용 사례 -->
                    <input class="form-control_wj" type="search" placeholder="검색어를 입력해주세요." aria-label="Search" name="word" required>
=======
                <form class="d-flex" role="search" style="max-width: 50%;">
                    <select class="form-select" aria-label="Default select example" style="margin-right: 10px;">
                        <option selected>제목</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
        
                    <input class="form-control_wj" type="search" placeholder="Search" aria-label="Search">
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
                    <button class="btn btn-light" type="submit"
                        style="width:74px !important; height:38px !important;white-space:nowrap;">검색</button>
                </form>
            </div>
            <hr>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
<<<<<<< HEAD
                        <th>제목</th>
=======
                        <th style="text-align: left;">제목</th>
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
                        <th>작성자</th>
                        <th>날짜</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
<<<<<<< HEAD
				    <c:forEach items="${list}" var="dto">
				        <tr class="qna-row">
				            <td>${dto.qna_seq}</td> <!-- qna_seq -->
				            <td style="text-align: left;">${dto.title}</td> <!-- title -->
				            <td>${dto.name}</td> <!-- fname -->
				            <td>${dto.qna_date}</td> <!-- qna_date -->
				            <td>${dto.read}</td> <!-- read -->
				            <td style="display: none;">${dto.id}</td>
				        </tr>
				    </c:forEach>
				</tbody>
=======
                    <tr>
                        <td>1</td>
                        <td>[실버타운]공지사항</td>
                        <td>관리자4</td>
                        <td>2023.06.03</td>
                        <td>46</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>[실버타운]공지사항</td>
                        <td>관리자4</td>
                        <td>2023.06.03</td>
                        <td>47</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>[실버타운]공지사항</td>
                        <td>관리자4</td>
                        <td>2023.06.03</td>
                        <td>48</td>
                    </tr>
                </tbody>
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
            </table>
        </div>
        
    </div>
<<<<<<< HEAD
	   
	<div style="text-align: right; margin-top: 50px; margin-bottom: 50px; margin-right: 300px;">
	  	 <% if (session.getAttribute("id") == null) {%>
        <button type="submit" class="btn btn-primary" style="display: none;">등록하기</button>
    <% } else { %>
        <button type="submit" class="btn btn-primary" onclick="location.href='http://localhost:8090/neulbom/client/board/qnaadd.do'">등록하기</button>
    <% } %>
	</div>
    
    
    
    <div class="pagination justify-content-center" style="text-align : center; margin-bottom: 10px;">${pagination}</div>
    
    
    <%-- <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">
            <li>
                ${dlwjs}            
            </li>
            <c:forEach begin="1" end="${totalPage}" var="pageNumber">
	            <li class="page-item">
	                <a class="page-link" href="/neulbom/client/board/qna.do?page=${pageNumber}">${pageNumber}</a>
	            </li>
	        </c:forEach>
            <li>
                ${ekdma}
            </li>
        </ul>
    </nav> --%>
    
   <!--  <nav aria-label="Page navigation example "><ul class="pagination justify-content-center"><li class="page-item"><a class="page-link" href="/neulbom/client/board/qna.do?page=%d" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
            <li class="page-item"><a class="page-link" href="/neulbom/client/board/qna.do?page=%d">%d</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="/neulbom/client/board/qna.do?page=%d" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li></ul></nav> -->
=======

    
    <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    </div>
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
	 
	<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script>

<<<<<<< HEAD
	const trElements = document.querySelectorAll('.qna-row');
	trElements.forEach(tr => {
	    tr.addEventListener('click', () => {
	        const qnaSeq = tr.querySelector('td:first-child').innerText;
	        const id = tr.querySelector('td:last-child').innerText;
	        const sessionId = '${sessionScope.id}';
	        const sessionLv = '${sessionScope.lv}';
	        if (qnaSeq) {
	        	if (id === sessionId || sessionLv === '1' || sessionLv === '2') {
	            	const link = `http://localhost:8090/neulbom/client/board/qnaview.do?qna_seq=` + qnaSeq;
	            	window.location.href = link; // 링크로 이동
	        	} else {
	        		alert('권한이 없습니다.');
	        		window.location.href = '/neulbom/client/board/qna.do';
	        	}
	        }
	    });
	});

=======
>>>>>>> 8bcf6e8984d0866a2ee8a4b53e40e1b5c3142dfb
</script>
</body>
</html>