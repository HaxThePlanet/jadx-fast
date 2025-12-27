package d.f.b.a;

import android.view.View;
import d.f.a.k.a.a;
import d.f.a.k.a.c;
import d.f.a.k.a.f;

/* compiled from: ViewTimeCycle.java */
/* loaded from: classes.dex */
public abstract class d extends f {

    public static class a extends d {
        @Override // d.f.b.a.d
        public boolean b(View view, float f, long j, c cVar) {
            return this.h;
        }

        @Override // d.f.b.a.d
        public boolean c(View view, c cVar, float f, long j, double d, double d2) {
            view.setRotation((this.a(f, j, view, cVar)) + (float)(Math.toDegrees(Math.atan2(d2, d))));
            return this.h;
        }
    }
    @Override // d.f.a.k.a.f
    public float a(float f, long j, View view, c cVar) {
        this.a.c((double)f, this.g);
        float f2 = fArr3[1];
        final boolean z = false;
        if (this.a == 0) {
            this.h = z;
            return fArr3[2];
        }
        int i3 = 0;
        if (Float.isNaN(this.j)) {
            cVar.a(view, this.f, z);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        }
        float f6 = (float)(double)this.j + (double)(j - this.i) * 0.000000001d * (double)f2 % 1d;
        this.j = f6;
        cVar.b(view, this.f, z, f6);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i3;
    }

    @Override // d.f.a.k.a.f
    public abstract boolean b(View view, float f, long j, c cVar);
}
