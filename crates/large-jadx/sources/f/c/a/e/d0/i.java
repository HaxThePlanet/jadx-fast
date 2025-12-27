package f.c.a.e.d0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize.java */
/* loaded from: classes2.dex */
public final class i implements c {

    private final float a;
    public i(float f) {
        super();
        this.a = f;
    }

    public float a(RectF rectF) {
        return this.a * rectF.height();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (!(object instanceof i)) {
            return false;
        }
        if (this.a != object.a) {
        }
        return z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Object[] arr = new Object[1];
        return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
    }
}
