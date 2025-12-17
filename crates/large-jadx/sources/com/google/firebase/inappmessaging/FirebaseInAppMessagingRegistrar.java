package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.components.AppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent.Builder;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    public static com.google.firebase.inappmessaging.FirebaseInAppMessaging a(com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar, ComponentContainer componentContainer2) {
        return firebaseInAppMessagingRegistrar.providesFirebaseInAppMessaging(componentContainer2);
    }

    private com.google.firebase.inappmessaging.FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        Object obj2 = componentContainer.get(FirebaseApp.class);
        ApplicationModule applicationModule2 = new ApplicationModule((Application)(FirebaseApp)obj2.getApplicationContext());
        AppMeasurementModule appMeasurementModule2 = new AppMeasurementModule(componentContainer.getDeferred(AnalyticsConnector.class), (Subscriber)componentContainer.get(Subscriber.class));
        AnalyticsEventsModule analyticsEventsModule2 = new AnalyticsEventsModule();
        ProgramaticContextualTriggers programaticContextualTriggers = new ProgramaticContextualTriggers();
        ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule2 = new ProgrammaticContextualTriggerFlowableModule(programaticContextualTriggers);
        UniversalComponent build = DaggerUniversalComponent.builder().applicationModule(applicationModule2).appMeasurementModule(appMeasurementModule2).analyticsEventsModule(analyticsEventsModule2).programmaticContextualTriggerFlowableModule(programmaticContextualTriggerFlowableModule2).build();
        AbtIntegrationHelper abtIntegrationHelper2 = new AbtIntegrationHelper((AbtComponent)componentContainer.get(AbtComponent.class).get("fiam"));
        ApiClientModule apiClientModule2 = new ApiClientModule(obj2, (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class), build.clock());
        GrpcClientModule grpcClientModule2 = new GrpcClientModule(obj2);
        return DaggerAppComponent.builder().abtIntegrationHelper(abtIntegrationHelper2).apiClientModule(apiClientModule2).grpcClientModule(grpcClientModule2).universalComponent(build).transportFactory((g)componentContainer.get(g.class)).build().providesFirebaseInAppMessaging();
    }

    public List<Component<?>> getComponents() {
        Component[] arr = new Component[2];
        c cVar = new c(this);
        return Arrays.asList(Component.builder(FirebaseInAppMessaging.class).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(AbtComponent.class)).add(Dependency.deferred(AnalyticsConnector.class)).add(Dependency.required(g.class)).add(Dependency.required(Subscriber.class)).factory(cVar).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiam", "20.1.1"));
    }
}
