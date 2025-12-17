package androidx.compose.foundation.text.input.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import android.view.KeyEvent;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J:\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\n2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\u0008'H\u0082\u0008J\u000c\u0010(\u001a\u00020)*\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006*", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "()V", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "preparedSelectionContext", "state", "isFromSoftKeyboard", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "getVisibleTextLayoutHeight", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class TextFieldKeyEventHandler {

    public static final int $stable = 8;
    private final DeadKeyCombiner deadKeyCombiner;
    private final KeyMapping keyMapping;
    private final TextFieldPreparedSelectionState preparedSelectionState;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal46;
            int ordinal24;
            int ordinal23;
            int ordinal32;
            int ordinal5;
            int ordinal3;
            int ordinal34;
            int ordinal39;
            int ordinal47;
            int ordinal45;
            int ordinal17;
            int ordinal28;
            int ordinal40;
            int ordinal21;
            int ordinal14;
            int ordinal15;
            int ordinal41;
            int ordinal29;
            int ordinal26;
            int ordinal16;
            int ordinal18;
            int ordinal31;
            int ordinal12;
            int ordinal36;
            int ordinal43;
            int ordinal30;
            int ordinal13;
            int ordinal7;
            int ordinal4;
            int ordinal37;
            int ordinal10;
            int ordinal44;
            int ordinal6;
            int ordinal33;
            int ordinal;
            int ordinal19;
            int ordinal48;
            int ordinal27;
            int ordinal11;
            int ordinal2;
            int ordinal8;
            int ordinal42;
            int ordinal9;
            int ordinal25;
            int ordinal20;
            int ordinal22;
            int ordinal38;
            int ordinal35;
            int[] iArr = new int[values.length];
            iArr[KeyCommand.COPY.ordinal()] = 1;
            iArr[KeyCommand.PASTE.ordinal()] = 2;
            iArr[KeyCommand.CUT.ordinal()] = 3;
            iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
                iArr[KeyCommand.DOWN.ordinal()] = 11;
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError e) {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
                iArr[KeyCommand.UNDO.ordinal()] = 46;
                iArr[KeyCommand.REDO.ordinal()] = 47;
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
                TextFieldKeyEventHandler.WhenMappings.$EnumSwitchMapping$0 = iArr;
            }
            iArr[KeyCommand.LINE_END.ordinal()] = 15;
            iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            iArr[KeyCommand.HOME.ordinal()] = 18;
            iArr[KeyCommand.END.ordinal()] = 19;
            iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError e) {
            }
            iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            iArr[KeyCommand.TAB.ordinal()] = 27;
            iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    static {
        final int i = 8;
    }

    public TextFieldKeyEventHandler() {
        super();
        TextFieldPreparedSelectionState textFieldPreparedSelectionState = new TextFieldPreparedSelectionState();
        this.preparedSelectionState = textFieldPreparedSelectionState;
        DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
        this.deadKeyCombiner = deadKeyCombiner;
        this.keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    }

    private final float getVisibleTextLayoutHeight(androidx.compose.foundation.text.input.internal.TextLayoutState $this$getVisibleTextLayoutHeight) {
        LayoutCoordinates textLayoutNodeCoordinates;
        int height-impl;
        boolean it2;
        int $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1;
        LayoutCoordinates decoratorNodeCoordinates;
        boolean it;
        int i;
        textLayoutNodeCoordinates = $this$getVisibleTextLayoutHeight.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            int i2 = 0;
            $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1 = 0;
            if (textLayoutNodeCoordinates.isAttached()) {
            } else {
                textLayoutNodeCoordinates = $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1;
            }
            if (textLayoutNodeCoordinates != 0) {
                decoratorNodeCoordinates = $this$getVisibleTextLayoutHeight.getDecoratorNodeCoordinates();
                if (decoratorNodeCoordinates != null) {
                    i = 0;
                    if (decoratorNodeCoordinates.isAttached()) {
                    } else {
                        decoratorNodeCoordinates = $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1;
                    }
                    if (decoratorNodeCoordinates != null) {
                        $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1 = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, $i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1);
                    } else {
                    }
                } else {
                }
                if ($i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1 != 0) {
                    height-impl = Size.getHeight-impl($i$a$TakeIfTextFieldKeyEventHandler$getVisibleTextLayoutHeight$1.getSize-NH-jbRc());
                } else {
                    height-impl = 2143289344;
                }
            } else {
            }
        } else {
        }
        return height-impl;
    }

    private final void preparedSelectionContext(androidx.compose.foundation.text.input.internal.TransformedTextFieldState state, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, boolean isFromSoftKeyboard, Function1<? super TextFieldPreparedSelection, Unit> block) {
        long selection-d9O1mEE;
        final int i = 0;
        final androidx.compose.foundation.text.input.internal.TransformedTextFieldState field = state;
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(field, textLayoutState.getLayoutResult(), isFromSoftKeyboard, getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
        block.invoke(textFieldPreparedSelection);
        if (!TextRange.equals-impl0(textFieldPreparedSelection.getSelection-d9O1mEE(), obj7)) {
            field.selectCharsIn-5zc-tL8(textFieldPreparedSelection.getSelection-d9O1mEE());
        }
    }

    public boolean onKeyEvent-6ptp14s(KeyEvent event, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, boolean editable, boolean singleLine, Function0<Unit> onSubmit) {
        int this_$iv;
        int obj2;
        int i3;
        KeyEvent mainBuffer$foundation_release;
        boolean selection-d9O1mEE;
        int aRTIFICIAL_FRAME_PACKAGE_NAME;
        boolean typedEvent-ZmokQxo;
        boolean command2;
        int cmp;
        int i13;
        int it;
        int i12;
        int selection-d9O1mEE2;
        boolean editsText;
        int consumed3;
        int consumed;
        int intValue;
        TextFieldPreparedSelection preparedSelection$iv;
        int i6;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState field4;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState field;
        TextFieldState field2;
        androidx.compose.foundation.text.input.InputTransformation inputTransformation;
        TextFieldEditUndoBehavior mergeIfPossible;
        int i4;
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2;
        int i;
        androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState2;
        int i9;
        int ordinal;
        int box-impl;
        Object str2;
        int i8;
        int consumed2;
        KeyCommand command;
        KeyCommand keyCommand;
        TextFieldPreparedSelection field3;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState field5;
        String str;
        long selection-d9O1mEE3;
        int i2;
        int i7;
        int i11;
        int i10;
        Object obj = this;
        mainBuffer$foundation_release = event;
        if (!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(mainBuffer$foundation_release), KeyEventType.Companion.getKeyDown-CS__XNY())) {
            return 0;
        }
        selection-d9O1mEE2 = 1;
        typedEvent-ZmokQxo = obj.deadKeyCombiner.consume-ZmokQxo(mainBuffer$foundation_release);
        if (TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(mainBuffer$foundation_release) && typedEvent-ZmokQxo != null) {
            typedEvent-ZmokQxo = obj.deadKeyCombiner.consume-ZmokQxo(mainBuffer$foundation_release);
            if (typedEvent-ZmokQxo != null) {
                StringBuilder stringBuilder = new StringBuilder(2);
                if (editable) {
                    intValue = textFieldState;
                    i6 = 0;
                    field2 = TransformedTextFieldState.access$getTextFieldState$p(intValue);
                    i4 = 0;
                    field2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
                    mainBuffer$foundation_release2 = field2.getMainBuffer$foundation_release();
                    i = 0;
                    mainBuffer$foundation_release2.commitComposition();
                    EditCommandKt.commitText(mainBuffer$foundation_release2, StringHelpers_jvmKt.appendCodePointX(stringBuilder, typedEvent-ZmokQxo.intValue()).toString(), selection-d9O1mEE2);
                    TextFieldState.access$commitEditAsUser(field2, TransformedTextFieldState.access$getInputTransformation$p(intValue), fromSoftKeyboard-ZmokQxo ^= selection-d9O1mEE2, TextFieldEditUndoBehavior.MergeIfPossible);
                    obj.preparedSelectionState.resetCachedX();
                    i13 = selection-d9O1mEE2;
                } else {
                }
                return i13;
            }
        }
        command2 = obj.keyMapping.map-ZmokQxo(mainBuffer$foundation_release);
        if (command2 != null) {
            if (command2.getEditsText() && !editable) {
                if (!editable) {
                    field = textFieldState;
                    textLayoutState2 = textLayoutState;
                    obj2 = textFieldSelectionState;
                    keyCommand = command2;
                    return 0;
                } else {
                    int i21 = 0;
                    consumed = 1;
                    Object obj3 = this;
                    int i24 = 0;
                    preparedSelection$iv = new TextFieldPreparedSelection(textFieldState, textLayoutState.getLayoutResult(), TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(mainBuffer$foundation_release), obj3.getVisibleTextLayoutHeight(textLayoutState), obj3.preparedSelectionState);
                    TextFieldPreparedSelection field13 = preparedSelection$iv;
                    int i23 = 0;
                    it = -1;
                    box-impl = 0;
                    str2 = "";
                    switch (i9) {
                        case 1:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            textFieldSelectionState.copy(false);
                            consumed3 = consumed2;
                            break;
                        case 2:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            textFieldSelectionState.paste();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 3:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            textFieldSelectionState.cut();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 4:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.collapseLeftOr((Function1)TextFieldKeyEventHandler.onKeyEvent.2.1.INSTANCE);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 5:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.collapseRightOr((Function1)TextFieldKeyEventHandler.onKeyEvent.2.2.INSTANCE);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 6:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorLeftByWord();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 7:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorRightByWord();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 8:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorPrevByParagraph();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 9:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorNextByParagraph();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 10:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorUpByLine();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 11:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorDownByLine();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 12:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorUpByPage();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 13:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorDownByPage();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 14:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToLineStart();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 15:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToLineEnd();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 16:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToLineLeftSide();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 17:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToLineRightSide();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 18:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToHome();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 19:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            field13.moveCursorToEnd();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 20:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field10 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field10), (CharSequence)str2, field10.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            command2 = 0;
                            it = 1;
                            it = 0;
                            selection-d9O1mEE2 = box-impl;
                            box-impl = TextRange.box-impl(TextRangeKt.TextRange((Number)selection-d9O1mEE2.intValue(), TextRange.getEnd-impl(field13.getSelection-d9O1mEE())));
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field10), (CharSequence)str2, box-impl.unbox-impl(), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 21:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field11 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field11), (CharSequence)str2, field11.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            command2 = 0;
                            it = 1;
                            it = 0;
                            selection-d9O1mEE2 = box-impl;
                            box-impl = TextRange.box-impl(TextRangeKt.TextRange(TextRange.getStart-impl(field13.getSelection-d9O1mEE()), (Number)selection-d9O1mEE2.intValue()));
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field11), (CharSequence)str2, box-impl.unbox-impl(), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 22:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field8 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field8), (CharSequence)str2, field8.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            int i18 = 0;
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field8), (CharSequence)str2, TextRangeKt.TextRange(field13.getPreviousWordOffset(), TextRange.getEnd-impl(field13.getSelection-d9O1mEE())), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 23:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field6 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field6), (CharSequence)str2, field6.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            int i16 = 0;
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field6), (CharSequence)str2, TextRangeKt.TextRange(TextRange.getStart-impl(field13.getSelection-d9O1mEE()), field13.getNextWordOffset()), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 24:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field9 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field9), (CharSequence)str2, field9.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            int i19 = 0;
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field9), (CharSequence)str2, TextRangeKt.TextRange(field13.getLineStartByOffset(), TextRange.getEnd-impl(field13.getSelection-d9O1mEE())), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 25:
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            TextFieldPreparedSelection field7 = field13;
                            mainBuffer$foundation_release = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field7), (CharSequence)str2, field7.getSelection-d9O1mEE(), obj26, false, command2 ^ 1, 4);
                            int i17 = 0;
                            command2 = 0;
                            i8 = 1;
                            TransformedTextFieldState.replaceText-M8tDOmk$default(TextFieldPreparedSelection.access$getState$p(field7), (CharSequence)str2, TextRangeKt.TextRange(TextRange.getStart-impl(field13.getSelection-d9O1mEE()), field13.getLineEndByOffset()), obj26, false, it ^ 1, 4);
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 26:
                            command = command2;
                            command2 = TransformedTextFieldState.access$getTextFieldState$p(textFieldState);
                            i9 = 0;
                            command2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
                            ordinal = i15;
                            mainBuffer$foundation_release = command2.getMainBuffer$foundation_release();
                            box-impl = 0;
                            mainBuffer$foundation_release.commitComposition();
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            EditCommandKt.commitText(mainBuffer$foundation_release, "\n", 1);
                            TextFieldState.access$commitEditAsUser(command2, TransformedTextFieldState.access$getInputTransformation$p(textFieldState), true, TextFieldEditUndoBehavior.MergeIfPossible);
                            this_$iv = textFieldSelectionState;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            onSubmit.invoke();
                            this_$iv = textFieldSelectionState;
                            consumed3 = consumed2;
                            break;
                        case 27:
                            i9 = 0;
                            box-impl = field14;
                            ordinal = 0;
                            box-impl.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
                            androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release3 = box-impl.getMainBuffer$foundation_release();
                            int i26 = 0;
                            mainBuffer$foundation_release3.commitComposition();
                            command = command2;
                            EditCommandKt.commitText(mainBuffer$foundation_release3, "\t", 1);
                            TextFieldState.access$commitEditAsUser(box-impl, TransformedTextFieldState.access$getInputTransformation$p(textFieldState), true, TextFieldEditUndoBehavior.MergeIfPossible);
                            this_$iv = textFieldSelectionState;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            command = command2;
                            consumed3 = 0;
                            this_$iv = textFieldSelectionState;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 28:
                            field13.selectAll();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 29:
                            field13.moveCursorLeft().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 30:
                            field13.moveCursorRight().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 31:
                            field13.moveCursorLeftByWord().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 32:
                            field13.moveCursorRightByWord().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 33:
                            field13.moveCursorPrevByParagraph().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 34:
                            field13.moveCursorNextByParagraph().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 35:
                            field13.moveCursorToLineStart().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 36:
                            field13.moveCursorToLineEnd().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 37:
                            field13.moveCursorToLineLeftSide().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 38:
                            field13.moveCursorToLineRightSide().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 39:
                            field13.moveCursorUpByLine().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 40:
                            field13.moveCursorDownByLine().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 41:
                            field13.moveCursorUpByPage().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 42:
                            field13.moveCursorDownByPage().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 43:
                            field13.moveCursorToHome().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 44:
                            field13.moveCursorToEnd().selectMovement();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 45:
                            field13.deselect();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 46:
                            textFieldState.undo();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 47:
                            textFieldState.redo();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        case 48:
                            KeyEventHelpers_androidKt.showCharacterPalette();
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                            break;
                        default:
                            this_$iv = textFieldSelectionState;
                            command = command2;
                            consumed2 = consumed;
                            field3 = preparedSelection$iv;
                            consumed3 = consumed2;
                    }
                    if (!TextRange.equals-impl0(field3.getSelection-d9O1mEE(), command2)) {
                        textFieldState.selectCharsIn-5zc-tL8(field3.getSelection-d9O1mEE());
                    } else {
                        field4 = textFieldState;
                    }
                }
            } else {
            }
            return consumed3;
        }
        field = textFieldState;
        textLayoutState2 = textLayoutState;
        obj2 = textFieldSelectionState;
        keyCommand = command2;
    }

    public boolean onPreKeyEvent-MyFupTE(KeyEvent event, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        boolean cancelsTextSelection-ZmokQxo;
        int i;
        if (!TextRange.getCollapsed-impl(textFieldState.getVisualText().getSelection-d9O1mEE()) && KeyEventHelpers_androidKt.cancelsTextSelection-ZmokQxo(event)) {
            i = KeyEventHelpers_androidKt.cancelsTextSelection-ZmokQxo(event) ? 1 : 0;
        } else {
        }
        return i;
    }
}
