<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- main col left --> 
<div class="col-sm-5">
 
    <div class="panel panel-default">
      <div class="panel-thumbnail"><img src="/assets/example/bg_5.jpg" class="img-responsive"></div>
      <div class="panel-body">
        <p class="lead">Urbanization</p>
        <p>45 Followers, 13 Posts</p>
        
        <p>
          <img src="https://lh3.googleusercontent.com/uFp_tsTJboUY7kue5XAsGA=s28" width="28px" height="28px">
        </p>
      </div>
    </div>

 
    <div class="panel panel-default">
      <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>Bootstrap Examples</h4></div>
        <div class="panel-body">
          <div class="list-group">
            <a href="http://bootply.com/tagged/modal" class="list-group-item">Modal / Dialog</a>
            <a href="http://bootply.com/tagged/datetime" class="list-group-item">Datetime Examples</a>
            <a href="http://bootply.com/tagged/datatable" class="list-group-item">Data Grids</a>
          </div>
        </div>
    </div>
 
    <div class="well"> 
         <form class="form-horizontal" role="form">
          <h4>What's New</h4>
           <div class="form-group" style="padding:14px;">
            <textarea class="form-control" placeholder="Update your status"></textarea>
          </div>
          <button class="btn btn-primary pull-right" type="button">Post</button><ul class="list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
        </form>
    </div>
 
    <div class="panel panel-default">
       <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>More Templates</h4></div>
        <div class="panel-body">
          <img src="//placehold.it/150x150" class="img-circle pull-right"> <a href="#">Free @Bootply</a>
          <div class="clearfix"></div>
          There a load of new free Bootstrap 3 ready templates at Bootply. All of these templates are free and don't require extensive customization to the Bootstrap baseline.
          <hr>
          <ul class="list-unstyled"><li><a href="http://www.bootply.com/templates">Dashboard</a></li><li><a href="http://www.bootply.com/templates">Darkside</a></li><li><a href="http://www.bootply.com/templates">Greenfield</a></li></ul>
        </div>
    </div>
 
    <div class="panel panel-default">
      <div class="panel-heading"><h4>What Is Bootstrap?</h4></div>
     	<div class="panel-body">
      	Bootstrap is front end frameworkto build custom web applications that are fast, responsive &amp; intuitive. It consist of CSS and HTML for typography, forms, buttons, tables, grids, and navigation along with custom-built jQuery plug-ins and support for responsive layouts. With dozens of reusable components for navigation, pagination, labels, alerts etc..                          </div>
    </div>
 	

    <div class="well"> 
       <form class="form">
        <h4>Sign-up</h4>
        <div class="input-group text-center">
        <input type="text" class="form-control input-lg" placeholder="Enter your email address">
          <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">OK</button></span>
        </div>
      </form>
    </div>
 	
</div>

<!-- main col right -->
<div class="col-sm-7">
	<!-- Post -->
	<c:forEach var="post" items="${listContainer.list}">
     <div class="panel panel-default">
       <div class="panel-heading"><a href="#" class="pull-right">View all</a> <h4>#${post.postId}. ${post.title} &amp; Code Library</h4> 
       	<span class="label label-default">#Default</span> 
		<span class="label label-primary">#Primary</span> 
		<span class="label label-success">#Success</span> 
		<span class="label label-info">#Info</span> 
		<span class="label label-warning">#Warning</span> 
		<span class="label label-danger">#Danger</span></div>
        <div class="panel-body">
          <p><img src="//placehold.it/150x150" class="img-circle pull-right"> <a href="#">The Bootstrap Playground</a></p>
          <div class="clearfix"></div>
          <hr>
          <i class="glyphicon glyphicon glyphicon glyphicon-time"></i>
          <i class="glyphicon glyphicon glyphicon-eye-open"></i>
          <i class="glyphicon glyphicon glyphicon glyphicon-comment"></i>
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