<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<title>PAGINA DE INICIO</title>
</head>
<body>
	<header>
        <div id="mini-nav">
            <div id="left">
                <a href="https://es-es.facebook.com/" target="_blank"><img src="img/facebook.png"/>Facebook</a>
                <a href="https://www.instagram.com/?hl=es" target="_blank"><img src="img/instagram.png"/>Instagram</a>
            </div>
            <div id="right">
            <%
            if(session.getAttribute("nombre") != null && session.getAttribute("apellido") != null && session.getAttribute("email") != null 
            && session.getAttribute("nick") != null && session.getAttribute("rol") != null){	
            %>
            
             <a href="/MangaTV/Servlet?action=Perfil"><img src="img/cuenta.png"/>Perfil</a>
            
            <%
            } else {
            	%>
            	<a href="/MangaTV/Servlet?action=Acceder">Entra/Registrate</a>
            	
            <%
            }
            %>
            	
                <a href="">Ayuda</a>
                <a href=""><img src="img/Carrito.png"/></a>
            </div>
        </div>
        <nav>
            <div id="logo"><img src="fondo/logo2.png"/></div>
            <ul>
                <li>
                    <a href="/MangaTV/Servlet?action=Home">Novedades</a>
                    <a href="/MangaTV/Servlet?action=Mangas">Mangas</a>
                    <a href="/MangaTV/Servlet?action=Merca">Merchandising</a>
                </li>
            </ul>
            <div id="buscador">
                <input type="text" placeholder="Buscar..." maxlength="225" id="searchBar"/>
            </div>
        </nav>
    </header>
</body>
</html>