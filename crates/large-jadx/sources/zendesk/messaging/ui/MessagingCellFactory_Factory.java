package zendesk.messaging.ui;

import g.b.b;
import j.a.a;
import zendesk.messaging.EventFactory;
import zendesk.messaging.EventListener;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public final class MessagingCellFactory_Factory implements b<zendesk.messaging.ui.MessagingCellFactory> {

    private final a<zendesk.messaging.ui.AvatarStateFactory> avatarStateFactoryProvider;
    private final a<zendesk.messaging.ui.AvatarStateRenderer> avatarStateRendererProvider;
    private final a<zendesk.messaging.ui.MessagingCellPropsFactory> cellPropsFactoryProvider;
    private final a<DateProvider> dateProvider;
    private final a<EventFactory> eventFactoryProvider;
    private final a<EventListener> eventListenerProvider;
    private final a<Boolean> multilineResponseOptionsEnabledProvider;
    public MessagingCellFactory_Factory(a<zendesk.messaging.ui.MessagingCellPropsFactory> a, a<DateProvider> a2, a<EventListener> a3, a<EventFactory> a4, a<zendesk.messaging.ui.AvatarStateRenderer> a5, a<zendesk.messaging.ui.AvatarStateFactory> a6, a<Boolean> a7) {
        super();
        this.cellPropsFactoryProvider = a;
        this.dateProvider = a2;
        this.eventListenerProvider = a3;
        this.eventFactoryProvider = a4;
        this.avatarStateRendererProvider = a5;
        this.avatarStateFactoryProvider = a6;
        this.multilineResponseOptionsEnabledProvider = a7;
    }

    public static zendesk.messaging.ui.MessagingCellFactory_Factory create(a<zendesk.messaging.ui.MessagingCellPropsFactory> a, a<DateProvider> a2, a<EventListener> a3, a<EventFactory> a4, a<zendesk.messaging.ui.AvatarStateRenderer> a5, a<zendesk.messaging.ui.AvatarStateFactory> a6, a<Boolean> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return messagingCellFactory_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.MessagingCellFactory get() {
        super((MessagingCellPropsFactory)this.cellPropsFactoryProvider.get(), (DateProvider)this.dateProvider.get(), (EventListener)this.eventListenerProvider.get(), (EventFactory)this.eventFactoryProvider.get(), (AvatarStateRenderer)this.avatarStateRendererProvider.get(), (AvatarStateFactory)this.avatarStateFactoryProvider.get(), (Boolean)this.multilineResponseOptionsEnabledProvider.get().booleanValue());
        return messagingCellFactory;
    }
}
