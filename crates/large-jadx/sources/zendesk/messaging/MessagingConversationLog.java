package zendesk.messaging;

import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
class MessagingConversationLog implements zendesk.messaging.ConversationLog {

    private static final Comparator<zendesk.messaging.MessagingEvent> TIMESTAMP_COMPARATOR;
    private final List<zendesk.messaging.Event> events;
    private final zendesk.messaging.MessagingEventSerializer messagingEventSerializer;
    private final List<zendesk.messaging.MessagingItem> messagingItems;
    static {
        MessagingConversationLog.1 anon = new MessagingConversationLog.1();
        MessagingConversationLog.TIMESTAMP_COMPARATOR = anon;
    }

    MessagingConversationLog(zendesk.messaging.MessagingEventSerializer messagingEventSerializer) {
        super();
        this.messagingEventSerializer = messagingEventSerializer;
        ArrayList obj1 = new ArrayList();
        this.messagingItems = obj1;
        obj1 = new ArrayList();
        this.events = obj1;
    }

    @Override // zendesk.messaging.ConversationLog
    void addEvent(zendesk.messaging.Event event) {
        this.events.add(event);
    }

    @Override // zendesk.messaging.ConversationLog
    public String getLog() {
        int i;
        String serialize;
        boolean z;
        ArrayList arrayList = new ArrayList(size += size2);
        arrayList.addAll(this.messagingItems);
        arrayList.addAll(this.events);
        if (a.g(arrayList)) {
            return "";
        }
        Collections.sort(arrayList, MessagingConversationLog.TIMESTAMP_COMPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < arrayList.size()) {
            serialize = this.messagingEventSerializer.serialize((MessagingEvent)arrayList.get(i));
            stringBuilder.append(serialize);
            if (g.c(serialize) && i < size4--) {
            }
            i++;
            stringBuilder.append(serialize);
            if (i < size4--) {
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void setMessagingItems(List<zendesk.messaging.MessagingItem> list) {
        boolean messagingItems;
        this.messagingItems.clear();
        if (a.i(list)) {
            this.messagingItems.addAll(list);
        }
    }
}
