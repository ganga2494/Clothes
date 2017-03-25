app.controller('FriendController',function($scope,$rootScope,$location,FreindService){
	$scope.friend={ id:'',userId:'',friendId:'', status:'',isOnline:''};	
	//$scope.user={userid:'',username:'',password:'',isonlie:'',role:'',fullname:'',emailid:'',mobileno:'',address:'',city:'',state:'',country:''};	
	$scope.message;
	
	$scope.accept=function(userId){
		console.log('friend accept');
		FriendService.accept(userId)
		.then(function(response){			
				console.log('Friend  accepted..' +data);
				$scope.message="Friend accepted Successfully";
				getallFriends;
											
			},
			function(response){
				console.log(' failed...');
						
		})
	}
	

	$scope.reject=function(userId){
		console.log('Reject friend');
		FriendService.reject(userId)
		.then(function(response){			
				console.log('friend rejected..' +data);
				$scope.message="friend rejected Successfully";
				getallFriends;
											
			},
			function(response){
				console.log(' failed...');
						
		})
	}
	
	
	
	
	function getFriendsreq(){
		console.log(' get  friend req')
		FriendService.getFriendsreq()
		.then(function(response){
			console.log(response.status);
			$scope.friendsr=response.data;  			
		},function(response){
			console.log('failed to get friends req' + response.status)
		})
	}
	getFriendsreq();
	
	function getallFriends(){
		console.log('entering all friends')
		FriendService.getallFriends()
		.then(function(response){
			console.log(response.status); 
			$scope.nfriends=response.data;  
			
		},function(response){
			console.log('failed to get  all friends ' + response.status)
		})
	}
	getallFriends();
	
})