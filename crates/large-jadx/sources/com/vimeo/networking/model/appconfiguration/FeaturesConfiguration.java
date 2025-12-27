package com.vimeo.networking.model.appconfiguration;

import com.google.gson.annotations.SerializedName;

/* compiled from: FeaturesConfiguration.java */
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
    }

    public boolean equals(Object object) {
        boolean z = true;
        String chromecastReceiverAppID2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.iapEnabled != object.iapEnabled) {
                    return false;
                }
                if (this.autoUploadEnabled != object.autoUploadEnabled) {
                    return false;
                }
                if (this.comScoreEnabled != object.comScoreEnabled) {
                    return false;
                }
                if (this.playTrackingEnabled != object.playTrackingEnabled) {
                    return false;
                }
                if (this.chromecastReceiverAppID != null && object.chromecastReceiverAppID != null) {
                    return this.chromecastReceiverAppID.equals(object.chromecastReceiverAppID);
                }
                if (this.chromecastReceiverAppID != null || object.chromecastReceiverAppID != null) {
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.chromecastReceiverAppID != null) {
            i = this.chromecastReceiverAppID.hashCode();
        } else {
            i = 0;
        }
        return (this.iapEnabled * 31) + this.autoUploadEnabled * 31 + this.comScoreEnabled * 31 + this.playTrackingEnabled * 31 + i;
    }
}
