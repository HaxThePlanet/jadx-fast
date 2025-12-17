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
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
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
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0008\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00192\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0006\u0010$\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/util/QueueableEntryDataFetcher;", "", "challengeId", "", "acceptIntermittentResults", "", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "resultCallback", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;Lio/reactivex/disposables/CompositeDisposable;)V", "dataFetchQueue", "", "results", "", "stopEverything", "addToQueue", "", "voterDocs", "assignNextAction", "likeModel", "emitIntermittentResults", "fetch", "newQueueItems", "fetchDogProfile", "fetchEntryData", "markItemCompleted", "searchForEntryData", "stop", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w {

    private final String a;
    private final boolean b;
    private final m2 c;
    private final u2 d;
    private final s2 e;
    private final u<List<ChallengeEntryVoter>> f;
    private final a g;
    private boolean h;
    private final List<ChallengeEntryVoter> i;
    private final Set<ChallengeEntryVoter> j;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final ChallengeEntryVoter $likeModel;
        final app.dogo.com.dogo_android.util.w this$0;
        a(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2) {
            this.$likeModel = challengeEntryVoter;
            this.this$0 = w2;
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
            this.$likeModel.setDogProfileFetched(true);
            w.a(this.this$0, this.$likeModel);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<PublicDogProfile, w> {

        final ChallengeEntryVoter $likeModel;
        final app.dogo.com.dogo_android.util.w this$0;
        b(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2) {
            this.$likeModel = challengeEntryVoter;
            this.this$0 = w2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(PublicDogProfile publicDogProfile) {
            this.$likeModel.setDogProfile(publicDogProfile.toDogModel());
            this.$likeModel.setDogProfileFetched(true);
            w.a(this.this$0, this.$likeModel);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((PublicDogProfile)object);
            return w.a;
        }
    }
    public w(String string, boolean z2, m2 m23, u2 u24, s2 s25, u<List<ChallengeEntryVoter>> u6, a a7) {
        n.f(string, "challengeId");
        n.f(m23, "firestoreService");
        n.f(u24, "userLocalCacheService");
        n.f(s25, "stateManager");
        n.f(u6, "resultCallback");
        n.f(a7, "disposable");
        super();
        this.a = string;
        this.b = z2;
        this.c = m23;
        this.d = u24;
        this.e = s25;
        this.f = u6;
        this.g = a7;
        ArrayList obj2 = new ArrayList();
        this.i = obj2;
        obj2 = new HashSet();
        this.j = obj2;
    }

    public static final void a(app.dogo.com.dogo_android.util.w w, ChallengeEntryVoter challengeEntryVoter2) {
        w.c(challengeEntryVoter2);
    }

    private final void c(ChallengeEntryVoter challengeEntryVoter) {
        boolean dogProfileFetched;
        if (!this.h) {
            if (challengeEntryVoter.isDogProfileFetched() != null) {
                l(challengeEntryVoter);
            } else {
                if (challengeEntryVoter.getVoterEntryModel() != null) {
                    f(challengeEntryVoter);
                } else {
                    if (!challengeEntryVoter.isEntryModelFetched() && challengeEntryVoter.getVoterEntryId() != null) {
                        if (challengeEntryVoter.getVoterEntryId() != null) {
                            g(challengeEntryVoter);
                        } else {
                            if (!challengeEntryVoter.isEntryModelFetched() && challengeEntryVoter.getDogId() == null) {
                                if (challengeEntryVoter.getDogId() == null) {
                                    m(challengeEntryVoter);
                                } else {
                                    f(challengeEntryVoter);
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
        }
    }

    private final void d() {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.i.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (this.j.contains((ChallengeEntryVoter)next)) {
                break;
            } else {
            }
            arrayList.add(next);
        }
        this.i.removeAll(arrayList);
        this.f.a(arrayList, 0);
    }

    private final void e(List<ChallengeEntryVoter> list) {
        Object next;
        final Iterator obj2 = list.iterator();
        for (ChallengeEntryVoter next : obj2) {
            c(next);
        }
    }

    private final void f(ChallengeEntryVoter challengeEntryVoter) {
        a aVar;
        a0 observeOn;
        app.dogo.com.dogo_android.util.w.a aVar2;
        app.dogo.com.dogo_android.util.w.b bVar;
        Object obj5;
        if (challengeEntryVoter.getDogId() != null) {
            String dogId2 = challengeEntryVoter.getDogId();
            n.d(dogId2);
            observeOn = this.d.y(dogId2).subscribeOn(a.b()).observeOn(a.a());
            n.e(observeOn, "userLocalCacheService.getPublicDogProfile(likeModel.dogId!!)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(AndroidSchedulers.mainThread())");
            aVar2 = new w.a(challengeEntryVoter, this);
            bVar = new w.b(challengeEntryVoter, this);
            this.g.b(a.g(observeOn, aVar2, bVar));
        } else {
            challengeEntryVoter.setDogProfileFetched(true);
            c(challengeEntryVoter);
        }
    }

    private final void g(ChallengeEntryVoter challengeEntryVoter) {
        f forEntryId;
        m2 m2Var;
        app.dogo.com.dogo_android.util.b bVar;
        String voterEntryId = challengeEntryVoter.getVoterEntryId();
        if (voterEntryId != null) {
            bVar = new b(challengeEntryVoter, this);
            this.c.J(f.entry.forEntryId(voterEntryId), bVar);
        } else {
            challengeEntryVoter.setEntryModelFetched(true);
            c(challengeEntryVoter);
        }
    }

    private static final void h(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2, j j3) {
        boolean successful;
        s2.a aVar;
        String str;
        Object obj5;
        n.f(challengeEntryVoter, "$likeModel");
        n.f(w2, "this$0");
        n.f(j3, "documentSnapshots");
        obj5 = j3.getResult();
        n.d((DocumentSnapshot)obj5);
        successful = obj5.toObject(ChallengeEntryModel.class);
        if (j3.isSuccessful() && j3.getResult() != null && (ChallengeEntryModel)successful != null) {
            if (j3.getResult() != null) {
                obj5 = j3.getResult();
                n.d((DocumentSnapshot)obj5);
                successful = obj5.toObject(ChallengeEntryModel.class);
                if ((ChallengeEntryModel)(ChallengeEntryModel)successful != null) {
                    String id = obj5.getId();
                    n.e(id, "doc.id");
                    (ChallengeEntryModel)(ChallengeEntryModel)successful.setDocumentId(id);
                    challengeEntryVoter.setVoterEntryModel(successful);
                    successful.setEntryStateData(s2Var.a.b(obj5.getId()));
                }
            }
        }
        challengeEntryVoter.setEntryModelFetched(true);
        w2.c(challengeEntryVoter);
    }

    public static void i(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2, j j3) {
        w.h(challengeEntryVoter, w2, j3);
    }

    public static void j(app.dogo.com.dogo_android.util.w w, ChallengeEntryVoter challengeEntryVoter2, QuerySnapshot querySnapshot3) {
        w.n(w, challengeEntryVoter2, querySnapshot3);
    }

    public static void k(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2, Exception exception3) {
        w.o(challengeEntryVoter, w2, exception3);
    }

    private final void l(ChallengeEntryVoter challengeEntryVoter) {
        List list;
        List obj3;
        this.j.remove(challengeEntryVoter);
        final int i = 0;
        if (this.j.isEmpty()) {
            this.f.a(this.i, i);
            this.i.clear();
        } else {
            if (this.b && n.b(challengeEntryVoter, this.i.get(i))) {
                if (n.b(challengeEntryVoter, this.i.get(i))) {
                    d();
                }
            }
        }
    }

    private final void m(ChallengeEntryVoter challengeEntryVoter) {
        m2.c cVar = this.c.L(f.allEntries);
        String voterId = challengeEntryVoter.getVoterId();
        n.d(voterId);
        cVar.b(voterId);
        cVar.c(this.a);
        cVar.d(1);
        c cVar2 = new c(this, challengeEntryVoter);
        d dVar = new d(challengeEntryVoter, this);
        cVar.a().get().addOnSuccessListener(cVar2).addOnFailureListener(dVar);
    }

    private static final void n(app.dogo.com.dogo_android.util.w w, ChallengeEntryVoter challengeEntryVoter2, QuerySnapshot querySnapshot3) {
        boolean empty;
        app.dogo.com.dogo_android.util.l.a obj;
        String str;
        Object obj6;
        n.f(w, "this$0");
        n.f(challengeEntryVoter2, "$likeModel");
        n.f(querySnapshot3, "queryDocumentSnapshots");
        final int i = 1;
        if (!querySnapshot3.isEmpty()) {
            int i2 = 0;
            empty = (DocumentSnapshot)querySnapshot3.getDocuments().get(i2).getId();
            n.e(empty, "queryDocumentSnapshots.documents[0].id");
            obj6 = (DocumentSnapshot)querySnapshot3.getDocuments().get(i2).toObject(ChallengeEntryModel.class);
            if ((ChallengeEntryModel)obj6 == null) {
            } else {
                (ChallengeEntryModel)obj6.setEntryStateData(s2Var.a.b(empty));
            }
            if (obj6 != null) {
                obj6.setDocumentId(empty);
                challengeEntryVoter2.setVoterEntryModel(obj6);
            }
            challengeEntryVoter2.setEntryModelFetched(i);
            w.c(challengeEntryVoter2);
        } else {
            challengeEntryVoter2.setEntryModelFetched(i);
            w.c(challengeEntryVoter2);
        }
    }

    private static final void o(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2, Exception exception3) {
        n.f(challengeEntryVoter, "$likeModel");
        n.f(w2, "this$0");
        a.d(exception3);
        challengeEntryVoter.setEntryModelFetched(true);
        w2.c(challengeEntryVoter);
    }

    public final void b(List<ChallengeEntryVoter> list) {
        n.f(list, "voterDocs");
        this.i.addAll(list);
        this.j.addAll(list);
        e(list);
    }

    public final void p() {
        this.h = true;
    }
}
