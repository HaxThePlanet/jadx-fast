package androidx.compose.foundation.text.input;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u0017\u0010\u0005\u001a\u00020\u00068F¢\u0006\u000c\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068F¢\u0006\u000c\u0012\u0004\u0008\u000c\u0010\u0008\u001a\u0004\u0008\r\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/text/input/UndoState;", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "(Landroidx/compose/foundation/text/input/TextFieldState;)V", "canRedo", "", "getCanRedo$annotations", "()V", "getCanRedo", "()Z", "canUndo", "getCanUndo$annotations", "getCanUndo", "clearHistory", "", "redo", "undo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UndoState {

    public static final int $stable;
    private final androidx.compose.foundation.text.input.TextFieldState state;
    static {
    }

    public UndoState(androidx.compose.foundation.text.input.TextFieldState state) {
        super();
        this.state = state;
    }

    public static void getCanRedo$annotations() {
    }

    public static void getCanUndo$annotations() {
    }

    public final void clearHistory() {
        this.state.getTextUndoManager$foundation_release().clearHistory();
    }

    public final boolean getCanRedo() {
        return this.state.getTextUndoManager$foundation_release().getCanRedo();
    }

    public final boolean getCanUndo() {
        return this.state.getTextUndoManager$foundation_release().getCanUndo();
    }

    public final void redo() {
        this.state.getTextUndoManager$foundation_release().redo(this.state);
    }

    public final void undo() {
        this.state.getTextUndoManager$foundation_release().undo(this.state);
    }
}
