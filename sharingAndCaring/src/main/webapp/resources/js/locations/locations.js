var lct = angular.module('location_screen', []);

lct.controller("locationController", function ($http) {
    var self = this;
    self.newLocation = "";
    self.locationEnabled = true;
    self.addEnable = false;
    self.updateEnable = true;
    self.deleteDelete = true;
    self.clearEnable = true;
    self.index = -1;
    self.waringText = "";
    self.warningEnable = false;


    self.getLocations = function() {
        var url = 'http://127.0.0.1:8080/shipxtimetracker/rest/workLocations';
        $http
            .get(url)
            .then
        (function (resp) {
                self.locations = resp.data;
                console.log("getLocations status" + resp.status);
            },
            function (err) {
                console.log('Locations request ERR ' + err);
            })
    };

    self.addLocation = function () {
        if (self.newLocation.length > 0) {
            self.waringText = "";
            self.warningEnable = false;
            var data = {locationName:self.newLocation,isEnable:self.locationEnabled};
            var url = 'http://127.0.0.1:8080/shipxtimetracker/rest/workLocation';
            $http
                .post(url, data)
                .then(
                function (resp) {
                    self.getLocations();
                    console.log("addLocation status" + resp.status);
                },
                function (err) {
                    console.log('Locations request ERR ' + err);
                    self.waringText = "Please Enter a Valid Location";
                    self.warningAppeared();
                });
            self.newLocation = "";
            self.locationEnabled = true;
        }
        else {
            self.waringText = "Please Enter a Location";
            self.warningAppeared();
        }

    };

    self.updateLocation = function(){
            var newWorkLocation = {locationName:self.newLocation, isEnable:self.locationEnabled};
            var locationId = self.locations[self.index].locationId;
            var url ='http://127.0.0.1:8080/shipxtimetracker/rest/workLocation/'+locationId;
            //var url = 'http://127.0.0.1:8080/shipxtimetracker/rest/workLocation/'+locationId;
            $http
                .put(url,newWorkLocation)
                .then(
                function(resp) {
                    self.getLocations();
                    console.log("updateLocation status"+resp.status);
                },
                function(err) {
                    console.log('UPDATE request ERR data: '+ err.data);
                    self.waringText = "Please Enter a Valid Location";
                    self.warningAppeared();
                }
            );

        self.newLocation = "";
        self.locationEnabled = true;
        self.index = -1;
        self.addEnable = false;
        self.updateEnable = true;
        self.deleteDelete = true;
        self.clearEnable = true;
    };

    self.deleteLocation = function () {
        var locationId = self.locations[self.index].locationId;
        var url = 'http://127.0.0.1:8080/shipxtimetracker/rest/workLocation/'+locationId;
        $http
            .delete(url)
            .then(
            function (resp) {
                self.getLocations();
                console.log("deleteLocation status" + resp.status);
            },
            function (err) {
                console.log('Delete request ERR: ' + err);
            }
        );
        self.newLocation = "";
        self.locationEnabled = true;
        self.index = -1;
        self.addEnable = false;
        self.updateEnable = true;
        self.deleteDelete = true;
        self.clearEnable = true;
    };

    self.clearLocation = function () {
        self.newLocation = "";
        self.locationEnabled = true;
        self.index = -1;
        self.addEnable = false;
        self.updateEnable = true;
        self.deleteDelete = true;
        self.clearEnable = true;
    };

    self.locationsSelected = function (lct) {
        self.index = self.locations.indexOf(lct);
        self.newLocation = lct.locationName;
        self.locationEnabled = lct.isEnable;
        self.addEnable = true;
        self.updateEnable = false;
        self.deleteDelete = false;
        self.clearEnable = false;
        self.warningEnable = false;
        self.waringText = "";
        self.selcted = true;
    };

    self.warningAppeared = function () {
        self.warningEnable = true;
    }

    self.isSelected = function (index) {
        return (index == self.index);
    };
});

