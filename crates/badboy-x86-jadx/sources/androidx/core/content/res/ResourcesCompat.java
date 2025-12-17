package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public final class ResourcesCompat {

    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap<androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey, SparseArray<androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry>> sColorStateCaches;
    private static final java.lang.ThreadLocal<TypedValue> sTempTypedValue;

    static class Api21Impl {
        static Drawable getDrawable(Resources resources, int id, Resources.Theme theme) {
            return resources.getDrawable(id, theme);
        }

        static Drawable getDrawableForDensity(Resources resources, int id, int density, Resources.Theme theme) {
            return resources.getDrawableForDensity(id, density, theme);
        }
    }

    static class Api23Impl {
        static int getColor(Resources resources, int id, Resources.Theme theme) {
            return resources.getColor(id, theme);
        }

        static ColorStateList getColorStateList(Resources res, int id, Resources.Theme theme) {
            return res.getColorStateList(id, theme);
        }
    }

    static class Api29Impl {
        static float getFloat(Resources res, int id) {
            return res.getFloat(id);
        }
    }

    private static class ColorStateListCacheEntry {

        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;
        ColorStateListCacheEntry(ColorStateList value, Configuration configuration, Resources.Theme theme) {
            int i;
            super();
            this.mValue = value;
            this.mConfiguration = configuration;
            if (theme == null) {
                i = 0;
            } else {
                i = theme.hashCode();
            }
            this.mThemeHash = i;
        }
    }

    private static final class ColorStateListCacheKey {

        final Resources mResources;
        final Resources.Theme mTheme;
        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            super();
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object o) {
            int i;
            Class class;
            boolean equals;
            Class class2;
            Object mResources;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (o != null) {
                if (getClass() != o.getClass()) {
                } else {
                    Object obj = o;
                    if (this.mResources.equals(obj.mResources) && ObjectsCompat.equals(this.mTheme, obj.mTheme)) {
                        if (ObjectsCompat.equals(this.mTheme, obj.mTheme)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return ObjectsCompat.hash(/* result */);
        }
    }

    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            Handler handler2;
            Looper mainLooper;
            if (handler == null) {
                handler2 = new Handler(Looper.getMainLooper());
            } else {
                handler2 = handler;
            }
            return handler2;
        }

        public final void callbackFailAsync(int reason, Handler handler) {
            ResourcesCompat.FontCallback$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ResourcesCompat.FontCallback$$ExternalSyntheticLambda1(this, reason);
            ResourcesCompat.FontCallback.getHandler(handler).post(externalSyntheticLambda1);
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            ResourcesCompat.FontCallback$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ResourcesCompat.FontCallback$$ExternalSyntheticLambda0(this, typeface);
            ResourcesCompat.FontCallback.getHandler(handler).post(externalSyntheticLambda0);
        }

        void lambda$callbackFailAsync$1$androidx-core-content-res-ResourcesCompat$FontCallback(int reason) {
            onFontRetrievalFailed(reason);
        }

        void lambda$callbackSuccessAsync$0$androidx-core-content-res-ResourcesCompat$FontCallback(Typeface typeface) {
            onFontRetrieved(typeface);
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static final class ThemeCompat {
        public static void rebase(Resources.Theme theme) {
            ResourcesCompat.ThemeCompat.Api29Impl.rebase(theme);
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        ResourcesCompat.sTempTypedValue = threadLocal;
        WeakHashMap weakHashMap = new WeakHashMap(0);
        ResourcesCompat.sColorStateCaches = weakHashMap;
        Object object = new Object();
        ResourcesCompat.sColorStateCacheLock = object;
    }

    private static void addColorStateListToCache(androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey key, int resId, ColorStateList value, Resources.Theme theme) {
        Object entries;
        WeakHashMap sColorStateCaches;
        final Object sColorStateCacheLock = ResourcesCompat.sColorStateCacheLock;
        synchronized (sColorStateCacheLock) {
            SparseArray sparseArray = new SparseArray();
            ResourcesCompat.sColorStateCaches.put(key, sparseArray);
            ResourcesCompat.ColorStateListCacheEntry colorStateListCacheEntry = new ResourcesCompat.ColorStateListCacheEntry(value, key.mResources.getConfiguration(), theme);
            entries.append(resId, colorStateListCacheEntry);
        }
    }

    public static void clearCachesForTheme(Resources.Theme theme) {
        Object next;
        boolean equals;
        final Object sColorStateCacheLock = ResourcesCompat.sColorStateCacheLock;
        Iterator iterator = ResourcesCompat.sColorStateCaches.keySet().iterator();
        synchronized (sColorStateCacheLock) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((ResourcesCompat.ColorStateListCacheKey)next != null && theme.equals(next.mTheme)) {
                }
                if (theme.equals(next.mTheme)) {
                }
                iterator.remove();
            }
        }
    }

    private static ColorStateList getCachedColorStateList(androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey key, int resId) {
        int size;
        boolean mThemeHash;
        Configuration configuration;
        Object sColorStateCacheLock = ResourcesCompat.sColorStateCacheLock;
        Object obj = ResourcesCompat.sColorStateCaches.get(key);
        synchronized (sColorStateCacheLock) {
            if ((SparseArray)obj.size() > 0) {
                size = obj.get(resId);
                if ((ResourcesCompat.ColorStateListCacheEntry)size != null) {
                    try {
                        if (size.mConfiguration.equals(key.mResources.getConfiguration())) {
                        }
                        if (key.mTheme == null) {
                        } else {
                        }
                        if (size.mThemeHash != 0 && key.mTheme != null && size.mThemeHash == key.mTheme.hashCode()) {
                        }
                        if (key.mTheme != null) {
                        }
                        if (size.mThemeHash == key.mTheme.hashCode()) {
                        }
                        return size.mValue;
                        obj.remove(resId);
                        return null;
                        throw th;
                    }
                }
            }
        }
    }

    public static Typeface getCachedFont(Context context, int id) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return ResourcesCompat.loadFont(context, id, typedValue, 0, 0, 0, false, true);
    }

    public static int getColor(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.Api23Impl.getColor(res, id, theme);
    }

    public static ColorStateList getColorStateList(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        ResourcesCompat.ColorStateListCacheKey colorStateListCacheKey = new ResourcesCompat.ColorStateListCacheKey(res, theme);
        ColorStateList cachedColorStateList = ResourcesCompat.getCachedColorStateList(colorStateListCacheKey, id);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList csl = ResourcesCompat.inflateColorStateList(res, id, theme);
        if (csl != null) {
            ResourcesCompat.addColorStateListToCache(colorStateListCacheKey, id, csl, theme);
            return csl;
        }
        return ResourcesCompat.Api23Impl.getColorStateList(res, id, theme);
    }

    public static Drawable getDrawable(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.Api21Impl.getDrawable(res, id, theme);
    }

    public static Drawable getDrawableForDensity(Resources res, int id, int density, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.Api21Impl.getDrawableForDensity(res, id, density, theme);
    }

    public static float getFloat(Resources res, int id) {
        return ResourcesCompat.Api29Impl.getFloat(res, id);
    }

    public static Typeface getFont(Context context, int id) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return ResourcesCompat.loadFont(context, id, typedValue, 0, 0, 0, false, false);
    }

    public static Typeface getFont(Context context, int id, TypedValue value, int style, androidx.core.content.res.ResourcesCompat.FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, id, value, style, fontCallback, 0, true, false);
    }

    public static void getFont(Context context, int id, androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        }
        TypedValue typedValue = new TypedValue();
        ResourcesCompat.loadFont(context, id, typedValue, 0, fontCallback, handler, false, false);
    }

    private static TypedValue getTypedValue() {
        Object tv;
        java.lang.ThreadLocal sTempTypedValue;
        if ((TypedValue)ResourcesCompat.sTempTypedValue.get() == null) {
            TypedValue typedValue = new TypedValue();
            ResourcesCompat.sTempTypedValue.set(typedValue);
        }
        return tv;
    }

    private static ColorStateList inflateColorStateList(Resources resources, int resId, Resources.Theme theme) {
        if (ResourcesCompat.isColorInt(resources, resId)) {
            return null;
        }
        return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(resId), theme);
    }

    private static boolean isColorInt(Resources resources, int resId) {
        int i;
        int type;
        int i2;
        final TypedValue typedValue = ResourcesCompat.getTypedValue();
        resources.getValue(resId, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            if (typedValue.type <= 31) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static Typeface loadFont(Context context, int id, TypedValue value, int style, androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isRequestFromLayoutInflator, boolean isCachedOnly) {
        final Resources resources = context.getResources();
        resources.getValue(id, value, true);
        final Typeface font = ResourcesCompat.loadFont(context, resources, value, id, style, fontCallback, handler, isRequestFromLayoutInflator, isCachedOnly);
        if (font == null && fontCallback == null) {
            if (fontCallback == null) {
                if (!isCachedOnly) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.append("Font resource ID #0x").append(Integer.toHexString(id)).append(" could not be retrieved.").toString());
                throw notFoundException;
            }
        }
        return font;
    }

    private static Typeface loadFont(Context context, Resources wrapper, TypedValue value, int id, int style, androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isRequestFromLayoutInflator, boolean isCachedOnly) {
        StringBuilder string;
        Resources resources;
        int i;
        String str2;
        String str;
        Resources resources2 = wrapper;
        final Object obj = value;
        int i2 = id;
        final androidx.core.content.res.ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        final Handler handler2 = handler;
        if (obj.string == null) {
        } else {
            String string5 = obj.string.toString();
            final int i6 = -3;
            final int i7 = 0;
            if (!string5.startsWith("res/") && fontCallback2 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackFailAsync(i6, handler2);
                }
                return i7;
            }
            final int i5 = style;
            Typeface fromCache = TypefaceCompat.findFromCache(resources2, i2, string5, obj.assetCookie, i5);
            if (fromCache != null && fontCallback2 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(fromCache, handler2);
                }
                return fromCache;
            }
            if (isCachedOnly) {
                return i7;
            }
            androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources2.getXml(i2), resources2);
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (string5.toLowerCase().endsWith(".xml") && parse == null && fontCallback2 != null) {
                parse = FontResourcesParserCompat.parse(resources2.getXml(i2), resources2);
                if (parse == null) {
                    Log.e(str11, "Failed to find font-family tag");
                    if (fontCallback2 != null) {
                        fontCallback2.callbackFailAsync(i6, handler2);
                    }
                    return i7;
                }
                String str10 = string5;
                String str8 = str10;
                return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources2, i2, str10, obj.assetCookie, i5, fontCallback2, handler2, isRequestFromLayoutInflator);
            }
            Typeface typeface = fromResourcesFontFile;
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.callbackSuccessAsync(typeface, handler2);
                } else {
                    fontCallback2.callbackFailAsync(i6, handler2);
                }
            }
            return typeface;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.append("Resource \"").append(resources2.getResourceName(i2)).append("\" (").append(Integer.toHexString(i2)).append(") is not a Font: ").append(obj).toString());
        throw notFoundException;
    }
}
