/**
 * Created by luiz on 22/03/17.
 */

app.controller("controllerLogin", function($scope, $http) {

    $scope.usuario = {};
    
    $scope.token = "";
    
    $scope.autencitar = function () {

        $http.path("http://" + location.host + "/login", $scope.usuario)
            .success(function (data, status) {

                console.log("Sucesso" + response);
                $scope.token = data.token;
                localStorage.setItem("userToken", data.token);

            })
            .error(function (response) {
                console.log("falha" + response);
            });
    }
})