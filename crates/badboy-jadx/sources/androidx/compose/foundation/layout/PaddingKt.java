package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a&\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a:\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a>\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a*\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a>\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaddingKt {
    public static final androidx.compose.foundation.layout.PaddingValues PaddingValues-0680j_4(float all) {
        PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(all, all, all, all, 0);
        return (PaddingValues)paddingValuesImpl;
    }

    public static final androidx.compose.foundation.layout.PaddingValues PaddingValues-YgX7TsA(float horizontal, float vertical) {
        PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(horizontal, vertical, horizontal, vertical, 0);
        return (PaddingValues)paddingValuesImpl;
    }

    public static androidx.compose.foundation.layout.PaddingValues PaddingValues-YgX7TsA$default(float f, float f2, int i3, Object object4) {
        float f3;
        float obj1;
        float obj2;
        int obj3;
        int obj4;
        if (i3 & 1 != 0) {
            obj4 = 0;
            obj1 = Dp.constructor-impl((float)obj1);
        }
        if (i3 &= 2 != 0) {
            obj3 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        return PaddingKt.PaddingValues-YgX7TsA(obj1, obj2);
    }

    public static final androidx.compose.foundation.layout.PaddingValues PaddingValues-a9UjIt4(float start, float top, float end, float bottom) {
        PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(start, top, end, bottom, 0);
        return (PaddingValues)paddingValuesImpl;
    }

    public static androidx.compose.foundation.layout.PaddingValues PaddingValues-a9UjIt4$default(float f, float f2, float f3, float f4, int i5, Object object6) {
        float f5;
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        int obj5;
        int obj6;
        if (i5 & 1 != 0) {
            obj6 = 0;
            obj1 = Dp.constructor-impl((float)obj1);
        }
        if (i5 & 2 != 0) {
            obj6 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i5 & 4 != 0) {
            obj6 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        if (i5 &= 8 != 0) {
            obj5 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        return PaddingKt.PaddingValues-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static final Modifier absolutePadding-qDBjuR0(Modifier $this$absolutePadding_u2dqDBjuR0, float left, float top, float right, float bottom) {
        PaddingKt.absolutePadding.1 anon = new PaddingKt.absolutePadding.1(left, top, right, bottom);
        PaddingElement paddingElement = new PaddingElement(left, top, right, bottom, 0, (Function1)anon, 0);
        return $this$absolutePadding_u2dqDBjuR0.then((Modifier)paddingElement);
    }

    public static Modifier absolutePadding-qDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float f;
        float obj2;
        float obj3;
        float obj4;
        float obj5;
        int obj6;
        int obj7;
        if (i6 & 1 != 0) {
            obj7 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i6 & 2 != 0) {
            obj7 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        if (i6 & 4 != 0) {
            obj7 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        if (i6 &= 8 != 0) {
            obj6 = 0;
            obj5 = Dp.constructor-impl((float)obj5);
        }
        return PaddingKt.absolutePadding-qDBjuR0(modifier, obj2, obj3, obj4, obj5);
    }

    public static final float calculateEndPadding(androidx.compose.foundation.layout.PaddingValues $this$calculateEndPadding, LayoutDirection layoutDirection) {
        float rightPadding-u2uoSUM;
        if (layoutDirection == LayoutDirection.Ltr) {
            rightPadding-u2uoSUM = $this$calculateEndPadding.calculateRightPadding-u2uoSUM(layoutDirection);
        } else {
            rightPadding-u2uoSUM = $this$calculateEndPadding.calculateLeftPadding-u2uoSUM(layoutDirection);
        }
        return rightPadding-u2uoSUM;
    }

    public static final float calculateStartPadding(androidx.compose.foundation.layout.PaddingValues $this$calculateStartPadding, LayoutDirection layoutDirection) {
        float rightPadding-u2uoSUM;
        if (layoutDirection == LayoutDirection.Ltr) {
            rightPadding-u2uoSUM = $this$calculateStartPadding.calculateLeftPadding-u2uoSUM(layoutDirection);
        } else {
            rightPadding-u2uoSUM = $this$calculateStartPadding.calculateRightPadding-u2uoSUM(layoutDirection);
        }
        return rightPadding-u2uoSUM;
    }

    public static final Modifier padding(Modifier $this$padding, androidx.compose.foundation.layout.PaddingValues paddingValues) {
        PaddingKt.padding.4 anon = new PaddingKt.padding.4(paddingValues);
        PaddingValuesElement paddingValuesElement = new PaddingValuesElement(paddingValues, (Function1)anon);
        return $this$padding.then((Modifier)paddingValuesElement);
    }

    public static final Modifier padding-3ABfNKs(Modifier $this$padding_u2d3ABfNKs, float all) {
        PaddingKt.padding.3 anon = new PaddingKt.padding.3(all);
        PaddingElement paddingElement = new PaddingElement(all, all, all, all, 1, (Function1)anon, 0);
        return $this$padding_u2d3ABfNKs.then((Modifier)paddingElement);
    }

    public static final Modifier padding-VpY3zN4(Modifier $this$padding_u2dVpY3zN4, float horizontal, float vertical) {
        PaddingKt.padding.2 anon = new PaddingKt.padding.2(horizontal, vertical);
        PaddingElement paddingElement = new PaddingElement(horizontal, vertical, horizontal, vertical, 1, (Function1)anon, 0);
        return $this$padding_u2dVpY3zN4.then((Modifier)paddingElement);
    }

    public static Modifier padding-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float f;
        float obj2;
        float obj3;
        int obj4;
        int obj5;
        if (i4 & 1 != 0) {
            obj5 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i4 &= 2 != 0) {
            obj4 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        return PaddingKt.padding-VpY3zN4(modifier, obj2, obj3);
    }

    public static final Modifier padding-qDBjuR0(Modifier $this$padding_u2dqDBjuR0, float start, float top, float end, float bottom) {
        PaddingKt.padding.1 anon = new PaddingKt.padding.1(start, top, end, bottom);
        PaddingElement paddingElement = new PaddingElement(start, top, end, bottom, 1, (Function1)anon, 0);
        return $this$padding_u2dqDBjuR0.then((Modifier)paddingElement);
    }

    public static Modifier padding-qDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float f;
        float obj2;
        float obj3;
        float obj4;
        float obj5;
        int obj6;
        int obj7;
        if (i6 & 1 != 0) {
            obj7 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i6 & 2 != 0) {
            obj7 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        if (i6 & 4 != 0) {
            obj7 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        if (i6 &= 8 != 0) {
            obj6 = 0;
            obj5 = Dp.constructor-impl((float)obj5);
        }
        return PaddingKt.padding-qDBjuR0(modifier, obj2, obj3, obj4, obj5);
    }
}
