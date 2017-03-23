package com.gsww.www.complexrecycleview;

/**
 * Created by luweicheng on 2017/3/23 0023.
 */

public  class OneTypeBean {
    private String name;
    private int imageView;
    private String professional;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public OneTypeBean(String name, int imageView, String professional) {
        this.name = name;
        this.imageView = imageView;
        this.professional = professional;
    }
}
