<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Klient</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Klient</h1>
            <p>Czy jesteś naszym klientem?</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="order.customer" class="formhorizontal">
        <legend>ID klienta</legend>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="customerId">Identyfikator klienta</label>
            <div class="col-lg-10">
                <form:input id="customerId" path="customerId" type="text" class="form:input-large"/>
            </div>
        </div>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btnprimary"
                       value="Sprawdź" name="_eventId_checkCustomerExist"/>
                <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Anuluj</button>
            </div>
        </div>
    </form:form>
</section>

</body>
</html>
