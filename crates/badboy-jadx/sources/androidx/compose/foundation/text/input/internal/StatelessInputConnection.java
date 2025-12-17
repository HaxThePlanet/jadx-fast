package androidx.compose.foundation.text.input.internal;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import androidx.core.view.inputmethod.InputConnectionCompat;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008*\u0001\u0013\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0019\u001a\u00020\u00102\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0008\u0011H\u0002J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0008H\u0016J\u0008\u0010 \u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u00020\u001c2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00082\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001c2\u0008\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001c2\u0008\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0018\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00082\u0006\u00101\u001a\u00020\u0008H\u0016J\u0018\u00102\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00082\u0006\u00101\u001a\u00020\u0008H\u0016J\u0008\u00103\u001a\u00020\u001cH\u0016J\u0008\u00104\u001a\u00020\u001cH\u0002J\u0008\u00105\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\u00082\u0006\u00107\u001a\u00020\u0008H\u0016J\u001a\u00108\u001a\u0002092\u0008\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010&\u001a\u00020\u0008H\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020\u0008H\u0016J\u0018\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u00082\u0006\u0010&\u001a\u00020\u0008H\u0016J\u0018\u0010A\u001a\u00020-2\u0006\u0010@\u001a\u00020\u00082\u0006\u0010&\u001a\u00020\u0008H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u0008H\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0008H\u0016J$\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020K2\u0008\u0010L\u001a\u0004\u0018\u00010M2\u0008\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u001c\u0010P\u001a\u00020\u001c2\u0008\u0010Q\u001a\u0004\u0018\u00010D2\u0008\u0010R\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010S\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020T2\u0008\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\u001cH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u0008H\u0016J\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010_\u001a\u00020\u0008H\u0002J\u0018\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00082\u0006\u0010b\u001a\u00020\u0008H\u0016J\u001a\u0010c\u001a\u00020\u001c2\u0008\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0018\u0010d\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00082\u0006\u0010b\u001a\u00020\u0008H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\n\u0010\u000bR%\u0010\u000c\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\u0008\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006e", d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "performPrivateCommand", "action", "data", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StatelessInputConnection implements InputConnection {

    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    private final MutableVector<Function1<androidx.compose.foundation.text.input.internal.EditingBuffer, Unit>> editCommands;
    private final androidx.compose.foundation.text.input.internal.TextInputSession session;
    private final androidx.compose.foundation.text.input.internal.StatelessInputConnection.terminalInputConnection.1 terminalInputConnection;
    static {
        final int i = 8;
    }

    public StatelessInputConnection(androidx.compose.foundation.text.input.internal.TextInputSession session, EditorInfo editorInfo) {
        super();
        this.session = session;
        int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new Function1[16], 0);
        this.editCommands = mutableVector;
        StatelessInputConnection.terminalInputConnection.1 anon = new StatelessInputConnection.terminalInputConnection.1(this);
        this.terminalInputConnection = anon;
        StatelessInputConnection.commitContentDelegateInputConnection.1 anon2 = new StatelessInputConnection.commitContentDelegateInputConnection.1(this);
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper((InputConnection)this.terminalInputConnection, editorInfo, (InputConnectionCompat.OnCommitContentListener)anon2);
    }

    public static final MutableVector access$getEditCommands$p(androidx.compose.foundation.text.input.internal.StatelessInputConnection $this) {
        return $this.editCommands;
    }

    public static final androidx.compose.foundation.text.input.internal.TextInputSession access$getSession$p(androidx.compose.foundation.text.input.internal.StatelessInputConnection $this) {
        return $this.session;
    }

    public static final TextFieldCharSequence access$getText(androidx.compose.foundation.text.input.internal.StatelessInputConnection $this) {
        return $this.getText();
    }

    public static final void access$logDebug(androidx.compose.foundation.text.input.internal.StatelessInputConnection $this, String message) {
        $this.logDebug(message);
    }

    private final void addEditCommandWithBatch(Function1<? super androidx.compose.foundation.text.input.internal.EditingBuffer, Unit> editCommand) {
        beginBatchEditInternal();
        this.editCommands.add(editCommand);
        endBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        final int i2 = 1;
        this.batchDepth = batchDepth += i2;
        return i2;
    }

    private final boolean endBatchEditInternal() {
        int editCommands;
        int i;
        androidx.compose.foundation.text.input.internal.StatelessInputConnection.endBatchEditInternal.1 anon;
        this.batchDepth = batchDepth--;
        if (this.batchDepth == 0 && this.editCommands.isNotEmpty()) {
            if (this.editCommands.isNotEmpty()) {
                anon = new StatelessInputConnection.endBatchEditInternal.1(this);
                this.session.requestEdit((Function1)anon);
                this.editCommands.clear();
            }
        }
        i = this.batchDepth > 0 ? 1 : 0;
        return i;
    }

    private static void getCommitContentDelegateInputConnection$annotations() {
    }

    private final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    private final void logDebug(String message) {
    }

    private final void sendSynthesizedKeyEvent(int code) {
        KeyEvent keyEvent = new KeyEvent(0, code);
        sendKeyEvent(keyEvent);
        KeyEvent keyEvent2 = new KeyEvent(1, code);
        sendKeyEvent(keyEvent2);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("clearMetaKeyStates(").append(states).append(')').toString());
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        java.lang.CharSequence text2;
        StringBuilder stringBuilder = new StringBuilder();
        if (text != null) {
            text2 = text.getText();
        } else {
            text2 = 0;
        }
        logDebug(stringBuilder.append("commitCompletion(").append(text2).append(')').toString());
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", ";
        logDebug(stringBuilder.append("commitContent(").append(inputContentInfo).append(str2).append(flags).append(str2).append(opts).append(')').toString());
        return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, inputContentInfo, flags, opts);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(java.lang.CharSequence text, int newCursorPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("commitText(\"").append(text).append("\", ").append(newCursorPosition).append(')').toString());
        StatelessInputConnection.commitText.1 anon = new StatelessInputConnection.commitText.1(text, newCursorPosition);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("deleteSurroundingText(").append(beforeLength).append(", ").append(afterLength).append(')').toString());
        StatelessInputConnection.deleteSurroundingText.1 anon = new StatelessInputConnection.deleteSurroundingText.1(beforeLength, afterLength);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("deleteSurroundingTextInCodePoints(").append(beforeLength).append(", ").append(afterLength).append(')').toString());
        StatelessInputConnection.deleteSurroundingTextInCodePoints.1 anon = new StatelessInputConnection.deleteSurroundingTextInCodePoints.1(beforeLength, afterLength);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        addEditCommandWithBatch((Function1)StatelessInputConnection.finishComposingText.1.INSTANCE);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("getCursorCapsMode(").append(reqModes).append(')').toString());
        return TextUtils.getCapsMode((CharSequence)getText(), TextRange.getMin-impl(getText().getSelection-d9O1mEE()), reqModes);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("getExtractedText(").append(request).append(", ").append(flags).append(')').toString());
        return StatelessInputConnection_androidKt.access$toExtractedText(getText());
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getSelectedText(int flags) {
        int string;
        if (TextRange.getCollapsed-impl(getText().getSelection-d9O1mEE())) {
            string = 0;
        } else {
            string = TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("getSelectedText(").append(flags).append("): ").append(string).toString());
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getTextAfterCursor(int maxChars, int flags) {
        String string = TextFieldCharSequenceKt.getTextAfterSelection(getText(), maxChars).toString();
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("getTextAfterCursor(").append(maxChars).append(", ").append(flags).append("): ").append(string).toString());
        return (CharSequence)string;
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getTextBeforeCursor(int maxChars, int flags) {
        String string = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), maxChars).toString();
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("getTextBeforeCursor(").append(maxChars).append(", ").append(flags).append("): ").append(string).toString());
        return (CharSequence)string;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        int string;
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("performContextMenuAction(").append(id).append(')').toString());
        switch (id) {
            case 16908319:
                string = new StatelessInputConnection.performContextMenuAction.1(this);
                addEditCommandWithBatch((Function1)string);
                break;
            case 16908320:
                sendSynthesizedKeyEvent(277);
                break;
            case 16908321:
                sendSynthesizedKeyEvent(278);
                break;
            case 16908322:
                sendSynthesizedKeyEvent(279);
                break;
            default:
        }
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int previous-eUduSuo;
        int str;
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("performEditorAction(").append(editorAction).append(')').toString());
        switch (editorAction) {
            case 0:
                previous-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
                break;
            case 1:
                StringBuilder stringBuilder2 = new StringBuilder();
                logDebug(stringBuilder2.append("IME sent an unrecognized editor action: ").append(editorAction).toString());
                previous-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
                break;
            case 2:
                previous-eUduSuo = ImeAction.Companion.getGo-eUduSuo();
                break;
            case 3:
                previous-eUduSuo = ImeAction.Companion.getSearch-eUduSuo();
                break;
            case 4:
                previous-eUduSuo = ImeAction.Companion.getSend-eUduSuo();
                break;
            case 5:
                previous-eUduSuo = ImeAction.Companion.getNext-eUduSuo();
                break;
            case 6:
                previous-eUduSuo = ImeAction.Companion.getDone-eUduSuo();
                break;
            default:
                previous-eUduSuo = ImeAction.Companion.getPrevious-eUduSuo();
        }
        this.session.onImeAction-KlQnJC8(previous-eUduSuo);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture gesture, Executor executor, IntConsumer consumer) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", ";
        logDebug(stringBuilder.append("performHandwritingGesture(").append(gesture).append(str2).append(executor).append(str2).append(consumer).append(')').toString());
        if (Build.VERSION.SDK_INT < 34) {
        }
        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, gesture, executor, consumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("performPrivateCommand(").append(action).append(", ").append(data).append(')').toString());
        return this.commitContentDelegateInputConnection.performPrivateCommand(action, data);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("previewHandwritingGesture(").append(gesture).append(", ").append(cancellationSignal).append(')').toString());
        if (Build.VERSION.SDK_INT < 34) {
            return 0;
        }
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, gesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("reportFullscreenMode(").append(enabled).append(')').toString());
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("requestCursorUpdates(").append(cursorUpdateMode).append(')').toString());
        this.session.requestCursorUpdates(cursorUpdateMode);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("sendKeyEvent(").append(event).append(')').toString());
        this.session.sendKeyEvent(event);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("setComposingRegion(").append(start).append(", ").append(end).append(')').toString());
        StatelessInputConnection.setComposingRegion.1 anon = new StatelessInputConnection.setComposingRegion.1(start, end);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(java.lang.CharSequence text, int newCursorPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("setComposingText(\"").append(text).append("\", ").append(newCursorPosition).append(')').toString());
        StatelessInputConnection.setComposingText.1 anon = new StatelessInputConnection.setComposingText.1(text, newCursorPosition);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        logDebug(stringBuilder.append("setSelection(").append(start).append(", ").append(end).append(')').toString());
        StatelessInputConnection.setSelection.1 anon = new StatelessInputConnection.setSelection.1(start, end);
        addEditCommandWithBatch((Function1)anon);
        return 1;
    }
}
