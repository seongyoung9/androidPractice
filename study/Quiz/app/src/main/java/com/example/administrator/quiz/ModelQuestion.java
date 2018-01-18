package com.example.administrator.quiz;

public class ModelQuestion {

    private int     questiontext;
    private boolean answertrue  ;


    public int getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(int questiontext) {
        this.questiontext = questiontext;
    }

    public boolean isAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(boolean answertrue) {
        this.answertrue = answertrue;
    }

    @Override
    public String toString() {
        return "ModelQuestion{" +
                "questiontext=" + questiontext +
                ", answertrue=" + answertrue +
                '}';
    }

    public ModelQuestion() {
    }

    public ModelQuestion(int questiontext, boolean answertrue) {
        this.questiontext = questiontext;
        this.answertrue = answertrue;
    }
}
