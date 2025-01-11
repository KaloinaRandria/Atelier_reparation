<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VClientOrdinateurList" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<%
    List<VClientOrdinateurList> vClientOrdinateurLists = (List<VClientOrdinateurList>) request.getAttribute("vClientOrdinateurLists");
%>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste Client Avec leur Problemes</h1>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Default Table</h5>
                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Reference Client</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Ordinateur</th>
                                <th scope="col">Type d'Ordinateur</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <% for (VClientOrdinateurList v : vClientOrdinateurLists) {%>
                                    <tr>
                                        <td><%=v.getIdClient() %></td>
                                        <td><%=v.getNomClient()%> <%=v.getPrenomClient()%></td>
                                        <td><%=v.getMarque()%> <%=v.getModele()%></td>
                                        <td><%=v.getTypeOrdinateur()%></td>
                                        <td>
<%--                                         mankany am reparationController --%>
                                            <form method="get" action="">
                                                <input type="hidden" value="<%=v.getIdClient()%>">
                                                <input type="submit" value="Faire diagnostique" class="btn btn-success">
                                            </form>
                                        </td>
                                    </tr>

                                <% } %>
                            </tbody>
                        </table>
                        <!-- End Default Table Example -->
                    </div>
                </div>
            </div>
        </div>
    </section>

</main><!-- End #main -->

<jsp:include page="../../includes/footer.jsp"/>
<jsp:include page="../../includes/link/jsLink.jsp"/>
</body>
</html>