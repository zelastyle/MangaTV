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
	
	<form action="/MangaTV/Servlet?action=insertarRegistro" id="registrarse" name="formulario" method="post" class="form">
		<h2 class="form-title">CREAR UNA CUENTA</h2>
		<div>
			<div class="input-group">
				<input type="text" id="nombre" name="nombre" placeholder="Nombre" class="input-50">
				<input type="text" id="apellido" name="apellido" placeholder="Apellido" class="input-50" >
				<input type="email" id="email" name="email" placeholder="E-mail" class="input-100" >
				<input type="password" id="pass" name="pass" placeholder="Contraseña" class="input-50" >
				<input type="password" id="pass2" name="pass2" placeholder="Contraseña" class="input-50" >
				<input type="text" id="user" name="user" placeholder="Nombre de usuario" class="input-100" >
				<input type="submit" id="btn-submit" value="Registrarse" name="registrar">
				<p class="form-link ">¿Ya tienes una cuenta?<a href="/MangaTV/Servlet?action=Acceder" id="form-link-text">Entra aqui.</a></p>
			</div>
		</div>
	</form>
	</div>
	<script src="js/validarRegistro.js"></script>
</body>
</html>