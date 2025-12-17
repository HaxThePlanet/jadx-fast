package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000cH\u0002¨\u0006\r", d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontListFontFamilyTypefaceAdapterKt {
    public static final Pair access$firstImmediatelyAvailable(List $receiver, androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Function1 createDefaultTypeface) {
        return FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable($receiver, typefaceRequest, asyncTypefaceCache, platformFontLoader, createDefaultTypeface);
    }

    private static final Pair<List<androidx.compose.ui.text.font.Font>, Object> firstImmediatelyAvailable(List<? extends androidx.compose.ui.text.font.Font> $this$firstImmediatelyAvailable, androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends Object> createDefaultTypeface) {
        int i2;
        int i3;
        Object constructor-impl;
        int permanentFailure-impl;
        Object obj3;
        Object obj;
        Object synchronizedObject;
        int companion;
        int i;
        Object blocking;
        int string;
        androidx.compose.ui.text.font.AsyncTypefaceCache.Key key;
        int str;
        Object obj2;
        int asyncFontsToLoad;
        int idx;
        int i4;
        Object unbox-impl2;
        Object unbox-impl;
        final androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader2 = platformFontLoader;
        asyncFontsToLoad = i2;
        idx = permanentFailure-impl;
        while (idx < $this$firstImmediatelyAvailable.size()) {
            obj3 = obj4;
            int loadingStrategy-PKNRLFQ = (Font)obj3.getLoadingStrategy-PKNRLFQ();
            i2 = asyncTypefaceCache.get-1ASDuI8(obj3, platformFontLoader2);
            idx++;
            if (asyncFontsToLoad == 0) {
            } else {
            }
            asyncFontsToLoad.add(obj3);
            androidx.compose.ui.text.font.Font[] arr = new Font[1];
            asyncFontsToLoad = permanentFailure-impl;
            permanentFailure-impl = asyncTypefaceCache;
            i4 = 0;
            obj = AsyncTypefaceCache.access$getCacheLock$p(permanentFailure-impl);
            companion = 0;
            i2 = 0;
            string = new AsyncTypefaceCache.Key(obj3, platformFontLoader2.getCacheKey());
            if ((AsyncTypefaceCache.AsyncTypefaceResult)AsyncTypefaceCache.access$getResultCache$p(permanentFailure-impl).get(string) == null) {
            }
            if (str != null) {
            } else {
            }
            Unit iNSTANCE2 = Unit.INSTANCE;
            int lock$iv$iv2 = 0;
            kotlin.Result.Companion companion2 = Result.Companion;
            int i5 = 0;
            constructor-impl = Result.constructor-impl(platformFontLoader2.loadBlocking(obj3));
            if (Result.isFailure-impl(constructor-impl)) {
            }
            i2 = 0;
            AsyncTypefaceCache.put$default(permanentFailure-impl, obj3, platformFontLoader2, constructor-impl, false, 8, 0);
            constructor-impl = 0;
            unbox-impl = str.unbox-impl();
            str = AsyncTypefaceCache.access$getPermanentCache$p(permanentFailure-impl).get(string);
            companion = Result.Companion;
            Throwable th = ResultKt.createFailure(th);
            th = Result.constructor-impl(th);
        }
        return TuplesKt.to(asyncFontsToLoad, createDefaultTypeface.invoke(typefaceRequest));
    }
}
