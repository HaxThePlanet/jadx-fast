package d.f.b.a;

import android.view.View;
import d.f.a.k.a.d;

/* compiled from: ViewOscillator.java */
/* loaded from: classes.dex */
public abstract class b extends d {

    public static class a extends b {
        @Override // d.f.b.a.b
        public void c(View view, float f, double d, double d2) {
            view.setRotation(a(f) + (float)(Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // d.f.b.a.b
        public void b(View view, float f) {
        }
    }
    @Override // d.f.a.k.a.d
    public abstract void b(View view, float f);
}
