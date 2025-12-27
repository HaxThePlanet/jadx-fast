package app.dogo.com.dogo_android.a0.g.f;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.appcompat.app.c.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeFilterItem;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable.LabelState;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.InviteFriendsBannerItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.m2.b;
import app.dogo.com.dogo_android.service.m2.c;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.n2.a;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g0.b.b;
import app.dogo.com.dogo_android.util.h0.l1;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.w2;
import com.google.android.gms.tasks.g;
import com.google.firebase.Timestamp;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: ChallengeHomeViewModel.java */
/* loaded from: classes.dex */
public class g0 extends r {

    private SponsorBannerItem A;
    private x<List<h.a.b.h.f>> A0;
    private InviteFriendsBannerItem B;
    private x<Boolean> B0;
    private BecomePremiumBannerItem C;
    private long C0;
    private final m2 D;
    private boolean D0;
    private final u2 E;
    private boolean E0;
    private final a1 F;
    private ChallengeEntryModel F0;
    private final h2 G;
    private CountDownTimer G0;
    private final t2 H;
    private String H0;
    private final p2 I;
    private boolean I0;
    private final j2 J;
    private boolean J0;
    private final q2 K;
    private boolean K0;
    private final app.dogo.com.dogo_android.service.v2 L;
    private Calendar L0;
    private final s2 M;
    private final k2 N;
    private final Resources O;
    private final app.dogo.com.dogo_android.service.r2 P;
    private final o3 Q;
    private final n3 R;
    private i.b.j0.a S;
    private m2.b T;
    private m2.b U;
    private app.dogo.com.dogo_android.util.g0.b V;
    private boolean W;
    private String X;
    private app.dogo.com.dogo_android.util.e0.y<Boolean> Y;
    private x<Boolean> Z;
    private x<Boolean> a0;
    private x<Integer> b0;
    private x<Boolean> c0;
    private v<Boolean> d0;
    private x<List<h.a.b.h.f>> e0;
    private x<List<h.a.b.h.f>> f0;
    private x<List<h.a.b.h.f>> g0;
    private x<Boolean> h0;
    private g0.c i0;
    private ChallengeModel j0;
    private Map<String, Object> k0;
    private Map<String, EntryUserPhotoItem> l0;
    private boolean m0;
    private Set<String> n0;
    private ListenerRegistration o0;
    private ListenerRegistration p0;
    private ListenerRegistration q0;
    private ListenerRegistration r0;
    private LiteDogProfile s0;
    private boolean t0;
    private ChallengeModel u0;
    private EntryTitleItem v0;
    private ChallengeTitleItem w0;
    private EntryFilterItem x0;
    private boolean y0;
    private EntrySortingTabItem z;
    private boolean z0;

    class a extends CountDownTimer {

