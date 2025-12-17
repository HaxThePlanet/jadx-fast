package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticBackport1;
import androidx.core.graphics.TypefaceCompat.ResourcesCallbackAdapter;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class FontsContractCompat {

    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    public static class FontRequestCallback {

        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated
        public static final int RESULT_OK;
        static final int RESULT_SUCCESS;
        public void onTypefaceRequestFailed(int reason) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    public static final class Columns implements BaseColumns {

        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {

        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final List<androidx.core.provider.FontsContractCompat.FontInfo[]> mFonts;
        private final int mStatusCode;
        FontFamilyResult(int statusCode, List<androidx.core.provider.FontsContractCompat.FontInfo[]> list2) {
            super();
            this.mStatusCode = statusCode;
            this.mFonts = list2;
        }

        @Deprecated
        public FontFamilyResult(int statusCode, androidx.core.provider.FontsContractCompat.FontInfo[] fonts) {
            super();
            this.mStatusCode = statusCode;
            this.mFonts = Collections.singletonList(fonts);
        }

        static androidx.core.provider.FontsContractCompat.FontFamilyResult create(int statusCode, List<androidx.core.provider.FontsContractCompat.FontInfo[]> list2) {
            FontsContractCompat.FontFamilyResult fontFamilyResult = new FontsContractCompat.FontFamilyResult(statusCode, list2);
            return fontFamilyResult;
        }

        static androidx.core.provider.FontsContractCompat.FontFamilyResult create(int statusCode, androidx.core.provider.FontsContractCompat.FontInfo[] fonts) {
            FontsContractCompat.FontFamilyResult fontFamilyResult = new FontsContractCompat.FontFamilyResult(statusCode, fonts);
            return fontFamilyResult;
        }

        public androidx.core.provider.FontsContractCompat.FontInfo[] getFonts() {
            return (FontsContractCompat.FontInfo[])this.mFonts.get(0);
        }

        public List<androidx.core.provider.FontsContractCompat.FontInfo[]> getFontsWithFallbacks() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        boolean hasFallback() {
            int i;
            if (this.mFonts.size() > 1) {
            } else {
                i = 0;
            }
            return i;
        }
    }

    public static class FontInfo {

        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;
        @Deprecated
        public FontInfo(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            super();
            this.mUri = (Uri)Preconditions.checkNotNull(uri);
            this.mTtcIndex = ttcIndex;
            this.mWeight = weight;
            this.mItalic = italic;
            this.mResultCode = resultCode;
        }

        static androidx.core.provider.FontsContractCompat.FontInfo create(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            FontsContractCompat.FontInfo fontInfo = new FontsContractCompat.FontInfo(uri, ttcIndex, weight, italic, resultCode);
            return fontInfo;
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TypefaceStyle {
    }
    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, androidx.core.provider.FontsContractCompat.FontInfo[] fonts) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fonts, 0);
    }

    public static androidx.core.provider.FontsContractCompat.FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, androidx.core.provider.FontRequest request) throws PackageManager.NameNotFoundException {
        return FontProvider.getFontFamilyResult(context, TypefaceCompat$$ExternalSyntheticBackport1.m(request), cancellationSignal);
    }

    @Deprecated
    public static Typeface getFontSync(Context context, androidx.core.provider.FontRequest request, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isBlockingFetch, int timeout, int style) {
        TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter = new TypefaceCompat.ResourcesCallbackAdapter(fontCallback);
        return FontsContractCompat.requestFont(context, TypefaceCompat$$ExternalSyntheticBackport1.m(request), style, isBlockingFetch, timeout, ResourcesCompat.FontCallback.getHandler(handler), resourcesCallbackAdapter);
    }

    @Deprecated
    public static ProviderInfo getProvider(PackageManager packageManager, androidx.core.provider.FontRequest request, Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider(packageManager, request, resources);
    }

    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, androidx.core.provider.FontsContractCompat.FontInfo[] fonts, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fonts, cancellationSignal);
    }

    public static Typeface requestFont(Context context, androidx.core.provider.FontRequest request, int style, boolean isBlockingFetch, int timeout, Handler handler, androidx.core.provider.FontsContractCompat.FontRequestCallback callback) {
        return FontsContractCompat.requestFont(context, TypefaceCompat$$ExternalSyntheticBackport1.m(request), style, isBlockingFetch, timeout, handler, callback);
    }

    public static Typeface requestFont(Context context, List<androidx.core.provider.FontRequest> list2, int style, boolean isBlockingFetch, int timeout, Handler handler, androidx.core.provider.FontsContractCompat.FontRequestCallback callback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(callback, RequestExecutor.createHandlerExecutor(handler));
        if (isBlockingFetch) {
            if (list2.size() > 1) {
            } else {
                return FontRequestWorker.requestFontSync(context, (FontRequest)list2.get(0), callbackWrapper, style, timeout);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
            throw illegalArgumentException;
        }
        return FontRequestWorker.requestFontAsync(context, list2, style, 0, callbackWrapper);
    }

    public static void requestFont(Context context, androidx.core.provider.FontRequest request, int style, Executor loadingExecutor, Executor callbackExecutor, androidx.core.provider.FontsContractCompat.FontRequestCallback callback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(callback, callbackExecutor);
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), TypefaceCompat$$ExternalSyntheticBackport1.m(request), style, loadingExecutor, callbackWrapper);
    }

    @Deprecated
    public static void requestFont(Context context, androidx.core.provider.FontRequest request, androidx.core.provider.FontsContractCompat.FontRequestCallback callback, Handler handler) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(callback);
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), TypefaceCompat$$ExternalSyntheticBackport1.m(request), 0, RequestExecutor.createHandlerExecutor(handler), callbackWrapper);
    }

    public static void requestFontWithFallbackChain(Context context, List<androidx.core.provider.FontRequest> list2, int style, Executor loadingExecutor, Executor callbackExecutor, androidx.core.provider.FontsContractCompat.FontRequestCallback callback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(callback, callbackExecutor);
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), list2, style, loadingExecutor, callbackWrapper);
    }

    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}
