app.controller("controllerBuscaAnuncio", function($scope, $http, CONFIGURACAO, ROTA, SUB_ROTA) {


    $scope.valorBusca;
    $scope.anuncios = [];
    $scope.mostrarAvaliacoes = false;
    $scope.anuncioContratado;
    $scope.anuncioAvaliado;
    
    (function () {
        $http({
            method:'GET',
            url: CONFIGURACAO.URL + ROTA.ANUNCIO
       
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
    	$http.post(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.ANUNCIO_DATA + "/"+  $scope.anuncioContratado.id, $scope.novaData).success(function (data, status) {
    		console.log(status);
    		$scope.comprarAnuncio();
    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
    };
    
    $scope.comprarAnuncio = function() {
    	$http.delete(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.ANUNCIO_CONTRATO + "/"+  $scope.anuncioContratado.id).success(function (data, status) {
    		console.log(status);
    		$("#modalContratarAnuncio").modal("hide");    	  	
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
    };
    
    $scope.getNotaAvaliacao = function(nota) {
    	if(nota === "NOTA_CINCO"){
            return 5;
        }else if(nota === "NOTA_QUATRO"){
            return 4;
        }else if(nota === "NOTA_TRES"){
            return 3;
        }else if(nota === "NOTA_DOIS"){
            return 2;
        }else if(nota === "NOTA_UM"){
            return 1;
        }else{
            return 0;
        }
    }

    $scope.calculaMediaAvaliacao = function (anuncio) {
    	var media = 0;
        var avaliacoes = anuncio.avaliacoes;
        
        if(avaliacoes.length == 0) {
        	return 0;
        }

        for (i = 0; i < avaliacoes.length; i++) { 
        	media += $scope.getNotaAvaliacao(avaliacoes[i].nota);	
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
    	
    	$http.post(CONFIGURACAO.URL + ROTA.ANUNCIO + SUB_ROTA.ANUNCIO_CADASTRO_AVALIACAO + "/"+ $scope.anuncioAvaliado.id, avaliacao).success(function (data, status) {
    		$scope.anuncioAvaliado.avaliacoes.push(data);
    		
    		$("#modalAdicionarAvalicao").modal("hide");
    	
    		$scope.notaAvalicao = "";
    		$scope.novaAvalicao = "";
    	
    	}).error(function (data, status){
    		console.log(status);
    	});
    };
    
    $scope.mostrarTodosAnunciosUsuario = function() {
    	 $http({
             method:'GET',
             url: CONFIGURACAO.URL + ROTA.ANUNCIO +"/usuario"
        
         }).then(function (response) {
         	console.log(response.status);
        	$scope.anuncios = response.data;

         }, function (response) {
             console.log(response.data);
         });
    };
    
    $scope.mostrarTodosAnuncios = function() {
   	 $http({
            method:'GET',
            url: CONFIGURACAO.URL + ROTA.ANUNCIO
       
        }).then(function (response) {
        	console.log(response.status);
        	$scope.anuncios = response.data;

        }, function (response) {
            console.log(response.data);
        });
   };
});
