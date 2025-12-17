package zendesk.messaging;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class ObservableEngine implements zendesk.messaging.Engine {

    private final Set<zendesk.messaging.Engine.UpdateObserver> updateObservers;
    public ObservableEngine() {
        super();
        HashSet hashSet = new HashSet();
        this.updateObservers = hashSet;
    }

    @Override // zendesk.messaging.Engine
    public void isConversationOngoing(zendesk.messaging.Engine.ConversationOnGoingCallback engine$ConversationOnGoingCallback) {
        conversationOnGoingCallback.onConversationOngoing(this, false);
    }

    @Override // zendesk.messaging.Engine
    public boolean isConversationOngoing() {
        return 0;
    }

    @Override // zendesk.messaging.Engine
    public void notifyObservers(zendesk.messaging.Update update) {
        Object next;
        Iterator iterator = this.updateObservers.iterator();
        for (Engine.UpdateObserver next : iterator) {
            next.update(update);
        }
    }

    @Override // zendesk.messaging.Engine
    public boolean registerObserver(zendesk.messaging.Engine.UpdateObserver engine$UpdateObserver) {
        return this.updateObservers.add(updateObserver);
    }

    @Override // zendesk.messaging.Engine
    public boolean unregisterObserver(zendesk.messaging.Engine.UpdateObserver engine$UpdateObserver) {
        return this.updateObservers.remove(updateObserver);
    }
}
