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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfoData", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "shouldShowRateUsDialog", "", "update", "", "rating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends s {

    private final InAppMessageDataHolder a;
    private final InAppFeedbackExtras b;
    private final ExamHistorySaveInfo c;
    private final p1 d;
    private final k1 e;
    private final j1 f;
    private final o3 g;
    public n(InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras2, ExamHistorySaveInfo examHistorySaveInfo3, p1 p14, k1 k15, j1 j16, o3 o37) {
        n.f(inAppMessageDataHolder, "messageData");
        n.f(p14, "userRepository");
        n.f(k15, "rateRepository");
        n.f(j16, "programRepository");
        n.f(o37, "tracker");
        super();
        this.a = inAppMessageDataHolder;
        this.b = inAppFeedbackExtras2;
        this.c = examHistorySaveInfo3;
        this.d = p14;
        this.e = k15;
        this.f = j16;
        this.g = o37;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final InAppMessageDataHolder h() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean i() {
        return this.e.j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j(int i) {
        Object inAppMessageDataHolder;
        Object recommendationScore;
        Object valueOf;
        Object examId;
        Object obj12;
        this.g.q(q3.RecommendationScore, Integer.valueOf(i));
        p1.b(this.d, i, 0, this.a.getCampaignId(), this.a.getCampaignName(), this.b, 2, 0);
        obj12 = this.c;
        if (obj12 != null) {
            this.f.C(obj12.getDogId(), this.c.getProgramId(), this.c.getTrickId(), this.c.getExamId());
        }
    }
}
