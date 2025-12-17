package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class FirebaseAppCheckTokenProvider extends com.google.firebase.firestore.auth.CredentialsProvider<String> {

    private static final String LOG_TAG = "FirebaseAppCheckTokenProvider";
    private Listener<String> changeListener;
    private boolean forceRefresh;
    private InternalAppCheckTokenProvider internalAppCheckTokenProvider;
    private final AppCheckTokenListener tokenListener;
    public FirebaseAppCheckTokenProvider(Deferred<InternalAppCheckTokenProvider> deferred) {
        super();
        c cVar = new c(this);
        this.tokenListener = cVar;
        b bVar = new b(this);
        deferred.whenAvailable(bVar);
    }

    static j a(j j) {
        if (j.isSuccessful()) {
            return m.e((AppCheckTokenResult)j.getResult().getToken());
        }
        return m.d(j.getException());
    }

    private void b(AppCheckTokenResult appCheckTokenResult) {
        onTokenChanged(appCheckTokenResult);
    }

    private void d(Provider provider) {
        AppCheckTokenListener tokenListener;
        final Object obj2 = provider.get();
        this.internalAppCheckTokenProvider = (InternalAppCheckTokenProvider)obj2;
        synchronized (this) {
            try {
                obj2.addAppCheckTokenListener(this.tokenListener);
                throw provider;
            }
        }
    }

    private void onTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        Object error;
        String string;
        Object[] arr;
        Object obj4;
        synchronized (this) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error getting App Check token; using placeholder token instead. Error: ");
                stringBuilder.append(appCheckTokenResult.getError());
                Logger.warn("FirebaseAppCheckTokenProvider", stringBuilder.toString(), new Object[0]);
                Listener changeListener = this.changeListener;
                if (changeListener != null) {
                }
                changeListener.onValue(appCheckTokenResult.getToken());
                throw appCheckTokenResult;
            }
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void c(AppCheckTokenResult appCheckTokenResult) {
        b(appCheckTokenResult);
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void e(Provider provider) {
        d(provider);
    }

    public j<String> getToken() {
        InternalAppCheckTokenProvider internalAppCheckTokenProvider = this.internalAppCheckTokenProvider;
        synchronized (this) {
            try {
                FirebaseApiNotAvailableException firebaseApiNotAvailableException = new FirebaseApiNotAvailableException("AppCheck is not available");
                return m.d(firebaseApiNotAvailableException);
                this.forceRefresh = false;
                return internalAppCheckTokenProvider.getToken(this.forceRefresh).continueWithTask(Executors.DIRECT_EXECUTOR, a.a);
                throw th;
            }
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void invalidateToken() {
        this.forceRefresh = true;
        return;
        synchronized (this) {
            this.forceRefresh = true;
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void removeChangeListener() {
        AppCheckTokenListener tokenListener;
        this.changeListener = 0;
        InternalAppCheckTokenProvider internalAppCheckTokenProvider = this.internalAppCheckTokenProvider;
        synchronized (this) {
            internalAppCheckTokenProvider.removeAppCheckTokenListener(this.tokenListener);
            try {
                throw th;
            }
        }
    }

    public void setChangeListener(Listener<String> listener) {
        this.changeListener = listener;
        return;
        synchronized (this) {
            this.changeListener = listener;
        }
    }
}
