var membershipManager = angular.module('MembershipManager', ['ngResource', 'ngRoute']);

membershipManager.controller('MembershipCtrl'
    , function ($scope, Member) {
        //var member = Member.get({ id: $scope.id }, function() {
        //    console.log(member);
        //}); // get() returns a single entry

        $scope.members = Member.query(function () {
        }); //query() returns all the entries

        $scope.addMember = function () { //create a new movie. Issues a POST to /api/movies
            var member = $scope.member.$save({id: $scope.member._id}, function () {
                //$state.go('movies'); // on success go back to home i.e. movies state.
            });
            member.then(function (data) {
                console.log(data);
            });
            $scope.members = Member.query(function () {
                console.log(members);
            }); //query() returns all the entries
        };
        $scope.removeMember = function (member) {
            Member.remove({id: member._id}, function () {
                $scope.members = Member.query(function () {
                }); //query() returns all the entries
            });
        }
    }
);
