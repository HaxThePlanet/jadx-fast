package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lkotlinx/coroutines/debug/internal/AgentInstallationType;", "", "()V", "isInstalledStatically", "", "isInstalledStatically$kotlinx_coroutines_core", "()Z", "setInstalledStatically$kotlinx_coroutines_core", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AgentInstallationType {

    public static final kotlinx.coroutines.debug.internal.AgentInstallationType INSTANCE;
    private static boolean isInstalledStatically;
    static {
        AgentInstallationType agentInstallationType = new AgentInstallationType();
        AgentInstallationType.INSTANCE = agentInstallationType;
    }

    public final boolean isInstalledStatically$kotlinx_coroutines_core() {
        return AgentInstallationType.isInstalledStatically;
    }

    public final void setInstalledStatically$kotlinx_coroutines_core(boolean <set-?>) {
        AgentInstallationType.isInstalledStatically = <set-?>;
    }
}
