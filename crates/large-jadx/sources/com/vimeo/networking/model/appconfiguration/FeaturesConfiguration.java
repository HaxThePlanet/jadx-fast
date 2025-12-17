package com.vimeo.networking.model.appconfiguration;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class FeaturesConfiguration {

    @SerializedName("autoupload")
    public boolean autoUploadEnabled;
    @SerializedName("chromecast_app_id")
    public String chromecastReceiverAppID;
    @SerializedName("comscore")
    public boolean comScoreEnabled;
    @SerializedName("iap")
    public boolean iapEnabled;
    @SerializedName("play_tracking")
    public boolean playTrackingEnabled = true;
    public FeaturesConfiguration() {
        super();
        final int i = 1;
    }

    public boolean equals(Object object) {
        int i;
        Class class;
        boolean chromecastReceiverAppID;
        Class class2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.iapEnabled != object.iapEnabled) {
                    return i2;
                }
                if (this.autoUploadEnabled != object.autoUploadEnabled) {
                    return i2;
                }
                if (this.comScoreEnabled != object.comScoreEnabled) {
                    return i2;
                }
                if (this.playTrackingEnabled != object.playTrackingEnabled) {
                    return i2;
                }
                String chromecastReceiverAppID2 = this.chromecastReceiverAppID;
                chromecastReceiverAppID = object.chromecastReceiverAppID;
                if (chromecastReceiverAppID2 != null && chromecastReceiverAppID != null) {
                    chromecastReceiverAppID = object.chromecastReceiverAppID;
                    if (chromecastReceiverAppID != null) {
                        return chromecastReceiverAppID2.equals(chromecastReceiverAppID);
                    }
                }
                if (chromecastReceiverAppID2 == null && object.chromecastReceiverAppID == null) {
                    if (object.chromecastReceiverAppID == null) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i;
        String chromecastReceiverAppID = this.chromecastReceiverAppID;
        if (chromecastReceiverAppID != null) {
            i = chromecastReceiverAppID.hashCode();
        } else {
            i = 0;
        }
        return i8 += i;
    }
}
