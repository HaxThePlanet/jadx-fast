package app.dogo.com.dogo_android.x.b;

import androidx.lifecycle.f0;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0008J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "trickRatingList", "", "", "viewSource", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getMotivationMessageRes", "getSpentTimeFormatted", "getTimeGoalMinutes", "", "getTimeGoalSeconds", "updateGoalNotReachedState", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    public static final app.dogo.com.dogo_android.x.b.d.a Companion;
    private final TrainingTimeMetrics a;
    private final List<Integer> b;
    private final String c;
    private final r2 d;
    private final p1 e;
    private final p2 f;
    private final v2 g;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel$Companion;", "", "()V", "TRAINING_TIME_REF_SEC", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.GoalNotAchievedViewModel$updateGoalNotReachedState$1", f = "GoalNotAchievedViewModel.kt", l = 32, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.x.b.d this$0;
        b(app.dogo.com.dogo_android.x.b.d d, d<? super app.dogo.com.dogo_android.x.b.d.b> d2) {
            this.this$0 = d;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (d.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            d.b obj2 = new d.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int todayTrainingTimeSeconds;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            obj5 = new SimpleDateFormat("yyyy-MM-dd", n2.b(d.h(this.this$0).W()));
            obj5 = obj5.format(d.i(this.this$0).f().getTime());
            n.e(obj5, "todayDate");
            this.label = i;
            if (d.j(this.this$0).x0(obj5, this.this$0.o().getTodayTrainingTimeSeconds(), this) == obj) {
                return obj;
            }
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.Companion = aVar;
    }

    public d(TrainingTimeMetrics trainingTimeMetrics, List<Integer> list2, String string3, r2 r24, p1 p15, p2 p26, v2 v27) {
        n.f(trainingTimeMetrics, "timeMetrics");
        n.f(list2, "trickRatingList");
        n.f(string3, "viewSource");
        n.f(r24, "remoteConfigService");
        n.f(p15, "userRepository");
        n.f(p26, "preferenceService");
        n.f(v27, "timeUtils");
        super();
        this.a = trainingTimeMetrics;
        this.b = list2;
        this.c = string3;
        this.d = r24;
        this.e = p15;
        this.f = p26;
        this.g = v27;
    }

    public static final p2 h(app.dogo.com.dogo_android.x.b.d d) {
        return d.f;
    }

    public static final v2 i(app.dogo.com.dogo_android.x.b.d d) {
        return d.g;
    }

    public static final p1 j(app.dogo.com.dogo_android.x.b.d d) {
        return d.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int k() {
        int illegalStateException;
        int string;
        boolean todayTrainingTimeSeconds;
        Object iterator;
        int i3;
        boolean empty;
        int i;
        int i2;
        string = 0;
        int i4 = 1;
        illegalStateException = this.b.size() > i4 ? i4 : string;
        iterator = this.b;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
                i3 = string;
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if ((Number)iterator.next().intValue() < 4) {
                    } else {
                    }
                    empty = string;
                    empty = i4;
                }
            }
        } else {
        }
        if (this.a.getTodayTrainingTimeSeconds() <= 40) {
            string = i4;
        }
        todayTrainingTimeSeconds = n.b(this.c, "lesson");
        boolean z = n.b(this.c, "workout");
        i2 = 2131887527;
        if (string != null && z) {
            if (z) {
                i2 = 2131887534;
            } else {
                if (string != null && illegalStateException != null && i3 != 0) {
                    if (illegalStateException != null) {
                        if (i3 != 0) {
                            i2 = i7;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String l() {
        long l = (long)todayTrainingTimeSeconds;
        final int i4 = 1;
        f0 f0Var = f0.a;
        int i5 = 2;
        final Object[] arr = new Object[i5];
        arr[0] = Long.valueOf(TimeUnit.SECONDS.toMinutes(l));
        arr[1] = Long.valueOf(l % seconds);
        String format = String.format("%d:%02d", Arrays.copyOf(arr, i5));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long m() {
        return TimeUnit.SECONDS.toMinutes((long)i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int n() {
        return this.d.s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrainingTimeMetrics o() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        final int i = 0;
        d.b bVar = new d.b(this, i);
        k.d(f0.a(this), i, 0, bVar, 3, 0);
    }
}
