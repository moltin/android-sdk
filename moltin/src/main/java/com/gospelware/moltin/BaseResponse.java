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

        private String self;
        private String next;
        private String prev;
        private String first;
        private String last;
        private String current;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }
    }
}
