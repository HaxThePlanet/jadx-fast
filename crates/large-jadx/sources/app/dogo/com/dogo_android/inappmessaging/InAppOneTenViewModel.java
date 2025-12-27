package app.dogo.com.dogo_android.inappmessaging;

import app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: InAppOneTenViewModel.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfoData", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "shouldShowRateUsDialog", "", "update", "", "rating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class InAppOneTenViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final InAppMessageDataHolder examInfoData;
    /* renamed from: b, reason: from kotlin metadata */
    private final InAppFeedbackExtras extras;
    private final ExamHistorySaveInfo c;
    /* renamed from: d, reason: from kotlin metadata */
    private final p1 programRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final k1 rateRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final j1 tracker;
    /* renamed from: g, reason: from kotlin metadata */
    private final o3 userRepository;
    public n(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo, p1 p1Var, k1 k1Var, j1 j1Var, o3 o3Var) {
        n.f(inAppMessageDataHolder, "messageData");
        n.f(p1Var, "userRepository");
        n.f(k1Var, "rateRepository");
        n.f(j1Var, "programRepository");
        n.f(o3Var, "tracker");
        super();
        this.examInfoData = inAppMessageDataHolder;
        this.extras = inAppFeedbackExtras;
        this.c = examHistorySaveInfo;
        this.programRepository = p1Var;
        this.rateRepository = k1Var;
        this.tracker = j1Var;
        this.userRepository = o3Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final InAppMessageDataHolder shouldShowRateUsDialog() {
        return this.examInfoData;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean i() {
        return this.rateRepository.j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: j, reason: from kotlin metadata */
    public final void update(int rating) {
        this.userRepository.setUserProperty(UserProperty.RecommendationScore, Integer.valueOf(rating));
        UserRepository.b(this.programRepository, rating, null, this.examInfoData.getCampaignId(), this.examInfoData.getCampaignName(), this.extras, 2, null);
        if (this.c != null) {
            this.tracker.C(this.c.getDogId(), this.c.getProgramId(), this.c.getTrickId(), this.c.getExamId());
        }
    }
}
