package com.gospelware.moltin.modules.files;

import com.gospelware.moltin.BaseResponse;

/**
 * Created by lewis on 07/03/2017.
 */

public class FileResponse extends BaseResponse {

    private File data;

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }
}
