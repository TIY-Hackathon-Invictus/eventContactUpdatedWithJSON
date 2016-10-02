angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {
    $scope.user = {};
    console.log("Initial start");
        $scope.login = function(email, password) {
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
//                     ", $scope.email, $scope.firstName, $scope.lastName, $scope.password)
                        .then(
                           function success(response) {
                               console.log(response.data);
                               console.log("Todo toggled");

                               $scope.users={};

                               alert("About to refresh the todos on the scope");
                               $scope.users = response.data;
                           },
                           function error(response) {
                                console.log("Unable to toggle todo-");
                           });
         };

         $scope.allEvents = function() {
                      console.log("About to add the show events "); // + JSON.stringify($scope.newGame));

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

    });

