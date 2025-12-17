package zendesk.messaging.ui;

import f.g.e.g;
import zendesk.messaging.AgentDetails;

/* loaded from: classes3.dex */
class AvatarStateFactory {
    zendesk.messaging.ui.AvatarState createAvatarState(AgentDetails agentDetails) {
        String substring;
        int i;
        int i2;
        if (g.c(agentDetails.getAgentName())) {
            substring = agentDetails.getAgentName().substring(0, 1);
        } else {
            substring = "";
        }
        AvatarState avatarState = new AvatarState(agentDetails.getAgentId(), substring, agentDetails.getAvatarPath(), agentDetails.getAvatarDrawableRes());
        return avatarState;
    }
}
