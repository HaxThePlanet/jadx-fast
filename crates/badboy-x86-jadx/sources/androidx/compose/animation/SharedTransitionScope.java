package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008g\u0018\u00002\u00020\u0001:\u0004\u0005345J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H&J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH'¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013H\u0017J\u001c\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013H\u0017JD\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u000e\u0008\u0002\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0008\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001dH&Jl\u0010!\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u000f2\u0008\u0008\u0002\u0010&\u001a\u00020\u00152\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0006H&JN\u0010.\u001a\u00020\u0017*\u00020\u00172\u0006\u0010/\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0006H&JN\u00100\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\"\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00032\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0006H&J\u000c\u00102\u001a\u00020\u0017*\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u00066À\u0006\u0001", d2 = {"Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "isTransitionActive", "", "()Z", "OverlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "rememberSharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "key", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "scaleInSharedContentToBounds", "Landroidx/compose/animation/EnterTransition;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "scaleOutSharedContentToBounds", "Landroidx/compose/animation/ExitTransition;", "renderInSharedTransitionScopeOverlay", "Landroidx/compose/ui/Modifier;", "renderInOverlay", "Lkotlin/Function0;", "zIndexInOverlay", "", "clipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedBounds", "sharedContentState", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "enter", "exit", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderInOverlayDuringTransition", "sharedElement", "state", "sharedElementWithCallerManagedVisibility", "visible", "skipToLookaheadSize", "PlaceHolderSize", "ResizeMode", "SharedContentState", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SharedTransitionScope extends LookaheadScope {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "", "Companion", "Landroidx/compose/animation/RemeasureImpl;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResizeMode {

        public static final androidx.compose.animation.SharedTransitionScope.ResizeMode.Companion Companion;
        static {
            SharedTransitionScope.ResizeMode.Companion = SharedTransitionScope.ResizeMode.Companion.$$INSTANCE;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "", "getClipPath", "Landroidx/compose/ui/graphics/Path;", "state", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OverlayClip {
        public abstract Path getClipPath(androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState, Rect rect2, LayoutDirection layoutDirection3, Density density4);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008æ\u0080\u0001\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "", "calculateSize", "Landroidx/compose/ui/unit/IntSize;", "contentSize", "animatedSize", "calculateSize-JyjRU_E", "(JJ)J", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PlaceHolderSize {

        public static final androidx.compose.animation.SharedTransitionScope.PlaceHolderSize.Companion Companion;
        static {
            SharedTransitionScope.PlaceHolderSize.Companion = SharedTransitionScope.PlaceHolderSize.Companion.$$INSTANCE;
        }

        public abstract long calculateSize-JyjRU_E(long l, long l2);
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R/\u0010\n\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000cR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006\u001b", d2 = {"Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "", "key", "(Ljava/lang/Object;)V", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay", "()Landroidx/compose/ui/graphics/Path;", "<set-?>", "Landroidx/compose/animation/SharedElementInternalState;", "internalState", "getInternalState$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "setInternalState$animation_release", "(Landroidx/compose/animation/SharedElementInternalState;)V", "internalState$delegate", "Landroidx/compose/runtime/MutableState;", "isMatchFound", "", "()Z", "getKey", "()Ljava/lang/Object;", "nonNullInternalState", "getNonNullInternalState", "parentSharedContentState", "getParentSharedContentState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SharedContentState {

        public static final int $stable = 8;
        private final MutableState internalState$delegate;
        private final Object key;
        static {
            final int i = 8;
        }

        public SharedContentState(Object key) {
            super();
            this.key = key;
            int i = 0;
            this.internalState$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
        }

        private final androidx.compose.animation.SharedElementInternalState getNonNullInternalState() {
            androidx.compose.animation.SharedElementInternalState internalState$animation_release = getInternalState$animation_release();
            if (internalState$animation_release == null) {
            } else {
                return internalState$animation_release;
            }
            int i = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not bee initialized.".toString());
            throw illegalArgumentException;
        }

        public final Path getClipPathInOverlay() {
            return getNonNullInternalState().getClipPathInOverlay$animation_release();
        }

        public final androidx.compose.animation.SharedElementInternalState getInternalState$animation_release() {
            final int i = 0;
            final int i2 = 0;
            return (SharedElementInternalState)(State)this.internalState$delegate.getValue();
        }

        public final Object getKey() {
            return this.key;
        }

        public final androidx.compose.animation.SharedTransitionScope.SharedContentState getParentSharedContentState() {
            androidx.compose.animation.SharedTransitionScope.SharedContentState userState;
            androidx.compose.animation.SharedElementInternalState parentState = getNonNullInternalState().getParentState();
            if (parentState != null) {
                userState = parentState.getUserState();
            } else {
                userState = 0;
            }
            return userState;
        }

        public final boolean isMatchFound() {
            Object internalState$animation_release;
            int foundMatch;
            internalState$animation_release = getInternalState$animation_release();
            internalState$animation_release = internalState$animation_release.getSharedElement();
            if (internalState$animation_release != null && internalState$animation_release != null) {
                internalState$animation_release = internalState$animation_release.getSharedElement();
                if (internalState$animation_release != null) {
                    foundMatch = internalState$animation_release.getFoundMatch();
                } else {
                    foundMatch = 0;
                }
            } else {
            }
            return foundMatch;
        }

        public final void setInternalState$animation_release(androidx.compose.animation.SharedElementInternalState <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.internalState$delegate.setValue(<set-?>);
        }
    }
    public static Modifier renderInSharedTransitionScopeOverlay$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, Modifier modifier2, Function0 function03, float f4, Function2 function25, int i6, Object object7) {
        androidx.compose.animation.SharedTransitionScope.renderInSharedTransitionScopeOverlay.1 obj2;
        int obj3;
        Function2 obj4;
        if (object7 != null) {
        } else {
            if (i6 & 1 != 0) {
                obj2 = new SharedTransitionScope.renderInSharedTransitionScopeOverlay.1(sharedTransitionScope);
            }
            if (i6 & 2 != 0) {
                obj3 = 0;
            }
            if (i6 &= 4 != 0) {
                obj4 = SharedTransitionScopeKt.access$getDefaultClipInOverlayDuringTransition$p();
            }
            return sharedTransitionScope.renderInSharedTransitionScopeOverlay(modifier2, obj2, obj3, obj4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderInSharedTransitionScopeOverlay");
        throw obj0;
    }

    public static androidx.compose.animation.EnterTransition scaleInSharedContentToBounds$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, ContentScale contentScale2, Alignment alignment3, int i4, Object object5) {
        ContentScale obj1;
        Alignment obj2;
        if (object5 != null) {
        } else {
            if (i4 & 1 != 0) {
                obj1 = ContentScale.Companion.getFit();
            }
            if (i4 &= 2 != 0) {
                obj2 = Alignment.Companion.getCenter();
            }
            return sharedTransitionScope.scaleInSharedContentToBounds(obj1, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleInSharedContentToBounds");
        throw obj0;
    }

    public static androidx.compose.animation.ExitTransition scaleOutSharedContentToBounds$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, ContentScale contentScale2, Alignment alignment3, int i4, Object object5) {
        ContentScale obj1;
        Alignment obj2;
        if (object5 != null) {
        } else {
            if (i4 & 1 != 0) {
                obj1 = ContentScale.Companion.getFit();
            }
            if (i4 &= 2 != 0) {
                obj2 = Alignment.Companion.getCenter();
            }
            return sharedTransitionScope.scaleOutSharedContentToBounds(obj1, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleOutSharedContentToBounds");
        throw obj0;
    }

    public static Modifier sharedBounds$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, Modifier modifier2, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState3, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope4, androidx.compose.animation.EnterTransition enterTransition5, androidx.compose.animation.ExitTransition exitTransition6, androidx.compose.animation.BoundsTransform boundsTransform7, androidx.compose.animation.SharedTransitionScope.ResizeMode sharedTransitionScope$ResizeMode8, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize9, boolean z10, float f11, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip12, int i13, Object object14) {
        androidx.compose.animation.SharedTransitionScope.OverlayClip i6;
        int fadeIn$default;
        int fadeOut$default;
        int i2;
        androidx.compose.animation.SharedTransitionScope.ResizeMode i;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize contentSize;
        int i3;
        ContentScale fillWidth;
        Alignment center;
        androidx.compose.animation.EnterTransition enterTransition;
        androidx.compose.animation.ExitTransition exitTransition;
        androidx.compose.animation.BoundsTransform boundsTransform;
        androidx.compose.animation.SharedTransitionScope.ResizeMode resizeMode;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize;
        int i4;
        int i5;
        androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip;
        int i7 = i13;
        if (object14 != null) {
        } else {
            fillWidth = 3;
            final int i9 = 0;
            center = 0;
            if (i7 & 4 != 0) {
                enterTransition = fadeIn$default;
            } else {
                enterTransition = enterTransition5;
            }
            if (i7 & 8 != 0) {
                exitTransition = fadeOut$default;
            } else {
                exitTransition = exitTransition6;
            }
            if (i7 & 16 != 0) {
                boundsTransform = i2;
            } else {
                boundsTransform = boundsTransform7;
            }
            if (i7 & 32 != 0) {
                resizeMode = i;
            } else {
                resizeMode = resizeMode8;
            }
            if (i7 & 64 != 0) {
                placeHolderSize = contentSize;
            } else {
                placeHolderSize = placeHolderSize9;
            }
            i4 = i7 & 128 != 0 ? i3 : z10;
            i5 = i7 & 256 != 0 ? i9 : f11;
            if (i7 &= 512 != 0) {
                overlayClip = i6;
            } else {
                overlayClip = overlayClip12;
            }
            return sharedTransitionScope.sharedBounds(modifier2, sharedContentState3, animatedVisibilityScope4, enterTransition, exitTransition, boundsTransform, resizeMode, placeHolderSize, i4, i5, overlayClip);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedBounds");
        throw unsupportedOperationException;
    }

    public static Modifier sharedElement$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, Modifier modifier2, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState3, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope4, androidx.compose.animation.BoundsTransform boundsTransform5, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize6, boolean z7, float f8, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip9, int i10, Object object11) {
        androidx.compose.animation.BoundsTransform boundsTransform;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize;
        int i;
        int i2;
        androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip;
        androidx.compose.animation.BoundsTransform obj13;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize obj14;
        if (object11 != null) {
        } else {
            if (i10 & 4 != 0) {
                boundsTransform = obj13;
            } else {
                boundsTransform = boundsTransform5;
            }
            if (i10 & 8 != 0) {
                placeHolderSize = obj14;
            } else {
                placeHolderSize = placeHolderSize6;
            }
            i = i10 & 16 != 0 ? obj13 : z7;
            i2 = i10 & 32 != 0 ? obj13 : f8;
            if (i10 & 64 != 0) {
                overlayClip = obj13;
            } else {
                overlayClip = overlayClip9;
            }
            return sharedTransitionScope.sharedElement(modifier2, sharedContentState3, animatedVisibilityScope4, boundsTransform, placeHolderSize, i, i2, overlayClip);
        }
        UnsupportedOperationException obj9 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElement");
        throw obj9;
    }

    public static Modifier sharedElementWithCallerManagedVisibility$default(androidx.compose.animation.SharedTransitionScope sharedTransitionScope, Modifier modifier2, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState3, boolean z4, androidx.compose.animation.BoundsTransform boundsTransform5, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize6, boolean z7, float f8, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip9, int i10, Object object11) {
        androidx.compose.animation.BoundsTransform boundsTransform;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize;
        int i2;
        int i;
        androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip;
        androidx.compose.animation.BoundsTransform obj13;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize obj14;
        if (object11 != null) {
        } else {
            if (i10 & 4 != 0) {
                boundsTransform = obj13;
            } else {
                boundsTransform = boundsTransform5;
            }
            if (i10 & 8 != 0) {
                placeHolderSize = obj14;
            } else {
                placeHolderSize = placeHolderSize6;
            }
            i2 = i10 & 16 != 0 ? obj13 : z7;
            i = i10 & 32 != 0 ? obj13 : f8;
            if (i10 & 64 != 0) {
                overlayClip = obj13;
            } else {
                overlayClip = overlayClip9;
            }
            return sharedTransitionScope.sharedElementWithCallerManagedVisibility(modifier2, sharedContentState3, z4, boundsTransform, placeHolderSize, i2, i, overlayClip);
        }
        UnsupportedOperationException obj9 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElementWithCallerManagedVisibility");
        throw obj9;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract androidx.compose.animation.SharedTransitionScope.OverlayClip OverlayClip(Shape shape);

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract boolean isTransitionActive();

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract androidx.compose.animation.SharedTransitionScope.SharedContentState rememberSharedContentState(Object object, Composer composer2, int i3);

    public abstract Modifier renderInSharedTransitionScopeOverlay(Modifier modifier, Function0<Boolean> function02, float f3, Function2<? super LayoutDirection, ? super Density, ? extends Path> function24);

    @Deprecated(message = "This EnterTransition has been deprecated. Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    public androidx.compose.animation.EnterTransition scaleInSharedContentToBounds(ContentScale contentScale, Alignment alignment) {
        ContentScaleTransitionEffect contentScaleTransitionEffect = new ContentScaleTransitionEffect(contentScale, alignment);
        return EnterExitTransitionKt.withEffect(EnterTransition.Companion.getNone(), (TransitionEffect)contentScaleTransitionEffect);
    }

    @Deprecated(message = "This ExitTransition has been deprecated.  Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    public androidx.compose.animation.ExitTransition scaleOutSharedContentToBounds(ContentScale contentScale, Alignment alignment) {
        ContentScaleTransitionEffect contentScaleTransitionEffect = new ContentScaleTransitionEffect(contentScale, alignment);
        return EnterExitTransitionKt.withEffect(ExitTransition.Companion.getNone(), (TransitionEffect)contentScaleTransitionEffect);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract Modifier sharedBounds(Modifier modifier, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState2, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope3, androidx.compose.animation.EnterTransition enterTransition4, androidx.compose.animation.ExitTransition exitTransition5, androidx.compose.animation.BoundsTransform boundsTransform6, androidx.compose.animation.SharedTransitionScope.ResizeMode sharedTransitionScope$ResizeMode7, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize8, boolean z9, float f10, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip11);

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract Modifier sharedElement(Modifier modifier, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState2, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope3, androidx.compose.animation.BoundsTransform boundsTransform4, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize5, boolean z6, float f7, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip8);

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract Modifier sharedElementWithCallerManagedVisibility(Modifier modifier, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState2, boolean z3, androidx.compose.animation.BoundsTransform boundsTransform4, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize5, boolean z6, float f7, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip8);

    @Override // androidx.compose.ui.layout.LookaheadScope
    public abstract Modifier skipToLookaheadSize(Modifier modifier);
}
