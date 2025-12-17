package androidx.core.os;

import android.os.Build.VERSION;
import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class b {

    private boolean a;
    private androidx.core.os.b.a b;
    private Object c;
    private boolean d;

    public interface a {
        public abstract void a();
    }
    private void d() {
        while (this.d) {
            wait();
        }
    }

    public void a() {
        androidx.core.os.b.a sDK_INT;
        int i;
        synchronized (this) {
            try {
                int i2 = 1;
                this.a = i2;
                this.d = i2;
                sDK_INT = this.b;
                final Object obj = this.c;
                if (sDK_INT != null) {
                }
                sDK_INT.a();
                if (obj != null && Build.VERSION.SDK_INT >= 16) {
                }
                if (Build.VERSION.SDK_INT >= 16) {
                }
                (CancellationSignal)obj.cancel();
                this.d = obj2;
                notifyAll();
                throw th;
                throw th;
                this.d = false;
                notifyAll();
                throw th;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public boolean b() {
        return this.a;
        synchronized (this) {
            return this.a;
        }
    }

    public void c(androidx.core.os.b.a b$a) {
        d();
        synchronized (this) {
            try {
                this.b = a;
                if (this.a && a == null) {
                }
                if (a == null) {
                }
                a.a();
                throw a;
            }
        }
    }
}