        final /* synthetic */ g0 a;
        a(long j, long j2) {
            this.a = g0Var;
            super(j, r3, j2, r5);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.a.Z.setValue(Boolean.TRUE);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    static class b {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.values().length];
            app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.b.a = iArr;
            try {
                iArr[app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Likes.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.b.a[app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum c {

        Country,
        Date,
        Days_7,
        Hour_24,
        Likes,
        User;
    }
    public g0(m2 m2Var, a1 a1Var, h2 h2Var, u2 u2Var, t2 t2Var, p2 p2Var, o3 o3Var, j2 j2Var, q2 q2Var, app.dogo.com.dogo_android.service.v2 v2Var, s2 s2Var, app.dogo.com.dogo_android.service.r2 r2Var, k2 k2Var, Resources resources, n3 n3Var) {
        final app.dogo.com.dogo_android.a0.g.f.g0 m2Var3 = this;
        s2 s2Var112 = s2Var;
        Resources resources142 = resources;
        super();
        m2Var3.S = new a();
        m2Var3.Y = LoadResult_Loading.a;
        m2Var3.Z = new x();
        m2Var3.a0 = new x();
        m2Var3.b0 = new x();
        m2Var3.c0 = new x();
        m2Var3.d0 = new v();
        m2Var3.e0 = new x();
        m2Var3.f0 = new x();
        m2Var3.g0 = new x();
        m2Var3.h0 = new x();
        m2Var3.i0 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date;
        m2Var3.k0 = new HashMap();
        m2Var3.l0 = new HashMap();
        m2Var3.m0 = false;
        m2Var3.n0 = new HashSet();
        m2Var3.A0 = new x();
        m2Var3.B0 = new x();
        m2Var3.H0 = null;
        m2Var3.D = m2Var;
        m2Var3.G = h2Var;
        m2Var3.F = a1Var;
        m2Var3.E = u2Var;
        m2Var3.H = t2Var;
        m2Var3.I = p2Var;
        m2Var3.J = j2Var;
        m2Var3.K = q2Var;
        m2Var3.Q = o3Var;
        m2Var3.L = v2Var;
        m2Var3.P = r2Var;
        m2Var3.M = s2Var112;
        m2Var3.N = k2Var;
        m2Var3.O = resources142;
        m2Var3.R = n3Var;
        app.dogo.com.dogo_android.util.g0.b bVar2 = new b(resources142);
        m2Var3.V = bVar2;
        bVar2.o();
        m2Var3.d0.b(s2Var112.a.d(), new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.a0(this));
        C2();
    }

    private /* synthetic */ void B1(g0.c cVar, String str, Set set, QuerySnapshot querySnapshot) {
        Object object;
        boolean commentReported;
        String documentId;
        boolean z;
        boolean hasNext;
        if (this.i0 == cVar) {
            if (str.equals(this.j0.getId())) {
                if (set.equals(this.x0.getFilters().keySet()) && querySnapshot != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = querySnapshot.getDocuments().iterator();
                    app.dogo.com.dogo_android.a0.g.f.g0.c cVar2 = 1;
                    while (it.hasNext()) {
                        Object item = it.next();
                        object = item.toObject(ChallengeEntryModel.class);
                        object.setDocumentId(item.getId());
                    }
                    if (this.T.hasReachedEnd() && !this.N0()) {
                        EntrySortingTabItem entrySortingTabItem = null;
                        if (this.n0.isEmpty()) {
                            arrayList.add(new ChallengeFeedEndItem(entrySortingTabItem, ChallengeFeedEndObservable.LabelState.ENTRIES_LIST_EMPTY));
                        }
                        if (!this.n0.isEmpty() && this.x0.isFilterLisEmpty()) {
                            arrayList.add(new ChallengeFeedEndItem(entrySortingTabItem, ChallengeFeedEndObservable.LabelState.FEED_END));
                        }
                        if (!this.n0.isEmpty() && !this.x0.isFilterLisEmpty()) {
                            arrayList.add(new ChallengeFeedEndItem(entrySortingTabItem, ChallengeFeedEndObservable.LabelState.CLEAR_FILTER));
                        }
                        this.B0.setValue(Boolean.TRUE);
                        this.z0 = true;
                    }
                    this.e0.setValue(arrayList);
                    i();
                    if (arrayList.isEmpty() && !querySnapshot.isEmpty()) {
                        X1();
                    }
                }
            }
        }
    }

    private /* synthetic */ void D1(QuerySnapshot querySnapshot) {
        Object object;
        boolean commentReported;
        String str;
        boolean z;
        if (querySnapshot != null) {
            int i = 10;
            if (querySnapshot.size() < 10) {
                ArrayList arrayList = new ArrayList();
                Iterator it = querySnapshot.getDocuments().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    object = item.toObject(ChallengeEntryModel.class);
                    object.setDocumentId(item.getId());
                    object.setEntryStateData(this.M.a.b(item.getId()));
                }
                this.f0.setValue(arrayList);
            } else {
                callLoadingDialog();
                boolean z2 = true;
                J(z2);
                l2();
                X1();
            }
        }
    }

    private void D2(boolean z) {
        this.z.setChallengeExpired(z ^ 1);
    }

    private boolean E(app.dogo.com.dogo_android.util.e0.a0 a0Var, boolean z) {
        final int i3 = 27;
        final boolean z5 = false;
        if (!this.J.getActiveNetworkType()) {
            notifyChange(i3);
            showToast(2131886953);
            return false;
        }
        if (G()) {
            return false;
        }
        final int i4 = 2131886693;
        if (this.j0 == null) {
            showToast(i4);
            return false;
        }
        if (this.j0.isHasEnded(this.L)) {
            showToast(2131886293);
            this.Z.setValue(Boolean.TRUE);
            return false;
        }
        if (!c1()) {
            this.Z.setValue(Boolean.TRUE);
            showToast(2131886305);
            return false;
        }
        if (!this.E.B("challenge_terms_v1")) {
            this.I2(a0Var, this.j0, true, false, true);
            return false;
        }
        if (this.E.A().j() == 0) {
            a0Var.w0(this.E.A().n(), 11103);
            showToast(2131886415);
            return false;
        }
        if (this.V.t() && !Boolean.TRUE) {
            return false;
        }
        if (!d1()) {
            showToast(i4);
            return false;
        }
        if (L0() != null) {
            if (U(this.j0) <= L0().getImageCount()) {
                showToast(i4);
                return false;
            }
        }
        notifyChange(i3);
        return true;
    }

    private void E2(boolean z) {
        this.z.setChallengWelcome(z);
    }

    private /* synthetic */ void F1(String str, String str2, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        Map map;
        String str3;
        EntryUserPhotoItem entryUserPhotoItem;
        String str5;
        boolean z;
        String object;
        if (str.equals(this.G.v())) {
            if (str2.equals(this.j0.getId()) && querySnapshot != null) {
                Iterator it = querySnapshot.getDocuments().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    object = item.toObject(ChallengeEntryModel.class);
                    object.setDocumentId(item.getId());
                    object.setEntryStateData(this.M.a.b(item.getId()));
                    if (this.l0.containsKey(item.getId()) && object.getIsBeingDeleted()) {
                    }
                }
                e2();
                P0(this.l0.isEmpty());
                f2();
                u2();
            }
        }
    }

    private /* synthetic */ void H1(com.google.android.gms.tasks.j jVar) {
        w2();
    }

    private EventListener<QuerySnapshot> I0(String str, String str2) {
        return new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.q(this, str, str2);
    }

    private /* synthetic */ void J1(Boolean boolean) {
        if (boolean != null) {
            this.d0.setValue(Boolean.TRUE);
        }
    }

    private ChallengeEntryModel L0() {
        ChallengeEntryModel model = null;
        if (this.F0 == null) {
            if (this.l0.get(this.X) != null) {
                model = (EntryUserPhotoItem)this.l0.get(this.X).getModel();
            } else {
                int i = 0;
            }
        }
        return model;
    }

    static /* synthetic */ void L1(app.dogo.com.dogo_android.util.e0.a0 a0Var, com.google.android.gms.tasks.j jVar) {
        a0Var.r(DialogTags.LOADING_DIALOG_FRAGMENT);
    }

    private boolean M0() {
        return this.E0;
    }

    private /* synthetic */ void M1(com.google.android.gms.tasks.j jVar) {
        if (jVar.isSuccessful()) {
            Object result = jVar.getResult();
            this.v0.updateDataSet(result);
            this.F.setChallenges(result);
            F();
            if (!result.isEmpty()) {
                boolean empty = true;
                this.m0 = empty;
                this.z.setViewVisibility(empty);
            }
        }
        this.h0.setValue(Boolean.TRUE);
    }

    private boolean N0() {
        return this.z0;
    }

    private /* synthetic */ void O1(com.google.android.gms.tasks.j jVar) {
        if (jVar.isSuccessful()) {
            this.k0.putAll((Map)jVar.getResult());
        }
        this.D0 = true;
        W1();
    }

    private void O2() {
        P2(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Likes);
    }

    private void P0(boolean z) {
        this.z.setYourTabVisibility(z ^ 1);
        if (z != 0) {
            if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
                N2();
                this.z.setSelectedTabAs(ChallengeSortingTab.LATEST_TAB);
            }
        }
    }

    private com.google.android.gms.tasks.j<Void> Q(String str, String str2) {
        final com.google.android.gms.tasks.j jVar = N(str, str2);
        jVar.continueWithTask(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.i(this, str, str2));
        return jVar;
    }

    private void Q0(ChallengeModel challengeModel) {
        m2.c cVar = this.D.L(FirestorePath.allEntries);
        cVar.forChallenge(challengeModel.getId());
        boolean z = true;
        cVar.wherePublished(z);
        cVar.sortByLikes(Query.Direction.DESCENDING);
        this.T = this.D.reportChallengeEntry(cVar.build(), 10, z);
        P(challengeModel.getId()).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.h(this));
    }

    static /* synthetic */ Boolean Q1(Throwable th) {
        return Boolean.FALSE;
    }

