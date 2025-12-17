package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R$\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0018\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0018\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000fÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "K", "V", "", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "keys", "getKeys", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ImmutableMap<K, V>  extends Map<K, V>, KMappedMarker {
    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet<Map.Entry<K, V>> getEntries();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet<K> getKeys();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection<V> getValues();
}
