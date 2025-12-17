package zendesk.messaging.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class DefaultCompositeActionListener<T>  extends zendesk.messaging.components.CompositeActionListener<T> {

    private final List<zendesk.messaging.components.ActionListener<T>> listeners;
    public DefaultCompositeActionListener() {
        super();
        ArrayList arrayList = new ArrayList();
        this.listeners = arrayList;
    }

    public void addListener(zendesk.messaging.components.ActionListener<T> actionListener) {
        final List listeners = this.listeners;
        this.listeners.add(actionListener);
        return;
        synchronized (listeners) {
            listeners = this.listeners;
            this.listeners.add(actionListener);
        }
    }

    @Override // zendesk.messaging.components.CompositeActionListener
    public void clearListeners() {
        this.listeners.clear();
    }

    public void onAction(T t) {
        Object next;
        final List listeners = this.listeners;
        Iterator iterator = this.listeners.iterator();
        synchronized (listeners) {
            for (ActionListener next : iterator) {
                next.onAction(t);
            }
            try {
                throw t;
            }
        }
    }
}
