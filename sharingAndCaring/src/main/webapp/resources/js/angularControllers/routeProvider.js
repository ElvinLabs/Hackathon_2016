var scApp = angular.module('sharingcaring',['ngRoute']);

scApp.config(function($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'home'
        })
        .when('/home', {
            templateUrl: 'home'
        })
        .when('/intro', {
            templateUrl: 'intro'
        })
        .when('/addDonation', {
            templateUrl: 'addDonation'
        })
        .otherwise({
            redirectTo: '/'
        });

});

scApp.controller("commonController" , function($scope ) {


});