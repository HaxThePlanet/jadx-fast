package app.dogo.android.persistencedb.room.database;

import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g.a;
import androidx.room.f1.g.d;
import androidx.room.u0;
import androidx.room.u0.b;
import androidx.room.w0;
import androidx.room.w0.a;
import androidx.room.w0.b;
import d.s.a.h;
import d.s.a.h.b;
import d.s.a.h.b.a;
import d.s.a.h.c;
import e.a.a.a.b.b.c0;
import e.a.a.a.b.b.d0;
import e.a.a.a.b.b.f0;
import e.a.a.a.b.b.g0;
import e.a.a.a.b.b.h0;
import e.a.a.a.b.b.i0;
import e.a.a.a.b.b.j0;
import e.a.a.a.b.b.n0;
import e.a.a.a.b.b.q;
import e.a.a.a.b.b.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ContentDatabase_Impl.java */
/* loaded from: classes.dex */
public final class ContentDatabase_Impl extends ContentDatabase {

    private volatile e.a.a.a.b.b.m0 q;
    private volatile i0 r;
    private volatile g0 s;
    private volatile e.a.a.a.b.b.e0 t;
    private volatile q u;
    private volatile c0 v;

    class a extends w0.a {

        final /* synthetic */ ContentDatabase_Impl b;
        a(int i) {
            this.b = contentDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `BreedEntity` (`breedId` TEXT NOT NULL, `title` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_breedId` TEXT NOT NULL, PRIMARY KEY(`locale_breedId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickEntity` (`trickId` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `categoryName` TEXT NOT NULL, `categoryId` TEXT NOT NULL, `examInstructions` TEXT, `examTimeLimit` INTEGER, `sortOrder` INTEGER, `isExam` INTEGER NOT NULL, `hasProgress` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `videoId` TEXT, `videoThumbnail` TEXT, `description` TEXT, `locale` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, `imageStepOrder` TEXT NOT NULL, `videoStepOder` TEXT NOT NULL, PRIMARY KEY(`locale_trickId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickStepEntity` (`stepId` TEXT NOT NULL, `description` TEXT NOT NULL, `image` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_stepId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `VideoStepEntity` (`stepId` TEXT NOT NULL, `text` TEXT NOT NULL, `locale` TEXT NOT NULL, `startTime` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_stepId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickTagEntity` (`tagId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ArticleWithTags` (`locale_articleId` TEXT NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_articleId`, `locale_tagId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ArticleWithTags_locale_articleId` ON `ArticleWithTags` (`locale_articleId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ArticleWithTags_locale_tagId` ON `ArticleWithTags` (`locale_tagId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `LessonWithTrick` (`locale_lessonId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTrick_locale_lessonId` ON `LessonWithTrick` (`locale_lessonId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTrick_locale_trickId` ON `LessonWithTrick` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `LessonWithQuestion` (`locale_lessonId` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_questionId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithQuestion_locale_lessonId` ON `LessonWithQuestion` (`locale_lessonId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithQuestion_locale_questionId` ON `LessonWithQuestion` (`locale_questionId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `LessonWithTask` (`locale_lessonId` TEXT NOT NULL, `locale_taskId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_taskId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTask_locale_lessonId` ON `LessonWithTask` (`locale_lessonId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTask_locale_taskId` ON `LessonWithTask` (`locale_taskId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `ModuleWithExams` (`locale_moduleId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithExams_locale_moduleId` ON `ModuleWithExams` (`locale_moduleId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithExams_locale_trickId` ON `ModuleWithExams` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickWithTags` (`locale_tagId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithTags_locale_tagId` ON `TrickWithTags` (`locale_tagId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithTags_locale_trickId` ON `TrickWithTags` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `ArticleEntity` (`articleId` TEXT NOT NULL, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `readingTime` INTEGER NOT NULL, `sortOrder` INTEGER, `categoryId` TEXT NOT NULL, `image` TEXT, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_articleId` TEXT NOT NULL, `textHtml` TEXT, PRIMARY KEY(`locale_articleId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ArticleTagEntity` (`hidden` INTEGER NOT NULL, `tagId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `LessonEntity` (`lessonId` TEXT NOT NULL, `index` INTEGER NOT NULL, `locale` TEXT NOT NULL, `programId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_lessonId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ModuleEntity` (`moduleId` TEXT NOT NULL, `index` INTEGER NOT NULL, `name` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_moduleId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ProgramEntity` (`type` TEXT NOT NULL, `programId` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `centeredImage` TEXT NOT NULL, `description` TEXT NOT NULL, `cardBackgroundColor` TEXT NOT NULL, `certificateLaurelsImage` TEXT NOT NULL, `certificatePaperImage` TEXT NOT NULL, `certificatePlaceholderUrl` TEXT NOT NULL, `certificateRequirements` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_programId` TEXT NOT NULL, `programOverviewImage` TEXT NOT NULL, `dogSkillsHighlights` TEXT NOT NULL, `dogSkillsOverview` TEXT NOT NULL, `userSkillsOverview` TEXT NOT NULL, `averageCompletionTimeWeeks` INTEGER NOT NULL, `numberOfEnrolledUsers` INTEGER NOT NULL, `certificatePreviewImage` TEXT NOT NULL, PRIMARY KEY(`locale_programId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `QuestionEntity` (`questionId` TEXT NOT NULL, `locale` TEXT NOT NULL, `question` TEXT NOT NULL, `answers` TEXT NOT NULL, `correctAnswer` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TaskEntity` (`taskId` TEXT NOT NULL, `text` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_taskId` TEXT NOT NULL, PRIMARY KEY(`locale_taskId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `ModuleWithLessons` (`locale_moduleId` TEXT NOT NULL, `locale_lessonId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`, `locale_lessonId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithLessons_locale_moduleId` ON `ModuleWithLessons` (`locale_moduleId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithLessons_locale_lessonId` ON `ModuleWithLessons` (`locale_lessonId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `ProgramWithModules` (`locale_programId` TEXT NOT NULL, `locale_moduleId` TEXT NOT NULL, PRIMARY KEY(`locale_programId`, `locale_moduleId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ProgramWithModules_locale_programId` ON `ProgramWithModules` (`locale_programId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_ProgramWithModules_locale_moduleId` ON `ProgramWithModules` (`locale_moduleId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `QuestionWithArticle` (`locale_articleId` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`, `locale_articleId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_QuestionWithArticle_locale_articleId` ON `QuestionWithArticle` (`locale_articleId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_QuestionWithArticle_locale_questionId` ON `QuestionWithArticle` (`locale_questionId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickWithSteps` (`locale_stepId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithSteps_locale_stepId` ON `TrickWithSteps` (`locale_stepId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithSteps_locale_trickId` ON `TrickWithSteps` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickWithVideoSteps` (`locale_stepId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVideoSteps_locale_stepId` ON `TrickWithVideoSteps` (`locale_stepId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVideoSteps_locale_trickId` ON `TrickWithVideoSteps` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `OnboardingQuestionEntity` (`questionId` TEXT NOT NULL, `text` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale` TEXT NOT NULL, `childOrderList` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `OnboardingAnswerEntity` (`answerId` TEXT NOT NULL, `text` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale` TEXT NOT NULL, `locale_answerId` TEXT NOT NULL, PRIMARY KEY(`locale_answerId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `OnboardingQuestionWithAnswer` (`locale_questionId` TEXT NOT NULL, `locale_answerId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`, `locale_answerId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_OnboardingQuestionWithAnswer_locale_questionId` ON `OnboardingQuestionWithAnswer` (`locale_questionId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_OnboardingQuestionWithAnswer_locale_answerId` ON `OnboardingQuestionWithAnswer` (`locale_answerId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickCategoryEntity` (`categoryId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_categoryId` TEXT NOT NULL, PRIMARY KEY(`locale_categoryId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickVariationEntity` (`tips` TEXT NOT NULL, `variationId` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `locale` TEXT NOT NULL, `contentfulId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_variationId` TEXT NOT NULL, PRIMARY KEY(`locale_variationId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickWithVariations` (`locale_variationId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_variationId`, `locale_trickId`))");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVariations_locale_variationId` ON `TrickWithVariations` (`locale_variationId`)");
            gVar.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVariations_locale_trickId` ON `TrickWithVariations` (`locale_trickId`)");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c721869b5384407530df9939ea8c8d1b')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `BreedEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrickEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrickStepEntity`");
            gVar.C("DROP TABLE IF EXISTS `VideoStepEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrickTagEntity`");
            gVar.C("DROP TABLE IF EXISTS `ArticleWithTags`");
            gVar.C("DROP TABLE IF EXISTS `LessonWithTrick`");
            gVar.C("DROP TABLE IF EXISTS `LessonWithQuestion`");
            gVar.C("DROP TABLE IF EXISTS `LessonWithTask`");
            gVar.C("DROP TABLE IF EXISTS `ModuleWithExams`");
            gVar.C("DROP TABLE IF EXISTS `TrickWithTags`");
            gVar.C("DROP TABLE IF EXISTS `ArticleEntity`");
            gVar.C("DROP TABLE IF EXISTS `ArticleTagEntity`");
            gVar.C("DROP TABLE IF EXISTS `LessonEntity`");
            gVar.C("DROP TABLE IF EXISTS `ModuleEntity`");
            gVar.C("DROP TABLE IF EXISTS `ProgramEntity`");
            gVar.C("DROP TABLE IF EXISTS `QuestionEntity`");
            gVar.C("DROP TABLE IF EXISTS `TaskEntity`");
            gVar.C("DROP TABLE IF EXISTS `ModuleWithLessons`");
            gVar.C("DROP TABLE IF EXISTS `ProgramWithModules`");
            gVar.C("DROP TABLE IF EXISTS `QuestionWithArticle`");
            gVar.C("DROP TABLE IF EXISTS `TrickWithSteps`");
            gVar.C("DROP TABLE IF EXISTS `TrickWithVideoSteps`");
            gVar.C("DROP TABLE IF EXISTS `OnboardingQuestionEntity`");
            gVar.C("DROP TABLE IF EXISTS `OnboardingAnswerEntity`");
            gVar.C("DROP TABLE IF EXISTS `OnboardingQuestionWithAnswer`");
            gVar.C("DROP TABLE IF EXISTS `TrickCategoryEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrickVariationEntity`");
            gVar.C("DROP TABLE IF EXISTS `TrickWithVariations`");
            if (this.b.g != null) {
                i = 0;
                while (this.b < this.b.g.size()) {
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
                while (this.b.g < this.b.g.size()) {
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
            HashMap hashMap = new HashMap(5);
            g.a aVar122 = new g.a("breedId", "TEXT", true, 0, null, 1);
            hashMap.put("breedId", aVar122);
            g.a aVar123 = new g.a("title", "TEXT", true, 0, null, 1);
            String str3 = "title";
            hashMap.put(str3, aVar123);
            g.a aVar124 = new g.a("locale", "TEXT", true, 0, null, 1);
            String str7 = "locale";
            hashMap.put(str7, aVar124);
            g.a aVar125 = new g.a("updatedAt", "INTEGER", true, 0, null, 1);
            String str6 = "updatedAt";
            hashMap.put(str6, aVar125);
            g.a aVar126 = new g.a("locale_breedId", "TEXT", true, 1, null, 1);
            hashMap.put("locale_breedId", aVar126);
            int i74 = 0;
            androidx.room.f1.g gVar52 = new g("BreedEntity", hashMap, new HashSet(i74), new HashSet(i74));
            androidx.room.f1.g gVar4 = g.a(gVar2, "BreedEntity");
            String str126 = "\n Found:\n";
            if (!gVar52.equals(gVar4)) {
                StringBuilder stringBuilder27 = new StringBuilder();
                String str74 = "BreedEntity(app.dogo.android.persistencedb.room.entity.BreedEntity).\n Expected:\n";
                r1 = str74 + gVar52 + str126 + gVar4;
                return new w0.b(false, r1);
            }
            HashMap hashMap2 = new HashMap(18);
            g.a aVar127 = new g.a("trickId", "TEXT", true, 0, null, 1);
            hashMap2.put("trickId", aVar127);
            boolean z3 = true;
            int i114 = 0;
            String str213 = null;
            int i126 = 1;
            g.a aVar128 = new g.a("name", "TEXT", z3, i114, str213, i126);
            String str2 = "name";
            hashMap2.put(str2, aVar128);
            g.a aVar129 = new g.a("image", "TEXT", z3, i114, str213, i126);
            String str10 = "image";
            hashMap2.put(str10, aVar129);
            g.a aVar130 = new g.a("categoryName", "TEXT", true, 0, null, 1);
            hashMap2.put("categoryName", aVar130);
            int i128 = 0;
            String str237 = null;
            int i134 = 1;
            g.a aVar131 = new g.a("categoryId", "TEXT", true, i128, str237, i134);
            String str = "categoryId";
            hashMap2.put(str, aVar131);
            g.a aVar132 = new g.a("examInstructions", "TEXT", false, i128, str237, i134);
            hashMap2.put("examInstructions", aVar132);
            int i132 = 0;
            String str239 = null;
            int i137 = 1;
            g.a aVar133 = new g.a("examTimeLimit", "INTEGER", i128, i132, str239, i137);
            hashMap2.put("examTimeLimit", aVar133);
            g.a aVar134 = new g.a("sortOrder", "INTEGER", i128, i132, str239, i137);
            hashMap2.put("sortOrder", aVar134);
            boolean z4 = true;
            g.a aVar135 = new g.a("isExam", "INTEGER", z4, i132, str239, i137);
            hashMap2.put("isExam", aVar135);
            g.a aVar136 = new g.a("hasProgress", "INTEGER", z4, i132, str239, i137);
            hashMap2.put("hasProgress", aVar136);
            g.a aVar137 = new g.a("updatedAt", "INTEGER", z4, i132, str239, i137);
            hashMap2.put(str6, aVar137);
            String str278 = null;
            int i155 = 1;
            g.a aVar138 = new g.a("videoId", "TEXT", false, 0, str278, i155);
            hashMap2.put("videoId", aVar138);
            boolean z5 = false;
            g.a aVar139 = new g.a("videoThumbnail", "TEXT", z5, i132, str239, i137);
            hashMap2.put("videoThumbnail", aVar139);
            g.a aVar140 = new g.a("description", "TEXT", z5, i132, str239, i137);
            String str4 = "description";
            hashMap2.put(str4, aVar140);
            g.a aVar141 = new g.a("locale", "TEXT", true, i132, str239, i137);
            hashMap2.put(str7, aVar141);
            g.a aVar142 = new g.a("locale_trickId", "TEXT", true, 1, str278, i155);
            String str197 = "locale_trickId";
            hashMap2.put(str197, aVar142);
            g.a aVar143 = new g.a("imageStepOrder", "TEXT", true, 0, null, 1);
            hashMap2.put("imageStepOrder", aVar143);
            g.a aVar144 = new g.a("videoStepOder", "TEXT", true, 0, null, 1);
            hashMap2.put("videoStepOder", aVar144);
            androidx.room.f1.g gVar59 = new g("TrickEntity", hashMap2, new HashSet(i74), new HashSet(i74));
            androidx.room.f1.g gVar5 = g.a(gVar2, "TrickEntity");
            if (!gVar59.equals(gVar5)) {
                StringBuilder stringBuilder26 = new StringBuilder();
                String str73 = "TrickEntity(app.dogo.android.persistencedb.room.entity.TrickEntity).\n Expected:\n";
                r1 = str73 + gVar59 + str126 + gVar5;
                return new w0.b(false, r1);
            }
            HashMap hashMap3 = new HashMap(6);
            boolean z6 = true;
            int i143 = 0;
            String str263 = null;
            int i147 = 1;
            g.a aVar145 = new g.a("stepId", "TEXT", z6, i143, str263, i147);
            hashMap3.put("stepId", aVar145);
            g.a aVar146 = new g.a("description", "TEXT", z6, i143, str263, i147);
            hashMap3.put(str4, aVar146);
            boolean z12 = true;
            int i161 = 0;
            String str310 = null;
            int i168 = 1;
            g.a aVar147 = new g.a("image", "TEXT", z12, i161, str310, i168);
            hashMap3.put(str10, aVar147);
            g.a aVar148 = new g.a("locale", "TEXT", z6, i143, str263, i147);
            hashMap3.put(str7, aVar148);
            g.a aVar149 = new g.a("updatedAt", "INTEGER", z12, i161, str310, i168);
            hashMap3.put(str6, aVar149);
            g.a aVar150 = new g.a("locale_stepId", "TEXT", z6, 1, str263, i147);
            String str5 = "locale_stepId";
            hashMap3.put(str5, aVar150);
            androidx.room.f1.g gVar32 = new g("TrickStepEntity", hashMap3, new HashSet(i74), new HashSet(i74));
            androidx.room.f1.g gVar6 = g.a(gVar2, "TrickStepEntity");
            if (!gVar32.equals(gVar6)) {
                StringBuilder stringBuilder29 = new StringBuilder();
                String str86 = "TrickStepEntity(app.dogo.android.persistencedb.room.entity.TrickStepEntity).\n Expected:\n";
                r1 = str86 + gVar32 + str126 + gVar6;
                return new w0.b(false, r1);
            }
            HashMap hashMap4 = new HashMap(6);
            boolean z7 = true;
            int i148 = 0;
            String str272 = null;
            int i152 = 1;
            g.a aVar = new g.a("stepId", "TEXT", z7, i148, str272, i152);
            hashMap4.put("stepId", aVar);
            g.a aVar2 = new g.a("text", "TEXT", z7, i148, str272, i152);
            String str44 = "text";
            hashMap4.put(str44, aVar2);
            g.a aVar3 = new g.a("locale", "TEXT", z7, i148, str272, i152);
            hashMap4.put(str7, aVar3);
            boolean z14 = true;
            String str336 = null;
            int i181 = 1;
            g.a aVar4 = new g.a("startTime", "INTEGER", z14, 0, str336, i181);
            hashMap4.put("startTime", aVar4);
            g.a aVar5 = new g.a("updatedAt", "INTEGER", z7, i148, str272, i152);
            hashMap4.put(str6, aVar5);
            g.a aVar6 = new g.a("locale_stepId", "TEXT", z14, 1, str336, i181);
            hashMap4.put(str5, aVar6);
            int i75 = 0;
            androidx.room.f1.g gVar47 = new g("VideoStepEntity", hashMap4, new HashSet(i75), new HashSet(i75));
            androidx.room.f1.g gVar7 = g.a(gVar2, "VideoStepEntity");
            if (!gVar47.equals(gVar7)) {
                StringBuilder stringBuilder25 = new StringBuilder();
                String str72 = "VideoStepEntity(app.dogo.android.persistencedb.room.entity.VideoStepEntity).\n Expected:\n";
                r1 = str72 + gVar47 + str126 + gVar7;
                return new w0.b(false, r1);
            }
            HashMap hashMap5 = new HashMap(5);
            boolean z8 = true;
            int i151 = 0;
            String str281 = null;
            int i156 = 1;
            g.a aVar7 = new g.a("tagId", "TEXT", z8, i151, str281, i156);
            hashMap5.put("tagId", aVar7);
            g.a aVar8 = new g.a("locale", "TEXT", z8, i151, str281, i156);
            hashMap5.put(str7, aVar8);
            boolean z15 = true;
            String str359 = null;
            int i188 = 1;
            g.a aVar9 = new g.a("name", "TEXT", z15, 0, str359, i188);
            hashMap5.put(str2, aVar9);
            g.a aVar10 = new g.a("updatedAt", "INTEGER", z8, i151, str281, i156);
            hashMap5.put(str6, aVar10);
            g.a aVar11 = new g.a("locale_tagId", "TEXT", z15, 1, str359, i188);
            String str109 = "locale_tagId";
            hashMap5.put(str109, aVar11);
            int i116 = 0;
            androidx.room.f1.g gVar58 = new g("TrickTagEntity", hashMap5, new HashSet(i116), new HashSet(i116));
            androidx.room.f1.g gVar8 = g.a(gVar2, "TrickTagEntity");
            if (!gVar58.equals(gVar8)) {
                StringBuilder stringBuilder24 = new StringBuilder();
                String str71 = "TrickTagEntity(app.dogo.android.persistencedb.room.entity.TrickTagEntity).\n Expected:\n";
                r1 = str71 + gVar58 + str126 + gVar8;
                return new w0.b(false, r1);
            }
            int i6 = 2;
            HashMap hashMap6 = new HashMap(i6);
            boolean z9 = true;
            String str289 = null;
            int i157 = 1;
            g.a aVar151 = new g.a("locale_articleId", "TEXT", z9, 1, str289, i157);
            String str11 = "locale_articleId";
            hashMap6.put(str11, aVar151);
            g.a aVar152 = new g.a("locale_tagId", "TEXT", z9, 2, str289, i157);
            hashMap6.put(str109, aVar152);
            HashSet hashSet57 = new HashSet(i6);
            String str269 = "ASC";
            boolean z = false;
            hashSet57.add(new g.d("index_ArticleWithTags_locale_articleId", z, Arrays.asList(new String[] { str11 }), Arrays.asList(new String[] { str269 })));
            hashSet57.add(new g.d("index_ArticleWithTags_locale_tagId", z, Arrays.asList(new String[] { str109 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar33 = new g("ArticleWithTags", hashMap6, new HashSet(0), hashSet57);
            androidx.room.f1.g gVar9 = g.a(gVar2, "ArticleWithTags");
            if (!gVar33.equals(gVar9)) {
                StringBuilder stringBuilder28 = new StringBuilder();
                String str85 = "ArticleWithTags(app.dogo.android.persistencedb.room.junction.ArticleWithTags).\n Expected:\n";
                r1 = str85 + gVar33 + str126 + gVar9;
                return new w0.b(false, r1);
            }
            HashMap hashMap7 = new HashMap(2);
            boolean z16 = true;
            String str360 = null;
            int i189 = 1;
            g.a aVar12 = new g.a("locale_lessonId", "TEXT", z16, 1, str360, i189);
            String str89 = "locale_lessonId";
            hashMap7.put(str89, aVar12);
            g.a aVar13 = new g.a("locale_trickId", "TEXT", z16, 2, str360, i189);
            hashMap7.put(str197, aVar13);
            int i70 = 0;
            HashSet hashSet41 = new HashSet(2);
            hashSet41.add(new g.d("index_LessonWithTrick_locale_lessonId", i70, Arrays.asList(new String[] { str89 }), Arrays.asList(new String[] { str269 })));
            hashSet41.add(new g.d("index_LessonWithTrick_locale_trickId", i70, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar44 = new g("LessonWithTrick", hashMap7, new HashSet(i70), hashSet41);
            androidx.room.f1.g gVar10 = g.a(gVar2, "LessonWithTrick");
            if (!gVar44.equals(gVar10)) {
                StringBuilder stringBuilder23 = new StringBuilder();
                String str70 = "LessonWithTrick(app.dogo.android.persistencedb.room.junction.LessonWithTrick).\n Expected:\n";
                r1 = str70 + gVar44 + str126 + gVar10;
                return new w0.b(false, r1);
            }
            HashMap hashMap8 = new HashMap(2);
            g.a aVar14 = new g.a("locale_lessonId", "TEXT", true, 1, null, 1);
            hashMap8.put(str89, aVar14);
            g.a aVar15 = new g.a("locale_questionId", "TEXT", true, 2, null, 1);
            String str8 = "locale_questionId";
            hashMap8.put(str8, aVar15);
            int i90 = 0;
            HashSet hashSet45 = new HashSet(2);
            hashSet45.add(new g.d("index_LessonWithQuestion_locale_lessonId", i90, Arrays.asList(new String[] { str89 }), Arrays.asList(new String[] { str269 })));
            hashSet45.add(new g.d("index_LessonWithQuestion_locale_questionId", i90, Arrays.asList(new String[] { str8 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar53 = new g("LessonWithQuestion", hashMap8, new HashSet(i90), hashSet45);
            androidx.room.f1.g gVar11 = g.a(gVar2, "LessonWithQuestion");
            if (!gVar53.equals(gVar11)) {
                StringBuilder stringBuilder22 = new StringBuilder();
                String str69 = "LessonWithQuestion(app.dogo.android.persistencedb.room.junction.LessonWithQuestion).\n Expected:\n";
                r1 = str69 + gVar53 + str126 + gVar11;
                return new w0.b(false, r1);
            }
            HashMap hashMap9 = new HashMap(2);
            g.a aVar16 = new g.a("locale_lessonId", "TEXT", true, 1, null, 1);
            hashMap9.put(str89, aVar16);
            g.a aVar17 = new g.a("locale_taskId", "TEXT", true, 2, null, 1);
            String str9 = "locale_taskId";
            hashMap9.put(str9, aVar17);
            int i96 = 0;
            HashSet hashSet50 = new HashSet(2);
            hashSet50.add(new g.d("index_LessonWithTask_locale_lessonId", i96, Arrays.asList(new String[] { str89 }), Arrays.asList(new String[] { str269 })));
            hashSet50.add(new g.d("index_LessonWithTask_locale_taskId", i96, Arrays.asList(new String[] { str9 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar45 = new g("LessonWithTask", hashMap9, new HashSet(i96), hashSet50);
            androidx.room.f1.g gVar12 = g.a(gVar2, "LessonWithTask");
            if (!gVar45.equals(gVar12)) {
                StringBuilder stringBuilder21 = new StringBuilder();
                String str68 = "LessonWithTask(app.dogo.android.persistencedb.room.junction.LessonWithTask).\n Expected:\n";
                r1 = str68 + gVar45 + str126 + gVar12;
                return new w0.b(false, r1);
            }
            HashMap hashMap10 = new HashMap(2);
            boolean z22 = true;
            String str472 = null;
            int i243 = 1;
            g.a aVar18 = new g.a("locale_moduleId", "TEXT", z22, 1, str472, i243);
            String str97 = "locale_moduleId";
            hashMap10.put(str97, aVar18);
            g.a aVar19 = new g.a("locale_trickId", "TEXT", z22, 2, str472, i243);
            hashMap10.put(str197, aVar19);
            int i97 = 0;
            HashSet hashSet51 = new HashSet(2);
            hashSet51.add(new g.d("index_ModuleWithExams_locale_moduleId", i97, Arrays.asList(new String[] { str97 }), Arrays.asList(new String[] { str269 })));
            hashSet51.add(new g.d("index_ModuleWithExams_locale_trickId", i97, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar54 = new g("ModuleWithExams", hashMap10, new HashSet(i97), hashSet51);
            androidx.room.f1.g gVar13 = g.a(gVar2, "ModuleWithExams");
            if (!gVar54.equals(gVar13)) {
                StringBuilder stringBuilder20 = new StringBuilder();
                String str67 = "ModuleWithExams(app.dogo.android.persistencedb.room.junction.ModuleWithExams).\n Expected:\n";
                r1 = str67 + gVar54 + str126 + gVar13;
                return new w0.b(false, r1);
            }
            HashMap hashMap11 = new HashMap(2);
            g.a aVar20 = new g.a("locale_tagId", "TEXT", true, 1, null, 1);
            hashMap11.put(str109, aVar20);
            g.a aVar21 = new g.a("locale_trickId", "TEXT", true, 2, null, 1);
            hashMap11.put(str197, aVar21);
            int i91 = 0;
            HashSet hashSet46 = new HashSet(2);
            hashSet46.add(new g.d("index_TrickWithTags_locale_tagId", i91, Arrays.asList(new String[] { str109 }), Arrays.asList(new String[] { str269 })));
            hashSet46.add(new g.d("index_TrickWithTags_locale_trickId", i91, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar55 = new g("TrickWithTags", hashMap11, new HashSet(i91), hashSet46);
            androidx.room.f1.g gVar14 = g.a(gVar2, "TrickWithTags");
            if (!gVar55.equals(gVar14)) {
                StringBuilder stringBuilder19 = new StringBuilder();
                String str66 = "TrickWithTags(app.dogo.android.persistencedb.room.junction.TrickWithTags).\n Expected:\n";
                r1 = str66 + gVar55 + str126 + gVar14;
                return new w0.b(false, r1);
            }
            HashMap hashMap12 = new HashMap(11);
            boolean z24 = true;
            int i222 = 0;
            String str476 = null;
            int i247 = 1;
            g.a aVar22 = new g.a("articleId", "TEXT", z24, i222, str476, i247);
            hashMap12.put("articleId", aVar22);
            g.a aVar23 = new g.a("title", "TEXT", z24, i222, str476, i247);
            hashMap12.put(str3, aVar23);
            g.a aVar24 = new g.a("text", "TEXT", true, 0, null, 1);
            hashMap12.put(str44, aVar24);
            g.a aVar25 = new g.a("readingTime", "INTEGER", z24, i222, str476, i247);
            hashMap12.put("readingTime", aVar25);
            g.a aVar26 = new g.a("sortOrder", "INTEGER", false, i222, str476, i247);
            hashMap12.put("sortOrder", aVar26);
            g.a aVar27 = new g.a("categoryId", "TEXT", true, i222, str476, i247);
            hashMap12.put(str, aVar27);
            g.a aVar28 = new g.a("image", "TEXT", false, i222, str476, i247);
            hashMap12.put(str10, aVar28);
            boolean z25 = true;
            g.a aVar29 = new g.a("locale", "TEXT", z25, i222, str476, i247);
            hashMap12.put(str7, aVar29);
            g.a aVar30 = new g.a("updatedAt", "INTEGER", z25, i222, str476, i247);
            hashMap12.put(str6, aVar30);
            g.a aVar31 = new g.a("locale_articleId", "TEXT", z25, 1, str476, i247);
            hashMap12.put(str11, aVar31);
            g.a aVar32 = new g.a("textHtml", "TEXT", false, 0, str476, i247);
            hashMap12.put("textHtml", aVar32);
            int i123 = 0;
            androidx.room.f1.g gVar60 = new g("ArticleEntity", hashMap12, new HashSet(i123), new HashSet(i123));
            androidx.room.f1.g gVar15 = g.a(gVar2, "ArticleEntity");
            if (!gVar60.equals(gVar15)) {
                StringBuilder stringBuilder18 = new StringBuilder();
                String str65 = "ArticleEntity(app.dogo.android.persistencedb.room.entity.ArticleEntity).\n Expected:\n";
                r1 = str65 + gVar60 + str126 + gVar15;
                return new w0.b(false, r1);
            }
            HashMap hashMap13 = new HashMap(6);
            boolean z26 = true;
            int i225 = 0;
            String str477 = null;
            int i248 = 1;
            g.a aVar33 = new g.a("hidden", "INTEGER", z26, i225, str477, i248);
            hashMap13.put("hidden", aVar33);
            g.a aVar34 = new g.a("tagId", "TEXT", z26, i225, str477, i248);
            hashMap13.put("tagId", aVar34);
            g.a aVar35 = new g.a("locale", "TEXT", z26, i225, str477, i248);
            hashMap13.put(str7, aVar35);
            boolean z34 = true;
            String str529 = null;
            int i309 = 1;
            g.a aVar36 = new g.a("name", "TEXT", z34, 0, str529, i309);
            hashMap13.put(str2, aVar36);
            g.a aVar37 = new g.a("updatedAt", "INTEGER", z26, i225, str477, i248);
            hashMap13.put(str6, aVar37);
            g.a aVar38 = new g.a("locale_tagId", "TEXT", z34, 1, str529, i309);
            hashMap13.put(str109, aVar38);
            int i76 = 0;
            androidx.room.f1.g gVar48 = new g("ArticleTagEntity", hashMap13, new HashSet(i76), new HashSet(i76));
            androidx.room.f1.g gVar16 = g.a(gVar2, "ArticleTagEntity");
            if (!gVar48.equals(gVar16)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str45 = "ArticleTagEntity(app.dogo.android.persistencedb.room.entity.ArticleTagEntity).\n Expected:\n";
                r1 = str45 + gVar48 + str126 + gVar16;
                return new w0.b(false, r1);
            }
            HashMap hashMap14 = new HashMap(6);
            boolean z27 = true;
            int i226 = 0;
            String str478 = null;
            int i249 = 1;
            g.a aVar39 = new g.a("lessonId", "TEXT", z27, i226, str478, i249);
            hashMap14.put("lessonId", aVar39);
            g.a aVar40 = new g.a("index", "INTEGER", z27, i226, str478, i249);
            hashMap14.put("index", aVar40);
            g.a aVar41 = new g.a("locale", "TEXT", z27, i226, str478, i249);
            hashMap14.put(str7, aVar41);
            boolean z35 = true;
            String str530 = null;
            int i310 = 1;
            g.a aVar42 = new g.a("programId", "TEXT", z35, 0, str530, i310);
            hashMap14.put("programId", aVar42);
            g.a aVar43 = new g.a("updatedAt", "INTEGER", z27, i226, str478, i249);
            hashMap14.put(str6, aVar43);
            g.a aVar44 = new g.a("locale_lessonId", "TEXT", z35, 1, str530, i310);
            hashMap14.put(str89, aVar44);
            int i77 = 0;
            androidx.room.f1.g gVar49 = new g("LessonEntity", hashMap14, new HashSet(i77), new HashSet(i77));
            androidx.room.f1.g gVar17 = g.a(gVar2, "LessonEntity");
            if (!gVar49.equals(gVar17)) {
                StringBuilder stringBuilder17 = new StringBuilder();
                String str64 = "LessonEntity(app.dogo.android.persistencedb.room.entity.LessonEntity).\n Expected:\n";
                r1 = str64 + gVar49 + str126 + gVar17;
                return new w0.b(false, r1);
            }
            HashMap hashMap15 = new HashMap(6);
            boolean z28 = true;
            int i227 = 0;
            String str479 = null;
            int i250 = 1;
            g.a aVar45 = new g.a("moduleId", "TEXT", z28, i227, str479, i250);
            hashMap15.put("moduleId", aVar45);
            g.a aVar46 = new g.a("index", "INTEGER", z28, i227, str479, i250);
            hashMap15.put("index", aVar46);
            g.a aVar47 = new g.a("name", "TEXT", z28, i227, str479, i250);
            hashMap15.put(str2, aVar47);
            boolean z36 = true;
            String str531 = null;
            int i311 = 1;
            g.a aVar48 = new g.a("locale", "TEXT", z36, 0, str531, i311);
            hashMap15.put(str7, aVar48);
            g.a aVar49 = new g.a("updatedAt", "INTEGER", z28, i227, str479, i250);
            hashMap15.put(str6, aVar49);
            g.a aVar50 = new g.a("locale_moduleId", "TEXT", z36, 1, str531, i311);
            hashMap15.put(str97, aVar50);
            int i78 = 0;
            androidx.room.f1.g gVar50 = new g("ModuleEntity", hashMap15, new HashSet(i78), new HashSet(i78));
            androidx.room.f1.g gVar18 = g.a(gVar2, "ModuleEntity");
            if (!gVar50.equals(gVar18)) {
                StringBuilder stringBuilder16 = new StringBuilder();
                String str63 = "ModuleEntity(app.dogo.android.persistencedb.room.entity.ModuleEntity).\n Expected:\n";
                r1 = str63 + gVar50 + str126 + gVar18;
                return new w0.b(false, r1);
            }
            HashMap hashMap16 = new HashMap(21);
            boolean z29 = true;
            int i228 = 0;
            String str480 = null;
            int i251 = 1;
            g.a aVar51 = new g.a("type", "TEXT", z29, i228, str480, i251);
            hashMap16.put("type", aVar51);
            g.a aVar52 = new g.a("programId", "TEXT", z29, i228, str480, i251);
            hashMap16.put("programId", aVar52);
            g.a aVar53 = new g.a("name", "TEXT", z29, i228, str480, i251);
            hashMap16.put(str2, aVar53);
            boolean z37 = true;
            int i294 = 0;
            String str532 = null;
            int i312 = 1;
            g.a aVar54 = new g.a("image", "TEXT", z37, i294, str532, i312);
            hashMap16.put(str10, aVar54);
            g.a aVar55 = new g.a("centeredImage", "TEXT", z29, i228, str480, i251);
            hashMap16.put("centeredImage", aVar55);
            g.a aVar56 = new g.a("description", "TEXT", z29, i228, str480, i251);
            hashMap16.put(str4, aVar56);
            g.a aVar57 = new g.a("cardBackgroundColor", "TEXT", z29, i228, str480, i251);
            hashMap16.put("cardBackgroundColor", aVar57);
            g.a aVar58 = new g.a("certificateLaurelsImage", "TEXT", z29, i228, str480, i251);
            hashMap16.put("certificateLaurelsImage", aVar58);
            g.a aVar59 = new g.a("certificatePaperImage", "TEXT", z29, i228, str480, i251);
            hashMap16.put("certificatePaperImage", aVar59);
            g.a aVar60 = new g.a("certificatePlaceholderUrl", "TEXT", z29, i228, str480, i251);
            hashMap16.put("certificatePlaceholderUrl", aVar60);
            g.a aVar61 = new g.a("certificateRequirements", "TEXT", z29, i228, str480, i251);
            hashMap16.put("certificateRequirements", aVar61);
            g.a aVar62 = new g.a("locale", "TEXT", z29, i228, str480, i251);
            hashMap16.put(str7, aVar62);
            g.a aVar63 = new g.a("updatedAt", "INTEGER", z37, i294, str532, i312);
            hashMap16.put(str6, aVar63);
            g.a aVar64 = new g.a("locale_programId", "TEXT", z29, 1, str480, i251);
            hashMap16.put("locale_programId", aVar64);
            int i230 = 0;
            g.a aVar65 = new g.a("programOverviewImage", "TEXT", z29, i230, str480, i251);
            hashMap16.put("programOverviewImage", aVar65);
            g.a aVar66 = new g.a("dogSkillsHighlights", "TEXT", z29, i230, str480, i251);
            hashMap16.put("dogSkillsHighlights", aVar66);
            g.a aVar67 = new g.a("dogSkillsOverview", "TEXT", z29, i230, str480, i251);
            hashMap16.put("dogSkillsOverview", aVar67);
            g.a aVar68 = new g.a("userSkillsOverview", "TEXT", z29, i230, str480, i251);
            hashMap16.put("userSkillsOverview", aVar68);
            g.a aVar69 = new g.a("averageCompletionTimeWeeks", "INTEGER", z29, i230, str480, i251);
            hashMap16.put("averageCompletionTimeWeeks", aVar69);
            g.a aVar70 = new g.a("numberOfEnrolledUsers", "INTEGER", z29, i230, str480, i251);
            hashMap16.put("numberOfEnrolledUsers", aVar70);
            g.a aVar71 = new g.a("certificatePreviewImage", "TEXT", z29, i230, str480, i251);
            hashMap16.put("certificatePreviewImage", aVar71);
            int i92 = 0;
            androidx.room.f1.g gVar56 = new g("ProgramEntity", hashMap16, new HashSet(i92), new HashSet(i92));
            androidx.room.f1.g gVar19 = g.a(gVar2, "ProgramEntity");
            if (!gVar56.equals(gVar19)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str46 = "ProgramEntity(app.dogo.android.persistencedb.room.entity.ProgramEntity).\n Expected:\n";
                r1 = str46 + gVar56 + str126 + gVar19;
                return new w0.b(false, r1);
            }
            HashMap hashMap17 = new HashMap(7);
            boolean z30 = true;
            int i231 = 0;
            String str481 = null;
            int i252 = 1;
            g.a aVar72 = new g.a("questionId", "TEXT", z30, i231, str481, i252);
            hashMap17.put("questionId", aVar72);
            g.a aVar73 = new g.a("locale", "TEXT", z30, i231, str481, i252);
            hashMap17.put(str7, aVar73);
            boolean z38 = true;
            String str533 = null;
            int i313 = 1;
            g.a aVar74 = new g.a("question", "TEXT", z38, 0, str533, i313);
            hashMap17.put("question", aVar74);
            g.a aVar75 = new g.a("answers", "TEXT", z30, i231, str481, i252);
            hashMap17.put("answers", aVar75);
            g.a aVar76 = new g.a("correctAnswer", "INTEGER", z30, i231, str481, i252);
            hashMap17.put("correctAnswer", aVar76);
            g.a aVar77 = new g.a("updatedAt", "INTEGER", z30, i231, str481, i252);
            hashMap17.put(str6, aVar77);
            g.a aVar78 = new g.a("locale_questionId", "TEXT", z38, 1, str533, i313);
            hashMap17.put(str8, aVar78);
            int i98 = 0;
            androidx.room.f1.g gVar57 = new g("QuestionEntity", hashMap17, new HashSet(i98), new HashSet(i98));
            androidx.room.f1.g gVar20 = g.a(gVar2, "QuestionEntity");
            if (!gVar57.equals(gVar20)) {
                StringBuilder stringBuilder15 = new StringBuilder();
                String str62 = "QuestionEntity(app.dogo.android.persistencedb.room.entity.QuestionEntity).\n Expected:\n";
                r1 = str62 + gVar57 + str126 + gVar20;
                return new w0.b(false, r1);
            }
            HashMap hashMap18 = new HashMap(5);
            boolean z31 = true;
            int i232 = 0;
            String str482 = null;
            int i253 = 1;
            g.a aVar79 = new g.a("taskId", "TEXT", z31, i232, str482, i253);
            hashMap18.put("taskId", aVar79);
            g.a aVar80 = new g.a("text", "TEXT", z31, i232, str482, i253);
            hashMap18.put(str44, aVar80);
            boolean z39 = true;
            String str534 = null;
            int i314 = 1;
            g.a aVar81 = new g.a("locale", "TEXT", z39, 0, str534, i314);
            hashMap18.put(str7, aVar81);
            g.a aVar82 = new g.a("updatedAt", "INTEGER", z31, i232, str482, i253);
            hashMap18.put(str6, aVar82);
            g.a aVar83 = new g.a("locale_taskId", "TEXT", z39, 1, str534, i314);
            hashMap18.put(str9, aVar83);
            int i79 = 0;
            androidx.room.f1.g gVar51 = new g("TaskEntity", hashMap18, new HashSet(i79), new HashSet(i79));
            androidx.room.f1.g gVar21 = g.a(gVar2, "TaskEntity");
            if (!gVar51.equals(gVar21)) {
                StringBuilder stringBuilder14 = new StringBuilder();
                String str61 = "TaskEntity(app.dogo.android.persistencedb.room.entity.TaskEntity).\n Expected:\n";
                r1 = str61 + gVar51 + str126 + gVar21;
                return new w0.b(false, r1);
            }
            HashMap hashMap19 = new HashMap(2);
            g.a aVar84 = new g.a("locale_moduleId", "TEXT", true, 1, null, 1);
            hashMap19.put(str97, aVar84);
            g.a aVar85 = new g.a("locale_lessonId", "TEXT", true, 2, null, 1);
            hashMap19.put(str89, aVar85);
            HashSet hashSet49 = new HashSet(2);
            boolean z2 = false;
            hashSet49.add(new g.d("index_ModuleWithLessons_locale_moduleId", z2, Arrays.asList(new String[] { str97 }), Arrays.asList(new String[] { str269 })));
            hashSet49.add(new g.d("index_ModuleWithLessons_locale_lessonId", z2, Arrays.asList(new String[] { str89 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar39 = new g("ModuleWithLessons", hashMap19, new HashSet(0), hashSet49);
            androidx.room.f1.g gVar22 = g.a(gVar2, "ModuleWithLessons");
            if (!gVar39.equals(gVar22)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str47 = "ModuleWithLessons(app.dogo.android.persistencedb.room.junction.ModuleWithLessons).\n Expected:\n";
                r1 = str47 + gVar39 + str126 + gVar22;
                return new w0.b(false, r1);
            }
            HashMap hashMap20 = new HashMap(2);
            boolean z17 = true;
            String str466 = null;
            int i234 = 1;
            g.a aVar86 = new g.a("locale_programId", "TEXT", z17, 1, str466, i234);
            hashMap20.put("locale_programId", aVar86);
            g.a aVar87 = new g.a("locale_moduleId", "TEXT", z17, 2, str466, i234);
            hashMap20.put(str97, aVar87);
            int i64 = 0;
            HashSet hashSet32 = new HashSet(2);
            hashSet32.add(new g.d("index_ProgramWithModules_locale_programId", i64, Arrays.asList(new String[] { "locale_programId" }), Arrays.asList(new String[] { str269 })));
            hashSet32.add(new g.d("index_ProgramWithModules_locale_moduleId", i64, Arrays.asList(new String[] { str97 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar40 = new g("ProgramWithModules", hashMap20, new HashSet(i64), hashSet32);
            androidx.room.f1.g gVar23 = g.a(gVar2, "ProgramWithModules");
            if (!gVar40.equals(gVar23)) {
                StringBuilder stringBuilder13 = new StringBuilder();
                String str60 = "ProgramWithModules(app.dogo.android.persistencedb.room.junction.ProgramWithModules).\n Expected:\n";
                r1 = str60 + gVar40 + str126 + gVar23;
                return new w0.b(false, r1);
            }
            HashMap hashMap21 = new HashMap(2);
            g.a aVar88 = new g.a("locale_articleId", "TEXT", true, 2, null, 1);
            hashMap21.put(str11, aVar88);
            g.a aVar89 = new g.a("locale_questionId", "TEXT", true, 1, null, 1);
            hashMap21.put(str8, aVar89);
            int i65 = 0;
            HashSet hashSet33 = new HashSet(2);
            hashSet33.add(new g.d("index_QuestionWithArticle_locale_articleId", i65, Arrays.asList(new String[] { str11 }), Arrays.asList(new String[] { str269 })));
            hashSet33.add(new g.d("index_QuestionWithArticle_locale_questionId", i65, Arrays.asList(new String[] { str8 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar41 = new g("QuestionWithArticle", hashMap21, new HashSet(i65), hashSet33);
            androidx.room.f1.g gVar24 = g.a(gVar2, "QuestionWithArticle");
            if (!gVar41.equals(gVar24)) {
                StringBuilder stringBuilder12 = new StringBuilder();
                String str59 = "QuestionWithArticle(app.dogo.android.persistencedb.room.junction.QuestionWithArticle).\n Expected:\n";
                r1 = str59 + gVar41 + str126 + gVar24;
                return new w0.b(false, r1);
            }
            HashMap hashMap22 = new HashMap(2);
            boolean z18 = true;
            String str467 = null;
            int i236 = 1;
            g.a aVar90 = new g.a("locale_stepId", "TEXT", z18, 1, str467, i236);
            hashMap22.put(str5, aVar90);
            g.a aVar91 = new g.a("locale_trickId", "TEXT", z18, 2, str467, i236);
            hashMap22.put(str197, aVar91);
            int i66 = 0;
            HashSet hashSet34 = new HashSet(2);
            hashSet34.add(new g.d("index_TrickWithSteps_locale_stepId", i66, Arrays.asList(new String[] { str5 }), Arrays.asList(new String[] { str269 })));
            hashSet34.add(new g.d("index_TrickWithSteps_locale_trickId", i66, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar43 = new g("TrickWithSteps", hashMap22, new HashSet(i66), hashSet34);
            androidx.room.f1.g gVar25 = g.a(gVar2, "TrickWithSteps");
            if (!gVar43.equals(gVar25)) {
                StringBuilder stringBuilder11 = new StringBuilder();
                String str58 = "TrickWithSteps(app.dogo.android.persistencedb.room.junction.TrickWithSteps).\n Expected:\n";
                r1 = str58 + gVar43 + str126 + gVar25;
                return new w0.b(false, r1);
            }
            HashMap hashMap23 = new HashMap(2);
            g.a aVar92 = new g.a("locale_stepId", "TEXT", true, 1, null, 1);
            hashMap23.put(str5, aVar92);
            g.a aVar93 = new g.a("locale_trickId", "TEXT", true, 2, null, 1);
            hashMap23.put(str197, aVar93);
            int i67 = 0;
            HashSet hashSet35 = new HashSet(2);
            hashSet35.add(new g.d("index_TrickWithVideoSteps_locale_stepId", i67, Arrays.asList(new String[] { str5 }), Arrays.asList(new String[] { str269 })));
            hashSet35.add(new g.d("index_TrickWithVideoSteps_locale_trickId", i67, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar42 = new g("TrickWithVideoSteps", hashMap23, new HashSet(i67), hashSet35);
            androidx.room.f1.g gVar26 = g.a(gVar2, "TrickWithVideoSteps");
            if (!gVar42.equals(gVar26)) {
                StringBuilder stringBuilder10 = new StringBuilder();
                String str57 = "TrickWithVideoSteps(app.dogo.android.persistencedb.room.junction.TrickWithVideoSteps).\n Expected:\n";
                r1 = str57 + gVar42 + str126 + gVar26;
                return new w0.b(false, r1);
            }
            HashMap hashMap24 = new HashMap(6);
            boolean z19 = true;
            int i199 = 0;
            String str468 = null;
            int i238 = 1;
            g.a aVar94 = new g.a("questionId", "TEXT", z19, i199, str468, i238);
            hashMap24.put("questionId", aVar94);
            g.a aVar95 = new g.a("text", "TEXT", z19, i199, str468, i238);
            hashMap24.put(str44, aVar95);
            g.a aVar96 = new g.a("updatedAt", "INTEGER", true, 0, null, 1);
            hashMap24.put(str6, aVar96);
            g.a aVar97 = new g.a("locale", "TEXT", z19, i199, str468, i238);
            hashMap24.put(str7, aVar97);
            g.a aVar98 = new g.a("childOrderList", "TEXT", z19, i199, str468, i238);
            hashMap24.put("childOrderList", aVar98);
            g.a aVar99 = new g.a("locale_questionId", "TEXT", z19, 1, str468, i238);
            hashMap24.put(str8, aVar99);
            int i72 = 0;
            androidx.room.f1.g gVar46 = new g("OnboardingQuestionEntity", hashMap24, new HashSet(i72), new HashSet(i72));
            androidx.room.f1.g gVar27 = g.a(gVar2, "OnboardingQuestionEntity");
            if (!gVar46.equals(gVar27)) {
                StringBuilder stringBuilder9 = new StringBuilder();
                String str56 = "OnboardingQuestionEntity(app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity).\n Expected:\n";
                r1 = str56 + gVar46 + str126 + gVar27;
                return new w0.b(false, r1);
            }
            HashMap hashMap25 = new HashMap(5);
            boolean z20 = true;
            int i201 = 0;
            String str469 = null;
            int i239 = 1;
            g.a aVar100 = new g.a("answerId", "TEXT", z20, i201, str469, i239);
            hashMap25.put("answerId", aVar100);
            g.a aVar101 = new g.a("text", "TEXT", z20, i201, str469, i239);
            hashMap25.put(str44, aVar101);
            boolean z33 = true;
            String str528 = null;
            int i303 = 1;
            g.a aVar102 = new g.a("updatedAt", "INTEGER", z33, 0, str528, i303);
            hashMap25.put(str6, aVar102);
            g.a aVar103 = new g.a("locale", "TEXT", z20, i201, str469, i239);
            hashMap25.put(str7, aVar103);
            g.a aVar104 = new g.a("locale_answerId", "TEXT", z33, 1, str528, i303);
            hashMap25.put("locale_answerId", aVar104);
            int i59 = 0;
            androidx.room.f1.g gVar34 = new g("OnboardingAnswerEntity", hashMap25, new HashSet(i59), new HashSet(i59));
            androidx.room.f1.g gVar28 = g.a(gVar2, "OnboardingAnswerEntity");
            if (!gVar34.equals(gVar28)) {
                StringBuilder stringBuilder8 = new StringBuilder();
                String str84 = "OnboardingAnswerEntity(app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity).\n Expected:\n";
                r1 = str84 + gVar34 + str126 + gVar28;
                return new w0.b(false, r1);
            }
            HashMap hashMap26 = new HashMap(2);
            g.a aVar105 = new g.a("locale_questionId", "TEXT", true, 1, null, 1);
            hashMap26.put(str8, aVar105);
            g.a aVar106 = new g.a("locale_answerId", "TEXT", true, 2, null, 1);
            hashMap26.put("locale_answerId", aVar106);
            int i60 = 0;
            HashSet hashSet37 = new HashSet(2);
            hashSet37.add(new g.d("index_OnboardingQuestionWithAnswer_locale_questionId", i60, Arrays.asList(new String[] { str8 }), Arrays.asList(new String[] { str269 })));
            hashSet37.add(new g.d("index_OnboardingQuestionWithAnswer_locale_answerId", i60, Arrays.asList(new String[] { "locale_answerId" }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar35 = new g("OnboardingQuestionWithAnswer", hashMap26, new HashSet(i60), hashSet37);
            androidx.room.f1.g gVar29 = g.a(gVar2, "OnboardingQuestionWithAnswer");
            if (!gVar35.equals(gVar29)) {
                StringBuilder stringBuilder7 = new StringBuilder();
                String str83 = "OnboardingQuestionWithAnswer(app.dogo.android.persistencedb.room.junction.OnboardingQuestionWithAnswer).\n Expected:\n";
                r1 = str83 + gVar35 + str126 + gVar29;
                return new w0.b(false, r1);
            }
            HashMap hashMap27 = new HashMap(5);
            boolean z21 = true;
            g.a aVar107 = new g.a("categoryId", "TEXT", z21, 0, null, 1);
            hashMap27.put(str, aVar107);
            g.a aVar108 = new g.a("locale", "TEXT", true, 0, null, z21);
            hashMap27.put(str7, aVar108);
            boolean z32 = true;
            g.a aVar109 = new g.a("name", "TEXT", z32, 0, null, 1);
            hashMap27.put(str2, aVar109);
            g.a aVar110 = new g.a("updatedAt", "INTEGER", true, 0, null, 1);
            hashMap27.put(str6, aVar110);
            g.a aVar111 = new g.a("locale_categoryId", "TEXT", true, z32, null, 1);
            hashMap27.put("locale_categoryId", aVar111);
            int i61 = 0;
            androidx.room.f1.g gVar36 = new g("TrickCategoryEntity", hashMap27, new HashSet(i61), new HashSet(i61));
            androidx.room.f1.g gVar30 = g.a(gVar2, "TrickCategoryEntity");
            if (!gVar36.equals(gVar30)) {
                StringBuilder stringBuilder6 = new StringBuilder();
                String str82 = "TrickCategoryEntity(app.dogo.android.persistencedb.room.entity.TrickCategoryEntity).\n Expected:\n";
                r1 = str82 + gVar36 + str126 + gVar30;
                return new w0.b(false, r1);
            }
            HashMap hashMap28 = new HashMap(8);
            boolean z13 = true;
            int i165 = 0;
            String str335 = null;
            int i180 = 1;
            g.a aVar112 = new g.a("tips", "TEXT", z13, i165, str335, i180);
            hashMap28.put("tips", aVar112);
            g.a aVar113 = new g.a("variationId", "TEXT", z13, i165, str335, i180);
            hashMap28.put("variationId", aVar113);
            g.a aVar114 = new g.a("title", "TEXT", z13, i165, str335, i180);
            hashMap28.put(str3, aVar114);
            boolean z10 = true;
            int i158 = 0;
            String str308 = null;
            int i166 = 1;
            g.a aVar115 = new g.a("description", "TEXT", z10, i158, str308, i166);
            hashMap28.put(str4, aVar115);
            g.a aVar116 = new g.a("locale", "TEXT", z10, i158, str308, i166);
            hashMap28.put(str7, aVar116);
            boolean z23 = true;
            String str474 = null;
            int i245 = 1;
            g.a aVar117 = new g.a("contentfulId", "TEXT", z23, 0, str474, i245);
            hashMap28.put("contentfulId", aVar117);
            g.a aVar118 = new g.a("updatedAt", "INTEGER", z10, i158, str308, i166);
            hashMap28.put(str6, aVar118);
            g.a aVar119 = new g.a("locale_variationId", "TEXT", z23, 1, str474, i245);
            hashMap28.put("locale_variationId", aVar119);
            int i62 = 0;
            androidx.room.f1.g gVar37 = new g("TrickVariationEntity", hashMap28, new HashSet(i62), new HashSet(i62));
            androidx.room.f1.g gVar31 = g.a(gVar2, "TrickVariationEntity");
            if (!gVar37.equals(gVar31)) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str81 = "TrickVariationEntity(app.dogo.android.persistencedb.room.entity.TrickVariationEntity).\n Expected:\n";
                r1 = str81 + gVar37 + str126 + gVar31;
                return new w0.b(false, r1);
            }
            HashMap hashMap29 = new HashMap(2);
            boolean z11 = true;
            String str309 = null;
            int i167 = 1;
            g.a aVar120 = new g.a("locale_variationId", "TEXT", z11, 1, str309, i167);
            hashMap29.put("locale_variationId", aVar120);
            g.a aVar121 = new g.a("locale_trickId", "TEXT", z11, 2, str309, i167);
            hashMap29.put(str197, aVar121);
            int i63 = 0;
            HashSet hashSet31 = new HashSet(2);
            hashSet31.add(new g.d("index_TrickWithVariations_locale_variationId", i63, Arrays.asList(new String[] { "locale_variationId" }), Arrays.asList(new String[] { str269 })));
            hashSet31.add(new g.d("index_TrickWithVariations_locale_trickId", i63, Arrays.asList(new String[] { str197 }), Arrays.asList(new String[] { str269 })));
            androidx.room.f1.g gVar38 = new g("TrickWithVariations", hashMap29, new HashSet(i63), hashSet31);
            androidx.room.f1.g gVar3 = g.a(gVar2, "TrickWithVariations");
            if (!gVar38.equals(gVar3)) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str80 = "TrickWithVariations(app.dogo.android.persistencedb.room.junction.TrickWithVariations).\n Expected:\n";
                r0 = str80 + gVar38 + str126 + gVar3;
                return new w0.b(false, r0);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List N(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List O(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List P(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List Q(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List R(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List S(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List T(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g U(ContentDatabase_Impl contentDatabase_Impl, d.s.a.g gVar) {
        contentDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void V(ContentDatabase_Impl contentDatabase_Impl, d.s.a.g gVar) {
        contentDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List W(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static /* synthetic */ List X(ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public q H() {
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            try {
                if (this.u == null) {
                    this.u = new app.dogo.android.persistencedb.room.dao.r(this);
                }
                return this.u;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public c0 I() {
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            try {
                if (this.v == null) {
                    this.v = new app.dogo.android.persistencedb.room.dao.d0(this);
                }
                return this.v;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public e.a.a.a.b.b.e0 J() {
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new app.dogo.android.persistencedb.room.dao.f0(this);
                }
                return this.t;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public g0 K() {
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new app.dogo.android.persistencedb.room.dao.h0(this);
                }
                return this.s;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public i0 L() {
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new app.dogo.android.persistencedb.room.dao.j0(this);
                }
                return this.r;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public e.a.a.a.b.b.m0 M() {
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new app.dogo.android.persistencedb.room.dao.n0(this);
                }
                return this.q;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    protected androidx.room.m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "BreedEntity", "TrickEntity", "TrickStepEntity", "VideoStepEntity", "TrickTagEntity", "ArticleWithTags", "LessonWithTrick", "LessonWithQuestion", "LessonWithTask", "ModuleWithExams", "TrickWithTags", "ArticleEntity", "ArticleTagEntity", "LessonEntity", "ModuleEntity", "ProgramEntity", "QuestionEntity", "TaskEntity", "ModuleWithLessons", "ProgramWithModules", "QuestionWithArticle", "TrickWithSteps", "TrickWithVideoSteps", "OnboardingQuestionEntity", "OnboardingAnswerEntity", "OnboardingQuestionWithAnswer", "TrickCategoryEntity", "TrickVariationEntity", "TrickWithVariations" });
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    protected h f(androidx.room.e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new ContentDatabase_Impl.a(this, 72), "c721869b5384407530df9939ea8c8d1b", "b30f2a9f1fbcb9e03714cab51d4b2d5c"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(TrickEntityDao.class, app.dogo.android.persistencedb.room.dao.n0.X());
        hashMap.put(TaskEntityDao.class, app.dogo.android.persistencedb.room.dao.j0.e());
        hashMap.put(QuestionEntityDao.class, app.dogo.android.persistencedb.room.dao.h0.A());
        hashMap.put(ProgramEntityDao.class, app.dogo.android.persistencedb.room.dao.f0.m0());
        hashMap.put(BreedEntityDao.class, app.dogo.android.persistencedb.room.dao.r.h());
        hashMap.put(OnboardingSurveyEntityDao.class, app.dogo.android.persistencedb.room.dao.d0.q());
        return hashMap;
    }
}
