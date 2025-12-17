package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ProfileInstallerInitializer implements Initializer<androidx.profileinstaller.ProfileInstallerInitializer.Result> {

    private static final int DELAY_MS = 5000;

    private static class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class Result {
    }
    static void lambda$installAfterDelay$1(Context appContext) {
        ProfileInstallerInitializer.writeInBackground(appContext);
    }

    static void lambda$writeInBackground$2(Context context) {
        ProfileInstaller.writeProfile(context);
    }

    private static void writeInBackground(Context context) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0, obj4, TimeUnit.MILLISECONDS, linkedBlockingQueue);
        ProfileInstallerInitializer$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new ProfileInstallerInitializer$$ExternalSyntheticLambda2(context);
        threadPoolExecutor.execute(externalSyntheticLambda2);
    }

    @Override // androidx.startup.Initializer
    public androidx.profileinstaller.ProfileInstallerInitializer.Result create(Context context) {
        ProfileInstallerInitializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ProfileInstallerInitializer$$ExternalSyntheticLambda0(this, context.getApplicationContext());
        Choreographer.getInstance().postFrameCallback(externalSyntheticLambda0);
        ProfileInstallerInitializer.Result result = new ProfileInstallerInitializer.Result();
        return result;
    }

    public Object create(Context context) {
        return create(context);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    @Override // androidx.startup.Initializer
    void installAfterDelay(Context appContext) {
        Random random = new Random();
        ProfileInstallerInitializer$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ProfileInstallerInitializer$$ExternalSyntheticLambda1(appContext);
        ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper()).postDelayed(externalSyntheticLambda1, (long)i4);
    }

    @Override // androidx.startup.Initializer
    void lambda$create$0$androidx-profileinstaller-ProfileInstallerInitializer(Context appContext, long frameTimeNanos) {
        installAfterDelay(appContext);
    }
}
