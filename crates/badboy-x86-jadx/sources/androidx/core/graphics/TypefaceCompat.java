package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.FontsContractCompat.FontInfo;
import androidx.core.provider.FontsContractCompat.FontRequestCallback;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.List;

/* loaded from: classes5.dex */
public class TypefaceCompat {

    public static final boolean DOWNLOADABLE_FALLBACK_DEBUG = false;
    public static final boolean DOWNLOADABLE_FONT_TRACING = true;
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final androidx.core.graphics.TypefaceCompatBaseImpl sTypefaceCompatImpl;

    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        private ResourcesCompat.FontCallback mFontCallback;
        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            super();
            this.mFontCallback = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat$FontRequestCallback
        public void onTypefaceRequestFailed(int reason) {
            ResourcesCompat.FontCallback mFontCallback;
            if (this.mFontCallback != null) {
                this.mFontCallback.onFontRetrievalFailed(reason);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat$FontRequestCallback
        public void onTypefaceRetrieved(Typeface typeface) {
            ResourcesCompat.FontCallback mFontCallback;
            if (this.mFontCallback != null) {
                this.mFontCallback.onFontRetrieved(typeface);
            }
        }
    }
    static {
        Trace.beginSection("TypefaceCompat static init");
        TypefaceCompatApi29Impl typefaceCompatApi29Impl = new TypefaceCompatApi29Impl();
        TypefaceCompat.sTypefaceCompatImpl = typefaceCompatApi29Impl;
        LruCache lruCache = new LruCache(16);
        TypefaceCompat.sTypefaceCache = lruCache;
        Trace.endSection();
    }

    public static void clearCache() {
        TypefaceCompat.sTypefaceCache.evictAll();
    }

    public static Typeface create(Context context, Typeface family, int style) {
        if (context == null) {
        } else {
            int i = 0;
            return Typeface.create(family, style);
        }
        IllegalArgumentException typefaceFromFamily = new IllegalArgumentException("Context cannot be null");
        throw typefaceFromFamily;
    }

    public static Typeface create(Context context, Typeface family, int weight, boolean italic) {
        Typeface obj4;
        if (context == null) {
        } else {
            Preconditions.checkArgumentInRange(weight, 1, 1000, "weight");
            if (family == null) {
                obj4 = Typeface.DEFAULT;
            }
            return TypefaceCompat.sTypefaceCompatImpl.createWeightStyle(context, obj4, weight, italic);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Context cannot be null");
        throw illegalArgumentException;
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        Trace.beginSection("TypefaceCompat.createFromFontInfo");
        Trace.endSection();
        return TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fonts, style);
    }

    public static Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list3, int style) {
        Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
        Trace.endSection();
        return TypefaceCompat.sTypefaceCompatImpl.createFromFontInfoWithFallback(context, cancellationSignal, list3, style);
    }

    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry entry, Resources resources, int id, int style, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        return TypefaceCompat.createFromResourcesFamilyXml(context, entry, resources, id, 0, 0, style, fontCallback, handler, isRequestFromLayoutInflator);
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry entry, Resources resources, int id, String path, int cookie, int style, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        Typeface providerEntry;
        Typeface systemFontFamily;
        int i;
        int timeout;
        List resourceUid;
        int fallbackRequest;
        Context context2;
        int fetchStrategy;
        int i4;
        int i2;
        int i3;
        Handler handler2;
        androidx.core.graphics.TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter;
        final ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        final Handler handler3 = handler;
        if (entry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            Object obj = entry;
            systemFontFamily = TypefaceCompat.getSystemFontFamily((FontResourcesParserCompat.ProviderResourceEntry)obj.getSystemFontFamilyName());
            if (systemFontFamily != null && fontCallback2 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(systemFontFamily, handler3);
                }
                return systemFontFamily;
            }
            i = 1;
            fallbackRequest = 0;
            if (isRequestFromLayoutInflator) {
                if (obj.getFetchStrategy() == 0) {
                } else {
                    i = fallbackRequest;
                }
            } else {
                if (fontCallback2 == null) {
                } else {
                    i = fallbackRequest;
                }
            }
            if (isRequestFromLayoutInflator) {
                i3 = timeout;
            } else {
                i3 = timeout;
            }
            resourcesCallbackAdapter = new TypefaceCompat.ResourcesCallbackAdapter(fontCallback2);
            if (obj.getFallbackRequest() != null) {
                fetchStrategy = resourceUid;
            } else {
                fetchStrategy = resourceUid;
            }
            providerEntry = FontsContractCompat.requestFont(context, fetchStrategy, style, i, i3, ResourcesCompat.FontCallback.getHandler(handler3), resourcesCallbackAdapter);
        } else {
            providerEntry = TypefaceCompat.sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)entry, resources, style);
            if (fontCallback2 != null) {
                if (providerEntry != null) {
                    fontCallback2.callbackSuccessAsync(providerEntry, handler3);
                } else {
                    fontCallback2.callbackFailAsync(-3, handler3);
                }
            }
        }
        if (providerEntry != null) {
            TypefaceCompat.sTypefaceCache.put(TypefaceCompat.createResourceUid(resources, id, path, cookie, style), providerEntry);
        }
        return providerEntry;
    }

    @Deprecated
    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) {
        return TypefaceCompat.createFromResourcesFontFile(context, resources, id, path, 0, style);
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int cookie, int style) {
        Object obj7;
        LruCache obj8;
        final Resources resources2 = resources;
        final int i = id;
        final String str = path;
        final int i2 = style;
        final Typeface obj6 = TypefaceCompat.sTypefaceCompatImpl.createFromResourcesFontFile(context, resources2, i, str, i2);
        if (obj6 != null) {
            TypefaceCompat.sTypefaceCache.put(TypefaceCompat.createResourceUid(resources2, i, str, cookie, i2), obj6);
        }
        return obj6;
    }

    private static String createResourceUid(Resources resources, int id, String path, int cookie, int style) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 45;
        return stringBuilder.append(resources.getResourcePackageName(id)).append(i).append(path).append(i).append(cookie).append(i).append(id).append(i).append(style).toString();
    }

    @Deprecated
    public static Typeface findFromCache(Resources resources, int id, int style) {
        return TypefaceCompat.findFromCache(resources, id, 0, 0, style);
    }

    public static Typeface findFromCache(Resources resources, int id, String path, int cookie, int style) {
        return (Typeface)TypefaceCompat.sTypefaceCache.get(TypefaceCompat.createResourceUid(resources, id, path, cookie, style));
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface typeface, int style) {
        androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = TypefaceCompat.sTypefaceCompatImpl.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return TypefaceCompat.sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), style);
    }

    private static Typeface getSystemFontFamily(String familyName) {
        int i;
        boolean empty;
        Typeface dEFAULT;
        if (familyName != null) {
            if (familyName.isEmpty()) {
            } else {
                int i2 = 0;
                final Typeface create2 = Typeface.create(familyName, i2);
                if (create2 != null && !create2.equals(Typeface.create(Typeface.DEFAULT, i2))) {
                    if (!create2.equals(create)) {
                        i = create2;
                    }
                }
            }
            return i;
        }
        return null;
    }
}
