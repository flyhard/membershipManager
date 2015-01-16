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

        $scope.cancelEditMember = function () {
            $location.path("/showMembers");
        };

        $scope.addEmail = function () {
            var newEmail = $scope.newEmail;
            if ($scope.member.alternativeAddresses == null) {
                $scope.member.alternativeAddresses = [];
            }
            $scope.$applyAsync(function () {
                var alternativeAddresses = $scope.member.alternativeAddresses;
                var found = false;
                angular.forEach(alternativeAddresses, function (alt) {
                    if (alt.email == newEmail) {
                        found = true;
                    }
                });
                if (!found) {
                    alternativeAddresses.push({email: newEmail, primary: false});
                }
            });
        };

        $scope.makePrimary = function (altEmail) {
            var oldPrimary = $scope.member.emailAddress;

            $scope.member.emailAddress = altEmail.email;
            altEmail.primary = true;

            var alternativeAddresses = $scope.member.alternativeAddresses;
            var found = false;
            angular.forEach(alternativeAddresses, function (alt) {
                if (alt.email == oldPrimary) {
                    alt.primary = false;
                    found = true;
                }
            });

            if (!found) {
                alternativeAddresses.push({email: oldPrimary, primary: false});
            }
        };

        $scope.removeEmail = function (altEmail) {
            var alternativeAddresses = $scope.member.alternativeAddresses;
            var index = alternativeAddresses.indexOf(altEmail);
            alternativeAddresses.splice(index, 1);
        };


    }]);