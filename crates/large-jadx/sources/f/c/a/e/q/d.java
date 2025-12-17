package f.c.a.e.q;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import f.c.a.e.w.a;

/* loaded from: classes2.dex */
public interface d {

    static class a {
    }

    public static class b implements TypeEvaluator<f.c.a.e.q.d.e> {

        public static final TypeEvaluator<f.c.a.e.q.d.e> b;
        private final f.c.a.e.q.d.e a;
        static {
            d.b bVar = new d.b();
            d.b.b = bVar;
        }

        public b() {
            super();
            d.e eVar = new d.e(0);
            this.a = eVar;
        }

        @Override // android.animation.TypeEvaluator
        public f.c.a.e.q.d.e a(float f, f.c.a.e.q.d.e d$e2, f.c.a.e.q.d.e d$e3) {
            this.a.a(a.c(e2.a, e3.a, f), a.c(e2.b, e3.b, f), a.c(e2.c, e3.c, f));
            return this.a;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object object2, Object object3) {
            return a(f, (d.e)object2, (d.e)object3);
        }
    }

    public static class c extends Property<f.c.a.e.q.d, f.c.a.e.q.d.e> {

        public static final Property<f.c.a.e.q.d, f.c.a.e.q.d.e> a;
        static {
            d.c cVar = new d.c("circularReveal");
            d.c.a = cVar;
        }

        private c(String string) {
            super(d.e.class, string);
        }

        @Override // android.util.Property
        public f.c.a.e.q.d.e a(f.c.a.e.q.d d) {
            return d.getRevealInfo();
        }

        @Override // android.util.Property
        public void b(f.c.a.e.q.d d, f.c.a.e.q.d.e d$e2) {
            d.setRevealInfo(e2);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((d)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((d)object, (d.e)object2);
        }
    }

    public static class d extends Property<f.c.a.e.q.d, Integer> {

        public static final Property<f.c.a.e.q.d, Integer> a;
        static {
            d.d dVar = new d.d("circularRevealScrimColor");
            d.d.a = dVar;
        }

        private d(String string) {
            super(Integer.class, string);
        }

        @Override // android.util.Property
        public Integer a(f.c.a.e.q.d d) {
            return Integer.valueOf(d.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void b(f.c.a.e.q.d d, Integer integer2) {
            d.setCircularRevealScrimColor(integer2.intValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((d)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((d)object, (Integer)object2);
        }
    }

    public static class e {

        public float a;
        public float b;
        public float c;
        public e(float f, float f2, float f3) {
            super();
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        e(f.c.a.e.q.d.a d$a) {
            super();
        }

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }
    public abstract void a();

    public abstract void b();

    public abstract int getCircularRevealScrimColor();

    public abstract f.c.a.e.q.d.e getRevealInfo();

    public abstract void setCircularRevealOverlayDrawable(Drawable drawable);

    public abstract void setCircularRevealScrimColor(int i);

    public abstract void setRevealInfo(f.c.a.e.q.d.e d$e);
}
