package com.google.firebase.database.android;

import com.google.android.gms.tasks.f;
import com.google.firebase.database.core.TokenProvider.GetTokenCompletionListener;

/* loaded from: classes2.dex */
public final class f implements f {

    public final TokenProvider.GetTokenCompletionListener a;
    public f(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener) {
        super();
        this.a = getTokenCompletionListener;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        AndroidAppCheckTokenProvider.e(this.a, exception);
    }
}
