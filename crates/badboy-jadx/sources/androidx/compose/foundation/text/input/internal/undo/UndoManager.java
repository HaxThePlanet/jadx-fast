package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 \u001d*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001\u001dB/\u0012\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u000b\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bR\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "T", "", "initialUndoStack", "", "initialRedoStack", "capacity", "", "(Ljava/util/List;Ljava/util/List;I)V", "canRedo", "", "getCanRedo$foundation_release", "()Z", "canUndo", "getCanUndo$foundation_release", "redoStack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "size", "getSize", "()I", "undoStack", "clearHistory", "", "record", "undoableAction", "(Ljava/lang/Object;)V", "redo", "()Ljava/lang/Object;", "undo", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UndoManager<T>  {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.text.input.internal.undo.UndoManager.Companion Companion;
    private final int capacity;
    private SnapshotStateList<T> redoStack;
    private SnapshotStateList<T> undoStack;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u00020\u00010\u0004\"\u0006\u0008\u0001\u0010\u0006\u0018\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\u0008¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/text/input/internal/undo/UndoManager$Companion;", "", "()V", "createSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "T", "itemSaver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <T> Saver<androidx.compose.foundation.text.input.internal.undo.UndoManager<T>, Object> createSaver(Saver<T, Object> itemSaver) {
            final int i = 0;
            Intrinsics.needClassReification();
            UndoManager.Companion.createSaver.1 anon = new UndoManager.Companion.createSaver.1(itemSaver);
            return (Saver)anon;
        }
    }
    static {
        UndoManager.Companion companion = new UndoManager.Companion(0);
        UndoManager.Companion = companion;
        int i = 8;
    }

    public UndoManager() {
        super(0, 0, 0, 7, 0);
    }

    public UndoManager(List<? extends T> initialUndoStack, List<? extends T> initialRedoStack, int capacity) {
        int i;
        int i2;
        super();
        this.capacity = capacity;
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        int i5 = 0;
        snapshotStateList.addAll((Collection)initialUndoStack);
        this.undoStack = snapshotStateList;
        SnapshotStateList snapshotStateList2 = new SnapshotStateList();
        int i6 = 0;
        snapshotStateList2.addAll((Collection)initialRedoStack);
        this.redoStack = snapshotStateList2;
        int i7 = 0;
        i = this.capacity >= 0 ? i2 : i7;
        if (i == 0) {
        } else {
            if (getSize() <= this.capacity) {
            } else {
                i2 = i7;
            }
            if (i2 == 0) {
            } else {
            }
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Initial list of undo and redo operations have a size=(").append(getSize()).append(") greater than the given capacity=(").append(this.capacity).append(").").toString().toString());
            throw illegalArgumentException;
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireUndoManager$1 = new IllegalArgumentException("Capacity must be a positive integer".toString());
        throw $i$a$RequireUndoManager$1;
    }

    public UndoManager(List list, List list2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        List obj1;
        List obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj1 = CollectionsKt.emptyList();
        }
        if (i4 & 2 != 0) {
            obj2 = CollectionsKt.emptyList();
        }
        obj3 = i4 &= 4 != 0 ? 100 : obj3;
        super(obj1, obj2, obj3);
    }

    public static final int access$getCapacity$p(androidx.compose.foundation.text.input.internal.undo.UndoManager $this) {
        return $this.capacity;
    }

    public static final SnapshotStateList access$getRedoStack$p(androidx.compose.foundation.text.input.internal.undo.UndoManager $this) {
        return $this.redoStack;
    }

    public static final SnapshotStateList access$getUndoStack$p(androidx.compose.foundation.text.input.internal.undo.UndoManager $this) {
        return $this.undoStack;
    }

    public final void clearHistory() {
        this.undoStack.clear();
        this.redoStack.clear();
    }

    public final boolean getCanRedo$foundation_release() {
        return empty ^= 1;
    }

    public final boolean getCanUndo$foundation_release() {
        return empty ^= 1;
    }

    public final int getSize() {
        return size += size2;
    }

    public final void record(T undoableAction) {
        SnapshotStateList redoStack;
        int i;
        this.redoStack.clear();
        while (getSize() > capacity--) {
            CollectionsKt.removeFirst((List)this.undoStack);
        }
        this.undoStack.add(undoableAction);
    }

    public final T redo() {
        if (!getCanRedo$foundation_release()) {
        } else {
            Object last = CollectionsKt.removeLast((List)this.redoStack);
            this.undoStack.add(last);
            return last;
        }
        int topOperation = 0;
        IllegalStateException $i$a$CheckUndoManager$redo$1 = new IllegalStateException("It's an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.".toString());
        throw $i$a$CheckUndoManager$redo$1;
    }

    public final T undo() {
        if (!getCanUndo$foundation_release()) {
        } else {
            Object last = CollectionsKt.removeLast((List)this.undoStack);
            this.redoStack.add(last);
            return last;
        }
        int topOperation = 0;
        IllegalStateException $i$a$CheckUndoManager$undo$1 = new IllegalStateException("It's an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.".toString());
        throw $i$a$CheckUndoManager$undo$1;
    }
}
