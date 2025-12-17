package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0008\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u000b\"\u00020\u0003H'¢\u0006\u0002\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "", "getRecommenceOrderOrEmpty", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "dogId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramListForDog", "insert", "", "items", "", "([Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;)V", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface y {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static Object a(e.a.a.a.b.b.y y, String string2, d<? super RecommendedListOrderEntity> d3) {
            boolean aVar;
            int label;
            int i;
            int i2;
            Object obj4;
            Object obj5;
            Object obj6;
            aVar = d3;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof y.a.a && label & i != 0) {
                aVar = d3;
                label = aVar.label;
                i = Integer.MIN_VALUE;
                if (label & i != 0) {
                    aVar.label = label -= i;
                } else {
                    aVar = new y.a.a(d3);
                }
            } else {
            }
            obj6 = aVar.result;
            Object obj = b.d();
            int label2 = aVar.label;
            int i3 = 1;
            if (label2 != 0) {
                if (label2 != i3) {
                } else {
                    obj5 = obj4;
                    q.b(obj6);
                    if ((RecommendedListOrderEntity)obj6 == null) {
                        obj6 = new RecommendedListOrderEntity(obj5, p.g());
                    }
                    return obj6;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(obj6);
            aVar.L$0 = string2;
            aVar.label = i3;
            if (y.c(string2, aVar) == obj) {
                return obj;
            }
        }
    }
    public abstract void a(RecommendedListOrderEntity... recommendedListOrderEntityArr);

    public abstract Object b(String string, d<? super RecommendedListOrderEntity> d2);

    public abstract Object c(String string, d<? super RecommendedListOrderEntity> d2);
}
