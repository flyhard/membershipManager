var serivces = angular.module('MembershipManager');

serivces.factory('Member',function($resource){
    return $resource('/member/:id');
});