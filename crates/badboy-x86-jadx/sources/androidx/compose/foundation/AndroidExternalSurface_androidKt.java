package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0008\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0008\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidExternalSurface_androidKt {
    public static final void AndroidEmbeddedExternalSurface-sv6N_fY(Modifier modifier, boolean isOpaque, long surfaceSize, float[] transform, Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, Unit> onInit, Composer $composer, int $changed, int i8) {
        int empty;
        int traceInProgress;
        int $dirty;
        Object $dirty2;
        int modifier3;
        boolean traceInProgress2;
        Object state;
        boolean z2;
        Object zero-YbymL2g;
        int i2;
        int changed2;
        long l2;
        int i12;
        int i11;
        int i14;
        int skipping;
        boolean defaultsInvalid;
        int i4;
        int i13;
        int changed;
        float[] fArr2;
        boolean anon;
        int i7;
        int i10;
        Object obj2;
        int modifier2;
        boolean changed3;
        int i5;
        long l;
        Object obj;
        int box-impl;
        int i9;
        int i6;
        int i;
        Object rememberedValue;
        int i3;
        int box-impl2;
        int anon2;
        Composer.Companion companion;
        androidx.compose.foundation.AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState;
        boolean z;
        float[] fArr;
        final Object obj5 = $composer;
        final int i33 = i8;
        traceInProgress = 217541314;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(AndroidEmbeddedExternalSurface)P(1!1,3:c#ui.unit.IntSize,4:c#ui.graphics.Matrix)455@18917L45,458@18999L203,467@19273L485,457@18968L796:AndroidExternalSurface.android.kt#71ulvw");
        $dirty = i8;
        int i15 = obj30 & 1;
        if (i15 != 0) {
            $dirty |= 6;
            zero-YbymL2g = modifier;
        } else {
            if (i33 & 6 == 0) {
                i12 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i12;
            } else {
                zero-YbymL2g = modifier;
            }
        }
        i14 = obj30 & 2;
        if (i14 != 0) {
            $dirty |= 48;
            anon = isOpaque;
        } else {
            if (i33 & 48 == 0) {
                i7 = restartGroup.changed(isOpaque) ? 32 : 16;
                $dirty |= i7;
            } else {
                anon = isOpaque;
            }
        }
        i5 = 256;
        if (i33 & 384 == 0) {
            if (obj30 & 4 == 0) {
                i10 = restartGroup.changed(surfaceSize) ? i5 : 128;
            } else {
                l = surfaceSize;
            }
            $dirty |= i10;
        } else {
            l = surfaceSize;
        }
        int i35 = obj30 & 8;
        if (i35 != 0) {
            $dirty |= 3072;
        } else {
            if (i33 & 3072 == 0) {
                if (onInit != null) {
                    box-impl2 = Matrix.box-impl(onInit);
                } else {
                    box-impl2 = 0;
                }
                i6 = restartGroup.changedInstance(box-impl2) ? 2048 : 1024;
                $dirty |= i6;
            }
        }
        i9 = 16384;
        if (obj30 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i33 & 24576 == 0) {
                i = restartGroup.changedInstance(obj5) ? i9 : 8192;
                $dirty |= i;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = zero-YbymL2g;
                        }
                        if (i14 != 0) {
                            anon = zero-YbymL2g;
                        }
                        if (obj30 & 4 != 0) {
                            $dirty &= -897;
                            l = zero-YbymL2g;
                        }
                        if (i35 != 0) {
                            obj2 = modifier3;
                            fArr = zero-YbymL2g;
                            z = anon;
                        } else {
                            fArr = onInit;
                            obj2 = modifier3;
                            z = anon;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj30 & 4 != 0) {
                            $dirty &= -897;
                        }
                        fArr = onInit;
                        obj2 = zero-YbymL2g;
                        z = anon;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)");
                }
                empty = 0;
                androidx.compose.foundation.AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState = AndroidExternalSurface_androidKt.rememberAndroidEmbeddedExternalSurfaceState(restartGroup, empty);
                String str2 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 184051342, str2);
                if (i28 ^= 384 > i5) {
                    if (!restartGroup.changed(l)) {
                        i4 = $dirty & 384 == i5 ? 1 : empty;
                    } else {
                    }
                } else {
                }
                i13 = i29 &= $dirty == i9 ? 1 : empty;
                Composer composer = restartGroup;
                int i36 = 0;
                rememberedValue = composer.rememberedValue();
                anon2 = 0;
                if (i20 |= i13 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface.1.1(rememberAndroidEmbeddedExternalSurfaceState, l, obj12, obj5);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 184060392, str2);
                if (i23 ^= 384 > i5) {
                    if (!restartGroup.changed(l)) {
                        i2 = $dirty & 384 == i5 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i11 = $dirty & 112 == 32 ? 1 : 0;
                if (fArr != null) {
                    box-impl = Matrix.box-impl(fArr);
                } else {
                    box-impl = 0;
                }
                i14 = restartGroup;
                int i32 = 0;
                Object rememberedValue2 = i14.rememberedValue();
                int i37 = 0;
                if (i25 |= changedInstance3 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        anon2 = new AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface.3.1(l, obj18, rememberAndroidEmbeddedExternalSurfaceState, z, fArr);
                        i14.updateRememberedValue((Function1)anon2);
                    } else {
                        androidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState;
                        state = rememberedValue2;
                        companion = l;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidView_androidKt.AndroidView((Function1)anon, obj2, (Function1)AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface.2.INSTANCE, 0, (Function1)state, restartGroup, i17 | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = $dirty;
                $dirty2 = obj4;
                l2 = companion;
                z2 = z;
                fArr2 = fArr;
            } else {
                restartGroup.skipToGroupEnd();
                fArr2 = onInit;
                modifier2 = $dirty;
                $dirty2 = zero-YbymL2g;
                z2 = anon;
                l2 = l;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface.4($dirty2, z2, l2, i14, fArr2, obj5, i33, obj30);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void AndroidExternalSurface-58FFMhA(Modifier modifier, boolean isOpaque, long surfaceSize, int zOrder, boolean isSecure, Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, Unit> onInit, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        Object it$iv;
        int $dirty;
        Object $dirty2;
        Object obj;
        boolean z3;
        int modifier2;
        boolean traceInProgress;
        Object behind-B_4ceCc;
        long l2;
        int i5;
        int changed;
        int i3;
        int i14;
        int i;
        int i2;
        int i10;
        int i11;
        int i15;
        int i12;
        int skipping;
        boolean defaultsInvalid;
        boolean z;
        boolean z4;
        int i6;
        int i4;
        int $this$cache$iv;
        boolean changed2;
        int i17;
        long l3;
        int i13;
        boolean z2;
        int i16;
        int i18;
        int i7;
        Composer.Companion companion;
        int i19;
        int i8;
        int $dirty3;
        long l;
        int companion2;
        boolean z5;
        androidx.compose.foundation.AndroidExternalSurface_androidKt.AndroidExternalSurface.3.1 obj23;
        long obj24;
        Object obj25;
        boolean obj26;
        int obj27;
        boolean obj28;
        androidx.compose.foundation.AndroidExternalSurface_androidKt.AndroidExternalSurface.2 obj30;
        final Object obj2 = $composer;
        final int i43 = i9;
        traceInProgress2 = 640888974;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(AndroidExternalSurface)P(2!1,4:c#ui.unit.IntSize,5:c#foundation.AndroidExternalSurfaceZOrder)288@12167L37,291@12241L150,299@12462L774,290@12210L1032:AndroidExternalSurface.android.kt#71ulvw");
        $dirty = i9;
        int i23 = obj32 & 1;
        if (i23 != 0) {
            $dirty |= 6;
            behind-B_4ceCc = modifier;
        } else {
            if (i43 & 6 == 0) {
                i14 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i14;
            } else {
                behind-B_4ceCc = modifier;
            }
        }
        i = obj32 & 2;
        if (i != 0) {
            $dirty |= 48;
            z = isOpaque;
        } else {
            if (i43 & 48 == 0) {
                i6 = restartGroup.changed(isOpaque) ? 32 : 16;
                $dirty |= i6;
            } else {
                z = isOpaque;
            }
        }
        if (i43 & 384 == 0) {
            if (obj32 & 4 == 0) {
                i4 = restartGroup.changed(surfaceSize) ? 256 : 128;
            } else {
                l3 = surfaceSize;
            }
            $dirty |= i4;
        } else {
            l3 = surfaceSize;
        }
        $this$cache$iv = obj32 & 8;
        if ($this$cache$iv != 0) {
            $dirty |= 3072;
            i16 = isSecure;
        } else {
            if (i43 & 3072 == 0) {
                i18 = restartGroup.changed(isSecure) ? 2048 : 1024;
                $dirty |= i18;
            } else {
                i16 = isSecure;
            }
        }
        i7 = obj32 & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            z2 = onInit;
        } else {
            if (i43 & 24576 == 0) {
                i19 = restartGroup.changed(onInit) ? 16384 : 8192;
                $dirty |= i19;
            } else {
                z2 = onInit;
            }
        }
        final int i51 = 196608;
        if (obj32 & 32 != 0) {
            $dirty |= i51;
        } else {
            if (i43 & i51 == 0) {
                i8 = restartGroup.changedInstance(obj2) ? 131072 : 65536;
                $dirty |= i8;
            }
        }
        if ($dirty & i49 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = behind-B_4ceCc;
                        }
                        if (i != 0) {
                            z = behind-B_4ceCc;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                            l3 = behind-B_4ceCc;
                        }
                        if ($this$cache$iv != 0) {
                            i16 = behind-B_4ceCc;
                        }
                        if (i7 != 0) {
                            i17 = modifier2;
                            z2 = behind-B_4ceCc;
                        } else {
                            i17 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i17 = behind-B_4ceCc;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)");
                }
                int i20 = 0;
                androidx.compose.foundation.AndroidExternalSurfaceState rememberAndroidExternalSurfaceState = AndroidExternalSurface_androidKt.rememberAndroidExternalSurfaceState(restartGroup, i20);
                String str2 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1356109309, str2);
                i5 = i26 &= $dirty == 131072 ? 1 : i20;
                Composer composer = restartGroup;
                int i47 = 0;
                it$iv = composer.rememberedValue();
                int i50 = 0;
                if (i5 |= changedInstance == null) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        defaultsInvalid = 0;
                        obj25 = it$iv;
                        it$iv = new AndroidExternalSurface_androidKt.AndroidExternalSurface.1.1(obj2, rememberAndroidExternalSurfaceState);
                        composer.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj25 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1356101613, str2);
                if (i30 ^= 384 > 256) {
                    if (!restartGroup.changed(l3)) {
                        i3 = $dirty & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                i10 = $dirty & 112 == 32 ? 1 : 0;
                i11 = $dirty & 7168 == 2048 ? 1 : 0;
                i15 = i36 &= $dirty == 16384 ? 1 : 0;
                i = restartGroup;
                int i41 = 0;
                Object rememberedValue = i.rememberedValue();
                int i48 = 0;
                if (i32 |= i15 == 0) {
                    $dirty3 = $dirty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int $dirty4 = 0;
                        obj26 = z;
                        obj24 = l3;
                        obj28 = z2;
                        obj27 = i16;
                        obj23 = anon2;
                        super(obj24, obj25, obj26, obj27, obj28);
                        l = obj24;
                        companion = obj26;
                        companion2 = obj27;
                        z5 = obj28;
                        i.updateRememberedValue((Function1)obj23);
                    } else {
                        obj = rememberedValue;
                        companion = z;
                        l = l3;
                        z5 = z2;
                        companion2 = i16;
                    }
                } else {
                    $dirty3 = $dirty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidView_androidKt.AndroidView((Function1)it$iv, i17, (Function1)AndroidExternalSurface_androidKt.AndroidExternalSurface.2.INSTANCE, 0, (Function1)obj, restartGroup, i22 | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = i17;
                z3 = companion;
                l2 = l;
                i12 = companion2;
                z4 = z5;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty3 = $dirty;
                $dirty2 = behind-B_4ceCc;
                z3 = z;
                l2 = l3;
                z4 = z2;
                i12 = i16;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AndroidExternalSurface_androidKt.AndroidExternalSurface.4($dirty2, z3, l2, i, i12, z4, obj2, i43, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final androidx.compose.foundation.AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object androidEmbeddedExternalSurfaceState;
        int empty2;
        kotlinx.coroutines.CoroutineScope compositionCoroutineScope;
        Object compositionScopedCoroutineScopeCanceller;
        int i = -1057437053;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberAndroidEmbeddedExternalSurfaceState)384@15036L24,385@15072L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        int i2 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, -954363344, "CC(remember):Effects.kt#9igjgp");
        int i9 = 0;
        Composer composer3 = $composer;
        int i10 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i12 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty2 = 0;
            int i13 = 0;
            compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer));
            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
        } else {
            compositionScopedCoroutineScopeCanceller = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1142294264, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            androidEmbeddedExternalSurfaceState = new AndroidEmbeddedExternalSurfaceState((CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope());
            composer.updateRememberedValue(androidEmbeddedExternalSurfaceState);
        } else {
            androidEmbeddedExternalSurfaceState = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (AndroidEmbeddedExternalSurfaceState)androidEmbeddedExternalSurfaceState;
    }

    private static final androidx.compose.foundation.AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object androidExternalSurfaceState;
        int empty2;
        kotlinx.coroutines.CoroutineScope compositionCoroutineScope;
        Object compositionScopedCoroutineScopeCanceller;
        int i = -873615933;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberAndroidExternalSurfaceState)190@7150L24,191@7186L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        int i2 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, -954363344, "CC(remember):Effects.kt#9igjgp");
        int i9 = 0;
        Composer composer3 = $composer;
        int i10 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i12 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty2 = 0;
            int i13 = 0;
            compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer));
            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
        } else {
            compositionScopedCoroutineScopeCanceller = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1983762950, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            androidExternalSurfaceState = new AndroidExternalSurfaceState((CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope());
            composer.updateRememberedValue(androidExternalSurfaceState);
        } else {
            androidExternalSurfaceState = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (AndroidExternalSurfaceState)androidExternalSurfaceState;
    }
}
