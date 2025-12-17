package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticBackport1;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes5.dex */
class FontRequestWorker {

    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    static final Object LOCK;
    static final SimpleArrayMap<String, ArrayList<Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>>> PENDING_REPLIES;
    static final LruCache<String, Typeface> sTypefaceCache;

    static final class TypefaceResult {

        final int mResult;
        final Typeface mTypeface;
        TypefaceResult(int result) {
            super();
            this.mTypeface = 0;
            this.mResult = result;
        }

        TypefaceResult(Typeface typeface) {
            super();
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        boolean isSuccess() {
            int i;
            i = this.mResult == null ? 1 : 0;
            return i;
        }
    }
    static {
        LruCache lruCache = new LruCache(16);
        FontRequestWorker.sTypefaceCache = lruCache;
        FontRequestWorker.DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        Object object = new Object();
        FontRequestWorker.LOCK = object;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        FontRequestWorker.PENDING_REPLIES = simpleArrayMap;
    }

    private static String createCacheId(List<androidx.core.provider.FontRequest> list, int style) {
        int i;
        int str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < list.size()) {
            stringBuilder.append((FontRequest)list.get(i).getId()).append("-").append(style);
            if (i < size2--) {
            }
            i++;
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

    private static int getFontFamilyResultStatus(androidx.core.provider.FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i2;
        int length;
        int i;
        androidx.core.provider.FontsContractCompat.FontInfo fontInfo;
        int resultCode;
        if (fontFamilyResult.getStatusCode() != 0 && /* condition */) {
            if (/* condition */) {
                return -2;
            }
            return -3;
        }
        androidx.core.provider.FontsContractCompat.FontInfo[] fonts2 = fontFamilyResult.getFonts();
        if (fonts2 != null) {
            if (fonts2.length == 0) {
            } else {
                final int i5 = 0;
                i = i5;
                while (i < fonts2.length) {
                    resultCode = fonts2[i].getResultCode();
                    i++;
                }
            }
            return i5;
        }
        return 1;
    }

    static androidx.core.provider.FontRequestWorker.TypefaceResult getFontSync(String cacheId, Context context, List<androidx.core.provider.FontRequest> list3, int style) {
        Typeface fromFontInfoWithFallback;
        androidx.core.provider.FontsContractCompat.FontInfo[] fontsWithFallbacks;
        Trace.beginSection("getFontSync");
        Object obj = FontRequestWorker.sTypefaceCache.get(cacheId);
        if ((Typeface)obj != null) {
            FontRequestWorker.TypefaceResult typefaceResult2 = new FontRequestWorker.TypefaceResult((Typeface)obj);
            Trace.endSection();
            return typefaceResult2;
        }
        int i = 0;
        final androidx.core.provider.FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, list3, i);
        final int fontFamilyResultStatus = FontRequestWorker.getFontFamilyResultStatus(fontFamilyResult);
        if (fontFamilyResultStatus != 0) {
            FontRequestWorker.TypefaceResult typefaceResult = new FontRequestWorker.TypefaceResult(fontFamilyResultStatus);
            Trace.endSection();
            return typefaceResult;
        }
        if (fontFamilyResult.hasFallback()) {
            try {
                fromFontInfoWithFallback = TypefaceCompat.createFromFontInfoWithFallback(context, i, fontFamilyResult.getFontsWithFallbacks(), style);
                fromFontInfoWithFallback = TypefaceCompat.createFromFontInfo(context, i, fontFamilyResult.getFonts(), style);
                if (fromFontInfoWithFallback != null) {
                }
                FontRequestWorker.sTypefaceCache.put(cacheId, fromFontInfoWithFallback);
                FontRequestWorker.TypefaceResult typefaceResult5 = new FontRequestWorker.TypefaceResult(fromFontInfoWithFallback);
                Trace.endSection();
                return typefaceResult5;
                FontRequestWorker.TypefaceResult typefaceResult4 = new FontRequestWorker.TypefaceResult(-3);
                Trace.endSection();
                return typefaceResult4;
                FontRequestWorker.TypefaceResult typefaceResult3 = new FontRequestWorker.TypefaceResult(-1);
                Trace.endSection();
                return typefaceResult3;
                Trace.endSection();
                throw cached;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            } catch (Throwable th1) {
            }
        } else {
        }
    }

    static Typeface requestFontAsync(Context context, List<androidx.core.provider.FontRequest> list2, int style, Executor executor, androidx.core.provider.CallbackWrapper callback) {
        ExecutorService dEFAULT_EXECUTOR_SERVICE;
        final String cacheId = FontRequestWorker.createCacheId(list2, style);
        Object obj = FontRequestWorker.sTypefaceCache.get(cacheId);
        if ((Typeface)obj != null) {
            FontRequestWorker.TypefaceResult typefaceResult = new FontRequestWorker.TypefaceResult((Typeface)obj);
            callback.onTypefaceResult(typefaceResult);
            return obj;
        }
        FontRequestWorker.2 anon = new FontRequestWorker.2(callback);
        Object lOCK = FontRequestWorker.LOCK;
        Object obj2 = FontRequestWorker.PENDING_REPLIES.get(cacheId);
        final int i = 0;
        synchronized (lOCK) {
            (ArrayList)obj2.add(anon);
            return i;
        }
        dEFAULT_EXECUTOR_SERVICE = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
        FontRequestWorker.4 anon3 = new FontRequestWorker.4(cacheId);
        RequestExecutor.execute(dEFAULT_EXECUTOR_SERVICE, anon2, anon3);
        return i;
    }

    static Typeface requestFontSync(Context context, androidx.core.provider.FontRequest request, androidx.core.provider.CallbackWrapper callback, int style, int timeoutInMillis) {
        String cacheId = FontRequestWorker.createCacheId(TypefaceCompat$$ExternalSyntheticBackport1.m(request), style);
        Object obj = FontRequestWorker.sTypefaceCache.get(cacheId);
        if ((Typeface)obj != null) {
            FontRequestWorker.TypefaceResult typefaceResult = new FontRequestWorker.TypefaceResult((Typeface)obj);
            callback.onTypefaceResult(typefaceResult);
            return obj;
        }
        if (timeoutInMillis == -1) {
            androidx.core.provider.FontRequestWorker.TypefaceResult fontSync = FontRequestWorker.getFontSync(cacheId, context, TypefaceCompat$$ExternalSyntheticBackport1.m(request), style);
            callback.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        FontRequestWorker.1 typefaceResult2 = new FontRequestWorker.1(cacheId, context, request, style);
        Object submit = RequestExecutor.submit(FontRequestWorker.DEFAULT_EXECUTOR_SERVICE, typefaceResult2, timeoutInMillis);
        callback.onTypefaceResult((FontRequestWorker.TypefaceResult)submit);
        return submit.mTypeface;
    }

    static void resetTypefaceCache() {
        FontRequestWorker.sTypefaceCache.evictAll();
    }
}
