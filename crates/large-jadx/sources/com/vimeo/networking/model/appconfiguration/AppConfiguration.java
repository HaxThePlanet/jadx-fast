package com.vimeo.networking.model.appconfiguration;

/* compiled from: AppConfiguration.java */
/* loaded from: classes2.dex */
public class AppConfiguration {

    public ApiConfiguration api;
    public FacebookConfiguration facebook;
    public FeaturesConfiguration features;
    public boolean equals(Object object) {
        boolean z = true;
        com.vimeo.networking.model.appconfiguration.FacebookConfiguration facebook2;
        com.vimeo.networking.model.appconfiguration.FeaturesConfiguration features2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.facebook != null) {
                    if (!this.facebook.equals(object.facebook)) {
                        return false;
                    }
                }
                if (this.api != null) {
                    if (!this.api.equals(object.api)) {
                        return false;
                    }
                }
                if (this.features != null) {
                    if (!this.features.equals(object.features)) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.facebook != null) {
            i = this.facebook.hashCode();
        } else {
        }
        if (this.api != null) {
            i = this.api.hashCode();
        } else {
        }
        if (this.features != null) {
            i = this.features.hashCode();
        }
        return (i * 31) + i * 31 + i;
    }
}
