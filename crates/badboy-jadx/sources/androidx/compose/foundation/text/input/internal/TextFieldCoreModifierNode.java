package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.TextHighlightType.Companion;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0008\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\"\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\u0008\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\u0008\u00101\u001a\u00020-H\u0002JN\u00102\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000c\u00103\u001a\u00020-*\u000204H\u0016J\u000c\u00105\u001a\u00020-*\u000206H\u0016J\u000c\u00107\u001a\u00020-*\u000208H\u0002J(\u00109\u001a\u00020-*\u0002082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001f0;2\u0006\u0010=\u001a\u00020>H\u0002J&\u0010?\u001a\u00020-*\u0002082\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u0014\u0010C\u001a\u00020-*\u0002082\u0006\u0010=\u001a\u00020>H\u0002J&\u0010D\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ&\u0010M\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\u0008N\u0010LJ&\u0010O\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\u0008P\u0010LJ6\u0010Q\u001a\u00020-*\u00020R2\u0006\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0002ø\u0001\u0000¢\u0006\u0004\u0008W\u0010XR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Y", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "changeObserverJob", "Lkotlinx/coroutines/Job;", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousTextLayoutSize", "", "showCursor", "getShowCursor", "()Z", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "calculateOffsetToFollow", "currSelection", "currTextLayoutSize", "calculateOffsetToFollow-72CqOWE", "(JI)I", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "startCursorJob", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawCursor", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection", "selection", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawText", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {

    public static final int $stable = 8;
    private Job changeObserverJob;
    private final androidx.compose.foundation.text.input.internal.CursorAnimationState cursorAnimation;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private Rect previousCursorRect;
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    private ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    private boolean writeable;
    static {
        final int i = 8;
    }

    public TextFieldCoreModifierNode(boolean isFocused, boolean isDragHovered, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        int i;
        boolean isDragHovered2;
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
        CursorAnimationState cursorAnimationState = new CursorAnimationState();
        this.cursorAnimation = cursorAnimationState;
        int i2 = -1082130432;
        Rect rect = new Rect(i2, i2, i2, i2);
        this.previousCursorRect = rect;
        if (!this.isFocused) {
            if (this.isDragHovered) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        this.textFieldMagnifierNode = (TextFieldMagnifierNode)delegate((DelegatableNode)AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, i));
    }

    public static final androidx.compose.foundation.text.input.internal.CursorAnimationState access$getCursorAnimation$p(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode $this) {
        return $this.cursorAnimation;
    }

    public static final ScrollState access$getScrollState$p(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode $this) {
        return $this.scrollState;
    }

    public static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState access$getTextFieldState$p(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode $this) {
        return $this.textFieldState;
    }

    public static final androidx.compose.foundation.text.input.internal.TextLayoutState access$getTextLayoutState$p(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode $this) {
        return $this.textLayoutState;
    }

    public static final void access$updateScrollState-tIlFzwE(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode $this, Density $receiver, int containerSize, int textLayoutSize, long currSelection, LayoutDirection layoutDirection) {
        $this.updateScrollState-tIlFzwE($receiver, containerSize, textLayoutSize, currSelection, layoutDirection);
    }

    private final int calculateOffsetToFollow-72CqOWE(long currSelection, int currTextLayoutSize) {
        TextRange previousSelection2;
        int i2;
        TextRange previousSelection;
        int start-impl;
        int i;
        int start-impl2;
        long unbox-impl;
        previousSelection2 = this.previousSelection;
        final int i3 = 0;
        if (previousSelection2 != null && TextRange.getEnd-impl(currSelection) == TextRange.getEnd-impl(previousSelection2.unbox-impl())) {
            i2 = TextRange.getEnd-impl(currSelection) == TextRange.getEnd-impl(previousSelection2.unbox-impl()) ? i : i3;
        } else {
        }
        if (i2 == 0) {
            start-impl = TextRange.getEnd-impl(currSelection);
        } else {
            previousSelection = this.previousSelection;
            if (previousSelection != null && TextRange.getStart-impl(currSelection) == TextRange.getStart-impl(previousSelection.unbox-impl())) {
                if (TextRange.getStart-impl(currSelection) == TextRange.getStart-impl(previousSelection.unbox-impl())) {
                } else {
                    i = i3;
                }
            } else {
            }
            if (i == 0) {
                start-impl = TextRange.getStart-impl(currSelection);
            } else {
                if (obj9 != this.previousTextLayoutSize) {
                    start-impl = TextRange.getStart-impl(currSelection);
                } else {
                    start-impl = -1;
                }
            }
        }
        return start-impl;
    }

    private final void drawCursor(DrawScope $this$drawCursor) {
        int showCursor;
        final Object obj = this;
        final float cursorAlpha = obj.cursorAnimation.getCursorAlpha();
        showCursor = Float.compare(cursorAlpha, i) == 0 ? 1 : 0;
        if (showCursor == null && !obj.getShowCursor()) {
            if (!obj.getShowCursor()) {
            }
            Rect cursorRect = obj.textFieldSelectionState.getCursorRect();
            DrawScope.drawLine-1RTmtNc$default($this$drawCursor, obj.cursorBrush, cursorRect.getTopCenter-F1C5BW0(), obj5, cursorRect.getBottomCenter-F1C5BW0(), obj7, cursorRect.getWidth(), 0, 0, cursorAlpha, 0, 0);
        }
    }

    private final void drawHighlight(DrawScope $this$drawHighlight, Pair<TextHighlightType, TextRange> highlight, TextLayoutResult textLayoutResult) {
        Object brush;
        float localTextSelectionColors;
        int i5;
        DrawScope drawScope;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        long copy-wmQWz5c$default;
        long i;
        long black-0d7_KjU;
        int i4;
        int i2;
        int i9;
        int i10;
        int i7;
        int i3;
        int i8;
        long l;
        int i6;
        long unbox-impl2 = (TextRange)highlight.component2().unbox-impl();
        if (TextRange.getCollapsed-impl(unbox-impl2)) {
        }
        final Object obj = textLayoutResult;
        final androidx.compose.ui.graphics.Path pathForRange = obj.getPathForRange(TextRange.getMin-impl(unbox-impl2), TextRange.getMax-impl(unbox-impl2));
        if (TextHighlightType.equals-impl0((TextHighlightType)highlight.component1().unbox-impl(), TextHighlightType.Companion.getHandwritingDeletePreview-s-xJuwY())) {
            copy-wmQWz5c$default = obj.getLayoutInput().getStyle().getBrush();
            if (copy-wmQWz5c$default != null) {
                DrawScope.drawPath-GBMwjPU$default($this$drawHighlight, pathForRange, copy-wmQWz5c$default, 1045220557, 0, 0, 0, 56, 0);
                brush = copy-wmQWz5c$default;
            } else {
                brush = copy-wmQWz5c$default;
                int i11 = 0;
                i5 = 0;
                i9 = Long.compare(black-0d7_KjU, i13) != 0 ? 1 : 0;
                if (i9 != 0) {
                } else {
                    i5 = 0;
                    $this$takeOrElse_u2dDxMtmZc$iv = black-0d7_KjU;
                }
                long l2 = $this$takeOrElse_u2dDxMtmZc$iv;
                l = l2;
                DrawScope.drawPath-LG529CI$default($this$drawHighlight, pathForRange, Color.copy-wmQWz5c$default(l2, obj11, localTextSelectionColors * i12, 0, 0, 0, 14), obj9, 0, 0, 0, 0, 60);
            }
        } else {
            DrawScope.drawPath-LG529CI$default($this$drawHighlight, pathForRange, (TextSelectionColors)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU(), obj9, 0, 0, 0, 0, 60);
        }
    }

    private final void drawSelection-Sb-Bc2M(DrawScope $this$drawSelection_u2dSb_u2dBc2M, long selection, TextLayoutResult textLayoutResult) {
        Object obj;
        androidx.compose.runtime.ProvidableCompositionLocal localTextSelectionColors;
        Object obj2;
        androidx.compose.ui.graphics.Path pathForRange;
        long l;
        int i5;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        final int min-impl = TextRange.getMin-impl(selection);
        final int max-impl = TextRange.getMax-impl(selection);
        if (min-impl != max-impl) {
            DrawScope.drawPath-LG529CI$default($this$drawSelection_u2dSb_u2dBc2M, obj18.getPathForRange(min-impl, max-impl), (TextSelectionColors)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU(), obj7, 0, 0, 0, 0, 60);
        } else {
            obj = obj18;
        }
    }

    private final void drawText(DrawScope $this$drawText, TextLayoutResult textLayoutResult) {
        final int i = 0;
        final int i2 = 0;
        TextPainter.INSTANCE.paint($this$drawText.getDrawContext().getCanvas(), textLayoutResult);
    }

    private final boolean getShowCursor() {
        boolean isDragHovered;
        int i;
        if (this.writeable) {
            if (!this.isFocused) {
                if (this.isDragHovered && TextFieldCoreModifierKt.access$isSpecified(this.cursorBrush)) {
                    i = TextFieldCoreModifierKt.access$isSpecified(this.cursorBrush) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final MeasureResult measureHorizontalScroll-3p2s80s(MeasureScope $this$measureHorizontalScroll_u2d3p2s80s, Measurable measurable, long constraints) {
        final Object obj = constraints;
        Placeable obj13 = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(obj, obj1, 0, Integer.MAX_VALUE, 0, 0, 13));
        int i4 = Math.min(obj13.getWidth(), Constraints.getMaxWidth-impl(obj));
        TextFieldCoreModifierNode.measureHorizontalScroll.1 obj14 = new TextFieldCoreModifierNode.measureHorizontalScroll.1(this, $this$measureHorizontalScroll_u2d3p2s80s, i4, obj13);
        return MeasureScope.layout$default($this$measureHorizontalScroll_u2d3p2s80s, i4, obj13.getHeight(), 0, (Function1)obj14, 4, 0);
    }

    private final MeasureResult measureVerticalScroll-3p2s80s(MeasureScope $this$measureVerticalScroll_u2d3p2s80s, Measurable measurable, long constraints) {
        final int i2 = 0;
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints, obj1, 0, i2, 0, Integer.MAX_VALUE, 7));
        int i7 = Math.min(measure-BRTryo0.getHeight(), Constraints.getMaxHeight-impl(constraints));
        TextFieldCoreModifierNode.measureVerticalScroll.1 anon = new TextFieldCoreModifierNode.measureVerticalScroll.1(this, $this$measureVerticalScroll_u2d3p2s80s, i7, measure-BRTryo0);
        return MeasureScope.layout$default($this$measureVerticalScroll_u2d3p2s80s, measure-BRTryo0.getWidth(), i7, 0, (Function1)anon, 4, 0);
    }

    private final void startCursorJob() {
        final int i2 = 0;
        TextFieldCoreModifierNode.startCursorJob.1 anon = new TextFieldCoreModifierNode.startCursorJob.1(this, i2);
        this.changeObserverJob = BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
    }

    private final void updateScrollState-tIlFzwE(Density $this$updateScrollState_u2dtIlFzwE, int containerSize, int textLayoutSize, long currSelection, LayoutDirection layoutDirection) {
        int i3;
        int difference;
        long l;
        int cmp2;
        int cmp;
        int anon;
        boolean showCursor;
        int i2;
        int i7;
        int left;
        LayoutDirection layoutDirection2;
        Density density;
        int previousTextLayoutSize;
        float value;
        int i5;
        int i;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i4;
        CoroutineStart uNDISPATCHED;
        androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.updateScrollState.1 field;
        int i6;
        int i8;
        final Object obj = this;
        i3 = containerSize;
        final int i9 = textLayoutSize;
        difference = i9 - i3;
        obj.scrollState.setMaxValue$foundation_release(difference);
        final int offsetToFollow-72CqOWE = obj.calculateOffsetToFollow-72CqOWE(currSelection, obj5);
        if (offsetToFollow-72CqOWE >= 0) {
            if (!obj.getShowCursor()) {
                density = $this$updateScrollState_u2dtIlFzwE;
                layoutDirection2 = obj29;
                i5 = difference;
            } else {
                TextLayoutResult layoutResult = obj.textLayoutState.getLayoutResult();
                if (layoutResult == null) {
                }
                i7 = 0;
                IntRange intRange = new IntRange(i7, layoutResult.getLayoutInput().getText().length());
                Rect cursorRect = layoutResult.getCursorRect(RangesKt.coerceIn(offsetToFollow-72CqOWE, (ClosedRange)intRange));
                left = 1;
                i2 = obj29 == LayoutDirection.Rtl ? left : i7;
                Rect rect = TextFieldCoreModifierKt.access$getCursorRectInScroller($this$updateScrollState_u2dtIlFzwE, cursorRect, i2, i9);
                previousTextLayoutSize = Float.compare(left2, value) == 0 ? left : i7;
                if (previousTextLayoutSize != 0) {
                    previousTextLayoutSize = Float.compare(top, value) == 0 ? left : i7;
                    if (previousTextLayoutSize != 0) {
                        if (i9 != obj.previousTextLayoutSize) {
                            if (obj.orientation == Orientation.Vertical) {
                                i7 = left;
                            }
                            if (i7 != 0) {
                                left = rect.getTop();
                            } else {
                                left = rect.getLeft();
                            }
                            if (i7 != 0) {
                                previousTextLayoutSize = rect.getBottom();
                            } else {
                                previousTextLayoutSize = rect.getRight();
                            }
                            value = obj.scrollState.getValue();
                            i = difference;
                            difference = value + i3;
                            if (Float.compare(previousTextLayoutSize, f) > 0) {
                                l = previousTextLayoutSize - f2;
                            } else {
                                if (Float.compare(left, f3) < 0 && Float.compare(i10, anon) > 0) {
                                    if (Float.compare(i10, anon) > 0) {
                                        l = previousTextLayoutSize - f4;
                                    } else {
                                        if (Float.compare(left, f5) < 0 && Float.compare(i11, anon) <= 0) {
                                            l = Float.compare(i11, anon) <= 0 ? left - f6 : 0;
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                            obj.previousSelection = TextRange.box-impl(currSelection);
                            obj.previousCursorRect = rect;
                            obj.previousTextLayoutSize = i9;
                            anon = new TextFieldCoreModifierNode.updateScrollState.1(obj, l, cursorRect, 0);
                            BuildersKt.launch$default(obj.getCoroutineScope(), 0, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
                        } else {
                            i = difference;
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        density = $this$updateScrollState_u2dtIlFzwE;
        layoutDirection2 = obj29;
        i5 = difference;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        final int i = 0;
        this.textFieldMagnifierNode.applySemantics($this$applySemantics);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void draw(ContentDrawScope $this$draw) {
        boolean showSelection;
        DrawScope showSelection2;
        int selection-d9O1mEE;
        DrawScope drawScope;
        $this$draw.drawContent();
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
        }
        Pair highlight = visualText.getHighlight();
        if (highlight != null) {
            selection-d9O1mEE = 0;
            drawHighlight((DrawScope)$this$draw, highlight, layoutResult);
        }
        if (TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
            drawText((DrawScope)$this$draw, layoutResult);
            if (visualText.shouldShowSelection()) {
                drawCursor((DrawScope)$this$draw);
            }
        } else {
            if (visualText.shouldShowSelection()) {
                drawSelection-Sb-Bc2M((DrawScope)$this$draw, visualText.getSelection-d9O1mEE(), drawScope);
            }
            drawText((DrawScope)$this$draw, layoutResult);
        }
        int i = 0;
        this.textFieldMagnifierNode.draw($this$draw);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MeasureResult measureVerticalScroll-3p2s80s;
        if (this.orientation == Orientation.Vertical) {
            measureVerticalScroll-3p2s80s = measureVerticalScroll-3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
        } else {
            measureVerticalScroll-3p2s80s = measureHorizontalScroll-3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
        }
        return measureVerticalScroll-3p2s80s;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onAttach() {
        boolean showCursor;
        if (this.isFocused && getShowCursor()) {
            if (getShowCursor()) {
                startCursorJob();
            }
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setCoreNodeCoordinates(coordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void updateNode(boolean isFocused, boolean isDragHovered, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        androidx.compose.foundation.text.input.internal.CursorAnimationState cursorAnimation;
        boolean equal;
        int i2;
        int previousShowCursor;
        int i;
        boolean previousShowCursor2;
        final Object obj = this;
        final androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState2 = textLayoutState;
        final androidx.compose.foundation.text.input.internal.TransformedTextFieldState field = textFieldState;
        final TextFieldSelectionState field2 = textFieldSelectionState;
        final ScrollState scrollState2 = scrollState;
        previousShowCursor = obj.getShowCursor();
        final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState2 = obj.textFieldState;
        obj.isFocused = isFocused;
        obj.isDragHovered = isDragHovered;
        obj.textLayoutState = textLayoutState2;
        obj.textFieldState = field;
        obj.textFieldSelectionState = field2;
        obj.cursorBrush = cursorBrush;
        obj.writeable = writeable;
        obj.scrollState = scrollState2;
        obj.orientation = orientation;
        if (!isFocused) {
            if (isDragHovered) {
                i2 = 1;
            } else {
                i2 = i;
            }
        } else {
        }
        obj.textFieldMagnifierNode.update(field, field2, textLayoutState2, i2);
        if (!obj.getShowCursor()) {
            Job changeObserverJob = obj.changeObserverJob;
            i2 = 0;
            if (changeObserverJob != null) {
                previousShowCursor2 = previousShowCursor;
                Job.DefaultImpls.cancel$default(changeObserverJob, i2, 1, i2);
            } else {
                previousShowCursor2 = previousShowCursor;
            }
            obj.changeObserverJob = i2;
            obj.cursorAnimation.cancelAndHide();
        } else {
            if (obj.isFocused && Intrinsics.areEqual(textFieldState2, field)) {
                if (Intrinsics.areEqual(textFieldState2, field)) {
                    if (previousShowCursor == null) {
                        obj.startCursorJob();
                    }
                } else {
                }
            } else {
            }
        }
        if (Intrinsics.areEqual(textFieldState2, field) && Intrinsics.areEqual(obj.textLayoutState, textLayoutState2) && Intrinsics.areEqual(obj.textFieldSelectionState, field2)) {
            if (Intrinsics.areEqual(textLayoutState3, textLayoutState2)) {
                if (Intrinsics.areEqual(textFieldSelectionState2, field2)) {
                    if (!Intrinsics.areEqual(obj.scrollState, scrollState2)) {
                        LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)obj);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
