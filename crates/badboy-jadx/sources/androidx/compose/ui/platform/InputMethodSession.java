package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper_androidKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0006R$\u0010\u0008\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\u0008\u0012\u0004\u0012\u00020\u000b`\u000c0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/platform/InputMethodSession;", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "onAllConnectionsClosed", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/jvm/functions/Function0;)V", "connections", "Landroidx/compose/runtime/collection/MutableVector;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "Landroidx/compose/ui/node/WeakReference;", "disposed", "", "isActive", "()Z", "lock", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "dispose", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InputMethodSession {

    private MutableVector<WeakReference<NullableInputConnectionWrapper>> connections;
    private boolean disposed;
    private final Object lock;
    private final Function0<Unit> onAllConnectionsClosed;
    private final androidx.compose.ui.platform.PlatformTextInputMethodRequest request;
    public InputMethodSession(androidx.compose.ui.platform.PlatformTextInputMethodRequest request, Function0<Unit> onAllConnectionsClosed) {
        super();
        this.request = request;
        this.onAllConnectionsClosed = onAllConnectionsClosed;
        Object object = new Object();
        this.lock = object;
        int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new WeakReference[16], 0);
        this.connections = mutableVector;
    }

    public static final MutableVector access$getConnections$p(androidx.compose.ui.platform.InputMethodSession $this) {
        return $this.connections;
    }

    public static final Function0 access$getOnAllConnectionsClosed$p(androidx.compose.ui.platform.InputMethodSession $this) {
        return $this.onAllConnectionsClosed;
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        Object lock = this.lock;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (lock) {
            return null;
        }
    }

    public final void dispose() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        Object obj2;
        final Object lock = this.lock;
        final int i2 = 0;
        int i3 = 0;
        this.disposed = true;
        MutableVector connections = this.connections;
        final int i5 = 0;
        final int size = connections.getSize();
        synchronized (lock) {
            i$iv = 0;
            i = 0;
            obj2 = (WeakReference)connections.getContent()[i$iv].get();
            do {
                i = 0;
                obj2 = (WeakReference)content[i$iv].get();
                if (i$iv++ < size) {
                }
                (NullableInputConnectionWrapper)(NullableInputConnectionWrapper)obj2.disposeDelegate();
            } while ((NullableInputConnectionWrapper)obj2 != null);
            this.connections.clear();
            Unit $i$a$SynchronizedInputMethodSession$dispose$1 = Unit.INSTANCE;
        }
    }

    public final boolean isActive() {
        return disposed ^= 1;
    }
}
