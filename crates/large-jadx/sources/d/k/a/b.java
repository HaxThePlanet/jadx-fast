package d.k.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b<T extends d.k.a.b<T>>  implements d.k.a.a.b {

    public static final d.k.a.b.k m;
    public static final d.k.a.b.k n;
    public static final d.k.a.b.k o;
    public static final d.k.a.b.k p;
    public static final d.k.a.b.k q;
    public static final d.k.a.b.k r;
    float a = 0f;
    float b = 340282350000000000000000000000000000000f;
    boolean c = false;
    final Object d;
    final d.k.a.c e;
    boolean f = false;
    float g = 340282350000000000000000000000000000000f;
    float h = 340282350000000000000000000000000000000f;
    private long i = 0;
    private float j;
    private final ArrayList<d.k.a.b.i> k;
    private final ArrayList<d.k.a.b.j> l;

    static class h {

        float a;
        float b;
    }

    public interface i {
        public abstract void a(d.k.a.b b, boolean z2, float f3, float f4);
    }

    public interface j {
        public abstract void a(d.k.a.b b, float f2, float f3);
    }

    public static abstract class k extends d.k.a.c<View> {
        private k(String string) {
            super(string);
        }

        k(String string, d.k.a.b.b b$b2) {
            super(string);
        }
    }

    static class a extends d.k.a.b.k {
        a(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getAlpha();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setAlpha(f2);
        }
    }

    static class b extends d.k.a.b.k {
    }

    static class c extends d.k.a.b.k {
        c(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getScaleX();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setScaleX(f2);
        }
    }

    static class d extends d.k.a.b.k {
        d(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getScaleY();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setScaleY(f2);
        }
    }

    static class e extends d.k.a.b.k {
        e(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotation();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setRotation(f2);
        }
    }

    static class f extends d.k.a.b.k {
        f(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotationX();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setRotationX(f2);
        }
    }

    static class g extends d.k.a.b.k {
        g(String string) {
            super(string, 0);
        }

        @Override // d.k.a.b$k
        public float a(Object object) {
            return c((View)object);
        }

        @Override // d.k.a.b$k
        public void b(Object object, float f2) {
            d((View)object, f2);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotationY();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f2) {
            view.setRotationY(f2);
        }
    }
    static {
        b.c cVar = new b.c("scaleX");
        b.m = cVar;
        b.d dVar = new b.d("scaleY");
        b.n = dVar;
        b.e eVar = new b.e("rotation");
        b.o = eVar;
        b.f fVar = new b.f("rotationX");
        b.p = fVar;
        b.g gVar = new b.g("rotationY");
        b.q = gVar;
        b.a aVar = new b.a("alpha");
        b.r = aVar;
    }

    b(K k, d.k.a.c<K> c2) {
        ArrayList arrayList;
        d.k.a.b.k obj3;
        super();
        int i = 0;
        final int i5 = 0;
        int i3 = -i2;
        int i4 = 0;
        ArrayList arrayList2 = new ArrayList();
        this.k = arrayList2;
        arrayList = new ArrayList();
        this.l = arrayList;
        this.d = k;
        this.e = c2;
        if (c2 != b.o && c2 != b.p) {
            if (c2 != b.p) {
                if (c2 == b.q) {
                    this.j = 1036831949;
                } else {
                    arrayList = 998244352;
                    if (c2 == b.r) {
                        this.j = arrayList;
                    } else {
                        if (c2 != b.m) {
                            if (c2 == b.n) {
                                this.j = arrayList;
                            } else {
                                this.j = 1065353216;
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        } else {
        }
    }

    private void b(boolean z) {
        int i;
        int i2;
        float f;
        float f2;
        i = 0;
        this.f = i;
        a.d().g(this);
        this.i = 0;
        this.c = i;
        while (i < this.k.size()) {
            if (this.k.get(i) != null) {
            }
            i++;
            (b.i)this.k.get(i).a(this, z, this.b, this.a);
        }
        b.f(this.k);
    }

    private float c() {
        return this.e.a(this.d);
    }

    private static <T> void f(ArrayList<T> arrayList) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            if (arrayList.get(i) == null) {
            }
            i--;
            arrayList.remove(i);
        }
    }

    private void j() {
        boolean z;
        boolean z2;
        float cmp2;
        int i;
        int cmp;
        this.f = true;
        if (!this.f && !this.c) {
            this.f = true;
            if (!this.c) {
                this.b = c();
            }
            cmp2 = this.b;
            if (Float.compare(cmp2, f) > 0) {
            } else {
                if (Float.compare(cmp2, cmp) < 0) {
                } else {
                    a.d().a(this, 0);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Starting value need to be in between min value and max value");
            throw illegalArgumentException;
        }
    }

    @Override // d.k.a.a$b
    public boolean a(long l) {
        long l2 = this.i;
        final int i3 = 0;
        if (Long.compare(l2, i2) == 0) {
            this.i = l;
            g(this.b);
            return i3;
        }
        this.i = l;
        boolean obj5 = k(l - l2);
        float obj6 = Math.min(this.b, this.g);
        this.b = obj6;
        obj6 = Math.max(obj6, this.h);
        this.b = obj6;
        g(obj6);
        if (obj5 != null) {
            b(i3);
        }
        return obj5;
    }

    @Override // d.k.a.a$b
    float d() {
        return f *= i2;
    }

    @Override // d.k.a.a$b
    public boolean e() {
        return this.f;
    }

    @Override // d.k.a.a$b
    void g(float f) {
        d.k.a.c cVar;
        Object obj;
        float f2;
        int obj4;
        this.e.b(this.d, f);
        obj4 = 0;
        while (obj4 < this.l.size()) {
            if (this.l.get(obj4) != null) {
            }
            obj4++;
            (b.j)this.l.get(obj4).a(this, this.b, this.a);
        }
        b.f(this.l);
    }

    public T h(float f) {
        this.b = f;
        this.c = true;
        return this;
    }

    @Override // d.k.a.a$b
    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
        } else {
            if (!this.f) {
                j();
            }
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animations may only be started on the main thread");
        throw androidRuntimeException;
    }

    @Override // d.k.a.a$b
    abstract boolean k(long l);
}
