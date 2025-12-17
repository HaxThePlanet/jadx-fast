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

/* loaded from: classes2.dex */
public final class d {

    public static final io.grpc.d k;
    private io.grpc.u a;
    private Executor b;
    private String c;
    private io.grpc.c d;
    private String e;
    private Object[][] f;
    private List<io.grpc.l.a> g;
    private Boolean h;
    private Integer i;
    private Integer j;

    public static final class a {

        private final String a;
        private final T b;
        private a(String string, T t2) {
            super();
            this.a = string;
            this.b = t2;
        }

        static Object a(io.grpc.d.a d$a) {
            return a.b;
        }

        public static <T> io.grpc.d.a<T> b(String string) {
            n.p(string, "debugString");
            d.a aVar = new d.a(string, 0);
            return aVar;
        }

        public String toString() {
            return this.a;
        }
    }
    static {
        d dVar = new d();
        d.k = dVar;
    }

    private d() {
        super();
        this.g = Collections.emptyList();
        int[] iArr = new int[2];
        iArr = new int[]{0, 2};
        this.f = (Object[][])Array.newInstance(Object.class, iArr);
    }

    private d(io.grpc.d d) {
        super();
        this.g = Collections.emptyList();
        this.a = d.a;
        this.c = d.c;
        this.d = d.d;
        this.b = d.b;
        this.e = d.e;
        this.f = d.f;
        this.h = d.h;
        this.i = d.i;
        this.j = d.j;
        this.g = d.g;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    public io.grpc.c c() {
        return this.d;
    }

    public io.grpc.u d() {
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

    public <T> T h(io.grpc.d.a<T> d$a) {
        int i;
        boolean equals;
        int length;
        n.p(a, "key");
        int i2 = 0;
        i = i2;
        Object[][] arr = this.f;
        for (Object objArr : obj2) {
            arr = this.f;
        }
        return d.a.a(a);
    }

    public List<io.grpc.l.a> i() {
        return this.g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.h);
    }

    public io.grpc.d k(io.grpc.c c) {
        d dVar = new d(this);
        dVar.d = c;
        return dVar;
    }

    public io.grpc.d l(io.grpc.u u) {
        d dVar = new d(this);
        dVar.a = u;
        return dVar;
    }

    public io.grpc.d m(long l, TimeUnit timeUnit2) {
        return l(u.a(l, timeUnit2));
    }

    public io.grpc.d n(Executor executor) {
        d dVar = new d(this);
        dVar.b = executor;
        return dVar;
    }

    public io.grpc.d o(int i) {
        int i2;
        i2 = i >= 0 ? 1 : 0;
        n.h(i2, "invalid maxsize %s", i);
        d dVar = new d(this);
        dVar.i = Integer.valueOf(i);
        return dVar;
    }

    public io.grpc.d p(int i) {
        int i2;
        i2 = i >= 0 ? 1 : 0;
        n.h(i2, "invalid maxsize %s", i);
        d dVar = new d(this);
        dVar.j = Integer.valueOf(i);
        return dVar;
    }

    public <T> io.grpc.d q(io.grpc.d.a<T> d$a, T t2) {
        int i2;
        boolean equals;
        Object[][] length2;
        int length;
        int i;
        Object[] arr;
        int i3;
        n.p(a, "key");
        n.p(t2, "value");
        d dVar = new d(this);
        final int i4 = 0;
        i2 = i4;
        equals = this.f;
        i = -1;
        for (Object objArr : obj3) {
            equals = this.f;
            i = -1;
        }
        i2 = i;
        int i6 = 1;
        i3 = i2 == i ? i6 : i4;
        int i7 = 2;
        int[] iArr = new int[i7];
        iArr[i6] = i7;
        iArr[i4] = length3 += i3;
        Object instance = Array.newInstance(Object.class, iArr);
        dVar.f = (Object[][])instance;
        Object[][] arr4 = this.f;
        System.arraycopy(arr4, i4, instance, i4, arr4.length);
        if (i2 == i) {
            arr = new Object[i7];
            arr[i4] = a;
            arr[i6] = t2;
            dVar.f[arr3.length] = arr;
        } else {
            arr = new Object[i7];
            arr[i4] = a;
            arr[i6] = t2;
            dVar.f[i2] = arr;
        }
        return dVar;
    }

    public io.grpc.d r(io.grpc.l.a l$a) {
        d dVar = new d(this);
        ArrayList arrayList = new ArrayList(size++);
        arrayList.addAll(this.g);
        arrayList.add(a);
        dVar.g = Collections.unmodifiableList(arrayList);
        return dVar;
    }

    public io.grpc.d s() {
        d dVar = new d(this);
        dVar.h = Boolean.TRUE;
        return dVar;
    }

    public io.grpc.d t() {
        d dVar = new d(this);
        dVar.h = Boolean.FALSE;
        return dVar;
    }

    public String toString() {
        Class class;
        j.b bVar = j.c(this);
        bVar.d("deadline", this.a);
        bVar.d("authority", this.c);
        bVar.d("callCredentials", this.d);
        Executor executor = this.b;
        if (executor != null) {
            class = executor.getClass();
        } else {
            class = 0;
        }
        bVar.d("executor", class);
        bVar.d("compressorName", this.e);
        bVar.d("customOptions", Arrays.deepToString(this.f));
        bVar.e("waitForReady", j());
        bVar.d("maxInboundMessageSize", this.i);
        bVar.d("maxOutboundMessageSize", this.j);
        bVar.d("streamTracerFactories", this.g);
        return bVar.toString();
    }
}
