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
					<a class="navbar-brand" href="#">Water Admin</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Configura��o <span class="caret"></span></a>
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

			<!-- #top -->
			<div id="top" class="row">
				<div class="col-md-3">
					<h2>Lista de categorias</h2>
				</div>
	
				<div class="col-md-6">
					<div class="input-group h2">
						<input name="data[search]" class="form-control" id="search"
							type="text" placeholder="Pesquisar Categorias"> <span
							class="input-group-btn">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
	
				<div class="col-md-3">
					<a href="page/categoria/create.jsp" class="btn btn-primary pull-right h2">Adicionar Categoria</a>
				</div>
			</div>

			<hr />
			<div id="list" class="row">
	
				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>ID</th>
								<th>Descri��o</th>
								<th>Situa��o</th>
								<th class="actions">A��es</th>
							</tr>
						</thead>
						<tbody>
							
							<s:iterator value="categoriaList" status="categoria">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="descricao" /></td>
								<td><s:if test="situacao == 1">Ativo</s:if><s:else>Inativo</s:else></td>
								<td class="actions">
									<a class="btn btn-success btn-xs" href="categoriaRetrieve.action?id=<s:property value="id" />">Visualizar</a> 
									<a class="btn btn-warning btn-xs" href="categoriaUpdate.action?submitType=updatedata&id=<s:property value="id" />">Editar</a> 
									<a class="btn btn-danger btn-xs" href="#" onclick="defineId(${id});" data-toggle="modal" data-target="#delete-modal">Excluir</a>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
	
				</div>
			</div>
			<!-- /#list -->

			<div id="bottom" class="row">
				<div class="col-md-12">
	
					<ul class="pagination">
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="#" rel="next">Pr�ximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->
	
				</div>
			</div>
			<!-- /#bottom -->
		
		</div>
	</body>
	
</html>