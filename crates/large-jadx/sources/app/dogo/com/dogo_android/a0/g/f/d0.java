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
import app.dogo.com.dogo_android.k.h;
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
import app.dogo.com.dogo_android.util.g0.a;
import app.dogo.com.dogo_android.util.g0.b;
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
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.h;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010 \n\u0002\u0008\u0005\u0018\u0000 h2\u00020\u0001:\u0001hB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0008\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010Q\u001a\u00020R2\u0008\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010U\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u0006\u0010X\u001a\u00020RJ\u0006\u0010Y\u001a\u00020\u0014J\u0008\u0010Z\u001a\u00020\u0014H\u0007J\u0008\u0010[\u001a\u00020\u0014H\u0002J\u0006\u0010\\\u001a\u00020RJ\u000e\u0010]\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u000e\u0010^\u001a\u00020R2\u0006\u0010V\u001a\u00020WJ\u000e\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020\u0014J\u0006\u0010a\u001a\u00020RJ\u0010\u0010b\u001a\u00020\u00142\u0008\u0010S\u001a\u0004\u0018\u00010TJ \u0010c\u001a\u0008\u0012\u0004\u0012\u00020\u00190d2\u0006\u0010e\u001a\u00020\u00192\u0008\u0010f\u001a\u0004\u0018\u00010\u0019H\u0002J\u0008\u0010g\u001a\u00020RH\u0002R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008$\u0010\u001bR\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u0008)\u0010\u001bR\u0011\u0010*\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010+R\u0011\u0010-\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008-\u0010+R\u0011\u0010.\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008.\u0010+R\u0011\u0010/\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008/\u0010+R\u0014\u00100\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010+R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u00086\u0010+R\u001d\u00107\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u001308¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u0011\u0010?\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008@\u0010>R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008D\u0010>R\u0017\u0010E\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010'R\u000e\u0010G\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010\u001bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010K\u001a\u0004\u0018\u00010\u00198G¢\u0006\u0006\u001a\u0004\u0008L\u0010\u001bR\u000e\u0010M\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "context", "Landroid/content/Context;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "_policySave", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "buttonVisible", "callReason", "", "challengeId", "", "getChallengeId", "()Ljava/lang/String;", "checkboxState", "connectivityManager", "Landroid/net/ConnectivityManager;", "customFabViewStateModel", "Lapp/dogo/com/dogo_android/util/customfab/CustomFabViewStateModel;", "getCustomFabViewStateModel", "()Lapp/dogo/com/dogo_android/util/customfab/CustomFabViewStateModel;", "description", "getDescription", "fabHideTrigger", "getFabHideTrigger", "()Landroidx/lifecycle/MutableLiveData;", "image", "getImage", "isBarkBoxVisible", "()Z", "isConnected", "isFriendlyCollarVisible", "isSponsorBannerVisible", "isUniversalBannerVisible", "isUserUnderLimit", "model", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "participateFabViewModel", "Lapp/dogo/com/dogo_android/util/customfab/ParticipateButtonHelper;", "policyCheckVisibility", "getPolicyCheckVisibility", "policySave", "Landroidx/lifecycle/LiveData;", "getPolicySave", "()Landroidx/lifecycle/LiveData;", "privacyModel", "Lapp/dogo/com/dogo_android/model/ChallengeDetailsTabModel;", "getPrivacyModel", "()Lapp/dogo/com/dogo_android/model/ChallengeDetailsTabModel;", "prizeRulesModel", "getPrizeRulesModel", "resources", "Landroid/content/res/Resources;", "rulesModel", "getRulesModel", "scrollTrigger", "getScrollTrigger", "shouldStartCreationFlow", "shouldTriggerPublish", "title", "getTitle", "universalSponsorBanner", "getUniversalSponsorBanner", "userEntryFetched", "userEntryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "checkActionPermission", "checkForScrollCommands", "", "arguments", "Landroid/os/Bundle;", "doOnParticipate", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "fetchUserEntry", "hasChallengeEnded", "isButtonVisible", "isChallengePolicyAccepted", "onCancelClick", "onParticipateClick", "onSponsorBannerClick", "onTermAcceptClick", "state", "refreshFab", "setArguments", "stringParser", "", "regex", "init", "updateChallengePolicyStatus", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d0 extends r {

    public static final app.dogo.com.dogo_android.a0.g.f.d0.a Companion;
    private final p1 A;
    private final h2 B;
    private final o3 C;
    private final v2 D;
    private final r2 E;
    private final ConnectivityManager F;
    private final Resources G;
    private ChallengeModel H;
    private int I;
    private final x<Integer> J;
    private boolean K = true;
    private boolean L;
    private final x<Boolean> M;
    private boolean N;
    private final b O;
    private boolean P = true;
    private boolean Q;
    private ChallengeEntryModel R;
    private final x<y<Boolean>> S;
    private final LiveData<y<Boolean>> T;
    private final m2 z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel$Companion;", "", "()V", "BREAK_POINT_REGEX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ChallengeModel.MediaTypes.PHOTO_BARKBOX.ordinal()] = 1;
            iArr[ChallengeModel.MediaTypes.PHOTO_FRIENDLY_COLLAR.ordinal()] = 2;
            d0.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.a0.g.f.d0 this$0;
        c(app.dogo.com.dogo_android.a0.g.f.d0 d0) {
            this.this$0 = d0;
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
            y.a aVar = new y.a(throwable);
            d0.x(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.a0.g.f.d0 this$0;
        d(app.dogo.com.dogo_android.a0.g.f.d0 d0) {
            this.this$0 = d0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            d0.w(this.this$0).c(u.x);
            y.c cVar = new y.c(Boolean.TRUE);
            d0.x(this.this$0).postValue(cVar);
        }
    }
    static {
        d0.a aVar = new d0.a(0);
        d0.Companion = aVar;
    }

    public d0(m2 m2, p1 p12, h2 h23, o3 o34, v2 v25, Context context6, r2 r27) {
        n.f(m2, "firestoreService");
        n.f(p12, "userRepository");
        n.f(h23, "authService");
        n.f(o34, "tracker");
        n.f(v25, "utilities");
        n.f(context6, "context");
        n.f(r27, "remoteConfigService");
        super();
        this.z = m2;
        this.A = p12;
        this.B = h23;
        this.C = o34;
        this.D = v25;
        this.E = r27;
        Object obj2 = context6.getSystemService("connectivity");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.F = (ConnectivityManager)obj2;
        obj2 = context6.getResources();
        n.e(obj2, "context.resources");
        this.G = obj2;
        x obj3 = new x();
        this.J = obj3;
        obj3 = 1;
        x obj4 = new x();
        this.M = obj4;
        obj3 = new x();
        this.S = obj3;
        this.T = obj3;
        obj3 = new b(obj2);
        this.O = obj3;
    }

    private static final void C(app.dogo.com.dogo_android.a0.g.f.d0 d0, QuerySnapshot querySnapshot2) {
        int size;
        Object obj2;
        n.f(d0, "this$0");
        n.f(querySnapshot2, "querySnapshot");
        d0.N = true;
        if (querySnapshot2.size() > 0) {
            d0.R = (ChallengeEntryModel)(DocumentSnapshot)querySnapshot2.getDocuments().get(0).toObject(ChallengeEntryModel.class);
            d0.e0();
        }
        d0.l(26);
    }

    private final boolean T() {
        return this.A.L("challenge_terms_v1");
    }

    private final boolean U() {
        NetworkInfo connectedOrConnecting;
        int i;
        connectedOrConnecting = this.F.getActiveNetworkInfo();
        if (connectedOrConnecting != null && connectedOrConnecting.isConnectedOrConnecting()) {
            i = connectedOrConnecting.isConnectedOrConnecting() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean Y() {
        Object mediaType;
        int i;
        ChallengeModel.MediaTypes sINGLE_ENTRY_NEVER_ENDING;
        if (this.R != null) {
            mediaType = this.H;
            n.d(mediaType);
            if (mediaType != null && mediaType.getMediaType() != ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING) {
                n.d(mediaType);
                if (mediaType.getMediaType() != ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static void Z(app.dogo.com.dogo_android.a0.g.f.d0 d0, QuerySnapshot querySnapshot2) {
        d0.C(d0, querySnapshot2);
    }

    private final List<String> g0(String string, String string2) {
        n.d(string2);
        h hVar = new h(string);
        int obj2 = 0;
        obj2 = hVar.f(string2, obj2).toArray(new String[obj2]);
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T>");
        ArrayList obj3 = new ArrayList(p.j(Arrays.copyOf((String[])obj2, obj2.length)));
        return obj3;
    }

    private final void h0() {
        this.S.postValue(y.b.a);
        b bVar4 = this.A.y0("challenge_terms_v1", b.c.ACCEPTED).q(a.b()).y(a.b());
        n.e(bVar4, "userRepository.updatePolicy(User.CHALLENGE_TERMS_POLICY_ID, User.PolicyStatus.ACCEPTED)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        d0.c cVar = new d0.c(this);
        d0.d dVar = new d0.d(this);
        getDisposable().b(a.d(bVar4, cVar, dVar));
    }

    public static final o3 w(app.dogo.com.dogo_android.a0.g.f.d0 d0) {
        return d0.C;
    }

    public static final x x(app.dogo.com.dogo_android.a0.g.f.d0 d0) {
        return d0.S;
    }

    private final boolean y() {
        ChallengeModel hasEnded;
        v2 v2Var;
        final int i4 = 0;
        if (!U()) {
            v(2131886953);
            return i4;
        }
        hasEnded = this.H;
        n.d(hasEnded);
        if (hasEnded != null && hasEnded.isHasEnded(this.D)) {
            n.d(hasEnded);
            if (hasEnded.isHasEnded(this.D)) {
            }
            return 1;
        }
        v(2131886293);
        this.M.setValue(Boolean.TRUE);
        return i4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void A(a0 a0) {
        boolean mESSAGE_ACTION_START_ENTRY_CREATION_FLOW;
        boolean mESSAGE_ACTION_PUBLISH_ENTRY;
        Bundle bundle;
        n.f(a0, "navigator");
        if (this.P) {
            bundle = new Bundle();
            j(h.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW, bundle);
        }
        if (this.Q) {
            bundle = new Bundle();
            j(h.MESSAGE_ACTION_PUBLISH_ENTRY, bundle);
        }
        a0.r(c.CHALLENGE_DETAILS_DIALOG);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void B() {
        Object challengeModel;
        app.dogo.com.dogo_android.a0.g.f.a aVar;
        String str;
        if (this.H != null) {
            ChallengeModel challengeModel2 = this.H;
            n.d(challengeModel2);
            str = "challengeId";
            aVar = new a(this);
            this.z.I(f.allEntries).whereEqualTo("author", this.B.v()).whereEqualTo(str, challengeModel2.getId()).limit(1).get().addOnSuccessListener(aVar);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String D() {
        String str;
        ChallengeModel challengeModel = this.H;
        if (challengeModel != null) {
            n.d(challengeModel);
            str = challengeModel.getId();
        } else {
            str = 0;
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final a E() {
        return this.O;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String F() {
        String description;
        ChallengeModel challengeModel = this.H;
        if (challengeModel != null) {
            n.d(challengeModel);
            description = challengeModel.getDescription();
        } else {
            description = "";
        }
        return description;
    }

    public final x<Boolean> G() {
        return this.M;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String H() {
        String imageUrl;
        ChallengeModel challengeModel = this.H;
        if (challengeModel != null) {
            n.d(challengeModel);
            imageUrl = challengeModel.getImageUrl();
        } else {
            imageUrl = "";
        }
        return imageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean I() {
        boolean z;
        int i;
        if (!T() && this.K) {
            i = this.K ? 1 : 0;
        } else {
        }
        return i;
    }

    public final LiveData<y<Boolean>> J() {
        return this.T;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel K() {
        int i2;
        Object next;
        int str;
        int i;
        ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131887105);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = g0("(\\d+\\.)", this.G.getString(2131886311)).iterator();
        final int i5 = 1;
        i2 = i5;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next.length() > 0) {
            } else {
            }
            str = 0;
            if (str != null) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append('.');
            stringBuilder.append(next);
            arrayList.addAll(g0("(?=\\*)", stringBuilder.toString()));
            i2++;
            str = i5;
        }
        challengeDetailsTabModel.bulletPointList.addAll(arrayList);
        return challengeDetailsTabModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel L() {
        Object arrayList;
        Object prizeRules;
        ChallengeModel.MediaTypes uNDEFINED;
        int i;
        ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131886274);
        arrayList = new ArrayList();
        prizeRules = this.H;
        final String str = "(?=\\*)";
        n.d(prizeRules);
        if (prizeRules != null && prizeRules.getPrizeRules() != null) {
            n.d(prizeRules);
            if (prizeRules.getPrizeRules() != null) {
                ChallengeModel challengeModel = this.H;
                n.d(challengeModel);
                arrayList = g0(str, challengeModel.getPrizeRules());
            } else {
                ChallengeModel challengeModel2 = this.H;
                if (challengeModel2 != null) {
                    n.d(challengeModel2);
                    uNDEFINED = challengeModel2.getMediaType();
                } else {
                    uNDEFINED = ChallengeModel.MediaTypes.UNDEFINED;
                }
                prizeRules = d0.b.a[uNDEFINED.ordinal()];
                if (prizeRules != 1) {
                    if (prizeRules != 2) {
                    } else {
                        arrayList = g0(str, this.G.getString(2131886273));
                    }
                } else {
                    arrayList = g0(str, this.G.getString(2131886272));
                }
            }
        } else {
        }
        challengeDetailsTabModel.bulletPointList.addAll(arrayList);
        return challengeDetailsTabModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeDetailsTabModel M() {
        ChallengeDetailsTabModel challengeDetailsTabModel = new ChallengeDetailsTabModel();
        challengeDetailsTabModel.title = this.G.getString(2131887106);
        challengeDetailsTabModel.bulletPointList.addAll(g0("(?=\\*)", this.G.getString(2131886315)));
        return challengeDetailsTabModel;
    }

    public final x<Integer> N() {
        return this.J;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String O() {
        String name;
        ChallengeModel challengeModel = this.H;
        if (challengeModel != null) {
            n.d(challengeModel);
            name = challengeModel.getName();
        } else {
            name = "";
        }
        return name;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String P() {
        ChallengeModel sponsor;
        int sponsorDetailsBannerImageUrl;
        sponsor = this.H;
        n.d(sponsor);
        if (sponsor != null && sponsor.hasSponsor()) {
            n.d(sponsor);
            if (sponsor.hasSponsor()) {
                ChallengeModel challengeModel = this.H;
                n.d(challengeModel);
                sponsorDetailsBannerImageUrl = challengeModel.getSponsorDetailsBannerImageUrl();
            } else {
                sponsorDetailsBannerImageUrl = 0;
            }
        } else {
        }
        return sponsorDetailsBannerImageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean Q() {
        int i;
        ChallengeModel hasEnded;
        v2 v2Var;
        hasEnded = this.H;
        if (hasEnded != null) {
            n.d(hasEnded);
            if (hasEnded.isHasEnded(this.D)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean R() {
        Object mediaType;
        int i;
        ChallengeModel.MediaTypes pHOTO_BARKBOX;
        mediaType = this.H;
        n.d(mediaType);
        if (mediaType != null && mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_BARKBOX) {
            n.d(mediaType);
            i = mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_BARKBOX ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean S() {
        boolean z;
        int i;
        if (this.K && !Q() && this.N && Y()) {
            if (!Q()) {
                if (this.N) {
                    i = Y() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean V() {
        Object mediaType;
        int i;
        ChallengeModel.MediaTypes pHOTO_FRIENDLY_COLLAR;
        mediaType = this.H;
        n.d(mediaType);
        if (mediaType != null && mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_FRIENDLY_COLLAR) {
            n.d(mediaType);
            i = mediaType.getMediaType() == ChallengeModel.MediaTypes.PHOTO_FRIENDLY_COLLAR ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean W() {
        int i;
        ChallengeModel hasEnded;
        v2 v2Var;
        hasEnded = this.H;
        n.d(hasEnded);
        ChallengeModel challengeModel = this.H;
        n.d(challengeModel);
        if (hasEnded != null && hasEnded.hasPrize() && !challengeModel.isHasEnded(this.D)) {
            n.d(hasEnded);
            if (hasEnded.hasPrize()) {
                challengeModel = this.H;
                n.d(challengeModel);
                i = !challengeModel.isHasEnded(this.D) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean X() {
        ChallengeModel sponsor;
        int i;
        sponsor = this.H;
        n.d(sponsor);
        if (sponsor != null && sponsor.hasSponsor()) {
            n.d(sponsor);
            i = sponsor.hasSponsor() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void a0() {
        int i;
        int i2;
        if (this.I == 1) {
            this.C.c(u.w);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void b0(a0 a0) {
        boolean z;
        boolean valueOf;
        Object obj2;
        n.f(a0, "navigator");
        if (y()) {
            if (!T()) {
                if (this.L) {
                    if (this.L) {
                        h0();
                    } else {
                        A(a0);
                    }
                } else {
                    this.J.setValue(0);
                }
            } else {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void c0(a0 a0) {
        String sponsorWebsiteUrl;
        int intent;
        int str2;
        boolean sponsor;
        String str;
        Object obj5;
        n.f(a0, "navigator");
        if (this.H != null) {
            c1 c1Var = new c1();
            ChallengeModel challengeModel6 = this.H;
            n.d(challengeModel6);
            this.C.d(n0.d.c(c1Var, challengeModel6.getId()));
            ChallengeModel challengeModel = this.H;
            n.d(challengeModel);
            int i = d0.b.a[challengeModel.getMediaType().ordinal()];
            if (i != 1) {
                sponsorWebsiteUrl = i != 2 ? "" : "http://friendlydogcollars.com.au/?utm_campaign=ah&utm_source=leaddyno&utm_medium=affiliate#_l_ah";
            } else {
                ChallengeModel challengeModel4 = this.H;
                n.d(challengeModel4);
                sponsorWebsiteUrl = n.o("https://www.barkbox.com/?utm_source=DogoAppAndroid&utm_medium=DogoApp&utm_campaign=", challengeModel4.getId());
            }
            ChallengeModel challengeModel5 = this.H;
            n.d(challengeModel5);
            ChallengeModel challengeModel2 = this.H;
            n.d(challengeModel2);
            if (challengeModel5.hasSponsor() && k.a(challengeModel2.getId(), this.E.v()) == null) {
                challengeModel2 = this.H;
                n.d(challengeModel2);
                if (k.a(challengeModel2.getId(), this.E.v()) == null) {
                    ChallengeModel challengeModel3 = this.H;
                    n.d(challengeModel3);
                    sponsorWebsiteUrl = challengeModel3.getSponsorWebsiteUrl();
                }
            }
            if (sponsorWebsiteUrl != null) {
                if (sponsorWebsiteUrl.length() == 0) {
                } else {
                    intent = 0;
                }
                if (intent == null) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(sponsorWebsiteUrl));
                    a0.startActivity(intent);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void d0(boolean z) {
        this.L = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void e0() {
        this.O.u(this.R, this.D.g());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean f0(Bundle bundle) {
        int i;
        String boolean2;
        String boolean;
        boolean obj4;
        if (bundle == null) {
            return 0;
        }
        this.H = (ChallengeModel)bundle.getParcelable("challenge");
        boolean2 = "hide_participate_button";
        if (bundle.containsKey(boolean2)) {
            this.K = bundle.getBoolean(boolean2);
        }
        boolean = "shouldStartCreationFlow";
        if (bundle.containsKey(boolean)) {
            this.P = bundle.getBoolean(boolean);
        }
        String str2 = "shouldTriggerPublish";
        if (bundle.containsKey(str2)) {
            this.Q = bundle.getBoolean(str2);
        }
        l(148);
        l(20);
        l(76);
        l(168);
        l(169);
        if (this.H != null) {
            i = 1;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void z(Bundle bundle) {
        boolean boolean;
        Object valueOf2;
        Integer valueOf;
        boolean obj5;
        if (bundle == null) {
        }
        final int i2 = 0;
        final int i3 = 1;
        if (bundle.getBoolean("show_rules", i2)) {
            this.J.setValue(Integer.valueOf(i3));
            this.I = i3;
        }
        if (bundle.getBoolean("show_checkbox", i2)) {
            this.I = i3;
        }
        if (bundle.getBoolean("show_prize", i2)) {
            this.J.setValue(2);
            this.I = i3;
        }
    }
}
