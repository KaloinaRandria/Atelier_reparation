<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<main id="main" class="main">

    <div class="pagetitle mb-5">
        <h1>Ajout d'un nouveau Client</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Veuillez remplir le formulaire</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3">
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