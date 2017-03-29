app.controller("controllerBuscaAnuncio", function($scope, $http, $location, $routeParams) {


    $scope.valorBusca;
    $scope.anuncios = [];
    $scope.mostrarAvaliacoes = false;
    $scope.anuncioContratado;
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

    $scope.contratarAnuncio = function () {
    	if($scope.anuncioContratado.tipo === 'SERVICO') {
    		$scope.contratarAnuncioServico();
    	} else {
    		$scope.comprarAnuncio();
    	}
    };
    
    $scope.contratarAnuncioServico = function() {
    	$http.post("http://" + location.host + "/anuncios/data/"+  $scope.anuncioContratado.id, $scope.novaData).success(function (data, status) {
    		console.log(status);
    		$scope.comprarAnuncio();
    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
    };
    
    $scope.comprarAnuncio = function() {
    	$http.delete("http://" + location.host + "/anuncios/contrato/"+  $scope.anuncioContratado.id).success(function (data, status) {
    		console.log(status);
    		$("#modalContratarAnuncio").modal("hide");    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
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
    
    $scope.setAnuncioContratado = function(anuncio) {
    	 $scope.anuncioContratado = anuncio;
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
