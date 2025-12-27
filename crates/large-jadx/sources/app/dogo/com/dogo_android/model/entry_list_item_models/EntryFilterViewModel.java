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

/* compiled from: EntryFilterViewModel.java */
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

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$app$dogo$com$dogo_android$model$ChallengeFilterItem$FilterTypes;
        static {
            int[] iArr = new int[ChallengeFilterItem_FilterTypes.values().length];
            EntryFilterViewModel.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$ChallengeFilterItem$FilterTypes = iArr;
            try {
                iArr[ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                EntryFilterViewModel.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$ChallengeFilterItem$FilterTypes[ChallengeFilterItem_FilterTypes.FEATURED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public EntryFilterViewModel() {
        this(App.i(), App.p(), App.onCreate().getResources(), App.o(), App.k(), App.b());
    }

    private String getStringForFilter(ChallengeFilterItem.FilterTypes filterTypes) throws android.content.res.Resources.NotFoundException {
        int i7 = EntryFilterViewModel.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$ChallengeFilterItem$FilterTypes[filterTypes.ordinal()];
        int i = 1;
        if (i7 != i && i7 != 2) {
            return "";
        }
        Object[] arr = new Object[i];
        return this.resources.getString(2131886291, new Object[] { this.utilities.s(24L, Utilities_TimeUnit.HOURS, v.NARROW) });
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.registry.a(aVar);
    }

    public boolean featuredEnabled() {
        boolean z2 = false;
        if (!this.remoteConfigService.f()) {
            if (this.authService.C()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    public List<f.b> getConvertedList(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        String str;
        final ArrayList arrayList = new ArrayList();
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    public Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> getList() {
        return this.filterTypeList;
    }

    public boolean isListEmpty() {
        return getConvertedList(getList()).isEmpty();
    }

    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    public void removeFilter(ChallengeFilterItem.FilterTypes filterTypes, String str) {
        if (str.isEmpty()) {
            this.filterTypeList.remove(filterTypes);
        } else {
            (ChallengeFilterItem)this.filterTypeList.get(filterTypes).getValues().remove(str);
            if ((ChallengeFilterItem)this.filterTypeList.get(filterTypes).getValues().isEmpty()) {
                this.filterTypeList.remove(filterTypes);
            }
        }
        this.preferenceService.y0(this.filterTypeList, this.model.getId());
        notifyChange(104);
        this.tracker.logEvent(E_Challenges.i.c(new EP_Type(), filterTypes.getId()));
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.registry.j(aVar);
    }

    public void setFilters(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> map) {
        if (this.model != null) {
            if (this.model.isHasEnded(this.utilities)) {
                map.remove(ChallengeFilterItem_FilterTypes.LATEST_ENTRIES_24);
            }
            this.filterTypeList = map;
            this.preferenceService.y0(map, this.model.getId());
            int i = 104;
            notifyChange(i);
        }
    }

    public void setModel(ChallengeModel challengeModel) {
        this.model = challengeModel;
    }

    public void setPossibleFilters(Set<ChallengeFilterItem.FilterTypes> set) {
        this.possibleFilters = set;
        notifyChange(104);
    }

    public void toggleHideHeightAnimation(boolean z, View view, int i, int i2) {
        this.utilities.w("filterHide", z, view, (long)i, i2, null);
    }

    public EntryFilterViewModel(p2 p2Var, v2 v2Var, Resources resources, o3 o3Var, r2 r2Var, h2 h2Var) {
        super();
        this.registry = new j();
        this.filterTypeList = new HashMap();
        this.possibleFilters = new HashSet();
        this.preferenceService = p2Var;
        this.utilities = v2Var;
        this.resources = resources;
        this.tracker = o3Var;
        this.remoteConfigService = r2Var;
        this.authService = h2Var;
    }
}
