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
import app.dogo.com.dogo_android.d.b.y;
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.d.b.z.m;
import app.dogo.com.dogo_android.k.a;
import app.dogo.com.dogo_android.k.b;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.f;
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
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g0.a;
import app.dogo.com.dogo_android.util.g0.b;
import app.dogo.com.dogo_android.util.g0.b.b;
import app.dogo.com.dogo_android.util.h0.l1;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.util.l0.a;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.w2;
import app.dogo.com.dogo_android.y.j;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
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
import f.c.a.e.s.b;
import f.d.a.a;
import h.a.b.h.f;
import i.b.a0;
import i.b.j0.a;
import i.b.s0.a;
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
import n.a.a;

/* loaded from: classes.dex */
public class g0 extends r {

    private SponsorBannerItem A;
    private x<List<f>> A0;
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
    private final v2 L;
    private Calendar L0;
    private final s2 M;
    private final k2 N;
    private final Resources O;
    private final r2 P;
    private final o3 Q;
    private final n3 R;
    private a S;
    private m2.b T;
    private m2.b U;
    private b V;
    private boolean W;
    private String X;
    private y<Boolean> Y;
    private x<Boolean> Z;
    private x<Boolean> a0;
    private x<Integer> b0;
    private x<Boolean> c0;
    private v<Boolean> d0;
    private x<List<f>> e0;
    private x<List<f>> f0;
    private x<List<f>> g0;
    private x<Boolean> h0;
    private app.dogo.com.dogo_android.a0.g.f.g0.c i0;
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

