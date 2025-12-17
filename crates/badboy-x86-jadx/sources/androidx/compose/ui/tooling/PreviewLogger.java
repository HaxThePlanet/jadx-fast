package androidx.compose.ui.tooling;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/ui/tooling/PreviewLogger;", "", "()V", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PreviewLogger {

    public static final int $stable;
    public static final androidx.compose.ui.tooling.PreviewLogger.Companion Companion;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0000¢\u0006\u0002\u0008\tJ!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0000¢\u0006\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/ui/tooling/PreviewLogger$Companion;", "", "()V", "logError", "", "message", "", "throwable", "", "logError$ui_tooling_release", "logWarning", "logWarning$ui_tooling_release", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void logError$ui_tooling_release$default(androidx.compose.ui.tooling.PreviewLogger.Companion previewLogger$Companion, String string2, Throwable throwable3, int i4, Object object5) {
            int obj2;
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            companion.logError$ui_tooling_release(string2, obj2);
        }

        public static void logWarning$ui_tooling_release$default(androidx.compose.ui.tooling.PreviewLogger.Companion previewLogger$Companion, String string2, Throwable throwable3, int i4, Object object5) {
            int obj2;
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            companion.logWarning$ui_tooling_release(string2, obj2);
        }

        public final void logError$ui_tooling_release(String message, Throwable throwable) {
            Log.e("PreviewLogger", message, throwable);
        }

        public final void logWarning$ui_tooling_release(String message, Throwable throwable) {
            Log.w("PreviewLogger", message, throwable);
        }
    }
    static {
        PreviewLogger.Companion companion = new PreviewLogger.Companion(0);
        PreviewLogger.Companion = companion;
    }
}
