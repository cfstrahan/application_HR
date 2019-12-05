package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateElementAmdElementType();
        generateVehicleMakesAndModels();

    }

    private void generateVehicleMakesAndModels(){

        //ford

        VehicleMake vehicleMakeFord = new VehicleMake("Ford");

        List<VehicleModel> vehicleFordModels = new ArrayList<>();
        vehicleFordModels.add(new VehicleModel("Focus"));
        vehicleFordModels.add(new VehicleModel("Fiesta"));
        vehicleFordModels.add(new VehicleModel("Fusion"));
        vehicleFordModels.add(new VehicleModel("Mustang"));
        vehicleFordModels.add(new VehicleModel("GT"));
        vehicleFordModels.add(new VehicleModel("F-150"));
        vehicleFordModels.add(new VehicleModel("Super Duty"));

        vehicleMakeFord.setVehicleModelList(vehicleFordModels);

        vehicleMakeService.saveVehicleMake(vehicleMakeFord);

        //jeep

        VehicleMake vehicleMakeJeep = new VehicleMake("Jeep");

        List<VehicleModel> vehicleModelsJeep = new ArrayList<>();
        vehicleModelsJeep.add(new VehicleModel("Commando"));
        vehicleModelsJeep.add(new VehicleModel("Grand Cherokee"));
        vehicleModelsJeep.add(new VehicleModel("Super Wagoneer"));
        vehicleModelsJeep.add(new VehicleModel("CJ"));
        vehicleModelsJeep.add(new VehicleModel("Wrangler"));
        vehicleModelsJeep.add(new VehicleModel("Compass"));
        vehicleModelsJeep.add(new VehicleModel("Renegade"));

        vehicleMakeJeep.setVehicleModelList(vehicleModelsJeep);

        vehicleMakeService.saveVehicleMake(vehicleMakeJeep);

        //toyota

        VehicleMake vehicleMakeToyota = new VehicleMake("Toyota");

        List<VehicleModel> vehicleModelsToyota = new ArrayList<>();
        vehicleModelsToyota.add(new VehicleModel("Camry"));
        vehicleModelsToyota.add(new VehicleModel("Corolla"));
        vehicleModelsToyota.add(new VehicleModel("Crown Majesta"));
        vehicleModelsToyota.add(new VehicleModel("Prius"));
        vehicleModelsToyota.add(new VehicleModel("Yaris"));
        vehicleModelsToyota.add(new VehicleModel("Supra"));
        vehicleModelsToyota.add(new VehicleModel("Land Cruiser"));

        vehicleMakeToyota.setVehicleModelList(vehicleModelsToyota);

        vehicleMakeService.saveVehicleMake(vehicleMakeToyota);

        //saturn

        VehicleMake vehicleMakeSaturn = new VehicleMake("Saturn");

        List<VehicleModel> vehicleModelsSaturn = new ArrayList<>();
        vehicleModelsSaturn.add(new VehicleModel("Vue"));
        vehicleModelsSaturn.add(new VehicleModel("Ion"));
        vehicleModelsSaturn.add(new VehicleModel("Relay"));
        vehicleModelsSaturn.add(new VehicleModel("Sky"));
        vehicleModelsSaturn.add(new VehicleModel("EV1"));
        vehicleModelsSaturn.add(new VehicleModel("Outlook"));
        vehicleModelsSaturn.add(new VehicleModel("Astra"));

        vehicleMakeSaturn.setVehicleModelList(vehicleModelsSaturn);

        vehicleMakeService.saveVehicleMake(vehicleMakeSaturn);

        //tesla

        VehicleMake vehicleMakeTesla = new VehicleMake("Tesla");

        List<VehicleModel> vehicleModelsTesla = new ArrayList<>();
        vehicleModelsTesla.add(new VehicleModel("Model X"));
        vehicleModelsTesla.add(new VehicleModel("Model S"));
        vehicleModelsTesla.add(new VehicleModel("Model 3"));
        vehicleModelsTesla.add(new VehicleModel("Roadster"));
        vehicleModelsTesla.add(new VehicleModel("Semi"));
        vehicleModelsTesla.add(new VehicleModel("Model Y"));
        vehicleModelsTesla.add(new VehicleModel("Cybertruck"));

        vehicleMakeTesla.setVehicleModelList(vehicleModelsTesla);

        vehicleMakeService.saveVehicleMake(vehicleMakeTesla);

        //mini

        VehicleMake vehicleMakeMini = new VehicleMake("Mini");

        List<VehicleModel> vehicleModelsMini = new ArrayList<>();
        vehicleModelsMini.add(new VehicleModel("John Cooper Works"));
        vehicleModelsMini.add(new VehicleModel("Countryman"));
        vehicleModelsMini.add(new VehicleModel("Clubman"));
        vehicleModelsMini.add(new VehicleModel("Convertible"));
        vehicleModelsMini.add(new VehicleModel("Hardtop 2 Door"));
        vehicleModelsMini.add(new VehicleModel("Hardtop 4 Door"));

        vehicleMakeMini.setVehicleModelList(vehicleModelsMini);

        vehicleMakeService.saveVehicleMake(vehicleMakeMini);

    }



    private void generateElementAmdElementType(){
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));
        elementList.add(new Element("AlienWare"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        //email
        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Delegated"));

        emailType.setElementList(emailList);

        elementTypeService.saveElementType(emailType);
    }
}
