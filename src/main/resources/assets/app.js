var membershipManager = angular.module('MembershipManager', ['ngResource', 'ngRoute']);

membershipManager.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode(false);
}]);

membershipManager.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when("/showMembers", {
            templateUrl: 'views/showMembers.html',
            controller: 'MemberListController'
        })
        .when("/addMember", {
            templateUrl: 'views/addMember.html',
            controller: 'MemberEditController'
        })
        .when("/editMember/:id", {
            templateUrl: 'views/addMember.html',
            controller: 'MemberEditController'
        })
        .otherwise({
            redirectTo: '/showMembers'
        });
}]);

membershipManager.controller('MembershipCtrl'
    , ['$scope', 'Member', 'MemberService', '$location', function ($scope, Member, MemberService, $location) {
        //var member = Member.get({ id: $scope.id }, function() {
        //    console.log(member);
        //}); // get() returns a single entry
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };

    }]
);
