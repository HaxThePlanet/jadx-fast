package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0001\u001a\u000c\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\"\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u001e\u0010\u000c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"FocusableInNonTouchModeElement", "androidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1", "Landroidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1;", "focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusableKt {

    private static final androidx.compose.foundation.FocusableKt.FocusableInNonTouchModeElement.1 FocusableInNonTouchModeElement;
    private static final InspectableModifier focusGroupInspectorInfo;
    static {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new FocusableKt.special$$inlined.debugInspectorInfo.1();
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        InspectableModifier inspectableModifier = new InspectableModifier(noInspectorInfo);
        FocusableKt.focusGroupInspectorInfo = inspectableModifier;
        FocusableKt.FocusableInNonTouchModeElement.1 anon = new FocusableKt.FocusableInNonTouchModeElement.1();
        FocusableKt.FocusableInNonTouchModeElement = anon;
    }

    public static final Modifier focusGroup(Modifier $this$focusGroup) {
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties($this$focusGroup.then((Modifier)FocusableKt.focusGroupInspectorInfo), (Function1)FocusableKt.focusGroup.1.INSTANCE));
    }

    public static final Modifier focusable(Modifier $this$focusable, boolean enabled, MutableInteractionSource interactionSource) {
        Object focusableElement;
        if (enabled) {
            focusableElement = new FocusableElement(interactionSource);
        } else {
            focusableElement = Modifier.Companion;
        }
        return $this$focusable.then(focusableElement);
    }

    public static Modifier focusable$default(Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 1;
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return FocusableKt.focusable(modifier, obj1, obj2);
    }

    public static final Modifier focusableInNonTouchMode(Modifier $this$focusableInNonTouchMode, boolean enabled, MutableInteractionSource interactionSource) {
        Object focusableInNonTouchModeElement;
        focusableInNonTouchModeElement = enabled ? FocusableKt.FocusableInNonTouchModeElement : Modifier.Companion;
        return FocusableKt.focusable($this$focusableInNonTouchMode.then((Modifier)focusableInNonTouchModeElement), enabled, interactionSource);
    }
}
