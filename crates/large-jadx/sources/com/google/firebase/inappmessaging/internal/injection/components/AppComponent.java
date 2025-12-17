package com.google.firebase.inappmessaging.internal.injection.components;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.dagger.BindsInstance;
import com.google.firebase.inappmessaging.dagger.Component;
import com.google.firebase.inappmessaging.dagger.Component.Builder;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import f.c.a.b.g;

/* loaded from: classes2.dex */
@Component(dependencies = UniversalComponent.class, modules = {ApiClientModule.class, GrpcClientModule.class, TransportClientModule.class})
public interface AppComponent {

    @Component$Builder
    public interface Builder {
        @BindsInstance
        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper);

        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder apiClientModule(ApiClientModule apiClientModule);

        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent build();

        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder grpcClientModule(GrpcClientModule grpcClientModule);

        @BindsInstance
        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder transportFactory(g g);

        public abstract com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder universalComponent(com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent universalComponent);
    }
    public abstract DisplayCallbacksFactory displayCallbacksFactory();

    public abstract FirebaseInAppMessaging providesFirebaseInAppMessaging();
}
