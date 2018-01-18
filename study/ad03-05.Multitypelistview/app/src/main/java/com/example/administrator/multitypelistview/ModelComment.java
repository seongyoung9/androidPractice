package com.example.administrator.multitypelistview;

public class ModelComment {

    private String textMessage = ""  ;
    private String textWriter = ""  ;

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextWriter() {
        return textWriter;
    }

    public void setTextWriter(String textWriter) {
        this.textWriter = textWriter;
    }



    @Override
    public String toString() {
        return "ModelComment{" +
                "textMessage='" + textMessage + '\'' +
                ", textWriter='" + textWriter + '\'' +
                '}';
    }
    public ModelComment() {
    }
    public ModelComment(String textMessage, String textWriter) {
        this.textMessage = textMessage;
        this.textWriter = textWriter;
    }
}
