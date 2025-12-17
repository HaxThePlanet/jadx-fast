package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a(\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007\u001a \u0010\u0010\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a%\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u000e*\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"BITS_PER_SLOT", "", "SLOTS_PER_INT", "lambdaKey", "", "bitsForSlot", "bits", "slot", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "", "block", "composableLambdaInstance", "differentBits", "rememberComposableLambda", "(IZLjava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/internal/ComposableLambda;", "sameBits", "replacableWith", "Landroidx/compose/runtime/RecomposeScope;", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposableLambdaKt {

    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;
    private static final Object lambdaKey;
    static {
        Object object = new Object();
        ComposableLambdaKt.lambdaKey = object;
    }

    public static final int bitsForSlot(int bits, int slot) {
        return bits << i3;
    }

    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambda composableLambda(Composer composer, int key, boolean tracked, Object block) {
        Object composableLambdaImpl;
        int i3 = 0;
        composer.startMovableGroup(Integer.rotateLeft(key, 1), ComposableLambdaKt.lambdaKey);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaImpl = new ComposableLambdaImpl(key, tracked, block);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            Object obj = rememberedValue;
            (ComposableLambdaImpl)rememberedValue.update(block);
            composableLambdaImpl = rememberedValue;
        }
        composer.endMovableGroup();
        return (ComposableLambda)composableLambdaImpl;
    }

    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambda composableLambdaInstance(int key, boolean tracked, Object block) {
        ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(key, tracked, block);
        return (ComposableLambda)composableLambdaImpl;
    }

    public static final int differentBits(int slot) {
        return ComposableLambdaKt.bitsForSlot(2, slot);
    }

    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda(int key, boolean tracked, Object block, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty;
        Object composableLambdaImpl;
        int i = -1573003438;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberComposableLambda)P(1,2)*628@13280L54:ComposableLambda.kt#9drcc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:628)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1920923313, "CC(remember):ComposableLambda.kt#9igjgp");
        int i3 = 0;
        Composer composer = $composer;
        int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            composableLambdaImpl = new ComposableLambdaImpl(key, tracked, block);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            composableLambdaImpl = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i4 = 0;
        (ComposableLambdaImpl)composableLambdaImpl.update(block);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ComposableLambda)composableLambdaImpl;
    }

    public static final boolean replacableWith(RecomposeScope $this$replacableWith, RecomposeScope other) {
        int i;
        boolean valid;
        androidx.compose.runtime.Anchor anchor;
        if ($this$replacableWith != null) {
            if ($this$replacableWith instanceof RecomposeScopeImpl && other instanceof RecomposeScopeImpl) {
                if (other instanceof RecomposeScopeImpl) {
                    if ((RecomposeScopeImpl)$this$replacableWith.getValid() && !Intrinsics.areEqual($this$replacableWith, other)) {
                        if (!Intrinsics.areEqual($this$replacableWith, other)) {
                            if (Intrinsics.areEqual((RecomposeScopeImpl)$this$replacableWith.getAnchor(), (RecomposeScopeImpl)other.getAnchor())) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final int sameBits(int slot) {
        return ComposableLambdaKt.bitsForSlot(1, slot);
    }
}
