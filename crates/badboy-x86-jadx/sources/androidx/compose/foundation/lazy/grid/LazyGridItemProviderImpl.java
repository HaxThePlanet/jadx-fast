package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0008\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "intervalContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "itemCount", "", "getItemCount", "()I", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getContentType", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyGridItemProviderImpl implements androidx.compose.foundation.lazy.grid.LazyGridItemProvider {

    private final androidx.compose.foundation.lazy.grid.LazyGridIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final androidx.compose.foundation.lazy.grid.LazyGridState state;
    public LazyGridItemProviderImpl(androidx.compose.foundation.lazy.grid.LazyGridState state, androidx.compose.foundation.lazy.grid.LazyGridIntervalContent intervalContent, LazyLayoutKeyIndexMap keyIndexMap) {
        super();
        this.state = state;
        this.intervalContent = intervalContent;
        this.keyIndexMap = keyIndexMap;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridIntervalContent access$getIntervalContent$p(androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl $this) {
        return $this.intervalContent;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public void Item(int index, Object key, Composer $composer, int $changed) {
        int i6;
        int i;
        int i5;
        int i3;
        Object obj;
        int skipping;
        boolean traceInProgress;
        int i4;
        int str;
        androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItems$foundation_release;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i2;
        int obj8;
        Object obj9;
        int obj10;
        i6 = 1493551140;
        final Composer restartGroup = $composer.startRestartGroup(i6);
        ComposerKt.sourceInformation(restartGroup, "C(Item)75@2938L162,75@2884L216:LazyGridItemProvider.kt#7791vq");
        if ($changed & 6 == 0) {
            i = restartGroup.changed(index) ? 4 : 2;
            obj10 |= i;
        }
        if ($changed & 48 == 0) {
            i5 = restartGroup.changedInstance(key) ? 32 : 16;
            obj10 |= i5;
        }
        if ($changed & 384 == 0) {
            i3 = restartGroup.changed(this) ? 256 : 128;
            obj10 |= i3;
        }
        if (obj10 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, obj10, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:74)");
                }
                LazyGridItemProviderImpl.Item.1 anon = new LazyGridItemProviderImpl.Item.1(this, index);
                LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, index, this.state.getPinnedItems$foundation_release(), (Function2)ComposableLambdaKt.rememberComposableLambda(726189336, true, anon, restartGroup, 54), restartGroup, i6 | i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i4 = index;
                obj = key;
            }
        } else {
        }
        obj8 = restartGroup.endRestartGroup();
        if (obj8 != null) {
            obj9 = new LazyGridItemProviderImpl.Item.2(this, i4, obj, $changed);
            obj8.updateScope((Function2)obj9);
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof LazyGridItemProviderImpl) {
            return 0;
        }
        return Intrinsics.areEqual(this.intervalContent, obj.intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public Object getContentType(int index) {
        return this.intervalContent.getContentType(index);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public int getIndex(Object key) {
        return getKeyIndexMap().getIndex(key);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public Object getKey(int index) {
        Object key;
        if (getKeyIndexMap().getKey(index) == null) {
            key = this.intervalContent.getKey(index);
        }
        return key;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.intervalContent.getSpanLayoutProvider$foundation_release();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
