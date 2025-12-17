package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusDirection.Companion;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J:\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "()V", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextFieldKeyEventHandler extends androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler {

    public static final int $stable;
    static {
    }

    public boolean onKeyEvent-6ptp14s(KeyEvent event, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, boolean editable, boolean singleLine, Function0<Unit> onSubmit) {
        boolean fromSoftKeyboard-ZmokQxo;
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(event), KeyEventType.Companion.getKeyDown-CS__XNY()) && event.isFromSource(257) && !TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(event)) {
            if (event.isFromSource(257)) {
                if (!TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(event)) {
                    textFieldSelectionState.setInTouchMode(false);
                }
            }
        }
        return super.onKeyEvent-6ptp14s(event, textFieldState, textLayoutState, textFieldSelectionState, editable, singleLine, onSubmit);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    public boolean onPreKeyEvent-MyFupTE(KeyEvent event, androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        int moveFocus-3ESFkO8;
        boolean supportsSource;
        int keyDown-CS__XNY;
        if (super.onPreKeyEvent-MyFupTE(event, textFieldState, textFieldSelectionState, focusManager, keyboardController)) {
            return 1;
        }
        InputDevice device = event.getDevice();
        final int i = 0;
        if (device == null) {
            moveFocus-3ESFkO8 = i;
        } else {
            if (!device.supportsSource(513)) {
                moveFocus-3ESFkO8 = i;
            } else {
                if (device.isVirtual()) {
                    moveFocus-3ESFkO8 = i;
                } else {
                    if (!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(event), KeyEventType.Companion.getKeyDown-CS__XNY())) {
                        moveFocus-3ESFkO8 = i;
                    } else {
                        if (event.getSource() == 257) {
                            moveFocus-3ESFkO8 = i;
                        } else {
                            if (TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(event, 19)) {
                                moveFocus-3ESFkO8 = focusManager.moveFocus-3ESFkO8(FocusDirection.Companion.getUp-dhqQ-8s());
                            } else {
                                if (TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(event, 20)) {
                                    moveFocus-3ESFkO8 = focusManager.moveFocus-3ESFkO8(FocusDirection.Companion.getDown-dhqQ-8s());
                                } else {
                                    if (TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(event, 21)) {
                                        moveFocus-3ESFkO8 = focusManager.moveFocus-3ESFkO8(FocusDirection.Companion.getLeft-dhqQ-8s());
                                    } else {
                                        if (TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(event, 22)) {
                                            moveFocus-3ESFkO8 = focusManager.moveFocus-3ESFkO8(FocusDirection.Companion.getRight-dhqQ-8s());
                                        } else {
                                            if (TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(event, 23)) {
                                                keyboardController.show();
                                            } else {
                                                moveFocus-3ESFkO8 = i;
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
        return moveFocus-3ESFkO8;
    }
}
