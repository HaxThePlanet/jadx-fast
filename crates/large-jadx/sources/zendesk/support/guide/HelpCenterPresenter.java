package zendesk.support.guide;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkAware;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.messaging.Engine;
import zendesk.support.HelpCenterSettings;
import zendesk.support.SearchArticle;

/* loaded from: classes3.dex */
class HelpCenterPresenter implements zendesk.support.guide.HelpCenterMvp.Presenter, NetworkAware {

    private static final Integer NETWORK_AWARE_ID;
    private static final Integer RETRY_ACTION_ID;
    private ActionHandlerRegistry actionHandlerRegistry;
    private zendesk.support.guide.HelpCenterConfiguration config;
    private List<Engine> engines;
    private HelpCenterSettings helpCenterSettings;
    private Set<RetryAction> internalRetryActions;
    private zendesk.support.guide.HelpCenterMvp.Model model;
    private NetworkInfoProvider networkInfoProvider;
    private boolean networkPreviouslyUnavailable;
    private zendesk.support.guide.HelpCenterMvp.View view;

    class ViewSafeRetryZendeskCallback extends f<List<SearchArticle>> {

        private String query;
        final zendesk.support.guide.HelpCenterPresenter this$0;
        ViewSafeRetryZendeskCallback(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter, String string2) {
            this.this$0 = helpCenterPresenter;
            super();
            this.query = string2;
        }

        static String access$200(zendesk.support.guide.HelpCenterPresenter.ViewSafeRetryZendeskCallback helpCenterPresenter$ViewSafeRetryZendeskCallback) {
            return viewSafeRetryZendeskCallback.query;
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            Object aRTICLES_LOAD;
            Object anon;
            Object obj3;
            if (HelpCenterPresenter.access$000(this.this$0) != null) {
                HelpCenterPresenter.access$000(this.this$0).hideLoadingState();
                anon = new HelpCenterPresenter.ViewSafeRetryZendeskCallback.2(this);
                HelpCenterPresenter.access$000(this.this$0).showLoadArticleErrorWithRetry(HelpCenterMvp.ErrorType.ARTICLES_LOAD, anon);
            } else {
                anon = new HelpCenterPresenter.ViewSafeRetryZendeskCallback.3(this, a);
                HelpCenterPresenter.access$100(this.this$0).add(anon);
            }
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((List)object);
        }

        public void onSuccess(List<SearchArticle> list) {
            Object set;
            Object query;
            List obj3;
            if (HelpCenterPresenter.access$000(this.this$0) != null) {
                HelpCenterPresenter.access$000(this.this$0).hideLoadingState();
                HelpCenterPresenter.access$000(this.this$0).showSearchResults(list, this.query);
                if (this.this$0.shouldShowContactUsButton()) {
                    HelpCenterPresenter.access$000(this.this$0).showContactUsButton();
                }
            } else {
                query = new HelpCenterPresenter.ViewSafeRetryZendeskCallback.1(this, list);
                HelpCenterPresenter.access$100(this.this$0).add(query);
            }
        }
    }
    static {
        HelpCenterPresenter.NETWORK_AWARE_ID = 31;
        HelpCenterPresenter.RETRY_ACTION_ID = 8642;
    }

    HelpCenterPresenter(zendesk.support.guide.HelpCenterMvp.View helpCenterMvp$View, zendesk.support.guide.HelpCenterMvp.Model helpCenterMvp$Model2, NetworkInfoProvider networkInfoProvider3, ActionHandlerRegistry actionHandlerRegistry4) {
        super();
        HashSet hashSet = new HashSet();
        this.internalRetryActions = hashSet;
        this.view = view;
        this.model = model2;
        this.networkInfoProvider = networkInfoProvider3;
        this.actionHandlerRegistry = actionHandlerRegistry4;
    }

    static zendesk.support.guide.HelpCenterMvp.View access$000(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter) {
        return helpCenterPresenter.view;
    }

    static Set access$100(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter) {
        return helpCenterPresenter.internalRetryActions;
    }

    static HelpCenterSettings access$302(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter, HelpCenterSettings helpCenterSettings2) {
        helpCenterPresenter.helpCenterSettings = helpCenterSettings2;
        return helpCenterSettings2;
    }

    static zendesk.support.guide.HelpCenterConfiguration access$400(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter) {
        return helpCenterPresenter.config;
    }

    static ActionHandlerRegistry access$500(zendesk.support.guide.HelpCenterPresenter helpCenterPresenter) {
        return helpCenterPresenter.actionHandlerRegistry;
    }

    private void invokeRetryActions() {
        Object next;
        Iterator iterator = this.internalRetryActions.iterator();
        for (RetryAction next : iterator) {
            next.onRetry();
        }
        this.internalRetryActions.clear();
    }

