package f.c.a.e.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes2.dex */
public final class b implements c {

    private final c a;
    private final float b;
    public b(float f, c cVar) {
        float f3;
        f.c.a.e.d0.c cVar22;
        super();
        while (cVar22 instanceof b) {
            f3 = f3 + (b)cVar22.b;
        }
        this.a = cVar22;
        this.b = f3;
    }

    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        int cmp;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (!(object instanceof b)) {
            return false;
        }
        if (this.a.equals(object.a)) {
            if (this.b != object.b) {
            }
        }
        return z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Object[] arr = new Object[2];
        return Arrays.hashCode(new Object[] { this.a, Float.valueOf(this.b) });
    }
}
