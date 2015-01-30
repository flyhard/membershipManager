var module = angular.module('MembershipManager');

module.factory('UserService', ['$http', '$q', function ($http, $q) {
    var getPrivileges = function () {
        var deferred = $q.defer();
        $http
            .get("/api/user/privileges")
            .success(function (data) {
                console.log(data);
                deferred.resolve(data);
            })
            .error(function (err) {
                console.log(err);
                deferred.reject(err);
            });
        return deferred.promise;
    };
    return {
        getPrivileges: function () {
            return getPrivileges();
        }
    };
}]);

