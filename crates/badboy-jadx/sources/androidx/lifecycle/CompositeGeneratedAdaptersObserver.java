package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016R\u0016\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e", d2 = {"Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "generatedAdapters", "", "Landroidx/lifecycle/GeneratedAdapter;", "<init>", "([Landroidx/lifecycle/GeneratedAdapter;)V", "[Landroidx/lifecycle/GeneratedAdapter;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CompositeGeneratedAdaptersObserver implements androidx.lifecycle.LifecycleEventObserver {

    private final androidx.lifecycle.GeneratedAdapter[] generatedAdapters;
    public CompositeGeneratedAdaptersObserver(androidx.lifecycle.GeneratedAdapter[] generatedAdapters) {
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        super();
        this.generatedAdapters = generatedAdapters;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
        int i;
        int i2;
        androidx.lifecycle.GeneratedAdapter generatedAdapter;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        androidx.lifecycle.GeneratedAdapter[] generatedAdapters = this.generatedAdapters;
        i = 0;
        i2 = i;
        while (i2 < generatedAdapters.length) {
            generatedAdapters[i2].callMethods(source, event, i, methodCallsLogger);
            i2++;
        }
        androidx.lifecycle.GeneratedAdapter[] generatedAdapters2 = this.generatedAdapters;
        while (i < generatedAdapters2.length) {
            generatedAdapters2[i].callMethods(source, event, true, methodCallsLogger);
            i++;
        }
    }
}
