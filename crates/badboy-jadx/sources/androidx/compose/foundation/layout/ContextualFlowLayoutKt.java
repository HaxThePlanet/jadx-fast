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
        int i9;
        Object obj4;
        int i12;
        int traceInProgress2;
        Object $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1;
        Object contextualColumnMeasureHelper;
        int $dirty;
        int companion;
        Object overflow3;
        Object overflow2;
        int i4;
        boolean traceInProgress;
        int i5;
        int i20;
        Object obj6;
        int i10;
        int str;
        Object obj5;
        Object obj2;
        int modifier2;
        int i;
        int i17;
        int i13;
        Object obj3;
        androidx.compose.foundation.layout.ContextualFlowColumnOverflow verticalArrangement2;
        int i6;
        Composer verticalArrangement3;
        Object obj;
        int i3;
        int i7;
        int $dirty2;
        int i2;
        int i18;
        Object $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1;
        int i14;
        int i8;
        int arrayList;
        ArrayList i16;
        int i19;
        androidx.compose.runtime.internal.ComposableLambda i15;
        Object companion2;
        int i21;
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
            i4 = itemCount;
        } else {
            if (i57 & 6 == 0) {
                i10 = contextualColumnMeasureHelper.changed(itemCount) ? 4 : 2;
                $dirty |= i10;
            } else {
                i4 = itemCount;
            }
        }
        str = i58 & 2;
        if (str != null) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i57 & 48 == 0) {
                i = contextualColumnMeasureHelper.changed(modifier) ? 32 : 16;
                $dirty |= i;
            } else {
                obj2 = modifier;
            }
        }
        i17 = i58 & 4;
        if (i17 != 0) {
            $dirty |= 384;
            obj3 = verticalArrangement;
        } else {
            if (i57 & 384 == 0) {
                i6 = contextualColumnMeasureHelper.changed(verticalArrangement) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj3 = verticalArrangement;
            }
        }
        int i59 = i58 & 8;
        if (i59 != 0) {
            $dirty |= 3072;
            obj = horizontalArrangement;
        } else {
            if (i57 & 3072 == 0) {
                i3 = contextualColumnMeasureHelper.changed(horizontalArrangement) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                obj = horizontalArrangement;
            }
        }
        i7 = i58 & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            i2 = maxItemsInEachColumn;
        } else {
            if (i57 & 24576 == 0) {
                i18 = contextualColumnMeasureHelper.changed(maxItemsInEachColumn) ? 16384 : 8192;
                $dirty |= i18;
            } else {
                i2 = maxItemsInEachColumn;
            }
        }
        $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1 = i58 & 32;
        i14 = 196608;
        if ($i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1 != 0) {
            $dirty |= i14;
            i9 = maxLines;
        } else {
            if (i57 & i14 == 0) {
                i8 = contextualColumnMeasureHelper.changed(maxLines) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                i9 = maxLines;
            }
        }
        i16 = i58 & 64;
        i19 = 1572864;
        if (i16 != 0) {
            $dirty |= i19;
            obj4 = overflow;
        } else {
            if (i57 & i19 == 0) {
                i19 = contextualColumnMeasureHelper.changed(overflow) ? 1048576 : 524288;
                $dirty |= i19;
            } else {
                obj4 = overflow;
            }
        }
        i15 = 12582912;
        if (i58 & 128 != 0) {
            $dirty |= i15;
        } else {
            if (i57 & i15 == 0) {
                i12 = contextualColumnMeasureHelper.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i12;
            }
        }
        traceInProgress2 = $dirty;
        if ($dirty4 &= traceInProgress2 == 4793490) {
            if (!contextualColumnMeasureHelper.getSkipping()) {
                if (str != null) {
                    obj2 = companion;
                }
                if (i17 != 0) {
                    obj3 = companion;
                }
                if (i59 != 0) {
                    obj = companion;
                }
                i7 = i7 != 0 ? companion : i2;
                i2 = $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1 != 0 ? companion : maxLines;
                if (i16 != 0) {
                    overflow3 = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    overflow3 = overflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, traceInProgress2, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                String str3 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(contextualColumnMeasureHelper, -1055927072, str3);
                int i28 = 3670016;
                i5 = traceInProgress2 & i28 == 1048576 ? 1 : 0;
                Composer composer2 = contextualColumnMeasureHelper;
                int i63 = 0;
                Object rememberedValue = composer2.rememberedValue();
                arrayList = 0;
                if (i5 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i62 = 0;
                        composer2.updateRememberedValue(overflow3.createOverflowState$foundation_layout_release());
                    } else {
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(contextualColumnMeasureHelper);
                ComposerKt.sourceInformationMarkerStart(contextualColumnMeasureHelper, -1055923392, str3);
                i20 = traceInProgress2 & obj22 == 1048576 ? 1 : 0;
                Composer composer = contextualColumnMeasureHelper;
                int i53 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i64 = 0;
                if (i20 == 0) {
                    obj29 = traceInProgress2;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj22 = $dirty3;
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1 = arrayList;
                        overflow3.addOverflowComposables$foundation_layout_release((FlowLayoutOverflowState)$i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1, (List)$i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1);
                        composer.updateRememberedValue($i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1);
                    } else {
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1 = rememberedValue2;
                    }
                } else {
                    obj29 = traceInProgress2;
                }
                ComposerKt.sourceInformationMarkerEnd(contextualColumnMeasureHelper);
                ContextualFlowLayoutKt.ContextualFlowColumn.measurePolicy.1 anon = new ContextualFlowLayoutKt.ContextualFlowColumn.measurePolicy.1(obj8);
                companion2 = contextualColumnMeasureHelper;
                SubcomposeLayoutKt.SubcomposeLayout(obj2, ContextualFlowLayoutKt.contextualColumnMeasureHelper(obj3, obj, i7, i2, $i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$overflowState$1, itemCount, (List)$i$a$CacheContextualFlowLayoutKt$ContextualFlowColumn$list$1, (Function4)ComposableLambdaKt.rememberComposableLambda(302435318, true, anon, contextualColumnMeasureHelper, 54), companion2, i38 | i50), companion2, i39 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj3;
                i13 = i2;
                verticalArrangement2 = overflow3;
                overflow2 = obj2;
                modifier2 = i7;
                obj5 = obj;
            } else {
                contextualColumnMeasureHelper.skipToGroupEnd();
                i13 = maxLines;
                obj29 = traceInProgress2;
                verticalArrangement3 = contextualColumnMeasureHelper;
                overflow2 = obj2;
                obj6 = obj3;
                modifier2 = i2;
                verticalArrangement2 = overflow;
                obj5 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = verticalArrangement3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj29;
            traceInProgress2 = new ContextualFlowLayoutKt.ContextualFlowColumn.1(itemCount, overflow2, obj6, obj5, modifier2, i13, verticalArrangement2, obj8, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty2 = obj29;
        }
    }

    public static final void ContextualFlowRow(int itemCount, Modifier modifier, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, int maxLines, androidx.compose.foundation.layout.ContextualFlowRowOverflow overflow, Function4<? super androidx.compose.foundation.layout.ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i12;
        Object obj5;
        int i8;
        int traceInProgress;
        Object $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1;
        Object contextualRowMeasurementHelper;
        int $dirty;
        int companion2;
        Object overflow2;
        Object overflow3;
        int i20;
        boolean traceInProgress2;
        int i14;
        int i2;
        Object obj2;
        int i4;
        int str;
        Object obj6;
        Object obj3;
        int modifier2;
        int i15;
        int i7;
        int i13;
        Object obj;
        androidx.compose.foundation.layout.ContextualFlowRowOverflow horizontalArrangement3;
        int i16;
        Composer horizontalArrangement2;
        Object obj4;
        int i21;
        int i18;
        int $dirty2;
        int i5;
        int i10;
        Object $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1;
        int i;
        int i3;
        int arrayList;
        ArrayList i9;
        int i6;
        androidx.compose.runtime.internal.ComposableLambda i17;
        Object companion;
        int i19;
        int obj22;
        int obj29;
        final Object obj8 = content;
        final int i57 = $changed;
        final int i58 = i11;
        contextualRowMeasurementHelper = $composer.startRestartGroup(-341770689);
        ComposerKt.sourceInformation(contextualRowMeasurementHelper, "C(ContextualFlowRow)P(2,5,1,7,3,4,6)74@3434L65,77@3545L193,90@3961L267,82@3763L465,99@4233L90:ContextualFlowLayout.kt#2w3rfo");
        $dirty = $changed;
        if (i58 & 1 != 0) {
            $dirty |= 6;
            i20 = itemCount;
        } else {
            if (i57 & 6 == 0) {
                i4 = contextualRowMeasurementHelper.changed(itemCount) ? 4 : 2;
                $dirty |= i4;
            } else {
                i20 = itemCount;
            }
        }
        str = i58 & 2;
        if (str != null) {
            $dirty |= 48;
            obj3 = modifier;
        } else {
            if (i57 & 48 == 0) {
                i15 = contextualRowMeasurementHelper.changed(modifier) ? 32 : 16;
                $dirty |= i15;
            } else {
                obj3 = modifier;
            }
        }
        i7 = i58 & 4;
        if (i7 != 0) {
            $dirty |= 384;
            obj = horizontalArrangement;
        } else {
            if (i57 & 384 == 0) {
                i16 = contextualRowMeasurementHelper.changed(horizontalArrangement) ? 256 : 128;
                $dirty |= i16;
            } else {
                obj = horizontalArrangement;
            }
        }
        int i59 = i58 & 8;
        if (i59 != 0) {
            $dirty |= 3072;
            obj4 = verticalArrangement;
        } else {
            if (i57 & 3072 == 0) {
                i21 = contextualRowMeasurementHelper.changed(verticalArrangement) ? 2048 : 1024;
                $dirty |= i21;
            } else {
                obj4 = verticalArrangement;
            }
        }
        i18 = i58 & 16;
        if (i18 != 0) {
            $dirty |= 24576;
            i5 = maxItemsInEachRow;
        } else {
            if (i57 & 24576 == 0) {
                i10 = contextualRowMeasurementHelper.changed(maxItemsInEachRow) ? 16384 : 8192;
                $dirty |= i10;
            } else {
                i5 = maxItemsInEachRow;
            }
        }
        $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1 = i58 & 32;
        i = 196608;
        if ($i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1 != 0) {
            $dirty |= i;
            i12 = maxLines;
        } else {
            if (i57 & i == 0) {
                i3 = contextualRowMeasurementHelper.changed(maxLines) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                i12 = maxLines;
            }
        }
        i9 = i58 & 64;
        i6 = 1572864;
        if (i9 != 0) {
            $dirty |= i6;
            obj5 = overflow;
        } else {
            if (i57 & i6 == 0) {
                i6 = contextualRowMeasurementHelper.changed(overflow) ? 1048576 : 524288;
                $dirty |= i6;
            } else {
                obj5 = overflow;
            }
        }
        i17 = 12582912;
        if (i58 & 128 != 0) {
            $dirty |= i17;
        } else {
            if (i57 & i17 == 0) {
                i8 = contextualRowMeasurementHelper.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty |= i8;
            }
        }
        traceInProgress = $dirty;
        if ($dirty4 &= traceInProgress == 4793490) {
            if (!contextualRowMeasurementHelper.getSkipping()) {
                if (str != null) {
                    obj3 = companion2;
                }
                if (i7 != 0) {
                    obj = companion2;
                }
                if (i59 != 0) {
                    obj4 = companion2;
                }
                i18 = i18 != 0 ? companion2 : i5;
                i5 = $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1 != 0 ? companion2 : maxLines;
                if (i9 != 0) {
                    overflow2 = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    overflow2 = overflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, traceInProgress, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                String str3 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(contextualRowMeasurementHelper, 1235053714, str3);
                int i28 = 3670016;
                i14 = traceInProgress & i28 == 1048576 ? 1 : 0;
                Composer composer2 = contextualRowMeasurementHelper;
                int i63 = 0;
                Object rememberedValue = composer2.rememberedValue();
                arrayList = 0;
                if (i14 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i62 = 0;
                        composer2.updateRememberedValue(overflow2.createOverflowState$foundation_layout_release());
                    } else {
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(contextualRowMeasurementHelper);
                ComposerKt.sourceInformationMarkerStart(contextualRowMeasurementHelper, 1235057394, str3);
                i2 = traceInProgress & obj22 == 1048576 ? 1 : 0;
                Composer composer = contextualRowMeasurementHelper;
                int i53 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i64 = 0;
                if (i2 == 0) {
                    obj29 = traceInProgress;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj22 = $dirty3;
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1 = arrayList;
                        overflow2.addOverflowComposables$foundation_layout_release((FlowLayoutOverflowState)$i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1, (List)$i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1);
                        composer.updateRememberedValue($i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1);
                    } else {
                        $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1 = rememberedValue2;
                    }
                } else {
                    obj29 = traceInProgress;
                }
                ComposerKt.sourceInformationMarkerEnd(contextualRowMeasurementHelper);
                ContextualFlowLayoutKt.ContextualFlowRow.measurePolicy.1 anon = new ContextualFlowLayoutKt.ContextualFlowRow.measurePolicy.1(obj8);
                companion = contextualRowMeasurementHelper;
                SubcomposeLayoutKt.SubcomposeLayout(obj3, ContextualFlowLayoutKt.contextualRowMeasurementHelper(obj, obj4, i18, i5, $i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$overflowState$1, itemCount, (List)$i$a$CacheContextualFlowLayoutKt$ContextualFlowRow$list$1, (Function4)ComposableLambdaKt.rememberComposableLambda(-8464804, true, anon, contextualRowMeasurementHelper, 54), companion, i38 | i50), companion, i39 &= 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                i13 = i5;
                horizontalArrangement3 = overflow2;
                overflow3 = obj3;
                modifier2 = i18;
                obj6 = obj4;
            } else {
                contextualRowMeasurementHelper.skipToGroupEnd();
                i13 = maxLines;
                obj29 = traceInProgress;
                horizontalArrangement2 = contextualRowMeasurementHelper;
                overflow3 = obj3;
                obj2 = obj;
                modifier2 = i5;
                horizontalArrangement3 = overflow;
                obj6 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = horizontalArrangement2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj29;
            traceInProgress = new ContextualFlowLayoutKt.ContextualFlowRow.1(itemCount, overflow3, obj2, obj6, modifier2, i13, horizontalArrangement3, obj8, i57, i58);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj29;
        }
    }

    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState, int itemCount, List<? extends Function2<? super Composer, ? super Integer, Unit>> overflowComposables, Function4<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? super Composer, ? super Integer, Unit> getComposable, Composer $composer, int $changed) {
        boolean changed3;
        int i9;
        boolean traceInProgress;
        boolean changed2;
        int i2;
        boolean changed;
        int i4;
        boolean changed4;
        int i6;
        Object obj3;
        String str;
        int i8;
        boolean changed5;
        int i3;
        Object measurePolicy;
        int i12;
        Object rememberedValue;
        Object obj2;
        Object obj;
        int spacing-D9Ej5fM2;
        boolean cROSS_AXIS_ALIGNMENT_START;
        float spacing-D9Ej5fM;
        int i10;
        int i7;
        int i11;
        Object it$iv;
        List list;
        Function4 function4;
        int i;
        int i5;
        final Composer composer = $composer;
        final int i13 = $changed;
        int i14 = 1009762916;
        ComposerKt.sourceInformationMarkerStart(composer, i14, "C(contextualColumnMeasureHelper)P(7,1,3,4,6,2,5)383@15228L850:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i13, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:382)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1978242771, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        int i23 = 4;
        i8 = 0;
        int i27 = 1;
        if (i16 ^= 6 > i23) {
            if (!composer.changed(verticalArrangement)) {
                i9 = i13 & 6 == i23 ? i27 : i8;
            } else {
            }
        } else {
            obj = verticalArrangement;
        }
        int i29 = 32;
        if (i24 ^= 48 > i29) {
            if (!composer.changed(horizontalArrangement)) {
                i2 = i13 & 48 == i29 ? i27 : i8;
            } else {
            }
        } else {
            obj2 = horizontalArrangement;
        }
        int i30 = 256;
        if (i25 ^= 384 > i30) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i4 = i13 & 384 == i30 ? i27 : i8;
            } else {
            }
        } else {
            i11 = maxItemsInMainAxis;
        }
        int i31 = 2048;
        if (i26 ^= 3072 > i31) {
            if (!composer.changed(maxLines)) {
                i6 = i13 & 3072 == i31 ? i27 : i8;
            } else {
            }
        } else {
            i7 = maxLines;
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
            i10 = itemCount;
        }
        i12 = 12582912;
        spacing-D9Ej5fM2 = 8388608;
        if (i35 ^= i12 > spacing-D9Ej5fM2) {
            if (!composer.changed(getComposable)) {
                if (i12 &= i13 == spacing-D9Ej5fM2) {
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
                obj3 = obj6;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = new FlowMeasureLazyPolicy(0, obj2, obj, obj.getSpacing-D9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_START(), obj2.getSpacing-D9Ej5fM(), i10, i7, i11, obj4, overflowComposables, getComposable, 0);
                composer2.updateRememberedValue(flowMeasureLazyPolicy.getMeasurePolicy());
            } else {
                obj3 = rememberedValue;
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
        boolean changed3;
        int i2;
        boolean traceInProgress;
        boolean changed4;
        int i;
        boolean changed2;
        int i5;
        boolean changed5;
        int i8;
        Object obj;
        String str;
        int i9;
        boolean changed;
        int i3;
        Object measurePolicy;
        int i10;
        Object rememberedValue;
        Object obj2;
        Object obj3;
        int spacing-D9Ej5fM2;
        boolean cROSS_AXIS_ALIGNMENT_TOP;
        float spacing-D9Ej5fM;
        int i6;
        int i11;
        int i4;
        Object it$iv;
        List list;
        Function4 function4;
        int i12;
        int i7;
        final Composer composer = $composer;
        final int i13 = $changed;
        int i14 = -43351224;
        ComposerKt.sourceInformationMarkerStart(composer, i14, "C(contextualRowMeasurementHelper)P(1,7,3,4,6,2,5)343@13891L847:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i13, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:342)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1138967354, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        int i23 = 4;
        i9 = 0;
        int i27 = 1;
        if (i16 ^= 6 > i23) {
            if (!composer.changed(horizontalArrangement)) {
                i2 = i13 & 6 == i23 ? i27 : i9;
            } else {
            }
        } else {
            obj2 = horizontalArrangement;
        }
        int i29 = 32;
        if (i24 ^= 48 > i29) {
            if (!composer.changed(verticalArrangement)) {
                i = i13 & 48 == i29 ? i27 : i9;
            } else {
            }
        } else {
            obj3 = verticalArrangement;
        }
        int i30 = 256;
        if (i25 ^= 384 > i30) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i5 = i13 & 384 == i30 ? i27 : i9;
            } else {
            }
        } else {
            i4 = maxItemsInMainAxis;
        }
        int i31 = 2048;
        if (i26 ^= 3072 > i31) {
            if (!composer.changed(maxLines)) {
                i8 = i13 & 3072 == i31 ? i27 : i9;
            } else {
            }
        } else {
            i11 = maxLines;
        }
        Object obj4 = overflowState;
        int i37 = 196608;
        int i38 = 131072;
        if (i33 ^= i37 > i38) {
            if (!composer.changed(itemCount)) {
                i3 = i13 & i37 == i38 ? i27 : i9;
            } else {
            }
        } else {
            i6 = itemCount;
        }
        i10 = 12582912;
        spacing-D9Ej5fM2 = 8388608;
        if (i35 ^= i10 > spacing-D9Ej5fM2) {
            if (!composer.changed(getComposable)) {
                if (i10 &= i13 == spacing-D9Ej5fM2) {
                    i9 = i27;
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
        if (i21 |= i9 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i7 = 0;
                obj = obj6;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = new FlowMeasureLazyPolicy(1, obj2, obj3, obj2.getSpacing-D9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_TOP(), obj3.getSpacing-D9Ej5fM(), i6, i11, i4, obj4, overflowComposables, getComposable, 0);
                composer2.updateRememberedValue(flowMeasureLazyPolicy.getMeasurePolicy());
            } else {
                obj = rememberedValue;
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
