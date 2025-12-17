package com.google.firebase.database.android;

import com.google.android.gms.tasks.j;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.database.core.TokenProvider.GetTokenCompletionListener;
import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class AndroidAppCheckTokenProvider implements TokenProvider {

    private final Deferred<InternalAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InternalAppCheckTokenProvider> internalAppCheck;
    public AndroidAppCheckTokenProvider(Deferred<InternalAppCheckTokenProvider> deferred) {
        super();
        this.deferredAppCheckProvider = deferred;
        AtomicReference atomicReference = new AtomicReference();
        this.internalAppCheck = atomicReference;
        d dVar = new d(this);
        deferred.whenAvailable(dVar);
    }

    static void a(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener, AppCheckTokenResult appCheckTokenResult2) {
        tokenChangeListener.onTokenChange(appCheckTokenResult2.getToken());
    }

    static void b(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2, AppCheckTokenResult appCheckTokenResult3) {
        c cVar = new c(tokenChangeListener2, appCheckTokenResult3);
        executorService.execute(cVar);
    }

    static void c(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2, Provider provider3) {
        a aVar = new a(executorService, tokenChangeListener2);
        (InternalAppCheckTokenProvider)provider3.get().addAppCheckTokenListener(aVar);
    }

    static void d(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener, AppCheckTokenResult appCheckTokenResult2) {
        getTokenCompletionListener.onSuccess(appCheckTokenResult2.getToken());
    }

    static void e(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener, Exception exception2) {
        getTokenCompletionListener.onError(exception2.getMessage());
    }

    private void f(Provider provider) {
        this.internalAppCheck.set((InternalAppCheckTokenProvider)provider.get());
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2) {
        b bVar = new b(executorService, tokenChangeListener2);
        this.deferredAppCheckProvider.whenAvailable(bVar);
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void g(Provider provider) {
        f(provider);
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener2) {
        Object fVar;
        j obj2;
        fVar = this.internalAppCheck.get();
        if ((InternalAppCheckTokenProvider)fVar != null) {
            e eVar = new e(getTokenCompletionListener2);
            fVar = new f(getTokenCompletionListener2);
            (InternalAppCheckTokenProvider)fVar.getToken(z).addOnSuccessListener(eVar).addOnFailureListener(fVar);
        } else {
            getTokenCompletionListener2.onSuccess(0);
        }
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener) {
    }
}
