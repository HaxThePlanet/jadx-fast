package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001aw\u0010\u0019\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d", d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CardKt {
    public static final void Card(Modifier modifier, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int $dirty;
        Object $dirty2;
        Object obj;
        Object modifier2;
        boolean traceInProgress2;
        Object shape2;
        Object obj4;
        int i6;
        Object obj6;
        Object colors3;
        Object colors2;
        int changed;
        Object obj2;
        Object elevation3;
        Object elevation2;
        int changed2;
        Object iNSTANCE;
        int changed3;
        Object obj3;
        int shape3;
        Object obj5;
        int i;
        int i7;
        boolean containerColor-vNxB06k$material3_release;
        int defaultsInvalid;
        int i8;
        int contentColor-vNxB06k$material3_release;
        int i3;
        int i10;
        Composer restartGroup;
        int i4;
        int i11;
        int i12;
        int i2;
        int i5;
        int obj21;
        final Object obj9 = content;
        final int i37 = $changed;
        traceInProgress = 1179621553;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Card)P(4,5,1,3)82@3741L5,83@3786L12,84@3844L15,93@4163L57,95@4259L41,88@3951L349:Card.kt#uh7d8r");
        $dirty = $changed;
        int i21 = i9 & 1;
        if (i21 != 0) {
            $dirty |= 6;
            shape2 = modifier;
        } else {
            if (i37 & 6 == 0) {
                i6 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i6;
            } else {
                shape2 = modifier;
            }
        }
        if (i37 & 48 == 0) {
            if (i9 & 2 == 0) {
                changed = restartGroup.changed(shape) ? 32 : 16;
            } else {
                obj6 = shape;
            }
            $dirty |= changed;
        } else {
            obj6 = shape;
        }
        if (i37 & 384 == 0) {
            if (i9 & 4 == 0) {
                changed2 = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj2 = colors;
            }
            $dirty |= changed2;
        } else {
            obj2 = colors;
        }
        if (i37 & 3072 == 0) {
            if (i9 & 8 == 0) {
                changed3 = restartGroup.changed(elevation) ? 2048 : 1024;
            } else {
                iNSTANCE = elevation;
            }
            $dirty |= changed3;
        } else {
            iNSTANCE = elevation;
        }
        i12 = i9 & 16;
        if (i12 != 0) {
            $dirty |= 24576;
            obj3 = border;
        } else {
            if (i37 & 24576 == 0) {
                i = restartGroup.changed(border) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj3 = border;
            }
        }
        int i43 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i43;
        } else {
            if (i37 & i43 == 0) {
                i7 = restartGroup.changedInstance(obj9) ? 131072 : 65536;
                $dirty |= i7;
            }
        }
        if (i42 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = shape2;
                        }
                        defaultsInvalid = 6;
                        if (i9 & 2 != 0) {
                            shape2 = CardDefaults.INSTANCE.getShape(restartGroup, defaultsInvalid);
                            $dirty &= -113;
                        } else {
                            shape2 = obj6;
                        }
                        if (i9 & 4 != 0) {
                            colors2 = CardDefaults.INSTANCE.cardColors(restartGroup, defaultsInvalid);
                            $dirty &= -897;
                        } else {
                            colors2 = obj2;
                        }
                        if (i9 & 8 != 0) {
                            elevation2 = CardDefaults.INSTANCE.cardElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, restartGroup, 1572864, 63);
                            $dirty &= -7169;
                        } else {
                            elevation2 = elevation;
                        }
                        if (i12 != 0) {
                            obj5 = shape2;
                            i4 = i40;
                            iNSTANCE = modifier2;
                        } else {
                            i4 = border;
                            iNSTANCE = modifier2;
                            obj5 = shape2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (i9 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i9 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i4 = obj3;
                        obj5 = obj6;
                        colors2 = obj2;
                        elevation2 = iNSTANCE;
                        iNSTANCE = shape2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.Card (Card.kt:87)");
                }
                int i13 = 1;
                int i29 = 54;
                CardKt.Card.1 anon = new CardKt.Card.1(obj9);
                obj21 = $dirty;
                i12 = restartGroup;
                SurfaceKt.Surface-T9BRK9s(iNSTANCE, obj5, colors2.containerColor-vNxB06k$material3_release(i13), i8, colors2.contentColor-vNxB06k$material3_release(i13), i3, 0, (Dp)elevation2.shadowElevation$material3_release(i13, 0, restartGroup, i25 |= i29).getValue().unbox-impl(), i4, (Function2)ComposableLambdaKt.rememberComposableLambda(664103990, i13, anon, restartGroup, i29), i12);
                restartGroup = i12;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = colors2;
                colors3 = elevation2;
                $dirty2 = iNSTANCE;
                obj = obj5;
                elevation3 = i4;
                shape3 = obj21;
            } else {
                restartGroup.skipToGroupEnd();
                shape3 = $dirty;
                $dirty2 = shape2;
                obj4 = obj2;
                elevation3 = obj8;
                obj = obj6;
                colors3 = iNSTANCE;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CardKt.Card.2($dirty2, obj, obj4, colors3, elevation3, obj9, i37, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Card(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        Object obj5;
        int i18;
        int colors2;
        int defaultsInvalid;
        int shape2;
        Object $composer3;
        int $dirty;
        Object $dirty2;
        Object obj3;
        int border2;
        boolean traceInProgress;
        Object $i$a$CacheCardKt$Card$interactionSource$1;
        boolean z;
        int i7;
        int i6;
        int interactionSource3;
        Object interactionSource2;
        Object str;
        Object obj4;
        int i14;
        Composer $composer2;
        Object cardElevation;
        boolean z2;
        int i8;
        int i4;
        Object rememberedValue;
        int i16;
        int changed3;
        Object iNSTANCE;
        int i9;
        boolean changed2;
        Object obj2;
        int changed;
        Object obj;
        int i;
        int i5;
        int i10;
        int companion;
        long containerColor-vNxB06k$material3_release;
        int i2;
        int contentColor-vNxB06k$material3_release;
        Composer composer;
        int i11;
        int unbox-impl;
        int i13;
        int i3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer2;
        int i19;
        int i15;
        int i17;
        int obj30;
        final Object obj8 = content;
        final int i60 = $changed;
        final int i61 = i12;
        $composer3 = $composer.startRestartGroup(-2024281376);
        ComposerKt.sourceInformation($composer3, "C(Card)P(7,6,4,8,1,3!1,5)141@6394L5,142@6439L12,143@6497L15,157@7034L43,160@7163L41,150@6782L422:Card.kt#uh7d8r");
        $dirty = $changed;
        if (i61 & 1 != 0) {
            $dirty |= 6;
            obj3 = onClick;
        } else {
            if (i60 & 6 == 0) {
                i7 = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj3 = onClick;
            }
        }
        int i38 = i61 & 2;
        if (i38 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i60 & 48 == 0) {
                i14 = $composer3.changed(modifier) ? 32 : 16;
                $dirty |= i14;
            } else {
                str = modifier;
            }
        }
        int i51 = i61 & 4;
        if (i51 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i60 & 384 == 0) {
                i4 = $composer3.changed(enabled) ? 256 : 128;
                $dirty |= i4;
            } else {
                z2 = enabled;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed3 = $composer3.changed(shape) ? 2048 : 1024;
            } else {
                rememberedValue = shape;
            }
            $dirty |= changed3;
        } else {
            rememberedValue = shape;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed2 = $composer3.changed(colors) ? 16384 : 8192;
            } else {
                iNSTANCE = colors;
            }
            $dirty |= changed2;
        } else {
            iNSTANCE = colors;
        }
        if (i64 &= i60 == 0) {
            if (i61 & 32 == 0) {
                changed = $composer3.changed(elevation) ? 131072 : 65536;
            } else {
                obj2 = elevation;
            }
            $dirty |= changed;
        } else {
            obj2 = elevation;
        }
        i13 = i61 & 64;
        int i67 = 1572864;
        if (i13 != 0) {
            $dirty |= i67;
            obj = border;
        } else {
            if (i67 &= i60 == 0) {
                i = $composer3.changed(border) ? 1048576 : 524288;
                $dirty |= i;
            } else {
                obj = border;
            }
        }
        i5 = i61 & 128;
        i10 = 12582912;
        if (i5 != 0) {
            $dirty |= i10;
            obj5 = interactionSource;
        } else {
            if (i60 & i10 == 0) {
                i10 = $composer3.changed(interactionSource) ? 8388608 : 4194304;
                $dirty |= i10;
            } else {
                obj5 = interactionSource;
            }
        }
        containerColor-vNxB06k$material3_release = 100663296;
        if (i61 & 256 != 0) {
            $dirty |= containerColor-vNxB06k$material3_release;
        } else {
            if (i60 & containerColor-vNxB06k$material3_release == 0) {
                i18 = $composer3.changedInstance(obj8) ? 67108864 : 33554432;
                $dirty |= i18;
            }
        }
        if (i21 &= $dirty == 38347922) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                border2 = -458753;
                companion = -57345;
                if (i60 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i51 != 0) {
                            z2 = defaultsInvalid;
                        }
                        int i39 = 6;
                        if (i61 & 8 != 0) {
                            $dirty &= -7169;
                            rememberedValue = shape2;
                        }
                        if (i61 & 16 != 0) {
                            colors2 = CardDefaults.INSTANCE.cardColors($composer3, i39);
                            $dirty &= companion;
                        } else {
                            colors2 = iNSTANCE;
                        }
                        if (i61 & 32 != 0) {
                            i6 = i5;
                            composer = $composer3;
                            $composer3 = CardDefaults.INSTANCE.cardElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, composer, 1572864, 63);
                            $composer2 = composer;
                            $dirty &= border2;
                        } else {
                            $composer2 = $composer3;
                            i6 = i5;
                            $composer3 = elevation;
                        }
                        border2 = i13 != 0 ? 0 : border;
                        if (i6 != 0) {
                            interactionSource3 = 0;
                            i13 = border2;
                            obj2 = str;
                            obj = z2;
                            i5 = rememberedValue;
                        } else {
                            interactionSource3 = interactionSource;
                            i13 = border2;
                            obj2 = str;
                            obj = z2;
                            i5 = rememberedValue;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty &= companion;
                        }
                        if (i61 & 32 != 0) {
                            interactionSource3 = interactionSource;
                            $dirty = i25;
                            $composer2 = $composer3;
                            i5 = rememberedValue;
                            colors2 = iNSTANCE;
                            $composer3 = obj2;
                            i13 = obj;
                            obj2 = str;
                            obj = z2;
                        } else {
                            interactionSource3 = interactionSource;
                            $composer2 = $composer3;
                            i5 = rememberedValue;
                            colors2 = iNSTANCE;
                            $composer3 = obj2;
                            i13 = obj;
                            obj2 = str;
                            obj = z2;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2024281376, $dirty, -1, "androidx.compose.material3.Card (Card.kt:147)");
                }
                $composer2.startReplaceGroup(1976524431);
                ComposerKt.sourceInformation($composer2, "149@6738L39");
                if (interactionSource3 == 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 1976525082, "CC(remember):Card.kt#9igjgp");
                    str = $composer2;
                    z2 = 0;
                    rememberedValue = str.rememberedValue();
                    iNSTANCE = 0;
                    obj30 = i35;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i36 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheCardKt$Card$interactionSource$1 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    i3 = $i$a$CacheCardKt$Card$interactionSource$1;
                } else {
                    i3 = interactionSource3;
                }
                $composer2.endReplaceGroup();
                CardKt.Card.3 anon = new CardKt.Card.3(obj8);
                SurfaceKt.Surface-o_FOJdg(onClick, obj2, obj, i5, colors2.containerColor-vNxB06k$material3_release(obj), i2, colors2.contentColor-vNxB06k$material3_release(obj), composer, 0, (Dp)$composer3.shadowElevation$material3_release(obj, (InteractionSource)i3, $composer2, i43 |= i53).getValue().unbox-impl(), i13, i3, (Function2)ComposableLambdaKt.rememberComposableLambda(776921067, true, anon, $composer2, 54), $composer2, i33 | i50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = colors2;
                cardElevation = $composer3;
                i9 = $dirty;
                i16 = interactionSource3;
                $dirty2 = obj2;
                z = obj;
                interactionSource2 = i5;
                i8 = i13;
            } else {
                $composer3.skipToGroupEnd();
                i9 = $dirty;
                $dirty2 = str;
                obj4 = obj7;
                composer2 = $composer3;
                z = z2;
                interactionSource2 = rememberedValue;
                cardElevation = obj2;
                i8 = obj;
                i16 = interactionSource;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            colors2 = new CardKt.Card.4(onClick, $dirty2, z, interactionSource2, obj4, cardElevation, i8, i16, obj8, i60, i61);
            endRestartGroup.updateScope((Function2)colors2);
        }
    }

    public static final void ElevatedCard(Modifier modifier, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        boolean traceInProgress;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        boolean traceInProgress2;
        Object obj3;
        Object shape2;
        Object obj;
        int i;
        Object colors2;
        Object cardElevation;
        int changed;
        Object elevatedCardElevation-aqJV_2Y;
        int changed3;
        Object obj4;
        int changed2;
        Object obj2;
        Object obj5;
        int shape3;
        int i4;
        int skipping;
        int defaultsInvalid;
        Object i7;
        int i5;
        int i2;
        Composer $composer2;
        Composer $composer3;
        Composer composer;
        int i6;
        int i3;
        final int i31 = $changed;
        traceInProgress = 895940201;
        $composer2 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($composer2, "C(ElevatedCard)P(3,4!1,2)195@8668L13,196@8721L20,197@8787L23,200@8868L168:Card.kt#uh7d8r");
        $dirty = $changed;
        int i15 = i8 & 1;
        if (i15 != 0) {
            $dirty |= 6;
            shape2 = modifier;
        } else {
            if (i31 & 6 == 0) {
                i = $composer2.changed(modifier) ? 4 : 2;
                $dirty |= i;
            } else {
                shape2 = modifier;
            }
        }
        if (i31 & 48 == 0) {
            if (i8 & 2 == 0) {
                changed = $composer2.changed(shape) ? 32 : 16;
            } else {
                colors2 = shape;
            }
            $dirty |= changed;
        } else {
            colors2 = shape;
        }
        if (i31 & 384 == 0) {
            if (i8 & 4 == 0) {
                changed3 = $composer2.changed(colors) ? 256 : 128;
            } else {
                elevatedCardElevation-aqJV_2Y = colors;
            }
            $dirty |= changed3;
        } else {
            elevatedCardElevation-aqJV_2Y = colors;
        }
        if (i31 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changed2 = $composer2.changed(elevation) ? 2048 : 1024;
            } else {
                obj4 = elevation;
            }
            $dirty |= changed2;
        } else {
            obj4 = elevation;
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
            obj2 = content;
        } else {
            if (i31 & 24576 == 0) {
                i4 = $composer2.changedInstance(content) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                obj2 = content;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (i31 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = shape2;
                        }
                        int i37 = 6;
                        if (i8 & 2 != 0) {
                            shape2 = CardDefaults.INSTANCE.getElevatedShape($composer2, i37);
                            $dirty &= -113;
                        } else {
                            shape2 = colors2;
                        }
                        if (i8 & 4 != 0) {
                            colors2 = CardDefaults.INSTANCE.elevatedCardColors($composer2, i37);
                            $dirty &= -897;
                        } else {
                            colors2 = elevatedCardElevation-aqJV_2Y;
                        }
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                            obj4 = modifier2;
                            obj5 = shape2;
                            skipping = colors2;
                            i7 = elevatedCardElevation-aqJV_2Y;
                        } else {
                            $composer3 = $composer2;
                            i7 = elevation;
                            obj4 = modifier2;
                            obj5 = shape2;
                            skipping = colors2;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i8 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (i8 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        obj5 = colors2;
                        skipping = elevatedCardElevation-aqJV_2Y;
                        i7 = obj4;
                        $composer3 = $composer2;
                        obj4 = shape2;
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ElevatedCard (Card.kt:200)");
                }
                $composer2 = $composer3;
                CardKt.Card(obj4, obj5, skipping, i7, 0, content, $composer2, i13 |= i20, 0);
                composer = $composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                obj = skipping;
                cardElevation = i7;
                shape3 = $dirty;
                $dirty2 = obj4;
            } else {
                $composer2.skipToGroupEnd();
                shape3 = $dirty;
                $dirty2 = shape2;
                obj3 = colors2;
                obj = elevatedCardElevation-aqJV_2Y;
                cardElevation = obj4;
                composer = $composer2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CardKt.ElevatedCard.1($dirty2, obj3, obj, cardElevation, content, i31, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ElevatedCard(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int traceInProgress2;
        int colors2;
        boolean traceInProgress;
        int defaultsInvalid;
        int elevatedShape;
        Object $composer3;
        int $dirty2;
        Object $dirty;
        Object obj;
        boolean z;
        int i;
        int i9;
        Object interactionSource2;
        Object obj7;
        Object obj10;
        int i5;
        Object obj8;
        boolean z2;
        Object obj4;
        int i10;
        Object obj2;
        int changed3;
        Object iNSTANCE;
        int i4;
        int changed;
        Object obj5;
        int changed2;
        Object obj6;
        int i6;
        Object obj9;
        int i2;
        Object i8;
        int i12;
        Object obj3;
        int i14;
        Object $composer4;
        Composer $composer2;
        Composer interactionSource3;
        int i15;
        Composer composer;
        int i7;
        int i3;
        int i13;
        final int i47 = $changed;
        final int i48 = i11;
        $composer3 = $composer.startRestartGroup(-1850977784);
        ComposerKt.sourceInformation($composer3, "C(ElevatedCard)P(6,5,3,7!1,2,4)248@11071L13,249@11124L20,250@11190L23,254@11328L269:Card.kt#uh7d8r");
        $dirty2 = $changed;
        if (i48 & 1 != 0) {
            $dirty2 |= 6;
            obj = onClick;
        } else {
            if (i47 & 6 == 0) {
                i = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj = onClick;
            }
        }
        i9 = i48 & 2;
        if (i9 != 0) {
            $dirty2 |= 48;
            obj7 = modifier;
        } else {
            if (i47 & 48 == 0) {
                i5 = $composer3.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj7 = modifier;
            }
        }
        int i43 = i48 & 4;
        if (i43 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i47 & 384 == 0) {
                i10 = $composer3.changed(enabled) ? 256 : 128;
                $dirty2 |= i10;
            } else {
                z2 = enabled;
            }
        }
        if (i47 & 3072 == 0) {
            if (i48 & 8 == 0) {
                changed3 = $composer3.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty2 |= changed3;
        } else {
            obj2 = shape;
        }
        if (i47 & 24576 == 0) {
            if (i48 & 16 == 0) {
                changed = $composer3.changed(colors) ? 16384 : 8192;
            } else {
                iNSTANCE = colors;
            }
            $dirty2 |= changed;
        } else {
            iNSTANCE = colors;
        }
        if (i51 &= i47 == 0) {
            if (i48 & 32 == 0) {
                changed2 = $composer3.changed(elevation) ? 131072 : 65536;
            } else {
                obj5 = elevation;
            }
            $dirty2 |= changed2;
        } else {
            obj5 = elevation;
        }
        i7 = i48 & 64;
        i3 = 1572864;
        if (i7 != 0) {
            $dirty2 |= i3;
            obj6 = interactionSource;
        } else {
            if (i47 & i3 == 0) {
                i6 = $composer3.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i6;
            } else {
                obj6 = interactionSource;
            }
        }
        i2 = 12582912;
        if (i48 & 128 != 0) {
            $dirty2 |= i2;
            obj9 = content;
        } else {
            if (i47 & i2 == 0) {
                i2 = $composer3.changedInstance(content) ? 8388608 : 4194304;
                $dirty2 |= i2;
            } else {
                obj9 = content;
            }
        }
        if (i57 &= $dirty2 == 4793490) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                i13 = -458753;
                i12 = -57345;
                if (i47 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (i43 != 0) {
                            z2 = defaultsInvalid;
                        }
                        int i41 = 6;
                        if (i48 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj2 = elevatedShape;
                        }
                        if (i48 & 16 != 0) {
                            colors2 = CardDefaults.INSTANCE.elevatedCardColors($composer3, i41);
                            $dirty2 &= i12;
                        } else {
                            colors2 = iNSTANCE;
                        }
                        if (i48 & 32 != 0) {
                            $composer3 = CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, $composer3, 1572864, 63);
                            $dirty2 &= i13;
                        } else {
                            $composer2 = $composer3;
                            $composer3 = elevation;
                        }
                        if (i7 != 0) {
                            i8 = colors2;
                            obj3 = $composer3;
                            obj5 = obj7;
                            obj6 = z2;
                            obj9 = obj2;
                            composer = $composer2;
                            $composer4 = i9;
                        } else {
                            i8 = colors2;
                            obj3 = $composer3;
                            obj5 = obj7;
                            obj6 = z2;
                            obj9 = obj2;
                            composer = $composer2;
                            $composer4 = interactionSource;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i48 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i48 & 16 != 0) {
                            $dirty2 &= i12;
                        }
                        if (i48 & 32 != 0) {
                            $dirty2 = colors2;
                            composer = $composer3;
                            obj9 = obj2;
                            i8 = iNSTANCE;
                            obj3 = obj5;
                            $composer4 = obj6;
                            obj5 = obj7;
                            obj6 = z2;
                        } else {
                            composer = $composer3;
                            obj9 = obj2;
                            i8 = iNSTANCE;
                            obj3 = obj5;
                            $composer4 = obj6;
                            obj5 = obj7;
                            obj6 = z2;
                        }
                    }
                } else {
                }
                composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1850977784, $dirty2, -1, "androidx.compose.material3.ElevatedCard (Card.kt:254)");
                }
                CardKt.Card(obj, obj5, obj6, obj9, i8, obj3, 0, $composer4, content, composer, i26 | $composer3, 0);
                interactionSource3 = composer;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty2;
                obj4 = obj13;
                $dirty = obj5;
                z = obj6;
                interactionSource2 = obj9;
                obj10 = i8;
                obj8 = obj3;
            } else {
                $composer3.skipToGroupEnd();
                i4 = $dirty2;
                $dirty = obj7;
                obj10 = obj12;
                interactionSource3 = $composer3;
                z = z2;
                interactionSource2 = obj2;
                obj8 = obj5;
                obj4 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = interactionSource3.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new CardKt.ElevatedCard.2(onClick, $dirty, z, interactionSource2, obj10, obj8, obj4, content, i47, i48);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedCard(Modifier modifier, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object obj5;
        int modifier2;
        boolean traceInProgress;
        Object shape3;
        Object obj7;
        int i4;
        Object colors2;
        Object obj;
        int changed4;
        Object outlinedCardElevation-aqJV_2Y;
        Object obj3;
        int changed;
        Object outlinedCardBorder;
        int changed3;
        Object iNSTANCE;
        int changed2;
        Object obj6;
        int shape2;
        Object obj4;
        int i5;
        boolean skipping;
        int defaultsInvalid;
        int i3;
        int i6;
        Object obj2;
        Function3 function3;
        Composer $composer2;
        Composer composer;
        Composer $composer3;
        int i7;
        int i;
        int i2;
        final int i36 = $changed;
        traceInProgress2 = 740336179;
        $composer2 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation($composer2, "C(OutlinedCard)P(4,5,1,3)297@13151L13,298@13204L20,299@13270L23,300@13335L20,303@13413L170:Card.kt#uh7d8r");
        $dirty = $changed;
        int i15 = i9 & 1;
        if (i15 != 0) {
            $dirty |= 6;
            shape3 = modifier;
        } else {
            if (i36 & 6 == 0) {
                i4 = $composer2.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                shape3 = modifier;
            }
        }
        if (i36 & 48 == 0) {
            if (i9 & 2 == 0) {
                changed4 = $composer2.changed(shape) ? 32 : 16;
            } else {
                colors2 = shape;
            }
            $dirty |= changed4;
        } else {
            colors2 = shape;
        }
        if (i36 & 384 == 0) {
            if (i9 & 4 == 0) {
                changed = $composer2.changed(colors) ? 256 : 128;
            } else {
                outlinedCardElevation-aqJV_2Y = colors;
            }
            $dirty |= changed;
        } else {
            outlinedCardElevation-aqJV_2Y = colors;
        }
        if (i36 & 3072 == 0) {
            if (i9 & 8 == 0) {
                changed3 = $composer2.changed(elevation) ? 2048 : 1024;
            } else {
                outlinedCardBorder = elevation;
            }
            $dirty |= changed3;
        } else {
            outlinedCardBorder = elevation;
        }
        if (i36 & 24576 == 0) {
            if (i9 & 16 == 0) {
                changed2 = $composer2.changed(border) ? 16384 : 8192;
            } else {
                iNSTANCE = border;
            }
            $dirty |= changed2;
        } else {
            iNSTANCE = border;
        }
        i5 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i5;
            obj6 = content;
        } else {
            if (i36 & i5 == 0) {
                i5 = $composer2.changedInstance(content) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                obj6 = content;
            }
        }
        if (i43 &= $dirty == 74898) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                i2 = -57345;
                if (i36 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = shape3;
                        }
                        i3 = 6;
                        if (i9 & 2 != 0) {
                            shape3 = CardDefaults.INSTANCE.getOutlinedShape($composer2, i3);
                            $dirty &= -113;
                        } else {
                            shape3 = colors2;
                        }
                        if (i9 & 4 != 0) {
                            colors2 = CardDefaults.INSTANCE.outlinedCardColors($composer2, i3);
                            $dirty &= -897;
                        } else {
                            colors2 = outlinedCardElevation-aqJV_2Y;
                        }
                        if (i9 & 8 != 0) {
                            outlinedCardElevation-aqJV_2Y = CardDefaults.INSTANCE.outlinedCardElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, $composer2, 1572864, 63);
                            $dirty &= -7169;
                        } else {
                            $composer3 = $composer2;
                            outlinedCardElevation-aqJV_2Y = outlinedCardBorder;
                        }
                        if (i9 & 16 != 0) {
                            $dirty &= i2;
                            iNSTANCE = modifier2;
                            obj4 = shape3;
                            skipping = colors2;
                            i6 = outlinedCardElevation-aqJV_2Y;
                            obj2 = outlinedCardBorder;
                        } else {
                            obj2 = border;
                            iNSTANCE = modifier2;
                            obj4 = shape3;
                            skipping = colors2;
                            i6 = outlinedCardElevation-aqJV_2Y;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i9 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (i9 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i9 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i9 & 16 != 0) {
                            $dirty &= i2;
                        }
                        obj4 = colors2;
                        skipping = outlinedCardElevation-aqJV_2Y;
                        i6 = outlinedCardBorder;
                        obj2 = iNSTANCE;
                        $composer3 = $composer2;
                        iNSTANCE = shape3;
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.OutlinedCard (Card.kt:303)");
                }
                $composer2 = $composer3;
                CardKt.Card(iNSTANCE, obj4, skipping, i6, obj2, content, $composer2, i13 |= i22, 0);
                composer = $composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                obj7 = skipping;
                obj = i6;
                obj3 = obj2;
                shape2 = $dirty;
                $dirty2 = iNSTANCE;
            } else {
                $composer2.skipToGroupEnd();
                shape2 = $dirty;
                $dirty2 = shape3;
                obj5 = colors2;
                obj7 = outlinedCardElevation-aqJV_2Y;
                obj = outlinedCardBorder;
                obj3 = iNSTANCE;
                composer = $composer2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new CardKt.OutlinedCard.1($dirty2, obj5, obj7, obj, obj3, content, i36, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedCard(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.CardColors colors, androidx.compose.material3.CardElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        Object obj8;
        boolean traceInProgress;
        int defaultsInvalid;
        int outlinedShape;
        int shape2;
        int i4;
        boolean traceInProgress2;
        Composer $composer3;
        int $dirty2;
        Object $dirty;
        Object obj5;
        boolean z;
        int i14;
        int i9;
        Object obj;
        Composer $composer2;
        Object obj7;
        Object obj3;
        int i5;
        Object obj10;
        BorderStroke border2;
        boolean z2;
        Object obj9;
        int i3;
        Object obj2;
        Object obj12;
        int changed3;
        Object obj6;
        boolean changed4;
        Object iNSTANCE;
        int i6;
        int changed;
        Object obj11;
        int changed2;
        int i10;
        Object obj4;
        int i15;
        int i13;
        int i16;
        int i7;
        androidx.compose.material3.CardElevation cardElevation;
        BorderStroke borderStroke;
        int i11;
        int i2;
        Composer composer;
        int i;
        int i8;
        int i17;
        final int i56 = $changed;
        final int i57 = i12;
        $composer3 = $composer.startRestartGroup(-727137250);
        ComposerKt.sourceInformation($composer3, "C(OutlinedCard)P(7,6,4,8,1,3!1,5)352@15710L13,353@15763L20,354@15829L23,355@15894L27,359@16036L271:Card.kt#uh7d8r");
        $dirty2 = $changed;
        if (i57 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = onClick;
        } else {
            if (i56 & 6 == 0) {
                i9 = $composer3.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i9;
            } else {
                obj5 = onClick;
            }
        }
        int i47 = i57 & 2;
        if (i47 != 0) {
            $dirty2 |= 48;
            obj7 = modifier;
        } else {
            if (i56 & 48 == 0) {
                i5 = $composer3.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj7 = modifier;
            }
        }
        border2 = i57 & 4;
        if (border2 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i56 & 384 == 0) {
                i3 = $composer3.changed(enabled) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                z2 = enabled;
            }
        }
        if (i56 & 3072 == 0) {
            if (i57 & 8 == 0) {
                changed3 = $composer3.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty2 |= changed3;
        } else {
            obj2 = shape;
        }
        if (i56 & 24576 == 0) {
            if (i57 & 16 == 0) {
                changed4 = $composer3.changed(colors) ? 16384 : 8192;
            } else {
                obj6 = colors;
            }
            $dirty2 |= changed4;
        } else {
            obj6 = colors;
        }
        if (i58 &= i56 == 0) {
            if (i57 & 32 == 0) {
                changed = $composer3.changed(elevation) ? 131072 : 65536;
            } else {
                iNSTANCE = elevation;
            }
            $dirty2 |= changed;
        } else {
            iNSTANCE = elevation;
        }
        if (i63 &= i56 == 0) {
            if (i57 & 64 == 0) {
                changed2 = $composer3.changed(border) ? 1048576 : 524288;
            } else {
                obj11 = border;
            }
            $dirty2 |= changed2;
        } else {
            obj11 = border;
        }
        i10 = i57 & 128;
        int i66 = 12582912;
        if (i10 != 0) {
            $dirty2 |= i66;
            obj4 = interactionSource;
        } else {
            if (i66 &= i56 == 0) {
                i15 = $composer3.changed(interactionSource) ? 8388608 : 4194304;
                $dirty2 |= i15;
            } else {
                obj4 = interactionSource;
            }
        }
        i13 = 100663296;
        if (i57 & 256 != 0) {
            $dirty2 |= i13;
            obj8 = content;
        } else {
            if (i56 & i13 == 0) {
                i13 = $composer3.changedInstance(content) ? 67108864 : 33554432;
                $dirty2 |= i13;
            } else {
                obj8 = content;
            }
        }
        if ($dirty2 & i16 == 38347922) {
            if (!$composer3.getSkipping()) {
                $composer3.startDefaults();
                i14 = -3670017;
                int i68 = -458753;
                i7 = -57345;
                if (i56 & 1 != 0) {
                    if ($composer3.getDefaultsInvalid()) {
                        if (i47 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (border2 != 0) {
                            z2 = defaultsInvalid;
                        }
                        int i48 = 6;
                        if (i57 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj2 = outlinedShape;
                        }
                        if (i57 & 16 != 0) {
                            $dirty2 &= i7;
                            obj6 = shape2;
                        }
                        if (i57 & 32 != 0) {
                            i4 = i10;
                            i11 = $composer3;
                            $composer3 = CardDefaults.INSTANCE.outlinedCardElevation-aqJV_2Y(0, 0, 0, 0, 0, 0, i11, 1572864, 63);
                            $composer2 = i11;
                            $dirty2 &= i68;
                        } else {
                            $composer2 = $composer3;
                            i4 = i10;
                            $composer3 = elevation;
                        }
                        if (i57 & 64 != 0) {
                            border2 = CardDefaults.INSTANCE.outlinedCardBorder(z2, $composer2, i61 |= 48, 0);
                            $dirty2 &= i14;
                        } else {
                            border2 = border;
                        }
                        if (i4 != 0) {
                            i11 = i4;
                            cardElevation = $composer3;
                            obj11 = obj7;
                            borderStroke = border2;
                            i10 = z2;
                            obj4 = obj2;
                            i16 = obj6;
                        } else {
                            i11 = interactionSource;
                            cardElevation = $composer3;
                            obj11 = obj7;
                            borderStroke = border2;
                            i10 = z2;
                            obj4 = obj2;
                            i16 = obj6;
                        }
                    } else {
                        $composer3.skipToGroupEnd();
                        if (i57 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i57 & 16 != 0) {
                            $dirty2 &= i7;
                        }
                        if (i57 & 32 != 0) {
                            $dirty2 &= i68;
                        }
                        if (i57 & 64 != 0) {
                            $dirty2 = i4;
                            $composer2 = $composer3;
                            i10 = z2;
                            i16 = obj6;
                            cardElevation = iNSTANCE;
                            borderStroke = obj11;
                            i11 = obj4;
                            obj11 = obj7;
                            obj4 = obj2;
                        } else {
                            $composer2 = $composer3;
                            i10 = z2;
                            i16 = obj6;
                            cardElevation = iNSTANCE;
                            borderStroke = obj11;
                            i11 = obj4;
                            obj11 = obj7;
                            obj4 = obj2;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-727137250, $dirty2, -1, "androidx.compose.material3.OutlinedCard (Card.kt:359)");
                }
                CardKt.Card(onClick, obj11, i10, obj4, i16, cardElevation, borderStroke, i11, content, $composer2, i27 | $composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i6 = $dirty2;
                $dirty = obj11;
                z = i10;
                obj = obj4;
                obj3 = i16;
                obj10 = cardElevation;
                obj9 = borderStroke;
                obj12 = i11;
            } else {
                $composer3.skipToGroupEnd();
                composer = $composer3;
                z = z2;
                obj = obj2;
                obj10 = iNSTANCE;
                obj9 = obj11;
                obj12 = obj4;
                i6 = $dirty2;
                $dirty = obj7;
                obj3 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CardKt.OutlinedCard.2(onClick, $dirty, z, obj, obj3, obj10, obj9, obj12, content, i56, i57);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
