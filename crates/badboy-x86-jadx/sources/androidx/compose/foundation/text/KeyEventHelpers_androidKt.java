package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0007", d2 = {"showCharacterPalette", "", "cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyEventHelpers_androidKt {
    public static final boolean cancelsTextSelection-ZmokQxo(KeyEvent $this$cancelsTextSelection_u2dZmokQxo) {
        int keyCode;
        int i;
        int keyUp-CS__XNY;
        if ($this$cancelsTextSelection_u2dZmokQxo.getKeyCode() == 4 && KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo($this$cancelsTextSelection_u2dZmokQxo), KeyEventType.Companion.getKeyUp-CS__XNY())) {
            i = KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo($this$cancelsTextSelection_u2dZmokQxo), KeyEventType.Companion.getKeyUp-CS__XNY()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final void showCharacterPalette() {
    }
}
