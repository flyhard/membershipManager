var membershipManager = angular.module('MembershipManager', ['ngResource', 'ngRoute']);

membershipManager.controller('MembershipCtrl'
    , function ($scope, $resource, Member) {
        var member = Member.get({ id: $scope.id }, function() {
            console.log(member);
        }); // get() returns a single entry

        var members = Member.query(function() {
            console.log(members);
        }); //query() returns all the entries

        $scope.member = new Member(); //You can instantiate resource class

        $scope.member.name = 'some data';

        Member.save($scope.member, function() {
            //data saved. do something here.
        }); //saves an entry. Assuming $scope.entry is the Entry object

        $scope.addMember = function() { //create a new movie. Issues a POST to /api/movies
            $scope.member.$save(function () {
                //$state.go('movies'); // on success go back to home i.e. movies state.
            });
        };
    }
);
