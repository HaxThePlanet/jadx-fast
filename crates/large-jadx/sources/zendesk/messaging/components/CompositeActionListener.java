package zendesk.messaging.components;

/* loaded from: classes3.dex */
public abstract class CompositeActionListener<T>  implements zendesk.messaging.components.ActionListener<T> {
    public static <T> zendesk.messaging.components.CompositeActionListener<T> create() {
        DefaultCompositeActionListener defaultCompositeActionListener = new DefaultCompositeActionListener();
        return defaultCompositeActionListener;
    }

    public abstract void addListener(zendesk.messaging.components.ActionListener<T> actionListener);

    @Override // zendesk.messaging.components.ActionListener
    public abstract void clearListeners();
}
