package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0008\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "intervalContent", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "itemCount", "", "getItemCount", "()I", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getContentType", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyStaggeredGridItemProviderImpl implements androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider {

    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state;
    public LazyStaggeredGridItemProviderImpl(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent intervalContent, LazyLayoutKeyIndexMap keyIndexMap) {
        super();
        this.state = state;
        this.intervalContent = intervalContent;
        this.keyIndexMap = keyIndexMap;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent access$getIntervalContent$p(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl $this) {
        return $this.intervalContent;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public void Item(int index, Object key, Composer $composer, int $changed) {
        int i2;
        int i4;
        int i6;
        int i3;
        Object obj;
        int skipping;
        boolean traceInProgress;
        int i;
        int str;
        androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItems$foundation_release;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i5;
        int obj8;
        Object obj9;
        int obj10;
        i2 = 89098518;
        final Composer restartGroup = $composer.startRestartGroup(i2);
        ComposerKt.sourceInformation(restartGroup, "C(Item)77@3151L171,77@3097L225:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if ($changed & 6 == 0) {
            i4 = restartGroup.changed(index) ? 4 : 2;
            obj10 |= i4;
        }
        if ($changed & 48 == 0) {
            i6 = restartGroup.changedInstance(key) ? 32 : 16;
            obj10 |= i6;
        }
        if ($changed & 384 == 0) {
            i3 = restartGroup.changed(this) ? 256 : 128;
            obj10 |= i3;
        }
        if (obj10 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i2, obj10, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderImpl.Item (LazyStaggeredGridItemProvider.kt:76)");
                }
                LazyStaggeredGridItemProviderImpl.Item.1 anon = new LazyStaggeredGridItemProviderImpl.Item.1(this, index);
                LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, index, this.state.getPinnedItems$foundation_release(), (Function2)ComposableLambdaKt.rememberComposableLambda(608834466, true, anon, restartGroup, 54), restartGroup, i2 | i11);
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
            obj9 = new LazyStaggeredGridItemProviderImpl.Item.2(this, i, obj, $changed);
            obj8.updateScope((Function2)obj9);
        }
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof LazyStaggeredGridItemProviderImpl) {
            return 0;
        }
        return Intrinsics.areEqual(this.intervalContent, obj.intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public Object getContentType(int index) {
        return this.intervalContent.getContentType(index);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public int getIndex(Object key) {
        return getKeyIndexMap().getIndex(key);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public Object getKey(int index) {
        Object key;
        if (getKeyIndexMap().getKey(index) == null) {
            key = this.intervalContent.getKey(index);
        }
        return key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.intervalContent.getSpanProvider();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider
    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
