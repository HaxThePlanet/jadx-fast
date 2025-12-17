package zendesk.core;

/* loaded from: classes3.dex */
class ZendeskProviderStore implements zendesk.core.ProviderStore {

    private final zendesk.core.PushRegistrationProvider pushRegistrationProvider;
    private final zendesk.core.UserProvider userProvider;
    ZendeskProviderStore(zendesk.core.UserProvider userProvider, zendesk.core.PushRegistrationProvider pushRegistrationProvider2) {
        super();
        this.userProvider = userProvider;
        this.pushRegistrationProvider = pushRegistrationProvider2;
    }

    @Override // zendesk.core.ProviderStore
    public zendesk.core.PushRegistrationProvider pushRegistrationProvider() {
        return this.pushRegistrationProvider;
    }

    @Override // zendesk.core.ProviderStore
    public zendesk.core.UserProvider userProvider() {
        return this.userProvider;
    }
}
