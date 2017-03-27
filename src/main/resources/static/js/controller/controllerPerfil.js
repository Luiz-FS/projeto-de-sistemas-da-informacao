/**
 * Created by luiz on 26/03/17.
 */

app.controller("controllerPerfil", function ($scope, $http, CONFIGURACAO ,ROTA, SUB_ROTA) {

    $scope.usuarioLogado = {};


    $http.get(CONFIGURACAO.URL + ROTA.USUARIO + SUB_ROTA.PERFIL).success(function (data, status) {
        $scope.usuarioLogado = data;
        console.log(status);
        console.log(data)
    })
})