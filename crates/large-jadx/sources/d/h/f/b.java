package d.h.f;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    public static final d.h.f.b e;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    static {
        final int i = 0;
        b bVar = new b(i, i, i, i);
        b.e = bVar;
    }

    private b(int i, int i2, int i3, int i4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static d.h.f.b a(d.h.f.b b, d.h.f.b b2) {
        return b.b(Math.max(b.a, b2.a), Math.max(b.b, b2.b), Math.max(b.c, b2.c), Math.max(b.d, b2.d));
    }

    public static d.h.f.b b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (i2 == 0) {
                if (i3 == 0) {
                    if (i4 == 0) {
                        return b.e;
                    }
                }
            }
        }
        b bVar = new b(i, i2, i3, i4);
        return bVar;
    }

    public static d.h.f.b c(Rect rect) {
        return b.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static d.h.f.b d(Insets insets) {
        return b.b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object object) {
        Class<d.h.f.b> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (b.class != object.getClass()) {
            } else {
                if (this.d != object.d) {
                    return i2;
                }
                if (this.a != object.a) {
                    return i2;
                }
                if (this.c != object.c) {
                    return i2;
                }
                if (this.b != object.b) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Insets{left=");
        stringBuilder.append(this.a);
        stringBuilder.append(", top=");
        stringBuilder.append(this.b);
        stringBuilder.append(", right=");
        stringBuilder.append(this.c);
        stringBuilder.append(", bottom=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
