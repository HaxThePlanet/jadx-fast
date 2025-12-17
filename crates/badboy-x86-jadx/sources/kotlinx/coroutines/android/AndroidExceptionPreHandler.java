package kotlinx.coroutines.android;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    private volatile Object _preHandler;
    public AndroidExceptionPreHandler() {
        super((CoroutineContext.Key)CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    private final Method preHandler() {
        int i2;
        Method declaredMethod;
        int i;
        boolean public;
        final Object _preHandler = this._preHandler;
        if (_preHandler != this) {
            return (Method)_preHandler;
        }
        i2 = 0;
        declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        Method method = declaredMethod;
        int i3 = 0;
        if (Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            if (Modifier.isStatic(method.getModifiers())) {
                i = 1;
            }
        }
        if (i != 0) {
            i2 = declaredMethod;
        }
        this._preHandler = i2;
        return i2;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public void handleException(CoroutineContext context, Throwable exception) {
    }
}
