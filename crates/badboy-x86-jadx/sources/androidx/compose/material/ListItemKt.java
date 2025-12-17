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
        int traceInProgress;
        Integer invalid$iv;
        Object constructor-impl;
        int $dirty;
        Object obj;
        int $dirty2;
        Object modifier2;
        int valueOf;
        int i10;
        int i3;
        boolean traceInProgress2;
        Object str;
        int i2;
        int i8;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        Object anon;
        int i4;
        int i;
        int i9;
        int i5;
        int i7;
        Object measurePolicy$iv;
        Object obj20;
        Composer obj22;
        constructor-impl = offsets;
        final Object obj2 = content;
        valueOf = $changed;
        traceInProgress = 1631148337;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BaselinesOffsetColumn)P(2,1)355@13268L1109,355@13242L1135:ListItem.kt#jmzs0o");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (valueOf & 6 == 0) {
                i10 = restartGroup.changedInstance(constructor-impl) ? 4 : 2;
                $dirty |= i10;
            }
        }
        i3 = i6 & 2;
        if (i3 != 0) {
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
                i8 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty |= i8;
            }
        }
        int i19 = $dirty;
        if (i19 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i3 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i19, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:354)");
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
                i = 0;
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
                i5 = 0;
                obj22 = constructor-impl;
                i7 = 0;
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
            traceInProgress = new ListItemKt.BaselinesOffsetColumn.2(offsets, obj, obj2, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> secondaryText, boolean singleLineSecondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i10) {
        Object obj2;
        int skipping;
        Object modifier2;
        int $dirty3;
        Object $dirty2;
        Object icon3;
        Function2 function2;
        Object styledOverlineText2;
        Object obj3;
        Object secondaryText2;
        int i9;
        int singleLineSecondaryText2;
        Object obj;
        Object overlineText2;
        int i2;
        int trailing2;
        Object $dirty4;
        boolean traceInProgress;
        Object iNSTANCE;
        int i8;
        int semantics;
        boolean icon2;
        int $dirty;
        int i6;
        int textStyle2;
        Object styledSecondaryText2;
        Composer styledOverlineText;
        int i5;
        Function2 textStyle;
        int i7;
        int i3;
        int i;
        Function2 styledSecondaryText;
        int i4;
        androidx.compose.material.Typography typography;
        Function2 textStyle3;
        final Object obj5 = text;
        final int i21 = $changed;
        styledOverlineText = $composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation(styledOverlineText, "C(ListItem)P(1!1,3,4!1,6)84@3532L10,86@3615L4,87@3705L6,88@3806L4,89@3899L4:ListItem.kt#jmzs0o");
        $dirty3 = $changed;
        int i12 = i10 & 1;
        if (i12 != 0) {
            $dirty3 |= 6;
            obj3 = modifier;
        } else {
            if (i21 & 6 == 0) {
                i9 = styledOverlineText.changed(modifier) ? 4 : 2;
                $dirty3 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        int i18 = i10 & 2;
        if (i18 != 0) {
            $dirty3 |= 48;
            obj = icon;
        } else {
            if (i21 & 48 == 0) {
                i2 = styledOverlineText.changedInstance(icon) ? 32 : 16;
                $dirty3 |= i2;
            } else {
                obj = icon;
            }
        }
        int i20 = i10 & 4;
        if (i20 != 0) {
            $dirty3 |= 384;
            $dirty4 = secondaryText;
        } else {
            if (i21 & 384 == 0) {
                i8 = styledOverlineText.changedInstance(secondaryText) ? 256 : 128;
                $dirty3 |= i8;
            } else {
                $dirty4 = secondaryText;
            }
        }
        semantics = i10 & 8;
        if (semantics != 0) {
            $dirty3 |= 3072;
            icon2 = singleLineSecondaryText;
        } else {
            if (i21 & 3072 == 0) {
                i6 = styledOverlineText.changed(singleLineSecondaryText) ? 2048 : 1024;
                $dirty3 |= i6;
            } else {
                icon2 = singleLineSecondaryText;
            }
        }
        textStyle2 = i10 & 16;
        if (textStyle2 != 0) {
            $dirty3 |= 24576;
            styledSecondaryText2 = overlineText;
        } else {
            if (i21 & 24576 == 0) {
                i5 = styledOverlineText.changedInstance(overlineText) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                styledSecondaryText2 = overlineText;
            }
        }
        textStyle = i10 & 32;
        i7 = 196608;
        if (textStyle != 0) {
            $dirty3 |= i7;
            obj2 = trailing;
        } else {
            if (i21 & i7 == 0) {
                i3 = styledOverlineText.changedInstance(trailing) ? 131072 : 65536;
                $dirty3 |= i3;
            } else {
                obj2 = trailing;
            }
        }
        i4 = 1572864;
        if (i10 & 64 != 0) {
            $dirty3 |= i4;
        } else {
            if (i21 & i4 == 0) {
                i = styledOverlineText.changedInstance(obj5) ? 1048576 : 524288;
                $dirty3 |= i;
            }
        }
        if ($dirty3 & styledSecondaryText == 599186) {
            if (!styledOverlineText.getSkipping()) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj3;
                }
                icon3 = i18 != 0 ? 0 : obj;
                secondaryText2 = i20 != 0 ? 0 : $dirty4;
                singleLineSecondaryText2 = semantics != 0 ? 1 : icon2;
                overlineText2 = textStyle2 != 0 ? 0 : styledSecondaryText2;
                trailing2 = textStyle != 0 ? 0 : trailing;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-450923337, $dirty3, -1, "androidx.compose.material.ListItem (ListItem.kt:83)");
                }
                int i26 = 6;
                typography = MaterialTheme.INSTANCE.getTypography(styledOverlineText, i26);
                textStyle2 = ListItemKt.applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(styledOverlineText, i26), obj5);
                Intrinsics.checkNotNull(textStyle2);
                styledSecondaryText = ListItemKt.applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(styledOverlineText, i26), secondaryText2);
                textStyle3 = ListItemKt.applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(styledOverlineText, i26), overlineText2);
                textStyle = ListItemKt.applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(styledOverlineText, i26), trailing2);
                semantics = SemanticsModifierKt.semantics(modifier2, true, (Function1)ListItemKt.ListItem.semanticsModifier.1.INSTANCE);
                if (styledSecondaryText == null && textStyle3 == null) {
                    if (textStyle3 == null) {
                        styledOverlineText.startReplaceGroup(-215915306);
                        ComposerKt.sourceInformation(styledOverlineText, "94@4077L61");
                        Function2 function22 = textStyle;
                        OneLine.INSTANCE.ListItem(semantics, icon3, textStyle2, function22, styledOverlineText, i29 |= 24576, 0);
                        textStyle = function22;
                        styledOverlineText.endReplaceGroup();
                        styledSecondaryText2 = styledSecondaryText;
                        function2 = textStyle3;
                    } else {
                        icon2 = icon3;
                        if (textStyle3 == null) {
                            if (singleLineSecondaryText2 == 0) {
                                if (styledSecondaryText == null) {
                                    styledOverlineText.startReplaceGroup(-215716069);
                                    ComposerKt.sourceInformation(styledOverlineText, "98@4274L184");
                                    i7 = styledOverlineText;
                                    Function2 $composer2 = textStyle3;
                                    TwoLine.INSTANCE.ListItem(semantics, icon2, textStyle2, styledSecondaryText, $composer2, textStyle, i7, i15 |= i4, 0);
                                    function2 = $composer2;
                                    i7.endReplaceGroup();
                                } else {
                                    styledOverlineText.startReplaceGroup(-215503719);
                                    ComposerKt.sourceInformation(styledOverlineText, "107@4490L184");
                                    i7 = styledOverlineText;
                                    ThreeLine.INSTANCE.ListItem(semantics, icon2, textStyle2, styledSecondaryText, textStyle3, textStyle, i7, i32 | i4, 0);
                                    i7.endReplaceGroup();
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
                styledOverlineText2 = icon2;
            } else {
                styledOverlineText.skipToGroupEnd();
                trailing2 = trailing;
                modifier2 = obj3;
                styledOverlineText2 = obj;
                secondaryText2 = $dirty4;
                singleLineSecondaryText2 = icon2;
                overlineText2 = styledSecondaryText2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = styledOverlineText.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = i25;
            modifier2 = new ListItemKt.ListItem.1(modifier2, styledOverlineText2, secondaryText2, singleLineSecondaryText2, overlineText2, trailing2, obj5, i21, i10);
            endRestartGroup.updateScope((Function2)modifier2);
        } else {
            $dirty = $dirty3;
            $dirty2 = modifier2;
        }
    }

    private static final void OffsetToBaselineOrCenter-Kz89ssw(float offset, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int i;
        Integer invalid$iv;
        float constructor-impl;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier2;
        int valueOf;
        int i11;
        int currentCompositeKeyHash;
        boolean traceInProgress;
        int i8;
        Object str;
        int i5;
        int i9;
        int currentCompositionLocalMap;
        Modifier materializeModifier;
        Object constructor;
        int i7;
        Object anon;
        int i10;
        int i4;
        int i2;
        int i3;
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
        i8 = 4;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (valueOf & 6 == 0) {
                i11 = restartGroup.changed(constructor-impl) ? i8 : 2;
                $dirty2 |= i11;
            }
        }
        currentCompositeKeyHash = i6 & 2;
        if (currentCompositeKeyHash != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (valueOf & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (valueOf & 384 == 0) {
                i9 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty2 |= i9;
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
                i = i22 & 14 == i8 ? 1 : i16;
                Composer composer2 = restartGroup;
                int i20 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i24 = 0;
                if (i == 0) {
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
                i4 = 0;
                Updater.set-impl(constructor-impl, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i2 = 0;
                obj22 = constructor-impl;
                i3 = 0;
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
