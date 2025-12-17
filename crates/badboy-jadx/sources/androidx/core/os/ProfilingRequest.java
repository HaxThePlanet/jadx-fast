package androidx.core.os;

import android.os.Bundle;
import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0007\u0018\u00002\u00020\u0001B+\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u0013", d2 = {"Landroidx/core/os/ProfilingRequest;", "", "profilingType", "", "params", "Landroid/os/Bundle;", "tag", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "(ILandroid/os/Bundle;Ljava/lang/String;Landroid/os/CancellationSignal;)V", "getCancellationSignal", "()Landroid/os/CancellationSignal;", "getParams", "()Landroid/os/Bundle;", "getProfilingType", "()I", "getTag", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProfilingRequest {

    private final CancellationSignal cancellationSignal;
    private final Bundle params;
    private final int profilingType;
    private final String tag;
    public ProfilingRequest(int profilingType, Bundle params, String tag, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(params, "params");
        super();
        this.profilingType = profilingType;
        this.params = params;
        this.tag = tag;
        this.cancellationSignal = cancellationSignal;
    }

    public final CancellationSignal getCancellationSignal() {
        return this.cancellationSignal;
    }

    public final Bundle getParams() {
        return this.params;
    }

    public final int getProfilingType() {
        return this.profilingType;
    }

    public final String getTag() {
        return this.tag;
    }
}
