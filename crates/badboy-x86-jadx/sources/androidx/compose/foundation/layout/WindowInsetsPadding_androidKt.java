package androidx.compose.foundation.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0008\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000c\u001a\u00020\u0001*\u00020\u0001\u001aC\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0019\u0008\u0008\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\u0008\u00122\u0019\u0008\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\u0008\u0012H\u0083\u0008¨\u0006\u0016", d2 = {"captionBarPadding", "Landroidx/compose/ui/Modifier;", "displayCutoutPadding", "imePadding", "mandatorySystemGesturesPadding", "navigationBarsPadding", "safeContentPadding", "safeDrawingPadding", "safeGesturesPadding", "statusBarsPadding", "systemBarsPadding", "systemGesturesPadding", "waterfallPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsPadding_androidKt {
    public static final Modifier captionBarPadding(Modifier $this$captionBarPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.captionBarPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.captionBarPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.captionBarPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$captionBarPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier displayCutoutPadding(Modifier $this$displayCutoutPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.displayCutoutPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.displayCutoutPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.displayCutoutPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$displayCutoutPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier imePadding(Modifier $this$imePadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.imePadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.imePadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.imePadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$imePadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier $this$mandatorySystemGesturesPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.mandatorySystemGesturesPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.mandatorySystemGesturesPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.mandatorySystemGesturesPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$mandatorySystemGesturesPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier navigationBarsPadding(Modifier $this$navigationBarsPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.navigationBarsPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.navigationBarsPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.navigationBarsPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$navigationBarsPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier safeContentPadding(Modifier $this$safeContentPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.safeContentPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.safeContentPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.safeContentPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$safeContentPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier safeDrawingPadding(Modifier $this$safeDrawingPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.safeDrawingPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.safeDrawingPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.safeDrawingPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$safeDrawingPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier safeGesturesPadding(Modifier $this$safeGesturesPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.safeGesturesPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.safeGesturesPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.safeGesturesPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$safeGesturesPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier statusBarsPadding(Modifier $this$statusBarsPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.statusBarsPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.statusBarsPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.statusBarsPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$statusBarsPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier systemBarsPadding(Modifier $this$systemBarsPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.systemBarsPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.systemBarsPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.systemBarsPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$systemBarsPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier systemGesturesPadding(Modifier $this$systemGesturesPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.systemGesturesPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.systemGesturesPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.systemGesturesPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$systemGesturesPadding, noInspectorInfo, (Function3)anon);
    }

    public static final Modifier waterfallPadding(Modifier $this$waterfallPadding) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new WindowInsetsPadding_androidKt.waterfallPadding$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final int i2 = 0;
        WindowInsetsPadding_androidKt.waterfallPadding$$inlined.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.waterfallPadding$$inlined.windowInsetsPadding.1();
        return ComposedModifierKt.composed($this$waterfallPadding, noInspectorInfo, (Function3)anon);
    }

    private static final Modifier windowInsetsPadding(Modifier $this$windowInsetsPadding, Function1<? super InspectorInfo, Unit> inspectorInfo, Function1<? super androidx.compose.foundation.layout.WindowInsetsHolder, ? extends androidx.compose.foundation.layout.WindowInsets> insetsCalculation) {
        final int i = 0;
        WindowInsetsPadding_androidKt.windowInsetsPadding.1 anon = new WindowInsetsPadding_androidKt.windowInsetsPadding.1(insetsCalculation);
        return ComposedModifierKt.composed($this$windowInsetsPadding, inspectorInfo, (Function3)anon);
    }
}
