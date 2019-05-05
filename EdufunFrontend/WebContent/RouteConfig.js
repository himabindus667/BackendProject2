var myApp=anjular.module("myApp",['ngRoute']);
myApp.config(function($routeProvider)
		{
	     alert("I am in Config function with Route Provider");
	     
	     $routeProvider.when("/",{templateUrl:"index.html"})
	     .when("/login",{templateUrl:"c_user/Login.html"})
	     .when("/register",{templateUrl:"c_user/Register.html"})
	     .when("/home",{templateUrl:"c_user/Home.html"});
	     
	
		});
		









