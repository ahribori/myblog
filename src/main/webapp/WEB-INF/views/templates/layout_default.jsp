<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<c:choose>
	<c:when test="${post!=null}">
	<title>아리보리's 블로그 - ${post.title}</title>
	</c:when>
	<c:otherwise>
	<title>아리보리's 블로그 - aribori.com</title>
	</c:otherwise>
	</c:choose>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="${initParam.root}resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${initParam.root}resources/css/styles.css" rel="stylesheet">
	
	<link rel="shortcut icon" href="${initParam.root}resources/images/home/favicon.ico" type="image/x-icon">
	
	<!-- script references -->
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="${initParam.root}resources/js/bootstrap.min.js"></script>
	<script src="${initParam.root}resources/js/scripts.js"></script>
	
	<c:if test="${serverMessage!=null}">
	<script type="text/javascript">
		alert('${serverMessage}');
	</script>
	</c:if>
	
</head>
<body>
<div class="wrapper">
	<div class="box">
		<div class="row row-offcanvas row-offcanvas-left">
			<!-- sidebar -->
			<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
			<!-- /sidebar -->
			
			<!-- main right col -->
            <div class="column col-sm-10 col-xs-11" id="main">
			<tiles:insertAttribute name="nav"></tiles:insertAttribute>
			
				<div class="padding">
            		<div class="full col-sm-9">
            			 <!-- content -->                      
                      	<div class="row">
						<tiles:insertAttribute name="content"></tiles:insertAttribute>
                      	</div>
					<tiles:insertAttribute name="footer"></tiles:insertAttribute>
            		</div>
				</div>
            </div>
		</div>
	</div>
</div>
</body>
</html>