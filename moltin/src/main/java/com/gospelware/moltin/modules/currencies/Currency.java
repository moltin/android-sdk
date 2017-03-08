package com.gospelware.moltin.modules.currencies;

import com.google.gson.annotations.SerializedName;
import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.modules.meta.TimestampMeta;

/**
 * Created by lewis on 08/03/2017.
 */

public class Currency extends BaseResponse {

    private String type;
    private String id;
    private String code;
    private Double exchangeRate;
    private String format;
    private String decimalPoint;
    private String thousandSeparator;
    private Integer decimalPlaces;

    @SerializedName("default")
    private Boolean isDefault;
    private Boolean enabled;
    private CurrencyMeta meta;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDecimalPoint() {
        return decimalPoint;
    }

    public void setDecimalPoint(String decimalPoint) {
        this.decimalPoint = decimalPoint;
    }

    public String getThousandSeparator() {
        return thousandSeparator;
    }

    public void setThousandSeparator(String thousandSeparator) {
        this.thousandSeparator = thousandSeparator;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public CurrencyMeta getMeta() {
        return meta;
    }

    public void setMeta(CurrencyMeta meta) {
        this.meta = meta;
    }

    public class CurrencyMeta{
        private TimestampMeta timestamps;

        public TimestampMeta getTimestamps() {
            return timestamps;
        }

        public void setTimestamps(TimestampMeta timestamps) {
            this.timestamps = timestamps;
        }
    }
}
