package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.j;
import app.dogo.com.dogo_android.model.ChallengeFilterItem;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.util.n0.f.b;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.u2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.time4j.g1.v;

/* loaded from: classes.dex */
public class EntryFilterViewModel implements h {

    private h2 authService;
    private Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> filterTypeList;
    private ChallengeModel model;
    private Set<ChallengeFilterItem.FilterTypes> possibleFilters;
    private p2 preferenceService;
    private final j registry;
    private r2 remoteConfigService;
    private Resources resources;
    private o3 tracker;
    private v2 utilities;
    public EntryFilterViewModel() {
        super(App.i(), App.p(), App.a().getResources(), App.o(), App.k(), App.b());
    }

    public EntryFilterViewModel(p2 p2, v2 v22, Resources resources3, o3 o34, r2 r25, h2 h26) {
        super();
        j jVar = new j();
        this.registry = jVar;
        HashMap hashMap = new HashMap();
        this.filterTypeList = hashMap;
        HashSet hashSet = new HashSet();
        this.possibleFilters = hashSet;
        this.preferenceService = p2;
        this.utilities = v22;
        this.resources = resources3;
        this.tracker = o34;
        this.remoteConfigService = r25;
        this.authService = h26;
    }

    private String getStringForFilter(ChallengeFilterItem.FilterTypes challengeFilterItem$FilterTypes) {
        int obj9 = EntryFilterViewModel.1.$SwitchMap$app$dogo$com$dogo_android$model$ChallengeFilterItem$FilterTypes[filterTypes.ordinal()];
        int i = 1;
        if (obj9 != i && obj9 != 2) {
            if (obj9 != 2) {
                return "";
            }
            return this.resources.getString(2131886290);
        }
        Object[] arr = new Object[i];
        arr[0] = this.utilities.s(24, obj5, v2.b.HOURS);
        return this.resources.getString(2131886291, arr);
    }

    @Override // androidx.databinding.h
    public void addOnPropertyChangedCallback(h.a h$a) {
        this.registry.a(a);
    }

    @Override // androidx.databinding.h
    public boolean featuredEnabled() {
        int i;
        boolean z;
        if (!this.remoteConfigService.f()) {
            if (this.authService.C()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public List<f.b> getConvertedList(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        Object stringForFilter;
        boolean bVar;
        ChallengeFilterItem.FilterTypes filterType;
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = map.values().iterator();
        while (obj6.hasNext()) {
            stringForFilter = obj6.next();
            if (this.possibleFilters.contains((ChallengeFilterItem)stringForFilter.getFilterType())) {
            }
            if (!stringForFilter.getValues().isEmpty()) {
            } else {
            }
            bVar = new f.b(stringForFilter.getFilterType(), "", getStringForFilter(stringForFilter.getFilterType()));
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> getList() {
        return this.filterTypeList;
    }

    @Override // androidx.databinding.h
    public boolean isListEmpty() {
        return getConvertedList(getList()).isEmpty();
    }

    @Override // androidx.databinding.h
    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    @Override // androidx.databinding.h
    public void removeFilter(ChallengeFilterItem.FilterTypes challengeFilterItem$FilterTypes, String string2) {
        boolean values;
        Map obj4;
        if (string2.isEmpty()) {
            this.filterTypeList.remove(filterTypes);
        } else {
            (ChallengeFilterItem)this.filterTypeList.get(filterTypes).getValues().remove(string2);
            if ((ChallengeFilterItem)this.filterTypeList.get(filterTypes).getValues().isEmpty()) {
                this.filterTypeList.remove(filterTypes);
            }
        }
        this.preferenceService.y0(this.filterTypeList, this.model.getId());
        notifyChange(104);
        o2 o2Var = new o2();
        this.tracker.d(u.i.c(o2Var, filterTypes.getId()));
    }

    @Override // androidx.databinding.h
    public void removeOnPropertyChangedCallback(h.a h$a) {
        this.registry.j(a);
    }

    public void setFilters(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        boolean hasEnded;
        Object preferenceService;
        String str;
        Map obj3;
        preferenceService = this.model;
        if (preferenceService != null && preferenceService.isHasEnded(this.utilities)) {
            if (preferenceService.isHasEnded(this.utilities)) {
                map.remove(ChallengeFilterItem.FilterTypes.LATEST_ENTRIES_24);
            }
            this.filterTypeList = map;
            this.preferenceService.y0(map, this.model.getId());
            notifyChange(104);
        }
    }

    @Override // androidx.databinding.h
    public void setModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
    }

    public void setPossibleFilters(Set<ChallengeFilterItem.FilterTypes> set) {
        this.possibleFilters = set;
        notifyChange(104);
    }

    @Override // androidx.databinding.h
    public void toggleHideHeightAnimation(boolean z, View view2, int i3, int i4) {
        this.utilities.w("filterHide", z, view2, (long)i3, obj5, i4);
    }
}
