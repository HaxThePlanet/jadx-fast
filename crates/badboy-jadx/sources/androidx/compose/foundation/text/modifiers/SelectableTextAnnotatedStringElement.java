package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B­\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0016\u0008\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0016\u0008\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001e\u0008\u0002\u0010\u0018\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010 \u001a\u00020\u0004HÂ\u0003J\u001f\u0010!\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nHÂ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u001bHÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u001dHÂ\u0003J\t\u0010$\u001a\u00020\u0006HÂ\u0003J\t\u0010%\u001a\u00020\u0008HÂ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nHÂ\u0003J\u0016\u0010'\u001a\u00020\u000eHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J\t\u0010*\u001a\u00020\u0010HÂ\u0003J\t\u0010+\u001a\u00020\u0012HÂ\u0003J\t\u0010,\u001a\u00020\u0012HÂ\u0003J\u0017\u0010-\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015HÂ\u0003JÁ\u0001\u0010.\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0016\u0008\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0016\u0008\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u00152\u001e\u0008\u0002\u0010\u0018\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J\u0008\u00101\u001a\u00020\u0002H\u0016J\u0013\u00102\u001a\u00020\u00102\u0008\u00103\u001a\u0004\u0018\u000104H\u0096\u0002J\u0008\u00105\u001a\u00020\u0012H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\u0010\u00108\u001a\u00020\u000c2\u0006\u00109\u001a\u00020\u0002H\u0016J\u000c\u0010:\u001a\u00020\u000c*\u00020;H\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006<", d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component5-gIe3tQ8", "()I", "component6", "component7", "component8", "component9", "copy", "copy-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "create", "equals", "other", "", "hashCode", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement<androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode> {

    public static final int $stable;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1<List<Rect>, Unit> onPlaceholderLayout;
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final androidx.compose.foundation.text.modifiers.SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;
    static {
    }

    private SelectableTextAnnotatedStringElement(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, ColorProducer color) {
        super();
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.onTextLayout = onTextLayout;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = placeholders;
        this.onPlaceholderLayout = onPlaceholderLayout;
        this.selectionController = selectionController;
        this.color = color;
    }

    public SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, int i13, DefaultConstructorMarker defaultConstructorMarker14) {
        int clip-gIe3tQ8;
        int i;
        int i14;
        int i3;
        int i6;
        int i12;
        int i11;
        int i2;
        int i10;
        int i4;
        int i9;
        int i15 = i13;
        final int i23 = 0;
        i14 = i15 & 8 != 0 ? i23 : function14;
        if (i15 & 16 != 0) {
            i3 = clip-gIe3tQ8;
        } else {
            i3 = i5;
        }
        int i24 = 1;
        i6 = i15 & 32 != 0 ? i24 : z6;
        i12 = i15 & 64 != 0 ? i : i7;
        i11 = i15 & 128 != 0 ? i24 : i8;
        i2 = i15 & 256 != 0 ? i23 : list9;
        i10 = i15 & 512 != 0 ? i23 : function110;
        i4 = i15 & 1024 != 0 ? i23 : selectionController11;
        i9 = i15 &= 2048 != 0 ? i23 : colorProducer12;
        super(annotatedString, textStyle2, resolver3, i14, i3, i6, i12, i11, i2, i10, i4, i9, 0);
    }

    public SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, DefaultConstructorMarker defaultConstructorMarker13) {
        super(annotatedString, textStyle2, resolver3, function14, i5, z6, i7, i8, list9, function110, selectionController11, colorProducer12);
    }

    private final AnnotatedString component1() {
        return this.text;
    }

    private final Function1<List<Rect>, Unit> component10() {
        return this.onPlaceholderLayout;
    }

    private final androidx.compose.foundation.text.modifiers.SelectionController component11() {
        return this.selectionController;
    }

    private final ColorProducer component12() {
        return this.color;
    }

    private final TextStyle component2() {
        return this.style;
    }

    private final FontFamily.Resolver component3() {
        return this.fontFamilyResolver;
    }

    private final Function1<TextLayoutResult, Unit> component4() {
        return this.onTextLayout;
    }

    private final int component5-gIe3tQ8() {
        return this.overflow;
    }

    private final boolean component6() {
        return this.softWrap;
    }

    private final int component7() {
        return this.maxLines;
    }

    private final int component8() {
        return this.minLines;
    }

    private final List<AnnotatedString.Range<Placeholder>> component9() {
        return this.placeholders;
    }

    public static androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement copy-VhcvRP8$default(androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement, AnnotatedString annotatedString2, TextStyle textStyle3, FontFamily.Resolver fontFamily$Resolver4, Function1 function15, int i6, boolean z7, int i8, int i9, List list10, Function1 function111, androidx.compose.foundation.text.modifiers.SelectionController selectionController12, ColorProducer colorProducer13, int i14, Object object15) {
        AnnotatedString obj1;
        TextStyle obj2;
        FontFamily.Resolver obj3;
        Function1 obj4;
        int obj5;
        boolean obj6;
        int obj7;
        int obj8;
        List obj9;
        Function1 obj10;
        androidx.compose.foundation.text.modifiers.SelectionController obj11;
        ColorProducer obj12;
        if (i14 & 1 != 0) {
            obj1 = selectableTextAnnotatedStringElement.text;
        }
        if (i14 & 2 != 0) {
            obj2 = selectableTextAnnotatedStringElement.style;
        }
        if (i14 & 4 != 0) {
            obj3 = selectableTextAnnotatedStringElement.fontFamilyResolver;
        }
        if (i14 & 8 != 0) {
            obj4 = selectableTextAnnotatedStringElement.onTextLayout;
        }
        if (i14 & 16 != 0) {
            obj5 = selectableTextAnnotatedStringElement.overflow;
        }
        if (i14 & 32 != 0) {
            obj6 = selectableTextAnnotatedStringElement.softWrap;
        }
        if (i14 & 64 != 0) {
            obj7 = selectableTextAnnotatedStringElement.maxLines;
        }
        if (i14 & 128 != 0) {
            obj8 = selectableTextAnnotatedStringElement.minLines;
        }
        if (i14 & 256 != 0) {
            obj9 = selectableTextAnnotatedStringElement.placeholders;
        }
        if (i14 & 512 != 0) {
            obj10 = selectableTextAnnotatedStringElement.onPlaceholderLayout;
        }
        if (i14 & 1024 != 0) {
            obj11 = selectableTextAnnotatedStringElement.selectionController;
        }
        if (i14 &= 2048 != 0) {
            obj12 = selectableTextAnnotatedStringElement.color;
        }
        return selectableTextAnnotatedStringElement.copy-VhcvRP8(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    public final androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement copy-VhcvRP8(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1<? super TextLayoutResult, Unit> function14, int i5, boolean z6, int i7, int i8, List<AnnotatedString.Range<Placeholder>> list9, Function1<? super List<Rect>, Unit> function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12) {
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = new SelectableTextAnnotatedStringElement(annotatedString, textStyle2, resolver3, function14, i5, z6, i7, i8, list9, function110, selectionController11, colorProducer12, 0);
        return selectableTextAnnotatedStringElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode create() {
        final Object obj = this;
        SelectableTextAnnotatedStringNode selectableTextAnnotatedStringNode = new SelectableTextAnnotatedStringNode(obj.text, obj.style, obj.fontFamilyResolver, obj.onTextLayout, obj.overflow, obj.softWrap, obj.maxLines, obj.minLines, obj.placeholders, obj.onPlaceholderLayout, obj.selectionController, obj.color, 0, 4096, 0);
        return selectableTextAnnotatedStringNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SelectableTextAnnotatedStringElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.color, obj.color)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.text, obj2.text)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.style, obj3.style)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.placeholders, obj4.placeholders)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, obj5.fontFamilyResolver)) {
            return i2;
        }
        if (this.onTextLayout != obj6.onTextLayout) {
            return i2;
        }
        if (!TextOverflow.equals-impl0(this.overflow, obj7.overflow)) {
            return i2;
        }
        if (this.softWrap != obj8.softWrap) {
            return i2;
        }
        if (this.maxLines != obj9.maxLines) {
            return i2;
        }
        if (this.minLines != obj10.minLines) {
            return i2;
        }
        if (this.onPlaceholderLayout != obj11.onPlaceholderLayout) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.selectionController, obj12.selectionController)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i4;
        int i2;
        int i;
        int i3;
        int i5;
        Function1 onTextLayout = this.onTextLayout;
        i5 = 0;
        if (onTextLayout != null) {
            i4 = onTextLayout.hashCode();
        } else {
            i4 = i5;
        }
        List placeholders = this.placeholders;
        if (placeholders != null) {
            i2 = placeholders.hashCode();
        } else {
            i2 = i5;
        }
        Function1 onPlaceholderLayout = this.onPlaceholderLayout;
        if (onPlaceholderLayout != null) {
            i = onPlaceholderLayout.hashCode();
        } else {
            i = i5;
        }
        androidx.compose.foundation.text.modifiers.SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            i3 = selectionController.hashCode();
        } else {
            i3 = i5;
        }
        ColorProducer color = this.color;
        if (color != null) {
            i5 = color.hashCode();
        }
        return result10 += i5;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SelectableTextAnnotatedStringElement(text=").append(this.text).append(", style=").append(this.style).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", onTextLayout=").append(this.onTextLayout).append(", overflow=").append(TextOverflow.toString-impl(this.overflow)).append(", softWrap=").append(this.softWrap).append(", maxLines=").append(this.maxLines).append(", minLines=").append(this.minLines).append(", placeholders=").append(this.placeholders).append(", onPlaceholderLayout=").append(this.onPlaceholderLayout).append(", selectionController=").append(this.selectionController).append(", color=");
        stringBuilder.append(this.color).append(')');
        return stringBuilder.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringNode node) {
        node.update-L09Iy8E(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SelectableTextAnnotatedStringNode)node);
    }
}
