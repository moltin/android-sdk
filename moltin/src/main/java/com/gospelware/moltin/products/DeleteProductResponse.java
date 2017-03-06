package com.gospelware.moltin.products;

/**
 * Created by lewis on 02/03/2017.
 */

public class DeleteProductResponse {

    private DeleteProductResponseData data;

    public DeleteProductResponseData getData() {
        return data;
    }

    public void setData(DeleteProductResponseData data) {
        this.data = data;
    }

    private class DeleteProductResponseData{

        private String type;
        private String id;

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
    }
}
