package d.k.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

/* compiled from: DynamicAnimation.java */
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {

    public static final b.k m = new b$c("scaleX");
    public static final b.k n = new b$d("scaleY");
    public static final b.k o = new b$e("rotation");
    public static final b.k p = new b$f("rotationX");
    public static final b.k q = new b$g("rotationY");
    public static final b.k r = new b$a("alpha");
    float a = 0f;
    float b = 340282350000000000000000000000000000000f;
    boolean c = false;
    final Object d;
    final c e;
    boolean f = false;
    float g = 340282350000000000000000000000000000000f;
    float h;
    private long i = 0;
    private float j;
    private final ArrayList<b.i> k = new ArrayList<>();
    private final ArrayList<b.j> l = new ArrayList<>();

    static class h {

        float a;
        float b;
        h() {
            super();
        }
    }

    public interface i {
        void a(b bVar, boolean z, float f, float f2);
    }

    public interface j {
        void a(b bVar, float f, float f2);
    }

    public static abstract class k extends c<View> {
        /* synthetic */ k(String str, b.b bVar) {
            this(str);
        }

        private k(String str) {
            super(str);
        }
    }

    static class a extends b.k {
        a(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getAlpha();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setAlpha(f);
        }
    }

    static class b extends b.k {
    }

    static class c extends b.k {
        c(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getScaleX();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setScaleX(f);
        }
    }

    static class d extends b.k {
        d(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getScaleY();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setScaleY(f);
        }
    }

    static class e extends b.k {
        e(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotation();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setRotation(f);
        }
    }

    static class f extends b.k {
        f(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotationX();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setRotationX(f);
        }
    }

    static class g extends b.k {
        g(String str) {
            super(str, null);
        }

        @Override // d.k.a.b$k
        public float c(View view) {
            return view.getRotationY();
        }

        @Override // d.k.a.b$k
        public void d(View view, float f) {
            view.setRotationY(f);
        }
    }

    b(K k, c<K> cVar) {
        d.k.a.b.k kVar2;
        super();
        this.h = -(0x7f7fffff /* Unknown resource */);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.d = k;
        this.e = cVar;
        if (cVar == b.o || !(cVar == b.p && cVar != b.q)) {
            float f = 0.1f;
            this.j = f;
        }
    }

    private void b(boolean z) {
        int i = 0;
        long l;
        float f;
        float f2;
        boolean z2 = false;
        this.f = z2;
        a.d().g(this);
        l = 0L;
        this.i = l;
        this.c = z2;
        while (i < this.k.size()) {
            i = i + 1;
        }
        b.f(this.k);
    }

    private float c() {
        return this.e.a(this.d);
    }

    private static <T> void f(ArrayList<T> arrayList) {
        int i;
        i = arrayList.size() - 1;
        while (i >= 0) {
            i = i - 1;
        }
    }

    private void j() {
        if (!this.f) {
            this.f = true;
            if (!this.c) {
                this.b = c();
            }
            if (this.b > this.g) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            } else {
                if (this.b >= this.h) {
                    long l = 0L;
                    a.d().a(this, l);
                }
            }
        }
    }

    public boolean a(long j) {
        final boolean z = false;
        if (this.i == 0) {
            this.i = j;
            g(this.b);
            return false;
        }
        this.i = j;
        boolean z2 = k(j - l);
        float min = Math.min(this.b, this.g);
        this.b = min;
        float max = Math.max(min, this.h);
        this.b = max;
        g(max);
        if (z2) {
            b(z);
        }
        return this.k(j - l, obj);
    }

    float d() {
        return this.j * 0.75f;
    }

    public boolean e() {
        return this.f;
    }

    void g(float f) {
        d.k.a.c cVar;
        Object obj;
        float f2;
        int i = 0;
        this.e.b(this.d, f);
        i = 0;
        while (i < this.l.size()) {
            i = i + 1;
        }
        b.f(this.l);
    }

    public T h(float f) {
        this.b = f;
        this.c = true;
        return this;
    }

    public void i() throws AndroidRuntimeException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else {
            if (!this.f) {
                j();
            }
            return;
        }
    }

    abstract boolean k(long j);
}
