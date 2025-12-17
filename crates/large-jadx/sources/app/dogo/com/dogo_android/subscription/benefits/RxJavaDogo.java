package app.dogo.com.dogo_android.subscription.benefits;

import i.b.a0;
import i.b.s0.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/RxJavaDogo;", "", "()V", "EACH_SECOND", "", "timerWithStart", "Lio/reactivex/Single;", "absoluteSecondsLeft", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RxJavaDogo {

    public static final long EACH_SECOND = 1L;
    public static final app.dogo.com.dogo_android.subscription.benefits.RxJavaDogo INSTANCE;
    static {
        RxJavaDogo rxJavaDogo = new RxJavaDogo();
        RxJavaDogo.INSTANCE = rxJavaDogo;
    }

    public final a0<Long> timerWithStart(long l) {
        final i.b.z zVar = a.a();
        n.e(zVar, "computation()");
        super(1, obj2, TimeUnit.SECONDS, zVar, l, obj6);
        return timeLeft;
    }
}
