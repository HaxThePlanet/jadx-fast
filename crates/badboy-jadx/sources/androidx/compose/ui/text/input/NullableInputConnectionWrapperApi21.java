package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0012\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0010\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\u0012\u0010\u0012\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0006\u0010\u001f\u001a\u00020\u0006J\u0008\u0010 \u001a\u00020\u000cH\u0016J\u0008\u0010!\u001a\u00020\u000cH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010#\u001a\u00020$2\u0008\u0010\u000e\u001a\u0004\u0018\u00010%2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010+\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010-\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u00010.2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010/\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000cH\u0016J\u0010\u00100\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u00101\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u00104\u001a\u00020\u000c2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u00105\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0003@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "getDelegate", "()Landroid/view/inputmethod/InputConnection;", "beginBatchEdit", "", "clearMetaKeyStates", "p0", "", "closeConnection", "closeDelegate", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "Landroid/view/inputmethod/InputContentInfo;", "p1", "p2", "Landroid/os/Bundle;", "commitCorrection", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "deleteSurroundingText", "deleteSurroundingTextInCodePoints", "disposeDelegate", "endBatchEdit", "finishComposingText", "getCursorCapsMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "getTextBeforeCursor", "performContextMenuAction", "performEditorAction", "performPrivateCommand", "", "reportFullscreenMode", "requestCursorUpdates", "sendKeyEvent", "Landroid/view/KeyEvent;", "setComposingRegion", "setComposingText", "setSelection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
class NullableInputConnectionWrapperApi21 implements androidx.compose.ui.text.input.NullableInputConnectionWrapper {

