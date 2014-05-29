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
        <h1 class="text-center">Edit Contact</h1>
      </div>
      <div class="row">
        <div class="col-xs-12 col-md-6 col-md-offset-3">
          <form class="form-horizontal" role="form" action="contact" method="POST">

            <input type="hidden" name="id" value="${contactID}">

            <div class="form-group">
              <label for="firstname" class="col-sm-2 control-label">Firstname</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" name="firstname"
                  id="firstname" placeholder="Firstname" value="${contact.firstName}" >
              </div>
            </div>
            <div class="form-group">
              <label for="lastname" class="col-sm-2 control-label">Lastname</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" name="lastname"
                  id="lastname" placeholder="Lastname" value="${contact.lastName}">
              </div>
            </div>
            <div class="form-group">
              <label for="address" class="col-sm-2 control-label">Address</label>
              <div class="col-sm-10">
                <textarea class="form-control" rows="3"
                  id="address" placeholder="Address" name="address"
                >${contact.address}</textarea>
              </div>
            </div>
            <div class="form-group">
              <label for="phone" class="col-sm-2 control-label">Phone</label>
              <div class="col-sm-10">
                <input type="tel" class="form-control" name="phone"
                  id="phone" placeholder="Phone" value="${contact.phoneNumber}">
              </div>
            </div>
            <div class="form-group">
              <label for="email" class="col-sm-2 control-label">Email</label>
              <div class="col-sm-10">
                <input type="email" class="form-control" name="email"
                  id="email" placeholder="Email" value="${contact.email}">
              </div>
            </div>
            <div class="form-group">
              <label for="comment" class="col-sm-2 control-label">Comment</label>
              <div class="col-sm-10">
                <textarea class="form-control" rows="3"
                  id="comment" placeholder="Comment" name="comment"
                >${contact.comment}</textarea>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <div class="row">
                  <div class="col-xs-6">
                    <a class="btn btn-danger btn-block" href="contact">Cancel</a>
                  </div>
                  <div class="col-xs-6">
                    <button type="submit" class="btn btn-success btn-block">Save</button>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
