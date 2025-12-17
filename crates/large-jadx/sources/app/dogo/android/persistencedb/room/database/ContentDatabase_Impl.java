package app.dogo.android.persistencedb.room.database;

import androidx.room.e0;
import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g;
import androidx.room.f1.g.a;
import androidx.room.f1.g.d;
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
import e.a.a.a.b.b.c0;
import e.a.a.a.b.b.d0;
import e.a.a.a.b.b.e0;
import e.a.a.a.b.b.f0;
import e.a.a.a.b.b.g0;
import e.a.a.a.b.b.h0;
import e.a.a.a.b.b.i0;
import e.a.a.a.b.b.j0;
import e.a.a.a.b.b.m0;
import e.a.a.a.b.b.n0;
import e.a.a.a.b.b.q;
import e.a.a.a.b.b.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ContentDatabase_Impl extends app.dogo.android.persistencedb.room.database.ContentDatabase {

    private volatile m0 q;
    private volatile i0 r;
    private volatile g0 s;
    private volatile e0 t;
    private volatile q u;
    private volatile c0 v;

    class a extends w0.a {

        final app.dogo.android.persistencedb.room.database.ContentDatabase_Impl b;
        a(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl, int i2) {
            this.b = contentDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `BreedEntity` (`breedId` TEXT NOT NULL, `title` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_breedId` TEXT NOT NULL, PRIMARY KEY(`locale_breedId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrickEntity` (`trickId` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `categoryName` TEXT NOT NULL, `categoryId` TEXT NOT NULL, `examInstructions` TEXT, `examTimeLimit` INTEGER, `sortOrder` INTEGER, `isExam` INTEGER NOT NULL, `hasProgress` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `videoId` TEXT, `videoThumbnail` TEXT, `description` TEXT, `locale` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, `imageStepOrder` TEXT NOT NULL, `videoStepOder` TEXT NOT NULL, PRIMARY KEY(`locale_trickId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrickStepEntity` (`stepId` TEXT NOT NULL, `description` TEXT NOT NULL, `image` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_stepId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`))");
            g.C("CREATE TABLE IF NOT EXISTS `VideoStepEntity` (`stepId` TEXT NOT NULL, `text` TEXT NOT NULL, `locale` TEXT NOT NULL, `startTime` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_stepId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrickTagEntity` (`tagId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`))");
            g.C("CREATE TABLE IF NOT EXISTS `ArticleWithTags` (`locale_articleId` TEXT NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_articleId`, `locale_tagId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_ArticleWithTags_locale_articleId` ON `ArticleWithTags` (`locale_articleId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_ArticleWithTags_locale_tagId` ON `ArticleWithTags` (`locale_tagId`)");
            g.C("CREATE TABLE IF NOT EXISTS `LessonWithTrick` (`locale_lessonId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTrick_locale_lessonId` ON `LessonWithTrick` (`locale_lessonId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTrick_locale_trickId` ON `LessonWithTrick` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS `LessonWithQuestion` (`locale_lessonId` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_questionId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithQuestion_locale_lessonId` ON `LessonWithQuestion` (`locale_lessonId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithQuestion_locale_questionId` ON `LessonWithQuestion` (`locale_questionId`)");
            g.C("CREATE TABLE IF NOT EXISTS `LessonWithTask` (`locale_lessonId` TEXT NOT NULL, `locale_taskId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`, `locale_taskId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTask_locale_lessonId` ON `LessonWithTask` (`locale_lessonId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_LessonWithTask_locale_taskId` ON `LessonWithTask` (`locale_taskId`)");
            g.C("CREATE TABLE IF NOT EXISTS `ModuleWithExams` (`locale_moduleId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithExams_locale_moduleId` ON `ModuleWithExams` (`locale_moduleId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithExams_locale_trickId` ON `ModuleWithExams` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS `TrickWithTags` (`locale_tagId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithTags_locale_tagId` ON `TrickWithTags` (`locale_tagId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithTags_locale_trickId` ON `TrickWithTags` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS `ArticleEntity` (`articleId` TEXT NOT NULL, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `readingTime` INTEGER NOT NULL, `sortOrder` INTEGER, `categoryId` TEXT NOT NULL, `image` TEXT, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_articleId` TEXT NOT NULL, `textHtml` TEXT, PRIMARY KEY(`locale_articleId`))");
            g.C("CREATE TABLE IF NOT EXISTS `ArticleTagEntity` (`hidden` INTEGER NOT NULL, `tagId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_tagId` TEXT NOT NULL, PRIMARY KEY(`locale_tagId`))");
            g.C("CREATE TABLE IF NOT EXISTS `LessonEntity` (`lessonId` TEXT NOT NULL, `index` INTEGER NOT NULL, `locale` TEXT NOT NULL, `programId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_lessonId` TEXT NOT NULL, PRIMARY KEY(`locale_lessonId`))");
            g.C("CREATE TABLE IF NOT EXISTS `ModuleEntity` (`moduleId` TEXT NOT NULL, `index` INTEGER NOT NULL, `name` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_moduleId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`))");
            g.C("CREATE TABLE IF NOT EXISTS `ProgramEntity` (`type` TEXT NOT NULL, `programId` TEXT NOT NULL, `name` TEXT NOT NULL, `image` TEXT NOT NULL, `centeredImage` TEXT NOT NULL, `description` TEXT NOT NULL, `cardBackgroundColor` TEXT NOT NULL, `certificateLaurelsImage` TEXT NOT NULL, `certificatePaperImage` TEXT NOT NULL, `certificatePlaceholderUrl` TEXT NOT NULL, `certificateRequirements` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_programId` TEXT NOT NULL, `programOverviewImage` TEXT NOT NULL, `dogSkillsHighlights` TEXT NOT NULL, `dogSkillsOverview` TEXT NOT NULL, `userSkillsOverview` TEXT NOT NULL, `averageCompletionTimeWeeks` INTEGER NOT NULL, `numberOfEnrolledUsers` INTEGER NOT NULL, `certificatePreviewImage` TEXT NOT NULL, PRIMARY KEY(`locale_programId`))");
            g.C("CREATE TABLE IF NOT EXISTS `QuestionEntity` (`questionId` TEXT NOT NULL, `locale` TEXT NOT NULL, `question` TEXT NOT NULL, `answers` TEXT NOT NULL, `correctAnswer` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TaskEntity` (`taskId` TEXT NOT NULL, `text` TEXT NOT NULL, `locale` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_taskId` TEXT NOT NULL, PRIMARY KEY(`locale_taskId`))");
            g.C("CREATE TABLE IF NOT EXISTS `ModuleWithLessons` (`locale_moduleId` TEXT NOT NULL, `locale_lessonId` TEXT NOT NULL, PRIMARY KEY(`locale_moduleId`, `locale_lessonId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithLessons_locale_moduleId` ON `ModuleWithLessons` (`locale_moduleId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_ModuleWithLessons_locale_lessonId` ON `ModuleWithLessons` (`locale_lessonId`)");
            g.C("CREATE TABLE IF NOT EXISTS `ProgramWithModules` (`locale_programId` TEXT NOT NULL, `locale_moduleId` TEXT NOT NULL, PRIMARY KEY(`locale_programId`, `locale_moduleId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_ProgramWithModules_locale_programId` ON `ProgramWithModules` (`locale_programId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_ProgramWithModules_locale_moduleId` ON `ProgramWithModules` (`locale_moduleId`)");
            g.C("CREATE TABLE IF NOT EXISTS `QuestionWithArticle` (`locale_articleId` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`, `locale_articleId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_QuestionWithArticle_locale_articleId` ON `QuestionWithArticle` (`locale_articleId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_QuestionWithArticle_locale_questionId` ON `QuestionWithArticle` (`locale_questionId`)");
            g.C("CREATE TABLE IF NOT EXISTS `TrickWithSteps` (`locale_stepId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithSteps_locale_stepId` ON `TrickWithSteps` (`locale_stepId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithSteps_locale_trickId` ON `TrickWithSteps` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS `TrickWithVideoSteps` (`locale_stepId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_stepId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVideoSteps_locale_stepId` ON `TrickWithVideoSteps` (`locale_stepId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVideoSteps_locale_trickId` ON `TrickWithVideoSteps` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS `OnboardingQuestionEntity` (`questionId` TEXT NOT NULL, `text` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale` TEXT NOT NULL, `childOrderList` TEXT NOT NULL, `locale_questionId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`))");
            g.C("CREATE TABLE IF NOT EXISTS `OnboardingAnswerEntity` (`answerId` TEXT NOT NULL, `text` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale` TEXT NOT NULL, `locale_answerId` TEXT NOT NULL, PRIMARY KEY(`locale_answerId`))");
            g.C("CREATE TABLE IF NOT EXISTS `OnboardingQuestionWithAnswer` (`locale_questionId` TEXT NOT NULL, `locale_answerId` TEXT NOT NULL, PRIMARY KEY(`locale_questionId`, `locale_answerId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_OnboardingQuestionWithAnswer_locale_questionId` ON `OnboardingQuestionWithAnswer` (`locale_questionId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_OnboardingQuestionWithAnswer_locale_answerId` ON `OnboardingQuestionWithAnswer` (`locale_answerId`)");
            g.C("CREATE TABLE IF NOT EXISTS `TrickCategoryEntity` (`categoryId` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_categoryId` TEXT NOT NULL, PRIMARY KEY(`locale_categoryId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrickVariationEntity` (`tips` TEXT NOT NULL, `variationId` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `locale` TEXT NOT NULL, `contentfulId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `locale_variationId` TEXT NOT NULL, PRIMARY KEY(`locale_variationId`))");
            g.C("CREATE TABLE IF NOT EXISTS `TrickWithVariations` (`locale_variationId` TEXT NOT NULL, `locale_trickId` TEXT NOT NULL, PRIMARY KEY(`locale_variationId`, `locale_trickId`))");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVariations_locale_variationId` ON `TrickWithVariations` (`locale_variationId`)");
            g.C("CREATE INDEX IF NOT EXISTS `index_TrickWithVariations_locale_trickId` ON `TrickWithVariations` (`locale_trickId`)");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c721869b5384407530df9939ea8c8d1b')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `BreedEntity`");
            g.C("DROP TABLE IF EXISTS `TrickEntity`");
            g.C("DROP TABLE IF EXISTS `TrickStepEntity`");
            g.C("DROP TABLE IF EXISTS `VideoStepEntity`");
            g.C("DROP TABLE IF EXISTS `TrickTagEntity`");
            g.C("DROP TABLE IF EXISTS `ArticleWithTags`");
            g.C("DROP TABLE IF EXISTS `LessonWithTrick`");
            g.C("DROP TABLE IF EXISTS `LessonWithQuestion`");
            g.C("DROP TABLE IF EXISTS `LessonWithTask`");
            g.C("DROP TABLE IF EXISTS `ModuleWithExams`");
            g.C("DROP TABLE IF EXISTS `TrickWithTags`");
            g.C("DROP TABLE IF EXISTS `ArticleEntity`");
            g.C("DROP TABLE IF EXISTS `ArticleTagEntity`");
            g.C("DROP TABLE IF EXISTS `LessonEntity`");
            g.C("DROP TABLE IF EXISTS `ModuleEntity`");
            g.C("DROP TABLE IF EXISTS `ProgramEntity`");
            g.C("DROP TABLE IF EXISTS `QuestionEntity`");
            g.C("DROP TABLE IF EXISTS `TaskEntity`");
            g.C("DROP TABLE IF EXISTS `ModuleWithLessons`");
            g.C("DROP TABLE IF EXISTS `ProgramWithModules`");
            g.C("DROP TABLE IF EXISTS `QuestionWithArticle`");
            g.C("DROP TABLE IF EXISTS `TrickWithSteps`");
            g.C("DROP TABLE IF EXISTS `TrickWithVideoSteps`");
            g.C("DROP TABLE IF EXISTS `OnboardingQuestionEntity`");
            g.C("DROP TABLE IF EXISTS `OnboardingAnswerEntity`");
            g.C("DROP TABLE IF EXISTS `OnboardingQuestionWithAnswer`");
            g.C("DROP TABLE IF EXISTS `TrickCategoryEntity`");
            g.C("DROP TABLE IF EXISTS `TrickVariationEntity`");
            g.C("DROP TABLE IF EXISTS `TrickWithVariations`");
            if (ContentDatabase_Impl.N(this.b) != null) {
                list = 0;
                while (list < ContentDatabase_Impl.O(this.b).size()) {
                    (u0.b)ContentDatabase_Impl.Q(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (ContentDatabase_Impl.R(this.b) != null) {
                list = 0;
                while (list < ContentDatabase_Impl.S(this.b).size()) {
                    (u0.b)ContentDatabase_Impl.T(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            ContentDatabase_Impl.U(this.b, g);
            ContentDatabase_Impl.V(this.b, g);
            if (ContentDatabase_Impl.W(this.b) != null) {
                list = 0;
                while (list < ContentDatabase_Impl.X(this.b).size()) {
                    (u0.b)ContentDatabase_Impl.P(this.b).get(list).c(g);
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
            HashMap hashMap = new HashMap(5);
            super("breedId", "TEXT", 1, 0, 0, 1);
            hashMap.put("breedId", aVar155);
            super("title", "TEXT", 1, 0, 0, 1);
            String str69 = "title";
            hashMap.put(str69, aVar123);
            super("locale", "TEXT", 1, 0, 0, 1);
            String str85 = "locale";
            hashMap.put(str85, aVar124);
            super("updatedAt", "INTEGER", 1, 0, 0, 1);
            String str94 = "updatedAt";
            hashMap.put(str94, aVar125);
            super("locale_breedId", "TEXT", 1, 1, 0, 1);
            hashMap.put("locale_breedId", aVar126);
            int i75 = 0;
            HashSet hashSet26 = new HashSet(i75);
            HashSet hashSet40 = new HashSet(i75);
            g gVar51 = new g("BreedEntity", hashMap, hashSet26, hashSet40);
            g gVar3 = g.a(gVar, "BreedEntity");
            String str129 = "\n Found:\n";
            if (!gVar51.equals(gVar3)) {
                StringBuilder stringBuilder27 = new StringBuilder();
                stringBuilder27.append("BreedEntity(app.dogo.android.persistencedb.room.entity.BreedEntity).\n Expected:\n");
                stringBuilder27.append(gVar51);
                stringBuilder27.append(str129);
                stringBuilder27.append(gVar3);
                w0.b bVar29 = new w0.b(i75, stringBuilder27.toString());
                return bVar29;
            }
            HashMap hashMap2 = new HashMap(18);
            super("trickId", "TEXT", 1, 0, 0, 1);
            hashMap2.put("trickId", aVar127);
            int i114 = 1;
            int i117 = 0;
            int i122 = 0;
            int i130 = 1;
            g.a aVar156 = new g.a("name", "TEXT", i114, i117, i122, i130);
            String str132 = "name";
            hashMap2.put(str132, aVar128);
            super("image", "TEXT", i114, i117, i122, i130);
            String str163 = "image";
            hashMap2.put(str163, aVar129);
            super("categoryName", "TEXT", 1, 0, 0, 1);
            hashMap2.put("categoryName", aVar130);
            int i132 = 0;
            int i138 = 0;
            int i141 = 1;
            super("categoryId", "TEXT", 1, i132, i138, i141);
            String str175 = "categoryId";
            hashMap2.put(str175, aVar131);
            super("examInstructions", "TEXT", 0, i132, i138, i141);
            hashMap2.put("examInstructions", aVar132);
            int i139 = 0;
            int i142 = 0;
            int i145 = 1;
            super("examTimeLimit", "INTEGER", i132, i139, i142, i145);
            hashMap2.put("examTimeLimit", aVar133);
            super("sortOrder", "INTEGER", i132, i139, i142, i145);
            hashMap2.put("sortOrder", aVar134);
            int i133 = 1;
            super("isExam", "INTEGER", i133, i139, i142, i145);
            hashMap2.put("isExam", aVar135);
            super("hasProgress", "INTEGER", i133, i139, i142, i145);
            hashMap2.put("hasProgress", aVar136);
            super("updatedAt", "INTEGER", i133, i139, i142, i145);
            hashMap2.put(str94, aVar137);
            int i166 = 0;
            int i171 = 1;
            super("videoId", "TEXT", 0, 0, i166, i171);
            hashMap2.put("videoId", aVar138);
            int i134 = 0;
            super("videoThumbnail", "TEXT", i134, i139, i142, i145);
            hashMap2.put("videoThumbnail", aVar139);
            super("description", "TEXT", i134, i139, i142, i145);
            String str200 = "description";
            hashMap2.put(str200, aVar140);
            super("locale", "TEXT", 1, i139, i142, i145);
            hashMap2.put(str85, aVar141);
            super("locale_trickId", "TEXT", 1, 1, i166, i171);
            String str210 = "locale_trickId";
            hashMap2.put(str210, aVar142);
            super("imageStepOrder", "TEXT", 1, 0, 0, 1);
            hashMap2.put("imageStepOrder", aVar143);
            super("videoStepOder", "TEXT", 1, 0, 0, 1);
            hashMap2.put("videoStepOder", aVar144);
            HashSet hashSet27 = new HashSet(i75);
            HashSet hashSet53 = new HashSet(i75);
            g gVar58 = new g("TrickEntity", hashMap2, hashSet27, hashSet53);
            g gVar4 = g.a(gVar, "TrickEntity");
            if (!gVar58.equals(gVar4)) {
                StringBuilder stringBuilder26 = new StringBuilder();
                stringBuilder26.append("TrickEntity(app.dogo.android.persistencedb.room.entity.TrickEntity).\n Expected:\n");
                stringBuilder26.append(gVar58);
                stringBuilder26.append(str129);
                stringBuilder26.append(gVar4);
                w0.b bVar28 = new w0.b(i75, stringBuilder26.toString());
                return bVar28;
            }
            HashMap hashMap3 = new HashMap(6);
            int i150 = 1;
            int i152 = 0;
            int i154 = 0;
            int i158 = 1;
            super("stepId", "TEXT", i150, i152, i154, i158);
            hashMap3.put("stepId", aVar145);
            super("description", "TEXT", i150, i152, i154, i158);
            hashMap3.put(str200, aVar146);
            int i176 = 1;
            int i181 = 0;
            int i186 = 0;
            int i193 = 1;
            super("image", "TEXT", i176, i181, i186, i193);
            hashMap3.put(str163, aVar147);
            super("locale", "TEXT", i150, i152, i154, i158);
            hashMap3.put(str85, aVar148);
            super("updatedAt", "INTEGER", i176, i181, i186, i193);
            hashMap3.put(str94, aVar149);
            super("locale_stepId", "TEXT", i150, 1, i154, i158);
            String str224 = "locale_stepId";
            hashMap3.put(str224, aVar150);
            HashSet hashSet28 = new HashSet(i75);
            HashSet hashSet54 = new HashSet(i75);
            g gVar31 = new g("TrickStepEntity", hashMap3, hashSet28, hashSet54);
            g gVar5 = g.a(gVar, "TrickStepEntity");
            if (!gVar31.equals(gVar5)) {
                StringBuilder stringBuilder29 = new StringBuilder();
                stringBuilder29.append("TrickStepEntity(app.dogo.android.persistencedb.room.entity.TrickStepEntity).\n Expected:\n");
                stringBuilder29.append(gVar31);
                stringBuilder29.append(str129);
                stringBuilder29.append(gVar5);
                w0.b bVar27 = new w0.b(0, stringBuilder29.toString());
                return bVar27;
            }
            HashMap hashMap4 = new HashMap(6);
            int i155 = 1;
            int i159 = 0;
            int i163 = 0;
            int i167 = 1;
            super("stepId", "TEXT", i155, i159, i163, i167);
            hashMap4.put("stepId", aVar);
            super("text", "TEXT", i155, i159, i163, i167);
            String str33 = "text";
            hashMap4.put(str33, aVar2);
            super("locale", "TEXT", i155, i159, i163, i167);
            hashMap4.put(str85, aVar3);
            int i187 = 1;
            int i201 = 0;
            int i210 = 1;
            super("startTime", "INTEGER", i187, 0, i201, i210);
            hashMap4.put("startTime", aVar4);
            super("updatedAt", "INTEGER", i155, i159, i163, i167);
            hashMap4.put(str94, aVar5);
            super("locale_stepId", "TEXT", i187, 1, i201, i210);
            hashMap4.put(str224, aVar6);
            int i76 = 0;
            HashSet hashSet = new HashSet(i76);
            HashSet hashSet55 = new HashSet(i76);
            g gVar46 = new g("VideoStepEntity", hashMap4, hashSet, hashSet55);
            g gVar6 = g.a(gVar, "VideoStepEntity");
            if (!gVar46.equals(gVar6)) {
                StringBuilder stringBuilder25 = new StringBuilder();
                stringBuilder25.append("VideoStepEntity(app.dogo.android.persistencedb.room.entity.VideoStepEntity).\n Expected:\n");
                stringBuilder25.append(gVar46);
                stringBuilder25.append(str129);
                stringBuilder25.append(gVar6);
                w0.b bVar26 = new w0.b(0, stringBuilder25.toString());
                return bVar26;
            }
            HashMap hashMap5 = new HashMap(5);
            int i160 = 1;
            int i164 = 0;
            int i168 = 0;
            int i172 = 1;
            super("tagId", "TEXT", i160, i164, i168, i172);
            hashMap5.put("tagId", aVar7);
            super("locale", "TEXT", i160, i164, i168, i172);
            hashMap5.put(str85, aVar8);
            int i196 = 1;
            int i211 = 0;
            int i224 = 1;
            super("name", "TEXT", i196, 0, i211, i224);
            hashMap5.put(str132, aVar9);
            super("updatedAt", "INTEGER", i160, i164, i168, i172);
            hashMap5.put(str94, aVar10);
            super("locale_tagId", "TEXT", i196, 1, i211, i224);
            String str110 = "locale_tagId";
            hashMap5.put(str110, aVar11);
            int i119 = 0;
            HashSet hashSet2 = new HashSet(i119);
            HashSet hashSet56 = new HashSet(i119);
            g gVar57 = new g("TrickTagEntity", hashMap5, hashSet2, hashSet56);
            g gVar7 = g.a(gVar, "TrickTagEntity");
            if (!gVar57.equals(gVar7)) {
                StringBuilder stringBuilder24 = new StringBuilder();
                stringBuilder24.append("TrickTagEntity(app.dogo.android.persistencedb.room.entity.TrickTagEntity).\n Expected:\n");
                stringBuilder24.append(gVar57);
                stringBuilder24.append(str129);
                stringBuilder24.append(gVar7);
                w0.b bVar25 = new w0.b(0, stringBuilder24.toString());
                return bVar25;
            }
            int i6 = 2;
            HashMap hashMap6 = new HashMap(i6);
            int i165 = 1;
            int i173 = 0;
            int i177 = 1;
            super("locale_articleId", "TEXT", i165, 1, i173, i177);
            String str226 = "locale_articleId";
            hashMap6.put(str226, aVar162);
            super("locale_tagId", "TEXT", i165, 2, i173, i177);
            hashMap6.put(str110, aVar163);
            HashSet hashSet52 = new HashSet(0);
            HashSet hashSet57 = new HashSet(i6);
            String str284 = "ASC";
            int i66 = 0;
            g.d dVar = new g.d("index_ArticleWithTags_locale_articleId", i66, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet57.add(dVar);
            g.d dVar2 = new g.d("index_ArticleWithTags_locale_tagId", i66, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet57.add(dVar2);
            g gVar32 = new g("ArticleWithTags", hashMap6, hashSet52, hashSet57);
            g gVar8 = g.a(gVar, "ArticleWithTags");
            if (!gVar32.equals(gVar8)) {
                StringBuilder stringBuilder28 = new StringBuilder();
                stringBuilder28.append("ArticleWithTags(app.dogo.android.persistencedb.room.junction.ArticleWithTags).\n Expected:\n");
                stringBuilder28.append(gVar32);
                stringBuilder28.append(str129);
                stringBuilder28.append(gVar8);
                w0.b bVar24 = new w0.b(0, stringBuilder28.toString());
                return bVar24;
            }
            HashMap hashMap7 = new HashMap(2);
            int i197 = 1;
            int i212 = 0;
            int i225 = 1;
            super("locale_lessonId", "TEXT", i197, 1, i212, i225);
            String str87 = "locale_lessonId";
            hashMap7.put(str87, aVar12);
            super("locale_trickId", "TEXT", i197, 2, i212, i225);
            hashMap7.put(str210, aVar13);
            int i71 = 0;
            HashSet hashSet3 = new HashSet(i71);
            HashSet hashSet41 = new HashSet(2);
            g.d dVar22 = new g.d("index_LessonWithTrick_locale_lessonId", i71, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet41.add(dVar22);
            g.d dVar18 = new g.d("index_LessonWithTrick_locale_trickId", i71, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet41.add(dVar18);
            g gVar43 = new g("LessonWithTrick", hashMap7, hashSet3, hashSet41);
            g gVar9 = g.a(gVar, "LessonWithTrick");
            if (!gVar43.equals(gVar9)) {
                StringBuilder stringBuilder23 = new StringBuilder();
                stringBuilder23.append("LessonWithTrick(app.dogo.android.persistencedb.room.junction.LessonWithTrick).\n Expected:\n");
                stringBuilder23.append(gVar43);
                stringBuilder23.append(str129);
                stringBuilder23.append(gVar9);
                w0.b bVar23 = new w0.b(0, stringBuilder23.toString());
                return bVar23;
            }
            HashMap hashMap8 = new HashMap(2);
            super("locale_lessonId", "TEXT", 1, 1, 0, 1);
            hashMap8.put(str87, aVar14);
            super("locale_questionId", "TEXT", 1, 2, 0, 1);
            String str96 = "locale_questionId";
            hashMap8.put(str96, aVar15);
            int i91 = 0;
            HashSet hashSet4 = new HashSet(i91);
            HashSet hashSet45 = new HashSet(2);
            String str327 = str175;
            g.d dVar23 = new g.d("index_LessonWithQuestion_locale_lessonId", i91, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet45.add(dVar23);
            g.d dVar19 = new g.d("index_LessonWithQuestion_locale_questionId", i91, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet45.add(dVar19);
            g gVar52 = new g("LessonWithQuestion", hashMap8, hashSet4, hashSet45);
            g gVar10 = g.a(gVar, "LessonWithQuestion");
            if (!gVar52.equals(gVar10)) {
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append("LessonWithQuestion(app.dogo.android.persistencedb.room.junction.LessonWithQuestion).\n Expected:\n");
                stringBuilder22.append(gVar52);
                stringBuilder22.append(str129);
                stringBuilder22.append(gVar10);
                w0.b bVar22 = new w0.b(0, stringBuilder22.toString());
                return bVar22;
            }
            HashMap hashMap9 = new HashMap(2);
            super("locale_lessonId", "TEXT", 1, 1, 0, 1);
            hashMap9.put(str87, aVar16);
            super("locale_taskId", "TEXT", 1, 2, 0, 1);
            String str133 = "locale_taskId";
            hashMap9.put(str133, aVar17);
            int i97 = 0;
            HashSet hashSet5 = new HashSet(i97);
            HashSet hashSet50 = new HashSet(2);
            g.d dVar24 = new g.d("index_LessonWithTask_locale_lessonId", i97, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet50.add(dVar24);
            g.d dVar7 = new g.d("index_LessonWithTask_locale_taskId", i97, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet50.add(dVar7);
            g gVar44 = new g("LessonWithTask", hashMap9, hashSet5, hashSet50);
            g gVar11 = g.a(gVar, "LessonWithTask");
            if (!gVar44.equals(gVar11)) {
                StringBuilder stringBuilder21 = new StringBuilder();
                stringBuilder21.append("LessonWithTask(app.dogo.android.persistencedb.room.junction.LessonWithTask).\n Expected:\n");
                stringBuilder21.append(gVar44);
                stringBuilder21.append(str129);
                stringBuilder21.append(gVar11);
                w0.b bVar21 = new w0.b(0, stringBuilder21.toString());
                return bVar21;
            }
            HashMap hashMap10 = new HashMap(2);
            int i228 = 1;
            int i271 = 0;
            int i295 = 1;
            super("locale_moduleId", "TEXT", i228, 1, i271, i295);
            String str98 = "locale_moduleId";
            hashMap10.put(str98, aVar18);
            super("locale_trickId", "TEXT", i228, 2, i271, i295);
            hashMap10.put(str210, aVar19);
            int i98 = 0;
            HashSet hashSet6 = new HashSet(i98);
            HashSet hashSet51 = new HashSet(2);
            g.d dVar25 = new g.d("index_ModuleWithExams_locale_moduleId", i98, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet51.add(dVar25);
            g.d dVar17 = new g.d("index_ModuleWithExams_locale_trickId", i98, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet51.add(dVar17);
            g gVar53 = new g("ModuleWithExams", hashMap10, hashSet6, hashSet51);
            g gVar12 = g.a(gVar, "ModuleWithExams");
            if (!gVar53.equals(gVar12)) {
                StringBuilder stringBuilder20 = new StringBuilder();
                stringBuilder20.append("ModuleWithExams(app.dogo.android.persistencedb.room.junction.ModuleWithExams).\n Expected:\n");
                stringBuilder20.append(gVar53);
                stringBuilder20.append(str129);
                stringBuilder20.append(gVar12);
                w0.b bVar20 = new w0.b(0, stringBuilder20.toString());
                return bVar20;
            }
            HashMap hashMap11 = new HashMap(2);
            super("locale_tagId", "TEXT", 1, 1, 0, 1);
            hashMap11.put(str110, aVar20);
            super("locale_trickId", "TEXT", 1, 2, 0, 1);
            hashMap11.put(str210, aVar21);
            int i92 = 0;
            HashSet hashSet7 = new HashSet(i92);
            HashSet hashSet46 = new HashSet(2);
            g.d dVar20 = new g.d("index_TrickWithTags_locale_tagId", i92, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet46.add(dVar20);
            g.d dVar21 = new g.d("index_TrickWithTags_locale_trickId", i92, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet46.add(dVar21);
            g gVar54 = new g("TrickWithTags", hashMap11, hashSet7, hashSet46);
            g gVar13 = g.a(gVar, "TrickWithTags");
            if (!gVar54.equals(gVar13)) {
                StringBuilder stringBuilder19 = new StringBuilder();
                stringBuilder19.append("TrickWithTags(app.dogo.android.persistencedb.room.junction.TrickWithTags).\n Expected:\n");
                stringBuilder19.append(gVar54);
                stringBuilder19.append(str129);
                stringBuilder19.append(gVar13);
                w0.b bVar19 = new w0.b(0, stringBuilder19.toString());
                return bVar19;
            }
            HashMap hashMap12 = new HashMap(11);
            int i247 = 1;
            int i273 = 0;
            int i297 = 0;
            int i307 = 1;
            super("articleId", "TEXT", i247, i273, i297, i307);
            hashMap12.put("articleId", aVar22);
            super("title", "TEXT", i247, i273, i297, i307);
            hashMap12.put(str69, aVar23);
            super("text", "TEXT", 1, 0, 0, 1);
            hashMap12.put(str33, aVar24);
            super("readingTime", "INTEGER", i247, i273, i297, i307);
            hashMap12.put("readingTime", aVar25);
            super("sortOrder", "INTEGER", 0, i273, i297, i307);
            hashMap12.put("sortOrder", aVar26);
            super("categoryId", "TEXT", 1, i273, i297, i307);
            hashMap12.put(str327, aVar27);
            super("image", "TEXT", 0, i273, i297, i307);
            String str168 = str314;
            hashMap12.put(str168, aVar28);
            int i251 = 1;
            super("locale", "TEXT", i251, i273, i297, i307);
            String str179 = str306;
            hashMap12.put(str179, aVar29);
            super("updatedAt", "INTEGER", i251, i273, i297, i307);
            String str202 = str288;
            hashMap12.put(str202, aVar30);
            super("locale_articleId", "TEXT", i251, 1, i297, i307);
            String str228 = str297;
            hashMap12.put(str228, aVar31);
            super("textHtml", "TEXT", 0, 0, i297, i307);
            hashMap12.put("textHtml", aVar32);
            int i127 = 0;
            HashSet hashSet8 = new HashSet(i127);
            HashSet hashSet29 = new HashSet(i127);
            g gVar59 = new g("ArticleEntity", hashMap12, hashSet8, hashSet29);
            g gVar14 = g.a(gVar, "ArticleEntity");
            if (!gVar59.equals(gVar14)) {
                StringBuilder stringBuilder18 = new StringBuilder();
                stringBuilder18.append("ArticleEntity(app.dogo.android.persistencedb.room.entity.ArticleEntity).\n Expected:\n");
                stringBuilder18.append(gVar59);
                stringBuilder18.append(str129);
                stringBuilder18.append(gVar14);
                w0.b bVar18 = new w0.b(0, stringBuilder18.toString());
                return bVar18;
            }
            HashMap hashMap13 = new HashMap(6);
            int i253 = 1;
            int i276 = 0;
            int i298 = 0;
            int i308 = 1;
            super("hidden", "INTEGER", i253, i276, i298, i308);
            hashMap13.put("hidden", aVar33);
            super("tagId", "TEXT", i253, i276, i298, i308);
            hashMap13.put("tagId", aVar34);
            super("locale", "TEXT", i253, i276, i298, i308);
            hashMap13.put(str179, aVar35);
            int i341 = 1;
            int i375 = 0;
            int i383 = 1;
            super("name", "TEXT", i341, 0, i375, i383);
            String str72 = str287;
            hashMap13.put(str72, aVar36);
            super("updatedAt", "INTEGER", i253, i276, i298, i308);
            hashMap13.put(str202, aVar37);
            super("locale_tagId", "TEXT", i341, 1, i375, i383);
            hashMap13.put(str110, aVar38);
            int i77 = 0;
            HashSet hashSet9 = new HashSet(i77);
            HashSet hashSet42 = new HashSet(i77);
            g gVar47 = new g("ArticleTagEntity", hashMap13, hashSet9, hashSet42);
            g gVar15 = g.a(gVar, "ArticleTagEntity");
            if (!gVar47.equals(gVar15)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ArticleTagEntity(app.dogo.android.persistencedb.room.entity.ArticleTagEntity).\n Expected:\n");
                stringBuilder.append(gVar47);
                stringBuilder.append(str129);
                stringBuilder.append(gVar15);
                w0.b bVar = new w0.b(0, stringBuilder.toString());
                return bVar;
            }
            HashMap hashMap14 = new HashMap(6);
            int i254 = 1;
            int i277 = 0;
            int i299 = 0;
            int i309 = 1;
            super("lessonId", "TEXT", i254, i277, i299, i309);
            hashMap14.put("lessonId", aVar39);
            super("index", "INTEGER", i254, i277, i299, i309);
            hashMap14.put("index", aVar40);
            super("locale", "TEXT", i254, i277, i299, i309);
            hashMap14.put(str179, aVar41);
            int i342 = 1;
            int i376 = 0;
            int i384 = 1;
            super("programId", "TEXT", i342, 0, i376, i384);
            hashMap14.put("programId", aVar42);
            super("updatedAt", "INTEGER", i254, i277, i299, i309);
            hashMap14.put(str202, aVar43);
            super("locale_lessonId", "TEXT", i342, 1, i376, i384);
            hashMap14.put(str87, aVar44);
            int i78 = 0;
            HashSet hashSet10 = new HashSet(i78);
            HashSet hashSet43 = new HashSet(i78);
            g gVar48 = new g("LessonEntity", hashMap14, hashSet10, hashSet43);
            g gVar16 = g.a(gVar, "LessonEntity");
            if (!gVar48.equals(gVar16)) {
                StringBuilder stringBuilder17 = new StringBuilder();
                stringBuilder17.append("LessonEntity(app.dogo.android.persistencedb.room.entity.LessonEntity).\n Expected:\n");
                stringBuilder17.append(gVar48);
                stringBuilder17.append(str129);
                stringBuilder17.append(gVar16);
                w0.b bVar17 = new w0.b(0, stringBuilder17.toString());
                return bVar17;
            }
            HashMap hashMap15 = new HashMap(6);
            int i255 = 1;
            int i278 = 0;
            int i300 = 0;
            int i310 = 1;
            super("moduleId", "TEXT", i255, i278, i300, i310);
            hashMap15.put("moduleId", aVar45);
            super("index", "INTEGER", i255, i278, i300, i310);
            hashMap15.put("index", aVar46);
            super("name", "TEXT", i255, i278, i300, i310);
            hashMap15.put(str72, aVar47);
            int i343 = 1;
            int i377 = 0;
            int i385 = 1;
            super("locale", "TEXT", i343, 0, i377, i385);
            hashMap15.put(str179, aVar48);
            super("updatedAt", "INTEGER", i255, i278, i300, i310);
            hashMap15.put(str202, aVar49);
            super("locale_moduleId", "TEXT", i343, 1, i377, i385);
            hashMap15.put(str98, aVar50);
            int i79 = 0;
            HashSet hashSet11 = new HashSet(i79);
            HashSet hashSet44 = new HashSet(i79);
            g gVar49 = new g("ModuleEntity", hashMap15, hashSet11, hashSet44);
            g gVar17 = g.a(gVar, "ModuleEntity");
            if (!gVar49.equals(gVar17)) {
                StringBuilder stringBuilder16 = new StringBuilder();
                stringBuilder16.append("ModuleEntity(app.dogo.android.persistencedb.room.entity.ModuleEntity).\n Expected:\n");
                stringBuilder16.append(gVar49);
                stringBuilder16.append(str129);
                stringBuilder16.append(gVar17);
                w0.b bVar16 = new w0.b(0, stringBuilder16.toString());
                return bVar16;
            }
            HashMap hashMap16 = new HashMap(21);
            int i256 = 1;
            int i279 = 0;
            int i301 = 0;
            int i311 = 1;
            super("type", "TEXT", i256, i279, i301, i311);
            hashMap16.put("type", aVar51);
            super("programId", "TEXT", i256, i279, i301, i311);
            hashMap16.put("programId", aVar52);
            super("name", "TEXT", i256, i279, i301, i311);
            hashMap16.put(str72, aVar53);
            int i344 = 1;
            int i362 = 0;
            int i378 = 0;
            int i386 = 1;
            super("image", "TEXT", i344, i362, i378, i386);
            hashMap16.put(str168, aVar54);
            super("centeredImage", "TEXT", i256, i279, i301, i311);
            hashMap16.put("centeredImage", aVar55);
            super("description", "TEXT", i256, i279, i301, i311);
            String str119 = str266;
            hashMap16.put(str119, aVar56);
            super("cardBackgroundColor", "TEXT", i256, i279, i301, i311);
            hashMap16.put("cardBackgroundColor", aVar57);
            super("certificateLaurelsImage", "TEXT", i256, i279, i301, i311);
            hashMap16.put("certificateLaurelsImage", aVar58);
            super("certificatePaperImage", "TEXT", i256, i279, i301, i311);
            hashMap16.put("certificatePaperImage", aVar59);
            super("certificatePlaceholderUrl", "TEXT", i256, i279, i301, i311);
            hashMap16.put("certificatePlaceholderUrl", aVar60);
            super("certificateRequirements", "TEXT", i256, i279, i301, i311);
            hashMap16.put("certificateRequirements", aVar61);
            super("locale", "TEXT", i256, i279, i301, i311);
            hashMap16.put(str179, aVar62);
            super("updatedAt", "INTEGER", i344, i362, i378, i386);
            hashMap16.put(str202, aVar63);
            super("locale_programId", "TEXT", i256, 1, i301, i311);
            hashMap16.put("locale_programId", aVar64);
            int i281 = 0;
            super("programOverviewImage", "TEXT", i256, i281, i301, i311);
            hashMap16.put("programOverviewImage", aVar65);
            super("dogSkillsHighlights", "TEXT", i256, i281, i301, i311);
            hashMap16.put("dogSkillsHighlights", aVar66);
            super("dogSkillsOverview", "TEXT", i256, i281, i301, i311);
            hashMap16.put("dogSkillsOverview", aVar67);
            super("userSkillsOverview", "TEXT", i256, i281, i301, i311);
            hashMap16.put("userSkillsOverview", aVar68);
            super("averageCompletionTimeWeeks", "INTEGER", i256, i281, i301, i311);
            hashMap16.put("averageCompletionTimeWeeks", aVar69);
            super("numberOfEnrolledUsers", "INTEGER", i256, i281, i301, i311);
            hashMap16.put("numberOfEnrolledUsers", aVar70);
            super("certificatePreviewImage", "TEXT", i256, i281, i301, i311);
            hashMap16.put("certificatePreviewImage", aVar71);
            int i93 = 0;
            HashSet hashSet12 = new HashSet(i93);
            HashSet hashSet47 = new HashSet(i93);
            g gVar55 = new g("ProgramEntity", hashMap16, hashSet12, hashSet47);
            g gVar18 = g.a(gVar, "ProgramEntity");
            if (!gVar55.equals(gVar18)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("ProgramEntity(app.dogo.android.persistencedb.room.entity.ProgramEntity).\n Expected:\n");
                stringBuilder2.append(gVar55);
                stringBuilder2.append(str129);
                stringBuilder2.append(gVar18);
                w0.b bVar2 = new w0.b(0, stringBuilder2.toString());
                return bVar2;
            }
            HashMap hashMap17 = new HashMap(7);
            int i257 = 1;
            int i282 = 0;
            int i302 = 0;
            int i312 = 1;
            super("questionId", "TEXT", i257, i282, i302, i312);
            hashMap17.put("questionId", aVar72);
            super("locale", "TEXT", i257, i282, i302, i312);
            hashMap17.put(str179, aVar73);
            int i345 = 1;
            int i379 = 0;
            int i387 = 1;
            super("question", "TEXT", i345, 0, i379, i387);
            hashMap17.put("question", aVar74);
            super("answers", "TEXT", i257, i282, i302, i312);
            hashMap17.put("answers", aVar75);
            super("correctAnswer", "INTEGER", i257, i282, i302, i312);
            hashMap17.put("correctAnswer", aVar76);
            super("updatedAt", "INTEGER", i257, i282, i302, i312);
            hashMap17.put(str202, aVar77);
            super("locale_questionId", "TEXT", i345, 1, i379, i387);
            String str157 = str334;
            hashMap17.put(str157, aVar78);
            int i99 = 0;
            HashSet hashSet13 = new HashSet(i99);
            HashSet hashSet58 = new HashSet(i99);
            g gVar56 = new g("QuestionEntity", hashMap17, hashSet13, hashSet58);
            g gVar19 = g.a(gVar, "QuestionEntity");
            if (!gVar56.equals(gVar19)) {
                StringBuilder stringBuilder15 = new StringBuilder();
                stringBuilder15.append("QuestionEntity(app.dogo.android.persistencedb.room.entity.QuestionEntity).\n Expected:\n");
                stringBuilder15.append(gVar56);
                stringBuilder15.append(str129);
                stringBuilder15.append(gVar19);
                w0.b bVar15 = new w0.b(0, stringBuilder15.toString());
                return bVar15;
            }
            HashMap hashMap18 = new HashMap(5);
            int i258 = 1;
            int i283 = 0;
            int i303 = 0;
            int i313 = 1;
            super("taskId", "TEXT", i258, i283, i303, i313);
            hashMap18.put("taskId", aVar79);
            super("text", "TEXT", i258, i283, i303, i313);
            hashMap18.put(str33, aVar80);
            int i346 = 1;
            int i380 = 0;
            int i388 = 1;
            super("locale", "TEXT", i346, 0, i380, i388);
            hashMap18.put(str179, aVar81);
            super("updatedAt", "INTEGER", i258, i283, i303, i313);
            hashMap18.put(str202, aVar82);
            super("locale_taskId", "TEXT", i346, 1, i380, i388);
            hashMap18.put(str133, aVar83);
            int i80 = 0;
            HashSet hashSet14 = new HashSet(i80);
            HashSet hashSet48 = new HashSet(i80);
            g gVar50 = new g("TaskEntity", hashMap18, hashSet14, hashSet48);
            g gVar20 = g.a(gVar, "TaskEntity");
            if (!gVar50.equals(gVar20)) {
                StringBuilder stringBuilder14 = new StringBuilder();
                stringBuilder14.append("TaskEntity(app.dogo.android.persistencedb.room.entity.TaskEntity).\n Expected:\n");
                stringBuilder14.append(gVar50);
                stringBuilder14.append(str129);
                stringBuilder14.append(gVar20);
                w0.b bVar14 = new w0.b(0, stringBuilder14.toString());
                return bVar14;
            }
            HashMap hashMap19 = new HashMap(2);
            super("locale_moduleId", "TEXT", 1, 1, 0, 1);
            hashMap19.put(str98, aVar84);
            super("locale_lessonId", "TEXT", 1, 2, 0, 1);
            hashMap19.put(str87, aVar85);
            HashSet hashSet15 = new HashSet(0);
            HashSet hashSet49 = new HashSet(2);
            int i111 = 0;
            g.d dVar26 = new g.d("index_ModuleWithLessons_locale_moduleId", i111, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet49.add(dVar26);
            g.d dVar3 = new g.d("index_ModuleWithLessons_locale_lessonId", i111, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet49.add(dVar3);
            g gVar38 = new g("ModuleWithLessons", hashMap19, hashSet15, hashSet49);
            g gVar21 = g.a(gVar, "ModuleWithLessons");
            if (!gVar38.equals(gVar21)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("ModuleWithLessons(app.dogo.android.persistencedb.room.junction.ModuleWithLessons).\n Expected:\n");
                stringBuilder3.append(gVar38);
                stringBuilder3.append(str129);
                stringBuilder3.append(gVar21);
                w0.b bVar3 = new w0.b(0, stringBuilder3.toString());
                return bVar3;
            }
            HashMap hashMap20 = new HashMap(2);
            int i216 = 1;
            int i260 = 0;
            int i285 = 1;
            super("locale_programId", "TEXT", i216, 1, i260, i285);
            hashMap20.put("locale_programId", aVar86);
            super("locale_moduleId", "TEXT", i216, 2, i260, i285);
            hashMap20.put(str98, aVar87);
            int i64 = 0;
            HashSet hashSet16 = new HashSet(i64);
            HashSet hashSet32 = new HashSet(2);
            g.d dVar10 = new g.d("index_ProgramWithModules_locale_programId", i64, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet32.add(dVar10);
            g.d dVar11 = new g.d("index_ProgramWithModules_locale_moduleId", i64, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet32.add(dVar11);
            g gVar39 = new g("ProgramWithModules", hashMap20, hashSet16, hashSet32);
            g gVar22 = g.a(gVar, "ProgramWithModules");
            if (!gVar39.equals(gVar22)) {
                StringBuilder stringBuilder13 = new StringBuilder();
                stringBuilder13.append("ProgramWithModules(app.dogo.android.persistencedb.room.junction.ProgramWithModules).\n Expected:\n");
                stringBuilder13.append(gVar39);
                stringBuilder13.append(str129);
                stringBuilder13.append(gVar22);
                w0.b bVar13 = new w0.b(0, stringBuilder13.toString());
                return bVar13;
            }
            HashMap hashMap21 = new HashMap(2);
            super("locale_articleId", "TEXT", 1, 2, 0, 1);
            hashMap21.put(str228, aVar88);
            super("locale_questionId", "TEXT", 1, 1, 0, 1);
            hashMap21.put(str157, aVar89);
            int i65 = 0;
            HashSet hashSet17 = new HashSet(i65);
            HashSet hashSet33 = new HashSet(2);
            g.d dVar8 = new g.d("index_QuestionWithArticle_locale_articleId", i65, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet33.add(dVar8);
            g.d dVar9 = new g.d("index_QuestionWithArticle_locale_questionId", i65, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet33.add(dVar9);
            g gVar40 = new g("QuestionWithArticle", hashMap21, hashSet17, hashSet33);
            g gVar23 = g.a(gVar, "QuestionWithArticle");
            if (!gVar40.equals(gVar23)) {
                StringBuilder stringBuilder12 = new StringBuilder();
                stringBuilder12.append("QuestionWithArticle(app.dogo.android.persistencedb.room.junction.QuestionWithArticle).\n Expected:\n");
                stringBuilder12.append(gVar40);
                stringBuilder12.append(str129);
                stringBuilder12.append(gVar23);
                w0.b bVar12 = new w0.b(0, stringBuilder12.toString());
                return bVar12;
            }
            HashMap hashMap22 = new HashMap(2);
            int i218 = 1;
            int i262 = 0;
            int i287 = 1;
            super("locale_stepId", "TEXT", i218, 1, i262, i287);
            String str74 = str261;
            hashMap22.put(str74, aVar90);
            super("locale_trickId", "TEXT", i218, 2, i262, i287);
            hashMap22.put(str210, aVar91);
            int i67 = 0;
            HashSet hashSet18 = new HashSet(i67);
            HashSet hashSet34 = new HashSet(2);
            g.d dVar12 = new g.d("index_TrickWithSteps_locale_stepId", i67, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet34.add(dVar12);
            g.d dVar13 = new g.d("index_TrickWithSteps_locale_trickId", i67, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet34.add(dVar13);
            g gVar42 = new g("TrickWithSteps", hashMap22, hashSet18, hashSet34);
            g gVar24 = g.a(gVar, "TrickWithSteps");
            if (!gVar42.equals(gVar24)) {
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append("TrickWithSteps(app.dogo.android.persistencedb.room.junction.TrickWithSteps).\n Expected:\n");
                stringBuilder11.append(gVar42);
                stringBuilder11.append(str129);
                stringBuilder11.append(gVar24);
                w0.b bVar11 = new w0.b(0, stringBuilder11.toString());
                return bVar11;
            }
            HashMap hashMap23 = new HashMap(2);
            super("locale_stepId", "TEXT", 1, 1, 0, 1);
            hashMap23.put(str74, aVar92);
            super("locale_trickId", "TEXT", 1, 2, 0, 1);
            hashMap23.put(str210, aVar93);
            int i68 = 0;
            HashSet hashSet19 = new HashSet(i68);
            HashSet hashSet35 = new HashSet(2);
            g.d dVar14 = new g.d("index_TrickWithVideoSteps_locale_stepId", i68, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet35.add(dVar14);
            g.d dVar4 = new g.d("index_TrickWithVideoSteps_locale_trickId", i68, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet35.add(dVar4);
            g gVar41 = new g("TrickWithVideoSteps", hashMap23, hashSet19, hashSet35);
            g gVar25 = g.a(gVar, "TrickWithVideoSteps");
            if (!gVar41.equals(gVar25)) {
                StringBuilder stringBuilder10 = new StringBuilder();
                stringBuilder10.append("TrickWithVideoSteps(app.dogo.android.persistencedb.room.junction.TrickWithVideoSteps).\n Expected:\n");
                stringBuilder10.append(gVar41);
                stringBuilder10.append(str129);
                stringBuilder10.append(gVar25);
                w0.b bVar10 = new w0.b(0, stringBuilder10.toString());
                return bVar10;
            }
            HashMap hashMap24 = new HashMap(6);
            int i220 = 1;
            int i236 = 0;
            int i264 = 0;
            int i289 = 1;
            super("questionId", "TEXT", i220, i236, i264, i289);
            hashMap24.put("questionId", aVar94);
            super("text", "TEXT", i220, i236, i264, i289);
            hashMap24.put(str33, aVar95);
            super("updatedAt", "INTEGER", 1, 0, 0, 1);
            String str76 = str315;
            hashMap24.put(str76, aVar96);
            super("locale", "TEXT", i220, i236, i264, i289);
            String str90 = str307;
            hashMap24.put(str90, aVar97);
            super("childOrderList", "TEXT", i220, i236, i264, i289);
            hashMap24.put("childOrderList", aVar98);
            super("locale_questionId", "TEXT", i220, 1, i264, i289);
            hashMap24.put(str157, aVar99);
            int i73 = 0;
            HashSet hashSet20 = new HashSet(i73);
            HashSet hashSet39 = new HashSet(i73);
            g gVar45 = new g("OnboardingQuestionEntity", hashMap24, hashSet20, hashSet39);
            g gVar26 = g.a(gVar, "OnboardingQuestionEntity");
            if (!gVar45.equals(gVar26)) {
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append("OnboardingQuestionEntity(app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity).\n Expected:\n");
                stringBuilder9.append(gVar45);
                stringBuilder9.append(str129);
                stringBuilder9.append(gVar26);
                w0.b bVar9 = new w0.b(0, stringBuilder9.toString());
                return bVar9;
            }
            HashMap hashMap25 = new HashMap(5);
            int i221 = 1;
            int i238 = 0;
            int i265 = 0;
            int i290 = 1;
            super("answerId", "TEXT", i221, i238, i265, i290);
            hashMap25.put("answerId", aVar100);
            super("text", "TEXT", i221, i238, i265, i290);
            hashMap25.put(str33, aVar101);
            int i325 = 1;
            int i351 = 0;
            int i371 = 1;
            super("updatedAt", "INTEGER", i325, 0, i351, i371);
            hashMap25.put(str76, aVar102);
            super("locale", "TEXT", i221, i238, i265, i290);
            hashMap25.put(str90, aVar103);
            super("locale_answerId", "TEXT", i325, 1, i351, i371);
            hashMap25.put("locale_answerId", aVar104);
            int i59 = 0;
            HashSet hashSet21 = new HashSet(i59);
            HashSet hashSet36 = new HashSet(i59);
            g gVar33 = new g("OnboardingAnswerEntity", hashMap25, hashSet21, hashSet36);
            g gVar27 = g.a(gVar, "OnboardingAnswerEntity");
            if (!gVar33.equals(gVar27)) {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append("OnboardingAnswerEntity(app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity).\n Expected:\n");
                stringBuilder8.append(gVar33);
                stringBuilder8.append(str129);
                stringBuilder8.append(gVar27);
                w0.b bVar8 = new w0.b(0, stringBuilder8.toString());
                return bVar8;
            }
            HashMap hashMap26 = new HashMap(2);
            super("locale_questionId", "TEXT", 1, 1, 0, 1);
            hashMap26.put(str157, aVar105);
            super("locale_answerId", "TEXT", 1, 2, 0, 1);
            hashMap26.put("locale_answerId", aVar106);
            int i60 = 0;
            HashSet hashSet22 = new HashSet(i60);
            HashSet hashSet37 = new HashSet(2);
            g.d dVar15 = new g.d("index_OnboardingQuestionWithAnswer_locale_questionId", i60, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet37.add(dVar15);
            g.d dVar16 = new g.d("index_OnboardingQuestionWithAnswer_locale_answerId", i60, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet37.add(dVar16);
            g gVar34 = new g("OnboardingQuestionWithAnswer", hashMap26, hashSet22, hashSet37);
            g gVar28 = g.a(gVar, "OnboardingQuestionWithAnswer");
            if (!gVar34.equals(gVar28)) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append("OnboardingQuestionWithAnswer(app.dogo.android.persistencedb.room.junction.OnboardingQuestionWithAnswer).\n Expected:\n");
                stringBuilder7.append(gVar34);
                stringBuilder7.append(str129);
                stringBuilder7.append(gVar28);
                w0.b bVar7 = new w0.b(0, stringBuilder7.toString());
                return bVar7;
            }
            HashMap hashMap27 = new HashMap(5);
            int i223 = 1;
            super("categoryId", "TEXT", i223, 0, 0, 1);
            hashMap27.put(str327, aVar107);
            super("locale", "TEXT", 1, 0, 0, i223);
            hashMap27.put(str90, aVar108);
            int i304 = 1;
            super("name", "TEXT", i304, 0, 0, 1);
            hashMap27.put(str72, aVar109);
            super("updatedAt", "INTEGER", 1, 0, 0, 1);
            hashMap27.put(str76, aVar110);
            super("locale_categoryId", "TEXT", 1, i304, 0, 1);
            hashMap27.put("locale_categoryId", aVar111);
            int i61 = 0;
            HashSet hashSet23 = new HashSet(i61);
            HashSet hashSet38 = new HashSet(i61);
            g gVar35 = new g("TrickCategoryEntity", hashMap27, hashSet23, hashSet38);
            g gVar29 = g.a(gVar, "TrickCategoryEntity");
            if (!gVar35.equals(gVar29)) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("TrickCategoryEntity(app.dogo.android.persistencedb.room.entity.TrickCategoryEntity).\n Expected:\n");
                stringBuilder6.append(gVar35);
                stringBuilder6.append(str129);
                stringBuilder6.append(gVar29);
                w0.b bVar6 = new w0.b(0, stringBuilder6.toString());
                return bVar6;
            }
            HashMap hashMap28 = new HashMap(8);
            int i183 = 1;
            int i190 = 0;
            int i200 = 0;
            int i209 = 1;
            super("tips", "TEXT", i183, i190, i200, i209);
            hashMap28.put("tips", aVar112);
            super("variationId", "TEXT", i183, i190, i200, i209);
            hashMap28.put("variationId", aVar113);
            super("title", "TEXT", i183, i190, i200, i209);
            hashMap28.put(str69, aVar114);
            int i174 = 1;
            int i178 = 0;
            int i184 = 0;
            int i191 = 1;
            super("description", "TEXT", i174, i178, i184, i191);
            hashMap28.put(str119, aVar115);
            super("locale", "TEXT", i174, i178, i184, i191);
            hashMap28.put(str90, aVar116);
            int i241 = 1;
            int i294 = 0;
            int i305 = 1;
            super("contentfulId", "TEXT", i241, 0, i294, i305);
            hashMap28.put("contentfulId", aVar117);
            super("updatedAt", "INTEGER", i174, i178, i184, i191);
            hashMap28.put(str76, aVar118);
            super("locale_variationId", "TEXT", i241, 1, i294, i305);
            hashMap28.put("locale_variationId", aVar119);
            int i62 = 0;
            HashSet hashSet24 = new HashSet(i62);
            HashSet hashSet30 = new HashSet(i62);
            g gVar36 = new g("TrickVariationEntity", hashMap28, hashSet24, hashSet30);
            g gVar30 = g.a(gVar, "TrickVariationEntity");
            if (!gVar36.equals(gVar30)) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("TrickVariationEntity(app.dogo.android.persistencedb.room.entity.TrickVariationEntity).\n Expected:\n");
                stringBuilder5.append(gVar36);
                stringBuilder5.append(str129);
                stringBuilder5.append(gVar30);
                w0.b bVar5 = new w0.b(0, stringBuilder5.toString());
                return bVar5;
            }
            HashMap hashMap29 = new HashMap(2);
            int i175 = 1;
            int i185 = 0;
            int i192 = 1;
            super("locale_variationId", "TEXT", i175, 1, i185, i192);
            hashMap29.put("locale_variationId", aVar120);
            super("locale_trickId", "TEXT", i175, 2, i185, i192);
            hashMap29.put(str210, aVar121);
            int i63 = 0;
            HashSet hashSet25 = new HashSet(i63);
            HashSet hashSet31 = new HashSet(2);
            g.d dVar5 = new g.d("index_TrickWithVariations_locale_variationId", i63, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet31.add(dVar5);
            g.d dVar6 = new g.d("index_TrickWithVariations_locale_trickId", i63, Arrays.asList(/* result */), Arrays.asList(/* result */));
            hashSet31.add(dVar6);
            g gVar37 = new g("TrickWithVariations", hashMap29, hashSet25, hashSet31);
            g gVar2 = g.a(gVar, "TrickWithVariations");
            if (!gVar37.equals(gVar2)) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("TrickWithVariations(app.dogo.android.persistencedb.room.junction.TrickWithVariations).\n Expected:\n");
                stringBuilder4.append(gVar37);
                stringBuilder4.append(str129);
                stringBuilder4.append(gVar2);
                w0.b bVar30 = new w0.b(0, stringBuilder4.toString());
                return bVar30;
            }
            w0.b bVar4 = new w0.b(1, 0);
            return bVar4;
        }
    }
    static List N(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List P(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List Q(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List R(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List S(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List T(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static g U(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl, g g2) {
        contentDatabase_Impl.a = g2;
        return g2;
    }

    static void V(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl, g g2) {
        contentDatabase_Impl.t(g2);
    }

    static List W(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    static List X(app.dogo.android.persistencedb.room.database.ContentDatabase_Impl contentDatabase_Impl) {
        return contentDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public q H() {
        q rVar;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            rVar = new r(this);
            this.u = rVar;
            return this.u;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public c0 I() {
        c0 d0Var;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            d0Var = new d0(this);
            this.v = d0Var;
            return this.v;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public e0 J() {
        e0 f0Var;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            f0Var = new f0(this);
            this.t = f0Var;
            return this.t;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public g0 K() {
        g0 h0Var;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            h0Var = new h0(this);
            this.s = h0Var;
            return this.s;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public i0 L() {
        i0 j0Var;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            j0Var = new j0(this);
            this.r = j0Var;
            return this.r;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    public m0 M() {
        m0 n0Var;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            n0Var = new n0(this);
            this.q = n0Var;
            return this.q;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.room.database.ContentDatabase
    protected h f(e0 e0) {
        ContentDatabase_Impl.a aVar = new ContentDatabase_Impl.a(this, 72);
        w0 w0Var = new w0(e0, aVar, "c721869b5384407530df9939ea8c8d1b", "b30f2a9f1fbcb9e03714cab51d4b2d5c");
        h.b.a aVar2 = h.b.a(e0.b);
        aVar2.c(e0.c);
        aVar2.b(w0Var);
        return e0.a.a(aVar2.a());
    }

    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    public Set<Class<? extends a>> m() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(m0.class, n0.X());
        hashMap.put(i0.class, j0.e());
        hashMap.put(g0.class, h0.A());
        hashMap.put(e0.class, f0.m0());
        hashMap.put(q.class, r.h());
        hashMap.put(c0.class, d0.q());
        return hashMap;
    }
}
