package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
class l {

    private static final Object a;
    private static Field b;
    private static boolean c;
    static {
        Object object = new Object();
        l.a = object;
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int sparseArray;
        int i;
        Object obj;
        sparseArray = 0;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            if ((Bundle)obj != null && sparseArray == null) {
            }
            i++;
            if (sparseArray == null) {
            }
            sparseArray.put(i, (Bundle)obj);
            sparseArray = new SparseArray();
        }
        return sparseArray;
    }

    static Bundle b(androidx.core.app.j.a j$a) {
        int i;
        Bundle bundle;
        Object str;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = a.e();
        if (iconCompat != null) {
            i = iconCompat.e();
        } else {
            i = 0;
        }
        bundle2.putInt("icon", i);
        bundle2.putCharSequence("title", a.i());
        bundle2.putParcelable("actionIntent", a.a());
        if (a.d() != null) {
            bundle = new Bundle(a.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", a.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", l.e(a.f()));
        bundle2.putBoolean("showsUserInterface", a.h());
        bundle2.putInt("semanticAction", a.g());
        return bundle2;
    }

    public static Bundle c(Notification notification) {
        String str;
        Field declaredField;
        Object bundle;
        String assignableFrom;
        Class type;
        final Object obj = l.a;
        final int i2 = 0;
        synchronized (obj) {
            return i2;
        }
    }

    private static Bundle d(androidx.core.app.o o) {
        Bundle arrayList;
        int size;
        String next;
        Object obj3;
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", o.j());
        bundle.putCharSequence("label", o.i());
        bundle.putCharSequenceArray("choices", o.e());
        bundle.putBoolean("allowFreeFormInput", o.c());
        bundle.putBundle("extras", o.h());
        obj3 = o.d();
        if (obj3 != null && !obj3.isEmpty()) {
            if (!obj3.isEmpty()) {
                arrayList = new ArrayList(obj3.size());
                obj3 = obj3.iterator();
                for (String size : obj3) {
                    arrayList.add(size);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
        }
        return bundle;
    }

    private static Bundle[] e(androidx.core.app.o[] oArr) {
        int i;
        Bundle bundle;
        if (oArr == null) {
            return null;
        }
        Bundle[] arr = new Bundle[oArr.length];
        i = 0;
        for (Object obj : oArr) {
            arr[i] = l.d(obj);
        }
        return arr;
    }

    public static Bundle f(Notification.Builder notification$Builder, androidx.core.app.j.a j$a2) {
        int i;
        androidx.core.app.o[] objArr2;
        androidx.core.app.o[] objArr;
        Object str;
        IconCompat iconCompat = a2.e();
        if (iconCompat != null) {
            i = iconCompat.e();
        } else {
            i = 0;
        }
        builder.addAction(i, a2.i(), a2.a());
        Bundle obj3 = new Bundle(a2.d());
        if (a2.f() != null) {
            obj3.putParcelableArray("android.support.remoteInputs", l.e(a2.f()));
        }
        if (a2.c() != null) {
            obj3.putParcelableArray("android.support.dataRemoteInputs", l.e(a2.c()));
        }
        obj3.putBoolean("android.support.allowGeneratedReplies", a2.b());
        return obj3;
    }
}
