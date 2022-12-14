<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/commun.css">
<link rel="icon" href="img/favicon.ico" />


</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="welcome" class="navbar-brand active"> <span
					class="glyphicon glyphicon-education"></span>
				</a>

				<a href="welcome" class="navbar-brand active"> <span
					class="glyphicon glyphicon-education"></span>
				</a>				
				
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<c:if test="${!empty userInSession}">
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="deconnexion"><spring:message
									code="welcome.disconnection" /> </a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${empty userInSession}">
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="connexion"><spring:message
									code="welcome.connection" /> </a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<div class="row align-items-cente">
				<h2 class="text-center">U : ${userInSession} Lister des Ench?res</h2>
				</br>
				<form:form cssClass="form-horizontal" method="POST" action="rechercher">
					<div class="col col-lg-6 col-md-12">
						<div class="col-12">
							<label for="exampleDataList" class="form-label">Filtres :</label>
							<input class="form-control" list="datalistOptions"
								id="exampleDataList" placeholder="Le nom de l'article ncontient">
							<datalist id="datalistOptions">
								<option value="San Francisco">
								<option value="New Yorc">
								<option value="Seattle">
								<option value="Los Angeles">
								<option value="Chicago">
							</datalist>
						</div>
						<div class="col-12">
							<select class="form-select" aria-label="Default select example">
								<option selected>Toutes</option>
								<option value="1">One</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
							</select>
						</div>

					</div>
					<div class="col col-lg-6 col-md-12">
						<button type="submit" class="btn btn-primary mb-3">Rechercher</button>
					</div>
				</form:form>
			</div>

			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="..." class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h4 class="card-title">NomerrrrrrrrrArticle : </h4>
							<h5 class="card-title">prix : </h5>
							<h5 class="card-title">Fin de l'ench?re : </h5>
							<p class="card-text">vendeur : </p>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
	<jsp:include page="footer.jsp" />
</html>