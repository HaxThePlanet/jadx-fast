package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.DelayedTask;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.Logger;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class LruGarbageCollector {

    private static final long INITIAL_GC_DELAY_MS;
    private static final long REGULAR_GC_DELAY_MS;
    private final com.google.firebase.firestore.local.LruDelegate delegate;
    private final com.google.firebase.firestore.local.LruGarbageCollector.Params params;

    public static class Params {

        private static final long COLLECTION_DISABLED = -1L;
        private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600L;
        private static final int DEFAULT_COLLECTION_PERCENTILE = 10;
        private static final int DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT = 1000;
        final int maximumSequenceNumbersToCollect;
        final long minBytesThreshold;
        final int percentileToCollect;
        Params(long l, int i2, int i3) {
            super();
            this.minBytesThreshold = l;
            this.percentileToCollect = i3;
            this.maximumSequenceNumbersToCollect = obj4;
        }

        public static com.google.firebase.firestore.local.LruGarbageCollector.Params Default() {
            LruGarbageCollector.Params params = new LruGarbageCollector.Params(104857600, obj2, 10, 1000);
            return params;
        }

        public static com.google.firebase.firestore.local.LruGarbageCollector.Params Disabled() {
            final int i2 = 0;
            LruGarbageCollector.Params params = new LruGarbageCollector.Params(-1, obj2, i2, i2);
            return params;
        }

        public static com.google.firebase.firestore.local.LruGarbageCollector.Params WithCacheSizeBytes(long l) {
            LruGarbageCollector.Params params = new LruGarbageCollector.Params(l, obj4, 10, 1000);
            return params;
        }
    }

    public static class Results {

        private final int documentsRemoved;
        private final boolean hasRun;
        private final int sequenceNumbersCollected;
        private final int targetsRemoved;
        Results(boolean z, int i2, int i3, int i4) {
            super();
            this.hasRun = z;
            this.sequenceNumbersCollected = i2;
            this.targetsRemoved = i3;
            this.documentsRemoved = i4;
        }

        static com.google.firebase.firestore.local.LruGarbageCollector.Results DidNotRun() {
            final int i = 0;
            LruGarbageCollector.Results results = new LruGarbageCollector.Results(i, i, i, i);
            return results;
        }

        public int getDocumentsRemoved() {
            return this.documentsRemoved;
        }

        public int getSequenceNumbersCollected() {
            return this.sequenceNumbersCollected;
        }

        public int getTargetsRemoved() {
            return this.targetsRemoved;
        }

        public boolean hasRun() {
            return this.hasRun;
        }
    }

    private static class RollingSequenceNumberBuffer {

        private static final Comparator<Long> COMPARATOR;
        private final int maxElements;
        private final PriorityQueue<Long> queue;
        static {
            LruGarbageCollector.RollingSequenceNumberBuffer.COMPARATOR = w.a;
        }

        RollingSequenceNumberBuffer(int i) {
            super();
            this.maxElements = i;
            PriorityQueue priorityQueue = new PriorityQueue(i, LruGarbageCollector.RollingSequenceNumberBuffer.COMPARATOR);
            this.queue = priorityQueue;
        }

        static int a(Long long, Long long2) {
            return long2.compareTo(long);
        }

        void addElement(Long long) {
            PriorityQueue queue;
            int maxElements;
            long longValue;
            if (this.queue.size() < this.maxElements) {
                this.queue.add(long);
            } else {
                if (Long.compare(maxElements, longValue) < 0) {
                    this.queue.poll();
                    this.queue.add(long);
                }
            }
        }

        long getMaxValue() {
            return (Long)this.queue.peek().longValue();
        }
    }

    public class GCScheduler implements com.google.firebase.firestore.local.Scheduler {

        private final AsyncQueue asyncQueue;
        private AsyncQueue.DelayedTask gcTask;
        private boolean hasRun = false;
        private final com.google.firebase.firestore.local.LocalStore localStore;
        final com.google.firebase.firestore.local.LruGarbageCollector this$0;
        public GCScheduler(com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector, AsyncQueue asyncQueue2, com.google.firebase.firestore.local.LocalStore localStore3) {
            this.this$0 = lruGarbageCollector;
            super();
            final int obj1 = 0;
            this.asyncQueue = asyncQueue2;
            this.localStore = localStore3;
        }

        private void a() {
            this.localStore.collectGarbage(this.this$0);
            this.hasRun = true;
            scheduleGC();
        }

        private void scheduleGC() {
            long l;
            if (this.hasRun) {
                l = LruGarbageCollector.access$100();
            } else {
                l = LruGarbageCollector.access$200();
            }
            v vVar = new v(this);
            this.gcTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.GARBAGE_COLLECTION, l, obj1);
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void b() {
            a();
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            if (Long.compare(minBytesThreshold, i) != 0) {
                scheduleGC();
            }
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            final AsyncQueue.DelayedTask gcTask = this.gcTask;
            if (gcTask != null) {
                gcTask.cancel();
            }
        }
    }
    static {
        TimeUnit mINUTES = TimeUnit.MINUTES;
        LruGarbageCollector.INITIAL_GC_DELAY_MS = mINUTES.toMillis(1);
        LruGarbageCollector.REGULAR_GC_DELAY_MS = mINUTES.toMillis(5);
    }

    LruGarbageCollector(com.google.firebase.firestore.local.LruDelegate lruDelegate, com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params2) {
        super();
        this.delegate = lruDelegate;
        this.params = params2;
    }

    static void a(com.google.firebase.firestore.local.LruGarbageCollector.RollingSequenceNumberBuffer lruGarbageCollector$RollingSequenceNumberBuffer, com.google.firebase.firestore.local.TargetData targetData2) {
        rollingSequenceNumberBuffer.addElement(Long.valueOf(targetData2.getSequenceNumber()));
    }

    static com.google.firebase.firestore.local.LruGarbageCollector.Params access$000(com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector) {
        return lruGarbageCollector.params;
    }

    static long access$100() {
        return LruGarbageCollector.REGULAR_GC_DELAY_MS;
    }

    static long access$200() {
        return LruGarbageCollector.INITIAL_GC_DELAY_MS;
    }

    private com.google.firebase.firestore.local.LruGarbageCollector.Results runGarbageCollection(SparseArray<?> sparseArray) {
        Object string;
        long currentTimeMillis2;
        String str2;
        int maximumSequenceNumbersToCollect;
        int maximumSequenceNumbersToCollect2;
        Object rOOT;
        int stringBuilder;
        String str;
        long currentTimeMillis;
        long i;
        boolean debugEnabled;
        long currentTimeMillis3;
        int i2;
        String str3;
        Integer valueOf;
        string = this;
        currentTimeMillis2 = System.currentTimeMillis();
        maximumSequenceNumbersToCollect = string.calculateQueryCount(params.percentileToCollect);
        rOOT = "LruGarbageCollector";
        if (maximumSequenceNumbersToCollect > params3.maximumSequenceNumbersToCollect) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Capping sequence numbers to collect down to the maximum of ");
            stringBuilder2.append(params4.maximumSequenceNumbersToCollect);
            stringBuilder2.append(" from ");
            stringBuilder2.append(maximumSequenceNumbersToCollect);
            Logger.debug(rOOT, stringBuilder2.toString(), new Object[0]);
            maximumSequenceNumbersToCollect = params2.maximumSequenceNumbersToCollect;
        }
        currentTimeMillis = System.currentTimeMillis();
        long nthSequenceNumber = string.getNthSequenceNumber(maximumSequenceNumbersToCollect);
        final long currentTimeMillis4 = System.currentTimeMillis();
        int targets = string.removeTargets(nthSequenceNumber, obj10);
        final long currentTimeMillis5 = System.currentTimeMillis();
        int orphanedDocuments = string.removeOrphanedDocuments(nthSequenceNumber);
        currentTimeMillis3 = System.currentTimeMillis();
        if (Logger.isDebugEnabled()) {
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("LRU Garbage Collection:\n");
            String str7 = "\tCounted targets in ";
            stringBuilder6.append(str7);
            stringBuilder6.append(currentTimeMillis - currentTimeMillis2);
            stringBuilder6.append("ms\n");
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder6.toString());
            rOOT = Locale.ROOT;
            debugEnabled = 2;
            Object[] arr = new Object[debugEnabled];
            arr[0] = Integer.valueOf(maximumSequenceNumbersToCollect);
            arr[1] = Long.valueOf(currentTimeMillis4 - currentTimeMillis);
            stringBuilder3.append(String.format(rOOT, "\tDetermined least recently used %d sequence numbers in %dms\n", arr));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder3.toString());
            Object[] arr2 = new Object[debugEnabled];
            int i10 = 0;
            arr2[i10] = Integer.valueOf(targets);
            arr2[1] = Long.valueOf(currentTimeMillis5 - currentTimeMillis4);
            stringBuilder4.append(String.format(rOOT, "\tRemoved %d targets in %dms\n", arr2));
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(stringBuilder4.toString());
            Object[] arr3 = new Object[debugEnabled];
            int i12 = 0;
            arr3[i12] = Integer.valueOf(orphanedDocuments);
            i = 1;
            arr3[i] = Long.valueOf(currentTimeMillis3 - currentTimeMillis5);
            stringBuilder5.append(String.format(rOOT, "\tRemoved %d documents in %dms\n", arr3));
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder5.toString());
            Object[] arr4 = new Object[i];
            int i4 = 0;
            arr4[i4] = Long.valueOf(currentTimeMillis3 -= currentTimeMillis2);
            stringBuilder.append(String.format(rOOT, "Total Duration: %dms", arr4));
            Logger.debug(rOOT, stringBuilder.toString(), new Object[i4]);
        }
        LruGarbageCollector.Results results = new LruGarbageCollector.Results(1, maximumSequenceNumbersToCollect, targets, orphanedDocuments);
        return results;
    }

    int calculateQueryCount(int i) {
        return (int)obj4;
    }

    com.google.firebase.firestore.local.LruGarbageCollector.Results collect(SparseArray<?> sparseArray) {
        final int i = 0;
        String str4 = "LruGarbageCollector";
        if (Long.compare(minBytesThreshold, i2) == 0) {
            Logger.debug(str4, "Garbage collection skipped; disabled", new Object[i]);
            return LruGarbageCollector.Results.DidNotRun();
        }
        long byteSize = getByteSize();
        if (Long.compare(byteSize, minBytesThreshold3) < 0) {
            StringBuilder obj8 = new StringBuilder();
            obj8.append("Garbage collection skipped; Cache size ");
            obj8.append(byteSize);
            obj8.append(" is lower than threshold ");
            obj8.append(params3.minBytesThreshold);
            Logger.debug(str4, obj8.toString(), new Object[i]);
            return LruGarbageCollector.Results.DidNotRun();
        }
        return runGarbageCollection(sparseArray);
    }

    long getByteSize() {
        return this.delegate.getByteSize();
    }

    long getNthSequenceNumber(int i) {
        if (i == 0) {
            return -1;
        }
        LruGarbageCollector.RollingSequenceNumberBuffer rollingSequenceNumberBuffer = new LruGarbageCollector.RollingSequenceNumberBuffer(i);
        x xVar = new x(rollingSequenceNumberBuffer);
        this.delegate.forEachTarget(xVar);
        a2 a2Var = new a2(rollingSequenceNumberBuffer);
        this.delegate.forEachOrphanedDocumentSequenceNumber(a2Var);
        return rollingSequenceNumberBuffer.getMaxValue();
    }

    public com.google.firebase.firestore.local.LruGarbageCollector.GCScheduler newScheduler(AsyncQueue asyncQueue, com.google.firebase.firestore.local.LocalStore localStore2) {
        LruGarbageCollector.GCScheduler gCScheduler = new LruGarbageCollector.GCScheduler(this, asyncQueue, localStore2);
        return gCScheduler;
    }

    int removeOrphanedDocuments(long l) {
        return this.delegate.removeOrphanedDocuments(l);
    }

    int removeTargets(long l, SparseArray<?> sparseArray2) {
        return this.delegate.removeTargets(l, sparseArray2);
    }
}
