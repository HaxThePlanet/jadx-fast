package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class t {

    static final Handler p;
    static volatile com.squareup.picasso.t q;
    private final com.squareup.picasso.t.d a;
    private final com.squareup.picasso.t.g b;
    private final com.squareup.picasso.t.c c;
    private final List<com.squareup.picasso.y> d;
    final Context e;
    final com.squareup.picasso.i f;
    final com.squareup.picasso.d g;
    final com.squareup.picasso.a0 h;
    final Map<Object, com.squareup.picasso.a> i;
    final Map<ImageView, com.squareup.picasso.h> j;
    final ReferenceQueue<Object> k;
    final Bitmap.Config l;
    boolean m;
    volatile boolean n;
    boolean o;

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            com.squareup.picasso.t size;
            int str;
            String str2;
            String str3;
            Object obj5;
            int what = message.what;
            if (what != 3) {
                str2 = 0;
                if (what != 8) {
                    if (what != 13) {
                    } else {
                        obj5 = message.obj;
                        while (str2 < (List)obj5.size()) {
                            str = obj5.get(str2);
                            str.a.n((a)str);
                            str2++;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown handler message received: ");
                    stringBuilder.append(message.what);
                    AssertionError assertionError = new AssertionError(stringBuilder.toString());
                    throw assertionError;
                }
                obj5 = message.obj;
                while (str2 < (List)obj5.size()) {
                    str = obj5.get(str2);
                    str.b.d((c)str);
                    str2++;
                }
            } else {
                obj5 = message.obj;
                if (tVar.n) {
                    f0.t("Main", "canceled", obj5.b.d(), "target got garbage collected");
                }
                obj5.a.a(obj5.k());
            }
        }
    }

    public static class b {

        private final Context a;
        private com.squareup.picasso.j b;
        private ExecutorService c;
        private com.squareup.picasso.d d;
        private com.squareup.picasso.t.d e;
        private com.squareup.picasso.t.g f;
        private List<com.squareup.picasso.y> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;
        public b(Context context) {
            super();
            if (context == null) {
            } else {
                this.a = context.getApplicationContext();
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Context must not be null.");
            throw obj2;
        }

        public com.squareup.picasso.t a() {
            com.squareup.picasso.j sVar;
            com.squareup.picasso.d mVar;
            Object vVar;
            com.squareup.picasso.t.g gVar;
            Context context2 = this.a;
            if (this.b == null) {
                sVar = new s(context2);
                this.b = sVar;
            }
            if (this.d == null) {
                mVar = new m(context2);
                this.d = mVar;
            }
            if (this.c == null) {
                vVar = new v();
                this.c = vVar;
            }
            if (this.f == null) {
                this.f = t.g.a;
            }
            a0 a0Var3 = new a0(this.d);
            final Context context = context2;
            super(context, this.c, t.p, this.b, this.d, a0Var3);
            super(context, iVar3, this.d, this.e, this.f, this.g, a0Var3, this.h, this.i, this.j);
            return tVar2;
        }

        public com.squareup.picasso.t.b b(Bitmap.Config bitmap$Config) {
            if (config == null) {
            } else {
                this.h = config;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Bitmap config must not be null.");
            throw obj2;
        }

        public com.squareup.picasso.t.b c(com.squareup.picasso.j j) {
            if (j == null) {
            } else {
                if (this.b != null) {
                } else {
                    this.b = j;
                    return this;
                }
                IllegalStateException obj2 = new IllegalStateException("Downloader already set.");
                throw obj2;
            }
            obj2 = new IllegalArgumentException("Downloader must not be null.");
            throw obj2;
        }

        public com.squareup.picasso.t.b d(ExecutorService executorService) {
            if (executorService == null) {
            } else {
                if (this.c != null) {
                } else {
                    this.c = executorService;
                    return this;
                }
                IllegalStateException obj2 = new IllegalStateException("Executor service already set.");
                throw obj2;
            }
            obj2 = new IllegalArgumentException("Executor service must not be null.");
            throw obj2;
        }
    }

    private static class c extends Thread {

        private final ReferenceQueue<Object> a;
        private final Handler b;
        c(ReferenceQueue<Object> referenceQueue, Handler handler2) {
            super();
            this.a = referenceQueue;
            this.b = handler2;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread
        public void run() {
            int remove;
            Object message;
            com.squareup.picasso.t.c.a aVar;
            Process.setThreadPriority(10);
            remove = this.a.remove(1000);
            message = this.b.obtainMessage();
            while (true) {
                message.what = 3;
                message.obj = remove.a;
                this.b.sendMessage(message);
                remove = this.a.remove(1000);
                message = this.b.obtainMessage();
                message.recycle();
            }
        }
    }

    public interface d {
        public abstract void a(com.squareup.picasso.t t, Uri uri2, Exception exception3);
    }

    public static enum e {

        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);

        final int debugColor;
    }

    public static enum f {

        LOW,
        NORMAL,
        HIGH;
    }

    public interface g {

        public static final com.squareup.picasso.t.g a;
        static {
            t.g.a aVar = new t.g.a();
            t.g.a = aVar;
        }

        public abstract com.squareup.picasso.w a(com.squareup.picasso.w w);
    }
    static {
        t.a aVar = new t.a(Looper.getMainLooper());
        t.p = aVar;
        t.q = 0;
    }

    t(Context context, com.squareup.picasso.i i2, com.squareup.picasso.d d3, com.squareup.picasso.t.d t$d4, com.squareup.picasso.t.g t$g5, List<com.squareup.picasso.y> list6, com.squareup.picasso.a0 a07, Bitmap.Config bitmap$Config8, boolean z9, boolean z10) {
        int obj3;
        super();
        this.e = context;
        this.f = i2;
        this.g = d3;
        this.a = d4;
        this.b = g5;
        this.l = config8;
        if (list6 != null) {
            obj3 = list6.size();
        } else {
            obj3 = 0;
        }
        ArrayList obj4 = new ArrayList(obj3 += 7);
        obj3 = new z(context);
        obj4.add(obj3);
        if (list6 != null) {
            obj4.addAll(list6);
        }
        obj3 = new f(context);
        obj4.add(obj3);
        obj3 = new o(context);
        obj4.add(obj3);
        obj3 = new g(context);
        obj4.add(obj3);
        obj3 = new b(context);
        obj4.add(obj3);
        obj3 = new k(context);
        obj4.add(obj3);
        r obj1 = new r(i2.d, a07);
        obj4.add(obj1);
        this.d = Collections.unmodifiableList(obj4);
        this.h = a07;
        obj1 = new WeakHashMap();
        this.i = obj1;
        obj1 = new WeakHashMap();
        this.j = obj1;
        this.m = z9;
        this.n = z10;
        obj1 = new ReferenceQueue();
        this.k = obj1;
        t.c obj2 = new t.c(obj1, t.p);
        this.c = obj2;
        obj2.start();
    }

    private void f(Bitmap bitmap, com.squareup.picasso.t.e t$e2, com.squareup.picasso.a a3, Exception exception4) {
        boolean z;
        Object obj;
        boolean obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (a3.l()) {
        }
        if (!a3.m()) {
            this.i.remove(a3.k());
        }
        String str = "Main";
        if (bitmap != null) {
            if (e2 == null) {
            } else {
                a3.b(bitmap, e2);
                if (this.n) {
                    obj5 = new StringBuilder();
                    obj5.append("from ");
                    obj5.append(e2);
                    f0.t(str, "completed", a3.b.d(), obj5.toString());
                }
            }
            obj3 = new AssertionError("LoadedFrom cannot be null.");
            throw obj3;
        }
        a3.c(exception4);
        if (this.n) {
            f0.t(str, "errored", a3.b.d(), exception4.getMessage());
        }
    }

    public static com.squareup.picasso.t h() {
        com.squareup.picasso.t tVar;
        Object th;
        com.squareup.picasso.t.b bVar;
        tVar = t.class;
        if (t.q == null && t.q == null) {
            tVar = t.class;
            synchronized (tVar) {
                Context context = PicassoProvider.a;
                if (context == null) {
                } else {
                    bVar = new t.b(context);
                    t.q = bVar.a();
                }
                IllegalStateException illegalStateException = new IllegalStateException("context == null");
                throw illegalStateException;
            }
        }
        try {
            return t.q;
        }
    }

    void a(Object object) {
        boolean map;
        com.squareup.picasso.i iVar;
        Object obj3;
        f0.c();
        Object remove = this.i.remove(object);
        if ((a)remove != null) {
            (a)remove.a();
            this.f.c(remove);
        }
        obj3 = this.j.remove((ImageView)object);
        if (object instanceof ImageView != null && (h)obj3 != null) {
            obj3 = this.j.remove((ImageView)object);
            if ((h)(h)obj3 != null) {
                (h)(h)obj3.a();
            }
        }
    }

    public void b(ImageView imageView) {
        if (imageView == null) {
        } else {
            a(imageView);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("view cannot be null.");
        throw obj2;
    }

    public void c(com.squareup.picasso.c0 c0) {
        if (c0 == null) {
        } else {
            a(c0);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("target cannot be null.");
        throw obj2;
    }

    void d(com.squareup.picasso.c c) {
        com.squareup.picasso.a size;
        int i2;
        int i3;
        boolean empty;
        int i;
        size = c.h();
        final List list = c.i();
        i3 = 0;
        if (list != null && !list.isEmpty()) {
            i = !list.isEmpty() ? i2 : i3;
        } else {
        }
        if (size == null) {
            if (i != 0) {
            } else {
                i2 = i3;
            }
        }
        if (i2 == 0) {
        }
        final Exception exc = c.k();
        final Bitmap bitmap = c.s();
        com.squareup.picasso.t.e obj8 = c.o();
        if (size != null) {
            f(bitmap, obj8, size, exc);
        }
        if (i != 0) {
            while (i3 < list.size()) {
                f(bitmap, obj8, (a)list.get(i3), exc);
                i3++;
            }
        }
        obj8 = this.a;
        if (obj8 != null && exc != null) {
            if (exc != null) {
                obj8.a(this, wVar.d, exc);
            }
        }
    }

    void e(ImageView imageView, com.squareup.picasso.h h2) {
        if (this.j.containsKey(imageView)) {
            a(imageView);
        }
        this.j.put(imageView, h2);
    }

    void g(com.squareup.picasso.a a) {
        Object obj;
        final Object obj2 = a.k();
        if (obj2 != null && this.i.get(obj2) != a) {
            if (this.i.get(obj2) != a) {
                a(obj2);
                this.i.put(obj2, a);
            }
        }
        o(a);
    }

    List<com.squareup.picasso.y> i() {
        return this.d;
    }

    public com.squareup.picasso.x j(Uri uri) {
        x xVar = new x(this, uri, 0);
        return xVar;
    }

    public com.squareup.picasso.x k(File file) {
        if (file == null) {
            x obj3 = new x(this, 0, 0);
            return obj3;
        }
        return j(Uri.fromFile(file));
    }

    public com.squareup.picasso.x l(String string) {
        if (string == null) {
            x obj3 = new x(this, 0, 0);
            return obj3;
        }
        if (string.trim().length() == 0) {
        } else {
            return j(Uri.parse(string));
        }
        obj3 = new IllegalArgumentException("Path must not be empty.");
        throw obj3;
    }

    Bitmap m(String string) {
        com.squareup.picasso.a0 a0Var;
        final Bitmap obj2 = this.g.get(string);
        if (obj2 != null) {
            this.h.d();
        } else {
            this.h.e();
        }
        return obj2;
    }

    void n(com.squareup.picasso.a a) {
        int i;
        boolean string;
        int str;
        com.squareup.picasso.t.e mEMORY;
        Object obj5;
        str = 0;
        if (p.shouldReadFromMemoryCache(a.e)) {
            i = m(a.d());
        } else {
            i = str;
        }
        final String str4 = "Main";
        if (i != 0) {
            mEMORY = t.e.MEMORY;
            f(i, mEMORY, a, str);
            if (this.n) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append(mEMORY);
                f0.t(str4, "completed", a.b.d(), stringBuilder.toString());
            }
        } else {
            g(a);
            if (this.n) {
                f0.s(str4, "resumed", a.b.d());
            }
        }
    }

    void o(com.squareup.picasso.a a) {
        this.f.h(a);
    }

    com.squareup.picasso.w p(com.squareup.picasso.w w) {
        this.b.a(w);
        if (w == null) {
        } else {
            return w;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request transformer ");
        stringBuilder.append(this.b.getClass().getCanonicalName());
        stringBuilder.append(" returned null for ");
        stringBuilder.append(w);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }
}
