package app.dogo.com.dogo_android.d.a;

import android.os.Bundle;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.a.n.d;
import app.dogo.com.dogo_android.d.a.n.f;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.m2.b;
import app.dogo.com.dogo_android.service.m2.c;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.util.w;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.w2;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QuerySnapshot;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001Ba\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010G\u001a\u00020H2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020KJ\u0014\u0010M\u001a\u0008\u0012\u0004\u0012\u00020O0N2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010P\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0(J\u0010\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020KH\u0002J\u0006\u0010R\u001a\u00020HJ\u0008\u0010S\u001a\u00020HH\u0016J\u0018\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0017H\u0002J\u0018\u0010X\u001a\u00020H2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0017H\u0002J\u0010\u0010Y\u001a\u00020/2\u0008\u0010Z\u001a\u0004\u0018\u00010[J\u0012\u0010\\\u001a\u00020H2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u000c\u0010]\u001a\u0008\u0012\u0004\u0012\u00020O0NJ\u0010\u0010^\u001a\u00020H2\u0006\u0010%\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)\u0018\u00010(0'¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u0008\u0018\u00010-R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u00082\u00103R\u001e\u00104\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00103R\u0011\u00105\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u00085\u00103R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020/0'¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010+R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010>\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010A\"\u0004\u0008B\u0010CR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialogViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/StateManager;)V", "cachedLikedEntries", "", "", "", "challengeId", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "currentDogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "getCurrentDogProfile", "()Lapp/dogo/com/dogo_android/model/DogProfileModel;", "dataFetcher", "Lapp/dogo/com/dogo_android/util/QueueableEntryDataFetcher;", "entryId", "entryPasser", "Landroidx/lifecycle/MutableLiveData;", "", "Leu/davidea/flexibleadapter/items/IFlexible;", "getEntryPasser", "()Landroidx/lifecycle/MutableLiveData;", "fanPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "fetchingData", "", "firstLaunch", "hasReachedEnd", "isChallengeExpired", "()Z", "isChallengeModelFetched", "isUserSignedIn", "lastSavedPosition", "", "getLastSavedPosition", "()I", "setLastSavedPosition", "(I)V", "listEndNotifier", "getListEndNotifier", "savedList", "Ljava/util/ArrayList;", "getSavedList", "()Ljava/util/ArrayList;", "setSavedList", "(Ljava/util/ArrayList;)V", "userEntryId", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "computeSimpleLikeFor", "itemModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "computeToggleLikeFor", "fetchLikedList", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "getCachedList", "isUserEntriesAuthor", "loadMoreFans", "onDestroy", "onUnvote", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "onUpvote", "setArguments", "bundle", "Landroid/os/Bundle;", "setupFanDataFetcher", "setupFanListData", "setupFanPager", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends r {

    private final a1 A;
    private final h2 B;
    private final o3 C;
    private final u2 D;
    private final p2 E;
    private final q2 F;
    private final s2 G;
    private ChallengeModel H;
    private final Map<String, Object> I;
    private final x<List<f<?>>> J;
    private final x<Boolean> K;
    private w L;
    private m2.b M;
    private String N;
    private String O;
    private String P;
    private boolean Q;
    private boolean R;
    private int S;
    private ArrayList<f<?>> T;
    private boolean U;
    private boolean V;
    private ListenerRegistration W;
    private final m2 z;
    public m() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
    }

    public m(m2 m2, a1 a12, h2 h23, o3 o34, u2 u25, v2 v26, p2 p27, q2 q28, s2 s29) {
        n.f(m2, "firestoreService");
        n.f(a12, "challengeLocalRepository");
        n.f(h23, "authService");
        n.f(o34, "tracker");
        n.f(u25, "userLocalCacheService");
        n.f(v26, "utilities");
        n.f(p27, "preferenceService");
        n.f(q28, "rateItService");
        n.f(s29, "stateManager");
        super();
        this.z = m2;
        this.A = a12;
        this.B = h23;
        this.C = o34;
        this.D = u25;
        this.E = p27;
        this.F = q28;
        this.G = s29;
        HashMap obj2 = new HashMap();
        this.I = obj2;
        obj2 = new x();
        this.J = obj2;
        obj2 = new x();
        this.K = obj2;
        obj2 = 1;
        this.R = obj2;
        ArrayList obj3 = new ArrayList();
        this.T = obj3;
        this.U = obj2;
    }

    public m(m2 m2, a1 a12, h2 h23, o3 o34, u2 u25, v2 v26, p2 p27, q2 q28, s2 s29, int i10, g g11) {
        s2 s2Var;
        m2 m2Var;
        a1 a1Var;
        h2 h2Var;
        o3 o3Var;
        u2 u2Var;
        v2 v2Var;
        p2 p2Var;
        q2 q2Var;
        int i = i10;
        if (i & 1 != 0) {
            m2Var = App.Companion.j();
        } else {
            m2Var = m2;
        }
        if (i & 2 != 0) {
            a1Var = App.Companion.f();
        } else {
            a1Var = a12;
        }
        if (i & 4 != 0) {
            h2Var = App.Companion.c();
        } else {
            h2Var = h23;
        }
        if (i & 8 != 0) {
            o3Var = App.Companion.r();
        } else {
            o3Var = o34;
        }
        if (i & 16 != 0) {
            u2Var = App.Companion.h();
        } else {
            u2Var = u25;
        }
        if (i & 32 != 0) {
            v2Var = App.Companion.t();
        } else {
            v2Var = v26;
        }
        if (i & 64 != 0) {
            p2Var = App.Companion.l();
        } else {
            p2Var = p27;
        }
        if (i & 128 != 0) {
            q2Var = App.Companion.m();
        } else {
            q2Var = q28;
        }
        if (i &= 256 != 0) {
            s2Var = App.Companion.o();
        } else {
            s2Var = s29;
        }
        super(m2Var, a1Var, h2Var, o3Var, u2Var, v2Var, p2Var, q2Var, s2Var);
    }

    private static final Void B(app.dogo.com.dogo_android.d.a.m m, j j2) {
        n.f(m, "this$0");
        n.f(j2, "task");
        final Object obj2 = j2.getResult();
        n.e(obj2, "task.result");
        obj1.a.c().d((Map)obj2, false);
        return null;
    }

    private final DogProfileModel E() {
        return this.D.A().g().toModel(this.B.v());
    }

    private final boolean K(ChallengeEntryVoter challengeEntryVoter) {
        return n.b(challengeEntryVoter.getVoterId(), this.B.v());
    }

    public static void L(app.dogo.com.dogo_android.d.a.m m, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        m.x(m, querySnapshot2, firebaseFirestoreException3);
    }

    public static void M(app.dogo.com.dogo_android.d.a.m m, j j2) {
        m.b0(m, j2);
    }

    public static void N(app.dogo.com.dogo_android.d.a.m m, QuerySnapshot querySnapshot2) {
        m.S(m, querySnapshot2);
    }

    public static Void O(app.dogo.com.dogo_android.d.a.m m, j j2) {
        return m.B(m, j2);
    }

    public static boolean P(app.dogo.com.dogo_android.d.a.m m, ChallengeModel challengeModel2, List list3, int i4) {
        return m.Y(m, challengeModel2, list3, i4);
    }

    public static j Q(app.dogo.com.dogo_android.d.a.m m, j j2) {
        return m.a0(m, j2);
    }

    private static final void S(app.dogo.com.dogo_android.d.a.m m, QuerySnapshot querySnapshot2) {
        Object arrayList;
        Object tRUE;
        String str;
        Class<ChallengeEntryVoter> obj;
        boolean obj5;
        n.f(m, "this$0");
        if (querySnapshot2 != 0) {
            arrayList = new ArrayList();
            obj5 = querySnapshot2.getDocuments().iterator();
            for (DocumentSnapshot next : obj5) {
                str = next.getId();
                n.e(str, "doc.id");
                tRUE = next.toObject(ChallengeEntryVoter.class);
                n.d((ChallengeEntryVoter)tRUE);
                tRUE.setDocumentId(str);
                arrayList.add(tRUE);
            }
            obj5 = m.M;
            n.d(obj5);
            if (obj5.e() && !m.Q) {
                if (!m.Q) {
                    m.Q = true;
                    m.H().setValue(Boolean.TRUE);
                }
            }
            obj5 = m.L;
            n.d(obj5);
            obj5.b(arrayList);
            m.R = false;
            m.i();
        }
    }

    private final void T(ChallengeEntryModel challengeEntryModel, String string2) {
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        q qVar = this.w;
        n.d(qVar);
        this.C.d(u.c.c(i1Var, challengeEntryModel.getDocumentId(), c1Var, challengeEntryModel.getChallengeId(), r2Var, qVar.getTag()));
        this.z.y0(this.B.v(), challengeEntryModel, string2);
        challengeEntryModel.setLikeStateForImage(string2, false);
        challengeEntryModel.incrementVotes(-1);
    }

    private final void U(ChallengeEntryModel challengeEntryModel, String string2) {
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        q qVar = this.w;
        n.d(qVar);
        this.C.d(u.b.c(i1Var, challengeEntryModel.getDocumentId(), c1Var, challengeEntryModel.getChallengeId(), r2Var, qVar.getTag()));
        this.z.E0(this.B.v(), challengeEntryModel, this.P, E().getId(), this.E.h(), string2);
        int i = 1;
        challengeEntryModel.setLikeStateForImage(string2, i);
        challengeEntryModel.incrementVotes(i);
        this.F.l();
        this.F.m();
    }

    private final void X(ChallengeModel challengeModel) {
        n.d(challengeModel);
        i iVar = new i(this, challengeModel);
        super(challengeModel.getId(), 1, this.z, this.D, this.G, iVar, getDisposable());
        this.L = wVar2;
    }

    private static final boolean Y(app.dogo.com.dogo_android.d.a.m m, ChallengeModel challengeModel2, List list3, int i4) {
        ArrayList arrayList;
        Object next;
        boolean dVar;
        int i;
        boolean key;
        String dogId;
        m2 documentId;
        boolean z;
        n.f(m, "this$0");
        n.f(list3, "itemDataList");
        ArrayList obj9 = new ArrayList();
        arrayList = new ArrayList();
        Iterator obj8 = list3.iterator();
        int i2 = 1;
        while (obj8.hasNext()) {
            next = obj8.next();
            if ((ChallengeEntryVoter)next.getDogId() == null) {
            }
            if (i2 ^= key != 0) {
            }
            i2 = 1;
            arrayList.add(next);
            dogId = "";
        }
        obj8 = arrayList.iterator();
        while (obj8.hasNext()) {
            arrayList = obj8.next();
            ChallengeEntryModel voterEntryModel = (ChallengeEntryVoter)arrayList.getVoterEntryModel();
            if (voterEntryModel != null) {
            } else {
            }
            DogProfileModel dogProfile = arrayList.getDogProfile();
            if (dogProfile == null) {
            } else {
            }
            dVar = dogProfile.getName();
            if (dVar) {
            }
            dVar = new f(arrayList);
            obj9.add(dVar);
            dVar = 0;
            voterEntryModel.setUserLiked(m.I.containsKey(voterEntryModel.getDocumentId()));
            arrayList.setChallengeName(challengeModel2.getName());
            dVar = new d(arrayList);
            obj9.add(dVar);
        }
        m.F().setValue(obj9);
        m.I().addAll(obj9);
        return i2;
    }

    private static final j a0(app.dogo.com.dogo_android.d.a.m m, j j2) {
        n.f(m, "this$0");
        n.f(j2, "task");
        m.H = (ChallengeModel)j2.getResult();
        m.X(m.D());
        ChallengeModel obj2 = m.D();
        n.d(obj2);
        m.w(obj2);
        obj2 = m.D();
        n.d(obj2);
        return m.A(obj2);
    }

    private static final void b0(app.dogo.com.dogo_android.d.a.m m, j j2) {
        n.f(m, "this$0");
        m.R = false;
        m.V = true;
    }

    private final void c0(String string) {
        final m2 m2Var = this.z;
        m2.c obj4 = m2Var.L(f.entryFans.forEntryId(string));
        obj4.e("date", Query.Direction.DESCENDING);
        this.M = m2Var.c(obj4.a(), 5, 0);
    }

    private final void w(ChallengeModel challengeModel) {
        if (this.W != null) {
        }
        m2.c cVar = this.z.L(f.allEntries);
        cVar.b(this.B.v());
        cVar.c(challengeModel.getId());
        cVar.d(1);
        e eVar = new e(this);
        this.W = cVar.a().addSnapshotListener(eVar);
    }

    private static final void x(app.dogo.com.dogo_android.d.a.m m, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        int str;
        boolean empty;
        Object[] obj2;
        String obj3;
        Object obj4;
        n.f(m, "this$0");
        str = 0;
        if (querySnapshot2 != null && !querySnapshot2.isEmpty()) {
            if (!querySnapshot2.isEmpty()) {
                obj4 = (DocumentSnapshot)querySnapshot2.getDocuments().get(str).toObject(ChallengeEntryModel.class);
                n.d((ChallengeEntryModel)obj4);
                obj3 = (DocumentSnapshot)querySnapshot2.getDocuments().get(str).getId();
                n.e(obj3, "queryDocumentSnapshots.documents[0].id");
                obj4.setDocumentId(obj3);
                m.P = obj4.getDocumentId();
            } else {
                a.e(firebaseFirestoreException3, "queryDocumentSnapshots is null", new Object[str]);
            }
        } else {
        }
    }

    public final j<Void> A(ChallengeModel challengeModel) {
        n.f(challengeModel, "challengeModel");
        h hVar = new h(this);
        j obj4 = this.z.B(this.B.v(), challengeModel.getId(), false).continueWith(hVar);
        n.e(obj4, "firestoreService.fetchUserLikeListForChallenge(authService.currentUserId, challengeModel.id, false).continueWith { task: Task<Map<String, Map<String, Boolean>>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(task.result, false)\n            null\n        }");
        return obj4;
    }

    public final List<f<?>> C() {
        Object next;
        String voterEntryModel;
        m2 m2Var;
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.T.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            voterEntryModel = next;
            z = 1;
            if (voterEntryModel instanceof d) {
            } else {
            }
            voterEntryModel = (f)(f)voterEntryModel.g().getVoterEntryModel();
            if (voterEntryModel instanceof f && voterEntryModel != null) {
            }
            if (z) {
            }
            arrayList.add(next);
            voterEntryModel = (f)voterEntryModel.g().getVoterEntryModel();
            if (voterEntryModel != null) {
            }
            z = this.z.R(voterEntryModel, this.B.v(), this.B.C());
            if ((d)voterEntryModel.g().getDogId() == null) {
            }
            z = this.z.Q(voterEntryModel, this.B.C());
            voterEntryModel = "";
        }
        return arrayList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel D() {
        return this.H;
    }

    public final x<List<f<?>>> F() {
        return this.J;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int G() {
        return this.S;
    }

    public final x<Boolean> H() {
        return this.K;
    }

    public final ArrayList<f<?>> I() {
        return this.T;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J() {
        return this.V;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void R() {
        boolean z;
        app.dogo.com.dogo_android.d.a.g gVar;
        if (!this.R) {
            this.R = true;
            z = this.M;
            n.d(z);
            gVar = new g(this);
            z.c(gVar);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean V(Bundle bundle) {
        String str;
        int i;
        String obj4;
        int i2 = 0;
        i = 1;
        if (bundle != null && !this.U) {
            i = 1;
            if (!this.U) {
                this.J.setValue(0);
                return i;
            }
            this.U = i2;
            this.N = bundle.getString("id");
            obj4 = bundle.getString("challenge_id");
            this.O = obj4;
            if (this.N != null) {
                if (obj4 == null) {
                } else {
                    obj4 = this.A.a(obj4);
                    this.H = obj4;
                    if (obj4 != null) {
                        this.V = i;
                    }
                }
                return i;
            }
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void W(int i) {
        this.S = i;
    }

    public final j<Void> Z() {
        boolean z;
        j continueWithTask;
        Object str2;
        String str;
        String str3 = this.N;
        n.d(str3);
        c0(str3);
        z = this.H;
        if (this.V && z != null) {
            z = this.H;
            if (z != null) {
                n.d(z);
                continueWithTask = A(z);
                X(this.H);
                str2 = this.H;
                n.d(str2);
                w(str2);
            } else {
                String str4 = this.O;
                n.d(str4);
                j jVar2 = new j(this);
                n.e(this.z.s(str4, this.E.W()).continueWithTask(jVar2), "firestoreService.fetchChallengeModel(challengeId!!, preferenceService.selectedLocale).continueWithTask { task: Task<ChallengeModel?> ->\n                challengeModel = task.result\n                setupFanDataFetcher(challengeModel)\n                attachUserEntryListener(challengeModel!!)\n                fetchLikedList(challengeModel!!)\n            }");
            }
        } else {
        }
        f fVar = new f(this);
        j onCompleteListener = continueWithTask.addOnCompleteListener(fVar);
        n.e(onCompleteListener, "dataFetchTask.addOnCompleteListener {\n            fetchingData = false\n            isChallengeModelFetched = true\n        }");
        return onCompleteListener;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n() {
        super.n();
        ListenerRegistration list = this.W;
        if (list != null) {
            n.d(list);
            list.remove();
        }
        w wVar = this.L;
        if (wVar != null) {
            n.d(wVar);
            wVar.p();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void y(ChallengeEntryVoter challengeEntryVoter) {
        n.f(challengeEntryVoter, "itemModel");
        ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
        if (K(challengeEntryVoter)) {
        }
        if (voterEntryModel == null) {
        }
        final String obj3 = challengeEntryVoter.getSelectedPhotoId();
        if (voterEntryModel.getLikeStateForImage(obj3)) {
        }
        if (obj3 != null) {
            U(voterEntryModel, obj3);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void z(ChallengeEntryVoter challengeEntryVoter) {
        boolean likeStateForImage;
        n.f(challengeEntryVoter, "itemModel");
        ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
        if (K(challengeEntryVoter)) {
        }
        if (voterEntryModel == null) {
        }
        final String obj3 = challengeEntryVoter.getSelectedPhotoId();
        if (obj3 != null) {
            if (voterEntryModel.getLikeStateForImage(obj3)) {
                T(voterEntryModel, obj3);
            } else {
                U(voterEntryModel, obj3);
            }
        }
    }
}
