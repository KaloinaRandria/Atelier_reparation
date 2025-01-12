<%@ page import="java.util.List" %>
<%@ page import="mg.working.atelier_reparation.model.view.VClientOrdinateurList" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../../includes/link/cssLink.jsp"/>
<body>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/sidebar.jsp"/>

<%

%>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste Des Reparations</h1>
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
                                <th scope="col">Ordinateur</th>
                                <th scope="col">Type d'Ordinateur</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>

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