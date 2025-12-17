package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010!\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kBÅ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0008\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\u0008\u0002\u0010\u001a\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0016\u0008\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c¢\u0006\u0002\u0010\"J\r\u00108\u001a\u00020\u000eH\u0000¢\u0006\u0002\u00089J&\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0012J\u000e\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020AJ\u0010\u0010+\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0002J\u0008\u0010D\u001a\u00020\u000eH\u0002J\u001e\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0014J\u001e\u0010K\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020\u0014J(\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010H\u001a\u00020Q2\u0006\u0010R\u001a\u00020Sø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJ\u001e\u0010V\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0014J\u001e\u0010W\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020\u0014J\u0010\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u0006H\u0002JZ\u0010Z\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c2\u001c\u0010\u001a\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000c2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000cJ\u0018\u0010[\u001a\u00020\u00122\u0008\u0010\\\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\u0008JV\u0010]\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00082\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008^\u0010_J\u0015\u0010`\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008aJ\u000c\u0010b\u001a\u00020\u000e*\u00020cH\u0016J\u000c\u0010d\u001a\u00020\u000e*\u00020AH\u0016J\u001c\u0010e\u001a\u00020\u0014*\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0014H\u0016J\u001c\u0010f\u001a\u00020\u0014*\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020\u0014H\u0016J&\u0010g\u001a\u00020N*\u00020P2\u0006\u0010H\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016ø\u0001\u0000¢\u0006\u0004\u0008h\u0010UJ\u001c\u0010i\u001a\u00020\u0014*\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0014H\u0016J\u001c\u0010j\u001a\u00020\u0014*\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020\u0014H\u0016R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0014\u0018\u00010&X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008(\u0010)R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010.\u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0/\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00081\u00102R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006l", d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "", "shouldClearDescendantSemantics", "getShouldClearDescendantSemantics", "()Z", "textSubstitution", "getTextSubstitution$foundation_release", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation_release", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "clearSubstitution", "clearSubstitution$foundation_release", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "invalidateForTranslate", "maxIntrinsicHeightNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidthNonExtension", "height", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeightNonExtension", "minIntrinsicWidthNonExtension", "setSubstitution", "updatedText", "updateCallbacks", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "updateText$foundation_release", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "measure-3p2s80s", "minIntrinsicHeight", "minIntrinsicWidth", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {

    public static final int $stable = 8;
    private androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private androidx.compose.foundation.text.modifiers.SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    private androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue textSubstitution;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0008HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012\"\u0004\u0008\u0014\u0010\u0015¨\u0006!", d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "", "original", "Landroidx/compose/ui/text/AnnotatedString;", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TextSubstitutionValue {

        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;
        static {
            final int i = 8;
        }

        public TextSubstitutionValue(AnnotatedString original, AnnotatedString substitution, boolean isShowingSubstitution, androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache) {
            super();
            this.original = original;
            this.substitution = substitution;
            this.isShowingSubstitution = isShowingSubstitution;
            this.layoutCache = layoutCache;
        }

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z3, androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache multiParagraphLayoutCache4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            int obj3;
            int obj4;
            obj3 = i5 & 4 != 0 ? 0 : obj3;
            obj4 = i5 &= 8 != 0 ? 0 : obj4;
            super(annotatedString, annotatedString2, obj3, obj4);
        }

        public static androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue copy$default(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue textAnnotatedStringNode$TextSubstitutionValue, AnnotatedString annotatedString2, AnnotatedString annotatedString3, boolean z4, androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache multiParagraphLayoutCache5, int i6, Object object7) {
            AnnotatedString obj1;
            AnnotatedString obj2;
            boolean obj3;
            androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache obj4;
            if (i6 & 1 != 0) {
                obj1 = textSubstitutionValue.original;
            }
            if (i6 & 2 != 0) {
                obj2 = textSubstitutionValue.substitution;
            }
            if (i6 & 4 != 0) {
                obj3 = textSubstitutionValue.isShowingSubstitution;
            }
            if (i6 &= 8 != 0) {
                obj4 = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(obj1, obj2, obj3, obj4);
        }

        public final AnnotatedString component1() {
            return this.original;
        }

        public final AnnotatedString component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue copy(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z3, androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache multiParagraphLayoutCache4) {
            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue = new TextAnnotatedStringNode.TextSubstitutionValue(annotatedString, annotatedString2, z3, multiParagraphLayoutCache4);
            return textSubstitutionValue;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TextAnnotatedStringNode.TextSubstitutionValue) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.original, obj.original)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.substitution, obj.substitution)) {
                return i2;
            }
            if (this.isShowingSubstitution != obj.isShowingSubstitution) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.layoutCache, obj.layoutCache)) {
                return i2;
            }
            return i;
        }

        public final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int i;
            if (this.layoutCache == null) {
                i = 0;
            } else {
                i = this.layoutCache.hashCode();
            }
            return i7 += i;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache <set-?>) {
            this.layoutCache = <set-?>;
        }

        public final void setShowingSubstitution(boolean <set-?>) {
            this.isShowingSubstitution = <set-?>;
        }

        public final void setSubstitution(AnnotatedString <set-?>) {
            this.substitution = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TextSubstitutionValue(original=").append(this.original).append(", substitution=").append(this.substitution).append(", isShowingSubstitution=").append(this.isShowingSubstitution).append(", layoutCache=").append(this.layoutCache).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    private TextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, ColorProducer overrideColor, Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation) {
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
        this.overrideColor = overrideColor;
        this.onShowTranslation = onShowTranslation;
    }

    public TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, int i14, DefaultConstructorMarker defaultConstructorMarker15) {
        int clip-gIe3tQ8;
        int i15;
        int i2;
        int i9;
        int i12;
        int i3;
        int i10;
        int i4;
        int i13;
        int i;
        int i6;
        int i11;
        int i16 = i14;
        final int i25 = 0;
        i2 = i16 & 8 != 0 ? i25 : function14;
        if (i16 & 16 != 0) {
            i9 = clip-gIe3tQ8;
        } else {
            i9 = i5;
        }
        int i26 = 1;
        i12 = i16 & 32 != 0 ? i26 : z6;
        i3 = i16 & 64 != 0 ? i15 : i7;
        i10 = i16 & 128 != 0 ? i26 : i8;
        i4 = i16 & 256 != 0 ? i25 : list9;
        i13 = i16 & 512 != 0 ? i25 : function110;
        i = i16 & 1024 != 0 ? i25 : selectionController11;
        i6 = i16 & 2048 != 0 ? i25 : colorProducer12;
        i11 = i16 &= 4096 != 0 ? i25 : function113;
        super(annotatedString, textStyle2, resolver3, i2, i9, i12, i3, i10, i4, i13, i, i6, i11, 0);
    }

    public TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, Function1 function14, int i5, boolean z6, int i7, int i8, List list9, Function1 function110, androidx.compose.foundation.text.modifiers.SelectionController selectionController11, ColorProducer colorProducer12, Function1 function113, DefaultConstructorMarker defaultConstructorMarker14) {
        super(annotatedString, textStyle2, resolver3, function14, i5, z6, i7, i8, list9, function110, selectionController11, colorProducer12, function113);
    }

    public static final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache access$getLayoutCache(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this) {
        return $this.getLayoutCache();
    }

    public static final Function1 access$getOnShowTranslation$p(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this) {
        return $this.onShowTranslation;
    }

    public static final ColorProducer access$getOverrideColor$p(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this) {
        return $this.overrideColor;
    }

    public static final TextStyle access$getStyle$p(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this) {
        return $this.style;
    }

    public static final void access$invalidateForTranslate(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this) {
        $this.invalidateForTranslate();
    }

    public static final boolean access$setSubstitution(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode $this, AnnotatedString updatedText) {
        return $this.setSubstitution(updatedText);
    }

    private static void getBaselineCache$annotations() {
    }

    private final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache getLayoutCache() {
        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache multiParagraphLayoutCache;
        AnnotatedString text;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        List placeholders;
        int i;
        if (this._layoutCache == null) {
            multiParagraphLayoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, 0);
            this._layoutCache = multiParagraphLayoutCache;
        }
        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache _layoutCache2 = this._layoutCache;
        Intrinsics.checkNotNull(_layoutCache2);
        return _layoutCache2;
    }

    private final androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache getLayoutCache(Density density) {
        int i;
        boolean showingSubstitution;
        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        i = 0;
        showingSubstitution = textSubstitution.getLayoutCache();
        if (textSubstitution != null && textSubstitution.isShowingSubstitution() && showingSubstitution != null) {
            i = 0;
            if (textSubstitution.isShowingSubstitution()) {
                showingSubstitution = textSubstitution.getLayoutCache();
                if (showingSubstitution != null) {
                    final int i3 = 0;
                    final int i4 = 0;
                    showingSubstitution.setDensity$foundation_release(density);
                    return showingSubstitution;
                }
            }
        }
        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache = getLayoutCache();
        int i2 = 0;
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)this);
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    private final boolean setSubstitution(AnnotatedString updatedText) {
        int multiParagraphLayoutCache;
        Object density$foundation_release;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        List placeholders;
        int i;
        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue str;
        final androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        if (textSubstitution != null) {
            i = 0;
            if (Intrinsics.areEqual(updatedText, textSubstitution.getSubstitution())) {
                return i;
            }
            textSubstitution.setSubstitution(updatedText);
            androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache = textSubstitution.getLayoutCache();
            if (layoutCache != null) {
                layoutCache.update-ZNqEYIc(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
                multiParagraphLayoutCache = Unit.INSTANCE;
            } else {
                multiParagraphLayoutCache = 0;
            }
            if (multiParagraphLayoutCache == 0) {
                return i;
            }
        } else {
            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue = new TextAnnotatedStringNode.TextSubstitutionValue(this.text, updatedText, 0, 0, 12, 0);
            str = textSubstitutionValue;
            multiParagraphLayoutCache = new MultiParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, 0);
            multiParagraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity$foundation_release());
            str.setLayoutCache(multiParagraphLayoutCache);
            this.textSubstitution = str;
        }
        return 1;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Function1 localSemanticsTextLayoutResult;
        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.1 anon;
        boolean showingSubstitution;
        if (this.semanticsTextLayoutResult == null) {
            anon = new TextAnnotatedStringNode.applySemantics.1(this);
            this.semanticsTextLayoutResult = (Function1)anon;
        }
        SemanticsPropertiesKt.setText($this$applySemantics, this.text);
        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue textSubstitution = this.textSubstitution;
        if (textSubstitution != null) {
            SemanticsPropertiesKt.setTextSubstitution($this$applySemantics, textSubstitution.getSubstitution());
            SemanticsPropertiesKt.setShowingTextSubstitution($this$applySemantics, textSubstitution.isShowingSubstitution());
        }
        TextAnnotatedStringNode.applySemantics.2 anon2 = new TextAnnotatedStringNode.applySemantics.2(this);
        final int i = 0;
        final int i2 = 1;
        SemanticsPropertiesKt.setTextSubstitution$default($this$applySemantics, i, (Function1)anon2, i2, i);
        TextAnnotatedStringNode.applySemantics.3 anon3 = new TextAnnotatedStringNode.applySemantics.3(this);
        SemanticsPropertiesKt.showTextSubstitution$default($this$applySemantics, i, (Function1)anon3, i2, i);
        TextAnnotatedStringNode.applySemantics.4 anon4 = new TextAnnotatedStringNode.applySemantics.4(this);
        SemanticsPropertiesKt.clearTextSubstitution$default($this$applySemantics, i, (Function0)anon4, i2, i);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, i, localSemanticsTextLayoutResult, i2, i);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void clearSubstitution$foundation_release() {
        this.textSubstitution = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache;
        boolean semanticsTextLayoutResult;
        AnnotatedString text;
        TextStyle style;
        FontFamily.Resolver fontFamilyResolver;
        int overflow;
        boolean softWrap;
        int maxLines;
        int minLines;
        List placeholders;
        if (!textChanged && !layoutChanged) {
            if (!layoutChanged) {
                if (callbacksChanged) {
                    getLayoutCache().update-ZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
                }
            } else {
            }
        } else {
        }
        if (!isAttached()) {
        }
        if (!textChanged) {
            if (drawChanged && this.semanticsTextLayoutResult != null) {
                if (this.semanticsTextLayoutResult != null) {
                    SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
                }
            }
        } else {
        }
        if (!textChanged && !layoutChanged) {
            if (!layoutChanged) {
                if (callbacksChanged) {
                    LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)this);
                    DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
                }
            } else {
            }
        } else {
        }
        if (drawChanged) {
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        int i2;
        TextDecoration textDecoration;
        Shadow shadow;
        androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle;
        int brush2;
        boolean hasVisualOverflow;
        DrawScope drawScope;
        long unspecified-0d7_KjU;
        int $this$isSpecified$iv2;
        int $this$isSpecified$iv;
        long black-0d7_KjU;
        int text;
        List placeholders;
        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue showingSubstitution;
        int i6;
        int links;
        int visible-gIe3tQ8;
        long rect;
        long i7;
        int i8;
        int i4;
        int alpha;
        int cmp;
        int i;
        int i5;
        int i3;
        androidx.compose.ui.graphics.Brush brush;
        long l;
        int cmp2;
        int i9;
        final Object obj = this;
        if (!obj.isAttached()) {
        }
        androidx.compose.foundation.text.modifiers.SelectionController selectionController = obj.selectionController;
        if (selectionController != null) {
            selectionController.draw((DrawScope)$this$draw);
        }
        final int i10 = 0;
        final Canvas canvas = (DrawScope)$this$draw.getDrawContext().getCanvas();
        final int i12 = 0;
        final TextLayoutResult textLayoutResult = obj.getLayoutCache((Density)$this$draw).getTextLayoutResult();
        final MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        int i11 = 1;
        i6 = 0;
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.equals-impl0(obj.overflow, TextOverflow.Companion.getVisible-gIe3tQ8())) {
            i2 = !TextOverflow.equals-impl0(obj.overflow, TextOverflow.Companion.getVisible-gIe3tQ8()) ? i11 : i6;
        } else {
        }
        final int i13 = i2;
        if (i13 != 0) {
            canvas.save();
            Canvas.clipRect-mtrdD-E$default(canvas, RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), obj10), i6, 2, 0);
        }
        if (obj.style.getTextDecoration() == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        if (obj.style.getShadow() == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        if (obj.style.getDrawStyle() == null) {
            drawStyle = Fill.INSTANCE;
        }
        androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle2 = drawStyle;
        androidx.compose.ui.graphics.Brush brush3 = obj.style.getBrush();
        if (brush3 != null) {
            i3 = i6;
            black-0d7_KjU = brush3;
            brush2 = i9;
            MultiParagraph.paint-hn5TExg$default(multiParagraph, canvas, black-0d7_KjU, obj.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, 0);
            brush = black-0d7_KjU;
        } else {
            brush = brush3;
            brush2 = i11;
            i3 = i6;
            ColorProducer overrideColor = obj.overrideColor;
            if (overrideColor != null) {
                unspecified-0d7_KjU = overrideColor.invoke-0d7_KjU();
            } else {
                unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
            }
            i4 = 0;
            cmp = 16;
            $this$isSpecified$iv2 = Long.compare(unspecified-0d7_KjU, cmp) != 0 ? brush2 : i3;
            if ($this$isSpecified$iv2 != 0) {
                black-0d7_KjU = l;
            } else {
                i4 = 0;
                $this$isSpecified$iv = Long.compare(color-0d7_KjU, cmp) != 0 ? brush2 : i3;
                if ($this$isSpecified$iv != 0) {
                    black-0d7_KjU = obj.style.getColor-0d7_KjU();
                } else {
                    black-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
                }
            }
            MultiParagraph.paint-LG529CI$default(multiParagraph, canvas, black-0d7_KjU, i6, shadow2, textDecoration2, drawStyle2, 0, 32);
        }
        if (i13 != 0) {
            canvas.restore();
        }
        showingSubstitution = obj.textSubstitution;
        if (showingSubstitution != null && showingSubstitution.isShowingSubstitution() == brush2) {
            text = showingSubstitution.isShowingSubstitution() == brush2 ? brush2 : i3;
        } else {
        }
        if (text != null) {
            links = i3;
        } else {
            links = TextAnnotatedStringNodeKt.hasLinks(obj.text);
        }
        if (links == 0) {
            placeholders = obj.placeholders;
            if ((Collection)placeholders != null) {
                if ((Collection)placeholders.isEmpty()) {
                    text = brush2;
                } else {
                    text = i3;
                }
            } else {
            }
            if (text == null) {
                $this$draw.drawContent();
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldClearDescendantSemantics() {
        return 1;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue getTextSubstitution$foundation_release() {
        return this.textSubstitution;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache((Density)$this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache((Density)$this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Object baselineCache;
        int placeholderRects;
        Integer valueOf;
        int i;
        androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache layoutCache = getLayoutCache((Density)$this$measure_u2d3p2s80s);
        final TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
        Function1 onTextLayout = this.onTextLayout;
        if (layoutCache.layoutWithConstraints-K40F9xA(constraints, obj13) && onTextLayout != null) {
            LayoutModifierNodeKt.invalidateLayer((LayoutModifierNode)this);
            onTextLayout = this.onTextLayout;
            if (onTextLayout != null) {
                onTextLayout.invoke(textLayoutResult);
            }
            androidx.compose.foundation.text.modifiers.SelectionController selectionController = this.selectionController;
            if (selectionController != null) {
                selectionController.updateTextLayout(textLayoutResult);
            }
            if (this.baselineCache == null) {
                baselineCache = new LinkedHashMap(2);
            }
            int i2 = 0;
            baselineCache.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResult.getFirstBaseline())));
            i = 0;
            baselineCache.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResult.getLastBaseline())));
            this.baselineCache = baselineCache;
        }
        Function1 cache = this.onPlaceholderLayout;
        if (cache != null) {
            cache.invoke(textLayoutResult.getPlaceholderRects());
        }
        int width-impl = IntSize.getWidth-impl(textLayoutResult.getSize-YbymL2g());
        int width-impl3 = IntSize.getWidth-impl(textLayoutResult.getSize-YbymL2g());
        int height-impl2 = IntSize.getHeight-impl(textLayoutResult.getSize-YbymL2g());
        Map baselineCache2 = this.baselineCache;
        Intrinsics.checkNotNull(baselineCache2);
        TextAnnotatedStringNode.measure.1 anon = new TextAnnotatedStringNode.measure.1(measurable.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(width-impl, width-impl3, height-impl2, IntSize.getHeight-impl(textLayoutResult.getSize-YbymL2g()))));
        return $this$measure_u2d3p2s80s.layout(IntSize.getWidth-impl(textLayoutResult.getSize-YbymL2g()), IntSize.getHeight-impl(textLayoutResult.getSize-YbymL2g()), baselineCache2, (Function1)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final MeasureResult measureNonExtension-3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        return measure-3p2s80s(measureScope, measurable, constraints);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache((Density)$this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache((Density)$this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setTextSubstitution$foundation_release(androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue <set-?>) {
        this.textSubstitution = <set-?>;
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super List<Rect>, Unit> onPlaceholderLayout, androidx.compose.foundation.text.modifiers.SelectionController selectionController, Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation) {
        int changed;
        changed = 0;
        if (this.onTextLayout != onTextLayout) {
            this.onTextLayout = onTextLayout;
            changed = 1;
        }
        if (this.onPlaceholderLayout != onPlaceholderLayout) {
            this.onPlaceholderLayout = onPlaceholderLayout;
            changed = 1;
        }
        if (!Intrinsics.areEqual(this.selectionController, selectionController)) {
            this.selectionController = selectionController;
            changed = 1;
        }
        if (this.onShowTranslation != onShowTranslation) {
            this.onShowTranslation = onShowTranslation;
            changed = 1;
        }
        return changed;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        int changed;
        int i;
        boolean sameDrawAffectingAttributes;
        changed = 0;
        if (!Intrinsics.areEqual(color, this.overrideColor)) {
            changed = 1;
        }
        this.overrideColor = color;
        if (changed == 0) {
            if (!style.hasSameDrawAffectingAttributes(this.style)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean updateLayoutRelatedArgs-MPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        int changed;
        int i = 0;
        sameLayoutAffectingAttributes ^= 1;
        this.style = style;
        if (!Intrinsics.areEqual(this.placeholders, placeholders)) {
            this.placeholders = placeholders;
            changed = 1;
        }
        if (this.minLines != minLines) {
            this.minLines = minLines;
            changed = 1;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            changed = 1;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            changed = 1;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            changed = 1;
        }
        if (!TextOverflow.equals-impl0(this.overflow, overflow)) {
            this.overflow = overflow;
            changed = 1;
        }
        return changed;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean updateText$foundation_release(AnnotatedString text) {
        int i;
        i = 1;
        equal ^= i;
        if (i2 == 0 && equal2 ^= i == 0 && equal3 ^= i == 0) {
            if (equal2 ^= i == 0) {
                if (equal3 ^= i == 0) {
                    if (equalAnnotations ^= i != 0) {
                    } else {
                        i = 0;
                    }
                }
            }
        }
        if (i != 0) {
            this.text = text;
        }
        if (i2 != 0) {
            clearSubstitution$foundation_release();
        }
        return i;
    }
}
