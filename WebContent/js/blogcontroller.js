app.controller('BlogController',function($scope,$rootScope,$location,BlogService){
	$scope.blog={ blogId:'',title:'',description:'', userId:'',status:''};	
	$scope.message;
	
	
	
	$scope.approveBlog=function(blogId){
		console.log('approved blog');
		BlogService.approveBlog(blogId)
		.then(function(response){			
				console.log('Blog approved..' +data);
				$scope.message="Blog accepted Successfully";
				getAllBlogs;
											
			},
			function(response){
				console.log('Blog failed...');
						
		})
	}
	

	$scope.rejectBlog=function(blogId){
		console.log('Reject blog');
		BlogService.rejectBlog(blogId)
		.then(function(response){			
				console.log('Blog rejected..' +data);
				$scope.message="Blog rejected Successfully";
				getAllBlogs;
											
			},
			function(response){
				console.log('Blog failed...');
						
		})
	}
	
	$scope.addBlog=function(){
		console.log('submit function in usercontroller');
		BlogService.addBlog($scope.blog)
		.then(function(response){			
				console.log('Blog added...');
				$scope.message="Blog Added Successfully";
				$location.path("/blog/");							
			},
			function(response){
				console.log('Blog failed...');
				$scope.message="Failed to add Blog";
				$location.path("/blog/");		
		})
	}
	
	
	function getAllBlogs(){
		console.log('entering get All blogs')
		BlogService.getAllBlogs()
		.then(function(response){
			console.log(response.status);
			$scope.blogs=response.data;  			
		},function(response){
			console.log('failed to get blogs' + response.status)
		})
	}
	getAllBlogs();
	
	function getnewBlogs(){
		console.log('entering new blogs')
		BlogService.getnewBlogs()
		.then(function(response){
			console.log(response.status); 
			$scope.nblogs=response.data;  
			
		},function(response){
			console.log('failed to get blogs' + response.status)
		})
	}
	getnewBlogs();
	
//    function approveBlog(){
//    	console.log('controller-->approveBlog called');
//        BlogService.approveBlog()
//                .then(
//                		getnewBlogs, 
//                        function(errResponse){
//                             console.error('Error while creating Blog.');
                      
            
//    }
    
//    function rejectBlog(){
//    	console.log('controller-->rejectBlog called');
//        BlogService.rejectBlog()
//                .then(
//                		getnewBlogs, 
//                        function(errResponse){
//                             console.error('Error while creating Blog.');
//                        } 
//            );
//    };

	/*

	$scope.registerUser=function(){
		console.log('entering register user')
        UserService.registerUser($scope.user)		
		.then(function(response){
			$scope.message="Successfully Registered";
			console.log("registration success" + response.status)
			$location.path("/login");
			
		}, function(response){
			console.log("registration failed" +  response.status)
			$scope.errmsg="Registration failed";
			$location.path("/register");
			
		})
	}
	
	$rootScope.logout=function(){
		console.log('logout function')	
		delete $rootScope.presentUser;
		UserService.logout()
		.then(function(response){
			console.log('logout successfully')
			$scope.message="Logged out - OK";
			$location.path('/default')
		},
		function(response){
			console.log(response.status)
		})
	}*/

	
})













