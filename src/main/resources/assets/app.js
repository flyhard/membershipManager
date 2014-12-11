var membershipManager = angular.module("MembershipManager", ['ngResource']);

membershipManager.controller("MembershipCtrl", function ($scope,$resource) {
    var memberResource = $resource("/member/:memberId", {memberId: '@id'});
    $scope.member = memberResource.get({memberId:1});
});