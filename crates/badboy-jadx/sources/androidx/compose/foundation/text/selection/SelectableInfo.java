package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0000J\u0008\u0010/\u001a\u00020\u0011H\u0016R\u0014\u0010\u000c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010#\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008$\u0010\u0019¨\u00060", d2 = {"Landroidx/compose/foundation/text/selection/SelectableInfo;", "", "selectableId", "", "slot", "", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "(JIIIILandroidx/compose/ui/text/TextLayoutResult;)V", "endRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getEndRunDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "inputText", "", "getInputText", "()Ljava/lang/String;", "rawCrossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getRawCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "getRawEndHandleOffset", "()I", "getRawPreviousHandleOffset", "getRawStartHandleOffset", "getSelectableId", "()J", "getSlot", "startRunDirection", "getStartRunDirection", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "textLength", "getTextLength", "anchorForOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "offset", "makeSingleLayoutSelection", "Landroidx/compose/foundation/text/selection/Selection;", "start", "end", "shouldRecomputeSelection", "", "other", "toString", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableInfo {

    public static final int $stable;
    private final int rawEndHandleOffset;
    private final int rawPreviousHandleOffset;
    private final int rawStartHandleOffset;
    private final long selectableId;
    private final int slot;
    private final TextLayoutResult textLayoutResult;
    static {
        SelectableInfo.$stable = TextLayoutResult.$stable;
    }

    public SelectableInfo(long selectableId, int slot, int rawStartHandleOffset, int rawEndHandleOffset, int rawPreviousHandleOffset, TextLayoutResult textLayoutResult) {
        super();
        this.selectableId = selectableId;
        this.slot = rawStartHandleOffset;
        this.rawStartHandleOffset = rawEndHandleOffset;
        this.rawEndHandleOffset = rawPreviousHandleOffset;
        this.rawPreviousHandleOffset = textLayoutResult;
        this.textLayoutResult = obj7;
    }

    private final ResolvedTextDirection getEndRunDirection() {
        return SelectionLayoutKt.access$getTextDirectionForOffset(this.textLayoutResult, this.rawEndHandleOffset);
    }

    private final ResolvedTextDirection getStartRunDirection() {
        return SelectionLayoutKt.access$getTextDirectionForOffset(this.textLayoutResult, this.rawStartHandleOffset);
    }

    public final androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorForOffset(int offset) {
        Selection.AnchorInfo anchorInfo = new Selection.AnchorInfo(SelectionLayoutKt.access$getTextDirectionForOffset(this.textLayoutResult, offset), offset, this.selectableId, obj3);
        return anchorInfo;
    }

    public final String getInputText() {
        return this.textLayoutResult.getLayoutInput().getText().getText();
    }

    public final androidx.compose.foundation.text.selection.CrossStatus getRawCrossStatus() {
        androidx.compose.foundation.text.selection.CrossStatus nOT_CROSSED;
        int rawEndHandleOffset;
        nOT_CROSSED = this.rawStartHandleOffset < this.rawEndHandleOffset ? CrossStatus.NOT_CROSSED : rawStartHandleOffset2 > rawEndHandleOffset ? CrossStatus.CROSSED : CrossStatus.COLLAPSED;
        return nOT_CROSSED;
    }

    public final int getRawEndHandleOffset() {
        return this.rawEndHandleOffset;
    }

    public final int getRawPreviousHandleOffset() {
        return this.rawPreviousHandleOffset;
    }

    public final int getRawStartHandleOffset() {
        return this.rawStartHandleOffset;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }

    public final int getTextLength() {
        return getInputText().length();
    }

    public final androidx.compose.foundation.text.selection.Selection makeSingleLayoutSelection(int start, int end) {
        int i;
        i = start > end ? 1 : 0;
        Selection selection = new Selection(anchorForOffset(start), anchorForOffset(end), i);
        return selection;
    }

    public final boolean shouldRecomputeSelection(androidx.compose.foundation.text.selection.SelectableInfo other) {
        int rawStartHandleOffset;
        int i;
        int rawStartHandleOffset2;
        if (Long.compare(selectableId, selectableId2) == 0 && this.rawStartHandleOffset == other.rawStartHandleOffset) {
            if (this.rawStartHandleOffset == other.rawStartHandleOffset) {
                if (this.rawEndHandleOffset != other.rawEndHandleOffset) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 45;
        return stringBuilder.append("SelectionInfo(id=").append(this.selectableId).append(", range=(").append(this.rawStartHandleOffset).append(i).append(getStartRunDirection()).append(',').append(this.rawEndHandleOffset).append(i).append(getEndRunDirection()).append("), prevOffset=").append(this.rawPreviousHandleOffset).append(')').toString();
    }
}
