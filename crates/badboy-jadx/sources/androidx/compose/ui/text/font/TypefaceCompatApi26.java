package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J\u0014\u0010\r\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0003R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/ui/text/font/TypefaceCompatApi26;", "", "()V", "threadLocalPaint", "Ljava/lang/ThreadLocal;", "Landroid/graphics/Paint;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "typeface", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "toAndroidString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TypefaceCompatApi26 {

    public static final androidx.compose.ui.text.font.TypefaceCompatApi26 INSTANCE;
    private static java.lang.ThreadLocal<Paint> threadLocalPaint;
    static {
        TypefaceCompatApi26 typefaceCompatApi26 = new TypefaceCompatApi26();
        TypefaceCompatApi26.INSTANCE = typefaceCompatApi26;
        ThreadLocal threadLocal = new ThreadLocal();
        TypefaceCompatApi26.threadLocalPaint = threadLocal;
    }

    private final String toAndroidString(androidx.compose.ui.text.font.FontVariation.Settings $this$toAndroidString, Context context) {
        TypefaceCompatApi26.toAndroidString.1 anon = new TypefaceCompatApi26.toAndroidString.1(AndroidDensity_androidKt.Density(context));
        return ListUtilsKt.fastJoinToString$default($this$toAndroidString.getSettings(), 0, 0, 0, 0, 0, (Function1)anon, 31, 0);
    }

    public final Typeface setFontVariationSettings(Typeface typeface, androidx.compose.ui.text.font.FontVariation.Settings variationSettings, Context context) {
        Object localPaint;
        java.lang.ThreadLocal threadLocalPaint;
        if (typeface == null) {
            return null;
        }
        if (variationSettings.getSettings().isEmpty()) {
            return typeface;
        }
        if ((Paint)TypefaceCompatApi26.threadLocalPaint.get() == null) {
            Paint paint = new Paint();
            TypefaceCompatApi26.threadLocalPaint.set(paint);
        }
        localPaint.setTypeface(typeface);
        localPaint.setFontVariationSettings(toAndroidString(variationSettings, context));
        return localPaint.getTypeface();
    }
}
