package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001a#\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006\u001a*\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"absoluteOffset", "Landroidx/compose/ui/Modifier;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "absoluteOffset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "offset-VpY3zN4", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OffsetKt {
    public static final Modifier absoluteOffset(Modifier $this$absoluteOffset, Function1<? super Density, IntOffset> offset) {
        OffsetKt.absoluteOffset.2 anon = new OffsetKt.absoluteOffset.2(offset);
        OffsetPxElement offsetPxElement = new OffsetPxElement(offset, 0, (Function1)anon);
        return $this$absoluteOffset.then((Modifier)offsetPxElement);
    }

    public static final Modifier absoluteOffset-VpY3zN4(Modifier $this$absoluteOffset_u2dVpY3zN4, float x, float y) {
        OffsetKt.absoluteOffset.1 anon = new OffsetKt.absoluteOffset.1(x, y);
        OffsetElement offsetElement = new OffsetElement(x, y, 0, (Function1)anon, 0);
        return $this$absoluteOffset_u2dVpY3zN4.then((Modifier)offsetElement);
    }

    public static Modifier absoluteOffset-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
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
        return OffsetKt.absoluteOffset-VpY3zN4(modifier, obj2, obj3);
    }

    public static final Modifier offset(Modifier $this$offset, Function1<? super Density, IntOffset> offset) {
        OffsetKt.offset.2 anon = new OffsetKt.offset.2(offset);
        OffsetPxElement offsetPxElement = new OffsetPxElement(offset, 1, (Function1)anon);
        return $this$offset.then((Modifier)offsetPxElement);
    }

    public static final Modifier offset-VpY3zN4(Modifier $this$offset_u2dVpY3zN4, float x, float y) {
        OffsetKt.offset.1 anon = new OffsetKt.offset.1(x, y);
        OffsetElement offsetElement = new OffsetElement(x, y, 1, (Function1)anon, 0);
        return $this$offset_u2dVpY3zN4.then((Modifier)offsetElement);
    }

    public static Modifier offset-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
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
        return OffsetKt.offset-VpY3zN4(modifier, obj2, obj3);
    }
}
