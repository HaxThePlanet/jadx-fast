package androidx.lifecycle;

/* loaded from: classes5.dex */
@Deprecated
public interface LifecycleRegistryOwner extends androidx.lifecycle.LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return getLifecycle();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public abstract androidx.lifecycle.LifecycleRegistry getLifecycle();
}
