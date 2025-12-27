package f.c.a.e.q;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import f.c.a.e.w.a;

/* compiled from: CircularRevealWidget.java */
/* loaded from: classes2.dex */
public interface d {

    static class a {
    }

    public static class b implements TypeEvaluator<d.e> {

        public static final TypeEvaluator<d.e> b = new d$b<>();
        private final d.e a = new d$e(0);

        public b() {
            super();
            final f.c.a.e.q.d.e eVar = new d.e(null);
        }

        public d.e a(float f, d.e eVar, d.e eVar2) {
            this.a.a(a.c(eVar.a, eVar2.a, f), a.c(eVar.b, eVar2.b, f), a.c(eVar.c, eVar2.c, f));
            return this.a;
        }
    }

    public static class c extends Property<d, d.e> {

        public static final Property<d, d.e> a = new d$c<>("circularReveal");

        private c(String str) {
            super(d.e.class, str);
        }

        @Override // android.util.Property
        public d.e a(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void b(d dVar, d.e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<d, Integer> {

        public static final Property<d, Integer> a = new d$d<>("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public Integer a(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void b(d dVar, Integer integer) {
            dVar.setCircularRevealScrimColor(integer.intValue());
        }
    }

    public static class e {

        public float a;
        public float b;
        public float c;
        /* synthetic */ e(d.a aVar) {
            this();
        }

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        private e() {
            super();
        }

        public e(float f, float f2, float f3) {
            super();
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }
    void a();

    void b();

    int getCircularRevealScrimColor();

    d.e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d.e eVar);
}
