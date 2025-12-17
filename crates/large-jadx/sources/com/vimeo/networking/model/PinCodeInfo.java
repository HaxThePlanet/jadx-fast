package com.vimeo.networking.model;

/* loaded from: classes2.dex */
public class PinCodeInfo {

    public int expiresIn;
    public int interval;
    public String mActivateLink;
    public String mAuthorizeLink;
    public String mDeviceCode;
    public String mUserCode;
    public String getActivateLink() {
        return this.mActivateLink;
    }

    public String getAuthorizeLink() {
        return this.mAuthorizeLink;
    }

    public String getDeviceCode() {
        return this.mDeviceCode;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getUserCode() {
        return this.mUserCode;
    }
}
