package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.y.p;

/* compiled from: DogRecommendedProgramOrderDao.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0008\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u000b\"\u00020\u0003H'¢\u0006\u0002\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "", "getRecommenceOrderOrEmpty", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "dogId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramListForDog", "insert", "", "items", "", "([Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;)V", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y, reason: from kotlin metadata */
public interface DogRecommendedProgramOrderDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static Object a(y yVar, String str, d<? super RecommendedListOrderEntity> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int i2;
            Object yVar2;
            Object result2;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.y.a.a;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.y.a.a) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.y.a.a aVar = new app.dogo.android.persistencedb.room.dao.y.a.a(dVar);
                }
            }
            Object obj = b.d();
            int i3 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar32.result);
                    if ((RecommendedListOrderEntity)result2 == null) {
                        RecommendedListOrderEntity recommendedListOrderEntity = new RecommendedListOrderEntity(str, p.g());
                    }
                    return result2;
                }
            }
            q.b(dVar32.result);
            dVar32.L$0 = str;
            dVar32.label = i3;
            if (yVar.c(str, dVar32) == obj) {
                return obj;
            }
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ void getRecommenceOrderOrEmpty(RecommendedListOrderEntity... dogId);

    Object b(String str, d<? super RecommendedListOrderEntity> dVar);

    Object c(String str, d<? super RecommendedListOrderEntity> dVar);
}
