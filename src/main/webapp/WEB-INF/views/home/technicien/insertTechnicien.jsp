<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<main id="main" class="main">

    <div class="pagetitle mb-5">
        <h1>Ajout d'un nouveau Technicien</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Veuillez remplir le formulaire</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3" method="post" action="">
                            <div class="col-12">
                                <label for="nom" class="form-label">Nom</label>
                                <input name="nom" type="text" class="form-control" id="nom">
                            </div> <div class="col-12">
                            <label for="prenom" class="form-label">Prenom</label>
                            <input name="prenom" type="text" class="form-control" id="prenom">
                        </div>
                            <div class="col-12">
                                <label for="email" class="form-label">Email</label>
                                <input name="email" type="email" class="form-control" id="email">
                            </div>
                            <div class="row mb-3 mt-3">
                                <label class="col-sm-2 col-form-label">Veuillez choisir une specialite</label>
                                <div class="col-sm-10">
                                    <div class="custom-select position-relative">
                                        <select name="specialite" class="form-select" id="optionsSelect" size="4">
                                            <option class="mb-3" disabled>Rechercher une option...</option>
<%--                                            <% for (Marque marque : marqueList) {%>--%>
<%--                                            <option value="<%=marque.getId()%>"> <%=marque.getLibelle()%></option>--%>
<%--                                            <% } %>--%>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Suivant</button>
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