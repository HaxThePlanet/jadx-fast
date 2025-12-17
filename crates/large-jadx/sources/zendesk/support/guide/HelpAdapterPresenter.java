package zendesk.support.guide;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.support.ArticleItem;
import zendesk.support.CategoryItem;
import zendesk.support.HelpItem;
import zendesk.support.SectionItem;
import zendesk.support.SeeAllArticlesItem;

/* loaded from: classes3.dex */
class HelpAdapterPresenter implements zendesk.support.guide.HelpMvp.Presenter {

    private static final Integer RETRY_ACTION_ID;
    private f<List<HelpItem>> callback;
    private zendesk.support.guide.HelpCenterMvp.Presenter contentPresenter;
    private List<HelpItem> filteredItems;
    private boolean hasError;
    private zendesk.support.guide.HelpCenterConfiguration helpCenterUiConfig;
    private List<HelpItem> helpItems;
    private zendesk.support.guide.HelpMvp.Model model;
    private NetworkInfoProvider networkInfoProvider;
    private boolean noResults;
    private RetryAction retryAction;
    private zendesk.support.guide.HelpMvp.View view;
    static {
        HelpAdapterPresenter.RETRY_ACTION_ID = 5;
    }

    public HelpAdapterPresenter(zendesk.support.guide.HelpMvp.View helpMvp$View, zendesk.support.guide.HelpMvp.Model helpMvp$Model2, NetworkInfoProvider networkInfoProvider3, zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration4) {
        super();
        ArrayList arrayList = new ArrayList();
        this.helpItems = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.filteredItems = arrayList2;
        HelpAdapterPresenter.2 anon = new HelpAdapterPresenter.2(this);
        this.callback = anon;
        this.view = view;
        this.model = model2;
        this.networkInfoProvider = networkInfoProvider3;
        this.helpCenterUiConfig = helpCenterConfiguration4;
    }

    static void access$000(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        helpAdapterPresenter.requestHelpContent();
    }

    static boolean access$102(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, boolean z2) {
        helpAdapterPresenter.hasError = z2;
        return z2;
    }

    static List access$200(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        return helpAdapterPresenter.helpItems;
    }

    static List access$202(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, List list2) {
        helpAdapterPresenter.helpItems = list2;
        return list2;
    }

    static zendesk.support.guide.HelpCenterConfiguration access$300(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        return helpAdapterPresenter.helpCenterUiConfig;
    }

    static List access$400(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        return helpAdapterPresenter.filteredItems;
    }

    static List access$402(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, List list2) {
        helpAdapterPresenter.filteredItems = list2;
        return list2;
    }

    static List access$500(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, List list2) {
        return helpAdapterPresenter.getCollapsedCategories(list2);
    }

    static boolean access$602(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, boolean z2) {
        helpAdapterPresenter.noResults = z2;
        return z2;
    }

    static zendesk.support.guide.HelpMvp.View access$700(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        return helpAdapterPresenter.view;
    }

    static zendesk.support.guide.HelpCenterMvp.Presenter access$800(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter) {
        return helpAdapterPresenter.contentPresenter;
    }

    static void access$900(zendesk.support.guide.HelpAdapterPresenter helpAdapterPresenter, SeeAllArticlesItem seeAllArticlesItem2) {
        helpAdapterPresenter.loadMoreArticles(seeAllArticlesItem2);
    }

    private void addItem(int i, HelpItem helpItem2) {
        this.filteredItems.add(i, helpItem2);
        this.view.addItem(i, helpItem2);
    }

    private void collapseItem(int i) {
        int viewType;
        final int i2 = 1;
        if (i >= itemCount -= i2) {
        }
        i += i2;
        while (obj3 < this.filteredItems.size()) {
            if (i2 != (HelpItem)this.filteredItems.get(obj3).getViewType()) {
            }
            removeItem(obj3);
        }
    }

    private void expandItem(CategoryItem categoryItem, int i2) {
        Object iterator;
        int next;
        String str;
        String str2;
        int obj6;
        i2++;
        Iterator obj5 = categoryItem.getSections().iterator();
        for (HelpItem next3 : obj5) {
            addItem(obj6, next3);
            obj6++;
            iterator = (SectionItem)next3.getChildren().iterator();
            for (HelpItem next : iterator) {
                addItem(obj6, next);
                obj6++;
            }
            addItem(obj6, (HelpItem)iterator.next());
            obj6++;
        }
    }

