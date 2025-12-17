package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u0000 >2\u00020\u0001:\u0001>BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0008¢\u0006\u0002\u0010\u000cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0016\u0010!\u001a\u00020\u0008HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010\u0011J\u0016\u0010#\u001a\u00020\u0008HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008$\u0010\u0011J\u0016\u0010%\u001a\u00020\u0008HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008&\u0010\u0011J\u0016\u0010'\u001a\u00020\u0008HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010\u0011J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.Jc\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0008HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u00080\u00101J\u0013\u00102\u001a\u00020*2\u0008\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\u0008\u0010;\u001a\u00020\u0000H\u0002J\u0008\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\n\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0019\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006?", d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RoundRect {

    public static final int $stable;
    public static final androidx.compose.ui.geometry.RoundRect.Companion Companion;
    private static final androidx.compose.ui.geometry.RoundRect Zero;
    private androidx.compose.ui.geometry.RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @JvmStatic
        public static void getZero$annotations() {
        }

        public final androidx.compose.ui.geometry.RoundRect getZero() {
            return RoundRect.access$getZero$cp();
        }
    }
    static {
        RoundRect.Companion companion = new RoundRect.Companion(0);
        RoundRect.Companion = companion;
        RoundRect.Zero = RoundRectKt.RoundRect-gG7oq9Y(0, 0, 0, 0, CornerRadius.Companion.getZero-kKHJgLs());
    }

    private RoundRect(float left, float top, float right, float bottom, long topLeftCornerRadius, long topRightCornerRadius, long bottomRightCornerRadius, long bottomLeftCornerRadius) {
        super();
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.topLeftCornerRadius = topLeftCornerRadius;
        this.topRightCornerRadius = bottomRightCornerRadius;
        this.bottomRightCornerRadius = obj9;
        this.bottomLeftCornerRadius = obj11;
    }

    public RoundRect(float f, float f2, float f3, float f4, long l5, long l6, long l7, long l8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int zero-kKHJgLs2;
        int zero-kKHJgLs4;
        int zero-kKHJgLs;
        long zero-kKHJgLs3;
        long l2;
        long l3;
        long l4;
        long l;
        int i = obj30;
        if (i & 16 != 0) {
            l2 = zero-kKHJgLs4;
        } else {
            l2 = l5;
        }
        if (i & 32 != 0) {
            l3 = zero-kKHJgLs;
        } else {
            l3 = l7;
        }
        if (i & 64 != 0) {
            l4 = zero-kKHJgLs3;
        } else {
            l4 = i9;
        }
        if (i &= 128 != 0) {
            l = zero-kKHJgLs2;
        } else {
            l = obj28;
        }
        super(f, f2, f3, f4, l2, obj9, l3, obj11, l4, obj13, l, obj15, 0);
    }

    public RoundRect(float f, float f2, float f3, float f4, long l5, long l6, long l7, long l8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(f, f2, f3, f4, l5, l6, l7, l8, defaultConstructorMarker9, obj10, obj11, obj12);
    }

    public static final androidx.compose.ui.geometry.RoundRect access$getZero$cp() {
        return RoundRect.Zero;
    }

    public static androidx.compose.ui.geometry.RoundRect copy-MDFrsts$default(androidx.compose.ui.geometry.RoundRect roundRect, float f2, float f3, float f4, float f5, long l6, long l7, long l8, long l9, int i10, Object object11) {
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        long obj5;
        long obj7;
        long obj9;
        long obj11;
        if (obj13 & 1 != 0) {
            obj1 = roundRect.left;
        }
        if (obj13 & 2 != 0) {
            obj2 = roundRect.top;
        }
        if (obj13 & 4 != 0) {
            obj3 = roundRect.right;
        }
        if (obj13 & 8 != 0) {
            obj4 = roundRect.bottom;
        }
        if (obj13 & 16 != 0) {
            obj5 = roundRect.topLeftCornerRadius;
        }
        if (obj13 & 32 != 0) {
            obj7 = roundRect.topRightCornerRadius;
        }
        int obj14 = obj13 & 64;
        if (obj14 != null) {
            obj9 = roundRect.bottomRightCornerRadius;
        }
        if (obj13 &= 128 != 0) {
            obj11 = roundRect.bottomLeftCornerRadius;
        }
        return roundRect.copy-MDFrsts(obj1, obj2, obj3, obj4, obj5, l9, obj7, object11);
    }

    public static final androidx.compose.ui.geometry.RoundRect getZero() {
        return RoundRect.Companion.getZero();
    }

    private final float minRadius(float min, float radius1, float radius2, float limit) {
        float f;
        int cmp;
        final int i = radius1 + radius2;
        if (Float.compare(i, limit) > 0) {
            cmp = Float.compare(i, i2) == 0 ? 1 : 0;
            if (cmp == 0) {
                f = Math.min(min, limit / i);
            } else {
                f = min;
            }
        } else {
        }
        return f;
    }

    private final androidx.compose.ui.geometry.RoundRect scaledRadiiRect() {
        androidx.compose.ui.geometry.RoundRect $this$scaledRadiiRect_u24lambda_u240;
        int i6;
        int i2;
        androidx.compose.ui.geometry.RoundRect roundRect;
        long l7;
        long l2;
        int i5;
        int i3;
        long l6;
        long l4;
        long l3;
        long l5;
        long l9;
        long l;
        long l8;
        int i;
        int i4;
        float f;
        final Object obj = this;
        if (obj._scaledRadiiRect == null) {
            Object obj2 = obj;
            float y-impl4 = CornerRadius.getY-impl(obj2.topLeftCornerRadius);
            float height = (RoundRect)obj2.getHeight();
            float x-impl4 = CornerRadius.getX-impl(obj2.topRightCornerRadius);
            float width = obj2.getWidth();
            float y-impl5 = CornerRadius.getY-impl(obj2.bottomRightCornerRadius);
            float height2 = obj2.getHeight();
            float scale4 = obj2.minRadius(obj2.minRadius(obj2.minRadius(obj2.minRadius(1065353216, CornerRadius.getY-impl(obj2.bottomLeftCornerRadius), y-impl4, height), CornerRadius.getX-impl(obj2.topLeftCornerRadius), x-impl4, width), CornerRadius.getY-impl(obj2.topRightCornerRadius), y-impl5, height2), CornerRadius.getX-impl(obj2.bottomRightCornerRadius), CornerRadius.getX-impl(obj2.bottomLeftCornerRadius), obj2.getWidth());
            y-impl6 *= scale4;
            y-impl7 *= scale4;
            y-impl8 *= scale4;
            i4 = i7;
            f = scale4;
            roundRect = roundRect3;
            roundRect = new RoundRect(left *= scale4, top *= scale4, right *= scale4, bottom *= scale4, CornerRadiusKt.CornerRadius(x-impl6 *= scale4, l4), l4, CornerRadiusKt.CornerRadius(x-impl7 *= scale4, l5), l5, CornerRadiusKt.CornerRadius(x-impl8 *= scale4, l), l, CornerRadiusKt.CornerRadius(x-impl *= f, y-impl *= f), obj16, 0);
            i6 = 0;
            obj._scaledRadiiRect = roundRect;
        }
        return $this$scaledRadiiRect_u24lambda_u240;
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

    public final long component5-kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    public final long component6-kKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final long component7-kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final long component8-kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final boolean contains-k-4lQ0M(long point) {
        int cmp5;
        int i2;
        int i;
        float bottom;
        float x-impl2;
        float y-impl2;
        int i5;
        int cmp3;
        int cmp;
        int cmp2;
        int cmp4;
        long bottomLeftCornerRadius;
        float x-impl;
        int i4;
        int i3;
        int i6;
        float y-impl;
        if (Float.compare(x-impl3, left) >= 0 && Float.compare(x-impl4, bottom) < 0 && Float.compare(y-impl3, bottom) >= 0) {
            if (Float.compare(x-impl4, bottom) < 0) {
                if (Float.compare(y-impl3, bottom) >= 0) {
                    if (Float.compare(y-impl4, bottom) >= 0) {
                    } else {
                        androidx.compose.ui.geometry.RoundRect scaledRadiiRect = scaledRadiiRect();
                        int i7 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i20 = 1;
                        y-impl = CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius);
                        if (Float.compare(x-impl5, i19) < 0 && Float.compare(y-impl9, x-impl) < 0) {
                            y-impl = CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius);
                            if (Float.compare(y-impl9, x-impl) < 0) {
                                i15 -= x-impl13;
                                i8 -= y-impl13;
                                x-impl2 = CornerRadius.getX-impl(scaledRadiiRect.topLeftCornerRadius);
                                y-impl2 = CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius);
                                int radiusY = i5 / x-impl2;
                                int i21 = i / y-impl2;
                                if (Float.compare(i23, i25) <= 0) {
                                    i2 = i20;
                                }
                                return i2;
                            } else {
                                y-impl = CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius);
                                if (Float.compare(x-impl7, i4) > 0 && Float.compare(y-impl12, i4) < 0) {
                                    y-impl = CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius);
                                    if (Float.compare(y-impl12, i4) < 0) {
                                        i18 += x-impl16;
                                        i11 -= y-impl16;
                                        x-impl2 = CornerRadius.getX-impl(scaledRadiiRect.topRightCornerRadius);
                                        y-impl2 = CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius);
                                    } else {
                                        y-impl = CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius);
                                        if (Float.compare(x-impl8, i3) > 0 && Float.compare(y-impl11, i3) > 0) {
                                            y-impl = CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius);
                                            if (Float.compare(y-impl11, i3) > 0) {
                                                i17 += x-impl15;
                                                i10 += y-impl15;
                                                x-impl2 = CornerRadius.getX-impl(scaledRadiiRect.bottomRightCornerRadius);
                                                y-impl2 = CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius);
                                            } else {
                                                y-impl = CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius);
                                                if (Float.compare(x-impl9, i6) < 0 && Float.compare(y-impl10, i6) > 0) {
                                                    y-impl = CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius);
                                                    if (Float.compare(y-impl10, i6) > 0) {
                                                        i16 -= x-impl14;
                                                        i9 += y-impl14;
                                                        x-impl2 = CornerRadius.getX-impl(scaledRadiiRect.bottomLeftCornerRadius);
                                                        y-impl2 = CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius);
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                    return i20;
                }
            }
        }
        return 0;
    }

    public final androidx.compose.ui.geometry.RoundRect copy-MDFrsts(float f, float f2, float f3, float f4, long l5, long l6, long l7, long l8) {
        RoundRect roundRect = new RoundRect(f, f2, f3, f4, l5, obj6, l7, obj8, obj23, obj10, obj25, obj12, 0);
        return roundRect;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof RoundRect) {
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
        float bottom2 = obj.bottom;
        if (Float.compare(this.bottom, bottom2) != 0) {
            return i2;
        }
        if (!CornerRadius.equals-impl0(this.topLeftCornerRadius, bottom2)) {
            return i2;
        }
        if (!CornerRadius.equals-impl0(this.topRightCornerRadius, bottom2)) {
            return i2;
        }
        if (!CornerRadius.equals-impl0(this.bottomRightCornerRadius, bottom2)) {
            return i2;
        }
        if (!CornerRadius.equals-impl0(this.bottomLeftCornerRadius, bottom2)) {
            return i2;
        }
        return i;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final long getBottomLeftCornerRadius-kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final long getBottomRightCornerRadius-kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return bottom -= top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final long getTopLeftCornerRadius-kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    public final long getTopRightCornerRadius-kKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return right -= left;
    }

    public int hashCode() {
        return i14 += i22;
    }

    public String toString() {
        boolean equals-impl0;
        int i;
        final long topLeftCornerRadius = this.topLeftCornerRadius;
        final long topRightCornerRadius = this.topRightCornerRadius;
        final long bottomRightCornerRadius = this.bottomRightCornerRadius;
        final long bottomLeftCornerRadius = this.bottomLeftCornerRadius;
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 1;
        String str = ", ";
        String string = stringBuilder.append(GeometryUtilsKt.toStringAsFixed(this.left, i2)).append(str).append(GeometryUtilsKt.toStringAsFixed(this.top, i2)).append(str).append(GeometryUtilsKt.toStringAsFixed(this.right, i2)).append(str).append(GeometryUtilsKt.toStringAsFixed(this.bottom, i2)).toString();
        int i3 = 41;
        String str6 = "RoundRect(rect=";
        if (CornerRadius.equals-impl0(topLeftCornerRadius, obj1) && CornerRadius.equals-impl0(topRightCornerRadius, obj3) && CornerRadius.equals-impl0(bottomRightCornerRadius, obj5)) {
            if (CornerRadius.equals-impl0(topRightCornerRadius, obj3)) {
                if (CornerRadius.equals-impl0(bottomRightCornerRadius, obj5)) {
                    i = Float.compare(x-impl, y-impl2) == 0 ? i2 : 0;
                    if (i != 0) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        return stringBuilder3.append(str6).append(string).append(", radius=").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(topLeftCornerRadius), i2)).append(i3).toString();
                    }
                    StringBuilder stringBuilder4 = new StringBuilder();
                    return stringBuilder4.append(str6).append(string).append(", x=").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(topLeftCornerRadius), i2)).append(", y=").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getY-impl(topLeftCornerRadius), i2)).append(i3).toString();
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        return stringBuilder2.append(str6).append(string).append(", topLeft=").append(CornerRadius.toString-impl(topLeftCornerRadius)).append(", topRight=").append(CornerRadius.toString-impl(topRightCornerRadius)).append(", bottomRight=").append(CornerRadius.toString-impl(bottomRightCornerRadius)).append(", bottomLeft=").append(CornerRadius.toString-impl(bottomLeftCornerRadius)).append(i3).toString();
    }
}
