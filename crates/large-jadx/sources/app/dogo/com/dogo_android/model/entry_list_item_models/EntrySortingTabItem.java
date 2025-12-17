package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.i2;
import app.dogo.com.dogo_android.k.b;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.h;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001a2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J(\u0010 \u001a\u00020\u00022\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aH\u0016J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0008\u0010&\u001a\u00020\u0010H\u0016J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020$J\u0008\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020$J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020$J\u0018\u0010-\u001a\u00020\u00182\u0010\u0010.\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\u00182\u0008\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020$J\u000e\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020$J.\u00107\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u000c\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "Leu/davidea/flexibleadapter/items/AbstractHeaderItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$HeaderViewHolder;", "id", "", "listener", "Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;)V", "height", "", "getHeight", "()F", "holder", "getId", "()Ljava/lang/String;", "position", "", "getPosition", "()I", "sortingCellModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "vm", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getLayoutRes", "hideNotifications", "b", "refreshView", "setChallengWelcome", "setChallengeExpired", "bool", "setParticipatingCountries", "participatingCountries", "", "setSelectedTabAs", "latestTab", "Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "setViewVisibility", "visibilityState", "setYourTabVisibility", "yourTabVisibility", "unbindViewHolder", "HeaderViewHolder", "SortingCellModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EntrySortingTabItem extends b<app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder> {

    private app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder holder;
    private final String id;
    private final h listener;
    private final app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel sortingCellModel;
    private app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable vm;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u001a2\u0010\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ\u0010\u0010\u001f\u001a\u00020\u001a2\u0008\u0010 \u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u0006\"\u0004\u0008\u000c\u0010\u0008R2\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\t\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "", "()V", "challengeEnded", "", "isChallengeSingleEntryInfinite", "()Z", "setChallengeSingleEntryInfinite", "(Z)V", "<set-?>", "isVisible", "isYourTabVisible", "setYourTabVisible", "", "", "participatingCountries", "getParticipatingCountries", "()Ljava/util/Set;", "Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "selectedTab", "getSelectedTab", "()Lapp/dogo/com/dogo_android/enums/ChallengeSortingTab;", "checkIfCurrentTabIs", "tab", "hasChallengeExpired", "setCellVisible", "", "cellVisible", "setChallengeAsExpired", "challengeExpired", "setParticipatingCountriesList", "setSelectedTabAs", "state", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SortingCellModel {

        private boolean challengeEnded;
        private boolean isChallengeSingleEntryInfinite;
        private boolean isVisible;
        private boolean isYourTabVisible;
        private Set<String> participatingCountries;
        private b selectedTab;
        public SortingCellModel() {
            super();
            HashSet hashSet = new HashSet();
            this.participatingCountries = hashSet;
        }

        public final boolean checkIfCurrentTabIs(b b) {
            int obj2;
            n.f(b, "tab");
            obj2 = b == this.selectedTab ? 1 : 0;
            return obj2;
        }

        public final Set<String> getParticipatingCountries() {
            return this.participatingCountries;
        }

        public final b getSelectedTab() {
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

        public final void setCellVisible(boolean z) {
            this.isVisible = z;
        }

        public final void setChallengeAsExpired(boolean z) {
            b obj1;
            this.challengeEnded = z;
            if (z) {
                setSelectedTabAs(b.POPULAR_TAB);
            } else {
                setSelectedTabAs(b.LATEST_TAB);
            }
        }

        public final void setChallengeSingleEntryInfinite(boolean z) {
            this.isChallengeSingleEntryInfinite = z;
        }

        public final void setParticipatingCountriesList(Set<String> set) {
            this.participatingCountries = set;
        }

        public final void setSelectedTabAs(b b) {
            this.selectedTab = b;
        }

        public final void setYourTabVisible(boolean z) {
            this.isYourTabVisible = z;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            iArr[b.YOUR_TAB.ordinal()] = 1;
            iArr[b.LATEST_TAB.ordinal()] = 2;
            iArr[b.POPULAR_TAB.ordinal()] = 3;
            iArr[b.HOURS_24.ordinal()] = 4;
            iArr[b.DAYS_7.ordinal()] = 5;
            iArr[b.COUNTRY.ordinal()] = 6;
            EntrySortingTabItem.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$HeaderViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "listener", "Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;Lapp/dogo/com/dogo_android/util/recycle_views/ClickCallback;)V", "holderBinding", "Lapp/dogo/com/dogo_android/databinding/CellEntrySortingChipItemBinding;", "getHolderBinding", "()Lapp/dogo/com/dogo_android/databinding/CellEntrySortingChipItemBinding;", "viewModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "getViewModel", "()Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingObservable;", "setModel", "", "sortingCellModel", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem$SortingCellModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class HeaderViewHolder extends b {

        private final i2 holderBinding;
        private final app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable viewModel;
        public HeaderViewHolder(View view, e e2, h h3) {
            super(view, e2, 1);
            n.d(view);
            i2 obj2 = i2.T(view);
            n.e(obj2, "bind(view!!)");
            this.holderBinding = obj2;
            EntrySortingObservable obj3 = new EntrySortingObservable(h3);
            this.viewModel = obj3;
            obj2.V(obj3);
            obj2.T.setOnClickListener(this);
        }

        @Override // h.a.c.b
        public final i2 getHolderBinding() {
            return this.holderBinding;
        }

        @Override // h.a.c.b
        public final app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable getViewModel() {
            return this.viewModel;
        }

        @Override // h.a.c.b
        public final void setModel(app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel entrySortingTabItem$SortingCellModel) {
            this.viewModel.setModel(sortingCellModel);
        }
    }
    public EntrySortingTabItem(String string, h h2) {
        n.f(string, "id");
        n.f(h2, "listener");
        super();
        this.id = string;
        this.listener = h2;
        EntrySortingTabItem.SortingCellModel obj2 = new EntrySortingTabItem.SortingCellModel();
        this.sortingCellModel = obj2;
    }

    private final void refreshView() {
        final app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable entrySortingObservable = this.vm;
        if (entrySortingObservable != null) {
            n.d(entrySortingObservable);
            entrySortingObservable.refreshView();
        }
    }

    @Override // h.a.b.h.b
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntrySortingTabItem.HeaderViewHolder)e02, i3, list4);
    }

    public void bindViewHolder(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder entrySortingTabItem$HeaderViewHolder2, int i3, List<Object> list4) {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel obj1;
        if (headerViewHolder2 == null) {
        } else {
            headerViewHolder2.setModel(this.sortingCellModel);
        }
        if (headerViewHolder2 == null) {
            obj1 = 0;
        } else {
            obj1 = headerViewHolder2.getViewModel();
        }
        this.vm = obj1;
        this.holder = headerViewHolder2;
    }

    @Override // h.a.b.h.b
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    public app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder createViewHolder(View view, b<f<RecyclerView.e0>> b2) {
        EntrySortingTabItem.HeaderViewHolder headerViewHolder = new EntrySortingTabItem.HeaderViewHolder(view, (e)b2, this.listener);
        return headerViewHolder;
    }

    @Override // h.a.b.h.b
    public boolean equals(Object object) {
        if (object instanceof EntrySortingTabItem) {
            return n.b(this.id, object.id);
        }
        return 0;
    }

    @Override // h.a.b.h.b
    public final float getHeight() {
        float f;
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder holder = this.holder;
        if (holder != null) {
            n.d(holder);
            f = (float)height;
        } else {
            f = 0;
        }
        return f;
    }

    @Override // h.a.b.h.b
    public final String getId() {
        return this.id;
    }

    @Override // h.a.b.h.b
    public int getLayoutRes() {
        return 2131558489;
    }

    @Override // h.a.b.h.b
    public final int getPosition() {
        int i;
        int[] iArr;
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder holder = this.holder;
        if (holder != null) {
            iArr = new int[2];
            n.d(holder);
            holderBinding.O.getLocationInWindow(iArr);
            i = iArr[1];
        } else {
            i = 0;
        }
        return i;
    }

    @Override // h.a.b.h.b
    public final void hideNotifications(boolean z) {
        Object holder;
        int obj2;
        holder = this.holder;
        if (holder != null) {
            n.d(holder);
            obj2 = z != 0 ? 8 : 0;
            holderBinding.T.setVisibility(obj2);
        }
    }

    @Override // h.a.b.h.b
    public final void setChallengWelcome(boolean z) {
        this.sortingCellModel.setChallengeSingleEntryInfinite(z);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setChallengeExpired(boolean z) {
        this.sortingCellModel.setChallengeAsExpired(z);
        refreshView();
    }

    public final void setParticipatingCountries(Set<String> set) {
        this.sortingCellModel.setParticipatingCountriesList(set);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setSelectedTabAs(b b) {
        int entrySortingObservable;
        int ordinal;
        if (this.vm != null) {
            if (b == null) {
                entrySortingObservable = -1;
            } else {
                entrySortingObservable = EntrySortingTabItem.WhenMappings.$EnumSwitchMapping$0[b.ordinal()];
            }
            switch (entrySortingObservable) {
                case 1:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.onYourSelect();
                    break;
                case 2:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.onLatestSelect();
                    break;
                case 3:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.onPopularSelect();
                    break;
                case 4:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.on24HourSelect();
                    break;
                case 5:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.on7DaySelect();
                    break;
                case 6:
                    entrySortingObservable = this.vm;
                    n.d(entrySortingObservable);
                    entrySortingObservable.onCountrySelect();
                    break;
                default:
            }
        }
        this.sortingCellModel.setSelectedTabAs(b);
    }

    @Override // h.a.b.h.b
    public final void setViewVisibility(boolean z) {
        this.sortingCellModel.setCellVisible(z);
        refreshView();
    }

    @Override // h.a.b.h.b
    public final void setYourTabVisibility(boolean z) {
        this.sortingCellModel.setYourTabVisible(z);
        refreshView();
    }

    @Override // h.a.b.h.b
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (EntrySortingTabItem.HeaderViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f<?>> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.HeaderViewHolder entrySortingTabItem$HeaderViewHolder2, int i3) {
        n.f(headerViewHolder2, "holder");
        super.unbindViewHolder(b, headerViewHolder2, i3);
    }
}
