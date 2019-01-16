myApp.filter('reverse', function() {
      return function(items) {
        return items.slice().reverse();
      };
    });
 
    myApp.directive('ngFocus', function() {
      return function(scope, element, attrs) {
        element.bind('click', function() {
          $('.' + attrs.ngFocus)[0].focus();
        });
      };
    });
     
myApp.factory('ChatService',function($rootScope){
     
    var socket=new SockJS("/middlware/chatmodule")
    var stompClient=Stomp.over(socket);
    stompClient.connect('','',function(frame){
        alert('in connect with service')
        $rootScope.$broadcast('sockConnected',frame)
    })
    return{
        stompClient:stompClient
    }
})