package com.animesh.dailytadkarecipes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class RecipeResponse implements Parcelable {

    public String type;
    public String name;
    public String preparationTime;
    public String thumbnail;
    public String servings;
    public String recipeDescription;
    public ArrayList<String> listingImages;

    protected RecipeResponse(Parcel in) {
        type = in.readString();
        name = in.readString();
        preparationTime = in.readString();
        thumbnail = in.readString();
        servings = in.readString();
        recipeDescription = in.readString();
        listingImages = in.createStringArrayList();
    }

    public static final Creator<RecipeResponse> CREATOR = new Creator<RecipeResponse>() {
        @Override
        public RecipeResponse createFromParcel(Parcel in) {
            return new RecipeResponse(in);
        }

        @Override
        public RecipeResponse[] newArray(int size) {
            return new RecipeResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(preparationTime);
        dest.writeString(thumbnail);
        dest.writeString(servings);
        dest.writeString(recipeDescription);
        dest.writeStringList(listingImages);
    }

}