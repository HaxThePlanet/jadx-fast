package e.a.a.a.b.a;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility;
import app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState;
import com.squareup.moshi.f;
import com.squareup.moshi.r;
import com.squareup.moshi.r.a;
import com.squareup.moshi.t;
import com.squareup.moshi.w.a.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: DataConverter.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0008\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0014\u0010\u0008\u001a\u0004\u0018\u00010\u00042\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J \u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0007J \u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0007J\u0016\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J \u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/converter/DataConverter;", "", "()V", "fromBooleanList", "", "array", "", "", "fromGoalNotReachedState", "item", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "fromProgramCompatibilityList", "list", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "fromStringList", "fromStringLongMap", "map", "", "", "fromStringMap", "toBooleanList", "flatArray", "toGoalNotReachedState", "itemString", "toProgramCompatibilityList", "flatMap", "toStringList", "toStringLongMap", "toStringMap", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class DataConverter {
    /* renamed from: a, reason: from kotlin metadata */
    public final String fromBooleanList(List<Boolean> array) {
        n.f(array, "array");
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = new r.a().b().d(t.j(List.class, new Type[] { Boolean.class }));
        n.e(fVar, "moshi.adapter(type)");
        p.w0(array);
        final String str4 = fVar.h(array);
        n.e(str4, "adapter.toJson(array.requireNoNulls())");
        return str4;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final String fromGoalNotReachedState(UserStateEntity.GoalNotReachedState item) {
        if (item == null) {
            return null;
        }
        r.a aVar = new r.a();
        aVar.a(new b());
        f fVar = aVar.b().c(UserStateEntity_GoalNotReachedState.class);
        n.e(fVar, "moshi.adapter(UserStateEntity.GoalNotReachedState::class.java)");
        return fVar.h(item);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final String fromProgramCompatibilityList(List<RecommendedListOrderEntity.ProgramCompatibility> list) {
        if (list == null) {
            return null;
        }
        r.a aVar = new r.a();
        aVar.a(new b());
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = aVar.b().d(t.j(List.class, new Type[] { RecommendedListOrderEntity_ProgramCompatibility.class }));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(list);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final String fromStringList(List<String> array) {
        n.f(array, "array");
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = new r.a().b().d(t.j(List.class, new Type[] { String.class }));
        n.e(fVar, "moshi.adapter(type)");
        p.w0(array);
        final String str4 = fVar.h(array);
        n.e(str4, "adapter.toJson(array.requireNoNulls())");
        return str4;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final String fromStringLongMap(Map<String, Long> map) {
        if (map == null) {
            return null;
        }
        java.lang.reflect.Type[] arr = new Type[2];
        f fVar = new r.a().b().d(t.j(Map.class, new Type[] { String.class, Long.class }));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(map);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final String fromStringMap(Map<String, String> map) {
        Class<String> obj = String.class;
        if (map == null) {
            return null;
        }
        java.lang.reflect.Type[] arr = new Type[2];
        f fVar = new r.a().b().d(t.j(Map.class, new Type[] { obj, obj }));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(map);
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final List<Boolean> toBooleanList(String flatArray) {
        int i;
        Object obj = null;
        n.f(flatArray, "flatArray");
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            return p.g();
        }
        java.lang.reflect.Type[] arr = new Type[i];
        f fVar = new r.a().b().d(t.j(List.class, new Type[] { Boolean.class }));
        n.e(fVar, "moshi.adapter(type)");
        obj = fVar.c(flatArray);
        if (obj == null) {
            int i2 = 0;
        } else {
            p.w0(obj);
        }
        if (obj == null) {
            List list = p.g();
        }
        return obj;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final UserStateEntity.GoalNotReachedState toGoalNotReachedState(String itemString) {
        if (itemString == null) {
            return null;
        }
        r.a aVar = new r.a();
        aVar.a(new b());
        f fVar = aVar.b().c(UserStateEntity_GoalNotReachedState.class);
        n.e(fVar, "moshi.adapter(UserStateEntity.GoalNotReachedState::class.java)");
        return (UserStateEntity_GoalNotReachedState)fVar.c(itemString);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public final List<RecommendedListOrderEntity.ProgramCompatibility> toProgramCompatibilityList(String flatMap) {
        int i;
        Object obj;
        if (flatMap != null) {
            i = 1;
            i = 0;
            int r0 = i;
            if (i == 0) {
                r.a aVar = new r.a();
                aVar.a(new b());
                java.lang.reflect.Type[] arr = new Type[i];
                f fVar = aVar.b().d(t.j(List.class, new Type[] { RecommendedListOrderEntity_ProgramCompatibility.class }));
                n.e(fVar, "moshi.adapter(type)");
                if ((List)fVar.c(flatMap) == null) {
                    List list = p.g();
                }
            }
            return obj;
        }
        return null;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final List<String> toStringList(String flatArray) {
        int i;
        Object obj = null;
        n.f(flatArray, "flatArray");
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            return p.g();
        }
        java.lang.reflect.Type[] arr = new Type[i];
        f fVar = new r.a().b().d(t.j(List.class, new Type[] { String.class }));
        n.e(fVar, "moshi.adapter(type)");
        obj = fVar.c(flatArray);
        if (obj == null) {
            int i2 = 0;
        } else {
            p.w0(obj);
        }
        if (obj == null) {
            List list = p.g();
        }
        return obj;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final Map<String, Long> toStringLongMap(String flatMap) {
        int i;
        Object obj;
        if (flatMap != null) {
            i = 1;
            i = 0;
            int r0 = i;
            if (i == 0) {
                java.lang.reflect.Type[] arr = new Type[2];
                f fVar = new r.a().b().d(t.j(Map.class, new Type[] { String.class, Long.class }));
                n.e(fVar, "moshi.adapter(type)");
                if ((Map)fVar.c(flatMap) == null) {
                    Map map = j0.h();
                }
            }
            return obj;
        }
        return null;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final Map<String, String> toStringMap(String flatMap) {
        int i;
        Object obj;
        Class<String> obj2 = String.class;
        if (flatMap != null) {
            i = 1;
            i = 0;
            int r1 = i;
            if (i == 0) {
                java.lang.reflect.Type[] arr = new Type[2];
                f fVar = new r.a().b().d(t.j(Map.class, new Type[] { obj2, obj2 }));
                n.e(fVar, "moshi.adapter(type)");
                if ((Map)fVar.c(flatMap) == null) {
                    Map map = j0.h();
                }
            }
            return obj;
        }
        return null;
    }
}
