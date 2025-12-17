package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0005H\u0016J\u0008\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/input/CommitTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "text", "", "newCursorPosition", "", "(Ljava/lang/String;I)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommitTextCommand implements androidx.compose.ui.text.input.EditCommand {

    public static final int $stable;
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;
    static {
    }

    public CommitTextCommand(AnnotatedString annotatedString, int newCursorPosition) {
        super();
        this.annotatedString = annotatedString;
        this.newCursorPosition = newCursorPosition;
    }

    public CommitTextCommand(String text, int newCursorPosition) {
        AnnotatedString annotatedString = new AnnotatedString(text, 0, 0, 6, 0);
        super(annotatedString, newCursorPosition);
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(androidx.compose.ui.text.input.EditingBuffer buffer) {
        int compositionStart$ui_text_release;
        int compositionEnd$ui_text_release;
        int i;
        String length;
        if (buffer.hasComposition$ui_text_release()) {
            buffer.replace$ui_text_release(buffer.getCompositionStart$ui_text_release(), buffer.getCompositionEnd$ui_text_release(), getText());
        } else {
            buffer.replace$ui_text_release(buffer.getSelectionStart$ui_text_release(), buffer.getSelectionEnd$ui_text_release(), getText());
        }
        int cursor$ui_text_release = buffer.getCursor$ui_text_release();
        if (this.newCursorPosition > 0) {
            i3--;
        } else {
            i2 -= length;
        }
        buffer.setCursor$ui_text_release(RangesKt.coerceIn(i, 0, buffer.getLength$ui_text_release()));
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof CommitTextCommand) {
            return i2;
        }
        if (!Intrinsics.areEqual(getText(), (CommitTextCommand)other.getText())) {
            return i2;
        }
        if (this.newCursorPosition != obj2.newCursorPosition) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final String getText() {
        return this.annotatedString.getText();
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public int hashCode() {
        return i2 += newCursorPosition;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CommitTextCommand(text='").append(getText()).append("', newCursorPosition=").append(this.newCursorPosition).append(')').toString();
    }
}
