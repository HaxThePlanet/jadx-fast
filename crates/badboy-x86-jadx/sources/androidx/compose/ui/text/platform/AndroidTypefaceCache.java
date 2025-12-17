package androidx.compose.ui.text.platform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import androidx.collection.LruCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.AndroidFont.TypefaceLoader;
import androidx.compose.ui.text.font.AndroidPreloadedFont;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "Duplicate cache")
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000c\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/ui/text/platform/AndroidTypefaceCache;", "", "()V", "cache", "Landroidx/collection/LruCache;", "", "Landroid/graphics/Typeface;", "getKey", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/Font;", "getOrCreate", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidTypefaceCache {

    public static final int $stable = 8;
    public static final androidx.compose.ui.text.platform.AndroidTypefaceCache INSTANCE;
    private static final LruCache<String, Typeface> cache;
    static {
        AndroidTypefaceCache androidTypefaceCache = new AndroidTypefaceCache();
        AndroidTypefaceCache.INSTANCE = androidTypefaceCache;
        LruCache lruCache = new LruCache(16);
        AndroidTypefaceCache.cache = lruCache;
        int i = 8;
    }

    public final String getKey(Context context, Font font) {
        String value;
        StringBuilder append;
        int string;
        int i;
        if (font instanceof ResourceFont) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue((ResourceFont)font.getResId(), typedValue, true);
            StringBuilder stringBuilder2 = new StringBuilder();
            java.lang.CharSequence string3 = typedValue.string;
            if (string3 != null) {
                string = string3.toString();
            } else {
                string = 0;
            }
            Intrinsics.checkNotNull(string);
            value = stringBuilder2.append("res:").append(string).toString();
            return value;
        } else {
            if (!font instanceof AndroidPreloadedFont) {
            } else {
                value = (AndroidPreloadedFont)font.getCacheKey();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown font type: ").append(font).toString());
        throw illegalArgumentException;
    }

    public final Typeface getOrCreate(Context context, Font font) {
        String str;
        Typeface blocking;
        int i;
        Font resId;
        Object obj2;
        Object obj;
        final String key = getKey(context, font);
        str = key;
        i = 0;
        obj2 = AndroidTypefaceCache.cache.get(key);
        if (key != null && (Typeface)obj2 != null) {
            str = key;
            i = 0;
            obj2 = AndroidTypefaceCache.cache.get(key);
            if ((Typeface)(Typeface)obj2 != null) {
                int i2 = 0;
                return (Typeface)(Typeface)obj2;
            }
        }
        if (font instanceof ResourceFont) {
            blocking = AndroidResourceFontLoaderHelper.INSTANCE.create(context, (ResourceFont)font.getResId());
            if (blocking == null) {
            } else {
                if (key != null) {
                    resId = key;
                    obj2 = 0;
                    obj = AndroidTypefaceCache.cache.put(key, blocking);
                }
                return blocking;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException typeface = new IllegalArgumentException(stringBuilder2.append("Unable to load font ").append(font).toString());
            throw typeface;
        } else {
            if (!font instanceof AndroidFont) {
            } else {
                blocking = (AndroidFont)font.getTypefaceLoader().loadBlocking(context, (AndroidFont)font);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown font type: ").append(font).toString());
        throw illegalArgumentException;
    }
}
