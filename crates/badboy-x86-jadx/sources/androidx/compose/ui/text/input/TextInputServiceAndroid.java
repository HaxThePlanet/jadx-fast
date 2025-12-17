package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.")
@Metadata(d1 = "\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001:\u0001RB\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0010\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205J\u0008\u00106\u001a\u00020%H\u0016J\u0006\u00107\u001a\u00020\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0017J\u0008\u0010;\u001a\u00020%H\u0002J\u0008\u0010<\u001a\u00020%H\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020/H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0008\u0010A\u001a\u00020%H\u0016J\u0008\u0010B\u001a\u00020%H\u0016JF\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0\"H\u0016J\u0008\u0010D\u001a\u00020%H\u0016J\u001a\u0010E\u001a\u00020%2\u0008\u0010F\u001a\u0004\u0018\u00010)2\u0006\u0010G\u001a\u00020)H\u0016JD\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020%0\"2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020%0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0014\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101¨\u0006S", d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/PositionCalculator;)V", "rootPositionCalculator", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "inputCommandProcessorExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/view/View;Landroidx/compose/ui/input/pointer/PositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;Ljava/util/concurrent/Executor;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "frameCallback", "Ljava/lang/Runnable;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandQueue", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "processInputCommands", "restartInputImmediately", "sendInputCommand", "command", "setKeyboardVisibleImmediately", "visible", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "TextInputCommand", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextInputServiceAndroid implements androidx.compose.ui.text.input.PlatformTextInputService {

    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    private final androidx.compose.ui.text.input.CursorAnchorInfoController cursorAnchorInfoController;
    private boolean editorHasFocus;
    private Rect focusedRect;
    private Runnable frameCallback;
    private List<WeakReference<androidx.compose.ui.text.input.RecordingInputConnection>> ics;
    private androidx.compose.ui.text.input.ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final androidx.compose.ui.text.input.InputMethodManager inputMethodManager;
    private Function1<? super List<? extends androidx.compose.ui.text.input.EditCommand>, Unit> onEditCommand;
    private Function1<? super androidx.compose.ui.text.input.ImeAction, Unit> onImeActionPerformed;
    private androidx.compose.ui.text.input.TextFieldValue state;
    private final MutableVector<androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand> textInputCommandQueue;
    private final View view;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static enum TextInputCommand {

        StartInput,
        StartInput,
        StartInput,
        StartInput,
        StartInput;
        private static final androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand[] $values() {
            return /* result */;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int ordinal4;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[TextInputServiceAndroid.TextInputCommand.StartInput.ordinal()] = 1;
            iArr[TextInputServiceAndroid.TextInputCommand.StopInput.ordinal()] = 2;
            iArr[TextInputServiceAndroid.TextInputCommand.ShowKeyboard.ordinal()] = 3;
            iArr[TextInputServiceAndroid.TextInputCommand.HideKeyboard.ordinal()] = 4;
            TextInputServiceAndroid.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static void $r8$lambda$EPVR_TMFA5GOjs4tvuSSub8L5-M(androidx.compose.ui.text.input.TextInputServiceAndroid textInputServiceAndroid) {
        TextInputServiceAndroid.sendInputCommand$lambda$1(textInputServiceAndroid);
    }

    static {
        final int i = 8;
    }

    public TextInputServiceAndroid(View view, PositionCalculator positionCalculator) {
        InputMethodManagerImpl inputMethodManagerImpl = new InputMethodManagerImpl(view);
        super(view, positionCalculator, (InputMethodManager)inputMethodManagerImpl, 0, 8, 0);
    }

    public TextInputServiceAndroid(View view, PositionCalculator rootPositionCalculator, androidx.compose.ui.text.input.InputMethodManager inputMethodManager, Executor inputCommandProcessorExecutor) {
        super();
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.inputCommandProcessorExecutor = inputCommandProcessorExecutor;
        this.onEditCommand = (Function1)TextInputServiceAndroid.onEditCommand.1.INSTANCE;
        this.onImeActionPerformed = (Function1)TextInputServiceAndroid.onImeActionPerformed.1.INSTANCE;
        TextFieldValue textFieldValue = new TextFieldValue("", TextRange.Companion.getZero-d9O1mEE(), obj4, 0, 4, 0);
        this.state = textFieldValue;
        this.imeOptions = ImeOptions.Companion.getDefault();
        ArrayList arrayList = new ArrayList();
        this.ics = (List)arrayList;
        TextInputServiceAndroid.baseInputConnection.2 anon = new TextInputServiceAndroid.baseInputConnection.2(this);
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
        CursorAnchorInfoController cursorAnchorInfoController = new CursorAnchorInfoController(rootPositionCalculator, this.inputMethodManager);
        this.cursorAnchorInfoController = cursorAnchorInfoController;
        int i = 0;
        int i3 = 0;
        MutableVector mutableVector = new MutableVector(new TextInputServiceAndroid.TextInputCommand[16], 0);
        this.textInputCommandQueue = mutableVector;
    }

    public TextInputServiceAndroid(View view, PositionCalculator positionCalculator2, androidx.compose.ui.text.input.InputMethodManager inputMethodManager3, Executor executor4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        Executor obj4;
        if (i5 &= 8 != 0) {
            obj4 = TextInputServiceAndroid_androidKt.asExecutor(Choreographer.getInstance());
        }
        super(view, positionCalculator2, inputMethodManager3, obj4);
    }

    public static final BaseInputConnection access$getBaseInputConnection(androidx.compose.ui.text.input.TextInputServiceAndroid $this) {
        return $this.getBaseInputConnection();
    }

    public static final androidx.compose.ui.text.input.CursorAnchorInfoController access$getCursorAnchorInfoController$p(androidx.compose.ui.text.input.TextInputServiceAndroid $this) {
        return $this.cursorAnchorInfoController;
    }

    public static final List access$getIcs$p(androidx.compose.ui.text.input.TextInputServiceAndroid $this) {
        return $this.ics;
    }

    public static final Function1 access$getOnEditCommand$p(androidx.compose.ui.text.input.TextInputServiceAndroid $this) {
        return $this.onEditCommand;
    }

    public static final Function1 access$getOnImeActionPerformed$p(androidx.compose.ui.text.input.TextInputServiceAndroid $this) {
        return $this.onImeActionPerformed;
    }

    private final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection)this.baseInputConnection$delegate.getValue();
    }

    private final void processInputCommands() {
        Object booleanValue;
        Boolean valueOf;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        MutableVector textInputCommandQueue = this.textInputCommandQueue;
        int i2 = 0;
        final int size = textInputCommandQueue.getSize();
        final int i4 = 1;
        if (size > 0) {
            i$iv = 0;
            i = 0;
            TextInputServiceAndroid.processInputCommands$applyToState((TextInputServiceAndroid.TextInputCommand)textInputCommandQueue.getContent()[i$iv], objectRef, objectRef2);
            while (i$iv += i4 >= size) {
                i = 0;
                TextInputServiceAndroid.processInputCommands$applyToState((TextInputServiceAndroid.TextInputCommand)content[i$iv], objectRef, objectRef2);
            }
        }
        this.textInputCommandQueue.clear();
        if (Intrinsics.areEqual(objectRef.element, Boolean.valueOf(i4))) {
            restartInputImmediately();
        }
        booleanValue = objectRef2.element;
        if ((Boolean)booleanValue != null) {
            valueOf = 0;
            setKeyboardVisibleImmediately((Boolean)booleanValue.booleanValue());
        }
        if (Intrinsics.areEqual(objectRef.element, false)) {
            restartInputImmediately();
        }
    }

    private static final void processInputCommands$applyToState(androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand $this$processInputCommands_u24applyToState, Ref.ObjectRef<Boolean> startInput, Ref.ObjectRef<Boolean> showKeyboard) {
        int valueOf;
        int i;
        final Boolean valueOf2 = true;
        final int i3 = 0;
        final Boolean valueOf3 = Boolean.valueOf(i3);
        switch (valueOf) {
            case 1:
                startInput.element = valueOf2;
                showKeyboard.element = valueOf2;
                break;
            case 2:
                startInput.element = valueOf3;
                showKeyboard.element = valueOf3;
                break;
            case 3:
                i = i3;
                showKeyboard.element = Boolean.valueOf(i);
                break;
            default:
        }
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void sendInputCommand(androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand command) {
        Runnable this_$iv;
        int inputCommandProcessorExecutor;
        androidx.compose.ui.text.input.TextInputServiceAndroid$$ExternalSyntheticLambda0 service;
        int i;
        inputCommandProcessorExecutor = 0;
        this.textInputCommandQueue.add(command);
        if (this.frameCallback == null) {
            this_$iv = new TextInputServiceAndroid$$ExternalSyntheticLambda0(this);
            i = 0;
            this.inputCommandProcessorExecutor.execute(this_$iv);
            this.frameCallback = this_$iv;
        }
    }

    private static final void sendInputCommand$lambda$1(androidx.compose.ui.text.input.TextInputServiceAndroid this$0) {
        this$0.frameCallback = 0;
        this$0.processInputCommands();
    }

    private final void setKeyboardVisibleImmediately(boolean visible) {
        androidx.compose.ui.text.input.InputMethodManager inputMethodManager;
        if (visible) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(outAttrs, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.access$updateWithEmojiCompat(outAttrs);
        TextInputServiceAndroid.createInputConnection.1 anon = new TextInputServiceAndroid.createInputConnection.1(this);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, (InputEventCallback2)anon, this.imeOptions.getAutoCorrect());
        int i2 = 0;
        WeakReference weakReference = new WeakReference(recordingInputConnection);
        this.ics.add(weakReference);
        return (InputConnection)recordingInputConnection;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final androidx.compose.ui.text.input.TextFieldValue getState$ui_release() {
        return this.state;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void hideSoftwareKeyboard() {
        sendInputCommand(TextInputServiceAndroid.TextInputCommand.HideKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(Rect rect) {
        boolean focusedRect;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        Rect rect2 = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        this.focusedRect = rect2;
        focusedRect = this.focusedRect;
        if (this.ics.isEmpty() && focusedRect != null) {
            focusedRect = this.focusedRect;
            if (focusedRect != null) {
                roundToInt = 0;
                roundToInt3 = new Rect(focusedRect);
                this.view.requestRectangleOnScreen(roundToInt3);
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void showSoftwareKeyboard() {
        sendInputCommand(TextInputServiceAndroid.TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput() {
        sendInputCommand(TextInputServiceAndroid.TextInputCommand.StartInput);
    }

    public void startInput(androidx.compose.ui.text.input.TextFieldValue value, androidx.compose.ui.text.input.ImeOptions imeOptions, Function1<? super List<? extends androidx.compose.ui.text.input.EditCommand>, Unit> onEditCommand, Function1<? super androidx.compose.ui.text.input.ImeAction, Unit> onImeActionPerformed) {
        this.editorHasFocus = true;
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        sendInputCommand(TextInputServiceAndroid.TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = (Function1)TextInputServiceAndroid.stopInput.1.INSTANCE;
        this.onImeActionPerformed = (Function1)TextInputServiceAndroid.stopInput.2.INSTANCE;
        this.focusedRect = 0;
        sendInputCommand(TextInputServiceAndroid.TextInputCommand.StopInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateState(androidx.compose.ui.text.input.TextFieldValue oldValue, androidx.compose.ui.text.input.TextFieldValue newValue) {
        int i2;
        boolean equal;
        int inputMethodManager;
        int i3;
        TextRange composition-MzsxiRA2;
        int i;
        boolean max-impl2;
        int min-impl;
        boolean max-impl;
        long composition-MzsxiRA;
        long selection-d9O1mEE;
        i3 = 1;
        if (TextRange.equals-impl0(this.state.getSelection-d9O1mEE(), obj1)) {
            if (!Intrinsics.areEqual(this.state.getComposition-MzsxiRA(), newValue.getComposition-MzsxiRA())) {
                i2 = i3;
            } else {
                i2 = inputMethodManager;
            }
        } else {
        }
        this.state = newValue;
        i = 0;
        min-impl = this.ics.size();
        while (i < min-impl) {
            max-impl = (WeakReference)this.ics.get(i).get();
            if ((RecordingInputConnection)max-impl == null) {
            } else {
            }
            (RecordingInputConnection)max-impl.setMTextFieldValue$ui_release(newValue);
            i++;
        }
        this.cursorAnchorInfoController.invalidate();
        max-impl2 = Intrinsics.areEqual(oldValue, newValue);
        if (max-impl2 && i2 != 0) {
            if (i2 != 0) {
                TextRange composition-MzsxiRA4 = this.state.getComposition-MzsxiRA();
                if (composition-MzsxiRA4 != null) {
                    min-impl = TextRange.getMin-impl(composition-MzsxiRA4.unbox-impl());
                } else {
                    min-impl = max-impl;
                }
                composition-MzsxiRA = this.state.getComposition-MzsxiRA();
                if (composition-MzsxiRA != null) {
                    max-impl = TextRange.getMax-impl(composition-MzsxiRA.unbox-impl());
                }
                this.inputMethodManager.updateSelection(TextRange.getMin-impl(newValue.getSelection-d9O1mEE()), TextRange.getMax-impl(newValue.getSelection-d9O1mEE()), min-impl, max-impl);
            }
        }
        if (oldValue != null) {
            max-impl2 = oldValue;
            min-impl = 0;
            composition-MzsxiRA = newValue.getText();
            if (Intrinsics.areEqual(max-impl2.getText(), composition-MzsxiRA)) {
                if (TextRange.equals-impl0(max-impl2.getSelection-d9O1mEE(), composition-MzsxiRA) && !Intrinsics.areEqual(max-impl2.getComposition-MzsxiRA(), newValue.getComposition-MzsxiRA())) {
                    if (!Intrinsics.areEqual(max-impl2.getComposition-MzsxiRA(), newValue.getComposition-MzsxiRA())) {
                        inputMethodManager = i3;
                    }
                }
            } else {
            }
        } else {
        }
        if (inputMethodManager != null) {
            restartInputImmediately();
        } else {
            i3 = 0;
            while (i3 < this.ics.size()) {
                min-impl = (WeakReference)this.ics.get(i3).get();
                if ((RecordingInputConnection)min-impl != 0) {
                }
                i3++;
                (RecordingInputConnection)min-impl.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    public void updateTextLayoutResult(androidx.compose.ui.text.input.TextFieldValue textFieldValue, androidx.compose.ui.text.input.OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1<? super Matrix, Unit> textFieldToRootTransform, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, textFieldToRootTransform, innerTextFieldBounds, decorationBoxBounds);
    }
}
