package com.vimeo.networking.model.appconfiguration;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class FacebookConfiguration {

    public String[] requiredScopes;
    public boolean equals(Object object) {
        Class class;
        Class class2;
        if (this == object) {
            return 1;
        }
        if (object != null && getClass() != object.getClass()) {
            if (getClass() != object.getClass()) {
            }
            return Arrays.deepEquals(this.requiredScopes, object.requiredScopes);
        }
        return 0;
    }

    public int hashCode() {
        int i;
        String[] requiredScopes = this.requiredScopes;
        if (requiredScopes != null) {
            i = Arrays.hashCode(requiredScopes);
        } else {
            i = 0;
        }
        return i;
    }
}