    private List<HelpItem> getCollapsedCategories(List<HelpItem> list) {
        int size;
        int i3;
        int i2;
        int viewType;
        int i;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (list.size() == 0) {
            } else {
                i3 = 0;
                i2 = i3;
                while (i2 < list.size()) {
                    if (1 == (HelpItem)list.get(i2).getViewType()) {
                    }
                    i2++;
                    arrayList.add(list.get(i2));
                    (CategoryItem)list.get(i2).setExpanded(i3);
                }
            }
        }
        return arrayList;
    }

    private int getPaddingItemCount() {
        return this.helpCenterUiConfig.isContactUsButtonVisible();
    }

    private void loadMoreArticles(SeeAllArticlesItem seeAllArticlesItem) {
        Object rETRY_ACTION_ID;
        zendesk.support.guide.HelpMvp.Model networkAvailable;
        String[] labelNames;
        zendesk.support.guide.HelpAdapterPresenter.4 anon;
        Object obj6;
        rETRY_ACTION_ID = seeAllArticlesItem.getSection();
        HelpAdapterPresenter.3 anon2 = new HelpAdapterPresenter.3(this, seeAllArticlesItem);
        if (this.networkInfoProvider.isNetworkAvailable()) {
            anon = new HelpAdapterPresenter.4(this, seeAllArticlesItem, rETRY_ACTION_ID, anon2);
            this.model.getArticlesForSection(rETRY_ACTION_ID, this.helpCenterUiConfig.getLabelNames(), anon);
        } else {
            this.retryAction = anon2;
            this.networkInfoProvider.addRetryAction(HelpAdapterPresenter.RETRY_ACTION_ID, anon2);
        }
    }

    private void removeItem(int i) {
        this.filteredItems.remove(i);
        this.view.removeItem(i);
    }

    private void requestHelpContent() {
        boolean networkAvailable;
        NetworkInfoProvider networkInfoProvider;
        Integer rETRY_ACTION_ID;
        if (!this.networkInfoProvider.isNetworkAvailable()) {
            networkAvailable = new HelpAdapterPresenter.1(this);
            this.retryAction = networkAvailable;
            this.networkInfoProvider.addRetryAction(HelpAdapterPresenter.RETRY_ACTION_ID, networkAvailable);
        }
        this.model.getArticles(this.helpCenterUiConfig.getCategoryIds(), this.helpCenterUiConfig.getSectionIds(), this.helpCenterUiConfig.getLabelNames(), this.callback);
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public HelpItem getItem(int i) {
        return (HelpItem)this.filteredItems.get(i);
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public int getItemCount() {
        if (this.hasError != null) {
            return 0;
        }
        return Math.max(size += paddingItemCount, 1);
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public HelpItem getItemForBinding(int i) {
        int filteredItems;
        int i2;
        int obj3;
        i2 = 0;
        if (this.filteredItems.size() > 0 && i < this.filteredItems.size()) {
            if (i < this.filteredItems.size()) {
                i2 = obj3;
            }
        }
        return i2;
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public int getItemViewType(int i) {
        List filteredItems;
        int obj2;
        if (this.noResults) {
            return 7;
        }
        if (this.filteredItems.size() > 0) {
            if (i == this.filteredItems.size()) {
                obj2 = 8;
            } else {
                obj2 = (HelpItem)this.filteredItems.get(i).getViewType();
            }
        } else {
            obj2 = 5;
        }
        return obj2;
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public void onAttached() {
        this.networkInfoProvider.register();
        if (a.g(this.helpItems)) {
            requestHelpContent();
        }
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public boolean onCategoryClick(CategoryItem categoryItem, int i2) {
        int filteredItems;
        Object obj2;
        if (categoryItem == null) {
            return 0;
        }
        boolean obj3 = categoryItem.setExpanded(obj3 ^= 1);
        if (obj3 != null) {
            expandItem(categoryItem, this.filteredItems.indexOf(categoryItem));
        } else {
            collapseItem(this.filteredItems.indexOf(categoryItem));
        }
        return obj3;
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public void onDetached() {
        this.networkInfoProvider.removeRetryAction(HelpAdapterPresenter.RETRY_ACTION_ID);
        this.networkInfoProvider.unregister();
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public void onSeeAllClick(SeeAllArticlesItem seeAllArticlesItem) {
        loadMoreArticles(seeAllArticlesItem);
    }

    @Override // zendesk.support.guide.HelpMvp$Presenter
    public void setContentPresenter(zendesk.support.guide.HelpCenterMvp.Presenter helpCenterMvp$Presenter) {
        this.contentPresenter = presenter;
    }
}
