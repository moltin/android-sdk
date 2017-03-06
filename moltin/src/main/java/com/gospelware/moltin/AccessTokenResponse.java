package com.gospelware.moltin;

/**
 * Created by lewis on 06/02/2017.
 */

public class AccessTokenResponse {

    public Long expires;

    public String identifier;

    public Long  expiresIn;

    public String accessToken;

    public String tokenType;

    public Long getExpires() {
        return expires;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public boolean isValid(){
        return true;
    }
}
