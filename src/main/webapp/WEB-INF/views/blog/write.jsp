<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<script src="${initParam.root}resources/ckeditor/ckeditor.js"></script>

<form action="${initParam.root}post" method="post">
	
	<label>카테고리</label>
	<select name="categoryId" class="form-control">
		<option>------카테고리를 선택하세요------</option>
		<c:forEach var="category" items="${categories}">
		<option value="${category.categoryId}">${category.name}</option>
		</c:forEach>
	</select><br>
	
	<label>제목</label>
	<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요"><br>
	
	<label>#태그</label>
	<input type="text" name="tags" class="form-control" placeholder="#태그를 등록하세요(미구현)"><br>
	
    <textarea name="content" id="editor1" rows="10" cols="80"></textarea>
    
    <label></label>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Post</button>
    <label></label>
    
</form>

<script src="${initParam.root}resources/js/application.js"></script>

<script>
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace( 'editor1',{
    	height:'400px',
    	'filebrowserImageUploadUrl':'/blog/post/imageUpload'
    });
    
    CKEDITOR.on('dialogDefinition', function( ev ){
        var dialogName = ev.data.name;
        var dialogDefinition = ev.data.definition;
      
        switch (dialogName) {
            case 'image': //Image Properties dialog
                //dialogDefinition.removeContents('info');
                dialogDefinition.removeContents('Link');
                dialogDefinition.removeContents('advanced');
                break;
        }
    });
</script>
