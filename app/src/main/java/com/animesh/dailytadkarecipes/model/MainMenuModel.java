package com.animesh.dailytadkarecipes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainMenuModel {

    @SerializedName("menu_name")
    @Expose
    private String menuName;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("menu_code")
    @Expose
    private int menuCode;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
}