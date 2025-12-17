package app.dogo.com.dogo_android.x.d;

import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/streakachieved/TrainingMetricsStreakCompletedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "saveTodayWorkoutCompletedShowedTime", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final p2 a;
    private final v2 b;
    public d(p2 p2, v2 v22) {
        n.f(p2, "preferenceService");
        n.f(v22, "utilities");
        super();
        this.a = p2;
        this.b = v22;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", n2.b(this.a.W()));
        String format = simpleDateFormat.format(this.b.f().getTime());
        n.e(format, "todayDate");
        this.a.c1(format);
    }
}
