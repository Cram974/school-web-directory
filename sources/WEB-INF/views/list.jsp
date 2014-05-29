<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <h1>Directory</h1>
        <p>A simple directory service</p>
        <p><a class="btn btn-primary"href="contact?action=create">New Contact</a></p>
      </div>
      <form role="form" action="contact" method="GET">
        <input type="hidden" name="action" value="search">
        <div class="row">
          <div class="col-md-6 col-md-offset-3">
            <div class="input-group">
              <input type="text" class="form-control" name="query" placeholder="Search">
              <span class="input-group-btn">
                <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
              </span>
            </div>
          </div>
        </div>
      </form>
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody class="table-striped">
            <c:forEach items="${contacts}" var="contact" varStatus="status">
              <tr>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.email}</td>
                <td>${contact.phoneNumber}</td>
                <td>
                  <a class="btn btn-primary" href="contact?action=show&id=${contact.id}">
                    <span class="glyphicon glyphicon-zoom-in"></span> Show
                  </a>
                  <a class="btn btn-warning" href="contact?action=edit&id=${contact.id}">
                    <span class="glyphicon glyphicon-edit"></span> Edit
                  </a>
                  <a class="btn btn-danger" href="contact?action=delete&id=${contact.id}">
                    <span class="glyphicon glyphicon-trash"></span> Delete
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
