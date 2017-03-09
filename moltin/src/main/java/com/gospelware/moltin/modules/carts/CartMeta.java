package com.gospelware.moltin.modules.carts;

import com.gospelware.moltin.modules.gateways.Gateway;
import com.gospelware.moltin.modules.meta.DisplayPrice;
import com.gospelware.moltin.modules.meta.TimestampMeta;

import java.util.ArrayList;

/**
 * Created by lewis on 08/03/2017.
 */

public class CartMeta {

    private TimestampMeta timestamps;
    private DisplayPriceWrapper displayPrice;
    private ArrayList<Gateway> availablePaymentMethods;

    public DisplayPriceWrapper getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(DisplayPriceWrapper displayPrice) {
        this.displayPrice = displayPrice;
    }

    public TimestampMeta getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(TimestampMeta timestamps) {
        this.timestamps = timestamps;
    }

    public ArrayList<Gateway> getAvailablePaymentMethods() {
        return availablePaymentMethods;
    }

    public void setAvailablePaymentMethods(ArrayList<Gateway> availablePaymentMethods) {
        this.availablePaymentMethods = availablePaymentMethods;
    }

//    public class DisplayPriceWrapper {
//
//        private DisplayPrice withTax;
//        private DisplayPrice withoutTax;
//
//        public DisplayPrice getWithTax() {
//            return withTax;
//        }
//
//        public void setWithTax(DisplayPrice withTax) {
//            this.withTax = withTax;
//        }
//
//        public DisplayPrice getWithoutTax() {
//            return withoutTax;
//        }
//
//        public void setWithoutTax(DisplayPrice withoutTax) {
//            this.withoutTax = withoutTax;
//        }
//    }
}
