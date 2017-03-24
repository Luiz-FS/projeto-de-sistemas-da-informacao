app.controller("controllerLogin", function($scope, $http) {

    $scope.loginFalhou = false;
    
    $scope.autencitar = function () {

        $http.patch("http://" + location.host + "/login", $scope.usuario)
            .success(function (data, status) {
                $scope.loginFalhou = false;

                console.log("Sucesso: " + status);
            })
            .error(function (response) {
                $scope.loginFalhou = true;

                console.log("Falha: " + response);
           });
    }
});
