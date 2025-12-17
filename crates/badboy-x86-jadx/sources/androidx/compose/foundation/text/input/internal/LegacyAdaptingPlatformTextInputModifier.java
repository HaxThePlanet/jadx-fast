package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0008HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0008\u0010\u0014\u001a\u00020\u0002H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u000c\u0010 \u001a\u00020\u001e*\u00020!H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\"", d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "serviceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getServiceAdapter", "()Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "component1", "component2", "component3", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LegacyAdaptingPlatformTextInputModifier extends ModifierNodeElement<androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode> {

    private final LegacyTextFieldState legacyTextFieldState;
    private final androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter serviceAdapter;
    private final TextFieldSelectionManager textFieldSelectionManager;
    public LegacyAdaptingPlatformTextInputModifier(androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter serviceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        super();
        this.serviceAdapter = serviceAdapter;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
    }

    public static androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifier copy$default(androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier, androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2, LegacyTextFieldState legacyTextFieldState3, TextFieldSelectionManager textFieldSelectionManager4, int i5, Object object6) {
        androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter obj1;
        LegacyTextFieldState obj2;
        TextFieldSelectionManager obj3;
        if (i5 & 1 != 0) {
            obj1 = legacyAdaptingPlatformTextInputModifier.serviceAdapter;
        }
        if (i5 & 2 != 0) {
            obj2 = legacyAdaptingPlatformTextInputModifier.legacyTextFieldState;
        }
        if (i5 &= 4 != 0) {
            obj3 = legacyAdaptingPlatformTextInputModifier.textFieldSelectionManager;
        }
        return legacyAdaptingPlatformTextInputModifier.copy(obj1, obj2, obj3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter component1() {
        return this.serviceAdapter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final LegacyTextFieldState component2() {
        return this.legacyTextFieldState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final TextFieldSelectionManager component3() {
        return this.textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifier copy(androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState2, TextFieldSelectionManager textFieldSelectionManager3) {
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = new LegacyAdaptingPlatformTextInputModifier(legacyPlatformTextInputServiceAdapter, legacyTextFieldState2, textFieldSelectionManager3);
        return legacyAdaptingPlatformTextInputModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode create() {
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = new LegacyAdaptingPlatformTextInputModifierNode(this.serviceAdapter, this.legacyTextFieldState, this.textFieldSelectionManager);
        return legacyAdaptingPlatformTextInputModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LegacyAdaptingPlatformTextInputModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.serviceAdapter, obj.serviceAdapter)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.legacyTextFieldState, obj.legacyTextFieldState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldSelectionManager, obj.textFieldSelectionManager)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter getServiceAdapter() {
        return this.serviceAdapter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LegacyAdaptingPlatformTextInputModifier(serviceAdapter=").append(this.serviceAdapter).append(", legacyTextFieldState=").append(this.legacyTextFieldState).append(", textFieldSelectionManager=").append(this.textFieldSelectionManager).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode node) {
        node.setServiceAdapter(this.serviceAdapter);
        node.setLegacyTextFieldState(this.legacyTextFieldState);
        node.setTextFieldSelectionManager(this.textFieldSelectionManager);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LegacyAdaptingPlatformTextInputModifierNode)node);
    }
}
