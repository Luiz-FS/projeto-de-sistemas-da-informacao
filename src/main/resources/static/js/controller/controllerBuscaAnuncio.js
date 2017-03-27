app.controller("controllerBuscaAnuncio", function($scope, $http, $location, $routeParams) {


    $scope.valorBusca;
    $scope.anuncios = [];


    $scope.contratarAnuncio = function (anuncio) {

        console.log("Abre O ANUNCIO DE ID"+anuncio.id);

    };

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


    $scope.calculaMediaAvaliacao = function (anuncio) {


        console.log(anuncio.avaliacoes);


        var media = 0;
        var avaliacoes = anuncio.avaliacoes;

        if(avaliacoes.length == 0){
            return 0;
        }

        for(avaliacao in avaliacoes){

            if(avaliacao.nota = "NOTA_CINCO"){
                media += 5;
            }else if(avaliacao.nota = "NOTA_QUATRO"){
                media += 4;
            }else if(avaliacao.nota = "NOTA_TRES"){
                media += 3;
            }else if(avaliacao.nota = "NOTA_DOIS"){
                media += 2;
            }else if(avaliacao.nota = "NOTA_UM"){
                media += 1;
            }else{
                media += 0;
            }


        }

        return media/avaliacoes.length;

    };




});
