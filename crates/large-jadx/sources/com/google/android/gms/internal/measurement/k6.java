package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k6 {

    private final Map<String, Map<String, String>> a;
    k6(Map<String, Map<String, String>> map) {
        super();
        this.a = map;
    }

    public final String a(Uri uri, String string2, String string3, String string4) {
        String obj2;
        obj2 = 0;
        Object obj1 = this.a.get(uri.toString());
        if (uri != null && (Map)obj1 == null) {
            obj1 = this.a.get(uri.toString());
            if ((Map)(Map)obj1 == null) {
                return obj2;
            }
            obj2 = String.valueOf(string4);
            String obj3 = "";
            if (obj2.length() != 0) {
                obj2 = obj3.concat(obj2);
            } else {
                obj2 = new String(obj3);
            }
            return (String)(Map)(Map)obj1.get(obj2);
        }
        return obj2;
    }
}
