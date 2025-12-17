package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes5.dex */
public class EmojiCompat {

    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = null;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile androidx.emoji2.text.EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions = 3;
    private final int mEmojiSpanIndicatorColor = 3;
    private final boolean mEmojiSpanIndicatorEnabled = true;
    private final androidx.emoji2.text.EmojiCompat.GlyphChecker mGlyphChecker = 3;
    private final androidx.emoji2.text.EmojiCompat.CompatInternal mHelper;
    private final Set<androidx.emoji2.text.EmojiCompat.InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock;
    private volatile int mLoadState = 3;
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy = 3;
    final androidx.emoji2.text.EmojiCompat.MetadataRepoLoader mMetadataLoader = 3;
    final boolean mReplaceAll = true;
    private final androidx.emoji2.text.EmojiCompat.SpanFactory mSpanFactory;
    final boolean mUseEmojiAsDefaultStyle = true;

    public interface GlyphChecker {
        public abstract boolean hasGlyph(java.lang.CharSequence charSequence, int i2, int i3, int i4);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable throwable);

        public abstract void onLoaded(androidx.emoji2.text.MetadataRepo metadataRepo);
    }

    private static class CompatInternal {

        final androidx.emoji2.text.EmojiCompat mEmojiCompat;
        CompatInternal(androidx.emoji2.text.EmojiCompat emojiCompat) {
            super();
            this.mEmojiCompat = emojiCompat;
        }

        String getAssetSignature() {
            return "";
        }

        int getEmojiEnd(java.lang.CharSequence cs, int offset) {
            return -1;
        }

        public int getEmojiMatch(java.lang.CharSequence sequence, int metadataVersion) {
            return 0;
        }

        int getEmojiStart(java.lang.CharSequence cs, int offset) {
            return -1;
        }

        boolean hasEmojiGlyph(java.lang.CharSequence sequence) {
            return 0;
        }

        boolean hasEmojiGlyph(java.lang.CharSequence sequence, int metadataVersion) {
            return 0;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount, boolean replaceAll) {
            return charSequence;
        }

        void updateEditorInfoAttrs(EditorInfo outAttrs) {
        }
    }

    private static final class CompatInternal19 extends androidx.emoji2.text.EmojiCompat.CompatInternal {

        private volatile androidx.emoji2.text.MetadataRepo mMetadataRepo;
        private volatile androidx.emoji2.text.EmojiProcessor mProcessor;
        CompatInternal19(androidx.emoji2.text.EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        String getAssetSignature() {
            String str;
            String sourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
            str = sourceSha == null ? "" : sourceSha;
            return str;
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        int getEmojiEnd(java.lang.CharSequence sequence, int offset) {
            return this.mProcessor.getEmojiEnd(sequence, offset);
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        public int getEmojiMatch(java.lang.CharSequence sequence, int metadataVersion) {
            return this.mProcessor.getEmojiMatch(sequence, metadataVersion);
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        int getEmojiStart(java.lang.CharSequence sequence, int offset) {
            return this.mProcessor.getEmojiStart(sequence, offset);
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        boolean hasEmojiGlyph(java.lang.CharSequence sequence) {
            int i;
            if (this.mProcessor.getEmojiMatch(sequence) == 1) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        boolean hasEmojiGlyph(java.lang.CharSequence sequence, int metadataVersion) {
            int i;
            if (this.mProcessor.getEmojiMatch(sequence, metadataVersion) == 1) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        void loadMetadata() {
            androidx.emoji2.text.EmojiCompat.CompatInternal19.1 anon;
            androidx.emoji2.text.EmojiCompat.MetadataRepoLoader mMetadataLoader;
            try {
                anon = new EmojiCompat.CompatInternal19.1(this);
                mEmojiCompat2.mMetadataLoader.load(anon);
                this.mEmojiCompat.onMetadataLoadFailed(th);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        void onMetadataLoadSuccess(androidx.emoji2.text.MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("metadataRepo cannot be null");
                this.mEmojiCompat.onMetadataLoadFailed(illegalArgumentException);
            }
            this.mMetadataRepo = metadataRepo;
            EmojiProcessor emojiProcessor = new EmojiProcessor(this.mMetadataRepo, EmojiCompat.access$000(this.mEmojiCompat), EmojiCompat.access$100(this.mEmojiCompat), mEmojiCompat4.mUseEmojiAsDefaultStyle, mEmojiCompat5.mEmojiAsDefaultStyleExceptions, EmojiExclusions.getEmojiExclusions());
            this.mProcessor = emojiProcessor;
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount, boolean replaceAll) {
            return this.mProcessor.process(charSequence, start, end, maxEmojiCount, replaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
        void updateEditorInfoAttrs(EditorInfo outAttrs) {
            outAttrs.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.mMetadataRepo.getMetadataVersion());
            outAttrs.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", mEmojiCompat.mReplaceAll);
        }
    }

    public static abstract class Config {

        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor = -16711936;
        boolean mEmojiSpanIndicatorEnabled;
        androidx.emoji2.text.EmojiCompat.GlyphChecker mGlyphChecker;
        Set<androidx.emoji2.text.EmojiCompat.InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy = 0;
        final androidx.emoji2.text.EmojiCompat.MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        androidx.emoji2.text.EmojiCompat.SpanFactory mSpanFactory;
        boolean mUseEmojiAsDefaultStyle;
        protected Config(androidx.emoji2.text.EmojiCompat.MetadataRepoLoader metadataLoader) {
            super();
            int i = -16711936;
            int i2 = 0;
            DefaultGlyphChecker defaultGlyphChecker = new DefaultGlyphChecker();
            this.mGlyphChecker = defaultGlyphChecker;
            Preconditions.checkNotNull(metadataLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataLoader;
        }

        protected final androidx.emoji2.text.EmojiCompat.MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        public androidx.emoji2.text.EmojiCompat.Config registerInitCallback(androidx.emoji2.text.EmojiCompat.InitCallback initCallback) {
            Object mInitCallbacks;
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                mInitCallbacks = new ArraySet();
                this.mInitCallbacks = mInitCallbacks;
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setEmojiSpanIndicatorColor(int color) {
            this.mEmojiSpanIndicatorColor = color;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setEmojiSpanIndicatorEnabled(boolean emojiSpanIndicatorEnabled) {
            this.mEmojiSpanIndicatorEnabled = emojiSpanIndicatorEnabled;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setGlyphChecker(androidx.emoji2.text.EmojiCompat.GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setMetadataLoadStrategy(int strategy) {
            this.mMetadataLoadStrategy = strategy;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setReplaceAll(boolean replaceAll) {
            this.mReplaceAll = replaceAll;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setSpanFactory(androidx.emoji2.text.EmojiCompat.SpanFactory factory) {
            this.mSpanFactory = factory;
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config setUseEmojiAsDefaultStyle(boolean useEmojiAsDefaultStyle) {
            return setUseEmojiAsDefaultStyle(useEmojiAsDefaultStyle, 0);
        }

        public androidx.emoji2.text.EmojiCompat.Config setUseEmojiAsDefaultStyle(boolean useEmojiAsDefaultStyle, List<Integer> list2) {
            int i;
            int[] mEmojiAsDefaultStyleExceptions;
            boolean next;
            int[] mEmojiAsDefaultStyleExceptions2;
            int i2;
            int intValue;
            this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
            if (this.mUseEmojiAsDefaultStyle && list2 != null) {
                if (list2 != null) {
                    this.mEmojiAsDefaultStyleExceptions = new int[list2.size()];
                    i = 0;
                    Iterator iterator = list2.iterator();
                    for (Integer next : iterator) {
                        this.mEmojiAsDefaultStyleExceptions[i] = next.intValue();
                        i = i2;
                    }
                    Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
                } else {
                    this.mEmojiAsDefaultStyleExceptions = 0;
                }
            } else {
            }
            return this;
        }

        public androidx.emoji2.text.EmojiCompat.Config unregisterInitCallback(androidx.emoji2.text.EmojiCompat.InitCallback initCallback) {
            Set mInitCallbacks;
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks != null) {
                this.mInitCallbacks.remove(initCallback);
            }
            return this;
        }
    }

    public interface SpanFactory {
        public abstract androidx.emoji2.text.EmojiSpan createSpan(androidx.emoji2.text.TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    public static class DefaultSpanFactory implements androidx.emoji2.text.EmojiCompat.SpanFactory {
        @Override // androidx.emoji2.text.EmojiCompat$SpanFactory
        public androidx.emoji2.text.EmojiSpan createSpan(androidx.emoji2.text.TypefaceEmojiRasterizer rasterizer) {
            TypefaceEmojiSpan typefaceEmojiSpan = new TypefaceEmojiSpan(rasterizer);
            return typefaceEmojiSpan;
        }
    }

    public static abstract class InitCallback {
        public void onFailed(Throwable throwable) {
        }

        public void onInitialized() {
        }
    }

    private static class ListenerDispatcher implements Runnable {

        private final List<androidx.emoji2.text.EmojiCompat.InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;
        ListenerDispatcher(androidx.emoji2.text.EmojiCompat.InitCallback initCallback, int loadState) {
            androidx.emoji2.text.EmojiCompat.InitCallback[] arr = new EmojiCompat.InitCallback[1];
            super(Arrays.asList((EmojiCompat.InitCallback)Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), loadState, 0);
        }

        ListenerDispatcher(Collection<androidx.emoji2.text.EmojiCompat.InitCallback> collection, int loadState) {
            super(collection, loadState, 0);
        }

        ListenerDispatcher(Collection<androidx.emoji2.text.EmojiCompat.InitCallback> collection, int loadState, Throwable throwable) {
            super();
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            ArrayList arrayList = new ArrayList(collection);
            this.mInitCallbacks = arrayList;
            this.mLoadState = loadState;
            this.mThrowable = throwable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Object obj;
            Throwable mThrowable;
            if (/* condition */) {
                i = 0;
                while (i < size2) {
                    (EmojiCompat.InitCallback)this.mInitCallbacks.get(i).onInitialized();
                    i++;
                }
            } else {
                i = 0;
                while (i < size2) {
                    (EmojiCompat.InitCallback)this.mInitCallbacks.get(i).onFailed(this.mThrowable);
                    i++;
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        public abstract void load(androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback emojiCompat$MetadataRepoLoaderCallback);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }
    static {
        Object object = new Object();
        EmojiCompat.INSTANCE_LOCK = object;
        Object object2 = new Object();
        EmojiCompat.CONFIG_LOCK = object2;
    }

    private EmojiCompat(androidx.emoji2.text.EmojiCompat.Config config) {
        androidx.emoji2.text.EmojiCompat.SpanFactory defaultSpanFactory;
        Set mInitCallbacks;
        Set mInitCallbacks2;
        super();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        int i = 3;
        boolean mReplaceAll = config.mReplaceAll;
        boolean mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        int[] mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        boolean mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        int mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        androidx.emoji2.text.EmojiCompat.MetadataRepoLoader mMetadataLoader = config.mMetadataLoader;
        int mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        androidx.emoji2.text.EmojiCompat.GlyphChecker mGlyphChecker = config.mGlyphChecker;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mMainHandler = handler;
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        androidx.emoji2.text.EmojiCompat.SpanFactory mSpanFactory = config.mSpanFactory;
        if (mSpanFactory != null) {
            defaultSpanFactory = mSpanFactory;
        } else {
            defaultSpanFactory = new EmojiCompat.DefaultSpanFactory();
        }
        this.mSpanFactory = defaultSpanFactory;
        if (config.mInitCallbacks != null && !config.mInitCallbacks.isEmpty()) {
            if (!config.mInitCallbacks.isEmpty()) {
                this.mInitCallbacks.addAll(config.mInitCallbacks);
            }
        }
        EmojiCompat.CompatInternal19 compatInternal19 = new EmojiCompat.CompatInternal19(this);
        this.mHelper = compatInternal19;
        loadMetadata();
    }

    static androidx.emoji2.text.EmojiCompat.SpanFactory access$000(androidx.emoji2.text.EmojiCompat x0) {
        return x0.mSpanFactory;
    }

    static androidx.emoji2.text.EmojiCompat.GlyphChecker access$100(androidx.emoji2.text.EmojiCompat x0) {
        return x0.mGlyphChecker;
    }

    public static androidx.emoji2.text.EmojiCompat get() {
        int i;
        final Object iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
        final androidx.emoji2.text.EmojiCompat sInstance = EmojiCompat.sInstance;
        synchronized (iNSTANCE_LOCK) {
            i = 1;
            try {
                Preconditions.checkState(i, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                return sInstance;
                throw localInstance;
            }
        }
    }

    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int beforeLength, int afterLength, boolean inCodePoints) {
        return EmojiProcessor.handleDeleteSurroundingText(inputConnection, editable, beforeLength, afterLength, inCodePoints);
    }

    public static boolean handleOnKeyDown(Editable editable, int keyCode, KeyEvent event) {
        return EmojiProcessor.handleOnKeyDown(editable, keyCode, event);
    }

    public static androidx.emoji2.text.EmojiCompat init(Context context) {
        return EmojiCompat.init(context, 0);
    }

    public static androidx.emoji2.text.EmojiCompat init(Context context, androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultFactory) {
        androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory;
        int i;
        boolean sHasDoneDefaultConfigLookup;
        if (EmojiCompat.sHasDoneDefaultConfigLookup) {
            return EmojiCompat.sInstance;
        }
        if (defaultFactory != null) {
            defaultEmojiCompatConfigFactory = defaultFactory;
        } else {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(0);
        }
        androidx.emoji2.text.EmojiCompat.Config factory = defaultEmojiCompatConfigFactory.create(context);
        Object cONFIG_LOCK = EmojiCompat.CONFIG_LOCK;
        synchronized (cONFIG_LOCK) {
            if (factory != null) {
                EmojiCompat.init(factory);
            }
            EmojiCompat.sHasDoneDefaultConfigLookup = true;
            return EmojiCompat.sInstance;
        }
    }

    public static androidx.emoji2.text.EmojiCompat init(androidx.emoji2.text.EmojiCompat.Config config) {
        androidx.emoji2.text.EmojiCompat localInstance;
        Object iNSTANCE_LOCK;
        androidx.emoji2.text.EmojiCompat emojiCompat;
        iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
        if (EmojiCompat.sInstance == null && EmojiCompat.sInstance == null) {
            iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
            synchronized (iNSTANCE_LOCK) {
                emojiCompat = new EmojiCompat(config);
                EmojiCompat.sInstance = emojiCompat;
            }
        }
        return localInstance;
    }

    public static boolean isConfigured() {
        int i;
        i = EmojiCompat.sInstance != null ? 1 : 0;
        return i;
    }

    private boolean isInitialized() {
        int i;
        if (getLoadState() == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private void loadMetadata() {
        int mMetadataLoadStrategy;
        int loadState;
        this.mInitLock.writeLock().lock();
        if (this.mMetadataLoadStrategy == 0) {
            this.mLoadState = 0;
        }
        this.mInitLock.writeLock().unlock();
        if (getLoadState() == 0) {
            this.mHelper.loadMetadata();
        }
    }

    public static androidx.emoji2.text.EmojiCompat reset(androidx.emoji2.text.EmojiCompat.Config config) {
        final Object iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
        EmojiCompat emojiCompat = new EmojiCompat(config);
        EmojiCompat.sInstance = emojiCompat;
        return emojiCompat;
        synchronized (iNSTANCE_LOCK) {
            iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
            emojiCompat = new EmojiCompat(config);
            EmojiCompat.sInstance = emojiCompat;
            return emojiCompat;
        }
    }

    public static androidx.emoji2.text.EmojiCompat reset(androidx.emoji2.text.EmojiCompat emojiCompat) {
        final Object iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
        EmojiCompat.sInstance = emojiCompat;
        return EmojiCompat.sInstance;
        synchronized (iNSTANCE_LOCK) {
            iNSTANCE_LOCK = EmojiCompat.INSTANCE_LOCK;
            EmojiCompat.sInstance = emojiCompat;
            return EmojiCompat.sInstance;
        }
    }

    public static void skipDefaultConfigurationLookup(boolean shouldSkip) {
        final Object cONFIG_LOCK = EmojiCompat.CONFIG_LOCK;
        EmojiCompat.sHasDoneDefaultConfigLookup = shouldSkip;
        return;
        synchronized (cONFIG_LOCK) {
            cONFIG_LOCK = EmojiCompat.CONFIG_LOCK;
            EmojiCompat.sHasDoneDefaultConfigLookup = shouldSkip;
        }
    }

    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiEnd(java.lang.CharSequence charSequence, int offset) {
        return this.mHelper.getEmojiEnd(charSequence, offset);
    }

    public int getEmojiMatch(java.lang.CharSequence sequence, int metadataVersion) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(sequence, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(sequence, metadataVersion);
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getEmojiStart(java.lang.CharSequence charSequence, int offset) {
        return this.mHelper.getEmojiStart(charSequence, offset);
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        this.mInitLock.readLock().unlock();
        return this.mLoadState;
    }

    @Deprecated
    public boolean hasEmojiGlyph(java.lang.CharSequence sequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(sequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(sequence);
    }

    @Deprecated
    public boolean hasEmojiGlyph(java.lang.CharSequence sequence, int metadataVersion) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(sequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(sequence, metadataVersion);
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        int i;
        final int i2 = 0;
        if (this.mMetadataLoadStrategy == 1) {
        } else {
            i = i2;
        }
        Preconditions.checkState(i, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized()) {
        }
        this.mInitLock.writeLock().lock();
        if (this.mLoadState == 0) {
            this.mInitLock.writeLock().unlock();
        }
        this.mLoadState = i2;
        this.mInitLock.writeLock().unlock();
        this.mHelper.loadMetadata();
    }

    void onMetadataLoadFailed(Throwable throwable) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;
        arrayList.addAll(this.mInitCallbacks);
        this.mInitCallbacks.clear();
        this.mInitLock.writeLock().unlock();
        EmojiCompat.ListenerDispatcher listenerDispatcher = new EmojiCompat.ListenerDispatcher(arrayList, this.mLoadState, throwable);
        this.mMainHandler.post(listenerDispatcher);
    }

    void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;
        arrayList.addAll(this.mInitCallbacks);
        this.mInitCallbacks.clear();
        this.mInitLock.writeLock().unlock();
        EmojiCompat.ListenerDispatcher listenerDispatcher = new EmojiCompat.ListenerDispatcher(arrayList, this.mLoadState);
        this.mMainHandler.post(listenerDispatcher);
    }

    public java.lang.CharSequence process(java.lang.CharSequence charSequence) {
        int length;
        int i = 0;
        if (charSequence == null) {
            length = i;
        } else {
            length = charSequence.length();
        }
        return process(charSequence, i, length);
    }

    public java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end) {
        return process(charSequence, start, end, Integer.MAX_VALUE);
    }

    public java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount) {
        return this.process(charSequence, start, end, maxEmojiCount, 0);
    }

    public java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount, int replaceStrategy) {
        int i;
        int replaceAll;
        int i7;
        int i3;
        java.lang.CharSequence charSequence2;
        int i2;
        int i6;
        int i4;
        int i5;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(start, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(end, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(maxEmojiCount, "maxEmojiCount cannot be negative");
        i = 1;
        int i9 = 0;
        i7 = start <= end ? i : i9;
        Preconditions.checkArgument(i7, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        i3 = start <= charSequence.length() ? i : i9;
        Preconditions.checkArgument(i3, "start should be < than charSequence length");
        if (end <= charSequence.length()) {
        } else {
            i = i9;
        }
        Preconditions.checkArgument(i, "end should be < than charSequence length");
        if (charSequence.length() != 0) {
            if (start == end) {
                charSequence2 = charSequence;
                i2 = start;
                i6 = end;
                i4 = maxEmojiCount;
                return charSequence2;
            } else {
                switch (replaceStrategy) {
                    case 1:
                        i5 = replaceAll;
                        break;
                    case 2:
                        i5 = replaceAll;
                        break;
                    default:
                        i5 = replaceAll;
                }
            }
            return this.mHelper.process(charSequence, start, end, maxEmojiCount, i5);
        }
        charSequence2 = charSequence;
        i2 = start;
        i6 = end;
        i4 = maxEmojiCount;
    }

    public void registerInitCallback(androidx.emoji2.text.EmojiCompat.InitCallback initCallback) {
        Object mInitCallbacks;
        int mLoadState2;
        int listenerDispatcher;
        int mLoadState;
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        if (this.mLoadState != 1) {
            if (this.mLoadState == 2) {
                listenerDispatcher = new EmojiCompat.ListenerDispatcher(initCallback, this.mLoadState);
                this.mMainHandler.post(listenerDispatcher);
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } else {
        }
        this.mInitLock.writeLock().unlock();
    }

    public void unregisterInitCallback(androidx.emoji2.text.EmojiCompat.InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(initCallback);
        this.mInitLock.writeLock().unlock();
    }

    public void updateEditorInfo(EditorInfo outAttrs) {
        Bundle extras;
        if (isInitialized()) {
            if (outAttrs == null) {
            } else {
                if (outAttrs.extras == null) {
                    extras = new Bundle();
                    outAttrs.extras = extras;
                }
            }
            this.mHelper.updateEditorInfoAttrs(outAttrs);
        }
    }
}
