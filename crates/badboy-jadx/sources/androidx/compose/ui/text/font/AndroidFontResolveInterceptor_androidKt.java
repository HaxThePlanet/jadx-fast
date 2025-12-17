package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004", d2 = {"AndroidFontResolveInterceptor", "Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontResolveInterceptor_androidKt {
    public static final androidx.compose.ui.text.font.AndroidFontResolveInterceptor AndroidFontResolveInterceptor(Context context) {
        AndroidFontResolveInterceptor androidFontResolveInterceptor = new AndroidFontResolveInterceptor(FontWeightAdjustmentHelper.INSTANCE.getFontWeightAdjustment(context));
        return androidFontResolveInterceptor;
    }
}
