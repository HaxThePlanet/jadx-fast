package zendesk.messaging;

import java.util.List;
import o.a.a;

/* loaded from: classes3.dex */
public interface MessagingApi {
    public abstract zendesk.messaging.AgentDetails getBotAgentDetails();

    public abstract List<a> getConfigurations();

    public abstract zendesk.messaging.ConversationLog getConversationLog();

    public abstract List<zendesk.messaging.Engine.TransferOptionDescription> getTransferOptionDescriptions();
}
