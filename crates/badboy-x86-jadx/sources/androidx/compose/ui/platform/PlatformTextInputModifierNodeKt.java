package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\tH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\u000c*\u00020\r2'\u0010\u000e\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¢\u0006\u0002\u0008\u0013H\u0086@¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u00020\u000c*\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00022'\u0010\u0018\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¢\u0006\u0002\u0008\u0013H\u0082@¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"LocalChainedPlatformTextInputInterceptor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "InterceptPlatformTextInput", "", "interceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptedTextInputSession", "Landroidx/compose/ui/node/Owner;", "chainedInterceptor", "session", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformTextInputModifierNodeKt {

    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor> LocalChainedPlatformTextInputInterceptor;
    static {
        PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor = CompositionLocalKt.staticCompositionLocalOf((Function0)PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor.1.INSTANCE);
    }

    public static final void InterceptPlatformTextInput(androidx.compose.ui.platform.PlatformTextInputInterceptor interceptor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int this_$iv;
        int $dirty;
        int i3;
        int i5;
        int invalid$iv;
        boolean traceInProgress2;
        boolean changedInstance;
        int traceInProgress;
        int i;
        int i2;
        int i4;
        Object empty;
        Object chainedPlatformTextInputInterceptor;
        this_$iv = 1315007550;
        final Composer obj11 = $composer.startRestartGroup(this_$iv);
        ComposerKt.sourceInformation(obj11, "C(InterceptPlatformTextInput)P(1)163@7651L7,168@8038L89,176@8348L135:PlatformTextInputModifierNode.kt#itgzvw");
        if ($changed & 6 == 0) {
            if ($changed & 8 == 0) {
                changedInstance = obj11.changed(interceptor);
            } else {
                changedInstance = obj11.changedInstance(interceptor);
            }
            i3 = changedInstance != null ? 4 : 2;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i5 = obj11.changedInstance(content) ? 32 : 16;
            $dirty |= i5;
        }
        if ($dirty & 19 == 18) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_$iv, $dirty, -1, "androidx.compose.ui.platform.InterceptPlatformTextInput (PlatformTextInputModifierNode.kt:162)");
                }
                int i6 = 6;
                int i9 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj11);
                this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(obj11, -1708127741, "CC(remember):PlatformTextInputModifierNode.kt#9igjgp");
                Composer composer = obj11;
                int i11 = 0;
                Object rememberedValue = composer.rememberedValue();
                i4 = 0;
                if (!obj11.changed((ChainedPlatformTextInputInterceptor)this_$iv)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        chainedPlatformTextInputInterceptor = new ChainedPlatformTextInputInterceptor(interceptor, this_$iv);
                        composer.updateRememberedValue(chainedPlatformTextInputInterceptor);
                    } else {
                        chainedPlatformTextInputInterceptor = rememberedValue;
                    }
                } else {
                }
                invalid$iv = chainedPlatformTextInputInterceptor;
                ComposerKt.sourceInformationMarkerEnd(obj11);
                (ChainedPlatformTextInputInterceptor)invalid$iv.updateInterceptor(interceptor);
                CompositionLocalKt.CompositionLocalProvider(PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor.provides(invalid$iv), content, obj11, $stable |= i2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new PlatformTextInputModifierNodeKt.InterceptPlatformTextInput.1(interceptor, content, $changed);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    public static final Object access$interceptedTextInputSession(Owner $receiver, androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor chainedInterceptor, Function2 session, Continuation $completion) {
        return PlatformTextInputModifierNodeKt.interceptedTextInputSession($receiver, chainedInterceptor, session, $completion);
    }

    public static final Object establishTextInputSession(androidx.compose.ui.platform.PlatformTextInputModifierNode platformTextInputModifierNode, Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function22, Continuation<?> continuation3) {
        boolean anon;
        int i2;
        int i;
        Owner requireOwner;
        Object obj;
        ProvidableCompositionLocal localChainedPlatformTextInputInterceptor;
        Object obj5;
        Object obj7;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof PlatformTextInputModifierNodeKt.establishTextInputSession.1 && label &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new PlatformTextInputModifierNodeKt.establishTextInputSession.1(continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (requireOwner) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = 0;
                obj5 = new IllegalArgumentException("establishTextInputSession called from an unattached node".toString());
                throw obj5;
            case 1:
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        obj5 = new KotlinNothingValueException();
        throw obj5;
    }

    private static final Object interceptedTextInputSession(Owner owner, androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor2, Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function23, Continuation<?> continuation4) {
        boolean anon;
        int i;
        int i2;
        int label;
        Object obj3;
        int obj4;
        Object obj6;
        anon = continuation4;
        i2 = Integer.MIN_VALUE;
        if (continuation4 instanceof PlatformTextInputModifierNodeKt.interceptedTextInputSession.1 && label2 &= i2 != 0) {
            anon = continuation4;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new PlatformTextInputModifierNodeKt.interceptedTextInputSession.1(continuation4);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj3 = new KotlinNothingValueException();
                throw obj3;
            case 1:
                ResultKt.throwOnFailure(obj6);
                break;
            case 2:
                ResultKt.throwOnFailure(obj6);
                obj3 = new KotlinNothingValueException();
                throw obj3;
            default:
                obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj3;
        }
        obj3 = new KotlinNothingValueException();
        throw obj3;
    }
}
