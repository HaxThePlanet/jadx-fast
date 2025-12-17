package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a\u0008\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"isFromSoftKeyboard", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isFromSoftKeyboard-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "createTextFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "isKeyCode", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKeyEventHandler_androidKt {
    public static final boolean access$isKeyCode-YhN2O0w(KeyEvent $receiver, int keyCode) {
        return TextFieldKeyEventHandler_androidKt.isKeyCode-YhN2O0w($receiver, keyCode);
    }

    public static final androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler createTextFieldKeyEventHandler() {
        AndroidTextFieldKeyEventHandler androidTextFieldKeyEventHandler = new AndroidTextFieldKeyEventHandler();
        return (TextFieldKeyEventHandler)androidTextFieldKeyEventHandler;
    }

    public static final boolean isFromSoftKeyboard-ZmokQxo(KeyEvent $this$isFromSoftKeyboard) {
        int i;
        final int i3 = 2;
        i = flags &= i3 == i3 ? 1 : 0;
        return i;
    }

    private static final boolean isKeyCode-YhN2O0w(KeyEvent $this$isKeyCode_u2dYhN2O0w, int keyCode) {
        int i;
        i = Key_androidKt.getNativeKeyCode-YVgTNJs(KeyEvent_androidKt.getKey-ZmokQxo($this$isKeyCode_u2dYhN2O0w)) == keyCode ? 1 : 0;
        return i;
    }
}
