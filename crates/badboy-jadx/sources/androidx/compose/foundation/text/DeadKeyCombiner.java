package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeadKeyCombiner {

    public static final int $stable = 8;
    private Integer deadKeyCode;
    static {
        final int i = 8;
    }

    public final Integer consume-ZmokQxo(KeyEvent event) {
        int valueOf;
        int i;
        final int utf16CodePoint-ZmokQxo = KeyEvent_androidKt.getUtf16CodePoint-ZmokQxo(event);
        valueOf = 0;
        if (i2 &= utf16CodePoint-ZmokQxo != 0) {
            this.deadKeyCode = Integer.valueOf(i4 &= utf16CodePoint-ZmokQxo);
            return valueOf;
        }
        Integer deadKeyCode = this.deadKeyCode;
        if (deadKeyCode != null) {
            this.deadKeyCode = valueOf;
            Integer valueOf4 = Integer.valueOf(KeyCharacterMap.getDeadChar(deadKeyCode.intValue(), utf16CodePoint-ZmokQxo));
            final int i6 = 0;
            i = (Number)valueOf4.intValue() == 0 ? 1 : 0;
            if (i == 0) {
                valueOf = valueOf4;
            }
            if (valueOf == 0) {
                valueOf = Integer.valueOf(utf16CodePoint-ZmokQxo);
            }
            return valueOf;
        }
        return Integer.valueOf(utf16CodePoint-ZmokQxo);
    }
}
