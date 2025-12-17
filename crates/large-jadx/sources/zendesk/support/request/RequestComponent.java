package zendesk.support.request;

/* loaded from: classes3.dex */
public interface RequestComponent {
    public abstract void inject(zendesk.support.request.RequestActivity requestActivity);

    public abstract void inject(zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled);

    public abstract void inject(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled);
}
