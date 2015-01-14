var module = angular.module('MembershipManager');

module.factory('Member', ['$resource', function ($resource) {
    return $resource('/api/member/:id');
}]);

module.factory('MemberService', ['Member', '$q', function (Member, $q) {
    var saveMember = function (member) { //create a new movie. Issues a POST to /api/movies
        var deferred = $q.defer();
        Member.save({id: member._id}, member, function (data) {
            //$state.go('movies'); // on success go back to home i.e. movies state.
            console.log(data);
            deferred.resolve(data);
        }, function (err) {
            deferred.reject(err);
        });
        return deferred.promise;
    };

    var getMembers = function () {
        var deferred = $q.defer();
        Member.query(function (members) {
            deferred.resolve(members);
        }, function (err) {
            deferred.reject(err);
        }); //query() returns all the entries
        return deferred.promise;
    };

    var getMember = function (params) {
        var deferred = $q.defer();
        Member.get({id: params.id}, function (member) {
            deferred.resolve(member);
        }, function (err) {
            deferred.reject(err);
        });
        return deferred.promise;
    };

    var removeMember = function (member) {
        var deferred = $q.defer();
        Member.remove({id: member._id}, function () {
            deferred.resolve()
        }, function (err) {
            deferred.reject(err);
        });
        return deferred.promise;
    };
    return {
        saveMember: function (member) {
            return saveMember(member);
        },
        getMembers: function () {
            return getMembers();
        },
        getMember: function (id) {
            return getMember(id);
        },
        removeMember: function (member) {
            return removeMember(member);
        }
    };
}]);