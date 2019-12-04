package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;
    private Integer vehicleMakeId;

    public VehicleModel(){}
    public VehicleModel(String vehicleModelName){
        this.setVehicleModelName(vehicleModelName);
    }
    public VehicleModel(String vehicleModelName, Integer vehicleMakeId){
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMakeId(vehicleMakeId);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(Integer vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }
}