package h.a.b.i;

import android.util.Log;

/* loaded from: classes2.dex */
public class c {

    private String a;
    public c(String string) {
        super();
        this.a = string;
        b.l(0);
    }

    public void a(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (b.g()) {
            Log.d(this.a, b.d(string, object2Arr2));
        }
    }

    public void b(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (b.h()) {
            Log.e(this.a, b.d(string, object2Arr2));
        }
    }

    public void c(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (b.i()) {
            Log.i(this.a, b.d(string, object2Arr2));
        }
    }

    public void d(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (b.j()) {
            Log.v(this.a, b.d(string, object2Arr2));
        }
    }

    public void e(String string, Object... object2Arr2) {
        boolean z;
        String obj2;
        if (b.k()) {
            Log.w(this.a, b.d(string, object2Arr2));
        }
    }
}
