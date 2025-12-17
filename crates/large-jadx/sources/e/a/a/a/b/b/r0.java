package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
import androidx.room.c0;
import androidx.room.f1.b;
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
import d.e.a;
import d.e.g;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import e.a.a.a.b.d.h;
import i.b.a0;
import i.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
public final class r0 implements e.a.a.a.b.b.q0 {

    private final u0 a;
    private final h0<UserEntity> b;
    private final a c;
    private final h0<ReminderEntity> d;
    private final h0<PottyReminderEntity> e;
    private final h0<PolicyEntity> f;
    private final h0<UserStateEntity> g;
    private final g0<UserCurrentDogIdUpdate> h;
    private final b1 i;
    private final b1 j;

    class a implements Callable<Void> {

        final UserEntity a;
        final e.a.a.a.b.b.r0 b;
        a(e.a.a.a.b.b.r0 r0, UserEntity userEntity2) {
            this.b = r0;
            this.a = userEntity2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            r0.z(this.b).c();
            r0.B(this.b).h(this.a);
            r0.z(this.b).C();
            r0.z(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class b implements Callable<Void> {

        final ReminderEntity[] a;
        final e.a.a.a.b.b.r0 b;
        b(e.a.a.a.b.b.r0 r0, ReminderEntity[] reminderEntity2Arr2) {
            this.b = r0;
            this.a = reminderEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            r0.z(this.b).c();
            r0.C(this.b).i(this.a);
            r0.z(this.b).C();
            r0.z(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<List<Long>> {

        final PottyReminderEntity[] a;
        final e.a.a.a.b.b.r0 b;
        c(e.a.a.a.b.b.r0 r0, PottyReminderEntity[] pottyReminderEntity2Arr2) {
            this.b = r0;
            this.a = pottyReminderEntity2Arr2;
            super();
        }

        public List<Long> a() {
            r0.z(this.b).c();
            r0.z(this.b).C();
            r0.z(this.b).g();
            return r0.D(this.b).j(this.a);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<Void> {

        final PolicyEntity[] a;
        final e.a.a.a.b.b.r0 b;
        d(e.a.a.a.b.b.r0 r0, PolicyEntity[] policyEntity2Arr2) {
            this.b = r0;
            this.a = policyEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            r0.z(this.b).c();
            r0.E(this.b).i(this.a);
            r0.z(this.b).C();
            r0.z(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<w> {

        final UserStateEntity a;
        final e.a.a.a.b.b.r0 b;
        e(e.a.a.a.b.b.r0 r0, UserStateEntity userStateEntity2) {
            this.b = r0;
            this.a = userStateEntity2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            r0.z(this.b).c();
            r0.F(this.b).h(this.a);
            r0.z(this.b).C();
            r0.z(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f implements Callable<Void> {

        final e.a.a.a.b.b.r0 a;
        f(e.a.a.a.b.b.r0 r0) {
            this.a = r0;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = r0.G(this.a).a();
            r0.z(this.a).c();
            kVar.N();
            r0.z(this.a).C();
            r0.z(this.a).g();
            r0.G(this.a).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<Void> {

        final e.a.a.a.b.b.r0 a;
        g(e.a.a.a.b.b.r0 r0) {
            this.a = r0;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = r0.H(this.a).a();
            r0.z(this.a).c();
            kVar.N();
            r0.z(this.a).C();
            r0.z(this.a).g();
            r0.H(this.a).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class h implements Callable<h> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        h(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public h a() {
            int arrayList;
            int hVar;
            int string;
            int valueOf;
            int userEntity;
            String string2;
            boolean moveToFirst;
            Object arrayList2;
            long null;
            r0.z(this.b).c();
            string = 0;
            Cursor cursor = c.c(r0.z(this.b), this.a, true, string);
            arrayList = b.e(cursor, "id");
            hVar = b.e(cursor, "currentDogId");
            valueOf = b.e(cursor, "abBucket");
            userEntity = b.e(cursor, "participatingInChallenges");
            a aVar2 = new a();
            while (cursor.moveToNext()) {
                string2 = cursor.getString(arrayList);
                if ((ArrayList)aVar2.get(string2) == null) {
                }
                arrayList2 = new ArrayList();
                aVar2.put(string2, arrayList2);
            }
            cursor.moveToPosition(-1);
            r0.A(this.b, aVar2);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(arrayList) && cursor.isNull(hVar) && cursor.isNull(valueOf)) {
                    if (cursor.isNull(hVar)) {
                        if (cursor.isNull(valueOf)) {
                            if (!cursor.isNull(userEntity)) {
                                try {
                                    if (cursor.isNull(arrayList)) {
                                    } else {
                                    }
                                    moveToFirst = string;
                                    moveToFirst = cursor.getString(arrayList);
                                    if (cursor.isNull(hVar)) {
                                    } else {
                                    }
                                    hVar = string;
                                    hVar = cursor.getString(hVar);
                                    if (cursor.isNull(valueOf)) {
                                    } else {
                                    }
                                    valueOf = string;
                                    valueOf = Long.valueOf(cursor.getLong(valueOf));
                                    if (cursor.isNull(userEntity)) {
                                    } else {
                                    }
                                    string = cursor.getString(userEntity);
                                    userEntity = new UserEntity(moveToFirst, hVar, valueOf, r0.y(this.b).j(string));
                                    string = userEntity;
                                } catch (Throwable th) {
                                }
                                try {
                                    arrayList = new ArrayList();
                                    hVar = new h(string, arrayList);
                                    string = hVar;
                                    if (string == null) {
                                    } else {
                                    }
                                    r0.z(this.b).C();
                                    cursor.close();
                                    r0.z(this.b).g();
                                    return string;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Query returned empty result set: ");
                                    stringBuilder.append(this.a.a());
                                    EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
                                    throw emptyResultSetException;
                                    th.close();
                                    throw th2;
                                    Throwable th2 = this.b;
                                    th2 = r0.z(th2);
                                    th2.g();
                                    throw th;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class i implements Callable<Boolean> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        i(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Boolean a() {
            boolean moveToFirst;
            int i2;
            int i;
            i2 = 0;
            i = 0;
            Cursor cursor = c.c(r0.z(this.b), this.a, i2, i);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i2)) {
                    moveToFirst = i;
                } else {
                    moveToFirst = Integer.valueOf(cursor.getInt(i2));
                }
                if (moveToFirst == null) {
                } else {
                    if (moveToFirst.intValue() != 0) {
                        i2 = 1;
                    }
                    i = moveToFirst;
                }
            }
            if (i == 0) {
            } else {
                cursor.close();
                return i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Query returned empty result set: ");
            stringBuilder.append(this.a.a());
            EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
            throw emptyResultSetException;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class k implements Callable<List<ReminderEntity>> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        k(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        public List<ReminderEntity> a() {
            int reminderEntity;
            boolean string5;
            boolean string7;
            int string4;
            boolean string;
            boolean string6;
            boolean string2;
            String string3;
            int int;
            int i6;
            int i2;
            int i4;
            List list;
            int i3;
            int i;
            int i5;
            String str;
            int i7;
            final Object obj = this;
            final int i9 = 0;
            final int i10 = 0;
            Cursor cursor = c.c(r0.z(obj.b), obj.a, i9, i10);
            int i8 = b.e(cursor, "id");
            int i11 = b.e(cursor, "ownerId");
            int i12 = b.e(cursor, "days");
            int i13 = b.e(cursor, "name");
            int i14 = b.e(cursor, "type");
            int i15 = b.e(cursor, "time");
            int i16 = b.e(cursor, "repeating");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i8)) {
                } else {
                }
                i2 = string5;
                if (cursor.isNull(i11)) {
                } else {
                }
                i4 = string7;
                if (cursor.isNull(i12)) {
                } else {
                }
                string4 = cursor.getString(i12);
                if (cursor.isNull(i13)) {
                } else {
                }
                i3 = string;
                if (cursor.isNull(i14)) {
                } else {
                }
                i = string6;
                if (cursor.isNull(i15)) {
                } else {
                }
                i5 = string2;
                if (cursor.isNull(i16)) {
                } else {
                }
                str = string3;
                if (cursor.getInt(b.e(cursor, "isActive")) != 0) {
                } else {
                }
                i7 = i9;
                super(i2, i4, r0.y(obj.b).g(string4), i3, i, i5, str, i7);
                arrayList.add(reminderEntity);
                i7 = int;
                str = i10;
                i5 = i10;
                i = i10;
                i3 = i10;
                string4 = i10;
                i4 = i10;
                i2 = i10;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class l implements Callable<PottyReminderEntity> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        l(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public PottyReminderEntity a() {
            int string6;
            String string4;
            String string;
            int string3;
            boolean string2;
            boolean string5;
            int i5;
            int pottyReminderEntity;
            int i;
            boolean moveToFirst;
            String str3;
            String str;
            String str2;
            List list;
            int i6;
            int i3;
            int i2;
            int i4;
            final Object obj = this;
            pottyReminderEntity = 0;
            Cursor cursor = c.c(r0.z(obj.b), obj.a, false, pottyReminderEntity);
            string6 = b.e(cursor, "reminderId");
            i = b.e(cursor, "dogId");
            int i7 = b.e(cursor, "ownerId");
            int i8 = b.e(cursor, "days");
            int i9 = b.e(cursor, "startTime");
            int i10 = b.e(cursor, "endTime");
            int i11 = b.e(cursor, "repeatIntervalMs");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string6)) {
                    str3 = pottyReminderEntity;
                } else {
                    str3 = string6;
                }
                if (cursor.isNull(i)) {
                    str = pottyReminderEntity;
                } else {
                    str = string4;
                }
                if (cursor.isNull(i7)) {
                    str2 = pottyReminderEntity;
                } else {
                    str2 = string;
                }
                if (cursor.isNull(i8)) {
                    string3 = pottyReminderEntity;
                } else {
                    string3 = cursor.getString(i8);
                }
                i = r0.y(obj.b);
                if (cursor.isNull(i9)) {
                    i6 = pottyReminderEntity;
                } else {
                    i6 = string2;
                }
                try {
                    if (cursor.isNull(i10)) {
                    } else {
                    }
                    i3 = pottyReminderEntity;
                    i3 = string5;
                    if (!cursor.isNull(i11)) {
                    }
                    pottyReminderEntity = Long.valueOf(cursor.getLong(i11));
                    if (cursor.getInt(b.e(cursor, "isActive")) != 0) {
                    }
                    i5 = 1;
                    super(str3, str, str2, i.g(string3), i6, i3, pottyReminderEntity, i5);
                    if (pottyReminderEntity == 0) {
                    } else {
                    }
                    cursor.close();
                    return pottyReminderEntity;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Query returned empty result set: ");
                    stringBuilder.append(obj.a.a());
                    EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
                    throw emptyResultSetException;
                    obj2.close();
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class m implements Callable<List<PottyReminderEntity>> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        m(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        public List<PottyReminderEntity> a() {
            int pottyReminderEntity;
            boolean string;
            boolean string6;
            boolean string4;
            int string3;
            boolean string5;
            boolean string2;
            Long valueOf;
            int int;
            int i6;
            int i7;
            int i4;
            int i3;
            List list;
            int i;
            int i2;
            Long num;
            int i5;
            final Object obj = this;
            final int i9 = 0;
            final int i10 = 0;
            Cursor cursor = c.c(r0.z(obj.b), obj.a, i9, i10);
            int i8 = b.e(cursor, "reminderId");
            int i11 = b.e(cursor, "dogId");
            int i12 = b.e(cursor, "ownerId");
            int i13 = b.e(cursor, "days");
            int i14 = b.e(cursor, "startTime");
            int i15 = b.e(cursor, "endTime");
            int i16 = b.e(cursor, "repeatIntervalMs");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i8)) {
                } else {
                }
                i7 = string;
                if (cursor.isNull(i11)) {
                } else {
                }
                i4 = string6;
                if (cursor.isNull(i12)) {
                } else {
                }
                i3 = string4;
                if (cursor.isNull(i13)) {
                } else {
                }
                string3 = cursor.getString(i13);
                a aVar = r0.y(obj.b);
                if (cursor.isNull(i14)) {
                } else {
                }
                i = string5;
                if (cursor.isNull(i15)) {
                } else {
                }
                i2 = string2;
                if (cursor.isNull(i16)) {
                } else {
                }
                num = valueOf;
                if (cursor.getInt(b.e(cursor, "isActive")) != 0) {
                } else {
                }
                i5 = i9;
                super(i7, i4, i3, aVar.g(string3), i, i2, num, i5);
                arrayList.add(pottyReminderEntity);
                i5 = int;
                num = i10;
                i2 = i10;
                i = i10;
                string3 = i10;
                i3 = i10;
                i4 = i10;
                i7 = i10;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class n implements Callable<List<PottyReminderEntity>> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        n(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        public List<PottyReminderEntity> a() {
            int pottyReminderEntity;
            boolean string;
            boolean string5;
            boolean string2;
            int string6;
            boolean string3;
            boolean string4;
            Long valueOf;
            int int;
            int i2;
            int i4;
            int i6;
            int i5;
            List list;
            int i;
            int i7;
            Long num;
            int i3;
            final Object obj = this;
            final int i9 = 0;
            final int i10 = 0;
            Cursor cursor = c.c(r0.z(obj.b), obj.a, i9, i10);
            int i8 = b.e(cursor, "reminderId");
            int i11 = b.e(cursor, "dogId");
            int i12 = b.e(cursor, "ownerId");
            int i13 = b.e(cursor, "days");
            int i14 = b.e(cursor, "startTime");
            int i15 = b.e(cursor, "endTime");
            int i16 = b.e(cursor, "repeatIntervalMs");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i8)) {
                } else {
                }
                i4 = string;
                if (cursor.isNull(i11)) {
                } else {
                }
                i6 = string5;
                if (cursor.isNull(i12)) {
                } else {
                }
                i5 = string2;
                if (cursor.isNull(i13)) {
                } else {
                }
                string6 = cursor.getString(i13);
                a aVar = r0.y(obj.b);
                if (cursor.isNull(i14)) {
                } else {
                }
                i = string3;
                if (cursor.isNull(i15)) {
                } else {
                }
                i7 = string4;
                if (cursor.isNull(i16)) {
                } else {
                }
                num = valueOf;
                if (cursor.getInt(b.e(cursor, "isActive")) != 0) {
                } else {
                }
                i3 = i9;
                super(i4, i6, i5, aVar.g(string6), i, i7, num, i3);
                arrayList.add(pottyReminderEntity);
                i3 = int;
                num = i10;
                i7 = i10;
                i = i10;
                string6 = i10;
                i5 = i10;
                i6 = i10;
                i4 = i10;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class o implements Callable<UserStateEntity> {

        final x0 a;
        final e.a.a.a.b.b.r0 b;
        o(e.a.a.a.b.b.r0 r0, x0 x02) {
            this.b = r0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public UserStateEntity a() {
            int string2;
            int i;
            int string;
            int userStateEntity;
            boolean moveToFirst;
            string = 0;
            Cursor cursor = c.c(r0.z(this.b), this.a, false, string);
            string2 = b.e(cursor, "userId");
            int i2 = b.e(cursor, "lastSeenGoalNotReachedState");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string2)) {
                    string2 = string;
                } else {
                    string2 = cursor.getString(string2);
                }
                if (cursor.getInt(b.e(cursor, "isWorkoutStreakSyncedToTrainingMetrics")) != 0) {
                    i = 1;
                }
                if (cursor.isNull(i2)) {
                } else {
                    string = cursor.getString(i2);
                }
                userStateEntity = new UserStateEntity(string2, i, r0.y(this.b).h(string));
                string = userStateEntity;
            }
            cursor.close();
            this.a.j();
            return string;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class u extends b1 {
        u(e.a.a.a.b.b.r0 r0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM ReminderEntity";
        }
    }

    class v extends b1 {
        v(e.a.a.a.b.b.r0 r0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM PolicyEntity";
        }
    }

    class w extends b1 {
        w(e.a.a.a.b.b.r0 r0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM UserEntity";
        }
    }

    class j extends h0<UserEntity> {

        final e.a.a.a.b.b.r0 d;
        j(e.a.a.a.b.b.r0 r0, u0 u02) {
            this.d = r0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `UserEntity` (`id`,`currentDogId`,`abBucket`,`participatingInChallenges`) VALUES (?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (UserEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, UserEntity userEntity2) {
            String str;
            String currentDogId;
            Long abBucket;
            long longValue;
            int i2 = 1;
            if (userEntity2.getId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, userEntity2.getId());
            }
            int i3 = 2;
            if (userEntity2.getCurrentDogId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, userEntity2.getCurrentDogId());
            }
            int i4 = 3;
            if (userEntity2.getAbBucket() == null) {
                k.k1(i4);
            } else {
                k.u0(i4, userEntity2.getAbBucket().longValue());
            }
            String obj6 = r0.y(this.d).d(userEntity2.getParticipatingInChallenges());
            int i = 4;
            if (obj6 == null) {
                k.k1(i);
            } else {
                k.D(i, obj6);
            }
        }
    }

    class p extends h0<ReminderEntity> {

        final e.a.a.a.b.b.r0 d;
        p(e.a.a.a.b.b.r0 r0, u0 u02) {
            this.d = r0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ReminderEntity` (`id`,`ownerId`,`days`,`name`,`type`,`time`,`repeating`,`isActive`) VALUES (?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (ReminderEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, ReminderEntity reminderEntity2) {
            String reminderId;
            String ownerId;
            String name;
            String type;
            String time;
            String repeating;
            int i2 = 1;
            if (reminderEntity2.getReminderId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, reminderEntity2.getReminderId());
            }
            int i3 = 2;
            if (reminderEntity2.getOwnerId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, reminderEntity2.getOwnerId());
            }
            String str = r0.y(this.d).a(reminderEntity2.getDays());
            int i4 = 3;
            if (str == null) {
                k.k1(i4);
            } else {
                k.D(i4, str);
            }
            int i5 = 4;
            if (reminderEntity2.getName() == null) {
                k.k1(i5);
            } else {
                k.D(i5, reminderEntity2.getName());
            }
            int i6 = 5;
            if (reminderEntity2.getType() == null) {
                k.k1(i6);
            } else {
                k.D(i6, reminderEntity2.getType());
            }
            int i7 = 6;
            if (reminderEntity2.getTime() == null) {
                k.k1(i7);
            } else {
                k.D(i7, reminderEntity2.getTime());
            }
            int i8 = 7;
            if (reminderEntity2.getRepeating() == null) {
                k.k1(i8);
            } else {
                k.D(i8, reminderEntity2.getRepeating());
            }
            k.u0(8, (long)obj5);
        }
    }

    class q extends h0<PottyReminderEntity> {

        final e.a.a.a.b.b.r0 d;
        q(e.a.a.a.b.b.r0 r0, u0 u02) {
            this.d = r0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `PottyReminderEntity` (`reminderId`,`dogId`,`ownerId`,`days`,`startTime`,`endTime`,`repeatIntervalMs`,`isActive`) VALUES (?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (PottyReminderEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, PottyReminderEntity pottyReminderEntity2) {
            String reminderId;
            String dogId;
            String ownerId;
            String startTime;
            String endTime;
            Long repeatIntervalMs;
            long longValue;
            int i2 = 1;
            if (pottyReminderEntity2.getReminderId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, pottyReminderEntity2.getReminderId());
            }
            int i3 = 2;
            if (pottyReminderEntity2.getDogId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, pottyReminderEntity2.getDogId());
            }
            int i4 = 3;
            if (pottyReminderEntity2.getOwnerId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, pottyReminderEntity2.getOwnerId());
            }
            String str = r0.y(this.d).a(pottyReminderEntity2.getDays());
            int i5 = 4;
            if (str == null) {
                k.k1(i5);
            } else {
                k.D(i5, str);
            }
            int i6 = 5;
            if (pottyReminderEntity2.getStartTime() == null) {
                k.k1(i6);
            } else {
                k.D(i6, pottyReminderEntity2.getStartTime());
            }
            int i7 = 6;
            if (pottyReminderEntity2.getEndTime() == null) {
                k.k1(i7);
            } else {
                k.D(i7, pottyReminderEntity2.getEndTime());
            }
            int i8 = 7;
            if (pottyReminderEntity2.getRepeatIntervalMs() == null) {
                k.k1(i8);
            } else {
                k.u0(i8, pottyReminderEntity2.getRepeatIntervalMs().longValue());
            }
            k.u0(8, (long)obj6);
        }
    }

    class r extends h0<PolicyEntity> {
        r(e.a.a.a.b.b.r0 r0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `PolicyEntity` (`id`,`status`,`ownerId`) VALUES (?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (PolicyEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, PolicyEntity policyEntity2) {
            String str;
            String status;
            String obj4;
            int i = 1;
            if (policyEntity2.getId() == null) {
                k.k1(i);
            } else {
                k.D(i, policyEntity2.getId());
            }
            int i2 = 2;
            if (policyEntity2.getStatus() == null) {
                k.k1(i2);
            } else {
                k.D(i2, policyEntity2.getStatus());
            }
            int i3 = 3;
            if (policyEntity2.getOwnerId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, policyEntity2.getOwnerId());
            }
        }
    }

    class s extends h0<UserStateEntity> {

        final e.a.a.a.b.b.r0 d;
        s(e.a.a.a.b.b.r0 r0, u0 u02) {
            this.d = r0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `UserStateEntity` (`userId`,`isWorkoutStreakSyncedToTrainingMetrics`,`lastSeenGoalNotReachedState`) VALUES (?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (UserStateEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, UserStateEntity userStateEntity2) {
            String userId;
            int i2 = 1;
            if (userStateEntity2.getUserId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, userStateEntity2.getUserId());
            }
            k.u0(2, (long)workoutStreakSyncedToTrainingMetrics);
            String obj6 = r0.y(this.d).b(userStateEntity2.getLastSeenGoalNotReachedState());
            int i = 3;
            if (obj6 == null) {
                k.k1(i);
            } else {
                k.D(i, obj6);
            }
        }
    }

    class t extends g0<UserCurrentDogIdUpdate> {
        t(e.a.a.a.b.b.r0 r0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `UserEntity` SET `id` = ?,`currentDogId` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (UserCurrentDogIdUpdate)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, UserCurrentDogIdUpdate userCurrentDogIdUpdate2) {
            String str;
            String currentDogId;
            String obj4;
            int i = 1;
            if (userCurrentDogIdUpdate2.getId() == null) {
                k.k1(i);
            } else {
                k.D(i, userCurrentDogIdUpdate2.getId());
            }
            int i2 = 2;
            if (userCurrentDogIdUpdate2.getCurrentDogId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, userCurrentDogIdUpdate2.getCurrentDogId());
            }
            int i3 = 3;
            if (userCurrentDogIdUpdate2.getId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, userCurrentDogIdUpdate2.getId());
            }
        }
    }
    public r0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        r0.j jVar = new r0.j(this, u0);
        this.b = jVar;
        r0.p pVar = new r0.p(this, u0);
        this.d = pVar;
        r0.q qVar = new r0.q(this, u0);
        this.e = qVar;
        r0.r rVar = new r0.r(this, u0);
        this.f = rVar;
        r0.s sVar = new r0.s(this, u0);
        this.g = sVar;
        r0.t tVar = new r0.t(this, u0);
        this.h = tVar;
        r0.u uVar = new r0.u(this, u0);
        r0.v vVar = new r0.v(this, u0);
        this.i = vVar;
        r0.w wVar = new r0.w(this, u0);
        this.j = wVar;
    }

    static void A(e.a.a.a.b.b.r0 r0, a a2) {
        r0.x(a2);
    }

    static h0 B(e.a.a.a.b.b.r0 r0) {
        return r0.b;
    }

    static h0 C(e.a.a.a.b.b.r0 r0) {
        return r0.d;
    }

    static h0 D(e.a.a.a.b.b.r0 r0) {
        return r0.e;
    }

    static h0 E(e.a.a.a.b.b.r0 r0) {
        return r0.f;
    }

    static h0 F(e.a.a.a.b.b.r0 r0) {
        return r0.g;
    }

    static b1 G(e.a.a.a.b.b.r0 r0) {
        return r0.i;
    }

    static b1 H(e.a.a.a.b.b.r0 r0) {
        return r0.j;
    }

    public static List<Class<?>> I() {
        return Collections.emptyList();
    }

    private void x(a<String, ArrayList<PolicyEntity>> a) {
        a aVar;
        int i3;
        int i2;
        int i;
        Object next;
        int i4;
        Object string3;
        Object string;
        String string2;
        PolicyEntity policyEntity;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i6 = 999;
        final int i9 = 0;
        if (a.size() > i6) {
            aVar = new a(i6);
            i = i3;
            while (i3 < a.size()) {
                aVar.put((String)a.j(i3), (ArrayList)a.n(i3));
                i3++;
                if (i++ == i6) {
                }
                x(aVar);
                aVar = new a(i6);
                i = i9;
            }
            if (i > 0) {
                x(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `id`,`status`,`ownerId` FROM `PolicyEntity` WHERE `ownerId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i9);
        Iterator iterator = keySet.iterator();
        int i8 = 1;
        i2 = i8;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i2, (String)next);
            i2++;
            x0Var.k1(i2);
        }
        int i10 = 0;
        Cursor cursor = c.c(this.a, x0Var, i9, i10);
        int i5 = b.d(cursor, "ownerId");
        if (i5 == -1) {
            cursor.close();
        }
        while (cursor.moveToNext()) {
            i4 = a.get(cursor.getString(i5));
            if ((ArrayList)i4 != 0) {
            }
            if (cursor.isNull(i9)) {
            } else {
            }
            string3 = cursor.getString(i9);
            if (cursor.isNull(i8)) {
            } else {
            }
            string = cursor.getString(i8);
            int i11 = 2;
            if (cursor.isNull(i11)) {
            } else {
            }
            string2 = cursor.getString(i11);
            policyEntity = new PolicyEntity(string3, string, string2);
            (ArrayList)i4.add(policyEntity);
            string2 = i10;
            string = i10;
            string3 = i10;
        }
        cursor.close();
    }

    static a y(e.a.a.a.b.b.r0 r0) {
        return r0.c;
    }

    static u0 z(e.a.a.a.b.b.r0 r0) {
        return r0.a;
    }

    public a0<PottyReminderEntity> a(String string) {
        return q0.a.f(this, string);
    }

    @Override // e.a.a.a.b.b.q0
    public b b(UserEntity userEntity) {
        r0.a aVar = new r0.a(this, userEntity);
        return b.o(aVar);
    }

    public Object c(String string, String string2, int i3, d<? super w> d4) {
        return q0.a.m(this, string, string2, i3, d4);
    }

    @Override // e.a.a.a.b.b.q0
    public b d() {
        r0.g gVar = new r0.g(this);
        return b.o(gVar);
    }

    public Object e(String string, boolean z2, d<? super w> d3) {
        return q0.a.n(this, string, z2, d3);
    }

    public Object f(UserStateEntity userStateEntity, d<? super w> d2) {
        r0.e eVar = new r0.e(this, userStateEntity);
        return c0.b(this.a, true, eVar, d2);
    }

    @Override // e.a.a.a.b.b.q0
    public b g(PolicyEntity... policyEntityArr) {
        r0.d dVar = new r0.d(this, policyEntityArr);
        return b.o(dVar);
    }

    public a0<h> h(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM UserEntity WHERE id= ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.h obj3 = new r0.h(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.q0
    public b i(ReminderEntity... reminderEntityArr) {
        r0.b bVar = new r0.b(this, reminderEntityArr);
        return b.o(bVar);
    }

    public a0<List<PottyReminderEntity>> j(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE dogId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.m obj3 = new r0.m(this, x0Var);
        return y0.a(obj3);
    }

    public a0<List<ReminderEntity>> k(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ReminderEntity WHERE ownerId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.k obj3 = new r0.k(this, x0Var);
        return y0.a(obj3);
    }

    public a0<List<ReminderEntity>> l(String string) {
        return q0.a.g(this, string);
    }

    public Object m(String string, d<? super UserStateEntity> d2) {
        return q0.a.i(this, string, d2);
    }

    public Object n(String string, d<? super UserStateEntity> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM UserStateEntity WHERE userId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.o oVar = new r0.o(this, x0Var);
        return c0.a(this.a, false, c.a(), oVar, d2);
    }

    @Override // e.a.a.a.b.b.q0
    public void o(UserCurrentDogIdUpdate userCurrentDogIdUpdate) {
        this.a.b();
        this.a.c();
        this.h.h(userCurrentDogIdUpdate);
        this.a.C();
        this.a.g();
    }

    public a0<List<Long>> p(PottyReminderEntity... pottyReminderEntityArr) {
        r0.c cVar = new r0.c(this, pottyReminderEntityArr);
        return a0.fromCallable(cVar);
    }

    public a0<PottyReminderEntity> q(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE reminderId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.l obj3 = new r0.l(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.q0
    public b r() {
        return q0.a.a(this);
    }

    @Override // e.a.a.a.b.b.q0
    public b s(h h) {
        return q0.a.b(this, h);
    }

    public a0<List<PottyReminderEntity>> t(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM PottyReminderEntity WHERE ownerId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.n obj3 = new r0.n(this, x0Var);
        return y0.a(obj3);
    }

    public a0<String> u(String string) {
        return q0.a.c(this, string);
    }

    @Override // e.a.a.a.b.b.q0
    public b v() {
        r0.f fVar = new r0.f(this);
        return b.o(fVar);
    }

    public a0<Boolean> w(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM UserEntity WHERE id = ?)", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r0.i obj3 = new r0.i(this, x0Var);
        return y0.a(obj3);
    }
}
