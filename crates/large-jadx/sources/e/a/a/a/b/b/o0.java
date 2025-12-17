package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData;
import i.b.a0;
import i.b.b;
import i.b.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001c\u0010\u0008\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0003H'J\u001e\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0003H'J\u000e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016J'\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0018\"\u00020\nH'¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u0018\"\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00162\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\tH\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0019H'J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001fH'\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "", "doesTrickProgressExists", "Lio/reactivex/Single;", "", "dogId", "", "trickId", "getAllDogTrickKnowledge", "", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "getAllTrickData", "getDogTrickKnowledge", "getLatestTrickKnowledge", "getLatestTrickKnowledgeTimestamp", "", "getRecentlyViewedTrick", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickKnowledgeOrZero", "insertTrickKnowledge", "Lio/reactivex/Completable;", "entities", "", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;)Lio/reactivex/Completable;", "insertTrickProgressCompletable", "allProgressEntity", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;)Lio/reactivex/Completable;", "insertTrickViewed", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;)Lio/reactivex/Completable;", "updateLatestTrickKnowledge", "updateTrickKnowledge", "obj", "updateTrickView", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface o0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeRateData... trickProgressEntity$TrickKnowledgeRateData2Arr2) {
            int i;
            b flatMapCompletable;
            a0 a0Var;
            e.a.a.a.b.b.i iVar;
            n.f(o0, "this");
            n.f(trickKnowledgeRateData2Arr2, "entities");
            ArrayList arrayList = new ArrayList(trickKnowledgeRateData2Arr2.length);
            final int i2 = 0;
            i = i2;
            while (i < trickKnowledgeRateData2Arr2.length) {
                Object obj = trickKnowledgeRateData2Arr2[i];
                iVar = new i(o0, obj);
                arrayList.add(o0.f(obj.getDogId(), obj.getTrickId()).flatMapCompletable(iVar));
                i++;
            }
            Object[] obj7 = arrayList.toArray(new b[i2]);
            Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Array<T>");
            obj7 = b.p((f[])Arrays.copyOf((b[])obj7, obj7.length));
            n.e(obj7, "mergeArray(*entities.map { entity ->\n            doesTrickProgressExists(entity.dogId, entity.trickId).flatMapCompletable { exists ->\n                if (exists) {\n                    updateTrickKnowledge(entity)\n                } else {\n                    insertTrickProgressCompletable(TrickProgressEntity(\n                        trickId = entity.trickId,\n                        dogId = entity.dogId,\n                        updatedAt = entity.updatedAt,\n                        lastRatedAt = entity.lastRatedAt,\n                        knowledge = entity.knowledge,\n                    ))\n                }\n            }\n        }.toTypedArray())");
            return obj7;
        }

        private static f b(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData2, Boolean boolean3) {
            String str;
            TrickProgressEntity trickProgressEntity2;
            String trickId;
            String dogId;
            long updatedAt;
            int i3;
            Long valueOf;
            long knowledge;
            int i;
            int i2;
            TrickProgressEntity trickProgressEntity;
            b obj12;
            boolean obj14;
            n.f(o0, "this$0");
            n.f(trickKnowledgeRateData2, "$entity");
            n.f(boolean3, "exists");
            if (boolean3.booleanValue()) {
                obj12 = o0.h(trickKnowledgeRateData2);
            } else {
                obj14 = new TrickProgressEntity[1];
                super(trickKnowledgeRateData2.getTrickId(), trickKnowledgeRateData2.getDogId(), trickKnowledgeRateData2.getUpdatedAt(), obj5, 0, Long.valueOf(trickKnowledgeRateData2.getLastRatedAt()), trickKnowledgeRateData2.getKnowledge(), 8, 0);
                obj12 = o0.j(trickProgressEntity);
            }
            return obj12;
        }

        public static b c(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeViewData... trickProgressEntity$TrickKnowledgeViewData2Arr2) {
            int i;
            b flatMapCompletable;
            a0 a0Var;
            e.a.a.a.b.b.j jVar;
            n.f(o0, "this");
            n.f(trickKnowledgeViewData2Arr2, "entities");
            ArrayList arrayList = new ArrayList(trickKnowledgeViewData2Arr2.length);
            final int i2 = 0;
            i = i2;
            while (i < trickKnowledgeViewData2Arr2.length) {
                Object obj = trickKnowledgeViewData2Arr2[i];
                jVar = new j(o0, obj);
                arrayList.add(o0.f(obj.getDogId(), obj.getTrickId()).flatMapCompletable(jVar));
                i++;
            }
            Object[] obj7 = arrayList.toArray(new b[i2]);
            Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Array<T>");
            obj7 = b.p((f[])Arrays.copyOf((b[])obj7, obj7.length));
            n.e(obj7, "mergeArray(*entities.map { entity ->\n            doesTrickProgressExists(entity.dogId, entity.trickId).flatMapCompletable { exists ->\n                if (exists) {\n                    updateTrickView(entity)\n                } else {\n                    insertTrickProgressCompletable(TrickProgressEntity(\n                        trickId = entity.trickId,\n                        dogId = entity.dogId,\n                        updatedAt = entity.updatedAt,\n                        lastViewedAt = entity.lastViewedAt,\n                        knowledge = 0,\n                    ))\n                }\n            }\n        }.toTypedArray())");
            return obj7;
        }

        private static f d(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData2, Boolean boolean3) {
            String str;
            TrickProgressEntity trickProgressEntity2;
            String trickId;
            String dogId;
            long updatedAt;
            Long valueOf;
            long l;
            int i2;
            int i3;
            int i;
            TrickProgressEntity trickProgressEntity;
            b obj12;
            boolean obj14;
            n.f(o0, "this$0");
            n.f(trickKnowledgeViewData2, "$entity");
            n.f(boolean3, "exists");
            if (boolean3.booleanValue()) {
                obj12 = o0.e(trickKnowledgeViewData2);
            } else {
                obj14 = new TrickProgressEntity[1];
                super(trickKnowledgeViewData2.getTrickId(), trickKnowledgeViewData2.getDogId(), trickKnowledgeViewData2.getUpdatedAt(), obj5, Long.valueOf(trickKnowledgeViewData2.getLastViewedAt()), 0, 0, 16, 0);
                obj12 = o0.j(trickProgressEntity);
            }
            return obj12;
        }

        public static f e(List list, e.a.a.a.b.b.o0 o02, List list3) {
            return o0.a.i(list, o02, list3);
        }

        public static f f(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData2, Boolean boolean3) {
            return o0.a.b(o0, trickKnowledgeRateData2, boolean3);
        }

        public static f g(e.a.a.a.b.b.o0 o0, TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData2, Boolean boolean3) {
            return o0.a.d(o0, trickKnowledgeViewData2, boolean3);
        }

        public static b h(e.a.a.a.b.b.o0 o0, List<TrickProgressEntity.TrickKnowledgeRateData> list2) {
            n.f(o0, "this");
            n.f(list2, "allProgressEntity");
            h hVar = new h(list2, o0);
            final b obj2 = o0.g().flatMapCompletable(hVar);
            n.e(obj2, "getAllTrickData().flatMapCompletable { savedKnowledge ->\n            val filteredList = allProgressEntity.sortedByDescending { it.updatedAt }\n                .distinctBy { it.trickId }\n                .filter { trick ->\n                    trick.lastRatedAt > savedKnowledge.find { it.trickId == trick.trickId && it.dogId == trick.dogId }?.lastRatedAt ?: 0\n                }\n            insertTrickKnowledge(*filteredList.toTypedArray())\n        }");
            return obj2;
        }

        private static f i(List list, e.a.a.a.b.b.o0 o02, List list3) {
            ArrayList arrayList;
            Object next3;
            boolean next2;
            boolean cmp;
            Object lastRatedAt;
            long lastRatedAt2;
            Iterator iterator;
            int next;
            int i;
            int longValue;
            Object obj;
            boolean dogId;
            String trickId;
            n.f(list, "$allProgressEntity");
            n.f(o02, "this$0");
            n.f(list3, "savedKnowledge");
            o0.a.a aVar = new o0.a.a();
            HashSet hashSet = new HashSet();
            arrayList = new ArrayList();
            Iterator obj12 = p.D0(list, aVar).iterator();
            while (obj12.hasNext()) {
                next3 = obj12.next();
                if (hashSet.add((TrickProgressEntity.TrickKnowledgeRateData)next3.getTrickId())) {
                }
                arrayList.add(next3);
            }
            obj12 = new ArrayList();
            Iterator iterator2 = arrayList.iterator();
            next2 = 0;
            for (Object arrayList : iterator2) {
                lastRatedAt = arrayList;
                iterator = list3.iterator();
                i = 1;
                while (iterator.hasNext()) {
                    obj = next;
                    if (n.b((TrickProgressEntity)obj.getTrickId(), lastRatedAt.getTrickId()) && n.b(obj.getDogId(), lastRatedAt.getDogId())) {
                    } else {
                    }
                    longValue = next2;
                    i = 1;
                    if (n.b(obj.getDogId(), lastRatedAt.getDogId())) {
                    } else {
                    }
                    longValue = i;
                }
                next = 0;
                longValue = 0;
                if ((TrickProgressEntity)next == 0) {
                } else {
                }
                lastRatedAt = (TrickProgressEntity)next.getLastRatedAt();
                if (lastRatedAt == null) {
                } else {
                }
                longValue = lastRatedAt.longValue();
                if (Long.compare(lastRatedAt2, longValue) > 0) {
                }
                if (next2) {
                }
                next2 = 0;
                obj12.add(arrayList);
                next2 = i;
                obj = next;
                if (n.b((TrickProgressEntity)obj.getTrickId(), lastRatedAt.getTrickId()) && n.b(obj.getDogId(), lastRatedAt.getDogId())) {
                } else {
                }
                longValue = next2;
                if (longValue != 0) {
                } else {
                }
                if (n.b(obj.getDogId(), lastRatedAt.getDogId())) {
                } else {
                }
                longValue = i;
            }
            obj12 = obj12.toArray(new TrickProgressEntity.TrickKnowledgeRateData[next2]);
            Objects.requireNonNull(obj12, "null cannot be cast to non-null type kotlin.Array<T>");
            return o02.a((TrickProgressEntity.TrickKnowledgeRateData[])Arrays.copyOf((TrickProgressEntity.TrickKnowledgeRateData[])obj12, obj12.length));
        }
    }
    public abstract b a(TrickProgressEntity.TrickKnowledgeRateData... trickProgressEntity$TrickKnowledgeRateDataArr);

    public abstract b b(List<TrickProgressEntity.TrickKnowledgeRateData> list);

    public abstract Object c(String string, int i2, d<? super List<TrickProgressEntity>> d3);

    public abstract a0<List<TrickProgressEntity>> d(String string);

    public abstract b e(TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData);

    public abstract a0<Boolean> f(String string, String string2);

    public abstract a0<List<TrickProgressEntity>> g();

    public abstract b h(TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData);

    public abstract b i(TrickProgressEntity.TrickKnowledgeViewData... trickProgressEntity$TrickKnowledgeViewDataArr);

    public abstract b j(TrickProgressEntity... trickProgressEntityArr);
}
