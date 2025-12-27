package app.dogo.com.dogo_android.s.b;

import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.q2.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: RateRepository.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00088F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00088F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000b¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RateItService;)V", "rateUsPopUpCallLiveData", "Landroidx/lifecycle/LiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUpCallLiveData", "()Landroidx/lifecycle/LiveData;", "reminderPopUpCallLiveData", "getReminderPopUpCallLiveData", "sharePopUpCallLiveData", "getSharePopUpCallLiveData", "incrementLibraryItemInteractionCount", "", "saveRatePopUpAsShownFor", "source", "", "saveSharePopUpAsShownFor", "setRatingPopUpForLessonListAsShowed", "setUserAsRated", "setUserAsShared", "shouldShowRatePopUpForLessonList", "", "shouldShowRatePopUpForUserScore", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k1, reason: from kotlin metadata */
public final class RateRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 preferenceService;
    /* renamed from: b, reason: from kotlin metadata */
    private final q2 rateItService;
    public k1(p2 p2Var, q2 q2Var) {
        n.f(p2Var, "preferenceService");
        n.f(q2Var, "rateItService");
        super();
        this.preferenceService = p2Var;
        this.rateItService = q2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final LiveData<q2.a> incrementLibraryItemInteractionCount() {
        return this.rateItService.e();
    }

    public final LiveData<q2.a> b() {
        return this.rateItService.f();
    }

    public final void c() {
        this.rateItService.g();
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void saveRatePopUpAsShownFor(String source) {
        n.f(source, "source");
        this.rateItService.o(source);
        this.rateItService.w();
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final void saveSharePopUpAsShownFor(String source) {
        n.f(source, "source");
        this.rateItService.q(source);
        this.rateItService.x();
    }

    public final void f() {
        final boolean z = true;
        this.preferenceService.i1(z);
        this.preferenceService.saveDebugOverrideValue(RateItService_RateSource.LESSON_LIST_SECOND_ITEM, z);
        this.rateItService.w();
    }

    public final void g() {
        this.rateItService.n();
    }

    public final void h() {
        this.rateItService.p();
    }

    public final boolean i() {
        boolean z2 = false;
        if (this.rateItService.j(RateItService_RateSource.LESSON_LIST_SECOND_ITEM.getTag())) {
            int r0 = !this.preferenceService.P() ? 1 : 0;
        }
        return (!this.preferenceService.P() ? 1 : 0);
    }

    public final boolean j() {
        return this.rateItService.j(RateItService_RateSource.USER_SCORE_RATE.getTag());
    }
}
