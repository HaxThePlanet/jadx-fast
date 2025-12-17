package androidx.activity.result.f;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.a;
import d.e.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends androidx.activity.result.f.a<String[], Map<String, Boolean>> {
    static Intent e(String[] stringArr) {
        Intent intent = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS");
        return intent.putExtra("androidx.activity.result.contract.extra.PERMISSIONS", stringArr);
    }

    @Override // androidx.activity.result.f.a
    public Intent a(Context context, Object object2) {
        return d(context, (String[])object2);
    }

    @Override // androidx.activity.result.f.a
    public androidx.activity.result.f.a.a b(Context context, Object object2) {
        return f(context, (String[])object2);
    }

    @Override // androidx.activity.result.f.a
    public Object c(int i, Intent intent2) {
        return g(i, intent2);
    }

    @Override // androidx.activity.result.f.a
    public Intent d(Context context, String[] string2Arr2) {
        return b.e(string2Arr2);
    }

    public androidx.activity.result.f.a.a<Map<String, Boolean>> f(Context context, String[] string2Arr2) {
        int length;
        int i;
        int i3;
        Object obj;
        int i2;
        Boolean valueOf;
        if (string2Arr2 != null) {
            if (string2Arr2.length == 0) {
            } else {
                a aVar = new a();
                final int i4 = 0;
                final int i5 = 1;
                i = i4;
                i3 = i5;
                while (i < string2Arr2.length) {
                    obj = string2Arr2[i];
                    if (a.a(context, obj) == 0) {
                    } else {
                    }
                    i2 = i4;
                    aVar.put(obj, Boolean.valueOf(i2));
                    if (i2 == 0) {
                    }
                    i++;
                    i3 = i4;
                    i2 = i5;
                }
                if (i3 != 0) {
                    a.a obj10 = new a.a(aVar);
                    return obj10;
                }
            }
            return 0;
        }
        obj10 = new a.a(Collections.emptyMap());
        return obj10;
    }

    public Map<String, Boolean> g(int i, Intent intent2) {
        int i2;
        String str;
        Boolean valueOf;
        int i3;
        if (i != -1) {
            return Collections.emptyMap();
        }
        if (intent2 == null) {
            return Collections.emptyMap();
        }
        String[] obj7 = intent2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        final int[] obj8 = intent2.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (obj8 != null) {
            if (obj7 == null) {
            } else {
                HashMap hashMap = new HashMap();
                final int i5 = 0;
                i2 = i5;
                while (i2 < obj7.length) {
                    if (obj8[i2] == 0) {
                    } else {
                    }
                    i3 = i5;
                    hashMap.put(obj7[i2], Boolean.valueOf(i3));
                    i2++;
                    i3 = 1;
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
