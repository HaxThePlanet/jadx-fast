package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u00002\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t¨\u0006\u0011", d2 = {"Landroidx/activity/compose/ActivityResultLauncherHolder;", "I", "", "()V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "launch", "", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultLauncherHolder<I>  {

    public static final int $stable = 8;
    private ActivityResultLauncher<I> launcher;
    static {
        final int i = 8;
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final void launch(I input, ActivityOptionsCompat options) {
        Unit iNSTANCE;
        ActivityResultLauncher launcher = this.launcher;
        iNSTANCE = launcher != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Launcher has not been initialized".toString());
        throw illegalStateException;
    }

    public final void setLauncher(ActivityResultLauncher<I> <set-?>) {
        this.launcher = <set-?>;
    }

    public final void unregister() {
        Unit iNSTANCE;
        ActivityResultLauncher launcher = this.launcher;
        iNSTANCE = launcher != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Launcher has not been initialized".toString());
        throw illegalStateException;
    }
}
