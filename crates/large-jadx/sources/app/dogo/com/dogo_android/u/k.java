package app.dogo.com.dogo_android.u;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "", "startedTimeMs", "", "getStartedTimeMs", "()J", "stoppedTimeMs", "getStoppedTimeMs", "isActive", "", "isStopped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface k {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(app.dogo.com.dogo_android.u.k k) {
            int startedTimeMs;
            int stoppedTimeMs;
            Object obj4;
            n.f(k, "this");
            if (Long.compare(startedTimeMs2, stoppedTimeMs) != 0 && Long.compare(startedTimeMs, stoppedTimeMs) > 0) {
                obj4 = Long.compare(startedTimeMs, stoppedTimeMs) > 0 ? 1 : 0;
            } else {
            }
            return obj4;
        }

        public static boolean b(app.dogo.com.dogo_android.u.k k) {
            int obj4;
            n.f(k, "this");
            obj4 = Long.compare(startedTimeMs, stoppedTimeMs) < 0 ? 1 : 0;
            return obj4;
        }
    }
    public abstract long getStartedTimeMs();

    public abstract long getStoppedTimeMs();
}