    private /* synthetic */ void R1(com.google.android.gms.tasks.k kVar, Boolean boolean) {
        this.Y = new LoadResult_Success(boolean);
        kVar.c(Boolean.TRUE);
    }

    static /* synthetic */ void T1(app.dogo.com.dogo_android.util.l0.a aVar, DialogInterface dialogInterface, int i) {
        aVar.a();
    }

    private int U(ChallengeModel challengeModel) {
        int i = 1;
        challengeModel = challengeModel.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 1 : 0x7fffffff /* Unknown resource */;
        return (challengeModel.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 1 : 0x7fffffff /* Unknown resource */);
    }

    private /* synthetic */ com.google.android.gms.tasks.j U1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        final int i2 = 0;
        if (!b3(str, str2)) {
            return null;
        }
        this.M.a.c().setEntryVoteCount((Map)jVar.getResult(), false);
        return i2;
    }

    private void W1() {
        if (this.D0) {
            this.U.fetchNextPage(Z(this.X));
        }
    }

    private g<QuerySnapshot> Z(String str) {
        return new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.b0(this, str);
    }

    private boolean b3(String str, String str2) {
        ChallengeModel challengeModel;
        boolean z = true;
        if (this.j0 != null) {
            if (str.equals(this.G.v())) {
                str = str2.equals(this.j0.getId()) ? 1 : 0;
            }
        }
        return (str2.equals(this.j0.getId()) ? 1 : 0);
    }

    private boolean d1() {
        return this.I0;
    }

    private /* synthetic */ void e1(String str, DocumentSnapshot documentSnapshot, FirebaseFirestoreException exc) {
        if (documentSnapshot == null) {
            return;
        }
        Object object = documentSnapshot.toObject(ChallengeModel.class);
        if (object == null) {
            return;
        }
        object.setId(documentSnapshot.getId());
        this.F.updateChallengeModel(object);
        if (this.j0 != null) {
            if (str.equals(this.j0.getId())) {
                this.z.setParticipatingCountries(object.getParticipatingCountries());
            }
        }
    }

