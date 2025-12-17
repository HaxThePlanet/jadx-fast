package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007", d2 = {"windowInsetsBottomHeight", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsetsEndWidth", "windowInsetsStartWidth", "windowInsetsTopHeight", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsSizeKt {
    public static final Modifier windowInsetsBottomHeight(Modifier $this$windowInsetsBottomHeight, androidx.compose.foundation.layout.WindowInsets insets) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsSizeKt.windowInsetsBottomHeight$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        DerivedHeightModifier derivedHeightModifier = new DerivedHeightModifier(insets, noInspectorInfo, (Function2)WindowInsetsSizeKt.windowInsetsBottomHeight.2.INSTANCE);
        return $this$windowInsetsBottomHeight.then((Modifier)derivedHeightModifier);
    }

    public static final Modifier windowInsetsEndWidth(Modifier $this$windowInsetsEndWidth, androidx.compose.foundation.layout.WindowInsets insets) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsSizeKt.windowInsetsEndWidth$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        DerivedWidthModifier derivedWidthModifier = new DerivedWidthModifier(insets, noInspectorInfo, (Function3)WindowInsetsSizeKt.windowInsetsEndWidth.2.INSTANCE);
        return $this$windowInsetsEndWidth.then((Modifier)derivedWidthModifier);
    }

    public static final Modifier windowInsetsStartWidth(Modifier $this$windowInsetsStartWidth, androidx.compose.foundation.layout.WindowInsets insets) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsSizeKt.windowInsetsStartWidth$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        DerivedWidthModifier derivedWidthModifier = new DerivedWidthModifier(insets, noInspectorInfo, (Function3)WindowInsetsSizeKt.windowInsetsStartWidth.2.INSTANCE);
        return $this$windowInsetsStartWidth.then((Modifier)derivedWidthModifier);
    }

    public static final Modifier windowInsetsTopHeight(Modifier $this$windowInsetsTopHeight, androidx.compose.foundation.layout.WindowInsets insets) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsSizeKt.windowInsetsTopHeight$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        DerivedHeightModifier derivedHeightModifier = new DerivedHeightModifier(insets, noInspectorInfo, (Function2)WindowInsetsSizeKt.windowInsetsTopHeight.2.INSTANCE);
        return $this$windowInsetsTopHeight.then((Modifier)derivedHeightModifier);
    }
}
