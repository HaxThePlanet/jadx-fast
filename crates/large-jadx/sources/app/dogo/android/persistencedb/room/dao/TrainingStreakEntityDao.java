package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity.Companion;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.w;

/* compiled from: TrainingStreakEntityDao.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ%\u0010\r\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;", "", "deleteEntity", "", "entity", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "doesEntityExists", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntity", "getEntityOrEmpty", "insertEntity", "", "([Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k0, reason: from kotlin metadata */
public interface TrainingStreakEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static Object a(k0 k0Var, String str, d<? super TrainingStreakEntity> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int i2;
            Object obj;
            Object result2;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.k0.a.a;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.k0.a.a) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.k0.a.a aVar = new app.dogo.android.persistencedb.room.dao.k0.a.a(dVar);
                }
            }
            Object obj2 = b.d();
            int i3 = 2;
            final int i4 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i4) {
                    if (dVar32.label != i3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar32.result);
                        return result2;
                    }
                }
                q.b(dVar32.result);
            } else {
                q.b(dVar32.result);
                dVar32.L$0 = k0Var;
                dVar32.L$1 = str;
                dVar32.label = i4;
                if (k0Var.a(str, dVar32) == obj2) {
                    return obj2;
                }
            }
            if ((Boolean)result2.booleanValue()) {
                Object obj3 = null;
                dVar32.L$0 = obj3;
                dVar32.L$1 = obj3;
                dVar32.label = i3;
                return obj.d(str, dVar32) == obj2 ? obj2 : result2;
            }
            return TrainingStreakEntity.INSTANCE.emptyInstance(str);
        }
    }
    Object a(String str, d<? super Boolean> dVar);

    Object b(TrainingStreakEntity[] trainingStreakEntityArr, d<? super w> dVar);

    Object c(String str, d<? super TrainingStreakEntity> dVar);

    Object d(String str, d<? super TrainingStreakEntity> dVar);
}
