package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 P2\u00020\u0001:\u0001PB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J1\u0010@\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0010\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0003H\u0007J\u0013\u0010C\u001a\u00020\u001e2\u0008\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\u0010\u0010F\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0003H\u0007J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0000H\u0007J\u000e\u0010H\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u0000J\u0008\u0010I\u001a\u00020JH\u0016J\u001a\u0010K\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJ\u0018\u0010K\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u0003H\u0007R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u000c\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\t\u001a\u0004\u0008\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\t\u001a\u0004\u0008\u001d\u0010 R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008!\u0010\t\u001a\u0004\u0008\"\u0010\u000bR\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008$\u0010\u000bR\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008&\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008'\u0010\t\u001a\u0004\u0008(\u0010\u000bR \u0010)\u001a\u00020*8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008+\u0010\t\u001a\u0004\u0008,\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008-\u0010\t\u001a\u0004\u0008.\u0010\u000bR\u0017\u0010/\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00080\u0010\u000fR\u0017\u00101\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00082\u0010\u000fR\u0017\u00103\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00084\u0010\u000fR\u001a\u00105\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00086\u0010\t\u001a\u0004\u00087\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/ui/unit/IntRect;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom$annotations", "()V", "getBottom", "()I", "bottomCenter", "Landroidx/compose/ui/unit/IntOffset;", "getBottomCenter-nOcc-ac", "()J", "bottomLeft", "getBottomLeft-nOcc-ac", "bottomRight", "getBottomRight-nOcc-ac", "center", "getCenter-nOcc-ac", "centerLeft", "getCenterLeft-nOcc-ac", "centerRight", "getCenterRight-nOcc-ac", "height", "getHeight$annotations", "getHeight", "isEmpty", "", "isEmpty$annotations", "()Z", "getLeft$annotations", "getLeft", "maxDimension", "getMaxDimension", "minDimension", "getMinDimension", "getRight$annotations", "getRight", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$annotations", "getSize-YbymL2g", "getTop$annotations", "getTop", "topCenter", "getTopCenter-nOcc-ac", "topLeft", "getTopLeft-nOcc-ac", "topRight", "getTopRight-nOcc-ac", "width", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "contains", "offset", "contains--gyyYBs", "(J)Z", "copy", "deflate", "delta", "equals", "other", "hashCode", "inflate", "intersect", "overlaps", "toString", "", "translate", "translate--gyyYBs", "(J)Landroidx/compose/ui/unit/IntRect;", "translateX", "translateY", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntRect {

    public static final int $stable;
    public static final androidx.compose.ui.unit.IntRect.Companion Companion;
    private static final androidx.compose.ui.unit.IntRect Zero;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/unit/IntRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/unit/IntRect;", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getZero$annotations() {
        }

        public final androidx.compose.ui.unit.IntRect getZero() {
            return IntRect.access$getZero$cp();
        }
    }
    static {
        IntRect.Companion companion = new IntRect.Companion(0);
        IntRect.Companion = companion;
        int i2 = 0;
        IntRect intRect = new IntRect(i2, i2, i2, i2);
        IntRect.Zero = intRect;
    }

    public IntRect(int left, int top, int right, int bottom) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public static final androidx.compose.ui.unit.IntRect access$getZero$cp() {
        return IntRect.Zero;
    }

    public static androidx.compose.ui.unit.IntRect copy$default(androidx.compose.ui.unit.IntRect intRect, int i2, int i3, int i4, int i5, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = intRect.left;
        }
        if (i6 & 2 != 0) {
            obj2 = intRect.top;
        }
        if (i6 & 4 != 0) {
            obj3 = intRect.right;
        }
        if (i6 &= 8 != 0) {
            obj4 = intRect.bottom;
        }
        return intRect.copy(obj1, obj2, obj3, obj4);
    }

    public static void getBottom$annotations() {
    }

    public static void getHeight$annotations() {
    }

    public static void getLeft$annotations() {
    }

    public static void getRight$annotations() {
    }

    public static void getSize-YbymL2g$annotations() {
    }

    public static void getTop$annotations() {
    }

    public static void getWidth$annotations() {
    }

    public static void isEmpty$annotations() {
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final boolean contains--gyyYBs(long offset) {
        int x-impl;
        int i;
        int bottom;
        if (IntOffset.getX-impl(offset) >= this.left && IntOffset.getX-impl(offset) < this.right && IntOffset.getY-impl(offset) >= this.top && IntOffset.getY-impl(offset) < this.bottom) {
            if (IntOffset.getX-impl(offset) < this.right) {
                if (IntOffset.getY-impl(offset) >= this.top) {
                    i = IntOffset.getY-impl(offset) < this.bottom ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final androidx.compose.ui.unit.IntRect copy(int i, int i2, int i3, int i4) {
        IntRect intRect = new IntRect(i, i2, i3, i4);
        return intRect;
    }

    public final androidx.compose.ui.unit.IntRect deflate(int delta) {
        return inflate(-delta);
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof IntRect) {
            return i2;
        }
        Object obj = object;
        if (this.left != obj.left) {
            return i2;
        }
        if (this.top != obj.top) {
            return i2;
        }
        if (this.right != obj.right) {
            return i2;
        }
        if (this.bottom != obj.bottom) {
            return i2;
        }
        return i;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final long getBottomCenter-nOcc-ac() {
        return IntOffsetKt.IntOffset(left += i2, this.bottom);
    }

    public final long getBottomLeft-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.left, this.bottom);
    }

    public final long getBottomRight-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.right, this.bottom);
    }

    public final long getCenter-nOcc-ac() {
        return IntOffsetKt.IntOffset(left += i2, top += i4);
    }

    public final long getCenterLeft-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.left, top += i2);
    }

    public final long getCenterRight-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.right, top += i2);
    }

    public final int getHeight() {
        return bottom -= top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getRight() {
        return this.right;
    }

    public final long getSize-YbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public final int getTop() {
        return this.top;
    }

    public final long getTopCenter-nOcc-ac() {
        return IntOffsetKt.IntOffset(left += i2, this.top);
    }

    public final long getTopLeft-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.left, this.top);
    }

    public final long getTopRight-nOcc-ac() {
        return IntOffsetKt.IntOffset(this.right, this.top);
    }

    public final int getWidth() {
        return right -= left;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public final androidx.compose.ui.unit.IntRect inflate(int delta) {
        IntRect intRect = new IntRect(left -= delta, top -= delta, right += delta, bottom += delta);
        return intRect;
    }

    public final androidx.compose.ui.unit.IntRect intersect(androidx.compose.ui.unit.IntRect other) {
        IntRect intRect = new IntRect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
        return intRect;
    }

    public final boolean isEmpty() {
        int i;
        int left;
        int bottom;
        if (this.left < this.right) {
            if (this.top >= this.bottom) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean overlaps(androidx.compose.ui.unit.IntRect other) {
        int bottom;
        int right;
        int top;
        int left;
        final int i2 = 0;
        if (this.right > other.left) {
            if (other.right <= this.left) {
            } else {
                if (this.bottom > other.top && other.bottom <= this.top) {
                    if (other.bottom <= this.top) {
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
        String str2 = ", ";
        return stringBuilder.append("IntRect.fromLTRB(").append(this.left).append(str2).append(this.top).append(str2).append(this.right).append(str2).append(this.bottom).append(')').toString();
    }

    public final androidx.compose.ui.unit.IntRect translate(int translateX, int translateY) {
        IntRect intRect = new IntRect(left += translateX, top += translateY, right += translateX, bottom += translateY);
        return intRect;
    }

    public final androidx.compose.ui.unit.IntRect translate--gyyYBs(long offset) {
        IntRect intRect = new IntRect(left += x-impl, top += y-impl, right += x-impl2, bottom += y-impl2);
        return intRect;
    }
}
