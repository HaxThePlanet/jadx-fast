package com.vimeo.networking.model.appconfiguration;

import java.util.Arrays;

/* compiled from: FacebookConfiguration.java */
/* loaded from: classes2.dex */
public class FacebookConfiguration {

    public String[] requiredScopes;
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            return Arrays.deepEquals(this.requiredScopes, object.requiredScopes);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.requiredScopes != null) {
            i = Arrays.hashCode(this.requiredScopes);
        } else {
            i = 0;
        }
        return i;
    }
}
