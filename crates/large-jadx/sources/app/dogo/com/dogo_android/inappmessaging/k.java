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
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0008\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppFeedbackViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "rating", "", "messageData", "Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "extras", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "examInfoData", "Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(ILapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;Lapp/dogo/com/dogo_android/repository/domain/ExamHistorySaveInfo;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "closeDialog", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCloseDialog", "()Lcom/hadilq/liveevent/LiveEvent;", "createZendeskTicket", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getCreateZendeskTicket", "getExtras", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getMessageData", "()Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "getRating", "()I", "text", "Landroidx/lifecycle/MutableLiveData;", "", "getText", "()Landroidx/lifecycle/MutableLiveData;", "fetchDataAndCreateZendeskTicket", "", "showLoginAfterFeedback", "submitScore", "trackZendeskTicketCreated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends s {

    private final int a;
    private final InAppMessageDataHolder b;
    private final InAppFeedbackExtras c;
    private final ExamHistorySaveInfo d;
    private final p1 e;
    private final o3 f;
    private final r2 g;
    private final h2 h;
    private final d3 i;
    private final j1 j;
    private final a<Boolean> k;
    private final x<String> l;
    private final a<ZendeskConfigurationInfo> m;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.inappmessaging.k this$0;
        a(app.dogo.com.dogo_android.inappmessaging.k k) {
            this.this$0 = k;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            a.d(throwable);
            this.this$0.l().postValue(ZendeskConfigurationInfo.Companion.createEmpty(k.h(this.this$0).v()));
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<ZendeskConfigurationInfo, w> {

        final app.dogo.com.dogo_android.inappmessaging.k this$0;
        b(app.dogo.com.dogo_android.inappmessaging.k k) {
            this.this$0 = k;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((ZendeskConfigurationInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(ZendeskConfigurationInfo zendeskConfigurationInfo) {
            this.this$0.l().postValue(zendeskConfigurationInfo);
        }
    }
    public k(int i, InAppMessageDataHolder inAppMessageDataHolder2, InAppFeedbackExtras inAppFeedbackExtras3, ExamHistorySaveInfo examHistorySaveInfo4, p1 p15, o3 o36, r2 r27, h2 h28, d3 d39, j1 j110) {
        n.f(inAppMessageDataHolder2, "messageData");
        n.f(p15, "userRepository");
        n.f(o36, "tracker");
        n.f(r27, "remoteConfigService");
        n.f(h28, "authService");
        n.f(d39, "isDogPremiumInteractor");
        n.f(j110, "programRepository");
        super();
        this.a = i;
        this.b = inAppMessageDataHolder2;
        this.c = inAppFeedbackExtras3;
        this.d = examHistorySaveInfo4;
        this.e = p15;
        this.f = o36;
        this.g = r27;
        this.h = h28;
        this.i = d39;
        this.j = j110;
        a obj2 = new a();
        this.k = obj2;
        obj2 = new x();
        this.l = obj2;
        obj2 = new a();
        this.m = obj2;
    }

    public static final h2 h(app.dogo.com.dogo_android.inappmessaging.k k) {
        return k.h;
    }

    private final void i() {
        int i = 0;
        f fVar = new f(this);
        a0 subscribeOn = a0.zip(this.e.w(), d3.b(this.i, i, 1, i), fVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium(),\n                    { dogProfile, isPremium ->\n                        ZendeskConfigurationInfo(\n                            userId = authService.currentUserId,\n                            dogProfile = dogProfile,\n                            isDogPremium = isPremium\n                        )\n                    }\n                )\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        k.a aVar = new k.a(this);
        k.b bVar2 = new k.b(this);
        getDisposable().b(a.g(subscribeOn, aVar, bVar2));
    }

    private static final ZendeskConfigurationInfo j(app.dogo.com.dogo_android.inappmessaging.k k, DogProfile dogProfile2, Boolean boolean3) {
        n.f(k, "this$0");
        n.f(dogProfile2, "dogProfile");
        n.f(boolean3, "isPremium");
        super(k.h.v(), boolean3, dogProfile2, 0, 0, 0, 0, 0, 248, 0);
        return obj11;
    }

    public static ZendeskConfigurationInfo p(app.dogo.com.dogo_android.inappmessaging.k k, DogProfile dogProfile2, Boolean boolean3) {
        return k.j(k, dogProfile2, boolean3);
    }

    public final a<Boolean> k() {
        return this.k;
    }

    public final a<ZendeskConfigurationInfo> l() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final InAppFeedbackExtras m() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final InAppMessageDataHolder n() {
        return this.b;
    }

    public final x<String> o() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        boolean z;
        int i;
        if (this.g.X() && !this.h.D()) {
            i = !this.h.D() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        Object length;
        Object dogId;
        int tRUE;
        Object p1Var;
        r2 programId;
        Object trickId;
        long campaignId;
        String campaignName;
        InAppFeedbackExtras inAppFeedbackExtras;
        trickId = length;
        if (trickId != null && Long.compare(l, campaignId) >= 0) {
            if (Long.compare(l, campaignId) >= 0) {
                i();
            }
        }
        this.f.q(q3.RecommendationScore, Integer.valueOf(this.a));
        this.e.a(this.a, trickId, this.b.getCampaignId(), this.b.getCampaignName(), this.c);
        dogId = this.d;
        if (trickId != null && trickId.length() > 3 && dogId != null) {
            if (trickId.length() > 3) {
                this.f.q(q3.RecommendationScore, Integer.valueOf(this.a));
                this.e.a(this.a, trickId, this.b.getCampaignId(), this.b.getCampaignName(), this.c);
                dogId = this.d;
                if (dogId != null) {
                    this.j.C(dogId.getDogId(), this.d.getProgramId(), this.d.getTrickId(), this.d.getExamId());
                }
                this.k.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        this.f.c(c0.d);
    }
}
