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
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: ChallengeProfileDialogViewModel.kt */
@Metadata(d1 = "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010$\n\u0002\u0010#\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0018\u0010B\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CH\u0002J\u0016\u0010D\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CJ\u0018\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0C2\u0006\u0010G\u001a\u00020\u0019H\u0002J\u0016\u0010H\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u00180CJ\u0006\u0010I\u001a\u00020@J\u0010\u0010J\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u0018J\u0006\u0010K\u001a\u00020\u001cJ\u0006\u0010L\u001a\u00020\u001cJ\u0006\u0010M\u001a\u00020\u001cJ\u0006\u0010N\u001a\u00020@J\u0006\u0010O\u001a\u00020@J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u001eJ\u0010\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0CH\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0,0\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010/\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u0003000\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\u00086\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R)\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190:090\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010.R \u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190:0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "resources", "Landroid/content/res/Resources;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "badgeList", "", "", "currentDogChangeTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "<set-?>", "isFirstLaunch", "()Z", "lastSavedPosition", "", "getLastSavedPosition", "()I", "setLastSavedPosition", "(I)V", "likeList", "", "", "profileLoadResult", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getProfileLoadResult", "()Landroidx/lifecycle/MutableLiveData;", "savedList", "Leu/davidea/flexibleadapter/items/IFlexible;", "getSavedList", "()Ljava/util/List;", "setSavedList", "(Ljava/util/List;)V", "title", "getTitle", "()Ljava/lang/String;", "userEntryChangeListener", "", "", "getUserEntryChangeListener", "userEntryIds", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "detachUserEntryListener", "fetchChallengeAndEntries", "Lcom/google/android/gms/tasks/Task;", "fetchEntries", "fetchLikeListForEntry", "Ljava/lang/Void;", "entryId", "fetchListData", "fetchPublicProfile", "getCachedList", "isAdmin", "isDataLoaded", "isDogReported", "retry", "saveProfileReport", "setArguments", "arguments", "Landroid/os/Bundle;", "updateDogProfile", "data", "updateLikeList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class ChallengeProfileDialogViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final Resources authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 badgeList;
    /* renamed from: c, reason: from kotlin metadata */
    private final m2 challengeLocalRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final h2 connectivityService;
    /* renamed from: e, reason: from kotlin metadata */
    private final a1 currentDogChangeTrigger;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 dogProfile;
    /* renamed from: g, reason: from kotlin metadata */
    private final r2 firestoreService;
    private final s2 h;
    private final j2 i;
    /* renamed from: j, reason: from kotlin metadata */
    private final o3 likeList;
    /* renamed from: k, reason: from kotlin metadata */
    private ListenerRegistration preferenceService;
    private LiteDogProfile l;
    /* renamed from: m, reason: from kotlin metadata */
    private final Map<String, Object> remoteConfigService = new HashMap<>();
    /* renamed from: n, reason: from kotlin metadata */
    private final Map<String, Set<String>> resources = new HashMap<>();
    /* renamed from: o, reason: from kotlin metadata */
    private List<String> savedList = new ArrayList<>();
    /* renamed from: p, reason: from kotlin metadata */
    private boolean stateManager = true;
    private final x<Boolean> q = new x<>();
    /* renamed from: r, reason: from kotlin metadata */
    private final x<y<LiteDogProfile>> tracker = new x<>();
    private final x<Map<String, Set<String>>> s = new x<>();
    /* renamed from: t, reason: from kotlin metadata */
    private List<? extends f<?>> userEntryIds;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
            p.this.y().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<LiteDogProfile, w> {
        @Override // kotlin.d0.d.p
        public final void a(LiteDogProfile liteDogProfile) {
            p.this.y().postValue(new LoadResult_Success(liteDogProfile));
        }

        b() {
            super(1);
        }
    }
    public p(Resources resources, p1 p1Var, m2 m2Var, h2 h2Var, a1 a1Var, p2 p2Var, r2 r2Var, s2 s2Var, j2 j2Var, o3 o3Var) {
        n.f(resources, "resources");
        n.f(p1Var, "userRepository");
        n.f(m2Var, "firestoreService");
        n.f(h2Var, "authService");
        n.f(a1Var, "challengeLocalRepository");
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        n.f(s2Var, "stateManager");
        n.f(j2Var, "connectivityService");
        n.f(o3Var, "tracker");
        super();
        this.authService = resources;
        this.badgeList = p1Var;
        this.challengeLocalRepository = m2Var;
        this.connectivityService = h2Var;
        this.currentDogChangeTrigger = a1Var;
        this.dogProfile = p2Var;
        this.firestoreService = r2Var;
        this.h = s2Var;
        this.i = j2Var;
        this.likeList = o3Var;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        this.userEntryIds = p.g();
        new v().b(p1Var.x(), new app.dogo.com.dogo_android.challenge.profile.e(this));
    }

    /* renamed from: W, reason: from kotlin metadata */
    private final j<Void> attachUserEntryListener() {
        j continueWith = this.challengeLocalRepository.fetchAllChallenges(this.connectivityService.v(), null, true).continueWith(new app.dogo.com.dogo_android.challenge.profile.f(this));
        n.e(continueWith, "firestoreService.fetchUserLikeListForChallenge(authService.currentUserId, null, true).continueWith { task: Task<Map<String, Map<String, Boolean>>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(task.result, true)\n            null\n        }");
        return continueWith;
    }

    private static final Void X(p pVar, j jVar) {
        n.f(pVar, "this$0");
        n.f(jVar, "task");
        final Object result = jVar.getResult();
        n.e(result, "task.result");
        pVar.h.a.c().setEntryVoteCount(result, true);
        return null;
    }

    private static final void h(p pVar, DogProfile dogProfile) {
        n.f(pVar, "this$0");
        if (dogProfile != null) {
            pVar.q.setValue(Boolean.TRUE);
        }
    }

    private static final void j(p pVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        String str;
        Object value;
        DocumentChange.Type type2;
        DocumentChange.Type aDDED2;
        item = "this$0";
        n.f(pVar, item);
        if (querySnapshot == null) {
            return;
        }
        Iterator it = querySnapshot.getDocumentChanges().iterator();
        while (it.hasNext()) {
            String item = it.next();
            str = "challengeId";
            Object obj = item.getDocument().get(str);
        }
    }

    private final j<List<f<?>>> l() {
        j continueWithTask = this.challengeLocalRepository.startListeningToArchivedNotificationBranch(this.dogProfile.W(), this.firestoreService.v(), this.connectivityService.C()).continueWith(new app.dogo.com.dogo_android.challenge.profile.h(this)).continueWithTask(new app.dogo.com.dogo_android.challenge.profile.m(this));
        n.e(continueWithTask, "firestoreService.fetchAllChallenges(preferenceService.selectedLocale, remoteConfigService.locationCode, authService.isUserAdmin).continueWith<Map<String, ChallengeModel>> { task: Task<List<ChallengeModel>> ->\n            val challenges: MutableMap<String, ChallengeModel> = HashMap()\n            for (model in task.result) {\n                challenges[model.id] = model\n            }\n            challengeLocalRepository.setChallenges(task.result)\n            challenges\n        }.continueWithTask { fetchEntries() }");
        return continueWithTask;
    }

    private static final Map m(p pVar, j jVar) {
        n.f(pVar, "this$0");
        n.f(jVar, "task");
        HashMap hashMap = new HashMap();
        Iterator it = (List)jVar.getResult().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            hashMap.put(item.getId(), item);
        }
        final Object result2 = jVar.getResult();
        n.e(result2, "task.result");
        pVar.currentDogChangeTrigger.setChallenges(result2);
        return hashMap;
    }

    private static final j n(p pVar, j jVar) {
        n.f(pVar, "this$0");
        return pVar.o();
    }

    private static final List p(p pVar, Map map, j jVar) {
        boolean z;
        n.f(pVar, "this$0");
        n.f(map, "$challengeModels");
        n.f(jVar, "task");
        ArrayList arrayList = new ArrayList();
        Iterator it = (QuerySnapshot)jVar.getResult().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Object object = item.toObject(ChallengeEntryModel.class);
            n.e(object, "doc.toObject(ChallengeEntryModel::class.java)");
            String id2 = item.getId();
            str = "doc.id";
            n.e(id2, str);
            object.setDocumentId(id2);
            object.setEntryStateData(pVar.h.a.b(item.getId()));
            Object value = map.get(object.getChallengeId());
        }
        return arrayList;
    }

    /* renamed from: q, reason: from kotlin metadata */
    private final j<Void> setArguments(String arguments) {
        final j continueWith = this.challengeLocalRepository.fetchAllChallengesQuery(this.connectivityService.v(), arguments, false).continueWith(new app.dogo.com.dogo_android.challenge.profile.g(this, arguments));
        n.e(continueWith, "firestoreService.fetchUserLikeListForEntry(authService.currentUserId, entryId, false).continueWith { task: Task<Map<String, Boolean>?> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(entryId, task.result)\n            null\n        }");
        return continueWith;
    }

    private static final Void r(p pVar, String str, j jVar) {
        n.f(pVar, "this$0");
        n.f(str, "$entryId");
        n.f(jVar, "task");
        pVar.h.a.c().setEntryCommentCount(str, (Map)jVar.getResult());
        return null;
    }

    private static final List t(p pVar, j jVar) {
        int i;
        n.f(pVar, "this$0");
        i = 0;
        Object result2 = (j)(List)jVar.getResult().get(i).getResult();
        Objects.requireNonNull(result2, "null cannot be cast to non-null type kotlin.collections.List<eu.davidea.flexibleadapter.items.IFlexible<*>>");
        Iterator it = result2.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof ChallengeProfileItem;
        }
        pVar.remoteConfigService.clear();
        pVar.stateManager = false;
        List list = p.N0(result2);
        Iterator it2 = result2.iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            z2 = item2 instanceof ChallengeProfileItem;
        }
        n.d(pVar.l);
        n.d(pVar.savedList);
        list.add(i, new ChallengeProfileTitleItem(liteDogProfile, result2.size(), i, savedList2));
        pVar.U(list);
        return list;
    }

    /* renamed from: v, reason: from kotlin metadata */
    private static final LiteDogProfile updateDogProfile(PublicDogProfile data) {
        n.f(data, "it");
        return new LiteDogProfile(data.getName(), data.getAvatarUrl(), data.getId());
    }

    private static final LiteDogProfile w(p pVar, Throwable th) {
        n.f(pVar, "this$0");
        n.f(th, "it");
        return pVar.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String A() throws android.content.res.Resources.NotFoundException {
        String string = null;
        if (this.l == null) {
            int i = 0;
        } else {
            string = this.l.getName();
        }
        if (this.l == null || this.l == null) {
            str = "resources.getString(R.string.general_anonymous)";
            n.e(this.authService.getString(2131886675), str);
        }
        return string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Map<String, Set<String>>> B() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean C() {
        return this.connectivityService.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D() {
        return !this.userEntryIds.isEmpty();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean E() {
        String str;
        str = "";
        if (this.l != null) {
            str = this.l.getId();
            if (str != null) {
            }
        }
        return this.challengeLocalRepository.isDogReported(str, this.connectivityService.C());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean F() {
        return this.stateManager;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void Q() {
        u();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        if (this.l != null) {
            String str = this.l.getId();
            if (str != null) {
                if (!this.badgeList.H().m().containsKey(str)) {
                    List list2 = p.I(z(), ChallengeProfileItem.class);
                    ArrayList arrayList = new ArrayList(p.r(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add((ChallengeProfileItem)it.next().getId());
                    }
                    this.challengeLocalRepository.unvoteChallengeEntry(str, this.connectivityService.v(), arrayList);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S(Bundle bundle) {
        n.f(bundle, "arguments");
        this.l = (LiteDogProfile)bundle.getParcelable("liteDogProfile");
        this.savedList = bundle.getStringArrayList("badges");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void U(List<? extends f<?>> list) {
        n.f(list, "<set-?>");
        this.userEntryIds = list;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void V(LiteDogProfile liteDogProfile) {
        n.f(liteDogProfile, "data");
        this.l = liteDogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        if (this.preferenceService != null) {
            return;
        }
        this.preferenceService = this.challengeLocalRepository.writeToDocument(this.connectivityService.v(), null, new app.dogo.com.dogo_android.challenge.profile.l(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        if (this.preferenceService != null) {
            n.d(this.preferenceService);
            this.preferenceService.remove();
            this.preferenceService = null;
            this.resources.clear();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j<List<f<?>>> o() {
        n.d(this.l);
        j continueWith = this.challengeLocalRepository.m(this.l.getId()).continueWith(new app.dogo.com.dogo_android.challenge.profile.i(this, this.currentDogChangeTrigger.b()));
        n.e(continueWith, "firestoreService.fetchAllChallengeEntriesForDog(dogProfile!!.id).continueWith { task: Task<QuerySnapshot> ->\n            val list: MutableList<IFlexible<*>> = ArrayList()\n            for (doc in task.result) {\n                val entryModel = doc.toObject(ChallengeEntryModel::class.java)\n                entryModel.setDocumentId(doc.id)\n                entryModel.setEntryStateData(stateManager.challengeState.getEntryStateDataFor(doc.id))\n                val challengeModel = challengeModels[entryModel.challengeId]\n                if (challengeModel != null && !firestoreService.isEntryReported(entryModel, authService.currentUserId, authService.isUserAdmin)) {\n                    list.add(ChallengeProfileItem(entryModel, challengeModel))\n                }\n            }\n            list\n        }");
        return continueWith;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j<List<f<?>>> s() {
        j jVar;
        final int i2 = 1;
        if (this.currentDogChangeTrigger.b().isEmpty() ^ i2) {
            jVar = o();
        } else {
            jVar = l();
        }
        j[] arr = new j[2];
        j continueWith = m.i(new j[] { jVar, attachUserEntryListener() }).continueWith(new app.dogo.com.dogo_android.challenge.profile.k(this));
        n.e(continueWith, "whenAllComplete(entryTask, fetchTask).continueWith {\n            val entryList = it.result[0].result as List<IFlexible<*>>\n            for (item in entryList) {\n                if (item is ChallengeProfileItem) {\n                    fetchLikeListForEntry(item.id)\n                }\n            }\n            likeList.clear()\n            isFirstLaunch = false\n            val itemList = entryList.toMutableList()\n            var totalLikes = 0\n            entryList.forEach { item ->\n                if (item is ChallengeProfileItem) {\n                    totalLikes += item.entryModel.getVotes()\n                }\n            }\n            itemList.add(0, ChallengeProfileTitleItem(dogProfile!!, entryList.size, totalLikes, badgeList!!))\n            savedList = itemList\n            itemList\n        }");
        return continueWith;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        String str;
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.i.getActiveNetworkType()) {
            this.likeList.setTrainingReminderUserProperties("challenge_profile");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            str = "";
            if (this.l != null) {
                str = this.l.getId();
                if (str != null) {
                }
            }
            a0 observable2 = this.badgeList.getPremiumStateForDog(str).map(app.dogo.com.dogo_android.challenge.profile.j.a).onErrorReturn(new app.dogo.com.dogo_android.challenge.profile.n(this)).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "userRepository.getPublicDogProfile(dogId)\n                    .map {\n                        LiteDogProfile(\n                            name = it.name,\n                            avatar = it.avatarUrl,\n                            id = it.id\n                        )\n                    }.onErrorReturn {\n                        dogProfile\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.challenge.profile.p.a(this), new app.dogo.com.dogo_android.challenge.profile.p.b(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<f<?>> x() {
        int i = 0;
        m2 challengeLocalRepository2;
        boolean z;
        String str;
        boolean z2;
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.userEntryIds.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof ChallengeProfileItem;
        }
        return arrayList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<LiteDogProfile>> y() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<f<?>> z() {
        return this.userEntryIds;
    }

    public static /* synthetic */ void G(p pVar, DogProfile dogProfile) {
        ChallengeProfileDialogViewModel.h(pVar, dogProfile);
    }

    public static /* synthetic */ Void H(p pVar, j jVar) {
        return ChallengeProfileDialogViewModel.X(pVar, jVar);
    }

    public static /* synthetic */ Void I(p pVar, String str, j jVar) {
        return ChallengeProfileDialogViewModel.r(pVar, str, jVar);
    }

    public static /* synthetic */ Map J(p pVar, j jVar) {
        return ChallengeProfileDialogViewModel.m(pVar, jVar);
    }

    public static /* synthetic */ List K(p pVar, Map map, j jVar) {
        return ChallengeProfileDialogViewModel.p(pVar, map, jVar);
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static /* synthetic */ LiteDogProfile fetchLikeListForEntry(PublicDogProfile entryId) {
        return ChallengeProfileDialogViewModel.updateDogProfile(entryId);
    }

    public static /* synthetic */ List M(p pVar, j jVar) {
        return ChallengeProfileDialogViewModel.t(pVar, jVar);
    }

    public static /* synthetic */ void N(p pVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        ChallengeProfileDialogViewModel.j(pVar, querySnapshot, exc);
    }

    public static /* synthetic */ j O(p pVar, j jVar) {
        return ChallengeProfileDialogViewModel.n(pVar, jVar);
    }

    public static /* synthetic */ LiteDogProfile P(p pVar, Throwable th) {
        return ChallengeProfileDialogViewModel.w(pVar, th);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T(int i) {
    }
}
