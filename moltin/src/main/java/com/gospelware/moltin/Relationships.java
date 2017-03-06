package com.gospelware.moltin;

import java.util.ArrayList;

/**
 * Created by lewis on 06/03/2017.
 */

public class Relationships {

    private Relationship children;
    private Relationship parent;

    public Relationship getChildren() {
        return children;
    }

    public void setChildren(Relationship children) {
        this.children = children;
    }

    public Relationship getParent() {
        return parent;
    }

    public void setParent(Relationship parent) {
        this.parent = parent;
    }

    public class Relationship {

        private ArrayList<KeyValueData> data;

        public ArrayList<KeyValueData> getData() {
            return data;
        }

        public void setData(ArrayList<KeyValueData> data) {
            this.data = data;
        }
    }
}
