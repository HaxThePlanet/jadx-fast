package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPosition.Start;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132%\u0008\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\u0008#¢\u0006\u0002\u0008$H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001aâ\u0001\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132%\u0008\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\u0008#¢\u0006\u0002\u0008$H\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a\u0017\u0010,\u001a\u00020\u00012\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.H\u0082\u0008\u001aL\u00100\u001a\u00020\u000b*\u00020\u001e2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000bH\u0000\u001a,\u00109\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006=", d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerKt {
    public static final void HorizontalPager-oI3XNZo(androidx.compose.foundation.pager.PagerState state, Modifier modifier, PaddingValues contentPadding, androidx.compose.foundation.pager.PageSize pageSize, int beyondViewportPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, SnapPosition snapPosition, Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i18) {
        int $dirty;
        Object obj9;
        int $dirty16;
        Object $dirty15;
        Object flingBehavior2;
        Object endRestartGroup;
        Object obj;
        int traceInProgress;
        int $this$dp$iv;
        Object $dirty12;
        int i20;
        boolean z;
        boolean z2;
        Object obj2;
        int i6;
        int userScrollEnabled3;
        Object userScrollEnabled2;
        Object contentPadding2;
        int i25;
        int i4;
        int reverseLayout3;
        Object reverseLayout2;
        Object obj8;
        int key3;
        int key2;
        Object obj5;
        Object obj10;
        Object pageNestedScrollConnection4;
        Object pageNestedScrollConnection2;
        int flingBehavior3;
        int $composer2;
        float $composer3;
        int i16;
        Object beyondViewportPageCount2;
        float f;
        Object pageSpacing2;
        Object obj3;
        int pageSize2;
        NestedScrollConnection connection;
        int pageNestedScrollConnection3;
        int obj13;
        Object obj7;
        int i23;
        Object obj4;
        Object obj6;
        Object modifier2;
        Object verticalAlignment2;
        int i7;
        Object obj11;
        Object contentPadding3;
        Object obj12;
        boolean traceInProgress2;
        int changedInstance;
        int $dirty13;
        Composer $dirty14;
        int i21;
        Object i3;
        int i17;
        Composer composer;
        float i22;
        int i;
        int $dirty1;
        int i9;
        int i10;
        int changed2;
        int i13;
        int i5;
        int i24;
        int i14;
        int i11;
        int changed;
        int i12;
        int i15;
        int i2;
        int i19;
        int i8;
        int $dirty2;
        int changedInstance2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj36;
        int obj37;
        int obj38;
        int i64 = $changed;
        int i65 = $changed1;
        int i66 = i18;
        Composer restartGroup = $composer.startRestartGroup(1870896258);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalPager)P(11,4,1,7!1,8:c#ui.unit.Dp,13!1,12,9!1,6,10)114@6534L28,118@6750L79,125@6952L661:Pager.kt#g6yjnt");
        $dirty = $changed;
        if (i66 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i64 & 6 == 0) {
                i25 = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i25;
            }
        }
        i4 = i66 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i64 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj6 = modifier;
            }
        }
        contentPadding3 = i66 & 4;
        if (contentPadding3 != 0) {
            $dirty |= 384;
            obj8 = contentPadding;
        } else {
            if (i64 & 384 == 0) {
                i21 = restartGroup.changed(contentPadding) ? 256 : changedInstance;
                $dirty |= i21;
            } else {
                obj8 = contentPadding;
            }
        }
        i3 = i66 & 8;
        i22 = 2048;
        if (i3 != 0) {
            $dirty |= 3072;
            obj10 = pageSize;
        } else {
            if (i64 & 3072 == 0) {
                i10 = restartGroup.changed(pageSize) ? i22 : i17;
                $dirty |= i10;
            } else {
                obj10 = pageSize;
            }
        }
        int i98 = i66 & 16;
        if (i98 != 0) {
            $dirty |= 24576;
            i16 = beyondViewportPageCount;
        } else {
            if (i64 & 24576 == 0) {
                i13 = restartGroup.changed(beyondViewportPageCount) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                i16 = beyondViewportPageCount;
            }
        }
        int i99 = i66 & 32;
        final int i100 = 196608;
        if (i99 != 0) {
            $dirty |= i100;
            f = pageSpacing;
        } else {
            if (i64 & i100 == 0) {
                i24 = restartGroup.changed(pageSpacing) ? 131072 : 65536;
                $dirty |= i24;
            } else {
                f = pageSpacing;
            }
        }
        int i101 = i66 & 64;
        i14 = 1572864;
        if (i101 != 0) {
            $dirty |= i14;
            obj12 = verticalAlignment;
        } else {
            if (i64 & i14 == 0) {
                i11 = restartGroup.changed(verticalAlignment) ? 1048576 : 524288;
                $dirty |= i11;
            } else {
                obj12 = verticalAlignment;
            }
        }
        if (i64 & i102 == 0) {
            if (i66 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj7 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj7 = flingBehavior;
        }
        int i104 = i54;
        int $dirty110 = i66 & 256;
        int i105 = 100663296;
        if ($dirty110 != 0) {
            $dirty |= i105;
            i15 = $dirty110;
            z = userScrollEnabled;
        } else {
            if (i64 & i105 == 0) {
                i15 = $dirty110;
                i2 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty |= i2;
            } else {
                i15 = $dirty110;
                z = userScrollEnabled;
            }
        }
        int i55 = i66 & 512;
        int i107 = 805306368;
        if (i55 != 0) {
            $dirty2 = $dirty;
            i19 = i55;
            z2 = reverseLayout;
        } else {
            if (i64 & i107 == 0) {
                i19 = i55;
                i8 = restartGroup.changed(reverseLayout) ? 536870912 : 268435456;
                $dirty |= i8;
            } else {
                i19 = i55;
                z2 = reverseLayout;
            }
            $dirty2 = $dirty;
        }
        int $dirty3 = i66 & 1024;
        if ($dirty3 != 0) {
            $dirty1 = i104 | 6;
            obj2 = key;
        } else {
        }
        if (i65 & 48 == 0) {
            i12 = $dirty3;
            if (i66 & 2048 == 0) {
                changed2 = restartGroup.changedInstance(pageNestedScrollConnection) ? 32 : 16;
            } else {
                obj9 = pageNestedScrollConnection;
            }
            $dirty1 |= changed2;
        } else {
            i12 = $dirty3;
            obj9 = pageNestedScrollConnection;
        }
        int i26 = $dirty1;
        int i56 = i66 & 4096;
        if (i56 != 0) {
            i26 |= 384;
        } else {
            $dirty1 = i26;
            if (i65 & 384 == 0) {
                if (restartGroup.changed(snapPosition)) {
                    changedInstance = 256;
                }
                $dirty16 = changedInstance;
            } else {
                Object obj16 = snapPosition;
                $dirty16 = $dirty1;
            }
        }
        if (i66 & 8192 != 0) {
            $dirty16 |= 3072;
            obj = pageContent;
        } else {
            if (i65 & 3072 == 0) {
                if (restartGroup.changedInstance(pageContent)) {
                    i17 = i22;
                }
                $dirty16 |= i17;
            } else {
                obj = pageContent;
            }
        }
        $dirty14 = i56;
        if ($dirty2 & i70 == 306783378 && $dirty16 & 1171 == 1170) {
            if ($dirty16 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i64 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i4 != 0) {
                                obj6 = $this$dp$iv;
                            }
                            if (contentPadding3 != 0) {
                                i6 = 0;
                                obj11 = $this$dp$iv;
                            } else {
                                obj11 = obj8;
                            }
                            if (i3 != 0) {
                                i3 = $this$dp$iv;
                            } else {
                                i3 = obj10;
                            }
                            i17 = i98 != 0 ? $this$dp$iv : i16;
                            if (i99 != 0) {
                                i6 = 0;
                                i22 = $this$dp$iv;
                            } else {
                                i22 = f;
                            }
                            if (i101 != 0) {
                                obj12 = $this$dp$iv;
                            }
                            if (i66 & 128 != 0) {
                                $dirty1 = $dirty14;
                                $dirty13 = i49;
                                $dirty15 = PagerDefaults.INSTANCE.flingBehavior(state, 0, 0, 0, 0, restartGroup, i57 | i100, 30);
                                $dirty2 &= i6;
                            } else {
                                $dirty12 = state;
                                $dirty1 = $dirty14;
                                $dirty13 = $dirty16;
                                $dirty15 = obj7;
                            }
                            userScrollEnabled3 = i15 != 0 ? 1 : userScrollEnabled;
                            reverseLayout3 = i19 != 0 ? 0 : reverseLayout;
                            key3 = i12 != 0 ? 0 : key;
                            if (i66 & 2048 != 0) {
                                pageNestedScrollConnection4 = PagerDefaults.INSTANCE.pageNestedScrollConnection($dirty12, Orientation.Horizontal, restartGroup, i63 |= 432);
                                $dirty13 = i16;
                            } else {
                                pageNestedScrollConnection4 = pageNestedScrollConnection;
                            }
                            if ($dirty1 != 0) {
                                obj13 = key3;
                                connection = pageNestedScrollConnection4;
                                key2 = $dirty13;
                                obj3 = i3;
                                f = i22;
                                i23 = $dirty2;
                                pageNestedScrollConnection2 = $dirty15;
                                $dirty14 = restartGroup;
                                flingBehavior2 = obj6;
                                modifier2 = obj12;
                                $composer2 = userScrollEnabled3;
                                userScrollEnabled2 = obj11;
                                contentPadding3 = iNSTANCE2;
                                i16 = i17;
                            } else {
                                obj13 = key3;
                                connection = pageNestedScrollConnection4;
                                key2 = $dirty13;
                                obj3 = i3;
                                i16 = i17;
                                f = i22;
                                i23 = $dirty2;
                                pageNestedScrollConnection2 = $dirty15;
                                $dirty14 = restartGroup;
                                flingBehavior2 = obj6;
                                modifier2 = obj12;
                                $composer2 = userScrollEnabled3;
                                userScrollEnabled2 = obj11;
                                contentPadding3 = snapPosition;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i66 & 128 != 0) {
                                $dirty2 &= i20;
                            }
                            if (i66 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            $dirty12 = state;
                            reverseLayout3 = reverseLayout;
                            obj13 = key;
                            connection = pageNestedScrollConnection;
                            contentPadding3 = snapPosition;
                            userScrollEnabled2 = obj8;
                            obj3 = obj10;
                            $dirty14 = restartGroup;
                            pageNestedScrollConnection2 = obj7;
                            i23 = $dirty2;
                            $composer2 = userScrollEnabled;
                            key2 = $dirty16;
                            flingBehavior2 = obj6;
                            modifier2 = obj12;
                        }
                    } else {
                    }
                    $dirty14.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj36 = flingBehavior2;
                        ComposerKt.traceEventStart(1870896258, i23, key2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)");
                    } else {
                        obj36 = flingBehavior2;
                    }
                    obj37 = modifier3;
                    $dirty16 = obj36;
                    i9 = obj37;
                    $dirty2 = i23;
                    LazyLayoutPagerKt.Pager-uYRUAWA($dirty16, $dirty12, userScrollEnabled2, reverseLayout3, Orientation.Horizontal, pageNestedScrollConnection2, $composer2, i16, f, obj3, connection, obj13, Alignment.Companion.getCenterHorizontally(), modifier2, contentPadding3, pageContent, $dirty14, i37 | i83, i45 | i94, 0);
                    composer = $dirty14;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj3;
                    obj4 = connection;
                    pageNestedScrollConnection3 = reverseLayout3;
                    pageSize2 = $composer2;
                    $composer3 = f;
                    reverseLayout2 = userScrollEnabled2;
                    pageSpacing2 = pageNestedScrollConnection2;
                    flingBehavior3 = i16;
                    beyondViewportPageCount2 = modifier2;
                    verticalAlignment2 = contentPadding3;
                    contentPadding2 = $dirty16;
                } else {
                    restartGroup.skipToGroupEnd();
                    pageSize2 = userScrollEnabled;
                    pageNestedScrollConnection3 = reverseLayout;
                    obj13 = key;
                    i9 = $dirty16;
                    reverseLayout2 = obj8;
                    obj5 = obj10;
                    composer = restartGroup;
                    flingBehavior3 = i16;
                    $composer3 = f;
                    pageSpacing2 = obj7;
                    contentPadding2 = obj6;
                    beyondViewportPageCount2 = obj12;
                    obj4 = pageNestedScrollConnection;
                    verticalAlignment2 = snapPosition;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new PagerKt.HorizontalPager.1(state, contentPadding2, reverseLayout2, obj5, flingBehavior3, $composer3, beyondViewportPageCount2, pageSpacing2, pageSize2, pageNestedScrollConnection3, obj13, obj4, verticalAlignment2, pageContent, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void VerticalPager-oI3XNZo(androidx.compose.foundation.pager.PagerState state, Modifier modifier, PaddingValues contentPadding, androidx.compose.foundation.pager.PageSize pageSize, int beyondViewportPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, SnapPosition snapPosition, Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i18) {
        int $dirty2;
        Object obj2;
        int $dirty16;
        Object $dirty14;
        Object flingBehavior2;
        Object endRestartGroup;
        Object obj13;
        int traceInProgress2;
        int $this$dp$iv;
        Object $dirty15;
        int i24;
        boolean z;
        boolean z2;
        Object obj;
        int i19;
        int userScrollEnabled2;
        Object userScrollEnabled3;
        Object contentPadding2;
        int i10;
        int i;
        int reverseLayout3;
        Object reverseLayout2;
        Object obj5;
        int key3;
        int key2;
        Object obj3;
        Object obj6;
        Object pageNestedScrollConnection4;
        Object pageNestedScrollConnection3;
        int flingBehavior3;
        int $composer2;
        float $composer3;
        int i23;
        Object beyondViewportPageCount2;
        float f;
        Object pageSpacing2;
        Object obj14;
        int pageSize2;
        NestedScrollConnection connection;
        int pageNestedScrollConnection2;
        int obj11;
        Object obj9;
        Object obj12;
        Object horizontalAlignment2;
        Object obj8;
        int modifier2;
        Object obj4;
        int i13;
        Object obj7;
        Object contentPadding3;
        Object obj10;
        boolean traceInProgress;
        int changedInstance;
        int $dirty13;
        Composer $dirty1;
        int i21;
        Object i22;
        int i3;
        Composer composer;
        float i7;
        int i11;
        int $dirty12;
        int i9;
        int i15;
        int changed;
        int i4;
        int i20;
        int i16;
        int i8;
        int i5;
        int changed2;
        int i12;
        int i14;
        int i17;
        int i6;
        int i2;
        int $dirty;
        int changedInstance2;
        ScopeUpdateScope scopeUpdateScope;
        Object obj36;
        int obj37;
        int obj38;
        int i63 = $changed;
        int i64 = $changed1;
        int i65 = i18;
        Composer restartGroup = $composer.startRestartGroup(909160706);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalPager)P(12,5,1,8!1,9:c#ui.unit.Dp,3!1,13,10!1,7,11)201@11541L28,205@11757L77,212@11957L659:Pager.kt#g6yjnt");
        $dirty2 = $changed;
        if (i65 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i63 & 6 == 0) {
                i10 = restartGroup.changed(state) ? 4 : 2;
                $dirty2 |= i10;
            }
        }
        i = i65 & 2;
        if (i != 0) {
            $dirty2 |= 48;
            obj8 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i13 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i13;
            } else {
                obj8 = modifier;
            }
        }
        contentPadding3 = i65 & 4;
        if (contentPadding3 != 0) {
            $dirty2 |= 384;
            obj5 = contentPadding;
        } else {
            if (i63 & 384 == 0) {
                i21 = restartGroup.changed(contentPadding) ? 256 : changedInstance;
                $dirty2 |= i21;
            } else {
                obj5 = contentPadding;
            }
        }
        i22 = i65 & 8;
        i7 = 2048;
        if (i22 != 0) {
            $dirty2 |= 3072;
            obj6 = pageSize;
        } else {
            if (i63 & 3072 == 0) {
                i15 = restartGroup.changed(pageSize) ? i7 : i3;
                $dirty2 |= i15;
            } else {
                obj6 = pageSize;
            }
        }
        int i97 = i65 & 16;
        if (i97 != 0) {
            $dirty2 |= 24576;
            i23 = beyondViewportPageCount;
        } else {
            if (i63 & 24576 == 0) {
                i4 = restartGroup.changed(beyondViewportPageCount) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                i23 = beyondViewportPageCount;
            }
        }
        int i98 = i65 & 32;
        final int i99 = 196608;
        if (i98 != 0) {
            $dirty2 |= i99;
            f = pageSpacing;
        } else {
            if (i63 & i99 == 0) {
                i16 = restartGroup.changed(pageSpacing) ? 131072 : 65536;
                $dirty2 |= i16;
            } else {
                f = pageSpacing;
            }
        }
        int i100 = i65 & 64;
        i8 = 1572864;
        if (i100 != 0) {
            $dirty2 |= i8;
            obj10 = horizontalAlignment;
        } else {
            if (i63 & i8 == 0) {
                i5 = restartGroup.changed(horizontalAlignment) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj10 = horizontalAlignment;
            }
        }
        if (i63 & i101 == 0) {
            if (i65 & 128 == 0) {
                changed2 = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj9 = flingBehavior;
            }
            $dirty2 |= changed2;
        } else {
            obj9 = flingBehavior;
        }
        int i103 = i53;
        int $dirty110 = i65 & 256;
        int i104 = 100663296;
        if ($dirty110 != 0) {
            $dirty2 |= i104;
            i14 = $dirty110;
            z = userScrollEnabled;
        } else {
            if (i63 & i104 == 0) {
                i14 = $dirty110;
                i17 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i14 = $dirty110;
                z = userScrollEnabled;
            }
        }
        int i54 = i65 & 512;
        int i106 = 805306368;
        if (i54 != 0) {
            $dirty = $dirty2;
            i6 = i54;
            z2 = reverseLayout;
        } else {
            if (i63 & i106 == 0) {
                i6 = i54;
                i2 = restartGroup.changed(reverseLayout) ? 536870912 : 268435456;
                $dirty2 |= i2;
            } else {
                i6 = i54;
                z2 = reverseLayout;
            }
            $dirty = $dirty2;
        }
        int $dirty3 = i65 & 1024;
        if ($dirty3 != 0) {
            $dirty12 = i103 | 6;
            obj = key;
        } else {
        }
        if (i64 & 48 == 0) {
            i12 = $dirty3;
            if (i65 & 2048 == 0) {
                changed = restartGroup.changedInstance(pageNestedScrollConnection) ? 32 : 16;
            } else {
                obj2 = pageNestedScrollConnection;
            }
            $dirty12 |= changed;
        } else {
            i12 = $dirty3;
            obj2 = pageNestedScrollConnection;
        }
        int i25 = $dirty12;
        int i55 = i65 & 4096;
        if (i55 != 0) {
            i25 |= 384;
        } else {
            $dirty12 = i25;
            if (i64 & 384 == 0) {
                if (restartGroup.changed(snapPosition)) {
                    changedInstance = 256;
                }
                $dirty16 = changedInstance;
            } else {
                Object obj17 = snapPosition;
                $dirty16 = $dirty12;
            }
        }
        if (i65 & 8192 != 0) {
            $dirty16 |= 3072;
            obj13 = pageContent;
        } else {
            if (i64 & 3072 == 0) {
                if (restartGroup.changedInstance(pageContent)) {
                    i3 = i7;
                }
                $dirty16 |= i3;
            } else {
                obj13 = pageContent;
            }
        }
        $dirty1 = i55;
        if ($dirty & i69 == 306783378 && $dirty16 & 1171 == 1170) {
            if ($dirty16 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i63 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i != 0) {
                                obj8 = $this$dp$iv;
                            }
                            if (contentPadding3 != 0) {
                                i19 = 0;
                                obj7 = $this$dp$iv;
                            } else {
                                obj7 = obj5;
                            }
                            if (i22 != 0) {
                                i22 = $this$dp$iv;
                            } else {
                                i22 = obj6;
                            }
                            i3 = i97 != 0 ? $this$dp$iv : i23;
                            if (i98 != 0) {
                                i19 = 0;
                                i7 = $this$dp$iv;
                            } else {
                                i7 = f;
                            }
                            if (i100 != 0) {
                                obj10 = $this$dp$iv;
                            }
                            if (i65 & 128 != 0) {
                                $dirty12 = $dirty1;
                                $dirty13 = i48;
                                $dirty14 = PagerDefaults.INSTANCE.flingBehavior(state, 0, 0, 0, 0, restartGroup, i56 | i99, 30);
                                $dirty &= i19;
                            } else {
                                $dirty15 = state;
                                $dirty12 = $dirty1;
                                $dirty13 = $dirty16;
                                $dirty14 = obj9;
                            }
                            userScrollEnabled2 = i14 != 0 ? 1 : userScrollEnabled;
                            reverseLayout3 = i6 != 0 ? 0 : reverseLayout;
                            key3 = i12 != 0 ? 0 : key;
                            if (i65 & 2048 != 0) {
                                pageNestedScrollConnection4 = PagerDefaults.INSTANCE.pageNestedScrollConnection($dirty15, Orientation.Vertical, restartGroup, i62 |= 432);
                                $dirty13 = i23;
                            } else {
                                pageNestedScrollConnection4 = pageNestedScrollConnection;
                            }
                            if ($dirty12 != 0) {
                                obj11 = key3;
                                connection = pageNestedScrollConnection4;
                                obj12 = obj10;
                                key2 = $dirty13;
                                obj14 = i22;
                                f = i7;
                                pageNestedScrollConnection3 = $dirty14;
                                $dirty1 = restartGroup;
                                flingBehavior2 = obj8;
                                modifier2 = $dirty;
                                $composer2 = userScrollEnabled2;
                                userScrollEnabled3 = obj7;
                                contentPadding3 = iNSTANCE2;
                                i23 = i3;
                            } else {
                                obj11 = key3;
                                connection = pageNestedScrollConnection4;
                                obj12 = obj10;
                                key2 = $dirty13;
                                obj14 = i22;
                                i23 = i3;
                                f = i7;
                                pageNestedScrollConnection3 = $dirty14;
                                $dirty1 = restartGroup;
                                flingBehavior2 = obj8;
                                modifier2 = $dirty;
                                $composer2 = userScrollEnabled2;
                                userScrollEnabled3 = obj7;
                                contentPadding3 = snapPosition;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i65 & 128 != 0) {
                                $dirty &= i24;
                            }
                            if (i65 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            $dirty15 = state;
                            reverseLayout3 = reverseLayout;
                            obj11 = key;
                            connection = pageNestedScrollConnection;
                            contentPadding3 = snapPosition;
                            userScrollEnabled3 = obj5;
                            obj14 = obj6;
                            $dirty1 = restartGroup;
                            pageNestedScrollConnection3 = obj9;
                            obj12 = obj10;
                            $composer2 = userScrollEnabled;
                            key2 = $dirty16;
                            flingBehavior2 = obj8;
                            modifier2 = $dirty;
                        }
                    } else {
                    }
                    $dirty1.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj36 = flingBehavior2;
                        ComposerKt.traceEventStart(909160706, modifier2, key2, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:211)");
                    } else {
                        obj36 = flingBehavior2;
                    }
                    obj37 = modifier3;
                    $dirty16 = obj36;
                    i9 = obj37;
                    $dirty = modifier2;
                    LazyLayoutPagerKt.Pager-uYRUAWA($dirty16, $dirty15, userScrollEnabled3, reverseLayout3, Orientation.Vertical, pageNestedScrollConnection3, $composer2, i23, f, obj14, connection, obj11, obj12, Alignment.Companion.getCenterVertically(), contentPadding3, pageContent, $dirty1, i36 | i82, i44 | i93, 0);
                    composer = $dirty1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj14;
                    obj4 = contentPadding3;
                    pageSize2 = $composer2;
                    $composer3 = f;
                    pageSpacing2 = pageNestedScrollConnection3;
                    flingBehavior3 = i23;
                    beyondViewportPageCount2 = obj12;
                    horizontalAlignment2 = connection;
                    pageNestedScrollConnection2 = reverseLayout3;
                    reverseLayout2 = userScrollEnabled3;
                    contentPadding2 = $dirty16;
                } else {
                    restartGroup.skipToGroupEnd();
                    pageSize2 = userScrollEnabled;
                    pageNestedScrollConnection2 = reverseLayout;
                    obj11 = key;
                    i9 = $dirty16;
                    reverseLayout2 = obj5;
                    obj3 = obj6;
                    composer = restartGroup;
                    flingBehavior3 = i23;
                    $composer3 = f;
                    pageSpacing2 = obj9;
                    contentPadding2 = obj8;
                    beyondViewportPageCount2 = obj10;
                    horizontalAlignment2 = pageNestedScrollConnection;
                    obj4 = snapPosition;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new PagerKt.VerticalPager.1(state, contentPadding2, reverseLayout2, obj3, flingBehavior3, $composer3, beyondViewportPageCount2, pageSpacing2, pageSize2, pageNestedScrollConnection2, obj11, horizontalAlignment2, obj4, pageContent, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final boolean access$pagerSemantics$performBackwardPaging(androidx.compose.foundation.pager.PagerState $state, CoroutineScope $scope) {
        return PagerKt.pagerSemantics$performBackwardPaging($state, $scope);
    }

    public static final boolean access$pagerSemantics$performForwardPaging(androidx.compose.foundation.pager.PagerState $state, CoroutineScope $scope) {
        return PagerKt.pagerSemantics$performForwardPaging($state, $scope);
    }

    public static final int currentPageOffset(SnapPosition $this$currentPageOffset, int layoutSize, int pageSize, int spaceBetweenPages, int beforeContentPadding, int afterContentPadding, int currentPage, float currentPageOffsetFraction, int pageCount) {
        final int i2 = pageSize;
        return MathKt.roundToInt(obj8 -= obj9);
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    public static final Modifier pagerSemantics(Modifier $this$pagerSemantics, androidx.compose.foundation.pager.PagerState state, boolean isVertical, CoroutineScope scope, boolean userScrollEnabled) {
        Modifier then;
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.1 anon;
        int i3;
        int i2;
        int i;
        if (userScrollEnabled) {
            anon = new PagerKt.pagerSemantics.1(isVertical, state, scope);
            then = $this$pagerSemantics.then(SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)anon, 1, 0));
        } else {
            then = $this$pagerSemantics.then((Modifier)Modifier.Companion);
        }
        return then;
    }

    private static final boolean pagerSemantics$performBackwardPaging(androidx.compose.foundation.pager.PagerState $state, CoroutineScope $scope) {
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performBackwardPaging.1 canScrollBackward;
        int i3;
        CoroutineScope $scope2;
        int i4;
        int i;
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performBackwardPaging.1 anon;
        int i5;
        int i2;
        int obj9;
        if ($state.getCanScrollBackward()) {
            canScrollBackward = new PagerKt.pagerSemantics.performBackwardPaging.1($state, 0);
            BuildersKt.launch$default($scope, 0, 0, (Function2)canScrollBackward, 3, 0);
            obj9 = 1;
        } else {
            $scope2 = $scope;
            obj9 = 0;
        }
        return obj9;
    }

    private static final boolean pagerSemantics$performForwardPaging(androidx.compose.foundation.pager.PagerState $state, CoroutineScope $scope) {
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performForwardPaging.1 canScrollForward;
        int i;
        CoroutineScope $scope2;
        int i4;
        int i3;
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performForwardPaging.1 anon;
        int i2;
        int i5;
        int obj9;
        if ($state.getCanScrollForward()) {
            canScrollForward = new PagerKt.pagerSemantics.performForwardPaging.1($state, 0);
            BuildersKt.launch$default($scope, 0, 0, (Function2)canScrollForward, 3, 0);
            obj9 = 1;
        } else {
            $scope2 = $scope;
            obj9 = 0;
        }
        return obj9;
    }
}
