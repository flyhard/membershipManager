var membershipManager = angular.module('MembershipManager');

membershipManager.controller('MemberListController', ['$scope', 'MemberService', '$location', function ($scope, MemberService, $location) {

    MemberService.getMembers()
        .then(function (members) {
            $scope.members = members
        }
    );

    $scope.removeMember = function (member) {
        MemberService.removeMember(member)
            .then(function () {
                return MemberService.getMembers();
            })
            .then(function (members) {
                $scope.members = members
            }
        );
    };

    $scope.editMember = function (member) {
        $location.path("/editMember/" + member._id);
    };
}])
;