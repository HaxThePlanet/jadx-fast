package zendesk.messaging;

import android.content.res.Resources;
import g.b.b;
import j.a.a;
import java.util.List;

/* loaded from: classes3.dex */
public final class MessagingModel_Factory implements b<zendesk.messaging.MessagingModel> {

    private final a<zendesk.messaging.MessagingConversationLog> conversationLogProvider;
    private final a<List<zendesk.messaging.Engine>> enginesProvider;
    private final a<zendesk.messaging.MessagingConfiguration> messagingConfigurationProvider;
    private final a<Resources> resourcesProvider;
    public MessagingModel_Factory(a<Resources> a, a<List<zendesk.messaging.Engine>> a2, a<zendesk.messaging.MessagingConfiguration> a3, a<zendesk.messaging.MessagingConversationLog> a4) {
        super();
        this.resourcesProvider = a;
        this.enginesProvider = a2;
        this.messagingConfigurationProvider = a3;
        this.conversationLogProvider = a4;
    }

    public static zendesk.messaging.MessagingModel_Factory create(a<Resources> a, a<List<zendesk.messaging.Engine>> a2, a<zendesk.messaging.MessagingConfiguration> a3, a<zendesk.messaging.MessagingConversationLog> a4) {
        MessagingModel_Factory messagingModel_Factory = new MessagingModel_Factory(a, a2, a3, a4);
        return messagingModel_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.MessagingModel get() {
        MessagingModel messagingModel = new MessagingModel((Resources)this.resourcesProvider.get(), (List)this.enginesProvider.get(), (MessagingConfiguration)this.messagingConfigurationProvider.get(), (MessagingConversationLog)this.conversationLogProvider.get());
        return messagingModel;
    }
}
