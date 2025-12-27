package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.i2;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.h;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: EntrySortingTabItem.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001a2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J(\u0010 \u001a\u00020\u00022\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aH\u0016J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0008\u0010&\u001a\u00020\u0010H\u0016J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020$J\u0008\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020$J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020$J\u0018\u0010-\u001a\u00020\u00182\u0010\u0010.\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\u00182\u0008\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020$J\u000e\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020$J.\u00107\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u000c\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/AbstractHeaderItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$HeaderViewHolder;", "id", "", "listener", "Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;)V", "height", "", "getHeight", "()F", "holder", "getId", "()Ljava/lang/String;", "position", "", "getPosition", "()I", "sortingCellModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "vm", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "hideNotifications", "b", "refreshView", "setChallengWelcome", "setChallengeExpired", "bool", "setParticipatingCountries", "participatingCountries", "", "setSelectedTabAs", "latestTab", "Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "setViewVisibility", "visibilityState", "setYourTabVisibility", "yourTabVisibility", "unbindViewHolder", "HeaderViewHolder", "SortingCellModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class EntrySortingTabItem extends h.a.b.h.b<EntrySortingTabItem.HeaderViewHolder> {

    private EntrySortingTabItem.HeaderViewHolder holder;
    private final String id;
    private final h listener;
    private final EntrySortingTabItem.SortingCellModel sortingCellModel = new EntrySortingTabItem$SortingCellModel();
    private EntrySortingObservable vm;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u001a2\u0010\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ\u0010\u0010\u001f\u001a\u00020\u001a2\u0008\u0010 \u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u0006\"\u0004\u0008\u000c\u0010\u0008R2\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\t\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "", "()V", "challengeEnded", "", "isChallengeSingleEntryInfinite", "()Z", "setChallengeSingleEntryInfinite", "(Z)V", "<set-?>", "isVisible", "isYourTabVisible", "setYourTabVisible", "", "", "participatingCountries", "getParticipatingCountries", "()Ljava/util/Set;", "Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "selectedTab", "getSelectedTab", "()Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "checkIfCurrentTabIs", "tab", "hasChallengeExpired", "setCellVisible", "", "cellVisible", "setChallengeAsExpired", "challengeExpired", "setParticipatingCountriesList", "setSelectedTabAs", "state", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SortingCellModel {

        private boolean challengeEnded;
        private boolean isChallengeSingleEntryInfinite;
        private boolean isVisible;
        private boolean isYourTabVisible;
        private Set<String> participatingCountries = new HashSet<>();
        private app.dogo.com.dogo_android.k.b selectedTab;
        public SortingCellModel() {
            super();
            final HashSet hashSet = new HashSet();
        }

        public final boolean checkIfCurrentTabIs(app.dogo.com.dogo_android.k.b tab) {
            boolean z = true;
            n.f(tab, "tab");
            tab = tab == this.selectedTab ? 1 : 0;
            return (tab == this.selectedTab ? 1 : 0);
        }

        public final Set<String> getParticipatingCountries() {
            return this.participatingCountries;
        }

        public final app.dogo.com.dogo_android.k.b getSelectedTab() {
            return this.selectedTab;
        }

        public final boolean hasChallengeExpired() {
            return this.challengeEnded;
        }

        public final boolean isChallengeSingleEntryInfinite() {
            return this.isChallengeSingleEntryInfinite;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public final boolean isYourTabVisible() {
            return this.isYourTabVisible;
        }

        public final void setCellVisible(boolean cellVisible) {
            this.isVisible = cellVisible;
        }

        public final void setChallengeAsExpired(boolean challengeExpired) {
            this.challengeEnded = challengeExpired;
            if (challengeExpired) {
                setSelectedTabAs(ChallengeSortingTab.POPULAR_TAB);
            } else {
                setSelectedTabAs(ChallengeSortingTab.LATEST_TAB);
            }
        }

        public final void setChallengeSingleEntryInfinite(boolean z) {
            this.isChallengeSingleEntryInfinite = z;
        }

        public final void setParticipatingCountriesList(Set<String> participatingCountries) {
            this.participatingCountries = participatingCountries;
        }

        public final void setSelectedTabAs(app.dogo.com.dogo_android.k.b state) {
            this.selectedTab = state;
        }

        public final void setYourTabVisible(boolean z) {
            this.isYourTabVisible = z;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[ChallengeSortingTab.values().length];
            iArr[ChallengeSortingTab.YOUR_TAB.ordinal()] = 1;
            iArr[ChallengeSortingTab.LATEST_TAB.ordinal()] = 2;
            iArr[ChallengeSortingTab.POPULAR_TAB.ordinal()] = 3;
            iArr[ChallengeSortingTab.HOURS_24.ordinal()] = 4;
            iArr[ChallengeSortingTab.DAYS_7.ordinal()] = 5;
            iArr[ChallengeSortingTab.COUNTRY.ordinal()] = 6;
            EntrySortingTabItem.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$HeaderViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "listener", "Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntrySortingChipItemBinding;", "getHolderBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEntrySortingChipItemBinding;", "viewModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "getViewModel", "()Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "setModel", "", "sortingCellModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class HeaderViewHolder extends h.a.c.b {

        private final i2 holderBinding;
        private final EntrySortingObservable viewModel = new EntrySortingObservable();
        public HeaderViewHolder(View view, e eVar, h hVar) {
            super(view, eVar, true);
            n.d(view);
            i2 i2Var = i2.T(view);
            n.e(i2Var, "bind(view!!)");
            this.holderBinding = i2Var;
            i2Var.V(new EntrySortingObservable(hVar));
            i2Var.T.setOnClickListener(this);
        }

        @Override // h.a.c.b
        public final i2 getHolderBinding() {
            return this.holderBinding;
        }

        @Override // h.a.c.b
        public final EntrySortingObservable getViewModel() {
            return this.viewModel;
        }

        @Override // h.a.c.b
        public final void setModel(EntrySortingTabItem.SortingCellModel sortingCellModel) {
            this.viewModel.setModel(sortingCellModel);
        }
    }
    public EntrySortingTabItem(String str, h hVar) {
        n.f(str, "id");
        n.f(hVar, "listener");
        super();
        this.id = str;
        this.listener = hVar;
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel entrySortingTabItem_SortingCellModel = new EntrySortingTabItem_SortingCellModel();
    }

    private final void refreshView() {
        if (this.vm != null) {
            n.d(this.vm);
            this.vm.refreshView();
        }
    }

    @Override // h.a.b.h.b
    /* operator */ public boolean equals(Object other) {
        if (other instanceof EntrySortingTabItem) {
            return n.b(this.id, other.id);
        }
        return false;
    }

    @Override // h.a.b.h.b
    public final float getHeight() {
        float f = 0;
        if (this.holder != null) {
            n.d(this.holder);
            f = (float)this.holder.getHolderBinding().w().getHeight();
        } else {
            int i = 0;
        }
        return f;
    }

    @Override // h.a.b.h.b
    public final String getId() {
        return this.id;
    }

    @Override // h.a.b.h.b
    public final int getPosition() {
        int i = 0;
        if (this.holder != null) {
            int[] iArr = new int[2];
            n.d(this.holder);
            this.holder.getHolderBinding().O.getLocationInWindow(iArr);
            i = iArr[1];
        } else {
            i = 0;
        }
        return i;
    }

    @Override // h.a.b.h.b
    public final void hideNotifications(boolean b) {
        int i = 0;
        if (this.holder != null) {
            n.d(this.holder);
            b = b ? 8 : 0;
            this.holder.getHolderBinding().T.setVisibility((b ? 8 : 0));
        }
    }

    @Override // h.a.b.h.b
    public final void setChallengWelcome(boolean b) {
        this.sortingCellModel.setChallengeSingleEntryInfinite(b);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setChallengeExpired(boolean bool) {
        this.sortingCellModel.setChallengeAsExpired(bool);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setParticipatingCountries(Set<String> participatingCountries) {
        this.sortingCellModel.setParticipatingCountriesList(participatingCountries);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setSelectedTabAs(app.dogo.com.dogo_android.k.b latestTab) {
        int i2 = -1;
        int ordinal;
        if (this.vm != null && latestTab == null) {
            i2 = -1;
            switch (i2) {
                case 1:
                    n.d(this.vm);
                    this.vm.onYourSelect();
                    break;
                case 2:
                    n.d(this.vm);
                    this.vm.onLatestSelect();
                    break;
                case 3:
                    n.d(this.vm);
                    this.vm.onPopularSelect();
                    break;
                case 4:
                    n.d(this.vm);
                    this.vm.on24HourSelect();
                    break;
                case 5:
                    n.d(this.vm);
                    this.vm.on7DaySelect();
                    break;
                case 6:
                    n.d(this.vm);
                    this.vm.onCountrySelect();
                    break;
                default:
            }
        }
        this.sortingCellModel.setSelectedTabAs(latestTab);
    }

    @Override // h.a.b.h.b
    public final void setViewVisibility(boolean visibilityState) {
        this.sortingCellModel.setCellVisible(visibilityState);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setYourTabVisibility(boolean yourTabVisibility) {
        this.sortingCellModel.setYourTabVisible(yourTabVisibility);
        refreshView();
    }

    @Override // h.a.b.h.b
    public void bindViewHolder(h.a.b.b<f<RecyclerView.e0>> bVar, EntrySortingTabItem.HeaderViewHolder headerViewHolder, int i, List<Object> list) {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable viewModel = null;
        if (headerViewHolder != null) {
            headerViewHolder.setModel(this.sortingCellModel);
        }
        if (headerViewHolder == null) {
            i = 0;
        } else {
            viewModel = headerViewHolder.getViewModel();
        }
        this.vm = viewModel;
        this.holder = headerViewHolder;
    }

    @Override // h.a.b.h.b
    public EntrySortingTabItem.HeaderViewHolder createViewHolder(View view, h.a.b.b<f<RecyclerView.e0>> bVar) {
        return new EntrySortingTabItem_HeaderViewHolder(view, bVar, this.listener);
    }

    @Override // h.a.b.h.b
    public void unbindViewHolder(h.a.b.b<f<?>> bVar, EntrySortingTabItem.HeaderViewHolder headerViewHolder, int i) {
        n.f(headerViewHolder, "holder");
        super.unbindViewHolder(bVar, headerViewHolder, i);
    }

    @Override // h.a.b.h.b
    public int getLayoutRes() {
        return R.layout.cell_entry_sorting_chip_item;
    }
}
