package androidx.compose.foundation.text.handwriting;

import android.os.Build.VERSION;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0000\u0010\u0002¨\u0006\u0003", d2 = {"isStylusHandwritingSupported", "", "()Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StylusHandwriting_androidKt {

    private static final boolean isStylusHandwritingSupported = false;
    static {
        if (Build.VERSION.SDK_INT >= 34) {
            int i = 1;
        }
        int i2 = 0;
    }

    public static final boolean isStylusHandwritingSupported() {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported;
    }
}
