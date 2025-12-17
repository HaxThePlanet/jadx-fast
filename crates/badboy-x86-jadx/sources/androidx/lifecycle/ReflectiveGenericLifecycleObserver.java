package androidx.lifecycle;

/* loaded from: classes5.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements androidx.lifecycle.LifecycleEventObserver {

    private final androidx.lifecycle.ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;
    ReflectiveGenericLifecycleObserver(Object wrapped) {
        super();
        this.mWrapped = wrapped;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(this.mWrapped.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
        this.mInfo.invokeCallbacks(source, event, this.mWrapped);
    }
}
