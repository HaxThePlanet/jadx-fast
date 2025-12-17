package com.facebook;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\n", d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FacebookGraphResponseException extends com.facebook.FacebookException {

    private final com.facebook.s graphResponse;
    public FacebookGraphResponseException(com.facebook.s s, String string2) {
        super(string2);
        this.graphResponse = s;
    }

    @Override // com.facebook.FacebookException
    public String toString() {
        int str;
        String message;
        com.facebook.s graphResponse = this.graphResponse;
        if (graphResponse != null) {
            str = graphResponse.b();
        } else {
            str = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookGraphResponseException: ");
        n.e(stringBuilder, "StringBuilder().append(\"…raphResponseException: \")");
        message = getMessage();
        if (message != null) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        if (str != null) {
            stringBuilder.append("httpResponseCode: ");
            stringBuilder.append(str.f());
            stringBuilder.append(", facebookErrorCode: ");
            stringBuilder.append(str.b());
            stringBuilder.append(", facebookErrorType: ");
            stringBuilder.append(str.d());
            stringBuilder.append(", message: ");
            stringBuilder.append(str.c());
            stringBuilder.append("}");
        }
        String string = stringBuilder.toString();
        n.e(string, "errorStringBuilder.toString()");
        return string;
    }
}
