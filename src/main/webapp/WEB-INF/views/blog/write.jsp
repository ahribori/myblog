<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="${initParam.root}resources/ckeditor/ckeditor.js"></script>

<form action="${initParam.root}post" method="post">
	
	<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요"><br>

	<input type="text" name="tags" class="form-control" placeholder="#태그를 등록하세요(미구현)"><br>
	
    <textarea name="content" id="editor1" rows="10" cols="80"></textarea>
    
    <label></label>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Post</button>
    <label></label>
    
</form>

<script>
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace( 'editor1' );
</script>
