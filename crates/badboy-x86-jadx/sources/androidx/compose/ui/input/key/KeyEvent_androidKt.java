package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\u000c*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012\"\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0012*\n\u0010\u0016\"\u00020\u00172\u00020\u0017¨\u0006\u0018", d2 = {"isAltPressed", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isAltPressed-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isCtrlPressed", "isCtrlPressed-ZmokQxo", "isMetaPressed", "isMetaPressed-ZmokQxo", "isShiftPressed", "isShiftPressed-ZmokQxo", "key", "Landroidx/compose/ui/input/key/Key;", "getKey-ZmokQxo", "(Landroid/view/KeyEvent;)J", "type", "Landroidx/compose/ui/input/key/KeyEventType;", "getType-ZmokQxo", "(Landroid/view/KeyEvent;)I", "utf16CodePoint", "", "getUtf16CodePoint-ZmokQxo", "NativeKeyEvent", "Landroid/view/KeyEvent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyEvent_androidKt {
    public static final long getKey-ZmokQxo(KeyEvent $this$key) {
        return Key_androidKt.Key($this$key.getKeyCode());
    }

    public static final int getType-ZmokQxo(KeyEvent $this$type) {
        int keyDown-CS__XNY;
        switch (action) {
            case 0:
                keyDown-CS__XNY = KeyEventType.Companion.getKeyDown-CS__XNY();
                break;
            case 1:
                keyDown-CS__XNY = KeyEventType.Companion.getKeyUp-CS__XNY();
                break;
            default:
                keyDown-CS__XNY = KeyEventType.Companion.getUnknown-CS__XNY();
        }
        return keyDown-CS__XNY;
    }

    public static final int getUtf16CodePoint-ZmokQxo(KeyEvent $this$utf16CodePoint) {
        return $this$utf16CodePoint.getUnicodeChar();
    }

    public static final boolean isAltPressed-ZmokQxo(KeyEvent $this$isAltPressed) {
        return $this$isAltPressed.isAltPressed();
    }

    public static final boolean isCtrlPressed-ZmokQxo(KeyEvent $this$isCtrlPressed) {
        return $this$isCtrlPressed.isCtrlPressed();
    }

    public static final boolean isMetaPressed-ZmokQxo(KeyEvent $this$isMetaPressed) {
        return $this$isMetaPressed.isMetaPressed();
    }

    public static final boolean isShiftPressed-ZmokQxo(KeyEvent $this$isShiftPressed) {
        return $this$isShiftPressed.isShiftPressed();
    }
}
