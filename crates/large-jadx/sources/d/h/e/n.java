package d.h.e;

/* loaded from: classes.dex */
public abstract class n<T>  implements java.lang.Cloneable {

    boolean a;
    boolean b;
    float c;
    private d.h.e.m v = null;

    static class a extends d.h.e.n<Float> {

        float w;
        a(float f) {
            super();
            this.c = f;
            final Class obj1 = Float.TYPE;
        }

        a(float f, float f2) {
            super();
            this.c = f;
            this.w = f2;
            Class obj1 = Float.TYPE;
            this.a = true;
        }

        @Override // d.h.e.n
        public d.h.e.n a() {
            return o();
        }

        @Override // d.h.e.n
        public Object clone() {
            return o();
        }

        @Override // d.h.e.n
        public Object d() {
            return r();
        }

        @Override // d.h.e.n
        public void l(Object object) {
            s((Float)object);
        }

        @Override // d.h.e.n
        public d.h.e.n.a o() {
            d.h.e.n.a aVar;
            float f;
            float f2;
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
            Class class;
            Class<Float> obj;
            int obj3;
            if (float != 0 && float.getClass() == Float.class) {
                if (float.getClass() == Float.class) {
                    this.w = float.floatValue();
                    this.a = true;
                }
            }
        }
    }

    static class b extends d.h.e.n<Integer> {

        int w;
        b(float f) {
            super();
            this.c = f;
            final Class obj1 = Integer.TYPE;
        }

        b(float f, int i2) {
            super();
            this.c = f;
            this.w = i2;
            Class obj1 = Integer.TYPE;
            this.a = true;
        }

        @Override // d.h.e.n
        public d.h.e.n a() {
            return o();
        }

        @Override // d.h.e.n
        public Object clone() {
            return o();
        }

        @Override // d.h.e.n
        public Object d() {
            return r();
        }

        @Override // d.h.e.n
        public void l(Object object) {
            s((Integer)object);
        }

        @Override // d.h.e.n
        public d.h.e.n.b o() {
            d.h.e.n.b bVar;
            float f;
            int i;
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
            Class class;
            Class<Integer> obj;
            int obj3;
            if (integer != 0 && integer.getClass() == Integer.class) {
                if (integer.getClass() == Integer.class) {
                    this.w = integer.intValue();
                    this.a = true;
                }
            }
        }
    }
    public n() {
        super();
        final int i = 0;
    }

    public static d.h.e.n<Float> f(float f) {
        n.a aVar = new n.a(f);
        return aVar;
    }

    public static d.h.e.n<Float> g(float f, float f2) {
        n.a aVar = new n.a(f, f2);
        return aVar;
    }

    public static d.h.e.n<Integer> h(float f) {
        n.b bVar = new n.b(f);
        return bVar;
    }

    public static d.h.e.n<Integer> j(float f, int i2) {
        n.b bVar = new n.b(f, i2);
        return bVar;
    }

    public abstract d.h.e.n<T> a();

    @Override // java.lang.Cloneable
    public float b() {
        return this.c;
    }

    @Override // java.lang.Cloneable
    public d.h.e.m c() {
        return this.v;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return a();
    }

    public abstract T d();

    @Override // java.lang.Cloneable
    public boolean e() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    public void k(d.h.e.m m) {
        this.v = m;
    }

    public abstract void l(T t);

    @Override // java.lang.Cloneable
    void m(boolean z) {
        this.b = z;
    }

    @Override // java.lang.Cloneable
    boolean n() {
        return this.b;
    }
}
