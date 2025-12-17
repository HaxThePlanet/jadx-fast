package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0008\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR/\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0008\u0010\r\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text/input/internal/undo/UndoManager;)V", "canRedo", "", "getCanRedo", "()Z", "canUndo", "getCanUndo", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "clearHistory", "", "flush", "record", "op", "redo", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "undo", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextUndoManager {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.text.input.TextUndoManager.Companion Companion;
    private final MutableState stagingUndo$delegate;
    private final UndoManager<TextUndoOperation> undoManager;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion;", "", "()V", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        TextUndoManager.Companion companion = new TextUndoManager.Companion(0);
        TextUndoManager.Companion = companion;
        int i = 8;
    }

    public TextUndoManager() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public TextUndoManager(TextUndoOperation initialStagingUndo, UndoManager<TextUndoOperation> undoManager) {
        super();
        this.undoManager = undoManager;
        int i = 0;
        this.stagingUndo$delegate = SnapshotStateKt.mutableStateOf$default(initialStagingUndo, i, 2, i);
    }

    public TextUndoManager(TextUndoOperation textUndoOperation, UndoManager undoManager2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        UndoManager undoManager;
        int i4;
        int i;
        int i6;
        int i2;
        int i5;
        int obj7;
        UndoManager obj8;
        obj7 = i3 & 1 != 0 ? 0 : obj7;
        if (i3 &= 2 != 0) {
            undoManager = new UndoManager(0, 0, 100, 3, 0);
            obj8 = undoManager;
        }
        super(obj7, obj8);
    }

    public static final TextUndoOperation access$getStagingUndo(androidx.compose.foundation.text.input.TextUndoManager $this) {
        return $this.getStagingUndo();
    }

    public static final UndoManager access$getUndoManager$p(androidx.compose.foundation.text.input.TextUndoManager $this) {
        return $this.undoManager;
    }

    private final void flush() {
        Object companion;
        int i;
        Object currentThreadSnapshot;
        kotlin.jvm.functions.Function1 readObserver;
        companion = Snapshot.Companion;
        i = 0;
        currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        final int i2 = 0;
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = i2;
        }
        final int i3 = 0;
        final TextUndoOperation stagingUndo = getStagingUndo();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        if (stagingUndo != null) {
            i = 0;
            this.undoManager.record(stagingUndo);
        }
        setStagingUndo(i2);
    }

    private final TextUndoOperation getStagingUndo() {
        final int i = 0;
        final int i2 = 0;
        return (TextUndoOperation)(State)this.stagingUndo$delegate.getValue();
    }

    private final void setStagingUndo(TextUndoOperation <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.stagingUndo$delegate.setValue(<set-?>);
    }

    public final void clearHistory() {
        setStagingUndo(0);
        this.undoManager.clearHistory();
    }

    public final boolean getCanRedo() {
        boolean canRedo$foundation_release;
        int i;
        if (this.undoManager.getCanRedo$foundation_release() && getStagingUndo() == null) {
            i = getStagingUndo() == null ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean getCanUndo() {
        int i;
        boolean canUndo$foundation_release;
        if (!this.undoManager.getCanUndo$foundation_release()) {
            if (getStagingUndo() != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final void record(TextUndoOperation op) {
        int readObserver;
        Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        final int i2 = 0;
        final TextUndoOperation stagingUndo = getStagingUndo();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        if (stagingUndo == null) {
            setStagingUndo(op);
        }
        TextUndoOperation merge = TextUndoManagerKt.merge(stagingUndo, op);
        if (merge != null) {
            setStagingUndo(merge);
        }
        flush();
        setStagingUndo(op);
    }

    public final void redo(androidx.compose.foundation.text.input.TextFieldState state) {
        if (!getCanRedo()) {
        }
        TextUndoOperationKt.redo(state, (TextUndoOperation)this.undoManager.redo());
    }

    public final void undo(androidx.compose.foundation.text.input.TextFieldState state) {
        if (!getCanUndo()) {
        }
        flush();
        TextUndoOperationKt.undo(state, (TextUndoOperation)this.undoManager.undo());
    }
}
