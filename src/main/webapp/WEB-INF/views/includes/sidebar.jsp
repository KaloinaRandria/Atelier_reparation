<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="index.html">
                <i class="bi bi-grid"></i>
                <span>Tableau de bord</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Client</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/client/redirectList">
                        <i class="bi bi-circle"></i><span>Tous les Clients</span>
                    </a>
                </li>
                <li>
                    <a href="/client/redirectInsert">
                        <i class="bi bi-circle"></i><span>Ajout nouveau Client</span>
                    </a>
                </li>

            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-journal-text"></i><span>Services</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="">
                        <i class="bi bi-circle"></i><span>Nos Techniciens</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="bi bi-circle"></i><span>Ajout Nouveau Technicien</span>
                    </a>
                </li>
                <li>
                    <a href="/home/redirectMarque">
                        <i class="bi bi-circle"></i><span>Ajout Nouvelle marque</span>
                    </a>
                </li>
                <li>
                    <a href="/home/redirectSpecialite">
                        <i class="bi bi-circle"></i><span>Ajout Nouvelle specialite</span>
                    </a>
                </li>
                <li>
                    <a href="/composant/redirectInsert">
                        <i class="bi bi-circle"></i><span>Ajout Composant Du Mois</span>
                    </a>
                </li>
                <li>
                    <a href="/composantMois/redirectList">
                        <i class="bi bi-circle"></i><span>List Composant du Mois</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-layout-text-window-reverse"></i><span>Reparations</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/client/redirectList">
                        <i class="bi bi-circle"></i><span>En Attente</span>
                    </a>
                </li>
                <li>
                    <a href="/reparation/redirectList">
                        <i class="bi bi-circle"></i><span>En cours</span>
                    </a>
                </li>
                <li>
                    <a href="/reparation/listTermine">
                        <i class="bi bi-circle"></i><span>Termine</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Tables Nav -->

    </ul>

</aside><!-- End Sidebar-->