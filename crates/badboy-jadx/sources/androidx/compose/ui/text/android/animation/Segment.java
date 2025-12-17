package androidx.compose.ui.text.android.animation;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u001e", d2 = {"Landroidx/compose/ui/text/android/animation/Segment;", "", "startOffset", "", "endOffset", "left", "top", "right", "bottom", "(IIIIII)V", "getBottom", "()I", "getEndOffset", "getLeft", "getRight", "getStartOffset", "getTop", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Segment {

    public static final int $stable;
    private final int bottom;
    private final int endOffset;
    private final int left;
    private final int right;
    private final int startOffset;
    private final int top;
    static {
    }

    public Segment(int startOffset, int endOffset, int left, int top, int right, int bottom) {
        super();
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public static androidx.compose.ui.text.android.animation.Segment copy$default(androidx.compose.ui.text.android.animation.Segment segment, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object object9) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        if (i8 & 1 != 0) {
            obj1 = segment.startOffset;
        }
        if (i8 & 2 != 0) {
            obj2 = segment.endOffset;
        }
        if (i8 & 4 != 0) {
            obj3 = segment.left;
        }
        if (i8 & 8 != 0) {
            obj4 = segment.top;
        }
        if (i8 & 16 != 0) {
            obj5 = segment.right;
        }
        if (i8 &= 32 != 0) {
            obj6 = segment.bottom;
        }
        return segment.copy(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    public final int component1() {
        return this.startOffset;
    }

    public final int component2() {
        return this.endOffset;
    }

    public final int component3() {
        return this.left;
    }

    public final int component4() {
        return this.top;
    }

    public final int component5() {
        return this.right;
    }

    public final int component6() {
        return this.bottom;
    }

    public final androidx.compose.ui.text.android.animation.Segment copy(int i, int i2, int i3, int i4, int i5, int i6) {
        Segment segment = new Segment(i, i2, i3, i4, i5, i6);
        return segment;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Segment) {
            return i2;
        }
        Object obj = object;
        if (this.startOffset != obj.startOffset) {
            return i2;
        }
        if (this.endOffset != obj.endOffset) {
            return i2;
        }
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

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Segment(startOffset=").append(this.startOffset).append(", endOffset=").append(this.endOffset).append(", left=").append(this.left).append(", top=").append(this.top).append(", right=").append(this.right).append(", bottom=").append(this.bottom).append(')').toString();
    }
}
