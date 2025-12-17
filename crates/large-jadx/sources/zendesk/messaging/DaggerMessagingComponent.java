package zendesk.messaging;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.t;
import g.b.a;
import g.b.c;
import g.b.d;
import j.a.a;
import java.util.List;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
final class DaggerMessagingComponent implements zendesk.messaging.MessagingComponent {

    private a<Context> appContextProvider;
    private a<zendesk.messaging.BelvedereMediaHolder> belvedereMediaHolderProvider;
    private a<a> belvedereProvider;
    private a<List<zendesk.messaging.Engine>> enginesProvider;
    private final zendesk.messaging.MessagingConfiguration messagingConfiguration;
    private a<zendesk.messaging.MessagingConfiguration> messagingConfigurationProvider;
    private a<zendesk.messaging.MessagingConversationLog> messagingConversationLogProvider;
    private a<zendesk.messaging.MessagingEventSerializer> messagingEventSerializerProvider;
    private a<zendesk.messaging.MessagingModel> messagingModelProvider;
    private a<zendesk.messaging.MessagingViewModel> messagingViewModelProvider;
    private a<t> picassoProvider;
    private a<Resources> resourcesProvider;
    private a<zendesk.messaging.TimestampFactory> timestampFactoryProvider;

    private static final class Builder implements zendesk.messaging.MessagingComponent.Builder {

        private Context appContext;
        private List<zendesk.messaging.Engine> engines;
        private zendesk.messaging.MessagingConfiguration messagingConfiguration;
        Builder(zendesk.messaging.DaggerMessagingComponent.1 daggerMessagingComponent$1) {
            super();
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.DaggerMessagingComponent.Builder appContext(Context context) {
            d.b(context);
            this.appContext = (Context)context;
            return this;
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.MessagingComponent.Builder appContext(Context context) {
            appContext(context);
            return this;
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.MessagingComponent build() {
            d.a(this.appContext, Context.class);
            d.a(this.engines, List.class);
            d.a(this.messagingConfiguration, MessagingConfiguration.class);
            DaggerMessagingComponent daggerMessagingComponent = new DaggerMessagingComponent(this.appContext, this.engines, this.messagingConfiguration, 0);
            return daggerMessagingComponent;
        }

        public zendesk.messaging.DaggerMessagingComponent.Builder engines(List<zendesk.messaging.Engine> list) {
            d.b(list);
            this.engines = (List)list;
            return this;
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.MessagingComponent.Builder engines(List list) {
            engines(list);
            return this;
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.DaggerMessagingComponent.Builder messagingConfiguration(zendesk.messaging.MessagingConfiguration messagingConfiguration) {
            d.b(messagingConfiguration);
            this.messagingConfiguration = (MessagingConfiguration)messagingConfiguration;
            return this;
        }

        @Override // zendesk.messaging.MessagingComponent$Builder
        public zendesk.messaging.MessagingComponent.Builder messagingConfiguration(zendesk.messaging.MessagingConfiguration messagingConfiguration) {
            messagingConfiguration(messagingConfiguration);
            return this;
        }
    }
    private DaggerMessagingComponent(Context context, List<zendesk.messaging.Engine> list2, zendesk.messaging.MessagingConfiguration messagingConfiguration3) {
        super();
        this.messagingConfiguration = messagingConfiguration3;
        initialize(context, list2, messagingConfiguration3);
    }

    DaggerMessagingComponent(Context context, List list2, zendesk.messaging.MessagingConfiguration messagingConfiguration3, zendesk.messaging.DaggerMessagingComponent.1 daggerMessagingComponent$14) {
        super(context, list2, messagingConfiguration3);
    }

    public static zendesk.messaging.MessagingComponent.Builder builder() {
        DaggerMessagingComponent.Builder builder = new DaggerMessagingComponent.Builder(0);
        return builder;
    }

    private void initialize(Context context, List<zendesk.messaging.Engine> list2, zendesk.messaging.MessagingConfiguration messagingConfiguration3) {
        g.b.b obj2 = c.a(context);
        this.appContextProvider = obj2;
        this.picassoProvider = a.a(MessagingModule_PicassoFactory.create(obj2));
        this.resourcesProvider = a.a(MessagingModule_ResourcesFactory.create(this.appContextProvider));
        this.enginesProvider = c.a(list2);
        this.messagingConfigurationProvider = c.a(messagingConfiguration3);
        obj2 = TimestampFactory_Factory.create(this.appContextProvider);
        this.timestampFactoryProvider = obj2;
        obj2 = a.a(MessagingEventSerializer_Factory.create(this.appContextProvider, obj2));
        this.messagingEventSerializerProvider = obj2;
        obj2 = a.a(MessagingConversationLog_Factory.create(obj2));
        this.messagingConversationLogProvider = obj2;
        obj2 = a.a(MessagingModel_Factory.create(this.resourcesProvider, this.enginesProvider, this.messagingConfigurationProvider, obj2));
        this.messagingModelProvider = obj2;
        this.messagingViewModelProvider = a.a(MessagingViewModel_Factory.create(obj2));
        this.belvedereProvider = a.a(MessagingModule_BelvedereFactory.create(this.appContextProvider));
        this.belvedereMediaHolderProvider = a.a(BelvedereMediaHolder_Factory.create());
    }

    @Override // zendesk.messaging.MessagingComponent
    public a belvedere() {
        return (a)this.belvedereProvider.get();
    }

    @Override // zendesk.messaging.MessagingComponent
    public zendesk.messaging.BelvedereMediaHolder belvedereMediaHolder() {
        return (BelvedereMediaHolder)this.belvedereMediaHolderProvider.get();
    }

    @Override // zendesk.messaging.MessagingComponent
    public zendesk.messaging.MessagingConfiguration messagingConfiguration() {
        return this.messagingConfiguration;
    }

    @Override // zendesk.messaging.MessagingComponent
    public zendesk.messaging.MessagingViewModel messagingViewModel() {
        return (MessagingViewModel)this.messagingViewModelProvider.get();
    }

    @Override // zendesk.messaging.MessagingComponent
    public t picasso() {
        return (t)this.picassoProvider.get();
    }

    @Override // zendesk.messaging.MessagingComponent
    public Resources resources() {
        return (Resources)this.resourcesProvider.get();
    }
}
