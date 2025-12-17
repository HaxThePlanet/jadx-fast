package com.google.firebase.database.android;

import com.google.android.gms.tasks.g;
import com.google.firebase.database.core.TokenProvider.GetTokenCompletionListener;

/* loaded from: classes2.dex */
public final class e implements g {

    public final TokenProvider.GetTokenCompletionListener a;
    public e(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener) {
        super();
        this.a = getTokenCompletionListener;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        AndroidAppCheckTokenProvider.d(this.a, (AppCheckTokenResult)object);
    }
}
