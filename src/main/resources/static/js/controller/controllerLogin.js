app.controller("controllerLogin", function($scope, $http) {

    $scope.token = "";
    $scope.mensagemLogin = "";
    
    $scope.autencitar = function () {

        $http.patch("http://" + location.host + "/login", $scope.usuario)
            .success(function (data, status) {

                console.log("Sucesso: " + status + ", " + data);
                $scope.token = data.token;
                localStorage.setItem("userToken", data.token);

                $scope.mensagemLogin = "Login feito com sucesso!";

            })
            .error(function (response) {
                $scope.mensagemLogin = "Login não efetuado!";

                console.log("Falha: " + response);
           });
    }
});
