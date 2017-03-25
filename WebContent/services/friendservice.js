app.factory('FriendService',function($http){
	var freindService=this;
	var BASE_URL="http://localhost:8026/web/"
	//var BASE_URL="http://172.23.170.91:1010/toygroup1"
		
	friendService.getFreindsreq=function(){
		return $http.get(BASE_URL + "/getMyFriendRequests/");
	};
	friendService.getallFreinds=function(){
		return $http.get(BASE_URL + "/myFriends");
	};
	
	
	
	friendService.accept=function(userId){
		return $http.get(BASE_URL + '/acceptFriend/'+userId)
		.then(
                function(response){
                    return response.data;
                }
        );
	};
	friendService.reject=function(userId){
		return $http.get(BASE_URL + '/rejectFriend/'+userId)
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
	
	return friendService;
})