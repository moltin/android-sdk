package com.gospelware.moltin.modules.files;

import com.gospelware.moltin.BaseResponse;

import java.util.ArrayList;

/**
 * Created by lewis on 07/03/2017.
 */

public class FilesResponse extends BaseResponse {

    private ArrayList<File> data;

    public ArrayList<File> getData() {
        return data;
    }

    public void setData(ArrayList<File> data) {
        this.data = data;
    }
}
