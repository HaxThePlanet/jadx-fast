package app.dogo.com.dogo_android.a0.g.f;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.model.ChallengeFilterItem;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.u2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.g1.v;
import net.time4j.k0;

/* compiled from: ChallengeFilterViewModel.java */
/* loaded from: classes.dex */
public class f0 extends r {

    private Set<ChallengeFilterItem.FilterTypes> A;
    private HashMap<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> B;
    private o3 C;
    private HashMap<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> z;
    public f0() {
        this(App.o(), App.b(), App.k());
    }

    private void w(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map, Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map2) {
        boolean contains;
        u2 u2Var;
        o2 eP_Type;
        HashSet hashSet = new HashSet(map.keySet());
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.C.logEvent(E_Challenges.h.c(new EP_Type(), (ChallengeFilterItem_FilterTypes)it2.next().getId()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean A() {
        return this.A.contains(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B(a0 a0Var) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", this.z);
        emitMessage(FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_FILTERS, bundle);
        w(this.z, this.B);
        a0Var.r(DialogTags.CHALLENGE_FILTER_DIALOG_FRAGMENT);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C(Bundle bundle) {
        str = "currentFilters";
        if (bundle.containsKey(str)) {
            this.z = (HashMap)bundle.getSerializable(str);
            this.A = (HashSet)bundle.getSerializable("possibleFilters");
            this.B = new HashMap(this.z);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void D(boolean z) {
        boolean key;
        if (z && !this.z.containsKey(ChallengeFilterItem_FilterTypes.FEATURED)) {
            this.z.put(ChallengeFilterItem_FilterTypes.FEATURED, new ChallengeFilterItem(ChallengeFilterItem_FilterTypes.FEATURED));
        }
        if (!z) {
            this.z.remove(ChallengeFilterItem_FilterTypes.FEATURED);
        }
        notifyChange(69);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void E(boolean z) {
        boolean key;
        if (z && !this.z.containsKey(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24)) {
            this.z.put(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24, new ChallengeFilterItem(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24));
        }
        if (!z) {
            this.z.remove(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
        }
        notifyChange(98);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean isFeatured() {
        return this.z.containsKey(ChallengeFilterItem_FilterTypes.FEATURED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean x() {
        return this.A.contains(ChallengeFilterItem_FilterTypes.FEATURED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String y(int i) {
        return k0.d(Locale.getDefault()).f((long)i, h.HOURS, v.WIDE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean z() {
        return this.z.containsKey(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
    }

    public f0(o3 o3Var, h2 h2Var, r2 r2Var) {
        super();
        this.z = new HashMap();
        this.A = new HashSet();
        this.B = new HashMap();
        this.C = o3Var;
    }
}
