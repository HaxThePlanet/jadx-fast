package app.dogo.com.dogo_android.util.exceptions;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0004\u0005B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "NameIsTooLong", "NameIsTooShort", "Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions$NameIsTooLong;", "Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions$NameIsTooShort;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DogExceptions extends Exception {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions$NameIsTooLong;", "Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NameIsTooLong extends app.dogo.com.dogo_android.util.exceptions.DogExceptions {
        public NameIsTooLong() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions$NameIsTooShort;", "Lapp/dogo/com/dogo_android/util/exceptions/DogExceptions;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NameIsTooShort extends app.dogo.com.dogo_android.util.exceptions.DogExceptions {
        public NameIsTooShort() {
            super(0);
        }
    }
    public DogExceptions(g g) {
        super();
    }
}
