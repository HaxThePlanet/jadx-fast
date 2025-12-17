package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.f1.e;
import d.b.a.c.a;
import d.s.a.g;
import d.s.a.h;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class z {

    private h a = null;
    private final Handler b;
    Runnable c = null;
    final Object d;
    final long e;
    final Executor f;
    int g = 0;
    long h;
    g i;
    private boolean j = false;
    private final Runnable k;
    final Runnable l;

    class a implements Runnable {

        final androidx.room.z a;
        a(androidx.room.z z) {
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.z zVar = this.a;
            zVar.f.execute(zVar.l);
        }
    }

    class b implements Runnable {

        final androidx.room.z a;
        b(androidx.room.z z) {
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g open;
            Object th;
            Object obj = zVar.d;
            final androidx.room.z zVar4 = this.a;
            synchronized (obj) {
            }
        }
    }
    z(long l, TimeUnit timeUnit2, Executor executor3) {
        super();
        int i = 0;
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        Object object = new Object();
        this.d = object;
        int i2 = 0;
        this.h = SystemClock.uptimeMillis();
        z.a aVar = new z.a(this);
        this.k = aVar;
        z.b bVar = new z.b(this);
        this.l = bVar;
        this.e = executor3.toMillis(l);
        this.f = obj7;
    }

    public void a() {
        final Object obj = this.d;
        this.j = true;
        g gVar = this.i;
        synchronized (obj) {
            gVar.close();
            this.i = 0;
        }
    }

    public void b() {
        int i;
        Runnable runnable;
        long l;
        final Object obj = this.d;
        int i2 = this.g;
        synchronized (obj) {
            i2--;
            this.g = i;
            if (i == 0 && this.i == null) {
                if (this.i == null) {
                    try {
                        this.b.postDelayed(this.k, this.e);
                        IllegalStateException illegalStateException = new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
                        throw illegalStateException;
                        throw th;
                    }
                }
            }
        }
    }

    public <V> V c(a<g, V> a) {
        try {
            b();
            return a.apply(e());
            b();
            throw a;
        }
    }

    public g d() {
        final Object obj = this.d;
        return this.i;
        synchronized (obj) {
            obj = this.d;
            return this.i;
        }
    }

    public g e() {
        g open;
        final Object obj = this.d;
        this.b.removeCallbacks(this.k);
        this.g = i++;
        synchronized (obj) {
            open = this.i;
            if (open != null && open.isOpen()) {
                if (open.isOpen()) {
                    try {
                        return this.i;
                        h hVar = this.a;
                        if (hVar == null) {
                        } else {
                        }
                        g writableDatabase = hVar.getWritableDatabase();
                        this.i = writableDatabase;
                        return writableDatabase;
                        IllegalStateException illegalStateException2 = new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                        throw illegalStateException2;
                        IllegalStateException illegalStateException = new IllegalStateException("Attempting to open already closed database.");
                        throw illegalStateException;
                        throw th;
                    }
                }
            }
        }
    }

    public void f(h h) {
        if (this.a != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        }
        this.a = h;
    }

    public boolean g() {
        return z ^= 1;
    }

    public void h(Runnable runnable) {
        this.c = runnable;
    }
}
