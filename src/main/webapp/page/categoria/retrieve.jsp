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
		<script lang="javascript">
		
			function defineId(param) {
				var categoriaEl = document.querySelector('button#categoriaId');
				categoriaEl.setAttribute('onclick', 'sendFormDelete(' + param + ')');
			}
		
			function sendFormDelete(id) {
			    $.ajax({
			        url: "categoriaDelete.action",
			        type: "POST",
			        data: {'id': id},
			    	success: function() {  
			        	location = 'categoriaList.action';
			        	location.load();
			    	}
			    });
			}
		
		</script>
		
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
		
		<!-- Modal -->
		<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Excluir Categoria</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este item?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="categoriaId" onClick="sendFormDelete(<s:property value="id" />);">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal -->
		
		<div id="main" class="container-fluid">
 			<h3 class="page-header">Visualizar Categoria</h3>

			<form action="index.html">
				<div class="row">
					<div class="form-group col-md-4">
						<p><strong>Descrição</strong></p>
    					<p>${categoria.descricao}</p>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-4">
						<p><strong>Situação</strong></p>
    					<p><s:if test="categoria.situacao == 1">Ativo</s:if><s:else>Inativo</s:else></p>
					</div>
				</div>
	
				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<a href="categoriaList.action" class="btn btn-primary">Voltar</a>
						<a href="categoriaUpdate.action?submitType=updatedata&id=<s:property value="categoria.id" />" class="btn btn-default">Editar</a>
						<a href="#" onclick="defineId(${id});" class="btn btn-default" data-toggle="modal" data-target="#delete-modal">Excluir</a>
					</div>
				</div>
			</form>
			
		</div>

	</body>
	
</html>