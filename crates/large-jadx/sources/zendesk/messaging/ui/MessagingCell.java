package zendesk.messaging.ui;

/* loaded from: classes3.dex */
class MessagingCell<T, V extends android.view.View & zendesk.messaging.ui.Updatable<T>>  {

    private final String id;
    private final int layoutRes;
    private final T state;
    private final Class<V> viewClassType;
    MessagingCell(String string, T t2, int i3, Class<V> class4) {
        super();
        this.id = string;
        this.state = t2;
        this.layoutRes = i3;
        this.viewClassType = class4;
    }

    boolean areContentsTheSame(zendesk.messaging.ui.MessagingCell messagingCell) {
        boolean equals;
        Object obj3;
        if (getId().equals(messagingCell.getId()) && messagingCell.state.equals(this.state)) {
            obj3 = messagingCell.state.equals(this.state) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    void bind(V v) {
        (Updatable)v.update(this.state);
    }

    String getId() {
        return this.id;
    }

    int getLayoutRes() {
        return this.layoutRes;
    }

    public Class<V> getViewClassType() {
        return this.viewClassType;
    }
}
