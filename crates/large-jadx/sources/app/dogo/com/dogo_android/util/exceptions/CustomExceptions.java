package app.dogo.com.dogo_android.util.exceptions;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0006B\u0011\u0008\u0004\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CustomExceptions;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "DataNotFound", "Lapp/dogo/com/dogo_android/util/exceptions/CustomExceptions$DataNotFound;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CustomExceptions extends Exception {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/CustomExceptions$DataNotFound;", "Lapp/dogo/com/dogo_android/util/exceptions/CustomExceptions;", "message", "", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DataNotFound extends app.dogo.com.dogo_android.util.exceptions.CustomExceptions {
        public DataNotFound(String string) {
            n.f(string, "message");
            super(string, 0);
        }
    }
    private CustomExceptions(String string) {
        super(string);
    }

    public CustomExceptions(String string, g g2) {
        super(string);
    }
}
