package app.dogo.com.dogo_android.d.d;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.d.r.e;
import app.dogo.com.dogo_android.d.d.r.g;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentChange.Type;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import h.a.b.h.f;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010$\n\u0002\u0010#\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0018\u0010B\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CH\u0002J\u0016\u0010D\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CJ\u0018\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0C2\u0006\u0010G\u001a\u00020\u0019H\u0002J\u0016\u0010H\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CJ\u0006\u0010I\u001a\u00020@J\u0010\u0010J\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u0018J\u0006\u0010K\u001a\u00020\u001cJ\u0006\u0010L\u001a\u00020\u001cJ\u0006\u0010M\u001a\u00020\u001cJ\u0006\u0010N\u001a\u00020@J\u0006\u0010O\u001a\u00020@J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u001eJ\u0010\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0CH\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0,0\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010/\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u00086\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R)\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190:090\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010.R \u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190:0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "resources", "Landroid/content/res/Resources;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "badgeList", "", "", "currentDogChangeTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "<set-?>", "isFirstLaunch", "()Z", "lastSavedPosition", "", "getLastSavedPosition", "()I", "setLastSavedPosition", "(I)V", "likeList", "", "", "profileLoadResult", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getProfileLoadResult", "()Landroidx/lifecycle/MutableLiveData;", "savedList", "Leu/davidea/flexibleadapter/items/IFlexible;", "getSavedList", "()Ljava/util/List;", "setSavedList", "(Ljava/util/List;)V", "title", "getTitle", "()Ljava/lang/String;", "userEntryChangeListener", "", "", "getUserEntryChangeListener", "userEntryIds", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "detachUserEntryListener", "fetchChallengeAndEntries", "Lcom/google/android/gms/tasks/Task;", "fetchEntries", "fetchLikeListForEntry", "Ljava/lang/Void;", "entryId", "fetchListData", "fetchPublicProfile", "getCachedList", "isAdmin", "isDataLoaded", "isDogReported", "retry", "saveProfileReport", "setArguments", "arguments", "Landroid/os/Bundle;", "updateDogProfile", "data", "updateLikeList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends s {

    private final Resources a;
    private final p1 b;
    private final m2 c;
    private final h2 d;
    private final a1 e;
    private final p2 f;
    private final r2 g;
    private final s2 h;
    private final j2 i;
    private final o3 j;
    private ListenerRegistration k;
    private LiteDogProfile l;
    private final Map<String, Object> m;
    private final Map<String, Set<String>> n;
    private List<String> o;
    private boolean p = true;
    private final x<Boolean> q;
    private final x<y<LiteDogProfile>> r;
    private final x<Map<String, Set<String>>> s;
    private List<? extends f<?>> t;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.d.d.p this$0;
        a(app.dogo.com.dogo_android.d.d.p p) {
            this.this$0 = p;
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
            y.a aVar = new y.a(throwable);
            this.this$0.y().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<LiteDogProfile, w> {

        final app.dogo.com.dogo_android.d.d.p this$0;
        b(app.dogo.com.dogo_android.d.d.p p) {
            this.this$0 = p;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(LiteDogProfile liteDogProfile) {
            y.c cVar = new y.c(liteDogProfile);
            this.this$0.y().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((LiteDogProfile)object);
            return w.a;
        }
    }
    public p(Resources resources, p1 p12, m2 m23, h2 h24, a1 a15, p2 p26, r2 r27, s2 s28, j2 j29, o3 o310) {
        n.f(resources, "resources");
        n.f(p12, "userRepository");
        n.f(m23, "firestoreService");
        n.f(h24, "authService");
        n.f(a15, "challengeLocalRepository");
        n.f(p26, "preferenceService");
        n.f(r27, "remoteConfigService");
        n.f(s28, "stateManager");
        n.f(j29, "connectivityService");
        n.f(o310, "tracker");
        super();
        this.a = resources;
        this.b = p12;
        this.c = m23;
        this.d = h24;
        this.e = a15;
        this.f = p26;
        this.g = r27;
        this.h = s28;
        this.i = j29;
        this.j = o310;
        HashMap obj2 = new HashMap();
        this.m = obj2;
        obj2 = new HashMap();
        this.n = obj2;
        obj2 = new ArrayList();
        this.o = obj2;
        obj2 = 1;
        obj2 = new x();
        this.q = obj2;
        obj2 = new x();
        this.r = obj2;
        obj2 = new x();
        this.s = obj2;
        this.t = p.g();
        obj2 = new v();
        e obj4 = new e(this);
        obj2.b(p12.x(), obj4);
    }

    public static void G(app.dogo.com.dogo_android.d.d.p p, DogProfile dogProfile2) {
        p.h(p, dogProfile2);
    }

    public static Void H(app.dogo.com.dogo_android.d.d.p p, j j2) {
        return p.X(p, j2);
    }

    public static Void I(app.dogo.com.dogo_android.d.d.p p, String string2, j j3) {
        return p.r(p, string2, j3);
    }

    public static Map J(app.dogo.com.dogo_android.d.d.p p, j j2) {
        return p.m(p, j2);
    }

    public static List K(app.dogo.com.dogo_android.d.d.p p, Map map2, j j3) {
        return p.p(p, map2, j3);
    }

    public static LiteDogProfile L(PublicDogProfile publicDogProfile) {
        return p.v(publicDogProfile);
    }

    public static List M(app.dogo.com.dogo_android.d.d.p p, j j2) {
        return p.t(p, j2);
    }

    public static void N(app.dogo.com.dogo_android.d.d.p p, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        p.j(p, querySnapshot2, firebaseFirestoreException3);
    }

    public static j O(app.dogo.com.dogo_android.d.d.p p, j j2) {
        return p.n(p, j2);
    }

    public static LiteDogProfile P(app.dogo.com.dogo_android.d.d.p p, Throwable throwable2) {
        return p.w(p, throwable2);
    }

    private final j<Void> W() {
        f fVar = new f(this);
        j continueWith = this.c.B(this.d.v(), 0, true).continueWith(fVar);
        n.e(continueWith, "firestoreService.fetchUserLikeListForChallenge(authService.currentUserId, null, true).continueWith { task: Task<Map<String, Map<String, Boolean>>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(task.result, true)\n            null\n        }");
        return continueWith;
    }

    private static final Void X(app.dogo.com.dogo_android.d.d.p p, j j2) {
        n.f(p, "this$0");
        n.f(j2, "task");
        final Object obj2 = j2.getResult();
        n.e(obj2, "task.result");
        obj1.a.c().d((Map)obj2, true);
        return null;
    }

    private static final void h(app.dogo.com.dogo_android.d.d.p p, DogProfile dogProfile2) {
        Object obj1;
        Boolean obj2;
        n.f(p, "this$0");
        if (dogProfile2 != null) {
            p.q.setValue(Boolean.TRUE);
        }
    }

    private static final void j(app.dogo.com.dogo_android.d.d.p p, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        Object obj;
        Object type;
        Object hashSet;
        DocumentChange.Type mODIFIED;
        DocumentChange.Type aDDED;
        String obj6;
        n.f(p, "this$0");
        if (querySnapshot2 == null) {
        }
        Iterator obj5 = querySnapshot2.getDocumentChanges().iterator();
        while (obj5.hasNext()) {
            obj6 = obj5.next();
            obj = (DocumentChange)obj6.getDocument().get("challengeId");
            if ((String)obj != null) {
            }
            if (obj6.getType() == DocumentChange.Type.MODIFIED) {
            } else {
            }
            hashSet = p.n.get((String)obj);
            if (obj6.getType() == DocumentChange.Type.ADDED) {
            } else {
            }
            if (obj6.getType() == DocumentChange.Type.REMOVED) {
            }
            p.B().setValue(p.n);
            if ((Set)hashSet == null) {
            } else {
            }
            (Set)hashSet.remove(obj6.getDocument().getId());
            if (hashSet == null) {
            }
            obj6 = obj6.getDocument().getId();
            n.e(obj6, "docChange.document.id");
            hashSet.add(obj6);
            hashSet = new HashSet();
            p.n.put(obj, hashSet);
        }
    }

    private final j<List<f<?>>> l() {
        h hVar = new h(this);
        m mVar = new m(this);
        j continueWithTask = this.c.n(this.f.W(), this.g.v(), this.d.C()).continueWith(hVar).continueWithTask(mVar);
        n.e(continueWithTask, "firestoreService.fetchAllChallenges(preferenceService.selectedLocale, remoteConfigService.locationCode, authService.isUserAdmin).continueWith<Map<String, ChallengeModel>> { task: Task<List<ChallengeModel>> ->\n            val challenges: MutableMap<String, ChallengeModel> = HashMap()\n            for (model in task.result) {\n                challenges[model.id] = model\n            }\n            challengeLocalRepository.setChallenges(task.result)\n            challenges\n        }.continueWithTask { fetchEntries() }");
        return continueWithTask;
    }

    private static final Map m(app.dogo.com.dogo_android.d.d.p p, j j2) {
        Object next;
        String str;
        n.f(p, "this$0");
        n.f(j2, "task");
        HashMap hashMap = new HashMap();
        Iterator iterator = (List)j2.getResult().iterator();
        for (ChallengeModel next : iterator) {
            hashMap.put(next.getId(), next);
        }
        final Object obj5 = j2.getResult();
        n.e(obj5, "task.result");
        p.e.c((List)obj5);
        return hashMap;
    }

    private static final j n(app.dogo.com.dogo_android.d.d.p p, j j2) {
        n.f(p, "this$0");
        return p.o();
    }

    private static final List p(app.dogo.com.dogo_android.d.d.p p, Map map2, j j3) {
        Object obj;
        Object object;
        s2.a eVar;
        String str;
        boolean z;
        n.f(p, "this$0");
        n.f(map2, "$challengeModels");
        n.f(j3, "task");
        ArrayList arrayList = new ArrayList();
        Iterator obj8 = (QuerySnapshot)j3.getResult().iterator();
        while (obj8.hasNext()) {
            Object next2 = obj8.next();
            object = (QueryDocumentSnapshot)next2.toObject(ChallengeEntryModel.class);
            n.e(object, "doc.toObject(ChallengeEntryModel::class.java)");
            String id2 = next2.getId();
            n.e(id2, "doc.id");
            (ChallengeEntryModel)object.setDocumentId(id2);
            object.setEntryStateData(s2Var.a.b(next2.getId()));
            obj = map2.get(object.getChallengeId());
            if ((ChallengeModel)obj != null && !p.c.R(object, p.d.v(), p.d.C())) {
            }
            if (!p.c.R(object, p.d.v(), p.d.C())) {
            }
            eVar = new e(object, (ChallengeModel)obj);
            arrayList.add(eVar);
        }
        return arrayList;
    }

    private final j<Void> q(String string) {
        g gVar = new g(this, string);
        final j obj4 = this.c.D(this.d.v(), string, false).continueWith(gVar);
        n.e(obj4, "firestoreService.fetchUserLikeListForEntry(authService.currentUserId, entryId, false).continueWith { task: Task<Map<String, Boolean>?> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(entryId, task.result)\n            null\n        }");
        return obj4;
    }

    private static final Void r(app.dogo.com.dogo_android.d.d.p p, String string2, j j3) {
        n.f(p, "this$0");
        n.f(string2, "$entryId");
        n.f(j3, "task");
        obj1.a.c().c(string2, (Map)j3.getResult());
        return null;
    }

    private static final List t(app.dogo.com.dogo_android.d.d.p p, j j2) {
        Object next;
        boolean z;
        int i;
        Object votes;
        boolean z2;
        n.f(p, "this$0");
        int i2 = 0;
        Object obj7 = (j)(List)j2.getResult().get(i2).getResult();
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.collections.List<eu.davidea.flexibleadapter.items.IFlexible<*>>");
        Iterator iterator = (List)obj7.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof e) {
            }
            p.q((e)(f)next.getId());
        }
        p.m.clear();
        p.p = i2;
        List list = p.N0(obj7);
        Iterator iterator2 = obj7.iterator();
        i = i2;
        while (iterator2.hasNext()) {
            votes = iterator2.next();
            if (votes instanceof e) {
            }
            i += votes;
        }
        LiteDogProfile liteDogProfile = p.l;
        n.d(liteDogProfile);
        List list2 = p.o;
        n.d(list2);
        g gVar = new g(liteDogProfile, obj7.size(), i, list2);
        list.add(i2, gVar);
        p.U(list);
        return list;
    }

    private static final LiteDogProfile v(PublicDogProfile publicDogProfile) {
        n.f(publicDogProfile, "it");
        LiteDogProfile liteDogProfile = new LiteDogProfile(publicDogProfile.getName(), publicDogProfile.getAvatarUrl(), publicDogProfile.getId());
        return liteDogProfile;
    }

    private static final LiteDogProfile w(app.dogo.com.dogo_android.d.d.p p, Throwable throwable2) {
        n.f(p, "this$0");
        n.f(throwable2, "it");
        return p.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String A() {
        String string;
        Object str;
        LiteDogProfile liteDogProfile = this.l;
        if (liteDogProfile == null) {
            string = 0;
        } else {
            string = liteDogProfile.getName();
        }
        if (this.l != null && string != null) {
            if (string != null) {
            } else {
                n.e(this.a.getString(2131886675), "resources.getString(R.string.general_anonymous)");
            }
        } else {
        }
        return string;
    }

    public final x<Map<String, Set<String>>> B() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean C() {
        return this.d.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D() {
        return empty ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean E() {
        Object liteDogProfile;
        String str;
        liteDogProfile = this.l;
        str = "";
        if (liteDogProfile == null) {
        } else {
            liteDogProfile = liteDogProfile.getId();
            if (liteDogProfile == null) {
            } else {
                str = liteDogProfile;
            }
        }
        return this.c.Q(str, this.d.C());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean F() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Q() {
        u();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        Object liteDogProfile;
        boolean key;
        ArrayList arrayList;
        int i;
        String str;
        liteDogProfile = this.l;
        if (liteDogProfile == null) {
        } else {
            liteDogProfile = liteDogProfile.getId();
            if (liteDogProfile == null) {
            } else {
                if (this.b.H().m().containsKey(liteDogProfile) == null) {
                    List list2 = p.I(z(), e.class);
                    arrayList = new ArrayList(p.r(list2, 10));
                    Iterator iterator = list2.iterator();
                    for (e next2 : iterator) {
                        arrayList.add(next2.getId());
                    }
                    this.c.p0(liteDogProfile, this.d.v(), arrayList);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S(Bundle bundle) {
        n.f(bundle, "arguments");
        this.l = (LiteDogProfile)bundle.getParcelable("liteDogProfile");
        this.o = bundle.getStringArrayList("badges");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T(int i) {
    }

    public final void U(List<? extends f<?>> list) {
        n.f(list, "<set-?>");
        this.t = list;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void V(LiteDogProfile liteDogProfile) {
        n.f(liteDogProfile, "data");
        this.l = liteDogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        if (this.k != null) {
        }
        l lVar = new l(this);
        this.k = this.c.z(this.d.v(), 0, lVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        Object list;
        list = this.k;
        if (list != null) {
            n.d(list);
            list.remove();
            this.k = 0;
            this.n.clear();
        }
    }

    public final j<List<f<?>>> o() {
        LiteDogProfile liteDogProfile = this.l;
        n.d(liteDogProfile);
        i iVar = new i(this, this.e.b());
        j continueWith = this.c.m(liteDogProfile.getId()).continueWith(iVar);
        n.e(continueWith, "firestoreService.fetchAllChallengeEntriesForDog(dogProfile!!.id).continueWith { task: Task<QuerySnapshot> ->\n            val list: MutableList<IFlexible<*>> = ArrayList()\n            for (doc in task.result) {\n                val entryModel = doc.toObject(ChallengeEntryModel::class.java)\n                entryModel.setDocumentId(doc.id)\n                entryModel.setEntryStateData(stateManager.challengeState.getEntryStateDataFor(doc.id))\n                val challengeModel = challengeModels[entryModel.challengeId]\n                if (challengeModel != null && !firestoreService.isEntryReported(entryModel, authService.currentUserId, authService.isUserAdmin)) {\n                    list.add(ChallengeProfileItem(entryModel, challengeModel))\n                }\n            }\n            list\n        }");
        return continueWith;
    }

    public final j<List<f<?>>> s() {
        j jVar;
        final int i2 = 1;
        if (empty ^= i2 != 0) {
            jVar = o();
        } else {
            jVar = l();
        }
        j[] arr = new j[2];
        arr[i2] = W();
        k kVar = new k(this);
        j continueWith = m.i(arr).continueWith(kVar);
        n.e(continueWith, "whenAllComplete(entryTask, fetchTask).continueWith {\n            val entryList = it.result[0].result as List<IFlexible<*>>\n            for (item in entryList) {\n                if (item is ChallengeProfileItem) {\n                    fetchLikeListForEntry(item.id)\n                }\n            }\n            likeList.clear()\n            isFirstLaunch = false\n            val itemList = entryList.toMutableList()\n            var totalLikes = 0\n            entryList.forEach { item ->\n                if (item is ChallengeProfileItem) {\n                    totalLikes += item.entryModel.getVotes()\n                }\n            }\n            itemList.add(0, ChallengeProfileTitleItem(dogProfile!!, entryList.size, totalLikes, badgeList!!))\n            savedList = itemList\n            itemList\n        }");
        return continueWith;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        Object liteDogProfile;
        Object disposable;
        String str;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.d.d.p.b bVar;
        this.r.postValue(y.b.a);
        if (!this.i.a()) {
            this.j.s("challenge_profile");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.r.postValue(aVar);
        } else {
            liteDogProfile = this.l;
            str = "";
            if (liteDogProfile == null) {
            } else {
                liteDogProfile = liteDogProfile.getId();
                if (liteDogProfile == null) {
                } else {
                    str = liteDogProfile;
                }
            }
            n nVar = new n(this);
            a0 observeOn = this.b.E(str).map(j.a).onErrorReturn(nVar).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "userRepository.getPublicDogProfile(dogId)\n                    .map {\n                        LiteDogProfile(\n                            name = it.name,\n                            avatar = it.avatarUrl,\n                            id = it.id\n                        )\n                    }.onErrorReturn {\n                        dogProfile\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            unknownHostException = new p.a(this);
            bVar = new p.b(this);
            getDisposable().b(a.g(observeOn, unknownHostException, bVar));
        }
    }

    public final List<f<?>> x() {
        Object next;
        int i;
        Object obj;
        m2 m2Var;
        String str;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.t.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = next;
            if (obj instanceof e) {
            } else {
            }
            i = 1;
            if (i != 0) {
            }
            arrayList.add(next);
            if (!this.c.R((e)(f)obj.g(), this.d.v(), this.d.C())) {
            } else {
            }
            i = 0;
        }
        return arrayList;
    }

    public final x<y<LiteDogProfile>> y() {
        return this.r;
    }

    public final List<f<?>> z() {
        return this.t;
    }
}
