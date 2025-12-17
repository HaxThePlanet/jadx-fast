package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0007\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000cH\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003¨\u0006\r", d2 = {"HandwritingBoundsHorizontalOffset", "Landroidx/compose/ui/unit/Dp;", "getHandwritingBoundsHorizontalOffset", "()F", "F", "HandwritingBoundsVerticalOffset", "getHandwritingBoundsVerticalOffset", "stylusHandwriting", "Landroidx/compose/ui/Modifier;", "enabled", "", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StylusHandwritingKt {

    private static final float HandwritingBoundsHorizontalOffset;
    private static final float HandwritingBoundsVerticalOffset;
    static {
        int i3 = 0;
        StylusHandwritingKt.HandwritingBoundsVerticalOffset = Dp.constructor-impl((float)i);
        int i4 = 0;
        StylusHandwritingKt.HandwritingBoundsHorizontalOffset = Dp.constructor-impl((float)i2);
    }

    public static final float getHandwritingBoundsHorizontalOffset() {
        return StylusHandwritingKt.HandwritingBoundsHorizontalOffset;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return StylusHandwritingKt.HandwritingBoundsVerticalOffset;
    }

    public static final Modifier stylusHandwriting(Modifier $this$stylusHandwriting, boolean enabled, Function0<Boolean> onHandwritingSlopExceeded) {
        boolean stylusHandwritingSupported;
        Modifier padding-VpY3zN4;
        float handwritingBoundsHorizontalOffset;
        float handwritingBoundsVerticalOffset;
        if (enabled && StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                StylusHandwritingElementWithNegativePadding stylusHandwritingElementWithNegativePadding = new StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded);
                padding-VpY3zN4 = PaddingKt.padding-VpY3zN4($this$stylusHandwriting.then((Modifier)stylusHandwritingElementWithNegativePadding), StylusHandwritingKt.HandwritingBoundsHorizontalOffset, StylusHandwritingKt.HandwritingBoundsVerticalOffset);
            } else {
                padding-VpY3zN4 = $this$stylusHandwriting;
            }
        } else {
        }
        return padding-VpY3zN4;
    }
}
