package zendesk.messaging;

import android.content.res.Resources;
import android.os.Handler;
import androidx.appcompat.app.d;
import com.squareup.picasso.t;
import g.b.a;
import g.b.c;
import g.b.d;
import j.a.a;
import zendesk.belvedere.a;
import zendesk.belvedere.e;
import zendesk.messaging.components.DateProvider;
import zendesk.messaging.ui.AvatarStateFactory_Factory;
import zendesk.messaging.ui.AvatarStateRenderer_Factory;
import zendesk.messaging.ui.InputBoxAttachmentClickListener_Factory;
import zendesk.messaging.ui.InputBoxConsumer;
import zendesk.messaging.ui.InputBoxConsumer_Factory;
import zendesk.messaging.ui.MessagingCellFactory;
import zendesk.messaging.ui.MessagingCellFactory_Factory;
import zendesk.messaging.ui.MessagingCellPropsFactory;
import zendesk.messaging.ui.MessagingCellPropsFactory_Factory;
import zendesk.messaging.ui.MessagingComposer;
import zendesk.messaging.ui.MessagingComposer_Factory;

/* loaded from: classes3.dex */
final class DaggerMessagingActivityComponent implements zendesk.messaging.MessagingActivityComponent {

    private a<d> activityProvider;
    private a avatarStateRendererProvider;
    private a<zendesk.messaging.BelvedereMediaHolder> belvedereMediaHolderProvider;
    private a<zendesk.messaging.BelvedereMediaResolverCallback> belvedereMediaResolverCallbackProvider;
    private a<a> belvedereProvider;
    private a<e> belvedereUiProvider;
    private a<DateProvider> dateProvider;
    private a<zendesk.messaging.EventFactory> eventFactoryProvider;
    private a<Handler> handlerProvider;
    private a inputBoxAttachmentClickListenerProvider;
    private a<InputBoxConsumer> inputBoxConsumerProvider;
    private a<MessagingCellFactory> messagingCellFactoryProvider;
    private a<MessagingCellPropsFactory> messagingCellPropsFactoryProvider;
    private final zendesk.messaging.MessagingComponent messagingComponent;
    private a<zendesk.messaging.MessagingComponent> messagingComponentProvider;
    private a<MessagingComposer> messagingComposerProvider;
    private a<zendesk.messaging.MessagingDialog> messagingDialogProvider;
    private a<zendesk.messaging.MessagingViewModel> messagingViewModelProvider;
    private a<Boolean> multilineResponseOptionsEnabledProvider;
    private a<t> picassoProvider;
    private a<Resources> resourcesProvider;
    private a<zendesk.messaging.TypingEventDispatcher> typingEventDispatcherProvider;

    private static final class Builder implements zendesk.messaging.MessagingActivityComponent.Builder {

        private d activity;
        private zendesk.messaging.MessagingComponent messagingComponent;
        Builder(zendesk.messaging.DaggerMessagingActivityComponent.1 daggerMessagingActivityComponent$1) {
            super();
        }

        @Override // zendesk.messaging.MessagingActivityComponent$Builder
        public zendesk.messaging.DaggerMessagingActivityComponent.Builder activity(d d) {
            d.b(d);
            this.activity = (d)d;
            return this;
        }

        @Override // zendesk.messaging.MessagingActivityComponent$Builder
        public zendesk.messaging.MessagingActivityComponent.Builder activity(d d) {
            activity(d);
            return this;
        }

        @Override // zendesk.messaging.MessagingActivityComponent$Builder
        public zendesk.messaging.MessagingActivityComponent build() {
            d.a(this.activity, d.class);
            d.a(this.messagingComponent, MessagingComponent.class);
            DaggerMessagingActivityComponent daggerMessagingActivityComponent = new DaggerMessagingActivityComponent(this.messagingComponent, this.activity, 0);
            return daggerMessagingActivityComponent;
        }

        @Override // zendesk.messaging.MessagingActivityComponent$Builder
        public zendesk.messaging.DaggerMessagingActivityComponent.Builder messagingComponent(zendesk.messaging.MessagingComponent messagingComponent) {
            d.b(messagingComponent);
            this.messagingComponent = (MessagingComponent)messagingComponent;
            return this;
        }

        @Override // zendesk.messaging.MessagingActivityComponent$Builder
        public zendesk.messaging.MessagingActivityComponent.Builder messagingComponent(zendesk.messaging.MessagingComponent messagingComponent) {
            messagingComponent(messagingComponent);
            return this;
        }
    }

