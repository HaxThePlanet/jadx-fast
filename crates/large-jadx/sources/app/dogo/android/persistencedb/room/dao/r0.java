package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
import androidx.room.c0;
import androidx.room.f1.c;
import androidx.room.f1.f;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.PolicyEntity;
import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import app.dogo.android.persistencedb.room.entity.ReminderEntity;
import app.dogo.android.persistencedb.room.entity.UserCurrentDogIdUpdate;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity;
import d.e.g;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.d.h;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* compiled from: UserEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class r0 implements q0 {

    private final u0 a;
    private final h0<UserEntity> b = new r0$j<>();
    private final e.a.a.a.b.a.a c = new a();
    private final h0<ReminderEntity> d = new r0$p<>();
    private final h0<PottyReminderEntity> e = new r0$q<>();
    private final h0<PolicyEntity> f = new r0$r<>();
    private final h0<UserStateEntity> g = new r0$s<>();
    private final g0<UserCurrentDogIdUpdate> h = new r0$t<>();
    private final b1 i = new r0$v();
    private final b1 j = new r0$w();

    class a implements Callable<Void> {

        final /* synthetic */ UserEntity a;
        final /* synthetic */ r0 b;
        a(UserEntity userEntity) {
            this.b = r0Var;
            this.a = userEntity;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class b implements Callable<Void> {

        final /* synthetic */ ReminderEntity[] a;
        final /* synthetic */ r0 b;
        b(ReminderEntity[] reminderEntityArr) {
            this.b = r0Var;
            this.a = reminderEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.d.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class c implements Callable<List<Long>> {

        final /* synthetic */ PottyReminderEntity[] a;
        final /* synthetic */ r0 b;
        c(PottyReminderEntity[] pottyReminderEntityArr) {
            this.b = r0Var;
            this.a = pottyReminderEntityArr;
            super();
        }

        public List<Long> a() {
            this.b.a.c();
            try {
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var3 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return this.b.e.j(this.a);
        }
    }

    class d implements Callable<Void> {

        final /* synthetic */ PolicyEntity[] a;
        final /* synthetic */ r0 b;
        d(PolicyEntity[] policyEntityArr) {
            this.b = r0Var;
            this.a = policyEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.f.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class e implements Callable<w> {

        final /* synthetic */ UserStateEntity a;
        final /* synthetic */ r0 b;
        e(UserStateEntity userStateEntity) {
            this.b = r0Var;
            this.a = userStateEntity;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.g.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class f implements Callable<Void> {

        final /* synthetic */ r0 a;
        f() {
            this.a = r0Var;
            super();
        }

        public Void a() {
            k kVar2 = this.a.i.a();
            this.a.a.c();
            try {
                kVar2.N();
                this.a.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.a.a;
                this.a.g();
                r0Var4 = this.a.i;
                this.a.f(kVar);
                throw th;
            }
            this.a.a.g();
            this.a.i.f(kVar2);
            return null;
        }
    }

    class g implements Callable<Void> {

        final /* synthetic */ r0 a;
        g() {
            this.a = r0Var;
            super();
        }

        public Void a() {
            k kVar2 = this.a.j.a();
            this.a.a.c();
            try {
                kVar2.N();
                this.a.a.C();
            } finally {
                e.a.a.a.b.b.r0 r0Var4 = this.a.a;
                this.a.g();
                r0Var4 = this.a.j;
                this.a.f(kVar);
                throw th;
            }
            this.a.a.g();
            this.a.j.f(kVar2);
            return null;
        }
    }

    class h implements Callable<h> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        h(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public h a() {
            List list;
            Object obj3;
            android.os.CancellationSignal cancellationSignal = null;
            Object obj4 = null;
            String string = null;
            int i3;
            Object obj5;
            int i4;
            boolean moveToFirst;
            Object obj6;
            Object obj;
            this.b.a.c();
            try {
                cancellationSignal = null;
                Cursor cursor = c.c(this.b.a, this.a, true, cancellationSignal);
            } catch (Throwable th) {
            }
            try {
                int i = b.e(cursor, "id");
                int i2 = b.e(cursor, "currentDogId");
                i3 = b.e(cursor, "abBucket");
                i4 = b.e(cursor, "participatingInChallenges");
                final d.e.a aVar2 = new a();
                while (cursor.moveToNext()) {
                    String string2 = cursor.getString(i);
                    if ((ArrayList)aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList());
                    }
                }
                cursor.moveToPosition(-1);
                this.b.x(aVar2);
                if (cursor.moveToFirst()) {
                    if (!cursor.isNull(i) || this.b.a.isNull(i2) || this.b.a.isNull(i3) || !this.b.a.isNull(i4)) {
                        if (cursor.isNull(i)) {
                        } else {
                            String string5 = cursor.getString(i);
                        }
                        if (cursor.isNull(i2)) {
                        } else {
                            String string4 = cursor.getString(i2);
                        }
                        if (cursor.isNull(i3)) {
                        } else {
                            Long num = Long.valueOf(cursor.getLong(i3));
                        }
                        if (!(cursor.isNull(i4))) {
                            string = cursor.getString(i4);
                        }
                    }
                    if ((ArrayList)aVar2.get(cursor.getString(i)) == null) {
                        ArrayList arrayList = new ArrayList();
                    }
                }
                this.b.a.C();
            } catch (Throwable th) {
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Query returned empty result set: ";
                String str4 = this.a.a();
                r2 = str3 + str4;
                throw new EmptyResultSetException(r2);
            } catch (Throwable th) {
            }
            try {
                th.close();
                throw th;
            } catch (Throwable th) {
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class i implements Callable<Boolean> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        i(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public Boolean a() {
            android.os.CancellationSignal cancellationSignal;
            boolean z = false;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                if (cursor.isNull(z)) {
                } else {
                    Integer num = Integer.valueOf(cursor.getInt(z));
                }
                if (cancellationSignal.intValue() != 0) {
                    int i = 1;
                }
            } finally {
                obj.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Query returned empty result set: ";
                    String str3 = this.a.a();
                    r2 = str2 + str3;
                    throw new EmptyResultSetException(r2);
                } finally {
                    obj.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class k implements Callable<List<ReminderEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        k(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public List<ReminderEntity> a() {
            String string3;
            String string;
            String string2;
            String string4;
            String string5;
            String string6;
            Object obj3;
            boolean z;
            final Object obj = this;
            z = false;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "id");
                int i2 = b.e(cursor, "ownerId");
                int i3 = b.e(cursor, "days");
                int i4 = b.e(cursor, "name");
                int i5 = b.e(cursor, "type");
                int i6 = b.e(cursor, "time");
                int i7 = b.e(cursor, "repeating");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                if (cursor.isNull(i3)) {
                } else {
                    string3 = cursor.getString(i3);
                }
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string6;
                cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string7;
                int _int = cursor.getInt(b.e(cursor, "isActive")) != 0 ? _int : z;
                ReminderEntity reminderEntity = new ReminderEntity(string, string2, obj.b.c.toBooleanList(string3), string4, string5, string6, obj3, z);
                arrayList.add(reminderEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class l implements Callable<PottyReminderEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        l(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public PottyReminderEntity a() {
            Object obj7;
            boolean z = false;
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            final Object obj8 = this;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(obj8.b.a, obj8.a, z, cancellationSignal);
            try {
                int _int = b.e(cursor, "reminderId");
                int i = b.e(cursor, "dogId");
                int i3 = b.e(cursor, "ownerId");
                int i4 = b.e(cursor, "days");
                int i5 = b.e(cursor, "startTime");
                int i6 = b.e(cursor, "endTime");
                int i7 = b.e(cursor, "repeatIntervalMs");
                if (cursor.moveToFirst()) {
                    cancellationSignal = cursor.isNull(_int) ? cancellationSignal : string5;
                    cancellationSignal = cursor.isNull(i) ? cancellationSignal : string4;
                    cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string3;
                    if (cursor.isNull(i4)) {
                    } else {
                        String string6 = cursor.getString(i4);
                    }
                    e.a.a.a.b.a.a aVar = obj8.b.c;
                    cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string2;
                    cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string;
                    if (!cursor.isNull(i7)) {
                        Object num = Long.valueOf(cursor.getLong(i7));
                    }
                    if (cursor.getInt(b.e(cursor, "isActive")) != 0) {
                        int i2 = 1;
                    }
                    PottyReminderEntity pottyReminderEntity = new PottyReminderEntity(obj, obj2, obj3, aVar.toBooleanList(obj7), obj4, obj5, cancellationSignal, z);
                }
            } finally {
                obj9.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Query returned empty result set: ";
                    String str3 = obj8.a.a();
                    r3 = str2 + str3;
                    throw new EmptyResultSetException(r3);
                } finally {
                    obj9.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class m implements Callable<List<PottyReminderEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        m(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public List<PottyReminderEntity> a() {
            String string4;
            String string;
            String string2;
            String string3;
            String string5;
            String string6;
            Object obj3;
            boolean z;
            final Object obj = this;
            z = false;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "reminderId");
                int i2 = b.e(cursor, "dogId");
                int i3 = b.e(cursor, "ownerId");
                int i4 = b.e(cursor, "days");
                int i5 = b.e(cursor, "startTime");
                int i6 = b.e(cursor, "endTime");
                int i7 = b.e(cursor, "repeatIntervalMs");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string3;
                if (cursor.isNull(i4)) {
                } else {
                    string4 = cursor.getString(i4);
                }
                e.a.a.a.b.a.a aVar = obj.b.c;
                cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string6;
                if (cursor.isNull(i7)) {
                } else {
                }
                int _int = cursor.getInt(b.e(cursor, "isActive")) != 0 ? _int : z;
                PottyReminderEntity pottyReminderEntity = new PottyReminderEntity(string, string2, string3, aVar.toBooleanList(string4), string5, string6, obj3, z);
                arrayList.add(pottyReminderEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class n implements Callable<List<PottyReminderEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        n(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public List<PottyReminderEntity> a() {
            String string4;
            String string;
            String string2;
            String string3;
            String string5;
            String string6;
            Object obj3;
            boolean z;
            final Object obj = this;
            z = false;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "reminderId");
                int i2 = b.e(cursor, "dogId");
                int i3 = b.e(cursor, "ownerId");
                int i4 = b.e(cursor, "days");
                int i5 = b.e(cursor, "startTime");
                int i6 = b.e(cursor, "endTime");
                int i7 = b.e(cursor, "repeatIntervalMs");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string3;
                if (cursor.isNull(i4)) {
                } else {
                    string4 = cursor.getString(i4);
                }
                e.a.a.a.b.a.a aVar = obj.b.c;
                cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string6;
                if (cursor.isNull(i7)) {
                } else {
                }
                int _int = cursor.getInt(b.e(cursor, "isActive")) != 0 ? _int : z;
                PottyReminderEntity pottyReminderEntity = new PottyReminderEntity(string, string2, string3, aVar.toBooleanList(string4), string5, string6, obj3, z);
                arrayList.add(pottyReminderEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class o implements Callable<UserStateEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r0 b;
        o(x0 x0Var) {
            this.b = r0Var;
            this.a = x0Var;
            super();
        }

        public UserStateEntity a() {
            Object obj;
            boolean z = false;
            String string = null;
            android.os.CancellationSignal cancellationSignal = null;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "userId");
                int i4 = b.e(cursor, "lastSeenGoalNotReachedState");
                if (cursor.isNull(i)) {
                } else {
                    String string2 = cursor.getString(i);
                }
                if (cursor.getInt(b.e(cursor, "isWorkoutStreakSyncedToTrainingMetrics")) != 0) {
                    int i3 = 1;
                }
                if (!(cursor.isNull(i4))) {
                    string = cursor.getString(i4);
                }
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return cancellationSignal;
        }
    }

    class u extends b1 {
        u(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM ReminderEntity";
        }
    }

    class v extends b1 {
        v(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM PolicyEntity";
        }
    }

    class w extends b1 {
        w(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM UserEntity";
        }
    }

    class j extends h0<UserEntity> {

        final /* synthetic */ r0 d;
        j(u0 u0Var) {
            this.d = r0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, UserEntity userEntity) {
            int i2 = 1;
            if (userEntity.getId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, userEntity.getId());
            }
            int i3 = 2;
            if (userEntity.getCurrentDogId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, userEntity.getCurrentDogId());
            }
            int i4 = 3;
            if (userEntity.getAbBucket() == null) {
                kVar.k1(i4);
            } else {
                kVar.u0(i4, userEntity.getAbBucket().longValue());
            }
            String stringList = this.d.c.fromStringList(userEntity.getParticipatingInChallenges());
            int i = 4;
            if (stringList == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, stringList);
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `UserEntity` (`id`,`currentDogId`,`abBucket`,`participatingInChallenges`) VALUES (?,?,?,?)";
        }
    }

    class p extends h0<ReminderEntity> {

        final /* synthetic */ r0 d;
        p(u0 u0Var) {
            this.d = r0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, ReminderEntity reminderEntity) {
            int i2 = 1;
            if (reminderEntity.getReminderId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, reminderEntity.getReminderId());
            }
            int i3 = 2;
            if (reminderEntity.getOwnerId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, reminderEntity.getOwnerId());
            }
            String booleanList = this.d.c.fromBooleanList(reminderEntity.getDays());
            int i4 = 3;
            if (booleanList == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, booleanList);
            }
            int i5 = 4;
            if (reminderEntity.getName() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, reminderEntity.getName());
            }
            int i6 = 5;
            if (reminderEntity.getType() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, reminderEntity.getType());
            }
            int i7 = 6;
            if (reminderEntity.getTime() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, reminderEntity.getTime());
            }
            int i8 = 7;
            if (reminderEntity.getRepeating() == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, reminderEntity.getRepeating());
            }
            kVar.u0(8, reminderEntity.isActive() != 0 ? 1 : 0);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ReminderEntity` (`id`,`ownerId`,`days`,`name`,`type`,`time`,`repeating`,`isActive`) VALUES (?,?,?,?,?,?,?,?)";
        }
    }

    class q extends h0<PottyReminderEntity> {

        final /* synthetic */ r0 d;
        q(u0 u0Var) {
            this.d = r0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, PottyReminderEntity pottyReminderEntity) {
            long value;
            int i2 = 1;
            if (pottyReminderEntity.getReminderId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, pottyReminderEntity.getReminderId());
            }
            int i3 = 2;
            if (pottyReminderEntity.getDogId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, pottyReminderEntity.getDogId());
            }
            int i4 = 3;
            if (pottyReminderEntity.getOwnerId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, pottyReminderEntity.getOwnerId());
            }
            String booleanList = this.d.c.fromBooleanList(pottyReminderEntity.getDays());
            int i5 = 4;
            if (booleanList == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, booleanList);
            }
            int i6 = 5;
            if (pottyReminderEntity.getStartTime() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, pottyReminderEntity.getStartTime());
            }
            int i7 = 6;
            if (pottyReminderEntity.getEndTime() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, pottyReminderEntity.getEndTime());
            }
            int i8 = 7;
            if (pottyReminderEntity.getRepeatIntervalMs() == null) {
                kVar.k1(i8);
            } else {
                kVar.u0(i8, pottyReminderEntity.getRepeatIntervalMs().longValue());
            }
            kVar.u0(8, pottyReminderEntity.isActive() != 0 ? 1 : 0);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `PottyReminderEntity` (`reminderId`,`dogId`,`ownerId`,`days`,`startTime`,`endTime`,`repeatIntervalMs`,`isActive`) VALUES (?,?,?,?,?,?,?,?)";
        }
    }

    class r extends h0<PolicyEntity> {
        r(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, PolicyEntity policyEntity) {
            int i = 1;
            if (policyEntity.getId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, policyEntity.getId());
            }
            int i2 = 2;
            if (policyEntity.getStatus() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, policyEntity.getStatus());
            }
            int i3 = 3;
            if (policyEntity.getOwnerId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, policyEntity.getOwnerId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `PolicyEntity` (`id`,`status`,`ownerId`) VALUES (?,?,?)";
        }
    }

    class s extends h0<UserStateEntity> {

        final /* synthetic */ r0 d;
        s(u0 u0Var) {
            this.d = r0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, UserStateEntity userStateEntity) {
            int i2 = 1;
            if (userStateEntity.getUserId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, userStateEntity.getUserId());
            }
            kVar.u0(2, userStateEntity.isWorkoutStreakSyncedToTrainingMetrics() != 0 ? 1 : 0);
            String goalNotReachedState = this.d.c.fromGoalNotReachedState(userStateEntity.getLastSeenGoalNotReachedState());
            int i = 3;
            if (goalNotReachedState == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, goalNotReachedState);
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `UserStateEntity` (`userId`,`isWorkoutStreakSyncedToTrainingMetrics`,`lastSeenGoalNotReachedState`) VALUES (?,?,?)";
        }
    }

    class t extends g0<UserCurrentDogIdUpdate> {
        t(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, UserCurrentDogIdUpdate userCurrentDogIdUpdate) {
            int i = 1;
            if (userCurrentDogIdUpdate.getId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, userCurrentDogIdUpdate.getId());
            }
            int i2 = 2;
            if (userCurrentDogIdUpdate.getCurrentDogId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, userCurrentDogIdUpdate.getCurrentDogId());
            }
            int i3 = 3;
            if (userCurrentDogIdUpdate.getId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, userCurrentDogIdUpdate.getId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `UserEntity` SET `id` = ?,`currentDogId` = ? WHERE `id` = ?";
        }
    }
    public r0(u0 u0Var) {
        super();
        e.a.a.a.b.a.a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.r0.j jVar = new app.dogo.android.persistencedb.room.dao.r0.j(this, u0Var);
        e.a.a.a.b.b.r0.p pVar = new app.dogo.android.persistencedb.room.dao.r0.p(this, u0Var);
        e.a.a.a.b.b.r0.q qVar = new app.dogo.android.persistencedb.room.dao.r0.q(this, u0Var);
        e.a.a.a.b.b.r0.r rVar = new app.dogo.android.persistencedb.room.dao.r0.r(this, u0Var);
        e.a.a.a.b.b.r0.s sVar = new app.dogo.android.persistencedb.room.dao.r0.s(this, u0Var);
        e.a.a.a.b.b.r0.t tVar = new app.dogo.android.persistencedb.room.dao.r0.t(this, u0Var);
        e.a.a.a.b.b.r0.u uVar = new app.dogo.android.persistencedb.room.dao.r0.u(this, u0Var);
        e.a.a.a.b.b.r0.v vVar = new app.dogo.android.persistencedb.room.dao.r0.v(this, u0Var);
        e.a.a.a.b.b.r0.w wVar = new app.dogo.android.persistencedb.room.dao.r0.w(this, u0Var);
    }

    static /* synthetic */ void A(r0 r0Var, d.e.a aVar) {
        r0Var.x(aVar);
    }

    static /* synthetic */ h0 B(r0 r0Var) {
        return r0Var.b;
    }

    static /* synthetic */ h0 C(r0 r0Var) {
        return r0Var.d;
    }

    static /* synthetic */ h0 D(r0 r0Var) {
        return r0Var.e;
    }

    static /* synthetic */ h0 E(r0 r0Var) {
        return r0Var.f;
    }

    static /* synthetic */ h0 F(r0 r0Var) {
        return r0Var.g;
    }

    static /* synthetic */ b1 G(r0 r0Var) {
        return r0Var.i;
    }

    static /* synthetic */ b1 H(r0 r0Var) {
        return r0Var.j;
    }

    public static List<Class<?>> I() {
        return Collections.emptyList();
    }

    private void x(d.e.a<String, ArrayList<PolicyEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        String string;
        String string2;
        String string3;
        PolicyEntity policyEntity;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i5 = 999;
        i2 = 0;
        if (aVar.size() > i5) {
            aVar2 = new a(i5);
            while (i2 < aVar.size()) {
                aVar2.put((String)aVar.j(i2), (ArrayList)aVar.n(i2));
                i2 = i2 + 1;
                i2 = i2 + 1;
            }
            if (i2 > 0) {
                x(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str3 = "SELECT `id`,`status`,`ownerId` FROM `PolicyEntity` WHERE `ownerId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str4 = ")";
        str = str3 + str4;
        x0 x0Var = x0.e(str, size3 + i2);
        Iterator it = keys.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
        }
        android.os.CancellationSignal cancellationSignal = null;
        Cursor cursor = c.c(this.a, x0Var, false, cancellationSignal);
        try {
            int i4 = b.d(cursor, "ownerId");
        } finally {
            obj3.close();
            throw aVar;
        }
        int i3 = -1;
        if (i4 == -1) {
            cursor.close();
            return;
        }
        while (cursor.moveToNext()) {
            Object obj4 = aVar.get(cursor.getString(i4));
            try {
                obj4 = aVar.get(this.a.getString(i4));
                int i7 = 2;
                obj4.add(new PolicyEntity(string, string2, string3));
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    static /* synthetic */ e.a.a.a.b.a.a y(r0 r0Var) {
        return r0Var.c;
    }

    static /* synthetic */ u0 z(r0 r0Var) {
        return r0Var.a;
    }

    public a0<PottyReminderEntity> a(String str) {
        return app.dogo.android.persistencedb.room.dao.q0.a.f(this, str);
    }

    public i.b.b b(UserEntity userEntity) {
        return b.o(new app.dogo.android.persistencedb.room.dao.r0.a(this, userEntity));
    }

    public Object c(String str, String str2, int i, d<? super w> dVar) {
        return app.dogo.android.persistencedb.room.dao.q0.a.m(this, str, str2, i, dVar);
    }

    public i.b.b d() {
        return b.o(new app.dogo.android.persistencedb.room.dao.r0.g(this));
    }

    public Object e(String str, boolean z, d<? super w> dVar) {
        return app.dogo.android.persistencedb.room.dao.q0.a.n(this, str, z, dVar);
    }

    public Object f(UserStateEntity userStateEntity, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.r0.e(this, userStateEntity), dVar);
    }

    public i.b.b g(PolicyEntity... policyEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.r0.d(this, policyEntityArr));
    }

    public a0<h> h(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM UserEntity WHERE id= ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.h(this, x0Var));
    }

    public i.b.b i(ReminderEntity... reminderEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.r0.b(this, reminderEntityArr));
    }

    public a0<List<PottyReminderEntity>> j(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE dogId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.m(this, x0Var));
    }

    public a0<List<ReminderEntity>> k(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ReminderEntity WHERE ownerId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.k(this, x0Var));
    }

    public a0<List<ReminderEntity>> l(String str) {
        return app.dogo.android.persistencedb.room.dao.q0.a.g(this, str);
    }

    public Object m(String str, d<? super UserStateEntity> dVar) {
        return app.dogo.android.persistencedb.room.dao.q0.a.i(this, str, dVar);
    }

    public Object n(String str, d<? super UserStateEntity> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM UserStateEntity WHERE userId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.r0.o(this, x0Var), dVar);
    }

    public void o(UserCurrentDogIdUpdate userCurrentDogIdUpdate) {
        this.a.b();
        this.a.c();
        try {
            this.h.h(userCurrentDogIdUpdate);
            this.a.C();
        } finally {
            this.a.g();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) userCurrentDogIdUpdate;
        }
        this.a.g();
    }

    public a0<List<Long>> p(PottyReminderEntity... pottyReminderEntityArr) {
        return a0.fromCallable(new app.dogo.android.persistencedb.room.dao.r0.c(this, pottyReminderEntityArr));
    }

    public a0<PottyReminderEntity> q(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE reminderId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.l(this, x0Var));
    }

    public i.b.b r() {
        return app.dogo.android.persistencedb.room.dao.q0.a.a(this);
    }

    public i.b.b s(h hVar) {
        return app.dogo.android.persistencedb.room.dao.q0.a.b(this, hVar);
    }

    public a0<List<PottyReminderEntity>> t(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE ownerId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.n(this, x0Var));
    }

    public a0<String> u(String str) {
        return app.dogo.android.persistencedb.room.dao.q0.a.c(this, str);
    }

    public i.b.b v() {
        return b.o(new app.dogo.android.persistencedb.room.dao.r0.f(this));
    }

    public a0<Boolean> w(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM UserEntity WHERE id = ?)", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r0.i(this, x0Var));
    }
}
