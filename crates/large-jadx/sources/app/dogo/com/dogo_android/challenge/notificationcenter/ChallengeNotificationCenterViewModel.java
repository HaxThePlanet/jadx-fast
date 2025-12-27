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

/* compiled from: ChallengeNotificationCenterViewModel.kt */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\r\u0018\u0000 >2\u00020\u0001:\u0002>?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020.J\u000e\u00105\u001a\u0002032\u0006\u0010#\u001a\u00020\"J\u0006\u00106\u001a\u000203J\u000e\u00107\u001a\u0002032\u0006\u00108\u001a\u00020.J\u0006\u00109\u001a\u000203J\u0016\u0010:\u001a\u0002032\u0006\u00108\u001a\u00020.2\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R!\u0010&\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u000fR!\u0010*\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u000fR\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020.0-j\u0008\u0012\u0004\u0012\u00020.`/X\u0082\u0004¢\u0006\u0002\n\u0000R!\u00100\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030(0'0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "currentPageLimit", "", "emptyListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getEmptyListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "endOfListNotifier", "getEndOfListNotifier", "firestoreListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "followedChallengeNotificationEventListener", "Lcom/google/firebase/firestore/EventListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "getFollowedChallengeNotificationEventListener", "()Lcom/google/firebase/firestore/EventListener;", "freshPageFetched", "getFreshPageFetched", "()Z", "setFreshPageFetched", "(Z)V", "isClickDebounced", "lastClickTime", "", "<set-?>", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "listType", "getListType", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "modifiedItemLiveData", "", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "getModifiedItemLiveData", "newItemLiveData", "getNewItemLiveData", "notificationInProcessingList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "removedItemLiveData", "getRemovedItemLiveData", "addToTemporaryIgnoreList", "", "notificationId", "changeListType", "fetchNewPage", "markNotificationAsViewed", "itemId", "removeFirestoreListener", "updateFollowState", "followState", "updateListEmptynesState", "state", "Companion", "ListType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ChallengeNotificationCenterViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h.a INSTANCE = new h$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final m2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 currentPageLimit;
    private final v2 c;
    private h.b d;
    /* renamed from: e, reason: from kotlin metadata */
    private final x<List<b0<?>>> firestoreListener = new x<>();
    /* renamed from: f, reason: from kotlin metadata */
    private final x<List<b0<?>>> firestoreService = new x<>();
    private final x<List<b0<?>>> g = new x<>();
    private final x<Boolean> h = new x<>();
    private final x<Boolean> i = new x<>();
    /* renamed from: j, reason: from kotlin metadata */
    private ListenerRegistration lastClickTime;
    private int k;
    private boolean l;
    private long m;
    /* renamed from: n, reason: from kotlin metadata */
    private final ArrayList<String> notificationInProcessingList = new ArrayList<>();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$Companion;", "", "()V", "DEBOUNCE_TIME", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/ChallengeNotificationCenterViewModel$ListType;", "", "stringRes", "", "(Ljava/lang/String;II)V", "getStringRes", "()I", "FOLLOWED", "UNFOLLOWED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        FOLLOWED,
        UNFOLLOWED;

        private final int stringRes;
        @Override // java.lang.Enum
        public final int getStringRes() {
            return this.stringRes;
        }

        private static final /* synthetic */ h.b[] $values() {
            app.dogo.com.dogo_android.d.c.h.b[] arr = new h.b[2];
            return new h.b[] { ChallengeNotificationCenterViewModel_ListType.FOLLOWED, ChallengeNotificationCenterViewModel_ListType.UNFOLLOWED };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class c {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DocumentChange.Type.values().length];
            iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            iArr[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            iArr[DocumentChange.Type.REMOVED.ordinal()] = 3;
            app.dogo.com.dogo_android.challenge.notificationcenter.h.c.a = iArr;
        }
    }
    public h(m2 m2Var, h2 h2Var, v2 v2Var) {
        n.f(m2Var, "firestoreService");
        n.f(h2Var, "authService");
        n.f(v2Var, "utilities");
        super();
        this.authService = m2Var;
        this.currentPageLimit = h2Var;
        this.c = v2Var;
        this.d = ChallengeNotificationCenterViewModel_ListType.FOLLOWED;
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        x xVar4 = new x();
        x xVar5 = new x();
        ArrayList arrayList = new ArrayList();
    }

    private static final void h(h hVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        String entryId;
        java.util.Set reportedCommentIds2;
        List documentChanges = null;
        n.f(hVar, "this$0");
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (querySnapshot == null) {
            int i7 = 0;
        } else {
            documentChanges = querySnapshot.getDocumentChanges();
        }
        if (documentChanges == null) {
            ArrayList arrayList4 = new ArrayList();
        }
        Iterator it = documentChanges.iterator();
        int i4 = 1;
        while (it.hasNext()) {
            Object item = it.next();
            Object object = item.getDocument().toObject(ChallengeNotificationModel.class);
            n.e(object, "docChange.document.toObject(ChallengeNotificationModel::class.java)");
            app.dogo.com.dogo_android.d.c.h.b bVar = app.dogo.com.dogo_android.challenge.notificationcenter.h.c.a[item.getType().ordinal()];
        }
        i = arrayList.isEmpty() ^ i4;
        if (arrayList.isEmpty() ^ i4) {
            hVar.r().setValue(arrayList);
        }
        i2 = arrayList2.isEmpty() ^ i4;
        if (arrayList2.isEmpty() ^ i4) {
            hVar.q().setValue(arrayList2);
        }
        i3 = arrayList3.isEmpty() ^ i4;
        if (arrayList3.isEmpty() ^ i4) {
            hVar.s().setValue(arrayList3);
        }
        if (hVar.o()) {
            if (arrayList.size() < hVar.k) {
                hVar.m().setValue(Boolean.TRUE);
            }
        }
        hVar.updateListEmptynesState(false);
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final EventListener<QuerySnapshot> fetchNewPage() {
        return new app.dogo.com.dogo_android.challenge.notificationcenter.f(this);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void addToTemporaryIgnoreList(String notificationId) {
        n.f(notificationId, "notificationId");
        this.notificationInProcessingList.add(notificationId);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: j, reason: from kotlin metadata */
    public final void changeListType(h.b listType) {
        n.f(listType, "listType");
        this.d = listType;
        this.k = 0;
        this.i.setValue(Boolean.FALSE);
        w();
        k();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        ListenerRegistration chatNotificationFollowState;
        String str;
        int i;
        EventListener newPage;
        if (!this.l) {
            this.k += 20;
            w();
            this.l = true;
            if (this.d == ChallengeNotificationCenterViewModel_ListType.FOLLOWED) {
                chatNotificationFollowState = this.authService.upvoteEntryComment(this.currentPageLimit.v(), this.k, fetchNewPage());
            } else {
                chatNotificationFollowState = this.authService.updateChatNotificationFollowState(this.currentPageLimit.v(), this.k, fetchNewPage());
            }
            this.lastClickTime = chatNotificationFollowState;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> l() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final h.b p() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<List<b0<?>>> q() {
        return this.firestoreService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<List<b0<?>>> r() {
        return this.firestoreListener;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<List<b0<?>>> s() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t() {
        long l = this.c.g();
        long l3 = l - this.m;
        if (this.m > 500) {
            this.m = l;
            return true;
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: v, reason: from kotlin metadata */
    public final void markNotificationAsViewed(String itemId) {
        n.f(itemId, "itemId");
        this.authService.fetchUserEntries(this.currentPageLimit.v(), itemId);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        if (this.lastClickTime != null) {
            this.lastClickTime.remove();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: x, reason: from kotlin metadata */
    public final void updateListEmptynesState(boolean state) {
        this.l = state;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: y, reason: from kotlin metadata */
    public final void updateFollowState(String itemId, boolean followState) {
        n.f(itemId, "itemId");
        this.authService.deleteChallengeEntry(this.currentPageLimit.v(), itemId, followState);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }


    public static /* synthetic */ void u(h hVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        ChallengeNotificationCenterViewModel.h(hVar, querySnapshot, exc);
    }
}
