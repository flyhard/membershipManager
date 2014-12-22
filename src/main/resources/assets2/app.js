var app = angular.module("TestApp", []);

app.controller('AppCtrl', function ($scope) {
    $scope.tasks = [{desc: 'Task 1', completed: false}];
    $scope.task = {completed: false};

    $scope.add = function () {
        $scope.tasks.push($scope.task);
        $scope.task = {};
    }
});
