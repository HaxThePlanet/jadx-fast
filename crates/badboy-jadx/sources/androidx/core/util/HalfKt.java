package androidx.core.util;

import android.util.Half;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\u0008\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\u0008\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\u0008¨\u0006\u0006", d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HalfKt {
    public static final Half toHalf(double $this$toHalf) {
        final int i = 0;
        final int i2 = 0;
        return Half.valueOf((float)$this$toHalf);
    }

    public static final Half toHalf(float $this$toHalf) {
        final int i = 0;
        return Half.valueOf($this$toHalf);
    }

    public static final Half toHalf(String $this$toHalf) {
        final int i = 0;
        return Half.valueOf($this$toHalf);
    }

    public static final Half toHalf(short $this$toHalf) {
        final int i = 0;
        return Half.valueOf($this$toHalf);
    }
}
