<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>늘봄 > 커뮤니티 > 자유게시판</title>

<%@ include file="/WEB-INF/views/inc/assetclient.jsp" %>

<style>

.introducetitle {

	background-image: url("/neulbom/asset/image/자유게시판 사진.jpg");
}


tr:hover {
	cursor: pointer;
	font-weight: bold;
}

#addbtn {
	float: left;
	margin-right: 400px;
	background-color: #043886;
    color: #FFF;
    border: none;
    width: 100px;
    height: 40px;
    border: none;
    font-size: 20px;
    font-weight: bold;
    border-radius: 10%;
}

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
                    <a href="#" class="list-group-item list-group-item-action">문의게시판</a>
                    <a href="#" class="list-group-item list-group-item-action">자유게시판</a>
                </div>
            </div>
        </span>

        

        <div id="deepmenu">
            <nav class="navbar bg-light">
                <div class="container-fluid">
                    <h3 style="font-weight: 400;">커뮤니티</h3>
                    <div style="display: flex;">
                        <span class="material-symbols-outlined" style="display: block;">
                            home
                        </span>
                        > 커뮤니티 > 자유게시판
                    </div>
                </div>
            </nav>
            <hr>
            <div style="display: flex; justify-content: end; margin-bottom: 15px;">
            
            <%-- <c:if test="${not empty id }"> --%>
    			<input type="button" id="addbtn" value="글쓰기" onclick="location.href='/neulbom/client/community/addfree.do';">
    		<%-- </c:if> --%>
            
                <form class="d-flex" role="search" style="max-width: 50%;">
                    <select class="form-select" aria-label="Default select example" style="margin-right: 10px;">
                        <option selected>제목</option>
                        <option value="1">번호</option>
                        <option value="2">작성자</option>
                        <option value="3">내용</option>
                    </select>
        
                    <input class="form-control_wj" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-light" type="submit"
                        style="width:74px !important; height:38px !important;white-space:nowrap;">검색</button>
                </form>
            </div>
            <hr>
            <table class="table table-hover list">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th style="text-align: center;">제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                <c:if test="${list.size() == 0}">
                	<tr>
					<td colspan="10">게시물이 없습니다.</td>
					</tr>
	            </c:if>
	            <c:forEach items="${list }" var="dto">
                    <tr>
                    	<td>
	            		<c:if test="${dto.depth == 0 }">
                        ${dto.free_seq }
                        </c:if>
                        <c:if test="${dto.depth > 0 }">
                        <td>답글</td>
                        </c:if>
                        </td>
                        <td>${dto.title }</td>
                        <td>${dto.name }</td>
                        <td>${dto.free_date }</td>
                        <td>${dto.read }</td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>
    

    

    
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
    
    <div>
    	
    
    </div>
    

    </div>
	 
	<%@ include file="/WEB-INF/views/inc/footerclient.jsp" %>
<script>

</script>
</body>
</html>