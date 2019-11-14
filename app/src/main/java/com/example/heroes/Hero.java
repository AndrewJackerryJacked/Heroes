package com.example.heroes;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {
    private String image;
    private String heroName;
    private String heroDescription;
    private Parcelable MyParcelable;
    private int mData;
    private ImageView listview;
    private String s;

    public String getImage()
    {
        return image;
    }



    public static void main(String[] args) {
        System.out.print("Sorted List: ");
        List names = new ArrayList();
        names.add("");
        names.add("Banana");
        names.add("Apple");
        names.add("Guava");
        names.add("Grapes");
        Collections.sort(names);
        for(Object s: names) System.out.print(s+", ");

    }

    public int describeContents() {
        return 0;
    }

    ListView.OnItemClickListener
    public static class MyParcelable implements Parcelable {
        private int mData;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(mData);
        }

        public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {

            public MyParcelable createFromParcel(Parcel in) {
                return new MyParcelable(in);
            }

            public MyParcelable[] newArray(int size) {
                return new MyParcelable[size];
            }
        };

        private MyParcelable(Parcel in) {
            mData = in.readInt();
        }



    public Parcelable getMyParcelable(Parcelable MyParcelable) {
        return MyParcelable;
    }

    public String getheroDescription(String heroDescription)
    {
        return heroDescription;
    }

    public String getHeroName(String heroName)
    {
        return heroName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String setName(String heroName) {
            return heroName;
        }
    }
}