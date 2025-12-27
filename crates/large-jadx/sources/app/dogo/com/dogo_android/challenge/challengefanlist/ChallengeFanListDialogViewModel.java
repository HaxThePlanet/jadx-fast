package app.dogo.com.dogo_android.d.a;

import android.os.Bundle;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.a.n.d;
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

/* compiled from: ChallengeFanListDialogViewModel.kt */
@Metadata(d1 = "\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001Ba\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010G\u001a\u00020H2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020KJ\u0014\u0010M\u001a\u0008\u0012\u0004\u0012\u00020O0N2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010P\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0(J\u0010\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020KH\u0002J\u0006\u0010R\u001a\u00020HJ\u0008\u0010S\u001a\u00020HH\u0016J\u0018\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0017H\u0002J\u0018\u0010X\u001a\u00020H2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0017H\u0002J\u0010\u0010Y\u001a\u00020/2\u0008\u0010Z\u001a\u0004\u0018\u00010[J\u0012\u0010\\\u001a\u00020H2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u000c\u0010]\u001a\u0008\u0012\u0004\u0012\u00020O0NJ\u0010\u0010^\u001a\u00020H2\u0006\u0010%\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)\u0018\u00010(0'¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u0008\u0018\u00010-R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u00082\u00103R\u001e\u00104\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00103R\u0011\u00105\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u00085\u00103R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020/0'¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010+R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010>\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010A\"\u0004\u0008B\u0010CR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialogViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/StateManager;)V", "cachedLikedEntries", "", "", "", "challengeId", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "currentDogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "getCurrentDogProfile", "()Lapp/dogo/com/dogo_android/model/DogProfileModel;", "dataFetcher", "Lapp/dogo/com/dogo_android/util/QueueableEntryDataFetcher;", "entryId", "entryPasser", "Landroidx/lifecycle/MutableLiveData;", "", "Leu/davidea/flexibleadapter/items/IFlexible;", "getEntryPasser", "()Landroidx/lifecycle/MutableLiveData;", "fanPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "fetchingData", "", "firstLaunch", "hasReachedEnd", "isChallengeExpired", "()Z", "isChallengeModelFetched", "isUserSignedIn", "lastSavedPosition", "", "getLastSavedPosition", "()I", "setLastSavedPosition", "(I)V", "listEndNotifier", "getListEndNotifier", "savedList", "Ljava/util/ArrayList;", "getSavedList", "()Ljava/util/ArrayList;", "setSavedList", "(Ljava/util/ArrayList;)V", "userEntryId", "userEntryListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "attachUserEntryListener", "", "computeSimpleLikeFor", "itemModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "computeToggleLikeFor", "fetchLikedList", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "getCachedList", "isUserEntriesAuthor", "loadMoreFans", "onDestroy", "onUnvote", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "onUpvote", "setArguments", "bundle", "Landroid/os/Bundle;", "setupFanDataFetcher", "setupFanListData", "setupFanPager", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ChallengeFanListDialogViewModel extends r {

    /* renamed from: A, reason: from kotlin metadata */
    private final a1 authService;
    /* renamed from: B, reason: from kotlin metadata */
    private final h2 cachedLikedEntries;
    /* renamed from: C, reason: from kotlin metadata */
    private final o3 challengeId;
    /* renamed from: D, reason: from kotlin metadata */
    private final u2 challengeLocalRepository;
    private final p2 E;
    private final q2 F;
    /* renamed from: G, reason: from kotlin metadata */
    private final s2 dataFetcher;
    /* renamed from: H, reason: from kotlin metadata */
    private ChallengeModel entryId;
    private final Map<String, Object> I;
    /* renamed from: J, reason: from kotlin metadata */
    private final x<List<h.a.b.h.f<?>>> fanPager;
    /* renamed from: K, reason: from kotlin metadata */
    private final x<Boolean> fetchingData;
    /* renamed from: L, reason: from kotlin metadata */
    private w firestoreService;
    /* renamed from: M, reason: from kotlin metadata */
    private m2.b firstLaunch;
    /* renamed from: N, reason: from kotlin metadata */
    private String hasReachedEnd;
    private String O;
    private String P;
    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isUserSignedIn;
    private boolean R;
    private int S;
    /* renamed from: T, reason: from kotlin metadata */
    private ArrayList<h.a.b.h.f<?>> preferenceService;
    /* renamed from: U, reason: from kotlin metadata */
    private boolean rateItService;
    private boolean V;
    /* renamed from: W, reason: from kotlin metadata */
    private ListenerRegistration stateManager;
    /* renamed from: z, reason: from kotlin metadata */
    private final m2 tracker;
    public /* synthetic */ m(m2 m2Var, a1 a1Var, h2 h2Var, o3 o3Var, u2 u2Var, v2 v2Var, p2 p2Var, q2 q2Var, s2 s2Var, int i, g gVar) {
        s2 s2Var92;
        m2 m2Var2;
        a1 a1Var22;
        h2 h2Var32;
        o3 o3Var42;
        u2 u2Var52;
        v2 v2Var62;
        p2 p2Var72;
        q2 q2Var82;
        int i102 = i;
        if (i102 & 1 != 0) {
            m2Var2 = App.INSTANCE.j();
        } else {
            m2Var2 = m2Var;
        }
        if (i102 & 2 != 0) {
            a1Var22 = App.INSTANCE.f();
        } else {
            a1Var22 = a1Var;
        }
        if (i102 & 4 != 0) {
            h2Var32 = App.INSTANCE.c();
        } else {
            h2Var32 = h2Var;
        }
        if (i102 & 8 != 0) {
            o3Var42 = App.INSTANCE.r();
        } else {
            o3Var42 = o3Var;
        }
        if (i102 & 16 != 0) {
            u2Var52 = App.INSTANCE.h();
        } else {
            u2Var52 = u2Var;
        }
        if (i102 & 32 != 0) {
            v2Var62 = App.INSTANCE.t();
        } else {
            v2Var62 = v2Var;
        }
        if (i102 & 64 != 0) {
            p2Var72 = App.INSTANCE.l();
        } else {
            p2Var72 = p2Var;
        }
        if (i102 & 128 != 0) {
            q2Var82 = App.INSTANCE.m();
        } else {
            q2Var82 = q2Var;
        }
        if (i102 & 256 != 0) {
            s2Var92 = App.INSTANCE.o();
        } else {
            s2Var92 = s2Var;
        }
        this(m2Var2, a1Var22, h2Var32, o3Var42, u2Var52, v2Var62, p2Var72, q2Var82, s2Var92);
    }

    /* renamed from: B, reason: from kotlin metadata */
    private static final Void onUnvote(m entryModel, j photoId) {
        n.f(entryModel, "this$0");
        n.f(photoId, "task");
        final Object result = photoId.getResult();
        n.e(result, "task.result");
        entryModel.dataFetcher.a.c().setEntryVoteCount(result, false);
        return null;
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final DogProfileModel getCachedList() {
        return this.challengeLocalRepository.A().g().toModel(this.cachedLikedEntries.v());
    }

    /* renamed from: K, reason: from kotlin metadata */
    private final boolean attachUserEntryListener(ChallengeEntryVoter challengeModel) {
        return n.b(challengeModel.getVoterId(), this.cachedLikedEntries.v());
    }

    private static final void S(m mVar, QuerySnapshot querySnapshot) {
        boolean hasNext;
        String str2;
        Class cls;
        str = "this$0";
        n.f(mVar, str);
        if (querySnapshot != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = querySnapshot.getDocuments().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                str2 = item.getId();
                n.e(str2, "doc.id");
                cls = ChallengeEntryVoter.class;
                Object object = item.toObject(cls);
                n.d(object);
                object.setDocumentId(str2);
                arrayList.add(object);
            }
            n.d(mVar.firstLaunch);
            if (mVar.firstLaunch.hasReachedEnd() && !mVar.isUserSignedIn) {
                mVar.isUserSignedIn = true;
                mVar.H().setValue(Boolean.TRUE);
            }
            n.d(mVar.firestoreService);
            mVar.firestoreService.searchForEntryData(arrayList);
            boolean z = false;
            mVar.R = z;
            mVar.i();
        }
    }

    private final void T(ChallengeEntryModel challengeEntryModel, String str) {
        n.d(this.registry);
        this.challengeId.logEvent(E_Challenges.c.c(new EP_EntryId(), challengeEntryModel.getDocumentId(), new EP_ChallengeId(), challengeEntryModel.getChallengeId(), new EP_ViewSource(), this.registry.getTag()));
        this.tracker.writeToDocument(this.cachedLikedEntries.v(), challengeEntryModel, str);
        challengeEntryModel.setLikeStateForImage(str, false);
        challengeEntryModel.incrementVotes(-1);
    }

    private final void U(ChallengeEntryModel challengeEntryModel, String str) {
        n.d(this.registry);
        this.challengeId.logEvent(E_Challenges.b.c(new EP_EntryId(), challengeEntryModel.getDocumentId(), new EP_ChallengeId(), challengeEntryModel.getChallengeId(), new EP_ViewSource(), this.registry.getTag()));
        this.tracker.upvoteChallengeEntry(this.cachedLikedEntries.v(), challengeEntryModel, this.P, getCachedList().getId(), this.E.h(), str);
        boolean z = true;
        challengeEntryModel.setLikeStateForImage(str, z);
        challengeEntryModel.incrementVotes(z);
        this.F.l();
        this.F.m();
    }

    /* renamed from: X, reason: from kotlin metadata */
    private final void computeSimpleLikeFor(ChallengeModel itemModel) {
        n.d(itemModel);
        QueueableEntryDataFetcher queueableEntryDataFetcher = new QueueableEntryDataFetcher(itemModel.getId(), true, this.tracker, this.challengeLocalRepository, this.dataFetcher, new app.dogo.com.dogo_android.challenge.challengefanlist.i(this, itemModel), getDisposable());
        this.firestoreService = queueableEntryDataFetcher;
    }

    private static final boolean Y(m mVar, ChallengeModel challengeModel, List list, int i) {
        boolean hasNext = false;
        boolean dogReported;
        String dogId;
        m2 tracker2;
        n.f(mVar, "this$0");
        n.f(list, "itemDataList");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i3 ^ (mVar.tracker.isDogReported(dogId, mVar.cachedLikedEntries.C()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList = it2.next();
            ChallengeEntryModel voterEntryModel = arrayList.getVoterEntryModel();
        }
        mVar.F().setValue(arrayList2);
        mVar.I().addAll(arrayList2);
        return true;
    }

    private static final j a0(m mVar, j jVar) {
        n.f(mVar, "this$0");
        n.f(jVar, "task");
        mVar.entryId = (ChallengeModel)jVar.getResult();
        mVar.computeSimpleLikeFor(mVar.D());
        ChallengeModel challengeModel2 = mVar.D();
        n.d(challengeModel2);
        mVar.fetchLikedList(challengeModel2);
        ChallengeModel challengeModel3 = mVar.D();
        n.d(challengeModel3);
        return mVar.isUserEntriesAuthor(challengeModel3);
    }

    private static final void b0(m mVar, j jVar) {
        n.f(mVar, "this$0");
        mVar.R = false;
        mVar.V = true;
    }

    /* renamed from: c0, reason: from kotlin metadata */
    private final void computeToggleLikeFor(String itemModel) {
        m2.c cVar = this.tracker.L(FirestorePath.entryFans.forEntryId(itemModel));
        cVar.orderBy("date", Query.Direction.DESCENDING);
        this.firstLaunch = this.tracker.reportChallengeEntry(cVar.build(), 5, 0);
    }

    /* renamed from: w, reason: from kotlin metadata */
    private final void fetchLikedList(ChallengeModel challengeModel) {
        if (this.stateManager != null) {
            return;
        }
        m2.c cVar = this.tracker.L(FirestorePath.allEntries);
        cVar.forAuthor(this.cachedLikedEntries.v());
        cVar.forChallenge(challengeModel.getId());
        cVar.limitTo(1L);
        this.stateManager = cVar.build().addSnapshotListener(new app.dogo.com.dogo_android.challenge.challengefanlist.e(this));
    }

    private static final void x(m mVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        boolean empty;
        n.f(mVar, "this$0");
        int i = 0;
        if (querySnapshot == null || querySnapshot.isEmpty()) {
            documentId = "queryDocumentSnapshots is null";
            a.e(exc, documentId, new Object[i]);
        } else {
            Object object = (DocumentSnapshot)querySnapshot.getDocuments().get(i).toObject(ChallengeEntryModel.class);
            n.d(object);
            String id = (DocumentSnapshot)querySnapshot.getDocuments().get(i).getId();
            n.e(id, "queryDocumentSnapshots.documents[0].id");
            object.setDocumentId(id);
            mVar.P = object.getDocumentId();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: A, reason: from kotlin metadata */
    public final j<Void> isUserEntriesAuthor(ChallengeModel itemModel) {
        n.f(itemModel, "challengeModel");
        j continueWith = this.tracker.fetchAllChallenges(this.cachedLikedEntries.v(), itemModel.getId(), false).continueWith(new app.dogo.com.dogo_android.challenge.challengefanlist.h(this));
        n.e(continueWith, "firestoreService.fetchUserLikeListForChallenge(authService.currentUserId, challengeModel.id, false).continueWith { task: Task<Map<String, Map<String, Boolean>>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(task.result, false)\n            null\n        }");
        return continueWith;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final List<h.a.b.h.f<?>> C() {
        String dogId;
        m2 tracker2;
        boolean commentReported = true;
        boolean z;
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.preferenceService.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            int i = 1;
        }
        return arrayList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel D() {
        return this.entryId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<List<h.a.b.h.f<?>>> F() {
        return this.fanPager;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int G() {
        return this.S;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<Boolean> H() {
        return this.fetchingData;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ArrayList<h.a.b.h.f<?>> I() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J() {
        return this.V;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void R() {
        if (!this.R) {
            this.R = true;
            n.d(this.firstLaunch);
            this.firstLaunch.fetchNextPage(new app.dogo.com.dogo_android.challenge.challengefanlist.g(this));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: V, reason: from kotlin metadata */
    public final boolean setArguments(Bundle bundle) {
        boolean z2 = false;
        if (bundle != null) {
            boolean z = true;
            if (this.rateItService == null) {
                this.fanPager.setValue(null);
                return true;
            }
            this.rateItService = z2;
            this.hasReachedEnd = bundle.getString("id");
            String string = bundle.getString("challenge_id");
            this.O = string;
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: W, reason: from kotlin metadata */
    public final void setupFanDataFetcher(int challengeModel) {
        this.S = challengeModel;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final j<Void> Z() {
        j userEntriesAuthor;
        n.d(this.hasReachedEnd);
        computeToggleLikeFor(this.hasReachedEnd);
        if (!this.V || this.entryId == null) {
            n.d(this.O);
            str = "firestoreService.fetchChallengeModel(challengeId!!, preferenceService.selectedLocale).continueWithTask { task: Task<ChallengeModel?> ->\n                challengeModel = task.result\n                setupFanDataFetcher(challengeModel)\n                attachUserEntryListener(challengeModel!!)\n                fetchLikedList(challengeModel!!)\n            }";
            n.e(this.tracker.s(this.O, this.E.W()).continueWithTask(new app.dogo.com.dogo_android.challenge.challengefanlist.j(this)), str);
        } else {
            n.d(this.entryId);
            userEntriesAuthor = isUserEntriesAuthor(this.entryId);
            computeSimpleLikeFor(this.entryId);
            n.d(this.entryId);
            fetchLikedList(this.entryId);
        }
        j onCompleteListener = userEntriesAuthor.addOnCompleteListener(new app.dogo.com.dogo_android.challenge.challengefanlist.f(this));
        n.e(onCompleteListener, "dataFetchTask.addOnCompleteListener {\n            fetchingData = false\n            isChallengeModelFetched = true\n        }");
        return onCompleteListener;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n() {
        super.n();
        if (this.stateManager != null) {
            n.d(this.stateManager);
            this.stateManager.remove();
        }
        if (this.firestoreService != null) {
            n.d(this.firestoreService);
            this.firestoreService.p();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    /* renamed from: y, reason: from kotlin metadata */
    public final void setupFanPager(ChallengeEntryVoter entryId) {
        n.f(entryId, "itemModel");
        ChallengeEntryModel voterEntryModel = entryId.getVoterEntryModel();
        if (attachUserEntryListener(entryId)) {
            return;
        }
        if (voterEntryModel == null) {
            return;
        }
        final String selectedPhotoId = entryId.getSelectedPhotoId();
        if (voterEntryModel.getLikeStateForImage(selectedPhotoId)) {
            return;
        }
        if (selectedPhotoId != null) {
            U(voterEntryModel, selectedPhotoId);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void z(ChallengeEntryVoter challengeEntryVoter) {
        n.f(challengeEntryVoter, "itemModel");
        ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
        if (attachUserEntryListener(challengeEntryVoter)) {
            return;
        }
        if (voterEntryModel == null) {
            return;
        }
        final String selectedPhotoId = challengeEntryVoter.getSelectedPhotoId();
        if (selectedPhotoId != null && voterEntryModel.getLikeStateForImage(selectedPhotoId)) {
            T(voterEntryModel, selectedPhotoId);
        }
    }

    public m(m2 m2Var, a1 a1Var, h2 h2Var, o3 o3Var, u2 u2Var, v2 v2Var, p2 p2Var, q2 q2Var, s2 s2Var) {
        n.f(m2Var, "firestoreService");
        n.f(a1Var, "challengeLocalRepository");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(u2Var, "userLocalCacheService");
        n.f(v2Var, "utilities");
        n.f(p2Var, "preferenceService");
        n.f(q2Var, "rateItService");
        n.f(s2Var, "stateManager");
        super();
        this.tracker = m2Var;
        this.authService = a1Var;
        this.cachedLikedEntries = h2Var;
        this.challengeId = o3Var;
        this.challengeLocalRepository = u2Var;
        this.E = p2Var;
        this.F = q2Var;
        this.dataFetcher = s2Var;
        this.I = new HashMap();
        this.fanPager = new x();
        this.fetchingData = new x();
        boolean z = true;
        this.R = z;
        this.preferenceService = new ArrayList();
        this.rateItService = z;
    }

    public m() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ void L(m mVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        ChallengeFanListDialogViewModel.x(mVar, querySnapshot, exc);
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static /* synthetic */ void onUpvote(m entryModel, j photoId) {
        ChallengeFanListDialogViewModel.b0(entryModel, photoId);
    }

    public static /* synthetic */ void N(m mVar, QuerySnapshot querySnapshot) {
        ChallengeFanListDialogViewModel.S(mVar, querySnapshot);
    }

    public static /* synthetic */ Void O(m mVar, j jVar) {
        return ChallengeFanListDialogViewModel.onUnvote(mVar, jVar);
    }

    public static /* synthetic */ boolean P(m mVar, ChallengeModel challengeModel, List list, int i) {
        return ChallengeFanListDialogViewModel.Y(mVar, challengeModel, list, i);
    }

    public static /* synthetic */ j Q(m mVar, j jVar) {
        return ChallengeFanListDialogViewModel.a0(mVar, jVar);
    }
}
