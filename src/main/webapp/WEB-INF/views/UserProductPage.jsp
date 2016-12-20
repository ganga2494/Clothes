<%@include file="Header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>


<script>
	var adprod = ${pdata};

	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {

				$scope.adproduct = adprod;

			});
</script>
Session ID: <%=session.getId()%>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample">
	
<div ng-controller="repeatController">
	<div>
		search:<input type="text" placeholder="search category"
			ng-model="searchprd" /> <br>
		<br>
		<table class="table table-bordered table-hover table-striped">
<tr>
			<th>Product name</th>
			
				<th>Product Description</th>
				<th>Stock</th>
				<th>Price</th>

				<th>Image</th>
			</tr>
			<tr class="success" ng-repeat="ad in adproduct|filter:searchprd">

				<td>{{ad.aprodName}}</td>
				<td>{{ad.adesciption}}</td>
				<td>{{ad.astock}}</td>
				<td>{{ad.aprice}}</td>


				<td><a href="Single?adpid={{ad.aproductId}}"><img
						src="resources/images/{{ad.aproductId}}.jpg"
						style="width: 230px; height: 215px" /></a></td>

				




			</tr>
		</table>
	</div>
</div>



	<%@include file="Footer.jsp" %>