var scApp = angular.module('sharingcaring',['ngRoute']);

scApp.config(function($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'home'
        })
        .when('/home', {
            templateUrl: 'home',
            controller: 'donationController'
        })
        .when('/intro', {
            templateUrl: 'intro'
        })
        .when('/addDonation', {
            templateUrl: 'addDonation'

            //controllerAs:'dntnCtrl'

        })
        .otherwise({
            redirectTo: '/'
        });

});

scApp.controller("commonController" , function($scope ) {

});