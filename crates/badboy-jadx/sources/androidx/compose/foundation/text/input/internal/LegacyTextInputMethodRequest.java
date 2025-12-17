package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.ImeOptions.Companion;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u000206J\u0008\u00107\u001a\u00020\u0007H\u0002JN\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020'2\u0008\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010!\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005J\u0018\u0010<\u001a\u00020\u00072\u0008\u0010=\u001a\u0004\u0018\u00010'2\u0006\u0010>\u001a\u00020'J.\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002062\u0006\u0010F\u001a\u000206R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "startInput", "value", "textInputNode", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {

    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    private final androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private List<WeakReference<androidx.compose.foundation.text.input.internal.RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final androidx.compose.foundation.text.input.internal.InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    private Function1<? super ImeAction, Unit> onImeActionPerformed;
    private TextFieldValue state;
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;
    static {
        final int i = 8;
    }

    public LegacyTextInputMethodRequest(View view, Function1<? super Matrix, Unit> localToScreen, androidx.compose.foundation.text.input.internal.InputMethodManager inputMethodManager) {
        super();
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.onEditCommand = (Function1)LegacyTextInputMethodRequest.onEditCommand.1.INSTANCE;
        this.onImeActionPerformed = (Function1)LegacyTextInputMethodRequest.onImeActionPerformed.1.INSTANCE;
        TextFieldValue textFieldValue = new TextFieldValue("", TextRange.Companion.getZero-d9O1mEE(), obj4, 0, 4, 0);
        this.state = textFieldValue;
        this.imeOptions = ImeOptions.Companion.getDefault();
        ArrayList arrayList = new ArrayList();
        this.ics = (List)arrayList;
        LegacyTextInputMethodRequest.baseInputConnection.2 anon = new LegacyTextInputMethodRequest.baseInputConnection.2(this);
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
        LegacyCursorAnchorInfoController legacyCursorAnchorInfoController = new LegacyCursorAnchorInfoController(localToScreen, this.inputMethodManager);
        this.cursorAnchorInfoController = legacyCursorAnchorInfoController;
    }

    public static final BaseInputConnection access$getBaseInputConnection(androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest $this) {
        return $this.getBaseInputConnection();
    }

    public static final androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoController access$getCursorAnchorInfoController$p(androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest $this) {
        return $this.cursorAnchorInfoController;
    }

    public static final List access$getIcs$p(androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest $this) {
        return $this.ics;
    }

    public static final Function1 access$getOnEditCommand$p(androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest $this) {
        return $this.onEditCommand;
    }

    public static final Function1 access$getOnImeActionPerformed$p(androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest $this) {
        return $this.onImeActionPerformed;
    }

    private final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection)this.baseInputConnection$delegate.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public InputConnection createInputConnection(EditorInfo outAttributes) {
        return (InputConnection)createInputConnection(outAttributes);
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public androidx.compose.foundation.text.input.internal.RecordingInputConnection createInputConnection(EditorInfo outAttributes) {
        final EditorInfo editorInfo = outAttributes;
        EditorInfo_androidKt.update-pLxbY9I$default(editorInfo, (CharSequence)this.state.getText(), this.state.getSelection-d9O1mEE(), obj4, this.imeOptions, 0, 8);
        LegacyPlatformTextInputServiceAdapter_androidKt.access$updateWithEmojiCompat(editorInfo);
        LegacyTextInputMethodRequest.createInputConnection.1 obj10 = new LegacyTextInputMethodRequest.createInputConnection.1(this);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, (InputEventCallback2)obj10, this.imeOptions.getAutoCorrect(), this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        int i = 0;
        WeakReference weakReference = new WeakReference(recordingInputConnection);
        this.ics.add(weakReference);
        return recordingInputConnection;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final Rect getFocusedRect$foundation_release() {
        return this.focusedRect;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final TextFieldValue getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final void notifyFocusedRect(Rect rect) {
        boolean focusedRect;
        int roundToInt2;
        int roundToInt3;
        int roundToInt;
        Rect rect2 = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        this.focusedRect = rect2;
        focusedRect = this.focusedRect;
        if (this.ics.isEmpty() && focusedRect != null) {
            focusedRect = this.focusedRect;
            if (focusedRect != null) {
                roundToInt2 = 0;
                roundToInt = new Rect(focusedRect);
                this.view.requestRectangleOnScreen(roundToInt);
            }
        }
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final void setFocusedRect$foundation_release(Rect <set-?>) {
        this.focusedRect = <set-?>;
    }

    public final void startInput(TextFieldValue value, androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode textInputNode, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> onEditCommand, Function1<? super ImeAction, Unit> onImeActionPerformed) {
        int viewConfiguration;
        int legacyTextFieldState;
        int textFieldSelectionManager;
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        viewConfiguration = 0;
        if (textInputNode != null) {
            legacyTextFieldState = textInputNode.getLegacyTextFieldState();
        } else {
            legacyTextFieldState = viewConfiguration;
        }
        this.legacyTextFieldState = legacyTextFieldState;
        if (textInputNode != null) {
            textFieldSelectionManager = textInputNode.getTextFieldSelectionManager();
        } else {
            textFieldSelectionManager = viewConfiguration;
        }
        this.textFieldSelectionManager = textFieldSelectionManager;
        if (textInputNode != null) {
            viewConfiguration = textInputNode.getViewConfiguration();
        }
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        int i;
        boolean equal;
        int inputMethodManager;
        int i3;
        TextRange composition-MzsxiRA2;
        int i2;
        boolean max-impl2;
        int min-impl;
        boolean max-impl;
        long composition-MzsxiRA;
        long selection-d9O1mEE;
        i3 = 1;
        if (TextRange.equals-impl0(this.state.getSelection-d9O1mEE(), obj1)) {
            if (!Intrinsics.areEqual(this.state.getComposition-MzsxiRA(), newValue.getComposition-MzsxiRA())) {
                i = i3;
            } else {
                i = inputMethodManager;
            }
        } else {
        }
        this.state = newValue;
        i2 = 0;
        min-impl = this.ics.size();
        while (i2 < min-impl) {
            max-impl = (WeakReference)this.ics.get(i2).get();
            if ((RecordingInputConnection)max-impl == null) {
            } else {
            }
            (RecordingInputConnection)max-impl.setTextFieldValue$foundation_release(newValue);
            i2++;
        }
        this.cursorAnchorInfoController.invalidate();
        max-impl2 = Intrinsics.areEqual(oldValue, newValue);
        if (max-impl2 && i != 0) {
            if (i != 0) {
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

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, innerTextFieldBounds, decorationBoxBounds);
    }
}
