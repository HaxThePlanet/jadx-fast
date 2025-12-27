package h.a.b.i;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public class c {

    private String a;
    public c(String str) {
        super();
        this.a = str;
        b.l(null);
    }

    public void a(String str, Object... objectArr) {
        if (b.g()) {
            Log.d(this.a, b.d(str, objectArr));
        }
    }

    public void b(String str, Object... objectArr) {
        if (b.h()) {
            Log.e(this.a, b.d(str, objectArr));
        }
    }

    public void c(String str, Object... objectArr) {
        if (b.i()) {
            Log.i(this.a, b.d(str, objectArr));
        }
    }

    public void d(String str, Object... objectArr) {
        if (b.j()) {
            Log.v(this.a, b.d(str, objectArr));
        }
    }

    public void e(String str, Object... objectArr) {
        if (b.k()) {
            Log.w(this.a, b.d(str, objectArr));
        }
    }
}
