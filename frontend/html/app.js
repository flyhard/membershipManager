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
        .when("/addPayment/:id", {
            templateUrl: 'views/addPayment.html',
            controller: 'PaymentEditController'
        })
        .otherwise({
            redirectTo: '/showMembers'
        });
}]);

membershipManager.controller('MembershipCtrl'
    , ['$scope', 'UserService', 'MemberService', '$location', function ($scope, UserService, MemberService, $location) {
        //var member = Member.get({ id: $scope.id }, function() {
        //    console.log(member);
        //}); // get() returns a single entry
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };

        UserService.getPrivileges().then(function (data) {
            $scope.privileges = {
                isMemberAdmin: data.privileges.indexOf("MANAGE_MEMBERS") == -1,
                isPaymentManger: data.privileges.indexOf("MANAGE_PAYMENTS") == -1,
                mayListMembers: data.privileges.indexOf("LIST_MEMBERS") == -1
            };
            $scope.username = data.username;
        });

    }]
);
