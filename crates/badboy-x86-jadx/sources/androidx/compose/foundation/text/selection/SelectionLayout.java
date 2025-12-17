package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u00002\u00020\u0001J\u0016\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00180\"2\u0006\u0010#\u001a\u00020\u0018H&J\u001c\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020%0'H&J\u0012\u0010(\u001a\u00020\u00132\u0008\u0010)\u001a\u0004\u0018\u00010\u0000H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u0012\u0010\u000c\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\tR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u000fR\u0012\u0010\u001d\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\tR\u0012\u0010\u001f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006*À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/selection/SelectionLayout;", "", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "currentInfo", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "getCurrentInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "endSlot", "", "getEndSlot", "()I", "firstInfo", "getFirstInfo", "isStartHandle", "", "()Z", "lastInfo", "getLastInfo", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "startInfo", "getStartInfo", "startSlot", "getStartSlot", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SelectionLayout {
    public abstract LongObjectMap<androidx.compose.foundation.text.selection.Selection> createSubSelections(androidx.compose.foundation.text.selection.Selection selection);

    public abstract void forEachMiddleInfo(Function1<? super androidx.compose.foundation.text.selection.SelectableInfo, Unit> function1);

    public abstract androidx.compose.foundation.text.selection.CrossStatus getCrossStatus();

    public abstract androidx.compose.foundation.text.selection.SelectableInfo getCurrentInfo();

    public abstract androidx.compose.foundation.text.selection.SelectableInfo getEndInfo();

    public abstract int getEndSlot();

    public abstract androidx.compose.foundation.text.selection.SelectableInfo getFirstInfo();

    public abstract androidx.compose.foundation.text.selection.SelectableInfo getLastInfo();

    public abstract androidx.compose.foundation.text.selection.Selection getPreviousSelection();

    public abstract int getSize();

    public abstract androidx.compose.foundation.text.selection.SelectableInfo getStartInfo();

    public abstract int getStartSlot();

    public abstract boolean isStartHandle();

    public abstract boolean shouldRecomputeSelection(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout);
}
