package com.google.firebase.database.core;

import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public interface TokenProvider {

    public interface GetTokenCompletionListener {
        public abstract void onError(String string);

        public abstract void onSuccess(String string);
    }

    public interface TokenChangeListener {
        public abstract void onTokenChange();

        public abstract void onTokenChange(String string);
    }
    public abstract void addTokenChangeListener(ExecutorService executorService, com.google.firebase.database.core.TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2);

    public abstract void getToken(boolean z, com.google.firebase.database.core.TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener2);

    public abstract void removeTokenChangeListener(com.google.firebase.database.core.TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener);
}
