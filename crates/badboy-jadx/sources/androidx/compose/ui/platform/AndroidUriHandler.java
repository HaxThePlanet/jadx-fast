package androidx.compose.ui.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/AndroidUriHandler;", "Landroidx/compose/ui/platform/UriHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "openUri", "", "uri", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidUriHandler implements androidx.compose.ui.platform.UriHandler {

    public static final int $stable = 8;
    private final Context context;
    static {
        final int i = 8;
    }

    public AndroidUriHandler(Context context) {
        super();
        this.context = context;
    }

    @Override // androidx.compose.ui.platform.UriHandler
    public void openUri(String uri) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uri));
        this.context.startActivity(intent);
    }
}
