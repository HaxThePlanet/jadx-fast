package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000c\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0014HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0019\u001a\u00020\u0008HÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÂ\u0003J\t\u0010\u001b\u001a\u00020\u000cHÂ\u0003J\t\u0010\u001c\u001a\u00020\u000cHÂ\u0003J\t\u0010\u001d\u001a\u00020\u000fHÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0011HÂ\u0003J\t\u0010\u001f\u001a\u00020\u000cHÂ\u0003Jq\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0008\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\u000c2\u0008\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u000c\u0010,\u001a\u00020**\u00020-H\u0016R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDecoratorModifier extends ModifierNodeElement<androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode> {

    public static final int $stable;
    private final boolean enabled;
    private final InputTransformation filter;
    private final MutableInteractionSource interactionSource;
    private final KeyboardActionHandler keyboardActionHandler;
    private final KeyboardOptions keyboardOptions;
    private final boolean readOnly;
    private final boolean singleLine;
    private final TextFieldSelectionState textFieldSelectionState;
    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private final androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    static {
    }

    public TextFieldDecoratorModifier(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource) {
        super();
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = singleLine;
        this.interactionSource = interactionSource;
    }

    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState component1() {
        return this.textFieldState;
    }

    private final MutableInteractionSource component10() {
        return this.interactionSource;
    }

    private final androidx.compose.foundation.text.input.internal.TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TextFieldSelectionState component3() {
        return this.textFieldSelectionState;
    }

    private final InputTransformation component4() {
        return this.filter;
    }

    private final boolean component5() {
        return this.enabled;
    }

    private final boolean component6() {
        return this.readOnly;
    }

    private final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    private final KeyboardActionHandler component8() {
        return this.keyboardActionHandler;
    }

    private final boolean component9() {
        return this.singleLine;
    }

    public static androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier copy$default(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier textFieldDecoratorModifier, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState2, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState3, TextFieldSelectionState textFieldSelectionState4, InputTransformation inputTransformation5, boolean z6, boolean z7, KeyboardOptions keyboardOptions8, KeyboardActionHandler keyboardActionHandler9, boolean z10, MutableInteractionSource mutableInteractionSource11, int i12, Object object13) {
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState obj1;
        androidx.compose.foundation.text.input.internal.TextLayoutState obj2;
        TextFieldSelectionState obj3;
        InputTransformation obj4;
        boolean obj5;
        boolean obj6;
        KeyboardOptions obj7;
        KeyboardActionHandler obj8;
        boolean obj9;
        MutableInteractionSource obj10;
        if (i12 & 1 != 0) {
            obj1 = textFieldDecoratorModifier.textFieldState;
        }
        if (i12 & 2 != 0) {
            obj2 = textFieldDecoratorModifier.textLayoutState;
        }
        if (i12 & 4 != 0) {
            obj3 = textFieldDecoratorModifier.textFieldSelectionState;
        }
        if (i12 & 8 != 0) {
            obj4 = textFieldDecoratorModifier.filter;
        }
        if (i12 & 16 != 0) {
            obj5 = textFieldDecoratorModifier.enabled;
        }
        if (i12 & 32 != 0) {
            obj6 = textFieldDecoratorModifier.readOnly;
        }
        if (i12 & 64 != 0) {
            obj7 = textFieldDecoratorModifier.keyboardOptions;
        }
        if (i12 & 128 != 0) {
            obj8 = textFieldDecoratorModifier.keyboardActionHandler;
        }
        if (i12 & 256 != 0) {
            obj9 = textFieldDecoratorModifier.singleLine;
        }
        if (i12 &= 512 != 0) {
            obj10 = textFieldDecoratorModifier.interactionSource;
        }
        return textFieldDecoratorModifier.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier copy(androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState3, InputTransformation inputTransformation4, boolean z5, boolean z6, KeyboardOptions keyboardOptions7, KeyboardActionHandler keyboardActionHandler8, boolean z9, MutableInteractionSource mutableInteractionSource10) {
        TextFieldDecoratorModifier textFieldDecoratorModifier = new TextFieldDecoratorModifier(transformedTextFieldState, textLayoutState2, textFieldSelectionState3, inputTransformation4, z5, z6, keyboardOptions7, keyboardActionHandler8, z9, mutableInteractionSource10);
        return textFieldDecoratorModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode create() {
        TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = new TextFieldDecoratorModifierNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource);
        return textFieldDecoratorModifierNode;
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
        if (!object instanceof TextFieldDecoratorModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.textFieldState, obj.textFieldState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textLayoutState, obj.textLayoutState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldSelectionState, obj.textFieldSelectionState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.filter, obj.filter)) {
            return i2;
        }
        if (this.enabled != obj.enabled) {
            return i2;
        }
        if (this.readOnly != obj.readOnly) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.keyboardOptions, obj.keyboardOptions)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.keyboardActionHandler, obj.keyboardActionHandler)) {
            return i2;
        }
        if (this.singleLine != obj.singleLine) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.interactionSource, obj.interactionSource)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        KeyboardActionHandler keyboardActionHandler;
        int i2;
        if (this.filter == null) {
            i = i2;
        } else {
            i = this.filter.hashCode();
        }
        if (this.keyboardActionHandler == null) {
        } else {
            i2 = this.keyboardActionHandler.hashCode();
        }
        return i20 += i28;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextFieldDecoratorModifier(textFieldState=").append(this.textFieldState).append(", textLayoutState=").append(this.textLayoutState).append(", textFieldSelectionState=").append(this.textFieldSelectionState).append(", filter=").append(this.filter).append(", enabled=").append(this.enabled).append(", readOnly=").append(this.readOnly).append(", keyboardOptions=").append(this.keyboardOptions).append(", keyboardActionHandler=").append(this.keyboardActionHandler).append(", singleLine=").append(this.singleLine).append(", interactionSource=").append(this.interactionSource).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode node) {
        node.updateNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TextFieldDecoratorModifierNode)node);
    }
}
