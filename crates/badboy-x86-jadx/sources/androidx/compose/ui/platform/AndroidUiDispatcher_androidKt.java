package androidx.compose.ui.platform;

import android.os.Looper;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002", d2 = {"isMainThread", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidUiDispatcher_androidKt {
    public static final boolean access$isMainThread() {
        return AndroidUiDispatcher_androidKt.isMainThread();
    }

    private static final boolean isMainThread() {
        int i;
        i = Looper.myLooper() == Looper.getMainLooper() ? 1 : 0;
        return i;
    }
}
