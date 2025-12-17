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
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0016\u0008\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0016\u0008\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001e\u0008\u0002\u0010\u0018\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0016\u0008\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000c\u0018\u00010\n¢\u0006\u0002\u0010 J\u0008\u0010\"\u001a\u00020\u0002H\u0016J\u0013\u0010#\u001a\u00020\u00102\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0008\u0010&\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020\u000c2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u000c\u0010)\u001a\u00020\u000c*\u00020*H\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010!R\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "equals", "other", "", "hashCode", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextAnnotatedStringElement extends ModifierNodeElement<androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode> {

    public static final int $stable;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1<List<Rect>, Unit> onPlaceholderLayout;
    private final Function1<androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation;
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final androidx.compose.foundation.text.modifiers.SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;
    static {
    }

    private TextAnnotatedStringElement(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, ColorProducer color, Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation) {
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
        this.onShowTranslation = onShowTranslation;
    }

    public TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, int i14, DefaultConstructorMarker defaultConstructorMarker15) {
        int clip-gIe3tQ8;
        int i12;
        int i3;
        int i10;
        int i2;
        int i15;
        int i4;
        int i13;
        int i;
        int i9;
        int i6;
        int i11;
        int i16 = i14;
        final int i25 = 0;
        i3 = i16 & 8 != 0 ? i25 : function14;
        if (i16 & 16 != 0) {
            i10 = clip-gIe3tQ8;
        } else {
            i10 = i5;
        }
        int i26 = 1;
        i2 = i16 & 32 != 0 ? i26 : z6;
        i15 = i16 & 64 != 0 ? i12 : i7;
        i4 = i16 & 128 != 0 ? i26 : i8;
        i13 = i16 & 256 != 0 ? i25 : list9;
        i = i16 & 512 != 0 ? i25 : function110;
        i9 = i16 & 1024 != 0 ? i25 : selectionController11;
        i6 = i16 & 2048 != 0 ? i25 : colorProducer12;
        i11 = i16 &= 4096 != 0 ? i25 : function113;
        super(annotatedString, textStyle2, resolver3, i3, i10, i2, i15, i4, i13, i, i9, i6, i11, 0);
    }

    public TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, DefaultConstructorMarker defaultConstructorMarker14) {
        super(annotatedString, textStyle2, resolver3, function14, i5, z6, i7, i8, list9, function110, selectionController11, colorProducer12, function113);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode create() {
        TextAnnotatedStringNode textAnnotatedStringNode = new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, this.onShowTranslation, 0);
        return textAnnotatedStringNode;
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
        if (!other instanceof TextAnnotatedStringElement) {
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
        if (this.onShowTranslation != obj7.onShowTranslation) {
            return i2;
        }
        if (!TextOverflow.equals-impl0(this.overflow, obj8.overflow)) {
            return i2;
        }
        if (this.softWrap != obj9.softWrap) {
            return i2;
        }
        if (this.maxLines != obj10.maxLines) {
            return i2;
        }
        if (this.minLines != obj11.minLines) {
            return i2;
        }
        if (this.onPlaceholderLayout != obj12.onPlaceholderLayout) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.selectionController, obj13.selectionController)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i3;
        int i5;
        int i;
        int i6;
        int i2;
        int i4;
        Function1 onTextLayout = this.onTextLayout;
        i4 = 0;
        if (onTextLayout != null) {
            i3 = onTextLayout.hashCode();
        } else {
            i3 = i4;
        }
        List placeholders = this.placeholders;
        if (placeholders != null) {
            i5 = placeholders.hashCode();
        } else {
            i5 = i4;
        }
        Function1 onPlaceholderLayout = this.onPlaceholderLayout;
        if (onPlaceholderLayout != null) {
            i = onPlaceholderLayout.hashCode();
        } else {
            i = i4;
        }
        androidx.compose.foundation.text.modifiers.SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            i6 = selectionController.hashCode();
        } else {
            i6 = i4;
        }
        ColorProducer color = this.color;
        if (color != null) {
            i2 = color.hashCode();
        } else {
            i2 = i4;
        }
        Function1 onShowTranslation = this.onShowTranslation;
        if (onShowTranslation != null) {
            i4 = onShowTranslation.hashCode();
        }
        return result6 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode node) {
        final Object obj = node;
        obj.doInvalidations(node.updateDraw(this.color, this.style), node.updateText$foundation_release(this.text), obj.updateLayoutRelatedArgs-MPT68mk(this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), obj.updateCallbacks(this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.onShowTranslation));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TextAnnotatedStringNode)node);
    }
}
