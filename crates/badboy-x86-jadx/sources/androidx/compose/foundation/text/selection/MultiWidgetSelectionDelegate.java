package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\"J\u0008\u0010\u0010\u001a\u00020\u000bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008(\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010+\u001a\u00020,H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getCenterYForOffset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getLineLeft", "getLineRight", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiWidgetSelectionDelegate implements androidx.compose.foundation.text.selection.Selectable {

    public static final int $stable = 8;
    private int _previousLastVisibleOffset = -1;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;
    static {
        final int i = 8;
    }

    public MultiWidgetSelectionDelegate(long selectableId, Function0<? extends LayoutCoordinates> coordinatesCallback, Function0<TextLayoutResult> layoutResultCallback) {
        super();
        this.selectableId = selectableId;
        this.coordinatesCallback = layoutResultCallback;
        this.layoutResultCallback = obj5;
        final int i = -1;
    }

    private final int getLastVisibleOffset(TextLayoutResult $this$lastVisibleOffset) {
        TextLayoutResult _previousTextLayoutResult;
        int finalVisibleLine;
        boolean didOverflowHeight;
        int i;
        int coerceAtLeast;
        int cmp;
        long l;
        synchronized (this) {
            try {
                i = 1;
                if ($this$lastVisibleOffset.getDidOverflowHeight()) {
                } else {
                }
                if ($this$lastVisibleOffset.getMultiParagraph().getDidExceedMaxLines()) {
                } else {
                }
                finalVisibleLine = RangesKt.coerceAtMost($this$lastVisibleOffset.getLineForVerticalPosition((float)height-impl), lineCount -= i);
                while (finalVisibleLine >= 0) {
                    if (Float.compare(lineTop, l) >= 0) {
                    }
                    finalVisibleLine--;
                }
                if (Float.compare(lineTop, l) >= 0) {
                }
                finalVisibleLine--;
                coerceAtLeast = RangesKt.coerceAtLeast(finalVisibleLine, 0);
                coerceAtLeast = finalVisibleLine + -1;
                this._previousLastVisibleOffset = $this$lastVisibleOffset.getLineEnd(coerceAtLeast, i);
                this._previousTextLayoutResult = $this$lastVisibleOffset;
                return this._previousLastVisibleOffset;
                throw $this$lastVisibleOffset;
            }
        }
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void appendSelectableInfoToBuilder(androidx.compose.foundation.text.selection.SelectionLayoutBuilder builder) {
        long minus-MK-Hz9U;
        long l;
        final LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
        }
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
        }
        Offset.Companion companion2 = Offset.Companion;
        final long l2 = localPositionOf-R5De75A;
        if (OffsetKt.isUnspecified-k-4lQ0M(builder.getPreviousHandlePosition-F1C5BW0())) {
            l = minus-MK-Hz9U;
        } else {
            l = minus-MK-Hz9U;
        }
        MultiWidgetSelectionDelegateKt.appendSelectableInfo-Parwq6A(builder, (TextLayoutResult)invoke, Offset.minus-MK-Hz9U(builder.getCurrentPosition-F1C5BW0(), companion2), obj5, l);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int offset) {
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            return Rect.Companion.getZero();
        }
        int length = (TextLayoutResult)invoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.Companion.getZero();
        }
        return invoke.getBoundingBox(RangesKt.coerceIn(offset, 0, length + -1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getCenterYForOffset(int offset) {
        Object invoke = this.layoutResultCallback.invoke();
        int i = -1082130432;
        if ((TextLayoutResult)invoke == null) {
            return i;
        }
        final int lineForOffset = (TextLayoutResult)invoke.getLineForOffset(offset);
        if (lineForOffset >= invoke.getLineCount()) {
            return i;
        }
        float lineTop = invoke.getLineTop(lineForOffset);
        return i3 += lineTop;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getHandlePosition-dBAh8RU(androidx.compose.foundation.text.selection.Selection selection, boolean isStartHandle) {
        int cmp;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        long selectableId;
        if (isStartHandle) {
            if (Long.compare(selectableId3, selectableId) == 0 && !isStartHandle && Long.compare(selectableId2, selectableId) != 0) {
                if (!isStartHandle) {
                    if (Long.compare(selectableId2, selectableId) != 0) {
                    }
                }
            }
            return Offset.Companion.getUnspecified-F1C5BW0();
        } else {
        }
        if (getLayoutCoordinates() == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        if (isStartHandle) {
            start = selection.getStart();
        } else {
            start = selection.getEnd();
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(invoke, RangesKt.coerceIn(start.getOffset(), 0, getLastVisibleOffset((TextLayoutResult)invoke)), isStartHandle, selection.getHandlesCrossed());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            return 0;
        }
        return getLastVisibleOffset((TextLayoutResult)invoke);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        boolean attached;
        Object invoke = this.coordinatesCallback.invoke();
        if (invoke != null && !(LayoutCoordinates)invoke.isAttached()) {
            if (!invoke.isAttached()) {
            }
            return invoke;
        }
        return null;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineLeft(int offset) {
        Object invoke = this.layoutResultCallback.invoke();
        int i = -1082130432;
        if ((TextLayoutResult)invoke == null) {
            return i;
        }
        final int lineForOffset = (TextLayoutResult)invoke.getLineForOffset(offset);
        if (lineForOffset >= invoke.getLineCount()) {
            return i;
        }
        return invoke.getLineLeft(lineForOffset);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineRight(int offset) {
        Object invoke = this.layoutResultCallback.invoke();
        int i = -1082130432;
        if ((TextLayoutResult)invoke == null) {
            return i;
        }
        final int lineForOffset = (TextLayoutResult)invoke.getLineForOffset(offset);
        if (lineForOffset >= invoke.getLineCount()) {
            return i;
        }
        return invoke.getLineRight(lineForOffset);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getRangeOfLineContaining--jx7JFs(int offset) {
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        final int lastVisibleOffset = getLastVisibleOffset((TextLayoutResult)invoke);
        int i = 1;
        if (lastVisibleOffset < i) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        int lineForOffset = invoke.getLineForOffset(RangesKt.coerceIn(offset, 0, lastVisibleOffset + -1));
        return TextRangeKt.TextRange(invoke.getLineStart(lineForOffset), invoke.getLineEnd(lineForOffset, i));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public androidx.compose.foundation.text.selection.Selection getSelectAllSelection() {
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            return null;
        }
        final int i2 = 0;
        int length = (TextLayoutResult)invoke.getLayoutInput().getText().length();
        Selection.AnchorInfo anchorInfo = new Selection.AnchorInfo(invoke.getBidiRunDirection(i2), i2, getSelectableId(), obj7);
        final int i5 = 0;
        Selection.AnchorInfo anchorInfo2 = new Selection.AnchorInfo(invoke.getBidiRunDirection(Math.max(length + -1, i5)), length, getSelectableId(), obj9);
        Selection selection = new Selection(anchorInfo, anchorInfo2, i5);
        return selection;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        Object invoke = this.layoutResultCallback.invoke();
        if ((TextLayoutResult)invoke == null) {
            AnnotatedString annotatedString = new AnnotatedString("", 0, 0, 6, 0);
            return annotatedString;
        }
        return (TextLayoutResult)invoke.getLayoutInput().getText();
    }
}
