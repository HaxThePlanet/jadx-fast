package androidx.emoji2.text;

import android.content.Context;
import android.os.Handler;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes5.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {

    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500L;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    static class BackgroundDefaultConfig extends androidx.emoji2.text.EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader = new EmojiCompatInitializer.BackgroundDefaultLoader(context);
            super(backgroundDefaultLoader);
            setMetadataLoadStrategy(1);
        }
    }

    static class BackgroundDefaultLoader implements androidx.emoji2.text.EmojiCompat.MetadataRepoLoader {

        private final Context mContext;
        BackgroundDefaultLoader(Context context) {
            super();
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        void doLoad(androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback loaderCallback, ThreadPoolExecutor executor) {
            androidx.emoji2.text.FontRequestEmojiCompatConfig create;
            try {
                create = DefaultEmojiCompatConfig.create(this.mContext);
                if (create == null) {
                } else {
                }
                create.setLoadingExecutor(executor);
                EmojiCompatInitializer.BackgroundDefaultLoader.1 anon = new EmojiCompatInitializer.BackgroundDefaultLoader.1(this, loaderCallback, executor);
                create.getMetadataRepoLoader().load(anon);
                RuntimeException runtimeException = new RuntimeException("EmojiCompat font provider not available on this device.");
                throw runtimeException;
                loaderCallback.onFailed(config);
                executor.shutdown();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        void lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader(androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback loaderCallback, ThreadPoolExecutor executor) {
            doLoad(loaderCallback, executor);
        }

        @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoader
        public void load(androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback loaderCallback) {
            ThreadPoolExecutor backgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("EmojiCompatInitializer");
            EmojiCompatInitializer.BackgroundDefaultLoader$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new EmojiCompatInitializer.BackgroundDefaultLoader$$ExternalSyntheticLambda0(this, loaderCallback, backgroundPriorityExecutor);
            backgroundPriorityExecutor.execute(externalSyntheticLambda0);
        }
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            boolean configured;
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                }
                EmojiCompat.get().load();
                TraceCompat.endSection();
                TraceCompat.endSection();
                throw th;
            }
        }
    }
    @Override // androidx.startup.Initializer
    public Boolean create(Context context) {
        EmojiCompatInitializer.BackgroundDefaultConfig backgroundDefaultConfig = new EmojiCompatInitializer.BackgroundDefaultConfig(context);
        EmojiCompat.init(backgroundDefaultConfig);
        delayUntilFirstResume(context);
        return true;
    }

    @Override // androidx.startup.Initializer
    public Object create(Context context) {
        return create(context);
    }

    @Override // androidx.startup.Initializer
    void delayUntilFirstResume(Context context) {
        final Lifecycle lifecycle = (LifecycleOwner)AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class).getLifecycle();
        EmojiCompatInitializer.1 anon = new EmojiCompatInitializer.1(this, lifecycle);
        lifecycle.addObserver(anon);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // androidx.startup.Initializer
    void loadEmojiCompatAfterDelay() {
        EmojiCompatInitializer.LoadEmojiCompatRunnable loadEmojiCompatRunnable = new EmojiCompatInitializer.LoadEmojiCompatRunnable();
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(loadEmojiCompatRunnable, 500);
    }
}