        final app.dogo.com.dogo_android.a0.g.f.g0 a;
        a(app.dogo.com.dogo_android.a0.g.f.g0 g0, long l2, long l3) {
            this.a = g0;
            super(l2, l3, obj4, obj5);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            g0.w(this.a).setValue(Boolean.TRUE);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long l) {
        }
    }

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            g0.b.a = iArr;
            iArr[g0.c.Likes.ordinal()] = 1;
            g0.b.a[g0.c.Date.ordinal()] = 2;
        }
    }

    public static enum c {

        Likes,
        Date,
        User,
        Hour_24,
        Days_7,
        Country;
    }
    public g0() {
        super(App.h(), App.e(), App.b(), App.g(), App.m(), App.i(), App.o(), App.d(), App.j(), App.p(), App.l(), App.k(), App.f(), App.a().getResources(), App.n());
    }

    public g0(m2 m2, a1 a12, h2 h23, u2 u24, t2 t25, p2 p26, o3 o37, j2 j28, q2 q29, v2 v210, s2 s211, r2 r212, k2 k213, Resources resources14, n3 n315) {
        final Object obj = this;
        s2 s2Var = s211;
        Resources resources = resources14;
        super();
        a aVar2 = new a();
        obj.S = aVar2;
        obj.Y = y.b.a;
        x xVar = new x();
        obj.Z = xVar;
        x xVar2 = new x();
        obj.a0 = xVar2;
        x xVar3 = new x();
        obj.b0 = xVar3;
        x xVar4 = new x();
        obj.c0 = xVar4;
        v vVar2 = new v();
        obj.d0 = vVar2;
        x xVar5 = new x();
        obj.e0 = xVar5;
        x xVar6 = new x();
        obj.f0 = xVar6;
        x xVar7 = new x();
        obj.g0 = xVar7;
        x xVar8 = new x();
        obj.h0 = xVar8;
        obj.i0 = g0.c.Date;
        HashMap hashMap = new HashMap();
        obj.k0 = hashMap;
        HashMap hashMap2 = new HashMap();
        obj.l0 = hashMap2;
        obj.m0 = false;
        HashSet hashSet = new HashSet();
        obj.n0 = hashSet;
        x xVar9 = new x();
        obj.A0 = xVar9;
        x xVar10 = new x();
        obj.B0 = xVar10;
        obj.H0 = 0;
        obj.D = m2;
        obj.G = h23;
        obj.F = a12;
        obj.E = u24;
        obj.H = t25;
        obj.I = p26;
        obj.J = j28;
        obj.K = q29;
        obj.Q = o37;
        obj.L = v210;
        obj.P = r212;
        obj.M = s2Var;
        obj.N = k213;
        obj.O = resources;
        obj.R = n315;
        b bVar2 = new b(resources);
        obj.V = bVar2;
        bVar2.o();
        a0 a0Var = new a0(this);
        obj.d0.b(s2Var.a.d(), a0Var);
        C2();
    }

    private void B1(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, String string2, Set set3, QuerySnapshot querySnapshot4) {
        app.dogo.com.dogo_android.a0.g.f.g0.c entryPhotoItem;
        Object eNTRIES_LIST_EMPTY;
        boolean entryOldPhotoItem;
        boolean equals;
        String documentId;
        String dogId;
        boolean z;
        app.dogo.com.dogo_android.a0.g.f.g0.c obj6;
        boolean obj7;
        Object obj8;
        if (this.i0 == c && string2.equals(this.j0.getId()) && set3.equals(this.x0.getFilters().keySet()) && querySnapshot4 != null) {
            if (string2.equals(this.j0.getId())) {
                if (set3.equals(this.x0.getFilters().keySet())) {
                    if (querySnapshot4 != null) {
                        obj6 = new ArrayList();
                        obj7 = querySnapshot4.getDocuments().iterator();
                        entryPhotoItem = 1;
                        while (obj7.hasNext()) {
                            obj8 = obj7.next();
                            eNTRIES_LIST_EMPTY = (DocumentSnapshot)obj8.toObject(ChallengeEntryModel.class);
                            (ChallengeEntryModel)eNTRIES_LIST_EMPTY.setDocumentId(obj8.getId());
                            eNTRIES_LIST_EMPTY.setEntryStateData(s2Var.a.b(obj8.getId()));
                            if (!this.D.R(eNTRIES_LIST_EMPTY, this.G.v(), this.G.C()) && eNTRIES_LIST_EMPTY.getAuthor().equals(this.G.v())) {
                            }
                            entryPhotoItem = 1;
                            eNTRIES_LIST_EMPTY.setEntryStateData(s2Var.a.b(obj8.getId()));
                            if (eNTRIES_LIST_EMPTY.getAuthor().equals(this.G.v())) {
                            }
                            if (!this.n0.contains(eNTRIES_LIST_EMPTY.getDocumentId())) {
                            }
                            this.n0.add(eNTRIES_LIST_EMPTY.getDocumentId());
                            if (this.j0.isHasEnded(this.L)) {
                            } else {
                            }
                            entryPhotoItem = new EntryPhotoItem(eNTRIES_LIST_EMPTY, obj8.getId(), b1());
                            obj6.add(entryPhotoItem);
                            entryOldPhotoItem = new EntryOldPhotoItem(eNTRIES_LIST_EMPTY, obj8.getId(), entryPhotoItem ^= filterLisEmpty, b1());
                            obj6.add(entryOldPhotoItem);
                            eNTRIES_LIST_EMPTY.setDogProfile(App.g().A().l(eNTRIES_LIST_EMPTY.getDogId(), this.G.v()));
                        }
                        obj8 = 0;
                        if (this.T.e() && !N0() && this.n0.isEmpty()) {
                            if (!N0()) {
                                obj8 = 0;
                                if (this.n0.isEmpty()) {
                                    obj7 = new ChallengeFeedEndItem(obj8, ChallengeFeedEndObservable.LabelState.ENTRIES_LIST_EMPTY);
                                    obj6.add(obj7);
                                }
                                if (!this.n0.isEmpty() && this.x0.isFilterLisEmpty()) {
                                    if (this.x0.isFilterLisEmpty()) {
                                        obj7 = new ChallengeFeedEndItem(obj8, ChallengeFeedEndObservable.LabelState.FEED_END);
                                        obj6.add(obj7);
                                    }
                                }
                                if (!this.n0.isEmpty() && !this.x0.isFilterLisEmpty()) {
                                    if (!this.x0.isFilterLisEmpty()) {
                                        obj7 = new ChallengeFeedEndItem(obj8, ChallengeFeedEndObservable.LabelState.CLEAR_FILTER);
                                        obj6.add(obj7);
                                    }
                                }
                                this.B0.setValue(Boolean.TRUE);
                                this.z0 = entryPhotoItem;
                            }
                        }
                        this.e0.setValue(obj6);
                        i();
                        if (obj6.isEmpty() && !querySnapshot4.isEmpty()) {
                            if (!querySnapshot4.isEmpty()) {
                                X1();
                            }
                        }
                    }
                }
            }
        }
    }

    private void D1(QuerySnapshot querySnapshot) {
        int arrayList;
        int next;
        Object object;
        boolean entryPhotoItem;
        String str;
        boolean z;
        int obj7;
        if (querySnapshot != 0) {
            if (querySnapshot.size() < 10) {
                arrayList = new ArrayList();
                obj7 = querySnapshot.getDocuments().iterator();
                while (obj7.hasNext()) {
                    next = obj7.next();
                    object = (DocumentSnapshot)next.toObject(ChallengeEntryModel.class);
                    (ChallengeEntryModel)object.setDocumentId(next.getId());
                    object.setEntryStateData(s2Var.a.b(next.getId()));
                    if (!this.D.R(object, this.G.v(), this.G.C())) {
                    }
                    entryPhotoItem = new EntryPhotoItem(object, next.getId(), b1());
                    arrayList.add(entryPhotoItem);
                }
                this.f0.setValue(arrayList);
            } else {
                h();
                J(true);
                l2();
                X1();
            }
        }
    }

    private void D2(boolean z) {
        this.z.setChallengeExpired(z ^= 1);
    }

    private boolean E(a0 a0, boolean z2) {
        ChallengeEntryModel obj11;
        int obj12;
        final int i3 = 27;
        final int i4 = 0;
        if (!this.J.a()) {
            l(i3);
            v(2131886953);
            return i4;
        }
        if (G()) {
            return i4;
        }
        ChallengeModel challengeModel = this.j0;
        final int i5 = 2131886693;
        if (challengeModel == null) {
            v(i5);
            return i4;
        }
        if (challengeModel.isHasEnded(this.L)) {
            v(2131886293);
            this.Z.setValue(Boolean.TRUE);
            return i4;
        }
        if (!c1()) {
            this.Z.setValue(Boolean.TRUE);
            v(2131886305);
            return i4;
        }
        if (!this.E.B("challenge_terms_v1")) {
            this.I2(a0, this.j0, true, false, true);
            return i4;
        }
        if (this.E.A().j() == 0) {
            a0.w0(this.E.A().n(), 11103);
            v(2131886415);
            return i4;
        }
        if (this.V.t() && z2 == 0) {
            if (z2 == 0) {
                return i4;
            }
        }
        if (!d1()) {
            v(i5);
            return i4;
        }
        if (L0() != null && U(this.j0) <= L0().getImageCount()) {
            if (U(this.j0) <= L0().getImageCount()) {
                v(i5);
                return i4;
            }
        }
        l(i3);
        return 1;
    }

    private void E2(boolean z) {
        this.z.setChallengWelcome(z);
    }

    private void F1(String string, String string2, QuerySnapshot querySnapshot3, FirebaseFirestoreException firebaseFirestoreException4) {
        Map map;
        boolean hasEnded;
        boolean isBeingDeleted;
        boolean published;
        String str2;
        String string3;
        EntryUserPhotoItem entryUserPhotoItem;
        String str;
        boolean z;
        boolean obj6;
        boolean obj7;
        String obj8;
        String obj9;
        if (string.equals(this.G.v()) && string2.equals(this.j0.getId()) && querySnapshot3) {
            if (string2.equals(this.j0.getId())) {
                if (querySnapshot3) {
                    obj7 = querySnapshot3.getDocuments().iterator();
                    while (obj7.hasNext()) {
                        obj8 = obj7.next();
                        obj9 = (DocumentSnapshot)obj8.toObject(ChallengeEntryModel.class);
                        (ChallengeEntryModel)obj9.setDocumentId(obj8.getId());
                        obj9.setEntryStateData(s2Var.a.b(obj8.getId()));
                        if (this.j0.isHasEnded(this.L)) {
                        }
                        if (!obj9.getPublished()) {
                        }
                        obj9.setDogProfile(this.E.A().l(obj9.getDogId(), string));
                        entryUserPhotoItem = new EntryUserPhotoItem(obj9, obj8.getId(), b1());
                        this.l0.put(obj8.getId(), entryUserPhotoItem);
                        t2(obj8.getId());
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(obj9.getDocumentId());
                        stringBuilder.append(".jpg");
                        obj9.setUploadFailed(this.H.c("challenge_failed", stringBuilder.toString()));
                        obj9.setChallengeEnded(true);
                    }
                    e2();
                    P0(this.l0.isEmpty());
                    f2();
                    u2();
                }
            }
        }
    }

    private void H1(j j) {
        w2();
    }

    private EventListener<QuerySnapshot> I0(String string, String string2) {
        q qVar = new q(this, string, string2);
        return qVar;
    }

    private void J1(Boolean boolean) {
        Boolean tRUE;
        v obj2;
        if (boolean != null) {
            this.d0.setValue(Boolean.TRUE);
        }
    }

    private ChallengeEntryModel L0() {
        ChallengeEntryModel model;
        String str;
        if (this.F0 == null) {
            if (this.l0.get(this.X) != null) {
                model = (EntryUserPhotoItem)this.l0.get(this.X).getModel();
            } else {
                model = 0;
            }
        }
        return model;
    }

    static void L1(a0 a0, j j2) {
        a0.r(c.LOADING_DIALOG_FRAGMENT);
    }

    private boolean M0() {
        return this.E0;
    }

    private void M1(j j) {
        boolean successful;
        boolean obj2;
        obj2 = j.getResult();
        this.v0.updateDataSet((List)obj2);
        this.F.c(obj2);
        F();
        if (j.isSuccessful() && !obj2.isEmpty()) {
            obj2 = j.getResult();
            this.v0.updateDataSet((List)obj2);
            this.F.c(obj2);
            F();
            if (!obj2.isEmpty()) {
                obj2 = 1;
                this.m0 = obj2;
                this.z.setViewVisibility(obj2);
            }
        }
        this.h0.setValue(Boolean.TRUE);
    }

    private boolean N0() {
        return this.z0;
    }

    private void O1(j j) {
        boolean successful;
        Object obj2;
        if (j.isSuccessful()) {
            this.k0.putAll((Map)j.getResult());
        }
        this.D0 = true;
        W1();
    }

    private void O2() {
        P2(g0.c.Likes);
    }

    private void P0(boolean z) {
        Object lATEST_TAB;
        int obj3;
        this.z.setYourTabVisibility(z ^ 1);
        if (z != 0 && this.i0 == g0.c.User) {
            if (this.i0 == g0.c.User) {
                N2();
                this.z.setSelectedTabAs(b.LATEST_TAB);
            }
        }
    }

    private j<Void> Q(String string, String string2) {
        final j jVar = N(string, string2);
        i iVar = new i(this, string, string2);
        jVar.continueWithTask(iVar);
        return jVar;
    }

    private void Q0(ChallengeModel challengeModel) {
        m2 m2Var = this.D;
        m2.c cVar = m2Var.L(f.allEntries);
        cVar.c(challengeModel.getId());
        int i = 1;
        cVar.k(i);
        cVar.h(Query.Direction.DESCENDING);
        this.T = m2Var.c(cVar.a(), 10, i);
        h hVar = new h(this);
        P(challengeModel.getId()).addOnCompleteListener(hVar);
    }

    static Boolean Q1(Throwable throwable) {
        return Boolean.FALSE;
    }

    private void R1(k k, Boolean boolean2) {
        y.c cVar = new y.c(boolean2);
        this.Y = cVar;
        k.c(Boolean.TRUE);
    }

    static void T1(a a, DialogInterface dialogInterface2, int i3) {
        a.a();
    }

    private int U(ChallengeModel challengeModel) {
        int obj2;
        obj2 = challengeModel.getMediaType().equals(ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING) ? 1 : 0x7fffffff /* Unknown resource */;
        return obj2;
    }

    private j U1(String string, String string2, j j3) {
        final int obj3 = 0;
        if (!b3(string, string2)) {
            return obj3;
        }
        obj2.a.c().d((Map)j3.getResult(), false);
        return obj3;
    }

    private void W1() {
        boolean z;
        g gVar;
        if (this.D0) {
            this.U.c(Z(this.X));
        }
    }

    private g<QuerySnapshot> Z(String string) {
        b0 b0Var = new b0(this, string);
        return b0Var;
    }

    private boolean b3(String string, String string2) {
        Object challengeModel;
        int obj2;
        if (this.j0 != null && string.equals(this.G.v()) && string2.equals(this.j0.getId())) {
            if (string.equals(this.G.v())) {
                obj2 = string2.equals(this.j0.getId()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean d1() {
        return this.I0;
    }

    private void e1(String string, DocumentSnapshot documentSnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        boolean obj1;
        Object obj2;
        if (documentSnapshot2 == null) {
        }
        Object obj3 = documentSnapshot2.toObject(ChallengeModel.class);
        if ((ChallengeModel)obj3 == null) {
        }
        (ChallengeModel)obj3.setId(documentSnapshot2.getId());
        this.F.d(obj3);
        obj2 = this.j0;
        if (obj2 != null && string.equals(obj2.getId())) {
            if (string.equals(obj2.getId())) {
                this.z.setParticipatingCountries(obj3.getParticipatingCountries());
            }
        }
    }

    private boolean g1(List list, int i2) {
        Object next;
        int i;
        k kVar;
        ArrayList obj5 = new ArrayList();
        Iterator obj4 = list.iterator();
        i = 0;
        for (ChallengeComment next : obj4) {
            kVar = new k(next, i);
            obj5.add(kVar);
            i = 0;
        }
        this.A0.setValue(obj5);
        return i;
    }

    private g<QuerySnapshot> h0(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, String string2, Set<ChallengeFilterItem.FilterTypes> set3) {
        d dVar = new d(this, c, string2, set3);
        return dVar;
    }

    private void h2(a0 a0) {
        t tVar = new t(a0);
        P(this.j0.getId()).addOnCompleteListener(tVar);
        R(this.j0);
    }

    private void i1(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException2) {
        boolean obj1;
        app.dogo.com.dogo_android.a0.g.f.g0.c obj2;
        k2();
        if (querySnapshot && !querySnapshot.isEmpty() && this.i0 == g0.c.Date) {
            if (!querySnapshot.isEmpty()) {
                k2();
                if (this.i0 == g0.c.Date) {
                    r2(true);
                }
            }
        }
    }

    private void k1(a0 a0, j j2) {
        Object result;
        int i;
        i1 i1Var;
        String str2;
        c1 c1Var;
        String str;
        Intent obj8;
        a0.s();
        if (!j2.isSuccessful()) {
        }
        if (j2.getResult() != null) {
            result = new Intent("android.intent.action.SEND");
            result.setType("text/plain");
            result.putExtra("android.intent.extra.TEXT", (ShortDynamicLink)j2.getResult().getShortLink().toString());
            i1Var = new i1();
            c1Var = new c1();
            this.Q.d(t.a.c(i1Var, this.X, c1Var, this.j0.getId()));
            a0.startActivity(Intent.createChooser(result, this.O.getString(2131887330)));
        }
    }

    private void m1(a0 a0, j j2) {
        boolean successful;
        int obj3;
        a0.s();
        if (j2.isSuccessful() && j2.getResult() != null) {
            if (j2.getResult() != null) {
                a0.h0((Uri)j2.getResult(), (EntryUserPhotoItem)this.l0.values().iterator().next().getModel());
            } else {
                a0.t0(2131886123);
            }
        } else {
        }
    }

    private void m2() {
        this.I0 = false;
    }

    private void o1(j j) {
        Object obj1;
        if (this.T == null) {
            Q0(this.j0);
        }
        w2();
    }

    private Void q1(String string, String string2, j j3) {
        final int obj3 = 0;
        if (!b3(string, string2)) {
            return obj3;
        }
        obj2.a.c().d((Map)j3.getResult(), true);
        return obj3;
    }

    private void r2(boolean z) {
        this.y0 = z;
        l(117);
    }

    static ChallengeModel s1(app.dogo.com.dogo_android.a0.g.f.h0 h0, j j2) {
        h0.e((ChallengeModel)j2.getResult());
        return null;
    }

    static ChallengeModel t1(app.dogo.com.dogo_android.a0.g.f.h0 h0, j j2) {
        h0.e((ChallengeModel)j2.getResult());
        return null;
    }

    private void t2(String string) {
        this.X = string;
        this.F0 = 0;
        L0();
    }

    private float u0(float f) {
        int obj3;
        final int i = 0;
        if (Float.compare(f, i) > 0) {
        } else {
            obj3 = i;
        }
        return obj3;
    }

    static Void u1(app.dogo.com.dogo_android.a0.g.f.h0 h0, j j2) {
        boolean documentId;
        int obj3;
        final int i = 0;
        if ((List)j2.getResult().isEmpty()) {
            obj3 = i;
        } else {
            obj3 = (List)j2.getResult().get(0);
        }
        if (obj3 != null) {
            h0.g(obj3.getDocumentId());
            h0.f(obj3.getComment());
        }
        return i;
    }

    private void u2() {
        this.I0 = true;
    }

    private app.dogo.com.dogo_android.a0.g.f.h0 v1(Uri uri, app.dogo.com.dogo_android.a0.g.f.h0 h02, j j3) {
        U2(uri);
        return h02;
    }

    private void v2() {
        boolean z;
        z = this.G0;
        if (!W2() && z != null) {
            z = this.G0;
            if (z != null) {
                z.cancel();
            }
        }
    }

    static x w(app.dogo.com.dogo_android.a0.g.f.g0 g0) {
        return g0.Z;
    }

    private void w2() {
        int equals;
        Object sINGLE_ENTRY_NEVER_ENDING;
        if (this.j0.isHasEnded(this.L)) {
            this.Z.setValue(Boolean.TRUE);
            equals = 0;
            D2(equals);
            E2(equals);
            O2();
        } else {
            D2(true);
            E2(this.j0.getMediaType().equals(ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING));
            N2();
        }
        this.z.setParticipatingCountries(this.j0.getParticipatingCountries());
        R(this.j0);
    }

    private j x1(String string, String string2, j j3) {
        return Y2(string, string2);
    }

    private void y2() {
        Object iterator;
        boolean empty;
        boolean mVar;
        String str;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        iterator = this.l0.values().iterator();
        if (!this.l0.isEmpty() && iterator.hasNext()) {
            iterator = this.l0.values().iterator();
            if (iterator.hasNext()) {
                Object next = iterator.next();
                this.X = (EntryUserPhotoItem)next.getModel().getDocumentId();
                arrayList.add(next);
                m mVar2 = new m(next.getModel());
                arrayList.add(mVar2);
                String documentId3 = next.getModel().getDocumentId();
                this.U = this.D.b(documentId3, 25, 0);
                y(this.L.g());
                mVar = new m(this);
                this.D.u(next.getModel().getDocumentId(), this.G.v()).addOnCompleteListener(mVar);
            }
            this.g0.setValue(arrayList);
        }
    }

    private void z1(String string, QuerySnapshot querySnapshot2) {
        app.dogo.com.dogo_android.a0.g.f.g0.c arrayList;
        Object tRUE;
        ChallengeComment next;
        boolean published;
        String str;
        String str2;
        boolean obj7;
        if (this.i0 == g0.c.User && string != null && string.equals(this.X) && querySnapshot2 != null) {
            if (string != null) {
                if (string.equals(this.X)) {
                    if (querySnapshot2 != null) {
                        arrayList = new ArrayList();
                        tRUE = querySnapshot2.getDocuments().iterator();
                        while (tRUE.hasNext()) {
                            next = this.D.h0((DocumentSnapshot)tRUE.next(), this.G.v(), string, W().getId());
                            if (!next.isPublished()) {
                            } else {
                            }
                            if (!this.D.P(next, this.G.v(), this.G.C())) {
                            }
                            next.setHasUserLiked(this.k0.containsKey(next.getDocumentId()));
                            published = new k(next, 0);
                            arrayList.add(published);
                            if (next.isSpam() && !this.D.P(next, this.G.v(), this.G.C())) {
                            }
                        }
                        if (this.U.e() && !M0()) {
                            if (!M0()) {
                                this.E0 = true;
                                this.B0.setValue(Boolean.TRUE);
                            }
                        }
                        this.e0.setValue(arrayList);
                        if (arrayList.isEmpty() && !querySnapshot2.isEmpty()) {
                            if (!querySnapshot2.isEmpty()) {
                                X1();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void A(a0 a0) {
        boolean empty;
        String documentId;
        app.dogo.com.dogo_android.a0.g.f.g gVar;
        String tag;
        if (!this.l0.isEmpty() && this.X == null) {
            if (this.X == null) {
                this.X = (EntryUserPhotoItem)this.l0.values().iterator().next().getModel().getDocumentId();
            }
            if (a0 == null) {
                Throwable obj5 = new Throwable("Couldn't find navigator");
                a.d(obj5);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.X);
            stringBuilder.append(".jpg");
            Uri uri = this.H.h("challenge_successful", stringBuilder.toString());
            if (uri == null) {
            }
            a0.m();
            if (!this.L.o(a.INSTAGRAM_PACKAGE_NAME.getTag())) {
                x xVar = new x(this, a0);
                this.N.d("sharing_challenge_photo", (EntryUserPhotoItem)this.l0.values().iterator().next().getModel(), this.F.a(this.j0.getId())).addOnCompleteListener(xVar);
            }
            t2 t2Var2 = this.H;
            gVar = new g(this, a0);
            t2Var2.a(t2Var2.f(uri)).addOnCompleteListener(gVar);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public SponsorBannerItem A0() {
        return this.A;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void A1(String string, QuerySnapshot querySnapshot2) {
        z1(string, querySnapshot2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void A2() {
        if (this.i0 == g0.c.User) {
            y2();
        } else {
            X1();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B(a0 a0) {
        ChallengeModel bundle;
        Object cHALLENGE_FILTER_DIALOG_FRAGMENT;
        String str;
        if (this.j0 != null && S0(z0(), this.j0)) {
            if (S0(z0(), this.j0)) {
                bundle = new Bundle();
                bundle.putSerializable("currentFilters", (HashMap)this.x0.getFilters());
                bundle.putSerializable("possibleFilters", (HashSet)v0(z0(), this.j0));
                a0.k(c.CHALLENGE_FILTER_DIALOG_FRAGMENT, bundle);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public j B0(String string, String string2) {
        return l1.a(this.P, string, string2, false, 0, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B2() {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3 = 0;
        if (!b1() && this.P.B()) {
            i = this.P.B() ? i2 : i3;
        } else {
        }
        if (i == 0 && this.P.u()) {
            if (this.P.u()) {
            } else {
                i2 = i3;
            }
        } else {
        }
        InviteFriendsBannerItem inviteFriendsBannerItem = new InviteFriendsBannerItem("inviteFriendsCell", i2);
        this.B = inviteFriendsBannerItem;
        BecomePremiumBannerItem becomePremiumBannerItem = new BecomePremiumBannerItem("becomePremiumCell", i);
        this.C = becomePremiumBannerItem;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C(ChallengeModel challengeModel) {
        Object hashMap;
        Object hashSet;
        ChallengeModel challengeModel2;
        Object obj4;
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
                hashMap = new HashMap();
                hashSet = new HashSet();
                this.x0.setFilters(hashMap, hashSet);
            } else {
                this.x0.setFilters(this.I.k(this.j0.getId(), challengeModel.getDefaultFilters()), v0(z0(), W()));
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
    public void C1(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, String string2, Set set3, QuerySnapshot querySnapshot4) {
        B1(c, string2, set3, querySnapshot4);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C2() {
        ChallengeTitleItem challengeTitleItem = new ChallengeTitleItem();
        this.w0 = challengeTitleItem;
        c0 c0Var = new c0(this);
        EntrySortingTabItem entrySortingTabItem = new EntrySortingTabItem("sortingCell", c0Var);
        this.z = entrySortingTabItem;
        SponsorBannerItem sponsorBannerItem = new SponsorBannerItem("sponsorCell");
        this.A = sponsorBannerItem;
        EntryFilterItem entryFilterItem = new EntryFilterItem("filterCell");
        this.x0 = entryFilterItem;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void D(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c) {
        this.i0 = c;
        ListenerRegistration obj1 = this.q0;
        if (obj1 != null) {
            obj1.remove();
        }
        p2(false);
        l(46);
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
        D(g0.c.User);
        k2();
        J(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void E1(QuerySnapshot querySnapshot) {
        D1(querySnapshot);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void F() {
        Object obj;
        EntryTitleItem entryTitleItem;
        obj = this.H0;
        if (obj != null) {
            this.v0.checkAndSelectIfExists(obj);
        } else {
            obj = this.u0;
            if (obj != null) {
                this.v0.checkAndSelectIfExists(obj);
            }
        }
        int i = 0;
        this.H0 = i;
        this.u0 = i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String F0() {
        return this.X;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void F2(View view, a0 a02) {
        super("titleCell", view, a02, this.Q, this);
        this.v0 = entryTitleItem2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean G() {
        ChallengeModel hasEnded;
        int i;
        boolean z;
        hasEnded = this.j0;
        i = 0;
        if (hasEnded != null && !this.t0 && hasEnded.isHasEnded(this.L)) {
            if (!this.t0) {
                if (hasEnded.isHasEnded(this.L)) {
                    this.j0.setHasEnded(true);
                    this.v0.refreshItem(this.j0);
                    this.v0.updateView();
                    K();
                    h();
                    v(2131886293);
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String G0() {
        String comment;
        if (L0() != null) {
            comment = L0().getComment();
        } else {
            comment = 0;
        }
        return comment;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void G1(String string, String string2, QuerySnapshot querySnapshot3, FirebaseFirestoreException firebaseFirestoreException4) {
        F1(string, string2, querySnapshot3, firebaseFirestoreException4);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean G2(Bundle bundle) {
        boolean key;
        boolean obj2;
        if (bundle != null && bundle.containsKey("challengeId") && bundle.containsKey("uploadDogId") && bundle.containsKey("uploadPhoto")) {
            if (bundle.containsKey("challengeId")) {
                if (bundle.containsKey("uploadDogId")) {
                    obj2 = bundle.containsKey("uploadPhoto") ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void H() {
        this.l0.clear();
        int i = 0;
        this.X = i;
        this.F0 = i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String H0() {
        String documentId;
        if (L0() != null) {
            documentId = L0().getDocumentId();
        } else {
            documentId = this.X;
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean H2(ChallengeComment challengeComment) {
        String equals;
        int obj3;
        if (!Objects.equals(challengeComment.getUserId(), this.G.v())) {
            if (challengeComment.isEntryAuthor(this.G.v())) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void I() {
        int i;
        app.dogo.com.dogo_android.w.t2 t2Var;
        HashSet hashSet;
        if (this.x0.isFilterLisEmpty()) {
            b2(4);
        } else {
            HashMap hashMap = new HashMap();
            hashSet = new HashSet();
            this.x0.setFilters(hashMap, hashSet);
            g2();
            this.Q.c(u.j);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void I1(j j) {
        H1(j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void I2(a0 a0, ChallengeModel challengeModel2, boolean z3, boolean z4, boolean z5) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("challenge", challengeModel2);
        bundle.putBoolean("show_checkbox", z3);
        bundle.putBoolean("show_prize", z4);
        bundle.putBoolean("show_rules", z5);
        bundle.putBoolean("is_user_over_limit", obj4 ^= 1);
        bundle.putInt("style", 2131951968);
        a0.k(c.CHALLENGE_DETAILS_DIALOG, bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void J(boolean z) {
        int tRUE;
        x obj2;
        tRUE = 0;
        this.z0 = tRUE;
        this.E0 = tRUE;
        if (z != null) {
            o0().setValue(Boolean.TRUE);
        }
        this.n0.clear();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public ChallengeEntryModel J0() {
        Map empty;
        int model;
        empty = this.l0;
        if (empty != null && !empty.isEmpty()) {
            if (!empty.isEmpty()) {
                model = (EntryUserPhotoItem)this.l0.values().iterator().next().getModel();
            } else {
                model = 0;
            }
        } else {
        }
        return model;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void J2() {
        this.x0.show();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void K() {
        this.t0 = this.j0.isHasEnded(this.L);
        H();
        j jVar2 = new j(this);
        P(this.j0.getId()).addOnCompleteListener(jVar2);
    }

    public x<List<f>> K0() {
        Object value;
        ArrayList arrayList;
        if (this.g0.getValue() == null) {
            arrayList = new ArrayList();
            this.g0.setValue(arrayList);
        }
        return this.g0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void K1(Boolean boolean) {
        J1(boolean);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void K2(Context context, a a2) {
        b bVar = new b(context);
        f fVar = new f(a2);
        bVar.w(2131886953).D(2131886562, fVar).y(2131886677, 0).o();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void L() {
        ListenerRegistration list = this.q0;
        if (list != null) {
            list.remove();
        }
        this.C0 = this.L.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void L2(a0 a0) {
        boolean z;
        final q2.a pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (this.K.j(pHOTO_LIKE.getTag())) {
            this.K.a(a0, pHOTO_LIKE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public float M(boolean z) {
        ChallengeModel height;
        int obj4;
        float f2 = u0((float)position);
        float height2 = y0().getHeight();
        if (W() != null && z) {
            if (z) {
                obj4 = (float)obj4;
                height = A0().getHeight();
                obj4 += height;
            } else {
                if (m0().isVisible()) {
                    obj4 = (float)obj4;
                    height = m0().getHeight();
                } else {
                    obj4 = f2 + height2;
                }
            }
        } else {
        }
        f2 += height2;
        if (Float.compare(obj4, i) < 0) {
            return i;
        }
        return obj4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void M2(a0 a0) {
        boolean z;
        final q2.a pHOTO_LIKE = q2.a.PHOTO_LIKE;
        if (this.K.k(pHOTO_LIKE.getTag())) {
            this.K.u(a0, pHOTO_LIKE);
        }
    }

    public j<Void> N(String string, String string2) {
        l lVar = new l(this, string, string2);
        return this.D.B(string, string2, true).continueWith(lVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void N1(j j) {
        M1(j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void N2() {
        D(g0.c.Date);
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

    public j<app.dogo.com.dogo_android.a0.g.f.h0> O(Bundle bundle) {
        Object liteDogProfile2;
        j continueWith;
        Object liteDogProfile;
        Object eVar;
        h0 h0Var = new h0();
        String string = bundle.getString("challengeId");
        liteDogProfile2 = bundle.getString("uploadDogId");
        ChallengeModel challengeModel = this.F.a(string);
        liteDogProfile = this.E.A().l(liteDogProfile2, this.G.v());
        if (challengeModel != null) {
            eVar = new e(h0Var);
            continueWith = m.e(challengeModel).continueWith(eVar);
        } else {
            eVar = new n(h0Var);
            continueWith = this.D.s(string, n2.a.ENGLISH.getLocaleTag()).continueWith(eVar);
        }
        if (liteDogProfile != null) {
            liteDogProfile2 = new LiteDogProfile(liteDogProfile);
            h0Var.h(liteDogProfile2);
        } else {
            eVar = 0;
            liteDogProfile = new LiteDogProfile(eVar, eVar, liteDogProfile2);
            h0Var.h(liteDogProfile);
        }
        y yVar = new y(h0Var);
        j[] arr = new j[2];
        u uVar = new u(this, (Uri)bundle.getParcelable("uploadPhoto"), h0Var);
        return m.g(continueWith, this.D.y(this.G.v(), string).continueWith(yVar)).continueWith(uVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void O0() {
        this.x0.hide();
    }

    public j<Void> P(String string) {
        return Q(this.G.v(), string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void P1(j j) {
        O1(j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void P2(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c) {
        D(c);
        if (S0(this.i0, this.j0)) {
            J2();
        } else {
            O0();
        }
        k2();
        this.x2(this.i0, this.j0, hasEnded ^ 1, this.x0.getFilters(), this.I.p());
        J(true);
        this.x0.refreshCell(v0(z0(), this.j0));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Q2(a0 a0) {
        int str;
        if (this.G.D()) {
            R2(a0, false);
        } else {
            a0.R("challenges_entry");
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void R(ChallengeModel challengeModel) {
        ListenerRegistration list = this.p0;
        if (list != null) {
            list.remove();
            m2();
        }
        this.l0.clear();
        this.V.o();
        this.p0 = this.D.z(this.G.v(), challengeModel.getId(), I0(this.G.v(), challengeModel.getId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean R0() {
        return this.G.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void R2(a0 a0, boolean z2) {
        int str;
        String str2;
        int i;
        DogProfileModel model;
        String str3;
        boolean obj6;
        if (E(a0, z2) && o.WELCOME_CHALLENGE.getId().equals(this.j0.getId()) && J0() != null) {
            if (o.WELCOME_CHALLENGE.getId().equals(this.j0.getId())) {
                if (J0() != null) {
                    v(2131886307);
                }
                str2 = 0;
                if (b0() != null) {
                    obj6 = this.H.h(b0().getId(), "avatar.jpg");
                } else {
                    obj6 = str2;
                }
                if (T0(obj6)) {
                    U2(obj6);
                    LiteDogProfile liteDogProfile = new LiteDogProfile(b0());
                    a0.n0(this.j0, liteDogProfile, str2, str2);
                }
            }
            str = 0;
            i = 800;
            if (J0() != null) {
                this.s0 = J0().getLiteDogProfile();
                a0.B0(str, i, i);
            }
            if (this.E.A().j() == 1) {
                obj6 = new LiteDogProfile(this.E.A().g().toModel(this.G.v()));
                this.s0 = obj6;
                a0.B0(str, i, i);
            } else {
                a0.l0("challenge_image_dog_select_request", "challenge_home");
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public BecomePremiumBannerItem S() {
        return this.C;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean S0(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, ChallengeModel challengeModel2) {
        return obj1 ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void S1(k k, Boolean boolean2) {
        R1(k, boolean2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void S2() {
        boolean z;
        if (this.K0) {
            z(this.L0);
            this.K0 = false;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int T() {
        int i2;
        int i;
        boolean z = this.J.a();
        if (!z) {
            v(2131886953);
        }
        i2 = z ? 8 : 0;
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean T0(Uri uri) {
        int i;
        int[] obj5;
        obj5 = this.H.e(uri);
        final int i3 = 1;
        final int i4 = 800;
        if (obj5[0] >= i4 && obj5[i3] >= i4) {
            if (obj5[i3] >= i4) {
                i = i3;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void T2() {
        boolean z;
        if (this.J0) {
            k2();
            this.K0 = true;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean U0(String string) {
        Uri uri = this.H.h(string, "avatar.jpg");
        if (string != null && uri == null) {
            if (uri == null) {
            }
            return T0(uri);
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean U2(Uri uri) {
        if (uri == null) {
            return 0;
        }
        return this.H.j("entryTemp", uri, "entry.jpg");
    }

    public x<Boolean> V() {
        return this.h0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean V0() {
        ChallengeModel hasEnded;
        int i;
        v2 v2Var;
        hasEnded = this.j0;
        if (hasEnded != null && !hasEnded.isHasEnded(this.L)) {
            i = !hasEnded.isHasEnded(this.L) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public j V1(String string, String string2, j j3) {
        return U1(string, string2, j3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void V2() {
        app.dogo.com.dogo_android.a0.g.f.g0.c cVar;
        Object likes;
        cVar = this.i0;
        if (cVar != g0.c.Likes) {
            if (cVar == g0.c.Date && S0(z0(), this.j0)) {
                if (S0(z0(), this.j0)) {
                    J2();
                } else {
                    O0();
                }
            } else {
            }
        } else {
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
            return 0;
        }
        CountDownTimer g0 = this.G0;
        if (g0 != null) {
            g0.cancel();
        }
        super(this, 3000, obj4, 3000, obj6);
        this.G0 = aVar.start();
        return 1;
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
        Object cVar;
        Object user;
        String str;
        HashSet hashSet;
        Set keySet;
        l(27);
        cVar = this.i0;
        if (cVar == g0.c.User) {
            W1();
        } else {
            user = this.T;
            if (user != null) {
                hashSet = new HashSet(this.x0.getFilters().keySet());
                user.c(h0(cVar, this.j0.getId(), hashSet));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void X2(ChallengeEntryModel challengeEntryModel, a0 a02) {
        l(27);
        L2(a02);
        M2(a02);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int Y() {
        app.dogo.com.dogo_android.a0.g.f.g0.c cVar;
        int i;
        if (this.i0 == g0.c.User && this.W) {
            i = this.W ? 0 : 8;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean Y0(ChallengeComment challengeComment) {
        return challengeComment.isEntryAuthor(this.G.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Y1(String string) {
        boolean key;
        t2 t2Var;
        String str;
        Object obj4;
        if (this.l0.containsKey(string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".jpg");
            (EntryUserPhotoItem)this.l0.get(string).setUploadFail(this.H.c("challenge_failed", stringBuilder.toString()));
            e2();
        }
    }

    public j<Void> Y2(String string, String string2) {
        k kVar = new k(this, string, string2);
        return this.D.B(string, string2, false).continueWithTask(kVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean Z0() {
        int i;
        int i2;
        ChallengeEntryModel challengeEntryModel = J0();
        i = 1;
        if (challengeEntryModel == null) {
            return i;
        }
        int i3 = 0;
        i2 = Long.compare(timeLeftInMillis, timeTillAdditionalUploadInMillis) > 0 ? i : i3;
        if (!this.j0.getMediaType().equals(ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING) && challengeEntryModel.isUploadStatusReadyToUpload(this.L.g()) && i2 != 0) {
            if (challengeEntryModel.isUploadStatusReadyToUpload(this.L.g())) {
                if (i2 != 0) {
                } else {
                    i = i3;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void Z1(ChallengeModel challengeModel, a0 a02, int i3) {
        Object obj;
        a0 a0Var;
        ChallengeModel challengeModel2;
        int i;
        int i4;
        int i2;
        Object obj8;
        Object obj9;
        if (this.j0 == challengeModel) {
            this.I2(a02, challengeModel, true, false, false);
        } else {
            this.v0.setPosition(i3);
            this.Q.c(u.A);
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
    public void a2(ChallengeComment challengeComment, String string2) {
        m2 obj10;
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        this.Q.d(u.e.c(i1Var, challengeComment.getDocumentId(), c1Var, challengeComment.getChallengeId(), r2Var, y.commentSourceParser(string2)));
        if (H2(challengeComment)) {
            this.D.h(challengeComment);
        } else {
            this.D.O(challengeComment);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean a3(String string, ChallengeComment challengeComment2, a0 a03) {
        super(this.G.v(), string, F0(), b0(), W().getId(), this.G.v());
        challengeComment3.setBadges(this.D.a(b0().getId(), b1()));
        if (challengeComment2 != null) {
            challengeComment3.setReplyTarget(challengeComment2);
        }
        int obj10 = 0;
        if (challengeComment3.getDogName() != null) {
            this.D.D0(challengeComment3);
            ArrayList obj9 = new ArrayList();
            k obj11 = new k(challengeComment3, obj10);
            obj9.add(obj11);
            this.A0.setValue(obj9);
            i1 i1Var = new i1();
            c1 c1Var = new c1();
            r2 r2Var = new r2();
            this.Q.d(u.d.c(i1Var, F0(), c1Var, W().getId(), r2Var, y.commentSourceParser(this.w.getTag())));
            obj9 = new Bundle();
            obj9.putString("id", F0());
            j(h.MESSAGE_ACTION_NEW_COMMENT_POSTED, obj9);
            return 1;
        }
        a03.w0(this.E.A().n(), 11100);
        a03.t0(2131886415);
        return obj10;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public DogProfileModel b0() {
        return this.E.A().g().toModel(this.G.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean b1() {
        y booleanValue;
        int i;
        booleanValue = this.Y;
        if (booleanValue instanceof y.c && (Boolean)(y.c)booleanValue.a().booleanValue()) {
            i = (Boolean)(y.c)booleanValue.a().booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void b2(int i) {
        int i6;
        Boolean tRUE;
        int i5;
        int i2;
        int i3;
        int i4;
        Integer valueOf;
        x obj3;
        l(27);
        if (i == 4) {
            this.b0.setValue(0);
        }
        if (i == 1 && this.i0 != g0.c.Date) {
            if (this.i0 != g0.c.Date) {
                N2();
                this.a0.setValue(Boolean.TRUE);
                L();
            } else {
                if (i == 0 && this.i0 != g0.c.Likes) {
                    if (this.i0 != g0.c.Likes) {
                        O2();
                        this.a0.setValue(Boolean.TRUE);
                        L();
                    } else {
                        if (i == 2 && this.i0 != g0.c.User) {
                            if (this.i0 != g0.c.User) {
                                O0();
                                this.a0.setValue(Boolean.TRUE);
                                E0();
                                this.x0.refreshCell(v0(z0(), this.j0));
                            } else {
                                valueOf = g0.c.Hour_24;
                                if (i == 6 && this.i0 != valueOf) {
                                    valueOf = g0.c.Hour_24;
                                    if (this.i0 != valueOf) {
                                        O0();
                                        P2(valueOf);
                                        this.a0.setValue(Boolean.TRUE);
                                        L();
                                    } else {
                                        valueOf = g0.c.Days_7;
                                        if (i == 5 && this.i0 != valueOf) {
                                            valueOf = g0.c.Days_7;
                                            if (this.i0 != valueOf) {
                                                O0();
                                                P2(valueOf);
                                                this.a0.setValue(Boolean.TRUE);
                                                L();
                                            } else {
                                                tRUE = g0.c.Country;
                                                if (i == 7 && this.i0 != tRUE) {
                                                    tRUE = g0.c.Country;
                                                    if (this.i0 != tRUE) {
                                                        O0();
                                                        P2(tRUE);
                                                        this.a0.setValue(Boolean.TRUE);
                                                        L();
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Calendar c0() {
        return Calendar.getInstance();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean c1() {
        Map empty;
        int i3;
        int i2;
        long longValue;
        long i;
        long longValue2;
        long l;
        empty = this.l0;
        i3 = 1;
        if (empty != null) {
            if (empty.isEmpty()) {
            } else {
                i2 = 0;
                if (J0().getDate() == null) {
                    return i2;
                }
                longValue3 += l;
                if (Long.compare(longValue, longValue2) > 0) {
                } else {
                    i3 = i2;
                }
            }
        }
        return i3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void c2(RecyclerView recyclerView) {
        Object challengeModel;
        o3 obj2;
        if (this.j0 != null) {
            j0();
            recyclerView.q1(1);
            this.Q.c(u.s);
        }
        r2(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean c3() {
        return this.m0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public a d0() {
        return this.V;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void d2() {
        Object cVar;
        int i = 0;
        r2(i);
        if (this.i0 == g0.c.Date) {
            z(c0());
        }
        J(i);
        l(27);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Uri e0(String string) {
        return this.H.h(string, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void e2() {
        y2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public int f0() {
        return this.E.A().j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void f1(String string, DocumentSnapshot documentSnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        e1(string, documentSnapshot2, firebaseFirestoreException3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void f2() {
        boolean z;
        Object tRUE;
        this.V.u(J0(), this.L.g());
        v2();
        if (!Z0()) {
            this.Z.setValue(Boolean.TRUE);
        }
    }

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
    public boolean h1(List list, int i2) {
        return g1(list, i2);
    }

    public x<List<f>> i0() {
        Object value;
        ArrayList arrayList;
        if (this.e0.getValue() == null) {
            arrayList = new ArrayList();
            this.e0.setValue(arrayList);
        }
        return this.e0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void i2() {
        o oVar = new o(this);
        this.D.n(this.I.W(), this.P.v(), this.G.C()).addOnCompleteListener(oVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void j0() {
        r2(false);
        w wVar = new w(this);
        this.T.a(wVar);
        z(c0());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void j1(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException2) {
        i1(querySnapshot, firebaseFirestoreException2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void j2() {
        ListenerRegistration list;
        list = this.r0;
        if (list != null) {
            list.remove();
            this.r0 = 0;
        }
    }

    public x<Boolean> k0() {
        return this.Z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void k2() {
        boolean z;
        final int i = 0;
        if (this.J0) {
            this.o0.remove();
            this.J0 = i;
        }
        r2(i);
    }

    public x<Boolean> l0() {
        return this.a0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void l1(a0 a0, j j2) {
        k1(a0, j2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void l2() {
        final m2.b bVar = this.T;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void m(int i, int i2, Intent intent3, a0 a04) {
        int obj1;
        int obj2;
        super.m(i, i2, intent3, a04);
        a04.j(c.LOADING_DIALOG_FRAGMENT);
        if (i == 10000 && i2 == -1 && this.j0 != null) {
            if (i2 == -1) {
                a04.j(c.LOADING_DIALOG_FRAGMENT);
                if (this.j0 != null) {
                    h2(a04);
                }
                if (!this.G.D()) {
                    this.Q.c(p.b);
                }
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
        ListenerRegistration list = this.o0;
        if (list != null) {
            list.remove();
        }
        ListenerRegistration list2 = this.p0;
        if (list2 != null) {
            list2.remove();
            m2();
        }
        ListenerRegistration list3 = this.q0;
        if (list3 != null) {
            list3.remove();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public InviteFriendsBannerItem n0() {
        return this.B;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n1(a0 a0, j j2) {
        m1(a0, j2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void n2(String string) {
        this.s0 = r0(string);
    }

    public x<Boolean> o0() {
        return this.c0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void o2(Bundle bundle) {
        String str;
        String obj2;
        if (bundle != null) {
            this.H0 = bundle.getString("challengeId");
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    protected void onCleared() {
        super.onCleared();
        this.S.d();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void p(Bundle bundle) {
        String str;
        ChallengeModel obj2;
        if (bundle != null) {
            this.s0 = (LiteDogProfile)bundle.getParcelable("selected_profile");
            this.j0 = (ChallengeModel)bundle.getParcelable("challenge_model");
            this.F0 = (ChallengeEntryModel)bundle.getParcelable("userEntryToUpload");
            this.u0 = this.j0;
        }
    }

    public LiveData<Boolean> p0() {
        return this.d0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void p1(j j) {
        o1(j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void p2(boolean z) {
        boolean obj2;
        if (this.W != z) {
            this.W = z;
            l(46);
        }
    }

    public x<Integer> q0() {
        return this.b0;
    }

    public void q2(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        this.x0.setFilters(map, v0(z0(), this.j0));
        g2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Bundle r() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selected_profile", this.s0);
        bundle.putParcelable("challenge_model", this.j0);
        bundle.putParcelable("userEntryToUpload", L0());
        return bundle;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiteDogProfile r0(String string) {
        LiteDogProfile liteDogProfile;
        final DogProfileModel obj3 = this.E.A().l(string, this.G.v());
        if (obj3 != null) {
            liteDogProfile = new LiteDogProfile(obj3);
        } else {
            liteDogProfile = 0;
        }
        return liteDogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public Void r1(String string, String string2, j j3) {
        return q1(string, string2, j3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void s() {
        super.s();
        S2();
        final ChallengeModel challengeModel = this.j0;
        if (challengeModel != null) {
            R(challengeModel);
        }
    }

    public LiveData<List<f>> s0() {
        return this.A0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void s2(b b) {
        y0().setSelectedTabAs(b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void t() {
        super.t();
        T2();
        final ListenerRegistration list = this.p0;
        if (list != null) {
            list.remove();
            m2();
        }
        L();
    }

    public x<List<f>> t0() {
        Object value;
        ArrayList arrayList;
        if (this.f0.getValue() == null) {
            arrayList = new ArrayList();
            this.f0.setValue(arrayList);
        }
        return this.f0;
    }

    public Set<ChallengeFilterItem.FilterTypes> v0(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, ChallengeModel challengeModel2) {
        boolean empty;
        ChallengeFilterItem.FilterTypes obj3;
        int obj4;
        Set possibleFilters = this.x0.getPossibleFilters();
        if (!possibleFilters.isEmpty() && c != null) {
            if (c != null) {
                obj3 = g0.b.a[c.ordinal()];
                if (obj3 != 1) {
                    if (obj3 != 2) {
                        possibleFilters.clear();
                    } else {
                        possibleFilters.remove(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
                    }
                } else {
                    if (challengeModel2.isHasEnded(this.L)) {
                        possibleFilters.remove(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
                    }
                }
            }
        }
        return possibleFilters;
    }

    public a<List<String>> w0() {
        return this.D.M();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public app.dogo.com.dogo_android.a0.g.f.h0 w1(Uri uri, app.dogo.com.dogo_android.a0.g.f.h0 h02, j j3) {
        v1(uri, h02, j3);
        return h02;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void x() {
        j2();
        ChallengeModel challengeModel = this.j0;
        if (challengeModel == null) {
        }
        z zVar = new z(this, challengeModel.getId());
        this.r0 = this.D.K(f.localisedChallenges.forLocale(n2.e(Locale.getDefault().getLanguage())).forChallengeId(this.j0.getId())).addSnapshotListener(zVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public LiteDogProfile x0() {
        return this.s0;
    }

    public void x2(app.dogo.com.dogo_android.a0.g.f.g0.c g0$c, ChallengeModel challengeModel2, int i3, Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map4, String string5) {
        app.dogo.com.dogo_android.a0.g.f.g0.c country;
        Object dESCENDING;
        m2.c cVar;
        f allEntries;
        country = g0.c.Hour_24;
        if (c == country) {
            cVar = this.D.L(f.latestEntries_24);
        } else {
            if (c == g0.c.Days_7) {
                cVar = this.D.L(f.latestEntries_168);
            } else {
                if (c == g0.c.Country) {
                    cVar = this.D.L(f.allEntries);
                } else {
                    cVar = this.D.L(f.allEntries);
                }
            }
        }
        if (c != g0.c.Likes && c != country && c != g0.c.Days_7) {
            if (c != country) {
                if (c != g0.c.Days_7) {
                    if (c == g0.c.Country) {
                        cVar.h(Query.Direction.DESCENDING);
                        cVar.g(Query.Direction.ASCENDING);
                    } else {
                        if (c == g0.c.Date) {
                            cVar.g(Query.Direction.DESCENDING);
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (map4.containsKey(ChallengeFilterItem.FilterTypes.FEATURED)) {
            cVar.j();
        }
        if (c == g0.c.Country && string5 != null) {
            if (string5 != null) {
                cVar.i(string5);
            }
        }
        cVar.c(challengeModel2.getId());
        cVar.k(true);
        this.T.h(cVar.a(), 10, i3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void y(long l) {
        app.dogo.com.dogo_android.a0.g.f.g0.c empty;
        Object user;
        String str2;
        String str4;
        boolean z;
        String str;
        String str3;
        int i;
        app.dogo.com.dogo_android.a0.g.f.s sVar;
        int obj11;
        empty = this.X;
        if (this.i0 == g0.c.User && Long.compare(l, i2) != 0 && empty != null && !empty.isEmpty()) {
            if (Long.compare(l, i2) != 0) {
                empty = this.X;
                if (empty != null) {
                    if (!empty.isEmpty()) {
                        L();
                        sVar = new s(this);
                        this.q0 = this.D.d(this.G.v(), this.X, this.G.C(), this.G.v(), W().getId(), l, obj8);
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public EntrySortingTabItem y0() {
        return this.z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public j y1(String string, String string2, j j3) {
        return x1(string, string2, j3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void z(Calendar calendar) {
        if (this.J0) {
            k2();
        }
        this.L0 = calendar;
        m2.c obj5 = this.D.L(f.allEntries);
        obj5.c(this.j0.getId());
        int i = 1;
        obj5.k(i);
        obj5.f(calendar.getTime());
        obj5.g(Query.Direction.DESCENDING);
        if (this.x0.getFilters().containsKey(ChallengeFilterItem.FilterTypes.FEATURED)) {
            obj5.j();
        }
        obj5.d(1);
        v vVar = new v(this);
        this.o0 = obj5.a().addSnapshotListener(vVar);
        this.J0 = i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public app.dogo.com.dogo_android.a0.g.f.g0.c z0() {
        return this.i0;
    }

    public j<Boolean> z2() {
        k kVar = new k();
        this.Y = y.b.a;
        r rVar = new r(this, kVar);
        this.S.b(this.R.q().observeOn(a.b()).subscribeOn(a.b()).onErrorReturn(p.a).subscribe(rVar));
        return kVar.a();
    }
}
