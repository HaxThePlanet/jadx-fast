package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontResourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DelegatingFontLoaderForDeprecatedUsage_androidKt {
    @Deprecated(message = "This exists to bridge existing Font.ResourceLoader APIs, and should be removed with them", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.font.FontFamily.Resolver createFontFamilyResolver(androidx.compose.ui.text.font.Font.ResourceLoader fontResourceLoader) {
        DelegatingFontLoaderForDeprecatedUsage delegatingFontLoaderForDeprecatedUsage = new DelegatingFontLoaderForDeprecatedUsage(fontResourceLoader);
        FontFamilyResolverImpl fontFamilyResolverImpl = new FontFamilyResolverImpl((PlatformFontLoader)delegatingFontLoaderForDeprecatedUsage, 0, 0, 0, 0, 30, 0);
        return (FontFamily.Resolver)fontFamilyResolverImpl;
    }

    @Deprecated(message = "This exists to bridge existing Font.ResourceLoader subclasses to be used as aFontFamily.ResourceLoader during upgrade.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.font.FontFamily.Resolver createFontFamilyResolver(androidx.compose.ui.text.font.Font.ResourceLoader fontResourceLoader, Context context) {
        DelegatingFontLoaderForBridgeUsage delegatingFontLoaderForBridgeUsage = new DelegatingFontLoaderForBridgeUsage(fontResourceLoader, context.getApplicationContext());
        FontFamilyResolverImpl fontFamilyResolverImpl = new FontFamilyResolverImpl((PlatformFontLoader)delegatingFontLoaderForBridgeUsage, 0, 0, 0, 0, 30, 0);
        return (FontFamily.Resolver)fontFamilyResolverImpl;
    }
}
