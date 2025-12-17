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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0008\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0014\u0010\u0008\u001a\u0004\u0018\u00010\u00042\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J \u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0007J \u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0007J\u0016\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J \u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/converter/DataConverter;", "", "()V", "fromBooleanList", "", "array", "", "", "fromGoalNotReachedState", "item", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity$GoalNotReachedState;", "fromProgramCompatibilityList", "list", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "fromStringList", "fromStringLongMap", "map", "", "", "fromStringMap", "toBooleanList", "flatArray", "toGoalNotReachedState", "itemString", "toProgramCompatibilityList", "flatMap", "toStringList", "toStringLongMap", "toStringMap", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {
    public final String a(List<Boolean> list) {
        n.f(list, "array");
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = aVar.b().d(t.j(List.class, Boolean.class));
        n.e(fVar, "moshi.adapter(type)");
        p.w0(list);
        final String obj6 = fVar.h(list);
        n.e(obj6, "adapter.toJson(array.requireNoNulls())");
        return obj6;
    }

    public final String b(UserStateEntity.GoalNotReachedState userStateEntity$GoalNotReachedState) {
        if (goalNotReachedState == null) {
            return null;
        }
        r.a aVar = new r.a();
        b bVar = new b();
        aVar.a(bVar);
        f fVar = aVar.b().c(UserStateEntity.GoalNotReachedState.class);
        n.e(fVar, "moshi.adapter(UserStateEntity.GoalNotReachedState::class.java)");
        return fVar.h(goalNotReachedState);
    }

    public final String c(List<RecommendedListOrderEntity.ProgramCompatibility> list) {
        if (list == null) {
            return null;
        }
        r.a aVar = new r.a();
        b bVar = new b();
        aVar.a(bVar);
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = aVar.b().d(t.j(List.class, RecommendedListOrderEntity.ProgramCompatibility.class));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(list);
    }

    public final String d(List<String> list) {
        n.f(list, "array");
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = aVar.b().d(t.j(List.class, String.class));
        n.e(fVar, "moshi.adapter(type)");
        p.w0(list);
        final String obj6 = fVar.h(list);
        n.e(obj6, "adapter.toJson(array.requireNoNulls())");
        return obj6;
    }

    public final String e(Map<String, Long> map) {
        if (map == null) {
            return null;
        }
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[2];
        f fVar = aVar.b().d(t.j(Map.class, String.class, Long.class));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(map);
    }

    public final String f(Map<String, String> map) {
        Class<String> obj = String.class;
        if (map == null) {
            return null;
        }
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[2];
        f fVar = aVar.b().d(t.j(Map.class, obj, obj));
        n.e(fVar, "moshi.adapter(type)");
        return fVar.h(map);
    }

    public final List<Boolean> g(String string) {
        int i;
        Object obj6;
        n.f(string, "flatArray");
        int i2 = 1;
        final int i3 = 0;
        i = string.length() == 0 ? i2 : i3;
        if (i != 0) {
            return p.g();
        }
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[i2];
        arr[i3] = Boolean.class;
        f fVar = aVar.b().d(t.j(List.class, arr));
        n.e(fVar, "moshi.adapter(type)");
        obj6 = fVar.c(string);
        if ((List)obj6 == null) {
            obj6 = 0;
        } else {
            p.w0((List)obj6);
        }
        if (obj6 == null) {
            obj6 = p.g();
        }
        return obj6;
    }

    public final UserStateEntity.GoalNotReachedState h(String string) {
        if (string == null) {
            return null;
        }
        r.a aVar = new r.a();
        b bVar = new b();
        aVar.a(bVar);
        f fVar = aVar.b().c(UserStateEntity.GoalNotReachedState.class);
        n.e(fVar, "moshi.adapter(UserStateEntity.GoalNotReachedState::class.java)");
        return (UserStateEntity.GoalNotReachedState)fVar.c(string);
    }

    public final List<RecommendedListOrderEntity.ProgramCompatibility> i(String string) {
        int i;
        int i2;
        int i3;
        Object obj6;
        if (string != null) {
            i2 = 1;
            i3 = 0;
            i = string.length() == 0 ? i2 : i3;
            if (i != 0) {
            } else {
                r.a aVar = new r.a();
                b bVar = new b();
                aVar.a(bVar);
                java.lang.reflect.Type[] arr = new Type[i2];
                arr[i3] = RecommendedListOrderEntity.ProgramCompatibility.class;
                f fVar = aVar.b().d(t.j(List.class, arr));
                n.e(fVar, "moshi.adapter(type)");
                if ((List)fVar.c(string) == null) {
                    obj6 = p.g();
                }
            }
            return obj6;
        }
        return 0;
    }

    public final List<String> j(String string) {
        int i;
        Object obj6;
        n.f(string, "flatArray");
        int i2 = 1;
        final int i3 = 0;
        i = string.length() == 0 ? i2 : i3;
        if (i != 0) {
            return p.g();
        }
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[i2];
        arr[i3] = String.class;
        f fVar = aVar.b().d(t.j(List.class, arr));
        n.e(fVar, "moshi.adapter(type)");
        obj6 = fVar.c(string);
        if ((List)obj6 == null) {
            obj6 = 0;
        } else {
            p.w0((List)obj6);
        }
        if (obj6 == null) {
            obj6 = p.g();
        }
        return obj6;
    }

    public final Map<String, Long> k(String string) {
        int i2;
        int i3;
        int i;
        Object obj7;
        if (string != null) {
            i3 = 1;
            i = 0;
            i2 = string.length() == 0 ? i3 : i;
            if (i2 != 0) {
            } else {
                r.a aVar = new r.a();
                java.lang.reflect.Type[] arr = new Type[2];
                arr[i] = String.class;
                arr[i3] = Long.class;
                f fVar = aVar.b().d(t.j(Map.class, arr));
                n.e(fVar, "moshi.adapter(type)");
                if ((Map)fVar.c(string) == null) {
                    obj7 = j0.h();
                }
            }
            return obj7;
        }
        return 0;
    }

    public final Map<String, String> l(String string) {
        int i;
        int i2;
        int i3;
        Object obj7;
        Class<String> obj = String.class;
        if (string != null) {
            i2 = 1;
            i3 = 0;
            i = string.length() == 0 ? i2 : i3;
            if (i != 0) {
            } else {
                r.a aVar = new r.a();
                java.lang.reflect.Type[] arr = new Type[2];
                arr[i3] = obj;
                arr[i2] = obj;
                f fVar = aVar.b().d(t.j(Map.class, arr));
                n.e(fVar, "moshi.adapter(type)");
                if ((Map)fVar.c(string) == null) {
                    obj7 = j0.h();
                }
            }
            return obj7;
        }
        return 0;
    }
}
