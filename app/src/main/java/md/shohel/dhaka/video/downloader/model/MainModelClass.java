package md.shohel.dhaka.video.downloader.model;

import java.util.ArrayList;

public class MainModelClass {
    private String title;
    private ArrayList<SubModelClass> list;

    public MainModelClass(String title, ArrayList<SubModelClass> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SubModelClass> getList() {
        return list;
    }

    public void setList(ArrayList<SubModelClass> list) {
        this.list = list;
    }
}
