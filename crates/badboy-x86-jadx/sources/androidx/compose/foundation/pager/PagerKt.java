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
        Object obj11;
        int $dirty14;
        Object $dirty15;
        Object flingBehavior3;
        Object endRestartGroup;
        Object obj12;
        int traceInProgress2;
        int $this$dp$iv;
        Object $dirty1;
        int i7;
        boolean z;
        boolean z2;
        Object obj7;
        int i24;
        int userScrollEnabled2;
        Object userScrollEnabled3;
        Object contentPadding3;
        int i11;
        int i8;
        int reverseLayout3;
        Object reverseLayout2;
        Object obj4;
        int key3;
        int key2;
        Object obj;
        Object obj6;
        Object pageNestedScrollConnection4;
        Object pageNestedScrollConnection2;
        int flingBehavior2;
        int $composer2;
        float $composer3;
        int i19;
        Object beyondViewportPageCount2;
        float f;
        Object pageSpacing2;
        Object obj13;
        int pageSize2;
        NestedScrollConnection connection;
        int pageNestedScrollConnection3;
        int obj8;
        Object obj2;
        int i3;
        Object obj5;
        Object obj10;
        Object modifier2;
        Object verticalAlignment2;
        int i21;
        Object obj3;
        Object contentPadding2;
        Object obj9;
        boolean traceInProgress;
        int changedInstance;
        int $dirty13;
        Composer $dirty16;
        int i2;
        Object i12;
        int i17;
        Composer composer;
        float i22;
        int i4;
        int $dirty12;
        int i5;
        int i20;
        int changed;
        int i9;
        int i25;
        int i6;
        int i13;
        int i14;
        int changed2;
        int i15;
        int i16;
        int i;
        int i10;
        int i23;
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
                i11 = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i11;
            }
        }
        i8 = i66 & 2;
        if (i8 != 0) {
            $dirty |= 48;
            obj10 = modifier;
        } else {
            if (i64 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i21;
            } else {
                obj10 = modifier;
            }
        }
        contentPadding2 = i66 & 4;
        if (contentPadding2 != 0) {
            $dirty |= 384;
            obj4 = contentPadding;
        } else {
            if (i64 & 384 == 0) {
                i2 = restartGroup.changed(contentPadding) ? 256 : changedInstance;
                $dirty |= i2;
            } else {
                obj4 = contentPadding;
            }
        }
        i12 = i66 & 8;
        i22 = 2048;
        if (i12 != 0) {
            $dirty |= 3072;
            obj6 = pageSize;
        } else {
            if (i64 & 3072 == 0) {
                i20 = restartGroup.changed(pageSize) ? i22 : i17;
                $dirty |= i20;
            } else {
                obj6 = pageSize;
            }
        }
        int i98 = i66 & 16;
        if (i98 != 0) {
            $dirty |= 24576;
            i19 = beyondViewportPageCount;
        } else {
            if (i64 & 24576 == 0) {
                i9 = restartGroup.changed(beyondViewportPageCount) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                i19 = beyondViewportPageCount;
            }
        }
        int i99 = i66 & 32;
        final int i100 = 196608;
        if (i99 != 0) {
            $dirty |= i100;
            f = pageSpacing;
        } else {
            if (i64 & i100 == 0) {
                i6 = restartGroup.changed(pageSpacing) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                f = pageSpacing;
            }
        }
        int i101 = i66 & 64;
        i13 = 1572864;
        if (i101 != 0) {
            $dirty |= i13;
            obj9 = verticalAlignment;
        } else {
            if (i64 & i13 == 0) {
                i14 = restartGroup.changed(verticalAlignment) ? 1048576 : 524288;
                $dirty |= i14;
            } else {
                obj9 = verticalAlignment;
            }
        }
        if (i64 & i102 == 0) {
            if (i66 & 128 == 0) {
                changed2 = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj2 = flingBehavior;
            }
            $dirty |= changed2;
        } else {
            obj2 = flingBehavior;
        }
        int i104 = i54;
        int $dirty110 = i66 & 256;
        int i105 = 100663296;
        if ($dirty110 != 0) {
            $dirty |= i105;
            i16 = $dirty110;
            z = userScrollEnabled;
        } else {
            if (i64 & i105 == 0) {
                i16 = $dirty110;
                i = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty |= i;
            } else {
                i16 = $dirty110;
                z = userScrollEnabled;
            }
        }
        int i55 = i66 & 512;
        int i107 = 805306368;
        if (i55 != 0) {
            $dirty2 = $dirty;
            i10 = i55;
            z2 = reverseLayout;
        } else {
            if (i64 & i107 == 0) {
                i10 = i55;
                i23 = restartGroup.changed(reverseLayout) ? 536870912 : 268435456;
                $dirty |= i23;
            } else {
                i10 = i55;
                z2 = reverseLayout;
            }
            $dirty2 = $dirty;
        }
        int $dirty3 = i66 & 1024;
        if ($dirty3 != 0) {
            $dirty12 = i104 | 6;
            obj7 = key;
        } else {
        }
        if (i65 & 48 == 0) {
            i15 = $dirty3;
            if (i66 & 2048 == 0) {
                changed = restartGroup.changedInstance(pageNestedScrollConnection) ? 32 : 16;
            } else {
                obj11 = pageNestedScrollConnection;
            }
            $dirty12 |= changed;
        } else {
            i15 = $dirty3;
            obj11 = pageNestedScrollConnection;
        }
        int i26 = $dirty12;
        int i56 = i66 & 4096;
        if (i56 != 0) {
            i26 |= 384;
        } else {
            $dirty12 = i26;
            if (i65 & 384 == 0) {
                if (restartGroup.changed(snapPosition)) {
                    changedInstance = 256;
                }
                $dirty14 = changedInstance;
            } else {
                Object obj16 = snapPosition;
                $dirty14 = $dirty12;
            }
        }
        if (i66 & 8192 != 0) {
            $dirty14 |= 3072;
            obj12 = pageContent;
        } else {
            if (i65 & 3072 == 0) {
                if (restartGroup.changedInstance(pageContent)) {
                    i17 = i22;
                }
                $dirty14 |= i17;
            } else {
                obj12 = pageContent;
            }
        }
        $dirty16 = i56;
        if ($dirty2 & i70 == 306783378 && $dirty14 & 1171 == 1170) {
            if ($dirty14 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i64 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                obj10 = $this$dp$iv;
                            }
                            if (contentPadding2 != 0) {
                                i24 = 0;
                                obj3 = $this$dp$iv;
                            } else {
                                obj3 = obj4;
                            }
                            if (i12 != 0) {
                                i12 = $this$dp$iv;
                            } else {
                                i12 = obj6;
                            }
                            i17 = i98 != 0 ? $this$dp$iv : i19;
                            if (i99 != 0) {
                                i24 = 0;
                                i22 = $this$dp$iv;
                            } else {
                                i22 = f;
                            }
                            if (i101 != 0) {
                                obj9 = $this$dp$iv;
                            }
                            if (i66 & 128 != 0) {
                                $dirty12 = $dirty16;
                                $dirty13 = i49;
                                $dirty15 = PagerDefaults.INSTANCE.flingBehavior(state, 0, 0, 0, 0, restartGroup, i57 | i100, 30);
                                $dirty2 &= i24;
                            } else {
                                $dirty1 = state;
                                $dirty12 = $dirty16;
                                $dirty13 = $dirty14;
                                $dirty15 = obj2;
                            }
                            userScrollEnabled2 = i16 != 0 ? 1 : userScrollEnabled;
                            reverseLayout3 = i10 != 0 ? 0 : reverseLayout;
                            key3 = i15 != 0 ? 0 : key;
                            if (i66 & 2048 != 0) {
                                pageNestedScrollConnection4 = PagerDefaults.INSTANCE.pageNestedScrollConnection($dirty1, Orientation.Horizontal, restartGroup, i63 |= 432);
                                $dirty13 = i19;
                            } else {
                                pageNestedScrollConnection4 = pageNestedScrollConnection;
                            }
                            if ($dirty12 != 0) {
                                obj8 = key3;
                                connection = pageNestedScrollConnection4;
                                key2 = $dirty13;
                                obj13 = i12;
                                f = i22;
                                i3 = $dirty2;
                                pageNestedScrollConnection2 = $dirty15;
                                $dirty16 = restartGroup;
                                flingBehavior3 = obj10;
                                modifier2 = obj9;
                                $composer2 = userScrollEnabled2;
                                userScrollEnabled3 = obj3;
                                contentPadding2 = iNSTANCE2;
                                i19 = i17;
                            } else {
                                obj8 = key3;
                                connection = pageNestedScrollConnection4;
                                key2 = $dirty13;
                                obj13 = i12;
                                i19 = i17;
                                f = i22;
                                i3 = $dirty2;
                                pageNestedScrollConnection2 = $dirty15;
                                $dirty16 = restartGroup;
                                flingBehavior3 = obj10;
                                modifier2 = obj9;
                                $composer2 = userScrollEnabled2;
                                userScrollEnabled3 = obj3;
                                contentPadding2 = snapPosition;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i66 & 128 != 0) {
                                $dirty2 &= i7;
                            }
                            if (i66 & 2048 != 0) {
                                $dirty14 &= -113;
                            }
                            $dirty1 = state;
                            reverseLayout3 = reverseLayout;
                            obj8 = key;
                            connection = pageNestedScrollConnection;
                            contentPadding2 = snapPosition;
                            userScrollEnabled3 = obj4;
                            obj13 = obj6;
                            $dirty16 = restartGroup;
                            pageNestedScrollConnection2 = obj2;
                            i3 = $dirty2;
                            $composer2 = userScrollEnabled;
                            key2 = $dirty14;
                            flingBehavior3 = obj10;
                            modifier2 = obj9;
                        }
                    } else {
                    }
                    $dirty16.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj36 = flingBehavior3;
                        ComposerKt.traceEventStart(1870896258, i3, key2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)");
                    } else {
                        obj36 = flingBehavior3;
                    }
                    obj37 = modifier3;
                    $dirty14 = obj36;
                    i5 = obj37;
                    $dirty2 = i3;
                    LazyLayoutPagerKt.Pager-uYRUAWA($dirty14, $dirty1, userScrollEnabled3, reverseLayout3, Orientation.Horizontal, pageNestedScrollConnection2, $composer2, i19, f, obj13, connection, obj8, Alignment.Companion.getCenterHorizontally(), modifier2, contentPadding2, pageContent, $dirty16, i37 | i83, i45 | i94, 0);
                    composer = $dirty16;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj = obj13;
                    obj5 = connection;
                    pageNestedScrollConnection3 = reverseLayout3;
                    pageSize2 = $composer2;
                    $composer3 = f;
                    reverseLayout2 = userScrollEnabled3;
                    pageSpacing2 = pageNestedScrollConnection2;
                    flingBehavior2 = i19;
                    beyondViewportPageCount2 = modifier2;
                    verticalAlignment2 = contentPadding2;
                    contentPadding3 = $dirty14;
                } else {
                    restartGroup.skipToGroupEnd();
                    pageSize2 = userScrollEnabled;
                    pageNestedScrollConnection3 = reverseLayout;
                    obj8 = key;
                    i5 = $dirty14;
                    reverseLayout2 = obj4;
                    obj = obj6;
                    composer = restartGroup;
                    flingBehavior2 = i19;
                    $composer3 = f;
                    pageSpacing2 = obj2;
                    contentPadding3 = obj10;
                    beyondViewportPageCount2 = obj9;
                    obj5 = pageNestedScrollConnection;
                    verticalAlignment2 = snapPosition;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new PagerKt.HorizontalPager.1(state, contentPadding3, reverseLayout2, obj, flingBehavior2, $composer3, beyondViewportPageCount2, pageSpacing2, pageSize2, pageNestedScrollConnection3, obj8, obj5, verticalAlignment2, pageContent, $changed, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void VerticalPager-oI3XNZo(androidx.compose.foundation.pager.PagerState state, Modifier modifier, PaddingValues contentPadding, androidx.compose.foundation.pager.PageSize pageSize, int beyondViewportPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> key, NestedScrollConnection pageNestedScrollConnection, SnapPosition snapPosition, Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, int $changed, int $changed1, int i18) {
        int $dirty2;
        Object obj9;
        int $dirty16;
        Object $dirty1;
        Object flingBehavior3;
        Object endRestartGroup;
        Object obj;
        int traceInProgress;
        int $this$dp$iv;
        Object $dirty13;
        int i13;
        boolean z2;
        boolean z;
        Object obj3;
        int i7;
        int userScrollEnabled2;
        Object userScrollEnabled3;
        Object contentPadding3;
        int i3;
        int i23;
        int reverseLayout3;
        Object reverseLayout2;
        Object obj14;
        int key2;
        int key3;
        Object obj7;
        Object obj13;
        Object pageNestedScrollConnection2;
        Object pageNestedScrollConnection4;
        int flingBehavior2;
        int $composer3;
        float $composer2;
        int i19;
        Object beyondViewportPageCount2;
        float f;
        Object pageSpacing2;
        Object obj12;
        int pageSize2;
        NestedScrollConnection connection;
        int pageNestedScrollConnection3;
        int obj10;
        Object obj8;
        Object obj4;
        Object horizontalAlignment2;
        Object obj6;
        int modifier2;
        Object obj2;
        int i9;
        Object obj5;
        Object contentPadding2;
        Object obj11;
        boolean traceInProgress2;
        int changedInstance;
        int $dirty14;
        Composer $dirty12;
        int i16;
        Object i;
        int i8;
        Composer composer;
        float i10;
        int i21;
        int $dirty15;
        int i24;
        int i2;
        int changed2;
        int i6;
        int i17;
        int i12;
        int i4;
        int i11;
        int changed;
        int i5;
        int i22;
        int i14;
        int i15;
        int i20;
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
                i3 = restartGroup.changed(state) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        i23 = i65 & 2;
        if (i23 != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj6 = modifier;
            }
        }
        contentPadding2 = i65 & 4;
        if (contentPadding2 != 0) {
            $dirty2 |= 384;
            obj14 = contentPadding;
        } else {
            if (i63 & 384 == 0) {
                i16 = restartGroup.changed(contentPadding) ? 256 : changedInstance;
                $dirty2 |= i16;
            } else {
                obj14 = contentPadding;
            }
        }
        i = i65 & 8;
        i10 = 2048;
        if (i != 0) {
            $dirty2 |= 3072;
            obj13 = pageSize;
        } else {
            if (i63 & 3072 == 0) {
                i2 = restartGroup.changed(pageSize) ? i10 : i8;
                $dirty2 |= i2;
            } else {
                obj13 = pageSize;
            }
        }
        int i97 = i65 & 16;
        if (i97 != 0) {
            $dirty2 |= 24576;
            i19 = beyondViewportPageCount;
        } else {
            if (i63 & 24576 == 0) {
                i6 = restartGroup.changed(beyondViewportPageCount) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                i19 = beyondViewportPageCount;
            }
        }
        int i98 = i65 & 32;
        final int i99 = 196608;
        if (i98 != 0) {
            $dirty2 |= i99;
            f = pageSpacing;
        } else {
            if (i63 & i99 == 0) {
                i12 = restartGroup.changed(pageSpacing) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                f = pageSpacing;
            }
        }
        int i100 = i65 & 64;
        i4 = 1572864;
        if (i100 != 0) {
            $dirty2 |= i4;
            obj11 = horizontalAlignment;
        } else {
            if (i63 & i4 == 0) {
                i11 = restartGroup.changed(horizontalAlignment) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj11 = horizontalAlignment;
            }
        }
        if (i63 & i101 == 0) {
            if (i65 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj8 = flingBehavior;
            }
            $dirty2 |= changed;
        } else {
            obj8 = flingBehavior;
        }
        int i103 = i53;
        int $dirty110 = i65 & 256;
        int i104 = 100663296;
        if ($dirty110 != 0) {
            $dirty2 |= i104;
            i22 = $dirty110;
            z2 = userScrollEnabled;
        } else {
            if (i63 & i104 == 0) {
                i22 = $dirty110;
                i14 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty2 |= i14;
            } else {
                i22 = $dirty110;
                z2 = userScrollEnabled;
            }
        }
        int i54 = i65 & 512;
        int i106 = 805306368;
        if (i54 != 0) {
            $dirty = $dirty2;
            i15 = i54;
            z = reverseLayout;
        } else {
            if (i63 & i106 == 0) {
                i15 = i54;
                i20 = restartGroup.changed(reverseLayout) ? 536870912 : 268435456;
                $dirty2 |= i20;
            } else {
                i15 = i54;
                z = reverseLayout;
            }
            $dirty = $dirty2;
        }
        int $dirty3 = i65 & 1024;
        if ($dirty3 != 0) {
            $dirty15 = i103 | 6;
            obj3 = key;
        } else {
        }
        if (i64 & 48 == 0) {
            i5 = $dirty3;
            if (i65 & 2048 == 0) {
                changed2 = restartGroup.changedInstance(pageNestedScrollConnection) ? 32 : 16;
            } else {
                obj9 = pageNestedScrollConnection;
            }
            $dirty15 |= changed2;
        } else {
            i5 = $dirty3;
            obj9 = pageNestedScrollConnection;
        }
        int i25 = $dirty15;
        int i55 = i65 & 4096;
        if (i55 != 0) {
            i25 |= 384;
        } else {
            $dirty15 = i25;
            if (i64 & 384 == 0) {
                if (restartGroup.changed(snapPosition)) {
                    changedInstance = 256;
                }
                $dirty16 = changedInstance;
            } else {
                Object obj17 = snapPosition;
                $dirty16 = $dirty15;
            }
        }
        if (i65 & 8192 != 0) {
            $dirty16 |= 3072;
            obj = pageContent;
        } else {
            if (i64 & 3072 == 0) {
                if (restartGroup.changedInstance(pageContent)) {
                    i8 = i10;
                }
                $dirty16 |= i8;
            } else {
                obj = pageContent;
            }
        }
        $dirty12 = i55;
        if ($dirty & i69 == 306783378 && $dirty16 & 1171 == 1170) {
            if ($dirty16 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i63 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i23 != 0) {
                                obj6 = $this$dp$iv;
                            }
                            if (contentPadding2 != 0) {
                                i7 = 0;
                                obj5 = $this$dp$iv;
                            } else {
                                obj5 = obj14;
                            }
                            if (i != 0) {
                                i = $this$dp$iv;
                            } else {
                                i = obj13;
                            }
                            i8 = i97 != 0 ? $this$dp$iv : i19;
                            if (i98 != 0) {
                                i7 = 0;
                                i10 = $this$dp$iv;
                            } else {
                                i10 = f;
                            }
                            if (i100 != 0) {
                                obj11 = $this$dp$iv;
                            }
                            if (i65 & 128 != 0) {
                                $dirty15 = $dirty12;
                                $dirty14 = i48;
                                $dirty1 = PagerDefaults.INSTANCE.flingBehavior(state, 0, 0, 0, 0, restartGroup, i56 | i99, 30);
                                $dirty &= i7;
                            } else {
                                $dirty13 = state;
                                $dirty15 = $dirty12;
                                $dirty14 = $dirty16;
                                $dirty1 = obj8;
                            }
                            userScrollEnabled2 = i22 != 0 ? 1 : userScrollEnabled;
                            reverseLayout3 = i15 != 0 ? 0 : reverseLayout;
                            key2 = i5 != 0 ? 0 : key;
                            if (i65 & 2048 != 0) {
                                pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection($dirty13, Orientation.Vertical, restartGroup, i62 |= 432);
                                $dirty14 = i19;
                            } else {
                                pageNestedScrollConnection2 = pageNestedScrollConnection;
                            }
                            if ($dirty15 != 0) {
                                obj10 = key2;
                                connection = pageNestedScrollConnection2;
                                obj4 = obj11;
                                key3 = $dirty14;
                                obj12 = i;
                                f = i10;
                                pageNestedScrollConnection4 = $dirty1;
                                $dirty12 = restartGroup;
                                flingBehavior3 = obj6;
                                modifier2 = $dirty;
                                $composer3 = userScrollEnabled2;
                                userScrollEnabled3 = obj5;
                                contentPadding2 = iNSTANCE2;
                                i19 = i8;
                            } else {
                                obj10 = key2;
                                connection = pageNestedScrollConnection2;
                                obj4 = obj11;
                                key3 = $dirty14;
                                obj12 = i;
                                i19 = i8;
                                f = i10;
                                pageNestedScrollConnection4 = $dirty1;
                                $dirty12 = restartGroup;
                                flingBehavior3 = obj6;
                                modifier2 = $dirty;
                                $composer3 = userScrollEnabled2;
                                userScrollEnabled3 = obj5;
                                contentPadding2 = snapPosition;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i65 & 128 != 0) {
                                $dirty &= i13;
                            }
                            if (i65 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            $dirty13 = state;
                            reverseLayout3 = reverseLayout;
                            obj10 = key;
                            connection = pageNestedScrollConnection;
                            contentPadding2 = snapPosition;
                            userScrollEnabled3 = obj14;
                            obj12 = obj13;
                            $dirty12 = restartGroup;
                            pageNestedScrollConnection4 = obj8;
                            obj4 = obj11;
                            $composer3 = userScrollEnabled;
                            key3 = $dirty16;
                            flingBehavior3 = obj6;
                            modifier2 = $dirty;
                        }
                    } else {
                    }
                    $dirty12.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj36 = flingBehavior3;
                        ComposerKt.traceEventStart(909160706, modifier2, key3, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:211)");
                    } else {
                        obj36 = flingBehavior3;
                    }
                    obj37 = modifier3;
                    $dirty16 = obj36;
                    i24 = obj37;
                    $dirty = modifier2;
                    LazyLayoutPagerKt.Pager-uYRUAWA($dirty16, $dirty13, userScrollEnabled3, reverseLayout3, Orientation.Vertical, pageNestedScrollConnection4, $composer3, i19, f, obj12, connection, obj10, obj4, Alignment.Companion.getCenterVertically(), contentPadding2, pageContent, $dirty12, i36 | i82, i44 | i93, 0);
                    composer = $dirty12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj7 = obj12;
                    obj2 = contentPadding2;
                    pageSize2 = $composer3;
                    $composer2 = f;
                    pageSpacing2 = pageNestedScrollConnection4;
                    flingBehavior2 = i19;
                    beyondViewportPageCount2 = obj4;
                    horizontalAlignment2 = connection;
                    pageNestedScrollConnection3 = reverseLayout3;
                    reverseLayout2 = userScrollEnabled3;
                    contentPadding3 = $dirty16;
                } else {
                    restartGroup.skipToGroupEnd();
                    pageSize2 = userScrollEnabled;
                    pageNestedScrollConnection3 = reverseLayout;
                    obj10 = key;
                    i24 = $dirty16;
                    reverseLayout2 = obj14;
                    obj7 = obj13;
                    composer = restartGroup;
                    flingBehavior2 = i19;
                    $composer2 = f;
                    pageSpacing2 = obj8;
                    contentPadding3 = obj6;
                    beyondViewportPageCount2 = obj11;
                    horizontalAlignment2 = pageNestedScrollConnection;
                    obj2 = snapPosition;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new PagerKt.VerticalPager.1(state, contentPadding3, reverseLayout2, obj7, flingBehavior2, $composer2, beyondViewportPageCount2, pageSpacing2, pageSize2, pageNestedScrollConnection3, obj10, horizontalAlignment2, obj2, pageContent, $changed, $changed1, i18);
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
        int i;
        int i2;
        int i3;
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
        int i4;
        CoroutineScope $scope2;
        int i2;
        int i;
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performBackwardPaging.1 anon;
        int i3;
        int i5;
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
        int i2;
        androidx.compose.foundation.pager.PagerKt.pagerSemantics.performForwardPaging.1 anon;
        int i5;
        int i3;
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
