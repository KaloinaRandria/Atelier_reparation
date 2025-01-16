<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VReparationOrdinateur" %>
<%@ page import="mg.working.atelier_reparation.model.util.Composant" %>
<%@ page import="mg.working.atelier_reparation.model.materiel.Type" %>
<%@ page import="mg.working.atelier_reparation.model.util.TypeReparation" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<main id="main" class="main">
    <%
        List<VReparationOrdinateur> vReparationOrdinateurs = (List<VReparationOrdinateur>) request.getAttribute("vReparationOrdinateurs");
        List<Composant> composants = (List<Composant>) request.getAttribute("composants");
        List<Type> typeList = (List<Type>) request.getAttribute("typeOrdinateurs");
        List<TypeReparation> typeReparations = (List<TypeReparation>) request.getAttribute("typeReparations");
    %>

    <div class="pagetitle">
        <h1>Liste Des Reparations</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Rechercher</h5>

                        <!-- Vertical Form -->
                        <form method="get" action="/reparation/listTermine" class="row g-3">
                            <div class="col-sm-10">
                                <label for="typeOrdinateur" class="form-label">Type Ordinateur</label>
                                <select name="id_type_ordinateur" id="typeOrdinateur" class="form-select" >
                                    <option selected value="">Type Ordinateur</option>
                                    <% for (Type type : typeList) {%>
                                    <option value="<%=type.getId()%>"><%=type.getLibelle() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-sm-10">
                                <label for="typeReparation" class="form-label">Type Reparation</label>
                                <select name="id_type_reparation" id="typeReparation" class="form-select" >
                                    <option selected value="">Type Reparation</option>
                                    <% for (TypeReparation typeReparation : typeReparations) {%>
                                    <option value="<%=typeReparation.getId()%>"><%=typeReparation.getLiblle()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-sm-10">
                                <label for="composant" class="form-label">Composant</label>
                                <select name="id_composant" id="composant" class="form-select" >
                                    <option selected value="">Composants</option>
                                    <% for (Composant composant : composants) {%>
                                    <option value="<%=composant.getId()%>"><%=composant.getLibelle()%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-sm-5">
                                <input type="date" class="form-control mt-3 " name="dateRetour">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-success">rechercher</button>
                            </div>
                        </form><!-- Vertical Form -->

                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-12 ">
                <div class="card justify-content-center">
                    <div class="card-body">
                        <h5 class="card-title">Default Table</h5>
                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Reference Reparation</th>
                                <th scope="col">Reference Client</th>
                                <th scope="col">Ordinateur</th>
                                <th scope="col">Composant</th>
                                <th scope="col">Description</th>
                                <th scope="col">Cout (MDG)</th>
                                <th scope="col">Type d'Ordinateur</th>
                                <th scope="col">Type Reparation</th>
                                <th>date retrait</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for(VReparationOrdinateur vReparationOrdinateur : vReparationOrdinateurs) {%>
                            <tr>
                                <td><%=vReparationOrdinateur.getIdReparation() %></td>
                                <td><%=vReparationOrdinateur.getIdClient() %> |
                                    <%=vReparationOrdinateur.getNomClient() +" "+ vReparationOrdinateur.getPrenomClient()%> </td>
                                <td><%=vReparationOrdinateur.getMarque() +" "+vReparationOrdinateur.getModele() %></td>
                                <td><%=vReparationOrdinateur.getComposant()%></td>
                                <td><%=vReparationOrdinateur.getDescirption()%></td>
                                <td><%=vReparationOrdinateur.getCoutReparation()%></td>
                                <td><%=vReparationOrdinateur.getTypeOrdinateur()%></td>
                                <td><%=vReparationOrdinateur.getTypeReparation()%></td>
                                <td><%=vReparationOrdinateur.getDateRetrait()%></td>
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