package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class Registrar implements ComponentRegistrar {

    private static class FIIDInternalAdapter implements FirebaseInstanceIdInternal {

        final com.google.firebase.iid.FirebaseInstanceId fiid;
        public FIIDInternalAdapter(com.google.firebase.iid.FirebaseInstanceId firebaseInstanceId) {
            super();
            this.fiid = firebaseInstanceId;
        }

        static final String lambda$getTokenTask$0$Registrar$FIIDInternalAdapter(j j) {
            return (InstanceIdResult)j.getResult().getToken();
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public void addNewTokenListener(FirebaseInstanceIdInternal.NewTokenListener firebaseInstanceIdInternal$NewTokenListener) {
            this.fiid.addNewTokenListener(newTokenListener);
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public void deleteToken(String string, String string2) {
            this.fiid.deleteToken(string, string2);
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public String getId() {
            return this.fiid.getId();
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public String getToken() {
            return this.fiid.getToken();
        }

        public j<String> getTokenTask() {
            String token = this.fiid.getToken();
            if (token != null) {
                return m.e(token);
            }
            return this.fiid.getInstanceId().continueWith(Registrar.FIIDInternalAdapter$$Lambda.0.$instance);
        }
    }
    static final com.google.firebase.iid.FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        FirebaseInstanceId firebaseInstanceId = new FirebaseInstanceId((FirebaseApp)componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi)componentContainer.get(FirebaseInstallationsApi.class));
        return firebaseInstanceId;
    }

    static final FirebaseInstanceIdInternal lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        Registrar.FIIDInternalAdapter fIIDInternalAdapter = new Registrar.FIIDInternalAdapter((FirebaseInstanceId)componentContainer.get(FirebaseInstanceId.class));
        return fIIDInternalAdapter;
    }

    public List<Component<?>> getComponents() {
        Class<com.google.firebase.iid.FirebaseInstanceId> obj = FirebaseInstanceId.class;
        Component[] arr = new Component[3];
        return Arrays.asList(Component.builder(obj).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.required(FirebaseInstallationsApi.class)).factory(Registrar$$Lambda.0.$instance).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(obj)).factory(Registrar$$Lambda.1.$instance).build(), LibraryVersionComponent.create("fire-iid", "21.1.0"));
    }
}
