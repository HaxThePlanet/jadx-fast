package zendesk.support.request;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.g;
import o.b.f;
import o.b.j;
import zendesk.core.AnonymousIdentity;
import zendesk.core.AuthenticationProvider;
import zendesk.support.SupportSdkSettings;
import zendesk.support.SupportSettingsProvider;

/* loaded from: classes3.dex */
class ActionLoadSettings implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final AuthenticationProvider authProvider;
    private final SupportSettingsProvider settingsProvider;
    ActionLoadSettings(zendesk.support.request.ActionFactory actionFactory, SupportSettingsProvider supportSettingsProvider2, AuthenticationProvider authenticationProvider3) {
        super();
        this.actionFactory = actionFactory;
        this.settingsProvider = supportSettingsProvider2;
        this.authProvider = authenticationProvider3;
    }

    static zendesk.support.request.StateSettings access$000(zendesk.support.request.ActionLoadSettings actionLoadSettings, SupportSdkSettings supportSdkSettings2) {
        return actionLoadSettings.constructSettings(supportSdkSettings2);
    }

    static zendesk.support.request.ActionFactory access$100(zendesk.support.request.ActionLoadSettings actionLoadSettings) {
        return actionLoadSettings.actionFactory;
    }

    private zendesk.support.request.StateSettings constructSettings(SupportSdkSettings supportSdkSettings) {
        zendesk.core.Identity identity = this.authProvider.getIdentity();
        if (identity instanceof AnonymousIdentity) {
            return StateSettings.fromSupportSettings(supportSdkSettings, g.c((AnonymousIdentity)identity.getEmail()), g.c(identity.getName()));
        }
        int i = 1;
        return StateSettings.fromSupportSettings(supportSdkSettings, i, i);
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
        f.c(this.actionFactory.loadSettings());
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        ActionLoadSettings.1 anon = new ActionLoadSettings.1(this, f, callback3);
        this.settingsProvider.getSettings(anon);
    }
}
