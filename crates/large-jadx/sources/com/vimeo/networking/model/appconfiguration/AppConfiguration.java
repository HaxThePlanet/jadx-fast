package com.vimeo.networking.model.appconfiguration;

/* loaded from: classes2.dex */
public class AppConfiguration {

    public com.vimeo.networking.model.appconfiguration.ApiConfiguration api;
    public com.vimeo.networking.model.appconfiguration.FacebookConfiguration facebook;
    public com.vimeo.networking.model.appconfiguration.FeaturesConfiguration features;
    public boolean equals(Object object) {
        int i;
        boolean facebook;
        boolean equals;
        Class class;
        Object facebook2;
        com.vimeo.networking.model.appconfiguration.FeaturesConfiguration obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                com.vimeo.networking.model.appconfiguration.FacebookConfiguration facebook3 = this.facebook;
                if (facebook3 != null) {
                    if (!facebook3.equals(object.facebook)) {
                        return i2;
                    }
                } else {
                    if (object.facebook != null) {
                    }
                }
                com.vimeo.networking.model.appconfiguration.ApiConfiguration api = this.api;
                if (api != null) {
                    if (!api.equals(object.api)) {
                        return i2;
                    }
                } else {
                    if (object.api != null) {
                    }
                }
                com.vimeo.networking.model.appconfiguration.FeaturesConfiguration features = this.features;
                obj5 = object.features;
                if (features != null) {
                    if (!features.equals(obj5)) {
                        i = i2;
                    }
                } else {
                    if (obj5 == null) {
                    } else {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i;
        com.vimeo.networking.model.appconfiguration.FacebookConfiguration facebook = this.facebook;
        i3 = 0;
        if (facebook != null) {
            i2 = facebook.hashCode();
        } else {
            i2 = i3;
        }
        com.vimeo.networking.model.appconfiguration.ApiConfiguration api = this.api;
        if (api != null) {
            i = api.hashCode();
        } else {
            i = i3;
        }
        com.vimeo.networking.model.appconfiguration.FeaturesConfiguration features = this.features;
        if (features != null) {
            i3 = features.hashCode();
        }
        return i6 += i3;
    }
}
