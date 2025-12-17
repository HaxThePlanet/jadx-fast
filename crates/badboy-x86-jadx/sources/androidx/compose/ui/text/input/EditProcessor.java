package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000c\u001a\u00020\u00082\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00082\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u0008J\u000c\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0008@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EditProcessor {

    public static final int $stable = 8;
    private androidx.compose.ui.text.input.EditingBuffer mBuffer;
    private androidx.compose.ui.text.input.TextFieldValue mBufferState;
    static {
        final int i = 8;
    }

    public EditProcessor() {
        super();
        final int i = 0;
        TextFieldValue textFieldValue = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.getZero-d9O1mEE(), obj3, i, 0);
        this.mBufferState = textFieldValue;
        EditingBuffer editingBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.getSelection-d9O1mEE(), obj3, i);
        this.mBuffer = editingBuffer;
    }

    public static final String access$toStringForLog(androidx.compose.ui.text.input.EditProcessor $this, androidx.compose.ui.text.input.EditCommand $receiver) {
        return $this.toStringForLog($receiver);
    }

    private final String generateBatchErrorMessage(List<? extends androidx.compose.ui.text.input.EditCommand> editCommands, androidx.compose.ui.text.input.EditCommand failedCommand) {
        final Object obj = this;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder append8 = sb.append(stringBuilder2.append("Error while applying EditCommand batch to buffer (length=").append(obj.mBuffer.getLength$ui_text_release()).append(", composition=").append(obj.mBuffer.getComposition-MzsxiRA$ui_text_release()).append(", selection=").append(TextRange.toString-impl(obj.mBuffer.getSelection-d9O1mEE$ui_text_release())).append("):").toString());
        Intrinsics.checkNotNullExpressionValue(append8, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append8.append('\n'), "append('\\n')");
        EditProcessor.generateBatchErrorMessage.1.1 anon = new EditProcessor.generateBatchErrorMessage.1.1(failedCommand, obj);
        CollectionsKt.joinTo$default((Iterable)editCommands, (Appendable)sb, (CharSequence)"\n", 0, 0, 0, 0, (Function1)anon, 60, 0);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final String toStringForLog(androidx.compose.ui.text.input.EditCommand $this$toStringForLog) {
        String string;
        int simpleName;
        int newCursorPosition;
        int length;
        simpleName = 41;
        newCursorPosition = ", newCursorPosition=";
        if ($this$toStringForLog instanceof CommitTextCommand) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("CommitTextCommand(text.length=").append((CommitTextCommand)$this$toStringForLog.getText().length()).append(newCursorPosition).append((CommitTextCommand)$this$toStringForLog.getNewCursorPosition()).append(simpleName).toString();
        } else {
            if ($this$toStringForLog instanceof SetComposingTextCommand) {
                StringBuilder stringBuilder2 = new StringBuilder();
                string = stringBuilder2.append("SetComposingTextCommand(text.length=").append((SetComposingTextCommand)$this$toStringForLog.getText().length()).append(newCursorPosition).append((SetComposingTextCommand)$this$toStringForLog.getNewCursorPosition()).append(simpleName).toString();
            } else {
                if ($this$toStringForLog instanceof SetComposingRegionCommand) {
                    string = $this$toStringForLog.toString();
                } else {
                    if ($this$toStringForLog instanceof DeleteSurroundingTextCommand) {
                        string = $this$toStringForLog.toString();
                    } else {
                        if ($this$toStringForLog instanceof DeleteSurroundingTextInCodePointsCommand) {
                            string = $this$toStringForLog.toString();
                        } else {
                            if ($this$toStringForLog instanceof SetSelectionCommand) {
                                string = $this$toStringForLog.toString();
                            } else {
                                if ($this$toStringForLog instanceof FinishComposingTextCommand) {
                                    string = $this$toStringForLog.toString();
                                } else {
                                    if ($this$toStringForLog instanceof BackspaceCommand) {
                                        string = $this$toStringForLog.toString();
                                    } else {
                                        if ($this$toStringForLog instanceof MoveCursorCommand) {
                                            string = $this$toStringForLog.toString();
                                        } else {
                                            if ($this$toStringForLog instanceof DeleteAllCommand) {
                                                string = $this$toStringForLog.toString();
                                            } else {
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                if (Reflection.getOrCreateKotlinClass($this$toStringForLog.getClass()).getSimpleName() == null) {
                                                    simpleName = "{anonymous EditCommand}";
                                                }
                                                string = stringBuilder3.append("Unknown EditCommand: ").append(simpleName).toString();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return string;
    }

    public final androidx.compose.ui.text.input.TextFieldValue apply(List<? extends androidx.compose.ui.text.input.EditCommand> editCommands) {
        int lastCommand;
        int box-impl;
        int index$iv;
        long l;
        Object obj;
        long unbox-impl;
        int i;
        androidx.compose.ui.text.input.EditingBuffer mBuffer;
        lastCommand = 0;
        List list = editCommands;
        int i3 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            obj = l;
            i = 0;
            lastCommand = obj;
            (EditCommand)obj.applyTo(this.mBuffer);
            index$iv++;
        }
        long selection-d9O1mEE$ui_text_release = this.mBuffer.getSelection-d9O1mEE$ui_text_release();
        int i2 = 0;
        long unbox-impl2 = TextRange.box-impl(selection-d9O1mEE$ui_text_release).unbox-impl();
        int i5 = 0;
        if (!TextRange.getReversed-impl(this.mBufferState.getSelection-d9O1mEE())) {
        } else {
            box-impl = 0;
        }
        try {
            if (box-impl != 0) {
            } else {
            }
            unbox-impl = box-impl.unbox-impl();
            unbox-impl = TextRangeKt.TextRange(TextRange.getMax-impl(selection-d9O1mEE$ui_text_release), TextRange.getMin-impl(selection-d9O1mEE$ui_text_release));
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), unbox-impl, l, this.mBuffer.getComposition-MzsxiRA$ui_text_release(), 0);
            this.mBufferState = textFieldValue;
            return textFieldValue;
            androidx.compose.ui.text.input.EditCommand batchErrorMessage = obj1;
            batchErrorMessage = generateBatchErrorMessage(editCommands, (EditCommand)batchErrorMessage);
            RuntimeException runtimeException = new RuntimeException(batchErrorMessage, (Throwable)th);
            throw runtimeException;
        }
    }

    public final androidx.compose.ui.text.input.EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final androidx.compose.ui.text.input.TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final void reset(androidx.compose.ui.text.input.TextFieldValue value, androidx.compose.ui.text.input.TextInputSession textInputSession) {
        int textChanged;
        int selectionChanged;
        androidx.compose.ui.text.input.EditingBuffer editingBuffer;
        boolean collapsed-impl;
        androidx.compose.ui.text.AnnotatedString annotatedString;
        androidx.compose.ui.text.input.TextFieldValue field;
        long selection-d9O1mEE;
        kotlin.jvm.internal.DefaultConstructorMarker constructor;
        int i;
        int i2;
        int i4;
        int i3;
        androidx.compose.ui.text.input.TextFieldValue obj12;
        textChanged = 0;
        selectionChanged = 0;
        annotatedString = value.getAnnotatedString();
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString(), annotatedString)) {
            editingBuffer = new EditingBuffer(value.getAnnotatedString(), value.getSelection-d9O1mEE(), obj6, 0);
            this.mBuffer = editingBuffer;
            textChanged = 1;
        } else {
            selection-d9O1mEE = value.getSelection-d9O1mEE();
            if (!TextRange.equals-impl0(this.mBufferState.getSelection-d9O1mEE(), annotatedString)) {
                this.mBuffer.setSelection$ui_text_release(TextRange.getMin-impl(value.getSelection-d9O1mEE()), TextRange.getMax-impl(value.getSelection-d9O1mEE()));
                selectionChanged = 1;
            }
        }
        if (value.getComposition-MzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else {
            if (!TextRange.getCollapsed-impl(value.getComposition-MzsxiRA().unbox-impl())) {
                this.mBuffer.setComposition$ui_text_release(TextRange.getMin-impl(value.getComposition-MzsxiRA().unbox-impl()), TextRange.getMax-impl(value.getComposition-MzsxiRA().unbox-impl()));
            }
        }
        if (textChanged == 0) {
            if (selectionChanged == 0 && equal ^= 1 != 0) {
                if (equal ^= 1 != 0) {
                    this.mBuffer.commitComposition$ui_text_release();
                    obj12 = TextFieldValue.copy-3r_uNRQ$default(value, 0, 0, i, 0, 3);
                } else {
                    field = value;
                }
            } else {
            }
        } else {
        }
        this.mBufferState = obj12;
        if (textInputSession != null) {
            textInputSession.updateState(this.mBufferState, obj12);
        }
    }

    public final androidx.compose.ui.text.input.TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}
