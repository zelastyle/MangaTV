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
                <a href="/MangaTV/Servlet?action=Acceder">Entra/Registrate</a>
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
	<div id="form-container">
	<form action="/MangaTV/Servlet?action=Logeo" id="inicio" class="form" name="formulario-registro" method="post">
		<h2 class="form-title">INICIAR SESION</h2>
			<div>
				<div class="input-group">
					<input type="text" id="user" name="user" placeholder="Nombre de usuario" class="input-100" required>
					<input type="Password" id="user" name="pass" placeholder="Contraseña" class="input-100" required>
					<input type="submit" id="btn-submit" value="Entrar" name="enviar">
					<p class="form-link ">¿No tienes una cuenta?<a href="/MangaTV/Servlet?action=Registro" id="form-link-text">Registrate aqui.</a></p>
				</div>
			</div>
	</form>
    </div>
</body>
</html>