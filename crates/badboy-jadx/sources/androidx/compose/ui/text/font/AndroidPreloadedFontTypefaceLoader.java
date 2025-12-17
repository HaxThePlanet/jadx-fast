package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0096@¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/font/AndroidPreloadedFontTypefaceLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "()V", "awaitLoad", "", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidPreloadedFontTypefaceLoader implements androidx.compose.ui.text.font.AndroidFont.TypefaceLoader {

    public static final androidx.compose.ui.text.font.AndroidPreloadedFontTypefaceLoader INSTANCE;
    static {
        AndroidPreloadedFontTypefaceLoader androidPreloadedFontTypefaceLoader = new AndroidPreloadedFontTypefaceLoader();
        AndroidPreloadedFontTypefaceLoader.INSTANCE = androidPreloadedFontTypefaceLoader;
    }

    public Object awaitLoad(Context context, androidx.compose.ui.text.font.AndroidFont font, Continuation<?> $completion) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("All preloaded fonts are blocking.");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont$TypefaceLoader
    public Typeface loadBlocking(Context context, androidx.compose.ui.text.font.AndroidFont font) {
        Object obj;
        int cached$ui_text_release;
        if (font instanceof AndroidPreloadedFont) {
            obj = font;
        } else {
            obj = cached$ui_text_release;
        }
        if (obj != null) {
            cached$ui_text_release = obj.loadCached$ui_text_release(context);
        }
        return cached$ui_text_release;
    }
}
