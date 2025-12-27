package com.vimeo.networking.model.appconfiguration;

/* compiled from: ApiConfiguration.java */
/* loaded from: classes2.dex */
public class ApiConfiguration {

    public String host = "https://api.vimeo.com/";
    public ApiConfiguration() {
        super();
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.host != null) {
                    if (!this.host.equals(object.host)) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.host != null) {
            i = this.host.hashCode();
        } else {
            i = 0;
        }
        return i;
    }
}
