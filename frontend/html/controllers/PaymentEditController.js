var ctrl = angular.module('MembershipManager');

ctrl.controller('PaymentEditController',
    ['$routeParams', 'MemberService', '$scope', function ($routeParams, MemberService, $scope) {
        if ($routeParams.id != null) {
            MemberService.getMember({id: $routeParams.id})
                .then(function (member) {
                    $scope.member = member;
                    console.log(member);
                });
        }
        $scope.payment = {
            date: new Date(),
            year: new Date().getFullYear(),
            registeredBy: $scope.username
        };
        $scope.savePayment = function () {
            $scope.payment.registeredBy = $scope.username;
            if ($scope.member.payments == null) {
                $scope.member.payments = [];
            }
            $scope.member.payments.push($scope.payment);
        }
    }]);

