package com.example.caoimhemalone.multimediaproject;

/**
 * Created by caoimhemalone on 12/12/2017.
 */

public class SliderInfo {
    public int id;
    public String name;
    public String sliderImage;
    public String sliderLink;


    public SliderInfo(int id, String name, String sliderImage, String sliderLink) {

        this.id = id;
        this.name = name;
        this.sliderImage = sliderImage;
        this.sliderLink = sliderLink;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSliderImage(){
        return sliderImage;
    }
    public String getSliderLink(){
        return sliderLink;
    }

}


