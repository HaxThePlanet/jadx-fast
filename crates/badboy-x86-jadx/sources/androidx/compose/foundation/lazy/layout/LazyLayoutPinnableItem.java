package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainer.PinnedHandle;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0018\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010)\u001a\u00020*J\u0008\u0010+\u001a\u00020\u0002H\u0016J\u0008\u0010,\u001a\u00020*H\u0016R/\u0010\n\u001a\u0004\u0018\u00010\u00012\u0008\u0010\t\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR/\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0008\u0010\t\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008 \u0010\u0010\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010\u00012\u0008\u0010!\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008#\u0010\u000c\"\u0004\u0008$\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010%\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008(\u0010\u0018\u001a\u0004\u0008&\u0010\u0014\"\u0004\u0008'\u0010\u0016¨\u0006-", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnableItem;", "Landroidx/compose/ui/layout/PinnableContainer;", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "key", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "(Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;)V", "<set-?>", "_parentPinnableContainer", "get_parentPinnableContainer", "()Landroidx/compose/ui/layout/PinnableContainer;", "set_parentPinnableContainer", "(Landroidx/compose/ui/layout/PinnableContainer;)V", "_parentPinnableContainer$delegate", "Landroidx/compose/runtime/MutableState;", "", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "getKey", "()Ljava/lang/Object;", "parentHandle", "getParentHandle", "()Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "setParentHandle", "(Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;)V", "parentHandle$delegate", "value", "parentPinnableContainer", "getParentPinnableContainer", "setParentPinnableContainer", "pinsCount", "getPinsCount", "setPinsCount", "pinsCount$delegate", "onDisposed", "", "pin", "release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyLayoutPinnableItem implements PinnableContainer, PinnableContainer.PinnedHandle, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem {

    private final MutableState _parentPinnableContainer$delegate;
    private final MutableIntState index$delegate;
    private final Object key;
    private final MutableState parentHandle$delegate;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItemList;
    private final MutableIntState pinsCount$delegate;
    public LazyLayoutPinnableItem(Object key, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItemList) {
        super();
        this.key = key;
        this.pinnedItemList = pinnedItemList;
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.pinsCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        int i3 = 0;
        final int i4 = 2;
        this.parentHandle$delegate = SnapshotStateKt.mutableStateOf$default(i3, i3, i4, i3);
        this._parentPinnableContainer$delegate = SnapshotStateKt.mutableStateOf$default(i3, i3, i4, i3);
    }

    private final PinnableContainer.PinnedHandle getParentHandle() {
        final int i = 0;
        final int i2 = 0;
        return (PinnableContainer.PinnedHandle)(State)this.parentHandle$delegate.getValue();
    }

    private final int getPinsCount() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.pinsCount$delegate.getIntValue();
    }

    private final PinnableContainer get_parentPinnableContainer() {
        final int i = 0;
        final int i2 = 0;
        return (PinnableContainer)(State)this._parentPinnableContainer$delegate.getValue();
    }

    private final void setParentHandle(PinnableContainer.PinnedHandle <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.parentHandle$delegate.setValue(<set-?>);
    }

    private final void setPinsCount(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.pinsCount$delegate.setIntValue(<set-?>);
    }

    private final void set_parentPinnableContainer(PinnableContainer <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._parentPinnableContainer$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public int getIndex() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.index$delegate.getIntValue();
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public final PinnableContainer getParentPinnableContainer() {
        return get_parentPinnableContainer();
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public final void onDisposed() {
        int i;
        int i2;
        int i3;
        i = 0;
        while (i < getPinsCount()) {
            i2 = i;
            i3 = 0;
            release();
            i++;
        }
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public PinnableContainer.PinnedHandle pin() {
        int pinsCount;
        Object obj;
        if (getPinsCount() == 0) {
            this.pinnedItemList.pin$foundation_release((LazyLayoutPinnedItemList.PinnedItem)this);
            PinnableContainer parentPinnableContainer = getParentPinnableContainer();
            if (parentPinnableContainer != null) {
                pinsCount = parentPinnableContainer.pin();
            } else {
                pinsCount = 0;
            }
            setParentHandle(pinsCount);
        }
        setPinsCount(pinsCount2++);
        return (PinnableContainer.PinnedHandle)this;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public void release() {
        int i;
        int pinsCount;
        Object obj;
        i = getPinsCount() > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            setPinsCount(pinsCount3--);
            this.pinnedItemList.release$foundation_release((LazyLayoutPinnedItemList.PinnedItem)this);
            PinnableContainer.PinnedHandle parentHandle = getParentHandle();
            if (getPinsCount() == 0 && parentHandle != null) {
                this.pinnedItemList.release$foundation_release((LazyLayoutPinnedItemList.PinnedItem)this);
                parentHandle = getParentHandle();
                if (parentHandle != null) {
                    parentHandle.release();
                }
                setParentHandle(0);
            }
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Release should only be called once".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public void setIndex(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.index$delegate.setIntValue(<set-?>);
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public final void setParentPinnableContainer(PinnableContainer value) {
        int i;
        int readObserver;
        int parentHandle;
        final Snapshot.Companion companion = Snapshot.Companion;
        final int i2 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = i;
        }
        final int i3 = 0;
        set_parentPinnableContainer(value);
        parentHandle = getParentHandle();
        if (value != get_parentPinnableContainer() && getPinsCount() > 0 && parentHandle != null) {
            set_parentPinnableContainer(value);
            if (getPinsCount() > 0) {
                parentHandle = getParentHandle();
                if (parentHandle != null) {
                    parentHandle.release();
                }
                if (value != null) {
                    i = value.pin();
                }
                setParentHandle(i);
            }
        }
        Unit iNSTANCE = Unit.INSTANCE;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
    }
}
