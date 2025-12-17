package androidx.compose.ui.contentcapture;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0004À\u0006\u0001", d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "", "Companion", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentCaptureManager {

    public static final androidx.compose.ui.contentcapture.ContentCaptureManager.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R,\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002\u001a\u0004\u0008\u0005\u0010\u0007\"\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager$Companion;", "", "()V", "<set-?>", "", "isEnabled", "isEnabled$annotations", "()Z", "setEnabled", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.contentcapture.ContentCaptureManager.Companion $$INSTANCE;
        private static boolean isEnabled;
        static {
            ContentCaptureManager.Companion companion = new ContentCaptureManager.Companion();
            ContentCaptureManager.Companion.$$INSTANCE = companion;
            ContentCaptureManager.Companion.isEnabled = true;
        }

        public static void isEnabled$annotations() {
        }

        public final boolean isEnabled() {
            return ContentCaptureManager.Companion.isEnabled;
        }

        public final void setEnabled(boolean <set-?>) {
            ContentCaptureManager.Companion.isEnabled = <set-?>;
        }
    }
    static {
        ContentCaptureManager.Companion = ContentCaptureManager.Companion.$$INSTANCE;
    }
}
