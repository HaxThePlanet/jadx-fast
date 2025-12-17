package androidx.compose.ui.platform;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u0000 \u00072\u00020\u0001:\u0005\u0007\u0008\t\n\u000bJ\u0016\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy;", "", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "Companion", "DisposeOnDetachedFromWindow", "DisposeOnDetachedFromWindowOrReleasedFromPool", "DisposeOnLifecycleDestroyed", "DisposeOnViewTreeLifecycleDestroyed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewCompositionStrategy {

    public static final androidx.compose.ui.platform.ViewCompositionStrategy.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy$Companion;", "", "()V", "Default", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "getDefault", "()Landroidx/compose/ui/platform/ViewCompositionStrategy;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.platform.ViewCompositionStrategy.Companion $$INSTANCE;
        static {
            ViewCompositionStrategy.Companion companion = new ViewCompositionStrategy.Companion();
            ViewCompositionStrategy.Companion.$$INSTANCE = companion;
        }

        public final androidx.compose.ui.platform.ViewCompositionStrategy getDefault() {
            return (ViewCompositionStrategy)ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DisposeOnDetachedFromWindow implements androidx.compose.ui.platform.ViewCompositionStrategy {

        public static final int $stable;
        public static final androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnDetachedFromWindow INSTANCE;
        static {
            ViewCompositionStrategy.DisposeOnDetachedFromWindow disposeOnDetachedFromWindow = new ViewCompositionStrategy.DisposeOnDetachedFromWindow();
            ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE = disposeOnDetachedFromWindow;
        }

        public Function0<Unit> installFor(androidx.compose.ui.platform.AbstractComposeView view) {
            ViewCompositionStrategy.DisposeOnDetachedFromWindow.installFor.listener.1 anon = new ViewCompositionStrategy.DisposeOnDetachedFromWindow.installFor.listener.1(view);
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon);
            ViewCompositionStrategy.DisposeOnDetachedFromWindow.installFor.1 anon2 = new ViewCompositionStrategy.DisposeOnDetachedFromWindow.installFor.1(view, anon);
            return (Function0)anon2;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DisposeOnDetachedFromWindowOrReleasedFromPool implements androidx.compose.ui.platform.ViewCompositionStrategy {

        public static final int $stable;
        public static final androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool INSTANCE;
        public static void $r8$lambda$1EnlY-0mfWTWqOp5qrEZy4cqUPk(androidx.compose.ui.platform.AbstractComposeView abstractComposeView) {
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor$lambda$0(abstractComposeView);
        }

        static {
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool disposeOnDetachedFromWindowOrReleasedFromPool = new ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool();
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE = disposeOnDetachedFromWindowOrReleasedFromPool;
        }

        private static final void installFor$lambda$0(androidx.compose.ui.platform.AbstractComposeView $view) {
            $view.disposeComposition();
        }

        public Function0<Unit> installFor(androidx.compose.ui.platform.AbstractComposeView view) {
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor.listener.1 anon = new ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor.listener.1(view);
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon);
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(view);
            PoolingContainer.addPoolingContainerListener((View)view, externalSyntheticLambda0);
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor.1 anon2 = new ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor.1(view, anon, externalSyntheticLambda0);
            return (Function0)anon2;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnLifecycleDestroyed;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DisposeOnLifecycleDestroyed implements androidx.compose.ui.platform.ViewCompositionStrategy {

        public static final int $stable = 8;
        private final Lifecycle lifecycle;
        static {
            final int i = 8;
        }

        public DisposeOnLifecycleDestroyed(Lifecycle lifecycle) {
            super();
            this.lifecycle = lifecycle;
        }

        public DisposeOnLifecycleDestroyed(LifecycleOwner lifecycleOwner) {
            super(lifecycleOwner.getLifecycle());
        }

        public Function0<Unit> installFor(androidx.compose.ui.platform.AbstractComposeView view) {
            return ViewCompositionStrategy_androidKt.access$installForLifecycle(view, this.lifecycle);
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DisposeOnViewTreeLifecycleDestroyed implements androidx.compose.ui.platform.ViewCompositionStrategy {

        public static final int $stable;
        public static final androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed INSTANCE;
        static {
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed disposeOnViewTreeLifecycleDestroyed = new ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed();
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE = disposeOnViewTreeLifecycleDestroyed;
        }

        public Function0<Unit> installFor(androidx.compose.ui.platform.AbstractComposeView view) {
            if (view.isAttachedToWindow()) {
                LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get((View)view);
                int i = 0;
                if (lifecycleOwner == null) {
                } else {
                    return ViewCompositionStrategy_androidKt.access$installForLifecycle(view, lifecycleOwner.getLifecycle());
                }
                int i2 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(stringBuilder.append("View tree for ").append(view).append(" has no ViewTreeLifecycleOwner").toString());
                KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
                throw kotlinNothingValueException;
            }
            Ref.ObjectRef value$iv = new Ref.ObjectRef();
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.listener.1 anon = new ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.listener.1(view, value$iv);
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)anon);
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.1 anon2 = new ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.1(view, anon);
            value$iv.element = anon2;
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.2 anon3 = new ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.installFor.2(value$iv);
            return (Function0)anon3;
        }
    }
    static {
        ViewCompositionStrategy.Companion = ViewCompositionStrategy.Companion.$$INSTANCE;
    }

    public abstract Function0<Unit> installFor(androidx.compose.ui.platform.AbstractComposeView abstractComposeView);
}
