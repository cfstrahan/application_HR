package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateElementAmdElementType();

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
