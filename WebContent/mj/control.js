var app=angular.module("myApp",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	console.log('entering configuration')		
	$routeProvider
	.when('/login',{		
		controller:'UserController',
		templateUrl:'template/login.html'
	})	
	.when('/register',{ // $scope.user, $scope.register() -- local for this page
		controller:'UserController',
		templateUrl:'template/register.html'
	})
	.when('/displayUsers',{
		controller:'UserController',
		templateUrl:'template/displayusers.html'
	})	
	.when('/home',{
		controller:'UserController',
		templateUrl:'template/home.html'
	})
	.when('/postjob',{
		controller:'JobController',
		templateUrl:'template/createJob.html'
	})	
	.when('/getAllJobs',{		
		controller:'JobController',
		templateUrl:'template/displayjobs1.html'
	})	
	.when('/reqAddBlog',{		
		controller:'BlogController',
		templateUrl:'template/addBlog.html'
	})	
	.when('/reqDisplayBlogs',{		
		controller:'BlogController',
		templateUrl:'template/displayBlogs.html'
	})	
	.when('/reqDisplaynewBlogs',{		
		controller:'BlogController',
		templateUrl:'template/displaynew.html'
	})	
	.when('/uploadPicture',{	
		templateUrl:'template/uploadPicture.html'
	})		
	.when("/chat",
	{
		templateUrl:"template/chat.html",
	controller:'chatController'
	})
	.when("/friendrequest.view",
	{
		templateUrl:"template/friendrequest.view.html",
	controller:'FriendController'
	}).when("/searchfriend.view",
	{
		templateUrl:"template/searchfriend.view.html",
	controller:'FriendController'
	}).when("/viewfriend.view",
	{
		templateUrl:"template/viewfriend.view.html",
	controller:'FriendController'
	})
	.when('/jobreg',{
		controller:'JobController',
		templateUrl:'template/jobreg.html'
	})	
	.otherwise({
		templateUrl:'_default/default.html'
	})
	
})



app.run(function($cookieStore,$rootScope,$location,UserService){  //entry point
	
	if($rootScope.presentUser==undefined)
		$rootScope.presentUser=$cookieStore.get('presentUser')
		
	$rootScope.logoff=function(){
		console.log('logout function')
		delete $rootScope.presentUser;
		$cookieStore.remove('presentUser')
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$rootScope.message="Logged out Successfully";
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
		
	}	
})









/*

.when('/logout',{		
		controller:'UserController',
		templateUrl:'_user/login.html'
	})	*/