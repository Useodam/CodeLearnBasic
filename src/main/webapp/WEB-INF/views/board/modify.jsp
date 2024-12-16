<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Board READ</h6>
    </div>
    <div class="card-body">
        <form id="actionform" action="/board/modify" method="post">
        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Bno</span>
            </div>
            <input type="text" name="bno" class="form-control" value="<c:out value="${vo.bno}"/>" readonly>
        </div>

        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Title</span>
            </div>
            <input type="text" name="title" class="form-control" value="<c:out value="${vo.title}"/>" >
        </div>

        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Content</span>
            </div>
            <input type="text" name="content" class="form-control" value="<c:out value="${vo.content}"/>" >
        </div>

        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">Writer</span>
            </div>
            <input type="text" class="form-control" value="<c:out value="${vo.writer}"/>" readonly>
        </div>

        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text">RegDate</span>
            </div>
            <input type="text" class="form-control" value="<c:out value="${vo.regDate}"/>" readonly>
        </div>
        </form>

        <div class="input-group input-group-lg">
            <button type="submit" class="btn btn-info btnList">LIST</button>
            <button type="submit" class="btn btn-warning btnModify">Modify</button>
            <button type="submit" class="btn btn-danger btnRemove">Remove</button>
        </div>



<%@include file="../includes/footer.jsp"%>

<script>

    const bno = `${vo.bno}`
    const actionForm = document.querySelector("#actionForm")

    document.querySelector(".btnList").addEventListener("click", (e) => {
        window.location="/board/list"
    }, false)

    document.querySelector(".btnModify").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionForm.action= `/board/modify/\${bno}`
        actionForm.method = 'post'
        actionForm.submit()
    }, false)

    document.querySelector(".btnRemove").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionForm.action= `/board/remove/\${bno}`
        actionForm.method = 'post'
        actionForm.submit()
    }, false)



</script>

<%@include file="../includes/end.jsp"%>