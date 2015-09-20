<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>아리보리's 블로그 - aribori.com</title>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="${initParam.root}resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${initParam.root}resources/css/styles.css" rel="stylesheet">
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
<!-- script references -->
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="${initParam.root}resources/js/bootstrap.min.js"></script>
<script src="${initParam.root}resources/js/scripts.js"></script>
</body>
</html>