    public void init(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration, List<Engine> list2) {
        this.config = helpCenterConfiguration;
        this.engines = list2;
        this.view.showLoadingState();
        HelpCenterPresenter.5 obj2 = new HelpCenterPresenter.5(this);
        this.model.getSettings(obj2);
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onErrorWithRetry(zendesk.support.guide.HelpCenterMvp.ErrorType helpCenterMvp$ErrorType, RetryAction retryAction2) {
        Set internalRetryActions;
        zendesk.support.guide.HelpCenterPresenter.3 anon;
        zendesk.support.guide.HelpCenterMvp.View view = this.view;
        if (view != null) {
            if (view.isShowingHelp()) {
                this.view.hideLoadingState();
                this.view.showLoadArticleErrorWithRetry(errorType, retryAction2);
            }
        } else {
            anon = new HelpCenterPresenter.3(this, errorType, retryAction2);
            this.internalRetryActions.add(anon);
        }
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onLoad() {
        boolean internalRetryActions;
        zendesk.support.guide.HelpCenterPresenter.2 anon;
        if (shouldShowContactUsButton()) {
            internalRetryActions = this.view;
            if (internalRetryActions != null) {
                internalRetryActions.showContactUsButton();
            } else {
                anon = new HelpCenterPresenter.2(this);
                this.internalRetryActions.add(anon);
            }
        }
        zendesk.support.guide.HelpCenterMvp.View view = this.view;
        if (view != null) {
            view.announceContentLoaded();
        }
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onNetworkAvailable() {
        Object internalRetryActions;
        int anon;
        int i = 0;
        final String str2 = "HelpCenterActivity";
        a.b(str2, "Network is available.", new Object[i]);
        if (!this.networkPreviouslyUnavailable) {
            a.b(str2, "Network was not previously unavailable, no need to dismiss Snackbar", new Object[i]);
        }
        this.networkPreviouslyUnavailable = i;
        zendesk.support.guide.HelpCenterMvp.View view = this.view;
        if (view != null) {
            view.setSearchEnabled(true);
            this.view.dismissError();
        } else {
            anon = new HelpCenterPresenter.4(this);
            this.internalRetryActions.add(anon);
        }
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onNetworkUnavailable() {
        int view;
        view = 0;
        a.b("HelpCenterActivity", "Network is unavailable.", new Object[view]);
        this.networkPreviouslyUnavailable = true;
        zendesk.support.guide.HelpCenterMvp.View view3 = this.view;
        if (view3 != null) {
            view3.setSearchEnabled(view);
            this.view.showNoConnectionError();
            this.view.hideLoadingState();
        }
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onPause() {
        this.view = 0;
        this.networkInfoProvider.removeNetworkAwareListener(HelpCenterPresenter.NETWORK_AWARE_ID);
        this.networkInfoProvider.removeRetryAction(HelpCenterPresenter.RETRY_ACTION_ID);
        this.networkInfoProvider.unregister();
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onResume(zendesk.support.guide.HelpCenterMvp.View helpCenterMvp$View) {
        zendesk.support.guide.HelpCenterMvp.View obj3;
        this.view = view;
        this.networkInfoProvider.addNetworkAwareListener(HelpCenterPresenter.NETWORK_AWARE_ID, this);
        this.networkInfoProvider.register();
        if (!this.networkInfoProvider.isNetworkAvailable()) {
            view.showNoConnectionError();
            view.hideLoadingState();
            this.networkPreviouslyUnavailable = true;
        }
        invokeRetryActions();
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public void onSearchSubmit(String string) {
        Object config;
        Object rETRY_ACTION_ID;
        List categoryIds;
        List sectionIds;
        String str;
        String[] labelNames;
        zendesk.support.guide.HelpCenterPresenter.ViewSafeRetryZendeskCallback viewSafeRetryZendeskCallback;
        Object obj8;
        if (this.networkInfoProvider.isNetworkAvailable()) {
            this.view.dismissError();
            this.view.showLoadingState();
            this.view.clearSearchResults();
            viewSafeRetryZendeskCallback = new HelpCenterPresenter.ViewSafeRetryZendeskCallback(this, string);
            this.model.search(this.config.getCategoryIds(), this.config.getSectionIds(), string, this.config.getLabelNames(), viewSafeRetryZendeskCallback);
        } else {
            config = new HelpCenterPresenter.1(this, string);
            this.networkInfoProvider.addRetryAction(HelpCenterPresenter.RETRY_ACTION_ID, config);
        }
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    boolean shouldShowContactUsButton() {
        int i;
        int i2;
        final int i3 = 0;
        i = this.actionHandlerRegistry.handlerByAction("action_contact_option") != null ? i2 : i3;
        if (this.config.isContactUsButtonVisible()) {
            if (i == 0) {
                if (a.i(this.engines)) {
                } else {
                    i2 = i3;
                }
            }
        } else {
        }
        return i2;
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public boolean shouldShowConversationsMenuItem() {
        zendesk.core.ActionHandler showConversationsMenuButton;
        int i;
        if (this.actionHandlerRegistry.handlerByAction("action_conversation_list") != null && this.config.isShowConversationsMenuButton()) {
            i = this.config.isShowConversationsMenuButton() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // zendesk.support.guide.HelpCenterMvp$Presenter
    public boolean shouldShowSearchMenuItem() {
        HelpCenterSettings helpCenterSettings;
        int i;
        helpCenterSettings = this.helpCenterSettings;
        if (helpCenterSettings != null && helpCenterSettings.isEnabled()) {
            i = helpCenterSettings.isEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }
}
