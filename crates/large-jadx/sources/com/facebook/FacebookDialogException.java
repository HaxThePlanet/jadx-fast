package com.facebook;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/facebook/FacebookDialogException;", "Lcom/facebook/FacebookException;", "message", "", "errorCode", "", "failingUrl", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrorCode", "()I", "getFailingUrl", "()Ljava/lang/String;", "toString", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class FacebookDialogException extends com.facebook.FacebookException {

    public static final long serialVersionUID = 1L;
    private final int errorCode;
    private final String failingUrl;
    static {
    }

    public FacebookDialogException(String string, int i2, String string3) {
        super(string);
        this.errorCode = i2;
        this.failingUrl = string3;
    }

    @Override // com.facebook.FacebookException
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookDialogException: ");
        stringBuilder.append("errorCode: ");
        stringBuilder.append(this.errorCode);
        stringBuilder.append(", message: ");
        stringBuilder.append(getMessage());
        stringBuilder.append(", url: ");
        stringBuilder.append(this.failingUrl);
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return string;
    }
}
