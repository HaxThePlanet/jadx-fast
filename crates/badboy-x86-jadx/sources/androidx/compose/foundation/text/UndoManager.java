package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0008\u0010\u0015\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0008J\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "(I)V", "forceNextSnapshot", "", "lastSnapshot", "", "Ljava/lang/Long;", "getMaxStoredCharacters", "()I", "redoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "storedCharacters", "undoStack", "", "makeSnapshot", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "redo", "removeLastUndo", "snapshotIfNeeded", "now", "undo", "Entry", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UndoManager {

    public static final int $stable = 8;
    private boolean forceNextSnapshot;
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    private androidx.compose.foundation.text.UndoManager.Entry redoStack;
    private int storedCharacters;
    private androidx.compose.foundation.text.UndoManager.Entry undoStack;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/text/UndoManager$Entry;", "", "next", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Entry {

        private androidx.compose.foundation.text.UndoManager.Entry next;
        private TextFieldValue value;
        public Entry(androidx.compose.foundation.text.UndoManager.Entry next, TextFieldValue value) {
            super();
            this.next = next;
            this.value = value;
        }

        public Entry(androidx.compose.foundation.text.UndoManager.Entry undoManager$Entry, TextFieldValue textFieldValue2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            int obj1;
            obj1 = i3 &= 1 != 0 ? 0 : obj1;
            super(obj1, textFieldValue2);
        }

        public final androidx.compose.foundation.text.UndoManager.Entry getNext() {
            return this.next;
        }

        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(androidx.compose.foundation.text.UndoManager.Entry <set-?>) {
            this.next = <set-?>;
        }

        public final void setValue(TextFieldValue <set-?>) {
            this.value = <set-?>;
        }
    }
    static {
        final int i = 8;
    }

    public UndoManager() {
        super(0, 1, 0);
    }

    public UndoManager(int maxStoredCharacters) {
        super();
        this.maxStoredCharacters = maxStoredCharacters;
    }

    public UndoManager(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 100000 : obj1;
        super(obj1);
    }

    private final void removeLastUndo() {
        androidx.compose.foundation.text.UndoManager.Entry entry;
        androidx.compose.foundation.text.UndoManager.Entry next;
        entry = this.undoStack;
        final int i = 0;
        if (entry != null) {
            next = entry.getNext();
        } else {
            next = i;
        }
        if (next == null) {
        }
        while (entry != null) {
            next = entry.getNext();
            if (next != null) {
            } else {
            }
            next = i;
            if (next != null) {
            }
            entry = entry.getNext();
            next = next.getNext();
        }
        if (entry == null) {
        } else {
            entry.setNext(i);
        }
    }

    public static void snapshotIfNeeded$default(androidx.compose.foundation.text.UndoManager undoManager, TextFieldValue textFieldValue2, long l3, int i4, Object object5) {
        long obj2;
        if (object5 &= 2 != 0) {
            obj2 = UndoManager_jvmKt.timeNowMillis();
        }
        undoManager.snapshotIfNeeded(textFieldValue2, obj2);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public final void makeSnapshot(TextFieldValue value) {
        TextFieldValue value2;
        String text;
        Object undoStack;
        this.forceNextSnapshot = false;
        androidx.compose.foundation.text.UndoManager.Entry undoStack2 = this.undoStack;
        int i3 = 0;
        if (undoStack2 != null) {
            value2 = undoStack2.getValue();
        } else {
            value2 = i3;
        }
        if (Intrinsics.areEqual(value, value2)) {
        }
        undoStack = this.undoStack;
        undoStack = undoStack.getValue();
        if (undoStack != null && undoStack != null) {
            undoStack = undoStack.getValue();
            if (undoStack != null) {
                text = undoStack.getText();
            } else {
                text = i3;
            }
        } else {
        }
        if (Intrinsics.areEqual(value.getText(), text)) {
            androidx.compose.foundation.text.UndoManager.Entry undoStack4 = this.undoStack;
            if (undoStack4 == null) {
            } else {
                undoStack4.setValue(value);
            }
        }
        UndoManager.Entry entry = new UndoManager.Entry(this.undoStack, value);
        this.undoStack = entry;
        this.redoStack = i3;
        this.storedCharacters = storedCharacters += length;
        if (this.storedCharacters > this.maxStoredCharacters) {
            removeLastUndo();
        }
    }

    public final TextFieldValue redo() {
        TextFieldValue redoEntry;
        int i2;
        int i;
        int length;
        androidx.compose.foundation.text.UndoManager.Entry entry;
        androidx.compose.foundation.text.UndoManager.Entry redoStack = this.redoStack;
        if (redoStack != null) {
            i2 = 0;
            this.redoStack = redoStack.getNext();
            entry = new UndoManager.Entry(this.undoStack, redoStack.getValue());
            this.undoStack = entry;
            this.storedCharacters = storedCharacters += length;
            redoEntry = redoStack.getValue();
        } else {
            redoEntry = 0;
        }
        return redoEntry;
    }

    public final void snapshotIfNeeded(TextFieldValue value, long now) {
        int longValue;
        boolean forceNextSnapshot;
        long l;
        if (!this.forceNextSnapshot) {
            Long lastSnapshot = this.lastSnapshot;
            if (lastSnapshot != null) {
                longValue = lastSnapshot.longValue();
            } else {
                longValue = 0;
            }
            if (Long.compare(now, i) > 0) {
                this.lastSnapshot = Long.valueOf(now);
                makeSnapshot(value);
            }
        } else {
        }
    }

    public final TextFieldValue undo() {
        int value2;
        int i;
        androidx.compose.foundation.text.UndoManager.Entry next;
        TextFieldValue value;
        androidx.compose.foundation.text.UndoManager.Entry redoStack;
        androidx.compose.foundation.text.UndoManager.Entry entry;
        final androidx.compose.foundation.text.UndoManager.Entry undoStack = this.undoStack;
        value2 = 0;
        i = 0;
        next = undoStack.getNext();
        if (undoStack != null && next != null) {
            i = 0;
            next = undoStack.getNext();
            if (next != null) {
                int i2 = 0;
                this.undoStack = next;
                this.storedCharacters = storedCharacters -= length;
                entry = new UndoManager.Entry(this.redoStack, undoStack.getValue());
                this.redoStack = entry;
                value2 = next.getValue();
            }
        }
        return value2;
    }
}
