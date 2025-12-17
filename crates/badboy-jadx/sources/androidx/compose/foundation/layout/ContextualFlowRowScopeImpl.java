package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0097\u0001J!\u0010\u0015\u001a\u00020\u0012*\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0017H\u0097\u0001J\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0097\u0001J\r\u0010\u001b\u001a\u00020\u0012*\u00020\u0012H\u0097\u0001J\u0017\u0010\u001c\u001a\u00020\u0012*\u00020\u00122\u0008\u0008\u0003\u0010\u001d\u001a\u00020\u001eH\u0097\u0001J\u001f\u0010\u001f\u001a\u00020\u0012*\u00020\u00122\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0097\u0001R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u001c\u0010\u0008\u001a\u00020\u0007X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0007X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScopeImpl;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "lineIndex", "", "indexInLine", "maxWidthInLine", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndexInLine", "()I", "getLineIndex", "getMaxHeight-D9Ej5fM", "()F", "F", "getMaxWidthInLine-D9Ej5fM", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "fillMaxRowHeight", "fraction", "", "weight", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextualFlowRowScopeImpl implements androidx.compose.foundation.layout.FlowRowScope, androidx.compose.foundation.layout.ContextualFlowRowScope {

    public static final int $stable;
    private final androidx.compose.foundation.layout.FlowRowScopeInstance $$delegate_0;
    private final int indexInLine;
    private final int lineIndex;
    private final float maxHeight;
    private final float maxWidthInLine;
    static {
    }

    private ContextualFlowRowScopeImpl(int lineIndex, int indexInLine, float maxWidthInLine, float maxHeight) {
        super();
        this.lineIndex = lineIndex;
        this.indexInLine = indexInLine;
        this.maxWidthInLine = maxWidthInLine;
        this.maxHeight = maxHeight;
        this.$$delegate_0 = FlowRowScopeInstance.INSTANCE;
    }

    public ContextualFlowRowScopeImpl(int i, int i2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, i2, f3, f4);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier align(Modifier modifier, Alignment.Vertical alignment$Vertical2) {
        return this.$$delegate_0.align(modifier, vertical2);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine2) {
        return this.$$delegate_0.alignBy(modifier, horizontalAlignmentLine2);
    }

    public Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function12) {
        return this.$$delegate_0.alignBy(modifier, function12);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier alignByBaseline(Modifier modifier) {
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier fillMaxRowHeight(Modifier modifier, float f2) {
        return this.$$delegate_0.fillMaxRowHeight(modifier, f2);
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public int getIndexInLine() {
        return this.indexInLine;
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public int getLineIndex() {
        return this.lineIndex;
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public float getMaxHeight-D9Ej5fM() {
        return this.maxHeight;
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public float getMaxWidthInLine-D9Ej5fM() {
        return this.maxWidthInLine;
    }

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public Modifier weight(Modifier modifier, float f2, boolean z3) {
        return this.$$delegate_0.weight(modifier, f2, z3);
    }
}
