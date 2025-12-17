package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0010\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\u00082\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a4\u0010\u0015\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u0084\u0002", d2 = {"adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "crossed", "", "isStart", "slot", "", "changeOffset", "info", "newOffset", "ensureAtLeastOneChar", "expandOneChar", "isExpanding", "currentRawOffset", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "updateSelectionBoundary", "previousSelectionAnchor", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionAdjustmentKt {
    public static final androidx.compose.foundation.text.selection.Selection access$adjustToBoundaries(androidx.compose.foundation.text.selection.SelectionLayout layout, androidx.compose.foundation.text.selection.BoundaryFunction boundaryFunction) {
        return SelectionAdjustmentKt.adjustToBoundaries(layout, boundaryFunction);
    }

    public static final androidx.compose.foundation.text.selection.Selection.AnchorInfo access$snapToWordBoundary(androidx.compose.foundation.text.selection.SelectableInfo $receiver, int currentLine, int currentOffset, int otherOffset, boolean isStart, boolean crossed) {
        return SelectionAdjustmentKt.snapToWordBoundary($receiver, currentLine, currentOffset, otherOffset, isStart, crossed);
    }

    public static final androidx.compose.foundation.text.selection.Selection.AnchorInfo access$updateSelectionBoundary(androidx.compose.foundation.text.selection.SelectionLayout $receiver, androidx.compose.foundation.text.selection.SelectableInfo info, androidx.compose.foundation.text.selection.Selection.AnchorInfo previousSelectionAnchor) {
        return SelectionAdjustmentKt.updateSelectionBoundary($receiver, info, previousSelectionAnchor);
    }

    public static final int access$updateSelectionBoundary$lambda$0(Lazy $currentRawLine$delegate) {
        return SelectionAdjustmentKt.updateSelectionBoundary$lambda$0($currentRawLine$delegate);
    }

    private static final androidx.compose.foundation.text.selection.Selection adjustToBoundaries(androidx.compose.foundation.text.selection.SelectionLayout layout, androidx.compose.foundation.text.selection.BoundaryFunction boundaryFunction) {
        int i;
        int i2 = 1;
        int i3 = 0;
        i = layout.getCrossStatus() == CrossStatus.CROSSED ? i2 : i3;
        Selection selection = new Selection(SelectionAdjustmentKt.anchorOnBoundary(layout.getStartInfo(), i, i2, layout.getStartSlot(), boundaryFunction), SelectionAdjustmentKt.anchorOnBoundary(layout.getEndInfo(), i, i3, layout.getEndSlot(), boundaryFunction), i);
        return selection;
    }

    private static final androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorOnBoundary(androidx.compose.foundation.text.selection.SelectableInfo $this$anchorOnBoundary, boolean crossed, boolean isStart, int slot, androidx.compose.foundation.text.selection.BoundaryFunction boundaryFunction) {
        int rawStartHandleOffset;
        int start-impl;
        if (isStart != 0) {
            rawStartHandleOffset = $this$anchorOnBoundary.getRawStartHandleOffset();
        } else {
            rawStartHandleOffset = $this$anchorOnBoundary.getRawEndHandleOffset();
        }
        if (slot != $this$anchorOnBoundary.getSlot()) {
            return $this$anchorOnBoundary.anchorForOffset(rawStartHandleOffset);
        }
        final int i = 0;
        long $this$anchorOnBoundary_u24lambda_u242 = boundaryFunction.getBoundary-fzxv0v0($this$anchorOnBoundary, rawStartHandleOffset);
        if (isStart ^ crossed != 0) {
            start-impl = TextRange.getStart-impl($this$anchorOnBoundary_u24lambda_u242);
        } else {
            start-impl = TextRange.getEnd-impl($this$anchorOnBoundary_u24lambda_u242);
        }
        return $this$anchorOnBoundary.anchorForOffset(start-impl);
    }

    private static final androidx.compose.foundation.text.selection.Selection.AnchorInfo changeOffset(androidx.compose.foundation.text.selection.Selection.AnchorInfo $this$changeOffset, androidx.compose.foundation.text.selection.SelectableInfo info, int newOffset) {
        return Selection.AnchorInfo.copy$default($this$changeOffset, info.getTextLayoutResult().getBidiRunDirection(newOffset), newOffset, 0, obj5, 4);
    }

    public static final androidx.compose.foundation.text.selection.Selection ensureAtLeastOneChar(androidx.compose.foundation.text.selection.Selection $this$ensureAtLeastOneChar, androidx.compose.foundation.text.selection.SelectionLayout layout) {
        int previousSelection;
        int i;
        if (!SelectionLayoutKt.isCollapsed($this$ensureAtLeastOneChar, layout)) {
            return $this$ensureAtLeastOneChar;
        }
        if (layout.getSize() <= 1 && layout.getPreviousSelection() != null) {
            if (layout.getPreviousSelection() != null) {
                if ((CharSequence)layout.getCurrentInfo().getInputText().length() == 0) {
                } else {
                    i = 0;
                }
                if (i != 0) {
                }
                return SelectionAdjustmentKt.expandOneChar($this$ensureAtLeastOneChar, layout);
            }
        }
        return $this$ensureAtLeastOneChar;
    }

    private static final androidx.compose.foundation.text.selection.Selection expandOneChar(androidx.compose.foundation.text.selection.Selection $this$expandOneChar, androidx.compose.foundation.text.selection.SelectionLayout layout) {
        int followingBreak;
        androidx.compose.foundation.text.selection.Selection $this$expandOneChar2;
        int i2;
        int changeOffset;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo changeOffset2;
        int i4;
        int i3;
        int i5;
        int i;
        androidx.compose.foundation.text.selection.Selection obj12;
        final androidx.compose.foundation.text.selection.SelectableInfo currentInfo = layout.getCurrentInfo();
        final String inputText = currentInfo.getInputText();
        final int rawStartHandleOffset = currentInfo.getRawStartHandleOffset();
        final int length = inputText.length();
        int i6 = 0;
        if (rawStartHandleOffset == null) {
            followingBreak = StringHelpers_androidKt.findFollowingBreak(inputText, i6);
            if (layout.isStartHandle()) {
                changeOffset = $this$expandOneChar;
                obj12 = Selection.copy$default(changeOffset, SelectionAdjustmentKt.changeOffset($this$expandOneChar.getStart(), currentInfo, followingBreak), 0, true, 2, 0);
                $this$expandOneChar2 = changeOffset;
            } else {
                $this$expandOneChar2 = $this$expandOneChar;
                obj12 = Selection.copy$default($this$expandOneChar2, 0, SelectionAdjustmentKt.changeOffset($this$expandOneChar2.getEnd(), currentInfo, followingBreak), false, 1, 0);
            }
        } else {
            $this$expandOneChar2 = $this$expandOneChar;
            if (rawStartHandleOffset == length) {
                obj12 = StringHelpers_androidKt.findPrecedingBreak(inputText, length);
                if (layout.isStartHandle()) {
                    obj12 = followingBreak;
                } else {
                    obj12 = Selection.copy$default($this$expandOneChar2, 0, SelectionAdjustmentKt.changeOffset($this$expandOneChar2.getEnd(), currentInfo, obj12), true, 1, 0);
                }
            } else {
                obj12 = layout.getPreviousSelection();
                i2 = 1;
                if (obj12 != null && obj12.getHandlesCrossed() == i2) {
                    i2 = 1;
                    i4 = obj12.getHandlesCrossed() == i2 ? i2 : i6;
                } else {
                }
                if (obj12 ^= i4 != 0) {
                    obj12 = StringHelpers_androidKt.findPrecedingBreak(inputText, rawStartHandleOffset);
                } else {
                    obj12 = StringHelpers_androidKt.findFollowingBreak(inputText, rawStartHandleOffset);
                }
                if (layout.isStartHandle()) {
                    obj12 = followingBreak;
                } else {
                    obj12 = followingBreak;
                }
            }
        }
        return obj12;
    }

    private static final boolean isExpanding(androidx.compose.foundation.text.selection.SelectableInfo $this$isExpanding, int currentRawOffset, boolean isStart) {
        int i2;
        int i;
        int rawPreviousHandleOffset;
        i = 1;
        if ($this$isExpanding.getRawPreviousHandleOffset() == -1) {
            return i;
        }
        int i4 = 0;
        if (currentRawOffset == $this$isExpanding.getRawPreviousHandleOffset()) {
            return i4;
        }
        i2 = $this$isExpanding.getRawCrossStatus() == CrossStatus.CROSSED ? i : i4;
        if (isStart ^ i2 != 0) {
            if (currentRawOffset < $this$isExpanding.getRawPreviousHandleOffset()) {
            } else {
                i = i4;
            }
        } else {
            if (currentRawOffset > $this$isExpanding.getRawPreviousHandleOffset()) {
            } else {
                i = i4;
            }
        }
        return i;
    }

    private static final androidx.compose.foundation.text.selection.Selection.AnchorInfo snapToWordBoundary(androidx.compose.foundation.text.selection.SelectableInfo $this$snapToWordBoundary, int currentLine, int currentOffset, int otherOffset, boolean isStart, boolean crossed) {
        int lineStart;
        int i5;
        int lineEnd$default;
        int i3;
        int i;
        int i4;
        int i6;
        int i2;
        long wordBoundary--jx7JFs = $this$snapToWordBoundary.getTextLayoutResult().getWordBoundary--jx7JFs(currentOffset);
        if ($this$snapToWordBoundary.getTextLayoutResult().getLineForOffset(TextRange.getStart-impl(wordBoundary--jx7JFs)) == currentLine) {
            lineStart = TextRange.getStart-impl(wordBoundary--jx7JFs);
        } else {
            if (currentLine >= $this$snapToWordBoundary.getTextLayoutResult().getLineCount()) {
                lineStart = $this$snapToWordBoundary.getTextLayoutResult().getLineStart(lineCount2--);
            } else {
                lineStart = $this$snapToWordBoundary.getTextLayoutResult().getLineStart(currentLine);
            }
        }
        if ($this$snapToWordBoundary.getTextLayoutResult().getLineForOffset(TextRange.getEnd-impl(wordBoundary--jx7JFs)) == currentLine) {
            lineEnd$default = TextRange.getEnd-impl(wordBoundary--jx7JFs);
        } else {
            i3 = 0;
            i4 = 2;
            i6 = 0;
            if (currentLine >= $this$snapToWordBoundary.getTextLayoutResult().getLineCount()) {
                lineEnd$default = TextLayoutResult.getLineEnd$default($this$snapToWordBoundary.getTextLayoutResult(), lineCount4--, i6, i4, i3);
            } else {
                lineEnd$default = TextLayoutResult.getLineEnd$default($this$snapToWordBoundary.getTextLayoutResult(), currentLine, i6, i4, i3);
            }
        }
        if (lineStart == otherOffset) {
            return $this$snapToWordBoundary.anchorForOffset(lineEnd$default);
        }
        if (lineEnd$default == otherOffset) {
            return $this$snapToWordBoundary.anchorForOffset(lineStart);
        }
        if (isStart ^ crossed != 0) {
            if (currentOffset <= lineEnd$default) {
                i = lineStart;
            } else {
                i = lineEnd$default;
            }
        } else {
            if (currentOffset >= lineStart) {
            } else {
            }
        }
        return $this$snapToWordBoundary.anchorForOffset(i);
    }

    private static final androidx.compose.foundation.text.selection.Selection.AnchorInfo updateSelectionBoundary(androidx.compose.foundation.text.selection.SelectionLayout $this$updateSelectionBoundary, androidx.compose.foundation.text.selection.SelectableInfo info, androidx.compose.foundation.text.selection.Selection.AnchorInfo previousSelectionAnchor) {
        int rawStartHandleOffset2;
        int startSlot;
        int rawStartHandleOffset;
        int i;
        int start-impl;
        if ($this$updateSelectionBoundary.isStartHandle()) {
            rawStartHandleOffset2 = info.getRawStartHandleOffset();
        } else {
            rawStartHandleOffset2 = info.getRawEndHandleOffset();
        }
        final int i2 = rawStartHandleOffset2;
        if ($this$updateSelectionBoundary.isStartHandle()) {
            startSlot = $this$updateSelectionBoundary.getStartSlot();
        } else {
            startSlot = $this$updateSelectionBoundary.getEndSlot();
        }
        if (startSlot != info.getSlot()) {
            return info.anchorForOffset(i2);
        }
        SelectionAdjustmentKt.updateSelectionBoundary.currentRawLine.2 anon2 = new SelectionAdjustmentKt.updateSelectionBoundary.currentRawLine.2(info, i2);
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon2);
        if ($this$updateSelectionBoundary.isStartHandle()) {
            i = rawStartHandleOffset;
        } else {
            i = rawStartHandleOffset;
        }
        final androidx.compose.foundation.text.selection.SelectionLayout selectionLayout = $this$updateSelectionBoundary;
        androidx.compose.foundation.text.selection.SelectableInfo selectableInfo = info;
        SelectionAdjustmentKt.updateSelectionBoundary.anchorSnappedToWordBoundary.2 anon = new SelectionAdjustmentKt.updateSelectionBoundary.anchorSnappedToWordBoundary.2(selectableInfo, i2, i, selectionLayout, lazy);
        final Lazy obj11 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
        final long selectableId2 = previousSelectionAnchor.getSelectableId();
        if (Long.compare(selectableId, selectableId2) != 0) {
            return SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(obj11);
        }
        int obj12 = selectableInfo.getRawPreviousHandleOffset();
        if (i2 == obj12) {
            return previousSelectionAnchor;
        }
        if (SelectionAdjustmentKt.updateSelectionBoundary$lambda$0(lazy) != selectableInfo.getTextLayoutResult().getLineForOffset(obj12)) {
            return SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(obj11);
        }
        int offset = previousSelectionAnchor.getOffset();
        long wordBoundary--jx7JFs = selectableInfo.getTextLayoutResult().getWordBoundary--jx7JFs(offset);
        if (!SelectionAdjustmentKt.isExpanding(selectableInfo, i2, selectionLayout.isStartHandle())) {
            return selectableInfo.anchorForOffset(i2);
        }
        if (offset != TextRange.getStart-impl(wordBoundary--jx7JFs) && offset == TextRange.getEnd-impl(wordBoundary--jx7JFs)) {
            if (offset == TextRange.getEnd-impl(wordBoundary--jx7JFs)) {
            }
            return selectableInfo.anchorForOffset(i2);
        }
        return SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(obj11);
    }

    private static final int updateSelectionBoundary$lambda$0(Lazy<Integer> $currentRawLine$delegate) {
        return (Number)$currentRawLine$delegate.getValue().intValue();
    }

    private static final androidx.compose.foundation.text.selection.Selection.AnchorInfo updateSelectionBoundary$lambda$1(Lazy<androidx.compose.foundation.text.selection.Selection.AnchorInfo> $anchorSnappedToWordBoundary$delegate) {
        return (Selection.AnchorInfo)$anchorSnappedToWordBoundary$delegate.getValue();
    }
}
