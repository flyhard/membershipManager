var membershipManager = angular.module('MembershipManager');

membershipManager.controller('MemberEditController', [
    '$scope', 'MemberService', '$location', '$routeParams',
    function ($scope, MemberService, $location, $routeParams) {
        $scope.member = {};

        if ($routeParams.id != null) {
            MemberService.getMember({id: $routeParams.id})
                .then(function (member) {
                    $scope.member = member;
                    console.log(member);
                });
        }

        $scope.saveMember = function () { //create a new movie. Issues a POST to /api/movies
            MemberService.saveMember($scope.member)
                .then(function () {
                    $scope.members = MemberService.getMembers();
                    $location.path("/showMembers");
                });
        };
    }]);