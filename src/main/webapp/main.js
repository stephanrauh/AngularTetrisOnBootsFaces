angular.module("AngularTetris", [ "angularfaces", "smart-table" ])
.controller('AngularTetrisController', ['$scope', function($scope) {
   initJSFScope($scope);

	$scope.game = new GameController($scope.grid, $scope);
	window.gameController=$scope.game;
	$scope.game.init($scope.grid);
//	$scope.game.startGame();

	$scope.brickColor = function(color){
		if (0==color) return "#FFFFFF";
        if (1==color) return "#00F0F0";
        if (2==color) return "#0000F0";
        if (3==color) return "#F0A000";
        if (4==color) return "#F0F000";
        if (5==color) return "#00F000";
        if (6==color) return "#F00000";
        if (7==color) return "#A000F0";
        return "#00FFFFFF";
	};
	
	$scope.onkey = function(event) {
		$scope.game.onKey(event);
	};
	
	$scope.showApplyButton=false;
	
    $scope.$watch('settingsBean.ignoreGravity', function(newValue, oldValue) {
      if (newValue!==oldValue) $scope.showApplyButton=true;
    });
    $scope.$watch('settingsBean.preview', function(newValue, oldValue) {
      if (newValue!==oldValue) $scope.showApplyButton=true;
    });
    $scope.$watch('settingsBean.numberOfColumns', function(newValue, oldValue) {
      if (newValue!==oldValue) $scope.showApplyButton=true;
    });
    $scope.$watch('settingsBean.numberOfRows', function(newValue, oldValue) {
      if (newValue!==oldValue) $scope.showApplyButton=true;
    });
    
    $scope.showApplyButton=false;
    
    
    var
        nameList = ['Pierre', 'Pol', 'Jacques', 'Robert', 'Elisa'],
        familyName = ['Dupont', 'Germain', 'Delcourt', 'bjip', 'Menez'];

    function createRandomItem() {
        var
            firstName = nameList[Math.floor(Math.random() * 4)],
            lastName = familyName[Math.floor(Math.random() * 4)],
            age = Math.floor(Math.random() * 100),
            email = firstName + lastName + '@whatever.com',
            balance = Math.random() * 3000;
    
        return{
            firstName: firstName,
            lastName: lastName,
            age: age,
            email: email,
            balance: balance
        };
    }
    
    $scope.itemsByPage=15;
    
    $scope.rowCollection = [];
    for (var j = 0; j < 200; j++) {
        $scope.rowCollection.push(createRandomItem());
    }


}]);

