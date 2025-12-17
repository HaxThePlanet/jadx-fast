package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class b {

    private static com.google.android.material.snackbar.b e;
    private final Object a;
    private final Handler b;
    private com.google.android.material.snackbar.b.c c;
    private com.google.android.material.snackbar.b.c d;

    class a implements Handler.Callback {

        final com.google.android.material.snackbar.b a;
        a(com.google.android.material.snackbar.b b) {
            this.a = b;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return 0;
            }
            this.a.d((b.c)message.obj);
            return 1;
        }
    }

    interface b {
        public abstract void a();

        public abstract void b(int i);
    }

    private static class c {

        final WeakReference<com.google.android.material.snackbar.b.b> a;
        int b;
        boolean c;
        c(int i, com.google.android.material.snackbar.b.b b$b2) {
            super();
            WeakReference weakReference = new WeakReference(b2);
            this.a = weakReference;
            this.b = i;
        }

        boolean a(com.google.android.material.snackbar.b.b b$b) {
            Object obj;
            int obj2;
            if (b != null && this.a.get() == b) {
                obj2 = this.a.get() == b ? 1 : 0;
            } else {
            }
            return obj2;
        }
    }
    private b() {
        super();
        Object object = new Object();
        this.a = object;
        b.a aVar = new b.a(this);
        Handler handler = new Handler(Looper.getMainLooper(), aVar);
        this.b = handler;
    }

    private boolean a(com.google.android.material.snackbar.b.c b$c, int i2) {
        Object obj = c.a.get();
        if ((b.b)obj != null) {
            this.b.removeCallbacksAndMessages(c);
            (b.b)obj.b(i2);
            return 1;
        }
        return 0;
    }

    static com.google.android.material.snackbar.b c() {
        com.google.android.material.snackbar.b bVar;
        if (b.e == null) {
            bVar = new b();
            b.e = bVar;
        }
        return b.e;
    }

    private boolean f(com.google.android.material.snackbar.b.b b$b) {
        com.google.android.material.snackbar.b.b obj2;
        final com.google.android.material.snackbar.b.c cVar = this.c;
        if (cVar != null && cVar.a(b)) {
            obj2 = cVar.a(b) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean g(com.google.android.material.snackbar.b.b b$b) {
        com.google.android.material.snackbar.b.b obj2;
        final com.google.android.material.snackbar.b.c cVar = this.d;
        if (cVar != null && cVar.a(b)) {
            obj2 = cVar.a(b) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private void l(com.google.android.material.snackbar.b.c b$c) {
        int i;
        int i2;
        i = c.b;
        if (i == -2) {
        }
        if (i > 0) {
        } else {
            i = i == -1 ? 1500 : i4;
        }
        this.b.removeCallbacksAndMessages(c);
        Handler handler2 = this.b;
        handler2.sendMessageDelayed(Message.obtain(handler2, 0, c), (long)i);
    }

    private void n() {
        Object cVar;
        int i;
        cVar = this.d;
        if (cVar != null) {
            this.c = cVar;
            i = 0;
            this.d = i;
            cVar = cVar.a.get();
            if ((b.b)cVar != null) {
                (b.b)cVar.a();
            } else {
                this.c = i;
            }
        }
    }

    public void b(com.google.android.material.snackbar.b.b b$b, int i2) {
        com.google.android.material.snackbar.b.c obj3;
        final Object obj = this.a;
        synchronized (obj) {
            a(this.c, i2);
        }
    }

    void d(com.google.android.material.snackbar.b.c b$c) {
        com.google.android.material.snackbar.b.c cVar;
        final Object obj = this.a;
        synchronized (obj) {
            if (this.d == c) {
                a(c, 2);
            }
            try {
                throw c;
            }
        }
    }

    public boolean e(com.google.android.material.snackbar.b.b b$b) {
        int obj3;
        final Object obj = this.a;
        synchronized (obj) {
            if (g(b)) {
                obj3 = 1;
            } else {
                try {
                    obj3 = 0;
                    obj3 = 1;
                    return obj3;
                    throw b;
                }
            }
        }
    }

    public void h(com.google.android.material.snackbar.b.b b$b) {
        boolean obj2;
        final Object obj = this.a;
        synchronized (obj) {
            this.c = 0;
            if (this.d != null) {
                n();
            }
            try {
                throw b;
            }
        }
    }

    public void i(com.google.android.material.snackbar.b.b b$b) {
        boolean obj2;
        final Object obj = this.a;
        synchronized (obj) {
            l(this.c);
        }
    }

    public void j(com.google.android.material.snackbar.b.b b$b) {
        boolean z;
        boolean obj3;
        final Object obj = this.a;
        synchronized (obj) {
            obj3 = this.c;
            if (!obj3.c) {
                obj3.c = true;
                this.b.removeCallbacksAndMessages(obj3);
            }
            try {
                throw b;
            }
        }
    }

    public void k(com.google.android.material.snackbar.b.b b$b) {
        boolean z;
        boolean obj3;
        final Object obj = this.a;
        synchronized (obj) {
            obj3 = this.c;
            if (obj3.c) {
                obj3.c = false;
                l(obj3);
            }
            try {
                throw b;
            }
        }
    }

    public void m(int i, com.google.android.material.snackbar.b.b b$b2) {
        boolean cVar;
        com.google.android.material.snackbar.b.c obj3;
        Object obj4;
        final Object obj = this.a;
        synchronized (obj) {
            obj4 = this.c;
            obj4.b = i;
            this.b.removeCallbacksAndMessages(obj4);
            l(this.c);
        }
    }
}
