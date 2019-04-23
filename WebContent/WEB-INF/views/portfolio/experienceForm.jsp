<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    info="내 포트폴리오 관리 페이지 - 관련 경험 (사진, 제목, 내용, 분류 코드)" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 포트폴리오 관리</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="http://localhost:8080/propofol_prj/common/css/myPortfolio.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#exp_cd").change(function() {
			alert($("#exp_cd").val());
			
			// 선택에 따라 다르게 .do 요청을 보낸다.
		}); // change
	}); // ready
</script>
</head>
<body>
	<!-- header -->
	<header id="page-header">
		<!-- navbar -->
		<c:import url="http://localhost:8080/propofol_prj/common/jsp/navbar.jsp"/>
	</header>
	<!-- section -->
	<section id="page-section">
	    <div class="container">
			<div id="section-head">
				<h3><span style="float: left;"><a href="./myPortfolio.do">내 포트폴리오 관리</a></span></h3>
				<ul>
					<li><a href="./aboutMeForm.do">자기소개</a></li>
					<li><a href="./techStacksForm.do">기술 스택</a></li>
					<li><a href="./experienceForm.do">관련 경험</a></li>
					<li><a href="./tellMeForm.do">연락처</a></li>
				</ul>
				<div style="clear: both;"></div>
			</div>
			<!-- section-main -->
	    	<!-- 관련 경험 -->
		    <div id="section-main">
				<div style="color: #000000;">
					<span style="font-weight: bold;">*관련 경험 등록이 가능합니다.</span>
					<span style="float: right; width: 150px;">
						<label for="exp_cd">페이지 선택</label>
						<select name="exp_cd" id="exp_cd" class="custom-select" style="text-align-last: center;">
							<option value="edu">교육사항</option>
							<option value="prj">프로젝트</option>
						</select>
					</span>
					<div style="clear: both;"></div>
				</div>
				<!-- import -->
				<%-- <c:import url="/WEB-INF/views/portfolio/experiencePrjSlice.jsp"/> --%>
				<c:import url="/WEB-INF/views/portfolio/experiencePrjSlice.jsp"/>
				<c:import url="/WEB-INF/views/portfolio/experience${ exp_cd }Slice.jsp"/>
			</div>
			<!-- section-footer -->
			<div id="section-footer">
				<input type="button" value="초기화" name="btnReset" id="btnReset" class="btn btn-dark" style="margin-right: 15px;"/>
				<input type="button" value="적용" name="btnRevise" id="btnRevise" class="btn btn-primary"/>
			</div>
		</div>
	</section>
	<footer class="page-footer font-small bg-dark">
		<c:import url="http://localhost:8080/propofol_prj/common/jsp/footer.jsp"/>
	</footer>
</body>
</html>