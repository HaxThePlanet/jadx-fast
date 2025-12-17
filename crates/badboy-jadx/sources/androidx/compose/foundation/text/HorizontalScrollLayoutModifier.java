package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J&\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/foundation/text/HorizontalScrollLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "(Landroidx/compose/foundation/text/TextFieldScrollerPosition;ILandroidx/compose/ui/text/input/TransformedText;Lkotlin/jvm/functions/Function0;)V", "getCursorOffset", "()I", "getScrollerPosition", "()Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getTextLayoutResultProvider", "()Lkotlin/jvm/functions/Function0;", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HorizontalScrollLayoutModifier implements LayoutModifier {

    private final int cursorOffset;
    private final androidx.compose.foundation.text.TextFieldScrollerPosition scrollerPosition;
    private final Function0<androidx.compose.foundation.text.TextLayoutResultProxy> textLayoutResultProvider;
    private final TransformedText transformedText;
    public HorizontalScrollLayoutModifier(androidx.compose.foundation.text.TextFieldScrollerPosition scrollerPosition, int cursorOffset, TransformedText transformedText, Function0<androidx.compose.foundation.text.TextLayoutResultProxy> textLayoutResultProvider) {
        super();
        this.scrollerPosition = scrollerPosition;
        this.cursorOffset = cursorOffset;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = textLayoutResultProvider;
    }

    public static androidx.compose.foundation.text.HorizontalScrollLayoutModifier copy$default(androidx.compose.foundation.text.HorizontalScrollLayoutModifier horizontalScrollLayoutModifier, androidx.compose.foundation.text.TextFieldScrollerPosition textFieldScrollerPosition2, int i3, TransformedText transformedText4, Function0 function05, int i6, Object object7) {
        androidx.compose.foundation.text.TextFieldScrollerPosition obj1;
        int obj2;
        TransformedText obj3;
        Function0 obj4;
        if (i6 & 1 != 0) {
            obj1 = horizontalScrollLayoutModifier.scrollerPosition;
        }
        if (i6 & 2 != 0) {
            obj2 = horizontalScrollLayoutModifier.cursorOffset;
        }
        if (i6 & 4 != 0) {
            obj3 = horizontalScrollLayoutModifier.transformedText;
        }
        if (i6 &= 8 != 0) {
            obj4 = horizontalScrollLayoutModifier.textLayoutResultProvider;
        }
        return horizontalScrollLayoutModifier.copy(obj1, obj2, obj3, obj4);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final androidx.compose.foundation.text.TextFieldScrollerPosition component1() {
        return this.scrollerPosition;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final int component2() {
        return this.cursorOffset;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final TransformedText component3() {
        return this.transformedText;
    }

    public final Function0<androidx.compose.foundation.text.TextLayoutResultProxy> component4() {
        return this.textLayoutResultProvider;
    }

    public final androidx.compose.foundation.text.HorizontalScrollLayoutModifier copy(androidx.compose.foundation.text.TextFieldScrollerPosition textFieldScrollerPosition, int i2, TransformedText transformedText3, Function0<androidx.compose.foundation.text.TextLayoutResultProxy> function04) {
        HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, i2, transformedText3, function04);
        return horizontalScrollLayoutModifier;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof HorizontalScrollLayoutModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.scrollerPosition, obj.scrollerPosition)) {
            return i2;
        }
        if (this.cursorOffset != obj.cursorOffset) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.transformedText, obj.transformedText)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textLayoutResultProvider, obj.textLayoutResultProvider)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final androidx.compose.foundation.text.TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    public final Function0<androidx.compose.foundation.text.TextLayoutResultProxy> getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int hashCode() {
        return i6 += i10;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long l;
        long copy-Zbe2FdA$default;
        int i3;
        int i4;
        int i5;
        int i;
        int i2;
        final Object obj = measurable;
        if (obj.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraints)) < Constraints.getMaxWidth-impl(constraints)) {
            copy-Zbe2FdA$default = constraints;
        } else {
            copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj4, 0, Integer.MAX_VALUE, 0, 0, 13);
        }
        Placeable measure-BRTryo0 = obj.measure-BRTryo0(copy-Zbe2FdA$default);
        int i7 = Math.min(measure-BRTryo0.getWidth(), Constraints.getMaxWidth-impl(constraints));
        HorizontalScrollLayoutModifier.measure.1 anon = new HorizontalScrollLayoutModifier.measure.1($this$measure_u2d3p2s80s, this, measure-BRTryo0, i7);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i7, measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("HorizontalScrollLayoutModifier(scrollerPosition=").append(this.scrollerPosition).append(", cursorOffset=").append(this.cursorOffset).append(", transformedText=").append(this.transformedText).append(", textLayoutResultProvider=").append(this.textLayoutResultProvider).append(')').toString();
    }
}
