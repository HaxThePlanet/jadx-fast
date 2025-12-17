package androidx.compose.ui.text.input;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0003H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeleteSurroundingTextCommand implements androidx.compose.ui.text.input.EditCommand {

    public static final int $stable;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;
    static {
    }

    public DeleteSurroundingTextCommand(int lengthBeforeCursor, int lengthAfterCursor) {
        int lengthBeforeCursor2;
        int i;
        super();
        this.lengthBeforeCursor = lengthBeforeCursor;
        this.lengthAfterCursor = lengthAfterCursor;
        if (this.lengthBeforeCursor >= 0 && this.lengthAfterCursor >= 0) {
            i = this.lengthAfterCursor >= 0 ? 1 : 0;
        } else {
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ").append(this.lengthBeforeCursor).append(" and ").append(this.lengthAfterCursor).append(" respectively.").toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(androidx.compose.ui.text.input.EditingBuffer buffer) {
        int result$iv2;
        int length$ui_text_release;
        int result$iv;
        int i;
        int selectionEnd$ui_text_release = buffer.getSelectionEnd$ui_text_release();
        int lengthAfterCursor = this.lengthAfterCursor;
        int i4 = 0;
        result$iv2 = selectionEnd$ui_text_release + lengthAfterCursor;
        if (i6 &= i8 < 0) {
            int i7 = 0;
            result$iv2 = length$ui_text_release;
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd$ui_text_release(), Math.min(result$iv2, buffer.getLength$ui_text_release()));
        int selectionStart$ui_text_release = buffer.getSelectionStart$ui_text_release();
        int lengthBeforeCursor = this.lengthBeforeCursor;
        int i5 = 0;
        int i11 = 0;
        if (i9 &= i10 < 0) {
            i = 0;
            result$iv = i11;
        }
        buffer.delete$ui_text_release(Math.max(i11, result$iv), buffer.getSelectionStart$ui_text_release());
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof DeleteSurroundingTextCommand) {
            return i2;
        }
        if (this.lengthBeforeCursor != obj.lengthBeforeCursor) {
            return i2;
        }
        if (this.lengthAfterCursor != obj2.lengthAfterCursor) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public int hashCode() {
        return i += lengthAfterCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DeleteSurroundingTextCommand(lengthBeforeCursor=").append(this.lengthBeforeCursor).append(", lengthAfterCursor=").append(this.lengthAfterCursor).append(')').toString();
    }
}
