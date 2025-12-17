package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.net.Uri;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¨\u0006\u0003", d2 = {"firstUriOrNull", "Landroid/net/Uri;", "Landroidx/compose/ui/platform/ClipEntry;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClipboardExtensions_androidKt {
    public static final Uri firstUriOrNull(androidx.compose.ui.platform.ClipEntry $this$firstUriOrNull) {
        int i;
        Uri uri;
        i = 0;
        while (i < $this$firstUriOrNull.getClipData().getItemCount()) {
            uri = $this$firstUriOrNull.getClipData().getItemAt(i).getUri();
            i++;
        }
        return null;
    }
}
