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
import i.b.g0;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* compiled from: UserEntityDao.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H'J\u0008\u0010\u0005\u001a\u00020\u0003H'J\u0008\u0010\u0006\u001a\u00020\u0003H'J\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\u000bH'J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u0016\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\u0016\u001a\u00020\u000bH'J&\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\tH'J\u0016\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00082\u0006\u0010\u001a\u001a\u00020\u000bH'J\u0016\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00082\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH'J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00082\u0006\u0010\u001a\u001a\u00020\u000bH'J\u001c\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00082\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\r\u001a\u00020\u000bH'J&\u0010#\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u00082\u0006\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\tH'J\u001b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\r\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020)H'J\u0019\u0010(\u001a\u00020*2\u0006\u0010+\u001a\u00020%H§@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u0010(\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0-\"\u00020.H'¢\u0006\u0002\u0010/J-\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002000\u00140\u00082\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00150-\"\u00020\u0015H'¢\u0006\u0002\u00101J!\u0010(\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0-\"\u00020\u001dH'¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205H'J)\u00106\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010:J!\u0010;\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010=\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006>", d2 = {"Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "", "clearAll", "Lio/reactivex/Completable;", "deletePolicies", "deleteReminders", "deleteUsers", "doesUserExists", "Lio/reactivex/Single;", "", "id", "", "doesUserHavePottyReminders", "userId", "doesUserHaveReminders", "fullInsert", "user", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "getCurrentDogId", "getDogPottyReminders", "", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "dogId", "getDogPottyRemindersWithState", "isActive", "getPottyReminder", "reminderId", "getPottyReminderOrEmpty", "getReminders", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "getTrainingReminder", "getTrainingReminderById", "getTrainingReminderOrEmpty", "getUser", "getUserPottyReminders", "getUserPottyRemindersWithState", "getUserStateEntity", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserStateEntityOrEmpty", "insert", "Lapp/dogo/android/persistencedb/room/entity/UserEntity;", "", "entity", "(Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;", "([Lapp/dogo/android/persistencedb/room/entity/PolicyEntity;)Lio/reactivex/Completable;", "", "([Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;)Lio/reactivex/Single;", "([Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;)Lio/reactivex/Completable;", "updateCurrentDog", "obj", "Lapp/dogo/android/persistencedb/room/entity/UserCurrentDogIdUpdate;", "updateMetricsGoalNotReachedState", "date", "durationSec", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWorkoutStreakSyncState", "state", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q0, reason: from kotlin metadata */
public interface UserEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static i.b.b a(q0 q0Var) {
            n.f(q0Var, "this");
            i.b.f[] arr = new f[2];
            i.b.b bVar2 = b.p(new f[] { q0Var.v(), q0Var.clearAll() });
            n.e(bVar2, "mergeArray(deletePolicies(), deleteUsers())");
            return bVar2;
        }

        public static i.b.b b(q0 q0Var, h hVar) {
            n.f(q0Var, "this");
            n.f(hVar, "user");
            i.b.f[] arr = new f[2];
            final int i2 = 0;
            arr[i2] = q0Var.doesUserHavePottyReminders(hVar.b());
            Object[] array = hVar.component1().toArray(new PolicyEntity[i2]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            arr[1] = q0Var.doesUserHaveReminders((PolicyEntity[])Arrays.copyOf(array, array.length));
            i.b.b bVar3 = q0Var.r().c(b.p(arr));
            n.e(bVar3, "clearAll().andThen(\n            Completable.mergeArray(\n                insert(user.user),\n                insert(*user.policies.toTypedArray())\n            )\n        )");
            return bVar3;
        }

        public static a0<String> c(q0 q0Var, String str) {
            n.f(q0Var, "this");
            n.f(str, "userId");
            final a0 flatMapped = q0Var.getUserStateEntity(str).flatMap(new app.dogo.android.persistencedb.room.dao.l(q0Var, str));
            n.e(flatMapped, "doesUserExists(userId).flatMap { exits ->\n            if (exits) {\n                getUser(userId).map { it.user.currentDogId }\n            } else {\n                Single.just(\"\")\n            }\n        }");
            return flatMapped;
        }

        private static g0 d(q0 q0Var, String str, Boolean boolean) {
            a0 just;
            n.f(q0Var, "this$0");
            n.f(str, "$userId");
            n.f(boolean, "exits");
            if (boolean.booleanValue()) {
                just = q0Var.fullInsert(str).map(app.dogo.android.persistencedb.room.dao.k.a);
            } else {
                just = a0.just("");
            }
            return just;
        }

        private static String e(h hVar) {
            n.f(hVar, "it");
            return hVar.b().getCurrentDogId();
        }

        public static a0<PottyReminderEntity> f(q0 q0Var, String str) {
            n.f(q0Var, "this");
            n.f(str, "reminderId");
            a0 onErrorReturnItem = q0Var.getTrainingReminderById(str).onErrorReturnItem(PottyReminderEntity.INSTANCE.createEmpty());
            n.e(onErrorReturnItem, "getPottyReminder(reminderId).onErrorReturnItem(PottyReminderEntity.createEmpty())");
            return onErrorReturnItem;
        }

        public static a0<List<ReminderEntity>> g(q0 q0Var, String str) {
            n.f(q0Var, "this");
            n.f(str, "userId");
            a0 onErrorReturn = q0Var.getPottyReminder(str).onErrorReturn(app.dogo.android.persistencedb.room.dao.m.a);
            n.e(onErrorReturn, "getReminders(userId).onErrorReturn { emptyList() }");
            return onErrorReturn;
        }

        private static List h(Throwable th) {
            n.f(th, "it");
            return p.g();
        }

        public static Object i(q0 q0Var, String str, d<? super UserStateEntity> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int i2;
            Object q0Var2;
            Object workoutStreakSyncState;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.q0.a.a;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.q0.a.a) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.q0.a.a aVar = new app.dogo.android.persistencedb.room.dao.q0.a.a(dVar);
                }
            }
            Object obj = b.d();
            int i4 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar32.result);
                    if ((UserStateEntity)workoutStreakSyncState == null) {
                        boolean z2 = false;
                        UserStateEntity.GoalNotReachedState goalNotReachedState = null;
                        int i3 = 6;
                        kotlin.d0.d.g gVar = null;
                        UserStateEntity dVar33 = new UserStateEntity(q0Var2, z2, goalNotReachedState, i3, gVar);
                    }
                    return workoutStreakSyncState;
                }
            }
            q.b(dVar32.result);
            dVar32.L$0 = str;
            dVar32.label = i4;
            if (q0Var.updateWorkoutStreakSyncState(str, dVar32) == obj) {
                return obj;
            }
        }

        public static Object m(q0 q0Var, String str, String str2, int i, d<? super w> dVar) {
            Object q0Var2;
            Object dVar52;
            int label2;
            int i42;
            int i2;
            String str4;
            q0Var2 = q0Var;
            Object str22 = str;
            dVar52 = dVar;
            z = dVar52 instanceof app.dogo.android.persistencedb.room.dao.q0.a.b;
            if (dVar52 instanceof app.dogo.android.persistencedb.room.dao.q0.a.b) {
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar52.label -= i;
                } else {
                    e.a.a.a.b.b.q0.a.b bVar = new app.dogo.android.persistencedb.room.dao.q0.a.b(dVar52);
                }
            }
            Object obj3 = b.d();
            int i6 = 3;
            int i7 = 2;
            int i8 = 1;
            if (dVar52.label != 0) {
                if (dVar52.label != i8) {
                    if (dVar52.label != i7) {
                        if (dVar52.label != i6) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar52.result);
                            return w.a;
                        }
                    }
                    q.b(dVar52.result);
                    return w.a;
                } else {
                    q.b(dVar52.result);
                    userStateEntity2 = q0Var2;
                    q0Var2 = null;
                    if (userStateEntity2 != null) {
                        String str5 = null;
                        boolean z3 = false;
                        int i5 = 3;
                        Object obj2 = null;
                        dVar52.L$0 = q0Var2;
                        dVar52.L$1 = q0Var2;
                        dVar52.L$2 = q0Var2;
                        dVar52.label = i7;
                        if (q0Var2.getDogPottyRemindersWithState(UserStateEntity.copy$default(userStateEntity2, str5, z3, new UserStateEntity_GoalNotReachedState(str, i42), i5, obj2), dVar52) == obj3) {
                            return obj3;
                        }
                    }
                }
            } else {
                q.b(dVar52.result);
                dVar52.L$0 = q0Var2;
                dVar52.L$1 = str22;
                Object str32 = str2;
                dVar52.L$2 = str32;
                dVar52.I$0 = i;
                dVar52.label = i8;
                q0Var2 = q0Var2.updateWorkoutStreakSyncState(str22, dVar52);
                if (q0Var2 == obj3) {
                    return obj3;
                }
            }
            boolean z2 = false;
            int i3 = 2;
            kotlin.d0.d.g gVar = null;
            UserStateEntity userStateEntity = new UserStateEntity(str4, z2, new UserStateEntity_GoalNotReachedState(str, i42), i3, gVar);
            dVar52.L$0 = q0Var2;
            dVar52.L$1 = q0Var2;
            dVar52.L$2 = q0Var2;
            dVar52.label = i6;
            if (q0Var2.getDogPottyRemindersWithState(userStateEntity, dVar52) == obj3) {
                return obj3;
            }
        }

        public static Object n(q0 q0Var, String str, boolean z, d<? super w> dVar) {
            Object q0Var2;
            Object dVar42;
            int label2;
            int i = -2147483648;
            int i2;
            boolean z32;
            q0Var2 = q0Var;
            str22 = str;
            dVar42 = dVar;
            z = dVar42 instanceof app.dogo.android.persistencedb.room.dao.q0.a.c;
            if (dVar42 instanceof app.dogo.android.persistencedb.room.dao.q0.a.c) {
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar42.label -= i;
                } else {
                    e.a.a.a.b.b.q0.a.c cVar = new app.dogo.android.persistencedb.room.dao.q0.a.c(dVar42);
                }
            }
            Object obj2 = b.d();
            int i4 = 3;
            final int i5 = 2;
            int i6 = 1;
            if (dVar42.label != 0) {
                if (dVar42.label != i6) {
                    if (dVar42.label != i5) {
                        if (dVar42.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar42.result);
                            return w.a;
                        }
                    }
                    q.b(dVar42.result);
                    return w.a;
                } else {
                    q.b(dVar42.result);
                    userStateEntity2 = q0Var2;
                    Object str22 = null;
                    if (userStateEntity2 != null) {
                        String str3 = null;
                        UserStateEntity.GoalNotReachedState goalNotReachedState2 = null;
                        int i3 = 5;
                        Object obj = null;
                        dVar42.L$0 = str22;
                        dVar42.L$1 = str22;
                        dVar42.label = i5;
                        if (q0Var2.getDogPottyRemindersWithState(UserStateEntity.copy$default(userStateEntity2, str3, z32, goalNotReachedState2, i3, obj), dVar42) == obj2) {
                            return obj2;
                        }
                    }
                }
            } else {
                q.b(dVar42.result);
                dVar42.L$0 = q0Var2;
                dVar42.L$1 = str22;
                z32 = z;
                dVar42.Z$0 = z32;
                dVar42.label = i6;
                q0Var2 = q0Var2.updateWorkoutStreakSyncState(str22, dVar42);
                if (q0Var2 == obj2) {
                    return obj2;
                }
            }
            UserStateEntity.GoalNotReachedState goalNotReachedState = null;
            int label22 = 4;
            kotlin.d0.d.g gVar = null;
            UserStateEntity userStateEntity = new UserStateEntity(str, z32, goalNotReachedState, label22, gVar);
            dVar42.L$0 = str22;
            dVar42.L$1 = str22;
            dVar42.label = i4;
            if (q0Var2.getDogPottyRemindersWithState(userStateEntity, dVar42) == obj2) {
                return obj2;
            }
        }

        public static /* synthetic */ String j(h hVar) {
            return app.dogo.android.persistencedb.room.dao.q0.a.e(hVar);
        }

        public static /* synthetic */ g0 k(q0 q0Var, String str, Boolean boolean) {
            return app.dogo.android.persistencedb.room.dao.q0.a.d(q0Var, str, boolean);
        }

        public static /* synthetic */ List l(Throwable th) {
            return app.dogo.android.persistencedb.room.dao.q0.a.h(th);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    a0<PottyReminderEntity> doesUserExists(String id);

    /* renamed from: b, reason: from kotlin metadata */
    i.b.b doesUserHavePottyReminders(UserEntity userId);

    Object c(String str, String str2, int i, d<? super w> dVar);

    /* renamed from: d, reason: from kotlin metadata */
    i.b.b clearAll();

    /* renamed from: e, reason: from kotlin metadata */
    /* suspend */ Object updateMetricsGoalNotReachedState(String userId, boolean date, d<? super w> durationSec);

    /* renamed from: f, reason: from kotlin metadata */
    Object getDogPottyRemindersWithState(UserStateEntity dogId, d<? super w> isActive);

    /* renamed from: g, reason: from kotlin metadata */
    i.b.b doesUserHaveReminders(PolicyEntity... userId);

    /* renamed from: h, reason: from kotlin metadata */
    a0<h> fullInsert(String user);

    /* renamed from: i, reason: from kotlin metadata */
    i.b.b getCurrentDogId(ReminderEntity... userId);

    /* renamed from: j, reason: from kotlin metadata */
    a0<List<PottyReminderEntity>> getDogPottyReminders(String dogId);

    /* renamed from: k, reason: from kotlin metadata */
    a0<List<ReminderEntity>> getPottyReminder(String reminderId);

    /* renamed from: l, reason: from kotlin metadata */
    a0<List<ReminderEntity>> getPottyReminderOrEmpty(String reminderId);

    /* renamed from: m, reason: from kotlin metadata */
    Object getUserPottyRemindersWithState(String userId, d<? super UserStateEntity> isActive);

    /* renamed from: n, reason: from kotlin metadata */
    /* suspend */ Object updateWorkoutStreakSyncState(String userId, d<? super UserStateEntity> state);

    /* renamed from: o, reason: from kotlin metadata */
    void getReminders(UserCurrentDogIdUpdate userId);

    /* renamed from: p, reason: from kotlin metadata */
    a0<List<Long>> getTrainingReminder(PottyReminderEntity... userId);

    /* renamed from: q, reason: from kotlin metadata */
    a0<PottyReminderEntity> getTrainingReminderById(String reminderId);

    i.b.b r();

    /* renamed from: s, reason: from kotlin metadata */
    i.b.b getTrainingReminderOrEmpty(h userId);

    /* renamed from: t, reason: from kotlin metadata */
    a0<List<PottyReminderEntity>> getUser(String id);

    /* renamed from: u, reason: from kotlin metadata */
    a0<String> getUserPottyReminders(String userId);

    i.b.b v();

    /* renamed from: w, reason: from kotlin metadata */
    /* suspend */ a0<Boolean> getUserStateEntity(String userId);
}
