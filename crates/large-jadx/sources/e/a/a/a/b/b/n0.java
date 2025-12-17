package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.f1.f;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.TrickCategoryEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import d.e.a;
import d.e.g;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import e.a.a.a.b.c.j;
import e.a.a.a.b.c.k;
import e.a.a.a.b.c.l;
import e.a.a.a.b.c.m;
import e.a.a.a.b.d.g;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
public final class n0 implements e.a.a.a.b.b.m0 {

    private final u0 a;
    private final h0<TrickEntity> b;
    private final a c;
    private final h0<TrickStepEntity> d;
    private final h0<VideoStepEntity> e;
    private final h0<TrickTagEntity> f;
    private final h0<TrickVariationEntity> g;
    private final h0<TrickCategoryEntity> h;
    private final h0<k> i;
    private final h0<m> j;
    private final h0<j> k;
    private final h0<l> l;
    private final g0<k> m;
    private final g0<m> n;
    private final g0<j> o;
    private final g0<l> p;

    class b0 implements Callable<w> {

        final l[] a;
        final e.a.a.a.b.b.n0 b;
        b0(e.a.a.a.b.b.n0 n0, l[] l2Arr2) {
            this.b = n0;
            this.a = l2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.L(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c0 implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        c0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, i, 0);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                } else {
                    valueOf = Long.valueOf(cursor.getLong(i));
                }
            }
            cursor.close();
            this.a.j();
            return valueOf;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e0 implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        e0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, i, 0);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                } else {
                    valueOf = Long.valueOf(cursor.getLong(i));
                }
            }
            cursor.close();
            this.a.j();
            return valueOf;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f0 implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        f0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, i, 0);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                } else {
                    valueOf = Long.valueOf(cursor.getLong(i));
                }
            }
            cursor.close();
            this.a.j();
            return valueOf;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g0 implements Callable<TrickCategoryEntity> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        g0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public TrickCategoryEntity a() {
            int string;
            String string3;
            String string2;
            int trickCategoryEntity;
            boolean moveToFirst;
            String str;
            String str2;
            String str3;
            long long;
            int i;
            trickCategoryEntity = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, false, trickCategoryEntity);
            string = b.e(cursor, "categoryId");
            int i3 = b.e(cursor, "locale");
            int i4 = b.e(cursor, "name");
            int i6 = b.e(cursor, "locale_categoryId");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    str = trickCategoryEntity;
                } else {
                    str = string;
                }
                if (cursor.isNull(i3)) {
                    str2 = trickCategoryEntity;
                } else {
                    str2 = string3;
                }
                if (cursor.isNull(i4)) {
                    str3 = trickCategoryEntity;
                } else {
                    str3 = string2;
                }
                if (!cursor.isNull(i6)) {
                    trickCategoryEntity = cursor.getString(i6);
                }
                super(str, str2, str3, cursor.getLong(b.e(cursor, "updatedAt")), obj12, trickCategoryEntity);
            }
            try {
                cursor.close();
                this.a.j();
                return trickCategoryEntity;
                x0Var.close();
                x0 x0Var = this.a;
                x0Var.j();
                throw th;
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class i0 implements Callable<List<g>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        i0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<g> a() {
            int i18;
            int i31;
            Object obj5;
            int trickEntity3;
            int i5;
            int str6;
            int string9;
            Object arrayList9;
            Object arrayList2;
            Object arrayList3;
            Object arrayList7;
            Object obj6;
            a aVar8;
            int i16;
            Object obj3;
            int i25;
            int i12;
            int i10;
            int arrayList;
            ArrayList arrayList5;
            int i33;
            int i27;
            int count;
            boolean null3;
            Object arrayList4;
            Object arrayList8;
            Object arrayList6;
            a aVar4;
            int i29;
            a aVar;
            int i13;
            a aVar3;
            int i9;
            int i15;
            int i19;
            int null2;
            int i21;
            int i30;
            int null;
            String string6;
            String string2;
            String string3;
            String string11;
            String string10;
            String string5;
            Integer valueOf2;
            Integer valueOf;
            String string;
            boolean string7;
            String string8;
            boolean string4;
            int i4;
            int i26;
            int i;
            int i6;
            int i2;
            int i28;
            a aVar5;
            int i22;
            a aVar6;
            int i32;
            a aVar2;
            int i35;
            int i3;
            a aVar7;
            int i7;
            int i17;
            ArrayList list3;
            TrickEntity trickEntity2;
            String str5;
            String str4;
            String str8;
            String str7;
            String str9;
            String str;
            Integer num2;
            Integer num;
            int i20;
            int i11;
            long long;
            String str10;
            int i34;
            String str2;
            int i24;
            String str3;
            List list;
            List list2;
            int i8;
            g gVar;
            TrickEntity trickEntity;
            Object obj2;
            Object obj7;
            Object obj;
            Object obj4;
            int i23;
            int i14;
            obj5 = this;
            n0.E(obj5.b).c();
            Cursor cursor = c.c(n0.E(obj5.b), obj5.a, true, 0);
            i18 = b.e(cursor, "trickId");
            i10 = b.e(cursor, "name");
            int i44 = b.e(cursor, "image");
            int i45 = b.e(cursor, "categoryName");
            int i46 = b.e(cursor, "categoryId");
            int i47 = b.e(cursor, "examInstructions");
            int i48 = b.e(cursor, "examTimeLimit");
            arrayList = b.e(cursor, "sortOrder");
            i27 = b.e(cursor, "isExam");
            i15 = i42;
            null2 = i43;
            i25 = b.e(cursor, "locale_trickId");
            null = i38;
            i26 = i39;
            i6 = i40;
            aVar8 = new a();
            i28 = i52;
            aVar3 = new a();
            i22 = i51;
            aVar = new a();
            i32 = i50;
            aVar4 = new a();
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(i25);
                if ((ArrayList)aVar8.get(string19) == null) {
                } else {
                }
                i7 = arrayList;
                String string16 = cursor.getString(i25);
                if ((ArrayList)aVar3.get(string16) == null) {
                }
                String string17 = cursor.getString(i25);
                if ((ArrayList)aVar.get(string17) == null) {
                }
                String string18 = cursor.getString(i25);
                if ((ArrayList)aVar4.get(string18) == null) {
                }
                i27 = i35;
                arrayList = i7;
                arrayList6 = new ArrayList();
                aVar4.put(string18, arrayList6);
                arrayList8 = new ArrayList();
                aVar.put(string17, arrayList8);
                arrayList4 = new ArrayList();
                aVar3.put(string16, arrayList4);
                i7 = arrayList;
                arrayList = new ArrayList();
                aVar8.put(string19, arrayList);
            }
            i17 = arrayList;
            i3 = i27;
            cursor.moveToPosition(-1);
            n0.M(obj5.b, aVar8);
            n0.N(obj5.b, aVar3);
            n0.O(obj5.b, aVar);
            n0.P(obj5.b, aVar4);
            arrayList5 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i18) && cursor.isNull(i10) && cursor.isNull(i44) && cursor.isNull(i45) && cursor.isNull(i46) && cursor.isNull(i47) && cursor.isNull(i48)) {
                } else {
                }
                trickEntity3 = null2;
                count = i17;
                i21 = i25;
                list3 = arrayList5;
                i12 = i6;
                i33 = i3;
                aVar7 = aVar4;
                i29 = i32;
                aVar2 = aVar;
                i13 = i22;
                aVar6 = aVar3;
                i9 = i28;
                aVar5 = aVar8;
                i16 = null;
                if (cursor.isNull(i18)) {
                } else {
                }
                str5 = string6;
                if (cursor.isNull(i10)) {
                } else {
                }
                str4 = string2;
                if (cursor.isNull(i44)) {
                } else {
                }
                str8 = string3;
                if (cursor.isNull(i45)) {
                } else {
                }
                str7 = string11;
                if (cursor.isNull(i46)) {
                } else {
                }
                str9 = string10;
                if (cursor.isNull(i47)) {
                } else {
                }
                str = string5;
                if (cursor.isNull(i48)) {
                } else {
                }
                num2 = valueOf2;
                if (cursor.isNull(count)) {
                } else {
                }
                num = valueOf;
                int i53 = 0;
                if (cursor.getInt(i33) != 0) {
                } else {
                }
                i20 = i53;
                if (cursor.getInt(i29) != 0) {
                } else {
                }
                i11 = i53;
                if (cursor.isNull(i9)) {
                } else {
                }
                str10 = string;
                if (cursor.isNull(i16)) {
                } else {
                }
                i34 = string7;
                i19 = i18;
                int i36 = i56;
                if (cursor.isNull(i36)) {
                } else {
                }
                str2 = string8;
                if (cursor.isNull(trickEntity3)) {
                } else {
                }
                i24 = string4;
                i30 = i36;
                i31 = i14;
                if (cursor.isNull(i31)) {
                } else {
                }
                str3 = string20;
                i4 = trickEntity3;
                i5 = i26;
                if (cursor.isNull(i5)) {
                } else {
                }
                i2 = i5;
                i8 = i10;
                str6 = string21;
                i = i16;
                obj3 = this;
                if (cursor.isNull(i12)) {
                } else {
                }
                string9 = cursor.getString(i12);
                super(str5, str4, str8, str7, str9, str, num2, num, i20, i11, cursor.getLong(i13), obj38, str10, i34, str2, i24, str3, n0.D(obj3.b).j(str6), n0.D(obj3.b).j(string9));
                trickEntity = trickEntity3;
                a aVar13 = aVar5;
                if ((ArrayList)aVar13.get(cursor.getString(i31)) == null) {
                }
                a aVar10 = aVar6;
                if ((ArrayList)aVar10.get(cursor.getString(i31)) == null) {
                }
                a aVar11 = aVar2;
                if ((ArrayList)aVar11.get(cursor.getString(i31)) == null) {
                }
                a aVar9 = aVar7;
                if ((ArrayList)aVar9.get(cursor.getString(i31)) == null) {
                }
                super(trickEntity, arrayList9, arrayList2, arrayList3, arrayList7);
                ArrayList list5 = list3;
                list5.add(gVar2);
                obj5 = obj3;
                aVar8 = aVar13;
                i17 = count;
                i10 = i8;
                arrayList5 = list5;
                i18 = i19;
                i15 = i30;
                null2 = i4;
                null = i;
                i26 = i2;
                i6 = i54;
                i28 = i9;
                aVar3 = aVar14;
                i22 = i13;
                aVar = aVar11;
                i25 = i55;
                i32 = i29;
                aVar4 = aVar15;
                i3 = i23;
                arrayList7 = new ArrayList();
                arrayList3 = new ArrayList();
                arrayList2 = new ArrayList();
                arrayList9 = new ArrayList();
                string9 = 0;
                i2 = i5;
                i = i16;
                i8 = i10;
                str6 = 0;
                i4 = trickEntity3;
                i5 = i26;
                str3 = 0;
                i24 = 0;
                str2 = 0;
                i34 = 0;
                str10 = 0;
                i11 = 1;
                i20 = 1;
                num = 0;
                num2 = 0;
                str = 0;
                str9 = 0;
                str7 = 0;
                str8 = 0;
                str4 = 0;
                str5 = 0;
                if (cursor.isNull(i10)) {
                } else {
                }
                if (cursor.isNull(i44)) {
                } else {
                }
                if (cursor.isNull(i45)) {
                } else {
                }
                if (cursor.isNull(i46)) {
                } else {
                }
                if (cursor.isNull(i47)) {
                } else {
                }
                if (cursor.isNull(i48)) {
                } else {
                }
                if (cursor.isNull(i17)) {
                } else {
                }
                list3 = arrayList5;
                trickEntity3 = null2;
                i33 = i3;
                i21 = i25;
                aVar7 = aVar4;
                i12 = i6;
                list3 = arrayList5;
                if (cursor.isNull(i3)) {
                } else {
                }
                aVar7 = aVar4;
                trickEntity3 = null2;
                i29 = i32;
                i21 = i25;
                aVar2 = aVar;
                i12 = i6;
                aVar7 = aVar4;
                if (cursor.isNull(i32)) {
                } else {
                }
                aVar2 = aVar;
                trickEntity3 = null2;
                i13 = i22;
                i21 = i25;
                aVar6 = aVar3;
                i12 = i6;
                aVar2 = aVar;
                if (cursor.isNull(i22)) {
                } else {
                }
                aVar6 = aVar3;
                trickEntity3 = null2;
                i9 = i28;
                aVar5 = aVar8;
                i21 = i25;
                i16 = null;
                i12 = i6;
                aVar6 = aVar3;
                if (cursor.isNull(i28)) {
                } else {
                }
                aVar5 = aVar8;
                trickEntity3 = null2;
                i16 = null;
                i21 = i25;
                aVar5 = aVar8;
                i16 = null;
                if (cursor.isNull(i16)) {
                } else {
                }
                trickEntity3 = null2;
                obj5 = i15;
                if (cursor.isNull(obj5)) {
                } else {
                }
                i15 = obj5;
                trickEntity3 = null2;
                if (cursor.isNull(trickEntity3) && cursor.isNull(i25)) {
                } else {
                }
                if (cursor.isNull(i25)) {
                } else {
                }
                i25 = i26;
                if (cursor.isNull(i25)) {
                } else {
                }
                i26 = i25;
                if (!cursor.isNull(i6)) {
                } else {
                }
                i4 = trickEntity3;
                i8 = i10;
                i2 = i26;
                trickEntity = 0;
                i = i16;
                obj3 = this;
                i19 = i18;
                i31 = i21;
                i30 = i14;
            }
            Object obj8 = obj5;
            n0.E(obj8.b).C();
            cursor.close();
            n0.E(obj8.b).g();
            return arrayList5;
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

    class j0 implements Callable<List<g>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        j0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<g> a() {
            int i4;
            int i19;
            Object obj3;
            int trickEntity;
            int i7;
            int str4;
            int string4;
            Object arrayList;
            Object arrayList8;
            Object arrayList4;
            Object arrayList7;
            Object obj2;
            a aVar7;
            int i20;
            Object obj;
            int i13;
            int i2;
            int i33;
            int arrayList3;
            ArrayList arrayList5;
            int i23;
            int i18;
            int count;
            boolean null;
            Object arrayList9;
            Object arrayList6;
            Object arrayList2;
            a aVar2;
            int i31;
            a aVar3;
            int i12;
            a aVar5;
            int i3;
            int i8;
            int i30;
            int null2;
            int i9;
            int i25;
            int null3;
            String string11;
            String string9;
            String string10;
            String string5;
            String string2;
            String string;
            Integer valueOf;
            Integer valueOf2;
            String string6;
            boolean string8;
            String string3;
            boolean string7;
            int i11;
            int i14;
            int i17;
            int i29;
            int i21;
            int i15;
            a aVar6;
            int i10;
            a aVar4;
            int i6;
            a aVar8;
            int i16;
            int i22;
            a aVar;
            int i24;
            int i32;
            ArrayList list;
            TrickEntity trickEntity3;
            String str;
            String str5;
            String str10;
            String str9;
            String str7;
            String str2;
            Integer num;
            Integer num2;
            int i35;
            int i;
            long long;
            String str3;
            int i26;
            String str6;
            int i34;
            String str8;
            List list3;
            List list2;
            int i28;
            g gVar;
            TrickEntity trickEntity2;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            int i27;
            int i5;
            obj3 = this;
            n0.E(obj3.b).c();
            Cursor cursor = c.c(n0.E(obj3.b), obj3.a, true, 0);
            i4 = b.e(cursor, "trickId");
            i33 = b.e(cursor, "name");
            int i44 = b.e(cursor, "image");
            int i45 = b.e(cursor, "categoryName");
            int i46 = b.e(cursor, "categoryId");
            int i47 = b.e(cursor, "examInstructions");
            int i48 = b.e(cursor, "examTimeLimit");
            arrayList3 = b.e(cursor, "sortOrder");
            i18 = b.e(cursor, "isExam");
            i8 = i42;
            null2 = i43;
            i13 = b.e(cursor, "locale_trickId");
            null3 = i38;
            i14 = i39;
            i29 = i40;
            aVar7 = new a();
            i15 = i52;
            aVar5 = new a();
            i10 = i51;
            aVar3 = new a();
            i6 = i50;
            aVar2 = new a();
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(i13);
                if ((ArrayList)aVar7.get(string19) == null) {
                } else {
                }
                i24 = arrayList3;
                String string16 = cursor.getString(i13);
                if ((ArrayList)aVar5.get(string16) == null) {
                }
                String string17 = cursor.getString(i13);
                if ((ArrayList)aVar3.get(string17) == null) {
                }
                String string18 = cursor.getString(i13);
                if ((ArrayList)aVar2.get(string18) == null) {
                }
                i18 = i16;
                arrayList3 = i24;
                arrayList2 = new ArrayList();
                aVar2.put(string18, arrayList2);
                arrayList6 = new ArrayList();
                aVar3.put(string17, arrayList6);
                arrayList9 = new ArrayList();
                aVar5.put(string16, arrayList9);
                i24 = arrayList3;
                arrayList3 = new ArrayList();
                aVar7.put(string19, arrayList3);
            }
            i32 = arrayList3;
            i22 = i18;
            cursor.moveToPosition(-1);
            n0.M(obj3.b, aVar7);
            n0.N(obj3.b, aVar5);
            n0.O(obj3.b, aVar3);
            n0.P(obj3.b, aVar2);
            arrayList5 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i4) && cursor.isNull(i33) && cursor.isNull(i44) && cursor.isNull(i45) && cursor.isNull(i46) && cursor.isNull(i47) && cursor.isNull(i48)) {
                } else {
                }
                trickEntity = null2;
                count = i32;
                i9 = i13;
                list = arrayList5;
                i2 = i29;
                i23 = i22;
                aVar = aVar2;
                i31 = i6;
                aVar8 = aVar3;
                i12 = i10;
                aVar4 = aVar5;
                i3 = i15;
                aVar6 = aVar7;
                i20 = null3;
                if (cursor.isNull(i4)) {
                } else {
                }
                str = string11;
                if (cursor.isNull(i33)) {
                } else {
                }
                str5 = string9;
                if (cursor.isNull(i44)) {
                } else {
                }
                str10 = string10;
                if (cursor.isNull(i45)) {
                } else {
                }
                str9 = string5;
                if (cursor.isNull(i46)) {
                } else {
                }
                str7 = string2;
                if (cursor.isNull(i47)) {
                } else {
                }
                str2 = string;
                if (cursor.isNull(i48)) {
                } else {
                }
                num = valueOf;
                if (cursor.isNull(count)) {
                } else {
                }
                num2 = valueOf2;
                int i53 = 0;
                if (cursor.getInt(i23) != 0) {
                } else {
                }
                i35 = i53;
                if (cursor.getInt(i31) != 0) {
                } else {
                }
                i = i53;
                if (cursor.isNull(i3)) {
                } else {
                }
                str3 = string6;
                if (cursor.isNull(i20)) {
                } else {
                }
                i26 = string8;
                i30 = i4;
                int i36 = i56;
                if (cursor.isNull(i36)) {
                } else {
                }
                str6 = string3;
                if (cursor.isNull(trickEntity)) {
                } else {
                }
                i34 = string7;
                i25 = i36;
                i19 = i5;
                if (cursor.isNull(i19)) {
                } else {
                }
                str8 = string20;
                i11 = trickEntity;
                i7 = i14;
                if (cursor.isNull(i7)) {
                } else {
                }
                i21 = i7;
                i28 = i33;
                str4 = string21;
                i17 = i20;
                obj = this;
                if (cursor.isNull(i2)) {
                } else {
                }
                string4 = cursor.getString(i2);
                super(str, str5, str10, str9, str7, str2, num, num2, i35, i, cursor.getLong(i12), obj38, str3, i26, str6, i34, str8, n0.D(obj.b).j(str4), n0.D(obj.b).j(string4));
                trickEntity2 = trickEntity;
                a aVar13 = aVar6;
                if ((ArrayList)aVar13.get(cursor.getString(i19)) == null) {
                }
                a aVar10 = aVar4;
                if ((ArrayList)aVar10.get(cursor.getString(i19)) == null) {
                }
                a aVar11 = aVar8;
                if ((ArrayList)aVar11.get(cursor.getString(i19)) == null) {
                }
                a aVar9 = aVar;
                if ((ArrayList)aVar9.get(cursor.getString(i19)) == null) {
                }
                super(trickEntity2, arrayList, arrayList8, arrayList4, arrayList7);
                ArrayList list5 = list;
                list5.add(gVar2);
                obj3 = obj;
                aVar7 = aVar13;
                i32 = count;
                i33 = i28;
                arrayList5 = list5;
                i4 = i30;
                i8 = i25;
                null2 = i11;
                null3 = i17;
                i14 = i21;
                i29 = i54;
                i15 = i3;
                aVar5 = aVar14;
                i10 = i12;
                aVar3 = aVar11;
                i13 = i55;
                i6 = i31;
                aVar2 = aVar15;
                i22 = i27;
                arrayList7 = new ArrayList();
                arrayList4 = new ArrayList();
                arrayList8 = new ArrayList();
                arrayList = new ArrayList();
                string4 = 0;
                i21 = i7;
                i17 = i20;
                i28 = i33;
                str4 = 0;
                i11 = trickEntity;
                i7 = i14;
                str8 = 0;
                i34 = 0;
                str6 = 0;
                i26 = 0;
                str3 = 0;
                i = 1;
                i35 = 1;
                num2 = 0;
                num = 0;
                str2 = 0;
                str7 = 0;
                str9 = 0;
                str10 = 0;
                str5 = 0;
                str = 0;
                if (cursor.isNull(i33)) {
                } else {
                }
                if (cursor.isNull(i44)) {
                } else {
                }
                if (cursor.isNull(i45)) {
                } else {
                }
                if (cursor.isNull(i46)) {
                } else {
                }
                if (cursor.isNull(i47)) {
                } else {
                }
                if (cursor.isNull(i48)) {
                } else {
                }
                if (cursor.isNull(i32)) {
                } else {
                }
                list = arrayList5;
                trickEntity = null2;
                i23 = i22;
                i9 = i13;
                aVar = aVar2;
                i2 = i29;
                list = arrayList5;
                if (cursor.isNull(i22)) {
                } else {
                }
                aVar = aVar2;
                trickEntity = null2;
                i31 = i6;
                i9 = i13;
                aVar8 = aVar3;
                i2 = i29;
                aVar = aVar2;
                if (cursor.isNull(i6)) {
                } else {
                }
                aVar8 = aVar3;
                trickEntity = null2;
                i12 = i10;
                i9 = i13;
                aVar4 = aVar5;
                i2 = i29;
                aVar8 = aVar3;
                if (cursor.isNull(i10)) {
                } else {
                }
                aVar4 = aVar5;
                trickEntity = null2;
                i3 = i15;
                aVar6 = aVar7;
                i9 = i13;
                i20 = null3;
                i2 = i29;
                aVar4 = aVar5;
                if (cursor.isNull(i15)) {
                } else {
                }
                aVar6 = aVar7;
                trickEntity = null2;
                i20 = null3;
                i9 = i13;
                aVar6 = aVar7;
                i20 = null3;
                if (cursor.isNull(i20)) {
                } else {
                }
                trickEntity = null2;
                obj3 = i8;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i8 = obj3;
                trickEntity = null2;
                if (cursor.isNull(trickEntity) && cursor.isNull(i13)) {
                } else {
                }
                if (cursor.isNull(i13)) {
                } else {
                }
                i13 = i14;
                if (cursor.isNull(i13)) {
                } else {
                }
                i14 = i13;
                if (!cursor.isNull(i29)) {
                } else {
                }
                i11 = trickEntity;
                i28 = i33;
                i21 = i14;
                trickEntity2 = 0;
                i17 = i20;
                obj = this;
                i30 = i4;
                i19 = i9;
                i25 = i5;
            }
            Object obj8 = obj3;
            n0.E(obj8.b).C();
            cursor.close();
            obj8.a.j();
            n0.E(obj8.b).g();
            return arrayList5;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class k0 implements Callable<List<k>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        k0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<k> a() {
            int string;
            String string2;
            k kVar;
            final int i4 = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_tagId");
            int i3 = b.e(cursor, "locale_trickId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string2 = cursor.getString(i3);
                kVar = new k(string, string2);
                arrayList.add(kVar);
                string2 = i4;
                string = i4;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class l0 implements Callable<List<m>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        l0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<m> a() {
            int string;
            String string2;
            m mVar;
            final int i4 = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_stepId");
            int i3 = b.e(cursor, "locale_trickId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string2 = cursor.getString(i3);
                mVar = new m(string, string2);
                arrayList.add(mVar);
                string2 = i4;
                string = i4;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class m0 implements Callable<List<j>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        m0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<j> a() {
            int string;
            String string2;
            j jVar;
            final int i4 = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_stepId");
            int i3 = b.e(cursor, "locale_trickId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string2 = cursor.getString(i3);
                jVar = new j(string, string2);
                arrayList.add(jVar);
                string2 = i4;
                string = i4;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class m implements Callable<w> {

        final TrickEntity[] a;
        final e.a.a.a.b.b.n0 b;
        m(e.a.a.a.b.b.n0 n0, TrickEntity[] trickEntity2Arr2) {
            this.b = n0;
            this.a = trickEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.J(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class n0 implements Callable<List<l>> {

        final x0 a;
        final e.a.a.a.b.b.n0 b;
        n0(e.a.a.a.b.b.n0 n0, x0 x02) {
            this.b = n0;
            this.a = x02;
            super();
        }

        public List<l> a() {
            int string2;
            String string;
            l lVar;
            final int i4 = 0;
            Cursor cursor = c.c(n0.E(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_variationId");
            int i3 = b.e(cursor, "locale_trickId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string2 = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string = cursor.getString(i3);
                lVar = new l(string2, string);
                arrayList.add(lVar);
                string = i4;
                string2 = i4;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class n implements Callable<w> {

        final TrickStepEntity[] a;
        final e.a.a.a.b.b.n0 b;
        n(e.a.a.a.b.b.n0 n0, TrickStepEntity[] trickStepEntity2Arr2) {
            this.b = n0;
            this.a = trickStepEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.Q(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class o implements Callable<w> {

        final VideoStepEntity[] a;
        final e.a.a.a.b.b.n0 b;
        o(e.a.a.a.b.b.n0 n0, VideoStepEntity[] videoStepEntity2Arr2) {
            this.b = n0;
            this.a = videoStepEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.R(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class p implements Callable<w> {

        final TrickTagEntity[] a;
        final e.a.a.a.b.b.n0 b;
        p(e.a.a.a.b.b.n0 n0, TrickTagEntity[] trickTagEntity2Arr2) {
            this.b = n0;
            this.a = trickTagEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.S(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class q implements Callable<w> {

        final TrickVariationEntity[] a;
        final e.a.a.a.b.b.n0 b;
        q(e.a.a.a.b.b.n0 n0, TrickVariationEntity[] trickVariationEntity2Arr2) {
            this.b = n0;
            this.a = trickVariationEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.T(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class r implements Callable<w> {

        final TrickCategoryEntity[] a;
        final e.a.a.a.b.b.n0 b;
        r(e.a.a.a.b.b.n0 n0, TrickCategoryEntity[] trickCategoryEntity2Arr2) {
            this.b = n0;
            this.a = trickCategoryEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.U(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class s implements Callable<w> {

        final k[] a;
        final e.a.a.a.b.b.n0 b;
        s(e.a.a.a.b.b.n0 n0, k[] k2Arr2) {
            this.b = n0;
            this.a = k2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.V(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class t implements Callable<w> {

        final m[] a;
        final e.a.a.a.b.b.n0 b;
        t(e.a.a.a.b.b.n0 n0, m[] m2Arr2) {
            this.b = n0;
            this.a = m2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.W(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class u implements Callable<w> {

        final j[] a;
        final e.a.a.a.b.b.n0 b;
        u(e.a.a.a.b.b.n0 n0, j[] j2Arr2) {
            this.b = n0;
            this.a = j2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.F(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class w implements Callable<w> {

        final l[] a;
        final e.a.a.a.b.b.n0 b;
        w(e.a.a.a.b.b.n0 n0, l[] l2Arr2) {
            this.b = n0;
            this.a = l2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.G(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class x implements Callable<w> {

        final k[] a;
        final e.a.a.a.b.b.n0 b;
        x(e.a.a.a.b.b.n0 n0, k[] k2Arr2) {
            this.b = n0;
            this.a = k2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.H(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class y implements Callable<w> {

        final m[] a;
        final e.a.a.a.b.b.n0 b;
        y(e.a.a.a.b.b.n0 n0, m[] m2Arr2) {
            this.b = n0;
            this.a = m2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.I(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class z implements Callable<w> {

        final j[] a;
        final e.a.a.a.b.b.n0 b;
        z(e.a.a.a.b.b.n0 n0, j[] j2Arr2) {
            this.b = n0;
            this.a = j2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            n0.E(this.b).c();
            n0.K(this.b).i(this.a);
            n0.E(this.b).C();
            n0.E(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a0 extends h0<VideoStepEntity> {
        a0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `VideoStepEntity` (`stepId`,`text`,`locale`,`startTime`,`updatedAt`,`locale_stepId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (VideoStepEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, VideoStepEntity videoStepEntity2) {
            String stepId;
            String text;
            String locale;
            String obj5;
            int i3 = 1;
            if (videoStepEntity2.getStepId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, videoStepEntity2.getStepId());
            }
            int i4 = 2;
            if (videoStepEntity2.getText() == null) {
                k.k1(i4);
            } else {
                k.D(i4, videoStepEntity2.getText());
            }
            int i5 = 3;
            if (videoStepEntity2.getLocale() == null) {
                k.k1(i5);
            } else {
                k.D(i5, videoStepEntity2.getLocale());
            }
            k.u0(4, (long)startTime);
            k.u0(5, videoStepEntity2.getUpdatedAt());
            int i6 = 6;
            if (videoStepEntity2.getLocale_stepId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, videoStepEntity2.getLocale_stepId());
            }
        }
    }

    class a extends h0<l> {
        a(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithVariations` (`locale_variationId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (l)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, l l2) {
            String str;
            String obj4;
            int i = 1;
            if (l2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, l2.b());
            }
            int i2 = 2;
            if (l2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, l2.a());
            }
        }
    }

    class b extends g0<TrickEntity> {
        b(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickEntity` WHERE `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickEntity trickEntity2) {
            String obj4;
            final int i = 1;
            if (trickEntity2.getLocale_trickId() == null) {
                k.k1(i);
            } else {
                k.D(i, trickEntity2.getLocale_trickId());
            }
        }
    }

    class c extends g0<TrickStepEntity> {
        c(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickStepEntity` WHERE `locale_stepId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickStepEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickStepEntity trickStepEntity2) {
            String obj4;
            final int i = 1;
            if (trickStepEntity2.getLocale_stepId() == null) {
                k.k1(i);
            } else {
                k.D(i, trickStepEntity2.getLocale_stepId());
            }
        }
    }

    class d0 extends h0<TrickTagEntity> {
        d0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickTagEntity` (`tagId`,`locale`,`name`,`updatedAt`,`locale_tagId`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickTagEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickTagEntity trickTagEntity2) {
            String tagId;
            String locale;
            String name;
            String obj5;
            int i2 = 1;
            if (trickTagEntity2.getTagId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, trickTagEntity2.getTagId());
            }
            int i3 = 2;
            if (trickTagEntity2.getLocale() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickTagEntity2.getLocale());
            }
            int i4 = 3;
            if (trickTagEntity2.getName() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickTagEntity2.getName());
            }
            k.u0(4, trickTagEntity2.getUpdatedAt());
            int i5 = 5;
            if (trickTagEntity2.getLocale_tagId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickTagEntity2.getLocale_tagId());
            }
        }
    }

    class d extends g0<VideoStepEntity> {
        d(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `VideoStepEntity` WHERE `locale_stepId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (VideoStepEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, VideoStepEntity videoStepEntity2) {
            String obj4;
            final int i = 1;
            if (videoStepEntity2.getLocale_stepId() == null) {
                k.k1(i);
            } else {
                k.D(i, videoStepEntity2.getLocale_stepId());
            }
        }
    }

    class e extends g0<TrickTagEntity> {
        e(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickTagEntity` WHERE `locale_tagId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickTagEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickTagEntity trickTagEntity2) {
            String obj4;
            final int i = 1;
            if (trickTagEntity2.getLocale_tagId() == null) {
                k.k1(i);
            } else {
                k.D(i, trickTagEntity2.getLocale_tagId());
            }
        }
    }

    class f extends g0<TrickVariationEntity> {
        f(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickVariationEntity` WHERE `locale_variationId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickVariationEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickVariationEntity trickVariationEntity2) {
            String obj4;
            final int i = 1;
            if (trickVariationEntity2.getLocale_variationId() == null) {
                k.k1(i);
            } else {
                k.D(i, trickVariationEntity2.getLocale_variationId());
            }
        }
    }

    class g extends g0<TrickCategoryEntity> {
        g(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickCategoryEntity` WHERE `locale_categoryId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickCategoryEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickCategoryEntity trickCategoryEntity2) {
            String obj4;
            final int i = 1;
            if (trickCategoryEntity2.getLocale_categoryId() == null) {
                k.k1(i);
            } else {
                k.D(i, trickCategoryEntity2.getLocale_categoryId());
            }
        }
    }

    class h0 extends h0<TrickVariationEntity> {

        final e.a.a.a.b.b.n0 d;
        h0(e.a.a.a.b.b.n0 n0, u0 u02) {
            this.d = n0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickVariationEntity` (`tips`,`variationId`,`title`,`description`,`locale`,`contentfulId`,`updatedAt`,`locale_variationId`) VALUES (?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickVariationEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickVariationEntity trickVariationEntity2) {
            String variationId;
            String title;
            String description;
            String locale;
            String contentfulId;
            String obj5;
            String str = n0.D(this.d).d(trickVariationEntity2.getTips());
            int i2 = 1;
            if (str == null) {
                k.k1(i2);
            } else {
                k.D(i2, str);
            }
            int i3 = 2;
            if (trickVariationEntity2.getVariationId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickVariationEntity2.getVariationId());
            }
            int i4 = 3;
            if (trickVariationEntity2.getTitle() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickVariationEntity2.getTitle());
            }
            int i5 = 4;
            if (trickVariationEntity2.getDescription() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickVariationEntity2.getDescription());
            }
            int i6 = 5;
            if (trickVariationEntity2.getLocale() == null) {
                k.k1(i6);
            } else {
                k.D(i6, trickVariationEntity2.getLocale());
            }
            int i7 = 6;
            if (trickVariationEntity2.getContentfulId() == null) {
                k.k1(i7);
            } else {
                k.D(i7, trickVariationEntity2.getContentfulId());
            }
            k.u0(7, trickVariationEntity2.getUpdatedAt());
            int i8 = 8;
            if (trickVariationEntity2.getLocale_variationId() == null) {
                k.k1(i8);
            } else {
                k.D(i8, trickVariationEntity2.getLocale_variationId());
            }
        }
    }

    class h extends g0<k> {
        h(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithTags` WHERE `locale_tagId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (k)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, k k2) {
            String str;
            String obj4;
            int i = 1;
            if (k2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, k2.a());
            }
            int i2 = 2;
            if (k2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, k2.b());
            }
        }
    }

    class i extends g0<m> {
        i(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithVideoSteps` WHERE `locale_stepId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (m)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, m m2) {
            String str;
            String obj4;
            int i = 1;
            if (m2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, m2.a());
            }
            int i2 = 2;
            if (m2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, m2.b());
            }
        }
    }

    class j extends g0<j> {
        j(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithSteps` WHERE `locale_stepId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (j)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, j j2) {
            String str;
            String obj4;
            int i = 1;
            if (j2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, j2.a());
            }
            int i2 = 2;
            if (j2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, j2.b());
            }
        }
    }

    class k extends h0<TrickEntity> {

        final e.a.a.a.b.b.n0 d;
        k(e.a.a.a.b.b.n0 n0, u0 u02) {
            this.d = n0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickEntity` (`trickId`,`name`,`image`,`categoryName`,`categoryId`,`examInstructions`,`examTimeLimit`,`sortOrder`,`isExam`,`hasProgress`,`updatedAt`,`videoId`,`videoThumbnail`,`description`,`locale`,`locale_trickId`,`imageStepOrder`,`videoStepOder`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickEntity trickEntity2) {
            String trickId;
            String name;
            String image;
            String categoryName;
            String categoryId;
            String examInstructions;
            int examTimeLimit;
            Integer sortOrder;
            String videoId;
            String videoThumbnail;
            String description;
            String locale;
            String locale_trickId;
            long l;
            int i3 = 1;
            if (trickEntity2.getTrickId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickEntity2.getTrickId());
            }
            int i4 = 2;
            if (trickEntity2.getName() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickEntity2.getName());
            }
            int i5 = 3;
            if (trickEntity2.getImage() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickEntity2.getImage());
            }
            int i6 = 4;
            if (trickEntity2.getCategoryName() == null) {
                k.k1(i6);
            } else {
                k.D(i6, trickEntity2.getCategoryName());
            }
            int i7 = 5;
            if (trickEntity2.getCategoryId() == null) {
                k.k1(i7);
            } else {
                k.D(i7, trickEntity2.getCategoryId());
            }
            int i8 = 6;
            if (trickEntity2.getExamInstructions() == null) {
                k.k1(i8);
            } else {
                k.D(i8, trickEntity2.getExamInstructions());
            }
            int i9 = 7;
            if (trickEntity2.getExamTimeLimit() == null) {
                k.k1(i9);
            } else {
                k.u0(i9, (long)examTimeLimit);
            }
            int i10 = 8;
            if (trickEntity2.getSortOrder() == null) {
                k.k1(i10);
            } else {
                k.u0(i10, (long)sortOrder);
            }
            k.u0(9, (long)exam);
            long l3 = (long)hasProgress;
            k.u0(10, l3);
            k.u0(11, trickEntity2.getUpdatedAt());
            int i13 = 12;
            if (trickEntity2.getVideoId() == null) {
                k.k1(i13);
            } else {
                k.D(i13, trickEntity2.getVideoId());
            }
            int i14 = 13;
            if (trickEntity2.getVideoThumbnail() == null) {
                k.k1(i14);
            } else {
                k.D(i14, trickEntity2.getVideoThumbnail());
            }
            int i15 = 14;
            if (trickEntity2.getDescription() == null) {
                k.k1(i15);
            } else {
                k.D(i15, trickEntity2.getDescription());
            }
            int i16 = 15;
            if (trickEntity2.getLocale() == null) {
                k.k1(i16);
            } else {
                k.D(i16, trickEntity2.getLocale());
            }
            int i17 = 16;
            if (trickEntity2.getLocale_trickId() == null) {
                k.k1(i17);
            } else {
                k.D(i17, trickEntity2.getLocale_trickId());
            }
            String str = n0.D(this.d).d(trickEntity2.getImageStepOrder());
            int i18 = 17;
            if (str == null) {
                k.k1(i18);
            } else {
                k.D(i18, str);
            }
            String obj6 = n0.D(this.d).d(trickEntity2.getVideoStepOder());
            int i2 = 18;
            if (obj6 == null) {
                k.k1(i2);
            } else {
                k.D(i2, obj6);
            }
        }
    }

    class l extends g0<l> {
        l(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithVariations` WHERE `locale_variationId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (l)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, l l2) {
            String str;
            String obj4;
            int i = 1;
            if (l2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, l2.b());
            }
            int i2 = 2;
            if (l2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, l2.a());
            }
        }
    }

    class o0 extends h0<TrickCategoryEntity> {
        o0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickCategoryEntity` (`categoryId`,`locale`,`name`,`updatedAt`,`locale_categoryId`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickCategoryEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickCategoryEntity trickCategoryEntity2) {
            String categoryId;
            String locale;
            String name;
            String obj5;
            int i2 = 1;
            if (trickCategoryEntity2.getCategoryId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, trickCategoryEntity2.getCategoryId());
            }
            int i3 = 2;
            if (trickCategoryEntity2.getLocale() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickCategoryEntity2.getLocale());
            }
            int i4 = 3;
            if (trickCategoryEntity2.getName() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickCategoryEntity2.getName());
            }
            k.u0(4, trickCategoryEntity2.getUpdatedAt());
            int i5 = 5;
            if (trickCategoryEntity2.getLocale_categoryId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickCategoryEntity2.getLocale_categoryId());
            }
        }
    }

    class p0 extends h0<k> {
        p0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithTags` (`locale_tagId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (k)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, k k2) {
            String str;
            String obj4;
            int i = 1;
            if (k2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, k2.a());
            }
            int i2 = 2;
            if (k2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, k2.b());
            }
        }
    }

    class q0 extends h0<m> {
        q0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithVideoSteps` (`locale_stepId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (m)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, m m2) {
            String str;
            String obj4;
            int i = 1;
            if (m2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, m2.a());
            }
            int i2 = 2;
            if (m2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, m2.b());
            }
        }
    }

    class r0 extends h0<j> {
        r0(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithSteps` (`locale_stepId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (j)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, j j2) {
            String str;
            String obj4;
            int i = 1;
            if (j2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, j2.a());
            }
            int i2 = 2;
            if (j2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, j2.b());
            }
        }
    }

    class v extends h0<TrickStepEntity> {
        v(e.a.a.a.b.b.n0 n0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickStepEntity` (`stepId`,`description`,`image`,`locale`,`updatedAt`,`locale_stepId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickStepEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickStepEntity trickStepEntity2) {
            String stepId;
            String description;
            String image;
            String locale;
            String obj5;
            int i2 = 1;
            if (trickStepEntity2.getStepId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, trickStepEntity2.getStepId());
            }
            int i3 = 2;
            if (trickStepEntity2.getDescription() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickStepEntity2.getDescription());
            }
            int i4 = 3;
            if (trickStepEntity2.getImage() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickStepEntity2.getImage());
            }
            int i5 = 4;
            if (trickStepEntity2.getLocale() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickStepEntity2.getLocale());
            }
            k.u0(5, trickStepEntity2.getUpdatedAt());
            int i6 = 6;
            if (trickStepEntity2.getLocale_stepId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, trickStepEntity2.getLocale_stepId());
            }
        }
    }
    public n0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        n0.k kVar = new n0.k(this, u0);
        this.b = kVar;
        n0.v vVar = new n0.v(this, u0);
        this.d = vVar;
        n0.a0 a0Var = new n0.a0(this, u0);
        this.e = a0Var;
        n0.d0 d0Var = new n0.d0(this, u0);
        this.f = d0Var;
        n0.h0 h0Var = new n0.h0(this, u0);
        this.g = h0Var;
        n0.o0 o0Var = new n0.o0(this, u0);
        this.h = o0Var;
        n0.p0 p0Var = new n0.p0(this, u0);
        this.i = p0Var;
        n0.q0 q0Var = new n0.q0(this, u0);
        this.j = q0Var;
        n0.r0 r0Var = new n0.r0(this, u0);
        this.k = r0Var;
        n0.a aVar2 = new n0.a(this, u0);
        this.l = aVar2;
        n0.b bVar = new n0.b(this, u0);
        n0.c cVar = new n0.c(this, u0);
        n0.d dVar = new n0.d(this, u0);
        n0.e eVar = new n0.e(this, u0);
        n0.f fVar = new n0.f(this, u0);
        n0.g gVar = new n0.g(this, u0);
        n0.h hVar = new n0.h(this, u0);
        this.m = hVar;
        n0.i iVar = new n0.i(this, u0);
        this.n = iVar;
        n0.j jVar = new n0.j(this, u0);
        this.o = jVar;
        n0.l lVar = new n0.l(this, u0);
        this.p = lVar;
    }

    private void A(a<String, ArrayList<TrickTagEntity>> a) {
        a aVar;
        x0 x0Var;
        int i3;
        int i;
        int i2;
        Object next;
        boolean trickTagEntity;
        String string2;
        String string4;
        String string3;
        String string;
        Object obj2;
        Object obj;
        String str3;
        String str2;
        long long;
        String str;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i2 = i3;
            while (i3 < a.size()) {
                aVar.put((String)a.j(i3), (ArrayList)a.n(i3));
                i3++;
                if (i2++ == i5) {
                }
                A(aVar);
                aVar = new a(i5);
                i2 = i8;
            }
            if (i2 > 0) {
                A(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TrickTagEntity`.`tagId` AS `tagId`,`TrickTagEntity`.`locale` AS `locale`,`TrickTagEntity`.`name` AS `name`,`TrickTagEntity`.`updatedAt` AS `updatedAt`,`TrickTagEntity`.`locale_tagId` AS `locale_tagId`,_junction.`locale_trickId` FROM `TrickWithTags` AS _junction INNER JOIN `TrickTagEntity` ON (_junction.`locale_tagId` = `TrickTagEntity`.`locale_tagId`) WHERE _junction.`locale_trickId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i, (String)next);
            i++;
            x0Var.k1(i);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(5));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj = string2;
            if (cursor.isNull(i7)) {
            } else {
            }
            str3 = string4;
            string3 = 2;
            if (cursor.isNull(string3)) {
            } else {
            }
            str2 = string3;
            string = 4;
            if (cursor.isNull(string)) {
            } else {
            }
            str = string;
            super(obj, str3, str2, cursor.getLong(3), obj11, str);
            (ArrayList)x0Var.add(trickTagEntity);
            str = i9;
            str2 = i9;
            str3 = i9;
            obj = i9;
        }
        cursor.close();
    }

    private void B(a<String, ArrayList<TrickVariationEntity>> a) {
        a aVar;
        x0 x0Var;
        int i3;
        int i2;
        int i;
        Object next;
        boolean trickVariationEntity;
        String string7;
        String string3;
        String string;
        String string5;
        String string2;
        String string6;
        String string4;
        Object null;
        Object obj;
        List list;
        String str4;
        String str5;
        String str3;
        String str6;
        String str;
        long long;
        String str2;
        final Object obj3 = this;
        final Throwable obj2 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i = i3;
            while (i3 < a.size()) {
                aVar.put((String)obj2.j(i3), (ArrayList)obj2.n(i3));
                i3++;
                if (i++ == i5) {
                }
                obj3.B(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                obj3.B(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TrickVariationEntity`.`tips` AS `tips`,`TrickVariationEntity`.`variationId` AS `variationId`,`TrickVariationEntity`.`title` AS `title`,`TrickVariationEntity`.`description` AS `description`,`TrickVariationEntity`.`locale` AS `locale`,`TrickVariationEntity`.`contentfulId` AS `contentfulId`,`TrickVariationEntity`.`updatedAt` AS `updatedAt`,`TrickVariationEntity`.`locale_variationId` AS `locale_variationId`,_junction.`locale_trickId` FROM `TrickWithVariations` AS _junction INNER JOIN `TrickVariationEntity` ON (_junction.`locale_variationId` = `TrickVariationEntity`.`locale_variationId`) WHERE _junction.`locale_trickId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i2 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i2, (String)next);
            i2++;
            x0Var.k1(i2);
        }
        int i9 = 0;
        Cursor cursor = c.c(obj3.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = obj2.get(cursor.getString(8));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            string7 = cursor.getString(i8);
            if (cursor.isNull(i7)) {
            } else {
            }
            str4 = string3;
            string = 2;
            if (cursor.isNull(string)) {
            } else {
            }
            str5 = string;
            string5 = 3;
            if (cursor.isNull(string5)) {
            } else {
            }
            str3 = string5;
            string2 = 4;
            if (cursor.isNull(string2)) {
            } else {
            }
            str6 = string2;
            string6 = 5;
            if (cursor.isNull(string6)) {
            } else {
            }
            str = string6;
            string4 = 7;
            if (cursor.isNull(string4)) {
            } else {
            }
            str2 = string4;
            super(obj3.c.j(string7), str4, str5, str3, str6, str, cursor.getLong(6), obj17, str2);
            (ArrayList)x0Var.add(trickVariationEntity);
            str2 = i9;
            str = i9;
            str6 = i9;
            str3 = i9;
            str5 = i9;
            str4 = i9;
            string7 = i9;
        }
        cursor.close();
    }

    private void C(a<String, ArrayList<VideoStepEntity>> a) {
        a aVar;
        x0 x0Var;
        int i3;
        int i2;
        int i;
        Object next;
        boolean videoStepEntity;
        String string3;
        String string;
        String string2;
        String string4;
        Object obj;
        Object obj2;
        String str3;
        String str;
        int int;
        long long;
        String str2;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i = i3;
            while (i3 < a.size()) {
                aVar.put((String)a.j(i3), (ArrayList)a.n(i3));
                i3++;
                if (i++ == i5) {
                }
                C(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                C(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `VideoStepEntity`.`stepId` AS `stepId`,`VideoStepEntity`.`text` AS `text`,`VideoStepEntity`.`locale` AS `locale`,`VideoStepEntity`.`startTime` AS `startTime`,`VideoStepEntity`.`updatedAt` AS `updatedAt`,`VideoStepEntity`.`locale_stepId` AS `locale_stepId`,_junction.`locale_trickId` FROM `TrickWithVideoSteps` AS _junction INNER JOIN `VideoStepEntity` ON (_junction.`locale_stepId` = `VideoStepEntity`.`locale_stepId`) WHERE _junction.`locale_trickId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i2 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i2, (String)next);
            i2++;
            x0Var.k1(i2);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(6));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj2 = string3;
            if (cursor.isNull(i7)) {
            } else {
            }
            str3 = string;
            string2 = 2;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            string4 = 5;
            if (cursor.isNull(string4)) {
            } else {
            }
            str2 = string4;
            super(obj2, str3, str, cursor.getInt(3), cursor.getLong(4), obj12, str2);
            (ArrayList)x0Var.add(videoStepEntity);
            str2 = i9;
            str = i9;
            str3 = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    static a D(e.a.a.a.b.b.n0 n0) {
        return n0.c;
    }

    static u0 E(e.a.a.a.b.b.n0 n0) {
        return n0.a;
    }

    static h0 F(e.a.a.a.b.b.n0 n0) {
        return n0.k;
    }

    static h0 G(e.a.a.a.b.b.n0 n0) {
        return n0.l;
    }

    static g0 H(e.a.a.a.b.b.n0 n0) {
        return n0.m;
    }

    static g0 I(e.a.a.a.b.b.n0 n0) {
        return n0.n;
    }

    static h0 J(e.a.a.a.b.b.n0 n0) {
        return n0.b;
    }

    static g0 K(e.a.a.a.b.b.n0 n0) {
        return n0.o;
    }

    static g0 L(e.a.a.a.b.b.n0 n0) {
        return n0.p;
    }

    static void M(e.a.a.a.b.b.n0 n0, a a2) {
        n0.C(a2);
    }

    static void N(e.a.a.a.b.b.n0 n0, a a2) {
        n0.z(a2);
    }

    static void O(e.a.a.a.b.b.n0 n0, a a2) {
        n0.A(a2);
    }

    static void P(e.a.a.a.b.b.n0 n0, a a2) {
        n0.B(a2);
    }

    static h0 Q(e.a.a.a.b.b.n0 n0) {
        return n0.d;
    }

    static h0 R(e.a.a.a.b.b.n0 n0) {
        return n0.e;
    }

    static h0 S(e.a.a.a.b.b.n0 n0) {
        return n0.f;
    }

    static h0 T(e.a.a.a.b.b.n0 n0) {
        return n0.g;
    }

    static h0 U(e.a.a.a.b.b.n0 n0) {
        return n0.h;
    }

    static h0 V(e.a.a.a.b.b.n0 n0) {
        return n0.i;
    }

    static h0 W(e.a.a.a.b.b.n0 n0) {
        return n0.j;
    }

    public static List<Class<?>> X() {
        return Collections.emptyList();
    }

    private void z(a<String, ArrayList<TrickStepEntity>> a) {
        a aVar;
        x0 x0Var;
        int i;
        int i2;
        int i3;
        Object next;
        boolean trickStepEntity;
        String string4;
        String string;
        String string2;
        String string3;
        String string5;
        Object obj;
        Object obj2;
        String str2;
        String str3;
        String str4;
        long long;
        String str;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i3 = i;
            while (i < a.size()) {
                aVar.put((String)a.j(i), (ArrayList)a.n(i));
                i++;
                if (i3++ == i5) {
                }
                z(aVar);
                aVar = new a(i5);
                i3 = i8;
            }
            if (i3 > 0) {
                z(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TrickStepEntity`.`stepId` AS `stepId`,`TrickStepEntity`.`description` AS `description`,`TrickStepEntity`.`image` AS `image`,`TrickStepEntity`.`locale` AS `locale`,`TrickStepEntity`.`updatedAt` AS `updatedAt`,`TrickStepEntity`.`locale_stepId` AS `locale_stepId`,_junction.`locale_trickId` FROM `TrickWithSteps` AS _junction INNER JOIN `TrickStepEntity` ON (_junction.`locale_stepId` = `TrickStepEntity`.`locale_stepId`) WHERE _junction.`locale_trickId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i2 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i2, (String)next);
            i2++;
            x0Var.k1(i2);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(6));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj2 = string4;
            if (cursor.isNull(i7)) {
            } else {
            }
            str2 = string;
            string2 = 2;
            if (cursor.isNull(string2)) {
            } else {
            }
            str3 = string2;
            string3 = 3;
            if (cursor.isNull(string3)) {
            } else {
            }
            str4 = string3;
            string5 = 5;
            if (cursor.isNull(string5)) {
            } else {
            }
            str = string5;
            super(obj2, str2, str3, str4, cursor.getLong(4), obj12, str);
            (ArrayList)x0Var.add(trickStepEntity);
            str = i9;
            str4 = i9;
            str3 = i9;
            str2 = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    public Object a(d<? super Long> d) {
        final int i = 0;
        n0.e0 e0Var = new n0.e0(this, x0.e("SELECT updatedAt FROM TrickTagEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), e0Var, d);
    }

    public Object b(String string, d<? super List<l>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithVariations WHERE locale_trickId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        n0.n0 n0Var = new n0.n0(this, x0Var);
        return c0.a(this.a, false, c.a(), n0Var, d2);
    }

    public Object c(TrickEntity[] trickEntityArr, d<? super w> d2) {
        n0.m mVar = new n0.m(this, trickEntityArr);
        return c0.b(this.a, true, mVar, d2);
    }

    public Object d(m[] mArr, d<? super w> d2) {
        n0.t tVar = new n0.t(this, mArr);
        return c0.b(this.a, true, tVar, d2);
    }

    public Object e(String string, d<? super List<j>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithSteps WHERE locale_trickId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        n0.m0 m0Var = new n0.m0(this, x0Var);
        return c0.a(this.a, false, c.a(), m0Var, d2);
    }

    public Object f(m[] mArr, d<? super w> d2) {
        n0.y yVar = new n0.y(this, mArr);
        return c0.b(this.a, true, yVar, d2);
    }

    public Object g(k[] kArr, d<? super w> d2) {
        n0.s sVar = new n0.s(this, kArr);
        return c0.b(this.a, true, sVar, d2);
    }

    public Object h(TrickVariationEntity[] trickVariationEntityArr, d<? super w> d2) {
        n0.q qVar = new n0.q(this, trickVariationEntityArr);
        return c0.b(this.a, true, qVar, d2);
    }

    public Object i(g g, d<? super w> d2) {
        return m0.a.b(this, g, d2);
    }

    public Object j(d<? super Long> d) {
        final int i = 0;
        n0.c0 c0Var = new n0.c0(this, x0.e("SELECT updatedAt FROM TrickEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), c0Var, d);
    }

    public Object k(l[] lArr, d<? super w> d2) {
        n0.b0 b0Var = new n0.b0(this, lArr);
        return c0.b(this.a, true, b0Var, d2);
    }

    public Object l(TrickCategoryEntity[] trickCategoryEntityArr, d<? super w> d2) {
        n0.r rVar = new n0.r(this, trickCategoryEntityArr);
        return c0.b(this.a, true, rVar, d2);
    }

    public Object m(j[] jArr, d<? super w> d2) {
        n0.z zVar = new n0.z(this, jArr);
        return c0.b(this.a, true, zVar, d2);
    }

    public Object n(String string, d<? super List<k>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithTags WHERE locale_trickId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        n0.k0 k0Var = new n0.k0(this, x0Var);
        return c0.a(this.a, false, c.a(), k0Var, d2);
    }

    public Object o(String string, String string2, d<? super TrickCategoryEntity> d3) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickCategoryEntity WHERE categoryId = ? AND locale = ?", i);
        int i3 = 1;
        if (string == null) {
            x0Var.k1(i3);
        } else {
            x0Var.D(i3, string);
        }
        if (string2 == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string2);
        }
        n0.g0 g0Var = new n0.g0(this, x0Var);
        return c0.a(this.a, false, c.a(), g0Var, d3);
    }

    public Object p(TrickTagEntity[] trickTagEntityArr, d<? super w> d2) {
        n0.p pVar = new n0.p(this, trickTagEntityArr);
        return c0.b(this.a, true, pVar, d2);
    }

    public Object q(j[] jArr, d<? super w> d2) {
        n0.u uVar = new n0.u(this, jArr);
        return c0.b(this.a, true, uVar, d2);
    }

    public Object r(TrickStepEntity[] trickStepEntityArr, d<? super w> d2) {
        n0.n nVar = new n0.n(this, trickStepEntityArr);
        return c0.b(this.a, true, nVar, d2);
    }

    public Object s(l[] lArr, d<? super w> d2) {
        n0.w wVar = new n0.w(this, lArr);
        return c0.b(this.a, true, wVar, d2);
    }

    public Object t(String string, String string2, d<? super List<g>> d3) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickEntity WHERE locale = ? AND trickId = ?", i);
        final int i2 = 1;
        if (string == null) {
            x0Var.k1(i2);
        } else {
            x0Var.D(i2, string);
        }
        if (string2 == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string2);
        }
        n0.j0 j0Var = new n0.j0(this, x0Var);
        return c0.a(this.a, i2, c.a(), j0Var, d3);
    }

    public Object u(d<? super Long> d) {
        final int i = 0;
        n0.f0 f0Var = new n0.f0(this, x0.e("SELECT updatedAt FROM TrickCategoryEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), f0Var, d);
    }

    public Object v(VideoStepEntity[] videoStepEntityArr, d<? super w> d2) {
        n0.o oVar = new n0.o(this, videoStepEntityArr);
        return c0.b(this.a, true, oVar, d2);
    }

    public Object w(k[] kArr, d<? super w> d2) {
        n0.x xVar = new n0.x(this, kArr);
        return c0.b(this.a, true, xVar, d2);
    }

    public Object x(String string, d<? super List<m>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithVideoSteps WHERE locale_trickId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        n0.l0 l0Var = new n0.l0(this, x0Var);
        return c0.a(this.a, false, c.a(), l0Var, d2);
    }

    public a0<List<g>> y(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickEntity WHERE locale = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        n0.i0 obj3 = new n0.i0(this, x0Var);
        return y0.a(obj3);
    }
}
