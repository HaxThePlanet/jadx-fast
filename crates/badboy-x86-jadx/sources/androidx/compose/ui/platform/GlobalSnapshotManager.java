package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", "()V", "sent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "ensureStarted", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalSnapshotManager {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.GlobalSnapshotManager INSTANCE;
    private static final AtomicBoolean sent;
    private static final AtomicBoolean started;
    static {
        GlobalSnapshotManager globalSnapshotManager = new GlobalSnapshotManager();
        GlobalSnapshotManager.INSTANCE = globalSnapshotManager;
        final int i2 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i2);
        GlobalSnapshotManager.started = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i2);
        GlobalSnapshotManager.sent = atomicBoolean2;
        int i = 8;
    }

    public static final AtomicBoolean access$getSent$p() {
        return GlobalSnapshotManager.sent;
    }

    public final void ensureStarted() {
        boolean compareAndSet;
        int companion;
        int anon2;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i4;
        androidx.compose.ui.platform.GlobalSnapshotManager.ensureStarted.1 anon;
        int i3;
        int i;
        anon2 = 1;
        if (GlobalSnapshotManager.started.compareAndSet(false, anon2)) {
            int i6 = 0;
            compareAndSet = ChannelKt.Channel$default(anon2, i6, i6, 6, i6);
            GlobalSnapshotManager.ensureStarted.1 anon3 = new GlobalSnapshotManager.ensureStarted.1(compareAndSet, i6);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(AndroidUiDispatcher.Companion.getMain()), 0, 0, (Function2)anon3, 3, 0);
            anon2 = new GlobalSnapshotManager.ensureStarted.2(compareAndSet);
            Snapshot.Companion.registerGlobalWriteObserver((Function1)anon2);
        }
    }
}
