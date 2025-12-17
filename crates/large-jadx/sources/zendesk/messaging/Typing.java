package zendesk.messaging;

/* loaded from: classes3.dex */
public class Typing {

    private final zendesk.messaging.AgentDetails agentDetails;
    private final boolean isTyping;
    public Typing(boolean z) {
        super(z, 0);
    }

    public Typing(boolean z, zendesk.messaging.AgentDetails agentDetails2) {
        super();
        this.isTyping = z;
        this.agentDetails = agentDetails2;
    }

    public zendesk.messaging.AgentDetails getAgentDetails() {
        return this.agentDetails;
    }

    public boolean isTyping() {
        return this.isTyping;
    }
}
