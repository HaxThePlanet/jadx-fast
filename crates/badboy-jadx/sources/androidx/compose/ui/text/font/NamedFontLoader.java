package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0096@¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/font/NamedFontLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "()V", "awaitLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class NamedFontLoader implements androidx.compose.ui.text.font.AndroidFont.TypefaceLoader {

    public static final androidx.compose.ui.text.font.NamedFontLoader INSTANCE;
    static {
        NamedFontLoader namedFontLoader = new NamedFontLoader();
        NamedFontLoader.INSTANCE = namedFontLoader;
    }

    public Object awaitLoad(Context context, androidx.compose.ui.text.font.AndroidFont font, Continuation<? super Typeface> $completion) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("All preloaded fonts are optional local.");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont$TypefaceLoader
    public Typeface loadBlocking(Context context, androidx.compose.ui.text.font.AndroidFont font) {
        Object obj;
        int cached;
        if (font instanceof DeviceFontFamilyNameFont) {
            obj = font;
        } else {
            obj = cached;
        }
        if (obj != null) {
            cached = obj.loadCached(context);
        }
        return cached;
    }
}
