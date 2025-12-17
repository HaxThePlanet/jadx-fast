package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import androidx.annotation.Keep;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.g;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {

    private volatile Object _preHandler;
    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.r);
        this._preHandler = this;
    }

    private final Method preHandler() {
        int i2;
        boolean public;
        int i;
        Object _preHandler = this._preHandler;
        if (_preHandler != this) {
            return (Method)_preHandler;
        }
        i2 = 0;
        Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
            if (Modifier.isStatic(declaredMethod.getModifiers())) {
                i = 1;
            }
        }
        if (i != 0) {
            i2 = declaredMethod;
        }
        this._preHandler = i2;
        return i2;
    }

    @Override // kotlin.b0.a
    public void handleException(g g, Throwable throwable2) {
        int uncaughtExceptionHandler;
        int i;
        boolean arr;
        final Thread obj4 = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            obj4.getUncaughtExceptionHandler().uncaughtException(obj4, throwable2);
        } else {
            Method preHandler = preHandler();
            i = 0;
            if (preHandler == null) {
                uncaughtExceptionHandler = i;
            } else {
                uncaughtExceptionHandler = preHandler.invoke(i, new Object[0]);
            }
            if (uncaughtExceptionHandler instanceof Thread.UncaughtExceptionHandler != null) {
                i = uncaughtExceptionHandler;
            }
            if (i == 0) {
            } else {
                i.uncaughtException(obj4, throwable2);
            }
        }
    }
}
