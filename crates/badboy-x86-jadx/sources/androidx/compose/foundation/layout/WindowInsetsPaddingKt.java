package androidx.compose.foundation.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a/\u0010\n\u001a\u00020\u0006*\u00020\u00062!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u000cH\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0012", d2 = {"ModifierLocalConsumedWindowInsets", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/layout/WindowInsets;", "getModifierLocalConsumedWindowInsets", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "consumeWindowInsets", "Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "onConsumedWindowInsetsChanged", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "consumedWindowInsets", "", "windowInsetsPadding", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsPaddingKt {

    private static final ProvidableModifierLocal<androidx.compose.foundation.layout.WindowInsets> ModifierLocalConsumedWindowInsets;
    static {
        WindowInsetsPaddingKt.ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf((Function0)WindowInsetsPaddingKt.ModifierLocalConsumedWindowInsets.1.INSTANCE);
    }

    public static final Modifier consumeWindowInsets(Modifier $this$consumeWindowInsets, androidx.compose.foundation.layout.PaddingValues paddingValues) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPaddingKt.consumeWindowInsets$$inlined.debugInspectorInfo.2(paddingValues);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        WindowInsetsPaddingKt.consumeWindowInsets.4 $i$f$debugInspectorInfo = new WindowInsetsPaddingKt.consumeWindowInsets.4(paddingValues);
        return ComposedModifierKt.composed($this$consumeWindowInsets, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static final Modifier consumeWindowInsets(Modifier $this$consumeWindowInsets, androidx.compose.foundation.layout.WindowInsets insets) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPaddingKt.consumeWindowInsets$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        WindowInsetsPaddingKt.consumeWindowInsets.2 $i$f$debugInspectorInfo = new WindowInsetsPaddingKt.consumeWindowInsets.2(insets);
        return ComposedModifierKt.composed($this$consumeWindowInsets, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static final ProvidableModifierLocal<androidx.compose.foundation.layout.WindowInsets> getModifierLocalConsumedWindowInsets() {
        return WindowInsetsPaddingKt.ModifierLocalConsumedWindowInsets;
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier $this$onConsumedWindowInsetsChanged, Function1<? super androidx.compose.foundation.layout.WindowInsets, Unit> block) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPaddingKt.onConsumedWindowInsetsChanged$$inlined.debugInspectorInfo.1(block);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        WindowInsetsPaddingKt.onConsumedWindowInsetsChanged.2 $i$f$debugInspectorInfo = new WindowInsetsPaddingKt.onConsumedWindowInsetsChanged.2(block);
        return ComposedModifierKt.composed($this$onConsumedWindowInsetsChanged, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static final Modifier windowInsetsPadding(Modifier $this$windowInsetsPadding, androidx.compose.foundation.layout.WindowInsets insets) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPaddingKt.windowInsetsPadding$$inlined.debugInspectorInfo.1(insets);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        WindowInsetsPaddingKt.windowInsetsPadding.2 $i$f$debugInspectorInfo = new WindowInsetsPaddingKt.windowInsetsPadding.2(insets);
        return ComposedModifierKt.composed($this$windowInsetsPadding, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }
}
