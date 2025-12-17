package zendesk.support.request;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import d.u.d;
import d.u.q;
import f.g.c.a;
import f.g.d.f;
import f.g.e.g;
import java.util.concurrent.atomic.AtomicReference;
import o.b.k;
import o.b.o;
import o.b.p;

/* loaded from: classes3.dex */
class ComponentRequestRouter implements k<zendesk.support.request.ComponentRequestRouter.RequestScreen> {

    private final d activity;
    private final zendesk.support.request.RequestComponent component;
    private zendesk.support.request.RequestView currentScreen;
    private final zendesk.support.request.RequestViewConversationsDisabled disabledView;
    private final zendesk.support.request.RequestViewConversationsEnabled enabledView;
    private final boolean isCleanStart;
    private final zendesk.support.request.RequestViewLoading loadingView;
    private final ViewGroup root;
    private final AtomicReference<zendesk.support.request.ComponentRequestRouter.RequestScreen> screen;

    static enum RequestScreen {

        Loading,
        EmailForm,
        Conversation,
        Fin;
    }

    static class RequestRouterSelector implements p<zendesk.support.request.ComponentRequestRouter.RequestScreen> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentRequestRouter.RequestScreen selectData(o o) {
            zendesk.support.request.StateSettings settings = StateConfig.fromState(o).getSettings();
            zendesk.support.request.StateError obj10 = StateError.fromState(o);
            final int i2 = 0;
            final String str3 = "RequestActivity";
            if (obj10.getState() == StateError.ErrorType.NoAccess) {
                Object[] arr = new Object[1];
                arr[i2] = obj10.getMessage();
                a.e(str3, "Network returned 'No Access'. Ticket is not longer valid. Error: '%s'", arr);
                return ComponentRequestRouter.RequestScreen.Fin;
            }
            if (!settings.hasSettings()) {
                return ComponentRequestRouter.RequestScreen.Loading;
            }
            if (settings.isConversationsEnabled()) {
                return ComponentRequestRouter.RequestScreen.Conversation;
            }
            if (g.c(StateConversation.fromState(o).getRemoteId())) {
                a.k(str3, "Conversations are disabled. Exiting RequestActivity", new Object[i2]);
                return ComponentRequestRouter.RequestScreen.Fin;
            }
            if (!settings.hasIdentityEmailAddress() && settings.isNeverRequestEmailOn()) {
                if (settings.isNeverRequestEmailOn()) {
                    a.k(str3, "Conversations are disabled, never request email is enabled, with this configuration tickets would go into a black hole. Exiting RequestActivity.", new Object[i2]);
                    return ComponentRequestRouter.RequestScreen.Fin;
                }
            }
            return ComponentRequestRouter.RequestScreen.EmailForm;
        }
    }
    ComponentRequestRouter(d d, ViewGroup viewGroup2, zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled3, zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled4, zendesk.support.request.RequestViewLoading requestViewLoading5, zendesk.support.request.RequestComponent requestComponent6, boolean z7) {
        super();
        this.activity = d;
        this.root = viewGroup2;
        this.disabledView = requestViewConversationsDisabled3;
        this.enabledView = requestViewConversationsEnabled4;
        this.loadingView = requestViewLoading5;
        this.component = requestComponent6;
        this.isCleanStart = z7;
        AtomicReference obj1 = new AtomicReference();
        this.screen = obj1;
    }

    static zendesk.support.request.ComponentRequestRouter create(d d, boolean z2, zendesk.support.request.RequestComponent requestComponent3) {
        super(d, (ViewGroup)d.findViewById(f.j), (RequestViewConversationsDisabled)d.findViewById(f.e), (RequestViewConversationsEnabled)d.findViewById(f.d), (RequestViewLoading)d.findViewById(f.f), requestComponent3, z2);
        return componentRequestRouter;
    }

    private void displayView(View view, View... view2Arr2) {
        int i2;
        d dVar;
        int i;
        dVar = new d();
        q.a(this.root, dVar);
        view.setVisibility(0);
        while (i2 < view2Arr2.length) {
            view2Arr2[i2].setVisibility(8);
            i2++;
        }
        this.activity.invalidateOptionsMenu();
        q.c(this.root);
    }

    @Override // o.b.k
    zendesk.support.request.RequestView getCurrentScreen() {
        return this.currentScreen;
    }

    p<zendesk.support.request.ComponentRequestRouter.RequestScreen> getSelector() {
        ComponentRequestRouter.RequestRouterSelector requestRouterSelector = new ComponentRequestRouter.RequestRouterSelector();
        return requestRouterSelector;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentRequestRouter.RequestScreen)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentRequestRouter.RequestScreen componentRequestRouter$RequestScreen) {
        Object component;
        zendesk.support.request.RequestViewLoading isCleanStart;
        String str;
        zendesk.support.request.RequestViewConversationsDisabled obj6;
        if (this.screen.getAndSet(requestScreen) == requestScreen) {
        }
        obj6 = ComponentRequestRouter.1.$SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen[requestScreen.ordinal()];
        component = "RequestActivity";
        int i = 2;
        final int i2 = 1;
        final int i3 = 0;
        if (obj6 != i2) {
            if (obj6 != i) {
                if (obj6 != 3) {
                    if (obj6 != 4) {
                    } else {
                        a.b(component, "Installing screen: 'Finish'", new Object[i3]);
                        this.activity.finish();
                    }
                } else {
                    a.b(component, "Installing screen: 'Conversations Enabled Screen'", new Object[i3]);
                    obj6 = this.enabledView;
                    this.currentScreen = obj6;
                    View[] arr2 = new View[i];
                    arr2[i3] = this.disabledView;
                    arr2[i2] = this.loadingView;
                    displayView(obj6, arr2);
                    this.enabledView.init(this.component, this.isCleanStart);
                }
            } else {
                a.b(component, "Installing screen: 'Conversations Disabled Screen'", new Object[i3]);
                obj6 = this.disabledView;
                this.currentScreen = obj6;
                View[] arr = new View[i];
                arr[i3] = this.enabledView;
                arr[i2] = this.loadingView;
                displayView(obj6, arr);
                this.disabledView.init(this.component);
            }
        } else {
            a.b(component, "Installing screen: 'Loading Screen'", new Object[i3]);
            obj6 = this.loadingView;
            this.currentScreen = obj6;
            component = new View[i];
            component[i3] = this.disabledView;
            component[i2] = this.enabledView;
            displayView(obj6, component);
        }
    }
}
