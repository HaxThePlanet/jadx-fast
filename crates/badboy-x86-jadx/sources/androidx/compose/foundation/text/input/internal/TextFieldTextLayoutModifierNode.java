package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B]\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u00126\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J^\u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c26\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\u0008\u0016J&\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getBaselineCache$annotations", "()V", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldTextLayoutModifierNode extends Modifier.Node implements LayoutModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {

    public static final int $stable = 8;
    private Map<AlignmentLine, Integer> baselineCache;
    private boolean singleLine;
    private androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    static {
        final int i = 8;
    }

    public TextFieldTextLayoutModifierNode(androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout) {
        super();
        this.textLayoutState = textLayoutState;
        this.singleLine = singleLine;
        this.textLayoutState.setOnTextLayout(onTextLayout);
        this.textLayoutState.updateNonMeasureInputs(textFieldState, textStyle, this.singleLine, singleLine3 ^= 1);
    }

    private static void getBaselineCache$annotations() {
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Object baselineCache;
        float $this$dp$iv;
        int height-impl;
        int constructor-impl;
        Density density = $this$measure_u2d3p2s80s;
        androidx.compose.ui.unit.LayoutDirection layoutDirection = $this$measure_u2d3p2s80s.getLayoutDirection();
        Object currentValueOf = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalFontFamilyResolver());
        final TextLayoutResult obj11 = this.textLayoutState.layoutWithNewMeasureInputs--hBUhpc((Density)density, layoutDirection, (FontFamily.Resolver)currentValueOf, constraints);
        int width-impl2 = IntSize.getWidth-impl(obj11.getSize-YbymL2g());
        if (this.singleLine) {
            $this$dp$iv = $this$measure_u2d3p2s80s.toDp-u2uoSUM(TextDelegateKt.ceilToIntPx(obj11.getLineBottom(0)));
        } else {
            height-impl = 0;
            $this$dp$iv = constructor-impl;
        }
        this.textLayoutState.setMinHeightForSingleLineField-0680j_4($this$dp$iv);
        if (this.baselineCache == null) {
            baselineCache = new LinkedHashMap(2);
        }
        int i3 = 0;
        baselineCache.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(obj11.getFirstBaseline())));
        Integer valueOf2 = Integer.valueOf(Math.round(obj11.getLastBaseline()));
        baselineCache.put(AlignmentLineKt.getLastBaseline(), valueOf2);
        this.baselineCache = baselineCache;
        Map baselineCache2 = this.baselineCache;
        Intrinsics.checkNotNull(baselineCache2);
        TextFieldTextLayoutModifierNode.measure.1 anon = new TextFieldTextLayoutModifierNode.measure.1(measurable.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(IntSize.getWidth-impl(obj11.getSize-YbymL2g()), width-impl2, IntSize.getHeight-impl(obj11.getSize-YbymL2g()), IntSize.getHeight-impl(obj11.getSize-YbymL2g()))));
        return $this$measure_u2d3p2s80s.layout(IntSize.getWidth-impl(obj11.getSize-YbymL2g()), IntSize.getHeight-impl(obj11.getSize-YbymL2g()), baselineCache2, (Function1)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setTextLayoutNodeCoordinates(coordinates);
    }

    public final void updateNode(androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout) {
        this.textLayoutState = textLayoutState;
        this.textLayoutState.setOnTextLayout(onTextLayout);
        this.singleLine = singleLine;
        this.textLayoutState.updateNonMeasureInputs(textFieldState, textStyle, singleLine, singleLine ^ 1);
    }
}
