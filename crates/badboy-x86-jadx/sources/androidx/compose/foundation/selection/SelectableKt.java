package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0002\u0008\u000e\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0002\u0008\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0010", d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-O2vRcR0", "selectable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectableKt {
    public static final Modifier selectable-O2vRcR0(Modifier $this$selectable_u2dO2vRcR0, boolean selected, MutableInteractionSource interactionSource, Indication indication, boolean enabled, Role role, Function0<Unit> onClick) {
        int indication2;
        Object obj2;
        int $i$a$ClickableWithIndicationIfNeededSelectableKt$selectable$3;
        boolean z2;
        Role role2;
        Function0 function0;
        Modifier selectableElement;
        boolean z;
        MutableInteractionSource mutableInteractionSource2;
        Object obj;
        boolean z5;
        Role role4;
        Function0 function02;
        int i;
        androidx.compose.foundation.selection.SelectableElement selectableElement2;
        boolean z3;
        MutableInteractionSource mutableInteractionSource;
        int i3;
        boolean z4;
        Role role3;
        Function0 function03;
        int i2;
        obj2 = indication;
        final int i5 = 0;
        if (obj2 instanceof IndicationNodeFactory != null) {
            indication2 = 0;
            selectableElement = new SelectableElement(selected, interactionSource, (IndicationNodeFactory)obj2, enabled, role, onClick, 0);
        } else {
            if (obj2 == null) {
                indication2 = 0;
                selectableElement2 = new SelectableElement(selected, interactionSource, 0, enabled, role, onClick, 0);
                selectableElement = selectableElement2;
            } else {
                if (interactionSource != null) {
                    int i4 = 0;
                    selectableElement2 = new SelectableElement(selected, interactionSource, 0, enabled, role, onClick, 0);
                    selectableElement = IndicationKt.indication((Modifier)Modifier.Companion, (InteractionSource)interactionSource, obj2).then((Modifier)selectableElement2);
                } else {
                    indication2 = new SelectableKt.selectable-O2vRcR0$$inlined.clickableWithIndicationIfNeeded.1(obj2, selected, enabled, role, onClick);
                    $i$a$ClickableWithIndicationIfNeededSelectableKt$selectable$3 = 0;
                    selectableElement = ComposedModifierKt.composed$default((Modifier)Modifier.Companion, $i$a$ClickableWithIndicationIfNeededSelectableKt$selectable$3, (Function3)indication2, 1, $i$a$ClickableWithIndicationIfNeededSelectableKt$selectable$3);
                }
            }
        }
        return $this$selectable_u2dO2vRcR0.then(selectableElement);
    }

    public static Modifier selectable-O2vRcR0$default(Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource3, Indication indication4, boolean z5, Role role6, Function0 function07, int i8, Object object9) {
        int i;
        int i2;
        int obj11;
        int obj12;
        i = i8 & 8 != 0 ? obj11 : z5;
        i2 = i8 & 16 != 0 ? obj12 : role6;
        return SelectableKt.selectable-O2vRcR0(modifier, z2, mutableInteractionSource3, indication4, i, i2, function07);
    }

    public static final Modifier selectable-XHw0xAI(Modifier $this$selectable_u2dXHw0xAI, boolean selected, boolean enabled, Role role, Function0<Unit> onClick) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SelectableKt.selectable-XHw0xAI$$inlined.debugInspectorInfo.1(selected, enabled, role, onClick);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SelectableKt.selectable.2 $i$f$debugInspectorInfo = new SelectableKt.selectable.2(selected, enabled, role, onClick);
        return ComposedModifierKt.composed($this$selectable_u2dXHw0xAI, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static Modifier selectable-XHw0xAI$default(Modifier modifier, boolean z2, boolean z3, Role role4, Function0 function05, int i6, Object object7) {
        int obj2;
        int obj3;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 &= 4 != 0) {
            obj3 = 0;
        }
        return SelectableKt.selectable-XHw0xAI(modifier, z2, obj2, obj3, function05);
    }
}
