package com.gospelware.moltin;

import java.util.ArrayList;

/**
 * Created by lewis on 20/02/2017.
 */

public class BaseResponse {

    private Links links;
    private ArrayList<JsonApiErrorResponse> errors;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public ArrayList<JsonApiErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<JsonApiErrorResponse> errors) {
        this.errors = errors;
    }

    public class JsonApiErrorResponse{
        public String code;
        public String title;
        public String detail;
        public JsonApiErrorResponseLinks links;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public JsonApiErrorResponseLinks getLinks() {
            return links;
        }

        public void setLinks(JsonApiErrorResponseLinks links) {
            this.links = links;
        }

        public class JsonApiErrorResponseLinks{

            public JsonApiErrorResponseLinks about;

            public class JsonApiErrorResponseLinksAbout{
                public String href;
            }
        }
    }


}
