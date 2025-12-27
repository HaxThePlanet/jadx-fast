package app.dogo.android.persistencedb.room.database;

import androidx.room.e0;
import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g.a;
import androidx.room.m0;
import androidx.room.u0;
import androidx.room.u0.b;
import androidx.room.w0;
import androidx.room.w0.a;
import androidx.room.w0.b;
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

/* compiled from: UserDatabase_Impl.java */
/* loaded from: classes.dex */
public final class UserDatabase_Impl extends UserDatabase {

    private volatile u s;
    private volatile q0 t;
    private volatile k0 u;

    class a extends w0.a {

        final /* synthetic */ UserDatabase_Impl b;
        a(int i) {
            this.b = userDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `DogEntity` (`id` TEXT NOT NULL, `creatorId` TEXT NOT NULL, `name` TEXT, `breedId` TEXT, `customBreed` TEXT, `birthday` TEXT, `birthdayExact` INTEGER, `gender` TEXT, `avatarUrl` TEXT, `parentId` TEXT NOT NULL, `createTimeMs` INTEGER, PRIMARY KEY(`id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `UserEntity` (`id` TEXT NOT NULL, `currentDogId` TEXT NOT NULL, `abBucket` INTEGER, `participatingInChallenges` TEXT NOT NULL, PRIMARY KEY(`id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `PolicyEntity` (`id` TEXT NOT NULL, `status` TEXT NOT NULL, `ownerId` TEXT NOT NULL, PRIMARY KEY(`id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ReminderEntity` (`id` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `days` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `time` TEXT NOT NULL, `repeating` TEXT NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `PottyReminderEntity` (`reminderId` TEXT NOT NULL DEFAULT '', `dogId` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `days` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `repeatIntervalMs` INTEGER, `isActive` INTEGER NOT NULL, PRIMARY KEY(`reminderId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrainingStreakEntity` (`userId` TEXT NOT NULL, `currentStreak` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `trainingTimesSec` TEXT NOT NULL, `totalTrainingTimeSec` INTEGER NOT NULL, `remoteUpdateTimeMs` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `UserStateEntity` (`userId` TEXT NOT NULL, `isWorkoutStreakSyncedToTrainingMetrics` INTEGER NOT NULL, `lastSeenGoalNotReachedState` TEXT, PRIMARY KEY(`userId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0617dcea4098cbc9356df439ae629c27')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `DogEntity`");
            gVar.C("DROP TABLE IF EXISTS `UserEntity`");
            gVar.C("DROP TABLE IF EXISTS `PolicyEntity`");
            gVar.C("DROP TABLE IF EXISTS `ReminderEntity`");
            gVar.C("DROP TABLE IF EXISTS `PottyReminderEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrainingStreakEntity`");
            gVar.C("DROP TABLE IF EXISTS `UserStateEntity`");
            if (this.b.g != null) {
                i = 0;
                while (this.b.g < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).b(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(d.s.a.g gVar) {
            int i = 0;
            Object item;
            if (this.b.g != null) {
                i = 0;
                while (this.b < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).a(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(d.s.a.g gVar) {
            int i = 0;
            Object item;
            this.b.a = gVar;
            this.b.t(gVar);
            if (this.b.g != null) {
                i = 0;
                while (this.b < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).c(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void f(d.s.a.g gVar) {
            c.b(gVar);
        }

        @Override // androidx.room.w0$a
        protected w0.b g(d.s.a.g gVar) {
            d.s.a.g gVar2 = gVar;
            HashMap hashMap = new HashMap(11);
            int i10 = 1;
            g.a aVar = new g.a("id", "TEXT", true, i10, null, 1);
            String str = "id";
            hashMap.put(str, aVar);
            int i13 = 0;
            g.a aVar2 = new g.a("creatorId", "TEXT", i10, i13, null, 1);
            hashMap.put("creatorId", aVar2);
            int i16 = 0;
            String str100 = null;
            int i27 = 1;
            g.a aVar3 = new g.a("name", "TEXT", i13, i16, str100, i27);
            String str18 = "name";
            hashMap.put(str18, aVar3);
            g.a aVar4 = new g.a("breedId", "TEXT", i13, i16, str100, i27);
            hashMap.put("breedId", aVar4);
            int i20 = 0;
            String str113 = null;
            int i37 = 1;
            g.a aVar5 = new g.a("customBreed", "TEXT", i16, i20, str113, i37);
            hashMap.put("customBreed", aVar5);
            g.a aVar6 = new g.a("birthday", "TEXT", i16, i20, str113, i37);
            hashMap.put("birthday", aVar6);
            g.a aVar7 = new g.a("birthdayExact", "INTEGER", i16, i20, str113, i37);
            hashMap.put("birthdayExact", aVar7);
            g.a aVar8 = new g.a("gender", "TEXT", i16, i20, str113, i37);
            hashMap.put("gender", aVar8);
            g.a aVar9 = new g.a("avatarUrl", "TEXT", i16, i20, str113, i37);
            hashMap.put("avatarUrl", aVar9);
            g.a aVar10 = new g.a("parentId", "TEXT", true, i20, str113, i37);
            hashMap.put("parentId", aVar10);
            g.a aVar11 = new g.a("createTimeMs", "INTEGER", false, i20, str113, i37);
            hashMap.put("createTimeMs", aVar11);
            int i8 = 0;
            String str65 = "DogEntity";
            androidx.room.f1.g gVar12 = new g(str65, hashMap, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar4 = g.a(gVar2, str65);
            String str41 = "\n Found:\n";
            if (!gVar12.equals(gVar4)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "DogEntity(app.dogo.android.persistencedb.room.entity.DogEntity).\n Expected:\n";
                r1 = str2 + gVar12 + str41 + gVar4;
                return new w0.b(false, r1);
            }
            HashMap hashMap2 = new HashMap(4);
            g.a aVar12 = new g.a("id", "TEXT", true, 1, null, 1);
            hashMap2.put(str, aVar12);
            g.a aVar13 = new g.a("currentDogId", "TEXT", true, 0, null, 1);
            hashMap2.put("currentDogId", aVar13);
            int i39 = 0;
            String str129 = null;
            int i52 = 1;
            g.a aVar14 = new g.a("abBucket", "INTEGER", false, i39, str129, i52);
            hashMap2.put("abBucket", aVar14);
            g.a aVar15 = new g.a("participatingInChallenges", "TEXT", true, i39, str129, i52);
            hashMap2.put("participatingInChallenges", aVar15);
            String str86 = "UserEntity";
            androidx.room.f1.g gVar14 = new g(str86, hashMap2, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar5 = g.a(gVar2, str86);
            if (!gVar14.equals(gVar5)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = "UserEntity(app.dogo.android.persistencedb.room.entity.UserEntity).\n Expected:\n";
                r1 = str3 + gVar14 + str41 + gVar5;
                return new w0.b(false, r1);
            }
            HashMap hashMap3 = new HashMap(3);
            g.a aVar41 = new g.a("id", "TEXT", true, 1, null, 1);
            hashMap3.put(str, aVar41);
            g.a aVar42 = new g.a("status", "TEXT", true, 0, null, 1);
            hashMap3.put("status", aVar42);
            g.a aVar43 = new g.a("ownerId", "TEXT", true, 0, null, 1);
            String str69 = "ownerId";
            hashMap3.put(str69, aVar43);
            String str115 = "PolicyEntity";
            androidx.room.f1.g gVar15 = new g(str115, hashMap3, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar6 = g.a(gVar2, str115);
            if (!gVar15.equals(gVar6)) {
                StringBuilder stringBuilder7 = new StringBuilder();
                String str15 = "PolicyEntity(app.dogo.android.persistencedb.room.entity.PolicyEntity).\n Expected:\n";
                r1 = str15 + gVar15 + str41 + gVar6;
                return new w0.b(false, r1);
            }
            int i11 = 8;
            HashMap hashMap4 = new HashMap(i11);
            boolean z3 = true;
            String str130 = null;
            g.a aVar16 = new g.a("id", "TEXT", z3, 1, str130, 1);
            hashMap4.put(str, aVar16);
            boolean z5 = true;
            int i72 = 0;
            String str145 = null;
            int i75 = 1;
            g.a aVar17 = new g.a("ownerId", "TEXT", z5, i72, str145, i75);
            hashMap4.put(str69, aVar17);
            int i46 = 0;
            int i56 = 1;
            g.a aVar18 = new g.a("days", "TEXT", z3, i46, str130, i56);
            String str4 = "days";
            hashMap4.put(str4, aVar18);
            g.a aVar19 = new g.a("name", "TEXT", z3, i46, str130, i56);
            hashMap4.put(str18, aVar19);
            g.a aVar20 = new g.a("type", "TEXT", z5, i72, str145, i75);
            hashMap4.put("type", aVar20);
            g.a aVar21 = new g.a("time", "TEXT", z3, i46, str130, i56);
            hashMap4.put("time", aVar21);
            g.a aVar22 = new g.a("repeating", "TEXT", z3, i46, str130, i56);
            hashMap4.put("repeating", aVar22);
            g.a aVar23 = new g.a("isActive", "INTEGER", z3, i46, str130, i56);
            String str22 = "isActive";
            hashMap4.put(str22, aVar23);
            String str122 = "ReminderEntity";
            androidx.room.f1.g gVar16 = new g(str122, hashMap4, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar7 = g.a(gVar2, str122);
            if (!gVar16.equals(gVar7)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str5 = "ReminderEntity(app.dogo.android.persistencedb.room.entity.ReminderEntity).\n Expected:\n";
                r1 = str5 + gVar16 + str41 + gVar7;
                return new w0.b(false, r1);
            }
            HashMap hashMap5 = new HashMap(i11);
            boolean z4 = true;
            int i57 = 1;
            g.a aVar24 = new g.a("reminderId", "TEXT", z4, 1, "''", i57);
            hashMap5.put("reminderId", aVar24);
            int i48 = 0;
            String str132 = null;
            g.a aVar25 = new g.a("dogId", "TEXT", z4, i48, str132, i57);
            hashMap5.put("dogId", aVar25);
            g.a aVar26 = new g.a("ownerId", "TEXT", z4, i48, str132, i57);
            hashMap5.put(str69, aVar26);
            g.a aVar27 = new g.a("days", "TEXT", true, 0, null, 1);
            hashMap5.put(str4, aVar27);
            boolean z = true;
            int i32 = 0;
            String str126 = null;
            int i49 = 1;
            g.a aVar28 = new g.a("startTime", "TEXT", z, i32, str126, i49);
            hashMap5.put("startTime", aVar28);
            g.a aVar29 = new g.a("endTime", "TEXT", z, i32, str126, i49);
            hashMap5.put("endTime", aVar29);
            g.a aVar30 = new g.a("repeatIntervalMs", "INTEGER", false, i32, str126, i49);
            hashMap5.put("repeatIntervalMs", aVar30);
            g.a aVar31 = new g.a("isActive", "INTEGER", true, i32, str126, i49);
            hashMap5.put(str22, aVar31);
            String str56 = "PottyReminderEntity";
            androidx.room.f1.g gVar10 = new g(str56, hashMap5, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar8 = g.a(gVar2, str56);
            if (!gVar10.equals(gVar8)) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str9 = "PottyReminderEntity(app.dogo.android.persistencedb.room.entity.PottyReminderEntity).\n Expected:\n";
                r1 = str9 + gVar10 + str41 + gVar8;
                return new w0.b(false, r1);
            }
            HashMap hashMap6 = new HashMap(6);
            boolean z2 = true;
            String str127 = null;
            int i50 = 1;
            g.a aVar32 = new g.a("userId", "TEXT", z2, 1, str127, i50);
            String str10 = "userId";
            hashMap6.put(str10, aVar32);
            int i34 = 0;
            g.a aVar33 = new g.a("currentStreak", "INTEGER", z2, i34, str127, i50);
            hashMap6.put("currentStreak", aVar33);
            g.a aVar34 = new g.a("longestStreak", "INTEGER", z2, i34, str127, i50);
            hashMap6.put("longestStreak", aVar34);
            g.a aVar35 = new g.a("trainingTimesSec", "TEXT", z2, i34, str127, i50);
            hashMap6.put("trainingTimesSec", aVar35);
            g.a aVar36 = new g.a("totalTrainingTimeSec", "INTEGER", z2, i34, str127, i50);
            hashMap6.put("totalTrainingTimeSec", aVar36);
            g.a aVar37 = new g.a("remoteUpdateTimeMs", "INTEGER", z2, i34, str127, i50);
            hashMap6.put("remoteUpdateTimeMs", aVar37);
            String str80 = "TrainingStreakEntity";
            androidx.room.f1.g gVar13 = new g(str80, hashMap6, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar9 = g.a(gVar2, str80);
            if (!gVar13.equals(gVar9)) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str11 = "TrainingStreakEntity(app.dogo.android.persistencedb.room.entity.TrainingStreakEntity).\n Expected:\n";
                r1 = str11 + gVar13 + str41 + gVar9;
                return new w0.b(false, r1);
            }
            HashMap hashMap7 = new HashMap(3);
            String str128 = null;
            int i51 = 1;
            g.a aVar38 = new g.a("userId", "TEXT", true, 1, str128, i51);
            hashMap7.put(str10, aVar38);
            g.a aVar39 = new g.a("isWorkoutStreakSyncedToTrainingMetrics", "INTEGER", true, 0, null, 1);
            hashMap7.put("isWorkoutStreakSyncedToTrainingMetrics", aVar39);
            g.a aVar40 = new g.a("lastSeenGoalNotReachedState", "TEXT", false, 0, str128, i51);
            hashMap7.put("lastSeenGoalNotReachedState", aVar40);
            String str57 = "UserStateEntity";
            androidx.room.f1.g gVar11 = new g(str57, hashMap7, new HashSet(i8), new HashSet(i8));
            androidx.room.f1.g gVar3 = g.a(gVar2, str57);
            if (!gVar11.equals(gVar3)) {
                StringBuilder stringBuilder6 = new StringBuilder();
                String str14 = "UserStateEntity(app.dogo.android.persistencedb.room.entity.UserStateEntity).\n Expected:\n";
                r0 = str14 + gVar11 + str41 + gVar3;
                return new w0.b(false, r0);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List M(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List N(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List O(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List P(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List Q(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List R(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List S(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g T(UserDatabase_Impl userDatabase_Impl, d.s.a.g gVar) {
        userDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void U(UserDatabase_Impl userDatabase_Impl, d.s.a.g gVar) {
        userDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List V(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    static /* synthetic */ List W(UserDatabase_Impl userDatabase_Impl) {
        return userDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public u J() {
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new app.dogo.android.persistencedb.room.dao.v(this);
                }
                return this.s;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public k0 K() {
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            try {
                if (this.u == null) {
                    this.u = new app.dogo.android.persistencedb.room.dao.l0(this);
                }
                return this.u;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public q0 L() {
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new app.dogo.android.persistencedb.room.dao.r0(this);
                }
                return this.t;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    protected m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "DogEntity", "UserEntity", "PolicyEntity", "ReminderEntity", "PottyReminderEntity", "TrainingStreakEntity", "UserStateEntity" });
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    protected h f(e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new UserDatabase_Impl.a(this, 4), "0617dcea4098cbc9356df439ae629c27", "e51802ac574aab935d389d96a47ba07f"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        b[] arr = new b[1];
        return Arrays.asList(new b[] { new a() });
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.room.database.UserDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(DogEntityDao.class, app.dogo.android.persistencedb.room.dao.v.j());
        hashMap.put(UserEntityDao.class, app.dogo.android.persistencedb.room.dao.r0.I());
        hashMap.put(TrainingStreakEntityDao.class, app.dogo.android.persistencedb.room.dao.l0.h());
        return hashMap;
    }
}
