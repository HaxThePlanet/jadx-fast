package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004R \u0010\u0005\u001a\u00020\u00068WX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/platform/WindowInfo;", "", "isWindowFocused", "", "()Z", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A$annotations", "()V", "getKeyboardModifiers-k7X9c1A", "()I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WindowInfo {
    public static void getKeyboardModifiers-k7X9c1A$annotations() {
    }

    public int getKeyboardModifiers-k7X9c1A() {
        return (PointerKeyboardModifiers)WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui_release().getValue().unbox-impl();
    }

    public abstract boolean isWindowFocused();
}
