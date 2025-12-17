package zendesk.support;

/* loaded from: classes3.dex */
class ZendeskProviderStore implements zendesk.support.ProviderStore {

    private final zendesk.support.HelpCenterProvider helpCenterProvider;
    private final zendesk.support.RequestProvider requestProvider;
    private final zendesk.support.UploadProvider uploadProvider;
    ZendeskProviderStore(zendesk.support.HelpCenterProvider helpCenterProvider, zendesk.support.RequestProvider requestProvider2, zendesk.support.UploadProvider uploadProvider3) {
        super();
        this.helpCenterProvider = helpCenterProvider;
        this.requestProvider = requestProvider2;
        this.uploadProvider = uploadProvider3;
    }

    @Override // zendesk.support.ProviderStore
    public zendesk.support.HelpCenterProvider helpCenterProvider() {
        return this.helpCenterProvider;
    }

    @Override // zendesk.support.ProviderStore
    public zendesk.support.RequestProvider requestProvider() {
        return this.requestProvider;
    }

    @Override // zendesk.support.ProviderStore
    public zendesk.support.UploadProvider uploadProvider() {
        return this.uploadProvider;
    }
}
