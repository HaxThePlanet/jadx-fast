package d.f.b.a;

import android.view.View;
import d.f.a.k.a.a;
import d.f.a.k.a.c;
import d.f.a.k.a.f;

/* loaded from: classes.dex */
public abstract class d extends f {

    public static class a extends d.f.b.a.d {
        @Override // d.f.b.a.d
        public boolean b(View view, float f2, long l3, c c4) {
            return this.h;
        }

        @Override // d.f.b.a.d
        public boolean c(View view, c c2, float f3, long l4, double d5, double d6) {
            view.setRotation(obj8 += obj9);
            return this.h;
        }
    }
    @Override // d.f.a.k.a.f
    public float a(float f, long l2, View view3, c c4) {
        this.a.c((double)f, obj2);
        float[] obj8 = this.g;
        float f2 = obj8[1];
        final int i4 = 0;
        if (Float.compare(f2, i2) == 0) {
            this.h = i4;
            return obj8[2];
        }
        int i3 = 0;
        if (Float.isNaN(this.j)) {
            obj12.a(c4, this.f, i4);
            throw i3;
        }
        obj8 = (float)i6;
        this.j = obj8;
        obj12.b(c4, this.f, i4, obj8);
        throw i3;
    }

    @Override // d.f.a.k.a.f
    public abstract boolean b(View view, float f2, long l3, c c4);
}
