package app.dogo.com.dogo_android.d.d;

import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.n0.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeProfileListAdapter.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B7\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00040\u0003H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u0003J \u0010\u0019\u001a\u00020\u00172\u0018\u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\u000f0\rR \u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "items", "", "Leu/davidea/flexibleadapter/items/IFlexible;", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/util/base_classes/Navigator;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "userEntryIds", "", "", "", "addItems", "", "position", "", "getUserEntryId", "challengeId", "replaceList", "", "list", "setUserEntryIds", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final class ChallengeProfileListAdapter extends e {

    /* renamed from: O0, reason: from kotlin metadata */
    private Map<String, ? extends Set<String>> userEntryIds = new HashMap<>();
    public q(List<? extends h.a.b.h.f<?>> list, app.dogo.com.dogo_android.util.k0.f fVar, a0 a0Var, q qVar) {
        n.f(a0Var, "navigator");
        super(list, null, a0Var, fVar, qVar);
        final HashMap hashMap = new HashMap();
        if (list != null && list.isEmpty()) {
            h2();
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.e
    /* renamed from: A2, reason: from kotlin metadata */
    public final String getUserEntryId(String challengeId) {
        Map userEntryIds2;
        int i = 0;
        Object value = this.userEntryIds.get(challengeId);
        if (value != null) {
            if (!value.isEmpty()) {
                Object item = value.iterator().next();
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.n0.e
    /* renamed from: B2, reason: from kotlin metadata */
    public final void replaceList(Map<String, ? extends Set<String>> list) {
        n.f(list, "userEntryIds");
        this.userEntryIds = list;
    }

    @Override // app.dogo.com.dogo_android.util.n0.e
    /* renamed from: Z, reason: from kotlin metadata */
    public boolean addItems(int position, List<? extends h.a.b.h.f<?>> items) {
        n.f(items, "items");
        x2();
        return super.Z(position, items);
    }
}
