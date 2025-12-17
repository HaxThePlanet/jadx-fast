package androidx.emoji2.text;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.FontsContractCompat.FontFamilyResult;
import androidx.core.provider.FontsContractCompat.FontInfo;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes5.dex */
public class FontRequestEmojiCompatConfig extends androidx.emoji2.text.EmojiCompat.Config {

    private static final androidx.emoji2.text.FontRequestEmojiCompatConfig.FontProviderHelper DEFAULT_FONTS_CONTRACT;

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public static class ExponentialBackoffRetryPolicy extends androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy {

        private long mRetryOrigin;
        private final long mTotalMs;
        public ExponentialBackoffRetryPolicy(long totalMs) {
            super();
            this.mTotalMs = totalMs;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy
        public long getRetryDelay() {
            int i2 = 0;
            if (Long.compare(mRetryOrigin, i2) == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return i2;
            }
            uptimeMillis2 -= mRetryOrigin2;
            if (Long.compare(i, mTotalMs) > 0) {
                return -1;
            }
            return Math.min(Math.max(i, obj1), obj3);
        }
    }

    public static class FontProviderHelper {
        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo font) throws PackageManager.NameNotFoundException {
            FontsContractCompat.FontInfo[] arr = new FontsContractCompat.FontInfo[1];
            return FontsContractCompat.buildTypeface(context, 0, arr);
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest request) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, 0, request);
        }

        public void registerObserver(Context context, Uri uri, ContentObserver observer) {
            context.getContentResolver().registerContentObserver(uri, false, observer);
        }

        public void unregisterObserver(Context context, ContentObserver observer) {
            context.getContentResolver().unregisterContentObserver(observer);
        }
    }

    private static class FontRequestMetadataLoader implements androidx.emoji2.text.EmojiCompat.MetadataRepoLoader {

        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final androidx.emoji2.text.FontRequestEmojiCompatConfig.FontProviderHelper mFontProviderHelper;
        private final Object mLock;
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy mRetryPolicy;
        FontRequestMetadataLoader(Context context, FontRequest request, androidx.emoji2.text.FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper) {
            super();
            Object object = new Object();
            this.mLock = object;
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(request, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = request;
            this.mFontProviderHelper = fontProviderHelper;
        }

        private void cleanUp() {
            Object mFontProviderHelper;
            Handler mMainHandler;
            ThreadPoolExecutor mMyThreadPoolExecutor;
            Context mMainHandlerLoadCallback;
            ContentObserver mObserver;
            final Object mLock = this.mLock;
            final int i = 0;
            this.mCallback = i;
            synchronized (mLock) {
                this.mFontProviderHelper.unregisterObserver(this.mContext, this.mObserver);
                this.mObserver = i;
                if (this.mMainHandler != null) {
                    this.mMainHandler.removeCallbacks(this.mMainHandlerLoadCallback);
                }
                try {
                    this.mMainHandler = i;
                    if (this.mMyThreadPoolExecutor != null) {
                    }
                    this.mMyThreadPoolExecutor.shutdown();
                    this.mExecutor = i;
                    this.mMyThreadPoolExecutor = i;
                    throw th;
                }
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontRequest mRequest;
            try {
                FontsContractCompat.FontFamilyResult fonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fonts.getStatusCode() != 0) {
                } else {
                }
                FontsContractCompat.FontInfo[] fonts3 = fonts.getFonts();
                if (fonts3 == null) {
                } else {
                }
                if (fonts3.length == 0) {
                } else {
                }
                return fonts3[0];
                RuntimeException runtimeException2 = new RuntimeException("fetchFonts failed (empty result)");
                throw runtimeException2;
                StringBuilder stringBuilder = new StringBuilder();
                RuntimeException fonts2 = new RuntimeException(stringBuilder.append("fetchFonts failed (").append(fonts.getStatusCode()).append(")").toString());
                throw fonts2;
                RuntimeException runtimeException = new RuntimeException("provider not found", result);
                throw runtimeException;
            }
        }

        private void scheduleRetry(Uri uri, long waitMs) {
            Handler handler;
            Handler mainHandlerAsync;
            Object mFontProviderHelper;
            Runnable mMainHandlerLoadCallback;
            Context mContext;
            ContentObserver mObserver;
            final Object mLock = this.mLock;
            synchronized (mLock) {
                this.mMainHandler = ConcurrencyHelpers.mainHandlerAsync();
                if (this.mObserver == null) {
                    try {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1 anon = new FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1(this, handler);
                        this.mObserver = anon;
                        this.mFontProviderHelper.registerObserver(this.mContext, uri, this.mObserver);
                        if (this.mMainHandlerLoadCallback == null) {
                        }
                        mMainHandlerLoadCallback = new FontRequestEmojiCompatConfig.FontRequestMetadataLoader$$ExternalSyntheticLambda1(this);
                        this.mMainHandlerLoadCallback = mMainHandlerLoadCallback;
                        handler.postDelayed(this.mMainHandlerLoadCallback, waitMs);
                        throw th;
                    }
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        void createMetadata() {
            FontsContractCompat.FontInfo retrieveFontInfo;
            Throwable t;
            int resultCode;
            Throwable mLock2;
            int mLock3;
            Object mLock;
            androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy mRetryPolicy;
            androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback mCallback;
            int cmp;
            Object mLock4 = this.mLock;
            synchronized (mLock4) {
            }
            mLock3 = this.mLock;
            synchronized (mLock3) {
                mRetryPolicy = this.mRetryPolicy.getRetryDelay();
                if (Long.compare(mRetryPolicy, i) >= 0) {
                    scheduleRetry(retrieveFontInfo.getUri(), mRetryPolicy);
                }
            }
            if (resultCode != 0) {
            } else {
                TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                Typeface typeface = this.mFontProviderHelper.buildTypeface(this.mContext, retrieveFontInfo);
                java.nio.ByteBuffer mmap = TypefaceCompatUtil.mmap(this.mContext, 0, retrieveFontInfo.getUri());
                if (mmap == null) {
                } else {
                    try {
                        if (typeface == null) {
                        } else {
                        }
                        TraceCompat.endSection();
                        mLock = this.mLock;
                        if (this.mCallback != null) {
                        }
                        this.mCallback.onLoaded(MetadataRepo.create(typeface, mmap));
                        cleanUp();
                        throw mRetryPolicy;
                        RuntimeException metadataRepo = new RuntimeException("Unable to open file.");
                        throw metadataRepo;
                        TraceCompat.endSection();
                        throw mLock2;
                        StringBuilder stringBuilder = new StringBuilder();
                        RuntimeException runtimeException = new RuntimeException(stringBuilder.append("fetchFonts result is not OK. (").append(resultCode).append(")").toString());
                        throw runtimeException;
                        t = th;
                        mLock2 = this.mLock;
                        Throwable th = this.mCallback;
                        if (th != null) {
                        }
                        th = this.mCallback;
                        th.onFailed(t);
                        cleanUp();
                        throw th;
                        throw t;
                    } catch (Throwable th) {
                    }
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        public void load(androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback loaderCallback) {
            Preconditions.checkNotNull(loaderCallback, "LoaderCallback cannot be null");
            Object mLock = this.mLock;
            this.mCallback = loaderCallback;
            loadInternal();
            return;
            synchronized (mLock) {
                Preconditions.checkNotNull(loaderCallback, "LoaderCallback cannot be null");
                mLock = this.mLock;
                this.mCallback = loaderCallback;
                loadInternal();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        void loadInternal() {
            Object mMyThreadPoolExecutor;
            final Object mLock = this.mLock;
            synchronized (mLock) {
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        public void setExecutor(Executor executor) {
            final Object mLock = this.mLock;
            this.mExecutor = executor;
            return;
            synchronized (mLock) {
                mLock = this.mLock;
                this.mExecutor = executor;
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        public void setRetryPolicy(androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy policy) {
            final Object mLock = this.mLock;
            this.mRetryPolicy = policy;
            return;
            synchronized (mLock) {
                mLock = this.mLock;
                this.mRetryPolicy = policy;
            }
        }
    }
    static {
        FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper = new FontRequestEmojiCompatConfig.FontProviderHelper();
        FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT = fontProviderHelper;
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest request) {
        FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = new FontRequestEmojiCompatConfig.FontRequestMetadataLoader(context, request, FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT);
        super(fontRequestMetadataLoader);
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest request, androidx.emoji2.text.FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper) {
        FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = new FontRequestEmojiCompatConfig.FontRequestMetadataLoader(context, request, fontProviderHelper);
        super(fontRequestMetadataLoader);
    }

    @Deprecated
    public androidx.emoji2.text.FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    @Override // androidx.emoji2.text.EmojiCompat$Config
    public androidx.emoji2.text.FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        (FontRequestEmojiCompatConfig.FontRequestMetadataLoader)getMetadataRepoLoader().setExecutor(executor);
        return this;
    }

    @Override // androidx.emoji2.text.EmojiCompat$Config
    public androidx.emoji2.text.FontRequestEmojiCompatConfig setRetryPolicy(androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy policy) {
        (FontRequestEmojiCompatConfig.FontRequestMetadataLoader)getMetadataRepoLoader().setRetryPolicy(policy);
        return this;
    }
}
