<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="pt-br">
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>App Water - Admin</title>
		
		<link href="./css/bootstrap.min.css" rel="stylesheet">
		<link href="./css/style.css" rel="stylesheet">
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
					<a class="navbar-brand" href="#">Water Admin</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Início</a></li>
						<li><a href="#">Opções</a></li>
						<li><a href="#">Perfil</a></li>
						<li><a href="#">Ajuda</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div id="main" class="container-fluid">
 			<h3 class="page-header">Atualizar Entregador</h3>

			<form action="/water-admin/entregadorUpdate.action">

				<input type="hidden" name="entregador.id" value="${entregador.id}">
				
				<div class="row">
					<div class="form-group col-md-4">
						<label for="campo1">Nome</label>
						<input type="text" class="form-control" name="entregador.nome" value="${entregador.nome}">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="campo1">CPF</label>
						<input type="text" class="form-control" name="entregador.cpf" value="${entregador.cpf}">
					</div>

					<div class="form-group col-md-6">
						<label for="campo1">E-mail</label>
						<input type="text" class="form-control" name="entregador.email" value="${entregador.email}">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="campo1">CEP</label>
						<input type="text" class="form-control" name="entregador.endereco.cep" value="${entregador.endereco.cep}">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="campo1">Logradouro</label>
						<input type="text" class="form-control" name="entregador.endereco.logradouro" value="${entregador.endereco.logradouro}">
					</div>
					
					<div class="form-group col-md-6">
						<label for="campo1">Complemento</label>
						<input type="text" class="form-control" name="entregador.endereco.complemento" value="${entregador.endereco.complemento}">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="campo1">Bairro</label>
						<input type="text" class="form-control" name="entregador.endereco.bairro" value="${entregador.endereco.bairro}">
					</div>
					
					<div class="form-group col-md-6">
						<label for="campo1">Cidade</label>
						<input type="text" class="form-control" name="entregador.endereco.cidade" value="${entregador.endereco.cidade}">
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-4">
						<label for="campo1">Situação</label>
						<select name="entregador.situacao" class="form-control">
							<option value="" selected disabled hidden>Escolha uma situação</option>
							<option value="1" <s:if test="entregador.situacao == 1">selected</s:if> >Ativo</option>
							<option value="0" <s:if test="entregador.situacao == 0">selected</s:if> >Inativo</option>
						</select>
					</div>
				</div>
	
				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<a href="entregadorList.action" class="btn btn-default">Cancelar</a>
					</div>
				</div>
			</form>
			
		</div>

	</body>
	
</html>