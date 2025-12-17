package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import j.a.a;

/* loaded from: classes2.dex */
public final class FirebaseInAppMessaging_Factory implements Factory<com.google.firebase.inappmessaging.FirebaseInAppMessaging> {

    private final a<DataCollectionHelper> dataCollectionHelperProvider;
    private final a<DeveloperListenerManager> developerListenerManagerProvider;
    private final a<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
    private final a<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final a<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
    private final a<ProgramaticContextualTriggers> programaticContextualTriggersProvider;
    public FirebaseInAppMessaging_Factory(a<InAppMessageStreamManager> a, a<ProgramaticContextualTriggers> a2, a<DataCollectionHelper> a3, a<FirebaseInstallationsApi> a4, a<DisplayCallbacksFactory> a5, a<DeveloperListenerManager> a6) {
        super();
        this.inAppMessageStreamManagerProvider = a;
        this.programaticContextualTriggersProvider = a2;
        this.dataCollectionHelperProvider = a3;
        this.firebaseInstallationsProvider = a4;
        this.displayCallbacksFactoryProvider = a5;
        this.developerListenerManagerProvider = a6;
    }

    public static com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory create(a<InAppMessageStreamManager> a, a<ProgramaticContextualTriggers> a2, a<DataCollectionHelper> a3, a<FirebaseInstallationsApi> a4, a<DisplayCallbacksFactory> a5, a<DeveloperListenerManager> a6) {
        super(a, a2, a3, a4, a5, a6);
        return firebaseInAppMessaging_Factory;
    }

    public static com.google.firebase.inappmessaging.FirebaseInAppMessaging newInstance(InAppMessageStreamManager inAppMessageStreamManager, ProgramaticContextualTriggers programaticContextualTriggers2, DataCollectionHelper dataCollectionHelper3, FirebaseInstallationsApi firebaseInstallationsApi4, DisplayCallbacksFactory displayCallbacksFactory5, DeveloperListenerManager developerListenerManager6) {
        super(inAppMessageStreamManager, programaticContextualTriggers2, dataCollectionHelper3, firebaseInstallationsApi4, displayCallbacksFactory5, developerListenerManager6);
        return firebaseInAppMessaging2;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.FirebaseInAppMessaging get() {
        return FirebaseInAppMessaging_Factory.newInstance((InAppMessageStreamManager)this.inAppMessageStreamManagerProvider.get(), (ProgramaticContextualTriggers)this.programaticContextualTriggersProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get(), (FirebaseInstallationsApi)this.firebaseInstallationsProvider.get(), (DisplayCallbacksFactory)this.displayCallbacksFactoryProvider.get(), (DeveloperListenerManager)this.developerListenerManagerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
