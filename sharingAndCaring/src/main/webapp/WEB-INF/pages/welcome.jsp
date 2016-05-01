<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="sharingcaring">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Sharing & Caring</title>

  <!-- Bootstrap Core CSS -->
  <link href="resources/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="resources/css/full-width-pics.css" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <script type="text/javascript" src="webjars/angularjs/1.4.8/angular.min.js"></script>
  <script type="text/javascript" src="webjars/angular-route/1.4.8/angular-route.js"></script>
</head>

<body style="background-color: #ededed" ng-controller="commonController as cmnCtrl">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="padding-top:15px;height:80px;box-shadow: 3px 0px 10px #888888">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="font-weight: 200;font-size: 25px;color: #007aff">sharingcaring.lk</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="float: right">
        <li >
          <a href="#">Dileepa Chandima</a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<div id="view" ng-view>


</div>

  <script src="resources/js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="resources/js/bootstrap.min.js"></script>
  <script src="resources/js/config/routeProvider.js"></script>
</body>

</html>

