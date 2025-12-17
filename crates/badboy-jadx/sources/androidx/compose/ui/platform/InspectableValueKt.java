package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a5\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u00042\u0019\u0008\u0004\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u0004H\u0086\u0008\u001aA\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0019\u0008\u0008\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u00042\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\u0002\u0008\u0004H\u0087\u0008\u001a-\u0010\u0012\u001a\u00020\u000f*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u0014", d2 = {"NoInspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "getNoInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "isDebugInspectorInfoEnabled", "", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "debugInspectorInfo", "definitions", "inspectable", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "factory", "inspectableWrapper", "wrapped", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InspectableValueKt {

    private static final Function1<androidx.compose.ui.platform.InspectorInfo, Unit> NoInspectorInfo;
    private static boolean isDebugInspectorInfoEnabled;
    static {
        InspectableValueKt.NoInspectorInfo = (Function1)InspectableValueKt.NoInspectorInfo.1.INSTANCE;
    }

    public static final Function1<androidx.compose.ui.platform.InspectorInfo, Unit> debugInspectorInfo(Function1<? super androidx.compose.ui.platform.InspectorInfo, Unit> definitions) {
        Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new InspectableValueKt.debugInspectorInfo.1(definitions);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return noInspectorInfo;
    }

    public static final Function1<androidx.compose.ui.platform.InspectorInfo, Unit> getNoInspectorInfo() {
        return InspectableValueKt.NoInspectorInfo;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This API will create more invalidations of your modifier than necessary, so it's use is discouraged. Implementing the inspectableProperties method on ModifierNodeElement is the recommended zero-cost alternative to exposing properties on a Modifier to tooling.")
    public static final Modifier inspectable(Modifier $this$inspectable, Function1<? super androidx.compose.ui.platform.InspectorInfo, Unit> inspectorInfo, Function1<? super Modifier, ? extends Modifier> factory) {
        final int i = 0;
        return InspectableValueKt.inspectableWrapper($this$inspectable, inspectorInfo, (Modifier)factory.invoke(Modifier.Companion));
    }

    public static final Modifier inspectableWrapper(Modifier $this$inspectableWrapper, Function1<? super androidx.compose.ui.platform.InspectorInfo, Unit> inspectorInfo, Modifier wrapped) {
        InspectableModifier inspectableModifier = new InspectableModifier(inspectorInfo);
        return $this$inspectableWrapper.then((Modifier)inspectableModifier).then(wrapped).then((Modifier)inspectableModifier.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return InspectableValueKt.isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean <set-?>) {
        InspectableValueKt.isDebugInspectorInfoEnabled = <set-?>;
    }
}
