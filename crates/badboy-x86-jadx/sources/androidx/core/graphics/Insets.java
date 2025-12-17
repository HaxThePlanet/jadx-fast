package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes5.dex */
public final class Insets {

    public static final androidx.core.graphics.Insets NONE;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static class Api29Impl {
        static Insets of(int left, int top, int right, int bottom) {
            return Insets.of(left, top, right, bottom);
        }
    }
    static {
        final int i = 0;
        Insets insets = new Insets(i, i, i, i);
        Insets.NONE = insets;
    }

    private Insets(int left, int top, int right, int bottom) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public static androidx.core.graphics.Insets add(androidx.core.graphics.Insets a, androidx.core.graphics.Insets b) {
        return Insets.of(left += left2, top += top2, right += right2, bottom += bottom2);
    }

    public static androidx.core.graphics.Insets max(androidx.core.graphics.Insets a, androidx.core.graphics.Insets b) {
        return Insets.of(Math.max(a.left, b.left), Math.max(a.top, b.top), Math.max(a.right, b.right), Math.max(a.bottom, b.bottom));
    }

    public static androidx.core.graphics.Insets min(androidx.core.graphics.Insets a, androidx.core.graphics.Insets b) {
        return Insets.of(Math.min(a.left, b.left), Math.min(a.top, b.top), Math.min(a.right, b.right), Math.min(a.bottom, b.bottom));
    }

    public static androidx.core.graphics.Insets of(int left, int top, int right, int bottom) {
        if (left == 0 && top == 0 && right == 0 && bottom == 0) {
            if (top == 0) {
                if (right == 0) {
                    if (bottom == 0) {
                        return Insets.NONE;
                    }
                }
            }
        }
        Insets insets = new Insets(left, top, right, bottom);
        return insets;
    }

    public static androidx.core.graphics.Insets of(Rect r) {
        return Insets.of(r.left, r.top, r.right, r.bottom);
    }

    public static androidx.core.graphics.Insets subtract(androidx.core.graphics.Insets a, androidx.core.graphics.Insets b) {
        return Insets.of(left -= left2, top -= top2, right -= right2, bottom -= bottom2);
    }

    public static androidx.core.graphics.Insets toCompatInsets(Insets insets) {
        return Insets.of(insets.left, insets.top, insets.right, insets.bottom);
    }

    @Deprecated
    public static androidx.core.graphics.Insets wrap(Insets insets) {
        return Insets.toCompatInsets(insets);
    }

    public boolean equals(Object o) {
        Class class2;
        Class class;
        final int i = 1;
        if (this == o) {
            return i;
        }
        final int i2 = 0;
        if (o != null) {
            if (getClass() != o.getClass()) {
            } else {
                Object obj = o;
                if (this.bottom != obj.bottom) {
                    return i2;
                }
                if (this.left != obj.left) {
                    return i2;
                }
                if (this.right != obj.right) {
                    return i2;
                }
                if (this.top != obj.top) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return result2 += bottom;
    }

    public Insets toPlatformInsets() {
        return Insets.Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Insets{left=").append(this.left).append(", top=").append(this.top).append(", right=").append(this.right).append(", bottom=").append(this.bottom).append('}').toString();
    }
}
