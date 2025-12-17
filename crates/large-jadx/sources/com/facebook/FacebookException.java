package com.facebook;

import com.facebook.internal.g0.j.b;
import com.facebook.internal.l;
import com.facebook.internal.l.a;
import com.facebook.internal.l.b;
import java.util.Random;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0005\u0008\u0016\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0011B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u0011\u0008\u0016\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B)\u0008\u0016\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0008\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0008\u0016\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB\u0011\u0008\u0016\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u0008\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0012", d2 = {"Lcom/facebook/FacebookException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "message", "", "(Ljava/lang/String;)V", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public class FacebookException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class a implements l.a {

        final String a;
        a(String string) {
            this.a = string;
            super();
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            String obj1;
            if (z != null) {
                b.c(this.a);
            }
            try {
            }
        }
    }
    static {
    }

    public FacebookException(String string) {
        Random errorReport;
        boolean aVar;
        super(string);
        errorReport = new Random();
        if (string != null && o.y() && errorReport.nextInt(100) > 50) {
            if (o.y()) {
                if (errorReport.nextInt(100) > 50) {
                    aVar = new FacebookException.a(string);
                    l.a(l.b.ErrorReport, aVar);
                }
            }
        }
    }

    public FacebookException(String string, Throwable throwable2) {
        super(string, throwable2);
    }

    public FacebookException(Throwable throwable) {
        super(throwable);
    }

    @Override // java.lang.RuntimeException
    public String toString() {
        String message;
        if (getMessage() != null) {
        } else {
            message = "";
        }
        return message;
    }
}
