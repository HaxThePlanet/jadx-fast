package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/font/DelegatingFontLoaderForBridgeUsage;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "loader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "getLoader$ui_text_release", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "awaitLoad", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DelegatingFontLoaderForBridgeUsage implements androidx.compose.ui.text.font.PlatformFontLoader {

    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;
    private final androidx.compose.ui.text.font.Font.ResourceLoader loader;
    static {
        final int i = 8;
    }

    public DelegatingFontLoaderForBridgeUsage(androidx.compose.ui.text.font.Font.ResourceLoader loader, Context context) {
        super();
        this.loader = loader;
        this.context = context;
        Object object = new Object();
        this.cacheKey = object;
    }

    public Object awaitLoad(androidx.compose.ui.text.font.Font font, Continuation<Object> $completion) {
        Object awaitLoad;
        Context context;
        Object obj;
        if (font instanceof AndroidFont) {
            awaitLoad = (AndroidFont)font.getTypefaceLoader().awaitLoad(this.context, (AndroidFont)font, $completion);
        } else {
            awaitLoad = this.loader.load(font);
        }
        return awaitLoad;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public final androidx.compose.ui.text.font.Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object loadBlocking(androidx.compose.ui.text.font.Font font) {
        Object blocking;
        Context context;
        Object obj;
        if (font instanceof AndroidFont) {
            blocking = (AndroidFont)font.getTypefaceLoader().loadBlocking(this.context, (AndroidFont)font);
        } else {
            blocking = this.loader.load(font);
        }
        return blocking;
    }
}
