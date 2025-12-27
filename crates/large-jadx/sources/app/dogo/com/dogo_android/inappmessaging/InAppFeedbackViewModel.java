package app.dogo.com.dogo_android.inappmessaging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo.Companion;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.c0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: InAppFeedbackViewModel.kt */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0008\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "rating", "", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfoData", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(ILapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "closeDialog", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCloseDialog", "()Lcom/hadilq/liveevent/LiveEvent;", "createZendeskTicket", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getCreateZendeskTicket", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "getRating", "()I", "text", "Landroidx/lifecycle/MutableLiveData;", "", "getText", "()Landroidx/lifecycle/MutableLiveData;", "fetchDataAndCreateZendeskTicket", "", "showLoginAfterFeedback", "submitScore", "trackZendeskTicketCreated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class InAppFeedbackViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final int authService;
    private final InAppMessageDataHolder b;
    private final InAppFeedbackExtras c;
    /* renamed from: d, reason: from kotlin metadata */
    private final ExamHistorySaveInfo examInfoData;
    private final p1 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final o3 isDogPremiumInteractor;
    private final r2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final h2 programRepository;
    private final d3 i;
    /* renamed from: j, reason: from kotlin metadata */
    private final j1 remoteConfigService;
    private final f.d.a.a<Boolean> k = new a<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final x<String> tracker = new x<>();
    /* renamed from: m, reason: from kotlin metadata */
    private final f.d.a.a<ZendeskConfigurationInfo> userRepository = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
            k.this.l().postValue(ZendeskConfigurationInfo.Companion.createEmpty(k.this.programRepository.v()));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<ZendeskConfigurationInfo, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(ZendeskConfigurationInfo zendeskConfigurationInfo) {
            k.this.l().postValue(zendeskConfigurationInfo);
        }

        b() {
            super(1);
        }
    }
    public k(int i, InAppMessageDataHolder inAppMessageDataHolder, InAppFeedbackExtras inAppFeedbackExtras, ExamHistorySaveInfo examHistorySaveInfo, p1 p1Var, o3 o3Var, r2 r2Var, h2 h2Var, d3 d3Var, j1 j1Var) {
        n.f(inAppMessageDataHolder, "messageData");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(r2Var, "remoteConfigService");
        n.f(h2Var, "authService");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(j1Var, "programRepository");
        super();
        this.authService = i;
        this.b = inAppMessageDataHolder;
        this.c = inAppFeedbackExtras;
        this.examInfoData = examHistorySaveInfo;
        this.e = p1Var;
        this.isDogPremiumInteractor = o3Var;
        this.g = r2Var;
        this.programRepository = h2Var;
        this.i = d3Var;
        this.remoteConfigService = j1Var;
        f.d.a.a aVar = new a();
        x xVar = new x();
        f.d.a.a aVar2 = new a();
    }

    public static final /* synthetic */ h2 h(k kVar) {
        return kVar.programRepository;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final void fetchDataAndCreateZendeskTicket() {
        String str2 = null;
        a0 observable2 = a0.zip(this.e.w(), IsDogPremiumInteractor.b(this.i, str2, 1, str2), new f(this)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium(),\n                    { dogProfile, isPremium ->\n                        ZendeskConfigurationInfo(\n                            userId = authService.currentUserId,\n                            dogProfile = dogProfile,\n                            isDogPremium = isPremium\n                        )\n                    }\n                )\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new k.a(this), new k.b(this)));
    }

    private static final ZendeskConfigurationInfo j(k kVar, DogProfile dogProfile, Boolean boolean) {
        n.f(kVar, "this$0");
        n.f(dogProfile, "dogProfile");
        n.f(boolean, "isPremium");
        ZendeskConfigurationInfo kVar2 = new ZendeskConfigurationInfo(kVar.programRepository.v(), boolean, dogProfile, null, false, false, false, false, 248, null);
        return kVar2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> k() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ZendeskConfigurationInfo> l() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final InAppFeedbackExtras m() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final InAppMessageDataHolder n() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> o() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        boolean z2 = false;
        if (this.g.X()) {
            int r0 = !this.programRepository.D() ? 1 : 0;
        }
        return (!this.programRepository.D() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        Object value;
        r2 r2Var;
        int authService2;
        String trickId;
        long l;
        String campaignId;
        trickId = this.tracker.getValue();
        if (trickId != null && this.tracker >= l) {
            fetchDataAndCreateZendeskTicket();
        }
        if (trickId != null) {
            int i = 3;
            if (trickId.length() > 3) {
                this.isDogPremiumInteractor.setUserProperty(UserProperty.RecommendationScore, Integer.valueOf(this.authService));
                this.e.a(this.authService, trickId, this.b.getCampaignId(), this.b.getCampaignName(), this.c);
                if (this.examInfoData != null) {
                    this.remoteConfigService.C(this.examInfoData.getDogId(), this.examInfoData.getProgramId(), this.examInfoData.getTrickId(), this.examInfoData.getExamId());
                }
                this.k.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        this.isDogPremiumInteractor.logEvent(E_InAppMessaging.d);
    }

    public static /* synthetic */ ZendeskConfigurationInfo p(k kVar, DogProfile dogProfile, Boolean boolean) {
        return InAppFeedbackViewModel.j(kVar, dogProfile, boolean);
    }
}
