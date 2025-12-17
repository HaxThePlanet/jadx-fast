package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;

/* loaded from: classes2.dex */
public final class FirebaseAuthCredentialsProvider extends com.google.firebase.firestore.auth.CredentialsProvider<com.google.firebase.firestore.auth.User> {

    private static final String LOG_TAG = "FirebaseAuthCredentialsProvider";
    private Listener<com.google.firebase.firestore.auth.User> changeListener;
    private boolean forceRefresh;
    private final IdTokenListener idTokenListener;
    private InternalAuthProvider internalAuthProvider;
    private int tokenCounter;
    public FirebaseAuthCredentialsProvider(Deferred<InternalAuthProvider> deferred) {
        super();
        f fVar = new f(this);
        this.idTokenListener = fVar;
        e eVar = new e(this);
        deferred.whenAvailable(eVar);
    }

    private j a(int i, j j2) {
        synchronized (this) {
            try {
                Logger.debug("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                return getToken();
                if (j2.isSuccessful()) {
                }
                return m.e((GetTokenResult)j2.getResult().getToken());
                return m.d(j2.getException());
                throw i;
            }
        }
    }

    private void c(InternalTokenResult internalTokenResult) {
        onIdTokenChanged();
    }

    private void e(Provider provider) {
        this.internalAuthProvider = (InternalAuthProvider)provider.get();
        onIdTokenChanged();
        this.internalAuthProvider.addIdTokenListener(this.idTokenListener);
        return;
        synchronized (this) {
            this.internalAuthProvider = (InternalAuthProvider)provider.get();
            onIdTokenChanged();
            this.internalAuthProvider.addIdTokenListener(this.idTokenListener);
        }
    }

    private com.google.firebase.firestore.auth.User getUser() {
        int uid;
        com.google.firebase.firestore.auth.User uNAUTHENTICATED;
        InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
        synchronized (this) {
            try {
                uid = 0;
                uid = internalAuthProvider.getUid();
                if (uid != 0) {
                } else {
                }
                uNAUTHENTICATED = new User(uid);
                uNAUTHENTICATED = User.UNAUTHENTICATED;
                return uNAUTHENTICATED;
                throw th;
            }
        }
    }

    private void onIdTokenChanged() {
        com.google.firebase.firestore.auth.User user;
        this.tokenCounter = tokenCounter++;
        Listener changeListener = this.changeListener;
        synchronized (this) {
            try {
                changeListener.onValue(getUser());
                throw th;
            }
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public j b(int i, j j2) {
        return a(i, j2);
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void d(InternalTokenResult internalTokenResult) {
        c(internalTokenResult);
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void f(Provider provider) {
        e(provider);
    }

    public j<String> getToken() {
        InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
        synchronized (this) {
            try {
                FirebaseApiNotAvailableException firebaseApiNotAvailableException = new FirebaseApiNotAvailableException("auth is not available");
                return m.d(firebaseApiNotAvailableException);
                this.forceRefresh = false;
                d dVar = new d(this, this.tokenCounter);
                return internalAuthProvider.getAccessToken(this.forceRefresh).continueWithTask(Executors.DIRECT_EXECUTOR, dVar);
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
        IdTokenListener idTokenListener;
        this.changeListener = 0;
        InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
        synchronized (this) {
            internalAuthProvider.removeIdTokenListener(this.idTokenListener);
            try {
                throw th;
            }
        }
    }

    public void setChangeListener(Listener<com.google.firebase.firestore.auth.User> listener) {
        this.changeListener = listener;
        listener.onValue(getUser());
        return;
        synchronized (this) {
            this.changeListener = listener;
            listener.onValue(getUser());
        }
    }
}
