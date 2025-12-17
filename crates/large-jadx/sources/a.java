import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* loaded from: classes.dex */
public final class a {
    public static Iterator a() {
        kotlinx.coroutines.CoroutineExceptionHandler[] arr = new CoroutineExceptionHandler[1];
        AndroidExceptionPreHandler androidExceptionPreHandler = new AndroidExceptionPreHandler();
        return Arrays.asList(androidExceptionPreHandler).iterator();
    }

    public static Iterator b() {
        kotlinx.coroutines.internal.MainDispatcherFactory[] arr = new MainDispatcherFactory[1];
        AndroidDispatcherFactory androidDispatcherFactory = new AndroidDispatcherFactory();
        return Arrays.asList(androidDispatcherFactory).iterator();
    }
}
