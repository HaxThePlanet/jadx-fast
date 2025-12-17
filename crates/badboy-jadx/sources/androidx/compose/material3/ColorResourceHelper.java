package androidx.compose.material3;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/material3/ColorResourceHelper;", "", "()V", "getColor", "Landroidx/compose/ui/graphics/Color;", "context", "Landroid/content/Context;", "id", "", "getColor-WaAFU9c", "(Landroid/content/Context;I)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ColorResourceHelper {

    public static final androidx.compose.material3.ColorResourceHelper INSTANCE;
    static {
        ColorResourceHelper colorResourceHelper = new ColorResourceHelper();
        ColorResourceHelper.INSTANCE = colorResourceHelper;
    }

    public final long getColor-WaAFU9c(Context context, int id) {
        return ColorKt.Color(context.getResources().getColor(id, context.getTheme()));
    }
}
