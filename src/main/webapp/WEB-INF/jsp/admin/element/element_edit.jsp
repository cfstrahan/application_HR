<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function () {
        //attach onclick function to the remove buttons
        $('.remove-button').click(function () {
            //log name button, and contents of the associated text box
            console.log(this.name);
            console.log($('#' + this.name).val())
            //clear the value/contents of the textbox
            $('#' + this.name).val('');
            //submit the form
            $('#elementType').submit();
        });
    });
</script>

<div class="wrapper">

    <%@include file="element_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page"/>
            <form:form class="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />

                <div class="row">
                    <div class="form-group">
                        <label for="inputElementTypeName" class="col-sm-2 control-label">Element Type</label>
                        <div class="col-sm-8">
                            <form:input path="elementTypeName" type="text" id="inputElementTypeName" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>
                <c:forEach items="${elementType.elementList}">
                    <form:hidden path="elementList[${idx}].id"/>
                    <form:hidden path="elementList[${idx}].version"/>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="${idx}">Element</label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                    <form:input path="elementList[${idx}].elementName" cssClass="form-control" id="${idx}"/>
                                        <span class="input-group-btn">
                                            <button name="${idx}" class="btn btn-default remove-button" type="button">Remove</button>
                                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx + 1}" scope="page"/>
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="inputNewElement">Add New Element</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewElement"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>

            </form:form>



        </div>
        <div class="col-sm-4">
<%--            Alerts--%>
<%--            <!--SUCCESS ALERT class="${successAlert == null ?}"-->--%>
            <div  class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissable alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Nice Job!</strong><a href="#" class="alert-link"> You successfully submitted</a> this information.
                </div>
            </div>
            <!--WARNING ALERT-->
            <div class="${successAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissable alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Small Issue!</strong><a href="#" class="alert-link"> You did good</a> Maybe do another?
                </div>
            </div>
            <!--ERROR ALERT-->
            <div class="${successAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissable alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh Snap!</strong><a href="#" class="alert-link">Change A few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>






</div>

<%@include file="../../includes/footer.jsp"%>
