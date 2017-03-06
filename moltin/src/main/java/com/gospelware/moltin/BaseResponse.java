package com.gospelware.moltin;

/**
 * Created by lewis on 20/02/2017.
 */

public class BaseResponse {

    public BaseResponseLinks links;

    public class JsonApiErrorResponse{
        public String code;
        public String title;
        public String detail;
        public JsonApiErrorResponseLinks links;

        public class JsonApiErrorResponseLinks{

            public JsonApiErrorResponseLinks about;

            public class JsonApiErrorResponseLinksAbout{
                public String href;
            }
        }
    }

    public class BaseResponseLinks{
        public String self;
        public String next;
        public String prev;
        public String first;
        public String last;
    }
}
