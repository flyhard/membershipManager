var membershipManager = angular.module("MembershipManager", ['ngResource', 'ngRoute']);

membershipManager.controller('MembershipCtrl'
    , ["$scope", "$resource", "$route", "Member"
        , function ($scope, $resource, $route, Member) {
            //var memberResource = $resource("/member/:memberId", {memberId: '@id'});
            //$scope.member = memberResource.get({memberId: 1});

            $scope.save = function (member) {
                if ($scope.member._id) {
                    Post.update({_id: $scope.member._id}, $scope.member);
                } else {
                    $scope.member.$save().then(function (response) {
                        $scope.member.push(response)
                    });
                }
                $scope.member = new Member();
                $scope.editing = false;
            }
        }
    ]
);