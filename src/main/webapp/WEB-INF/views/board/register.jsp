<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
</div>

<!-- Content Row -->
<h1 class="h3 mb-2 text-gray-800">Register</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
                                                               href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
    </div>
    <div class="card-body">
        <form action="/board/register" method="post">

            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Title</span>
                </div>
                <input type="text" name="title" class="form-control">
            </div>

            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Content</span>
                </div>
                <input type="text" name="content" class="form-control">
            </div>

            <div class="input-group input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text">Writer</span>
                </div>
                <input type="text" name="writer" class="form-control">
            </div>

            <div class="input-group input-group-lg">
                <button type="submit" class="btn btn-primary">submit</button>
            </div>

        </form>
    </div>
</div>



<%@include file="../includes/footer.jsp"%>

<script>
</script>

<%@include file="../includes/end.jsp"%>