<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">
    <%@ include file="vehicle_sidebar.jsp"%>
    <div id="main-wrapper" class="col-sm-10">
        <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
            <fieldset>
                <legend>Vehicle Management</legend>
                <div class="form-group">
                    <label for="inputNewVehicleMake" class="col-lg-2 control-label">New Vehicle Make</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleMake"  type="text" cssClass="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicleModel" class="col-lg-2 control-label">New Vehicle Models</label>
                    <div class="col-lg-10">
                        <form:textarea path="newVehicleModels" cssClass="form-control" id="inputNewVehicleModel"></form:textarea>
                        <span class="help-block">Enter each new vehicle model on a new line</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="submit" class="btn btn-primary">Submit</form:button>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>