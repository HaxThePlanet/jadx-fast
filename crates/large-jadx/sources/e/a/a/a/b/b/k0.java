package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity.Companion;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ%\u0010\r\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;", "", "deleteEntity", "", "entity", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "doesEntityExists", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntity", "getEntityOrEmpty", "insertEntity", "", "([Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface k0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static Object a(e.a.a.a.b.b.k0 k0, String string2, d<? super TrainingStreakEntity> d3) {
            boolean aVar;
            int label;
            int i2;
            int i;
            Object obj5;
            Object obj6;
            Object obj7;
            aVar = d3;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (d3 instanceof k0.a.a && label & i2 != 0) {
                aVar = d3;
                label = aVar.label;
                i2 = Integer.MIN_VALUE;
                if (label & i2 != 0) {
                    aVar.label = label -= i2;
                } else {
                    aVar = new k0.a.a(d3);
                }
            } else {
            }
            obj7 = aVar.result;
            Object obj = b.d();
            int label2 = aVar.label;
            int i3 = 2;
            final int i4 = 1;
            if (label2 != 0) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        q.b(obj7);
                        return obj7;
                    }
                    obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj5;
                }
                obj6 = obj5;
                obj5 = aVar.L$0;
                q.b(obj7);
            } else {
                q.b(obj7);
                aVar.L$0 = k0;
                aVar.L$1 = string2;
                aVar.label = i4;
                if (k0.a(string2, aVar) == obj) {
                    return obj;
                }
            }
            obj7 = 0;
            aVar.L$0 = obj7;
            aVar.L$1 = obj7;
            aVar.label = i3;
            if ((Boolean)obj7.booleanValue() && obj5.d(obj6, aVar) == obj) {
                obj7 = 0;
                aVar.L$0 = obj7;
                aVar.L$1 = obj7;
                aVar.label = i3;
                if (obj5.d(obj6, aVar) == obj) {
                    return obj;
                }
            }
            return TrainingStreakEntity.Companion.emptyInstance(obj6);
        }
    }
    public abstract Object a(String string, d<? super Boolean> d2);

    public abstract Object b(TrainingStreakEntity[] trainingStreakEntityArr, d<? super w> d2);

    public abstract Object c(String string, d<? super TrainingStreakEntity> d2);

    public abstract Object d(String string, d<? super TrainingStreakEntity> d2);
}