    private /* synthetic */ boolean g1(List list, int i) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(new ChallengeCommentItem((ChallengeComment)it.next(), z));
            z = false;
        }
        this.A0.setValue(arrayList);
        return false;
    }

    private g<QuerySnapshot> h0(g0.c cVar, String str, Set<ChallengeFilterItem.FilterTypes> set) {
        return new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.d(this, cVar, str, set);
    }

    private void h2(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        P(this.j0.getId()).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.t(a0Var));
        R(this.j0);
    }

    private /* synthetic */ void i1(QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        if (querySnapshot != null && !querySnapshot.isEmpty()) {
            k2();
            if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date) {
                boolean empty = true;
                r2(empty);
            }
        }
    }

    private /* synthetic */ void k1(app.dogo.com.dogo_android.util.e0.a0 a0Var, com.google.android.gms.tasks.j jVar) throws android.content.res.Resources.NotFoundException {
        a0Var.s();
        if (!jVar.isSuccessful()) {
            return;
        }
        if (jVar.getResult() != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (ShortDynamicLink)jVar.getResult().getShortLink().toString());
            this.Q.logEvent(E_ChallengeSharing.a.c(new EP_EntryId(), this.X, new EP_ChallengeId(), this.j0.getId()));
            int i = 2131887330;
            a0Var.startActivity(Intent.createChooser(intent, this.O.getString(i)));
        }
    }

    private /* synthetic */ void m1(app.dogo.com.dogo_android.util.e0.a0 a0Var, com.google.android.gms.tasks.j jVar) {
        boolean successful;
        a0Var.s();
        if (!jVar.isSuccessful() || jVar.getResult() == null) {
            int i = 2131886123;
            a0Var.t0(i);
        } else {
            a0Var.h0((Uri)jVar.getResult(), (EntryUserPhotoItem)this.l0.values().iterator().next().getModel());
        }
    }

    private void m2() {
        this.I0 = false;
    }

    private /* synthetic */ void o1(com.google.android.gms.tasks.j jVar) {
        if (this.T == null) {
            Q0(this.j0);
        }
        w2();
    }

    private /* synthetic */ Void q1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        final int i2 = 0;
        if (!b3(str, str2)) {
            return null;
        }
        this.M.a.c().setEntryVoteCount((Map)jVar.getResult(), true);
        return i2;
    }

    private void r2(boolean z) {
        this.y0 = z;
        notifyChange(117);
    }

    static /* synthetic */ ChallengeModel s1(h0 h0Var, com.google.android.gms.tasks.j jVar) {
        h0Var.e((ChallengeModel)jVar.getResult());
        return null;
    }

    static /* synthetic */ ChallengeModel t1(h0 h0Var, com.google.android.gms.tasks.j jVar) {
        h0Var.e((ChallengeModel)jVar.getResult());
        return null;
    }

    private void t2(String str) {
        this.X = str;
        this.F0 = null;
        L0();
    }

    static /* synthetic */ Void u1(h0 h0Var, com.google.android.gms.tasks.j jVar) {
        boolean empty = false;
        int i;
        i = 0;
        if ((List)jVar.getResult().isEmpty()) {
        } else {
            Object item = (List)jVar.getResult().get(0);
        }
        if (i != 0) {
            h0Var.g(i.getDocumentId());
            h0Var.f(i.getComment());
        }
        return null;
    }

    private void u2() {
        this.I0 = true;
    }

    private /* synthetic */ h0 v1(Uri uri, h0 h0Var, com.google.android.gms.tasks.j jVar) {
        U2(uri);
        return h0Var;
    }

    private void v2() {
        if (!W2() && this.G0 != null) {
            this.G0.cancel();
        }
    }

    static /* synthetic */ x w(g0 g0Var) {
        return g0Var.Z;
    }

    private void w2() {
        if (this.j0.isHasEnded(this.L)) {
            this.Z.setValue(Boolean.TRUE);
            boolean equals = false;
            D2(equals);
            E2(equals);
            O2();
        } else {
            D2(true);
            E2(this.j0.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING));
            N2();
        }
        this.z.setParticipatingCountries(this.j0.getParticipatingCountries());
        R(this.j0);
    }

    private /* synthetic */ com.google.android.gms.tasks.j x1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        return Y2(str, str2);
    }

    private void y2() {
        boolean hasNext;
        String str;
        int i = 25;
        int i2 = 0;
        final ArrayList arrayList = new ArrayList();
        if (!this.l0.isEmpty()) {
            Iterator it = this.l0.values().iterator();
            if (it.hasNext()) {
                Object item = it.next();
                this.X = item.getModel().getDocumentId();
                arrayList.add(item);
                arrayList.add(new ChallengeCommentsTitleItem(item.getModel()));
                String documentId3 = item.getModel().getDocumentId();
                i = 25;
                i2 = 0;
                this.U = this.D.isEntryReported(documentId3, i, i2);
                y(this.L.g());
                this.D.u(item.getModel().getDocumentId(), this.G.v()).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.m(this));
            }
            this.g0.setValue(arrayList);
        }
    }

    private /* synthetic */ void z1(String str, QuerySnapshot querySnapshot) {
        Iterator it;
        boolean userEntriesQuery;
        String str2 = null;
        String str3;
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User && str != null) {
            if (str.equals(this.X) && querySnapshot != null) {
                ArrayList arrayList = new ArrayList();
                it = querySnapshot.getDocuments().iterator();
                while (it.hasNext()) {
                    ChallengeComment reportComment = this.D.reportComment((DocumentSnapshot)it.next(), this.G.v(), str, W().getId());
                }
                if (this.U.hasReachedEnd() && !this.M0()) {
                    this.E0 = true;
                    this.B0.setValue(Boolean.TRUE);
                }
                this.e0.setValue(arrayList);
                if (arrayList.isEmpty() && !querySnapshot.isEmpty()) {
                    X1();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void A(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        if (!this.l0.isEmpty() && this.X == null) {
            this.X = (EntryUserPhotoItem)this.l0.values().iterator().next().getModel().getDocumentId();
            if (a0Var == null) {
                a.d(new Throwable("Couldn't find navigator"));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = ".jpg";
            str2 = this.X + str4;
            Uri uri = this.H.h("challenge_successful", str2);
            if (uri == null) {
                return;
            }
            a0Var.m();
            if (!this.L.o(ApplicationPackageNames.INSTAGRAM_PACKAGE_NAME.getTag())) {
                this.N.generateSharingLink("sharing_challenge_photo", (EntryUserPhotoItem)this.l0.values().iterator().next().getModel(), this.F.getChallenge(this.j0.getId())).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.x(this, a0Var));
                return;
            }
            this.H.a(this.H.f(uri)).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g(this, a0Var));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public SponsorBannerItem A0() {
        return this.A;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void A2() {
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
            y2();
        } else {
            X1();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        if (this.j0 != null) {
            if (S0(z0(), this.j0)) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("currentFilters", (HashMap)this.x0.getFilters());
                str = "possibleFilters";
                bundle.putSerializable(str, (HashSet)v0(z0(), this.j0));
                a0Var.k(DialogTags.CHALLENGE_FILTER_DIALOG_FRAGMENT, bundle);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public app.dogo.com.dogo_android.y.j B0(String str, String str2) {
        return app.dogo.com.dogo_android.util.extensionfunction.l1.a(this.P, str, str2, false, null, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B2() {
        boolean z3;
        boolean z4 = true;
        boolean z2;
        int i = 0;
        if (!b1()) {
            int r0 = this.P.B() ? 1 : i;
        }
        if (!this.P) {
            if (!(this.P.u())) {
            }
        }
        this.B = new InviteFriendsBannerItem("inviteFriendsCell", z4);
        this.C = new BecomePremiumBannerItem("becomePremiumCell", z3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C(ChallengeModel challengeModel) {
        Boolean tRUE2;
        Set set;
        ChallengeModel challengeModel3;
        x xVar;
        if (this.T == null) {
            Q0(challengeModel);
        }
        if (this.j0 != challengeModel) {
            this.j0 = challengeModel;
            x();
            K();
            r2(false);
            this.x0.changeChallenge(this.j0);
            if (challengeModel.isHasEnded(this.L)) {
                this.x0.setFilters(new HashMap(), new HashSet());
            } else {
                this.x0.setFilters(this.I.setChallengeFilters(this.j0.getId(), challengeModel.getDefaultFilters()), v0(z0(), W()));
                if (Z0()) {
                    this.Z.setValue(Boolean.FALSE);
                    v2();
                } else {
                    this.Z.setValue(Boolean.TRUE);
                }
            }
            g2();
        }
        this.V.o();
        this.a0.setValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public EntryTitleItem C0() {
        return this.v0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C2() {
        this.w0 = new ChallengeTitleItem();
        this.z = new EntrySortingTabItem("sortingCell", new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.c0(this));
        this.A = new SponsorBannerItem("sponsorCell");
        this.x0 = new EntryFilterItem("filterCell");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void D(g0.c cVar) {
        this.i0 = cVar;
        if (this.q0 != null) {
            this.q0.remove();
        }
        p2(false);
        notifyChange(46);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Uri D0() {
        String str = this.E.A().f();
        if (!str.isEmpty()) {
            return e0(str);
        }
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void E0() {
        D(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User);
        k2();
        J(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void F() {
        if (this.H0 != null) {
            this.v0.checkAndSelectIfExists(this.H0);
        } else {
            if (this.u0 != null) {
                this.v0.checkAndSelectIfExists(this.u0);
            }
        }
        String str2 = null;
        this.H0 = str2;
        this.u0 = str2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String F0() {
        return this.X;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void F2(View view, app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        EntryTitleItem entryTitleItem = new EntryTitleItem("titleCell", view, a0Var, this.Q, this);
        this.v0 = entryTitleItem;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean G() {
        boolean z = false;
        int i2 = 0;
        if (this.j0 != null && !this.t0) {
            if (this.j0.isHasEnded(this.L)) {
                z = true;
                this.j0.setHasEnded(z);
                this.v0.refreshItem(this.j0);
                this.v0.updateView();
                K();
                callLoadingDialog();
                showToast(2131886293);
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String G0() {
        String comment = null;
        if (L0() != null) {
            comment = L0().getComment();
        } else {
            int i = 0;
        }
        return comment;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean G2(Bundle bundle) {
        boolean key;
        boolean z = true;
        if (bundle != null) {
            if (bundle.containsKey("challengeId")) {
                if (bundle.containsKey("uploadDogId")) {
                    str = "uploadPhoto";
                    bundle = bundle.containsKey(str) ? 1 : 0;
                }
            }
        }
        return (bundle.containsKey(str) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void H() {
        this.l0.clear();
        String str = null;
        this.X = str;
        this.F0 = str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String H0() {
        String documentId;
        if (L0() != null) {
            documentId = L0().getDocumentId();
        } else {
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean H2(ChallengeComment challengeComment) {
        boolean equals;
        boolean z = false;
        if (!Objects.equals(challengeComment.getUserId(), this.G.v())) {
            if (challengeComment.isEntryAuthor(this.G.v())) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void I() {
        if (this.x0.isFilterLisEmpty()) {
            int i = 4;
            b2(i);
        } else {
            this.x0.setFilters(new HashMap(), new HashSet());
            g2();
            this.Q.logEvent(E_Challenges.j);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void I2(app.dogo.com.dogo_android.util.e0.a0 a0Var, ChallengeModel challengeModel, boolean z, boolean z2, boolean z3) {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("challenge", challengeModel);
        bundle.putBoolean("show_checkbox", z);
        bundle.putBoolean("show_prize", z2);
        bundle.putBoolean("show_rules", z3);
        bundle.putBoolean("is_user_over_limit", !c1());
        bundle.putInt("style", 2131951968);
        a0Var.k(DialogTags.CHALLENGE_DETAILS_DIALOG, bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void J(boolean z) {
        boolean z2 = false;
        this.z0 = z2;
        this.E0 = z2;
        if (z) {
            o0().setValue(Boolean.TRUE);
        }
        this.n0.clear();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public ChallengeEntryModel J0() {
        int i = 0;
        if (this.l0 == null || this.l0.isEmpty()) {
            i = 0;
        } else {
            ChallengeEntryModel model = (EntryUserPhotoItem)this.l0.values().iterator().next().getModel();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void J2() {
        this.x0.show();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void K() {
        this.t0 = this.j0.isHasEnded(this.L);
        H();
        P(this.j0.getId()).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.j(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<List<h.a.b.h.f>> K0() {
        if (this.g0.getValue() == null) {
            this.g0.setValue(new ArrayList());
        }
        return this.g0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void K2(Context context, app.dogo.com.dogo_android.util.l0.a aVar) {
        new b(context).w(2131886953).D(2131886562, new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.f(aVar)).y(2131886677, null).o();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void L() {
        if (this.q0 != null) {
            this.q0.remove();
        }
        this.C0 = this.L.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void L2(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        final q2.a pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
        if (this.K.shouldTriggerRateUsPopUp(pHOTO_LIKE2.getTag())) {
            this.K.callDialog(a0Var, RateItService_RateSource.PHOTO_LIKE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public float M(boolean z) {
        float height;
        float f;
        float f2;
        float f4 = u0((float)y0().getPosition());
        float height2 = y0().getHeight();
        if (W() == null || !z) {
            if (m0().isVisible()) {
                f2 = (float)m0().getPosition();
                height = m0().getHeight();
            } else {
                f = f4 + height2;
            }
        } else {
            f2 = (float)A0().getPosition();
            height = A0().getHeight();
            f = f2 + height;
        }
        f4 += height2;
        return f < f5 ? f5 : f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void M2(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        final q2.a pHOTO_LIKE2 = RateItService_RateSource.PHOTO_LIKE;
        if (this.K.shouldTriggerReminderPopUp(pHOTO_LIKE2.getTag())) {
            this.K.showShareDialog(a0Var, RateItService_RateSource.PHOTO_LIKE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public com.google.android.gms.tasks.j<Void> N(String str, String str2) {
        return this.D.fetchAllChallenges(str, str2, true).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.l(this, str, str2));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void N2() {
        D(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date);
        if (S0(this.i0, this.j0)) {
            J2();
        } else {
            O0();
        }
        this.x2(this.i0, this.j0, 0, this.x0.getFilters(), this.I.p());
        z(c0());
        J(true);
        this.x0.refreshCell(v0(z0(), this.j0));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public com.google.android.gms.tasks.j<h0> O(Bundle bundle) {
        com.google.android.gms.tasks.j continueWith;
        app.dogo.com.dogo_android.a0.g.f.e eVar;
        final app.dogo.com.dogo_android.a0.g.f.h0 h0Var = new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.h0();
        String string2 = bundle.getString("challengeId");
        String string = bundle.getString("uploadDogId");
        ChallengeModel challenge = this.F.getChallenge(string2);
        DogProfileModel dogProfileModel = this.E.getUserAndDogCache().getDogProfileModel(string, this.G.v());
        if (challenge != null) {
            continueWith = m.e(challenge).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.e(h0Var));
        } else {
            continueWith = this.D.s(string2, LocaleService_SupportedLocales.ENGLISH.getLocaleTag()).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.n(h0Var));
        }
        if (dogProfileModel != null) {
            h0Var.h(new LiteDogProfile(dogProfileModel));
        } else {
            String str = null;
            h0Var.h(new LiteDogProfile(str, str, string));
        }
        com.google.android.gms.tasks.j[] arr = new j[2];
        return m.g(new j[] { continueWith, this.D.y(this.G.v(), string2).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.y(h0Var)) }).continueWith(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.u(this, (Uri)bundle.getParcelable("uploadPhoto"), h0Var));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void O0() {
        this.x0.hide();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public com.google.android.gms.tasks.j<Void> P(String str) {
        return Q(this.G.v(), str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void P2(g0.c cVar) {
        D(cVar);
        if (S0(this.i0, this.j0)) {
            J2();
        } else {
            O0();
        }
        k2();
        this.x2(this.i0, this.j0, !this.j0.isHasEnded(this.L), this.x0.getFilters(), this.I.p());
        J(true);
        this.x0.refreshCell(v0(z0(), this.j0));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Q2(app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        if (this.G.D()) {
            boolean z = false;
            R2(a0Var, z);
        } else {
            a0Var.emitFragmentMessage("challenges_entry");
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void R(ChallengeModel challengeModel) {
        if (this.p0 != null) {
            this.p0.remove();
            m2();
        }
        this.l0.clear();
        this.V.o();
        this.p0 = this.D.writeToDocument(this.G.v(), challengeModel.getId(), I0(this.G.v(), challengeModel.getId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean R0() {
        return this.G.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void R2(app.dogo.com.dogo_android.util.e0.a0 a0Var, boolean z) {
        String str3;
        Uri fileUri;
        if (E(a0Var, z)) {
            if (SpecialChallenges.WELCOME_CHALLENGE.getId().equals(this.j0.getId()) && this.J0() != null) {
                showToast(2131886307);
                return;
            }
            z = false;
            int i = 800;
            if (J0() != null) {
                this.s0 = J0().getLiteDogProfile();
                a0Var.onRequestPermissionsResult(z, i, i);
                return;
            }
            if (this.E.getUserAndDogCache().j() == 1) {
                this.s0 = new LiteDogProfile(this.E.getUserAndDogCache().g().toModel(this.G.v()));
                a0Var.onRequestPermissionsResult(z, i, i);
            } else {
                a0Var.l0("challenge_image_dog_select_request", "challenge_home");
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public BecomePremiumBannerItem S() {
        return this.C;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean S0(g0.c cVar, ChallengeModel challengeModel) {
        return !(v0(cVar, challengeModel).isEmpty());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void S2() {
        if (this.K0) {
            z(this.L0);
            boolean z = false;
            this.K0 = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int T() {
        int i = 8;
        boolean activeNetworkType = this.J.getActiveNetworkType();
        if (!activeNetworkType) {
            int i2 = 2131886953;
            showToast(i2);
        }
        int r0 = activeNetworkType ? 8 : 0;
        return (activeNetworkType ? 8 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean T0(Uri uri) {
        boolean z = false;
        int[] bitmapSize = this.H.getBitmapSize(uri);
        final int i = 1;
        final int i4 = 800;
        if (bitmapSize[0] >= i4) {
            if (bitmapSize[i] >= i4) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void T2() {
        if (this.J0) {
            k2();
            boolean z = true;
            this.K0 = z;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean U0(String str) {
        Uri fileUri = this.H.getFileUri(str, "avatar.jpg");
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean U2(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.H.saveBitmapIntoInternalStorage("entryTemp", uri, "entry.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Boolean> V() {
        return this.h0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean V0() {
        boolean z = false;
        app.dogo.com.dogo_android.service.v2 v2Var;
        if (this.j0 != null) {
            int r0 = !this.j0.isHasEnded(this.L) ? 1 : 0;
        }
        return (!this.j0.isHasEnded(this.L) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void V2() {
        app.dogo.com.dogo_android.a0.g.f.g0.c cVar;
        app.dogo.com.dogo_android.a0.g.f.g0.c likes2;
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Likes || this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date) {
            if (S0(z0(), this.j0)) {
                J2();
            } else {
                O0();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public ChallengeModel W() {
        return this.j0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean W0() {
        return this.m0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean W2() {
        if (this.V.r() != b.b.TIMEOUT) {
            return false;
        }
        if (this.G0 != null) {
            this.G0.cancel();
        }
        app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.a aVar = new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.a(this, 3000L, l, 3000, obj);
        this.G0 = aVar.start();
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public ChallengeTitleItem X() {
        return this.w0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean X0(ChallengeComment challengeComment) {
        return challengeComment.isCommentAuthor(this.G.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void X1() {
        notifyChange(27);
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
            W1();
        } else {
            if (this.T != null) {
                this.T.fetchNextPage(h0(this.i0, this.j0.getId(), new HashSet(this.x0.getFilters().keySet())));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void X2(ChallengeEntryModel challengeEntryModel, app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        notifyChange(27);
        L2(a0Var);
        M2(a0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int Y() {
        int i = 8;
        int r0 = this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User && this.W ? 0 : 8;
        return (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User && this.W ? 0 : 8);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean Y0(ChallengeComment challengeComment) {
        return challengeComment.isEntryAuthor(this.G.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Y1(String str) {
        if (this.l0.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = ".jpg";
            str4 = str + str3;
            str2 = "challenge_failed";
            (EntryUserPhotoItem)this.l0.get(str).setUploadFail(this.H.getFile(str2, str4));
            e2();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public com.google.android.gms.tasks.j<Void> Y2(String str, String str2) {
        return this.D.fetchAllChallenges(str, str2, false).continueWithTask(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.k(this, str, str2));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean Z0() {
        boolean z = true;
        int i;
        ChallengeEntryModel challengeEntryModel = J0();
        i = 1;
        if (challengeEntryModel == null) {
            return true;
        }
        long timeLeftInMillis = this.j0.getTimeLeftInMillis(this.L.g());
        long timeTillAdditionalUploadInMillis = challengeEntryModel.computeTimeTillAdditionalUploadInMillis(this.L.g());
        i = 0;
        int r2 = i;
        if (this.j0.getMediaType().equals(ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING) || !challengeEntryModel.isUploadStatusReadyToUpload(this.L.g(), obj3) || this.j0 == 0) {
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Z1(ChallengeModel challengeModel, app.dogo.com.dogo_android.util.e0.a0 a0Var, int i) {
        if (this.j0 == challengeModel) {
            boolean z = true;
            boolean z2 = false;
            boolean z3 = false;
            this.I2(a0Var, challengeModel, z, z2, z3);
        } else {
            this.v0.setPosition(i);
            this.Q.logEvent(E_Challenges.A);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Z2(ChallengeModel challengeModel) {
        this.A.changeChallenge(challengeModel);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public long a0() {
        return this.C0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean a1() {
        return this.y0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void a2(ChallengeComment challengeComment, String str) {
        this.Q.logEvent(E_Challenges.e.c(new EP_EntryId(), challengeComment.getDocumentId(), new EP_ChallengeId(), challengeComment.getChallengeId(), new EP_ViewSource(), CommentSource.commentSourceParser(str)));
        if (H2(challengeComment)) {
            this.D.h(challengeComment);
        } else {
            this.D.O(challengeComment);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean a3(String str, ChallengeComment challengeComment, app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        challengeComment = new ChallengeComment(this.G.v(), str, F0(), b0(), W().getId(), this.G.v());
        challengeComment.setBadges(this.D.unvoteEntryComment(b0().getId(), b1()));
        if (challengeComment != null) {
            challengeComment.setReplyTarget(challengeComment);
        }
        boolean z2 = false;
        if (challengeComment.getDogName() != null) {
            this.D.D0(challengeComment);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ChallengeCommentItem(challengeComment, z2));
            this.A0.setValue(arrayList);
            this.Q.logEvent(E_Challenges.d.c(new EP_EntryId(), F0(), new EP_ChallengeId(), W().getId(), new EP_ViewSource(), CommentSource.commentSourceParser(this.registry.getTag())));
            Bundle bundle = new Bundle();
            bundle.putString("id", F0());
            emitMessage(FragmentMessageAction.MESSAGE_ACTION_NEW_COMMENT_POSTED, bundle);
            return true;
        }
        a0Var.w0(this.E.getUserAndDogCache().n(), 11100);
        a0Var.showToast(2131886415);
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public DogProfileModel b0() {
        return this.E.getUserAndDogCache().g().toModel(this.G.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean b1() {
        boolean z = false;
        if (yVar instanceof LoadResult_Success) {
            int r0 = (Boolean)yVar.component1().booleanValue() ? 1 : 0;
        }
        return ((Boolean)yVar.component1().booleanValue() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void b2(int i) {
        int i3 = 1;
        Integer num;
        notifyChange(27);
        int i2 = 4;
        if (i == 4) {
            this.b0.setValue(null);
        }
        i3 = 1;
        if (i == 1) {
            if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date) {
                N2();
                this.a0.setValue(Boolean.TRUE);
                L();
            } else {
                if (this.a0 == 0) {
                    if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Likes) {
                        O2();
                        this.a0.setValue(Boolean.TRUE);
                        L();
                    } else {
                        int i4 = 2;
                        if (this.a0 == 2) {
                            if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
                                O0();
                                this.a0.setValue(Boolean.TRUE);
                                E0();
                                this.x0.refreshCell(v0(z0(), this.j0));
                            } else {
                                int i5 = 6;
                                if (this.a0 == 6) {
                                    date2 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24;
                                    if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24) {
                                        O0();
                                        P2(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24);
                                        this.a0.setValue(Boolean.TRUE);
                                        L();
                                    } else {
                                        int i6 = 5;
                                        if (this.a0 == 5) {
                                            date2 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Days_7;
                                            if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Days_7) {
                                                O0();
                                                P2(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Days_7);
                                                this.a0.setValue(Boolean.TRUE);
                                                L();
                                            } else {
                                                if (this.a0 == 7) {
                                                    app.dogo.com.dogo_android.a0.g.f.g0.c country2 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country;
                                                    if (this.i0 != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country) {
                                                        O0();
                                                        P2(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country);
                                                        this.a0.setValue(Boolean.TRUE);
                                                        L();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Calendar c0() {
        return Calendar.getInstance();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean c1() {
        boolean z = true;
        int i2 = 1;
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void c2(RecyclerView recyclerView) {
        if (this.j0 != null) {
            j0();
            recyclerView.q1(1);
            this.Q.logEvent(E_Challenges.s);
        }
        r2(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean c3() {
        return this.m0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public app.dogo.com.dogo_android.util.g0.a d0() {
        return this.V;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void d2() {
        boolean z = false;
        r2(z);
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Date) {
            z(c0());
        }
        J(z);
        notifyChange(27);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Uri e0(String str) {
        return this.H.getFileUri(str, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void e2() {
        y2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int f0() {
        return this.E.getUserAndDogCache().j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void f2() {
        this.V.u(J0(), this.L.g());
        v2();
        if (!Z0()) {
            this.Z.setValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Boolean> g0() {
        return this.B0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void g2() {
        k2();
        this.x2(this.i0, this.j0, 0, this.x0.getFilters(), this.I.p());
        J(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<List<h.a.b.h.f>> i0() {
        if (this.e0.getValue() == null) {
            this.e0.setValue(new ArrayList());
        }
        return this.e0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void i2() {
        this.D.startListeningToArchivedNotificationBranch(this.I.W(), this.P.v(), this.G.C()).addOnCompleteListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.o(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void j0() {
        r2(false);
        this.T.addNewDocuments(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.w(this));
        z(c0());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void j2() {
        if (this.r0 != null) {
            this.r0.remove();
            ListenerRegistration listenerRegistration = null;
            this.r0 = listenerRegistration;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Boolean> k0() {
        return this.Z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void k2() {
        final boolean z2 = false;
        if (this.J0) {
            this.o0.remove();
            this.J0 = z2;
        }
        r2(z2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Boolean> l0() {
        return this.a0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void l2() {
        if (this.T != null) {
            this.T.i();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void m(int i, int i2, Intent intent, app.dogo.com.dogo_android.util.e0.a0 a0Var) {
        super.onActivityResult(i, i2, intent, a0Var);
        if (i == 10000 && i2 == -1) {
            a0Var.registerToChannel(DialogTags.LOADING_DIALOG_FRAGMENT);
            if (this.j0 != null) {
                h2(a0Var);
            }
            if (!this.G.D()) {
                this.Q.logEvent(E_Auth.b);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public EntryFilterItem m0() {
        return this.x0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n() {
        super.n();
        if (this.o0 != null) {
            this.o0.remove();
        }
        if (this.p0 != null) {
            this.p0.remove();
            m2();
        }
        if (this.q0 != null) {
            this.q0.remove();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public InviteFriendsBannerItem n0() {
        return this.B;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n2(String str) {
        this.s0 = r0(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Boolean> o0() {
        return this.c0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void o2(Bundle bundle) {
        if (bundle != null) {
            str = "challengeId";
            this.H0 = bundle.getString(str);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    protected void onCleared() {
        super.onCleared();
        this.S.d();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void p(Bundle bundle) {
        if (bundle != null) {
            this.s0 = (LiteDogProfile)bundle.getParcelable("selected_profile");
            this.j0 = (ChallengeModel)bundle.getParcelable("challenge_model");
            str = "userEntryToUpload";
            this.F0 = (ChallengeEntryModel)bundle.getParcelable(str);
            this.u0 = this.j0;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiveData<Boolean> p0() {
        return this.d0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void p2(boolean z) {
        if (this.W != z) {
            this.W = z;
            int i = 46;
            notifyChange(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<Integer> q0() {
        return this.b0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void q2(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        this.x0.setFilters(map, v0(z0(), this.j0));
        g2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Bundle r() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("selected_profile", this.s0);
        bundle.putParcelable("challenge_model", this.j0);
        bundle.putParcelable("userEntryToUpload", L0());
        return bundle;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiteDogProfile r0(String str) {
        LiteDogProfile liteDogProfile = null;
        final DogProfileModel dogProfileModel = this.E.getUserAndDogCache().getDogProfileModel(str, this.G.v());
        LiteDogProfile r0 = dogProfileModel != null ? new iteDogProfile(dogProfileModel) : 0;
        return (dogProfileModel != null ? new iteDogProfile(dogProfileModel) : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void s() {
        super.s();
        S2();
        if (this.j0 != null) {
            R(this.j0);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiveData<List<h.a.b.h.f>> s0() {
        return this.A0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void s2(app.dogo.com.dogo_android.k.b bVar) {
        y0().setSelectedTabAs(bVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void t() {
        super.t();
        T2();
        if (this.p0 != null) {
            this.p0.remove();
            m2();
        }
        L();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public x<List<h.a.b.h.f>> t0() {
        if (this.f0.getValue() == null) {
            this.f0.setValue(new ArrayList());
        }
        return this.f0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Set<ChallengeFilterItem.FilterTypes> v0(g0.c cVar, ChallengeModel challengeModel) {
        Set possibleFilters = this.x0.getPossibleFilters();
        if (!possibleFilters.isEmpty() && cVar != null) {
            int i3 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.b.a[cVar.ordinal()];
            if (i3 != 1) {
                int i = 2;
                if (i3 != 2) {
                    possibleFilters.clear();
                } else {
                    possibleFilters.remove(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
                }
            } else {
                if (challengeModel.isHasEnded(this.L)) {
                    possibleFilters.remove(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
                }
            }
        }
        return possibleFilters;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public f.d.a.a<List<String>> w0() {
        return this.D.M();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void x() {
        j2();
        if (this.j0 == null) {
            return;
        }
        this.r0 = this.D.K(FirestorePath.localisedChallenges.forLocale(LocaleService.getLocaleFullString(Locale.getDefault().getLanguage())).forChallengeId(this.j0.getId())).addSnapshotListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.z(this, this.j0.getId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiteDogProfile x0() {
        return this.s0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void x2(g0.c cVar, ChallengeModel challengeModel, int i, Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map, String str) {
        m2.c cVar2;
        country2 = app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24;
        if (cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24) {
            cVar2 = this.D.L(FirestorePath.latestEntries_24);
        } else {
            if (cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Days_7) {
                cVar2 = this.D.L(FirestorePath.latestEntries_168);
            } else {
                if (cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country) {
                    cVar2 = this.D.L(FirestorePath.allEntries);
                } else {
                    cVar2 = this.D.L(FirestorePath.allEntries);
                }
            }
        }
        if (cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Likes || !(cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Hour_24 && cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Days_7 && cVar != app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country)) {
            cVar2.sortByLikes(Query.Direction.DESCENDING);
            cVar2.sortByDate(Query.Direction.ASCENDING);
        }
        if (map.containsKey(ChallengeFilterItem_FilterTypes.FEATURED)) {
            cVar2.j();
        }
        if (cVar == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.Country && str != null) {
            cVar2.whereIsCountry(str);
        }
        cVar2.forChallenge(challengeModel.getId());
        cVar2.wherePublished(true);
        this.T.h(cVar2.build(), 10, i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void y(long j) {
        if (this.i0 == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
            if (j != 0 && this.X != null && !this.X.isEmpty()) {
                L();
                this.q0 = this.D.buildNewCommentListener(this.G.v(), this.X, this.G.C(), this.G.v(), W().getId(), j, new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.s(this));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public EntrySortingTabItem y0() {
        return this.z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void z(Calendar calendar) {
        if (this.J0) {
            k2();
        }
        this.L0 = calendar;
        m2.c cVar = this.D.L(FirestorePath.allEntries);
        cVar.forChallenge(this.j0.getId());
        boolean z = true;
        cVar.wherePublished(z);
        cVar.publishedAfter(calendar.getTime());
        cVar.sortByDate(Query.Direction.DESCENDING);
        if (this.x0.getFilters().containsKey(ChallengeFilterItem_FilterTypes.FEATURED)) {
            cVar.j();
        }
        cVar.limitTo(1L);
        this.o0 = cVar.build().addSnapshotListener(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.v(this));
        this.J0 = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public g0.c z0() {
        return this.i0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public com.google.android.gms.tasks.j<Boolean> z2() {
        com.google.android.gms.tasks.k kVar = new k();
        this.Y = LoadResult_Loading.a;
        this.S.b(this.R.q().observeOn(a.b()).subscribeOn(a.b()).onErrorReturn(app.dogo.com.dogo_android.viewmodel.main_screen.challenge.p.a).subscribe(new app.dogo.com.dogo_android.viewmodel.main_screen.challenge.r(this, kVar)));
        return kVar.a();
    }

    public g0() {
        this(App.h(), App.e(), App.b(), App.g(), App.m(), App.i(), App.o(), App.d(), App.j(), App.p(), App.l(), App.k(), App.f(), App.onCreate().getResources(), App.n());
    }

    private float u0(float f) {
        float f2;
        f2 = 0.0f;
        if (f <= 0.0f) {
        }
        return f2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void A1(String str, QuerySnapshot querySnapshot) {
        z1(str, querySnapshot);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void C1(g0.c cVar, String str, Set set, QuerySnapshot querySnapshot) {
        B1(cVar, str, set, querySnapshot);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void E1(QuerySnapshot querySnapshot) {
        D1(querySnapshot);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void G1(String str, String str2, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        F1(str, str2, querySnapshot, exc);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void I1(com.google.android.gms.tasks.j jVar) {
        this.w2(jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void K1(Boolean boolean) {
        J1(boolean);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void N1(com.google.android.gms.tasks.j jVar) {
        M1(jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void P1(com.google.android.gms.tasks.j jVar) {
        O1(jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void S1(com.google.android.gms.tasks.k kVar, Boolean boolean) {
        R1(kVar, boolean);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ com.google.android.gms.tasks.j V1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        return U1(str, str2, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void f1(String str, DocumentSnapshot documentSnapshot, FirebaseFirestoreException exc) {
        e1(str, documentSnapshot, exc);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ boolean h1(List list, int i) {
        return g1(list, i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void j1(QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        i1(querySnapshot, exc);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void l1(app.dogo.com.dogo_android.util.e0.a0 a0Var, com.google.android.gms.tasks.j jVar) {
        k1(a0Var, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void n1(app.dogo.com.dogo_android.util.e0.a0 a0Var, com.google.android.gms.tasks.j jVar) {
        m1(a0Var, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ void p1(com.google.android.gms.tasks.j jVar) {
        o1(jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ Void r1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        return q1(str, str2, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ h0 w1(Uri uri, h0 h0Var, com.google.android.gms.tasks.j jVar) {
        this.U2(uri, h0Var, jVar);
        return h0Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public /* synthetic */ com.google.android.gms.tasks.j y1(String str, String str2, com.google.android.gms.tasks.j jVar) {
        return this.Y2(str, str2, jVar);
    }
}
