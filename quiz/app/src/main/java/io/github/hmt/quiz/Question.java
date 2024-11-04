package io.github.hmt.quiz;


public class Question {
    public Question(int textResId, boolean mAnswer) {
        this.textResId = textResId;
        this.mAnswer = mAnswer;}

    private int textResId;

    public boolean ismAnswer() {
        return mAnswer;}

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    private boolean mAnswer;
}
