
<%@page language="java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<div class="container">
    <%@include file="sideBar.jsp"%>
    <main>


        <h1>The the dashboard page</h1>
        <%=request.getAttribute("Hi")%>
    </main>
</div>

<script>
    function showContent(contentId) {
        var sections = document.querySelectorAll('main section');
        sections.forEach(function(section) {
            section.classList.add(['hidden', 'active']);
        });

        var selectedSection = document.getElementById(contentId);
        if (selectedSection) {
            selectedSection.classList.add('visible');
            selectedSection.classList.remove('hidden');
        }
    }

    function logout() {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/logout', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                window.location.href = '/login';
            }
        };
        xhr.send();
    }
</script>

</body>
</html>
