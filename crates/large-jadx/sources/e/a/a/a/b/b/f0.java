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
import app.dogo.android.persistencedb.room.database.ContentDatabase;
import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
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
import e.a.a.a.b.c.b;
import e.a.a.a.b.c.c;
import e.a.a.a.b.c.d;
import e.a.a.a.b.c.e;
import e.a.a.a.b.c.f;
import e.a.a.a.b.c.h;
import e.a.a.a.b.d.a;
import e.a.a.a.b.d.b;
import e.a.a.a.b.d.c;
import e.a.a.a.b.d.e;
import e.a.a.a.b.d.f;
import e.a.a.a.b.d.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
public final class f0 extends e.a.a.a.b.b.e0 {

    private final u0 d;
    private final h0<LessonEntity> e;
    private final h0<ModuleEntity> f;
    private final h0<ProgramEntity> g;
    private final a h;
    private final h0<b> i;
    private final h0<d> j;
    private final h0<c> k;
    private final h0<e> l;
    private final h0<f> m;
    private final h0<h> n;
    private final g0<b> o;
    private final g0<d> p;
    private final g0<c> q;
    private final g0<e> r;
    private final g0<f> s;
    private final g0<h> t;

    class a0 implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        a0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, i, 0);
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

    class c0 implements Callable<List<e>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        c0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<e> a() {
            int i14;
            int i19;
            ProgramEntity programEntity;
            Object obj3;
            int i27;
            Object arrayList;
            Object obj2;
            int i21;
            Object obj;
            int arrayList3;
            ArrayList arrayList2;
            int i30;
            String string16;
            String string15;
            int i28;
            int i20;
            int count;
            boolean null2;
            a aVar2;
            int i5;
            int i17;
            a aVar;
            int i23;
            int i11;
            int i31;
            int i18;
            int i;
            int i2;
            int i4;
            String string3;
            int i10;
            int i8;
            int i32;
            int null3;
            boolean string12;
            String string6;
            boolean string;
            String string11;
            boolean string5;
            String string2;
            boolean string14;
            String string4;
            String string10;
            String string8;
            String string17;
            String string7;
            boolean string13;
            boolean string9;
            int i15;
            int i6;
            int i24;
            ArrayList list4;
            int i7;
            int null;
            int i25;
            String str6;
            int i16;
            String str4;
            int i26;
            String str7;
            int i29;
            String str9;
            String str8;
            String str;
            String str3;
            String str2;
            long long;
            int i12;
            int i22;
            List list;
            List list2;
            List list3;
            int int;
            int int2;
            String str5;
            int i3;
            int i9;
            int i13;
            obj3 = this;
            f0.V(obj3.b).c();
            Cursor cursor = c.c(f0.V(obj3.b), obj3.a, true, 0);
            i14 = b.e(cursor, "type");
            i21 = b.e(cursor, "programId");
            int i41 = b.e(cursor, "name");
            int i42 = b.e(cursor, "image");
            int i43 = b.e(cursor, "centeredImage");
            int i44 = b.e(cursor, "description");
            int i45 = b.e(cursor, "cardBackgroundColor");
            int i46 = b.e(cursor, "certificateLaurelsImage");
            int i47 = b.e(cursor, "certificatePaperImage");
            int i48 = b.e(cursor, "certificatePlaceholderUrl");
            int i49 = b.e(cursor, "certificateRequirements");
            i20 = b.e(cursor, "locale");
            arrayList3 = b.e(cursor, "locale_programId");
            i17 = i50;
            i23 = i51;
            i31 = i52;
            i = i53;
            i2 = i54;
            i4 = i55;
            i8 = i56;
            null3 = i57;
            aVar2 = new a();
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(arrayList3);
                if ((ArrayList)aVar2.get(string19) == null) {
                } else {
                }
                i7 = arrayList3;
                i20 = i6;
                arrayList3 = i7;
                i7 = arrayList3;
                arrayList3 = new ArrayList();
                aVar2.put(string19, arrayList3);
            }
            null = arrayList3;
            i24 = i20;
            cursor.moveToPosition(-1);
            f0.e0(obj3.b, aVar2);
            arrayList2 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i14) && cursor.isNull(i21) && cursor.isNull(i41) && cursor.isNull(i42) && cursor.isNull(i43) && cursor.isNull(i44) && cursor.isNull(i45) && cursor.isNull(i46) && cursor.isNull(i47) && cursor.isNull(i48) && cursor.isNull(i49)) {
                } else {
                }
                i27 = null3;
                count = i24;
                list4 = arrayList2;
                i30 = i17;
                aVar = aVar2;
                i5 = null;
                if (cursor.isNull(i14)) {
                } else {
                }
                i25 = string12;
                if (cursor.isNull(i21)) {
                } else {
                }
                str6 = string6;
                if (cursor.isNull(i41)) {
                } else {
                }
                i16 = string;
                if (cursor.isNull(i42)) {
                } else {
                }
                str4 = string11;
                if (cursor.isNull(i43)) {
                } else {
                }
                i26 = string5;
                if (cursor.isNull(i44)) {
                } else {
                }
                str7 = string2;
                if (cursor.isNull(i45)) {
                } else {
                }
                i29 = string14;
                if (cursor.isNull(i46)) {
                } else {
                }
                str9 = string4;
                if (cursor.isNull(i47)) {
                } else {
                }
                str8 = string10;
                if (cursor.isNull(i48)) {
                } else {
                }
                str = string8;
                if (cursor.isNull(i49)) {
                } else {
                }
                str3 = string17;
                if (cursor.isNull(count)) {
                } else {
                }
                str2 = string7;
                if (cursor.isNull(i5)) {
                } else {
                }
                i12 = string13;
                i11 = i14;
                int i33 = i59;
                if (cursor.isNull(i33)) {
                } else {
                }
                i22 = string9;
                i18 = i33;
                int i34 = i13;
                if (cursor.isNull(i34)) {
                } else {
                }
                i3 = i34;
                i9 = i30;
                i19 = string20;
                i15 = i21;
                obj = this;
                int i35 = i;
                if (cursor.isNull(i35)) {
                } else {
                }
                string16 = cursor.getString(i35);
                i = i35;
                int i36 = i2;
                if (cursor.isNull(i36)) {
                } else {
                }
                string15 = cursor.getString(i36);
                i2 = i36;
                int i37 = i4;
                if (cursor.isNull(i27)) {
                } else {
                }
                str5 = string3;
                super(i25, str6, i16, str4, i26, str7, i29, str9, str8, str, str3, str2, cursor.getLong(i30), obj39, i12, i22, f0.U(obj.b).j(i19), f0.U(obj.b).j(string16), f0.U(obj.b).j(string15), cursor.getInt(i37), cursor.getInt(i8), str5);
                i32 = i37;
                programEntity = programEntity2;
                i10 = i27;
                a aVar6 = aVar;
                if ((ArrayList)aVar6.get(cursor.getString(i5)) == null) {
                }
                e eVar = new e(programEntity, arrayList);
                ArrayList list6 = list4;
                list6.add(eVar);
                arrayList2 = list6;
                obj3 = obj;
                i24 = count;
                i14 = i11;
                i23 = i18;
                i21 = i15;
                i31 = i3;
                null3 = i10;
                i4 = i32;
                i8 = i58;
                null = i5;
                aVar2 = aVar7;
                i17 = i9;
                arrayList = new ArrayList();
                str5 = 0;
                i2 = i36;
                string15 = 0;
                i = i35;
                string16 = 0;
                i3 = i34;
                i15 = i21;
                i9 = i30;
                i19 = 0;
                i22 = 0;
                i12 = 0;
                str2 = 0;
                str3 = 0;
                str = 0;
                str8 = 0;
                str9 = 0;
                i29 = 0;
                str7 = 0;
                i26 = 0;
                str4 = 0;
                i16 = 0;
                str6 = 0;
                i25 = 0;
                if (cursor.isNull(i21)) {
                } else {
                }
                if (cursor.isNull(i41)) {
                } else {
                }
                if (cursor.isNull(i42)) {
                } else {
                }
                if (cursor.isNull(i43)) {
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
                if (cursor.isNull(i49)) {
                } else {
                }
                if (cursor.isNull(i24)) {
                } else {
                }
                list4 = arrayList2;
                i30 = i17;
                i27 = null3;
                list4 = arrayList2;
                i30 = i17;
                if (cursor.isNull(i30)) {
                } else {
                }
                aVar = aVar2;
                i27 = null3;
                aVar = aVar2;
                if (cursor.isNull(null)) {
                } else {
                }
                i27 = null3;
                obj3 = i23;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i23 = obj3;
                obj3 = i31;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i31 = obj3;
                obj3 = i;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i = obj3;
                i = obj3;
                obj3 = i2;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i2 = obj3;
                i2 = obj3;
                obj3 = i4;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i4 = obj3;
                obj3 = i8;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i8 = obj3;
                i27 = null3;
                if (!cursor.isNull(i27)) {
                } else {
                }
                i15 = i21;
                i9 = i30;
                i3 = i31;
                i28 = i8;
                obj = this;
                i18 = i23;
                i32 = i4;
                i11 = i14;
                i10 = i27;
                programEntity = 0;
            }
            Object obj4 = obj3;
            f0.V(obj4.b).C();
            cursor.close();
            obj4.a.j();
            f0.V(obj4.b).g();
            return arrayList2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d0 implements Callable<List<e>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        d0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<e> a() {
            int i11;
            int i16;
            ProgramEntity programEntity;
            Object obj3;
            int i21;
            Object arrayList2;
            Object obj;
            int i2;
            Object obj2;
            int arrayList;
            ArrayList arrayList3;
            int i20;
            String string9;
            String string;
            int i5;
            int i19;
            int count;
            boolean null3;
            a aVar2;
            int i26;
            int i24;
            a aVar;
            int i9;
            int i29;
            int i6;
            int i14;
            int i12;
            int i13;
            int i22;
            String string2;
            int i3;
            int i27;
            int i23;
            int null;
            boolean string17;
            String string4;
            boolean string16;
            String string13;
            boolean string10;
            String string7;
            boolean string11;
            String string3;
            String string5;
            String string6;
            String string8;
            String string15;
            boolean string14;
            boolean string12;
            int i32;
            int i15;
            int i;
            ArrayList list3;
            int i10;
            int null2;
            int i17;
            String str9;
            int i18;
            String str6;
            int i30;
            String str5;
            int i25;
            String str;
            String str7;
            String str8;
            String str2;
            String str3;
            long long;
            int i4;
            int i31;
            List list4;
            List list;
            List list2;
            int int;
            int int2;
            String str4;
            int i28;
            int i7;
            int i8;
            obj3 = this;
            f0.V(obj3.b).c();
            Cursor cursor = c.c(f0.V(obj3.b), obj3.a, true, 0);
            i11 = b.e(cursor, "type");
            i2 = b.e(cursor, "programId");
            int i41 = b.e(cursor, "name");
            int i42 = b.e(cursor, "image");
            int i43 = b.e(cursor, "centeredImage");
            int i44 = b.e(cursor, "description");
            int i45 = b.e(cursor, "cardBackgroundColor");
            int i46 = b.e(cursor, "certificateLaurelsImage");
            int i47 = b.e(cursor, "certificatePaperImage");
            int i48 = b.e(cursor, "certificatePlaceholderUrl");
            int i49 = b.e(cursor, "certificateRequirements");
            i19 = b.e(cursor, "locale");
            arrayList = b.e(cursor, "locale_programId");
            i24 = i50;
            i9 = i51;
            i6 = i52;
            i12 = i53;
            i13 = i54;
            i22 = i55;
            i27 = i56;
            null = i57;
            aVar2 = new a();
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(arrayList);
                if ((ArrayList)aVar2.get(string19) == null) {
                } else {
                }
                i10 = arrayList;
                i19 = i15;
                arrayList = i10;
                i10 = arrayList;
                arrayList = new ArrayList();
                aVar2.put(string19, arrayList);
            }
            null2 = arrayList;
            i = i19;
            cursor.moveToPosition(-1);
            f0.e0(obj3.b, aVar2);
            arrayList3 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i11) && cursor.isNull(i2) && cursor.isNull(i41) && cursor.isNull(i42) && cursor.isNull(i43) && cursor.isNull(i44) && cursor.isNull(i45) && cursor.isNull(i46) && cursor.isNull(i47) && cursor.isNull(i48) && cursor.isNull(i49)) {
                } else {
                }
                i21 = null;
                count = i;
                list3 = arrayList3;
                i20 = i24;
                aVar = aVar2;
                i26 = null2;
                if (cursor.isNull(i11)) {
                } else {
                }
                i17 = string17;
                if (cursor.isNull(i2)) {
                } else {
                }
                str9 = string4;
                if (cursor.isNull(i41)) {
                } else {
                }
                i18 = string16;
                if (cursor.isNull(i42)) {
                } else {
                }
                str6 = string13;
                if (cursor.isNull(i43)) {
                } else {
                }
                i30 = string10;
                if (cursor.isNull(i44)) {
                } else {
                }
                str5 = string7;
                if (cursor.isNull(i45)) {
                } else {
                }
                i25 = string11;
                if (cursor.isNull(i46)) {
                } else {
                }
                str = string3;
                if (cursor.isNull(i47)) {
                } else {
                }
                str7 = string5;
                if (cursor.isNull(i48)) {
                } else {
                }
                str8 = string6;
                if (cursor.isNull(i49)) {
                } else {
                }
                str2 = string8;
                if (cursor.isNull(count)) {
                } else {
                }
                str3 = string15;
                if (cursor.isNull(i26)) {
                } else {
                }
                i4 = string14;
                i29 = i11;
                int i33 = i59;
                if (cursor.isNull(i33)) {
                } else {
                }
                i31 = string12;
                i14 = i33;
                int i34 = i8;
                if (cursor.isNull(i34)) {
                } else {
                }
                i28 = i34;
                i7 = i20;
                i16 = string20;
                i32 = i2;
                obj2 = this;
                int i35 = i12;
                if (cursor.isNull(i35)) {
                } else {
                }
                string9 = cursor.getString(i35);
                i12 = i35;
                int i36 = i13;
                if (cursor.isNull(i36)) {
                } else {
                }
                string = cursor.getString(i36);
                i13 = i36;
                int i37 = i22;
                if (cursor.isNull(i21)) {
                } else {
                }
                str4 = string2;
                super(i17, str9, i18, str6, i30, str5, i25, str, str7, str8, str2, str3, cursor.getLong(i20), obj39, i4, i31, f0.U(obj2.b).j(i16), f0.U(obj2.b).j(string9), f0.U(obj2.b).j(string), cursor.getInt(i37), cursor.getInt(i27), str4);
                i23 = i37;
                programEntity = programEntity2;
                i3 = i21;
                a aVar6 = aVar;
                if ((ArrayList)aVar6.get(cursor.getString(i26)) == null) {
                }
                e eVar = new e(programEntity, arrayList2);
                ArrayList list6 = list3;
                list6.add(eVar);
                arrayList3 = list6;
                obj3 = obj2;
                i = count;
                i11 = i29;
                i9 = i14;
                i2 = i32;
                i6 = i28;
                null = i3;
                i22 = i23;
                i27 = i58;
                null2 = i26;
                aVar2 = aVar7;
                i24 = i7;
                arrayList2 = new ArrayList();
                str4 = 0;
                i13 = i36;
                string = 0;
                i12 = i35;
                string9 = 0;
                i28 = i34;
                i32 = i2;
                i7 = i20;
                i16 = 0;
                i31 = 0;
                i4 = 0;
                str3 = 0;
                str2 = 0;
                str8 = 0;
                str7 = 0;
                str = 0;
                i25 = 0;
                str5 = 0;
                i30 = 0;
                str6 = 0;
                i18 = 0;
                str9 = 0;
                i17 = 0;
                if (cursor.isNull(i2)) {
                } else {
                }
                if (cursor.isNull(i41)) {
                } else {
                }
                if (cursor.isNull(i42)) {
                } else {
                }
                if (cursor.isNull(i43)) {
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
                if (cursor.isNull(i49)) {
                } else {
                }
                if (cursor.isNull(i)) {
                } else {
                }
                list3 = arrayList3;
                i20 = i24;
                i21 = null;
                list3 = arrayList3;
                i20 = i24;
                if (cursor.isNull(i20)) {
                } else {
                }
                aVar = aVar2;
                i21 = null;
                aVar = aVar2;
                if (cursor.isNull(null2)) {
                } else {
                }
                i21 = null;
                obj3 = i9;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i9 = obj3;
                obj3 = i6;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i6 = obj3;
                obj3 = i12;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i12 = obj3;
                i12 = obj3;
                obj3 = i13;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i13 = obj3;
                i13 = obj3;
                obj3 = i22;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i22 = obj3;
                obj3 = i27;
                if (cursor.isNull(obj3)) {
                } else {
                }
                i27 = obj3;
                i21 = null;
                if (!cursor.isNull(i21)) {
                } else {
                }
                i32 = i2;
                i7 = i20;
                i28 = i6;
                i5 = i27;
                obj2 = this;
                i14 = i9;
                i23 = i22;
                i29 = i11;
                i3 = i21;
                programEntity = 0;
            }
            Object obj4 = obj3;
            f0.V(obj4.b).C();
            cursor.close();
            obj4.a.j();
            f0.V(obj4.b).g();
            return arrayList3;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e0 implements Callable<List<d>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        e0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<d> a() {
            int string;
            String string2;
            d dVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_lessonId");
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
                dVar = new d(string, string2);
                arrayList.add(dVar);
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

    class f0 implements Callable<List<b>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        f0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<b> a() {
            int string2;
            String string;
            b bVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_lessonId");
            int i3 = b.e(cursor, "locale_questionId");
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
                bVar = new b(string2, string);
                arrayList.add(bVar);
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

    class g0 implements Callable<List<c>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        g0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<c> a() {
            int string;
            String string2;
            c cVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_lessonId");
            int i3 = b.e(cursor, "locale_taskId");
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
                cVar = new c(string, string2);
                arrayList.add(cVar);
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

    class h0 implements Callable<List<e>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        h0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<e> a() {
            int string;
            String string2;
            e eVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_moduleId");
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
                eVar = new e(string, string2);
                arrayList.add(eVar);
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

    class i0 implements Callable<List<f>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        i0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<f> a() {
            int string;
            String string2;
            f fVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_moduleId");
            int i3 = b.e(cursor, "locale_lessonId");
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
                fVar = new f(string, string2);
                arrayList.add(fVar);
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

    class j0 implements Callable<List<h>> {

        final x0 a;
        final e.a.a.a.b.b.f0 b;
        j0(e.a.a.a.b.b.f0 f0, x0 x02) {
            this.b = f0;
            this.a = x02;
            super();
        }

        public List<h> a() {
            int string;
            String string2;
            h hVar;
            final int i4 = 0;
            Cursor cursor = c.c(f0.V(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_programId");
            int i3 = b.e(cursor, "locale_moduleId");
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
                hVar = new h(string, string2);
                arrayList.add(hVar);
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

    class j implements Callable<w> {

        final LessonEntity[] a;
        final e.a.a.a.b.b.f0 b;
        j(e.a.a.a.b.b.f0 f0, LessonEntity[] lessonEntity2Arr2) {
            this.b = f0;
            this.a = lessonEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.d0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class l implements Callable<w> {

        final ModuleEntity[] a;
        final e.a.a.a.b.b.f0 b;
        l(e.a.a.a.b.b.f0 f0, ModuleEntity[] moduleEntity2Arr2) {
            this.b = f0;
            this.a = moduleEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.f0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class m implements Callable<w> {

        final ProgramEntity[] a;
        final e.a.a.a.b.b.f0 b;
        m(e.a.a.a.b.b.f0 f0, ProgramEntity[] programEntity2Arr2) {
            this.b = f0;
            this.a = programEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.g0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class n implements Callable<w> {

        final b[] a;
        final e.a.a.a.b.b.f0 b;
        n(e.a.a.a.b.b.f0 f0, b[] b2Arr2) {
            this.b = f0;
            this.a = b2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.h0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class o implements Callable<w> {

        final d[] a;
        final e.a.a.a.b.b.f0 b;
        o(e.a.a.a.b.b.f0 f0, d[] d2Arr2) {
            this.b = f0;
            this.a = d2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.i0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class p implements Callable<w> {

        final c[] a;
        final e.a.a.a.b.b.f0 b;
        p(e.a.a.a.b.b.f0 f0, c[] c2Arr2) {
            this.b = f0;
            this.a = c2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.j0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class q implements Callable<w> {

        final e[] a;
        final e.a.a.a.b.b.f0 b;
        q(e.a.a.a.b.b.f0 f0, e[] e2Arr2) {
            this.b = f0;
            this.a = e2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.k0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class r implements Callable<w> {

        final f[] a;
        final e.a.a.a.b.b.f0 b;
        r(e.a.a.a.b.b.f0 f0, f[] f2Arr2) {
            this.b = f0;
            this.a = f2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.l0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class s implements Callable<w> {

        final h[] a;
        final e.a.a.a.b.b.f0 b;
        s(e.a.a.a.b.b.f0 f0, h[] h2Arr2) {
            this.b = f0;
            this.a = h2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.W(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class u implements Callable<w> {

        final b[] a;
        final e.a.a.a.b.b.f0 b;
        u(e.a.a.a.b.b.f0 f0, b[] b2Arr2) {
            this.b = f0;
            this.a = b2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.X(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class v implements Callable<w> {

        final d[] a;
        final e.a.a.a.b.b.f0 b;
        v(e.a.a.a.b.b.f0 f0, d[] d2Arr2) {
            this.b = f0;
            this.a = d2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.Y(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class w implements Callable<w> {

        final c[] a;
        final e.a.a.a.b.b.f0 b;
        w(e.a.a.a.b.b.f0 f0, c[] c2Arr2) {
            this.b = f0;
            this.a = c2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.Z(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class x implements Callable<w> {

        final e[] a;
        final e.a.a.a.b.b.f0 b;
        x(e.a.a.a.b.b.f0 f0, e[] e2Arr2) {
            this.b = f0;
            this.a = e2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.a0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class y implements Callable<w> {

        final f[] a;
        final e.a.a.a.b.b.f0 b;
        y(e.a.a.a.b.b.f0 f0, f[] f2Arr2) {
            this.b = f0;
            this.a = f2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.b0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class z implements Callable<w> {

        final h[] a;
        final e.a.a.a.b.b.f0 b;
        z(e.a.a.a.b.b.f0 f0, h[] h2Arr2) {
            this.b = f0;
            this.a = h2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            f0.V(this.b).c();
            f0.c0(this.b).i(this.a);
            f0.V(this.b).C();
            f0.V(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a extends g0<LessonEntity> {
        a(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonEntity` WHERE `locale_lessonId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (LessonEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, LessonEntity lessonEntity2) {
            String obj4;
            final int i = 1;
            if (lessonEntity2.getLocale_lessonId() == null) {
                k.k1(i);
            } else {
                k.D(i, lessonEntity2.getLocale_lessonId());
            }
        }
    }

    class b0 extends h0<ProgramEntity> {

        final e.a.a.a.b.b.f0 d;
        b0(e.a.a.a.b.b.f0 f0, u0 u02) {
            this.d = f0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ProgramEntity` (`type`,`programId`,`name`,`image`,`centeredImage`,`description`,`cardBackgroundColor`,`certificateLaurelsImage`,`certificatePaperImage`,`certificatePlaceholderUrl`,`certificateRequirements`,`locale`,`updatedAt`,`locale_programId`,`programOverviewImage`,`dogSkillsHighlights`,`dogSkillsOverview`,`userSkillsOverview`,`averageCompletionTimeWeeks`,`numberOfEnrolledUsers`,`certificatePreviewImage`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (ProgramEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, ProgramEntity programEntity2) {
            String type;
            String programId;
            String name;
            String image;
            String centeredImage;
            String description;
            String cardBackgroundColor;
            String certificateLaurelsImage;
            String certificatePaperImage;
            String certificatePlaceholderUrl;
            String certificateRequirements;
            String locale;
            String locale_programId;
            String programOverviewImage;
            String obj5;
            int i4 = 1;
            if (programEntity2.getType() == null) {
                k.k1(i4);
            } else {
                k.D(i4, programEntity2.getType());
            }
            int i5 = 2;
            if (programEntity2.getProgramId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, programEntity2.getProgramId());
            }
            int i6 = 3;
            if (programEntity2.getName() == null) {
                k.k1(i6);
            } else {
                k.D(i6, programEntity2.getName());
            }
            int i7 = 4;
            if (programEntity2.getImage() == null) {
                k.k1(i7);
            } else {
                k.D(i7, programEntity2.getImage());
            }
            int i8 = 5;
            if (programEntity2.getCenteredImage() == null) {
                k.k1(i8);
            } else {
                k.D(i8, programEntity2.getCenteredImage());
            }
            int i9 = 6;
            if (programEntity2.getDescription() == null) {
                k.k1(i9);
            } else {
                k.D(i9, programEntity2.getDescription());
            }
            int i10 = 7;
            if (programEntity2.getCardBackgroundColor() == null) {
                k.k1(i10);
            } else {
                k.D(i10, programEntity2.getCardBackgroundColor());
            }
            int i11 = 8;
            if (programEntity2.getCertificateLaurelsImage() == null) {
                k.k1(i11);
            } else {
                k.D(i11, programEntity2.getCertificateLaurelsImage());
            }
            int i12 = 9;
            if (programEntity2.getCertificatePaperImage() == null) {
                k.k1(i12);
            } else {
                k.D(i12, programEntity2.getCertificatePaperImage());
            }
            int i13 = 10;
            if (programEntity2.getCertificatePlaceholderUrl() == null) {
                k.k1(i13);
            } else {
                k.D(i13, programEntity2.getCertificatePlaceholderUrl());
            }
            int i14 = 11;
            if (programEntity2.getCertificateRequirements() == null) {
                k.k1(i14);
            } else {
                k.D(i14, programEntity2.getCertificateRequirements());
            }
            int i15 = 12;
            if (programEntity2.getLocale() == null) {
                k.k1(i15);
            } else {
                k.D(i15, programEntity2.getLocale());
            }
            k.u0(13, programEntity2.getUpdatedAt());
            int i16 = 14;
            if (programEntity2.getLocale_programId() == null) {
                k.k1(i16);
            } else {
                k.D(i16, programEntity2.getLocale_programId());
            }
            int i17 = 15;
            if (programEntity2.getProgramOverviewImage() == null) {
                k.k1(i17);
            } else {
                k.D(i17, programEntity2.getProgramOverviewImage());
            }
            String str = f0.U(this.d).d(programEntity2.getDogSkillsHighlights());
            int i18 = 16;
            if (str == null) {
                k.k1(i18);
            } else {
                k.D(i18, str);
            }
            String str2 = f0.U(this.d).d(programEntity2.getDogSkillsOverview());
            int i19 = 17;
            if (str2 == null) {
                k.k1(i19);
            } else {
                k.D(i19, str2);
            }
            String str3 = f0.U(this.d).d(programEntity2.getUserSkillsOverview());
            int i20 = 18;
            if (str3 == null) {
                k.k1(i20);
            } else {
                k.D(i20, str3);
            }
            k.u0(19, (long)averageCompletionTimeWeeks);
            k.u0(20, (long)numberOfEnrolledUsers);
            int i21 = 21;
            if (programEntity2.getCertificatePreviewImage() == null) {
                k.k1(i21);
            } else {
                k.D(i21, programEntity2.getCertificatePreviewImage());
            }
        }
    }

    class b extends g0<ModuleEntity> {
        b(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleEntity` WHERE `locale_moduleId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (ModuleEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, ModuleEntity moduleEntity2) {
            String obj4;
            final int i = 1;
            if (moduleEntity2.getLocale_moduleId() == null) {
                k.k1(i);
            } else {
                k.D(i, moduleEntity2.getLocale_moduleId());
            }
        }
    }

    class c extends g0<ProgramEntity> {
        c(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ProgramEntity` WHERE `locale_programId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (ProgramEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, ProgramEntity programEntity2) {
            String obj4;
            final int i = 1;
            if (programEntity2.getLocale_programId() == null) {
                k.k1(i);
            } else {
                k.D(i, programEntity2.getLocale_programId());
            }
        }
    }

    class d extends g0<b> {
        d(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithQuestion` WHERE `locale_lessonId` = ? AND `locale_questionId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (b)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, b b2) {
            String str;
            String obj4;
            int i = 1;
            if (b2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, b2.a());
            }
            int i2 = 2;
            if (b2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, b2.b());
            }
        }
    }

    class e extends g0<d> {
        e(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithTrick` WHERE `locale_lessonId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (d)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, d d2) {
            String str;
            String obj4;
            int i = 1;
            if (d2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, d2.a());
            }
            int i2 = 2;
            if (d2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, d2.b());
            }
        }
    }

    class f extends g0<c> {
        f(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithTask` WHERE `locale_lessonId` = ? AND `locale_taskId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (c)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, c c2) {
            String str;
            String obj4;
            int i = 1;
            if (c2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, c2.a());
            }
            int i2 = 2;
            if (c2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, c2.b());
            }
        }
    }

    class g extends g0<e> {
        g(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleWithExams` WHERE `locale_moduleId` = ? AND `locale_trickId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (e)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, e e2) {
            String str;
            String obj4;
            int i = 1;
            if (e2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, e2.a());
            }
            int i2 = 2;
            if (e2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, e2.b());
            }
        }
    }

    class h extends g0<f> {
        h(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleWithLessons` WHERE `locale_moduleId` = ? AND `locale_lessonId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (f)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, f f2) {
            String str;
            String obj4;
            int i = 1;
            if (f2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, f2.b());
            }
            int i2 = 2;
            if (f2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, f2.a());
            }
        }
    }

    class i extends g0<h> {
        i(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ProgramWithModules` WHERE `locale_programId` = ? AND `locale_moduleId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (h)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, h h2) {
            String str;
            String obj4;
            int i = 1;
            if (h2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, h2.b());
            }
            int i2 = 2;
            if (h2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, h2.a());
            }
        }
    }

    class k0 extends h0<b> {
        k0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithQuestion` (`locale_lessonId`,`locale_questionId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (b)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, b b2) {
            String str;
            String obj4;
            int i = 1;
            if (b2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, b2.a());
            }
            int i2 = 2;
            if (b2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, b2.b());
            }
        }
    }

    class k extends h0<LessonEntity> {
        k(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonEntity` (`lessonId`,`index`,`locale`,`programId`,`updatedAt`,`locale_lessonId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (LessonEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, LessonEntity lessonEntity2) {
            String lessonId;
            String locale;
            String programId;
            String obj5;
            int i3 = 1;
            if (lessonEntity2.getLessonId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, lessonEntity2.getLessonId());
            }
            k.u0(2, (long)index);
            int i4 = 3;
            if (lessonEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, lessonEntity2.getLocale());
            }
            int i5 = 4;
            if (lessonEntity2.getProgramId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, lessonEntity2.getProgramId());
            }
            k.u0(5, lessonEntity2.getUpdatedAt());
            int i6 = 6;
            if (lessonEntity2.getLocale_lessonId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, lessonEntity2.getLocale_lessonId());
            }
        }
    }

    class l0 extends h0<d> {
        l0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithTrick` (`locale_lessonId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (d)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, d d2) {
            String str;
            String obj4;
            int i = 1;
            if (d2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, d2.a());
            }
            int i2 = 2;
            if (d2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, d2.b());
            }
        }
    }

    class m0 extends h0<c> {
        m0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithTask` (`locale_lessonId`,`locale_taskId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (c)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, c c2) {
            String str;
            String obj4;
            int i = 1;
            if (c2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, c2.a());
            }
            int i2 = 2;
            if (c2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, c2.b());
            }
        }
    }

    class n0 extends h0<e> {
        n0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleWithExams` (`locale_moduleId`,`locale_trickId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (e)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, e e2) {
            String str;
            String obj4;
            int i = 1;
            if (e2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, e2.a());
            }
            int i2 = 2;
            if (e2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, e2.b());
            }
        }
    }

    class o0 extends h0<f> {
        o0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleWithLessons` (`locale_moduleId`,`locale_lessonId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (f)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, f f2) {
            String str;
            String obj4;
            int i = 1;
            if (f2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, f2.b());
            }
            int i2 = 2;
            if (f2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, f2.a());
            }
        }
    }

    class p0 extends h0<h> {
        p0(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ProgramWithModules` (`locale_programId`,`locale_moduleId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (h)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, h h2) {
            String str;
            String obj4;
            int i = 1;
            if (h2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, h2.b());
            }
            int i2 = 2;
            if (h2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, h2.a());
            }
        }
    }

    class t extends h0<ModuleEntity> {
        t(e.a.a.a.b.b.f0 f0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleEntity` (`moduleId`,`index`,`name`,`locale`,`updatedAt`,`locale_moduleId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (ModuleEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, ModuleEntity moduleEntity2) {
            String moduleId;
            String name;
            String locale;
            String obj5;
            int i3 = 1;
            if (moduleEntity2.getModuleId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, moduleEntity2.getModuleId());
            }
            k.u0(2, (long)index);
            int i4 = 3;
            if (moduleEntity2.getName() == null) {
                k.k1(i4);
            } else {
                k.D(i4, moduleEntity2.getName());
            }
            int i5 = 4;
            if (moduleEntity2.getLocale() == null) {
                k.k1(i5);
            } else {
                k.D(i5, moduleEntity2.getLocale());
            }
            k.u0(5, moduleEntity2.getUpdatedAt());
            int i6 = 6;
            if (moduleEntity2.getLocale_moduleId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, moduleEntity2.getLocale_moduleId());
            }
        }
    }
    public f0(ContentDatabase contentDatabase) {
        super(contentDatabase);
        a aVar = new a();
        this.h = aVar;
        this.d = contentDatabase;
        f0.k kVar = new f0.k(this, contentDatabase);
        this.e = kVar;
        f0.t tVar = new f0.t(this, contentDatabase);
        this.f = tVar;
        f0.b0 b0Var = new f0.b0(this, contentDatabase);
        this.g = b0Var;
        f0.k0 k0Var = new f0.k0(this, contentDatabase);
        this.i = k0Var;
        f0.l0 l0Var = new f0.l0(this, contentDatabase);
        this.j = l0Var;
        f0.m0 m0Var = new f0.m0(this, contentDatabase);
        this.k = m0Var;
        f0.n0 n0Var = new f0.n0(this, contentDatabase);
        this.l = n0Var;
        f0.o0 o0Var = new f0.o0(this, contentDatabase);
        this.m = o0Var;
        f0.p0 p0Var = new f0.p0(this, contentDatabase);
        this.n = p0Var;
        f0.a aVar2 = new f0.a(this, contentDatabase);
        f0.b bVar = new f0.b(this, contentDatabase);
        f0.c cVar = new f0.c(this, contentDatabase);
        f0.d dVar = new f0.d(this, contentDatabase);
        this.o = dVar;
        f0.e eVar = new f0.e(this, contentDatabase);
        this.p = eVar;
        f0.f fVar = new f0.f(this, contentDatabase);
        this.q = fVar;
        f0.g gVar = new f0.g(this, contentDatabase);
        this.r = gVar;
        f0.h hVar = new f0.h(this, contentDatabase);
        this.s = hVar;
        f0.i iVar = new f0.i(this, contentDatabase);
        this.t = iVar;
    }

    private void I(a<String, a> a) {
        a aVar;
        int articleEntity2;
        String string10;
        Integer valueOf;
        String string4;
        String string;
        String string7;
        String string3;
        String string8;
        int arrayList2;
        int string5;
        int string9;
        int i9;
        Object next;
        boolean arrayList;
        int i8;
        int i4;
        boolean null;
        a aVar2;
        int i7;
        int i;
        int i2;
        int i5;
        int i3;
        boolean null2;
        boolean string2;
        String string6;
        ArticleEntity articleEntity;
        int i6;
        String str4;
        String str7;
        int int;
        Integer num;
        String str5;
        String str6;
        String str;
        long long;
        String str3;
        String str2;
        final Object obj2 = this;
        final Throwable obj = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i10 = 999;
        articleEntity2 = 0;
        arrayList2 = 0;
        if (a.size() > i10) {
            aVar = new a(i10);
            i8 = i9;
            while (i9 < a.size()) {
                aVar.put((String)obj.j(i9), arrayList2);
                i9++;
                if (i8++ == i10) {
                }
                obj2.I(aVar);
                obj.putAll(aVar);
                aVar = new a(i10);
                i8 = articleEntity2;
            }
            if (i8 > 0) {
                obj2.I(aVar);
                obj.putAll(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `ArticleEntity`.`articleId` AS `articleId`,`ArticleEntity`.`title` AS `title`,`ArticleEntity`.`text` AS `text`,`ArticleEntity`.`readingTime` AS `readingTime`,`ArticleEntity`.`sortOrder` AS `sortOrder`,`ArticleEntity`.`categoryId` AS `categoryId`,`ArticleEntity`.`image` AS `image`,`ArticleEntity`.`locale` AS `locale`,`ArticleEntity`.`updatedAt` AS `updatedAt`,`ArticleEntity`.`locale_articleId` AS `locale_articleId`,`ArticleEntity`.`textHtml` AS `textHtml`,_junction.`locale_questionId` FROM `QuestionWithArticle` AS _junction INNER JOIN `ArticleEntity` ON (_junction.`locale_articleId` = `ArticleEntity`.`locale_articleId`) WHERE _junction.`locale_questionId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += articleEntity2);
        Iterator iterator = keySet.iterator();
        int i12 = 1;
        string5 = i12;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(string5, (String)next);
            string5++;
            x0Var.k1(string5);
        }
        Cursor cursor = c.c(obj2.d, x0Var, i12, arrayList2);
        a aVar3 = new a();
        int i15 = 9;
        while (cursor.moveToNext()) {
            string5 = cursor.getString(i15);
            if (!(ArrayList)aVar3.get(string5)) {
            }
            i15 = 9;
            arrayList = new ArrayList();
            aVar3.put(string5, arrayList);
        }
        cursor.moveToPosition(-1);
        obj2.J(aVar3);
        while (cursor.moveToNext()) {
            string9 = cursor.getString(11);
            if (obj.containsKey(string9)) {
            } else {
            }
            i4 = articleEntity2;
            articleEntity2 = i4;
            arrayList2 = 0;
            int i16 = 8;
            i7 = 3;
            i = 10;
            i2 = 7;
            i5 = 6;
            i3 = 5;
            int i13 = 4;
            string10 = 2;
            if (cursor.isNull(articleEntity2) && cursor.isNull(i12) && cursor.isNull(string10) && cursor.isNull(i7) && cursor.isNull(i13) && cursor.isNull(i3) && cursor.isNull(i5) && cursor.isNull(i2) && cursor.isNull(i16) && cursor.isNull(i15)) {
            } else {
            }
            i4 = 0;
            if (cursor.isNull(i4)) {
            } else {
            }
            i6 = string2;
            if (cursor.isNull(i12)) {
            } else {
            }
            str4 = string6;
            if (cursor.isNull(string10)) {
            } else {
            }
            str7 = string10;
            if (cursor.isNull(i13)) {
            } else {
            }
            num = valueOf;
            if (cursor.isNull(i3)) {
            } else {
            }
            str5 = string4;
            if (cursor.isNull(i5)) {
            } else {
            }
            str6 = string;
            if (cursor.isNull(i2)) {
            } else {
            }
            str = string7;
            if (cursor.isNull(i15)) {
            } else {
            }
            str3 = string3;
            if (cursor.isNull(i)) {
            } else {
            }
            str2 = string8;
            super(i6, str4, str7, cursor.getInt(i7), num, str5, str6, str, cursor.getLong(i16), obj27, str3, str2);
            if ((ArrayList)aVar3.get(cursor.getString(i15)) == null) {
            }
            aVar2 = new a(articleEntity2, arrayList2);
            obj.put(string9, aVar2);
            arrayList2 = new ArrayList();
            str2 = 0;
            str3 = 0;
            str = 0;
            str6 = 0;
            str5 = 0;
            num = 0;
            str7 = 0;
            str4 = 0;
            i6 = 0;
            if (cursor.isNull(i12)) {
            } else {
            }
            if (cursor.isNull(string10)) {
            } else {
            }
            if (cursor.isNull(i7)) {
            } else {
            }
            if (cursor.isNull(i13)) {
            } else {
            }
            if (cursor.isNull(i3)) {
            } else {
            }
            if (cursor.isNull(i5)) {
            } else {
            }
            if (cursor.isNull(i2)) {
            } else {
            }
            if (cursor.isNull(i16)) {
            } else {
            }
            if (cursor.isNull(i15)) {
            } else {
            }
            if (!cursor.isNull(i)) {
            } else {
            }
            articleEntity2 = 0;
            i4 = 0;
        }
        cursor.close();
    }

    private void J(a<String, ArrayList<ArticleTagEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i3;
        int i;
        Object next;
        boolean articleTagEntity;
        String string;
        String string4;
        String string3;
        String string2;
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
            i = i2;
            while (i2 < a.size()) {
                aVar.put((String)a.j(i2), (ArrayList)a.n(i2));
                i2++;
                if (i++ == i5) {
                }
                J(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                J(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `ArticleTagEntity`.`hidden` AS `hidden`,`ArticleTagEntity`.`tagId` AS `tagId`,`ArticleTagEntity`.`locale` AS `locale`,`ArticleTagEntity`.`name` AS `name`,`ArticleTagEntity`.`updatedAt` AS `updatedAt`,`ArticleTagEntity`.`locale_tagId` AS `locale_tagId`,_junction.`locale_articleId` FROM `ArticleWithTags` AS _junction INNER JOIN `ArticleTagEntity` ON (_junction.`locale_tagId` = `ArticleTagEntity`.`locale_tagId`) WHERE _junction.`locale_articleId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i3 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i3, (String)next);
            i3++;
            x0Var.k1(i3);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.d, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(6));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.getInt(i8) != 0) {
            } else {
            }
            obj2 = i8;
            if (cursor.isNull(i7)) {
            } else {
            }
            str2 = string;
            string4 = 2;
            if (cursor.isNull(string4)) {
            } else {
            }
            str3 = string4;
            string3 = 3;
            if (cursor.isNull(string3)) {
            } else {
            }
            str4 = string3;
            string2 = 5;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            super(obj2, str2, str3, str4, cursor.getLong(4), obj12, str);
            (ArrayList)x0Var.add(articleTagEntity);
            str = i9;
            str4 = i9;
            str3 = i9;
            str2 = i9;
            obj2 = i7;
        }
        cursor.close();
    }

    private void K(a<String, ArrayList<b>> a) {
        a aVar;
        int i3;
        int i2;
        int i5;
        Object next;
        Object obj;
        Object string;
        int i6;
        Object arrayList;
        Object lessonEntity;
        boolean null;
        boolean string5;
        boolean string4;
        boolean string3;
        String string2;
        Object arrayList3;
        Object obj2;
        Object arrayList2;
        Object bVar;
        int i;
        int int;
        int i4;
        int i7;
        long long;
        String str;
        final Object obj4 = this;
        final Throwable obj3 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i8 = 999;
        final int i11 = 0;
        if (a.size() > i8) {
            aVar = new a(i8);
            i5 = i3;
            while (i3 < a.size()) {
                aVar.put((String)obj3.j(i3), (ArrayList)obj3.n(i3));
                i3++;
                if (i5++ == i8) {
                }
                obj4.K(aVar);
                aVar = new a(i8);
                i5 = i11;
            }
            if (i5 > 0) {
                obj4.K(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `LessonEntity`.`lessonId` AS `lessonId`,`LessonEntity`.`index` AS `index`,`LessonEntity`.`locale` AS `locale`,`LessonEntity`.`programId` AS `programId`,`LessonEntity`.`updatedAt` AS `updatedAt`,`LessonEntity`.`locale_lessonId` AS `locale_lessonId`,_junction.`locale_moduleId` FROM `ModuleWithLessons` AS _junction INNER JOIN `LessonEntity` ON (_junction.`locale_lessonId` = `LessonEntity`.`locale_lessonId`) WHERE _junction.`locale_moduleId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i11);
        Iterator iterator = keySet.iterator();
        int i10 = 1;
        i2 = i10;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i2, (String)next);
            i2++;
            x0Var.k1(i2);
        }
        int i12 = 0;
        Cursor cursor = c.c(obj4.d, x0Var, i10, i12);
        a aVar2 = new a();
        a aVar3 = new a();
        a aVar4 = new a();
        int i14 = 5;
        while (cursor.moveToNext()) {
            String string8 = cursor.getString(i14);
            if ((ArrayList)aVar2.get(string8) == null) {
            }
            aVar3.put(cursor.getString(i14), i12);
            string = cursor.getString(i14);
            if ((ArrayList)aVar4.get(string) == null) {
            }
            i14 = 5;
            arrayList = new ArrayList();
            aVar4.put(string, arrayList);
            lessonEntity = new ArrayList();
            aVar2.put(string8, lessonEntity);
        }
        cursor.moveToPosition(-1);
        obj4.N(aVar2);
        obj4.M(aVar3);
        obj4.O(aVar4);
        while (cursor.moveToNext()) {
            i6 = obj3.get(cursor.getString(6));
            if ((ArrayList)i6 != 0) {
            }
            int i15 = 4;
            int i16 = 3;
            int i17 = 2;
            if (cursor.isNull(i11) && cursor.isNull(i10) && cursor.isNull(i17) && cursor.isNull(i16) && cursor.isNull(i15)) {
            } else {
            }
            if (cursor.isNull(i11)) {
            } else {
            }
            i = string5;
            if (cursor.isNull(i17)) {
            } else {
            }
            i4 = string4;
            if (cursor.isNull(i16)) {
            } else {
            }
            i7 = string3;
            if (cursor.isNull(i14)) {
            } else {
            }
            str = string2;
            super(i, cursor.getInt(i10), i4, i7, cursor.getLong(i15), obj21, str);
            if ((ArrayList)aVar2.get(cursor.getString(i14)) == null) {
            }
            if ((ArrayList)aVar4.get(cursor.getString(i14)) == null) {
            }
            bVar = new b(lessonEntity, arrayList3, (f)aVar3.get(cursor.getString(i14)), arrayList2);
            (ArrayList)i6.add(bVar);
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            str = i12;
            i7 = i12;
            i4 = i12;
            i = i12;
            if (cursor.isNull(i10)) {
            } else {
            }
            if (cursor.isNull(i17)) {
            } else {
            }
            if (cursor.isNull(i16)) {
            } else {
            }
            if (cursor.isNull(i15)) {
            } else {
            }
            if (!cursor.isNull(i14)) {
            } else {
            }
            lessonEntity = i12;
        }
        cursor.close();
    }

    private void L(a<String, ArrayList<c>> a) {
        a aVar;
        int i5;
        int i7;
        int i4;
        Object next;
        Object string5;
        int i6;
        Object arrayList3;
        Object moduleEntity;
        boolean null;
        boolean string2;
        boolean string3;
        boolean string;
        String string4;
        Object arrayList;
        Object arrayList2;
        c cVar;
        ModuleEntity moduleEntity2;
        int i2;
        int int;
        int i;
        int i3;
        long long;
        String str;
        final Object obj2 = this;
        final Throwable obj = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i8 = 999;
        final int i11 = 0;
        if (a.size() > i8) {
            aVar = new a(i8);
            i4 = i5;
            while (i5 < a.size()) {
                aVar.put((String)obj.j(i5), (ArrayList)obj.n(i5));
                i5++;
                if (i4++ == i8) {
                }
                obj2.L(aVar);
                aVar = new a(i8);
                i4 = i11;
            }
            if (i4 > 0) {
                obj2.L(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `ModuleEntity`.`moduleId` AS `moduleId`,`ModuleEntity`.`index` AS `index`,`ModuleEntity`.`name` AS `name`,`ModuleEntity`.`locale` AS `locale`,`ModuleEntity`.`updatedAt` AS `updatedAt`,`ModuleEntity`.`locale_moduleId` AS `locale_moduleId`,_junction.`locale_programId` FROM `ProgramWithModules` AS _junction INNER JOIN `ModuleEntity` ON (_junction.`locale_moduleId` = `ModuleEntity`.`locale_moduleId`) WHERE _junction.`locale_programId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i11);
        Iterator iterator = keySet.iterator();
        int i10 = 1;
        i7 = i10;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i7, (String)next);
            i7++;
            x0Var.k1(i7);
        }
        int i12 = 0;
        Cursor cursor = c.c(obj2.d, x0Var, i10, i12);
        a aVar2 = new a();
        a aVar3 = new a();
        int i14 = 5;
        while (cursor.moveToNext()) {
            String string8 = cursor.getString(i14);
            if ((ArrayList)aVar2.get(string8) == null) {
            }
            string5 = cursor.getString(i14);
            if ((ArrayList)aVar3.get(string5) == null) {
            }
            i14 = 5;
            arrayList3 = new ArrayList();
            aVar3.put(string5, arrayList3);
            moduleEntity = new ArrayList();
            aVar2.put(string8, moduleEntity);
        }
        cursor.moveToPosition(-1);
        obj2.K(aVar2);
        obj2.P(aVar3);
        while (cursor.moveToNext()) {
            i6 = obj.get(cursor.getString(6));
            if ((ArrayList)i6 != 0) {
            }
            int i15 = 4;
            int i16 = 3;
            int i17 = 2;
            if (cursor.isNull(i11) && cursor.isNull(i10) && cursor.isNull(i17) && cursor.isNull(i16) && cursor.isNull(i15)) {
            } else {
            }
            if (cursor.isNull(i11)) {
            } else {
            }
            i2 = string2;
            if (cursor.isNull(i17)) {
            } else {
            }
            i = string3;
            if (cursor.isNull(i16)) {
            } else {
            }
            i3 = string;
            if (cursor.isNull(i14)) {
            } else {
            }
            str = string4;
            super(i2, cursor.getInt(i10), i, i3, cursor.getLong(i15), obj20, str);
            if ((ArrayList)aVar2.get(cursor.getString(i14)) == null) {
            }
            if ((ArrayList)aVar3.get(cursor.getString(i14)) == null) {
            }
            cVar = new c(moduleEntity, arrayList, arrayList2);
            (ArrayList)i6.add(cVar);
            arrayList2 = new ArrayList();
            arrayList = new ArrayList();
            str = i12;
            i3 = i12;
            i = i12;
            i2 = i12;
            if (cursor.isNull(i10)) {
            } else {
            }
            if (cursor.isNull(i17)) {
            } else {
            }
            if (cursor.isNull(i16)) {
            } else {
            }
            if (cursor.isNull(i15)) {
            } else {
            }
            if (!cursor.isNull(i14)) {
            } else {
            }
            moduleEntity = i12;
        }
        cursor.close();
    }

    private void M(a<String, f> a) {
        a aVar2;
        int i4;
        int string7;
        int string;
        int i2;
        Object next;
        boolean next2;
        Object questionEntity2;
        boolean null;
        String string5;
        String string3;
        String string2;
        String string4;
        boolean string6;
        Object obj;
        f fVar;
        a aVar;
        int i;
        QuestionEntity questionEntity;
        String str2;
        String str;
        String str3;
        List list;
        int int;
        long long;
        int i3;
        final Object obj3 = this;
        final Throwable obj2 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        final int i9 = 0;
        if (a.size() > i5) {
            aVar2 = new a(i5);
            i2 = i4;
            while (i4 < a.size()) {
                aVar2.put((String)obj2.j(i4), i9);
                i4++;
                if (i2++ == i5) {
                }
                obj3.M(aVar2);
                obj2.putAll(aVar2);
                aVar2 = new a(i5);
                i2 = i8;
            }
            if (i2 > 0) {
                obj3.M(aVar2);
                obj2.putAll(aVar2);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `QuestionEntity`.`questionId` AS `questionId`,`QuestionEntity`.`locale` AS `locale`,`QuestionEntity`.`question` AS `question`,`QuestionEntity`.`answers` AS `answers`,`QuestionEntity`.`correctAnswer` AS `correctAnswer`,`QuestionEntity`.`updatedAt` AS `updatedAt`,`QuestionEntity`.`locale_questionId` AS `locale_questionId`,_junction.`locale_lessonId` FROM `LessonWithQuestion` AS _junction INNER JOIN `QuestionEntity` ON (_junction.`locale_questionId` = `QuestionEntity`.`locale_questionId`) WHERE _junction.`locale_lessonId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        string7 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(string7, (String)next);
            string7++;
            x0Var.k1(string7);
        }
        Cursor cursor = c.c(obj3.d, x0Var, i7, i9);
        a aVar3 = new a();
        next2 = true;
        while (cursor.moveToNext()) {
            aVar3.put(cursor.getString(next2), i9);
            next2 = true;
        }
        cursor.moveToPosition(-1);
        obj3.I(aVar3);
        while (cursor.moveToNext()) {
            string = cursor.getString(7);
            if (obj2.containsKey(string)) {
            }
            int i11 = 5;
            int i12 = 4;
            aVar = 3;
            i = 2;
            if (cursor.isNull(i8) && cursor.isNull(i7) && cursor.isNull(i) && cursor.isNull(aVar) && cursor.isNull(i12) && cursor.isNull(i11)) {
            } else {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            str2 = string5;
            if (cursor.isNull(i7)) {
            } else {
            }
            str = string3;
            if (cursor.isNull(i)) {
            } else {
            }
            str3 = string2;
            if (cursor.isNull(aVar)) {
            } else {
            }
            string4 = cursor.getString(aVar);
            if (cursor.isNull(next2)) {
            } else {
            }
            i3 = string6;
            super(str2, str, str3, obj3.h.j(string4), cursor.getInt(i12), cursor.getLong(i11), obj21, i3);
            fVar = new f(questionEntity2, (a)aVar3.get(cursor.getString(next2)));
            obj2.put(string, fVar);
            i3 = i9;
            string4 = i9;
            str3 = i9;
            str = i9;
            str2 = i9;
            if (cursor.isNull(i7)) {
            } else {
            }
            if (cursor.isNull(i)) {
            } else {
            }
            if (cursor.isNull(aVar)) {
            } else {
            }
            if (cursor.isNull(i12)) {
            } else {
            }
            if (cursor.isNull(i11)) {
            } else {
            }
            if (!cursor.isNull(next2)) {
            } else {
            }
            questionEntity2 = i9;
        }
        cursor.close();
    }

    private void N(a<String, ArrayList<TaskEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i;
        int i3;
        Object next;
        boolean taskEntity;
        String string4;
        String string;
        String string2;
        String string3;
        Object obj;
        Object obj2;
        String str3;
        String str;
        long long;
        String str2;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i3 = i2;
            while (i2 < a.size()) {
                aVar.put((String)a.j(i2), (ArrayList)a.n(i2));
                i2++;
                if (i3++ == i5) {
                }
                N(aVar);
                aVar = new a(i5);
                i3 = i8;
            }
            if (i3 > 0) {
                N(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TaskEntity`.`taskId` AS `taskId`,`TaskEntity`.`text` AS `text`,`TaskEntity`.`locale` AS `locale`,`TaskEntity`.`updatedAt` AS `updatedAt`,`TaskEntity`.`locale_taskId` AS `locale_taskId`,_junction.`locale_lessonId` FROM `LessonWithTask` AS _junction INNER JOIN `TaskEntity` ON (_junction.`locale_taskId` = `TaskEntity`.`locale_taskId`) WHERE _junction.`locale_lessonId` IN (");
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
        Cursor cursor = c.c(this.d, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(5));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj2 = string4;
            if (cursor.isNull(i7)) {
            } else {
            }
            str3 = string;
            string2 = 2;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            string3 = 4;
            if (cursor.isNull(string3)) {
            } else {
            }
            str2 = string3;
            super(obj2, str3, str, cursor.getLong(3), obj11, str2);
            (ArrayList)x0Var.add(taskEntity);
            str2 = i9;
            str = i9;
            str3 = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    private void O(a<String, ArrayList<g>> a) {
        a aVar;
        int i8;
        int i4;
        int i14;
        int i11;
        int i3;
        int i;
        int i6;
        int i9;
        String string6;
        String string10;
        int i5;
        Object arrayList6;
        Object arrayList5;
        Object arrayList3;
        int i10;
        int gVar;
        String string2;
        Integer valueOf;
        String string3;
        Object arrayList7;
        int i18;
        Object next;
        int i17;
        Object obj6;
        Object obj4;
        String string5;
        int i13;
        Object arrayList4;
        int i15;
        Object arrayList;
        Object arrayList2;
        Object arrayList8;
        boolean null;
        boolean string4;
        boolean string;
        boolean string9;
        boolean null2;
        boolean string7;
        String string8;
        g gVar2;
        TrickEntity trickEntity;
        Object obj;
        Object obj5;
        Object obj2;
        Object obj3;
        TrickEntity null3;
        int i12;
        String str2;
        String str3;
        String str9;
        int i16;
        String str;
        Integer num2;
        Integer num;
        int i2;
        int i7;
        long long;
        String str5;
        String str4;
        String str6;
        String str8;
        String str7;
        List list;
        List list2;
        final Object obj8 = this;
        final Throwable obj7 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i19 = 999;
        i8 = 0;
        if (a.size() > i19) {
            aVar = new a(i19);
            i17 = i18;
            while (i18 < a.size()) {
                aVar.put((String)obj7.j(i18), (ArrayList)obj7.n(i18));
                i18++;
                if (i17++ == i19) {
                }
                obj8.O(aVar);
                aVar = new a(i19);
                i17 = i8;
            }
            if (i17 > 0) {
                obj8.O(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TrickEntity`.`trickId` AS `trickId`,`TrickEntity`.`name` AS `name`,`TrickEntity`.`image` AS `image`,`TrickEntity`.`categoryName` AS `categoryName`,`TrickEntity`.`categoryId` AS `categoryId`,`TrickEntity`.`examInstructions` AS `examInstructions`,`TrickEntity`.`examTimeLimit` AS `examTimeLimit`,`TrickEntity`.`sortOrder` AS `sortOrder`,`TrickEntity`.`isExam` AS `isExam`,`TrickEntity`.`hasProgress` AS `hasProgress`,`TrickEntity`.`updatedAt` AS `updatedAt`,`TrickEntity`.`videoId` AS `videoId`,`TrickEntity`.`videoThumbnail` AS `videoThumbnail`,`TrickEntity`.`description` AS `description`,`TrickEntity`.`locale` AS `locale`,`TrickEntity`.`locale_trickId` AS `locale_trickId`,`TrickEntity`.`imageStepOrder` AS `imageStepOrder`,`TrickEntity`.`videoStepOder` AS `videoStepOder`,_junction.`locale_lessonId` FROM `LessonWithTrick` AS _junction INNER JOIN `TrickEntity` ON (_junction.`locale_trickId` = `TrickEntity`.`locale_trickId`) WHERE _junction.`locale_lessonId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i21 = 1;
        i10 = i21;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i10, (String)next);
            i10++;
            x0Var.k1(i10);
        }
        Cursor cursor = c.c(obj8.d, x0Var, i21, 0);
        a aVar2 = new a();
        a aVar4 = new a();
        a aVar5 = new a();
        a aVar6 = new a();
        i15 = 15;
        while (cursor.moveToNext()) {
            String string20 = cursor.getString(i15);
            if ((ArrayList)aVar2.get(string20) == null) {
            }
            String string21 = cursor.getString(i15);
            if ((ArrayList)aVar4.get(string21) == null) {
            }
            String string22 = cursor.getString(i15);
            if ((ArrayList)aVar5.get(string22) == null) {
            }
            string5 = cursor.getString(i15);
            if ((ArrayList)aVar6.get(string5) == null) {
            }
            i15 = 15;
            arrayList4 = new ArrayList();
            aVar6.put(string5, arrayList4);
            arrayList = new ArrayList();
            aVar5.put(string22, arrayList);
            arrayList8 = new ArrayList();
            aVar4.put(string21, arrayList8);
            arrayList2 = new ArrayList();
            aVar2.put(string20, arrayList2);
        }
        cursor.moveToPosition(-1);
        obj8.T(aVar2);
        obj8.Q(aVar4);
        obj8.R(aVar5);
        obj8.S(aVar6);
        while (cursor.moveToNext()) {
            i13 = obj7.get(cursor.getString(18));
            if ((ArrayList)i13 != 0) {
            } else {
            }
            arrayList = i8;
            i4 = i15;
            i15 = i4;
            i8 = arrayList;
            gVar = 0;
            int i22 = 7;
            i15 = 6;
            string2 = 5;
            string4 = 4;
            string = 3;
            string9 = 2;
            if (cursor.isNull(i8) && cursor.isNull(i21) && cursor.isNull(string9) && cursor.isNull(string) && cursor.isNull(string4) && cursor.isNull(string2) && cursor.isNull(i15) && cursor.isNull(i22) && cursor.isNull(8) && cursor.isNull(9) && cursor.isNull(10) && cursor.isNull(11) && cursor.isNull(12) && cursor.isNull(13) && cursor.isNull(14) && cursor.isNull(15) && cursor.isNull(16)) {
            } else {
            }
            arrayList = 0;
            if (cursor.isNull(arrayList)) {
            } else {
            }
            i12 = string7;
            if (cursor.isNull(i21)) {
            } else {
            }
            str2 = string8;
            if (cursor.isNull(string9)) {
            } else {
            }
            str3 = string9;
            if (cursor.isNull(string)) {
            } else {
            }
            str9 = string;
            if (cursor.isNull(string4)) {
            } else {
            }
            i16 = string4;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            if (cursor.isNull(i15)) {
            } else {
            }
            num2 = valueOf;
            if (cursor.isNull(i22)) {
            } else {
            }
            num = valueOf2;
            i14 = 8;
            if (cursor.getInt(i14) != 0) {
            } else {
            }
            i2 = arrayList;
            if (cursor.getInt(9) != 0) {
            } else {
            }
            i7 = arrayList;
            int i25 = 11;
            if (cursor.isNull(i25)) {
            } else {
            }
            str5 = string15;
            i11 = 12;
            if (cursor.isNull(i11)) {
            } else {
            }
            str4 = string14;
            i3 = 13;
            if (cursor.isNull(i3)) {
            } else {
            }
            str6 = string13;
            i = 14;
            if (cursor.isNull(i)) {
            } else {
            }
            str8 = string12;
            i6 = 15;
            if (cursor.isNull(i6)) {
            } else {
            }
            str7 = string3;
            i9 = 16;
            if (cursor.isNull(i9)) {
            } else {
            }
            string6 = cursor.getString(i9);
            int i26 = 17;
            if (cursor.isNull(i26)) {
            } else {
            }
            string10 = cursor.getString(i26);
            super(i12, str2, str3, str9, i16, str, num2, num, i2, i7, cursor.getLong(10), obj35, str5, str4, str6, str8, str7, obj8.h.j(string6), obj8.h.j(string10));
            trickEntity = trickEntity2;
            i5 = 15;
            if ((ArrayList)aVar2.get(cursor.getString(i5)) == null) {
            }
            if ((ArrayList)aVar4.get(cursor.getString(15)) == null) {
            }
            if ((ArrayList)aVar5.get(cursor.getString(15)) == null) {
            }
            if ((ArrayList)aVar6.get(cursor.getString(15)) == null) {
            }
            super(trickEntity, arrayList6, arrayList5, arrayList3, arrayList7);
            (ArrayList)i13.add(gVar);
            arrayList7 = new ArrayList();
            arrayList3 = new ArrayList();
            arrayList5 = new ArrayList();
            arrayList6 = new ArrayList();
            string10 = 0;
            string6 = 0;
            i9 = 16;
            str7 = 0;
            i6 = 15;
            str8 = 0;
            i = 14;
            str6 = 0;
            i3 = 13;
            str4 = 0;
            i11 = 12;
            str5 = 0;
            i7 = i21;
            i2 = i21;
            i14 = 8;
            num = 0;
            num2 = 0;
            str = 0;
            i16 = 0;
            str9 = 0;
            str3 = 0;
            str2 = 0;
            i12 = 0;
            if (cursor.isNull(i21)) {
            } else {
            }
            if (cursor.isNull(string9)) {
            } else {
            }
            if (cursor.isNull(string)) {
            } else {
            }
            if (cursor.isNull(string4)) {
            } else {
            }
            if (cursor.isNull(string2)) {
            } else {
            }
            if (cursor.isNull(i15)) {
            } else {
            }
            if (cursor.isNull(i22)) {
            } else {
            }
            if (cursor.isNull(8)) {
            } else {
            }
            if (cursor.isNull(9)) {
            } else {
            }
            if (cursor.isNull(10)) {
            } else {
            }
            if (cursor.isNull(11)) {
            } else {
            }
            if (cursor.isNull(12)) {
            } else {
            }
            if (cursor.isNull(13)) {
            } else {
            }
            if (cursor.isNull(14)) {
            } else {
            }
            if (cursor.isNull(15)) {
            } else {
            }
            if (cursor.isNull(16)) {
            } else {
            }
            if (!cursor.isNull(17)) {
            } else {
            }
            i5 = 15;
            arrayList = 0;
            trickEntity = 0;
        }
        cursor.close();
    }

    private void P(a<String, ArrayList<g>> a) {
        a aVar;
        int i16;
        int i10;
        int i3;
        int i8;
        int i15;
        int i;
        int i12;
        int i5;
        String string2;
        String string4;
        int i2;
        Object arrayList;
        Object arrayList7;
        Object arrayList4;
        int i6;
        int gVar2;
        String string8;
        Integer valueOf;
        String string7;
        Object arrayList8;
        int i11;
        Object next;
        int i4;
        Object obj5;
        Object obj6;
        String string9;
        int i18;
        Object arrayList3;
        int i14;
        Object arrayList6;
        Object arrayList5;
        Object arrayList2;
        boolean null2;
        boolean string10;
        boolean string3;
        boolean string5;
        boolean null3;
        boolean string6;
        String string;
        g gVar;
        TrickEntity trickEntity;
        Object obj4;
        Object obj3;
        Object obj;
        Object obj2;
        TrickEntity null;
        int i7;
        String str9;
        String str6;
        String str7;
        int i9;
        String str8;
        Integer num;
        Integer num2;
        int i17;
        int i13;
        long long;
        String str4;
        String str2;
        String str3;
        String str;
        String str5;
        List list;
        List list2;
        final Object obj8 = this;
        final Throwable obj7 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i19 = 999;
        i16 = 0;
        if (a.size() > i19) {
            aVar = new a(i19);
            i4 = i11;
            while (i11 < a.size()) {
                aVar.put((String)obj7.j(i11), (ArrayList)obj7.n(i11));
                i11++;
                if (i4++ == i19) {
                }
                obj8.P(aVar);
                aVar = new a(i19);
                i4 = i16;
            }
            if (i4 > 0) {
                obj8.P(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `TrickEntity`.`trickId` AS `trickId`,`TrickEntity`.`name` AS `name`,`TrickEntity`.`image` AS `image`,`TrickEntity`.`categoryName` AS `categoryName`,`TrickEntity`.`categoryId` AS `categoryId`,`TrickEntity`.`examInstructions` AS `examInstructions`,`TrickEntity`.`examTimeLimit` AS `examTimeLimit`,`TrickEntity`.`sortOrder` AS `sortOrder`,`TrickEntity`.`isExam` AS `isExam`,`TrickEntity`.`hasProgress` AS `hasProgress`,`TrickEntity`.`updatedAt` AS `updatedAt`,`TrickEntity`.`videoId` AS `videoId`,`TrickEntity`.`videoThumbnail` AS `videoThumbnail`,`TrickEntity`.`description` AS `description`,`TrickEntity`.`locale` AS `locale`,`TrickEntity`.`locale_trickId` AS `locale_trickId`,`TrickEntity`.`imageStepOrder` AS `imageStepOrder`,`TrickEntity`.`videoStepOder` AS `videoStepOder`,_junction.`locale_moduleId` FROM `ModuleWithExams` AS _junction INNER JOIN `TrickEntity` ON (_junction.`locale_trickId` = `TrickEntity`.`locale_trickId`) WHERE _junction.`locale_moduleId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0 x0Var = x0.e(sb.toString(), size3 += i16);
        Iterator iterator = keySet.iterator();
        int i21 = 1;
        i6 = i21;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i6, (String)next);
            i6++;
            x0Var.k1(i6);
        }
        Cursor cursor = c.c(obj8.d, x0Var, i21, 0);
        a aVar2 = new a();
        a aVar4 = new a();
        a aVar5 = new a();
        a aVar6 = new a();
        i14 = 15;
        while (cursor.moveToNext()) {
            String string20 = cursor.getString(i14);
            if ((ArrayList)aVar2.get(string20) == null) {
            }
            String string21 = cursor.getString(i14);
            if ((ArrayList)aVar4.get(string21) == null) {
            }
            String string22 = cursor.getString(i14);
            if ((ArrayList)aVar5.get(string22) == null) {
            }
            string9 = cursor.getString(i14);
            if ((ArrayList)aVar6.get(string9) == null) {
            }
            i14 = 15;
            arrayList3 = new ArrayList();
            aVar6.put(string9, arrayList3);
            arrayList6 = new ArrayList();
            aVar5.put(string22, arrayList6);
            arrayList2 = new ArrayList();
            aVar4.put(string21, arrayList2);
            arrayList5 = new ArrayList();
            aVar2.put(string20, arrayList5);
        }
        cursor.moveToPosition(-1);
        obj8.T(aVar2);
        obj8.Q(aVar4);
        obj8.R(aVar5);
        obj8.S(aVar6);
        while (cursor.moveToNext()) {
            i18 = obj7.get(cursor.getString(18));
            if ((ArrayList)i18 != 0) {
            } else {
            }
            arrayList6 = i16;
            i10 = i14;
            i14 = i10;
            i16 = arrayList6;
            gVar2 = 0;
            int i22 = 7;
            i14 = 6;
            string8 = 5;
            string10 = 4;
            string3 = 3;
            string5 = 2;
            if (cursor.isNull(i16) && cursor.isNull(i21) && cursor.isNull(string5) && cursor.isNull(string3) && cursor.isNull(string10) && cursor.isNull(string8) && cursor.isNull(i14) && cursor.isNull(i22) && cursor.isNull(8) && cursor.isNull(9) && cursor.isNull(10) && cursor.isNull(11) && cursor.isNull(12) && cursor.isNull(13) && cursor.isNull(14) && cursor.isNull(15) && cursor.isNull(16)) {
            } else {
            }
            arrayList6 = 0;
            if (cursor.isNull(arrayList6)) {
            } else {
            }
            i7 = string6;
            if (cursor.isNull(i21)) {
            } else {
            }
            str9 = string;
            if (cursor.isNull(string5)) {
            } else {
            }
            str6 = string5;
            if (cursor.isNull(string3)) {
            } else {
            }
            str7 = string3;
            if (cursor.isNull(string10)) {
            } else {
            }
            i9 = string10;
            if (cursor.isNull(string8)) {
            } else {
            }
            str8 = string8;
            if (cursor.isNull(i14)) {
            } else {
            }
            num = valueOf;
            if (cursor.isNull(i22)) {
            } else {
            }
            num2 = valueOf2;
            i3 = 8;
            if (cursor.getInt(i3) != 0) {
            } else {
            }
            i17 = arrayList6;
            if (cursor.getInt(9) != 0) {
            } else {
            }
            i13 = arrayList6;
            int i25 = 11;
            if (cursor.isNull(i25)) {
            } else {
            }
            str4 = string15;
            i8 = 12;
            if (cursor.isNull(i8)) {
            } else {
            }
            str2 = string14;
            i15 = 13;
            if (cursor.isNull(i15)) {
            } else {
            }
            str3 = string13;
            i = 14;
            if (cursor.isNull(i)) {
            } else {
            }
            str = string12;
            i12 = 15;
            if (cursor.isNull(i12)) {
            } else {
            }
            str5 = string7;
            i5 = 16;
            if (cursor.isNull(i5)) {
            } else {
            }
            string2 = cursor.getString(i5);
            int i26 = 17;
            if (cursor.isNull(i26)) {
            } else {
            }
            string4 = cursor.getString(i26);
            super(i7, str9, str6, str7, i9, str8, num, num2, i17, i13, cursor.getLong(10), obj35, str4, str2, str3, str, str5, obj8.h.j(string2), obj8.h.j(string4));
            trickEntity = trickEntity2;
            i2 = 15;
            if ((ArrayList)aVar2.get(cursor.getString(i2)) == null) {
            }
            if ((ArrayList)aVar4.get(cursor.getString(15)) == null) {
            }
            if ((ArrayList)aVar5.get(cursor.getString(15)) == null) {
            }
            if ((ArrayList)aVar6.get(cursor.getString(15)) == null) {
            }
            super(trickEntity, arrayList, arrayList7, arrayList4, arrayList8);
            (ArrayList)i18.add(gVar2);
            arrayList8 = new ArrayList();
            arrayList4 = new ArrayList();
            arrayList7 = new ArrayList();
            arrayList = new ArrayList();
            string4 = 0;
            string2 = 0;
            i5 = 16;
            str5 = 0;
            i12 = 15;
            str = 0;
            i = 14;
            str3 = 0;
            i15 = 13;
            str2 = 0;
            i8 = 12;
            str4 = 0;
            i13 = i21;
            i17 = i21;
            i3 = 8;
            num2 = 0;
            num = 0;
            str8 = 0;
            i9 = 0;
            str7 = 0;
            str6 = 0;
            str9 = 0;
            i7 = 0;
            if (cursor.isNull(i21)) {
            } else {
            }
            if (cursor.isNull(string5)) {
            } else {
            }
            if (cursor.isNull(string3)) {
            } else {
            }
            if (cursor.isNull(string10)) {
            } else {
            }
            if (cursor.isNull(string8)) {
            } else {
            }
            if (cursor.isNull(i14)) {
            } else {
            }
            if (cursor.isNull(i22)) {
            } else {
            }
            if (cursor.isNull(8)) {
            } else {
            }
            if (cursor.isNull(9)) {
            } else {
            }
            if (cursor.isNull(10)) {
            } else {
            }
            if (cursor.isNull(11)) {
            } else {
            }
            if (cursor.isNull(12)) {
            } else {
            }
            if (cursor.isNull(13)) {
            } else {
            }
            if (cursor.isNull(14)) {
            } else {
            }
            if (cursor.isNull(15)) {
            } else {
            }
            if (cursor.isNull(16)) {
            } else {
            }
            if (!cursor.isNull(17)) {
            } else {
            }
            i2 = 15;
            arrayList6 = 0;
            trickEntity = 0;
        }
        cursor.close();
    }

    private void Q(a<String, ArrayList<TrickStepEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i;
        int i3;
        Object next;
        boolean trickStepEntity;
        String string2;
        String string5;
        String string3;
        String string;
        String string4;
        Object obj;
        Object obj2;
        String str3;
        String str;
        String str2;
        long long;
        String str4;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i3 = i2;
            while (i2 < a.size()) {
                aVar.put((String)a.j(i2), (ArrayList)a.n(i2));
                i2++;
                if (i3++ == i5) {
                }
                Q(aVar);
                aVar = new a(i5);
                i3 = i8;
            }
            if (i3 > 0) {
                Q(aVar);
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
        Cursor cursor = c.c(this.d, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(6));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj2 = string2;
            if (cursor.isNull(i7)) {
            } else {
            }
            str3 = string5;
            string3 = 2;
            if (cursor.isNull(string3)) {
            } else {
            }
            str = string3;
            string = 3;
            if (cursor.isNull(string)) {
            } else {
            }
            str2 = string;
            string4 = 5;
            if (cursor.isNull(string4)) {
            } else {
            }
            str4 = string4;
            super(obj2, str3, str, str2, cursor.getLong(4), obj12, str4);
            (ArrayList)x0Var.add(trickStepEntity);
            str4 = i9;
            str2 = i9;
            str = i9;
            str3 = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    private void R(a<String, ArrayList<TrickTagEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i3;
        int i;
        Object next;
        boolean trickTagEntity;
        String string;
        String string2;
        String string4;
        String string3;
        Object obj;
        Object obj2;
        String str2;
        String str;
        long long;
        String str3;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i = i2;
            while (i2 < a.size()) {
                aVar.put((String)a.j(i2), (ArrayList)a.n(i2));
                i2++;
                if (i++ == i5) {
                }
                R(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                R(aVar);
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
        i3 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i3, (String)next);
            i3++;
            x0Var.k1(i3);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.d, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(5));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj2 = string;
            if (cursor.isNull(i7)) {
            } else {
            }
            str2 = string2;
            string4 = 2;
            if (cursor.isNull(string4)) {
            } else {
            }
            str = string4;
            string3 = 4;
            if (cursor.isNull(string3)) {
            } else {
            }
            str3 = string3;
            super(obj2, str2, str, cursor.getLong(3), obj11, str3);
            (ArrayList)x0Var.add(trickTagEntity);
            str3 = i9;
            str = i9;
            str2 = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    private void S(a<String, ArrayList<TrickVariationEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i3;
        int i;
        Object next;
        boolean trickVariationEntity;
        String string7;
        String string4;
        String string2;
        String string;
        String string3;
        String string6;
        String string5;
        Object null;
        Object obj;
        List list;
        String str6;
        String str;
        String str2;
        String str3;
        String str4;
        long long;
        String str5;
        final Object obj3 = this;
        final Throwable obj2 = a;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i = i2;
            while (i2 < a.size()) {
                aVar.put((String)obj2.j(i2), (ArrayList)obj2.n(i2));
                i2++;
                if (i++ == i5) {
                }
                obj3.S(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                obj3.S(aVar);
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
        i3 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i3, (String)next);
            i3++;
            x0Var.k1(i3);
        }
        int i9 = 0;
        Cursor cursor = c.c(obj3.d, x0Var, i8, i9);
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
            str6 = string4;
            string2 = 2;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            string = 3;
            if (cursor.isNull(string)) {
            } else {
            }
            str2 = string;
            string3 = 4;
            if (cursor.isNull(string3)) {
            } else {
            }
            str3 = string3;
            string6 = 5;
            if (cursor.isNull(string6)) {
            } else {
            }
            str4 = string6;
            string5 = 7;
            if (cursor.isNull(string5)) {
            } else {
            }
            str5 = string5;
            super(obj3.h.j(string7), str6, str, str2, str3, str4, cursor.getLong(6), obj17, str5);
            (ArrayList)x0Var.add(trickVariationEntity);
            str5 = i9;
            str4 = i9;
            str3 = i9;
            str2 = i9;
            str = i9;
            str6 = i9;
            string7 = i9;
        }
        cursor.close();
    }

    private void T(a<String, ArrayList<VideoStepEntity>> a) {
        a aVar;
        x0 x0Var;
        int i3;
        int i2;
        int i;
        Object next;
        boolean videoStepEntity;
        String string3;
        String string4;
        String string;
        String string2;
        Object obj;
        Object obj2;
        String str;
        String str2;
        int int;
        long long;
        String str3;
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
                T(aVar);
                aVar = new a(i5);
                i = i8;
            }
            if (i > 0) {
                T(aVar);
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
        Cursor cursor = c.c(this.d, x0Var, i8, i9);
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
            str = string4;
            string = 2;
            if (cursor.isNull(string)) {
            } else {
            }
            str2 = string;
            string2 = 5;
            if (cursor.isNull(string2)) {
            } else {
            }
            str3 = string2;
            super(obj2, str, str2, cursor.getInt(3), cursor.getLong(4), obj12, str3);
            (ArrayList)x0Var.add(videoStepEntity);
            str3 = i9;
            str2 = i9;
            str = i9;
            obj2 = i9;
        }
        cursor.close();
    }

    static a U(e.a.a.a.b.b.f0 f0) {
        return f0.h;
    }

    static u0 V(e.a.a.a.b.b.f0 f0) {
        return f0.d;
    }

    static h0 W(e.a.a.a.b.b.f0 f0) {
        return f0.n;
    }

    static g0 X(e.a.a.a.b.b.f0 f0) {
        return f0.o;
    }

    static g0 Y(e.a.a.a.b.b.f0 f0) {
        return f0.p;
    }

    static g0 Z(e.a.a.a.b.b.f0 f0) {
        return f0.q;
    }

    static g0 a0(e.a.a.a.b.b.f0 f0) {
        return f0.r;
    }

    static g0 b0(e.a.a.a.b.b.f0 f0) {
        return f0.s;
    }

    static g0 c0(e.a.a.a.b.b.f0 f0) {
        return f0.t;
    }

    static h0 d0(e.a.a.a.b.b.f0 f0) {
        return f0.e;
    }

    static void e0(e.a.a.a.b.b.f0 f0, a a2) {
        f0.L(a2);
    }

    static h0 f0(e.a.a.a.b.b.f0 f0) {
        return f0.f;
    }

    static h0 g0(e.a.a.a.b.b.f0 f0) {
        return f0.g;
    }

    static h0 h0(e.a.a.a.b.b.f0 f0) {
        return f0.i;
    }

    static h0 i0(e.a.a.a.b.b.f0 f0) {
        return f0.j;
    }

    static h0 j0(e.a.a.a.b.b.f0 f0) {
        return f0.k;
    }

    static h0 k0(e.a.a.a.b.b.f0 f0) {
        return f0.l;
    }

    static h0 l0(e.a.a.a.b.b.f0 f0) {
        return f0.m;
    }

    public static List<Class<?>> m0() {
        return Collections.emptyList();
    }

    public Object A(d[] dArr, d<? super w> d2) {
        f0.o oVar = new f0.o(this, dArr);
        return c0.b(this.d, true, oVar, d2);
    }

    public Object B(ModuleEntity[] moduleEntityArr, d<? super w> d2) {
        f0.l lVar = new f0.l(this, moduleEntityArr);
        return c0.b(this.d, true, lVar, d2);
    }

    public Object D(e[] eArr, d<? super w> d2) {
        f0.q qVar = new f0.q(this, eArr);
        return c0.b(this.d, true, qVar, d2);
    }

    public Object E(f[] fArr, d<? super w> d2) {
        f0.r rVar = new f0.r(this, fArr);
        return c0.b(this.d, true, rVar, d2);
    }

    public Object F(ProgramEntity[] programEntityArr, d<? super w> d2) {
        f0.m mVar = new f0.m(this, programEntityArr);
        return c0.b(this.d, true, mVar, d2);
    }

    public Object H(h[] hArr, d<? super w> d2) {
        f0.s sVar = new f0.s(this, hArr);
        return c0.b(this.d, true, sVar, d2);
    }

    public Object g(b[] bArr, d<? super w> d2) {
        f0.u uVar = new f0.u(this, bArr);
        return c0.b(this.d, true, uVar, d2);
    }

    public Object h(c[] cArr, d<? super w> d2) {
        f0.w wVar = new f0.w(this, cArr);
        return c0.b(this.d, true, wVar, d2);
    }

    public Object i(d[] dArr, d<? super w> d2) {
        f0.v vVar = new f0.v(this, dArr);
        return c0.b(this.d, true, vVar, d2);
    }

    public Object j(e[] eArr, d<? super w> d2) {
        f0.x xVar = new f0.x(this, eArr);
        return c0.b(this.d, true, xVar, d2);
    }

    public Object k(f[] fArr, d<? super w> d2) {
        f0.y yVar = new f0.y(this, fArr);
        return c0.b(this.d, true, yVar, d2);
    }

    public Object l(h[] hArr, d<? super w> d2) {
        f0.z zVar = new f0.z(this, hArr);
        return c0.b(this.d, true, zVar, d2);
    }

    public Object m(String string, d<? super List<e>> d2) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ProgramEntity WHERE locale = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.c0 c0Var = new f0.c0(this, x0Var);
        return c0.a(this.d, i, c.a(), c0Var, d2);
    }

    public Object n(d<? super Long> d) {
        final int i = 0;
        f0.a0 a0Var = new f0.a0(this, x0.e("SELECT updatedAt FROM ProgramEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.d, i, c.a(), a0Var, d);
    }

    public Object o(String string, d<? super List<b>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithQuestion WHERE locale_lessonId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.f0 f0Var = new f0.f0(this, x0Var);
        return c0.a(this.d, false, c.a(), f0Var, d2);
    }

    public Object p(String string, d<? super List<c>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithTask WHERE locale_lessonId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.g0 g0Var = new f0.g0(this, x0Var);
        return c0.a(this.d, false, c.a(), g0Var, d2);
    }

    public Object q(String string, d<? super List<d>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithTrick WHERE locale_lessonId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.e0 e0Var = new f0.e0(this, x0Var);
        return c0.a(this.d, false, c.a(), e0Var, d2);
    }

    public Object r(String string, String string2, d<? super List<e>> d3) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM ProgramEntity WHERE locale = ? AND programId = ?", i);
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
        f0.d0 d0Var = new f0.d0(this, x0Var);
        return c0.a(this.d, i2, c.a(), d0Var, d3);
    }

    public Object t(String string, d<? super List<e>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ModuleWithExams WHERE locale_moduleId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.h0 h0Var = new f0.h0(this, x0Var);
        return c0.a(this.d, false, c.a(), h0Var, d2);
    }

    public Object u(String string, d<? super List<f>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ModuleWithLessons WHERE locale_moduleId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.i0 i0Var = new f0.i0(this, x0Var);
        return c0.a(this.d, false, c.a(), i0Var, d2);
    }

    public Object v(String string, d<? super List<h>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ProgramWithModules WHERE locale_programId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        f0.j0 j0Var = new f0.j0(this, x0Var);
        return c0.a(this.d, false, c.a(), j0Var, d2);
    }

    public Object w(LessonEntity[] lessonEntityArr, d<? super w> d2) {
        f0.j jVar = new f0.j(this, lessonEntityArr);
        return c0.b(this.d, true, jVar, d2);
    }

    public Object y(b[] bArr, d<? super w> d2) {
        f0.n nVar = new f0.n(this, bArr);
        return c0.b(this.d, true, nVar, d2);
    }

    public Object z(c[] cArr, d<? super w> d2) {
        f0.p pVar = new f0.p(this, cArr);
        return c0.b(this.d, true, pVar, d2);
    }
}
