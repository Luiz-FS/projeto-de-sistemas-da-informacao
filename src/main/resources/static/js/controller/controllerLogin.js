app.controller("controllerLogin", function($scope, loginService) {

    $scope.loginFalhou = function() {
       	return loginService.getLoginFalhou();
    };
        
    $scope.autencitar = function () {
    	loginService.login($scope.usuario);
    };
});
