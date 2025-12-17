package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BÅ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0008\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\u0008\u0002\u0010\u001a\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0016\u0008\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c¢\u0006\u0002\u0010\"J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J¦\u0001\u0010(\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c2\u001c\u0010\u001a\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010)\u001a\u0004\u0018\u00010\u001fø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\u000c\u0010,\u001a\u00020\u000e*\u00020-H\u0016J\u001c\u0010.\u001a\u00020\u0014*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0016J\u001c\u00103\u001a\u00020\u0014*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0014H\u0016J&\u00105\u001a\u000206*\u0002072\u0006\u00100\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u001c\u0010=\u001a\u00020\u0014*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0014H\u0016J\u001c\u0010>\u001a\u00020\u0014*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0014H\u0016R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006?", d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "delegate", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "update", "color", "update-L09Iy8E", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {

    public static final int $stable = 8;
    private final androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode delegate;
    private Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation;
    private androidx.compose.foundation.text.modifiers.SelectionController selectionController;
    static {
        final int i = 8;
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, ColorProducer overrideColor, Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation) {
        final Object obj = this;
        super();
        obj.selectionController = selectionController;
        obj.onShowTranslation = onShowTranslation;
        TextAnnotatedStringNode textAnnotatedStringNode = new TextAnnotatedStringNode(text, style, fontFamilyResolver, onTextLayout, overflow, softWrap, maxLines, minLines, placeholders, onPlaceholderLayout, obj.selectionController, overrideColor, obj.onShowTranslation, 0);
        obj.delegate = (TextAnnotatedStringNode)obj.delegate((DelegatableNode)textAnnotatedStringNode);
        if (obj.selectionController == null) {
        } else {
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullSelectableTextAnnotatedStringNode$1 = new IllegalArgumentException("Do not use SelectionCapableStaticTextModifier unless selectionController != null".toString());
        throw $i$a$RequireNotNullSelectableTextAnnotatedStringNode$1;
    }

    public SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, int i14, DefaultConstructorMarker defaultConstructorMarker15) {
        int clip-gIe3tQ8;
        int i13;
        int i6;
        int i4;
        int i3;
        int i12;
        int i11;
        int i9;
        int i10;
        int i2;
        int i15;
        int i;
        int i16 = i14;
        final int i25 = 0;
        i6 = i16 & 8 != 0 ? i25 : function14;
        if (i16 & 16 != 0) {
            i4 = clip-gIe3tQ8;
        } else {
            i4 = i5;
        }
        int i26 = 1;
        i3 = i16 & 32 != 0 ? i26 : z6;
        i12 = i16 & 64 != 0 ? i13 : i7;
        i11 = i16 & 128 != 0 ? i26 : i8;
        i9 = i16 & 256 != 0 ? i25 : list9;
        i10 = i16 & 512 != 0 ? i25 : function110;
        i2 = i16 & 1024 != 0 ? i25 : selectionController11;
        i15 = i16 & 2048 != 0 ? i25 : colorProducer12;
        i = i16 &= 4096 != 0 ? i25 : function113;
        super(annotatedString, textStyle2, resolver3, i6, i4, i3, i12, i11, i9, i10, i2, i15, i, 0);
    }

    public SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, DefaultConstructorMarker defaultConstructorMarker14) {
        super(annotatedString, textStyle2, resolver3, function14, i5, z6, i7, i8, list9, function110, selectionController11, colorProducer12, function113);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void draw(ContentDrawScope $this$draw) {
        this.delegate.drawNonExtension($this$draw);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return this.delegate.maxIntrinsicHeightNonExtension($this$maxIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return this.delegate.maxIntrinsicWidthNonExtension($this$maxIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        return this.delegate.measureNonExtension-3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return this.delegate.minIntrinsicHeightNonExtension($this$minIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return this.delegate.minIntrinsicWidthNonExtension($this$minIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        final androidx.compose.foundation.text.modifiers.SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.updateGlobalPosition(coordinates);
        }
    }

    public final void update-L09Iy8E(AnnotatedString text, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow, Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, ColorProducer color) {
        final androidx.compose.foundation.text.modifiers.SelectionController selectionController2 = selectionController;
        this.delegate.doInvalidations(this.delegate.updateDraw(color, style), this.delegate.updateText$foundation_release(text), this.delegate.updateLayoutRelatedArgs-MPT68mk(style, placeholders, minLines, maxLines, softWrap, fontFamilyResolver, overflow), this.delegate.updateCallbacks(onTextLayout, onPlaceholderLayout, selectionController2, this.onShowTranslation));
        this.selectionController = selectionController2;
        LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)this);
    }
}
