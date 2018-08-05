package com.example.dell_i5.story;

public class Story  {
    private String storyTitle;
    private String storyMoral;
    private String storyDesc;

    public Story(){

    }

    public Story(String storyTitle, String storyMoral, String storyDesc) {
        this.storyTitle = storyTitle;
        this.storyMoral = storyMoral;
        this.storyDesc = storyDesc;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public String getStoryMoral() {
        return storyMoral;
    }

    public String getStoryDesc() {
        return storyDesc;
    }
}
