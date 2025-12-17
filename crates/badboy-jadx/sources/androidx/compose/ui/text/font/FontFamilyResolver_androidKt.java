package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001aD\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008*\u00020\u00012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "emptyCacheFontFamilyResolver", "resolveAsTypeface", "Landroidx/compose/runtime/State;", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolveAsTypeface-Wqqsr6A", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontFamilyResolver_androidKt {
    public static final androidx.compose.ui.text.font.FontFamily.Resolver createFontFamilyResolver(Context context) {
        AndroidFontLoader androidFontLoader = new AndroidFontLoader(context);
        FontFamilyResolverImpl fontFamilyResolverImpl = new FontFamilyResolverImpl((PlatformFontLoader)androidFontLoader, (PlatformResolveInterceptor)AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), 0, 0, 0, 28, 0);
        return (FontFamily.Resolver)fontFamilyResolverImpl;
    }

    public static final androidx.compose.ui.text.font.FontFamily.Resolver createFontFamilyResolver(Context context, CoroutineContext coroutineContext) {
        AndroidFontLoader androidFontLoader = new AndroidFontLoader(context);
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), coroutineContext);
        FontFamilyResolverImpl fontFamilyResolverImpl = new FontFamilyResolverImpl((PlatformFontLoader)androidFontLoader, (PlatformResolveInterceptor)AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), fontListFontFamilyTypefaceAdapter, 0, 16, 0);
        return (FontFamily.Resolver)fontFamilyResolverImpl;
    }

    public static final androidx.compose.ui.text.font.FontFamily.Resolver emptyCacheFontFamilyResolver(Context context) {
        AndroidFontLoader androidFontLoader = new AndroidFontLoader(context);
        TypefaceRequestCache typefaceRequestCache = new TypefaceRequestCache();
        AsyncTypefaceCache asyncTypefaceCache = new AsyncTypefaceCache();
        final int i2 = 0;
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter(asyncTypefaceCache, i2, 2, i2);
        FontFamilyResolverImpl fontFamilyResolverImpl = new FontFamilyResolverImpl((PlatformFontLoader)androidFontLoader, 0, typefaceRequestCache, fontListFontFamilyTypefaceAdapter, i2, 18, 0);
        return (FontFamily.Resolver)fontFamilyResolverImpl;
    }

    public static final State<Typeface> resolveAsTypeface-Wqqsr6A(androidx.compose.ui.text.font.FontFamily.Resolver $this$resolveAsTypeface_u2dWqqsr6A, androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        final State resolve-DPcqOEQ = $this$resolveAsTypeface_u2dWqqsr6A.resolve-DPcqOEQ(fontFamily, fontWeight, fontStyle, fontSynthesis);
        Intrinsics.checkNotNull(resolve-DPcqOEQ, "null cannot be cast to non-null type androidx.compose.runtime.State<android.graphics.Typeface>");
        return resolve-DPcqOEQ;
    }

    public static State resolveAsTypeface-Wqqsr6A$default(androidx.compose.ui.text.font.FontFamily.Resolver fontFamily$Resolver, androidx.compose.ui.text.font.FontFamily fontFamily2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, int i6, Object object7) {
        int obj1;
        androidx.compose.ui.text.font.FontWeight obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = 0;
        }
        if (i6 & 2 != 0) {
            obj2 = FontWeight.Companion.getNormal();
        }
        if (i6 & 4 != 0) {
            obj3 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i6 &= 8 != 0) {
            obj4 = FontSynthesis.Companion.getAll-GVVA2EU();
        }
        return FontFamilyResolver_androidKt.resolveAsTypeface-Wqqsr6A(resolver, obj1, obj2, obj3, obj4);
    }
}
