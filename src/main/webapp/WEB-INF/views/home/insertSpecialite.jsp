<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/sidebar.jsp"/>

<main id="main" class="main">

    <div class="pagetitle mb-5">
        <h1>Ajout Specialite </h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Insertion Specialite</h5>
                        <!-- Vertical Form -->
                        <form method="post" action="/home/specialite/save" class="row g-3">
                            <div class="col-12">
                                <label for="specialite" class="form-label">Ajouter une nouvelle specialite</label>
                                <input name="specialite" type="text" class="form-control" id="specialite">
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

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/link/jsLink.jsp"/>
</body>
</html>