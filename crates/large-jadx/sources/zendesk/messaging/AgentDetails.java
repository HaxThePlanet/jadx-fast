package zendesk.messaging;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class AgentDetails implements Serializable {

    private final String agentId;
    private final String agentName;
    private final Integer avatarDrawableRes;
    private final String avatarPath;
    private final boolean isBot;
    public AgentDetails(String string, String string2, boolean z3) {
        super(string, string2, z3, 0, 0);
    }

    public AgentDetails(String string, String string2, boolean z3, Integer integer4) {
        super(string, string2, z3, integer4, 0);
    }

    private AgentDetails(String string, String string2, boolean z3, Integer integer4, String string5) {
        super();
        this.agentName = string;
        this.agentId = string2;
        this.isBot = z3;
        this.avatarDrawableRes = integer4;
        this.avatarPath = string5;
    }

    @Override // java.io.Serializable
    public String getAgentId() {
        return this.agentId;
    }

    @Override // java.io.Serializable
    public String getAgentName() {
        return this.agentName;
    }

    @Override // java.io.Serializable
    public Integer getAvatarDrawableRes() {
        return this.avatarDrawableRes;
    }

    @Override // java.io.Serializable
    public String getAvatarPath() {
        return this.avatarPath;
    }

    @Override // java.io.Serializable
    public boolean isBot() {
        return this.isBot;
    }
}
