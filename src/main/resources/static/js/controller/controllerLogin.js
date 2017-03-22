/**
 * Created by luiz on 22/03/17.
 */

app.controller("controllerLogin", function($scope, $http) {

    $scope.usuario = {};
    
    $scope.token = "";
    
    $scope.autencitar = function () {

        $http.path("http://" + location.host + "/login", $scope.usuario)
            .then(function (response) {

                console.log("Sucesso" + response);
                $scope.token = response.data.token;
                localStorage.setItem("userToken", response.data.token);

            }, function (response) {
                console.log("falha", response)
            })       
    }
})