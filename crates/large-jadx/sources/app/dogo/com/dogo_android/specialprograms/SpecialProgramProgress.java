package app.dogo.com.dogo_android.u;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SpecialProgramProgress.kt */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "", "startedTimeMs", "", "getStartedTimeMs", "()J", "stoppedTimeMs", "getStoppedTimeMs", "isActive", "", "isStopped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public interface SpecialProgramProgress {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(k kVar) {
            int cmp;
            long stoppedTimeMs = 0;
            boolean z = false;
            n.f(kVar, "this");
            long startedTimeMs = kVar.getStartedTimeMs();
            stoppedTimeMs = 0L;
            if (startedTimeMs != stoppedTimeMs) {
                long startedTimeMs2 = kVar.getStartedTimeMs();
                stoppedTimeMs = kVar.getStoppedTimeMs();
                kVar = startedTimeMs2 > stoppedTimeMs ? 1 : 0;
            }
            return (startedTimeMs2 > stoppedTimeMs ? 1 : 0);
        }

        public static boolean b(k kVar) {
            boolean z = true;
            n.f(kVar, "this");
            long startedTimeMs = kVar.getStartedTimeMs();
            final long stoppedTimeMs = kVar.getStoppedTimeMs();
            kVar = startedTimeMs < stoppedTimeMs ? 1 : 0;
            return (startedTimeMs < stoppedTimeMs ? 1 : 0);
        }
    }
    long getStartedTimeMs();

    long getStoppedTimeMs();
}
