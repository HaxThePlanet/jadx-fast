package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build.VERSION;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/font/FontWeightAdjustmentHelper;", "", "()V", "getFontWeightAdjustment", "", "context", "Landroid/content/Context;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontWeightAdjustmentHelper {

    public static final int $stable;
    public static final androidx.compose.ui.text.font.FontWeightAdjustmentHelper INSTANCE;
    static {
        FontWeightAdjustmentHelper fontWeightAdjustmentHelper = new FontWeightAdjustmentHelper();
        FontWeightAdjustmentHelper.INSTANCE = fontWeightAdjustmentHelper;
    }

    public final int getFontWeightAdjustment(Context context) {
        int fontWeightAdjustment;
        if (Build.VERSION.SDK_INT >= 31) {
            fontWeightAdjustment = FontWeightAdjustmentHelperApi31.INSTANCE.fontWeightAdjustment(context);
        } else {
            fontWeightAdjustment = 0;
        }
        return fontWeightAdjustment;
    }
}
