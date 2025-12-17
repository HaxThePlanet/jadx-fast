package zendesk.core;

/* loaded from: classes3.dex */
class ZendeskAuthenticationProvider implements zendesk.core.AuthenticationProvider {

    private final zendesk.core.IdentityManager identityManager;
    ZendeskAuthenticationProvider(zendesk.core.IdentityManager identityManager) {
        super();
        this.identityManager = identityManager;
    }

    @Override // zendesk.core.AuthenticationProvider
    public zendesk.core.Identity getIdentity() {
        return this.identityManager.getIdentity();
    }
}
