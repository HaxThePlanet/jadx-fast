package zendesk.messaging;

import androidx.appcompat.app.d;
import g.b.b;
import j.a.a;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public final class MessagingDialog_Factory implements b<zendesk.messaging.MessagingDialog> {

    private final a<d> appCompatActivityProvider;
    private final a<DateProvider> dateProvider;
    private final a<zendesk.messaging.MessagingViewModel> messagingViewModelProvider;
    public MessagingDialog_Factory(a<d> a, a<zendesk.messaging.MessagingViewModel> a2, a<DateProvider> a3) {
        super();
        this.appCompatActivityProvider = a;
        this.messagingViewModelProvider = a2;
        this.dateProvider = a3;
    }

    public static zendesk.messaging.MessagingDialog_Factory create(a<d> a, a<zendesk.messaging.MessagingViewModel> a2, a<DateProvider> a3) {
        MessagingDialog_Factory messagingDialog_Factory = new MessagingDialog_Factory(a, a2, a3);
        return messagingDialog_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.MessagingDialog get() {
        MessagingDialog messagingDialog = new MessagingDialog((d)this.appCompatActivityProvider.get(), (MessagingViewModel)this.messagingViewModelProvider.get(), (DateProvider)this.dateProvider.get());
        return messagingDialog;
    }
}
