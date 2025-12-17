package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003H\u0090\u0002¢\u0006\u0002\u0008\u0010J\u0017\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\u0008\u0013J&\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0003H\u0090\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J,\u0010\u0018\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u00032\u0006\u0010\u0007\u001a\u0002H\u0015H\u0090\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u001b", d2 = {"Landroidx/compose/ui/modifier/SingleLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "(Landroidx/compose/ui/modifier/ModifierLocal;)V", "<set-?>", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "contains", "", "contains$ui_release", "forceValue", "", "forceValue$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SingleLocalMap extends androidx.compose.ui.modifier.ModifierLocalMap {

    public static final int $stable;
    private final androidx.compose.ui.modifier.ModifierLocal<?> key;
    private final MutableState value$delegate;
    static {
    }

    public SingleLocalMap(androidx.compose.ui.modifier.ModifierLocal<?> key) {
        int i = 0;
        super(i);
        this.key = key;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
    }

    private final Object getValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.value$delegate.getValue();
    }

    private final void setValue(Object <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    public boolean contains$ui_release(androidx.compose.ui.modifier.ModifierLocal<?> key) {
        int i;
        i = key == this.key ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public final void forceValue$ui_release(Object value) {
        setValue(value);
    }

    public <T> T get$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key) {
        int i;
        Object value;
        String str;
        i = key == this.key ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        if (getValue() == null) {
            value = 0;
        }
        return value;
    }

    public <T> void set$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key, T value) {
        int i;
        String str;
        i = key == this.key ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        setValue(value);
    }
}
