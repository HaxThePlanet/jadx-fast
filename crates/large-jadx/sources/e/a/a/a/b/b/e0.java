package e.a.a.a.b.b;

import android.app.ActivityManager.ProcessErrorStateInfo;
import app.dogo.android.persistencedb.room.database.ContentDatabase;
import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import e.a.a.a.b.c.b;
import e.a.a.a.b.c.c;
import e.a.a.a.b.c.d;
import e.a.a.a.b.c.e;
import e.a.a.a.b.c.f;
import e.a.a.a.b.c.h;
import e.a.a.a.b.d.b;
import e.a.a.a.b.d.c;
import e.a.a.a.b.d.e;
import e.a.a.a.b.d.f;
import e.a.a.a.b.d.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008 \u0008'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u000c2\u0012\u0010\u001d\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010!\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020#0\u001e\"\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J%\u0010%\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001e\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u000c2\u0006\u0010)\u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u0010,\u001a\u00020\u000c2\u0012\u0010-\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0\u001e\"\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J%\u00100\u001a\u00020\u000c2\u0012\u00101\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002020\u001e\"\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u000c2\u0006\u00105\u001a\u000206H§@ø\u0001\u0000¢\u0006\u0002\u00107J%\u00108\u001a\u00020\u000c2\u0012\u00109\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020:0\u001e\"\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00160=2\u0006\u0010>\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0013\u0010E\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u001f\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u001f0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010H\u001a\u0008\u0012\u0004\u0012\u00020#0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010I\u001a\u0008\u0012\u0004\u0012\u00020&0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J'\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00160=2\u0006\u0010>\u001a\u00020?2\u0006\u0010K\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010LJ!\u0010M\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?2\u0006\u0010K\u001a\u00020?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001f\u0010N\u001a\u0008\u0012\u0004\u0012\u00020.0=2\u0006\u0010O\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010P\u001a\u0008\u0012\u0004\u0012\u0002020=2\u0006\u0010O\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020:0=2\u0006\u0010R\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J%\u0010S\u001a\u00020\u000c2\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001a0\u001e\"\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010TJ\u0019\u0010U\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ%\u0010V\u001a\u00020\u000c2\u0012\u0010\u001d\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010W\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020#0\u001e\"\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J%\u0010X\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001e\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010Y\u001a\u00020\u000c2\u0012\u0010)\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020*0\u001e\"\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010ZJ\u0019\u0010[\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J%\u0010\\\u001a\u00020\u000c2\u0012\u0010-\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0\u001e\"\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J%\u0010]\u001a\u00020\u000c2\u0012\u00101\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002020\u001e\"\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J%\u0010^\u001a\u00020\u000c2\u0012\u00105\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002060\u001e\"\u000206H§@ø\u0001\u0000¢\u0006\u0002\u0010_J\u0019\u0010`\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010a\u001a\u00020\u000c2\u0012\u00109\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020:0\u001e\"\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006b", d2 = {"Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "", "contentDatabase", "Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "(Lapp/dogo/android/persistencedb/room/database/ContentDatabase;)V", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "taskDao", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "trickDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "cleanInsertFullLesson", "", "fullLessonEntity", "Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullModule", "moduleFullContent", "Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullProgram", "programFullEntity", "Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLesson", "lesson", "Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "(Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithQuestion", "lessonWithQuestion", "", "Lapp/dogo/android/persistencedb/room/junction/LessonWithQuestion;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithQuestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithTask", "lessonWithTrick", "Lapp/dogo/android/persistencedb/room/junction/LessonWithTask;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithTrick", "Lapp/dogo/android/persistencedb/room/junction/LessonWithTrick;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithTrick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModule", "module", "Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModuleWithExams", "moduleWithExam", "Lapp/dogo/android/persistencedb/room/junction/ModuleWithExams;", "([Lapp/dogo/android/persistencedb/room/junction/ModuleWithExams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModuleWithLessons", "moduleWithLesson", "Lapp/dogo/android/persistencedb/room/junction/ModuleWithLessons;", "([Lapp/dogo/android/persistencedb/room/junction/ModuleWithLessons;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProgram", "program", "Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProgramWithModules", "programWithModule", "Lapp/dogo/android/persistencedb/room/junction/ProgramWithModules;", "([Lapp/dogo/android/persistencedb/room/junction/ProgramWithModules;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocalisedPrograms", "", "locale", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestLessonTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestModuleTimestamp", "getLatestProgramTimestamp", "getLessonWithQuestionJunction", "locale_lessonId", "getLessonWithTaskJunction", "getLessonWithTrickJunction", "getLocalisedProgram", "programId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalisedProgramItem", "getModuleWithExamsJunction", "locale_moduleId", "getModuleWithLessonsJunction", "getProgramWithModulesJunction", "locale_programId", "insertLesson", "([Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLessonJunctions", "insertLessonWithQuestion", "insertLessonWithTask", "insertLessonWithTrick", "insertModule", "([Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertModuleJunctions", "insertModuleWithExams", "insertModuleWithLessons", "insertProgram", "([Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertProgramJunctions", "insertProgramWithModules", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class e0 {

    private final e.a.a.a.b.b.m0 a;
    private final e.a.a.a.b.b.i0 b;
    private final e.a.a.a.b.b.g0 c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {129, 131, 134, 136, 137}, m = "cleanInsertFullLesson")
    static final class a extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        a(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.a> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.d(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {163, 165, 168, 171}, m = "cleanInsertFullModule")
    static final class b extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        b(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.b> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.e(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {192, 194, 197}, m = "cleanInsertFullProgram")
    static final class c extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        c(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.c> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.f(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = 210, m = "getLocalisedProgramItem")
    static final class d extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        d(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.d> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.s(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {145, 146, 147, 153, 154, 155, 157, 158, 159}, m = "insertLessonJunctions")
    static final class e extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        e(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.e> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return e0.a(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {178, 179, 184, 185, 187, 188}, m = "insertModuleJunctions")
    static final class f extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        f(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.f> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return e0.b(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {202, 205, 206}, m = "insertProgramJunctions")
    static final class g extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final e.a.a.a.b.b.e0 this$0;
        g(e.a.a.a.b.b.e0 e0, d<? super e.a.a.a.b.b.e0.g> d2) {
            this.this$0 = e0;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return e0.c(this.this$0, 0, this);
        }
    }
    public e0(ContentDatabase contentDatabase) {
        n.f(contentDatabase, "contentDatabase");
        super();
        this.a = contentDatabase.M();
        this.b = contentDatabase.L();
        this.c = contentDatabase.K();
    }

    private final Object C(c c, d<? super w> d2) {
        boolean fVar2;
        int label2;
        int i2;
        Object obj2;
        Object l$2;
        Object label;
        int i3;
        Object l$1;
        Object l$02;
        int i;
        int locale_trickId;
        Object arrayList;
        Object l$0;
        int locale_lessonId;
        int locale_moduleId;
        Object fVar;
        Object obj3;
        Object obj;
        Object obj13;
        Object obj14;
        fVar2 = d2;
        label2 = fVar2.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof e0.f && label2 & i2 != 0) {
            fVar2 = d2;
            label2 = fVar2.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                fVar2.label = label2 -= i2;
            } else {
                fVar2 = new e0.f(this, d2);
            }
        } else {
        }
        obj14 = fVar2.result;
        Object obj4 = b.d();
        int i5 = 0;
        final String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i6 = 0;
        switch (label) {
            case 0:
                q.b(obj14);
                obj14 = c.b();
                int i7 = 10;
                ArrayList arrayList2 = new ArrayList(p.r(obj14, i7));
                obj14 = obj14.iterator();
                fVar = new f(c.c().getLocale_moduleId(), (b)obj14.next().a().getLocale_lessonId());
                arrayList2.add(fVar);
                obj14 = c.a();
                arrayList = new ArrayList(p.r(obj14, i7));
                obj14 = obj14.iterator();
                fVar = new e(c.c().getLocale_moduleId(), (g)obj14.next().d().getLocale_trickId());
                arrayList.add(fVar);
                fVar2.L$0 = this;
                fVar2.L$1 = c;
                fVar2.L$2 = arrayList2;
                fVar2.L$3 = arrayList;
                fVar2.label = 1;
                return obj4;
                l$1 = arrayList2;
                obj2 = this;
                fVar2.L$0 = obj2;
                fVar2.L$1 = l$1;
                fVar2.L$2 = arrayList;
                fVar2.L$3 = (List)obj14;
                fVar2.label = 2;
                obj13 = obj2.t(obj13.c().getLocale_moduleId(), fVar2);
                return obj4;
                obj14 = obj13;
                obj13 = obj3;
                l$0 = obj2;
                l$2 = obj;
                obj14 = p.E0((List)obj14, l$2);
                obj13 = p.E0(obj13, l$1).toArray(new f[i6]);
                Objects.requireNonNull(obj13, str);
                fVar2.L$0 = l$0;
                fVar2.L$1 = l$1;
                fVar2.L$2 = l$2;
                fVar2.L$3 = obj14;
                fVar2.label = 3;
                return obj4;
                obj13 = obj14;
                break;
            case 1:
                q.b(obj14);
                arrayList = obj13;
                obj13 = l$13;
                l$1 = l$22;
                obj2 = obj3;
                fVar2.L$0 = obj2;
                fVar2.L$1 = l$1;
                fVar2.L$2 = arrayList;
                fVar2.L$3 = (List)obj14;
                fVar2.label = 2;
                obj13 = obj2.t(obj13.c().getLocale_moduleId(), fVar2);
                return obj4;
                obj14 = obj13;
                obj13 = obj3;
                l$0 = obj2;
                l$2 = obj;
                obj14 = p.E0((List)obj14, l$2);
                obj13 = p.E0(obj13, l$1).toArray(new f[i6]);
                Objects.requireNonNull(obj13, str);
                fVar2.L$0 = l$0;
                fVar2.L$1 = l$1;
                fVar2.L$2 = l$2;
                fVar2.L$3 = obj14;
                fVar2.label = 3;
                return obj4;
                obj13 = obj14;
                break;
            case 2:
                obj13 = fVar2.L$3;
                l$2 = fVar2.L$2;
                l$1 = fVar2.L$1;
                l$0 = fVar2.L$0;
                q.b(obj14);
                obj14 = p.E0((List)obj14, l$2);
                obj13 = p.E0(obj13, l$1).toArray(new f[i6]);
                Objects.requireNonNull(obj13, str);
                fVar2.L$0 = l$0;
                fVar2.L$1 = l$1;
                fVar2.L$2 = l$2;
                fVar2.L$3 = obj14;
                fVar2.label = 3;
                return obj4;
                obj13 = obj14;
                break;
            case 3:
                obj13 = fVar2.L$3;
                l$2 = fVar2.L$2;
                l$1 = fVar2.L$1;
                l$0 = fVar2.L$0;
                q.b(obj14);
                break;
            case 4:
                obj13 = fVar2.L$2;
                q.b(obj14);
                obj14 = l$12;
                label = l$02;
                obj14 = obj14.toArray(new f[i6]);
                Objects.requireNonNull(obj14, str);
                fVar2.L$0 = label;
                fVar2.L$1 = obj13;
                fVar2.L$2 = i5;
                fVar2.label = 5;
                return obj4;
                obj13 = obj13.toArray(new e[i6]);
                Objects.requireNonNull(obj13, str);
                fVar2.L$0 = i5;
                fVar2.L$1 = i5;
                fVar2.label = 6;
                return obj4;
                return w.a;
            case 5:
                obj13 = fVar2.L$1;
                label = fVar2.L$0;
                q.b(obj14);
                obj13 = obj13.toArray(new e[i6]);
                Objects.requireNonNull(obj13, str);
                fVar2.L$0 = i5;
                fVar2.L$1 = i5;
                fVar2.label = 6;
                return obj4;
                return w.a;
            case 6:
                q.b(obj14);
                return w.a;
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        obj14 = l$2;
        Object obj5 = l$1;
        obj13 = obj13.toArray(new e[i6]);
        Objects.requireNonNull(obj13, str);
        fVar2.L$0 = l$0;
        fVar2.L$1 = obj5;
        fVar2.L$2 = obj14;
        fVar2.L$3 = i5;
        fVar2.label = 4;
        if (l$0.j((e[])Arrays.copyOf((e[])obj13, obj13.length), fVar2) == obj4) {
            return obj4;
        }
        obj13 = obj14;
        obj14 = obj5;
        label = l$0;
    }

    private final Object G(e e, d<? super w> d2) {
        boolean gVar;
        int label;
        int i;
        e.a.a.a.b.b.e0 label2;
        int i2;
        int length;
        boolean next;
        int locale_moduleId;
        String locale_programId;
        h hVar;
        Object obj12;
        int obj13;
        gVar = d2;
        label = gVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof e0.g && label & i != 0) {
            gVar = d2;
            label = gVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                gVar.label = label -= i;
            } else {
                gVar = new e0.g(this, d2);
            }
        } else {
        }
        obj13 = gVar.result;
        Object obj = b.d();
        label2 = gVar.label;
        String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i3 = 0;
        final int i4 = 3;
        final int i5 = 2;
        length = 1;
        if (label2 != 0) {
            if (label2 != length) {
                if (label2 != i5) {
                    if (label2 != i4) {
                    } else {
                        q.b(obj13);
                        return w.a;
                    }
                    obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj12;
                }
                obj12 = gVar.L$1;
                label2 = gVar.L$0;
                q.b(obj13);
            } else {
                obj12 = gVar.L$1;
                label2 = gVar.L$0;
                q.b(obj13);
                obj13 = p.E0((List)obj13, obj12).toArray(new h[i3]);
                Objects.requireNonNull(obj13, str);
                gVar.L$0 = label2;
                gVar.L$1 = obj12;
                gVar.label = i5;
                if (label2.l((h[])Arrays.copyOf((h[])obj13, obj13.length), gVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj13);
            obj13 = e.a();
            ArrayList arrayList = new ArrayList(p.r(obj13, 10));
            obj13 = obj13.iterator();
            for (c next2 : obj13) {
                hVar = new h(e.b().getLocale_programId(), next2.c().getLocale_moduleId());
                arrayList.add(hVar);
            }
            gVar.L$0 = this;
            gVar.L$1 = arrayList;
            gVar.label = length;
            if (v(e.b().getLocale_programId(), gVar) == obj) {
                return obj;
            }
            obj12 = arrayList;
            label2 = this;
        }
        obj12 = obj12.toArray(new h[i3]);
        Objects.requireNonNull(obj12, str);
        obj13 = 0;
        gVar.L$0 = obj13;
        gVar.L$1 = obj13;
        gVar.label = i4;
        if (label2.H((h[])Arrays.copyOf((h[])obj12, obj12.length), gVar) == obj) {
            return obj;
        }
    }

    public static final Object a(e.a.a.a.b.b.e0 e0, b b2, d d3) {
        return e0.x(b2, d3);
    }

    public static final Object b(e.a.a.a.b.b.e0 e0, c c2, d d3) {
        return e0.C(c2, d3);
    }

    public static final Object c(e.a.a.a.b.b.e0 e0, e e2, d d3) {
        return e0.G(e2, d3);
    }

    private final Object x(b b, d<? super w> d2) {
        boolean eVar;
        int label2;
        int i4;
        Object label;
        Object l$42;
        Object l$4;
        Object l$43;
        Object arrayList2;
        Object l$22;
        int i;
        Object l$02;
        int i2;
        Object l$1;
        Object l$3;
        Object l$32;
        Object bVar;
        Object l$0;
        Object l$23;
        int locale_trickId;
        Object l$2;
        Object next;
        int i3;
        Object l$12;
        int locale_taskId;
        Object l$13;
        Object arrayList;
        Object locale_lessonId;
        int dVar;
        Object obj;
        Object obj14;
        Object obj15;
        eVar = d2;
        label2 = eVar.label;
        i4 = Integer.MIN_VALUE;
        if (d2 instanceof e0.e && label2 & i4 != 0) {
            eVar = d2;
            label2 = eVar.label;
            i4 = Integer.MIN_VALUE;
            if (label2 & i4 != 0) {
                eVar.label = label2 -= i4;
            } else {
                eVar = new e0.e(this, d2);
            }
        } else {
        }
        obj15 = eVar.result;
        Object obj2 = b.d();
        i2 = 1;
        final String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i6 = 0;
        final int i7 = 0;
        switch (label) {
            case 0:
                q.b(obj15);
                bVar = new b(b.a().getLocale_lessonId(), b.b().b().getLocale_questionId());
                obj15 = b.c();
                int i9 = 10;
                arrayList2 = new ArrayList(p.r(obj15, i9));
                obj15 = obj15.iterator();
                dVar = new c(b.a().getLocale_lessonId(), (TaskEntity)obj15.next().getLocale_taskId());
                arrayList2.add(dVar);
                obj15 = b.d();
                arrayList = new ArrayList(p.r(obj15, i9));
                obj15 = obj15.iterator();
                dVar = new d(b.a().getLocale_lessonId(), (g)obj15.next().d().getLocale_trickId());
                arrayList.add(dVar);
                eVar.L$0 = this;
                eVar.L$1 = b;
                eVar.L$2 = bVar;
                eVar.L$3 = arrayList2;
                eVar.L$4 = arrayList;
                eVar.label = i2;
                return obj2;
                locale_lessonId = this;
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = obj14;
                eVar.L$2 = bVar;
                eVar.L$3 = arrayList2;
                eVar.L$4 = arrayList;
                eVar.L$5 = (List)obj15;
                eVar.label = 2;
                Object obj6 = locale_lessonId.p(obj14.a().getLocale_lessonId(), eVar);
                return obj2;
                l$13 = obj14;
                obj14 = obj15;
                obj15 = obj6;
                l$32 = arrayList2;
                l$4 = obj;
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$2;
                eVar.L$2 = l$32;
                eVar.L$3 = l$4;
                eVar.L$4 = obj14;
                eVar.L$5 = (List)obj15;
                eVar.label = 3;
                Object obj7 = locale_lessonId.q(l$13.a().getLocale_lessonId(), eVar);
                return obj2;
                l$43 = obj14;
                obj14 = obj15;
                obj15 = obj7;
                l$12 = l$2;
                l$23 = l$32;
                l$3 = obj;
                obj14 = p.E0(obj14, l$23);
                obj15 = p.E0((List)obj15, l$3);
                Object[] array2 = p.E0(l$43, p.b(l$12)).toArray(new b[i7]);
                Objects.requireNonNull(array2, str);
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$12;
                eVar.L$2 = l$23;
                eVar.L$3 = l$3;
                eVar.L$4 = obj14;
                eVar.L$5 = obj15;
                eVar.label = 4;
                return obj2;
                l$42 = obj14;
                obj14 = obj15;
                break;
            case 1:
                arrayList2 = eVar.L$3;
                bVar = eVar.L$2;
                q.b(obj15);
                locale_lessonId = l$03;
                arrayList = obj14;
                obj14 = next;
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = obj14;
                eVar.L$2 = bVar;
                eVar.L$3 = arrayList2;
                eVar.L$4 = arrayList;
                eVar.L$5 = (List)obj15;
                eVar.label = 2;
                obj6 = locale_lessonId.p(obj14.a().getLocale_lessonId(), eVar);
                return obj2;
                l$13 = obj14;
                obj14 = obj15;
                obj15 = obj6;
                l$32 = arrayList2;
                l$4 = obj;
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$2;
                eVar.L$2 = l$32;
                eVar.L$3 = l$4;
                eVar.L$4 = obj14;
                eVar.L$5 = (List)obj15;
                eVar.label = 3;
                obj7 = locale_lessonId.q(l$13.a().getLocale_lessonId(), eVar);
                return obj2;
                l$43 = obj14;
                obj14 = obj15;
                obj15 = obj7;
                l$12 = l$2;
                l$23 = l$32;
                l$3 = obj;
                obj14 = p.E0(obj14, l$23);
                obj15 = p.E0((List)obj15, l$3);
                array2 = p.E0(l$43, p.b(l$12)).toArray(new b[i7]);
                Objects.requireNonNull(array2, str);
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$12;
                eVar.L$2 = l$23;
                eVar.L$3 = l$3;
                eVar.L$4 = obj14;
                eVar.L$5 = obj15;
                eVar.label = 4;
                return obj2;
                l$42 = obj14;
                obj14 = obj15;
                break;
            case 2:
                obj14 = eVar.L$5;
                l$4 = eVar.L$4;
                l$32 = eVar.L$3;
                l$2 = eVar.L$2;
                l$13 = eVar.L$1;
                locale_lessonId = eVar.L$0;
                q.b(obj15);
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$2;
                eVar.L$2 = l$32;
                eVar.L$3 = l$4;
                eVar.L$4 = obj14;
                eVar.L$5 = (List)obj15;
                eVar.label = 3;
                obj7 = locale_lessonId.q(l$13.a().getLocale_lessonId(), eVar);
                return obj2;
                l$43 = obj14;
                obj14 = obj15;
                obj15 = obj7;
                l$12 = l$2;
                l$23 = l$32;
                l$3 = obj;
                obj14 = p.E0(obj14, l$23);
                obj15 = p.E0((List)obj15, l$3);
                array2 = p.E0(l$43, p.b(l$12)).toArray(new b[i7]);
                Objects.requireNonNull(array2, str);
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$12;
                eVar.L$2 = l$23;
                eVar.L$3 = l$3;
                eVar.L$4 = obj14;
                eVar.L$5 = obj15;
                eVar.label = 4;
                return obj2;
                l$42 = obj14;
                obj14 = obj15;
                break;
            case 3:
                obj14 = eVar.L$5;
                l$43 = eVar.L$4;
                l$3 = eVar.L$3;
                l$23 = eVar.L$2;
                l$12 = eVar.L$1;
                locale_lessonId = eVar.L$0;
                q.b(obj15);
                obj14 = p.E0(obj14, l$23);
                obj15 = p.E0((List)obj15, l$3);
                array2 = p.E0(l$43, p.b(l$12)).toArray(new b[i7]);
                Objects.requireNonNull(array2, str);
                eVar.L$0 = locale_lessonId;
                eVar.L$1 = l$12;
                eVar.L$2 = l$23;
                eVar.L$3 = l$3;
                eVar.L$4 = obj14;
                eVar.L$5 = obj15;
                eVar.label = 4;
                return obj2;
                l$42 = obj14;
                obj14 = obj15;
                break;
            case 4:
                obj14 = eVar.L$5;
                l$42 = eVar.L$4;
                l$3 = eVar.L$3;
                l$23 = eVar.L$2;
                l$12 = eVar.L$1;
                locale_lessonId = eVar.L$0;
                q.b(obj15);
                break;
            case 5:
                obj14 = eVar.L$4;
                q.b(obj15);
                obj15 = l$33;
                l$22 = l$24;
                l$1 = l$15;
                l$0 = l$12;
                obj14 = obj14.toArray(new d[i7]);
                Objects.requireNonNull(obj14, str);
                eVar.L$0 = l$0;
                eVar.L$1 = l$1;
                eVar.L$2 = l$22;
                eVar.L$3 = obj15;
                eVar.L$4 = i6;
                eVar.label = 6;
                return obj2;
                obj14 = obj15;
                obj15 = new b[i2];
                obj15[i7] = l$1;
                eVar.L$0 = l$0;
                eVar.L$1 = l$22;
                eVar.L$2 = obj14;
                eVar.L$3 = i6;
                eVar.label = 7;
                return obj2;
                obj15 = l$22;
                label = l$0;
                obj15 = obj15.toArray(new c[i7]);
                Objects.requireNonNull(obj15, str);
                eVar.L$0 = label;
                eVar.L$1 = obj14;
                eVar.L$2 = i6;
                eVar.label = 8;
                return obj2;
                obj14 = obj14.toArray(new d[i7]);
                Objects.requireNonNull(obj14, str);
                eVar.L$0 = i6;
                eVar.L$1 = i6;
                eVar.label = 9;
                return obj2;
                return w.a;
            case 6:
                obj14 = eVar.L$3;
                l$22 = eVar.L$2;
                l$1 = eVar.L$1;
                l$0 = eVar.L$0;
                q.b(obj15);
                obj15 = new b[i2];
                obj15[i7] = l$1;
                eVar.L$0 = l$0;
                eVar.L$1 = l$22;
                eVar.L$2 = obj14;
                eVar.L$3 = i6;
                eVar.label = 7;
                return obj2;
                obj15 = l$22;
                label = l$0;
                obj15 = obj15.toArray(new c[i7]);
                Objects.requireNonNull(obj15, str);
                eVar.L$0 = label;
                eVar.L$1 = obj14;
                eVar.L$2 = i6;
                eVar.label = 8;
                return obj2;
                obj14 = obj14.toArray(new d[i7]);
                Objects.requireNonNull(obj14, str);
                eVar.L$0 = i6;
                eVar.L$1 = i6;
                eVar.label = 9;
                return obj2;
                return w.a;
            case 7:
                obj14 = eVar.L$2;
                q.b(obj15);
                obj15 = l$14;
                label = l$02;
                obj15 = obj15.toArray(new c[i7]);
                Objects.requireNonNull(obj15, str);
                eVar.L$0 = label;
                eVar.L$1 = obj14;
                eVar.L$2 = i6;
                eVar.label = 8;
                return obj2;
                obj14 = obj14.toArray(new d[i7]);
                Objects.requireNonNull(obj14, str);
                eVar.L$0 = i6;
                eVar.L$1 = i6;
                eVar.label = 9;
                return obj2;
                return w.a;
            case 8:
                obj14 = eVar.L$1;
                label = eVar.L$0;
                q.b(obj15);
                obj14 = obj14.toArray(new d[i7]);
                Objects.requireNonNull(obj14, str);
                eVar.L$0 = i6;
                eVar.L$1 = i6;
                eVar.label = 9;
                return obj2;
                return w.a;
            case 9:
                q.b(obj15);
                return w.a;
            default:
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
        }
        Object obj5 = l$23;
        Object[] array = l$42.toArray(new c[i7]);
        Objects.requireNonNull(array, str);
        eVar.L$0 = locale_lessonId;
        eVar.L$1 = l$12;
        eVar.L$2 = obj5;
        eVar.L$3 = l$3;
        eVar.L$4 = obj14;
        eVar.L$5 = i6;
        eVar.label = 5;
        if (locale_lessonId.h((c[])Arrays.copyOf((c[])array, array.length), eVar) == obj2) {
            return obj2;
        }
        l$22 = obj5;
        l$1 = l$12;
        l$0 = locale_lessonId;
    }

    public abstract Object A(d[] dArr, d<? super w> d2);

    public abstract Object B(ModuleEntity[] moduleEntityArr, d<? super w> d2);

    public abstract Object D(e[] eArr, d<? super w> d2);

    public abstract Object E(f[] fArr, d<? super w> d2);

    public abstract Object F(ProgramEntity[] programEntityArr, d<? super w> d2);

    public abstract Object H(h[] hArr, d<? super w> d2);

    public final Object d(b b, d<? super w> d2) {
        boolean aVar;
        int label;
        int i2;
        Object l$1;
        Object label2;
        Object l$0;
        int i;
        Object l$03;
        Object l$02;
        TaskEntity[] arr;
        Object obj13;
        Object obj14;
        aVar = d2;
        label = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof e0.a && label & i2 != 0) {
            aVar = d2;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                aVar.label = label -= i2;
            } else {
                aVar = new e0.a(this, d2);
            }
        } else {
        }
        obj14 = aVar.result;
        Object obj = b.d();
        label2 = aVar.label;
        int i3 = 0;
        final int i4 = 5;
        final int i5 = 4;
        final int i6 = 3;
        l$03 = 2;
        final int i7 = 0;
        final int i8 = 1;
        if (label2 != 0) {
            if (label2 != i8) {
                if (label2 != l$03) {
                    if (label2 != i6) {
                        if (label2 != i5) {
                            if (label2 != i4) {
                            } else {
                                q.b(obj14);
                                return w.a;
                            }
                            obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            throw obj13;
                        }
                        obj13 = aVar.L$1;
                        label2 = aVar.L$0;
                        q.b(obj14);
                    } else {
                        obj13 = aVar.L$2;
                        l$1 = aVar.L$1;
                        q.b(obj14);
                        l$02 = l$03;
                        for (TaskEntity obj14 : obj13) {
                            arr = new TaskEntity[i8];
                            arr[i3] = obj14;
                            aVar.L$0 = l$02;
                            aVar.L$1 = l$1;
                            aVar.L$2 = obj13;
                            aVar.label = i6;
                        }
                        aVar.L$0 = l$02;
                        aVar.L$1 = l$1;
                        aVar.L$2 = i7;
                        aVar.label = i5;
                        if (l$02.c.g(l$1.b(), aVar) == obj) {
                            return obj;
                        }
                        obj13 = l$1;
                        label2 = l$02;
                    }
                } else {
                    obj13 = aVar.L$2;
                    l$1 = aVar.L$1;
                    l$02 = aVar.L$0;
                    q.b(obj14);
                    for (g obj14 : obj13) {
                        aVar.L$0 = l$02;
                        aVar.L$1 = l$1;
                        aVar.L$2 = obj13;
                        aVar.label = l$03;
                    }
                    obj13 = l$1.c().iterator();
                }
            } else {
                obj13 = aVar.L$1;
                l$0 = aVar.L$0;
                q.b(obj14);
                l$02 = l$0;
                l$1 = obj13;
                obj13 = obj14;
            }
        } else {
            q.b(obj14);
            obj14 = new LessonEntity[i8];
            obj14[i3] = b.a();
            aVar.L$0 = this;
            aVar.L$1 = b;
            aVar.label = i8;
            if (w(obj14, aVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        aVar.L$0 = i7;
        aVar.L$1 = i7;
        aVar.label = i4;
        if (label2.x(obj13, aVar) == obj) {
            return obj;
        }
    }

    public final Object e(c c, d<? super w> d2) {
        boolean bVar;
        int label2;
        int i;
        Object label;
        Object l$03;
        int i2;
        Object l$02;
        e.a.a.a.b.b.e0 l$0;
        ModuleEntity moduleEntity;
        Object obj9;
        boolean obj10;
        bVar = d2;
        label2 = bVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof e0.b && label2 & i != 0) {
            bVar = d2;
            label2 = bVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                bVar.label = label2 -= i;
            } else {
                bVar = new e0.b(this, d2);
            }
        } else {
        }
        obj10 = bVar.result;
        Object obj = b.d();
        label = bVar.label;
        int i4 = 4;
        final int i5 = 3;
        l$02 = 2;
        l$0 = 1;
        if (label != 0) {
            if (label != l$0) {
                if (label != l$02) {
                    if (label != i5) {
                        if (label != i4) {
                        } else {
                            q.b(obj10);
                            return w.a;
                        }
                        obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj9;
                    }
                    obj9 = bVar.L$2;
                    label = bVar.L$1;
                    l$02 = bVar.L$0;
                    q.b(obj10);
                } else {
                    obj9 = bVar.L$2;
                    label = bVar.L$1;
                    l$0 = bVar.L$0;
                    q.b(obj10);
                    for (b obj10 : obj9) {
                        bVar.L$0 = l$0;
                        bVar.L$1 = label;
                        bVar.L$2 = obj9;
                        bVar.label = l$02;
                    }
                    obj9 = label.a().iterator();
                    l$02 = l$0;
                }
            } else {
                obj9 = bVar.L$1;
                l$03 = bVar.L$0;
                q.b(obj10);
                l$0 = l$03;
                label = obj9;
                obj9 = obj10;
            }
        } else {
            q.b(obj10);
            obj10 = new ModuleEntity[l$0];
            obj10[0] = c.c();
            bVar.L$0 = this;
            bVar.L$1 = c;
            bVar.label = l$0;
            if (B(obj10, bVar) == obj) {
                return obj;
            }
            l$03 = this;
        }
        for (g obj10 : obj9) {
            bVar.L$0 = l$02;
            bVar.L$1 = label;
            bVar.L$2 = obj9;
            bVar.label = i5;
        }
        obj9 = 0;
        bVar.L$0 = obj9;
        bVar.L$1 = obj9;
        bVar.L$2 = obj9;
        bVar.label = i4;
        if (l$02.C(label, bVar) == obj) {
            return obj;
        }
    }

    public final Object f(e e, d<? super w> d2) {
        boolean cVar;
        int label;
        int i2;
        Object l$0;
        int label2;
        int i;
        int l$02;
        ProgramEntity programEntity;
        Object obj8;
        Object obj9;
        cVar = d2;
        label = cVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof e0.c && label & i2 != 0) {
            cVar = d2;
            label = cVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                cVar.label = label -= i2;
            } else {
                cVar = new e0.c(this, d2);
            }
        } else {
        }
        obj9 = cVar.result;
        Object obj = b.d();
        label2 = cVar.label;
        int i4 = 3;
        final int i5 = 2;
        l$02 = 1;
        if (label2 != 0) {
            if (label2 != l$02) {
                if (label2 != i5) {
                    if (label2 != i4) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj8;
                }
                obj8 = cVar.L$2;
                label2 = cVar.L$1;
                l$02 = cVar.L$0;
                q.b(obj9);
            } else {
                obj8 = cVar.L$1;
                l$0 = cVar.L$0;
                q.b(obj9);
                l$02 = l$0;
                label2 = obj8;
                obj8 = obj9;
            }
        } else {
            q.b(obj9);
            obj9 = new ProgramEntity[l$02];
            obj9[0] = e.b();
            cVar.L$0 = this;
            cVar.L$1 = e;
            cVar.label = l$02;
            if (F(obj9, cVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        for (c obj9 : obj8) {
            cVar.L$0 = l$02;
            cVar.L$1 = label2;
            cVar.L$2 = obj8;
            cVar.label = i5;
        }
        obj8 = 0;
        cVar.L$0 = obj8;
        cVar.L$1 = obj8;
        cVar.L$2 = obj8;
        cVar.label = i4;
        if (l$02.G(label2, cVar) == obj) {
            return obj;
        }
    }

    public abstract Object g(b[] bArr, d<? super w> d2);

    public abstract Object h(c[] cArr, d<? super w> d2);

    public abstract Object i(d[] dArr, d<? super w> d2);

    public abstract Object j(e[] eArr, d<? super w> d2);

    public abstract Object k(f[] fArr, d<? super w> d2);

    public abstract Object l(h[] hArr, d<? super w> d2);

    public abstract Object m(String string, d<? super List<e>> d2);

    public abstract Object n(d<? super Long> d);

    public abstract Object o(String string, d<? super List<b>> d2);

    public abstract Object p(String string, d<? super List<c>> d2);

    public abstract Object q(String string, d<? super List<d>> d2);

    public abstract Object r(String string, String string2, d<? super List<e>> d3);

    public final Object s(String string, String string2, d<? super e> d3) {
        boolean dVar;
        int label;
        int i;
        int i2;
        Object obj5;
        Object obj6;
        Object obj7;
        dVar = d3;
        label = dVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof e0.d && label & i != 0) {
            dVar = d3;
            label = dVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                dVar.label = label -= i;
            } else {
                dVar = new e0.d(this, d3);
            }
        } else {
        }
        obj7 = dVar.result;
        Object obj = b.d();
        int label2 = dVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj6 = obj5;
                obj5 = dVar.L$0;
                q.b(obj7);
                obj7 = p.Z((List)obj7);
                if ((e)obj7 == null) {
                } else {
                    return (e)obj7;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Program not found with ");
                stringBuilder.append(obj5);
                stringBuilder.append(" and ");
                stringBuilder.append(obj6);
                obj7 = new Exception(stringBuilder.toString());
                throw obj7;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj7);
        dVar.L$0 = string;
        dVar.L$1 = string2;
        dVar.label = i3;
        if (r(string, string2, dVar) == obj) {
            return obj;
        }
    }

    public abstract Object t(String string, d<? super List<e>> d2);

    public abstract Object u(String string, d<? super List<f>> d2);

    public abstract Object v(String string, d<? super List<h>> d2);

    public abstract Object w(LessonEntity[] lessonEntityArr, d<? super w> d2);

    public abstract Object y(b[] bArr, d<? super w> d2);

    public abstract Object z(c[] cArr, d<? super w> d2);
}
