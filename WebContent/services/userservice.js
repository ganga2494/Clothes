app.factory('UserService',function($http){
	var userService=this;
	var BASE_URL="http://localhost:8026/web/"
	//var BASE_URL="http://172.23.170.91:1010/toygroup1"
	userService.authenticate=function(user){
		return $http.post(BASE_URL + "/logincheck",user);
	};
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/candidatep",user);
	};
	
	userService.friend=function(userid){
		return $http.post(BASE_URL+'/addFriend/'+ userid);
	};
	
	userService.logout=function(){
		console.log('entering logout in userservice')		
		return $http.put(BASE_URL+"/logout");
	};
	
	userService.getUsers=function(){
		console.log('entering get users in userservice')		
		return $http.get(BASE_URL+"/candidate");
	};
		
	return userService;
})