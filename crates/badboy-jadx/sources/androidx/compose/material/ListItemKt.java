package androidx.compose.material;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.Companion;
import androidx.compose.ui.text.style.LineHeightStyle.Trim;
import androidx.compose.ui.text.style.LineHeightStyle.Trim.Companion;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0003¢\u0006\u0002\u0010\n\u001a\u0090\u0001\u0010\u000b\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0015\u0008\u0002\u0010\u000c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\t2\u0015\u0008\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\u0008\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\t2\u0015\u0008\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0007¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u000c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0008¢\u0006\u0002\u0008\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListItemKt {
    private static final void BaselinesOffsetColumn(List<Dp> offsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        Integer invalid$iv;
        Object constructor-impl;
        int $dirty;
        Object obj;
        int $dirty2;
        Object modifier2;
        int valueOf;
        int i;
        int i8;
        boolean traceInProgress;
        Object str;
        int i2;
        int i7;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        Object anon;
        int i3;
        int i4;
        int i5;
        int i9;
        int i10;
        Object measurePolicy$iv;
        Object obj20;
        Composer obj22;
        constructor-impl = offsets;
        final Object obj2 = content;
        valueOf = $changed;
        traceInProgress2 = 1631148337;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BaselinesOffsetColumn)P(2,1)355@13268L1109,355@13242L1135:ListItem.kt#jmzs0o");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (valueOf & 6 == 0) {
                i = restartGroup.changedInstance(constructor-impl) ? 4 : 2;
                $dirty |= i;
            }
        }
        i8 = i6 & 2;
        if (i8 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (valueOf & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (valueOf & 384 == 0) {
                i7 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty |= i7;
            }
        }
        int i19 = $dirty;
        if (i19 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i19, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:354)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1356159526, "CC(remember):ListItem.kt#9igjgp");
                Composer composer2 = restartGroup;
                int i17 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i22 = 0;
                if (!restartGroup.changedInstance(constructor-impl)) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        materializeModifier = 0;
                        anon = new ListItemKt.BaselinesOffsetColumn.1.1(constructor-impl);
                        composer2.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i5 = 0;
                Updater.set-impl(constructor-impl, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i9 = 0;
                obj22 = constructor-impl;
                i10 = 0;
                if (!obj22.getInserting()) {
                    measurePolicy$iv = invalid$iv;
                    if (!Intrinsics.areEqual(obj22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = obj22;
                    }
                } else {
                    measurePolicy$iv = invalid$iv;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj2.invoke(restartGroup, Integer.valueOf(i12 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj20;
            } else {
                restartGroup.skipToGroupEnd();
                obj = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ListItemKt.BaselinesOffsetColumn.2(offsets, obj, obj2, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> secondaryText, boolean singleLineSecondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i10) {
        Object obj3;
        int skipping;
        Object modifier2;
        int $dirty4;
        Object $dirty2;
        Object icon2;
        Function2 function2;
        Object styledOverlineText;
        Object obj2;
        Object secondaryText2;
        int i9;
        int singleLineSecondaryText2;
        Object obj;
        Object overlineText2;
        int i6;
        int trailing2;
        Object $dirty;
        boolean traceInProgress;
        Object iNSTANCE;
        int i5;
        int semantics;
        boolean icon3;
        int $dirty3;
        int i2;
        int textStyle3;
        Object styledSecondaryText2;
        Composer styledOverlineText2;
        int i8;
        Function2 textStyle;
        int i4;
        int i3;
        int i7;
        Function2 styledSecondaryText;
        int i;
        androidx.compose.material.Typography typography;
        Function2 textStyle2;
        final Object obj5 = text;
        final int i21 = $changed;
        styledOverlineText2 = $composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation(styledOverlineText2, "C(ListItem)P(1!1,3,4!1,6)84@3532L10,86@3615L4,87@3705L6,88@3806L4,89@3899L4:ListItem.kt#jmzs0o");
        $dirty4 = $changed;
        int i12 = i10 & 1;
        if (i12 != 0) {
            $dirty4 |= 6;
            obj2 = modifier;
        } else {
            if (i21 & 6 == 0) {
                i9 = styledOverlineText2.changed(modifier) ? 4 : 2;
                $dirty4 |= i9;
            } else {
                obj2 = modifier;
            }
        }
        int i18 = i10 & 2;
        if (i18 != 0) {
            $dirty4 |= 48;
            obj = icon;
        } else {
            if (i21 & 48 == 0) {
                i6 = styledOverlineText2.changedInstance(icon) ? 32 : 16;
                $dirty4 |= i6;
            } else {
                obj = icon;
            }
        }
        int i20 = i10 & 4;
        if (i20 != 0) {
            $dirty4 |= 384;
            $dirty = secondaryText;
        } else {
            if (i21 & 384 == 0) {
                i5 = styledOverlineText2.changedInstance(secondaryText) ? 256 : 128;
                $dirty4 |= i5;
            } else {
                $dirty = secondaryText;
            }
        }
        semantics = i10 & 8;
        if (semantics != 0) {
            $dirty4 |= 3072;
            icon3 = singleLineSecondaryText;
        } else {
            if (i21 & 3072 == 0) {
                i2 = styledOverlineText2.changed(singleLineSecondaryText) ? 2048 : 1024;
                $dirty4 |= i2;
            } else {
                icon3 = singleLineSecondaryText;
            }
        }
        textStyle3 = i10 & 16;
        if (textStyle3 != 0) {
            $dirty4 |= 24576;
            styledSecondaryText2 = overlineText;
        } else {
            if (i21 & 24576 == 0) {
                i8 = styledOverlineText2.changedInstance(overlineText) ? 16384 : 8192;
                $dirty4 |= i8;
            } else {
                styledSecondaryText2 = overlineText;
            }
        }
        textStyle = i10 & 32;
        i4 = 196608;
        if (textStyle != 0) {
            $dirty4 |= i4;
            obj3 = trailing;
        } else {
            if (i21 & i4 == 0) {
                i3 = styledOverlineText2.changedInstance(trailing) ? 131072 : 65536;
                $dirty4 |= i3;
            } else {
                obj3 = trailing;
            }
        }
        i = 1572864;
        if (i10 & 64 != 0) {
            $dirty4 |= i;
        } else {
            if (i21 & i == 0) {
                i7 = styledOverlineText2.changedInstance(obj5) ? 1048576 : 524288;
                $dirty4 |= i7;
            }
        }
        if ($dirty4 & styledSecondaryText == 599186) {
            if (!styledOverlineText2.getSkipping()) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj2;
                }
                icon2 = i18 != 0 ? 0 : obj;
                secondaryText2 = i20 != 0 ? 0 : $dirty;
                singleLineSecondaryText2 = semantics != 0 ? 1 : icon3;
                overlineText2 = textStyle3 != 0 ? 0 : styledSecondaryText2;
                trailing2 = textStyle != 0 ? 0 : trailing;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, $dirty4, -1, "androidx.compose.material.ListItem (ListItem.kt:83)");
                }
                int i26 = 6;
                typography = MaterialTheme.INSTANCE.getTypography(styledOverlineText2, i26);
                textStyle3 = ListItemKt.applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(styledOverlineText2, i26), obj5);
                Intrinsics.checkNotNull(textStyle3);
                styledSecondaryText = ListItemKt.applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(styledOverlineText2, i26), secondaryText2);
                textStyle2 = ListItemKt.applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(styledOverlineText2, i26), overlineText2);
                textStyle = ListItemKt.applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(styledOverlineText2, i26), trailing2);
                semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1)ListItemKt.ListItem.semanticsModifier.1.INSTANCE);
                if (styledSecondaryText == null && textStyle2 == null) {
                    if (textStyle2 == null) {
                        styledOverlineText2.startReplaceGroup(-215915306);
                        ComposerKt.sourceInformation(styledOverlineText2, "94@4077L61");
                        Function2 function22 = textStyle;
                        OneLine.INSTANCE.ListItem(semantics, icon2, textStyle3, function22, styledOverlineText2, i29 |= 24576, 0);
                        textStyle = function22;
                        styledOverlineText2.endReplaceGroup();
                        styledSecondaryText2 = styledSecondaryText;
                        function2 = textStyle2;
                    } else {
                        icon3 = icon2;
                        if (textStyle2 == null) {
                            if (singleLineSecondaryText2 == 0) {
                                if (styledSecondaryText == null) {
                                    styledOverlineText2.startReplaceGroup(-215716069);
                                    ComposerKt.sourceInformation(styledOverlineText2, "98@4274L184");
                                    i4 = styledOverlineText2;
                                    Function2 $composer2 = textStyle2;
                                    TwoLine.INSTANCE.ListItem(semantics, icon3, textStyle3, styledSecondaryText, $composer2, textStyle, i4, i15 |= i, 0);
                                    function2 = $composer2;
                                    i4.endReplaceGroup();
                                } else {
                                    styledOverlineText2.startReplaceGroup(-215503719);
                                    ComposerKt.sourceInformation(styledOverlineText2, "107@4490L184");
                                    i4 = styledOverlineText2;
                                    ThreeLine.INSTANCE.ListItem(semantics, icon3, textStyle3, styledSecondaryText, textStyle2, textStyle, i4, i32 | i, 0);
                                    i4.endReplaceGroup();
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                styledOverlineText = icon3;
            } else {
                styledOverlineText2.skipToGroupEnd();
                trailing2 = trailing;
                modifier2 = obj2;
                styledOverlineText = obj;
                secondaryText2 = $dirty;
                singleLineSecondaryText2 = icon3;
                overlineText2 = styledSecondaryText2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = styledOverlineText2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = i25;
            modifier2 = new ListItemKt.ListItem.1(modifier2, styledOverlineText, secondaryText2, singleLineSecondaryText2, overlineText2, trailing2, obj5, i21, i10);
            endRestartGroup.updateScope((Function2)modifier2);
        } else {
            $dirty3 = $dirty4;
            $dirty2 = modifier2;
        }
    }

    private static final void OffsetToBaselineOrCenter-Kz89ssw(float offset, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int i7;
        Integer invalid$iv;
        float constructor-impl;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier2;
        int valueOf;
        int i;
        int currentCompositeKeyHash;
        boolean traceInProgress;
        int i2;
        Object str;
        int i8;
        int i3;
        int currentCompositionLocalMap;
        Modifier materializeModifier;
        Object constructor;
        int i5;
        Object anon;
        int i10;
        int i9;
        int i11;
        int i4;
        Object measurePolicy$iv;
        Object obj20;
        Composer obj22;
        constructor-impl = offset;
        final Object obj2 = content;
        valueOf = $changed;
        traceInProgress2 = -1062692685;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)397@14931L780,397@14905L806:ListItem.kt#jmzs0o");
        $dirty2 = $changed;
        i2 = 4;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (valueOf & 6 == 0) {
                i = restartGroup.changed(constructor-impl) ? i2 : 2;
                $dirty2 |= i;
            }
        }
        currentCompositeKeyHash = i6 & 2;
        if (currentCompositeKeyHash != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (valueOf & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (valueOf & 384 == 0) {
                i3 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty2 |= i3;
            }
        }
        int i22 = $dirty2;
        if (i22 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (currentCompositeKeyHash != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i22, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:396)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1484813085, "CC(remember):ListItem.kt#9igjgp");
                int i16 = 0;
                i7 = i22 & 14 == i2 ? 1 : i16;
                Composer composer2 = restartGroup;
                int i20 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i24 = 0;
                if (i7 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        constructor = 0;
                        anon = new ListItemKt.OffsetToBaselineOrCenter.1.1(constructor-impl);
                        composer2.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i16);
                i10 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i9 = 0;
                Updater.set-impl(constructor-impl, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i11 = 0;
                obj22 = constructor-impl;
                i4 = 0;
                if (!obj22.getInserting()) {
                    measurePolicy$iv = invalid$iv;
                    if (!Intrinsics.areEqual(obj22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = obj22;
                    }
                } else {
                    measurePolicy$iv = invalid$iv;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj2.invoke(restartGroup, Integer.valueOf(i14 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj20;
            } else {
                restartGroup.skipToGroupEnd();
                obj = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ListItemKt.OffsetToBaselineOrCenter.2(offset, obj, obj2, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$BaselinesOffsetColumn(List offsets, Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        ListItemKt.BaselinesOffsetColumn(offsets, modifier, content, $composer, $changed, $default);
    }

    public static final void access$OffsetToBaselineOrCenter-Kz89ssw(float offset, Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        ListItemKt.OffsetToBaselineOrCenter-Kz89ssw(offset, modifier, content, $composer, $changed, $default);
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(TextStyle textStyle, float contentAlpha, Function2<? super Composer, ? super Integer, Unit> icon) {
        int i = 0;
        if (icon == null) {
            return i;
        }
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getProportional-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), i);
        ListItemKt.applyTextStyle.1 anon = new ListItemKt.applyTextStyle.1(contentAlpha, textStyle, lineHeightStyle, icon);
        return (Function2)ComposableLambdaKt.composableLambdaInstance(-830176860, true, anon);
    }
}
