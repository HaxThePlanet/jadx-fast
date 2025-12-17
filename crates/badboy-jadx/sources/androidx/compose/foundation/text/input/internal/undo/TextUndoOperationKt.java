package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006", d2 = {"redo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undo", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextUndoOperationKt {
    public static final void redo(TextFieldState $this$redo, androidx.compose.foundation.text.input.internal.undo.TextUndoOperation op) {
        final TextFieldState field = $this$redo;
        final int i = 0;
        field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release2 = field.getMainBuffer$foundation_release();
        int i2 = 0;
        index2 += length;
        String postText = op.getPostText();
        mainBuffer$foundation_release2.replace(op.getIndex(), i4, (CharSequence)postText);
        mainBuffer$foundation_release2.setSelection(TextRange.getStart-impl(op.getPostSelection-d9O1mEE()), TextRange.getEnd-impl(op.getPostSelection-d9O1mEE()));
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)field.getMainBuffer$foundation_release().toString(), field.getMainBuffer$foundation_release().getSelection-d9O1mEE(), obj9, field.getMainBuffer$foundation_release().getComposition-MzsxiRA(), 0, 8, 0);
        TextFieldState.access$updateValueAndNotifyListeners(field, field.getValue$foundation_release(), textFieldCharSequence, true);
    }

    public static final void undo(TextFieldState $this$undo, androidx.compose.foundation.text.input.internal.undo.TextUndoOperation op) {
        final TextFieldState field = $this$undo;
        final int i = 0;
        field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release2 = field.getMainBuffer$foundation_release();
        int i2 = 0;
        index2 += length;
        String preText = op.getPreText();
        mainBuffer$foundation_release2.replace(op.getIndex(), i4, (CharSequence)preText);
        mainBuffer$foundation_release2.setSelection(TextRange.getStart-impl(op.getPreSelection-d9O1mEE()), TextRange.getEnd-impl(op.getPreSelection-d9O1mEE()));
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)field.getMainBuffer$foundation_release().toString(), field.getMainBuffer$foundation_release().getSelection-d9O1mEE(), obj9, field.getMainBuffer$foundation_release().getComposition-MzsxiRA(), 0, 8, 0);
        TextFieldState.access$updateValueAndNotifyListeners(field, field.getValue$foundation_release(), textFieldCharSequence, true);
    }
}
