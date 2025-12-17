package com.google.firebase.database.core.persistence;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class TrackedQueryManager {

    private static final Predicate<Map<QueryParams, com.google.firebase.database.core.persistence.TrackedQuery>> HAS_ACTIVE_DEFAULT_PREDICATE;
    private static final Predicate<Map<QueryParams, com.google.firebase.database.core.persistence.TrackedQuery>> HAS_DEFAULT_COMPLETE_PREDICATE;
    private static final Predicate<com.google.firebase.database.core.persistence.TrackedQuery> IS_QUERY_PRUNABLE_PREDICATE;
    private static final Predicate<com.google.firebase.database.core.persistence.TrackedQuery> IS_QUERY_UNPRUNABLE_PREDICATE;
    private final Clock clock;
    private long currentQueryId = 0;
    private final LogWrapper logger;
    private final com.google.firebase.database.core.persistence.PersistenceStorageEngine storageLayer;
    private ImmutableTree<Map<QueryParams, com.google.firebase.database.core.persistence.TrackedQuery>> trackedQueryTree;
    static {
        TrackedQueryManager.1 anon = new TrackedQueryManager.1();
        TrackedQueryManager.HAS_DEFAULT_COMPLETE_PREDICATE = anon;
        TrackedQueryManager.2 anon2 = new TrackedQueryManager.2();
        TrackedQueryManager.HAS_ACTIVE_DEFAULT_PREDICATE = anon2;
        TrackedQueryManager.3 anon3 = new TrackedQueryManager.3();
        TrackedQueryManager.IS_QUERY_PRUNABLE_PREDICATE = anon3;
        TrackedQueryManager.4 anon4 = new TrackedQueryManager.4();
        TrackedQueryManager.IS_QUERY_UNPRUNABLE_PREDICATE = anon4;
    }

    public TrackedQueryManager(com.google.firebase.database.core.persistence.PersistenceStorageEngine persistenceStorageEngine, LogWrapper logWrapper2, Clock clock3) {
        int i;
        long currentQueryId;
        ImmutableTree obj6;
        super();
        i = 0;
        this.storageLayer = persistenceStorageEngine;
        this.logger = logWrapper2;
        this.clock = clock3;
        obj6 = new ImmutableTree(0);
        this.trackedQueryTree = obj6;
        resetPreviouslyActiveTrackedQueries();
        Iterator obj5 = persistenceStorageEngine.loadTrackedQueries().iterator();
        for (TrackedQuery obj6 : obj5) {
            this.currentQueryId = Math.max(l += i3, obj1);
            cacheTrackedQuery(obj6);
        }
    }

    static Predicate access$000() {
        return TrackedQueryManager.IS_QUERY_PRUNABLE_PREDICATE;
    }

    static void access$100(com.google.firebase.database.core.persistence.TrackedQueryManager trackedQueryManager, com.google.firebase.database.core.persistence.TrackedQuery trackedQuery2) {
        trackedQueryManager.saveTrackedQuery(trackedQuery2);
    }

    private static void assertValidTrackedQuery(QuerySpec querySpec) {
        int obj1;
        if (querySpec.loadsAllData()) {
            if (querySpec.isDefault()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        Utilities.hardAssert(obj1, "Can't have tracked non-default query that loads all data");
    }

    private void cacheTrackedQuery(com.google.firebase.database.core.persistence.TrackedQuery trackedQuery) {
        Object hashMap;
        Object path;
        int i;
        Object cmp;
        Path path2;
        long l;
        TrackedQueryManager.assertValidTrackedQuery(trackedQuery.querySpec);
        if ((Map)this.trackedQueryTree.get(trackedQuery.querySpec.getPath()) == null) {
            hashMap = new HashMap();
            this.trackedQueryTree = this.trackedQueryTree.set(trackedQuery.querySpec.getPath(), hashMap);
        }
        cmp = hashMap.get(trackedQuery.querySpec.getParams());
        if ((TrackedQuery)cmp != null) {
            if (Long.compare(l2, l) == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i);
        hashMap.put(trackedQuery.querySpec.getParams(), trackedQuery);
    }

    private static long calculateCountToPrune(com.google.firebase.database.core.persistence.CachePolicy cachePolicy, long l2) {
        i2 -= percentOfQueriesToPruneAtOnce;
        return l2 -= l3;
    }

    private Set<Long> filteredQueryIdsAtPath(Path path) {
        ImmutableTree trackedQueryTree;
        boolean loadsAllData;
        Object obj4;
        HashSet hashSet = new HashSet();
        obj4 = this.trackedQueryTree.get(path);
        if ((Map)obj4 != null) {
            obj4 = (Map)obj4.values().iterator();
            while (obj4.hasNext()) {
                trackedQueryTree = obj4.next();
                loadsAllData = trackedQueryTree.querySpec.loadsAllData();
                if (loadsAllData == null) {
                }
                hashSet.add(Long.valueOf(trackedQueryTree.id));
            }
        }
        return hashSet;
    }

    private List<com.google.firebase.database.core.persistence.TrackedQuery> getQueriesMatching(Predicate<com.google.firebase.database.core.persistence.TrackedQuery> predicate) {
        Iterator iterator;
        boolean next;
        boolean evaluate;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.trackedQueryTree.iterator();
        for (Map.Entry next3 : iterator2) {
            iterator = (Map)next3.getValue().values().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (predicate.evaluate((TrackedQuery)next)) {
                }
                arrayList.add(next);
            }
            next = iterator.next();
            if (predicate.evaluate((TrackedQuery)next)) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private boolean includedInDefaultCompleteQuery(Path path) {
        int obj3;
        obj3 = this.trackedQueryTree.findRootMostMatchingPath(path, TrackedQueryManager.HAS_DEFAULT_COMPLETE_PREDICATE) != null ? 1 : 0;
        return obj3;
    }

    private static QuerySpec normalizeQuery(QuerySpec querySpec) {
        QuerySpec obj1;
        if (querySpec.loadsAllData()) {
            obj1 = QuerySpec.defaultQueryAtPath(querySpec.getPath());
        }
        return obj1;
    }

    private void resetPreviouslyActiveTrackedQueries() {
        try {
            this.storageLayer.beginTransaction();
            this.storageLayer.resetPreviouslyActiveTrackedQueries(this.clock.millis());
            this.storageLayer.setTransactionSuccessful();
            this.storageLayer.endTransaction();
            this.storageLayer.endTransaction();
            throw th;
        }
    }

    private void saveTrackedQuery(com.google.firebase.database.core.persistence.TrackedQuery trackedQuery) {
        cacheTrackedQuery(trackedQuery);
        this.storageLayer.saveTrackedQuery(trackedQuery);
    }

    private void setQueryActiveFlag(QuerySpec querySpec, boolean z2) {
        Object clock;
        long currentQueryId;
        int i;
        boolean z;
        com.google.firebase.database.core.persistence.TrackedQuery obj9;
        final QuerySpec normalizeQuery = TrackedQueryManager.normalizeQuery(querySpec);
        obj9 = findTrackedQuery(normalizeQuery);
        final long millis = this.clock.millis();
        if (obj9 != null) {
            obj9 = obj9.updateLastUse(millis).setActiveState(z2);
        } else {
            Utilities.hardAssert(z2, "If we're setting the query to inactive, we should already be tracking it!");
            currentQueryId = this.currentQueryId;
            this.currentQueryId = i2 += currentQueryId;
            super(currentQueryId, obj2, normalizeQuery, millis, obj5, 0, z2);
        }
        saveTrackedQuery(obj9);
    }

    public long countOfPrunableQueries() {
        return (long)size;
    }

    public void ensureCompleteTrackedQuery(Path path) {
        int includedInDefaultCompleteQuery;
        Object str;
        long currentQueryId;
        QuerySpec defaultQueryAtPath;
        long millis;
        int i2;
        int i;
        com.google.firebase.database.core.persistence.TrackedQuery obj10;
        if (!includedInDefaultCompleteQuery(path)) {
            defaultQueryAtPath = QuerySpec.defaultQueryAtPath(path);
            obj10 = findTrackedQuery(defaultQueryAtPath);
            if (obj10 == null) {
                currentQueryId = this.currentQueryId;
                this.currentQueryId = i3 += currentQueryId;
                super(currentQueryId, obj3, defaultQueryAtPath, this.clock.millis(), obj6, 1, 0);
            } else {
                Utilities.hardAssert(complete ^= 1, "This should have been handled above!");
                obj10 = obj10.setComplete();
            }
            saveTrackedQuery(obj10);
        }
    }

    public com.google.firebase.database.core.persistence.TrackedQuery findTrackedQuery(QuerySpec querySpec) {
        Object obj3;
        obj3 = TrackedQueryManager.normalizeQuery(querySpec);
        Object obj = this.trackedQueryTree.get(obj3.getPath());
        if ((Map)obj != null) {
            obj3 = (Map)obj.get(obj3.getParams());
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    public Set<ChildKey> getKnownCompleteChildren(Path path) {
        Set filteredQueryIdsAtPath;
        ImmutableTree trackedQueryTree;
        boolean storageLayer;
        Object hAS_DEFAULT_COMPLETE_PREDICATE;
        Utilities.hardAssert(queryComplete ^= 1, "Path is fully complete.");
        HashSet hashSet = new HashSet();
        filteredQueryIdsAtPath = filteredQueryIdsAtPath(path);
        if (!filteredQueryIdsAtPath.isEmpty()) {
            hashSet.addAll(this.storageLayer.loadTrackedQueryKeys(filteredQueryIdsAtPath));
        }
        Iterator obj5 = this.trackedQueryTree.subtree(path).getChildren().iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            trackedQueryTree = next2.getValue();
            if ((ImmutableTree)trackedQueryTree.getValue() != null && TrackedQueryManager.HAS_DEFAULT_COMPLETE_PREDICATE.evaluate((Map)trackedQueryTree.getValue()) != null) {
            }
            if (TrackedQueryManager.HAS_DEFAULT_COMPLETE_PREDICATE.evaluate((Map)trackedQueryTree.getValue()) != null) {
            }
            hashSet.add((ChildKey)(Map.Entry)next2.getKey());
        }
        return hashSet;
    }

    public boolean hasActiveDefaultQuery(Path path) {
        int obj3;
        obj3 = this.trackedQueryTree.rootMostValueMatching(path, TrackedQueryManager.HAS_ACTIVE_DEFAULT_PREDICATE) != null ? 1 : 0;
        return obj3;
    }

    public boolean isQueryComplete(QuerySpec querySpec) {
        int i;
        boolean path;
        boolean obj5;
        if (includedInDefaultCompleteQuery(querySpec.getPath())) {
            return 1;
        }
        final int i2 = 0;
        if (querySpec.loadsAllData()) {
            return i2;
        }
        Object obj = this.trackedQueryTree.get(querySpec.getPath());
        if (obj != null && (Map)obj.containsKey(querySpec.getParams()) && obj5.complete) {
            if (obj.containsKey(querySpec.getParams())) {
                if (obj5.complete) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public com.google.firebase.database.core.persistence.PruneForest pruneOldQueries(com.google.firebase.database.core.persistence.CachePolicy cachePolicy) {
        int i;
        boolean logsDebug;
        long path;
        int string;
        boolean logsDebug2;
        int arr;
        String querySpec;
        Object[] path2;
        com.google.firebase.database.core.persistence.PruneForest obj8;
        List queriesMatching = getQueriesMatching(TrackedQueryManager.IS_QUERY_PRUNABLE_PREDICATE);
        long countToPrune = TrackedQueryManager.calculateCountToPrune(cachePolicy, (long)size);
        obj8 = new PruneForest();
        final int i2 = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Pruning old queries.  Prunable: ");
            stringBuilder2.append(queriesMatching.size());
            stringBuilder2.append(" Count to prune: ");
            stringBuilder2.append(countToPrune);
            this.logger.debug(stringBuilder2.toString(), new Object[i2]);
        }
        TrackedQueryManager.6 anon = new TrackedQueryManager.6(this);
        Collections.sort(queriesMatching, anon);
        arr = i2;
        while (Long.compare(l2, countToPrune) < 0) {
            Object obj2 = queriesMatching.get(arr);
            obj8 = obj8.prune(obj2.querySpec.getPath());
            removeTrackedQuery(obj2.querySpec);
            arr++;
        }
        i = (int)countToPrune;
        while (i < queriesMatching.size()) {
            obj8 = obj8.keep(obj.querySpec.getPath());
            i++;
        }
        List queriesMatching2 = getQueriesMatching(TrackedQueryManager.IS_QUERY_UNPRUNABLE_PREDICATE);
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unprunable queries: ");
            stringBuilder.append(queriesMatching2.size());
            this.logger.debug(stringBuilder.toString(), new Object[i2]);
        }
        Iterator iterator = queriesMatching2.iterator();
        for (TrackedQuery next2 : iterator) {
            obj8 = obj8.keep(next2.querySpec.getPath());
        }
        return obj8;
    }

    public void removeTrackedQuery(QuerySpec querySpec) {
        boolean trackedQueryTree;
        int i;
        Object obj5;
        obj5 = TrackedQueryManager.normalizeQuery(querySpec);
        com.google.firebase.database.core.persistence.TrackedQuery trackedQuery = findTrackedQuery(obj5);
        i = trackedQuery != null ? 1 : 0;
        Utilities.hardAssert(i, "Query must exist to be removed.");
        this.storageLayer.deleteTrackedQuery(trackedQuery.id);
        Object obj = this.trackedQueryTree.get(obj5.getPath());
        (Map)obj.remove(obj5.getParams());
        if (obj.isEmpty()) {
            this.trackedQueryTree = this.trackedQueryTree.remove(obj5.getPath());
        }
    }

    public void setQueriesComplete(Path path) {
        TrackedQueryManager.5 anon = new TrackedQueryManager.5(this);
        this.trackedQueryTree.subtree(path).foreach(anon);
    }

    public void setQueryActive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, true);
    }

    public void setQueryCompleteIfExists(QuerySpec querySpec) {
        boolean complete;
        com.google.firebase.database.core.persistence.TrackedQuery obj2;
        obj2 = findTrackedQuery(TrackedQueryManager.normalizeQuery(querySpec));
        if (obj2 != null && !obj2.complete) {
            if (!obj2.complete) {
                saveTrackedQuery(obj2.setComplete());
            }
        }
    }

    public void setQueryInactive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, false);
    }

    void verifyCache() {
        List trackedQueries = this.storageLayer.loadTrackedQueries();
        ArrayList arrayList = new ArrayList();
        TrackedQueryManager.7 anon2 = new TrackedQueryManager.7(this, arrayList);
        this.trackedQueryTree.foreach(anon2);
        TrackedQueryManager.8 anon = new TrackedQueryManager.8(this);
        Collections.sort(arrayList, anon);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tracked queries out of sync.  Tracked queries: ");
        stringBuilder.append(arrayList);
        stringBuilder.append(" Stored queries: ");
        stringBuilder.append(trackedQueries);
        Utilities.hardAssert(trackedQueries.equals(arrayList), stringBuilder.toString());
    }
}
