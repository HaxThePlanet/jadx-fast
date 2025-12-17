package androidx.compose.runtime.saveable;

import androidx.compose.runtime.RememberObserver;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u00020\u0003BE\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0010\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0010\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u0018J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001aH\u0016J\u0008\u0010\u001c\u001a\u00020\u001aH\u0016J\u0008\u0010\u001d\u001a\u00020\u001aH\u0002JK\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0010\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00060\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/runtime/saveable/SaveableHolder;", "T", "Landroidx/compose/runtime/saveable/SaverScope;", "Landroidx/compose/runtime/RememberObserver;", "saver", "Landroidx/compose/runtime/saveable/Saver;", "", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "key", "", "value", "inputs", "", "(Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "entry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "[Ljava/lang/Object;", "Ljava/lang/Object;", "valueProvider", "Lkotlin/Function0;", "canBeSaved", "", "getValueIfInputsDidntChange", "([Ljava/lang/Object;)Ljava/lang/Object;", "onAbandoned", "", "onForgotten", "onRemembered", "register", "update", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SaveableHolder<T>  implements androidx.compose.runtime.saveable.SaverScope, RememberObserver {

    private androidx.compose.runtime.saveable.SaveableStateRegistry.Entry entry;
    private Object[] inputs;
    private String key;
    private androidx.compose.runtime.saveable.SaveableStateRegistry registry;
    private androidx.compose.runtime.saveable.Saver<T, Object> saver;
    private T value;
    private final Function0<Object> valueProvider;
    public SaveableHolder(androidx.compose.runtime.saveable.Saver<T, Object> saver, androidx.compose.runtime.saveable.SaveableStateRegistry registry, String key, T value, Object[] inputs) {
        super();
        this.saver = saver;
        this.registry = registry;
        this.key = key;
        this.value = value;
        this.inputs = inputs;
        SaveableHolder.valueProvider.1 anon = new SaveableHolder.valueProvider.1(this);
        this.valueProvider = (Function0)anon;
    }

    public static final androidx.compose.runtime.saveable.Saver access$getSaver$p(androidx.compose.runtime.saveable.SaveableHolder $this) {
        return $this.saver;
    }

    public static final Object access$getValue$p(androidx.compose.runtime.saveable.SaveableHolder $this) {
        return $this.value;
    }

    private final void register() {
        int registerProvider;
        Function0 valueProvider;
        final androidx.compose.runtime.saveable.SaveableStateRegistry registry = this.registry;
        registerProvider = this.entry == null ? 1 : 0;
        if (registerProvider == null) {
        } else {
            if (registry != null) {
                RememberSaveableKt.access$requireCanBeSaved(registry, this.valueProvider.invoke());
                this.entry = registry.registerProvider(this.key, this.valueProvider);
            }
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("entry(").append(this.entry).append(") is not null").toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public boolean canBeSaved(Object value) {
        int i;
        boolean beSaved;
        final androidx.compose.runtime.saveable.SaveableStateRegistry registry = this.registry;
        if (registry != null) {
            if (registry.canBeSaved(value)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final T getValueIfInputsDidntChange(Object[] inputs) {
        Object value;
        value = Arrays.equals(inputs, this.inputs) ? this.value : 0;
        return value;
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public void onAbandoned() {
        final androidx.compose.runtime.saveable.SaveableStateRegistry.Entry entry = this.entry;
        if (entry != null) {
            entry.unregister();
        }
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public void onForgotten() {
        final androidx.compose.runtime.saveable.SaveableStateRegistry.Entry entry = this.entry;
        if (entry != null) {
            entry.unregister();
        }
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public void onRemembered() {
        register();
    }

    public final void update(androidx.compose.runtime.saveable.Saver<T, Object> saver, androidx.compose.runtime.saveable.SaveableStateRegistry registry, String key, T value, Object[] inputs) {
        int entryIsOutdated;
        androidx.compose.runtime.saveable.SaveableStateRegistry.Entry entry;
        entryIsOutdated = 0;
        if (this.registry != registry) {
            this.registry = registry;
            entryIsOutdated = 1;
        }
        if (!Intrinsics.areEqual(this.key, key)) {
            this.key = key;
            entryIsOutdated = 1;
        }
        this.saver = saver;
        this.value = value;
        this.inputs = inputs;
        androidx.compose.runtime.saveable.SaveableStateRegistry.Entry entry2 = this.entry;
        if (this.entry != null && entryIsOutdated != 0 && entry2 != null) {
            if (entryIsOutdated != 0) {
                entry2 = this.entry;
                if (entry2 != null) {
                    entry2.unregister();
                }
                this.entry = 0;
                register();
            }
        }
    }
}
