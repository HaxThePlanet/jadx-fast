package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008g\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000c\u0010\nJ\u0015\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "Absolute", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaddingValues {

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016J\u0008\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\u0008\u0008\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\u0008\u000b\u0010\tR\u001e\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\u0008\u000c\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\u0008\r\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "F", "getLeft-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getTop-D9Ej5fM$annotations", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Absolute implements androidx.compose.foundation.layout.PaddingValues {

        public static final int $stable;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;
        static {
        }

        private Absolute(float left, float top, float right, float bottom) {
            int i2;
            int i4;
            int i3;
            int i;
            super();
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
            int i9 = 0;
            i = 1;
            final int i10 = 0;
            i2 = Float.compare(left2, i9) >= 0 ? i : i10;
            if (i2 == 0) {
            } else {
                i4 = Float.compare(top2, i9) >= 0 ? i : i10;
                if (i4 == 0) {
                } else {
                    i3 = Float.compare(right2, i9) >= 0 ? i : i10;
                    if (i3 == 0) {
                    } else {
                        if (Float.compare(bottom2, i9) >= 0) {
                        } else {
                            i = i10;
                        }
                        if (i == 0) {
                        } else {
                        }
                        int i7 = 0;
                        IllegalArgumentException $i$a$RequirePaddingValues$Absolute$4 = new IllegalArgumentException("Bottom padding must be non-negative".toString());
                        throw $i$a$RequirePaddingValues$Absolute$4;
                    }
                    int i8 = 0;
                    IllegalArgumentException $i$a$RequirePaddingValues$Absolute$3 = new IllegalArgumentException("Right padding must be non-negative".toString());
                    throw $i$a$RequirePaddingValues$Absolute$3;
                }
                int i6 = 0;
                IllegalArgumentException $i$a$RequirePaddingValues$Absolute$2 = new IllegalArgumentException("Top padding must be non-negative".toString());
                throw $i$a$RequirePaddingValues$Absolute$2;
            }
            int i5 = 0;
            IllegalArgumentException $i$a$RequirePaddingValues$Absolute$1 = new IllegalArgumentException("Left padding must be non-negative".toString());
            throw $i$a$RequirePaddingValues$Absolute$1;
        }

        public Absolute(float f, float f2, float f3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float obj7;
            float obj8;
            float obj9;
            float obj10;
            int obj12;
            if (i5 & 1 != 0) {
                obj12 = 0;
                f6 = obj7;
            } else {
                f6 = f;
            }
            if (i5 & 2 != 0) {
                obj8 = 0;
                f7 = obj8;
            } else {
                f7 = f2;
            }
            if (i5 & 4 != 0) {
                obj8 = 0;
                f8 = obj9;
            } else {
                f8 = f3;
            }
            if (i5 & 8 != 0) {
                obj8 = 0;
                f9 = obj10;
            } else {
                f9 = f4;
            }
            super(f6, f7, f8, f9, 0);
        }

        public Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(f, f2, f3, f4);
        }

        private static void getBottom-D9Ej5fM$annotations() {
        }

        private static void getLeft-D9Ej5fM$annotations() {
        }

        private static void getRight-D9Ej5fM$annotations() {
        }

        private static void getTop-D9Ej5fM$annotations() {
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float calculateBottomPadding-D9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float calculateLeftPadding-u2uoSUM(LayoutDirection layoutDirection) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public float calculateRightPadding-u2uoSUM(LayoutDirection layoutDirection) {
            return this.right;
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
            if (!other instanceof PaddingValues.Absolute) {
                return 0;
            }
            if (Dp.equals-impl0(this.left, obj.left) && Dp.equals-impl0(this.top, obj2.top) && Dp.equals-impl0(this.right, obj3.right) && Dp.equals-impl0(this.bottom, obj4.bottom)) {
                if (Dp.equals-impl0(this.top, obj2.top)) {
                    if (Dp.equals-impl0(this.right, obj3.right)) {
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
        public int hashCode() {
            return i6 += i10;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("PaddingValues.Absolute(left=").append(Dp.toString-impl(this.left)).append(", top=").append(Dp.toString-impl(this.top)).append(", right=").append(Dp.toString-impl(this.right)).append(", bottom=").append(Dp.toString-impl(this.bottom)).append(')').toString();
        }
    }
    public abstract float calculateBottomPadding-D9Ej5fM();

    public abstract float calculateLeftPadding-u2uoSUM(LayoutDirection layoutDirection);

    public abstract float calculateRightPadding-u2uoSUM(LayoutDirection layoutDirection);

    public abstract float calculateTopPadding-D9Ej5fM();
}
