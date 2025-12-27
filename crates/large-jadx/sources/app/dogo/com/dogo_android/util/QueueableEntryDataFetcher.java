package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.m2.c;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.util.n0.u;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import i.b.a0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: QueueableEntryDataFetcher.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0008\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00192\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0006\u0010$\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/util/QueueableEntryDataFetcher;", "", "challengeId", "", "acceptIntermittentResults", "", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "resultCallback", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;Lio/reactivex/disposables/CompositeDisposable;)V", "dataFetchQueue", "", "results", "", "stopEverything", "addToQueue", "", "voterDocs", "assignNextAction", "likeModel", "emitIntermittentResults", "fetch", "newQueueItems", "fetchDogProfile", "fetchEntryData", "markItemCompleted", "searchForEntryData", "stop", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class QueueableEntryDataFetcher {

    /* renamed from: a, reason: from kotlin metadata */
    private final String acceptIntermittentResults;
    /* renamed from: b, reason: from kotlin metadata */
    private final boolean challengeId;
    /* renamed from: c, reason: from kotlin metadata */
    private final m2 dataFetchQueue;
    /* renamed from: d, reason: from kotlin metadata */
    private final u2 disposable;
    /* renamed from: e, reason: from kotlin metadata */
    private final s2 firestoreService;
    /* renamed from: f, reason: from kotlin metadata */
    private final u<List<ChallengeEntryVoter>> resultCallback;
    /* renamed from: g, reason: from kotlin metadata */
    private final i.b.j0.a results;
    /* renamed from: h, reason: from kotlin metadata */
    private boolean stateManager;
    /* renamed from: i, reason: from kotlin metadata */
    private final List<ChallengeEntryVoter> stopEverything = new ArrayList<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final Set<ChallengeEntryVoter> userLocalCacheService = new HashSet<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final /* synthetic */ ChallengeEntryVoter $likeModel;
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            this.$likeModel.setDogProfileFetched(true);
            w.this.addToQueue(this.$likeModel);
        }

        a(ChallengeEntryVoter challengeEntryVoter, w wVar) {
            this.$likeModel = challengeEntryVoter;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<PublicDogProfile, w> {

        final /* synthetic */ ChallengeEntryVoter $likeModel;
        @Override // kotlin.d0.d.p
        public final void a(PublicDogProfile publicDogProfile) {
            this.$likeModel.setDogProfile(publicDogProfile.toDogModel());
            this.$likeModel.setDogProfileFetched(true);
            w.this.addToQueue(this.$likeModel);
        }

        b(ChallengeEntryVoter challengeEntryVoter, w wVar) {
            this.$likeModel = challengeEntryVoter;
            super(1);
        }
    }
    public w(String str, boolean z, m2 m2Var, u2 u2Var, s2 s2Var, u<List<ChallengeEntryVoter>> uVar, i.b.j0.a aVar) {
        n.f(str, "challengeId");
        n.f(m2Var, "firestoreService");
        n.f(u2Var, "userLocalCacheService");
        n.f(s2Var, "stateManager");
        n.f(uVar, "resultCallback");
        n.f(aVar, "disposable");
        super();
        this.acceptIntermittentResults = str;
        this.challengeId = z;
        this.dataFetchQueue = m2Var;
        this.disposable = u2Var;
        this.firestoreService = s2Var;
        this.resultCallback = uVar;
        this.results = aVar;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
    }

    public static final /* synthetic */ void a(w wVar, ChallengeEntryVoter challengeEntryVoter) {
        wVar.addToQueue(challengeEntryVoter);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void addToQueue(ChallengeEntryVoter voterDocs) {
        boolean dogProfileFetched;
        if (this.stateManager == null && voterDocs.isDogProfileFetched()) {
            fetchEntryData(voterDocs);
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void emitIntermittentResults() {
        boolean contains;
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.stopEverything.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (this.userLocalCacheService.contains(item)) {
                break;
            }
        }
        this.stopEverything.removeAll(arrayList);
        this.resultCallback.a(arrayList, 0);
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final void assignNextAction(List<ChallengeEntryVoter> likeModel) {
        final Iterator it = likeModel.iterator();
        while (it.hasNext()) {
            addToQueue((ChallengeEntryVoter)it.next());
        }
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final void fetch(ChallengeEntryVoter newQueueItems) {
        if (newQueueItems.getDogId() != null) {
            String dogId2 = newQueueItems.getDogId();
            n.d(dogId2);
            a0 observable = this.disposable.y(dogId2).subscribeOn(a.b()).observeOn(a.a());
            n.e(observable, "userLocalCacheService.getPublicDogProfile(likeModel.dogId!!)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(AndroidSchedulers.mainThread())");
            this.results.b(a.g(observable, new w.a(newQueueItems, this), new w.b(newQueueItems, this)));
        } else {
            newQueueItems.setDogProfileFetched(true);
            addToQueue(newQueueItems);
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final void fetchDogProfile(ChallengeEntryVoter likeModel) {
        String voterEntryId = likeModel.getVoterEntryId();
        if (voterEntryId != null) {
            this.dataFetchQueue.J(FirestorePath.entry.forEntryId(voterEntryId), new b(likeModel, this));
        } else {
            likeModel.setEntryModelFetched(true);
            addToQueue(likeModel);
        }
    }

    private static final void h(ChallengeEntryVoter challengeEntryVoter, w wVar, j jVar) {
        n.f(challengeEntryVoter, "$likeModel");
        n.f(wVar, "this$0");
        n.f(jVar, "documentSnapshots");
        if (jVar.isSuccessful() && jVar.getResult() != null) {
            Object result = jVar.getResult();
            n.d(result);
            Object object = result.toObject(ChallengeEntryModel.class);
            if (object != null) {
                String id = result.getId();
                str = "doc.id";
                n.e(id, str);
                object.setDocumentId(id);
                challengeEntryVoter.setVoterEntryModel(object);
                object.setEntryStateData(wVar.firestoreService.a.b(result.getId()));
            }
        }
        challengeEntryVoter.setEntryModelFetched(true);
        wVar.addToQueue(challengeEntryVoter);
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final void fetchEntryData(ChallengeEntryVoter likeModel) {
        this.userLocalCacheService.remove(likeModel);
        final int i = 0;
        if (this.userLocalCacheService.isEmpty()) {
            this.resultCallback.a(this.stopEverything, i);
            this.stopEverything.clear();
        } else {
            if (this.challengeId) {
                if (n.b(likeModel, this.stopEverything.get(i))) {
                    emitIntermittentResults();
                }
            }
        }
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final void markItemCompleted(ChallengeEntryVoter likeModel) {
        m2.c cVar = this.dataFetchQueue.L(FirestorePath.allEntries);
        String voterId = likeModel.getVoterId();
        n.d(voterId);
        cVar.b(voterId);
        cVar.c(this.acceptIntermittentResults);
        cVar.d(1L);
        cVar.a().get().addOnSuccessListener(new c(this, likeModel)).addOnFailureListener(new d(likeModel, this));
    }

    private static final void n(w wVar, ChallengeEntryVoter challengeEntryVoter, QuerySnapshot querySnapshot) {
        app.dogo.com.dogo_android.util.l.a obj;
        n.f(wVar, "this$0");
        n.f(challengeEntryVoter, "$likeModel");
        n.f(querySnapshot, "queryDocumentSnapshots");
        final boolean z = true;
        if (!querySnapshot.isEmpty()) {
            int i = 0;
            String id = (DocumentSnapshot)querySnapshot.getDocuments().get(i).getId();
            str = "queryDocumentSnapshots.documents[0].id";
            n.e(id, str);
            obj = ChallengeEntryModel.class;
            Object object = (DocumentSnapshot)querySnapshot.getDocuments().get(i).toObject(obj);
            if (object != null) {
                object.setEntryStateData(wVar.firestoreService.a.b(id));
            }
            if (object != null) {
                object.setDocumentId(id);
                challengeEntryVoter.setVoterEntryModel(object);
            }
            challengeEntryVoter.setEntryModelFetched(z);
            wVar.addToQueue(challengeEntryVoter);
        } else {
            challengeEntryVoter.setEntryModelFetched(z);
            wVar.addToQueue(challengeEntryVoter);
        }
    }

    private static final void o(ChallengeEntryVoter challengeEntryVoter, w wVar, Exception exc) {
        n.f(challengeEntryVoter, "$likeModel");
        n.f(wVar, "this$0");
        a.d(exc);
        challengeEntryVoter.setEntryModelFetched(true);
        wVar.addToQueue(challengeEntryVoter);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void searchForEntryData(List<ChallengeEntryVoter> likeModel) {
        n.f(likeModel, "voterDocs");
        this.stopEverything.addAll(likeModel);
        this.userLocalCacheService.addAll(likeModel);
        assignNextAction(likeModel);
    }

    public final void p() {
        this.stateManager = true;
    }

    public static /* synthetic */ void i(ChallengeEntryVoter challengeEntryVoter, w wVar, j jVar) {
        QueueableEntryDataFetcher.h(challengeEntryVoter, wVar, jVar);
    }

    public static /* synthetic */ void j(w wVar, ChallengeEntryVoter challengeEntryVoter, QuerySnapshot querySnapshot) {
        QueueableEntryDataFetcher.n(wVar, challengeEntryVoter, querySnapshot);
    }

    public static /* synthetic */ void k(ChallengeEntryVoter challengeEntryVoter, w wVar, Exception exc) {
        QueueableEntryDataFetcher.o(challengeEntryVoter, wVar, exc);
    }
}
