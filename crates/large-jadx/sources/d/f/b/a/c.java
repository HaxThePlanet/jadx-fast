package d.f.b.a;

import android.view.View;
import d.f.a.k.a.e;

/* compiled from: ViewSpline.java */
/* loaded from: classes.dex */
public abstract class c extends e {

    public static class a extends c {
        @Override // d.f.b.a.c
        public void c(View view, float f, double d, double d2) {
            view.setRotation(a(f) + (float)(Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // d.f.b.a.c
        public void b(View view, float f) {
        }
    }
    @Override // d.f.a.k.a.e
    public abstract void b(View view, float f);
}
