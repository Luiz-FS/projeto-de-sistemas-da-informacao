app.controller("controllerBuscaAnuncio", function($scope, $http, $location, $routeParams) {


    $scope.valorBusca;
    $scope.anuncios = [];
    $scope.mostrarAvaliacoes = false;
    $scope.anuncioAvaliado;
    
    (function () {
        $http({
            method:'GET',
            url:"http://" + location.host + "/anuncios"
       
        }).then(function (response) {
        	$scope.anuncios = response.data;

        }, function (response) {
            console.log(response.data);
        });
    })();

    $scope.contratarAnuncio = function (anuncio) {
       console.log("Abre O ANUNCIO DE ID"+anuncio.id);
    };

    $scope.calculaMediaAvaliacao = function (anuncio) {
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
    
    $scope.setAnuncioAvaliado = function(anuncio) {
    	 $scope.anuncioAvaliado = anuncio;
    };
    
    $scope.addAvaliacao = function() {
    	var avaliacao = {nota: $scope.notaAvaliacao,
    					comentarios: $scope.novaAvalicao}
    	
    	$http.post("http://" + location.host + "/anuncios/avaliacao/"+ $scope.anuncioAvaliado.id, avaliacao).success(function (data, status) {
    		$scope.anuncioAvaliado.avaliacoes.push(data);
    		
    		$("#modalAdicionarAvalicao").modal("hide");
    	
    		$scope.notaAvalicao = "";
    		$scope.novaAvalicao = "";
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
    };
});
