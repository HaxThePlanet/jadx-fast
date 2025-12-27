package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: CallOptions.java */
/* loaded from: classes2.dex */
public final class d {

    public static final d k = new d();
    private u a;
    private Executor b;
    private String c;
    private c d;
    private String e;
    private Object[][] f;
    private List<l.a> g;
    private Boolean h;
    private Integer i;
    private Integer j;

    public static final class a<T> {

        private final String a;
        private final T b;
        private a(String str, T t) {
            super();
            this.a = str;
            this.b = t;
        }

        static /* synthetic */ Object a(d.a aVar) {
            return aVar.b;
        }

        public static <T> d.a<T> b(String str) {
            n.p(str, "debugString");
            return new d.a(str, null);
        }

        public String toString() {
            return this.a;
        }
    }

    private d() {
        super();
        this.g = Collections.emptyList();
        this.f = (Object[][])Array.newInstance(Object.class, new int[] { 0, 2 });
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    public c c() {
        return this.d;
    }

    public u d() {
        return this.a;
    }

    public Executor e() {
        return this.b;
    }

    public Integer f() {
        return this.i;
    }

    public Integer g() {
        return this.j;
    }

    public <T> T h(d.a<T> aVar) {
        int i;
        n.p(aVar, "key");
        i = 0;
        length = arr.length;
        while (i < arr.length) {
            if (aVar.equals(arr[i][i])) {
                return this.f[i][1];
            }
        }
        return aVar.b;
    }

    public List<l.a> i() {
        return this.g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.h);
    }

    public d k(c cVar) {
        final io.grpc.d dVar = new d(this);
        dVar.d = cVar;
        return dVar;
    }

    public d l(u uVar) {
        final io.grpc.d dVar = new d(this);
        dVar.a = uVar;
        return dVar;
    }

    public d m(long j, TimeUnit timeUnit) {
        return l(u.a(j, timeUnit));
    }

    public d n(Executor executor) {
        final io.grpc.d dVar = new d(this);
        dVar.b = executor;
        return dVar;
    }

    public d o(int i) {
        boolean z = true;
        int r0 = i >= 0 ? 1 : 0;
        n.h((i >= 0 ? 1 : 0), "invalid maxsize %s", i);
        r0 = new d(this);
        r0.i = Integer.valueOf(i);
        return r0;
    }

    public d p(int i) {
        boolean z = true;
        int r0 = i >= 0 ? 1 : 0;
        n.h((i >= 0 ? 1 : 0), "invalid maxsize %s", i);
        r0 = new d(this);
        r0.j = Integer.valueOf(i);
        return r0;
    }

    public <T> d q(d.a<T> aVar, T t) {
        int i;
        n.p(aVar, "key");
        n.p(t, "value");
        io.grpc.d dVar = new d(this);
        i = 0;
        length = arr4.length;
        i = -1;
        for (Object[] objArr : arr4) {
            if (aVar.equals(objArr[i])) {
                break;
            }
        }
        i = 1;
        int r6 = i;
        r6 = 2;
        int[] iArr = new int[i];
        iArr[i] = r6;
        iArr[i] = this.f.length + i;
        Object array = Array.newInstance(Object.class, iArr);
        dVar.f = array;
        System.arraycopy(this.f, i, array, i, arr7.length);
        if (i == i) {
            Object[] arr2 = new Object[2];
            arr2[i] = aVar;
            arr2[i] = t;
            dVar.f[this.f.length] = arr2;
        } else {
            arr2 = new Object[r6];
            arr2[i] = aVar;
            arr2[i] = t;
            dVar.f[i] = arr2;
        }
        return dVar;
    }

    public d r(l.a aVar) {
        final io.grpc.d dVar = new d(this);
        final ArrayList arrayList = new ArrayList(this.g.size() + 1);
        arrayList.addAll(this.g);
        arrayList.add(aVar);
        dVar.g = Collections.unmodifiableList(arrayList);
        return dVar;
    }

    public d s() {
        final io.grpc.d dVar = new d(this);
        dVar.h = Boolean.TRUE;
        return dVar;
    }

    public d t() {
        final io.grpc.d dVar = new d(this);
        dVar.h = Boolean.FALSE;
        return dVar;
    }

    public String toString() {
        Class cls = null;
        j.b bVar = j.c(this);
        bVar.d("deadline", this.a);
        bVar.d("authority", this.c);
        bVar.d("callCredentials", this.d);
        if (this.b != null) {
            cls = this.b.getClass();
        } else {
            int i = 0;
        }
        bVar.d("executor", cls);
        bVar.d("compressorName", this.e);
        bVar.d("customOptions", Arrays.deepToString(this.f));
        bVar.e("waitForReady", j());
        bVar.d("maxInboundMessageSize", this.i);
        bVar.d("maxOutboundMessageSize", this.j);
        bVar.d("streamTracerFactories", this.g);
        return bVar.toString();
    }

    private d(d dVar) {
        super();
        this.g = Collections.emptyList();
        this.a = dVar.a;
        this.c = dVar.c;
        this.d = dVar.d;
        this.b = dVar.b;
        this.e = dVar.e;
        this.f = dVar.f;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.g = dVar.g;
    }
}
