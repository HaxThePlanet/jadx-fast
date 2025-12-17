package com.google.android.gms.common.l;

import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.j;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {

    private final String a;
    private final String b;
    private final int c = 2;
    public a(String string, String... string2Arr2) {
        StringBuilder stringBuilder;
        int i2;
        Object obj;
        int length;
        int i;
        int obj7;
        String obj8;
        final int length2 = string2Arr2.length;
        if (length2 == 0) {
            obj8 = "";
            super();
            this.b = obj8;
            this.a = string;
            obj8 = new j(string);
            obj7 = 2;
            while (true) {
                obj7++;
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            i2 = 0;
            while (i2 < length2) {
                stringBuilder.append(string2Arr2[i2]);
                i2++;
                stringBuilder.append(",");
            }
            stringBuilder.append("] ");
            obj8 = stringBuilder.toString();
        }
    }

    public void a(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (f(3)) {
            Log.d(this.a, d(string, object2Arr2));
        }
    }

    public void b(String string, Throwable throwable2, Object... object3Arr3) {
        Log.e(this.a, d(string, object3Arr3), throwable2);
    }

    public void c(String string, Object... object2Arr2) {
        Log.e(this.a, d(string, object2Arr2));
    }

    protected String d(String string, Object... object2Arr2) {
        int length;
        String obj2;
        if (object2Arr2 != null && object2Arr2.length > 0) {
            if (object2Arr2.length > 0) {
                obj2 = String.format(Locale.US, string, object2Arr2);
            }
        }
        return this.b.concat(obj2);
    }

    public void e(String string, Object... object2Arr2) {
        Log.i(this.a, d(string, object2Arr2));
    }

    public boolean f(int i) {
        if (this.c <= i) {
            return 1;
        }
        return 0;
    }

    public void g(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (f(2)) {
            Log.v(this.a, d(string, object2Arr2));
        }
    }

    public void h(String string, Object... object2Arr2) {
        Log.w(this.a, d(string, object2Arr2));
    }

    public void i(String string, Throwable throwable2, Object... object3Arr3) {
        Log.wtf(this.a, d(string, object3Arr3), throwable2);
    }

    public void j(Throwable throwable) {
        Log.wtf(this.a, throwable);
    }
}
