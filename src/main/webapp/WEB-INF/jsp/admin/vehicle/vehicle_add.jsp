<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">
    <div id="main-wrapper" class="col-sm-10">
        <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
            <fieldset>
                <legend>Vehicle Management</legend>
                <div class="form-group">
                    <label for="inputNewVehicleType" class="col-lg-2 control-label"></label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleMake"  type="text" cssClass="form-control" id="inputNewVehicleType" placeholder="Vehicle Make"></form:input>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>