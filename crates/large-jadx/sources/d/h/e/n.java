package d.h.e;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public abstract class n<T> implements java.lang.Cloneable {

    boolean a;
    boolean b;
    float c;
    private m v = null;

    static class a extends n<Float> {

        float w;
        a(float f, float f2) {
            super();
            this.c = f;
            this.w = f2;
            this.a = true;
        }

        @Override // d.h.e.n
        public n.a o() {
            d.h.e.n.a aVar;
            if (this.a) {
                aVar = new n.a(b(), this.w);
            } else {
                aVar = new n.a(b());
            }
            aVar.k(c());
            aVar.b = this.b;
            return aVar;
        }

        @Override // d.h.e.n
        public float p() {
            return this.w;
        }

        @Override // d.h.e.n
        public Float r() {
            return Float.valueOf(this.w);
        }

        @Override // d.h.e.n
        public void s(Float float) {
            if (float != null) {
                obj = Float.class;
                if (float.getClass() == obj) {
                    this.w = float.floatValue();
                    boolean z = true;
                    this.a = z;
                }
            }
        }

        a(float f) {
            super();
            this.c = f;
        }
    }

    static class b extends n<Integer> {

        int w;
        b(float f, int i) {
            super();
            this.c = f;
            this.w = i;
            this.a = true;
        }

        @Override // d.h.e.n
        public n.b o() {
            d.h.e.n.b bVar;
            if (this.a) {
                bVar = new n.b(b(), this.w);
            } else {
                bVar = new n.b(b());
            }
            bVar.k(c());
            bVar.b = this.b;
            return bVar;
        }

        @Override // d.h.e.n
        public int p() {
            return this.w;
        }

        @Override // d.h.e.n
        public Integer r() {
            return Integer.valueOf(this.w);
        }

        @Override // d.h.e.n
        public void s(Integer integer) {
            if (integer != null) {
                obj = Integer.class;
                if (integer.getClass() == obj) {
                    this.w = integer.intValue();
                    boolean z = true;
                    this.a = z;
                }
            }
        }

        b(float f) {
            super();
            this.c = f;
        }
    }
    public n() {
        super();
    }

    public static n<Float> f(float f) {
        return new n.a(f);
    }

    public static n<Float> g(float f, float f2) {
        return new n.a(f, f2);
    }

    public static n<Integer> h(float f) {
        return new n.b(f);
    }

    public static n<Integer> j(float f, int i) {
        return new n.b(f, i);
    }

    public float b() {
        return this.c;
    }

    public m c() {
        return this.v;
    }

    public boolean e() {
        return this.a;
    }

    public void k(m mVar) {
        this.v = mVar;
    }

    void m(boolean z) {
        this.b = z;
    }

    boolean n() {
        return this.b;
    }

    public abstract n<T> a();

    public abstract T d();

    public abstract void l(T t);
}
