package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\u0088\u0001\u0002¨\u0006\u0016", d2 = {"Landroidx/compose/ui/input/key/KeyEvent;", "", "nativeKeyEvent", "Landroid/view/KeyEvent;", "Landroidx/compose/ui/input/key/NativeKeyEvent;", "constructor-impl", "(Landroid/view/KeyEvent;)Landroid/view/KeyEvent;", "getNativeKeyEvent", "()Landroid/view/KeyEvent;", "equals", "", "other", "equals-impl", "(Landroid/view/KeyEvent;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/view/KeyEvent;)I", "toString", "", "toString-impl", "(Landroid/view/KeyEvent;)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class KeyEvent {

    private final KeyEvent nativeKeyEvent;
    private KeyEvent(KeyEvent nativeKeyEvent) {
        super();
        this.nativeKeyEvent = nativeKeyEvent;
    }

    public static final androidx.compose.ui.input.key.KeyEvent box-impl(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = new KeyEvent(keyEvent);
        return keyEvent2;
    }

    public static KeyEvent constructor-impl(KeyEvent keyEvent) {
        return keyEvent;
    }

    public static boolean equals-impl(KeyEvent keyEvent, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof KeyEvent) {
            return i2;
        }
        if (!Intrinsics.areEqual(keyEvent, (KeyEvent)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(KeyEvent keyEvent, KeyEvent keyEvent2) {
        return Intrinsics.areEqual(keyEvent, keyEvent2);
    }

    public static int hashCode-impl(KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    public static String toString-impl(KeyEvent keyEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("KeyEvent(nativeKeyEvent=").append(keyEvent).append(')').toString();
    }

    public boolean equals(Object object) {
        return KeyEvent.equals-impl(this.nativeKeyEvent, object);
    }

    public final KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }

    public int hashCode() {
        return KeyEvent.hashCode-impl(this.nativeKeyEvent);
    }

    public String toString() {
        return KeyEvent.toString-impl(this.nativeKeyEvent);
    }

    public final KeyEvent unbox-impl() {
        return this.nativeKeyEvent;
    }
}
