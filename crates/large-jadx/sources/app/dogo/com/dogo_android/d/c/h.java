package app.dogo.com.dogo_android.d.c;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.c.j.a;
import app.dogo.com.dogo_android.d.c.j.b;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.b0;
import app.dogo.com.dogo_android.util.e0.s;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentChange.Type;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\r\u0018\u0000 >2\u00020\u0001:\u0002>?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020.J\u000e\u00105\u001a\u0002032\u0006\u0010#\u001a\u00020\"J\u0006\u00106\u001a\u000203J\u000e\u00107\u001a\u0002032\u0006\u00108\u001a\u00020.J\u0006\u00109\u001a\u000203J\u0016\u0010:\u001a\u0002032\u0006\u00108\u001a\u00020.2\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R!\u0010&\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u000fR!\u0010*\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u000fR\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020.0-j\u0008\u0012\u0004\u0012\u00020.`/X\u0082\u0004¢\u0006\u0002\n\u0000R!\u00100\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "currentPageLimit", "", "emptyListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getEmptyListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "endOfListNotifier", "getEndOfListNotifier", "firestoreListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "followedChallengeNotificationEventListener", "Lcom/google/firebase/firestore/EventListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "getFollowedChallengeNotificationEventListener", "()Lcom/google/firebase/firestore/EventListener;", "freshPageFetched", "getFreshPageFetched", "()Z", "setFreshPageFetched", "(Z)V", "isClickDebounced", "lastClickTime", "", "<set-?>", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "listType", "getListType", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "modifiedItemLiveData", "", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "getModifiedItemLiveData", "newItemLiveData", "getNewItemLiveData", "notificationInProcessingList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "removedItemLiveData", "getRemovedItemLiveData", "addToTemporaryIgnoreList", "", "notificationId", "changeListType", "fetchNewPage", "markNotificationAsViewed", "itemId", "removeFirestoreListener", "updateFollowState", "followState", "updateListEmptynesState", "state", "Companion", "ListType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends s {

    public static final app.dogo.com.dogo_android.d.c.h.a Companion;
    private final m2 a;
    private final h2 b;
    private final v2 c;
    private app.dogo.com.dogo_android.d.c.h.b d;
    private final x<List<b0<?>>> e;
    private final x<List<b0<?>>> f;
    private final x<List<b0<?>>> g;
    private final x<Boolean> h;
    private final x<Boolean> i;
    private ListenerRegistration j;
    private int k;
    private boolean l;
    private long m;
    private final ArrayList<String> n;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$Companion;", "", "()V", "DEBOUNCE_TIME", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "", "stringRes", "", "(Ljava/lang/String;II)V", "getStringRes", "()I", "FOLLOWED", "UNFOLLOWED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        FOLLOWED(2131886973),
        UNFOLLOWED(2131886973);

        private final int stringRes;
        private static final app.dogo.com.dogo_android.d.c.h.b[] $values() {
            app.dogo.com.dogo_android.d.c.h.b[] arr = new h.b[2];
            return arr;
        }

        @Override // java.lang.Enum
        public final int getStringRes() {
            return this.stringRes;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class c {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            iArr[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            iArr[DocumentChange.Type.REMOVED.ordinal()] = 3;
            h.c.a = iArr;
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.Companion = aVar;
    }

    public h(m2 m2, h2 h22, v2 v23) {
        n.f(m2, "firestoreService");
        n.f(h22, "authService");
        n.f(v23, "utilities");
        super();
        this.a = m2;
        this.b = h22;
        this.c = v23;
        this.d = h.b.FOLLOWED;
        x obj2 = new x();
        this.e = obj2;
        obj2 = new x();
        this.f = obj2;
        obj2 = new x();
        this.g = obj2;
        obj2 = new x();
        this.h = obj2;
        obj2 = new x();
        this.i = obj2;
        obj2 = new ArrayList();
        this.n = obj2;
    }

    private static final void h(app.dogo.com.dogo_android.d.c.h h, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        app.dogo.com.dogo_android.d.c.h.b aVar;
        Object bVar;
        app.dogo.com.dogo_android.d.c.h.b uNFOLLOWED;
        Object object;
        String entryId;
        java.util.Set set;
        List obj8;
        ArrayList obj9;
        n.f(h, "this$0");
        obj9 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (querySnapshot2 == null) {
            obj8 = 0;
        } else {
            obj8 = querySnapshot2.getDocumentChanges();
        }
        if (obj8 == null) {
            obj8 = new ArrayList();
        }
        obj8 = obj8.iterator();
        int i = 1;
        while (obj8.hasNext()) {
            Object next2 = obj8.next();
            object = (DocumentChange)next2.getDocument().toObject(ChallengeNotificationModel.class);
            n.e(object, "docChange.document.toObject(ChallengeNotificationModel::class.java)");
            aVar = h.c.a[next2.getType().ordinal()];
            if (aVar != i) {
            } else {
            }
            uNFOLLOWED = h.b.FOLLOWED;
            if (h.p() == uNFOLLOWED) {
            }
            if (h.p() != uNFOLLOWED) {
            } else {
            }
            uNFOLLOWED = new b((ChallengeNotificationModel)object, h.b.v(), m2Var3.f);
            aVar = new a(uNFOLLOWED);
            obj9.add(aVar);
            i = 1;
            if (!h.n.contains(object.getEntryId())) {
            }
            h.n.remove(object.getEntryId());
            if (aVar != 2) {
            } else {
            }
            uNFOLLOWED = new b(object, h.b.v(), m2Var2.f);
            aVar = new a(uNFOLLOWED);
            arrayList.add(aVar);
            if (aVar != 3) {
            } else {
            }
            b bVar2 = new b(object, h.b.v(), m2Var.f);
            a aVar2 = new a(bVar2);
            arrayList2.add(aVar2);
            if (h.p() == h.b.UNFOLLOWED) {
            }
            h.n.remove(object.getEntryId());
        }
        if (obj8 ^= i != 0) {
            h.r().setValue(obj9);
        }
        if (obj8 ^= i != 0) {
            h.q().setValue(arrayList);
        }
        if (obj8 ^= i != 0) {
            h.s().setValue(arrayList2);
        }
        if (h.o() && obj9.size() < h.k) {
            if (obj9.size() < h.k) {
                h.m().setValue(Boolean.TRUE);
            }
        }
        h.x(false);
    }

    private final EventListener<QuerySnapshot> n() {
        f fVar = new f(this);
        return fVar;
    }

    public static void u(app.dogo.com.dogo_android.d.c.h h, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        h.h(h, querySnapshot2, firebaseFirestoreException3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i(String string) {
        n.f(string, "notificationId");
        this.n.add(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j(app.dogo.com.dogo_android.d.c.h.b h$b) {
        n.f(b, "listType");
        this.d = b;
        this.k = 0;
        this.i.setValue(Boolean.FALSE);
        w();
        k();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        ListenerRegistration z;
        String str;
        int i;
        EventListener list;
        if (!this.l) {
            this.k = i2 += 20;
            w();
            this.l = true;
            if (this.d == h.b.FOLLOWED) {
                z = this.a.x0(this.b.v(), this.k, n());
            } else {
                z = this.a.w0(this.b.v(), this.k, n());
            }
            this.j = z;
        }
    }

    public final x<Boolean> l() {
        return this.i;
    }

    public final x<Boolean> m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.d.c.h.b p() {
        return this.d;
    }

    public final x<List<b0<?>>> q() {
        return this.f;
    }

    public final x<List<b0<?>>> r() {
        return this.e;
    }

    public final x<List<b0<?>>> s() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t() {
        long l = this.c.g();
        if (Long.compare(i3, i4) > 0) {
            this.m = l;
            return 1;
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String string) {
        n.f(string, "itemId");
        this.a.B0(this.b.v(), string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        final ListenerRegistration list = this.j;
        if (list == null) {
        } else {
            list.remove();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x(boolean z) {
        this.l = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String string, boolean z2) {
        n.f(string, "itemId");
        this.a.A0(this.b.v(), string, z2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }
}
