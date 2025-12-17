package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u00126\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000c¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0008HÂ\u0003J\t\u0010\u0019\u001a\u00020\nHÂ\u0003J9\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000c¢\u0006\u0002\u0008\u0014HÂ\u0003Jk\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n28\u0008\u0002\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000c¢\u0006\u0002\u0008\u0014HÆ\u0001J\u0008\u0010\u001c\u001a\u00020\u0002H\u0016J\u0013\u0010\u001d\u001a\u00020\n2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0002H\u0016J\u000c\u0010&\u001a\u00020\u0013*\u00020'H\u0016R>\u0010\u000b\u001a2\u0012\u0004\u0012\u00020\r\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000c¢\u0006\u0002\u0008\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldTextLayoutModifier extends ModifierNodeElement<androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifierNode> {

    public static final int $stable;
    private final Function2<Density, Function0<TextLayoutResult>, Unit> onTextLayout;
    private final boolean singleLine;
    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private final androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    private final TextStyle textStyle;
    static {
    }

    public TextFieldTextLayoutModifier(androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout) {
        super();
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textStyle = textStyle;
        this.singleLine = singleLine;
        this.onTextLayout = onTextLayout;
    }

    private final androidx.compose.foundation.text.input.internal.TextLayoutState component1() {
        return this.textLayoutState;
    }

    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState component2() {
        return this.textFieldState;
    }

    private final TextStyle component3() {
        return this.textStyle;
    }

    private final boolean component4() {
        return this.singleLine;
    }

    private final Function2<Density, Function0<TextLayoutResult>, Unit> component5() {
        return this.onTextLayout;
    }

    public static androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier copy$default(androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier textFieldTextLayoutModifier, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState2, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState3, TextStyle textStyle4, boolean z5, Function2 function26, int i7, Object object8) {
        androidx.compose.foundation.text.input.internal.TextLayoutState obj1;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState obj2;
        TextStyle obj3;
        boolean obj4;
        Function2 obj5;
        if (i7 & 1 != 0) {
            obj1 = textFieldTextLayoutModifier.textLayoutState;
        }
        if (i7 & 2 != 0) {
            obj2 = textFieldTextLayoutModifier.textFieldState;
        }
        if (i7 & 4 != 0) {
            obj3 = textFieldTextLayoutModifier.textStyle;
        }
        if (i7 & 8 != 0) {
            obj4 = textFieldTextLayoutModifier.singleLine;
        }
        if (i7 &= 16 != 0) {
            obj5 = textFieldTextLayoutModifier.onTextLayout;
        }
        return textFieldTextLayoutModifier.copy(obj1, obj2, obj3, obj4, obj5);
    }

    public final androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier copy(androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState2, TextStyle textStyle3, boolean z4, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25) {
        TextFieldTextLayoutModifier textFieldTextLayoutModifier = new TextFieldTextLayoutModifier(textLayoutState, transformedTextFieldState2, textStyle3, z4, function25);
        return textFieldTextLayoutModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifierNode create() {
        TextFieldTextLayoutModifierNode textFieldTextLayoutModifierNode = new TextFieldTextLayoutModifierNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
        return textFieldTextLayoutModifierNode;
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
        if (!object instanceof TextFieldTextLayoutModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.textLayoutState, obj.textLayoutState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldState, obj.textFieldState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textStyle, obj.textStyle)) {
            return i2;
        }
        if (this.singleLine != obj.singleLine) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onTextLayout, obj.onTextLayout)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.onTextLayout == null) {
            i = 0;
        } else {
            i = this.onTextLayout.hashCode();
        }
        return i5 += i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextFieldTextLayoutModifier(textLayoutState=").append(this.textLayoutState).append(", textFieldState=").append(this.textFieldState).append(", textStyle=").append(this.textStyle).append(", singleLine=").append(this.singleLine).append(", onTextLayout=").append(this.onTextLayout).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifierNode node) {
        node.updateNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TextFieldTextLayoutModifierNode)node);
    }
}
