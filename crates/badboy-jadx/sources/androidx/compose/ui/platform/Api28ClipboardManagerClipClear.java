package androidx.compose.ui.platform;

import android.content.ClipboardManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/platform/Api28ClipboardManagerClipClear;", "", "()V", "clearPrimaryClip", "", "clipboardManager", "Landroid/content/ClipboardManager;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api28ClipboardManagerClipClear {

    public static final androidx.compose.ui.platform.Api28ClipboardManagerClipClear INSTANCE;
    static {
        Api28ClipboardManagerClipClear api28ClipboardManagerClipClear = new Api28ClipboardManagerClipClear();
        Api28ClipboardManagerClipClear.INSTANCE = api28ClipboardManagerClipClear;
    }

    @JvmStatic
    public static final void clearPrimaryClip(ClipboardManager clipboardManager) {
        clipboardManager.clearPrimaryClip();
    }
}
