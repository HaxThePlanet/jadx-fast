package zendesk.messaging.ui;

import androidx.appcompat.app.d;
import g.b.b;
import j.a.a;
import zendesk.belvedere.e;
import zendesk.messaging.BelvedereMediaHolder;
import zendesk.messaging.MessagingViewModel;
import zendesk.messaging.TypingEventDispatcher;

/* loaded from: classes3.dex */
public final class MessagingComposer_Factory implements b<zendesk.messaging.ui.MessagingComposer> {

    private final a<d> appCompatActivityProvider;
    private final a<BelvedereMediaHolder> belvedereMediaHolderProvider;
    private final a<e> imageStreamProvider;
    private final a<zendesk.messaging.ui.InputBoxAttachmentClickListener> inputBoxAttachmentClickListenerProvider;
    private final a<zendesk.messaging.ui.InputBoxConsumer> inputBoxConsumerProvider;
    private final a<MessagingViewModel> messagingViewModelProvider;
    private final a<TypingEventDispatcher> typingEventDispatcherProvider;
    public MessagingComposer_Factory(a<d> a, a<MessagingViewModel> a2, a<e> a3, a<BelvedereMediaHolder> a4, a<zendesk.messaging.ui.InputBoxConsumer> a5, a<zendesk.messaging.ui.InputBoxAttachmentClickListener> a6, a<TypingEventDispatcher> a7) {
        super();
        this.appCompatActivityProvider = a;
        this.messagingViewModelProvider = a2;
        this.imageStreamProvider = a3;
        this.belvedereMediaHolderProvider = a4;
        this.inputBoxConsumerProvider = a5;
        this.inputBoxAttachmentClickListenerProvider = a6;
        this.typingEventDispatcherProvider = a7;
    }

    public static zendesk.messaging.ui.MessagingComposer_Factory create(a<d> a, a<MessagingViewModel> a2, a<e> a3, a<BelvedereMediaHolder> a4, a<zendesk.messaging.ui.InputBoxConsumer> a5, a<zendesk.messaging.ui.InputBoxAttachmentClickListener> a6, a<TypingEventDispatcher> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return messagingComposer_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.MessagingComposer get() {
        super((d)this.appCompatActivityProvider.get(), (MessagingViewModel)this.messagingViewModelProvider.get(), (e)this.imageStreamProvider.get(), (BelvedereMediaHolder)this.belvedereMediaHolderProvider.get(), (InputBoxConsumer)this.inputBoxConsumerProvider.get(), (InputBoxAttachmentClickListener)this.inputBoxAttachmentClickListenerProvider.get(), (TypingEventDispatcher)this.typingEventDispatcherProvider.get());
        return messagingComposer2;
    }
}
