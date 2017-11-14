package com.sowon.myapplication;


public class ViewItem {
    private int nKeyID;
    private String textName;
    private String textPWD;
    private String textContent;
    private int imgRes;
    //test
    private String textMoney;

    public ViewItem(String text, int imgRes) {
        this.textName = text;
        this.imgRes = imgRes;
    }

    // 원래사용하던 생성자
    public ViewItem(int nKeyID, String textName, String textContent) { //게시물고유ID 작성자이름 내용
        this.nKeyID = nKeyID;
        this.textName = textName;
        this.textContent = textContent;
    }

    // money추가 생성자
    public ViewItem(int nKeyID, String textName, String textContent, String textMoney) {
        this.nKeyID = nKeyID;
        this.textName = textName;
        this.textContent = textContent;
        this.textMoney = textMoney;
    }

    public ViewItem(String textName, String textContent) { //게시물고유ID 작성자이름 내용
        this.nKeyID = nKeyID;
        this.textName = textName;
        this.textContent = textContent;
    }

    public int getnKeyID() { return nKeyID; }

    public String getTextName() {
        return textName;
    }

    public String getTextPWD() { return textPWD; }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setText(String text) {
        this.textName = text;
    }

    public int getImage() { return imgRes; }

    public void setImage(String image) {
        this.imgRes = imgRes;
    }


    //
    public String getTextMoney() { return textMoney; }
    public void setTextMoney(String textMoney) { this.textMoney = textMoney; }
}