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

/* compiled from: Picasso.java */
/* loaded from: classes2.dex */
public class t {

    static final Handler p = new t$a();
    static volatile t q;
    private final t.d a;
    private final t.g b;
    private final t.c c = new t$c();
    private final List<y> d;
    final Context e;
    final i f;
    final d g;
    final a0 h;
    final Map<Object, a> i = new WeakHashMap<>();
    final Map<ImageView, h> j = new WeakHashMap<>();
    final ReferenceQueue<Object> k = new ReferenceQueue<>();
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
            int i = 3;
            String str;
            int i2 = 0;
            String str2;
            com.squareup.picasso.t tVar2;
            com.squareup.picasso.t tVar3;
            i = 3;
            if (message.what != 3) {
                i = 8;
                i2 = 0;
                if (message.what != 8) {
                    i = 13;
                    if (message.what != 13) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str5 = "Unknown handler message received: ";
                        message = str5 + message.what;
                        throw new AssertionError(message);
                    } else {
                        while (i2 < obj2.size()) {
                            Object item2 = obj2.get(i2);
                            item2.a.n(item2);
                            i2 = i2 + 1;
                        }
                    }
                }
                while (i2 < obj2.size()) {
                    Object item = obj2.get(i2);
                    item.b.d(item);
                    i2 = i2 + 1;
                }
            } else {
                if (obj22.g().n) {
                    str = "canceled";
                    str2 = "target got garbage collected";
                    f0.t("Main", str, obj22.b.d(), str2);
                }
                obj22.a.a(obj22.k());
            }
        }
    }

    public static class b {

        private final Context a;
        private j b;
        private ExecutorService c;
        private d d;
        private t.d e;
        private t.g f;
        private List<y> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;
        public b(Context context) {
            super();
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            } else {
                this.a = context.getApplicationContext();
                return;
            }
        }

        public t a() {
            if (this.b == null) {
                this.b = new s(context);
            }
            if (this.d == null) {
                this.d = new m(context);
            }
            if (this.c == null) {
                this.c = new v();
            }
            if (this.f == null) {
                this.f = t.g.a;
            }
            com.squareup.picasso.a0 a0Var = new a0(this.d);
            i iVar = new i(context, this.c, t.p, this.b, this.d, a0Var);
            t tVar = new t(context, iVar, this.d, this.e, this.f, this.g, a0Var, config, z, z2);
            return tVar;
        }

        public t.b b(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Bitmap config must not be null.");
            } else {
                this.h = config;
                return this;
            }
        }

        public t.b c(j jVar) {
            if (jVar == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else {
                if (this.b != null) {
                    throw new IllegalStateException("Downloader already set.");
                } else {
                    this.b = jVar;
                    return this;
                }
            }
        }

        public t.b d(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else {
                if (this.c != null) {
                    throw new IllegalStateException("Executor service already set.");
                } else {
                    this.c = executorService;
                    return this;
                }
            }
        }
    }

    private static class c extends Thread {

        private final ReferenceQueue<Object> a;
        private final Handler b;
        c(ReferenceQueue<Object> referenceQueue, Handler handler) {
            super();
            this.a = referenceQueue;
            this.b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread
        public void run() {
            int i2 = 3;
            int i = 10;
            Process.setThreadPriority(i);
            java.lang.ref.Reference remove = this.a.remove(1000L);
            Message message = this.b.obtainMessage();
            while (true) {
                i2 = 3;
                message.what = i2;
                message.obj = remove.a;
                this.b.sendMessage(message);
                try {
                    remove = this.a.remove(1000L);
                    message = this.b.obtainMessage();
                    i2 = 3;
                    message.what = i2;
                    message.obj = remove.a;
                    this.b.sendMessage(message);
                    message.recycle();
                } catch (Exception e) {
                    this.b.post(new t.c.a(this, e));
                } catch (java.lang.InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public interface d {
        void a(t tVar, Uri uri, Exception exc);
    }

    public enum e {

        DISK,
        MEMORY,
        NETWORK;

        final int debugColor;
    }

    public enum f {

        HIGH,
        LOW,
        NORMAL;
    }

    public interface g {

        public static final t.g a = new t$g$a();

        w a(w wVar);
    }
    static {
        t.q = null;
    }

    t(Context context, i iVar, d dVar, t.d dVar2, t.g gVar, List<y> list, a0 a0Var, Bitmap.Config config, boolean z, boolean z2) throws java.lang.IllegalThreadStateException {
        int size = 0;
        super();
        this.e = context;
        this.f = iVar;
        this.g = dVar;
        this.a = dVar2;
        this.b = gVar;
        this.l = config;
        if (list != null) {
            size = list.size();
        } else {
            size = 0;
        }
        final ArrayList arrayList = new ArrayList(size + 7);
        arrayList.add(new z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new f(context));
        arrayList.add(new o(context));
        arrayList.add(new g(context));
        arrayList.add(new b(context));
        arrayList.add(new k(context));
        arrayList.add(new r(iVar.d, a0Var));
        this.d = Collections.unmodifiableList(arrayList);
        this.h = a0Var;
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakHashMap weakHashMap2 = new WeakHashMap();
        this.m = z;
        this.n = z2;
        new t.c(new ReferenceQueue(), t.p).start();
    }

    private void f(Bitmap bitmap, t.e eVar, a aVar, Exception exc) {
        if (aVar.l()) {
            return;
        }
        if (!aVar.m()) {
            this.i.remove(aVar.k());
        }
        String str3 = "Main";
        if (bitmap != null) {
            if (eVar == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                aVar.b(bitmap, eVar);
                if (this.n) {
                    StringBuilder stringBuilder = new StringBuilder();
                    str2 = "from ";
                    message = str2 + eVar;
                    str = "completed";
                    f0.t(str3, str, aVar.b.d(), message);
                }
                return;
            }
        }
        aVar.c(exc);
        if (this.n) {
            str = "errored";
            f0.t(str3, str, aVar.b.d(), exc.getMessage());
        }
    }

    public static t h() {
        com.squareup.picasso.t tVar2;
        com.squareup.picasso.t.b bVar;
        if (t.q == null) {
            tVar = t.class;
            synchronized (tVar) {
                try {
                    if (t.q == null) {
                        Context context = PicassoProvider.a;
                        if (PicassoProvider.a == null) {
                            throw new IllegalStateException("context == null");
                        } else {
                            t.q = new t.b(PicassoProvider.a).a();
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
        return t.q;
    }

    void a(Object object) {
        f0.c();
        Object remove2 = this.i.remove(object);
        if (remove2 != null) {
            remove2.a();
            this.f.c(remove2);
        }
        z = object instanceof ImageView;
        if (object instanceof ImageView) {
            Object remove = this.j.remove(object);
            if (remove != null) {
                remove.a();
            }
        }
    }

    public void b(ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("view cannot be null.");
        } else {
            a(imageView);
            return;
        }
    }

    public void c(c0 c0Var) {
        if (c0Var == null) {
            throw new IllegalArgumentException("target cannot be null.");
        } else {
            a(c0Var);
            return;
        }
    }

    void d(c cVar) {
        int i = 1;
        com.squareup.picasso.a aVar = cVar.h();
        final List list = cVar.i();
        i = 1;
        i = 0;
        int r4 = list != null && !list.isEmpty() ? 1 : i;
        if (aVar == null) {
            if (i == 0) {
            }
        }
        if (i == 0) {
            return;
        }
        final Exception exc = cVar.k();
        final Bitmap bitmap = cVar.s();
        com.squareup.picasso.t.e eVar = cVar.o();
        if (aVar != null) {
            f(bitmap, eVar, aVar, exc);
        }
        if (i != 0) {
            while (i < list.size()) {
                f(bitmap, eVar, (a)list.get(i), exc);
                i = i + 1;
            }
        }
        if (this.a != null && exc != null) {
            this.a.a(this, cVar.j().d, exc);
        }
    }

    void e(ImageView imageView, h hVar) {
        if (this.j.containsKey(imageView)) {
            a(imageView);
        }
        this.j.put(imageView, hVar);
    }

    void g(a aVar) {
        final Object obj = aVar.k();
        if (obj != null) {
            if (this.i.get(obj) != aVar) {
                a(obj);
                this.i.put(obj, aVar);
            }
        }
        o(aVar);
    }

    List<y> i() {
        return this.d;
    }

    public x j(Uri uri) {
        return new x(this, uri, 0);
    }

    public x k(File file) {
        if (file == null) {
            return new x(this, null, 0);
        }
        return j(Uri.fromFile(file));
    }

    public x l(String str) {
        if (str == null) {
            return new x(this, null, 0);
        }
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Path must not be empty.");
        } else {
            return j(Uri.parse(str));
        }
    }

    Bitmap m(String str) {
        final Bitmap bitmap = this.g.get(str);
        if (bitmap != null) {
            this.h.d();
        } else {
            this.h.e();
        }
        return bitmap;
    }

    void n(a aVar) {
        Bitmap bitmap;
        Exception exc = null;
        if (p.shouldReadFromMemoryCache(aVar.e)) {
            bitmap = m(aVar.d());
        } else {
            int i2 = exc;
        }
        final String str7 = "Main";
        if (aVar.e != null) {
            mEMORY2 = t.e.MEMORY;
            f(bitmap, mEMORY2, aVar, exc);
            if (this.n) {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "from ";
                str3 = str5 + t.e.MEMORY;
                f0.t(str7, "completed", aVar.b.d(), str3);
            }
        } else {
            g(aVar);
            if (this.n) {
                f0.s(str7, "resumed", aVar.b.d());
            }
        }
    }

    void o(a aVar) {
        this.f.h(aVar);
    }

    w p(w wVar) {
        this.b.a(wVar);
        if (wVar == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str = "Request transformer ";
            String canonicalName = this.b.getClass().getCanonicalName();
            String str2 = " returned null for ";
            wVar = str + canonicalName + str2 + wVar;
            throw new IllegalStateException(wVar);
        } else {
            return wVar;
        }
    }
}
