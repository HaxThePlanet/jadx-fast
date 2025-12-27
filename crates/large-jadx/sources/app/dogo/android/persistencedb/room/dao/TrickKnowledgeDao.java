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

/* compiled from: TrickKnowledgeDao.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001c\u0010\u0008\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0003H'J\u001e\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0003H'J\u000e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016J'\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0018\"\u00020\nH'¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u0018\"\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00162\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\tH\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0019H'J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001fH'\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "", "doesTrickProgressExists", "Lio/reactivex/Single;", "", "dogId", "", "trickId", "getAllDogTrickKnowledge", "", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "getAllTrickData", "getDogTrickKnowledge", "getLatestTrickKnowledge", "getLatestTrickKnowledgeTimestamp", "", "getRecentlyViewedTrick", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickKnowledgeOrZero", "insertTrickKnowledge", "Lio/reactivex/Completable;", "entities", "", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;)Lio/reactivex/Completable;", "insertTrickProgressCompletable", "allProgressEntity", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;)Lio/reactivex/Completable;", "insertTrickViewed", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;", "([Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;)Lio/reactivex/Completable;", "updateLatestTrickKnowledge", "updateTrickKnowledge", "obj", "updateTrickView", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o0, reason: from kotlin metadata */
public interface TrickKnowledgeDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(o0 o0Var, TrickProgressEntity.TrickKnowledgeRateData... trickKnowledgeRateDataArr) {
            int i;
            n.f(o0Var, "this");
            n.f(trickKnowledgeRateDataArr, "entities");
            ArrayList arrayList = new ArrayList(trickKnowledgeRateDataArr.length);
            i = 0;
            for (Object obj : trickKnowledgeRateDataArr) {
                arrayList.add(o0Var.doesTrickProgressExists(obj.getDogId(), obj.getTrickId()).flatMapCompletable(new app.dogo.android.persistencedb.room.dao.i(o0Var, obj)));
            }
            Object[] array = arrayList.toArray(new b[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            b bVar = b.p((f[])Arrays.copyOf(array, array.length));
            n.e(bVar, "mergeArray(*entities.map { entity ->\n            doesTrickProgressExists(entity.dogId, entity.trickId).flatMapCompletable { exists ->\n                if (exists) {\n                    updateTrickKnowledge(entity)\n                } else {\n                    insertTrickProgressCompletable(TrickProgressEntity(\n                        trickId = entity.trickId,\n                        dogId = entity.dogId,\n                        updatedAt = entity.updatedAt,\n                        lastRatedAt = entity.lastRatedAt,\n                        knowledge = entity.knowledge,\n                    ))\n                }\n            }\n        }.toTypedArray())");
            return bVar;
        }

        private static f b(o0 o0Var, TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData, Boolean boolean) {
            b latestTrickKnowledge;
            n.f(o0Var, "this$0");
            n.f(trickKnowledgeRateData, "$entity");
            str = "exists";
            n.f(boolean, str);
            if (boolean.booleanValue()) {
                latestTrickKnowledge = o0Var.updateLatestTrickKnowledge(trickKnowledgeRateData);
            } else {
                TrickProgressEntity[] arr = new TrickProgressEntity[1];
                Long l = null;
                kotlin.d0.d.g gVar = 8;
                int i = 0;
                TrickProgressEntity trickProgressEntity = new TrickProgressEntity(trickKnowledgeRateData.getTrickId(), trickKnowledgeRateData.getDogId(), trickKnowledgeRateData.getUpdatedAt(), l2, l, Long.valueOf(trickKnowledgeRateData.getLastRatedAt()), trickKnowledgeRateData.getKnowledge(), gVar, i);
                latestTrickKnowledge = o0Var.updateTrickView(trickProgressEntity);
            }
            return latestTrickKnowledge;
        }

        public static b c(o0 o0Var, TrickProgressEntity.TrickKnowledgeViewData... trickKnowledgeViewDataArr) {
            int i;
            n.f(o0Var, "this");
            n.f(trickKnowledgeViewDataArr, "entities");
            ArrayList arrayList = new ArrayList(trickKnowledgeViewDataArr.length);
            i = 0;
            for (Object obj : trickKnowledgeViewDataArr) {
                arrayList.add(o0Var.doesTrickProgressExists(obj.getDogId(), obj.getTrickId()).flatMapCompletable(new app.dogo.android.persistencedb.room.dao.j(o0Var, obj)));
            }
            Object[] array = arrayList.toArray(new b[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            b bVar = b.p((f[])Arrays.copyOf(array, array.length));
            n.e(bVar, "mergeArray(*entities.map { entity ->\n            doesTrickProgressExists(entity.dogId, entity.trickId).flatMapCompletable { exists ->\n                if (exists) {\n                    updateTrickView(entity)\n                } else {\n                    insertTrickProgressCompletable(TrickProgressEntity(\n                        trickId = entity.trickId,\n                        dogId = entity.dogId,\n                        updatedAt = entity.updatedAt,\n                        lastViewedAt = entity.lastViewedAt,\n                        knowledge = 0,\n                    ))\n                }\n            }\n        }.toTypedArray())");
            return bVar;
        }

        private static f d(o0 o0Var, TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData, Boolean boolean) {
            b trickViewed;
            n.f(o0Var, "this$0");
            n.f(trickKnowledgeViewData, "$entity");
            str = "exists";
            n.f(boolean, str);
            if (boolean.booleanValue()) {
                trickViewed = o0Var.insertTrickViewed(trickKnowledgeViewData);
            } else {
                TrickProgressEntity[] arr = new TrickProgressEntity[1];
                int i = 0;
                int i2 = 0;
                kotlin.d0.d.g gVar = 16;
                int i3 = 0;
                TrickProgressEntity trickProgressEntity = new TrickProgressEntity(trickKnowledgeViewData.getTrickId(), trickKnowledgeViewData.getDogId(), trickKnowledgeViewData.getUpdatedAt(), l, Long.valueOf(trickKnowledgeViewData.getLastViewedAt()), i, i2, gVar, i3);
                trickViewed = o0Var.updateTrickView(trickProgressEntity);
            }
            return trickViewed;
        }

        public static b h(o0 o0Var, List<TrickProgressEntity.TrickKnowledgeRateData> list) {
            n.f(o0Var, "this");
            n.f(list, "allProgressEntity");
            final b flatMapCompletable = o0Var.getAllTrickData().flatMapCompletable(new app.dogo.android.persistencedb.room.dao.h(list, o0Var));
            n.e(flatMapCompletable, "getAllTrickData().flatMapCompletable { savedKnowledge ->\n            val filteredList = allProgressEntity.sortedByDescending { it.updatedAt }\n                .distinctBy { it.trickId }\n                .filter { trick ->\n                    trick.lastRatedAt > savedKnowledge.find { it.trickId == trick.trickId && it.dogId == trick.dogId }?.lastRatedAt ?: 0\n                }\n            insertTrickKnowledge(*filteredList.toTypedArray())\n        }");
            return flatMapCompletable;
        }

        private static f i(List list, o0 o0Var, List list2) {
            boolean hasNext = false;
            boolean cmp;
            int i2;
            int i = 1;
            boolean z;
            String trickId;
            n.f(list, "$allProgressEntity");
            n.f(o0Var, "this$0");
            n.f(list2, "savedKnowledge");
            ArrayList arrayList = new ArrayList();
            Iterator it3 = p.D0(list, new app.dogo.android.persistencedb.room.dao.o0.a.a()).iterator();
            while (it3.hasNext()) {
                Object item = it3.next();
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            i = 0;
            while (it2.hasNext()) {
                arrayList = it2.next();
                long lastRatedAt2 = arrayList.getLastRatedAt();
                Iterator it = list2.iterator();
                i = 1;
                while (it.hasNext()) {
                    if (i != 0) {
                        break loop_7;
                    }
                }
                i2 = 0;
                i = 0;
            }
            Object[] array = arrayList2.toArray(new TrickProgressEntity.TrickKnowledgeRateData[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return o0Var.getAllDogTrickKnowledge((TrickProgressEntity.TrickKnowledgeRateData[])Arrays.copyOf(array, array.length));
        }

        public static /* synthetic */ f e(List list, o0 o0Var, List list2) {
            return app.dogo.android.persistencedb.room.dao.o0.a.i(list, o0Var, list2);
        }

        public static /* synthetic */ f f(o0 o0Var, TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData, Boolean boolean) {
            return app.dogo.android.persistencedb.room.dao.o0.a.b(o0Var, trickKnowledgeRateData, boolean);
        }

        public static /* synthetic */ f g(o0 o0Var, TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData, Boolean boolean) {
            return app.dogo.android.persistencedb.room.dao.o0.a.d(o0Var, trickKnowledgeViewData, boolean);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    b getAllDogTrickKnowledge(TrickProgressEntity.TrickKnowledgeRateData... dogId);

    /* renamed from: b, reason: from kotlin metadata */
    b insertTrickKnowledge(List<TrickProgressEntity.TrickKnowledgeRateData> entities);

    Object c(String str, int i, d<? super List<TrickProgressEntity>> dVar);

    /* renamed from: d, reason: from kotlin metadata */
    a0<List<TrickProgressEntity>> insertTrickProgressCompletable(String allProgressEntity);

    /* renamed from: e, reason: from kotlin metadata */
    b insertTrickViewed(TrickProgressEntity.TrickKnowledgeViewData entities);

    /* renamed from: f, reason: from kotlin metadata */
    a0<Boolean> doesTrickProgressExists(String dogId, String trickId);

    /* renamed from: g, reason: from kotlin metadata */
    a0<List<TrickProgressEntity>> getAllTrickData();

    /* renamed from: h, reason: from kotlin metadata */
    b updateLatestTrickKnowledge(TrickProgressEntity.TrickKnowledgeRateData allProgressEntity);

    /* renamed from: i, reason: from kotlin metadata */
    b updateTrickKnowledge(TrickProgressEntity.TrickKnowledgeViewData... obj);

    /* renamed from: j, reason: from kotlin metadata */
    b updateTrickView(TrickProgressEntity... obj);
}
