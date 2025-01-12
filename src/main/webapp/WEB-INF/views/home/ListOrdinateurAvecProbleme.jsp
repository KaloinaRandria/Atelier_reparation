<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VOrdinateurClient" %>
<%@ page import="mg.working.atelier_reparation.model.view.VProblemeOrdi" %>
<%--<%@ page import="mg.working.atelier_reparation.model.util.Probleme" %>--%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/sidebar.jsp"/>

<%
    List<VOrdinateurClient> ordinateurClients = (List<VOrdinateurClient>) request.getAttribute("ordinateurClients");

    List<VProblemeOrdi> problemeOrdis = (List<VProblemeOrdi>) request.getAttribute("problemeOrdi");
//    List<Probleme> problemes = (List<Probleme>) request.getAttribute("problemes");
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
                        <div class="row mb-3 mt-3">
                            <form method="get" action="/probleme/ordinateur">
                            <label class="col-sm-2 col-form-label">Veuillez choisir un Probleme</label>
                            <div class="col-sm-10">
                                <select name="idProbleme" class="form-select" >
                                    <option selected >Voir les anomalies ...</option>
<%--                                    <% for(Probleme probleme : problemes)  {%>--%>
<%--                                    <option value="<%=probleme.getId()%>"><%=probleme.getLibelle()%></option>--%>
<%--                                    <% } %>--%>
                                </select>
                            </div>
                                <div class="mt-2">
                                    <input class="btn btn-primary" type="submit" value="valider">
                                </div>
                            </form>
                        </div>
                        <% if(problemeOrdis == null || problemeOrdis.isEmpty()) { %>
                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Reference Client</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Ordinateur</th>

                            </tr>
                            </thead>
                            <tbody>
                            <% for (VOrdinateurClient vOrdinateurClient : ordinateurClients) {%>
                            <tr>
                                <th scope="row"><%=vOrdinateurClient.getIdClient()%></th>
                                <td><%=vOrdinateurClient.getNom()%> <%=vOrdinateurClient.getPrenom()%></td>
                                <th><%=vOrdinateurClient.getMarque()%> <%=vOrdinateurClient.getModele()%></th>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                        <!-- End Default Table Example -->
                        <% } if(problemeOrdis != null) { %>

                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Reference Client</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Ordinateur</th>
                                <th scope="col">Probleme</th>

                            </tr>
                            </thead>
                            <tbody>
                            <% for (VProblemeOrdi problemeOrdi : problemeOrdis) {%>
                            <tr>
                                <th><%=problemeOrdi.getIdClient()%></th>
                                <th><%=problemeOrdi.getNom()%> <%=problemeOrdi.getPrenom()%></th>
                                <th><%=problemeOrdi.getMarque()%> <%=problemeOrdi.getModele()%></th>
                                <th><%=problemeOrdi.getProbleme()%></th>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                        <!-- End Default Table Example -->
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main><!-- End #main -->

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/link/jsLink.jsp"/>
</body>
</html>