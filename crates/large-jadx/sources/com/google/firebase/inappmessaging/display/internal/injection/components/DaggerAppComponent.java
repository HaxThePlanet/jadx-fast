package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.bumptech.glide.k;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener_Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule_ProvidesGlideRequestManagerFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
import j.a.a;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DaggerAppComponent implements com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent {

    private a<FiamAnimator> fiamAnimatorProvider;
    private a<FiamImageLoader> fiamImageLoaderProvider;
    private a<FiamWindowManager> fiamWindowManagerProvider;
    private a<FirebaseInAppMessagingDisplay> firebaseInAppMessagingDisplayProvider;
    private a<GlideErrorListener> glideErrorListenerProvider;
    private a<BindingWrapperFactory> inflaterClientProvider;
    private a<Map<String, a<InAppMessageLayoutConfig>>> myKeyStringMapProvider;
    private a<Application> providesApplicationProvider;
    private a<k> providesGlideRequestManagerProvider;
    private a<FirebaseInAppMessaging> providesHeadlesssSingletonProvider;

    public static final class Builder {

        private GlideModule glideModule;
        private HeadlessInAppMessagingModule headlessInAppMessagingModule;
        private com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent;
        Builder(com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.1 daggerAppComponent$1) {
            super();
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent build() {
            GlideModule glideModule;
            Preconditions.checkBuilderRequirement(this.headlessInAppMessagingModule, HeadlessInAppMessagingModule.class);
            if (this.glideModule == null) {
                glideModule = new GlideModule();
                this.glideModule = glideModule;
            }
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            DaggerAppComponent daggerAppComponent = new DaggerAppComponent(this.headlessInAppMessagingModule, this.glideModule, this.universalComponent, 0);
            return daggerAppComponent;
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.Builder glideModule(GlideModule glideModule) {
            this.glideModule = (GlideModule)Preconditions.checkNotNull(glideModule);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.Builder headlessInAppMessagingModule(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
            this.headlessInAppMessagingModule = (HeadlessInAppMessagingModule)Preconditions.checkNotNull(headlessInAppMessagingModule);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.Builder universalComponent(com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent)Preconditions.checkNotNull(universalComponent);
            return this;
        }
    }

    private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager implements a<FiamWindowManager> {

        private final com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public FiamWindowManager get() {
            return (FiamWindowManager)Preconditions.checkNotNull(this.universalComponent.fiamWindowManager(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient implements a<BindingWrapperFactory> {

        private final com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public BindingWrapperFactory get() {
            return (BindingWrapperFactory)Preconditions.checkNotNull(this.universalComponent.inflaterClient(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }

    private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap implements a<Map<String, a<InAppMessageLayoutConfig>>> {

        private final com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }

        public Map<String, a<InAppMessageLayoutConfig>> get() {
            return (Map)Preconditions.checkNotNull(this.universalComponent.myKeyStringMap(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication implements a<Application> {

        private final com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent;
        com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent) {
            super();
            this.universalComponent = universalComponent;
        }

        @Override // j.a.a
        public Application get() {
            return (Application)Preconditions.checkNotNull(this.universalComponent.providesApplication(), "Cannot return null from a non-@Nullable component method");
        }

        @Override // j.a.a
        public Object get() {
            return get();
        }
    }
    private DaggerAppComponent(HeadlessInAppMessagingModule headlessInAppMessagingModule, GlideModule glideModule2, com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent3) {
        super();
        initialize(headlessInAppMessagingModule, glideModule2, universalComponent3);
    }

    DaggerAppComponent(HeadlessInAppMessagingModule headlessInAppMessagingModule, GlideModule glideModule2, com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent3, com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.1 daggerAppComponent$14) {
        super(headlessInAppMessagingModule, glideModule2, universalComponent3);
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent.Builder builder() {
        DaggerAppComponent.Builder builder = new DaggerAppComponent.Builder(0);
        return builder;
    }

    private void initialize(HeadlessInAppMessagingModule headlessInAppMessagingModule, GlideModule glideModule2, com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent universalComponent3) {
        this.providesHeadlesssSingletonProvider = DoubleCheck.provider(HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.create(headlessInAppMessagingModule));
        DaggerAppComponent.com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap obj10 = new DaggerAppComponent.com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(universalComponent3);
        this.myKeyStringMapProvider = obj10;
        obj10 = new DaggerAppComponent.com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(universalComponent3);
        this.providesApplicationProvider = obj10;
        obj10 = DoubleCheck.provider(GlideErrorListener_Factory.create());
        this.glideErrorListenerProvider = obj10;
        obj10 = DoubleCheck.provider(GlideModule_ProvidesGlideRequestManagerFactory.create(glideModule2, this.providesApplicationProvider, obj10));
        this.providesGlideRequestManagerProvider = obj10;
        this.fiamImageLoaderProvider = DoubleCheck.provider(FiamImageLoader_Factory.create(obj10));
        obj10 = new DaggerAppComponent.com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(universalComponent3);
        this.fiamWindowManagerProvider = obj10;
        obj10 = new DaggerAppComponent.com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(universalComponent3);
        this.inflaterClientProvider = obj10;
        this.fiamAnimatorProvider = DoubleCheck.provider(FiamAnimator_Factory.create());
        this.firebaseInAppMessagingDisplayProvider = DoubleCheck.provider(FirebaseInAppMessagingDisplay_Factory.create(this.providesHeadlesssSingletonProvider, this.myKeyStringMapProvider, this.fiamImageLoaderProvider, RenewableTimer_Factory.create(), RenewableTimer_Factory.create(), this.fiamWindowManagerProvider, this.providesApplicationProvider, this.inflaterClientProvider, this.fiamAnimatorProvider));
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public FiamImageLoader fiamImageLoader() {
        return (FiamImageLoader)this.fiamImageLoaderProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public GlideErrorListener glideErrorListener() {
        return (GlideErrorListener)this.glideErrorListenerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI() {
        return (FirebaseInAppMessagingDisplay)this.firebaseInAppMessagingDisplayProvider.get();
    }
}
