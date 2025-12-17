package androidx.compose.ui.modifier;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0001\n\u0002\u0008\u0004\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006H\u0090\u0002¢\u0006\u0002\u0008\u0007J$\u0010\u0008\u001a\u0002H\t\"\u0004\u0008\u0000\u0010\t2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0006H\u0090\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ,\u0010\u000c\u001a\u00020\r\"\u0004\u0008\u0000\u0010\t2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u000e\u001a\u0002H\tH\u0090\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/compose/ui/modifier/EmptyMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "()V", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)Ljava/lang/Void;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EmptyMap extends androidx.compose.ui.modifier.ModifierLocalMap {

    public static final int $stable;
    public static final androidx.compose.ui.modifier.EmptyMap INSTANCE;
    static {
        EmptyMap emptyMap = new EmptyMap();
        EmptyMap.INSTANCE = emptyMap;
    }

    private EmptyMap() {
        super(0);
    }

    public boolean contains$ui_release(androidx.compose.ui.modifier.ModifierLocal<?> key) {
        return 0;
    }

    public <T> T get$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key) {
        IllegalStateException illegalStateException = new IllegalStateException("".toString());
        throw illegalStateException;
    }

    public <T> Void set$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key, T value) {
        IllegalStateException illegalStateException = new IllegalStateException("".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public void set$ui_release(androidx.compose.ui.modifier.ModifierLocal key, Object value) {
        set$ui_release(key, value);
    }
}
