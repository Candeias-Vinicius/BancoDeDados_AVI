<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:if test="${erro ne null}">
      <div class="alert alert-danger" role="alert">
  		${erro}
		</div>
</c:if>
 
<form method="post" action="/contatos/register"  >
	
    <input type="hidden" name="id" value="${contato.id}" >
    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" value="${contato.nome}"
        id="nome" name="nome" required >
    </div>
    <div class="form-group">
        <label for="telefone">Telefone</label>
        <input type="text" class="form-control" required value="${contato.telefone}"
               id="telefone" name="telefone">
    </div>
    <div class="form-group">
        <label for="celular">Celular</label>
        <input type="text" class="form-control" required value="${contato.celular}"
               id="celular" name="celular">
    </div>
    
    <div class="form-group">
        <label for="grupo">Grupo</label>
    	<select id="grupo" name="grupo">
    		<option value="">Selecione</option>
    		<option value="FAMILIA">FAMILIA</option>
    		<option value="AMIGOS">AMIGOS</option>
    		<option value="TRABALHO">TRABALHO</option>
    		<option value="OUTROS">OUTROS</option>
    	</select>
    </div>
    <button type="submit" class="btn btn-primary" >Salvar</button>
    
<script type="text/javascript">
	var erro = document.get
</script>
</form>
</div>
</body>
</html>