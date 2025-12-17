package androidx.compose.ui.text.input;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.")
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0008\u0010\u001e\u001a\u00020\u0007H\u0016J\u0008\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000cH\u0016J\u0008\u0010\"\u001a\u00020\u001cH\u0016J\u0012\u0010#\u001a\u00020\u00072\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000c2\u0008\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00072\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u00072\u0008\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u000cH\u0016J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000c2\u0006\u00104\u001a\u00020\u000cH\u0016J\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000c2\u0006\u00104\u001a\u00020\u000cH\u0016J\u0008\u00106\u001a\u00020\u0007H\u0016J\u0008\u00107\u001a\u00020\u0007H\u0002J\u0017\u00108\u001a\u00020\u00072\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u001c0:H\u0082\u0008J\u0008\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020\u000c2\u0006\u0010=\u001a\u00020\u000cH\u0016J\u001a\u0010>\u001a\u00020?2\u0008\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010)\u001a\u00020\u000cH\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u0004\u0018\u0001002\u0006\u0010)\u001a\u00020\u000cH\u0016J\u0018\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\u000c2\u0006\u0010)\u001a\u00020\u000cH\u0016J\u0018\u0010G\u001a\u0002002\u0006\u0010F\u001a\u00020\u000c2\u0006\u0010)\u001a\u00020\u000cH\u0016J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u000cH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u000cH\u0016J\u001c\u0010O\u001a\u00020\u00072\u0008\u0010P\u001a\u0004\u0018\u00010J2\u0008\u0010Q\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u000cH\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u000cH\u0002J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u000c2\u0006\u0010]\u001a\u00020\u000cH\u0016J\u001a\u0010^\u001a\u00020\u00072\u0008\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u000cH\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u000c2\u0006\u0010]\u001a\u00020\u000cH\u0016J\u0016\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006d", d2 = {"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getAutoCorrect", "()Z", "batchDepth", "", "currentExtractedTextRequestToken", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "extractedTextMonitorMode", "isActive", "value", "mTextFieldValue", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "addEditCommandWithBatch", "", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "ensureActive", "block", "Lkotlin/Function0;", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecordingInputConnection implements InputConnection {

    public static final int $stable = 8;
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List<androidx.compose.ui.text.input.EditCommand> editCommands;
    private final androidx.compose.ui.text.input.InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive = true;
    private androidx.compose.ui.text.input.TextFieldValue mTextFieldValue;
    static {
        final int i = 8;
    }

    public RecordingInputConnection(androidx.compose.ui.text.input.TextFieldValue initState, androidx.compose.ui.text.input.InputEventCallback2 eventCallback, boolean autoCorrect) {
        super();
        this.eventCallback = eventCallback;
        this.autoCorrect = autoCorrect;
        this.mTextFieldValue = initState;
        ArrayList arrayList = new ArrayList();
        this.editCommands = (List)arrayList;
        int i = 1;
    }

    private final void addEditCommandWithBatch(androidx.compose.ui.text.input.EditCommand editCommand) {
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
        List mutableList;
        this.batchDepth = batchDepth--;
        if (this.batchDepth == 0 && !(Collection)this.editCommands.isEmpty()) {
            if (!(Collection)this.editCommands.isEmpty()) {
                this.eventCallback.onEditCommands(CollectionsKt.toMutableList((Collection)this.editCommands));
                this.editCommands.clear();
            }
        }
        i = this.batchDepth > 0 ? 1 : 0;
        return i;
    }

    private final boolean ensureActive(Function0<Unit> block) {
        final int i = 0;
        final boolean isActive = this.isActive;
        final int i2 = 0;
        if (isActive) {
            block.invoke();
        }
        return isActive;
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
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return beginBatchEditInternal();
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return 0;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        int i = 0;
        this.batchDepth = i;
        this.isActive = i;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return 0;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return 0;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return this.autoCorrect;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(java.lang.CharSequence text, int newCursorPosition) {
        int i;
        androidx.compose.ui.text.input.CommitTextCommand commitTextCommand;
        String valueOf;
        final int i2 = 0;
        final boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            i = 0;
            commitTextCommand = new CommitTextCommand(String.valueOf(text), newCursorPosition);
            addEditCommandWithBatch((EditCommand)commitTextCommand);
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            DeleteSurroundingTextCommand deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(beforeLength, afterLength);
            addEditCommandWithBatch((EditCommand)deleteSurroundingTextCommand);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = new DeleteSurroundingTextInCodePointsCommand(beforeLength, afterLength);
            addEditCommandWithBatch((EditCommand)deleteSurroundingTextInCodePointsCommand);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            FinishComposingTextCommand finishComposingTextCommand = new FinishComposingTextCommand();
            addEditCommandWithBatch((EditCommand)finishComposingTextCommand);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        return TextUtils.getCapsMode((CharSequence)this.mTextFieldValue.getText(), TextRange.getMin-impl(this.mTextFieldValue.getSelection-d9O1mEE()), reqModes);
    }

    @Override // android.view.inputmethod.InputConnection
    public final androidx.compose.ui.text.input.InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        int i;
        int token;
        i = flags & 1 != 0 ? 1 : token;
        this.extractedTextMonitorMode = i;
        if (this.extractedTextMonitorMode && request != null) {
            if (request != null) {
                token = request.token;
            }
            this.currentExtractedTextRequestToken = token;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final androidx.compose.ui.text.input.TextFieldValue getMTextFieldValue$ui_release() {
        return this.mTextFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getSelectedText(int flags) {
        int string;
        if (TextRange.getCollapsed-impl(this.mTextFieldValue.getSelection-d9O1mEE())) {
            string = 0;
        } else {
            string = TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
        }
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getTextAfterCursor(int maxChars, int flags) {
        return (CharSequence)TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public java.lang.CharSequence getTextBeforeCursor(int maxChars, int flags) {
        return (CharSequence)TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        int setSelectionCommand;
        int length;
        final int i2 = 0;
        boolean isActive = obj.isActive;
        final int i4 = 0;
        if (isActive) {
            int i3 = 0;
            final int i5 = 0;
            switch (id) {
                case 16908319:
                    setSelectionCommand = new SetSelectionCommand(i5, this.mTextFieldValue.getText().length());
                    addEditCommandWithBatch((EditCommand)setSelectionCommand);
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
            return i5;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int previous-eUduSuo;
        String str;
        final int i = 0;
        boolean isActive = obj2.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            switch (editorAction) {
                case 0:
                    previous-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
                    break;
                case 1:
                    StringBuilder stringBuilder = new StringBuilder();
                    Log.w("RecordingIC", stringBuilder.append("IME sends unsupported Editor Action: ").append(editorAction).toString());
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
            this.eventCallback.onImeAction-KlQnJC8(previous-eUduSuo);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        int i7;
        int includeInsertionMarker;
        int sDK_INT;
        int includeCharacterBounds;
        int i3;
        int includeEditorBounds;
        int includeLineBounds;
        int includeLineBounds2;
        int i;
        int i5;
        int i4;
        int sDK_INT2;
        int i2;
        int i6;
        final int i8 = 0;
        boolean isActive = obj.isActive;
        final int i10 = 0;
        if (isActive) {
            int i9 = 0;
            sDK_INT = 0;
            final int i13 = 1;
            i7 = cursorUpdateMode & 1 != 0 ? i13 : sDK_INT;
            i3 = cursorUpdateMode & 2 != 0 ? i13 : sDK_INT;
            if (Build.VERSION.SDK_INT >= 33) {
                i = cursorUpdateMode & 16 != 0 ? i13 : sDK_INT;
                includeInsertionMarker = i;
                i5 = cursorUpdateMode & 8 != 0 ? i13 : sDK_INT;
                includeCharacterBounds = i5;
                i4 = cursorUpdateMode & 4 != 0 ? i13 : sDK_INT;
                int includeEditorBounds2 = i4;
                int i20 = 34;
                if (Build.VERSION.SDK_INT >= i20 && cursorUpdateMode & 32 != 0) {
                    if (cursorUpdateMode & 32 != 0) {
                        sDK_INT = i13;
                    }
                    includeLineBounds = sDK_INT;
                }
                if (includeInsertionMarker == 0 && includeCharacterBounds == 0 && includeEditorBounds2 == 0 && includeLineBounds == 0) {
                    if (includeCharacterBounds == 0) {
                        if (includeEditorBounds2 == 0) {
                            if (includeLineBounds == 0) {
                                includeInsertionMarker = 1;
                                includeCharacterBounds = 1;
                                int includeEditorBounds3 = 1;
                                if (Build.VERSION.SDK_INT >= i20) {
                                    i2 = includeEditorBounds3;
                                    i6 = includeLineBounds3;
                                    includeEditorBounds = includeInsertionMarker;
                                    includeLineBounds2 = includeCharacterBounds;
                                } else {
                                    i2 = includeEditorBounds3;
                                    i6 = includeLineBounds;
                                    includeEditorBounds = includeInsertionMarker;
                                    includeLineBounds2 = includeCharacterBounds;
                                }
                            } else {
                                i2 = includeEditorBounds2;
                                i6 = includeLineBounds;
                                includeEditorBounds = includeInsertionMarker;
                                includeLineBounds2 = includeCharacterBounds;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
                i2 = i15;
                i6 = includeLineBounds;
                includeEditorBounds = includeInsertionMarker;
                includeLineBounds2 = includeCharacterBounds;
            }
            this.eventCallback.onRequestCursorAnchorInfo(i7, i3, includeEditorBounds, includeLineBounds2, i2, i6);
            return i13;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            this.eventCallback.onKeyEvent(event);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        int i;
        androidx.compose.ui.text.input.SetComposingRegionCommand setComposingRegionCommand;
        final int i2 = 0;
        final boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            i = 0;
            setComposingRegionCommand = new SetComposingRegionCommand(start, end);
            addEditCommandWithBatch((EditCommand)setComposingRegionCommand);
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(java.lang.CharSequence text, int newCursorPosition) {
        int i;
        androidx.compose.ui.text.input.SetComposingTextCommand setComposingTextCommand;
        String valueOf;
        final int i2 = 0;
        final boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            i = 0;
            setComposingTextCommand = new SetComposingTextCommand(String.valueOf(text), newCursorPosition);
            addEditCommandWithBatch((EditCommand)setComposingTextCommand);
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void setMTextFieldValue$ui_release(androidx.compose.ui.text.input.TextFieldValue value) {
        this.mTextFieldValue = value;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        final int i = 0;
        boolean isActive = obj.isActive;
        final int i3 = 0;
        if (isActive) {
            int i2 = 0;
            SetSelectionCommand setSelectionCommand = new SetSelectionCommand(start, end);
            addEditCommandWithBatch((EditCommand)setSelectionCommand);
            return 1;
        }
        return isActive;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void updateInputState(androidx.compose.ui.text.input.TextFieldValue state, androidx.compose.ui.text.input.InputMethodManager inputMethodManager) {
        boolean extractedTextMonitorMode;
        int min-impl;
        ExtractedText extractedText;
        int max-impl;
        long unbox-impl;
        if (!this.isActive) {
        }
        setMTextFieldValue$ui_release(state);
        if (this.extractedTextMonitorMode) {
            inputMethodManager.updateExtractedText(this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(state));
        }
        TextRange composition-MzsxiRA = state.getComposition-MzsxiRA();
        if (composition-MzsxiRA != null) {
            min-impl = TextRange.getMin-impl(composition-MzsxiRA.unbox-impl());
        } else {
            min-impl = max-impl;
        }
        TextRange composition-MzsxiRA2 = state.getComposition-MzsxiRA();
        if (composition-MzsxiRA2 != null) {
            max-impl = TextRange.getMax-impl(composition-MzsxiRA2.unbox-impl());
        }
        inputMethodManager.updateSelection(TextRange.getMin-impl(state.getSelection-d9O1mEE()), TextRange.getMax-impl(state.getSelection-d9O1mEE()), min-impl, max-impl);
    }
}
