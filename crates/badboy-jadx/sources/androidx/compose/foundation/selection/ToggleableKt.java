package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aX\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0002\u0008\u000e\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0002\u0008\u000f\u001aR\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\u0008\u0015\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\u0008\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToggleableKt {
    public static final Modifier toggleable-O2vRcR0(Modifier $this$toggleable_u2dO2vRcR0, boolean value, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        int indication2;
        Object obj2;
        int $i$a$ClickableWithIndicationIfNeededToggleableKt$toggleable$3;
        boolean z5;
        Role role4;
        Function1 function13;
        Modifier toggleableElement;
        boolean z3;
        MutableInteractionSource mutableInteractionSource;
        Object obj;
        boolean z2;
        Role role2;
        Function1 function1;
        int i;
        androidx.compose.foundation.selection.ToggleableElement toggleableElement2;
        boolean z4;
        MutableInteractionSource mutableInteractionSource2;
        int i2;
        boolean z;
        Role role3;
        Function1 function12;
        int i3;
        obj2 = indication;
        final int i5 = 0;
        if (obj2 instanceof IndicationNodeFactory != null) {
            indication2 = 0;
            toggleableElement = new ToggleableElement(value, interactionSource, (IndicationNodeFactory)obj2, enabled, role, onValueChange, 0);
        } else {
            if (obj2 == null) {
                indication2 = 0;
                toggleableElement2 = new ToggleableElement(value, interactionSource, 0, enabled, role, onValueChange, 0);
                toggleableElement = toggleableElement2;
            } else {
                if (interactionSource != null) {
                    int i4 = 0;
                    toggleableElement2 = new ToggleableElement(value, interactionSource, 0, enabled, role, onValueChange, 0);
                    toggleableElement = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, obj2).then((Modifier)toggleableElement2);
                } else {
                    indication2 = new ToggleableKt.toggleable-O2vRcR0$$inlined.clickableWithIndicationIfNeeded.1(obj2, value, enabled, role, onValueChange);
                    $i$a$ClickableWithIndicationIfNeededToggleableKt$toggleable$3 = 0;
                    toggleableElement = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, $i$a$ClickableWithIndicationIfNeededToggleableKt$toggleable$3, (Function3)indication2, 1, $i$a$ClickableWithIndicationIfNeededToggleableKt$toggleable$3);
                }
            }
        }
        return $this$toggleable_u2dO2vRcR0.then(toggleableElement);
    }

    public static Modifier toggleable-O2vRcR0$default(Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource3, Indication indication4, boolean z5, Role role6, Function1 function17, int i8, Object object9) {
        int i2;
        int i;
        int obj11;
        int obj12;
        i2 = i8 & 8 != 0 ? obj11 : z5;
        i = i8 & 16 != 0 ? obj12 : role6;
        return ToggleableKt.toggleable-O2vRcR0(modifier, z2, mutableInteractionSource3, indication4, i2, i, function17);
    }

    public static final Modifier toggleable-XHw0xAI(Modifier $this$toggleable_u2dXHw0xAI, boolean value, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ToggleableKt.toggleable-XHw0xAI$$inlined.debugInspectorInfo.1(value, enabled, role, onValueChange);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ToggleableKt.toggleable.2 $i$f$debugInspectorInfo = new ToggleableKt.toggleable.2(value, enabled, role, onValueChange);
        return ComposedModifierKt.composed($this$toggleable_u2dXHw0xAI, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier toggleable-XHw0xAI$default(Modifier modifier, boolean z2, boolean z3, Role role4, Function1 function15, int i6, Object object7) {
        int obj2;
        int obj3;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 &= 4 != 0) {
            obj3 = 0;
        }
        return ToggleableKt.toggleable-XHw0xAI(modifier, z2, obj2, obj3, function15);
    }

    public static final Modifier triStateToggleable-O2vRcR0(Modifier $this$triStateToggleable_u2dO2vRcR0, ToggleableState state, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function0<Unit> onClick) {
        int indication2;
        Object obj2;
        int $i$a$ClickableWithIndicationIfNeededToggleableKt$triStateToggleable$3;
        boolean z2;
        Role role4;
        Function0 function02;
        Modifier triStateToggleableElement2;
        ToggleableState toggleableState;
        MutableInteractionSource mutableInteractionSource;
        Object obj;
        boolean z;
        Role role2;
        Function0 function0;
        int i;
        androidx.compose.foundation.selection.TriStateToggleableElement triStateToggleableElement;
        ToggleableState toggleableState2;
        MutableInteractionSource mutableInteractionSource2;
        int i3;
        boolean z3;
        Role role3;
        Function0 function03;
        int i2;
        obj2 = indication;
        final int i5 = 0;
        if (obj2 instanceof IndicationNodeFactory != null) {
            indication2 = 0;
            triStateToggleableElement2 = new TriStateToggleableElement(state, interactionSource, (IndicationNodeFactory)obj2, enabled, role, onClick, 0);
        } else {
            if (obj2 == null) {
                indication2 = 0;
                triStateToggleableElement = new TriStateToggleableElement(state, interactionSource, 0, enabled, role, onClick, 0);
                triStateToggleableElement2 = triStateToggleableElement;
            } else {
                if (interactionSource != null) {
                    int i4 = 0;
                    triStateToggleableElement = new TriStateToggleableElement(state, interactionSource, 0, enabled, role, onClick, 0);
                    triStateToggleableElement2 = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, obj2).then((Modifier)triStateToggleableElement);
                } else {
                    indication2 = new ToggleableKt.triStateToggleable-O2vRcR0$$inlined.clickableWithIndicationIfNeeded.1(obj2, state, enabled, role, onClick);
                    $i$a$ClickableWithIndicationIfNeededToggleableKt$triStateToggleable$3 = 0;
                    triStateToggleableElement2 = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, $i$a$ClickableWithIndicationIfNeededToggleableKt$triStateToggleable$3, (Function3)indication2, 1, $i$a$ClickableWithIndicationIfNeededToggleableKt$triStateToggleable$3);
                }
            }
        }
        return $this$triStateToggleable_u2dO2vRcR0.then(triStateToggleableElement2);
    }

    public static Modifier triStateToggleable-O2vRcR0$default(Modifier modifier, ToggleableState toggleableState2, MutableInteractionSource mutableInteractionSource3, Indication indication4, boolean z5, Role role6, Function0 function07, int i8, Object object9) {
        int i2;
        int i;
        int obj11;
        int obj12;
        i2 = i8 & 8 != 0 ? obj11 : z5;
        i = i8 & 16 != 0 ? obj12 : role6;
        return ToggleableKt.triStateToggleable-O2vRcR0(modifier, toggleableState2, mutableInteractionSource3, indication4, i2, i, function07);
    }

    public static final Modifier triStateToggleable-XHw0xAI(Modifier $this$triStateToggleable_u2dXHw0xAI, ToggleableState state, boolean enabled, Role role, Function0<Unit> onClick) {
        Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ToggleableKt.triStateToggleable-XHw0xAI$$inlined.debugInspectorInfo.1(state, enabled, role, onClick);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ToggleableKt.triStateToggleable.2 $i$f$debugInspectorInfo = new ToggleableKt.triStateToggleable.2(state, enabled, role, onClick);
        return ComposedModifierKt.composed($this$triStateToggleable_u2dXHw0xAI, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier triStateToggleable-XHw0xAI$default(Modifier modifier, ToggleableState toggleableState2, boolean z3, Role role4, Function0 function05, int i6, Object object7) {
        int obj2;
        int obj3;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 &= 4 != 0) {
            obj3 = 0;
        }
        return ToggleableKt.triStateToggleable-XHw0xAI(modifier, toggleableState2, obj2, obj3, function05);
    }
}
