package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0017\u001a\u00020\tHÂ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÂ\u0003J\t\u0010\u0019\u001a\u00020\rHÂ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001b\u001a\u00020\u0010HÂ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÂ\u0003Jc\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0008\u0010\u001e\u001a\u00020\u0002H\u0016J\u0013\u0010\u001f\u001a\u00020\u00042\u0008\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u000c\u0010)\u001a\u00020'*\u00020*H\u0016R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCoreModifier extends ModifierNodeElement<androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode> {

    public static final int $stable;
    private final Brush cursorBrush;
    private final boolean isDragHovered;
    private final boolean isFocused;
    private final Orientation orientation;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private final androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    private final boolean writeable;
    static {
    }

    public TextFieldCoreModifier(boolean isFocused, boolean isDragHovered, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        super();
        this.isFocused = isFocused;
        this.isDragHovered = isDragHovered;
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = cursorBrush;
        this.writeable = writeable;
        this.scrollState = scrollState;
        this.orientation = orientation;
    }

    private final boolean component1() {
        return this.isFocused;
    }

    private final boolean component2() {
        return this.isDragHovered;
    }

    private final androidx.compose.foundation.text.input.internal.TextLayoutState component3() {
        return this.textLayoutState;
    }

    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState component4() {
        return this.textFieldState;
    }

    private final TextFieldSelectionState component5() {
        return this.textFieldSelectionState;
    }

    private final Brush component6() {
        return this.cursorBrush;
    }

    private final boolean component7() {
        return this.writeable;
    }

    private final ScrollState component8() {
        return this.scrollState;
    }

    private final Orientation component9() {
        return this.orientation;
    }

    public static androidx.compose.foundation.text.input.internal.TextFieldCoreModifier copy$default(androidx.compose.foundation.text.input.internal.TextFieldCoreModifier textFieldCoreModifier, boolean z2, boolean z3, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState4, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState5, TextFieldSelectionState textFieldSelectionState6, Brush brush7, boolean z8, ScrollState scrollState9, Orientation orientation10, int i11, Object object12) {
        boolean obj1;
        boolean obj2;
        androidx.compose.foundation.text.input.internal.TextLayoutState obj3;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState obj4;
        TextFieldSelectionState obj5;
        Brush obj6;
        boolean obj7;
        ScrollState obj8;
        Orientation obj9;
        if (i11 & 1 != 0) {
            obj1 = textFieldCoreModifier.isFocused;
        }
        if (i11 & 2 != 0) {
            obj2 = textFieldCoreModifier.isDragHovered;
        }
        if (i11 & 4 != 0) {
            obj3 = textFieldCoreModifier.textLayoutState;
        }
        if (i11 & 8 != 0) {
            obj4 = textFieldCoreModifier.textFieldState;
        }
        if (i11 & 16 != 0) {
            obj5 = textFieldCoreModifier.textFieldSelectionState;
        }
        if (i11 & 32 != 0) {
            obj6 = textFieldCoreModifier.cursorBrush;
        }
        if (i11 & 64 != 0) {
            obj7 = textFieldCoreModifier.writeable;
        }
        if (i11 & 128 != 0) {
            obj8 = textFieldCoreModifier.scrollState;
        }
        if (i11 &= 256 != 0) {
            obj9 = textFieldCoreModifier.orientation;
        }
        return textFieldCoreModifier.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.text.input.internal.TextFieldCoreModifier copy(boolean z, boolean z2, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState3, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState4, TextFieldSelectionState textFieldSelectionState5, Brush brush6, boolean z7, ScrollState scrollState8, Orientation orientation9) {
        TextFieldCoreModifier textFieldCoreModifier = new TextFieldCoreModifier(z, z2, textLayoutState3, transformedTextFieldState4, textFieldSelectionState5, brush6, z7, scrollState8, orientation9);
        return textFieldCoreModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode create() {
        TextFieldCoreModifierNode textFieldCoreModifierNode = new TextFieldCoreModifierNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
        return textFieldCoreModifierNode;
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
        if (!object instanceof TextFieldCoreModifier) {
            return i2;
        }
        Object obj = object;
        if (this.isFocused != obj.isFocused) {
            return i2;
        }
        if (this.isDragHovered != obj.isDragHovered) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textLayoutState, obj.textLayoutState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldState, obj.textFieldState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldSelectionState, obj.textFieldSelectionState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.cursorBrush, obj.cursorBrush)) {
            return i2;
        }
        if (this.writeable != obj.writeable) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.scrollState, obj.scrollState)) {
            return i2;
        }
        if (this.orientation != obj.orientation) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i8 += i25;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextFieldCoreModifier(isFocused=").append(this.isFocused).append(", isDragHovered=").append(this.isDragHovered).append(", textLayoutState=").append(this.textLayoutState).append(", textFieldState=").append(this.textFieldState).append(", textFieldSelectionState=").append(this.textFieldSelectionState).append(", cursorBrush=").append(this.cursorBrush).append(", writeable=").append(this.writeable).append(", scrollState=").append(this.scrollState).append(", orientation=").append(this.orientation).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode node) {
        node.updateNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TextFieldCoreModifierNode)node);
    }
}
