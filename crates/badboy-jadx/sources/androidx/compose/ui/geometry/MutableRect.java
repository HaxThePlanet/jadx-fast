package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J(\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0007J&\u0010$\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u0008\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0012\u0010\u000c\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\t\"\u0004\u0008\u0012\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\t\"\u0004\u0008\u0014\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00168Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\t\"\u0004\u0008\u001a\u0010\u000bR\u0012\u0010\u001b\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006'", d2 = {"Landroidx/compose/ui/geometry/MutableRect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom", "()F", "setBottom", "(F)V", "height", "getHeight", "isEmpty", "", "()Z", "getLeft", "setLeft", "getRight", "setRight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getTop", "setTop", "width", "getWidth", "contains", "offset", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "intersect", "", "set", "toString", "", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableRect {

    public static final int $stable = 8;
    private float bottom;
    private float left;
    private float right;
    private float top;
    static {
        final int i = 8;
    }

    public MutableRect(float left, float top, float right, float bottom) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public final boolean contains-k-4lQ0M(long offset) {
        int cmp;
        int i;
        float bottom;
        if (Float.compare(x-impl, bottom) >= 0 && Float.compare(x-impl2, bottom) < 0 && Float.compare(y-impl, bottom) >= 0 && Float.compare(y-impl2, bottom) < 0) {
            if (Float.compare(x-impl2, bottom) < 0) {
                if (Float.compare(y-impl, bottom) >= 0) {
                    i = Float.compare(y-impl2, bottom) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getHeight() {
        final int i = 0;
        return bottom -= top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final long getSize-NH-jbRc() {
        Object obj = this;
        int i = 0;
        int i2 = 0;
        return SizeKt.Size(right -= left, bottom -= top);
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        final int i = 0;
        return right -= left;
    }

    public final void intersect(float left, float top, float right, float bottom) {
        this.left = Math.max(left, this.left);
        this.top = Math.max(top, this.top);
        this.right = Math.min(right, this.right);
        this.bottom = Math.min(bottom, this.bottom);
    }

    public final boolean isEmpty() {
        int i;
        int cmp;
        float bottom;
        if (Float.compare(left, bottom) < 0) {
            if (Float.compare(top, bottom) >= 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final void set(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public final void setBottom(float <set-?>) {
        this.bottom = <set-?>;
    }

    public final void setLeft(float <set-?>) {
        this.left = <set-?>;
    }

    public final void setRight(float <set-?>) {
        this.right = <set-?>;
    }

    public final void setTop(float <set-?>) {
        this.top = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 1;
        String str2 = ", ";
        return stringBuilder.append("MutableRect(").append(GeometryUtilsKt.toStringAsFixed(this.left, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.top, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.right, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.bottom, i2)).append(')').toString();
    }
}
