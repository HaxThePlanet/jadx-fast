package com.vimeo.networking.model.appconfiguration;

/* loaded from: classes2.dex */
public class ApiConfiguration {

    public String host;
    public ApiConfiguration() {
        super();
        this.host = "https://api.vimeo.com/";
    }

    public boolean equals(Object object) {
        int i;
        Class class2;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                String host = this.host;
                obj5 = object.host;
                if (host != null) {
                    if (!host.equals(obj5)) {
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
        int i;
        String host = this.host;
        if (host != null) {
            i = host.hashCode();
        } else {
            i = 0;
        }
        return i;
    }
}
