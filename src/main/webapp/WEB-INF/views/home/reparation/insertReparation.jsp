<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.materiel.Marque" %>
<%@ page import="mg.working.atelier_reparation.model.materiel.Type" %>
<%@ page import="mg.working.atelier_reparation.model.Technicien" %>
<%@ page import="mg.working.atelier_reparation.model.util.TypeReparation" %>
<%@ page import="mg.working.atelier_reparation.model.util.Composant" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<%
    List<Technicien> techniciens = (List<Technicien>) request.getAttribute("techniciens");

    List<TypeReparation> typeReparations = (List<TypeReparation>) request.getAttribute("typeReparations");

    List<Composant> composants = (List<Composant>) request.getAttribute("composants");

%>
<main id="main" class="main">

    <div class="pagetitle mb-5">
        <h1>Diagnostique</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Veuillez remplir le formulaire</h5>

                        <!-- Vertical Form -->
                        <form method="post" action="/client/ordi/save" class="row g-3">
                            <div class="col-sm-10">
                                <label for="technicien" class="form-label">Type</label>
                                <select name="technicien" id="technicien" class="form-select" >
                                    <option selected >Techniciens</option>
                                    <% for(Technicien technicien : techniciens) {%>
                                    <option value="<%=technicien.getId()%>"><%=technicien.getNom()%> <%=technicien.getPrenom()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-sm-10">
                                <label for="typeReparation" class="form-label">Type</label>
                                <select name="typeReparation" id="typeReparation" class="form-select" >
                                    <option selected >Type Reparation</option>
                                    <% for(TypeReparation typeReparation : typeReparations) {%>
                                    <option value="<%=typeReparation.getId()%>"><%=typeReparation.getLiblle()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-sm-10">
                                <label for="composant" class="form-label">Type</label>
                                <select name="composant" id="composant" class="form-select" >
                                    <option selected >Composants</option>
                                    <% for(Composant composant : composants) {%>
                                    <option value="<%=composant.getId()%>"><%=composant.getLibelle()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-12">
                                <label for="dateDebut" class="form-label">Date debut reparation</label>
                                <input name="dateDebut" type="date" class="form-control" id="dateDebut">
                            </div>
                            <div class="col-12">
                                <label for="cout" class="form-label">Cout</label>
                                <input type="number" class="form-control" id="cout" name="cout">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Valider</button>
                            </div>
                        </form><!-- Vertical Form -->

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