    private static class zendesk_messaging_MessagingComponent_belvedere implements a<a> {

        private final zendesk.messaging.MessagingComponent messagingComponent;
        zendesk_messaging_MessagingComponent_belvedere(zendesk.messaging.MessagingComponent messagingComponent) {
            super();
            this.messagingComponent = messagingComponent;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }

        @Override // j.a.a
        public a get() {
            a belvedere = this.messagingComponent.belvedere();
            d.c(belvedere, "Cannot return null from a non-@Nullable component method");
            return (a)belvedere;
        }
    }

    private static class zendesk_messaging_MessagingComponent_belvedereMediaHolder implements a<zendesk.messaging.BelvedereMediaHolder> {

        private final zendesk.messaging.MessagingComponent messagingComponent;
        zendesk_messaging_MessagingComponent_belvedereMediaHolder(zendesk.messaging.MessagingComponent messagingComponent) {
            super();
            this.messagingComponent = messagingComponent;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }

        @Override // j.a.a
        public zendesk.messaging.BelvedereMediaHolder get() {
            zendesk.messaging.BelvedereMediaHolder belvedereMediaHolder = this.messagingComponent.belvedereMediaHolder();
            d.c(belvedereMediaHolder, "Cannot return null from a non-@Nullable component method");
            return (BelvedereMediaHolder)belvedereMediaHolder;
        }
    }

    private static class zendesk_messaging_MessagingComponent_messagingViewModel implements a<zendesk.messaging.MessagingViewModel> {

        private final zendesk.messaging.MessagingComponent messagingComponent;
        zendesk_messaging_MessagingComponent_messagingViewModel(zendesk.messaging.MessagingComponent messagingComponent) {
            super();
            this.messagingComponent = messagingComponent;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }

        @Override // j.a.a
        public zendesk.messaging.MessagingViewModel get() {
            zendesk.messaging.MessagingViewModel messagingViewModel = this.messagingComponent.messagingViewModel();
            d.c(messagingViewModel, "Cannot return null from a non-@Nullable component method");
            return (MessagingViewModel)messagingViewModel;
        }
    }

    private static class zendesk_messaging_MessagingComponent_picasso implements a<t> {

        private final zendesk.messaging.MessagingComponent messagingComponent;
        zendesk_messaging_MessagingComponent_picasso(zendesk.messaging.MessagingComponent messagingComponent) {
            super();
            this.messagingComponent = messagingComponent;
        }

