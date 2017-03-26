app.controller("controllerLogin", function($scope, $location, $http, loginService) {

    $scope.loginFalhou = false;
    
    $scope.autencitar = function () {

        $http.patch("http://" + location.host + "/login", $scope.usuario)
            .success(function (data, status) {
                $scope.loginFalhou = false;

                localStorage.setItem("tokenUsuario", data.token);

                console.log("Sucesso: " + status);

                $location.path("/busca");
               
                loginService.usuarioEstaLogado = true;
            })
            .error(function (response) {
                $scope.loginFalhou = true;

                console.log("Falha: " + response);
           });
    }
});
