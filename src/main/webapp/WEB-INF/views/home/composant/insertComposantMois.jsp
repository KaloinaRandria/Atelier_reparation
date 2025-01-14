<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.util.Composant" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<main id="main" class="main">
    <%
        List<Composant> composants = (List<Composant>) request.getAttribute("composants");


    %>

    <div class="pagetitle mb-5">
        <h1>Ajout Composant du Mois </h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Insertion Composant Recommande</h5>
                        <!-- Vertical Form -->
                        <form method="post" action="/composant/save" class="row g-3">
                            <div class="col-sm-10">
                                <label for="composant" class="form-label">Composant</label>
                                <select name="composant" id="composant" class="form-select" >
                                    <option selected value="">Composant</option>
                                    <% for(Composant composant : composants) {%>
                                        <option value="<%=composant.getId()%>"><%=composant.getLibelle()%></option>
                                    <% } %>
                                </select>
                            <div class="col-12 mb-3">
                                <label for="date" class="form-label">Date</label>
                                <input name="date" type="date" class="form-control" id="date">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Inserer</button>
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