        @Override // j.a.a
        public t get() {
            t picasso = this.messagingComponent.picasso();
            d.c(picasso, "Cannot return null from a non-@Nullable component method");
            return (t)picasso;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class zendesk_messaging_MessagingComponent_resources implements a<Resources> {

        private final zendesk.messaging.MessagingComponent messagingComponent;
        zendesk_messaging_MessagingComponent_resources(zendesk.messaging.MessagingComponent messagingComponent) {
            super();
            this.messagingComponent = messagingComponent;
        }

        @Override // j.a.a
        public Resources get() {
            Resources resources = this.messagingComponent.resources();
            d.c(resources, "Cannot return null from a non-@Nullable component method");
            return (Resources)resources;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }
    private DaggerMessagingActivityComponent(zendesk.messaging.MessagingComponent messagingComponent, d d2) {
        super();
        this.messagingComponent = messagingComponent;
        initialize(messagingComponent, d2);
    }

    DaggerMessagingActivityComponent(zendesk.messaging.MessagingComponent messagingComponent, d d2, zendesk.messaging.DaggerMessagingActivityComponent.1 daggerMessagingActivityComponent$13) {
        super(messagingComponent, d2);
    }

    public static zendesk.messaging.MessagingActivityComponent.Builder builder() {
        DaggerMessagingActivityComponent.Builder builder = new DaggerMessagingActivityComponent.Builder(0);
        return builder;
    }

    private void initialize(zendesk.messaging.MessagingComponent messagingComponent, d d2) {
        DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_resources zendesk_messaging_MessagingComponent_resources = new DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_resources(messagingComponent);
        this.resourcesProvider = zendesk_messaging_MessagingComponent_resources;
        this.messagingCellPropsFactoryProvider = a.a(MessagingCellPropsFactory_Factory.create(zendesk_messaging_MessagingComponent_resources));
        a aVar2 = a.a(MessagingActivityModule_DateProviderFactory.create());
        this.dateProvider = aVar2;
        DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_messagingViewModel zendesk_messaging_MessagingComponent_messagingViewModel = new DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_messagingViewModel(messagingComponent);
        this.messagingViewModelProvider = zendesk_messaging_MessagingComponent_messagingViewModel;
        this.eventFactoryProvider = a.a(EventFactory_Factory.create(aVar2));
        DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_picasso zendesk_messaging_MessagingComponent_picasso = new DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_picasso(messagingComponent);
        this.picassoProvider = zendesk_messaging_MessagingComponent_picasso;
        this.avatarStateRendererProvider = a.a(AvatarStateRenderer_Factory.create(zendesk_messaging_MessagingComponent_picasso));
        g.b.b bVar = c.a(messagingComponent);
        this.messagingComponentProvider = bVar;
        this.multilineResponseOptionsEnabledProvider = a.a(MessagingActivityModule_MultilineResponseOptionsEnabledFactory.create(bVar));
        this.messagingCellFactoryProvider = a.a(MessagingCellFactory_Factory.create(this.messagingCellPropsFactoryProvider, this.dateProvider, this.messagingViewModelProvider, this.eventFactoryProvider, this.avatarStateRendererProvider, AvatarStateFactory_Factory.create(), this.multilineResponseOptionsEnabledProvider));
        g.b.b obj10 = c.a(d2);
        this.activityProvider = obj10;
        this.belvedereUiProvider = a.a(MessagingActivityModule_BelvedereUiFactory.create(obj10));
        obj10 = new DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_belvedereMediaHolder(messagingComponent);
        this.belvedereMediaHolderProvider = obj10;
        obj10 = new DaggerMessagingActivityComponent.zendesk_messaging_MessagingComponent_belvedere(messagingComponent);
        this.belvedereProvider = obj10;
        a aVar7 = a.a(BelvedereMediaResolverCallback_Factory.create(this.messagingViewModelProvider, this.eventFactoryProvider));
        this.belvedereMediaResolverCallbackProvider = aVar7;
        this.inputBoxConsumerProvider = a.a(InputBoxConsumer_Factory.create(this.messagingViewModelProvider, this.eventFactoryProvider, this.belvedereUiProvider, this.belvedereProvider, this.belvedereMediaHolderProvider, aVar7));
        this.inputBoxAttachmentClickListenerProvider = InputBoxAttachmentClickListener_Factory.create(this.activityProvider, this.belvedereUiProvider, this.belvedereMediaHolderProvider);
        a obj9 = a.a(MessagingActivityModule_HandlerFactory.create());
        this.handlerProvider = obj9;
        a aVar8 = a.a(TypingEventDispatcher_Factory.create(this.messagingViewModelProvider, obj9, this.eventFactoryProvider));
        this.typingEventDispatcherProvider = aVar8;
        this.messagingComposerProvider = a.a(MessagingComposer_Factory.create(this.activityProvider, this.messagingViewModelProvider, this.belvedereUiProvider, this.belvedereMediaHolderProvider, this.inputBoxConsumerProvider, this.inputBoxAttachmentClickListenerProvider, aVar8));
        this.messagingDialogProvider = a.a(MessagingDialog_Factory.create(this.activityProvider, this.messagingViewModelProvider, this.dateProvider));
    }

    private zendesk.messaging.MessagingActivity injectMessagingActivity(zendesk.messaging.MessagingActivity messagingActivity) {
        zendesk.messaging.MessagingViewModel messagingViewModel = this.messagingComponent.messagingViewModel();
        final String str = "Cannot return null from a non-@Nullable component method";
        d.c(messagingViewModel, str);
        MessagingActivity_MembersInjector.injectViewModel(messagingActivity, (MessagingViewModel)messagingViewModel);
        MessagingActivity_MembersInjector.injectMessagingCellFactory(messagingActivity, (MessagingCellFactory)this.messagingCellFactoryProvider.get());
        t picasso = this.messagingComponent.picasso();
        d.c(picasso, str);
        MessagingActivity_MembersInjector.injectPicasso(messagingActivity, (t)picasso);
        MessagingActivity_MembersInjector.injectEventFactory(messagingActivity, (EventFactory)this.eventFactoryProvider.get());
        MessagingActivity_MembersInjector.injectMessagingComposer(messagingActivity, (MessagingComposer)this.messagingComposerProvider.get());
        MessagingActivity_MembersInjector.injectMessagingDialog(messagingActivity, this.messagingDialogProvider.get());
        return messagingActivity;
    }

    @Override // zendesk.messaging.MessagingActivityComponent
    public void inject(zendesk.messaging.MessagingActivity messagingActivity) {
        injectMessagingActivity(messagingActivity);
    }
}
