package app.dogo.android.persistencedb.room.database;

import androidx.room.e0;
import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g;
import androidx.room.f1.g.a;
import androidx.room.m0;
import androidx.room.u0;
import androidx.room.u0.b;
import androidx.room.w0;
import androidx.room.w0.a;
import androidx.room.w0.b;
import d.s.a.g;
import d.s.a.h;
import d.s.a.h.b;
import d.s.a.h.b.a;
import d.s.a.h.c;
import e.a.a.a.b.b.k0;
import e.a.a.a.b.b.l0;
import e.a.a.a.b.b.q0;
import e.a.a.a.b.b.r0;
import e.a.a.a.b.b.u;
import e.a.a.a.b.b.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class UserDatabase_Impl extends app.dogo.android.persistencedb.room.database.UserDatabase {

    private volatile u s;
    private volatile q0 t;
    private volatile k0 u;

    class a extends w0.a {

        final app.dogo.android.persistencedb.room.database.UserDatabase_Impl b;
        a(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl, int i2) {
            this.b = userDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `DogEntity` (`id` TEXT NOT NULL, `creatorId` TEXT NOT NULL, `name` TEXT, `breedId` TEXT, `customBreed` TEXT, `birthday` TEXT, `birthdayExact` INTEGER, `gender` TEXT, `avatarUrl` TEXT, `parentId` TEXT NOT NULL, `createTimeMs` INTEGER, PRIMARY KEY(`id`))");
            g.C("CREATE TABLE IF NOT EXISTS `UserEntity` (`id` TEXT NOT NULL, `currentDogId` TEXT NOT NULL, `abBucket` INTEGER, `participatingInChallenges` TEXT NOT NULL, PRIMARY KEY(`id`))");
            g.C("CREATE TABLE IF NOT EXISTS `PolicyEntity` (`id` TEXT NOT NULL, `status` TEXT NOT NULL, `ownerId` TEXT NOT NULL, PRIMARY KEY(`id`))");
            g.C("CREATE TABLE IF NOT EXISTS `ReminderEntity` (`id` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `days` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `time` TEXT NOT NULL, `repeating` TEXT NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            g.C("CREATE TABLE IF NOT EXISTS `PottyReminderEntity` (`reminderId` TEXT NOT NULL DEFAULT '', `dogId` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `days` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `repeatIntervalMs` INTEGER, `isActive` INTEGER NOT NULL, PRIMARY KEY(`reminderId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrainingStreakEntity` (`userId` TEXT NOT NULL, `currentStreak` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `trainingTimesSec` TEXT NOT NULL, `totalTrainingTimeSec` INTEGER NOT NULL, `remoteUpdateTimeMs` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
            g.C("CREATE TABLE IF NOT EXISTS `UserStateEntity` (`userId` TEXT NOT NULL, `isWorkoutStreakSyncedToTrainingMetrics` INTEGER NOT NULL, `lastSeenGoalNotReachedState` TEXT, PRIMARY KEY(`userId`))");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0617dcea4098cbc9356df439ae629c27')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `DogEntity`");
            g.C("DROP TABLE IF EXISTS `UserEntity`");
            g.C("DROP TABLE IF EXISTS `PolicyEntity`");
            g.C("DROP TABLE IF EXISTS `ReminderEntity`");
            g.C("DROP TABLE IF EXISTS `PottyReminderEntity`");
            g.C("DROP TABLE IF EXISTS `TrainingStreakEntity`");
            g.C("DROP TABLE IF EXISTS `UserStateEntity`");
            if (UserDatabase_Impl.M(this.b) != null) {
                list = 0;
                while (list < UserDatabase_Impl.N(this.b).size()) {
                    (u0.b)UserDatabase_Impl.P(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (UserDatabase_Impl.Q(this.b) != null) {
                list = 0;
                while (list < UserDatabase_Impl.R(this.b).size()) {
                    (u0.b)UserDatabase_Impl.S(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            UserDatabase_Impl.T(this.b, g);
            UserDatabase_Impl.U(this.b, g);
            if (UserDatabase_Impl.V(this.b) != null) {
                list = 0;
                while (list < UserDatabase_Impl.W(this.b).size()) {
                    (u0.b)UserDatabase_Impl.O(this.b).get(list).c(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void e(g g) {
        }

        @Override // androidx.room.w0$a
        public void f(g g) {
            c.b(g);
        }

        @Override // androidx.room.w0$a
        protected w0.b g(g g) {
            g gVar = g;
            HashMap hashMap = new HashMap(11);
            int i10 = 1;
            super("id", "TEXT", 1, i10, 0, 1);
            String str = "id";
            hashMap.put(str, aVar);
            int i13 = 0;
            super("creatorId", "TEXT", i10, i13, 0, 1);
            hashMap.put("creatorId", aVar2);
            int i16 = 0;
            int i20 = 0;
            int i30 = 1;
            super("name", "TEXT", i13, i16, i20, i30);
            String str18 = "name";
            hashMap.put(str18, aVar3);
            super("breedId", "TEXT", i13, i16, i20, i30);
            hashMap.put("breedId", aVar4);
            int i21 = 0;
            int i31 = 0;
            int i41 = 1;
            super("customBreed", "TEXT", i16, i21, i31, i41);
            hashMap.put("customBreed", aVar5);
            super("birthday", "TEXT", i16, i21, i31, i41);
            hashMap.put("birthday", aVar6);
            super("birthdayExact", "INTEGER", i16, i21, i31, i41);
            hashMap.put("birthdayExact", aVar7);
            super("gender", "TEXT", i16, i21, i31, i41);
            hashMap.put("gender", aVar8);
            super("avatarUrl", "TEXT", i16, i21, i31, i41);
            hashMap.put("avatarUrl", aVar9);
            super("parentId", "TEXT", 1, i21, i31, i41);
            hashMap.put("parentId", aVar10);
            super("createTimeMs", "INTEGER", 0, i21, i31, i41);
            hashMap.put("createTimeMs", aVar11);
            int i8 = 0;
            HashSet hashSet = new HashSet(i8);
            HashSet hashSet10 = new HashSet(i8);
            String str65 = "DogEntity";
            g gVar11 = new g(str65, hashMap, hashSet, hashSet10);
            g gVar3 = g.a(gVar, str65);
            String str41 = "\n Found:\n";
            if (!gVar11.equals(gVar3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DogEntity(app.dogo.android.persistencedb.room.entity.DogEntity).\n Expected:\n");
                stringBuilder.append(gVar11);
                stringBuilder.append(str41);
                stringBuilder.append(gVar3);
                w0.b bVar = new w0.b(i8, stringBuilder.toString());
                return bVar;
            }
            HashMap hashMap2 = new HashMap(4);
            super("id", "TEXT", 1, 1, 0, 1);
            hashMap2.put(str, aVar12);
            super("currentDogId", "TEXT", 1, 0, 0, 1);
            hashMap2.put("currentDogId", aVar13);
            int i43 = 0;
            int i52 = 0;
            int i62 = 1;
            super("abBucket", "INTEGER", 0, i43, i52, i62);
            hashMap2.put("abBucket", aVar14);
            super("participatingInChallenges", "TEXT", 1, i43, i52, i62);
            hashMap2.put("participatingInChallenges", aVar15);
            HashSet hashSet2 = new HashSet(i8);
            HashSet hashSet11 = new HashSet(i8);
            String str86 = "UserEntity";
            g gVar13 = new g(str86, hashMap2, hashSet2, hashSet11);
            g gVar4 = g.a(gVar, str86);
            if (!gVar13.equals(gVar4)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("UserEntity(app.dogo.android.persistencedb.room.entity.UserEntity).\n Expected:\n");
                stringBuilder2.append(gVar13);
                stringBuilder2.append(str41);
                stringBuilder2.append(gVar4);
                w0.b bVar2 = new w0.b(i8, stringBuilder2.toString());
                return bVar2;
            }
            HashMap hashMap3 = new HashMap(3);
            super("id", "TEXT", 1, 1, 0, 1);
            hashMap3.put(str, aVar81);
            super("status", "TEXT", 1, 0, 0, 1);
            hashMap3.put("status", aVar54);
            super("ownerId", "TEXT", 1, 0, 0, 1);
            String str69 = "ownerId";
            hashMap3.put(str69, aVar55);
            HashSet hashSet12 = new HashSet(i8);
            HashSet hashSet13 = new HashSet(i8);
            String str113 = "PolicyEntity";
            g gVar14 = new g(str113, hashMap3, hashSet12, hashSet13);
            g gVar5 = g.a(gVar, str113);
            if (!gVar14.equals(gVar5)) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append("PolicyEntity(app.dogo.android.persistencedb.room.entity.PolicyEntity).\n Expected:\n");
                stringBuilder7.append(gVar14);
                stringBuilder7.append(str41);
                stringBuilder7.append(gVar5);
                w0.b bVar7 = new w0.b(i8, stringBuilder7.toString());
                return bVar7;
            }
            int i11 = 8;
            HashMap hashMap4 = new HashMap(i11);
            int i46 = 1;
            int i64 = 0;
            super("id", "TEXT", i46, 1, i64, 1);
            hashMap4.put(str, aVar84);
            int i83 = 1;
            int i85 = 0;
            int i87 = 0;
            int i89 = 1;
            super("ownerId", "TEXT", i83, i85, i87, i89);
            hashMap4.put(str69, aVar17);
            int i56 = 0;
            int i68 = 1;
            super("days", "TEXT", i46, i56, i64, i68);
            String str4 = "days";
            hashMap4.put(str4, aVar18);
            super("name", "TEXT", i46, i56, i64, i68);
            hashMap4.put(str18, aVar19);
            super("type", "TEXT", i83, i85, i87, i89);
            hashMap4.put("type", aVar20);
            super("time", "TEXT", i46, i56, i64, i68);
            hashMap4.put("time", aVar21);
            super("repeating", "TEXT", i46, i56, i64, i68);
            hashMap4.put("repeating", aVar22);
            super("isActive", "INTEGER", i46, i56, i64, i68);
            String str22 = "isActive";
            hashMap4.put(str22, aVar23);
            HashSet hashSet3 = new HashSet(i8);
            HashSet hashSet14 = new HashSet(i8);
            String str120 = "ReminderEntity";
            g gVar15 = new g(str120, hashMap4, hashSet3, hashSet14);
            g gVar6 = g.a(gVar, str120);
            if (!gVar15.equals(gVar6)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("ReminderEntity(app.dogo.android.persistencedb.room.entity.ReminderEntity).\n Expected:\n");
                stringBuilder3.append(gVar15);
                stringBuilder3.append(str41);
                stringBuilder3.append(gVar6);
                w0.b bVar3 = new w0.b(i8, stringBuilder3.toString());
                return bVar3;
            }
            HashMap hashMap5 = new HashMap(i11);
            int i47 = 1;
            int i69 = 1;
            super("reminderId", "TEXT", i47, 1, "''", i69);
            hashMap5.put("reminderId", aVar24);
            int i58 = 0;
            int i65 = 0;
            super("dogId", "TEXT", i47, i58, i65, i69);
            hashMap5.put("dogId", aVar25);
            super("ownerId", "TEXT", i47, i58, i65, i69);
            hashMap5.put(str69, aVar26);
            super("days", "TEXT", 1, 0, 0, 1);
            hashMap5.put(str4, aVar27);
            int i24 = 1;
            int i36 = 0;
            int i48 = 0;
            int i59 = 1;
            super("startTime", "TEXT", i24, i36, i48, i59);
            hashMap5.put("startTime", aVar28);
            super("endTime", "TEXT", i24, i36, i48, i59);
            hashMap5.put("endTime", aVar29);
            super("repeatIntervalMs", "INTEGER", 0, i36, i48, i59);
            hashMap5.put("repeatIntervalMs", aVar30);
            super("isActive", "INTEGER", 1, i36, i48, i59);
            hashMap5.put(str22, aVar31);
            HashSet hashSet4 = new HashSet(i8);
            HashSet hashSet7 = new HashSet(i8);
            String str56 = "PottyReminderEntity";
            g gVar9 = new g(str56, hashMap5, hashSet4, hashSet7);
            g gVar7 = g.a(gVar, str56);
            if (!gVar9.equals(gVar7)) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("PottyReminderEntity(app.dogo.android.persistencedb.room.entity.PottyReminderEntity).\n Expected:\n");
                stringBuilder4.append(gVar9);
                stringBuilder4.append(str41);
                stringBuilder4.append(gVar7);
                w0.b bVar4 = new w0.b(i8, stringBuilder4.toString());
                return bVar4;
            }
            HashMap hashMap6 = new HashMap(6);
            int i27 = 1;
            int i49 = 0;
            int i60 = 1;
            super("userId", "TEXT", i27, 1, i49, i60);
            String str10 = "userId";
            hashMap6.put(str10, aVar32);
            int i38 = 0;
            super("currentStreak", "INTEGER", i27, i38, i49, i60);
            hashMap6.put("currentStreak", aVar33);
            super("longestStreak", "INTEGER", i27, i38, i49, i60);
            hashMap6.put("longestStreak", aVar34);
            super("trainingTimesSec", "TEXT", i27, i38, i49, i60);
            hashMap6.put("trainingTimesSec", aVar35);
            super("totalTrainingTimeSec", "INTEGER", i27, i38, i49, i60);
            hashMap6.put("totalTrainingTimeSec", aVar36);
            super("remoteUpdateTimeMs", "INTEGER", i27, i38, i49, i60);
            hashMap6.put("remoteUpdateTimeMs", aVar37);
            HashSet hashSet5 = new HashSet(i8);
            HashSet hashSet9 = new HashSet(i8);
            String str80 = "TrainingStreakEntity";
            g gVar12 = new g(str80, hashMap6, hashSet5, hashSet9);
            g gVar8 = g.a(gVar, str80);
            if (!gVar12.equals(gVar8)) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("TrainingStreakEntity(app.dogo.android.persistencedb.room.entity.TrainingStreakEntity).\n Expected:\n");
                stringBuilder5.append(gVar12);
                stringBuilder5.append(str41);
                stringBuilder5.append(gVar8);
                w0.b bVar5 = new w0.b(i8, stringBuilder5.toString());
                return bVar5;
            }
            HashMap hashMap7 = new HashMap(3);
            int i50 = 0;
            int i61 = 1;
            super("userId", "TEXT", 1, 1, i50, i61);
            hashMap7.put(str10, aVar38);
            g.a aVar82 = new g.a("isWorkoutStreakSyncedToTrainingMetrics", "INTEGER", 1, 0, 0, 1);
            hashMap7.put("isWorkoutStreakSyncedToTrainingMetrics", aVar39);
            super("lastSeenGoalNotReachedState", "TEXT", 0, 0, i50, i61);
            hashMap7.put("lastSeenGoalNotReachedState", aVar40);
            HashSet hashSet6 = new HashSet(i8);
            HashSet hashSet8 = new HashSet(i8);
            String str57 = "UserStateEntity";
            g gVar10 = new g(str57, hashMap7, hashSet6, hashSet8);
            g gVar2 = g.a(gVar, str57);
            if (!gVar10.equals(gVar2)) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("UserStateEntity(app.dogo.android.persistencedb.room.entity.UserStateEntity).\n Expected:\n");
                stringBuilder6.append(gVar10);
                stringBuilder6.append(str41);
                stringBuilder6.append(gVar2);
                w0.b bVar8 = new w0.b(i8, stringBuilder6.toString());
                return bVar8;
            }
            w0.b bVar6 = new w0.b(1, 0);
            return bVar6;
        }
    }
    static List M(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List N(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List P(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List Q(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List R(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List S(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static g T(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl, g g2) {
        userDatabase_Impl.a = g2;
        return g2;
    }

    static void U(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl, g g2) {
        userDatabase_Impl.t(g2);
    }

    static List V(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static List W(app.dogo.android.persistencedb.room.database.UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public u J() {
        u vVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            vVar = new v(this);
            this.s = vVar;
            return this.s;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public k0 K() {
        k0 l0Var;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            l0Var = new l0(this);
            this.u = l0Var;
            return this.u;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public q0 L() {
        q0 r0Var;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            r0Var = new r0(this);
            this.t = r0Var;
            return this.t;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    protected h f(e0 e0) {
        UserDatabase_Impl.a aVar = new UserDatabase_Impl.a(this, 4);
        w0 w0Var = new w0(e0, aVar, "0617dcea4098cbc9356df439ae629c27", "e51802ac574aab935d389d96a47ba07f");
        h.b.a aVar2 = h.b.a(e0.b);
        aVar2.c(e0.c);
        aVar2.b(w0Var);
        return e0.a.a(aVar2.a());
    }

    public List<b> h(Map<Class<? extends a>, a> map) {
        b[] obj3 = new b[1];
        a aVar = new a();
        return Arrays.asList(aVar);
    }

    public Set<Class<? extends a>> m() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(u.class, v.j());
        hashMap.put(q0.class, r0.I());
        hashMap.put(k0.class, l0.h());
        return hashMap;
    }
}
