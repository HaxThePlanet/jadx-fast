package androidx.core.os;

import android.os.Bundle;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0004H\u0015J\u0008\u0010\u0006\u001a\u00020\u0007H\u0015J\u0008\u0010\u0008\u001a\u00020\u0000H\u0015J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/core/os/JavaHeapDumpRequestBuilder;", "Landroidx/core/os/ProfilingRequestBuilder;", "()V", "mParams", "Landroid/os/Bundle;", "getParams", "getProfilingType", "", "getThis", "setBufferSizeKb", "bufferSizeKb", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JavaHeapDumpRequestBuilder extends androidx.core.os.ProfilingRequestBuilder<androidx.core.os.JavaHeapDumpRequestBuilder> {

    private final Bundle mParams;
    public JavaHeapDumpRequestBuilder() {
        super();
        Bundle bundle = new Bundle();
        this.mParams = bundle;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    protected Bundle getParams() {
        return this.mParams;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    protected int getProfilingType() {
        return 1;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    protected androidx.core.os.JavaHeapDumpRequestBuilder getThis() {
        return this;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    public androidx.core.os.ProfilingRequestBuilder getThis() {
        return (ProfilingRequestBuilder)getThis();
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    public final androidx.core.os.JavaHeapDumpRequestBuilder setBufferSizeKb(int bufferSizeKb) {
        this.mParams.putInt("KEY_SIZE_KB", bufferSizeKb);
        return this;
    }
}
