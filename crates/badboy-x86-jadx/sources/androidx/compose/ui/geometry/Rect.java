package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 Y2\u00020\u0001:\u0001YB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u001b\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\rH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ1\u0010D\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0010\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0007J\u0013\u0010G\u001a\u00020\u001e2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0007J\u0010\u0010L\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0000H\u0007J(\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u0003H\u0007J\u000e\u0010Q\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u0000J\u0008\u0010R\u001a\u00020SH\u0016J\u001a\u0010T\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJ\u0018\u0010T\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u0003H\u0007R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u000c\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\t\u001a\u0004\u0008\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\t\u001a\u0004\u0008\u001d\u0010 R\u001a\u0010!\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\"\u0010\t\u001a\u0004\u0008!\u0010 R\u001a\u0010#\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010\t\u001a\u0004\u0008#\u0010 R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008%\u0010\t\u001a\u0004\u0008&\u0010\u000bR\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u000bR\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008*\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008+\u0010\t\u001a\u0004\u0008,\u0010\u000bR \u0010-\u001a\u00020.8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008/\u0010\t\u001a\u0004\u00080\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00081\u0010\t\u001a\u0004\u00082\u0010\u000bR\u0017\u00103\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00084\u0010\u000fR\u0017\u00105\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00086\u0010\u000fR\u0017\u00107\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00088\u0010\u000fR\u001a\u00109\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008:\u0010\t\u001a\u0004\u0008;\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Landroidx/compose/ui/geometry/Rect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom$annotations", "()V", "getBottom", "()F", "bottomCenter", "Landroidx/compose/ui/geometry/Offset;", "getBottomCenter-F1C5BW0", "()J", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "center", "getCenter-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "height", "getHeight$annotations", "getHeight", "isEmpty", "", "isEmpty$annotations", "()Z", "isFinite", "isFinite$annotations", "isInfinite", "isInfinite$annotations", "getLeft$annotations", "getLeft", "maxDimension", "getMaxDimension", "minDimension", "getMinDimension", "getRight$annotations", "getRight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc$annotations", "getSize-NH-jbRc", "getTop$annotations", "getTop", "topCenter", "getTopCenter-F1C5BW0", "topLeft", "getTopLeft-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "width", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "contains", "offset", "contains-k-4lQ0M", "(J)Z", "copy", "deflate", "delta", "equals", "other", "hashCode", "", "inflate", "intersect", "otherLeft", "otherTop", "otherRight", "otherBottom", "overlaps", "toString", "", "translate", "translate-k-4lQ0M", "(J)Landroidx/compose/ui/geometry/Rect;", "translateX", "translateY", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Rect {

    public static final int $stable;
    public static final androidx.compose.ui.geometry.Rect.Companion Companion;
    private static final androidx.compose.ui.geometry.Rect Zero;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/geometry/Rect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/Rect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getZero$annotations() {
        }

        public final androidx.compose.ui.geometry.Rect getZero() {
            return Rect.access$getZero$cp();
        }
    }
    static {
        Rect.Companion companion = new Rect.Companion(0);
        Rect.Companion = companion;
        int i2 = 0;
        Rect rect = new Rect(i2, i2, i2, i2);
        Rect.Zero = rect;
    }

    public Rect(float left, float top, float right, float bottom) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public static final androidx.compose.ui.geometry.Rect access$getZero$cp() {
        return Rect.Zero;
    }

    public static androidx.compose.ui.geometry.Rect copy$default(androidx.compose.ui.geometry.Rect rect, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        if (i6 & 1 != 0) {
            obj1 = rect.left;
        }
        if (i6 & 2 != 0) {
            obj2 = rect.top;
        }
        if (i6 & 4 != 0) {
            obj3 = rect.right;
        }
        if (i6 &= 8 != 0) {
            obj4 = rect.bottom;
        }
        return rect.copy(obj1, obj2, obj3, obj4);
    }

    public static void getBottom$annotations() {
    }

    public static void getHeight$annotations() {
    }

    public static void getLeft$annotations() {
    }

    public static void getRight$annotations() {
    }

    public static void getSize-NH-jbRc$annotations() {
    }

    public static void getTop$annotations() {
    }

    public static void getWidth$annotations() {
    }

    public static void isEmpty$annotations() {
    }

    public static void isFinite$annotations() {
    }

    public static void isInfinite$annotations() {
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
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

    public final androidx.compose.ui.geometry.Rect copy(float f, float f2, float f3, float f4) {
        Rect rect = new Rect(f, f2, f3, f4);
        return rect;
    }

    public final androidx.compose.ui.geometry.Rect deflate(float delta) {
        return inflate(-delta);
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Rect) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.left, obj.left) != 0) {
            return i2;
        }
        if (Float.compare(this.top, obj.top) != 0) {
            return i2;
        }
        if (Float.compare(this.right, obj.right) != 0) {
            return i2;
        }
        if (Float.compare(this.bottom, obj.bottom) != 0) {
            return i2;
        }
        return i;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final long getBottomCenter-F1C5BW0() {
        return OffsetKt.Offset(left += i2, this.bottom);
    }

    public final long getBottomLeft-F1C5BW0() {
        return OffsetKt.Offset(this.left, this.bottom);
    }

    public final long getBottomRight-F1C5BW0() {
        return OffsetKt.Offset(this.right, this.bottom);
    }

    public final long getCenter-F1C5BW0() {
        final int i4 = 1073741824;
        return OffsetKt.Offset(left += i2, top += i5);
    }

    public final long getCenterLeft-F1C5BW0() {
        return OffsetKt.Offset(this.left, top += i2);
    }

    public final long getCenterRight-F1C5BW0() {
        return OffsetKt.Offset(this.right, top += i2);
    }

    public final float getHeight() {
        return bottom -= top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final float getRight() {
        return this.right;
    }

    public final long getSize-NH-jbRc() {
        return SizeKt.Size(getWidth(), getHeight());
    }

    public final float getTop() {
        return this.top;
    }

    public final long getTopCenter-F1C5BW0() {
        return OffsetKt.Offset(left += i2, this.top);
    }

    public final long getTopLeft-F1C5BW0() {
        return OffsetKt.Offset(this.left, this.top);
    }

    public final long getTopRight-F1C5BW0() {
        return OffsetKt.Offset(this.right, this.top);
    }

    public final float getWidth() {
        return right -= left;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public final androidx.compose.ui.geometry.Rect inflate(float delta) {
        Rect rect = new Rect(left -= delta, top -= delta, right += delta, bottom += delta);
        return rect;
    }

    public final androidx.compose.ui.geometry.Rect intersect(float otherLeft, float otherTop, float otherRight, float otherBottom) {
        Rect rect = new Rect(Math.max(this.left, otherLeft), Math.max(this.top, otherTop), Math.min(this.right, otherRight), Math.min(this.bottom, otherBottom));
        return rect;
    }

    public final androidx.compose.ui.geometry.Rect intersect(androidx.compose.ui.geometry.Rect other) {
        Rect rect = new Rect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
        return rect;
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

    public final boolean isFinite() {
        float naN3;
        int i;
        float naN2;
        float naN4;
        float naN;
        boolean infinite;
        int i2;
        naN3 = this.left;
        i2 = 1;
        final int i3 = 0;
        if (!Float.isInfinite(naN3) && !Float.isNaN(naN3)) {
            i = !Float.isNaN(naN3) ? i2 : i3;
        } else {
        }
        if (i != 0) {
            naN = this.top;
            if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
                i = !Float.isNaN(naN) ? i2 : i3;
            } else {
            }
            if (i != 0) {
                naN4 = this.right;
                if (!Float.isInfinite(naN4) && !Float.isNaN(naN4)) {
                    i = !Float.isNaN(naN4) ? i2 : i3;
                } else {
                }
                if (i != 0) {
                    naN2 = this.bottom;
                    if (!Float.isInfinite(naN2) && !Float.isNaN(naN2)) {
                        i = !Float.isNaN(naN2) ? i2 : i3;
                    } else {
                    }
                    if (i != 0) {
                    } else {
                        i2 = i3;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    public final boolean isInfinite() {
        int i;
        int cmp;
        final int i2 = 2139095040;
        if (Float.compare(left, i2) < 0 && Float.compare(top, i2) < 0 && Float.compare(right, i2) < 0) {
            if (Float.compare(top, i2) < 0) {
                if (Float.compare(right, i2) < 0) {
                    if (Float.compare(bottom, i2) >= 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final boolean overlaps(androidx.compose.ui.geometry.Rect other) {
        int cmp;
        int cmp2;
        float top;
        float left;
        int i2 = 0;
        if (Float.compare(right, left2) > 0) {
            if (Float.compare(right2, left) <= 0) {
            } else {
                if (Float.compare(bottom, top) > 0 && Float.compare(bottom2, top) <= 0) {
                    if (Float.compare(bottom2, top) <= 0) {
                    }
                    return 1;
                }
            }
            return i2;
        }
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 1;
        String str2 = ", ";
        return stringBuilder.append("Rect.fromLTRB(").append(GeometryUtilsKt.toStringAsFixed(this.left, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.top, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.right, i2)).append(str2).append(GeometryUtilsKt.toStringAsFixed(this.bottom, i2)).append(')').toString();
    }

    public final androidx.compose.ui.geometry.Rect translate(float translateX, float translateY) {
        Rect rect = new Rect(left += translateX, top += translateY, right += translateX, bottom += translateY);
        return rect;
    }

    public final androidx.compose.ui.geometry.Rect translate-k-4lQ0M(long offset) {
        Rect rect = new Rect(left += x-impl, top += y-impl, right += x-impl2, bottom += y-impl2);
        return rect;
    }
}
