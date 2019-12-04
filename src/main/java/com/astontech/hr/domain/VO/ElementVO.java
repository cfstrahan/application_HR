package com.astontech.hr.domain.VO;

public class ElementVO {

    private String newElementType;
    private String newElements;
    private String[] newElementArray;

    public ElementVO(){}

    //Custom Methods

    public void splitNewElementsIntoArray(){
        //regex for splitting on a new line or carriage is "\\r?\\n"
        this.setNewElementArray(this.getNewElements().split("\\r?\\n"));
    }

    public String getNewElementType() {
        return newElementType;
    }

    public void setNewElementType(String newElementType) {
        this.newElementType = newElementType;
    }

    public String getNewElements() {
        return newElements;
    }

    public void setNewElements(String newElements) {
        this.newElements = newElements;
    }

    public String[] getNewElementArray() {
        return newElementArray;
    }

    public void setNewElementArray(String[] newElementArray) {
        this.newElementArray = newElementArray;
    }
}
