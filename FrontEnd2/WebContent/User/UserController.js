myApp.controller("UserController",function($scope,$http,$window,$location,$rootScope,$cookieStore){
     
$scope.user={email:'',password:'',firstName:'',lastName:'',contactNumber:'',role:'',onlineStatus:''};
     
$scope.registerUser=function(){
    $http.post("http://localhost:9988/middlware/register",$scope.user).
    then(function(response){
                alert("Error in Registering User");
            },
            function(response){
                alert("User Registered Succesfully");
                $location.path("/login");
            })
     
     
    };
 
    $scope.loginFunc=function(){
        console.log('login function : '+$scope.user.email+' '+$scope.user.password);
        $http.post("http://localhost:9988/middlware/login",$scope.user).
        then(function(response){
                    console.log('Valid User');
                    $scope.user=response.data;
                    $rootScope.currentUser=response.data;
                    $cookieStore.put('userDetails',response.data);
                    console.log($rootScope.currentUser.role);
                     
                    $location.path('homePage');
                     
                },
                function(response){
                    alert("Email or Password is incorrect");
                    $location.path("/login");
                })
    };
     
    $rootScope.logout=function(){
        console.log('LogOut function');
        delete $rootScope.currentUser;
        $cookieStore.remove('userDetails');
        $location.path("logout");
    }
         

	$scope.fetchUser=function(){
	console.log('fetching User');
	$http.get("http://localhost:9988/middlware/getUserData").
	then(function(response){
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				
	});
};

$scope.updateUser=function(){
	$http.post("http://localhost:9988/middlware/updateUser",$scope.user).
	then(function(response){
				alert("User Updated Succesfully");
				$location.path("/viewProfile");
			},
			function(error){
				alert("Error in Updating user"+error);
				console.log(error);
			})
	
};
});



