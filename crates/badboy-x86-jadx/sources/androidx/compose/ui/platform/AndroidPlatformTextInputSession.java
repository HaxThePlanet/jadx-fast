package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.SessionMutex.Session;
import androidx.compose.ui.text.input.TextInputService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0012\u0010\t\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u001c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlinx/coroutines/CoroutineScope;", "view", "Landroid/view/View;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "coroutineScope", "(Landroid/view/View;Landroidx/compose/ui/text/input/TextInputService;Lkotlinx/coroutines/CoroutineScope;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isReadyForConnection", "", "()Z", "methodSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/InputMethodSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "startInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPlatformTextInputSession implements androidx.compose.ui.platform.PlatformTextInputSessionScope, CoroutineScope {

    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final AtomicReference<SessionMutex.Session<T>> methodSessionMutex;
    private final TextInputService textInputService;
    private final View view;
    static {
        final int i = 8;
    }

    public AndroidPlatformTextInputSession(View view, TextInputService textInputService, CoroutineScope coroutineScope) {
        super();
        this.view = view;
        this.textInputService = textInputService;
        this.coroutineScope = coroutineScope;
        this.methodSessionMutex = SessionMutex.constructor-impl();
    }

    public static final CoroutineScope access$getCoroutineScope$p(androidx.compose.ui.platform.AndroidPlatformTextInputSession $this) {
        return $this.coroutineScope;
    }

    public static final TextInputService access$getTextInputService$p(androidx.compose.ui.platform.AndroidPlatformTextInputSession $this) {
        return $this.textInputService;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputSessionScope
    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        InputConnection inputConnection;
        Object currentSession-impl = SessionMutex.getCurrentSession-impl(this.methodSessionMutex);
        if ((InputMethodSession)currentSession-impl != null) {
            inputConnection = (InputMethodSession)currentSession-impl.createInputConnection(outAttrs);
        } else {
            inputConnection = 0;
        }
        return inputConnection;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputSessionScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineScope.getCoroutineContext();
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputSessionScope
    public View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputSessionScope
    public final boolean isReadyForConnection() {
        Object currentSession-impl;
        int i;
        int i2;
        currentSession-impl = SessionMutex.getCurrentSession-impl(this.methodSessionMutex);
        i = 0;
        i2 = 1;
        if (currentSession-impl != null && (InputMethodSession)currentSession-impl.isActive() == i2) {
            i2 = 1;
            if (currentSession-impl.isActive() == i2) {
                i = i2;
            }
        }
        return i;
    }

    public Object startInputMethod(androidx.compose.ui.platform.PlatformTextInputMethodRequest platformTextInputMethodRequest, Continuation<?> continuation2) {
        boolean anon3;
        int i2;
        int i;
        androidx.compose.ui.platform.AndroidPlatformTextInputSession label;
        AtomicReference methodSessionMutex;
        androidx.compose.ui.platform.AndroidPlatformTextInputSession.startInputMethod.2 anon2;
        androidx.compose.ui.platform.AndroidPlatformTextInputSession.startInputMethod.3 anon;
        int i3;
        Object obj8;
        Object obj9;
        anon3 = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof AndroidPlatformTextInputSession.startInputMethod.1 && label2 &= i != 0) {
            anon3 = continuation2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon3.label = obj9 -= i;
            } else {
                anon3 = new AndroidPlatformTextInputSession.startInputMethod.1(this, continuation2);
            }
        } else {
        }
        obj9 = anon3.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                label = this;
                anon2 = new AndroidPlatformTextInputSession.startInputMethod.2(platformTextInputMethodRequest, label);
                anon = new AndroidPlatformTextInputSession.startInputMethod.3(label, 0);
                anon3.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        obj8 = new KotlinNothingValueException();
        throw obj8;
    }
}
