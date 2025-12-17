package androidx.compose.ui.modifier;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0008\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u000bH\u0090\u0002¢\u0006\u0002\u0008\u000cJ&\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u000bH\u0090\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J,\u0010\u0011\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u000e2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u000b2\u0006\u0010\u0013\u001a\u0002H\u000eH\u0090\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0016", d2 = {"Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "element", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "(Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "getElement", "()Landroidx/compose/ui/modifier/ModifierLocalProvider;", "setElement", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackwardsCompatLocalMap extends androidx.compose.ui.modifier.ModifierLocalMap {

    public static final int $stable = 8;
    private androidx.compose.ui.modifier.ModifierLocalProvider<?> element;
    static {
        final int i = 8;
    }

    public BackwardsCompatLocalMap(androidx.compose.ui.modifier.ModifierLocalProvider<?> element) {
        super(0);
        this.element = element;
    }

    public boolean contains$ui_release(androidx.compose.ui.modifier.ModifierLocal<?> key) {
        int i;
        i = key == this.element.getKey() ? 1 : 0;
        return i;
    }

    public <T> T get$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key) {
        int i;
        String str;
        i = key == this.element.getKey() ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        return this.element.getValue();
    }

    public final androidx.compose.ui.modifier.ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    public <T> void set$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key, T value) {
        IllegalStateException illegalStateException = new IllegalStateException("Set is not allowed on a backwards compat provider".toString());
        throw illegalStateException;
    }

    public final void setElement(androidx.compose.ui.modifier.ModifierLocalProvider<?> <set-?>) {
        this.element = <set-?>;
    }
}
