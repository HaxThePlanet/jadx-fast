package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008ç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory;", "", "createRecomposer", "Landroidx/compose/runtime/Recomposer;", "windowRootView", "Landroid/view/View;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WindowRecomposerFactory {

    public static final androidx.compose.ui.platform.WindowRecomposerFactory.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory$Companion;", "", "()V", "LifecycleAware", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getLifecycleAware$annotations", "getLifecycleAware", "()Landroidx/compose/ui/platform/WindowRecomposerFactory;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.platform.WindowRecomposerFactory.Companion $$INSTANCE;
        private static final androidx.compose.ui.platform.WindowRecomposerFactory LifecycleAware;
        public static Recomposer $r8$lambda$FWAPLXs0qWMqekhMr83xkKattCY(View view) {
            return WindowRecomposerFactory.Companion.LifecycleAware$lambda$0(view);
        }

        static {
            WindowRecomposerFactory.Companion companion = new WindowRecomposerFactory.Companion();
            WindowRecomposerFactory.Companion.$$INSTANCE = companion;
            WindowRecomposerFactory.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new WindowRecomposerFactory.Companion$$ExternalSyntheticLambda0();
            WindowRecomposerFactory.Companion.LifecycleAware = externalSyntheticLambda0;
        }

        private static final Recomposer LifecycleAware$lambda$0(View rootView) {
            int i = 0;
            return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(rootView, i, i, 3, i);
        }

        public static void getLifecycleAware$annotations() {
        }

        public final androidx.compose.ui.platform.WindowRecomposerFactory getLifecycleAware() {
            return WindowRecomposerFactory.Companion.LifecycleAware;
        }
    }
    static {
        WindowRecomposerFactory.Companion = WindowRecomposerFactory.Companion.$$INSTANCE;
    }

    public abstract Recomposer createRecomposer(View view);
}
