<%--
  Created by IntelliJ IDEA.
  User: db970
  Date: 2024-12-11
  Time: 오후 10:30
  To change this template use File | Settings | File Templates.
--%>
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
<h1 class="h3 mb-2 text-gray-800">Tables</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
                                                               href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">

            <form id="actionForm" method="get" action="/board/list">
                <input type="hidden" name="pageNum" value="${cri.pageNum}">
                <input type="hidden" name="amount" value="${cri.amount}">
            </form>

            ${pageMaker}
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Bno</th>
                    <th>Title</th>
                    <th>Writer</th>
                    <th>RegDate</th>
                    <th>UpdateDate</th>
                </tr>
                </thead>
                <tbody class="tbody">
                    <c:forEach var="board" items="${list}">
                        <tr data-bno="${board.bno}">
                            <td><c:out value="${board.bno}" /></td>
                            <td><c:out value="${board.title}" /></td>
                            <td><c:out value="${board.writer}" /></td>
                            <td><c:out value="${board.regDate}" /></td>
                            <td><c:out value="${board.updateDate}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div>

                <ul class="pagination">
                    <c:if test="${pageMaker.prev}">
                    <li class="page-item">
                        <a class="page-link" href="${pageMaker.startPage - 1}" tabindex="-1">Previous</a>
                    </li
                    </c:if>

                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
                    <li class="page-item ${cri.pageNum == num ? 'active' : ''}">
                        <a class="page-link" href="${num}">${num} </a>
                    </li>
                    </c:forEach>

                    <c:if test="${pageMaker.next}">
                    <li class="page-item">
                        <a class="page-link" href="${pageMaker.endPage + 1}">Next</a>
                    </li>
                    </c:if>
                </ul>

            </div>
        </div>
    </div>
</div>

<div id="myModal" class="modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

                   

<%@include file="../includes/footer.jsp"%>

<script>
    const result = '${Result}'

    const myModal = new bootstrap.Modal(document.getElementById('myModal'), options)

    myModal.show();

    if(result){
        myModal.show()
    }

    const actionForm = document.querySelector("#actionForm")

    document.querySelector('.tbody').addEventListener("click", (e) => {
        const target = e.target.closest("tr")
        const bno = target.dataset.bno

        const before = document.querySelector("#clonedActionForm")

        if(before){
            before.remove()
        }

        const clonedActionForm = actionForm.cloneNode(true)
        clonedActionForm.setAttribute("action", `/board/read/\${bno}`)
        clonedActionForm.setAttribute("id", 'clonedActionForm')

        document.body.append(clonedActionForm)
        clonedActionForm.submit()
    }, false)

    document.querySelector(".pagination").addEventListener("click", (e) => {
        e.preventDefault()
        const target = e.target
        console.log(target)

        const targetPage = target.getAttribute("href")

        actionForm.setAttribute("action", "/board/list")
        actionForm.querySelector("input[name='pageNum'").value = target
        actionForm.submit()
    }, false)
</script>

<%@include file="../includes/end.jsp"%>