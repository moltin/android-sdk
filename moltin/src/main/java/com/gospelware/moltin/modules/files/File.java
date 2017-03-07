package com.gospelware.moltin.modules.files;

import com.google.gson.annotations.SerializedName;
import com.gospelware.moltin.Dimensions;
import com.gospelware.moltin.Links;
import com.gospelware.moltin.TimestampMeta;

/**
 * Created by lewis on 07/03/2017.
 */

public class File {

    private String type;
    private String id;
    private FileLink link;
    private String mimeType;
    private Double fileSize;

    @SerializedName("public")
    private Boolean isPublic;
    private FileMeta meta;
    private Links links;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FileLink getLink() {
        return link;
    }

    public void setLink(FileLink link) {
        this.link = link;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public FileMeta getMeta() {
        return meta;
    }

    public void setMeta(FileMeta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public class FileLink{
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public class FileMeta{
        private TimestampMeta timestamps;
        private Dimensions dimensions;

    }

}
