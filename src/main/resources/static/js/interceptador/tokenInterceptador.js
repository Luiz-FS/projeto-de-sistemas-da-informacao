/**
 * Created by luiz on 22/03/17.
 */

app.factory("tokenInterceptador", function ($q, $location) {

    return {

        'request': function(config) {
            config.headers.Authorization = 'Bearer ' + localStorage.getItem("tokenUsuario");
            return config;
        },

        'responseError' : function (rejection) {

            if (rejection.status == 401) {
                $location.path("/login");
            }

            return $q.reject(rejection);
        }
    };
});