<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VOrdinateurClient" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<%
    List<VOrdinateurClient> vOrdinateurClients = (List<VOrdinateurClient>) request.getAttribute("vOrdinateurClients");

%>>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste Client</h1>
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
                                <th scope="col">Prenom</th>
                                <th scope="col">Mail</th>
                                <th scope="col">Marque</th>
                                <th scope="col">Modele</th>

                            </tr>
                            </thead>
                            <tbody>
                            <% for (VOrdinateurClient vOrdinateurClient : vOrdinateurClients) {%>
                            <tr>
                                <th scope="row"><%=vOrdinateurClient.getIdClient()%></th>
                                <td><%=vOrdinateurClient.getNom()%></td>
                                <td><%=vOrdinateurClient.getPrenom()%></td>
                                <td><%=vOrdinateurClient.getMail()%></td>
                                <td><%=vOrdinateurClient.getMarque()%></td>
                                <td><%=vOrdinateurClient.getModele()%></td>

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