package kotlinx.coroutines.debug;

import java.io.PrintStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0001\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "()V", "enableCreationStackTraces", "", "installSignalHandler", "", "premain", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AgentPremain {

    public static final kotlinx.coroutines.debug.AgentPremain INSTANCE;
    private static final boolean enableCreationStackTraces;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DebugProbesTransformer implements ClassFileTransformer {

        public static final kotlinx.coroutines.debug.AgentPremain.DebugProbesTransformer INSTANCE;
        static {
            AgentPremain.DebugProbesTransformer debugProbesTransformer = new AgentPremain.DebugProbesTransformer();
            AgentPremain.DebugProbesTransformer.INSTANCE = debugProbesTransformer;
        }

        public byte[] transform(java.lang.ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            boolean equal;
            if (loader != null && !Intrinsics.areEqual(className, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                if (!Intrinsics.areEqual(className, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                }
                AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
                return ByteStreamsKt.readBytes(loader.getResourceAsStream("DebugProbesKt.bin"));
            }
            return null;
        }
    }
    public static void $r8$lambda$qtwhjy3HAlNEjQH7oAL6W8vp2zY(Signal signal) {
        AgentPremain.installSignalHandler$lambda$1(signal);
    }

    static {
        Object constructor-impl;
        boolean enableCreationStackTraces$kotlinx_coroutines_core;
        Object i;
        int i2;
        int valueOf;
        AgentPremain agentPremain = new AgentPremain();
        AgentPremain.INSTANCE = agentPremain;
        kotlinx.coroutines.debug.AgentPremain iNSTANCE = AgentPremain.INSTANCE;
        kotlin.Result.Companion companion2 = Result.Companion;
        i2 = 0;
        String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
        if (property != null) {
            valueOf = Boolean.valueOf(Boolean.parseBoolean(property));
        } else {
            valueOf = i;
        }
        constructor-impl = Result.constructor-impl(valueOf);
        if (Result.isFailure-impl(constructor-impl)) {
        } else {
            i = constructor-impl;
        }
        if ((Boolean)i != null) {
            enableCreationStackTraces$kotlinx_coroutines_core = (Boolean)i.booleanValue();
        } else {
            try {
                enableCreationStackTraces$kotlinx_coroutines_core = DebugProbesImpl.INSTANCE.getEnableCreationStackTraces$kotlinx_coroutines_core();
                AgentPremain.enableCreationStackTraces = enableCreationStackTraces$kotlinx_coroutines_core;
            }
        }
    }

    private final void installSignalHandler() {
        Signal signal;
        signal = new Signal("TRAP");
        AgentPremain$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new AgentPremain$$ExternalSyntheticLambda0();
        Signal.handle(signal, externalSyntheticLambda0);
    }

    private static final void installSignalHandler$lambda$1(Signal it) {
        Object iNSTANCE;
        PrintStream out;
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_debug()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        } else {
            System.out.println("Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @JvmStatic
    public static final void premain(String args, Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer((ClassFileTransformer)AgentPremain.DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces$kotlinx_coroutines_core(AgentPremain.enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install$kotlinx_coroutines_core();
        AgentPremain.INSTANCE.installSignalHandler();
    }
}
