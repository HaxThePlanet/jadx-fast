package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MoveCursorCommand implements androidx.compose.ui.text.input.EditCommand {

    public static final int $stable;
    private final int amount;
    static {
    }

    public MoveCursorCommand(int amount) {
        super();
        this.amount = amount;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(androidx.compose.ui.text.input.EditingBuffer buffer) {
        int selectionStart$ui_text_release;
        int newCursor;
        int i;
        int amount;
        int precedingBreak;
        final int i2 = -1;
        if (buffer.getCursor$ui_text_release() == i2) {
            buffer.setCursor$ui_text_release(buffer.getSelectionStart$ui_text_release());
        }
        newCursor = buffer.getSelectionStart$ui_text_release();
        final String string = buffer.toString();
        if (this.amount > 0) {
            i = 0;
            while (i < this.amount) {
                precedingBreak = JvmCharHelpers_androidKt.findFollowingBreak(string, newCursor);
                if (precedingBreak != i2) {
                }
                newCursor = precedingBreak;
                i++;
            }
        } else {
            i = 0;
            while (i < -amount3) {
                precedingBreak = JvmCharHelpers_androidKt.findPrecedingBreak(string, newCursor);
                if (precedingBreak != i2) {
                }
                newCursor = precedingBreak;
                i++;
            }
        }
        buffer.setCursor$ui_text_release(newCursor);
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof MoveCursorCommand) {
            return i2;
        }
        if (this.amount != obj.amount) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getAmount() {
        return this.amount;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public int hashCode() {
        return this.amount;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MoveCursorCommand(amount=").append(this.amount).append(')').toString();
    }
}
