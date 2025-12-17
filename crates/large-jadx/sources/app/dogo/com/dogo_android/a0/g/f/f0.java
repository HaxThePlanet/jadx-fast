package app.dogo.com.dogo_android.a0.g.f;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
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
import net.time4j.h;
import net.time4j.k0;

/* loaded from: classes.dex */
public class f0 extends r {

    private Set<ChallengeFilterItem.FilterTypes> A;
    private HashMap<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> B;
    private o3 C;
    private HashMap<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> z;
    public f0() {
        super(App.o(), App.b(), App.k());
    }

    public f0(o3 o3, h2 h22, r2 r23) {
        super();
        HashMap obj2 = new HashMap();
        this.z = obj2;
        obj2 = new HashSet();
        this.A = obj2;
        obj2 = new HashMap();
        this.B = obj2;
        this.C = o3;
    }

    private void w(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map, Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map2) {
        HashSet hashSet;
        boolean contains;
        u2 o2Var2;
        o2 o2Var;
        Object obj6;
        hashSet = new HashSet(map.keySet());
        Iterator obj5 = map2.keySet().iterator();
        while (obj5.hasNext()) {
            obj6 = obj5.next();
            if (hashSet.contains((ChallengeFilterItem.FilterTypes)obj6)) {
            } else {
            }
            o2Var = new o2();
            this.C.d(u.i.c(o2Var, obj6.getId()));
            hashSet.remove(obj6);
        }
        obj5 = hashSet.iterator();
        for (ChallengeFilterItem.FilterTypes obj6 : obj5) {
            o2Var2 = new o2();
            this.C.d(u.h.c(o2Var2, obj6.getId()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean A() {
        return this.A.contains(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void B(a0 a0) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", this.z);
        j(h.MESSAGE_ACTION_CHALLENGE_FILTERS, bundle);
        w(this.z, this.B);
        a0.r(c.CHALLENGE_FILTER_DIALOG_FRAGMENT);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void C(Bundle bundle) {
        Object str;
        HashMap obj3;
        str = "currentFilters";
        if (bundle.containsKey(str)) {
            this.z = (HashMap)bundle.getSerializable(str);
            this.A = (HashSet)bundle.getSerializable("possibleFilters");
            obj3 = new HashMap(this.z);
            this.B = obj3;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void D(boolean z) {
        boolean fEATURED2;
        ChallengeFilterItem.FilterTypes fEATURED;
        ChallengeFilterItem challengeFilterItem;
        HashMap obj4;
        fEATURED = ChallengeFilterItem.FilterTypes.FEATURED;
        if (z != null && !this.z.containsKey(fEATURED)) {
            fEATURED = ChallengeFilterItem.FilterTypes.FEATURED;
            if (!this.z.containsKey(fEATURED)) {
                challengeFilterItem = new ChallengeFilterItem(fEATURED);
                this.z.put(fEATURED, challengeFilterItem);
            }
        }
        if (z == null) {
            this.z.remove(ChallengeFilterItem.FilterTypes.FEATURED);
        }
        l(69);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void E(boolean z) {
        boolean key;
        ChallengeFilterItem.FilterTypes filterTypes;
        ChallengeFilterItem challengeFilterItem;
        HashMap obj4;
        filterTypes = ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24;
        if (z != null && !this.z.containsKey(filterTypes)) {
            filterTypes = ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24;
            if (!this.z.containsKey(filterTypes)) {
                challengeFilterItem = new ChallengeFilterItem(filterTypes);
                this.z.put(filterTypes, challengeFilterItem);
            }
        }
        if (z == null) {
            this.z.remove(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
        }
        l(98);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean isFeatured() {
        return this.z.containsKey(ChallengeFilterItem.FilterTypes.FEATURED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean x() {
        return this.A.contains(ChallengeFilterItem.FilterTypes.FEATURED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String y(int i) {
        return k0.d(Locale.getDefault()).f((long)i, obj2, h.HOURS);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean z() {
        return this.z.containsKey(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
    }
}
