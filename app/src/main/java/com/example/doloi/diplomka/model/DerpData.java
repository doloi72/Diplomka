package com.example.doloi.diplomka.model;

import com.example.doloi.diplomka.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by doloi on 14.2.2017.
 */

public class DerpData {

    private static final String[] titles = {"My Title"};
    private static final String[] subTitles = {"sub-title"};
    private static final int icons = R.drawable.ic_tonality_black_36dp;

    //RecyclerView
    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        for (int i = 1; i < 30; i++) {
            ListItem item = new ListItem();
            item.setTitle(titles[0] + i);
            item.setSubTitle(subTitles[0] + i);
            data.add(item);
        }

        return data;
    }

}
