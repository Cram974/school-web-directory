<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Directory</title>
    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
  </head>
  <body>
    <div class="container">
      <div class="jumbotron">
        <h1 class="text-center">Show Contact</h1>
      </div>
      <div class="row">
        <div class="col-xs-12 col-md-6 col-md-offset-3">
          <form class="form-horizontal" role="form">
            <div class="row">
              <label class="col-sm-2 control-label">Firstname</label>
              <div class="col-sm-10">
                <p>${contact.firstName}</p>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Lastname</label>
              <div class="col-sm-10">
                <p>${contact.lastName}</p>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Address</label>
              <div class="col-sm-10">
                <p>${contact.address}</p>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Phone</label>
              <div class="col-sm-10">
                <p>${contact.phoneNumber}</p>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Email</label>
              <div class="col-sm-10">
                <p>${contact.email}</p>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Comment</label>
              <div class="col-sm-10">
                <p>${contact.comment}</p>
              </div>
            </div>
            <div class="form-group">
              <div class="col-xs-6 col-xs-offset-3">
                <a class="btn btn-primary btn-block" href="contact">Back</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
