import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* compiled from: ServiceLoader */
/* loaded from: classes.dex */
public final class a {
    public static Iterator a() {
        try {
            kotlinx.coroutines.CoroutineExceptionHandler[] arr = new CoroutineExceptionHandler[1];
        } finally {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
        return Arrays.asList(new CoroutineExceptionHandler[] { new kotlinx.coroutines.AndroidExceptionPreHandler() }).iterator();
    }

    public static Iterator b() {
        try {
            kotlinx.coroutines.internal.MainDispatcherFactory[] arr = new MainDispatcherFactory[1];
        } finally {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
        return Arrays.asList(new MainDispatcherFactory[] { new kotlinx.coroutines.AndroidDispatcherFactory() }).iterator();
    }
}
