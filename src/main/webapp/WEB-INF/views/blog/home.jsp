<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- main col left --> 
<div class="col-sm-5">
 	
 	<div class="panel panel-default">
      <div class="panel-heading"><h4>아리보리's 블로그?</h4></div>
      	<div class="panel-thumbnail"><img src="${initParam.root}resources/images/home/aribori.jpg" class="img-responsive"></div>
     	<div class="panel-body">
	   	취업준비를 하게되면서 새로 시작하게 된 토비의 스프링 스터디와 함께,
	   	새로 시작하는 개인 프로젝트이다. 블로그를 하나 가지고 싶었는데, 개발자라면 적어도
	   	자신의 블로그 정도는 직접 만드는 것이 애착도 가고 의미 있을 것 같아서 시작하게 되었다.<br>
	   	블로그를 만들어 나가는 과정, 프로그래밍 스터디, 아리와 보리의 이야기, 피아노 연주 동영상 등을 포스팅 할 예정이다.
	   	</div>
    </div>
 	
 	<div class="panel panel-default">
      <div class="panel-heading"><h4>Powered By</h4></div>
     	<div class="panel-body">
	   	- Java 1.7<br>
	   	- Spring Framework 4.x.x<br>
	   	- MySQL 5.x or MariaDB<br>
	   	- MyBatis (Spring Data JPA or Hibernate와 고민중)<br>
	   	- Tiles<br>
	   	- BootStrap<br>
	   	- Maven<br>
	   	- require.js<br>
	   	- angular.js<br>
	   	- ElasticSearch<br><br>
	   	
	   	- 형상관리는 Git (Github) <a href="https://github.com/hs9923/myblog" target="_blank">https://github.com/hs9923/myblog</a><br>
	   	- Task 관리는 Trello, Google Drive
	   	</div>
    </div> 	
 	
    <div class="panel panel-default">
      <div class="panel-heading"><h4>본인소개</h4></div>
     	<div class="panel-body">
	   	<span class="label label-primary">정현승</span> 
		<span class="label label-success">27</span> 
		<span class="label label-info">남자</span> 
		<span class="label label-warning">백수</span> 
		<span class="label label-danger">취준생</span>
	   	</div>
    </div> 	
    
    <div class="panel panel-default">
      <div class="panel-heading"><h4>#태그</h4></div>
     	<div class="panel-body">
	   	<span class="label label-primary">#태그</span> 
		<span class="label label-success">#태그</span> 
		<span class="label label-info">#태그</span> 
		<span class="label label-warning">#태그</span> 
		<span class="label label-danger">#태그</span>
	   	<span class="label label-primary">#태그</span> 
		<span class="label label-success">#태그</span> 
		<span class="label label-info">#태그</span> 
		<span class="label label-warning">#태그</span> 
		<span class="label label-danger">#태그</span>
	   	<span class="label label-primary">#태그</span> 
		<span class="label label-success">#태그</span> 
		<span class="label label-info">#태그</span> 
		<span class="label label-warning">#태그</span> 
		<span class="label label-danger">#태그</span>
	   	<span class="label label-primary">#태그</span> 
		<span class="label label-success">#태그</span> 
		<span class="label label-info">#태그</span> 
		<span class="label label-warning">#태그</span> 
		<span class="label label-danger">#태그</span>
	   	</div>
    </div> 	

    <div class="well"> 
         <form class="form-horizontal" role="form">
          <h4>Contact Me!</h4>
           <div class="form-group" style="padding:14px;">
	        <input type="email" class="form-control" placeholder="연락받으실 E-Mail 주소를 입력하세요"><br>
            <textarea rows="6" class="form-control" placeholder="메세지를 입력하세요"></textarea>
          </div>
          <button class="btn btn-primary pull-right" type="button">보내기</button><ul class="list-inline"><li><a href=""></a></li></ul>
        </form>
    </div>
 	
</div>

<!-- main col right -->
<div class="col-sm-7">
	<!-- Post -->
	<c:forEach var="post" items="${listContainer.list}">
     <div class="panel panel-default">
       <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>#${post.postId}. ${post.title}</h4> 
       	<span class="label label-default">#태그1</span> 
		<span class="label label-primary">#태그2</span> 
		<span class="label label-success">#태그3</span> 
		<span class="label label-info">#태그4</span> 
		<span class="label label-warning">#태그5</span> 
		<span class="label label-danger">#태그6</span></div>
        <div class="panel-body">
          <p><img src="//placehold.it/150x150" class="img-circle pull-right"> <a href="${initParam.root}post/${post.postId}">${post.content}</a></p>
          <div class="clearfix"></div>
          <hr>
          <i class="glyphicon glyphicon glyphicon-eye-open"></i> ${post.hits}
          <i class="glyphicon glyphicon glyphicon glyphicon-comment"></i>
          <i class="glyphicon glyphicon glyphicon glyphicon-time"></i> ${post.regDate}
        </div>
     </div>
	</c:forEach>
    <!-- /Post -->
     <div class="panel panel-default">
       <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>Stackoverflow</h4></div>
        <div class="panel-body">
          <img src="//placehold.it/150x150" class="img-circle pull-right"> <a href="#">Keyword: Bootstrap</a>
          <div class="clearfix"></div>
          <hr>
          
          <p>If you're looking for help with Bootstrap code, the <code>twitter-bootstrap</code> tag at <a href="http://stackoverflow.com/questions/tagged/twitter-bootstrap">Stackoverflow</a> is a good place to find answers.</p>
          
          <hr>
          <form>
          <div class="input-group">
            <div class="input-group-btn">
            <button class="btn btn-default">+1</button><button class="btn btn-default"><i class="glyphicon glyphicon-share"></i></button>
            </div>
            <input type="text" class="form-control" placeholder="Add a comment..">
          </div>
          </form>
          
        </div>
     </div>

</div>