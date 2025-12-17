package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a8\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u001a.\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u000c\u0010\u000c\u001a\u00020\u0001*\u00020\rH\u0000\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"WindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "", "add", "insets", "asInsets", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "exclude", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "union", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsKt {
    public static final androidx.compose.foundation.layout.WindowInsets WindowInsets(int left, int top, int right, int bottom) {
        FixedIntInsets fixedIntInsets = new FixedIntInsets(left, top, right, bottom);
        return (WindowInsets)fixedIntInsets;
    }

    public static androidx.compose.foundation.layout.WindowInsets WindowInsets$default(int i, int i2, int i3, int i4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        final int i6 = 0;
        if (i5 & 1 != 0) {
            obj1 = i6;
        }
        if (i5 & 2 != 0) {
            obj2 = i6;
        }
        if (i5 & 4 != 0) {
            obj3 = i6;
        }
        if (i5 &= 8 != 0) {
            obj4 = i6;
        }
        return WindowInsetsKt.WindowInsets(obj1, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.layout.WindowInsets WindowInsets-a9UjIt4(float left, float top, float right, float bottom) {
        FixedDpInsets fixedDpInsets = new FixedDpInsets(left, top, right, bottom, 0);
        return (WindowInsets)fixedDpInsets;
    }

    public static androidx.compose.foundation.layout.WindowInsets WindowInsets-a9UjIt4$default(float f, float f2, float f3, float f4, int i5, Object object6) {
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
        return WindowInsetsKt.WindowInsets-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.layout.WindowInsets add(androidx.compose.foundation.layout.WindowInsets $this$add, androidx.compose.foundation.layout.WindowInsets insets) {
        AddedInsets addedInsets = new AddedInsets($this$add, insets);
        return (WindowInsets)addedInsets;
    }

    public static final androidx.compose.foundation.layout.WindowInsets asInsets(androidx.compose.foundation.layout.PaddingValues $this$asInsets) {
        PaddingValuesInsets paddingValuesInsets = new PaddingValuesInsets($this$asInsets);
        return (WindowInsets)paddingValuesInsets;
    }

    public static final androidx.compose.foundation.layout.PaddingValues asPaddingValues(androidx.compose.foundation.layout.WindowInsets $this$asPaddingValues, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1485016250;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(asPaddingValues)244@9228L7:WindowInsets.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:244)");
        }
        int i2 = 0;
        final int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues($this$asPaddingValues, (Density)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (PaddingValues)insetsPaddingValues;
    }

    public static final androidx.compose.foundation.layout.PaddingValues asPaddingValues(androidx.compose.foundation.layout.WindowInsets $this$asPaddingValues, Density density) {
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues($this$asPaddingValues, density);
        return (PaddingValues)insetsPaddingValues;
    }

    public static final androidx.compose.foundation.layout.WindowInsets exclude(androidx.compose.foundation.layout.WindowInsets $this$exclude, androidx.compose.foundation.layout.WindowInsets insets) {
        ExcludeInsets excludeInsets = new ExcludeInsets($this$exclude, insets);
        return (WindowInsets)excludeInsets;
    }

    public static final androidx.compose.foundation.layout.WindowInsets only-bOOhFvg(androidx.compose.foundation.layout.WindowInsets $this$only_u2dbOOhFvg, int sides) {
        LimitInsets limitInsets = new LimitInsets($this$only_u2dbOOhFvg, sides, 0);
        return (WindowInsets)limitInsets;
    }

    public static final androidx.compose.foundation.layout.WindowInsets union(androidx.compose.foundation.layout.WindowInsets $this$union, androidx.compose.foundation.layout.WindowInsets insets) {
        UnionInsets unionInsets = new UnionInsets($this$union, insets);
        return (WindowInsets)unionInsets;
    }
}
