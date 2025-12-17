package app.dogo.com.dogo_android.d.d;

import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k0.f;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.h.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B7\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00040\u0003H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u0003J \u0010\u0019\u001a\u00020\u00172\u0018\u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\u000f0\rR \u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "items", "", "Leu/davidea/flexibleadapter/items/IFlexible;", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/util/base_classes/Navigator;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "userEntryIds", "", "", "", "addItems", "", "position", "", "getUserEntryId", "challengeId", "replaceList", "", "list", "setUserEntryIds", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q extends e {

    private Map<String, ? extends Set<String>> O0;
    public q(List<? extends f<?>> list, f f2, a0 a03, q q4) {
        boolean obj8;
        n.f(a03, "navigator");
        super(list, 0, a03, f2, q4);
        HashMap obj9 = new HashMap();
        this.O0 = obj9;
        if (list != null && list.isEmpty()) {
            if (list.isEmpty()) {
                h2();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.n0.e
    public final String A2(String string) {
        Map map;
        int obj2;
        obj2 = this.O0.get(string);
        if (obj2 != null && empty ^= 1 != 0) {
            if (empty ^= 1 != 0) {
                obj2 = obj2.iterator().next();
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public final void B2(Map<String, ? extends Set<String>> map) {
        n.f(map, "userEntryIds");
        this.O0 = map;
    }

    public boolean Z(int i, List<? extends f<?>> list2) {
        n.f(list2, "items");
        x2();
        return super.Z(i, list2);
    }
}
