package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.PolicyEntity;
import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import app.dogo.android.persistencedb.room.entity.PottyReminderEntity.Companion;
import app.dogo.android.persistencedb.room.entity.ReminderEntity;
import app.dogo.android.persistencedb.room.entity.UserCurrentDogIdUpdate;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState;
import e.a.a.a.b.d.h;
import i.b.a0;
import i.b.b;
import i.b.g0;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H'J\u0008\u0010\u0005\u001a\u00020\u0003H'J\u0008\u0010\u0006\u001a\u00020\u0003H'J\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\u000bH'J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u0016\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\u0016\u001a\u00020\u000bH'J&\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\tH'J\u0016\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00082\u0006\u0010\u001a\u001a\u00020\u000bH'J\u0016\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00082\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00082\u0006\u0010\u001a\u001a\u00020\u000bH'J\u001c\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00082\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH'J&\u0010#\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\tH'J\u001b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\r\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020)H'J\u0019\u0010(\u001a\u00020*2\u0006\u0010+\u001a\u00020%H§@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u0010(\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0-\"\u00020.H'¢\u0006\u0002\u0010/J-\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002000\u00140\u00082\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00150-\"\u00020\u0015H'¢\u0006\u0002\u00101J!\u0010(\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0-\"\u00020\u001dH'¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205H'J)\u00106\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010:J!\u0010;\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010=\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006>", d2 = {"Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "", "clearAll", "Lio/reactivex/Completable;", "deletePolicies", "deleteReminders", "deleteUsers", "doesUserExists", "Lio/reactivex/Single;", "", "id", "", "doesUserHavePottyReminders", "userId", "doesUserHaveReminders", "fullInsert", "user", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "getCurrentDogId", "getDogPottyReminders", "", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "dogId", "getDogPottyRemindersWithState", "isActive", "getPottyReminder", "reminderId", "getPottyReminderOrEmpty", "getReminders", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "getTrainingReminder", "getTrainingReminderById", "getTrainingReminderOrEmpty", "getUser", "getUserPottyReminders", "getUserPottyRemindersWithState", "getUserStateEntity", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserStateEntityOrEmpty", "insert", "Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "", "entity", "(Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;", "([Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;)Lio/reactivex/Completable;", "", "([Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;)Lio/reactivex/Single;", "([Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;)Lio/reactivex/Completable;", "updateCurrentDog", "obj", "Lapp/dogo/android/persistencedb/room/entity/UserCurrentDogIdUpdate;", "updateMetricsGoalNotReachedState", "date", "durationSec", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWorkoutStreakSyncState", "state", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface q0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(e.a.a.a.b.b.q0 q0) {
            n.f(q0, "this");
            i.b.f[] arr = new f[2];
            b obj3 = b.p(q0.v(), q0.d());
            n.e(obj3, "mergeArray(deletePolicies(), deleteUsers())");
            return obj3;
        }

        public static b b(e.a.a.a.b.b.q0 q0, h h2) {
            n.f(q0, "this");
            n.f(h2, "user");
            i.b.f[] arr = new f[2];
            final int i2 = 0;
            arr[i2] = q0.b(h2.b());
            Object[] obj5 = h2.a().toArray(new PolicyEntity[i2]);
            Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Array<T>");
            arr[1] = q0.g((PolicyEntity[])Arrays.copyOf((PolicyEntity[])obj5, obj5.length));
            b obj4 = q0.r().c(b.p(arr));
            n.e(obj4, "clearAll().andThen(\n            Completable.mergeArray(\n                insert(user.user),\n                insert(*user.policies.toTypedArray())\n            )\n        )");
            return obj4;
        }

        public static a0<String> c(e.a.a.a.b.b.q0 q0, String string2) {
            n.f(q0, "this");
            n.f(string2, "userId");
            l lVar = new l(q0, string2);
            final a0 obj2 = q0.w(string2).flatMap(lVar);
            n.e(obj2, "doesUserExists(userId).flatMap { exits ->\n            if (exits) {\n                getUser(userId).map { it.user.currentDogId }\n            } else {\n                Single.just(\"\")\n            }\n        }");
            return obj2;
        }

        private static g0 d(e.a.a.a.b.b.q0 q0, String string2, Boolean boolean3) {
            a0 obj1;
            Object obj2;
            n.f(q0, "this$0");
            n.f(string2, "$userId");
            n.f(boolean3, "exits");
            if (boolean3.booleanValue()) {
                obj1 = q0.h(string2).map(k.a);
            } else {
                obj1 = a0.just("");
            }
            return obj1;
        }

        private static String e(h h) {
            n.f(h, "it");
            return h.b().getCurrentDogId();
        }

        public static a0<PottyReminderEntity> f(e.a.a.a.b.b.q0 q0, String string2) {
            n.f(q0, "this");
            n.f(string2, "reminderId");
            a0 obj1 = q0.q(string2).onErrorReturnItem(PottyReminderEntity.Companion.createEmpty());
            n.e(obj1, "getPottyReminder(reminderId).onErrorReturnItem(PottyReminderEntity.createEmpty())");
            return obj1;
        }

        public static a0<List<ReminderEntity>> g(e.a.a.a.b.b.q0 q0, String string2) {
            n.f(q0, "this");
            n.f(string2, "userId");
            a0 obj1 = q0.k(string2).onErrorReturn(m.a);
            n.e(obj1, "getReminders(userId).onErrorReturn { emptyList() }");
            return obj1;
        }

        private static List h(Throwable throwable) {
            n.f(throwable, "it");
            return p.g();
        }

        public static Object i(e.a.a.a.b.b.q0 q0, String string2, d<? super UserStateEntity> d3) {
            boolean aVar;
            int label2;
            int i;
            int label;
            int i4;
            int i2;
            int i6;
            int i5;
            int i3;
            Object obj8;
            Object obj9;
            Object obj10;
            aVar = d3;
            label2 = aVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof q0.a.a && label2 & i != 0) {
                aVar = d3;
                label2 = aVar.label;
                i = Integer.MIN_VALUE;
                if (label2 & i != 0) {
                    aVar.label = label2 -= i;
                } else {
                    aVar = new q0.a.a(d3);
                }
            } else {
            }
            obj10 = aVar.result;
            Object obj = b.d();
            label = aVar.label;
            int i7 = 1;
            if (label != 0) {
                if (label != i7) {
                } else {
                    obj9 = obj8;
                    q.b(obj10);
                    if ((UserStateEntity)obj10 == null) {
                        super(obj9, 0, 0, 6, 0);
                    }
                    return obj10;
                }
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
            }
            q.b(obj10);
            aVar.L$0 = string2;
            aVar.label = i7;
            if (q0.n(string2, aVar) == obj) {
                return obj;
            }
        }

        public static String j(h h) {
            return q0.a.e(h);
        }

        public static g0 k(e.a.a.a.b.b.q0 q0, String string2, Boolean boolean3) {
            return q0.a.d(q0, string2, boolean3);
        }

        public static List l(Throwable throwable) {
            return q0.a.h(throwable);
        }

        public static Object m(e.a.a.a.b.b.q0 q0, String string2, String string3, int i4, d<? super w> d5) {
            Object obj;
            Object copy$default;
            Object result;
            boolean bVar;
            int label;
            int i6;
            int label2;
            int i;
            UserStateEntity userStateEntity;
            Object l$0;
            Object obj3;
            Object obj2;
            int goalNotReachedState2;
            int i2;
            UserStateEntity.GoalNotReachedState goalNotReachedState;
            int i3;
            int i5;
            obj = q0;
            copy$default = string2;
            Object obj4 = d5;
            bVar = obj4;
            label = bVar.label;
            i6 = Integer.MIN_VALUE;
            if (obj4 instanceof q0.a.b && label & i6 != 0) {
                bVar = obj4;
                label = bVar.label;
                i6 = Integer.MIN_VALUE;
                if (label & i6 != 0) {
                    bVar.label = label -= i6;
                } else {
                    bVar = new q0.a.b(obj4);
                }
            } else {
            }
            result = bVar.result;
            Object obj6 = b.d();
            label2 = bVar.label;
            int i7 = 3;
            userStateEntity = 2;
            l$0 = 1;
            if (label2 != 0) {
                if (label2 != l$0) {
                    if (label2 != userStateEntity) {
                        if (label2 != i7) {
                        } else {
                            q.b(result);
                            return w.a;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    q.b(result);
                    return w.a;
                } else {
                    copy$default = bVar.L$2;
                    q.b(result);
                    obj3 = l$1;
                    label2 = i$0;
                    obj = l$0;
                    obj2 = result;
                    result = 0;
                    goalNotReachedState = new UserStateEntity.GoalNotReachedState(copy$default, label2);
                    bVar.L$0 = result;
                    bVar.L$1 = result;
                    bVar.L$2 = result;
                    bVar.label = userStateEntity;
                    if (obj2 != null && obj.f(UserStateEntity.copy$default((UserStateEntity)obj2, 0, false, goalNotReachedState, 3, 0), bVar) == obj6) {
                        goalNotReachedState = new UserStateEntity.GoalNotReachedState(copy$default, label2);
                        bVar.L$0 = result;
                        bVar.L$1 = result;
                        bVar.L$2 = result;
                        bVar.label = userStateEntity;
                        if (obj.f(UserStateEntity.copy$default(obj2, 0, false, goalNotReachedState, 3, 0), bVar) == obj6) {
                            return obj6;
                        }
                    }
                }
            } else {
                q.b(result);
                bVar.L$0 = obj;
                bVar.L$1 = copy$default;
                Object obj5 = string3;
                bVar.L$2 = obj5;
                bVar.I$0 = i4;
                bVar.label = l$0;
                l$0 = obj.n(copy$default, bVar);
                if (l$0 == obj6) {
                    return obj6;
                }
                obj3 = copy$default;
                copy$default = obj5;
                result = l$0;
            }
            goalNotReachedState2 = new UserStateEntity.GoalNotReachedState(copy$default, label2);
            super(obj3, 0, goalNotReachedState2, 2, 0);
            bVar.L$0 = result;
            bVar.L$1 = result;
            bVar.L$2 = result;
            bVar.label = i7;
            if (obj.f(userStateEntity, bVar) == obj6) {
                return obj6;
            }
        }

        public static Object n(e.a.a.a.b.b.q0 q0, String string2, boolean z3, d<? super w> d4) {
            Object obj;
            Object l$1;
            Object userStateEntity;
            boolean cVar;
            int label;
            int i6;
            Object label2;
            int i3;
            UserStateEntity i5;
            Object obj2;
            Object obj3;
            int i4;
            boolean z;
            int i7;
            int i2;
            int i;
            obj = q0;
            l$1 = string2;
            Object obj4 = d4;
            cVar = obj4;
            label = cVar.label;
            i6 = Integer.MIN_VALUE;
            if (obj4 instanceof q0.a.c && label & i6 != 0) {
                cVar = obj4;
                label = cVar.label;
                i6 = Integer.MIN_VALUE;
                if (label & i6 != 0) {
                    cVar.label = label -= i6;
                } else {
                    cVar = new q0.a.c(obj4);
                }
            } else {
            }
            userStateEntity = cVar.result;
            Object obj5 = b.d();
            label2 = cVar.label;
            int i8 = 3;
            final int i9 = 2;
            i5 = 1;
            if (label2 != 0) {
                if (label2 != i5) {
                    if (label2 != i9) {
                        if (label2 != i8) {
                        } else {
                            q.b(userStateEntity);
                            return w.a;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    q.b(userStateEntity);
                    return w.a;
                } else {
                    q.b(userStateEntity);
                    z = z$0;
                    obj2 = l$1;
                    obj = label2;
                    obj3 = userStateEntity;
                    l$1 = 0;
                    cVar.L$0 = l$1;
                    cVar.L$1 = l$1;
                    cVar.label = i9;
                    if (obj3 != null && obj.f(UserStateEntity.copy$default((UserStateEntity)obj3, 0, z, 0, 5, 0), cVar) == obj5) {
                        cVar.L$0 = l$1;
                        cVar.L$1 = l$1;
                        cVar.label = i9;
                        if (obj.f(UserStateEntity.copy$default(obj3, 0, z, 0, 5, 0), cVar) == obj5) {
                            return obj5;
                        }
                    }
                }
            } else {
                q.b(userStateEntity);
                cVar.L$0 = obj;
                cVar.L$1 = l$1;
                boolean z2 = z3;
                cVar.Z$0 = z2;
                cVar.label = i5;
                label2 = obj.n(l$1, cVar);
                if (label2 == obj5) {
                    return obj5;
                }
                obj2 = l$1;
                z = z2;
                userStateEntity = label2;
            }
            super(obj2, z, 0, 4, 0);
            cVar.L$0 = l$1;
            cVar.L$1 = l$1;
            cVar.label = i8;
            if (obj.f(userStateEntity, cVar) == obj5) {
                return obj5;
            }
        }
    }
    public abstract a0<PottyReminderEntity> a(String string);

    public abstract b b(UserEntity userEntity);

    public abstract Object c(String string, String string2, int i3, d<? super w> d4);

    public abstract b d();

    public abstract Object e(String string, boolean z2, d<? super w> d3);

    public abstract Object f(UserStateEntity userStateEntity, d<? super w> d2);

    public abstract b g(PolicyEntity... policyEntityArr);

    public abstract a0<h> h(String string);

    public abstract b i(ReminderEntity... reminderEntityArr);

    public abstract a0<List<PottyReminderEntity>> j(String string);

    public abstract a0<List<ReminderEntity>> k(String string);

    public abstract a0<List<ReminderEntity>> l(String string);

    public abstract Object m(String string, d<? super UserStateEntity> d2);

    public abstract Object n(String string, d<? super UserStateEntity> d2);

    public abstract void o(UserCurrentDogIdUpdate userCurrentDogIdUpdate);

    public abstract a0<List<Long>> p(PottyReminderEntity... pottyReminderEntityArr);

    public abstract a0<PottyReminderEntity> q(String string);

    public abstract b r();

    public abstract b s(h h);

    public abstract a0<List<PottyReminderEntity>> t(String string);

    public abstract a0<String> u(String string);

    public abstract b v();

    public abstract a0<Boolean> w(String string);
}
