package com.facebook.e0.u;

import com.facebook.e0.w.d;
import com.facebook.e0.w.d.a;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.o;
import com.facebook.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u000c2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/appevents/integrity/IntegrityManager;", "", "()V", "INTEGRITY_TYPE_ADDRESS", "", "INTEGRITY_TYPE_HEALTH", "INTEGRITY_TYPE_NONE", "RESTRICTIVE_ON_DEVICE_PARAMS_KEY", "enabled", "", "isSampleEnabled", "enable", "", "getIntegrityPredictionResult", "textFeature", "processParameters", "parameters", "", "shouldFilter", "input", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static boolean a;
    private static boolean b;
    public static final com.facebook.e0.u.a c;
    static {
        a aVar = new a();
        a.c = aVar;
    }

    public static final void a() {
        if (a.d(a.class)) {
        }
        a.a = true;
        a.b = o.f("FBSDKFeatureIntegritySample", o.g(), false);
    }

    private final String b(String string) {
        int i2;
        int i;
        String obj7;
        if (a.d(this)) {
            return null;
        }
        int i3 = 30;
        float[] fArr = new float[i3];
        final int i5 = 0;
        i2 = i5;
        while (i2 < i3) {
            fArr[i2] = 0;
            i2++;
        }
        int i6 = 1;
        float[][] fArr2 = new float[i6];
        fArr2[i5] = fArr;
        String[] strArr = new String[i6];
        strArr[i5] = string;
        obj7 = d.o(d.a.MTML_INTEGRITY_DETECT, fArr2, strArr);
        if (obj7 != null && obj7[i5] != null) {
            if (obj7[i5] != null) {
            } else {
                obj7 = "none";
            }
        } else {
        }
        return obj7;
    }

    public static final void c(Map<String, String> map) {
        boolean length;
        Object jSONObject;
        Object next;
        Object str;
        boolean z2;
        boolean z;
        if (a.d(a.class)) {
        }
        n.f(map, "parameters");
        if (a.a) {
            if (map.isEmpty()) {
            } else {
                jSONObject = new JSONObject();
                Iterator iterator = p.L0(map.keySet()).iterator();
                for (String next : iterator) {
                    str = map.get(next);
                    z2 = a.c;
                    if (!z2.d(next)) {
                    } else {
                    }
                    map.remove(next);
                    if (a.b) {
                    } else {
                    }
                    str = "";
                    jSONObject.put(next, str);
                    if (z2.d((String)str)) {
                    }
                }
                if (jSONObject.length() != 0) {
                    jSONObject = jSONObject.toString();
                    n.e(jSONObject, "restrictiveParamJson.toString()");
                    map.put("_onDeviceParams", jSONObject);
                }
            }
        }
    }

    private final boolean d(String string) {
        if (a.d(this)) {
            return 0;
        }
        return obj3 ^= 1;
    }
}
