package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"GlobalAsyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "getGlobalAsyncTypefaceCache", "()Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "GlobalTypefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "getGlobalTypefaceRequestCache", "()Landroidx/compose/ui/text/font/TypefaceRequestCache;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontFamilyResolverKt {

    private static final androidx.compose.ui.text.font.AsyncTypefaceCache GlobalAsyncTypefaceCache;
    private static final androidx.compose.ui.text.font.TypefaceRequestCache GlobalTypefaceRequestCache;
    static {
        TypefaceRequestCache typefaceRequestCache = new TypefaceRequestCache();
        FontFamilyResolverKt.GlobalTypefaceRequestCache = typefaceRequestCache;
        AsyncTypefaceCache asyncTypefaceCache = new AsyncTypefaceCache();
        FontFamilyResolverKt.GlobalAsyncTypefaceCache = asyncTypefaceCache;
    }

    public static final androidx.compose.ui.text.font.AsyncTypefaceCache getGlobalAsyncTypefaceCache() {
        return FontFamilyResolverKt.GlobalAsyncTypefaceCache;
    }

    public static final androidx.compose.ui.text.font.TypefaceRequestCache getGlobalTypefaceRequestCache() {
        return FontFamilyResolverKt.GlobalTypefaceRequestCache;
    }
}
