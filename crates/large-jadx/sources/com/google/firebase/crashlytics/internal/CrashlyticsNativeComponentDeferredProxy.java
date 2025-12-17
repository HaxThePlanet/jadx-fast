package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent {

    private static final com.google.firebase.crashlytics.internal.NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER;
    private final AtomicReference<com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent> availableNativeComponent;
    private final Deferred<com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent> deferredNativeComponent;

    private static final class MissingNativeSessionFileProvider implements com.google.firebase.crashlytics.internal.NativeSessionFileProvider {
        MissingNativeSessionFileProvider(com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy.1 crashlyticsNativeComponentDeferredProxy$1) {
            super();
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getAppFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getBinaryImagesFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getDeviceFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMetadataFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMinidumpFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getOsFile() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getSessionFile() {
            return null;
        }
    }
    static {
        CrashlyticsNativeComponentDeferredProxy.MissingNativeSessionFileProvider missingNativeSessionFileProvider = new CrashlyticsNativeComponentDeferredProxy.MissingNativeSessionFileProvider(0);
        CrashlyticsNativeComponentDeferredProxy.MISSING_NATIVE_SESSION_FILE_PROVIDER = missingNativeSessionFileProvider;
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred<com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent> deferred) {
        super();
        AtomicReference atomicReference = new AtomicReference(0);
        this.availableNativeComponent = atomicReference;
        this.deferredNativeComponent = deferred;
        a aVar = new a(this);
        deferred.whenAvailable(aVar);
    }

    static void a(String string, Provider provider2) {
        (CrashlyticsNativeComponent)provider2.get().finalizeSession(string);
    }

    private void b(Provider provider) {
        Logger.getLogger().d("Crashlytics native component now available.");
        this.availableNativeComponent.set((CrashlyticsNativeComponent)provider.get());
    }

    static void d(String string, String string2, long l3, StaticSessionData staticSessionData4, Provider provider5) {
        (CrashlyticsNativeComponent)obj11.get().prepareNativeSession(string, string2, l3, obj4);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void c(Provider provider) {
        b(provider);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void finalizeSession(String string) {
        b bVar = new b(string);
        this.deferredNativeComponent.whenAvailable(bVar);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public com.google.firebase.crashlytics.internal.NativeSessionFileProvider getSessionFileProvider(String string) {
        com.google.firebase.crashlytics.internal.NativeSessionFileProvider obj2;
        Object obj = this.availableNativeComponent.get();
        if ((CrashlyticsNativeComponent)obj == null) {
            obj2 = CrashlyticsNativeComponentDeferredProxy.MISSING_NATIVE_SESSION_FILE_PROVIDER;
        } else {
            obj2 = (CrashlyticsNativeComponent)obj.getSessionFileProvider(string);
        }
        return obj2;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForCurrentSession() {
        Object crashDataForCurrentSession;
        int i;
        crashDataForCurrentSession = this.availableNativeComponent.get();
        if (crashDataForCurrentSession != null && (CrashlyticsNativeComponent)crashDataForCurrentSession.hasCrashDataForCurrentSession()) {
            i = crashDataForCurrentSession.hasCrashDataForCurrentSession() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForSession(String string) {
        String obj2;
        Object obj = this.availableNativeComponent.get();
        if (obj != null && (CrashlyticsNativeComponent)obj.hasCrashDataForSession(string)) {
            obj2 = obj.hasCrashDataForSession(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void prepareNativeSession(String string, String string2, long l3, StaticSessionData staticSessionData4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deferring native open session: ");
        stringBuilder.append(string);
        Logger.getLogger().v(stringBuilder.toString());
        super(string, string2, l3, obj5, obj13);
        this.deferredNativeComponent.whenAvailable(cVar2);
    }
}
