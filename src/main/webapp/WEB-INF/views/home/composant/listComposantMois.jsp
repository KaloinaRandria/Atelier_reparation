<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VClientOrdinateurList" %>
<%@ page import="mg.working.atelier_reparation.model.util.ComposantMois" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<%
    List<ComposantMois> composantMois = (List<ComposantMois>) request.getAttribute("composantMois");
    List<String> moisList = (List<String>) request.getAttribute("moisList");
%>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste Composant du Mois</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Rechercher</h5>

                        <!-- Vertical Form -->
                        <form method="get" action="/composantMois/list" class="row g-3">
                            <div class="col-sm-10 d-flex">
                                <select name="mois" id="mois" class="form-select w-50 h-50 mt-3" >
                                    <option value="">TOUS</option>
                                    <% int index = 1; for (String s : moisList) {%>
                                        <option <% if (request.getAttribute("mois") != null && ((String) request.getAttribute("mois")).compareTo(String.valueOf(index)) == 0) { %> selected <% }%> value="<%=index%>"><%=s%></option>
                                    <% index++; } %>
                                </select>
                                <input type="number" class="form-control mt-3 m-lg-3" name="annee" placeholder="annee" <%if(request.getAttribute("annee") != null){%> value="<%=request.getAttribute("annee")  %>" <%}%> >
                                <div class="text-center">
                                    <button type="submit" class="btn btn-success mt-3 m-lg-3">rechercher</button>
                                </div>
                            </div>

                        </form><!-- Vertical Form -->

                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Default Table</h5>
                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Reference Composant</th>
                                <th scope="col">nom Composant</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <tbody>
                                <%if (composantMois != null) {for (ComposantMois composantMois1 : composantMois) {%>
                                    <tr>
                                        <td><%=composantMois1.getComposant().getId() %></td>
                                        <td><%=composantMois1.getComposant().getLibelle() %></td>
                                        <td><%=composantMois1.getDate() %></td>
                                    </tr>
                                <% }

                                } %>
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