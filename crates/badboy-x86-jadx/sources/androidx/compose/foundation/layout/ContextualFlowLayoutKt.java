package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r21\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0084\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u001921\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007¢\u0006\u0002\u0010\u001b\u001a¥\u0001\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\u0008\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0013\u0012\u00110'¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0014H\u0001¢\u0006\u0002\u0010)\u001a¥\u0001\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\u0008\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0013\u0012\u00110'¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0014H\u0001¢\u0006\u0002\u0010+¨\u0006,", d2 = {"ContextualFlowColumn", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualColumnMeasureHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualRowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextualFlowLayoutKt {
    public static final void ContextualFlowColumn(int itemCount, Modifier modifier, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInEachColumn, int maxLines, androidx.compose.foundation.layout.ContextualFlowColumnOverflow overflow, Function4<? super androidx.compose.foundation.layout.ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i12;
        Object obj5;
        int i2;
        int traceInProgress;
        Object list;
        Object contextualColumnMeasureHelper;
        int $dirty;
        int companion2;
        Object overflow3;
        Object overflow2;
        int i16;
        boolean traceInProgress2;
        int i15;
        int i19;
        Object obj;
        int i18;
        int str;
        Object obj3;
        Object obj2;
        int modifier2;
        int i8;
        int i4;
        int i14;
        Object obj6;
        androidx.compose.foundation.layout.ContextualFlowColumnOverflow verticalArrangement3;
        int i;
        Composer verticalArrangement2;
        Object obj4;
        int i9;
        int i21;
        int $dirty2;
        int i5;
        int i13;
        Object overflowState$foundation_layout_release;
        int i6;
        int i3;
        int arrayList;
        ArrayList i20;
        int i17;
        androidx.compose.runtime.internal.ComposableLambda i7;
        Object companion;
        int i10;
        int obj22;
        int obj29;
        final Object obj8 = content;
        final int i57 = $changed;
        final int i58 = i11;
        contextualColumnMeasureHelper = $composer.startRestartGroup(-588476895);
        ComposerKt.sourceInformation(contextualColumnMeasureHelper, "C(ContextualFlowColumn)P(2,5,7,1,3,4,6)149@6671L65,152@6782L193,165@7201L270,157@7000L471,175@7477L90:ContextualFlowLayout.kt#2w3rfo");
        $dirty = $changed;
        if (i58 & 1 != 0) {
            $dirty |= 6;
            i16 = itemCount;
        } else {
            if (i57 & 6 == 0) {
                i18 = contextualColumnMeasureHelper.changed(itemCount) ? 4 : 2;
                $dirty |= i18;
            } else {
                i16 = itemCount;
            }
        }
        str = i58 & 2;
        if (str != null) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i57 & 48 == 0) {
                i8 = contextualColumnMeasureHelper.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj2 = modifier;
            }
        }
        i4 = i58 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            obj6 = verticalArrangement;
        } else {
            if (i57 & 384 == 0) {
                i = contextualColumnMeasureHelper.changed(verticalArrangement) ? 256 : 128;
                $dirty |= i;
            } else {
                obj6 = verticalArrangement;
            }
        }
        int i59 = i58 & 8;
        if (i59 != 0) {
            $dirty |= 3072;
            obj4 = horizontalArrangement;
        } else {
            if (i57 & 3072 == 0) {
                i9 = contextualColumnMeasureHelper.changed(horizontalArrangement) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                obj4 = horizontalArrangement;
            }
        }
        i21 = i58 & 16;
        if (i21 != 0) {
            $dirty |= 24576;
            i5 = maxItemsInEachColumn;
        } else {
            if (i57 & 24576 == 0) {
                i13 = contextualColumnMeasureHelper.changed(maxItemsInEachColumn) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                i5 = maxItemsInEachColumn;
            }
        }
        overflowState$foundation_layout_release = i58 & 32;
        i6 = 196608;
        if (overflowState$foundation_layout_release != 0) {
            $dirty |= i6;
            i12 = maxLines;
        } else {
            if (i57 & i6 == 0) {
                i3 = contextualColumnMeasureHelper.changed(maxLines) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                i12 = maxLines;
            }
        }
        i20 = i58 & 64;
        i17 = 1572864;
        if (i20 != 0) {
            $dirty |= i17;
            obj5 = overflow;
        } else {
            if (i57 & i17 == 0) {
                i17 = contextualColumnMeasureHelper.changed(overflow) ? 1048576 : 524288;
                $dirty |= i17;
            } else {
                obj5 = overflow;
            }
        }
        i7 = 12582912;
        if (i58 & 128 != 0) {
            $dirty |= i7;
        } else {
            if (i57 & i7 == 0) {
                i2 = contextualColumnMeasureHelper.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i2;
            }
        }
        traceInProgress = $dirty;
        if ($dirty4 &= traceInProgress == 4793490) {
            if (!contextualColumnMeasureHelper.getSkipping()) {
                if (str != null) {
                    obj2 = companion2;
                }
                if (i4 != 0) {
                    obj6 = companion2;
                }
                if (i59 != 0) {
                    obj4 = companion2;
                }
                i21 = i21 != 0 ? companion2 : i5;
                i5 = overflowState$foundation_layout_release != 0 ? companion2 : maxLines;
                if (i20 != 0) {
                    overflow3 = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    overflow3 = overflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, traceInProgress, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                String str3 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(contextualColumnMeasureHelper, -1055927072, str3);
                int i28 = 3670016;
                i15 = traceInProgress & i28 == 1048576 ? 1 : 0;
                Composer composer2 = contextualColumnMeasureHelper;
                int i63 = 0;
                Object rememberedValue = composer2.rememberedValue();
                arrayList = 0;
                if (i15 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i62 = 0;
                        composer2.updateRememberedValue(overflow3.createOverflowState$foundation_layout_release());
                    } else {
                        overflowState$foundation_layout_release = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(contextualColumnMeasureHelper);
                ComposerKt.sourceInformationMarkerStart(contextualColumnMeasureHelper, -1055923392, str3);
                i19 = traceInProgress & obj22 == 1048576 ? 1 : 0;
                Composer composer = contextualColumnMeasureHelper;
                int i53 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i64 = 0;
                if (i19 == 0) {
                    obj29 = traceInProgress;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj22 = $dirty3;
                        list = arrayList;
                        overflow3.addOverflowComposables$foundation_layout_release((FlowLayoutOverflowState)overflowState$foundation_layout_release, (List)list);
                        composer.updateRememberedValue(list);
                    } else {
                        list = rememberedValue2;
                    }
                } else {
                    obj29 = traceInProgress;
                }
                ComposerKt.sourceInformationMarkerEnd(contextualColumnMeasureHelper);
                ContextualFlowLayoutKt.ContextualFlowColumn.measurePolicy.1 anon = new ContextualFlowLayoutKt.ContextualFlowColumn.measurePolicy.1(obj8);
                companion = contextualColumnMeasureHelper;
                SubcomposeLayoutKt.SubcomposeLayout(obj2, ContextualFlowLayoutKt.contextualColumnMeasureHelper(obj6, obj4, i21, i5, overflowState$foundation_layout_release, itemCount, (List)list, (Function4)ComposableLambdaKt.rememberComposableLambda(302435318, true, anon, contextualColumnMeasureHelper, 54), companion, i38 | i50), companion, i39 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj6;
                i14 = i5;
                verticalArrangement3 = overflow3;
                overflow2 = obj2;
                modifier2 = i21;
                obj3 = obj4;
            } else {
                contextualColumnMeasureHelper.skipToGroupEnd();
                i14 = maxLines;
                obj29 = traceInProgress;
                verticalArrangement2 = contextualColumnMeasureHelper;
                overflow2 = obj2;
                obj = obj6;
                modifier2 = i5;
                verticalArrangement3 = overflow;
                obj3 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = verticalArrangement2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj29;
            traceInProgress = new ContextualFlowLayoutKt.ContextualFlowColumn.1(itemCount, overflow2, obj, obj3, modifier2, i14, verticalArrangement3, obj8, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj29;
        }
    }

    public static final void ContextualFlowRow(int itemCount, Modifier modifier, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, int maxLines, androidx.compose.foundation.layout.ContextualFlowRowOverflow overflow, Function4<? super androidx.compose.foundation.layout.ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i2;
        Object obj4;
        int i16;
        int traceInProgress2;
        Object list;
        Object contextualRowMeasurementHelper;
        int $dirty2;
        int companion;
        Object overflow3;
        Object overflow2;
        int i21;
        boolean traceInProgress;
        int i;
        int i9;
        Object obj;
        int i5;
        int str;
        Object obj3;
        Object obj2;
        int modifier2;
        int i19;
        int i20;
        int i15;
        Object obj6;
        androidx.compose.foundation.layout.ContextualFlowRowOverflow horizontalArrangement2;
        int i3;
        Composer horizontalArrangement3;
        Object obj5;
        int i4;
        int i12;
        int $dirty;
        int i14;
        int i7;
        Object overflowState$foundation_layout_release;
        int i10;
        int i18;
        int arrayList;
        ArrayList i6;
        int i8;
        androidx.compose.runtime.internal.ComposableLambda i17;
        Object companion2;
        int i13;
        int obj22;
        int obj29;
        final Object obj8 = content;
        final int i57 = $changed;
        final int i58 = i11;
        contextualRowMeasurementHelper = $composer.startRestartGroup(-341770689);
        ComposerKt.sourceInformation(contextualRowMeasurementHelper, "C(ContextualFlowRow)P(2,5,1,7,3,4,6)74@3434L65,77@3545L193,90@3961L267,82@3763L465,99@4233L90:ContextualFlowLayout.kt#2w3rfo");
        $dirty2 = $changed;
        if (i58 & 1 != 0) {
            $dirty2 |= 6;
            i21 = itemCount;
        } else {
            if (i57 & 6 == 0) {
                i5 = contextualRowMeasurementHelper.changed(itemCount) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                i21 = itemCount;
            }
        }
        str = i58 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i57 & 48 == 0) {
                i19 = contextualRowMeasurementHelper.changed(modifier) ? 32 : 16;
                $dirty2 |= i19;
            } else {
                obj2 = modifier;
            }
        }
        i20 = i58 & 4;
        if (i20 != 0) {
            $dirty2 |= 384;
            obj6 = horizontalArrangement;
        } else {
            if (i57 & 384 == 0) {
                i3 = contextualRowMeasurementHelper.changed(horizontalArrangement) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                obj6 = horizontalArrangement;
            }
        }
        int i59 = i58 & 8;
        if (i59 != 0) {
            $dirty2 |= 3072;
            obj5 = verticalArrangement;
        } else {
            if (i57 & 3072 == 0) {
                i4 = contextualRowMeasurementHelper.changed(verticalArrangement) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                obj5 = verticalArrangement;
            }
        }
        i12 = i58 & 16;
        if (i12 != 0) {
            $dirty2 |= 24576;
            i14 = maxItemsInEachRow;
        } else {
            if (i57 & 24576 == 0) {
                i7 = contextualRowMeasurementHelper.changed(maxItemsInEachRow) ? 16384 : 8192;
                $dirty2 |= i7;
            } else {
                i14 = maxItemsInEachRow;
            }
        }
        overflowState$foundation_layout_release = i58 & 32;
        i10 = 196608;
        if (overflowState$foundation_layout_release != 0) {
            $dirty2 |= i10;
            i2 = maxLines;
        } else {
            if (i57 & i10 == 0) {
                i18 = contextualRowMeasurementHelper.changed(maxLines) ? 131072 : 65536;
                $dirty2 |= i18;
            } else {
                i2 = maxLines;
            }
        }
        i6 = i58 & 64;
        i8 = 1572864;
        if (i6 != 0) {
            $dirty2 |= i8;
            obj4 = overflow;
        } else {
            if (i57 & i8 == 0) {
                i8 = contextualRowMeasurementHelper.changed(overflow) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                obj4 = overflow;
            }
        }
        i17 = 12582912;
        if (i58 & 128 != 0) {
            $dirty2 |= i17;
        } else {
            if (i57 & i17 == 0) {
                i16 = contextualRowMeasurementHelper.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty2 |= i16;
            }
        }
        traceInProgress2 = $dirty2;
        if ($dirty4 &= traceInProgress2 == 4793490) {
            if (!contextualRowMeasurementHelper.getSkipping()) {
                if (str != null) {
                    obj2 = companion;
                }
                if (i20 != 0) {
                    obj6 = companion;
                }
                if (i59 != 0) {
                    obj5 = companion;
                }
                i12 = i12 != 0 ? companion : i14;
                i14 = overflowState$foundation_layout_release != 0 ? companion : maxLines;
                if (i6 != 0) {
                    overflow3 = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    overflow3 = overflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, traceInProgress2, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                String str3 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(contextualRowMeasurementHelper, 1235053714, str3);
                int i28 = 3670016;
                i = traceInProgress2 & i28 == 1048576 ? 1 : 0;
                Composer composer2 = contextualRowMeasurementHelper;
                int i63 = 0;
                Object rememberedValue = composer2.rememberedValue();
                arrayList = 0;
                if (i == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i62 = 0;
                        composer2.updateRememberedValue(overflow3.createOverflowState$foundation_layout_release());
                    } else {
                        overflowState$foundation_layout_release = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(contextualRowMeasurementHelper);
                ComposerKt.sourceInformationMarkerStart(contextualRowMeasurementHelper, 1235057394, str3);
                i9 = traceInProgress2 & obj22 == 1048576 ? 1 : 0;
                Composer composer = contextualRowMeasurementHelper;
                int i53 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i64 = 0;
                if (i9 == 0) {
                    obj29 = traceInProgress2;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj22 = $dirty3;
                        list = arrayList;
                        overflow3.addOverflowComposables$foundation_layout_release((FlowLayoutOverflowState)overflowState$foundation_layout_release, (List)list);
                        composer.updateRememberedValue(list);
                    } else {
                        list = rememberedValue2;
                    }
                } else {
                    obj29 = traceInProgress2;
                }
                ComposerKt.sourceInformationMarkerEnd(contextualRowMeasurementHelper);
                ContextualFlowLayoutKt.ContextualFlowRow.measurePolicy.1 anon = new ContextualFlowLayoutKt.ContextualFlowRow.measurePolicy.1(obj8);
                companion2 = contextualRowMeasurementHelper;
                SubcomposeLayoutKt.SubcomposeLayout(obj2, ContextualFlowLayoutKt.contextualRowMeasurementHelper(obj6, obj5, i12, i14, overflowState$foundation_layout_release, itemCount, (List)list, (Function4)ComposableLambdaKt.rememberComposableLambda(-8464804, true, anon, contextualRowMeasurementHelper, 54), companion2, i38 | i50), companion2, i39 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj6;
                i15 = i14;
                horizontalArrangement2 = overflow3;
                overflow2 = obj2;
                modifier2 = i12;
                obj3 = obj5;
            } else {
                contextualRowMeasurementHelper.skipToGroupEnd();
                i15 = maxLines;
                obj29 = traceInProgress2;
                horizontalArrangement3 = contextualRowMeasurementHelper;
                overflow2 = obj2;
                obj = obj6;
                modifier2 = i14;
                horizontalArrangement2 = overflow;
                obj3 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = horizontalArrangement3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = obj29;
            traceInProgress2 = new ContextualFlowLayoutKt.ContextualFlowRow.1(itemCount, overflow2, obj, obj3, modifier2, i15, horizontalArrangement2, obj8, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = obj29;
        }
    }

    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState, int itemCount, List<? extends Function2<? super Composer, ? super Integer, Unit>> overflowComposables, Function4<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super Composer, ? super Integer, Unit> getComposable, Composer $composer, int $changed) {
        boolean changed5;
        int i12;
        boolean traceInProgress;
        boolean changed2;
        int i10;
        boolean changed;
        int i;
        boolean changed3;
        int i3;
        Object obj2;
        String str;
        int i4;
        boolean changed4;
        int i9;
        Object measurePolicy;
        int i11;
        Object rememberedValue;
        Object obj3;
        Object obj;
        int spacing-D9Ej5fM;
        boolean cROSS_AXIS_ALIGNMENT_START;
        float spacing-D9Ej5fM2;
        int i6;
        int i8;
        int i5;
        Object it$iv;
        List list;
        Function4 function4;
        int i7;
        int i2;
        final Composer composer = $composer;
        final int i13 = $changed;
        int i14 = 1009762916;
        ComposerKt.sourceInformationMarkerStart(composer, i14, "C(contextualColumnMeasureHelper)P(7,1,3,4,6,2,5)383@15228L850:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i13, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:382)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1978242771, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        int i23 = 4;
        i4 = 0;
        int i27 = 1;
        if (i16 ^= 6 > i23) {
            if (!composer.changed(verticalArrangement)) {
                i12 = i13 & 6 == i23 ? i27 : i4;
            } else {
            }
        } else {
            obj = verticalArrangement;
        }
        int i29 = 32;
        if (i24 ^= 48 > i29) {
            if (!composer.changed(horizontalArrangement)) {
                i10 = i13 & 48 == i29 ? i27 : i4;
            } else {
            }
        } else {
            obj3 = horizontalArrangement;
        }
        int i30 = 256;
        if (i25 ^= 384 > i30) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i = i13 & 384 == i30 ? i27 : i4;
            } else {
            }
        } else {
            i5 = maxItemsInMainAxis;
        }
        int i31 = 2048;
        if (i26 ^= 3072 > i31) {
            if (!composer.changed(maxLines)) {
                i3 = i13 & 3072 == i31 ? i27 : i4;
            } else {
            }
        } else {
            i8 = maxLines;
        }
        Object obj4 = overflowState;
        int i37 = 196608;
        int i38 = 131072;
        if (i33 ^= i37 > i38) {
            if (!composer.changed(itemCount)) {
                i9 = i13 & i37 == i38 ? i27 : i4;
            } else {
            }
        } else {
            i6 = itemCount;
        }
        i11 = 12582912;
        spacing-D9Ej5fM = 8388608;
        if (i35 ^= i11 > spacing-D9Ej5fM) {
            if (!composer.changed(getComposable)) {
                if (i11 &= i13 == spacing-D9Ej5fM) {
                    i4 = i27;
                }
            } else {
            }
        } else {
            measurePolicy = getComposable;
        }
        Composer composer2 = $composer;
        int i28 = 0;
        rememberedValue = composer2.rememberedValue();
        final int i39 = 0;
        if (i21 |= i4 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i2 = 0;
                obj2 = obj6;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = new FlowMeasureLazyPolicy(0, obj3, obj, obj.getSpacing-D9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_START(), obj3.getSpacing-D9Ej5fM(), i6, i8, i5, obj4, overflowComposables, getComposable, 0);
                composer2.updateRememberedValue(flowMeasureLazyPolicy.getMeasurePolicy());
            } else {
                obj2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (Function2)rememberedValue;
    }

    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState, int itemCount, List<? extends Function2<? super Composer, ? super Integer, Unit>> overflowComposables, Function4<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super Composer, ? super Integer, Unit> getComposable, Composer $composer, int $changed) {
        boolean changed4;
        int i4;
        boolean traceInProgress;
        boolean changed;
        int i11;
        boolean changed3;
        int i2;
        boolean changed5;
        int i9;
        Object obj2;
        String str;
        int i8;
        boolean changed2;
        int i3;
        Object measurePolicy;
        int i12;
        Object rememberedValue;
        Object obj;
        Object obj3;
        int spacing-D9Ej5fM;
        boolean cROSS_AXIS_ALIGNMENT_TOP;
        float spacing-D9Ej5fM2;
        int i7;
        int i6;
        int i10;
        Object it$iv;
        List list;
        Function4 function4;
        int i;
        int i5;
        final Composer composer = $composer;
        final int i13 = $changed;
        int i14 = -43351224;
        ComposerKt.sourceInformationMarkerStart(composer, i14, "C(contextualRowMeasurementHelper)P(1,7,3,4,6,2,5)343@13891L847:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i13, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:342)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1138967354, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        int i23 = 4;
        i8 = 0;
        int i27 = 1;
        if (i16 ^= 6 > i23) {
            if (!composer.changed(horizontalArrangement)) {
                i4 = i13 & 6 == i23 ? i27 : i8;
            } else {
            }
        } else {
            obj = horizontalArrangement;
        }
        int i29 = 32;
        if (i24 ^= 48 > i29) {
            if (!composer.changed(verticalArrangement)) {
                i11 = i13 & 48 == i29 ? i27 : i8;
            } else {
            }
        } else {
            obj3 = verticalArrangement;
        }
        int i30 = 256;
        if (i25 ^= 384 > i30) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i2 = i13 & 384 == i30 ? i27 : i8;
            } else {
            }
        } else {
            i10 = maxItemsInMainAxis;
        }
        int i31 = 2048;
        if (i26 ^= 3072 > i31) {
            if (!composer.changed(maxLines)) {
                i9 = i13 & 3072 == i31 ? i27 : i8;
            } else {
            }
        } else {
            i6 = maxLines;
        }
        Object obj4 = overflowState;
        int i37 = 196608;
        int i38 = 131072;
        if (i33 ^= i37 > i38) {
            if (!composer.changed(itemCount)) {
                i3 = i13 & i37 == i38 ? i27 : i8;
            } else {
            }
        } else {
            i7 = itemCount;
        }
        i12 = 12582912;
        spacing-D9Ej5fM = 8388608;
        if (i35 ^= i12 > spacing-D9Ej5fM) {
            if (!composer.changed(getComposable)) {
                if (i12 &= i13 == spacing-D9Ej5fM) {
                    i8 = i27;
                }
            } else {
            }
        } else {
            measurePolicy = getComposable;
        }
        Composer composer2 = $composer;
        int i28 = 0;
        rememberedValue = composer2.rememberedValue();
        final int i39 = 0;
        if (i21 |= i8 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                obj2 = obj6;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = new FlowMeasureLazyPolicy(1, obj, obj3, obj.getSpacing-D9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_TOP(), obj3.getSpacing-D9Ej5fM(), i7, i6, i10, obj4, overflowComposables, getComposable, 0);
                composer2.updateRememberedValue(flowMeasureLazyPolicy.getMeasurePolicy());
            } else {
                obj2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (Function2)rememberedValue;
    }
}
