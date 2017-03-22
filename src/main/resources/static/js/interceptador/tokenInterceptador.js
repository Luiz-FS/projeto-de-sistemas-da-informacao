/**
 * Created by luiz on 22/03/17.
 */

app.factory("tokenInterceptador", function ($q, $location) {

    return {

        'request': function(config) {
            config.headers.Authorization = 'Bearer ' + localStorage.getItem("userToken");
            return config;
        },

        'reponseError' : function (rejection) {

            if (rejection.status == 401) {
                $location.path = "/login";
            }

            return response;
        }
    };
});