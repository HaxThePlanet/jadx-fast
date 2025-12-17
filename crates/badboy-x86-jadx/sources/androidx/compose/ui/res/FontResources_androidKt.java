package androidx.compose.ui.res;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.Typeface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0008\u001a\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0004H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"cacheLock", "Ljava/lang/Object;", "syncLoadedTypefaces", "", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/Typeface;", "fontResource", "fontFamily", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/font/Typeface;", "fontResourceFromContext", "context", "Landroid/content/Context;", "a", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontResources_androidKt {

    private static final Object cacheLock;
    private static final Map<FontFamily, Typeface> syncLoadedTypefaces;
    static {
        Object object = new Object();
        FontResources_androidKt.cacheLock = object;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FontResources_androidKt.syncLoadedTypefaces = (Map)linkedHashMap;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer to preload fonts using FontFamily.Resolver.", replaceWith = @ReplaceWith(...))
    public static final Typeface fontResource(FontFamily fontFamily, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -190831095;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(fontResource)54@1901L7:FontResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.fontResource (FontResources.android.kt:53)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return FontResources_androidKt.fontResourceFromContext((Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()), fontFamily);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer to preload fonts using FontFamily.Resolver.", replaceWith = @ReplaceWith(...))
    private static final Typeface fontResourceFromContext(Context context, FontFamily a) {
        boolean z;
        Object obj;
        int i;
        int i2 = 4;
        final int i3 = 0;
        if (!a instanceof SystemFontFamily && a instanceof LoadedFontFamily) {
            if (a instanceof LoadedFontFamily) {
            }
            return AndroidTypeface_androidKt.Typeface$default(context, a, i3, i2, i3);
        }
        Object cacheLock = FontResources_androidKt.cacheLock;
        final int i4 = 0;
        final Map syncLoadedTypefaces = FontResources_androidKt.syncLoadedTypefaces;
        final int i5 = 0;
        final Object obj2 = syncLoadedTypefaces.get(a);
        synchronized (cacheLock) {
            i = 0;
            syncLoadedTypefaces.put(a, AndroidTypeface_androidKt.Typeface$default(context, a, i3, i2, i3));
            return (Typeface)obj;
        }
    }
}
