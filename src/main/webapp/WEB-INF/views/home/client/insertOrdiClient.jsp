<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>
<main id="main" class="main">

    <div class="pagetitle mb-5">
        <h1>Ajout d'un nouveau Client (Information Sur l'Ordinateur)</h1>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Veuillez remplir le formulaire</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Select</label>
                                <div class="col-sm-10">
                                    <div class="custom-select position-relative">
                                        <select class="form-select" id="optionsSelect" size="4">
                                            <option class="mb-3" disabled>Rechercher une option...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                        <input type="text" class="form-control" id="searchInput" placeholder="Rechercher..." style="position: absolute; top: 0; left: 0; width: 100%; display: none;">
                                    </div>
                                </div>
                            </div>

                            <style>
                                .custom-select {
                                    position: relative;
                                }

                                .custom-select input {
                                    border-radius: 0.375rem; /* Correspond au style Bootstrap */
                                }

                                #optionsSelect {
                                    cursor: pointer;
                                }
                            </style>

                            <script>
                                const selectElement = document.getElementById("optionsSelect");
                                const searchInput = document.getElementById("searchInput");

                                // Afficher l'input lorsque le menu est ouvert
                                selectElement.addEventListener("focus", function () {
                                    searchInput.style.display = "block";
                                    searchInput.focus();
                                    selectElement.size = 4; // Afficher les options déroulantes
                                });

                                // Filtrer les options en fonction de l'entrée dans l'input
                                searchInput.addEventListener("input", function () {
                                    const filter = searchInput.value.toLowerCase();
                                    const options = selectElement.options;

                                    for (let i = 0; i < options.length; i++) {
                                        const optionText = options[i].text.toLowerCase();
                                        options[i].style.display = optionText.includes(filter) ? "" : "none";
                                    }
                                });

                                // Cacher l'input si le focus est perdu
                                searchInput.addEventListener("blur", function () {
                                    setTimeout(() => {
                                        searchInput.style.display = "none";
                                        selectElement.size = 1; // Réduire la taille
                                    }, 200); // Donne le temps de sélectionner une option
                                });

                                // Synchroniser la sélection de l'option avec le champ input
                                selectElement.addEventListener("change", function () {
                                    searchInput.value = selectElement.options[selectElement.selectedIndex].text;
                                });
                            </script>

                            <div class="col-12">
                                <label for="inputEmail4" class="form-label">Email</label>
                                <input type="email" class="form-control" id="inputEmail4">
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