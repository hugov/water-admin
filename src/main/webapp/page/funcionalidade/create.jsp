<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="pt-br">
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>App Water - Admin</title>
		
		<link href="./../../css/bootstrap.min.css" rel="stylesheet">
		<link href="./../../css/style.css" rel="stylesheet">
	</head>
	
	<body>
		<script src="./../../js/jquery.min.js"></script>
		<script src="./../../js/bootstrap.min.js"></script>

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
 			<h3 class="page-header">Adicionar Funcionalidade</h3>

			<form action="/water-admin/funcionalidadeCreate.action">

				<div class="row">
					<div class="form-group col-md-4">
						<label for="campo1">Descrição</label>
						<input type="text" class="form-control" name="funcionalidade.descricao">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-4">
						<label for="campo1">Situação</label>
						<select name="funcionalidade.situacao" class="form-control">
							<option value="" selected disabled hidden>Escolha uma situação</option>
							<option value="1">Ativo</option>
							<option value="0">Inativo</option>
						</select>
					</div>
				</div>
	
				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<a href="funcionalidadeList.action" class="btn btn-default">Cancelar</a>
					</div>
				</div>
			</form>
			
		</div>

	</body>
	
</html>