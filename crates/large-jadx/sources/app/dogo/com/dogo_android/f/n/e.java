package app.dogo.com.dogo_android.f.n;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.w;
import e.a.a.a.b.b.w;
import f.d.a.a;
import i.b.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;)V", "getDogId", "()Ljava/lang/String;", "goDailyWorkout", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoDailyWorkout", "()Lcom/hadilq/liveevent/LiveEvent;", "onDismiss", "getOnDismiss", "workoutLaterClicked", "", "workoutTryClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final String a;
    private final o3 b;
    private final w c;
    private final a<Boolean> d;
    private final a<Boolean> e;
    public e(String string, o3 o32, w w3) {
        n.f(string, "dogId");
        n.f(o32, "tracker");
        n.f(w3, "dogLocalEntityDao");
        super();
        this.a = string;
        this.b = o32;
        this.c = w3;
        a obj3 = new a();
        this.d = obj3;
        obj3 = new a();
        this.e = obj3;
        w3.c(string).e();
    }

    public final a<Boolean> h() {
        return this.d;
    }

    public final a<Boolean> i() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        this.b.d(w.e);
        this.e.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.b.d(w.d);
        this.d.postValue(Boolean.TRUE);
    }
}
