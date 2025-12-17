package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00062\u0014\u0008\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00062\u0014\u0008\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u000c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClickableTextKt {
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    public static final void ClickableText-03UYbkw(AnnotatedString text, Function1<? super Integer, Unit> onHover, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super Integer, Unit> onClick, Composer $composer, int $changed, int i12) {
        Object i;
        int i20;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object $i$a$CacheClickableTextKt$ClickableText$5;
        Object pointerInput;
        boolean traceInProgress2;
        Object restartGroup;
        int onTextLayout2;
        int $dirty;
        boolean traceInProgress;
        int invalid$iv;
        Object composer$iv;
        Object $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1;
        Object coroutineScope2;
        Object modifier2;
        int i11;
        int i22;
        int str;
        Object obj3;
        int i2;
        Object empty;
        Object invalid$iv2;
        boolean z;
        int i24;
        int i26;
        int i8;
        Object obj2;
        int modifier3;
        int i16;
        Object it$iv;
        androidx.compose.foundation.text.ClickableTextKt.ClickableText.4 anon;
        Function1 function1;
        Object obj;
        Object then;
        int i4;
        Object i15;
        boolean softWrap2;
        int i25;
        int i3;
        int i13;
        int i17;
        boolean i18;
        int i5;
        int i21;
        int i9;
        Object companion;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i6;
        int i7;
        int i14;
        Composer maxLines2;
        int i10;
        int i19;
        int i23;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int obj29;
        int obj30;
        Composer obj31;
        Object obj32;
        Object obj33;
        int obj34;
        Object obj7 = onClick;
        final int i64 = $changed;
        final int i65 = i12;
        restartGroup = $composer.startRestartGroup(1020774372);
        ComposerKt.sourceInformation(restartGroup, "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)163@7538L52,164@7616L24,171@7916L413,193@8556L76,186@8335L303:ClickableText.kt#423gt5");
        $dirty = $changed;
        if (i65 & 1 != 0) {
            $dirty |= 6;
            obj = text;
        } else {
            if (i64 & 6 == 0) {
                i11 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj = text;
            }
        }
        if (i65 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i64 & 48 == 0) {
                i22 = restartGroup.changedInstance(onHover) ? 32 : 16;
                $dirty |= i22;
            }
        }
        str = i65 & 4;
        if (str != null) {
            $dirty |= 384;
            obj2 = modifier;
        } else {
            if (i64 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i16;
            } else {
                obj2 = modifier;
            }
        }
        int i59 = i65 & 8;
        if (i59 != 0) {
            $dirty |= 3072;
            then = style;
        } else {
            if (i64 & 3072 == 0) {
                i4 = restartGroup.changed(style) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                then = style;
            }
        }
        i15 = i65 & 16;
        if (i15 != 0) {
            $dirty |= 24576;
            softWrap2 = softWrap;
        } else {
            if (i64 & 24576 == 0) {
                i25 = restartGroup.changed(softWrap) ? 16384 : 8192;
                $dirty |= i25;
            } else {
                softWrap2 = softWrap;
            }
        }
        i3 = i65 & 32;
        i13 = 196608;
        if (i3 != 0) {
            $dirty |= i13;
            i24 = overflow;
        } else {
            if (i64 & i13 == 0) {
                i13 = restartGroup.changed(overflow) ? 131072 : 65536;
                $dirty |= i13;
            } else {
                i24 = overflow;
            }
        }
        i18 = i65 & 64;
        i5 = 1572864;
        if (i18 != 0) {
            $dirty |= i5;
            i2 = maxLines;
        } else {
            if (i64 & i5 == 0) {
                i9 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                i2 = maxLines;
            }
        }
        i6 = i28;
        i7 = 12582912;
        if (i6 != 0) {
            $dirty |= i7;
            i = onTextLayout;
        } else {
            if (i64 & i7 == 0) {
                i14 = restartGroup.changedInstance(onTextLayout) ? 8388608 : 4194304;
                $dirty |= i14;
            } else {
                i = onTextLayout;
            }
        }
        int i78 = 100663296;
        if (i65 & 256 != 0) {
            $dirty |= i78;
        } else {
            if (i64 & i78 == 0) {
                i20 = restartGroup.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty |= i20;
            }
        }
        traceInProgress2 = $dirty;
        if ($dirty2 &= traceInProgress2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj2 = onTextLayout2;
                }
                if (i59 != 0) {
                    then = onTextLayout2;
                }
                if (i15 != 0) {
                    softWrap2 = onTextLayout2;
                }
                if (i3 != 0) {
                    i3 = onTextLayout2;
                } else {
                    i3 = i24;
                }
                if (i18 != 0) {
                    i2 = onTextLayout2;
                }
                if (i6 != 0) {
                    onTextLayout2 = ClickableTextKt.ClickableText.4.INSTANCE;
                } else {
                    onTextLayout2 = onTextLayout;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, traceInProgress2, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:162)");
                }
                String str4 = "CC(remember):ClickableText.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1498188796, str4);
                invalid$iv = 0;
                Composer composer3 = restartGroup;
                int i60 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i73 = 0;
                i23 = traceInProgress2;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    obj29 = i30;
                    int $i$a$CacheClickableTextKt$ClickableText$layoutResult$2 = 0;
                    obj30 = invalid$iv;
                    composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default($i$a$CacheClickableTextKt$ClickableText$layoutResult$2, $i$a$CacheClickableTextKt$ClickableText$layoutResult$2, 2, $i$a$CacheClickableTextKt$ClickableText$layoutResult$2));
                } else {
                    obj30 = invalid$iv;
                    mutableStateOf$default = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i43 = i33;
                int i61 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer = restartGroup;
                obj32 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                Composer composer5 = restartGroup;
                int i74 = 0;
                obj29 = i29;
                compositionCoroutineScope = composer5.rememberedValue();
                companion = 0;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i77 = 0;
                    obj30 = compositionCoroutineScope;
                    obj31 = composer;
                    composer$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer));
                    composer5.updateRememberedValue(composer$iv);
                } else {
                    obj31 = composer;
                    composer$iv = obj30;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)composer$iv.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1498201253, str4);
                i26 = i23 & 112 == 32 ? 1 : 0;
                i8 = i23 & i45 == 67108864 ? 1 : 0;
                i41 |= i8;
                Composer composer4 = restartGroup;
                int i71 = 0;
                it$iv = composer4.rememberedValue();
                int i75 = 0;
                if (i42 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj31 = onHover;
                        obj33 = obj7;
                        super(obj30, obj31, obj32, obj33, 0);
                        coroutineScope = obj30;
                        function1 = obj31;
                        obj29 = coroutineScope3;
                        obj30 = i42;
                        invalid$iv2 = obj32;
                        $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1 = obj33;
                        obj31 = it$iv;
                        composer4.updateRememberedValue((Function2)companion);
                    } else {
                        coroutineScope = obj30;
                        obj30 = i42;
                        obj31 = it$iv;
                        $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1 = obj7;
                        function1 = onHover;
                        invalid$iv2 = obj32;
                    }
                } else {
                    obj30 = coroutineScope2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1, function1, (Function2)it$iv);
                i15 = then;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1498221396, str4);
                i17 = i23 & i34 == 8388608 ? 1 : 0;
                Composer composer2 = restartGroup;
                int i49 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i76 = 0;
                if (i17 == 0) {
                    obj29 = pointerInput;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj30 = pointerInputModifier;
                        $i$a$CacheClickableTextKt$ClickableText$5 = new ClickableTextKt.ClickableText.5.1(invalid$iv2, onTextLayout2);
                        composer2.updateRememberedValue((Function1)$i$a$CacheClickableTextKt$ClickableText$5);
                    } else {
                        $i$a$CacheClickableTextKt$ClickableText$5 = rememberedValue;
                    }
                } else {
                    obj29 = pointerInput;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i18 = softWrap2;
                BasicTextKt.BasicText-RWo7tUw(obj, obj2.then(pointerInput), i15, (Function1)$i$a$CacheClickableTextKt$ClickableText$5, i3, i18, i2, 0, 0, 0, restartGroup, i39 | i57, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                anon = onTextLayout2;
                obj3 = i15;
                i24 = i3;
                z = i18;
            } else {
                restartGroup.skipToGroupEnd();
                anon = onTextLayout;
                i23 = traceInProgress2;
                maxLines2 = restartGroup;
                i21 = i2;
                $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1 = obj7;
                obj3 = then;
                z = softWrap2;
                function1 = onHover;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = maxLines2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ClickableTextKt.ClickableText.6(text, function1, obj2, obj3, z, i24, i21, anon, $i$a$CacheClickableTextKt$ClickableText$pointerInputModifier$1, i64, i65);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = obj2;
            modifier3 = i21;
        }
    }

    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    public static final void ClickableText-4YKlhWE(AnnotatedString text, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super Integer, Unit> onClick, Composer $composer, int $changed, int i11) {
        Object obj4;
        Object mutableStateOf$default;
        int maxLines2;
        boolean traceInProgress;
        Object $i$a$CacheClickableTextKt$ClickableText$2;
        int $dirty3;
        Object $dirty;
        int i3;
        Object onTextLayout3;
        Object onTextLayout2;
        int i;
        boolean z;
        boolean traceInProgress2;
        Object empty;
        Object obj3;
        int modifier2;
        int i9;
        int i5;
        int str;
        Object obj;
        androidx.compose.foundation.text.ClickableTextKt.ClickableText.1 anon;
        Object it$iv;
        int $i$a$CacheClickableTextKt$ClickableText$pressIndicator$1;
        Object obj2;
        int i13;
        Modifier then;
        int $dirty2;
        int i12;
        boolean softWrap2;
        int i15;
        Object invalid$iv;
        int i10;
        int i19;
        int i17;
        boolean i16;
        int i6;
        int i2;
        int i8;
        Composer.Companion companion2;
        int i21;
        int i7;
        int i20;
        int i4;
        Composer $composer2;
        int companion;
        int i18;
        int i14;
        int obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        int obj29;
        final Object obj6 = onClick;
        $i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 = $changed;
        final int i47 = i11;
        traceInProgress = $composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(traceInProgress, "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)84@3976L52,85@4085L184,100@4490L76,93@4275L297:ClickableText.kt#423gt5");
        $dirty3 = $changed;
        if (i47 & 1 != 0) {
            $dirty3 |= 6;
            obj2 = text;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & 6 == 0) {
                i3 = traceInProgress.changed(text) ? 4 : 2;
                $dirty3 |= i3;
            } else {
                obj2 = text;
            }
        }
        int i28 = i47 & 2;
        if (i28 != 0) {
            $dirty3 |= 48;
            obj3 = modifier;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & 48 == 0) {
                i9 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty3 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        str = i47 & 4;
        if (str != null) {
            $dirty3 |= 384;
            obj = style;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & 384 == 0) {
                i13 = traceInProgress.changed(style) ? 256 : 128;
                $dirty3 |= i13;
            } else {
                obj = style;
            }
        }
        then = i47 & 8;
        if (then != 0) {
            $dirty3 |= 3072;
            softWrap2 = softWrap;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & 3072 == 0) {
                i15 = traceInProgress.changed(softWrap) ? 2048 : 1024;
                $dirty3 |= i15;
            } else {
                softWrap2 = softWrap;
            }
        }
        invalid$iv = i47 & 16;
        if (invalid$iv != 0) {
            $dirty3 |= 24576;
            i19 = overflow;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & 24576 == 0) {
                i17 = traceInProgress.changed(overflow) ? 16384 : 8192;
                $dirty3 |= i17;
            } else {
                i19 = overflow;
            }
        }
        i16 = i47 & 32;
        i6 = 196608;
        if (i16 != 0) {
            $dirty3 |= i6;
            i = maxLines;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & i6 == 0) {
                i6 = traceInProgress.changed(maxLines) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                i = maxLines;
            }
        }
        i2 = i47 & 64;
        i21 = 1572864;
        if (i2 != 0) {
            $dirty3 |= i21;
            obj4 = onTextLayout;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & i21 == 0) {
                i7 = traceInProgress.changedInstance(onTextLayout) ? 1048576 : 524288;
                $dirty3 |= i7;
            } else {
                obj4 = onTextLayout;
            }
        }
        companion = 12582912;
        if (i47 & 128 != 0) {
            $dirty3 |= companion;
        } else {
            if ($i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 & companion == 0) {
                i20 = traceInProgress.changedInstance(obj6) ? 8388608 : 4194304;
                $dirty3 |= i20;
            }
        }
        if ($dirty3 & i58 == 4793490) {
            if (!traceInProgress.getSkipping()) {
                if (i28 != 0) {
                    obj3 = mutableStateOf$default;
                }
                if (str != null) {
                    obj = mutableStateOf$default;
                }
                if (then != 0) {
                    softWrap2 = mutableStateOf$default;
                }
                if (invalid$iv != 0) {
                    i19 = mutableStateOf$default;
                }
                maxLines2 = i16 != 0 ? 0x7fffffff /* Unknown resource */ : i;
                if (i2 != 0) {
                    onTextLayout2 = ClickableTextKt.ClickableText.1.INSTANCE;
                } else {
                    onTextLayout2 = onTextLayout;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, $dirty3, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:83)");
                }
                String str3 = "CC(remember):ClickableText.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(traceInProgress, 1498074812, str3);
                Composer composer2 = traceInProgress;
                int i52 = 0;
                i2 = maxLines2;
                mutableStateOf$default = composer2.rememberedValue();
                int i55 = 0;
                obj25 = i31;
                int style2 = 0;
                if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                    empty = 0;
                    obj27 = mutableStateOf$default;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(style2, style2, 2, style2));
                } else {
                    obj27 = mutableStateOf$default;
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                ComposerKt.sourceInformationMarkerStart(traceInProgress, 1498078432, str3);
                int i56 = 1;
                i12 = i49 &= $dirty3 == 8388608 ? i56 : 0;
                Composer composer3 = traceInProgress;
                companion2 = 0;
                it$iv = composer3.rememberedValue();
                int i59 = 0;
                if (i12 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj28 = it$iv;
                        obj29 = i46;
                        it$iv = new ClickableTextKt.ClickableText.pressIndicator.1.1((MutableState)mutableStateOf$default, obj6, 0);
                        composer3.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj28 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                ComposerKt.sourceInformationMarkerStart(traceInProgress, 1498091284, str3);
                int i33 = 3670016;
                i10 = $dirty3 & i33 == 1048576 ? i56 : 0;
                Composer composer = traceInProgress;
                $i$a$CacheClickableTextKt$ClickableText$pressIndicator$1 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i57 = 0;
                if (i10 == 0) {
                    $composer2 = traceInProgress;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj27 = $composer3;
                        $i$a$CacheClickableTextKt$ClickableText$2 = new ClickableTextKt.ClickableText.2.1(mutableStateOf$default, onTextLayout2);
                        composer.updateRememberedValue((Function1)$i$a$CacheClickableTextKt$ClickableText$2);
                    } else {
                        $i$a$CacheClickableTextKt$ClickableText$2 = rememberedValue;
                    }
                } else {
                    $composer2 = traceInProgress;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i16 = softWrap2;
                softWrap2 = obj26;
                BasicTextKt.BasicText-RWo7tUw(obj2, obj3.then(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj6, (Function2)it$iv)), softWrap2, (Function1)$i$a$CacheClickableTextKt$ClickableText$2, i19, i16, i2, 0, 0, 0, $composer2, i27 | i40, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                anon = onTextLayout2;
                onTextLayout3 = softWrap2;
                z = i16;
                i5 = i2;
            } else {
                traceInProgress.skipToGroupEnd();
                $composer2 = traceInProgress;
                i5 = i;
                onTextLayout3 = obj;
                z = softWrap2;
                anon = onTextLayout;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty3;
            mutableStateOf$default = new ClickableTextKt.ClickableText.3(text, obj3, onTextLayout3, z, i19, i5, anon, obj6, $changed, i47);
            endRestartGroup.updateScope((Function2)mutableStateOf$default);
        } else {
            $dirty2 = $dirty3;
            $dirty = obj3;
            modifier2 = i19;
        }
    }

    private static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> layoutResult, long positionOffset) {
        Object offsetForPosition-k-4lQ0M;
        int valueOf;
        boolean it;
        int i;
        offsetForPosition-k-4lQ0M = layoutResult.getValue();
        offsetForPosition-k-4lQ0M = (TextLayoutResult)offsetForPosition-k-4lQ0M.getMultiParagraph();
        if (offsetForPosition-k-4lQ0M != null && offsetForPosition-k-4lQ0M != null) {
            offsetForPosition-k-4lQ0M = offsetForPosition-k-4lQ0M.getMultiParagraph();
            if (offsetForPosition-k-4lQ0M != null) {
                i = 0;
                if (ClickableTextKt.containsWithinBounds-Uv8p0NA(offsetForPosition-k-4lQ0M, positionOffset)) {
                } else {
                    offsetForPosition-k-4lQ0M = valueOf;
                }
                if (offsetForPosition-k-4lQ0M != null) {
                    valueOf = Integer.valueOf(offsetForPosition-k-4lQ0M.getOffsetForPosition-k-4lQ0M(positionOffset));
                } else {
                }
            } else {
            }
        } else {
        }
        return valueOf;
    }

    public static final Integer access$ClickableText_03UYbkw$getOffset(MutableState layoutResult, long positionOffset) {
        return ClickableTextKt.ClickableText_03UYbkw$getOffset(layoutResult, positionOffset);
    }

    private static final boolean containsWithinBounds-Uv8p0NA(MultiParagraph $this$containsWithinBounds_u2dUv8p0NA, long positionOffset) {
        int cmp;
        int i;
        final int i2 = 0;
        int i3 = 0;
        float $i$f$component1Impl = Offset.getX-impl(positionOffset);
        int i4 = 0;
        float $i$f$component2Impl = Offset.getY-impl(positionOffset);
        cmp = 0;
        if (Float.compare($i$f$component1Impl, cmp) > 0 && Float.compare($i$f$component2Impl, cmp) >= 0 && Float.compare($i$f$component1Impl, width) <= 0 && Float.compare($i$f$component2Impl, height) <= 0) {
            if (Float.compare($i$f$component2Impl, cmp) >= 0) {
                if (Float.compare($i$f$component1Impl, width) <= 0) {
                    i = Float.compare($i$f$component2Impl, height) <= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
