package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0008\u0010#\u001a\u00020\rH\u0016R\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Landroidx/compose/foundation/lazy/LazyListItemProviderImpl;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "intervalContent", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListIntervalContent;Landroidx/compose/foundation/lazy/LazyItemScopeImpl;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "headerIndexes", "", "", "getHeaderIndexes", "()Ljava/util/List;", "itemCount", "getItemCount", "()I", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getContentType", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyListItemProviderImpl implements androidx.compose.foundation.lazy.LazyListItemProvider {

    private final androidx.compose.foundation.lazy.LazyListIntervalContent intervalContent;
    private final androidx.compose.foundation.lazy.LazyItemScopeImpl itemScope;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final androidx.compose.foundation.lazy.LazyListState state;
    public LazyListItemProviderImpl(androidx.compose.foundation.lazy.LazyListState state, androidx.compose.foundation.lazy.LazyListIntervalContent intervalContent, androidx.compose.foundation.lazy.LazyItemScopeImpl itemScope, LazyLayoutKeyIndexMap keyIndexMap) {
        super();
        this.state = state;
        this.intervalContent = intervalContent;
        this.itemScope = itemScope;
        this.keyIndexMap = keyIndexMap;
    }

    public static final androidx.compose.foundation.lazy.LazyListIntervalContent access$getIntervalContent$p(androidx.compose.foundation.lazy.LazyListItemProviderImpl $this) {
        return $this.intervalContent;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public void Item(int index, Object key, Composer $composer, int $changed) {
        int i4;
        int i2;
        int i3;
        int i5;
        Object obj;
        int skipping;
        boolean traceInProgress;
        int i;
        int str;
        androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItems$foundation_release;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i6;
        int obj8;
        Object obj9;
        int obj10;
        i4 = -462424778;
        final Composer restartGroup = $composer.startRestartGroup(i4);
        ComposerKt.sourceInformation(restartGroup, "C(Item)76@3005L150,76@2951L204:LazyListItemProvider.kt#428nma");
        if ($changed & 6 == 0) {
            i2 = restartGroup.changed(index) ? 4 : 2;
            obj10 |= i2;
        }
        if ($changed & 48 == 0) {
            i3 = restartGroup.changedInstance(key) ? 32 : 16;
            obj10 |= i3;
        }
        if ($changed & 384 == 0) {
            i5 = restartGroup.changed(this) ? 256 : 128;
            obj10 |= i5;
        }
        if (obj10 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i4, obj10, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)");
                }
                LazyListItemProviderImpl.Item.1 anon = new LazyListItemProviderImpl.Item.1(this, index);
                LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, index, this.state.getPinnedItems$foundation_release(), (Function2)ComposableLambdaKt.rememberComposableLambda(-824725566, true, anon, restartGroup, 54), restartGroup, i4 | i11);
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
            obj9 = new LazyListItemProviderImpl.Item.2(this, i, obj, $changed);
            obj8.updateScope((Function2)obj9);
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof LazyListItemProviderImpl) {
            return 0;
        }
        return Intrinsics.areEqual(this.intervalContent, obj.intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public Object getContentType(int index) {
        return this.intervalContent.getContentType(index);
    }

    public List<Integer> getHeaderIndexes() {
        return this.intervalContent.getHeaderIndexes();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public int getIndex(Object key) {
        return getKeyIndexMap().getIndex(key);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public androidx.compose.foundation.lazy.LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public Object getKey(int index) {
        Object key;
        if (getKeyIndexMap().getKey(index) == null) {
            key = this.intervalContent.getKey(index);
        }
        return key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
