package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u000bJ\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\u0008\u0010\"\u001a\u00020#H\u0016J\u0008\u0010$\u001a\u00020%H\u0016R$\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR$\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000bR$\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000c\u0012\u0004\u0008\u000f\u0010\t\u001a\u0004\u0008\u0010\u0010\u000bR$\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000c\u0012\u0004\u0008\u0011\u0010\t\u001a\u0004\u0008\u0012\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaddingValuesImpl implements androidx.compose.foundation.layout.PaddingValues {

    public static final int $stable;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;
    static {
    }

    private PaddingValuesImpl(float start, float top, float end, float bottom) {
        int i2;
        int i;
        int i3;
        int i4;
        super();
        this.start = start;
        this.top = top;
        this.end = end;
        this.bottom = bottom;
        int i9 = 0;
        i4 = 1;
        final int i10 = 0;
        i2 = Float.compare(start2, i9) >= 0 ? i4 : i10;
        if (i2 == 0) {
        } else {
            i = Float.compare(top2, i9) >= 0 ? i4 : i10;
            if (i == 0) {
            } else {
                i3 = Float.compare(end2, i9) >= 0 ? i4 : i10;
                if (i3 == 0) {
                } else {
                    if (Float.compare(bottom2, i9) >= 0) {
                    } else {
                        i4 = i10;
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    int i7 = 0;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Bottom padding must be non-negative".toString());
                    throw illegalArgumentException3;
                }
                int i8 = 0;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("End padding must be non-negative".toString());
                throw illegalArgumentException4;
            }
            int i6 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Top padding must be non-negative".toString());
            throw illegalArgumentException2;
        }
        int i5 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Start padding must be non-negative".toString());
        throw illegalArgumentException;
    }

    public PaddingValuesImpl(float f, float f2, float f3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        float f9;
        float f7;
        float f5;
        float f8;
        float f6;
        float obj7;
        float obj8;
        float obj9;
        float obj10;
        int obj12;
        if (i5 & 1 != 0) {
            obj12 = 0;
            f7 = obj7;
        } else {
            f7 = f;
        }
        if (i5 & 2 != 0) {
            obj8 = 0;
            f5 = obj8;
        } else {
            f5 = f2;
        }
        if (i5 & 4 != 0) {
            obj8 = 0;
            f8 = obj9;
        } else {
            f8 = f3;
        }
        if (i5 & 8 != 0) {
            obj8 = 0;
            f6 = obj10;
        } else {
            f6 = f4;
        }
        super(f7, f5, f8, f6, 0);
    }

    public PaddingValuesImpl(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, f3, f4);
    }

    public static void getBottom-D9Ej5fM$annotations() {
    }

    public static void getEnd-D9Ej5fM$annotations() {
    }

    public static void getStart-D9Ej5fM$annotations() {
    }

    public static void getTop-D9Ej5fM$annotations() {
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateBottomPadding-D9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateLeftPadding-u2uoSUM(LayoutDirection layoutDirection) {
        float start;
        start = layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
        return start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateRightPadding-u2uoSUM(LayoutDirection layoutDirection) {
        float start;
        start = layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
        return start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float calculateTopPadding-D9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public boolean equals(Object other) {
        boolean equals-impl0;
        int i;
        float bottom;
        if (!other instanceof PaddingValuesImpl) {
            return 0;
        }
        if (Dp.equals-impl0(this.start, obj.start) && Dp.equals-impl0(this.top, obj2.top) && Dp.equals-impl0(this.end, obj3.end) && Dp.equals-impl0(this.bottom, obj4.bottom)) {
            if (Dp.equals-impl0(this.top, obj2.top)) {
                if (Dp.equals-impl0(this.end, obj3.end)) {
                    if (Dp.equals-impl0(this.bottom, obj4.bottom)) {
                        i = 1;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public int hashCode() {
        return i6 += i10;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PaddingValues(start=").append(Dp.toString-impl(this.start)).append(", top=").append(Dp.toString-impl(this.top)).append(", end=").append(Dp.toString-impl(this.end)).append(", bottom=").append(Dp.toString-impl(this.bottom)).append(')').toString();
    }
}
