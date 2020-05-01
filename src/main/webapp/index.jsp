<!DOCTYPE html>
<html lang="pt-br">
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>App Water - Admin</title>
		
		<link href="./css/bootstrap.min.css" rel="stylesheet">
		<link href="./css/style.css" rel="stylesheet">
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
		
		<!-- Add to homescreen for Chrome on Android -->
	    <meta name="mobile-web-app-capable" content="yes">
	    <link rel="icon" sizes="192x192" href="favicon.ico">
	    <meta name="theme-color" content="#EB1E25">
	
	    <!-- Add to homescreen for Safari on iOS -->
	    <meta name="apple-mobile-web-app-capable" content="yes">
	    <meta name="apple-mobile-web-app-title" content="QRCode Mobile">
	    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
	    <link rel="apple-touch-icon-precomposed" href="favicon.ico">
	
	    <!-- Tile icon for Win8 (144x144 + tile color) -->
	    <meta name="msapplication-TileImage" content="favicon.ico">
	    <meta name="msapplication-TileColor" content="#EB1E25">
	</head>
	
	<body>
		<script src="./js/jquery.min.js"></script>
		<script src="./js/bootstrap.min.js"></script>

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.action">Water Admin</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Configuração <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="categoriaList.action">Categoria</a></li>
								<li><a href="produtoList.action">Produto</a></li>
							</ul>
						</li>
						
						<li><a href="contaList.action">Perfil</a></li>
						<li><a href="#">Ajuda</a></li>
					</ul>
			</div>
			</div>
		</nav>
		
		<div id="main" class="container-fluid">

		
		</div>
	</body>
	
</html>