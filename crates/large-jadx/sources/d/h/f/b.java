package d.h.f;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    public static final b e = new b(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    private b(int i, int i2, int i3, int i4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static b a(b bVar, b bVar2) {
        return b.b(Math.max(bVar.a, bVar2.a), Math.max(bVar.b, bVar2.b), Math.max(bVar.c, bVar2.c), Math.max(bVar.d, bVar2.d));
    }

    public static b b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return b.e;
        }
        return new b(i, i2, i3, i4);
    }

    public static b c(Rect rect) {
        return b.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b.b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = b.class;
            if (obj == object.getClass()) {
                if (this.d != object.d) {
                    return false;
                }
                if (this.a != object.a) {
                    return false;
                }
                if (this.c != object.c) {
                    return false;
                }
                return this.b != object.b ? z2 : z;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b * 31 + this.c * 31 + this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Insets{left=";
        String str3 = ", top=";
        String str4 = ", right=";
        String str5 = ", bottom=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + 125;
        return str;
    }
}
