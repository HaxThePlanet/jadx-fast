package androidx.lifecycle.viewmodel.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u0001B\t\u0008\u0016¢\u0006\u0004\u0008\u0002\u0010\u0003B\u0011\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0002\u0010\u0006B%\u0008\u0016\u0012\u001a\u0010\u0007\u001a\u000e\u0012\n\u0008\u0001\u0012\u00060\tj\u0002`\n0\u0008\"\u00060\tj\u0002`\n¢\u0006\u0004\u0008\u0002\u0010\u000bB-\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0007\u001a\u000e\u0012\n\u0008\u0001\u0012\u00060\tj\u0002`\n0\u0008\"\u00060\tj\u0002`\n¢\u0006\u0004\u0008\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\n\u0010\u0019\u001a\u00060\tj\u0002`\nJ\u0012\u0010\u0017\u001a\u00020\u00162\n\u0010\u0019\u001a\u00060\tj\u0002`\nJ#\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u000c\u0008\u0000\u0010\u001b*\u00060\tj\u0002`\n2\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0008\u0012\u00060\tj\u0002`\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u00060\tj\u0002`\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "", "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "closeables", "", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "([Ljava/lang/AutoCloseable;)V", "(Lkotlinx/coroutines/CoroutineScope;[Ljava/lang/AutoCloseable;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "keyToCloseables", "", "", "", "isCleared", "", "clear", "", "addCloseable", "key", "closeable", "getCloseable", "T", "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "closeWithRuntimeException", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelImpl {

    private final Set<java.lang.AutoCloseable> closeables;
    private volatile boolean isCleared;
    private final Map<String, java.lang.AutoCloseable> keyToCloseables;
    private final androidx.lifecycle.viewmodel.internal.SynchronizedObject lock;
    public ViewModelImpl() {
        super();
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.keyToCloseables = (Map)linkedHashMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = (Set)linkedHashSet;
    }

    public ViewModelImpl(CoroutineScope viewModelScope) {
        Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
        super();
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.keyToCloseables = (Map)linkedHashMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = (Set)linkedHashSet;
        addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", (AutoCloseable)CloseableCoroutineScopeKt.asCloseable(viewModelScope));
    }

    public ViewModelImpl(CoroutineScope viewModelScope, java.lang.AutoCloseable... closeables) {
        Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        super();
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.keyToCloseables = (Map)linkedHashMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = (Set)linkedHashSet;
        addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", (AutoCloseable)CloseableCoroutineScopeKt.asCloseable(viewModelScope));
        CollectionsKt.addAll((Collection)this.closeables, closeables);
    }

    public ViewModelImpl(java.lang.AutoCloseable... closeables) {
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        super();
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.keyToCloseables = (Map)linkedHashMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = (Set)linkedHashSet;
        CollectionsKt.addAll((Collection)this.closeables, closeables);
    }

    public static final void access$closeWithRuntimeException(androidx.lifecycle.viewmodel.internal.ViewModelImpl $this, java.lang.AutoCloseable closeable) {
        $this.closeWithRuntimeException(closeable);
    }

    public static final Set access$getCloseables$p(androidx.lifecycle.viewmodel.internal.ViewModelImpl $this) {
        return $this.closeables;
    }

    public static final Map access$getKeyToCloseables$p(androidx.lifecycle.viewmodel.internal.ViewModelImpl $this) {
        return $this.keyToCloseables;
    }

    private final void closeWithRuntimeException(java.lang.AutoCloseable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    public final void addCloseable(java.lang.AutoCloseable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(closeable);
        }
        androidx.lifecycle.viewmodel.internal.SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        (Collection)ViewModelImpl.access$getCloseables$p(this).add(closeable);
        Unit $i$a$SynchronizedViewModelImpl$addCloseable$1 = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            i3 = 0;
            (Collection)ViewModelImpl.access$getCloseables$p(this).add(closeable);
            $i$a$SynchronizedViewModelImpl$addCloseable$1 = Unit.INSTANCE;
        }
    }

    public final void addCloseable(String key, java.lang.AutoCloseable closeable) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(closeable);
        }
        androidx.lifecycle.viewmodel.internal.SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        closeWithRuntimeException((AutoCloseable)ViewModelImpl.access$getKeyToCloseables$p(this).put(key, closeable));
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            i3 = 0;
            closeWithRuntimeException((AutoCloseable)ViewModelImpl.access$getKeyToCloseables$p(this).put(key, closeable));
        }
    }

    public final void clear() {
        Object next2;
        boolean next;
        if (this.isCleared) {
        }
        this.isCleared = true;
        androidx.lifecycle.viewmodel.internal.SynchronizedObject lock = this.lock;
        final int i2 = 0;
        final int i3 = 0;
        int i4 = 0;
        Iterator iterator = ViewModelImpl.access$getKeyToCloseables$p(this).values().iterator();
        synchronized (lock) {
            for (AutoCloseable next2 : iterator) {
                ViewModelImpl.access$closeWithRuntimeException(this, next2);
            }
            Iterator iterator2 = ViewModelImpl.access$getCloseables$p(this).iterator();
            for (AutoCloseable next : iterator2) {
                ViewModelImpl.access$closeWithRuntimeException(this, next);
            }
            ViewModelImpl.access$getCloseables$p(this).clear();
            Unit $i$a$SynchronizedViewModelImpl$clear$1 = Unit.INSTANCE;
        }
    }

    public final <T extends java.lang.AutoCloseable> T getCloseable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        androidx.lifecycle.viewmodel.internal.SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (AutoCloseable)ViewModelImpl.access$getKeyToCloseables$p(this).get(key);
        synchronized (lock) {
            Intrinsics.checkNotNullParameter(key, "key");
            lock = this.lock;
            i = 0;
            i2 = 0;
            i3 = 0;
            return (AutoCloseable)ViewModelImpl.access$getKeyToCloseables$p(this).get(key);
        }
    }
}
