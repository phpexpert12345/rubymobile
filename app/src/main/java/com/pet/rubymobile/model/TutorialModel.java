package com.pet.rubymobile.model;

public class TutorialModel {
    private int fileName;
    private String textTitle;
    private String textContent;

    public TutorialModel(int fName, String tTitle, String tContent) {
        this.fileName = fName;
        this.textTitle = tTitle;
        this.textContent = tContent;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public int getFileName() {
        return fileName;
    }

    public void setFileName(int fileName) {
        this.fileName = fileName;
    }
}
