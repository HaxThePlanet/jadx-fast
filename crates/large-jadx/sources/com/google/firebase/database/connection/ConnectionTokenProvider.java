package com.google.firebase.database.connection;

/* loaded from: classes2.dex */
public interface ConnectionTokenProvider {

    public interface GetTokenCallback {
        public abstract void onError(String string);

        public abstract void onSuccess(String string);
    }
    public abstract void getToken(boolean z, com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback connectionTokenProvider$GetTokenCallback2);
}
