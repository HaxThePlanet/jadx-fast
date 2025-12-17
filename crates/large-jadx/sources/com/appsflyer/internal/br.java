package com.appsflyer.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class br<Body>  {

    public final Body AFInAppEventParameterName;
    public final int AFInAppEventType;
    public final com.appsflyer.internal.bj AFKeystoreWrapper;
    final boolean valueOf;
    final Map<String, List<String>> values;
    public br(Body body, int i2, boolean z3, Map<String, List<String>> map4, com.appsflyer.internal.bj bj5) {
        super();
        this.AFInAppEventParameterName = body;
        this.AFInAppEventType = i2;
        this.valueOf = z3;
        HashMap obj1 = new HashMap(map4);
        this.values = obj1;
        this.AFKeystoreWrapper = bj5;
    }

    public boolean equals(Object object) {
        Class class;
        Class class2;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.AFInAppEventType != object.AFInAppEventType) {
                    return i;
                }
                if (this.valueOf != object.valueOf) {
                    return i;
                }
                if (!this.AFInAppEventParameterName.equals(object.AFInAppEventParameterName)) {
                    return i;
                }
                if (!this.values.equals(object.values)) {
                    return i;
                }
            }
            return this.AFKeystoreWrapper.equals(object.AFKeystoreWrapper);
        }
        return i;
    }

    public int hashCode() {
        return i8 += i11;
    }

    public final boolean valueOf() {
        return this.valueOf;
    }
}