    private InputConnection delegate;
    private final Function1<androidx.compose.ui.text.input.NullableInputConnectionWrapper, Unit> onConnectionClosed;
    public NullableInputConnectionWrapperApi21(InputConnection delegate, Function1<? super androidx.compose.ui.text.input.NullableInputConnectionWrapper, Unit> onConnectionClosed) {
        super();
        this.onConnectionClosed = onConnectionClosed;
        this.delegate = delegate;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean beginBatchEdit() {
        boolean beginBatchEdit;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            beginBatchEdit = delegate.beginBatchEdit();
        } else {
            beginBatchEdit = 0;
        }
        return beginBatchEdit;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean clearMetaKeyStates(int p0) {
        boolean clearMetaKeyStates;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            clearMetaKeyStates = delegate.clearMetaKeyStates(p0);
        } else {
            clearMetaKeyStates = 0;
        }
        return clearMetaKeyStates;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public final void closeConnection() {
        int i;
        Function1 onConnectionClosed;
        if (this.delegate != null) {
            i = 0;
            disposeDelegate();
            this.onConnectionClosed.invoke(this);
        }
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    protected void closeDelegate(InputConnection delegate) {
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean commitCompletion(CompletionInfo p0) {
        boolean commitCompletion;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            commitCompletion = delegate.commitCompletion(p0);
        } else {
            commitCompletion = 0;
        }
        return commitCompletion;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean commitContent(InputContentInfo p0, int p1, Bundle p2) {
        return 0;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean commitCorrection(CorrectionInfo p0) {
        boolean commitCorrection;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            commitCorrection = delegate.commitCorrection(p0);
        } else {
            commitCorrection = 0;
        }
        return commitCorrection;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean commitText(java.lang.CharSequence p0, int p1) {
        boolean commitText;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            commitText = delegate.commitText(p0, p1);
        } else {
            commitText = 0;
        }
        return commitText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean deleteSurroundingText(int p0, int p1) {
        boolean surroundingText;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            surroundingText = delegate.deleteSurroundingText(p0, p1);
        } else {
            surroundingText = 0;
        }
        return surroundingText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean deleteSurroundingTextInCodePoints(int p0, int p1) {
        return 0;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public final void disposeDelegate() {
        int i2;
        int i;
        final InputConnection delegate = this.delegate;
        if (delegate != null) {
            i2 = 0;
            closeDelegate(delegate);
            this.delegate = 0;
        }
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean endBatchEdit() {
        boolean endBatchEdit;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            endBatchEdit = delegate.endBatchEdit();
        } else {
            endBatchEdit = 0;
        }
        return endBatchEdit;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean finishComposingText() {
        boolean finishComposingText;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            finishComposingText = delegate.finishComposingText();
        } else {
            finishComposingText = 0;
        }
        return finishComposingText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public int getCursorCapsMode(int p0) {
        int cursorCapsMode;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            cursorCapsMode = delegate.getCursorCapsMode(p0);
        } else {
            cursorCapsMode = 0;
        }
        return cursorCapsMode;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    protected final InputConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public ExtractedText getExtractedText(ExtractedTextRequest p0, int p1) {
        ExtractedText extractedText;
        extractedText = this.delegate;
        if (extractedText != null) {
            if (extractedText.getExtractedText(p0, p1) == null) {
                extractedText = new ExtractedText();
            }
        } else {
        }
        return extractedText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public Handler getHandler() {
        return null;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public java.lang.CharSequence getSelectedText(int p0) {
        Object selectedText;
        selectedText = this.delegate;
        if (selectedText != null) {
            if (selectedText.getSelectedText(p0) == null) {
                selectedText = "";
            }
        } else {
        }
        return selectedText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public java.lang.CharSequence getTextAfterCursor(int p0, int p1) {
        java.lang.CharSequence textAfterCursor;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            textAfterCursor = delegate.getTextAfterCursor(p0, p1);
        } else {
            textAfterCursor = 0;
        }
        return textAfterCursor;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public java.lang.CharSequence getTextBeforeCursor(int p0, int p1) {
        java.lang.CharSequence textBeforeCursor;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            textBeforeCursor = delegate.getTextBeforeCursor(p0, p1);
        } else {
            textBeforeCursor = 0;
        }
        return textBeforeCursor;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean performContextMenuAction(int p0) {
        boolean contextMenuAction;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            contextMenuAction = delegate.performContextMenuAction(p0);
        } else {
            contextMenuAction = 0;
        }
        return contextMenuAction;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean performEditorAction(int p0) {
        boolean editorAction;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            editorAction = delegate.performEditorAction(p0);
        } else {
            editorAction = 0;
        }
        return editorAction;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean performPrivateCommand(String p0, Bundle p1) {
        boolean privateCommand;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            privateCommand = delegate.performPrivateCommand(p0, p1);
        } else {
            privateCommand = 0;
        }
        return privateCommand;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean reportFullscreenMode(boolean p0) {
        boolean reportFullscreenMode;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            reportFullscreenMode = delegate.reportFullscreenMode(p0);
        } else {
            reportFullscreenMode = 0;
        }
        return reportFullscreenMode;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean requestCursorUpdates(int p0) {
        boolean requestCursorUpdates;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            requestCursorUpdates = delegate.requestCursorUpdates(p0);
        } else {
            requestCursorUpdates = 0;
        }
        return requestCursorUpdates;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean sendKeyEvent(KeyEvent p0) {
        boolean sendKeyEvent;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            sendKeyEvent = delegate.sendKeyEvent(p0);
        } else {
            sendKeyEvent = 0;
        }
        return sendKeyEvent;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean setComposingRegion(int p0, int p1) {
        boolean composingRegion;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            composingRegion = delegate.setComposingRegion(p0, p1);
        } else {
            composingRegion = 0;
        }
        return composingRegion;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean setComposingText(java.lang.CharSequence p0, int p1) {
        boolean composingText;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            composingText = delegate.setComposingText(p0, p1);
        } else {
            composingText = 0;
        }
        return composingText;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public boolean setSelection(int p0, int p1) {
        boolean selection;
        InputConnection delegate = this.delegate;
        if (delegate != null) {
            selection = delegate.setSelection(p0, p1);
        } else {
            selection = 0;
        }
        return selection;
    }
}
