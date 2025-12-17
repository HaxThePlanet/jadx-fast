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
        Object i8;
        int i23;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object anon2;
        Object pointerInput;
        boolean traceInProgress;
        Object restartGroup;
        int onTextLayout2;
        int $dirty;
        boolean traceInProgress2;
        int invalid$iv;
        Object composer$iv;
        Object obj4;
        Object coroutineScope2;
        Object modifier3;
        int i20;
        int i17;
        int str;
        Object obj2;
        int i18;
        Object empty;
        Object invalid$iv2;
        boolean z;
        int i13;
        int i3;
        int i2;
        Object obj3;
        int modifier2;
        int i24;
        Object it$iv;
        androidx.compose.foundation.text.ClickableTextKt.ClickableText.4 anon;
        Function1 function1;
        Object obj;
        Object then;
        int i4;
        Object i25;
        boolean softWrap2;
        int i5;
        int i6;
        int i21;
        int i26;
        boolean i9;
        int i10;
        int i22;
        int i7;
        Object companion;
        Object iNSTANCE;
        int i11;
        int i14;
        int i15;
        Composer maxLines2;
        int i;
        int i16;
        int i19;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int obj29;
        int obj30;
        Composer obj31;
        Object obj32;
        Object obj33;
        int obj34;
        Object obj8 = onClick;
        final int i65 = $changed;
        final int i66 = i12;
        restartGroup = $composer.startRestartGroup(1020774372);
        ComposerKt.sourceInformation(restartGroup, "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)163@7538L52,164@7616L24,171@7916L413,193@8556L76,186@8335L303:ClickableText.kt#423gt5");
        $dirty = $changed;
        if (i66 & 1 != 0) {
            $dirty |= 6;
            obj = text;
        } else {
            if (i65 & 6 == 0) {
                i20 = restartGroup.changed(text) ? 4 : 2;
                $dirty |= i20;
            } else {
                obj = text;
            }
        }
        if (i66 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i65 & 48 == 0) {
                i17 = restartGroup.changedInstance(onHover) ? 32 : 16;
                $dirty |= i17;
            }
        }
        str = i66 & 4;
        if (str != null) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i65 & 384 == 0) {
                i24 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i24;
            } else {
                obj3 = modifier;
            }
        }
        int i60 = i66 & 8;
        if (i60 != 0) {
            $dirty |= 3072;
            then = style;
        } else {
            if (i65 & 3072 == 0) {
                i4 = restartGroup.changed(style) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                then = style;
            }
        }
        i25 = i66 & 16;
        if (i25 != 0) {
            $dirty |= 24576;
            softWrap2 = softWrap;
        } else {
            if (i65 & 24576 == 0) {
                i5 = restartGroup.changed(softWrap) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                softWrap2 = softWrap;
            }
        }
        i6 = i66 & 32;
        i21 = 196608;
        if (i6 != 0) {
            $dirty |= i21;
            i13 = overflow;
        } else {
            if (i65 & i21 == 0) {
                i21 = restartGroup.changed(overflow) ? 131072 : 65536;
                $dirty |= i21;
            } else {
                i13 = overflow;
            }
        }
        i9 = i66 & 64;
        i10 = 1572864;
        if (i9 != 0) {
            $dirty |= i10;
            i18 = maxLines;
        } else {
            if (i65 & i10 == 0) {
                i7 = restartGroup.changed(maxLines) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                i18 = maxLines;
            }
        }
        i11 = i28;
        i14 = 12582912;
        if (i11 != 0) {
            $dirty |= i14;
            i8 = onTextLayout;
        } else {
            if (i65 & i14 == 0) {
                i15 = restartGroup.changedInstance(onTextLayout) ? 8388608 : 4194304;
                $dirty |= i15;
            } else {
                i8 = onTextLayout;
            }
        }
        int i79 = 100663296;
        if (i66 & 256 != 0) {
            $dirty |= i79;
        } else {
            if (i65 & i79 == 0) {
                i23 = restartGroup.changedInstance(obj8) ? 67108864 : 33554432;
                $dirty |= i23;
            }
        }
        traceInProgress = $dirty;
        if ($dirty2 &= traceInProgress == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj3 = onTextLayout2;
                }
                if (i60 != 0) {
                    then = onTextLayout2;
                }
                if (i25 != 0) {
                    softWrap2 = onTextLayout2;
                }
                if (i6 != 0) {
                    i6 = onTextLayout2;
                } else {
                    i6 = i13;
                }
                if (i9 != 0) {
                    i18 = onTextLayout2;
                }
                if (i11 != 0) {
                    onTextLayout2 = ClickableTextKt.ClickableText.4.INSTANCE;
                } else {
                    onTextLayout2 = onTextLayout;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020774372, traceInProgress, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:162)");
                }
                String str4 = "CC(remember):ClickableText.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1498188796, str4);
                invalid$iv = 0;
                Composer composer3 = restartGroup;
                int i61 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i74 = 0;
                i19 = traceInProgress;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    obj29 = i30;
                    int i31 = 0;
                    obj30 = invalid$iv;
                    composer3.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i31, i31, 2, i31));
                } else {
                    obj30 = invalid$iv;
                    mutableStateOf$default = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i44 = i34;
                int i62 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                Composer composer = restartGroup;
                obj32 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                Composer composer5 = restartGroup;
                int i75 = 0;
                obj29 = i29;
                compositionCoroutineScope = composer5.rememberedValue();
                companion = 0;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i78 = 0;
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
                i3 = i19 & 112 == 32 ? 1 : 0;
                i2 = i19 & i46 == 67108864 ? 1 : 0;
                i42 |= i2;
                Composer composer4 = restartGroup;
                int i72 = 0;
                it$iv = composer4.rememberedValue();
                int i76 = 0;
                if (i43 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj31 = onHover;
                        obj33 = obj8;
                        super(obj30, obj31, obj32, obj33, 0);
                        coroutineScope = obj30;
                        function1 = obj31;
                        obj29 = coroutineScope3;
                        obj30 = i43;
                        invalid$iv2 = obj32;
                        obj4 = obj33;
                        obj31 = it$iv;
                        composer4.updateRememberedValue((Function2)companion);
                    } else {
                        coroutineScope = obj30;
                        obj30 = i43;
                        obj31 = it$iv;
                        obj4 = obj8;
                        function1 = onHover;
                        invalid$iv2 = obj32;
                    }
                } else {
                    obj30 = coroutineScope2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj4, function1, (Function2)it$iv);
                i25 = then;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1498221396, str4);
                i26 = i19 & i35 == 8388608 ? 1 : 0;
                Composer composer2 = restartGroup;
                int i50 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i77 = 0;
                if (i26 == 0) {
                    obj29 = pointerInput;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj30 = pointerInputModifier;
                        anon2 = new ClickableTextKt.ClickableText.5.1(invalid$iv2, onTextLayout2);
                        composer2.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue;
                    }
                } else {
                    obj29 = pointerInput;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i9 = softWrap2;
                BasicTextKt.BasicText-RWo7tUw(obj, obj3.then(pointerInput), i25, (Function1)anon2, i6, i9, i18, 0, 0, 0, restartGroup, i40 | i58, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                anon = onTextLayout2;
                obj2 = i25;
                i13 = i6;
                z = i9;
            } else {
                restartGroup.skipToGroupEnd();
                anon = onTextLayout;
                i19 = traceInProgress;
                maxLines2 = restartGroup;
                i22 = i18;
                obj4 = obj8;
                obj2 = then;
                z = softWrap2;
                function1 = onHover;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = maxLines2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ClickableTextKt.ClickableText.6(text, function1, obj3, obj2, z, i13, i22, anon, obj4, i65, i66);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier3 = obj3;
            modifier2 = i22;
        }
    }

    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    public static final void ClickableText-4YKlhWE(AnnotatedString text, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super Integer, Unit> onClick, Composer $composer, int $changed, int i11) {
        Object obj2;
        Object mutableStateOf$default;
        int maxLines2;
        boolean traceInProgress2;
        Object anon;
        int $dirty;
        Object $dirty3;
        int i12;
        Object onTextLayout3;
        Object onTextLayout2;
        int i9;
        boolean z;
        boolean traceInProgress;
        Object empty;
        Object obj3;
        int modifier2;
        int i10;
        int i;
        int str;
        Object obj4;
        androidx.compose.foundation.text.ClickableTextKt.ClickableText.1 anon2;
        Object it$iv;
        int empty2;
        Object obj;
        int i17;
        Modifier then;
        int $dirty2;
        int i2;
        boolean softWrap2;
        int i14;
        Object invalid$iv;
        int i4;
        int i8;
        int i16;
        boolean i7;
        int i18;
        int i5;
        int i3;
        Composer.Companion companion2;
        int i20;
        int i19;
        int i15;
        int i21;
        Composer $composer2;
        int companion;
        int i6;
        int i13;
        int obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        int obj29;
        final Object obj6 = onClick;
        empty2 = $changed;
        final int i47 = i11;
        traceInProgress2 = $composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(traceInProgress2, "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)84@3976L52,85@4085L184,100@4490L76,93@4275L297:ClickableText.kt#423gt5");
        $dirty = $changed;
        if (i47 & 1 != 0) {
            $dirty |= 6;
            obj = text;
        } else {
            if (empty2 & 6 == 0) {
                i12 = traceInProgress2.changed(text) ? 4 : 2;
                $dirty |= i12;
            } else {
                obj = text;
            }
        }
        int i28 = i47 & 2;
        if (i28 != 0) {
            $dirty |= 48;
            obj3 = modifier;
        } else {
            if (empty2 & 48 == 0) {
                i10 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj3 = modifier;
            }
        }
        str = i47 & 4;
        if (str != null) {
            $dirty |= 384;
            obj4 = style;
        } else {
            if (empty2 & 384 == 0) {
                i17 = traceInProgress2.changed(style) ? 256 : 128;
                $dirty |= i17;
            } else {
                obj4 = style;
            }
        }
        then = i47 & 8;
        if (then != 0) {
            $dirty |= 3072;
            softWrap2 = softWrap;
        } else {
            if (empty2 & 3072 == 0) {
                i14 = traceInProgress2.changed(softWrap) ? 2048 : 1024;
                $dirty |= i14;
            } else {
                softWrap2 = softWrap;
            }
        }
        invalid$iv = i47 & 16;
        if (invalid$iv != 0) {
            $dirty |= 24576;
            i8 = overflow;
        } else {
            if (empty2 & 24576 == 0) {
                i16 = traceInProgress2.changed(overflow) ? 16384 : 8192;
                $dirty |= i16;
            } else {
                i8 = overflow;
            }
        }
        i7 = i47 & 32;
        i18 = 196608;
        if (i7 != 0) {
            $dirty |= i18;
            i9 = maxLines;
        } else {
            if (empty2 & i18 == 0) {
                i18 = traceInProgress2.changed(maxLines) ? 131072 : 65536;
                $dirty |= i18;
            } else {
                i9 = maxLines;
            }
        }
        i5 = i47 & 64;
        i20 = 1572864;
        if (i5 != 0) {
            $dirty |= i20;
            obj2 = onTextLayout;
        } else {
            if (empty2 & i20 == 0) {
                i19 = traceInProgress2.changedInstance(onTextLayout) ? 1048576 : 524288;
                $dirty |= i19;
            } else {
                obj2 = onTextLayout;
            }
        }
        companion = 12582912;
        if (i47 & 128 != 0) {
            $dirty |= companion;
        } else {
            if (empty2 & companion == 0) {
                i15 = traceInProgress2.changedInstance(obj6) ? 8388608 : 4194304;
                $dirty |= i15;
            }
        }
        if ($dirty & i58 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                if (i28 != 0) {
                    obj3 = mutableStateOf$default;
                }
                if (str != null) {
                    obj4 = mutableStateOf$default;
                }
                if (then != 0) {
                    softWrap2 = mutableStateOf$default;
                }
                if (invalid$iv != 0) {
                    i8 = mutableStateOf$default;
                }
                maxLines2 = i7 != 0 ? 0x7fffffff /* Unknown resource */ : i9;
                if (i5 != 0) {
                    onTextLayout2 = ClickableTextKt.ClickableText.1.INSTANCE;
                } else {
                    onTextLayout2 = onTextLayout;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, $dirty, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:83)");
                }
                String str3 = "CC(remember):ClickableText.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 1498074812, str3);
                Composer composer2 = traceInProgress2;
                int i52 = 0;
                i5 = maxLines2;
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
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 1498078432, str3);
                int i56 = 1;
                i2 = i49 &= $dirty == 8388608 ? i56 : 0;
                Composer composer3 = traceInProgress2;
                companion2 = 0;
                it$iv = composer3.rememberedValue();
                int i59 = 0;
                if (i2 == 0) {
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
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 1498091284, str3);
                int i33 = 3670016;
                i4 = $dirty & i33 == 1048576 ? i56 : 0;
                Composer composer = traceInProgress2;
                empty2 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i57 = 0;
                if (i4 == 0) {
                    $composer2 = traceInProgress2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        obj27 = $composer3;
                        anon = new ClickableTextKt.ClickableText.2.1(mutableStateOf$default, onTextLayout2);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                    $composer2 = traceInProgress2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i7 = softWrap2;
                softWrap2 = obj26;
                BasicTextKt.BasicText-RWo7tUw(obj, obj3.then(SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, obj6, (Function2)it$iv)), softWrap2, (Function1)anon, i8, i7, i5, 0, 0, 0, $composer2, i27 | i40, 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                anon2 = onTextLayout2;
                onTextLayout3 = softWrap2;
                z = i7;
                i = i5;
            } else {
                traceInProgress2.skipToGroupEnd();
                $composer2 = traceInProgress2;
                i = i9;
                onTextLayout3 = obj4;
                z = softWrap2;
                anon2 = onTextLayout;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            mutableStateOf$default = new ClickableTextKt.ClickableText.3(text, obj3, onTextLayout3, z, i8, i, anon2, obj6, $changed, i47);
            endRestartGroup.updateScope((Function2)mutableStateOf$default);
        } else {
            $dirty2 = $dirty;
            $dirty3 = obj3;
            modifier2 = i8;
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
        float x-impl = Offset.getX-impl(positionOffset);
        int i4 = 0;
        float y-impl = Offset.getY-impl(positionOffset);
        cmp = 0;
        if (Float.compare(x-impl, cmp) > 0 && Float.compare(y-impl, cmp) >= 0 && Float.compare(x-impl, width) <= 0 && Float.compare(y-impl, height) <= 0) {
            if (Float.compare(y-impl, cmp) >= 0) {
                if (Float.compare(x-impl, width) <= 0) {
                    i = Float.compare(y-impl, height) <= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
