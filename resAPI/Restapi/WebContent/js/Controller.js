var app=angular.module("app", []);
app.controller("Ctrl", function ($scope,$window, MyService) {
	
	MyService.getPersones().then(function(data){
		$scope.persones=data.data;
	});
	$scope.addperson=function(){
		console.log($scope.person);
		MyService.addPerson($scope.person);
		$window.location.reload();
	}
	$scope.deleteperson= function(id){
		MyService.deletPerson(id);
			//console.log(data.data);
			$window.location.reload();
	}
   
})
app.service("MyService",function($http){
	this.getPersones=function(){
		var response = $http({
			method:"GET",
			url:"http://localhost:8080/Restapi/resources/MyRestService/getAll"
		});
		return response;	
	}
	this.addPerson=function(data){
		var response=$http({
			method : "POST",
	        url : "http://localhost:8080/Restapi/resources/MyRestService/addPerson",
	        data : JSON.stringify(data),
	        //data: angular.toJson(data),
	        datatype:"json"
		});
		return response;
	}
	this.deletPerson =function(id){
		$http.delete("http://localhost:8080/Restapi/resources/MyRestService/delet/"+id);
	}
});