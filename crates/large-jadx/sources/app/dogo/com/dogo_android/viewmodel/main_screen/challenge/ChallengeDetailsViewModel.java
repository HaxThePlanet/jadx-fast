package app.dogo.com.dogo_android.a0.g.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeDetailsTabModel;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.k;
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.n0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: ChallengeDetailsViewModel.kt */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010 \n\u0002\u0008\u0005\u0018\u0000 h2\u00020\u0001:\u0001hB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0008\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010Q\u001a\u00020R2\u0008\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010U\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u0006\u0010X\u001a\u00020RJ\u0006\u0010Y\u001a\u00020\u0014J\u0008\u0010Z\u001a\u00020\u0014H\u0007J\u0008\u0010[\u001a\u00020\u0014H\u0002J\u0006\u0010\\\u001a\u00020RJ\u000e\u0010]\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u000e\u0010^\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u000e\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020\u0014J\u0006\u0010a\u001a\u00020RJ\u0010\u0010b\u001a\u00020\u00142\u0008\u0010S\u001a\u0004\u0018\u00010TJ \u0010c\u001a\u0008\u0012\u0004\u0012\u00020\u00190d2\u0006\u0010e\u001a\u00020\u00192\u0008\u0010f\u001a\u0004\u0018\u00010\u0019H\u0002J\u0008\u0010g\u001a\u00020RH\u0002R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008$\u0010\u001bR\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u0008)\u0010\u001bR\u0011\u0010*\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010+R\u0011\u0010-\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008-\u0010+R\u0011\u0010.\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008.\u0010+R\u0011\u0010/\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008/\u0010+R\u0014\u00100\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010+R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u00086\u0010+R\u001d\u00107\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u001308¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u0011\u0010?\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008@\u0010>R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008D\u0010>R\u0017\u0010E\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010'R\u000e\u0010G\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010\u001bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010K\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008L\u0010\u001bR\u000e\u0010M\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "context", "Landroid/content/Context;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "_policySave", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "buttonVisible", "callReason", "", "challengeId", "", "getChallengeId", "()Ljava/lang/String;", "checkboxState", "connectivityManager", "Landroid/net/ConnectivityManager;", "customFabViewStateModel", "Lapp/dogo/com/dogo_android/util/customfab/CustomFabViewStateModel;", "getCustomFabViewStateModel", "()Lapp/dogo/com/dogo_android/util/customfab/CustomFabViewStateModel;", "description", "getDescription", "fabHideTrigger", "getFabHideTrigger", "()Landroidx/lifecycle/MutableLiveData;", "image", "getImage", "isBarkBoxVisible", "()Z", "isConnected", "isFriendlyCollarVisible", "isSponsorBannerVisible", "isUniversalBannerVisible", "isUserUnderLimit", "model", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "participateFabViewModel", "Lapp/dogo/com/dogo_android/util/customfab/ParticipateButtonHelper;", "policyCheckVisibility", "getPolicyCheckVisibility", "policySave", "Landroidx/lifecycle/LiveData;", "getPolicySave", "()Landroidx/lifecycle/LiveData;", "privacyModel", "Lapp/dogo/com/dogo_android/model/ChallengeDetailsTabModel;", "getPrivacyModel", "()Lapp/dogo/com/dogo_android/model/ChallengeDetailsTabModel;", "prizeRulesModel", "getPrizeRulesModel", "resources", "Landroid/content/res/Resources;", "rulesModel", "getRulesModel", "scrollTrigger", "getScrollTrigger", "shouldStartCreationFlow", "shouldTriggerPublish", "title", "getTitle", "universalSponsorBanner", "getUniversalSponsorBanner", "userEntryFetched", "userEntryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "checkActionPermission", "checkForScrollCommands", "", "arguments", "Landroid/os/Bundle;", "doOnParticipate", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "fetchUserEntry", "hasChallengeEnded", "isButtonVisible", "isChallengePolicyAccepted", "onCancelClick", "onParticipateClick", "onSponsorBannerClick", "onTermAcceptClick", "state", "refreshFab", "setArguments", "stringParser", "", "regex", "init", "updateChallengePolicyStatus", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d0, reason: from kotlin metadata */
public final class ChallengeDetailsViewModel extends r {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final d0.a INSTANCE = new d0$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: B, reason: from kotlin metadata */
    private final h2 buttonVisible;
    /* renamed from: C, reason: from kotlin metadata */
    private final o3 callReason;
    private final v2 D;
    /* renamed from: E, reason: from kotlin metadata */
    private final r2 checkboxState;
    /* renamed from: F, reason: from kotlin metadata */
    private final ConnectivityManager connectivityManager;
    private final Resources G;
    private ChallengeModel H;
    private int I;
    /* renamed from: J, reason: from kotlin metadata */
    private final x<Integer> firestoreService = new x<>();
    private boolean K = true;
    /* renamed from: L, reason: from kotlin metadata */
    private boolean isBarkBoxVisible;
    private final x<Boolean> M = new x<>();
    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFriendlyCollarVisible;
    private final app.dogo.com.dogo_android.util.g0.b O = new b();
    /* renamed from: P, reason: from kotlin metadata */
    private boolean isUniversalBannerVisible = true;
    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isUserUnderLimit;
    /* renamed from: R, reason: from kotlin metadata */
    private ChallengeEntryModel model;
    /* renamed from: S, reason: from kotlin metadata */
    private final x<y<Boolean>> participateFabViewModel = new x<>();
    private final LiveData<y<Boolean>> T = new x<>();
    private final m2 z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel$Companion;", "", "()V", "BREAK_POINT_REGEX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ChallengeModel_MediaTypes.values().length];
            iArr[ChallengeModel_MediaTypes.PHOTO_BARKBOX.ordinal()] = 1;
            iArr[ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR.ordinal()] = 2;
            app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d0.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            d0.this.participateFabViewModel.postValue(new LoadResult_Error(th));
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            d0.this.callReason.logEvent(E_Challenges.x);
            d0.this.participateFabViewModel.postValue(new LoadResult_Success(Boolean.TRUE));
        }

        d() {
            super(0);
        }
    }
    public d0(m2 m2Var, p1 p1Var, h2 h2Var, o3 o3Var, v2 v2Var, Context context, r2 r2Var) {
        n.f(m2Var, "firestoreService");
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(v2Var, "utilities");
        n.f(context, "context");
        n.f(r2Var, "remoteConfigService");
        super();
        this.z = m2Var;
        this.authService = p1Var;
        this.buttonVisible = h2Var;
        this.callReason = o3Var;
        this.D = v2Var;
        this.checkboxState = r2Var;
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = systemService;
        Resources resources = context.getResources();
        n.e(resources, "context.resources");
        this.G = resources;
        x xVar = new x();
        final x xVar3 = new x();
        x xVar2 = new x();
        app.dogo.com.dogo_android.util.g0.b bVar = new b(resources);
    }

    /* renamed from: C, reason: from kotlin metadata */
    private static final void stringParser(d0 regex, QuerySnapshot init) {
        n.f(regex, "this$0");
        n.f(init, "querySnapshot");
        regex.isFriendlyCollarVisible = true;
        if (init.size() > 0) {
            regex.model = (ChallengeEntryModel)(DocumentSnapshot)init.getDocuments().get(0).toObject(ChallengeEntryModel.class);
            regex.e0();
        }
        regex.notifyChange(26);
    }

    /* renamed from: T, reason: from kotlin metadata */
    private final boolean checkActionPermission() {
        return this.authService.L("challenge_terms_v1");
    }

    private final boolean U() {
        boolean z = false;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        int r0 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0;
        return (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() ? 1 : 0);
    }

    private final boolean Y() {
        boolean z = false;
        ChallengeModel.MediaTypes sINGLE_ENTRY_NEVER_ENDING2;
        if (this.model == null || this.H != null) {
            int i2 = 1;
        } else {
            n.d(this.H);
            if (this.H.getMediaType() == ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) {
                int i = 0;
            }
        }
        return z;
    }

    private final List<String> g0(String str, String str2) {
        n.d(str2);
        int i = 0;
        Object[] array = new Regex(str).f(str2, i).toArray(new String[i]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new ArrayList(p.j(Arrays.copyOf(array, array.length)));
    }

    private final void h0() {
        this.participateFabViewModel.postValue(LoadResult_Loading.a);
        i.b.b bVar4 = this.authService.y0("challenge_terms_v1", User_PolicyStatus.ACCEPTED).q(a.b()).y(a.b());
        n.e(bVar4, "userRepository.updatePolicy(User.CHALLENGE_TERMS_POLICY_ID, User.PolicyStatus.ACCEPTED)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.d(bVar4, new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d0.c(this), new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d0.d(this)));
    }

    /* renamed from: w, reason: from kotlin metadata */
    public static final /* synthetic */ o3 checkForScrollCommands(d0 arguments) {
        return arguments.callReason;
    }

    /* renamed from: x, reason: from kotlin metadata */
    public static final /* synthetic */ x doOnParticipate(d0 navigator) {
        return navigator.participateFabViewModel;
    }

    private final boolean y() {
        final boolean z2 = false;
        if (!U()) {
            showToast(2131886953);
            return false;
        }
        if (this.H != null) {
            n.d(this.H);
            return true;
        }
        showToast(2131886293);
        this.M.setValue(Boolean.TRUE);
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: A, reason: from kotlin metadata */
    public final void onParticipateClick(a0 navigator) {
        Bundle bundle;
        n.f(navigator, "navigator");
        if (this.isUniversalBannerVisible) {
            emitMessage(FragmentMessageAction.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW, new Bundle());
        }
        if (this.isUserUnderLimit) {
            emitMessage(FragmentMessageAction.MESSAGE_ACTION_PUBLISH_ENTRY, new Bundle());
        }
        navigator.r(DialogTags.CHALLENGE_DETAILS_DIALOG);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void B() {
        if (this.H != null) {
            n.d(this.H);
            str = "challengeId";
            this.z.I(FirestorePath.allEntries).whereEqualTo("author", this.buttonVisible.v()).whereEqualTo(str, this.H.getId()).limit(1L).get().addOnSuccessListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.a(this));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String D() {
        String str = null;
        if (this.H != null) {
            n.d(this.H);
            str = this.H.getId();
        } else {
            int i = 0;
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final app.dogo.com.dogo_android.util.g0.a E() {
        return this.O;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String F() {
        String description;
        if (this.H != null) {
            n.d(this.H);
            description = this.H.getDescription();
        } else {
            description = "";
        }
        return description;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<Boolean> G() {
        return this.M;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String H() {
        String imageUrl;
        if (this.H != null) {
            n.d(this.H);
            imageUrl = this.H.getImageUrl();
        } else {
            imageUrl = "";
        }
        return imageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean I() {
        boolean z = false;
        int r0 = !checkActionPermission() && this.K ? 1 : 0;
        return (!checkActionPermission() && this.K ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final LiveData<y<Boolean>> J() {
        return this.T;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel K() throws android.content.res.Resources.NotFoundException {
        int i;
        char c = 46;
        final ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131887105);
        ArrayList arrayList = new ArrayList();
        Iterator it = g0("(\\d+\\.)", this.G.getString(2131886311)).iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            int r6 = item.length() > 0 ? i : 0;
        }
        challengeDetailsTabModel.bulletPointList.addAll(arrayList);
        return challengeDetailsTabModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel L() throws android.content.res.Resources.NotFoundException {
        List list;
        ChallengeModel.MediaTypes mediaType;
        final ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131886274);
        ArrayList arrayList = new ArrayList();
        final String str = "(?=\\*)";
        if (this.H != null) {
            n.d(this.H);
            if (this.H.getPrizeRules() != null) {
                n.d(this.H);
                list = g0(str, this.H.getPrizeRules());
            } else {
                if (this.H != null) {
                    n.d(this.H);
                    mediaType = this.H.getMediaType();
                } else {
                    mediaType = ChallengeModel_MediaTypes.UNDEFINED;
                }
                int i = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d0.b.a[mediaType.ordinal()];
                int i2 = 1;
                if (this.H == 1) {
                    i = 2131886272;
                    list = g0(str, this.G.getString(i));
                } else {
                    i2 = 2;
                    if (this.H == 2) {
                        i = 2131886273;
                        list = g0(str, this.G.getString(i));
                    }
                }
            }
        }
        challengeDetailsTabModel.bulletPointList.addAll(list);
        return challengeDetailsTabModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel M() throws android.content.res.Resources.NotFoundException {
        final ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131887106);
        challengeDetailsTabModel.bulletPointList.addAll(g0("(?=\\*)", this.G.getString(2131886315)));
        return challengeDetailsTabModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<Integer> N() {
        return this.firestoreService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String O() {
        String name;
        if (this.H != null) {
            n.d(this.H);
            name = this.H.getName();
        } else {
            name = "";
        }
        return name;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String P() {
        int i = 0;
        if (this.H != null) {
            n.d(this.H);
            if (this.H.hasSponsor()) {
                n.d(this.H);
                String sponsorDetailsBannerImageUrl = this.H.getSponsorDetailsBannerImageUrl();
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean Q() {
        boolean z = false;
        v2 v2Var;
        if (this.H != null) {
            n.d(this.H);
            if (this.H.isHasEnded(this.D)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean R() {
        boolean z = false;
        ChallengeModel.MediaTypes pHOTO_BARKBOX2;
        if (this.H != null) {
            n.d(this.H);
            int r0 = this.H.getMediaType() == ChallengeModel_MediaTypes.PHOTO_BARKBOX ? 1 : 0;
        }
        return (this.H.getMediaType() == ChallengeModel_MediaTypes.PHOTO_BARKBOX ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean S() {
        boolean z = true;
        int r0 = this.K && !this.Q() && this.isFriendlyCollarVisible && this.Y() ? 1 : 0;
        return (this.K && !this.Q() && this.isFriendlyCollarVisible && this.Y() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean V() {
        boolean z = false;
        ChallengeModel.MediaTypes pHOTO_FRIENDLY_COLLAR2;
        if (this.H != null) {
            n.d(this.H);
            int r0 = this.H.getMediaType() == ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0;
        }
        return (this.H.getMediaType() == ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean W() {
        boolean z = true;
        v2 v2Var;
        if (this.H != null) {
            n.d(this.H);
            if (this.H.hasPrize()) {
                n.d(this.H);
                int r0 = !this.H.isHasEnded(this.D) ? 1 : 0;
            }
        }
        return (!this.H.isHasEnded(this.D) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean X() {
        boolean z = false;
        if (this.H != null) {
            n.d(this.H);
            int r0 = this.H.hasSponsor() ? 1 : 0;
        }
        return (this.H.hasSponsor() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void a0() {
        int i2 = 1;
        if (this.I == 1) {
            this.callReason.logEvent(E_Challenges.w);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: b0, reason: from kotlin metadata */
    public final void onSponsorBannerClick(a0 navigator) {
        n.f(navigator, "navigator");
        if (y() && !this.checkActionPermission() && this.isBarkBoxVisible) {
            if (this.isBarkBoxVisible) {
                h0();
            } else {
                onParticipateClick(navigator);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: c0, reason: from kotlin metadata */
    public final void onTermAcceptClick(a0 state) {
        String customLinkByCountry;
        int i = 1;
        boolean sponsor;
        n.f(state, "navigator");
        if (this.H != null) {
            n.d(this.H);
            this.callReason.logEvent(E_Sponsors.d.c(new EP_ChallengeId(), this.H.getId()));
            n.d(this.H);
            int i3 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d0.b.a[this.H.getMediaType().ordinal()];
            i = 1;
            if (this.H != 1) {
                int i2 = 2;
                String r0 = this.H != 2 ? "" : "http://friendlydogcollars.com.au/?utm_campaign=ah&utm_source=leaddyno&utm_medium=affiliate#_l_ah";
            } else {
                n.d(this.H);
                customLinkByCountry = n.o("https://www.barkbox.com/?utm_source=DogoAppAndroid&utm_medium=DogoApp&utm_campaign=", this.H.getId());
            }
            n.d(this.H);
            if (this.H.hasSponsor() && CustomUrl.getCustomLinkByCountry(this.H.getId(), this.checkboxState.v()) == null) {
                n.d(this.H);
                customLinkByCountry = this.H.getSponsorWebsiteUrl();
            }
            if (this.H != null && this.H.length() == 0) {
                if (E_Sponsors.d == 0) {
                    try {
                        state.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(customLinkByCountry)));
                    } catch (Exception unused) {
                        state = 2131886123;
                        showToast(state);
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: d0, reason: from kotlin metadata */
    public final void setArguments(boolean arguments) {
        this.isBarkBoxVisible = arguments;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void e0() {
        this.O.u(this.model, this.D.g());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean f0(Bundle bundle) {
        boolean z = false;
        z = false;
        if (bundle == null) {
            return false;
        }
        this.H = (ChallengeModel)bundle.getParcelable("challenge");
        str = "hide_participate_button";
        if (bundle.containsKey(str)) {
            this.K = bundle.getBoolean(str);
        }
        str2 = "shouldStartCreationFlow";
        if (bundle.containsKey(str2)) {
            this.isUniversalBannerVisible = bundle.getBoolean(str2);
        }
        String str4 = "shouldTriggerPublish";
        if (bundle.containsKey(str4)) {
            this.isUserUnderLimit = bundle.getBoolean(str4);
        }
        notifyChange(148);
        notifyChange(20);
        notifyChange(76);
        notifyChange(168);
        notifyChange(169);
        if (this.H != null) {
            int i = 1;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void z(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        final boolean z = false;
        final int i2 = 1;
        if (bundle.getBoolean("show_rules", z)) {
            this.firestoreService.setValue(1);
            this.I = i2;
        }
        if (bundle.getBoolean("show_checkbox", z)) {
            this.I = i2;
        }
        str = "show_prize";
        if (bundle.getBoolean(str, z)) {
            this.firestoreService.setValue(2);
            this.I = i2;
        }
    }


    public static /* synthetic */ void Z(d0 d0Var, QuerySnapshot querySnapshot) {
        ChallengeDetailsViewModel.stringParser(d0Var, querySnapshot);
    }
}
