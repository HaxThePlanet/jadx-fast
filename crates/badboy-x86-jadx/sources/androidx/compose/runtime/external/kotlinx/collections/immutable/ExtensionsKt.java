package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001aQ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\u000c\u001a\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\nH\u0001\u001a-\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\u000f\u001aQ\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\nH\u0001\u001a-\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001¢\u0006\u0002\u0010\u000c\u001a \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\nH\u0000\u001a-\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\u000c\u001a\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\nH\u0000\u001a-\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\u000f\u001a \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\nH\u0000\u001a-\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000¢\u0006\u0002\u0010\u000c\u001a-\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0004\u001a-\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0004\u001a,\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010\u001c\u001a4\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a,\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010\u001f\u001a4\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010 \u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0080\u0002¢\u0006\u0002\u0010\"\u001aH\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010#\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0005H\u0080\u0002¢\u0006\u0002\u0010$\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0019H\u0080\u0002\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u001eH\u0080\u0002\u001a,\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010%\u001a4\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010&\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a9\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u000e2\u0018\u0010)\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H(0+\u0012\u0004\u0012\u00020,0*H\u0080\u0008\u001aS\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030-\u0012\u0004\u0012\u00020,0*H\u0080\u0008\u001a9\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H(0\t\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H(0.\u0012\u0004\u0012\u00020,0*H\u0080\u0008\u001a,\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010\u001c\u001a4\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010\u001d\u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a,\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010\u001f\u001a4\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010 \u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000e2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001aT\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0080\n¢\u0006\u0002\u00100\u001aG\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0080\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0080\n\u001aI\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0080\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0080\n\u001a,\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n¢\u0006\u0002\u0010%\u001a4\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\n0\u0005H\u0080\u0002¢\u0006\u0002\u0010&\u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\t2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001aS\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0000¢\u0006\u0002\u00100\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0000\u001aH\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0000\u001a\u0012\u00105\u001a\u0008\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001a\u001e\u00105\u001a\u0008\u0012\u0004\u0012\u0002H(06\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u00105\u001a\u0008\u0012\u0004\u0012\u0002H(06\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u00109\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030:\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010;\u001a\u0008\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010;\u001a\u0008\u0012\u0004\u0012\u0002H(0<\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010;\u001a\u0008\u0012\u0004\u0012\u0002H(0<\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010>\u001a\u0008\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H(0\t\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H(0\t\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a\u0012\u0010?\u001a\u0008\u0012\u0004\u0012\u0002070\u000e*\u000208H\u0000\u001a\u001e\u0010?\u001a\u0008\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010?\u001a\u0008\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010@\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010A\u001a\u0008\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010A\u001a\u0008\u0012\u0004\u0012\u0002H(0\t\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010A\u001a\u0008\u0012\u0004\u0012\u0002H(0\t\"\u0004\u0008\u0000\u0010(*\u0008\u0012\u0004\u0012\u0002H(0\u001eH\u0000¨\u0006B", d2 = {"immutableHashMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "immutableHashSetOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "immutableListOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "immutableMapOf", "immutableSetOf", "persistentHashMapOf", "persistentHashSetOf", "persistentListOf", "persistentMapOf", "persistentSetOf", "intersect", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "", "minus", "element", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Lkotlin/sequences/Sequence;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "mutate", "T", "mutator", "Lkotlin/Function1;", "", "", "", "", "plus", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "pair", "map", "", "putAll", "toImmutableList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "toImmutableMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toImmutableSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toPersistentHashMap", "toPersistentHashSet", "toPersistentList", "toPersistentMap", "toPersistentSet", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExtensionsKt {
    @Deprecated(message = "Use persistentHashMapOf instead.", replaceWith = @ReplaceWith(...))
    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> immutableHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        return ExtensionsKt.persistentHashMapOf((Pair[])Arrays.copyOf(pairs, pairs.length));
    }

    @Deprecated(message = "Use persistentHashSetOf instead.", replaceWith = @ReplaceWith(...))
    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> immutableHashSetOf(E... elements) {
        return ExtensionsKt.persistentHashSetOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(...))
    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> immutableListOf() {
        return ExtensionsKt.persistentListOf();
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(...))
    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> immutableListOf(E... elements) {
        return ExtensionsKt.persistentListOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentMapOf instead.", replaceWith = @ReplaceWith(...))
    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> immutableMapOf(Pair<? extends K, ? extends V>... pairs) {
        return ExtensionsKt.persistentMapOf((Pair[])Arrays.copyOf(pairs, pairs.length));
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(...))
    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> immutableSetOf() {
        return ExtensionsKt.persistentSetOf();
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(...))
    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> immutableSetOf(E... elements) {
        return ExtensionsKt.persistentSetOf(Arrays.copyOf(elements, elements.length));
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> intersect(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$intersect, Iterable<? extends E> elements) {
        return ExtensionsKt.intersect(ExtensionsKt.toPersistentSet((Iterable)$this$intersect), elements);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> intersect(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$intersect, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet $this$mutate$iv;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set2;
        if (elements instanceof Collection != null) {
            $this$mutate$iv = $this$intersect.retainAll((Collection)elements);
        } else {
            i2 = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$intersect.builder();
            i = 0;
            CollectionsKt.retainAll((Collection)(Set)builder, elements);
            $this$mutate$iv = build;
        }
        return $this$mutate$iv;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$minus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder collection;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder collection2;
        if (elements instanceof Collection != null) {
            build = $this$minus.removeAll((Collection)elements);
        } else {
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$minus.builder();
            i = 0;
            CollectionsKt.removeAll((Collection)builder, elements);
            build = builder.build();
        }
        return build;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$minus, E element) {
        final int i = 0;
        return $this$minus.remove(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$minus, Sequence<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$minus.builder();
        final int i = 0;
        CollectionsKt.removeAll((Collection)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$minus, E[] elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$minus.builder();
        final int i = 0;
        CollectionsKt.removeAll((Collection)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$minus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList $this$mutate$iv;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder list;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder list2;
        if (elements instanceof Collection != null) {
            $this$mutate$iv = $this$minus.removeAll((Collection)elements);
        } else {
            i = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$minus.builder();
            i2 = 0;
            CollectionsKt.removeAll((Collection)(List)builder, elements);
            $this$mutate$iv = build;
        }
        return $this$mutate$iv;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$minus, E element) {
        final int i = 0;
        return $this$minus.remove(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$minus, Sequence<? extends E> elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$minus.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(List)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$minus, E[] elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$minus.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(List)builder, elements);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$minus, Iterable<? extends K> keys) {
        Object obj = $this$minus;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(Map)builder.keySet(), keys);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$minus, K key) {
        Intrinsics.checkNotNull($this$minus, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus>");
        return $this$minus.remove(key);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$minus, Sequence<? extends K> keys) {
        Object obj = $this$minus;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(Map)builder.keySet(), keys);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$minus, K[] keys) {
        Object obj = $this$minus;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(Map)builder.keySet(), keys);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$minus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet $this$mutate$iv;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set2;
        if (elements instanceof Collection != null) {
            $this$mutate$iv = $this$minus.removeAll((Collection)elements);
        } else {
            i = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$minus.builder();
            i2 = 0;
            CollectionsKt.removeAll((Collection)(Set)builder, elements);
            $this$mutate$iv = build;
        }
        return $this$mutate$iv;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$minus, E element) {
        final int i = 0;
        return $this$minus.remove(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$minus, Sequence<? extends E> elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$minus.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(Set)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> minus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$minus, E[] elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$minus.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Collection)(Set)builder, elements);
        return builder.build();
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<T> mutate(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T> $this$mutate, Function1<? super List<T>, Unit> mutator) {
        final int i = 0;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> mutate(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$mutate, Function1<? super Map<K, V>, Unit> mutator) {
        final int i = 0;
        Intrinsics.checkNotNull($this$mutate, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<T> mutate(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends T> $this$mutate, Function1<? super Set<T>, Unit> mutator) {
        final int i = 0;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$mutate.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> persistentHashMapOf() {
        return (PersistentMap)PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> persistentHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        PersistentHashMap emptyOf$runtime_release = PersistentHashMap.Companion.emptyOf$runtime_release();
        final int i = 0;
        Intrinsics.checkNotNull((PersistentMap)emptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = emptyOf$runtime_release.builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> persistentHashSetOf(E... elements) {
        return PersistentHashSet.Companion.emptyOf$runtime_release().addAll((Collection)ArraysKt.asList(elements));
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> persistentListOf(E... elements) {
        return UtilsKt.persistentVectorOf().addAll((Collection)ArraysKt.asList(elements));
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> persistentMapOf() {
        return (PersistentMap)PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> persistentMapOf(Pair<? extends K, ? extends V>... pairs) {
        PersistentOrderedMap emptyOf$runtime_release = PersistentOrderedMap.Companion.emptyOf$runtime_release();
        final int i = 0;
        Intrinsics.checkNotNull((PersistentMap)emptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = emptyOf$runtime_release.builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> persistentSetOf(E... elements) {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release().addAll((Collection)ArraysKt.asList(elements));
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$plus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder collection2;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder collection;
        if (elements instanceof Collection != null) {
            build = $this$plus.addAll((Collection)elements);
        } else {
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$plus.builder();
            i = 0;
            CollectionsKt.addAll((Collection)builder, elements);
            build = builder.build();
        }
        return build;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$plus, E element) {
        final int i = 0;
        return $this$plus.add(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$plus, Sequence<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$plus.builder();
        final int i = 0;
        CollectionsKt.addAll((Collection)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<? extends E> $this$plus, E[] elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder builder = $this$plus.builder();
        final int i = 0;
        CollectionsKt.addAll((Collection)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$plus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList $this$mutate$iv;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder list;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder list2;
        if (elements instanceof Collection != null) {
            $this$mutate$iv = $this$plus.addAll((Collection)elements);
        } else {
            i = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$plus.builder();
            i2 = 0;
            CollectionsKt.addAll((Collection)(List)builder, elements);
            $this$mutate$iv = build;
        }
        return $this$mutate$iv;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$plus, E element) {
        final int i = 0;
        return $this$plus.add(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$plus, Sequence<? extends E> elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$plus.builder();
        final int i2 = 0;
        CollectionsKt.addAll((Collection)(List)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends E> $this$plus, E[] elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = $this$plus.builder();
        final int i2 = 0;
        CollectionsKt.addAll((Collection)(List)builder, elements);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$plus, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        final int i = 0;
        return ExtensionsKt.putAll($this$plus, pairs);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$plus, Map<? extends K, ? extends V> map) {
        final int i = 0;
        return ExtensionsKt.putAll($this$plus, map);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V> pair) {
        final int i = 0;
        Intrinsics.checkNotNull($this$plus, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus>");
        return $this$plus.put(pair.getFirst(), pair.getSecond());
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$plus, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        final int i = 0;
        return ExtensionsKt.putAll($this$plus, pairs);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V>[] pairs) {
        final int i = 0;
        return ExtensionsKt.putAll($this$plus, pairs);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$plus, Iterable<? extends E> elements) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet $this$mutate$iv;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet build;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set2;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder set;
        if (elements instanceof Collection != null) {
            $this$mutate$iv = $this$plus.addAll((Collection)elements);
        } else {
            i2 = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$plus.builder();
            i = 0;
            CollectionsKt.addAll((Collection)(Set)builder, elements);
            $this$mutate$iv = build;
        }
        return $this$mutate$iv;
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$plus, E element) {
        final int i = 0;
        return $this$plus.add(element);
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$plus, Sequence<? extends E> elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$plus.builder();
        final int i2 = 0;
        CollectionsKt.addAll((Collection)(Set)builder, elements);
        return builder.build();
    }

    public static final <E> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<E> plus(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<? extends E> $this$plus, E[] elements) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = $this$plus.builder();
        final int i2 = 0;
        CollectionsKt.addAll((Collection)(Set)builder, elements);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> putAll(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$putAll, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Object obj = $this$putAll;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> putAll(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$putAll, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNull($this$putAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll>");
        return $this$putAll.putAll(map);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> putAll(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$putAll, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Object obj = $this$putAll;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> putAll(androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<? extends K, ? extends V> $this$putAll, Pair<? extends K, ? extends V>[] pairs) {
        Object obj = $this$putAll;
        final int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<Character> toImmutableList(java.lang.CharSequence $this$toImmutableList) {
        return (ImmutableList)ExtensionsKt.toPersistentList($this$toImmutableList);
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<T> toImmutableList(Iterable<? extends T> $this$toImmutableList) {
        Object persistentList;
        if ($this$toImmutableList instanceof ImmutableList != null) {
            persistentList = $this$toImmutableList;
        } else {
            persistentList = 0;
        }
        if (persistentList == null) {
            persistentList = ExtensionsKt.toPersistentList($this$toImmutableList);
        }
        return persistentList;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<T> toImmutableList(Sequence<? extends T> $this$toImmutableList) {
        return (ImmutableList)ExtensionsKt.toPersistentList($this$toImmutableList);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap<K, V> toImmutableMap(Map<K, ? extends V> $this$toImmutableMap) {
        int all;
        int i;
        int build;
        build = 0;
        if ($this$toImmutableMap instanceof ImmutableMap != null) {
            all = $this$toImmutableMap;
        } else {
            all = build;
        }
        if (all == 0) {
            if ($this$toImmutableMap instanceof PersistentMap.Builder != null) {
                i = $this$toImmutableMap;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build != 0) {
                all = build;
            } else {
                all = ExtensionsKt.persistentMapOf().putAll($this$toImmutableMap);
            }
        }
        return all;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet<T> toImmutableSet(Iterable<? extends T> $this$toImmutableSet) {
        int plus;
        int i;
        int build;
        build = 0;
        if ($this$toImmutableSet instanceof ImmutableSet != null) {
            plus = $this$toImmutableSet;
        } else {
            plus = build;
        }
        if (plus == 0) {
            if ($this$toImmutableSet instanceof PersistentSet.Builder != null) {
                i = $this$toImmutableSet;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build != 0) {
                plus = build;
            } else {
                plus = ExtensionsKt.plus(ExtensionsKt.persistentSetOf(), $this$toImmutableSet);
            }
        }
        return plus;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet<T> toImmutableSet(Sequence<? extends T> $this$toImmutableSet) {
        return (ImmutableSet)ExtensionsKt.toPersistentSet($this$toImmutableSet);
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<Character> toImmutableSet(java.lang.CharSequence $this$toImmutableSet) {
        return ExtensionsKt.toPersistentSet($this$toImmutableSet);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> toPersistentHashMap(Map<K, ? extends V> $this$toPersistentHashMap) {
        int all;
        int i;
        int build;
        build = 0;
        if ($this$toPersistentHashMap instanceof PersistentHashMap != null) {
            all = $this$toPersistentHashMap;
        } else {
            all = build;
        }
        if (all != 0) {
        } else {
            if ($this$toPersistentHashMap instanceof PersistentHashMapBuilder != null) {
                i = $this$toPersistentHashMap;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build != 0) {
                all = build;
            } else {
                all = PersistentHashMap.Companion.emptyOf$runtime_release().putAll($this$toPersistentHashMap);
            }
        }
        return all;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<Character> toPersistentHashSet(java.lang.CharSequence $this$toPersistentHashSet) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = ExtensionsKt.persistentHashSetOf().builder();
        final int i2 = 0;
        StringsKt.toCollection($this$toPersistentHashSet, (Collection)(Set)builder);
        return builder.build();
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<T> toPersistentHashSet(Iterable<? extends T> $this$toPersistentHashSet) {
        int plus;
        int i;
        int build;
        build = 0;
        if ($this$toPersistentHashSet instanceof PersistentHashSet != null) {
            plus = $this$toPersistentHashSet;
        } else {
            plus = build;
        }
        if (plus != 0) {
        } else {
            if ($this$toPersistentHashSet instanceof PersistentHashSetBuilder != null) {
                i = $this$toPersistentHashSet;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build != 0) {
                plus = build;
            } else {
                plus = ExtensionsKt.plus(PersistentHashSet.Companion.emptyOf$runtime_release(), $this$toPersistentHashSet);
            }
        }
        return plus;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<T> toPersistentHashSet(Sequence<? extends T> $this$toPersistentHashSet) {
        return ExtensionsKt.plus(ExtensionsKt.persistentHashSetOf(), $this$toPersistentHashSet);
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<Character> toPersistentList(java.lang.CharSequence $this$toPersistentList) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder builder = ExtensionsKt.persistentListOf().builder();
        final int i2 = 0;
        StringsKt.toCollection($this$toPersistentList, (Collection)(List)builder);
        return builder.build();
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<T> toPersistentList(Iterable<? extends T> $this$toPersistentList) {
        int plus;
        int i;
        int build;
        build = 0;
        if ($this$toPersistentList instanceof PersistentList != null) {
            plus = $this$toPersistentList;
        } else {
            plus = build;
        }
        if (plus == 0) {
            if ($this$toPersistentList instanceof PersistentList.Builder != null) {
                i = $this$toPersistentList;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build == 0) {
                plus = ExtensionsKt.plus(ExtensionsKt.persistentListOf(), $this$toPersistentList);
            } else {
                plus = build;
            }
        }
        return plus;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<T> toPersistentList(Sequence<? extends T> $this$toPersistentList) {
        return ExtensionsKt.plus(ExtensionsKt.persistentListOf(), $this$toPersistentList);
    }

    public static final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, V> toPersistentMap(Map<K, ? extends V> $this$toPersistentMap) {
        int all;
        int i;
        int build;
        build = 0;
        if ($this$toPersistentMap instanceof PersistentOrderedMap != null) {
            all = $this$toPersistentMap;
        } else {
            all = build;
        }
        if (all != 0) {
        } else {
            if ($this$toPersistentMap instanceof PersistentOrderedMapBuilder != null) {
                i = $this$toPersistentMap;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build == 0) {
                all = PersistentOrderedMap.Companion.emptyOf$runtime_release().putAll($this$toPersistentMap);
            } else {
                all = build;
            }
        }
        return all;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<Character> toPersistentSet(java.lang.CharSequence $this$toPersistentSet) {
        final int i = 0;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder builder = ExtensionsKt.persistentSetOf().builder();
        final int i2 = 0;
        StringsKt.toCollection($this$toPersistentSet, (Collection)(Set)builder);
        return builder.build();
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<T> toPersistentSet(Iterable<? extends T> $this$toPersistentSet) {
        int plus;
        int i;
        int build;
        build = 0;
        if ($this$toPersistentSet instanceof PersistentOrderedSet != null) {
            plus = $this$toPersistentSet;
        } else {
            plus = build;
        }
        if (plus != 0) {
        } else {
            if ($this$toPersistentSet instanceof PersistentOrderedSetBuilder != null) {
                i = $this$toPersistentSet;
            } else {
                i = build;
            }
            if (i != 0) {
                build = i.build();
            }
            if (build == 0) {
                plus = ExtensionsKt.plus(PersistentOrderedSet.Companion.emptyOf$runtime_release(), $this$toPersistentSet);
            } else {
                plus = build;
            }
        }
        return plus;
    }

    public static final <T> androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet<T> toPersistentSet(Sequence<? extends T> $this$toPersistentSet) {
        return ExtensionsKt.plus(ExtensionsKt.persistentSetOf(), $this$toPersistentSet);
    }
}
