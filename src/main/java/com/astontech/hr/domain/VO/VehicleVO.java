package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;

public class VehicleVO {

    private String newVehicleMake;
    private String newVehicleModels;
    private String[] newVehicleModelArray;

    public VehicleVO(){}


    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModels() {
        return newVehicleModels;
    }

    public void setNewVehicleModels(String newVehicleModels) {
        this.newVehicleModels = newVehicleModels;
    }

    public String[] getNewVehicleModelArray() {
        return newVehicleModelArray;
    }

    public void setNewVehicleModelArray(String[] newVehicleModelArray) {
        this.newVehicleModelArray = newVehicleModelArray;
    }
}
