package androidx.compose.ui.focus;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/focus/FocusManager;", "", "clearFocus", "", "force", "", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FocusManager {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clearFocus$default(androidx.compose.ui.focus.FocusManager focusManager, boolean z2, int i3, Object object4) {
            FocusManager.clearFocus$default(focusManager, z2, i3, object4);
        }
    }
    public static void clearFocus$default(androidx.compose.ui.focus.FocusManager focusManager, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            focusManager.clearFocus(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
        throw obj0;
    }

    public abstract void clearFocus(boolean z);

    public abstract boolean moveFocus-3ESFkO8(int i);
}
