var myApp = angular.module("myApp", ["ngRoute",,"ngCookies"]);

myApp.config(function($routeProvider) {
	$routeProvider
    .when("/", {
        templateUrl : "Main.html"
    })
    .when("/AboutUs", {
        templateUrl : "AboutUs.html"
    })
    .when("/ContactUs", {
        templateUrl : "ContactUs.html"
    })
    .when("/signup", {
        templateUrl : "User//SignUp.html"
    })
     .when("/login", {
        templateUrl : "User//Login.html"
    }).
    when("/homePage", {
    templateUrl : "HomePage.html"
    })
    .when("/logout", {
    templateUrl : "Main.html"
    })
	.when("/addBlog", {
	    templateUrl : "blog//BlogForm.html"
	    
	})
	.when("/viewBlogs", {
	        templateUrl : "blog//viewBlogs.html"
	})
	
	.when("/viewApprovedBlogs", {
	    templateUrl : "blog//ViewApprovedBlogs.html"

	})

	.when("/addJob", {
        templateUrl : "Job//JobForm.html"
    })
    
     .when("/viewJob", {
        templateUrl : "Job//ViewJobs.html"
    })
.when("/UploadProfilePic", {
    templateUrl : "User//UpdateProfilePic.html"
})
.when("/viewProfile", {
    templateUrl : "User//ViewProfile.html"
})
.when("/updateProfile", {
    templateUrl : "User//UpdateProfile.html"
})
 

.when("/suggestedusers",{
	templateUrl:"User//SuggestedUsers.html"
	
})
.when("/pendingrequests",{
	templateUrl:"User//PendingRequests.html"
	
})
.when("/friends",{
	templateUrl:"User//FriendsList.html"
	
})
	


.when('/chat',{
    templateUrl:"User/ChatRoom.html",
    controller:'ChatController'
     
});

});
	myApp.run(function($rootScope,$cookieStore){
		console.log('I m in run function');
		console.log($rootScope.currentUser);
		
		if($rootScope.currentUser==undefined){
			console.log('current User is undefined');
			$rootScope.currentUser=$cookieStore.get('userDetails');
		}
		else {
			console.log($rootScope.currentUser.email);
			console.log($rootScope.currentUser.role);
		}
		
	});
