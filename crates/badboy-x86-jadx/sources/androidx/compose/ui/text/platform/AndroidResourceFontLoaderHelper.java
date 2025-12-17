package androidx.compose.ui.text.platform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import kotlin.Deprecated;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Deprecated(message = "Only used by deprecated APIs in this file, remove with them.")
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/text/platform/AndroidResourceFontLoaderHelper;", "", "()V", "create", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "resourceId", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidResourceFontLoaderHelper {

    public static final androidx.compose.ui.text.platform.AndroidResourceFontLoaderHelper INSTANCE;
    static {
        AndroidResourceFontLoaderHelper androidResourceFontLoaderHelper = new AndroidResourceFontLoaderHelper();
        AndroidResourceFontLoaderHelper.INSTANCE = androidResourceFontLoaderHelper;
    }

    public final Typeface create(Context context, int resourceId) {
        return context.getResources().getFont(resourceId);
    }
}
