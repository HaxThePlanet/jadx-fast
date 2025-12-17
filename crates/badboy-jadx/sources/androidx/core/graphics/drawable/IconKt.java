package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\u0008\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\u0008¨\u0006\u0006", d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap $this$toAdaptiveIcon) {
        final int i = 0;
        return Icon.createWithAdaptiveBitmap($this$toAdaptiveIcon);
    }

    public static final Icon toIcon(Bitmap $this$toIcon) {
        final int i = 0;
        return Icon.createWithBitmap($this$toIcon);
    }

    public static final Icon toIcon(Uri $this$toIcon) {
        final int i = 0;
        return Icon.createWithContentUri($this$toIcon);
    }

    public static final Icon toIcon(byte[] $this$toIcon) {
        final int i = 0;
        return Icon.createWithData($this$toIcon, 0, $this$toIcon.length);
    }
}
