package f.c.a.e.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements f.c.a.e.d0.c {

    private final f.c.a.e.d0.c a;
    private final float b;
    public b(float f, f.c.a.e.d0.c c2) {
        float f2;
        int obj2;
        Object obj3;
        super();
        while (obj3 instanceof b) {
            obj2 += f2;
        }
        this.a = (b)obj3;
        this.b = obj2;
    }

    @Override // f.c.a.e.d0.c
    public float a(RectF rectF) {
        return Math.max(0, obj2 += f);
    }

    @Override // f.c.a.e.d0.c
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        if (this.a.equals(object.a) && Float.compare(equals, obj5) == 0) {
            if (Float.compare(equals, obj5) == 0) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // f.c.a.e.d0.c
    public int hashCode() {
        Object[] arr = new Object[2];
        return Arrays.hashCode(this.a, Float.valueOf(this.b));
    }
}
