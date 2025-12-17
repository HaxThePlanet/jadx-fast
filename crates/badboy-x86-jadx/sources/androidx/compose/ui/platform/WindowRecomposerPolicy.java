package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000¢\u0006\u0002\u0008\rJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0005J*\u0010\u0011\u001a\u0002H\u0012\"\u0004\u0008\u0000\u0010\u00122\u0006\u0010\u0003\u001a\u00020\u00052\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\u0008¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/ui/platform/WindowRecomposerPolicy;", "", "()V", "factory", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "compareAndSetFactory", "", "expected", "createAndInstallWindowRecomposer", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;", "createAndInstallWindowRecomposer$ui_release", "getAndSetFactory", "setFactory", "", "withFactory", "R", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/WindowRecomposerFactory;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WindowRecomposerPolicy {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.WindowRecomposerPolicy INSTANCE;
    private static final AtomicReference<androidx.compose.ui.platform.WindowRecomposerFactory> factory;
    static {
        WindowRecomposerPolicy windowRecomposerPolicy = new WindowRecomposerPolicy();
        WindowRecomposerPolicy.INSTANCE = windowRecomposerPolicy;
        AtomicReference atomicReference = new AtomicReference(WindowRecomposerFactory.Companion.getLifecycleAware());
        WindowRecomposerPolicy.factory = atomicReference;
        int i = 8;
    }

    public final boolean compareAndSetFactory(androidx.compose.ui.platform.WindowRecomposerFactory expected, androidx.compose.ui.platform.WindowRecomposerFactory factory) {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(WindowRecomposerPolicy.factory, expected, factory);
    }

    public final Recomposer createAndInstallWindowRecomposer$ui_release(View rootView) {
        Recomposer recomposer = (WindowRecomposerFactory)WindowRecomposerPolicy.factory.get().createRecomposer(rootView);
        WindowRecomposer_androidKt.setCompositionContext(rootView, (CompositionContext)recomposer);
        final int i = 0;
        WindowRecomposerPolicy.createAndInstallWindowRecomposer.unsetJob.1 anon = new WindowRecomposerPolicy.createAndInstallWindowRecomposer.unsetJob.1(recomposer, rootView, i);
        WindowRecomposerPolicy.createAndInstallWindowRecomposer.1 anon2 = new WindowRecomposerPolicy.createAndInstallWindowRecomposer.1(BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)HandlerDispatcherKt.from(rootView.getHandler(), "windowRecomposer cleanup").getImmediate(), i, (Function2)anon, 2, 0));
        rootView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon2);
        return recomposer;
    }

    public final androidx.compose.ui.platform.WindowRecomposerFactory getAndSetFactory(androidx.compose.ui.platform.WindowRecomposerFactory factory) {
        return (WindowRecomposerFactory)WindowRecomposerPolicy.factory.getAndSet(factory);
    }

    public final void setFactory(androidx.compose.ui.platform.WindowRecomposerFactory factory) {
        WindowRecomposerPolicy.factory.set(factory);
    }

    public final <R> R withFactory(androidx.compose.ui.platform.WindowRecomposerFactory factory, Function0<? extends R> block) {
        final int i = 0;
        final int i2 = 0;
        if (!compareAndSetFactory(factory, getAndSetFactory(factory))) {
        } else {
            return block.invoke();
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state");
        throw illegalStateException2;
    }
}
