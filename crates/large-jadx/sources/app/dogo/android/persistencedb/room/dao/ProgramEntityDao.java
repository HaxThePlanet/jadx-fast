package e.a.a.a.b.b;

import android.app.ActivityManager.ProcessErrorStateInfo;
import app.dogo.android.persistencedb.room.database.ContentDatabase;
import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import e.a.a.a.b.c.h;
import e.a.a.a.b.d.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* compiled from: ProgramEntityDao.kt */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008 \u0008'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u000c2\u0012\u0010\u001d\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010!\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020#0\u001e\"\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J%\u0010%\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001e\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u000c2\u0006\u0010)\u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u0010,\u001a\u00020\u000c2\u0012\u0010-\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0\u001e\"\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J%\u00100\u001a\u00020\u000c2\u0012\u00101\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002020\u001e\"\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u000c2\u0006\u00105\u001a\u000206H§@ø\u0001\u0000¢\u0006\u0002\u00107J%\u00108\u001a\u00020\u000c2\u0012\u00109\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020:0\u001e\"\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00160=2\u0006\u0010>\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0013\u0010E\u001a\u0004\u0018\u00010BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u001f\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u001f0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010H\u001a\u0008\u0012\u0004\u0012\u00020#0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010I\u001a\u0008\u0012\u0004\u0012\u00020&0=2\u0006\u0010G\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J'\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00160=2\u0006\u0010>\u001a\u00020?2\u0006\u0010K\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010LJ!\u0010M\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?2\u0006\u0010K\u001a\u00020?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001f\u0010N\u001a\u0008\u0012\u0004\u0012\u00020.0=2\u0006\u0010O\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010P\u001a\u0008\u0012\u0004\u0012\u0002020=2\u0006\u0010O\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001f\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020:0=2\u0006\u0010R\u001a\u00020?H§@ø\u0001\u0000¢\u0006\u0002\u0010@J%\u0010S\u001a\u00020\u000c2\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001a0\u001e\"\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010TJ\u0019\u0010U\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ%\u0010V\u001a\u00020\u000c2\u0012\u0010\u001d\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010W\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020#0\u001e\"\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J%\u0010X\u001a\u00020\u000c2\u0012\u0010\"\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001e\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010Y\u001a\u00020\u000c2\u0012\u0010)\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020*0\u001e\"\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010ZJ\u0019\u0010[\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J%\u0010\\\u001a\u00020\u000c2\u0012\u0010-\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0\u001e\"\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J%\u0010]\u001a\u00020\u000c2\u0012\u00101\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002020\u001e\"\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J%\u0010^\u001a\u00020\u000c2\u0012\u00105\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002060\u001e\"\u000206H§@ø\u0001\u0000¢\u0006\u0002\u0010_J\u0019\u0010`\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010a\u001a\u00020\u000c2\u0012\u00109\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020:0\u001e\"\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006b", d2 = {"Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "", "contentDatabase", "Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "(Lapp/dogo/android/persistencedb/room/database/ContentDatabase;)V", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "taskDao", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "trickDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "cleanInsertFullLesson", "", "fullLessonEntity", "Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullModule", "moduleFullContent", "Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullProgram", "programFullEntity", "Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLesson", "lesson", "Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "(Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithQuestion", "lessonWithQuestion", "", "Lapp/dogo/android/persistencedb/room/junction/LessonWithQuestion;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithQuestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithTask", "lessonWithTrick", "Lapp/dogo/android/persistencedb/room/junction/LessonWithTask;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonWithTrick", "Lapp/dogo/android/persistencedb/room/junction/LessonWithTrick;", "([Lapp/dogo/android/persistencedb/room/junction/LessonWithTrick;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModule", "module", "Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModuleWithExams", "moduleWithExam", "Lapp/dogo/android/persistencedb/room/junction/ModuleWithExams;", "([Lapp/dogo/android/persistencedb/room/junction/ModuleWithExams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteModuleWithLessons", "moduleWithLesson", "Lapp/dogo/android/persistencedb/room/junction/ModuleWithLessons;", "([Lapp/dogo/android/persistencedb/room/junction/ModuleWithLessons;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProgram", "program", "Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProgramWithModules", "programWithModule", "Lapp/dogo/android/persistencedb/room/junction/ProgramWithModules;", "([Lapp/dogo/android/persistencedb/room/junction/ProgramWithModules;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocalisedPrograms", "", "locale", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestLessonTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestModuleTimestamp", "getLatestProgramTimestamp", "getLessonWithQuestionJunction", "locale_lessonId", "getLessonWithTaskJunction", "getLessonWithTrickJunction", "getLocalisedProgram", "programId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalisedProgramItem", "getModuleWithExamsJunction", "locale_moduleId", "getModuleWithLessonsJunction", "getProgramWithModulesJunction", "locale_programId", "insertLesson", "([Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLessonJunctions", "insertLessonWithQuestion", "insertLessonWithTask", "insertLessonWithTrick", "insertModule", "([Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertModuleJunctions", "insertModuleWithExams", "insertModuleWithLessons", "insertProgram", "([Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertProgramJunctions", "insertProgramWithModules", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public abstract class ProgramEntityDao {

    /* renamed from: a, reason: from kotlin metadata */
    private final m0 questionDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final i0 taskDao;
    /* renamed from: c, reason: from kotlin metadata */
    private final g0 trickDao;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {129, 131, 134, 136, 137}, m = "cleanInsertFullLesson")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super e0.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.d(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {163, 165, 168, 171}, m = "cleanInsertFullModule")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super e0.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.e(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {192, 194, 197}, m = "cleanInsertFullProgram")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super e0.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.f(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = 210, m = "getLocalisedProgramItem")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super e0.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return e0.this.s(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {145, 146, 147, 153, 154, 155, 157, 158, 159}, m = "insertLessonJunctions")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super e0.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.x(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {178, 179, 184, 185, 187, 188}, m = "insertModuleJunctions")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super e0.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.getLocalisedProgram(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.android.persistencedb.room.dao.ProgramEntityDao", f = "ProgramEntityDao.kt", l = {202, 205, 206}, m = "insertProgramJunctions")
    static final class g extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        g(kotlin.b0.d<? super e0.g> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e0.this.getLocalisedProgramItem(0, this);
        }
    }
    public e0(ContentDatabase contentDatabase) {
        n.f(contentDatabase, "contentDatabase");
        super();
        this.questionDao = contentDatabase.M();
        this.taskDao = contentDatabase.L();
        this.trickDao = contentDatabase.K();
    }

    /* renamed from: C, reason: from kotlin metadata */
    /* suspend */ private final Object getLocalisedProgram(e.a.a.a.b.d.c locale, kotlin.b0.d<? super w> programId) {
        Object programId2;
        int label2;
        int i = -2147483648;
        Object obj;
        Iterable programId3;
        int i2;
        Object obj2;
        Iterable iterable;
        int i3 = 5;
        Object locale2;
        int i7;
        String locale_moduleId;
        e.a.a.a.b.c.f moduleWithLessons;
        Object programId4;
        Object obj4;
        Iterable iterable2;
        Object obj6;
        Object obj5;
        Iterable iterable3;
        Object obj3;
        z = programId instanceof app.dogo.android.persistencedb.room.dao.e0.f;
        if (programId instanceof app.dogo.android.persistencedb.room.dao.e0.f) {
            programId2 = programId;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                programId2.label -= i;
            } else {
                e.a.a.a.b.b.e0.f fVar = new app.dogo.android.persistencedb.room.dao.e0.f(this, programId);
            }
        }
        Object obj8 = b.d();
        Object obj9 = null;
        final String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i8 = 0;
        switch (programId2.label) {
            case 0:
                q.b(programId2.result);
                List list = locale.b();
                int i10 = 10;
                ArrayList arrayList = new ArrayList(p.r(list, i10));
                Iterator it2 = list.iterator();
                arrayList.add(new ModuleWithLessons(locale.c().getLocale_moduleId(), it2.next().component1().getLocale_lessonId()));
                List component12 = locale.component1();
                ArrayList arrayList2 = new ArrayList(p.r(component12, i10));
                Iterator it3 = component12.iterator();
                arrayList2.add(new ModuleWithExams(locale.c().getLocale_moduleId(), it3.next().d().getLocale_trickId()));
                programId2.L$0 = this;
                programId2.L$1 = locale;
                programId2.L$2 = arrayList;
                programId2.L$3 = arrayList2;
                programId2.label = 1;
                return obj8;
                break;
            case 1:
                q.b(programId2.result);
                programId2.L$0 = obj;
                programId2.L$1 = obj2;
                programId2.L$2 = locale2;
                programId2.L$3 = programId4;
                int i6 = 2;
                programId2.label = 2;
                Object locale3 = obj.t(obj4.c().getLocale_moduleId(), programId2);
                return obj8;
                break;
            case 2:
                q.b(programId2.result);
                java.util.Set programId5 = p.E0((List)(ist)iterable3, programId3);
                Object[] array = p.E0(iterable2, iterable).toArray(new f[i8]);
                Objects.requireNonNull(array, str);
                programId2.L$0 = obj;
                programId2.L$1 = iterable;
                programId2.L$2 = programId3;
                programId2.L$3 = programId5;
                i7 = 3;
                programId2.label = 3;
                return obj8;
                break;
            case 3:
                q.b(programId2.result);
                break;
            case 4:
                q.b(programId2.result);
                Object[] array4 = obj3.toArray(new f[i8]);
                Objects.requireNonNull(array4, str);
                programId2.L$0 = obj;
                programId2.L$1 = obj6;
                programId2.L$2 = obj9;
                i3 = 5;
                programId2.label = 5;
                return obj8;
            case 5:
                q.b(programId2.result);
                Object[] array2 = obj6.toArray(new e[i8]);
                Objects.requireNonNull(array2, str);
                programId2.L$0 = obj9;
                programId2.L$1 = obj9;
                programId2.label = 6;
                return obj8;
            case 6:
                q.b(programId2.result);
                return w.a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object[] array3 = obj5.toArray(new e[i8]);
        Objects.requireNonNull(array3, str);
        programId2.L$0 = obj;
        programId2.L$1 = iterable;
        programId2.L$2 = programId3;
        programId2.L$3 = obj9;
        programId2.label = 4;
        if (obj.j((e[])Arrays.copyOf(array3, array3.length), programId2) == programId2.label) {
            return obj8;
        }
    }

    /* renamed from: G, reason: from kotlin metadata */
    /* suspend */ private final Object getLocalisedProgramItem(e.a.a.a.b.d.e locale, kotlin.b0.d<? super w> programId) {
        Object programId2;
        int label2;
        int i = -2147483648;
        e.a.a.a.b.b.e0 e0Var;
        int i2;
        int length = 1;
        boolean hasNext;
        String locale_programId;
        h programWithModules;
        ArrayList arrayList;
        Iterable iterable;
        z = programId instanceof app.dogo.android.persistencedb.room.dao.e0.g;
        if (programId instanceof app.dogo.android.persistencedb.room.dao.e0.g) {
            programId2 = programId;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                programId2.label -= i;
            } else {
                e.a.a.a.b.b.e0.g gVar = new app.dogo.android.persistencedb.room.dao.e0.g(this, programId);
            }
        }
        Object obj2 = b.d();
        String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i4 = 0;
        final int i5 = 3;
        final int i6 = 2;
        length = 1;
        if (programId2.label != 0) {
            if (programId2.label != length) {
                if (programId2.label != i6) {
                    if (programId2.label != i5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(programId2.result);
                        return w.a;
                    }
                }
                q.b(programId2.result);
            } else {
                q.b(programId2.result);
                Object[] array2 = p.E0((List)iterable, arrayList).toArray(new h[i4]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                length = array2.length;
                programId2.L$0 = e0Var;
                programId2.L$1 = arrayList;
                programId2.label = i6;
                if (e0Var.l((h[])Arrays.copyOf(array2, length), programId2) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(programId2.result);
            List component1 = locale.component1();
            arrayList = new ArrayList(p.r(component1, 10));
            Iterator it = component1.iterator();
            while (it.hasNext()) {
                arrayList.add(new ProgramWithModules(locale.b().getLocale_programId(), (ModuleFullEntity)it.next().c().getLocale_moduleId()));
            }
            programId2.L$0 = this;
            programId2.L$1 = arrayList;
            programId2.label = length;
            if (v(locale.b().getLocale_programId(), programId2) == obj2) {
                return obj2;
            }
            e0Var = this;
        }
        Object[] array = arrayList.toArray(new h[i4]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Object result2 = null;
        programId2.L$0 = result2;
        programId2.L$1 = result2;
        programId2.label = i5;
        if (e0Var.H((h[])Arrays.copyOf(array, array.length), programId2) == obj2) {
            return obj2;
        }
    }

    public static final /* synthetic */ Object a(e0 e0Var, e.a.a.a.b.d.b bVar, kotlin.b0.d dVar) {
        return e0Var.x(bVar, dVar);
    }

    public static final /* synthetic */ Object b(e0 e0Var, e.a.a.a.b.d.c cVar, kotlin.b0.d dVar) {
        return e0Var.getLocalisedProgram(cVar, dVar);
    }

    public static final /* synthetic */ Object c(e0 e0Var, e.a.a.a.b.d.e eVar, kotlin.b0.d dVar) {
        return e0Var.getLocalisedProgramItem(eVar, dVar);
    }

    private final Object x(e.a.a.a.b.d.b bVar, kotlin.b0.d<? super w> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        Object obj2;
        Object bVar2;
        Object bVar3;
        Iterable iterable;
        Object obj4;
        Object obj3;
        int i2;
        int i3 = 8;
        Object bVar4;
        Iterable iterable2;
        Iterable iterable3;
        int i5;
        Object bVar5;
        String locale_lessonId;
        int i7;
        e.a.a.a.b.c.c lessonWithTask;
        Object dVar23;
        Iterable iterable4;
        Iterable iterable5;
        z = dVar instanceof app.dogo.android.persistencedb.room.dao.e0.e;
        if (dVar instanceof app.dogo.android.persistencedb.room.dao.e0.e) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                e.a.a.a.b.b.e0.e eVar = new app.dogo.android.persistencedb.room.dao.e0.e(this, dVar);
            }
        }
        Object obj7 = b.d();
        i3 = 1;
        final String str = "null cannot be cast to non-null type kotlin.Array<T>";
        final Object obj10 = null;
        final int i11 = 0;
        switch (dVar22.label) {
            case 0:
                q.b(dVar22.result);
                List list2 = bVar.c();
                int i13 = 10;
                ArrayList arrayList = new ArrayList(p.r(list2, i13));
                Iterator it = list2.iterator();
                arrayList.add(new LessonWithTask(bVar.component1().getLocale_lessonId(), it.next().getLocale_taskId()));
                List list3 = bVar.d();
                ArrayList arrayList2 = new ArrayList(p.r(list3, i13));
                Iterator it2 = list3.iterator();
                arrayList2.add(new LessonWithTrick(bVar.component1().getLocale_lessonId(), it2.next().d().getLocale_trickId()));
                dVar22.L$0 = this;
                dVar22.L$1 = bVar;
                dVar22.L$2 = new LessonWithQuestion(bVar.component1().getLocale_lessonId(), bVar.b().b().getLocale_questionId());
                dVar22.L$3 = arrayList;
                dVar22.L$4 = arrayList2;
                dVar22.label = i3;
                return obj7;
                break;
            case 1:
                q.b(dVar22.result);
                dVar22.L$0 = obj2;
                dVar22.L$1 = bVar5;
                dVar22.L$2 = obj2;
                dVar22.L$3 = obj4;
                dVar22.L$4 = bVar3;
                dVar22.L$5 = bVar4;
                int i8 = 2;
                dVar22.label = 2;
                bVar4 = obj2.p(bVar5.component1().getLocale_lessonId(), dVar22);
                return obj7;
                break;
            case 2:
                q.b(dVar22.result);
                dVar22.L$0 = obj2;
                dVar22.L$1 = obj2;
                dVar22.L$2 = obj4;
                dVar22.L$3 = bVar3;
                dVar22.L$4 = bVar4;
                dVar22.L$5 = bVar4;
                int i9 = 3;
                dVar22.label = 3;
                Object obj5 = obj2.q(bVar5.component1().getLocale_lessonId(), dVar22);
                return obj7;
                break;
            case 3:
                q.b(dVar22.result);
                java.util.Set set2 = p.E0(iterable4, iterable3);
                java.util.Set set3 = p.E0((List)(ist)iterable5, iterable2);
                Object[] array2 = p.E0(Integer.MIN_VALUE, p.b(obj2)).toArray(new b[i11]);
                Objects.requireNonNull(array2, str);
                dVar22.L$0 = obj2;
                dVar22.L$1 = obj2;
                dVar22.L$2 = iterable3;
                dVar22.L$3 = iterable2;
                dVar22.L$4 = set2;
                dVar22.L$5 = set3;
                i7 = 4;
                dVar22.label = 4;
                return obj7;
                break;
            case 4:
                q.b(dVar22.result);
                break;
            case 5:
                q.b(dVar22.result);
                Object[] array4 = dVar23.toArray(new d[i11]);
                Objects.requireNonNull(array4, str);
                dVar22.L$0 = obj2;
                dVar22.L$1 = obj2;
                dVar22.L$2 = obj3;
                dVar22.L$3 = bVar4;
                dVar22.L$4 = obj10;
                i5 = 6;
                dVar22.label = 6;
                return obj7;
            case 6:
                q.b(dVar22.result);
                e.a.a.a.b.c.b[] arr6 = new b[i3];
                arr6[i11] = obj2;
                dVar22.L$0 = obj2;
                dVar22.L$1 = obj3;
                dVar22.L$2 = bVar4;
                dVar22.L$3 = obj10;
                dVar22.label = 7;
                return obj7;
            case 7:
                q.b(dVar22.result);
                Object[] array5 = obj3.toArray(new c[i11]);
                Objects.requireNonNull(array5, str);
                dVar22.L$0 = obj2;
                dVar22.L$1 = bVar4;
                dVar22.L$2 = obj10;
                i3 = 8;
                dVar22.label = 8;
                return obj7;
            case 8:
                q.b(dVar22.result);
                Object[] array3 = bVar4.toArray(new d[i11]);
                Objects.requireNonNull(array3, str);
                dVar22.L$0 = obj10;
                dVar22.L$1 = obj10;
                dVar22.label = 9;
                return obj7;
            case 9:
                q.b(dVar22.result);
                return w.a;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object[] array = bVar2.toArray(new c[i11]);
        Objects.requireNonNull(array, str);
        dVar22.L$0 = obj2;
        dVar22.L$1 = obj2;
        dVar22.L$2 = obj3;
        dVar22.L$3 = bVar4;
        dVar22.L$4 = dVar23;
        dVar22.L$5 = obj10;
        dVar22.label = 5;
        if (obj2.h((c[])Arrays.copyOf(array, array.length), dVar22) == dVar22.label) {
            return obj7;
        }
    }

    public final Object d(e.a.a.a.b.d.b bVar, kotlin.b0.d<? super w> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        Object bVar2;
        Object obj;
        int i2;
        e.a.a.a.b.b.i0 taskDao2;
        TaskEntity[] arr;
        e.a.a.a.b.b.m0 questionDao2;
        Object obj2;
        e.a.a.a.b.d.b bVar4;
        Object obj3;
        e.a.a.a.b.d.f fVar;
        z = dVar instanceof app.dogo.android.persistencedb.room.dao.e0.a;
        if (dVar instanceof app.dogo.android.persistencedb.room.dao.e0.a) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                e.a.a.a.b.b.e0.a aVar = new app.dogo.android.persistencedb.room.dao.e0.a(this, dVar);
            }
        }
        Object obj5 = b.d();
        int i4 = 0;
        final int i5 = 5;
        final int i6 = 4;
        final int i7 = 3;
        int i3 = 2;
        final Object obj6 = null;
        final int i8 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i8) {
                if (dVar22.label != i3) {
                    if (dVar22.label != i7) {
                        if (dVar22.label != i6) {
                            if (dVar22.label != i5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                q.b(dVar22.result);
                                return w.a;
                            }
                        }
                        q.b(dVar22.result);
                    } else {
                        q.b(dVar22.result);
                        while (obj2.hasNext()) {
                            arr = new TaskEntity[i8];
                            dVar22.L$0 = obj;
                            dVar22.L$1 = bVar2;
                            dVar22.L$2 = obj2;
                            dVar22.label = i7;
                            if (obj.taskDao.a(new TaskEntity[] { (TaskEntity)obj2.next() }, dVar22) == obj5) {
                                return obj5;
                            }
                        }
                        dVar22.L$0 = obj;
                        dVar22.L$1 = bVar2;
                        dVar22.L$2 = obj6;
                        dVar22.label = i6;
                        if (obj.trickDao.g(bVar2.b(), dVar22) == obj5) {
                            return obj5;
                        }
                    }
                } else {
                    q.b(dVar22.result);
                    while (obj3.hasNext()) {
                        dVar22.L$0 = obj;
                        dVar22.L$1 = bVar2;
                        dVar22.L$2 = obj3;
                        dVar22.label = i3;
                        if (obj.questionDao.i((TrickFullEntity)obj3.next(), dVar22) == obj5) {
                            return obj5;
                        }
                    }
                    Iterator it = bVar2.c().iterator();
                }
            } else {
                q.b(dVar22.result);
            }
        } else {
            q.b(dVar22.result);
            LessonEntity[] arr2 = new LessonEntity[i8];
            dVar22.L$0 = this;
            dVar22.L$1 = bVar;
            dVar22.label = i8;
            if (w(new LessonEntity[] { bVar.component1() }, dVar22) == obj5) {
                return obj5;
            }
            e.a.a.a.b.b.e0 bVar3 = this;
        }
        dVar22.L$0 = obj6;
        dVar22.L$1 = obj6;
        dVar22.label = i5;
        if (obj.x(bVar4, dVar22) == obj5) {
            return obj5;
        }
    }

    public final Object e(e.a.a.a.b.d.c cVar, kotlin.b0.d<? super w> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        e.a.a.a.b.d.c cVar2;
        e.a.a.a.b.b.e0 e0Var;
        Object cVar3;
        int i2;
        e.a.a.a.b.b.m0 questionDao2;
        ModuleEntity moduleEntity;
        Iterator it;
        Iterator dVar23;
        z = dVar instanceof app.dogo.android.persistencedb.room.dao.e0.b;
        if (dVar instanceof app.dogo.android.persistencedb.room.dao.e0.b) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                e.a.a.a.b.b.e0.b bVar = new app.dogo.android.persistencedb.room.dao.e0.b(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 4;
        final int i5 = 3;
        int i6 = 2;
        int i7 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i7) {
                if (dVar22.label != i6) {
                    if (dVar22.label != i5) {
                        if (dVar22.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar22.result);
                            return w.a;
                        }
                    }
                    q.b(dVar22.result);
                } else {
                    q.b(dVar22.result);
                    while (dVar23.hasNext()) {
                        dVar22.L$0 = e0Var;
                        dVar22.L$1 = cVar3;
                        dVar22.L$2 = dVar23;
                        dVar22.label = i6;
                        if (e0Var.d((LessonFullEntity)dVar23.next(), dVar22) == obj) {
                            return obj;
                        }
                    }
                    it = cVar3.component1().iterator();
                }
            } else {
                q.b(dVar22.result);
            }
        } else {
            q.b(dVar22.result);
            ModuleEntity[] arr = new ModuleEntity[i7];
            dVar22.L$0 = this;
            dVar22.L$1 = cVar;
            dVar22.label = i7;
            if (B(new ModuleEntity[] { cVar.c() }, dVar22) == obj) {
                return obj;
            }
            e0Var = this;
        }
        while (it.hasNext()) {
            dVar22.L$0 = e0Var;
            dVar22.L$1 = cVar2;
            dVar22.L$2 = it;
            dVar22.label = i5;
            if (e0Var.questionDao.i((TrickFullEntity)it.next(), dVar22) == obj) {
                return obj;
            }
        }
        Object obj2 = null;
        dVar22.L$0 = obj2;
        dVar22.L$1 = obj2;
        dVar22.L$2 = obj2;
        dVar22.label = i4;
        if (e0Var.getLocalisedProgram(cVar2, dVar22) == obj) {
            return obj;
        }
    }

    public final Object f(e.a.a.a.b.d.e eVar, kotlin.b0.d<? super w> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        e.a.a.a.b.b.e0 e0Var;
        e.a.a.a.b.d.e eVar3;
        int i2;
        ProgramEntity programEntity;
        Object eVar2;
        Iterator dVar23;
        z = dVar instanceof app.dogo.android.persistencedb.room.dao.e0.c;
        if (dVar instanceof app.dogo.android.persistencedb.room.dao.e0.c) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                e.a.a.a.b.b.e0.c cVar = new app.dogo.android.persistencedb.room.dao.e0.c(this, dVar);
            }
        }
        Object obj = b.d();
        int i5 = 3;
        final int i6 = 2;
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                if (dVar22.label != i6) {
                    if (dVar22.label != i5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar22.result);
                        return w.a;
                    }
                }
                q.b(dVar22.result);
            } else {
                q.b(dVar22.result);
            }
        } else {
            q.b(dVar22.result);
            ProgramEntity[] arr = new ProgramEntity[i3];
            dVar22.L$0 = this;
            dVar22.L$1 = eVar;
            dVar22.label = i3;
            if (F(new ProgramEntity[] { eVar.b() }, dVar22) == obj) {
                return obj;
            }
            e0Var = this;
        }
        while (dVar23.hasNext()) {
            dVar22.L$0 = e0Var;
            dVar22.L$1 = eVar3;
            dVar22.L$2 = dVar23;
            dVar22.label = i6;
            if (e0Var.e((ModuleFullEntity)dVar23.next(), dVar22) == obj) {
                return obj;
            }
        }
        Object obj2 = null;
        dVar22.L$0 = obj2;
        dVar22.L$1 = obj2;
        dVar22.L$2 = obj2;
        dVar22.label = i5;
        if (e0Var.getLocalisedProgramItem(eVar3, dVar22) == obj) {
            return obj;
        }
    }

    public final Object s(String str, String str2, kotlin.b0.d<? super e.a.a.a.b.d.e> dVar) throws Exception {
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        String str5;
        String str7;
        List list;
        z = dVar instanceof app.dogo.android.persistencedb.room.dao.e0.d;
        if (dVar instanceof app.dogo.android.persistencedb.room.dao.e0.d) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                dVar = new app.dogo.android.persistencedb.room.dao.e0.d(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar32.result);
                Object obj2 = p.Z((List)list);
                if (obj2 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str4 = "Program not found with ";
                    String str6 = " and ";
                    str = str4 + str5 + str6 + str7;
                    throw new Exception(str);
                } else {
                    return obj2;
                }
            }
        }
        q.b(dVar32.result);
        dVar32.L$0 = str;
        dVar32.L$1 = str2;
        dVar32.label = i3;
        if (r(str, str2, dVar32) == obj) {
            return obj;
        }
    }

    public abstract Object A(e.a.a.a.b.c.d[] dVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object B(ModuleEntity[] moduleEntityArr, kotlin.b0.d<? super w> dVar);

    public abstract Object D(e.a.a.a.b.c.e[] eVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object E(e.a.a.a.b.c.f[] fVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object F(ProgramEntity[] programEntityArr, kotlin.b0.d<? super w> dVar);

    public abstract Object H(h[] hVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object g(e.a.a.a.b.c.b[] bVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object h(e.a.a.a.b.c.c[] cVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object i(e.a.a.a.b.c.d[] dVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object j(e.a.a.a.b.c.e[] eVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object k(e.a.a.a.b.c.f[] fVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object l(h[] hVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object m(String str, kotlin.b0.d<? super List<e.a.a.a.b.d.e>> dVar);

    /* renamed from: n, reason: from kotlin metadata */
    /* suspend */ public abstract Object cleanInsertFullLesson(kotlin.b0.d<? super Long> fullLessonEntity);

    public abstract Object o(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.b>> dVar);

    public abstract Object p(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.c>> dVar);

    public abstract Object q(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.d>> dVar);

    public abstract Object r(String str, String str2, kotlin.b0.d<? super List<e.a.a.a.b.d.e>> dVar);

    public abstract Object t(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.e>> dVar);

    public abstract Object u(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.f>> dVar);

    public abstract Object v(String str, kotlin.b0.d<? super List<h>> dVar);

    public abstract Object w(LessonEntity[] lessonEntityArr, kotlin.b0.d<? super w> dVar);

    public abstract Object y(e.a.a.a.b.c.b[] bVarArr, kotlin.b0.d<? super w> dVar);

    public abstract Object z(e.a.a.a.b.c.c[] cVarArr, kotlin.b0.d<? super w> dVar);
}
