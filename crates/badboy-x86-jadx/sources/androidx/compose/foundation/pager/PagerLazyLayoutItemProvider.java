package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0008\u0010\u001b\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "itemCount", "", "getItemCount", "()I", "pagerScopeImpl", "Landroidx/compose/foundation/pager/PagerScopeImpl;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {

    public static final int $stable;
    private final LazyLayoutIntervalContent<androidx.compose.foundation.pager.PagerIntervalContent> intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final androidx.compose.foundation.pager.PagerScopeImpl pagerScopeImpl;
    private final androidx.compose.foundation.pager.PagerState state;
    static {
    }

    public PagerLazyLayoutItemProvider(androidx.compose.foundation.pager.PagerState state, LazyLayoutIntervalContent<androidx.compose.foundation.pager.PagerIntervalContent> intervalContent, LazyLayoutKeyIndexMap keyIndexMap) {
        super();
        this.state = state;
        this.intervalContent = intervalContent;
        this.keyIndexMap = keyIndexMap;
        this.pagerScopeImpl = PagerScopeImpl.INSTANCE;
    }

    public static final LazyLayoutIntervalContent access$getIntervalContent$p(androidx.compose.foundation.pager.PagerLazyLayoutItemProvider $this) {
        return $this.intervalContent;
    }

    public static final androidx.compose.foundation.pager.PagerScopeImpl access$getPagerScopeImpl$p(androidx.compose.foundation.pager.PagerLazyLayoutItemProvider $this) {
        return $this.pagerScopeImpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(int index, Object key, Composer $composer, int $changed) {
        int i3;
        int i2;
        int i4;
        int i6;
        Object obj;
        int skipping;
        boolean traceInProgress;
        int i;
        int str;
        androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedPages$foundation_release;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i5;
        int obj8;
        Object obj9;
        int obj10;
        i3 = -1201380429;
        final Composer restartGroup = $composer.startRestartGroup(i3);
        ComposerKt.sourceInformation(restartGroup, "C(Item)207@8683L155,207@8629L209:LazyLayoutPager.kt#g6yjnt");
        if ($changed & 6 == 0) {
            i2 = restartGroup.changed(index) ? 4 : 2;
            obj10 |= i2;
        }
        if ($changed & 48 == 0) {
            i4 = restartGroup.changedInstance(key) ? 32 : 16;
            obj10 |= i4;
        }
        if ($changed & 384 == 0) {
            i6 = restartGroup.changed(this) ? 256 : 128;
            obj10 |= i6;
        }
        if (obj10 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i3, obj10, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:206)");
                }
                PagerLazyLayoutItemProvider.Item.1 anon = new PagerLazyLayoutItemProvider.Item.1(this, index);
                LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, index, this.state.getPinnedPages$foundation_release(), (Function2)ComposableLambdaKt.rememberComposableLambda(1142237095, true, anon, restartGroup, 54), restartGroup, i3 | i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i = index;
                obj = key;
            }
        } else {
        }
        obj8 = restartGroup.endRestartGroup();
        if (obj8 != null) {
            obj9 = new PagerLazyLayoutItemProvider.Item.2(this, i, obj, $changed);
            obj8.updateScope((Function2)obj9);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (other instanceof PagerLazyLayoutItemProvider == null) {
            return 0;
        }
        return Intrinsics.areEqual(this.intervalContent, obj.intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getIndex(Object key) {
        return this.keyIndexMap.getIndex(key);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int index) {
        Object key;
        if (this.keyIndexMap.getKey(index) == null) {
            key = this.intervalContent.getKey(index);
        }
        return key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
