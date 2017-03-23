app.controller("controllerBuscaAnuncio", function($scope, $http, $location, $routeParams) {


    $scope.valorBusca;
    $scope.anuncios = [];


    $scope.buscaAll = function () {

        $http({

            method:'GET',
            url:"http://" + location.host + "/anuncios"



        }).then(function (response) {

            $scope.anuncios = response.data;

        }, function (response) {

            console.log(response.data);

        });


    };






});
