package com.facebook;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lcom/facebook/FacebookServiceException;", "Lcom/facebook/FacebookException;", "requestError", "Lcom/facebook/FacebookRequestError;", "errorMessage", "", "(Lcom/facebook/FacebookRequestError;Ljava/lang/String;)V", "getRequestError", "()Lcom/facebook/FacebookRequestError;", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FacebookServiceException extends com.facebook.FacebookException {

    private static final long serialVersionUID = 1L;
    private final com.facebook.n requestError;
    static {
    }

    public FacebookServiceException(com.facebook.n n, String string2) {
        n.f(n, "requestError");
        super(string2);
        this.requestError = n;
    }

    @Override // com.facebook.FacebookException
    public final com.facebook.n a() {
        return this.requestError;
    }

    @Override // com.facebook.FacebookException
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookServiceException: ");
        stringBuilder.append("httpResponseCode: ");
        stringBuilder.append(this.requestError.f());
        stringBuilder.append(", facebookErrorCode: ");
        stringBuilder.append(this.requestError.b());
        stringBuilder.append(", facebookErrorType: ");
        stringBuilder.append(this.requestError.d());
        stringBuilder.append(", message: ");
        stringBuilder.append(this.requestError.c());
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return string;
    }
}
