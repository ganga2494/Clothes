app.factory('BlogService',function($http){
	var blogService=this;
	var BASE_URL="http://localhost:8026/web/"
	//var BASE_URL="http://172.23.170.91:1010/toygroup1"
	blogService.addBlog=function(blog){
		return $http.post(BASE_URL + "/blog",blog);
	};
	blogService.getAllBlogs=function(){
		return $http.get(BASE_URL + "/blog/Approved");
	};
	blogService.getnewBlogs=function(){
		return $http.get(BASE_URL + "/blog/new");
	};
	
	blogService.approveBlog=function(blogId){
		return $http.post(BASE_URL + '/approveblog/'+blogId)
		.then(
                function(response){
                    return response.data;
                }
        );
	};
	blogService.rejectBlog=function(blogId){
		return $http.get(BASE_URL + '/rejectblog/{id}'+blogId)
		.then(
                function(response){
                    return response.data;
                }
        );
	};
//	blogService.approveBlog=function(blogId){
//		return $http.get(BASE_URL + '/approveblog/'+blogId)
//		.then(
//                function(response){
//                    return response.data;
//                }
////                function(errResponse){
////                    console.error('Error while creating blog');
////                    return $q.reject(errResponse);
////                }
//        );
//}

//	   function approveBlog(){
//           return $http.get(BASE_URL+'/approveblog/'+'blogId')
//                   .then(
//                           function(response){
//                               return response.data;
//                           }, 
//                           function(errResponse){
//                               console.error('Error while creating blog');
//                               return $q.reject(errResponse);
//                           }
                  // );
  // }
       
//       function rejectBlog(){
//           return $http.get(BASE_URL+'/rejectblog/'+'blogId')
//                   .then(
//                           function(response){
//                               return response.data;
//                           }, 
//                           function(errResponse){
//                               console.error('Error while creating blog');
//                               return $q.reject(errResponse);
//                           }
//                   );
//   }

/*	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user);
	};
	
	userService.logout=function(){
		console.log('entering logout in userservice')		
		return $http.put(BASE_URL+"/logout");
	};*/
	
	return blogService;
})