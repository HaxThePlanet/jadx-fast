package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.OffsetMapping.Companion;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0014\u0008\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ!\u0010+\u001a\u00020\u00172\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0008.H\u0002J\u0018\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201ø\u0001\u0000¢\u0006\u0004\u00082\u00103J\u001c\u00104\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\u00086\u00107J\u000c\u00108\u001a\u00020\u0017*\u000209H\u0002J\u0012\u00108\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u0002090:H\u0002R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u0018\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006;", d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEditable", "()Z", "I", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getSingleLine", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "process", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "apply", "Landroidx/compose/ui/text/input/EditCommand;", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKeyInput {

    public static final int $stable = 8;
    private final boolean editable;
    private final int imeAction;
    private final androidx.compose.foundation.text.DeadKeyCombiner keyCombiner;
    private final androidx.compose.foundation.text.KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final androidx.compose.foundation.text.LegacyTextFieldState state;
    private final androidx.compose.foundation.text.UndoManager undoManager;
    private final TextFieldValue value;
    static {
        final int i = 8;
    }

    private TextFieldKeyInput(androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldSelectionManager selectionManager, TextFieldValue value, boolean editable, boolean singleLine, TextPreparedSelectionState preparedSelectionState, OffsetMapping offsetMapping, androidx.compose.foundation.text.UndoManager undoManager, androidx.compose.foundation.text.DeadKeyCombiner keyCombiner, androidx.compose.foundation.text.KeyMapping keyMapping, Function1<? super TextFieldValue, Unit> onValueChange, int imeAction) {
        super();
        this.state = state;
        this.selectionManager = selectionManager;
        this.value = value;
        this.editable = editable;
        this.singleLine = singleLine;
        this.preparedSelectionState = preparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = keyCombiner;
        this.keyMapping = keyMapping;
        this.onValueChange = onValueChange;
        this.imeAction = imeAction;
    }

    public TextFieldKeyInput(androidx.compose.foundation.text.LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager2, TextFieldValue textFieldValue3, boolean z4, boolean z5, TextPreparedSelectionState textPreparedSelectionState6, OffsetMapping offsetMapping7, androidx.compose.foundation.text.UndoManager undoManager8, androidx.compose.foundation.text.DeadKeyCombiner deadKeyCombiner9, androidx.compose.foundation.text.KeyMapping keyMapping10, Function1 function111, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker14) {
        int iNSTANCE;
        int i8;
        int i2;
        int identity;
        int i10;
        int platformDefaultKeyMapping;
        TextFieldValue textFieldValue;
        int i7;
        int i6;
        TextFieldValue field;
        int i9;
        int i3;
        int i4;
        int i;
        OffsetMapping map2;
        int i5;
        androidx.compose.foundation.text.KeyMapping map;
        androidx.compose.foundation.text.TextFieldKeyInput.1 field2;
        int i11 = i13;
        if (i11 & 4 != 0) {
            textFieldValue = new TextFieldValue(0, 0, obj5, 0, 7, 0);
            field = textFieldValue;
        } else {
            field = textFieldValue3;
        }
        i3 = i11 & 8 != 0 ? i8 : z4;
        i = i11 & 16 != 0 ? i2 : z5;
        if (i11 & 64 != 0) {
            map2 = identity;
        } else {
            map2 = offsetMapping7;
        }
        i5 = i11 & 128 != 0 ? i10 : undoManager8;
        if (i11 & 512 != 0) {
            map = platformDefaultKeyMapping;
        } else {
            map = keyMapping10;
        }
        if (i11 &= 1024 != 0) {
            field2 = iNSTANCE;
        } else {
            field2 = function111;
        }
        super(legacyTextFieldState, textFieldSelectionManager2, field, i3, i, textPreparedSelectionState6, map2, i5, deadKeyCombiner9, map, field2, i12, 0);
    }

    public TextFieldKeyInput(androidx.compose.foundation.text.LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager2, TextFieldValue textFieldValue3, boolean z4, boolean z5, TextPreparedSelectionState textPreparedSelectionState6, OffsetMapping offsetMapping7, androidx.compose.foundation.text.UndoManager undoManager8, androidx.compose.foundation.text.DeadKeyCombiner deadKeyCombiner9, androidx.compose.foundation.text.KeyMapping keyMapping10, Function1 function111, int i12, DefaultConstructorMarker defaultConstructorMarker13) {
        super(legacyTextFieldState, textFieldSelectionManager2, textFieldValue3, z4, z5, textPreparedSelectionState6, offsetMapping7, undoManager8, deadKeyCombiner9, keyMapping10, function111, i12);
    }

    public static final void access$apply(androidx.compose.foundation.text.TextFieldKeyInput $this, EditCommand $receiver) {
        $this.apply($receiver);
    }

    public static final void access$apply(androidx.compose.foundation.text.TextFieldKeyInput $this, List $receiver) {
        $this.apply($receiver);
    }

    public static final int access$getImeAction$p(androidx.compose.foundation.text.TextFieldKeyInput $this) {
        return $this.imeAction;
    }

    public static final Function1 access$getOnValueChange$p(androidx.compose.foundation.text.TextFieldKeyInput $this) {
        return $this.onValueChange;
    }

    private final void apply(EditCommand $this$apply) {
        apply(CollectionsKt.listOf($this$apply));
    }

    private final void apply(List<? extends EditCommand> $this$apply) {
        List mutableList = CollectionsKt.toMutableList((Collection)$this$apply);
        final int i = 0;
        FinishComposingTextCommand finishComposingTextCommand = new FinishComposingTextCommand();
        mutableList.add(0, finishComposingTextCommand);
        this.onValueChange.invoke(this.state.getProcessor().apply(mutableList));
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> block) {
        boolean onValueChange;
        Object annotatedString;
        annotatedString = this.offsetMapping;
        final TextPreparedSelectionState preparedSelectionState = this.preparedSelectionState;
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, annotatedString, this.state.getLayoutResult(), preparedSelectionState);
        block.invoke(textFieldPreparedSelection);
        if (TextRange.equals-impl0(textFieldPreparedSelection.getSelection-d9O1mEE(), annotatedString)) {
            if (!Intrinsics.areEqual(textFieldPreparedSelection.getAnnotatedString(), this.value.getAnnotatedString())) {
                this.onValueChange.invoke(textFieldPreparedSelection.getValue());
            }
        } else {
        }
    }

    private final CommitTextCommand typedCommand-ZmokQxo(KeyEvent event) {
        int i = 0;
        if (!TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(event)) {
            return i;
        }
        Integer consume-ZmokQxo = this.keyCombiner.consume-ZmokQxo(event);
        if (consume-ZmokQxo != null) {
            StringBuilder stringBuilder = new StringBuilder();
            CommitTextCommand commitTextCommand = new CommitTextCommand(StringHelpers_jvmKt.appendCodePointX(stringBuilder, consume-ZmokQxo.intValue()).toString(), 1);
            return commitTextCommand;
        }
        return i;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final androidx.compose.foundation.text.LegacyTextFieldState getState() {
        return this.state;
    }

    public final androidx.compose.foundation.text.UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean process-ZmokQxo(KeyEvent event) {
        int i;
        int preparedSelectionState;
        int keyDown-CS__XNY;
        CommitTextCommand typedCommand-ZmokQxo = typedCommand-ZmokQxo(event);
        preparedSelectionState = 0;
        if (typedCommand-ZmokQxo != null) {
            int i2 = 0;
            if (this.editable) {
                apply((EditCommand)typedCommand-ZmokQxo);
                this.preparedSelectionState.resetCachedX();
            } else {
                i = preparedSelectionState;
            }
            return i;
        }
        if (!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(event), KeyEventType.Companion.getKeyDown-CS__XNY())) {
            return preparedSelectionState;
        }
        androidx.compose.foundation.text.KeyCommand map-ZmokQxo = this.keyMapping.map-ZmokQxo(event);
        if (map-ZmokQxo != null) {
            if (map-ZmokQxo.getEditsText() && !this.editable) {
                if (!this.editable) {
                } else {
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    TextFieldKeyInput.process.2 anon = new TextFieldKeyInput.process.2(map-ZmokQxo, this, booleanRef);
                    commandExecutionContext((Function1)anon);
                    androidx.compose.foundation.text.UndoManager undoManager = this.undoManager;
                    if (undoManager != null) {
                        undoManager.forceNextSnapshot();
                    }
                }
            } else {
            }
            return booleanRef.element;
        }
        return preparedSelectionState;
    }
}
