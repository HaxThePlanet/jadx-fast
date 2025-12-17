package zendesk.answerbot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.Engine.TransferOptionDescription;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.MessagingItem.TextQuery;
import zendesk.messaging.MessagingItem.TextResponse;

/* loaded from: classes3.dex */
class AnswerBotCellFactory {
    List<MessagingItem> create(AgentDetails agentDetails, List<zendesk.answerbot.AnswerBotInteraction> list2, List<Engine.TransferOptionDescription> list3) {
        Object obj4;
        ArrayList arrayList = new ArrayList();
        AnswerBotCellFactory.1 anon = new AnswerBotCellFactory.1(this, arrayList, agentDetails, list3);
        final Iterator obj3 = list2.iterator();
        for (AnswerBotInteraction obj4 : obj3) {
            obj4.handle(anon);
        }
        return arrayList;
    }
}
