angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {

    $scope.user = {};
    $scope.events ={};
    console.log("Initial start");
      $scope.login = function() {

            console.log("About to go get me some data!");
            $http.post("/login", $scope.user)
                .then(
                    function successCallback(response) {
                        console.log(response.data);
                        console.log("Adding data to scope");
                        $scope.login = response.data;
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
        };
        $scope.register = function(firstName, lastName, email2, password2) {
          console.log("About to register");
            $http.post("/register?firstName=" + firstName + "&lastName=" + lastName + "&email=" + email2 + "&password=" + password2)
//            ", $scope.email, $scope.firstName, $scope.lastName, $scope.password)
              .then(
                  function success(response) {
                     console.log(response.data);
                     console.log("Register works");
                     $scope.users={};
                     alert("About to refresh the users on the scope");
                     $scope.users = response.data;
                  },
                  function error(response) {
                     console.log("Unable to refresh the users");
                  });
         };
         $scope.allEvents = function() {
           console.log("About to show events "); // + JSON.stringify($scope.newGame));
             $http.post("/events")
               .then(
                  function successCallback(response) {
                    console.log(response.data);
                    console.log("Adding data to scope");
                    $scope.events = response.data;
                  },
                  function errorCallback(response) {
                    console.log("Unable to get data");
                  });
         };
         $scope.eventInfo = function() {
           console.log("About to show event "); // + JSON.stringify($scope.newGame));
             $http.post("/eventInfo")
                .then(
                   function successCallback(response) {
                       console.log(response.data);
                       console.log("Adding data to scope");
                       $scope.eventInfo = response.data;
                   },
                   function errorCallback(response) {
                       console.log("Unable to get data");
                   });
         };
         $scope.checkIn = function(event.id, user.id) {
           console.log("About to show checkedIn individuals "); // + JSON.stringify($scope.newGame));
             $http.post("/checkedIn")
               .then(
                  function successCallback(response) {
                     console.log(response.data);
                     console.log("Adding data to scope");
                     $scope.eventInfo = response.data;
                  },
                  function errorCallback(response) {
                     console.log("Unable to get data");
                  });
         };
    });

