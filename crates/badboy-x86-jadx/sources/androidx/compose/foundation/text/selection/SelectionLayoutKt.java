package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref.BooleanRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u000c*\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u000c*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"UNASSIGNED_SLOT", "", "getTextFieldSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "previousSelectionRange", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "", "isStartHandle", "getTextFieldSelectionLayout-RcvT-LA", "(Landroidx/compose/ui/text/TextLayoutResult;IIIJZZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "resolve2dDirection", "Landroidx/compose/foundation/text/selection/Direction;", "x", "y", "getTextDirectionForOffset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "isCollapsed", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "isOffsetAnEmptyLine", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionLayoutKt {

    public static final int UNASSIGNED_SLOT = -1;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal3;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[Direction.BEFORE.ordinal()] = 1;
            iArr[Direction.ON.ordinal()] = 2;
            iArr[Direction.AFTER.ordinal()] = 3;
            SelectionLayoutKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final ResolvedTextDirection access$getTextDirectionForOffset(TextLayoutResult $receiver, int offset) {
        return SelectionLayoutKt.getTextDirectionForOffset($receiver, offset);
    }

    private static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult $this$getTextDirectionForOffset, int offset) {
        ResolvedTextDirection paragraphDirection;
        if (SelectionLayoutKt.isOffsetAnEmptyLine($this$getTextDirectionForOffset, offset)) {
            paragraphDirection = $this$getTextDirectionForOffset.getParagraphDirection(offset);
        } else {
            paragraphDirection = $this$getTextDirectionForOffset.getBidiRunDirection(offset);
        }
        return paragraphDirection;
    }

    public static final androidx.compose.foundation.text.selection.SelectionLayout getTextFieldSelectionLayout-RcvT-LA(TextLayoutResult layoutResult, int rawStartHandleOffset, int rawEndHandleOffset, int rawPreviousHandleOffset, long previousSelectionRange, boolean isStartOfSelection, boolean isStartHandle) {
        int selection;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorInfo;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorInfo2;
        boolean reversed-impl;
        int i;
        int end-impl;
        if (isStartHandle) {
            selection = 0;
        } else {
            i = 1;
            anchorInfo = new Selection.AnchorInfo(SelectionLayoutKt.getTextDirectionForOffset(layoutResult, TextRange.getStart-impl(previousSelectionRange)), TextRange.getStart-impl(previousSelectionRange), i, obj5);
            anchorInfo2 = new Selection.AnchorInfo(SelectionLayoutKt.getTextDirectionForOffset(layoutResult, TextRange.getEnd-impl(previousSelectionRange)), TextRange.getEnd-impl(previousSelectionRange), i, obj5);
            selection = new Selection(anchorInfo, anchorInfo2, TextRange.getReversed-impl(previousSelectionRange));
        }
        int i4 = 1;
        SelectableInfo selectableInfo = new SelectableInfo(1, anchorInfo2, i4, rawStartHandleOffset, rawEndHandleOffset, rawPreviousHandleOffset, layoutResult);
        androidx.compose.foundation.text.selection.SingleSelectionLayout singleSelectionLayout = singleSelectionLayout2;
        super(obj17, 1, i4, selection, selectableInfo);
        return (SelectionLayout)singleSelectionLayout;
    }

    public static final boolean isCollapsed(androidx.compose.foundation.text.selection.Selection $this$isCollapsed, androidx.compose.foundation.text.selection.SelectionLayout layout) {
        int i;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start2;
        i = 1;
        if ($this$isCollapsed == null) {
            return i;
        }
        if (layout == null) {
            return i;
        }
        int i2 = 0;
        if (Long.compare(selectableId, selectableId2) == 0) {
            if ($this$isCollapsed.getStart().getOffset() == $this$isCollapsed.getEnd().getOffset()) {
            } else {
                i = i2;
            }
            return i;
        }
        if ($this$isCollapsed.getHandlesCrossed()) {
            start = $this$isCollapsed.getStart();
        } else {
            start = $this$isCollapsed.getEnd();
        }
        if (start.getOffset() != 0) {
            return i2;
        }
        if ($this$isCollapsed.getHandlesCrossed()) {
            start2 = $this$isCollapsed.getEnd();
        } else {
            start2 = $this$isCollapsed.getStart();
        }
        if (layout.getFirstInfo().getTextLength() != start2.getOffset()) {
            return i2;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = i;
        SelectionLayoutKt.isCollapsed.1 anon = new SelectionLayoutKt.isCollapsed.1(booleanRef);
        layout.forEachMiddleInfo((Function1)anon);
        return booleanRef.element;
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult $this$isOffsetAnEmptyLine, int offset) {
        int lineForOffset;
        int i2;
        int i;
        int lineForOffset2;
        i2 = 0;
        final int i3 = 1;
        lineForOffset = (CharSequence)$this$isOffsetAnEmptyLine.getLayoutInput().getText().length() == 0 ? i3 : i2;
        if (lineForOffset == null) {
            lineForOffset = $this$isOffsetAnEmptyLine.getLineForOffset(offset);
            i = 0;
            if (offset != null) {
                if (lineForOffset != $this$isOffsetAnEmptyLine.getLineForOffset(offset + -1)) {
                    if (offset != $this$isOffsetAnEmptyLine.getLayoutInput().getText().length()) {
                        if (lineForOffset != $this$isOffsetAnEmptyLine.getLineForOffset(offset + 1)) {
                            lineForOffset2 = i3;
                        } else {
                            lineForOffset2 = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (lineForOffset2 != 0) {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    public static final androidx.compose.foundation.text.selection.Direction resolve2dDirection(androidx.compose.foundation.text.selection.Direction x, androidx.compose.foundation.text.selection.Direction y) {
        androidx.compose.foundation.text.selection.Direction bEFORE;
        int ordinal;
        switch (i) {
            case 1:
                bEFORE = Direction.BEFORE;
                break;
            case 2:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
                bEFORE = Direction.AFTER;
                bEFORE = Direction.ON;
                bEFORE = Direction.BEFORE;
                break;
            case 3:
                bEFORE = Direction.AFTER;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
        }
        return bEFORE;
    }
}
