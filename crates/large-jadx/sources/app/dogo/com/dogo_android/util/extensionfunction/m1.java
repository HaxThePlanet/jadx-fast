package app.dogo.com.dogo_android.util.h0;

import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.BreedEntity;
import app.dogo.android.persistencedb.room.entity.CouponEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity;
import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import app.dogo.android.persistencedb.room.entity.TrickCategoryEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import app.dogo.com.dogo_android.model.BreedModel;
import app.dogo.com.dogo_android.model.CouponModel;
import app.dogo.com.dogo_android.model.survey.SurveyAnswerModel;
import app.dogo.com.dogo_android.model.survey.SurveyQuestionModel;
import app.dogo.com.dogo_android.model.trainingprogram.ArticleModel;
import app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.QuestionModel;
import app.dogo.com.dogo_android.model.trainingprogram.TasksModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import e.a.a.a.b.d.b;
import e.a.a.a.b.d.c;
import e.a.a.a.b.d.d;
import e.a.a.a.b.d.e;
import e.a.a.a.b.d.f;
import e.a.a.a.b.d.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: RoomExtensions.kt */
@Metadata(d1 = "\u0000®\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u001a$\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u0014\u0010\u0008\u001a\u00020\t*\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0001\u001a\n\u0010\u000c\u001a\u00020\n*\u00020\r\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0014*\u00020\u0013\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004\u001a\n\u0010\u0016\u001a\u00020\u001a*\u00020\u001b\u001a\n\u0010\u0016\u001a\u00020\u001c*\u00020\u001d\u001a\n\u0010\u0016\u001a\u00020\u001e*\u00020\u001f\u001a\n\u0010 \u001a\u00020!*\u00020\u0017\u001a\n\u0010\"\u001a\u00020#*\u00020$\u001a\n\u0010%\u001a\u00020$*\u00020#\u001a\n\u0010&\u001a\u00020'*\u00020\u0010\u001a\n\u0010(\u001a\u00020\u001b*\u00020\u001a\u001a\n\u0010(\u001a\u00020\u001f*\u00020\u001e\u001a\n\u0010(\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010)\u001a\u00020**\u00020+\u001a\n\u0010,\u001a\u00020+*\u00020*\u001a\n\u0010-\u001a\u00020.*\u00020/\u001a\n\u00100\u001a\u00020/*\u00020.\u001a\u0012\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u000205\u001a\u0012\u00106\u001a\u000207*\u0002082\u0006\u00104\u001a\u000209\u001a\n\u0010:\u001a\u000203*\u00020;\u001a\n\u0010<\u001a\u00020;*\u000203\u001a\n\u0010=\u001a\u000208*\u00020>\u001a\n\u0010?\u001a\u00020>*\u000208\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\u001b\u0010C\u001a\u00020D*\u00020A2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F¢\u0006\u0002\u0010G\u001a3\u0010H\u001a\u00020I*\u00020A2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0016\u0008\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020F\u0018\u00010K¢\u0006\u0002\u0010M\u001a\u0012\u0010N\u001a\u00020O*\u00020P2\u0006\u0010Q\u001a\u00020L\u001a\u0012\u0010R\u001a\u00020S*\u00020P2\u0006\u0010Q\u001a\u00020L\u001a\n\u0010T\u001a\u00020B*\u00020A\u001a\n\u0010U\u001a\u00020V*\u00020W\u001a\n\u0010X\u001a\u00020W*\u00020V\u001a\n\u0010Y\u001a\u00020Z*\u00020[\u001a\n\u0010\\\u001a\u00020]*\u00020^\u001a\n\u0010_\u001a\u00020^*\u00020]\u001a\n\u0010`\u001a\u00020a*\u00020b\u001a\n\u0010c\u001a\u00020b*\u00020a¨\u0006d", d2 = {"isActive", "", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "currentTimeMs", "", "gracePeriod", "isCacheValid", "validLengthInMs", "toArticle", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "isRead", "toArticleEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "toArticleModel", "toArticleTagEntity", "Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "toBreedEntity", "Lapp/dogo/android/persistencedb/room/entity/BreedEntity;", "Lapp/dogo/com/dogo_android/model/BreedModel;", "toBreedModel", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "Lapp/dogo/com/dogo_android/model/CouponModel;", "activationTime", "Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "Lapp/dogo/com/dogo_android/model/survey/SurveyAnswerModel;", "Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "toItem", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "toLessonEntity", "Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "toLessonModel", "toLibraryTag", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "toModel", "toModuleEntity", "Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "toModuleModel", "toProgramEntity", "Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "toProgramModel", "toProgramQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "toProgramTask", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "toQuestionEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "toQuestionModel", "toTaskEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/TasksModel;", "toTaskModel", "toTrickEntity", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "toTrickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "knowledge", "", "(Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;Ljava/lang/Integer;)Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "toTrickItemWithVariations", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "variationKnowledge", "", "", "(Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;Ljava/lang/Integer;Ljava/util/Map;)Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "toTrickKnowledge", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TrickAttempt;", "dogId", "toTrickKnowledgeRateData", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "toTrickModel", "toTrickStepEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "toTrickStepModel", "toTrickTagEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "toTrickVariationEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVariation;", "toTrickVariationModel", "toTrickVideoStepEntity", "Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "toVideoStepModel", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class m1 {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(t.getIndex()), Integer.valueOf(t2.getIndex()));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(t.getIndex()), Integer.valueOf(t2.getIndex()));
        }
    }
    /* renamed from: A, reason: from kotlin metadata */
    public static final QuestionModel toArticle(f isRead) {
        n.f(isRead, "<this>");
        QuestionModel isRead2 = new QuestionModel(isRead.b().getQuestionId(), isRead.b().getQuestion(), isRead.a().component1().getText(), isRead.a().component1().getTextHtml(), app.dogo.com.dogo_android.util.extensionfunction.m1.h(isRead.a()), isRead.b().getAnswers(), isRead.b().getCorrectAnswer(), 0L, str2, isRead.b().getLocale(), 128, 0);
        return isRead2;
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final TaskEntity toEntity(TasksModel activationTime) {
        n.f(activationTime, "<this>");
        TaskEntity taskEntity = new TaskEntity(activationTime.getId(), activationTime.getText(), activationTime.getLocale(), activationTime.getUpdatedAt(), str2, 0, 16, 0);
        return taskEntity;
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final TasksModel toProgramQuestion(TaskEntity type) {
        n.f(type, "<this>");
        TasksModel tasksModel = new TasksModel(type.getTaskId(), type.getText(), 0L, str2, type.getLocale(), 4, 0);
        return tasksModel;
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final g toProgramTask(TrickModel type) {
        n.f(type, "<this>");
        List trickSteps = type.getTrickSteps();
        int i6 = 10;
        ArrayList arrayList = new ArrayList(p.r(trickSteps, i6));
        Iterator it = trickSteps.iterator();
        while (it.hasNext()) {
            arrayList.add((TrickModel_TrickStep)it.next().getId());
        }
        List videoSteps = type.getVideoSteps();
        ArrayList arrayList6 = new ArrayList(p.r(videoSteps, i6));
        Iterator it2 = videoSteps.iterator();
        while (it2.hasNext()) {
            arrayList6.add((TrickModel_TrickVideoStep)it2.next().getId());
        }
        TrickEntity trickEntity = new TrickEntity(type.getId(), type.getName(), type.getImage(), type.getCategory().getName(), type.getCategory().getId(), type.getExamInstructions(), type.getExamTimeLimit(), type.getSortOrder(), type.isExam(), type.getHasProgress(), type.getUpdatedAt(), str2, videoId, type.getVideoThumbnail(), type.getDescription(), type.getLocale(), null, arrayList, arrayList6, 32768, 0);
        List videoSteps2 = type.getVideoSteps();
        ArrayList arrayList2 = new ArrayList(p.r(videoSteps2, i6));
        Iterator it4 = videoSteps2.iterator();
        while (it4.hasNext()) {
            arrayList2.add(app.dogo.com.dogo_android.util.extensionfunction.m1.N((TrickModel_TrickVideoStep)it4.next()));
        }
        List trickSteps2 = type.getTrickSteps();
        ArrayList arrayList3 = new ArrayList(p.r(trickSteps2, i6));
        Iterator it5 = trickSteps2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickKnowledge((TrickModel_TrickStep)it5.next()));
        }
        List tags = type.getTags();
        ArrayList arrayList4 = new ArrayList(p.r(tags, i6));
        Iterator it6 = tags.iterator();
        while (it6.hasNext()) {
            arrayList4.add(app.dogo.com.dogo_android.util.extensionfunction.m1.K((TrickModel_TrickTag)it6.next()));
        }
        List variations = type.getVariations();
        ArrayList arrayList5 = new ArrayList(p.r(variations, i6));
        Iterator it3 = variations.iterator();
        while (it3.hasNext()) {
            arrayList5.add(app.dogo.com.dogo_android.util.extensionfunction.m1.L((TrickModel_TrickVariation)it3.next()));
        }
        TrickFullEntity trickFullEntity = new TrickFullEntity(trickEntity, arrayList2, arrayList3, arrayList4, arrayList5);
        return trickFullEntity;
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final TrickItem isActive(g currentTimeMs, Integer gracePeriod) {
        String examInstructions;
        int value = 2147483647;
        int value2 = 0;
        List list;
        long parsed = 0;
        int startTime = -1;
        TrickItem.VideoStep trickItem_VideoStep;
        String text;
        int i3;
        n.f(currentTimeMs, "<this>");
        value2 = 0;
        int i6 = 10;
        if (currentTimeMs.d().getVideoId() != null) {
            List list2 = currentTimeMs.g();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                Object item4 = it.next();
                value2 = value2 + 1;
                if (value2 < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
        } else {
            list = p.g();
        }
        if (currentTimeMs.d().getExamInstructions() == null) {
            if (currentTimeMs.d().getDescription() == null) {
                examInstructions = "";
            }
        }
        if (gracePeriod != null) {
            value2 = gracePeriod.intValue();
        }
        List list3 = currentTimeMs.e();
        final ArrayList arrayList3 = new ArrayList(p.r(list3, i6));
        Iterator it2 = list3.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            arrayList3.add(new TrickItem_TrickStep(item.getDescription(), item.getImage()));
        }
        String videoId2 = currentTimeMs.d().getVideoId();
        if (videoId2 == null) {
            int i7 = 0;
        } else {
            parsed = Long.parseLong(videoId2);
        }
        Integer sortOrder = currentTimeMs.d().getSortOrder();
        if (sortOrder == null) {
            value = Integer.MAX_VALUE;
        } else {
            value = sortOrder.intValue();
        }
        List list4 = currentTimeMs.c();
        ArrayList arrayList = new ArrayList(p.r(list4, i6));
        Iterator it3 = list4.iterator();
        while (it3.hasNext()) {
            Object item2 = it3.next();
            boolean z = false;
            int i4 = 1;
            kotlin.d0.d.g gVar = null;
            LibraryTag libraryTag = new LibraryTag(z, item2.getName(), item2.getTagId(), i4, gVar);
            arrayList.add(libraryTag);
        }
        TrickItem trickItem = new TrickItem(currentTimeMs.d().getTrickId(), currentTimeMs.d().getName(), examInstructions, currentTimeMs.d().getImage(), false, value2, arrayList3, list, parsed, z2, currentTimeMs.d().getHasProgress(), value, arrayList, new TrickItem_TrickCategory(currentTimeMs.d().getCategoryId(), currentTimeMs.d().getCategoryName()), null, false, !currentTimeMs.f().isEmpty(), null, null, 0, 0, 1007616, 0);
        return trickItem;
    }

    /* renamed from: F, reason: from kotlin metadata */
    public static final TrickItemWithVariations isCacheValid(g currentTimeMs, Integer validLengthInMs, Map<String, Integer> gracePeriod) {
        int value = 0;
        String value2 = null;
        ArrayList arrayList;
        Object gracePeriod2 = gracePeriod;
        n.f(currentTimeMs, "<this>");
        TrickItem active = app.dogo.com.dogo_android.util.extensionfunction.m1.isActive(currentTimeMs, validLengthInMs);
        List list = currentTimeMs.f();
        arrayList = new ArrayList(p.r(list, 10));
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            value = 0;
            value2 = null;
            String str = null;
            String str2 = null;
            int i2 = 0;
            List list2 = null;
            List list3 = null;
            boolean z = false;
            int i3 = 0;
            List list4 = null;
            TrickItem.TrickCategory trickCategory = null;
            boolean z2 = false;
            app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = null;
            boolean z3 = false;
            int i4 = 0;
            int i5 = 557019;
            Object obj = null;
            i = arrayList;
            i.add(TrickItem.copy$default(active, null, value2, item.getDescription(), str, str2, value, i2, list2, list3, z, i3, list4, trickCategory, z2, vimeoData, z3, item.getVariationId(), item.getTips(), item.getTitle(), i4, i5, obj));
            arrayList = i;
        }
        return new TrickItemWithVariations(active, arrayList);
    }

    public static /* synthetic */ TrickItemWithVariations G(g gVar, Integer integer, Map map, int i, Object object) {
        Integer num;
        if (i & 1 != 0) {
            num = 0;
        }
        if (i & 2 != 0) {
            int i2 = 0;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.m1.isCacheValid(gVar, num, map);
    }

    /* renamed from: H, reason: from kotlin metadata */
    public static final TrickModel toTrickItem(g knowledge) {
        Object knowledge2;
        Object item2;
        boolean hasNext2;
        boolean z2;
        long l = 0;
        Object item;
        String locale;
        Object obj;
        n.f(knowledge, "<this>");
        List list = knowledge.e();
        int i6 = 10;
        ArrayList arrayList4 = new ArrayList(p.r(list, i6));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickKnowledgeRateData((TrickStepEntity)it2.next()));
        }
        List list2 = knowledge.g();
        ArrayList arrayList5 = new ArrayList(p.r(list2, i6));
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList5.add(app.dogo.com.dogo_android.util.extensionfunction.m1.O((VideoStepEntity)it3.next()));
        }
        List list3 = knowledge.f();
        ArrayList arrayList = new ArrayList(p.r(list3, i6));
        Iterator it4 = list3.iterator();
        while (it4.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.M((TrickVariationEntity)it4.next()));
        }
        final ArrayList arrayList6 = new ArrayList();
        Iterator it5 = knowledge.d().getImageStepOrder().iterator();
        while (it5.hasNext()) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                item2 = it.next();
                if (n.b((TrickModel_TrickStep)item2.getId(), (String)it5.next())) {
                    break loop_12;
                }
            }
            int i7 = 0;
            item2 = it.next();
        }
        l = 0L;
        int i5 = 0;
        TrickModel_TrickCategory trickModel_TrickCategory = new TrickModel_TrickCategory(knowledge.d().getCategoryId(), knowledge.d().getCategoryName(), l, str2, knowledge.d().getLocale(), 4, i5);
        List list4 = knowledge.c();
        ArrayList arrayList2 = new ArrayList(p.r(list4, i6));
        Iterator it6 = list4.iterator();
        while (it6.hasNext()) {
            Object item3 = it6.next();
            l = 0L;
            i5 = 0;
            trickModel_TrickCategory = new TrickModel_TrickTag(item3.getTagId(), item3.getName(), l, str2, knowledge.d().getLocale(), 4, i5);
            arrayList2.add(trickModel_TrickTag);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it7 = knowledge.d().getVideoStepOder().iterator();
        while (it7.hasNext()) {
            Iterator it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                if (n.b((TrickModel_TrickVideoStep)it8.next().getId(), (String)it7.next())) {
                    break loop_24;
                }
            }
            int i8 = 0;
            knowledge2 = knowledge;
        }
        TrickModel trickModel = new TrickModel(knowledge.d().getTrickId(), knowledge.d().getName(), knowledge.d().getImage(), arrayList6, trickModel_TrickCategory, knowledge.d().getExamInstructions(), knowledge.d().getExamTimeLimit(), knowledge.d().isExam(), knowledge.d().getSortOrder(), arrayList2, knowledge.d().getHasProgress(), knowledge.d().getVideoId(), knowledge.d().getVideoThumbnail(), arrayList3, knowledge.d().getDescription(), knowledge.d().getUpdatedAt(), obj, knowledge.d().getLocale(), arrayList);
        return trickModel;
    }

    /* renamed from: I, reason: from kotlin metadata */
    public static final TrickStepEntity toTrickKnowledge(TrickModel.TrickStep dogId) {
        n.f(dogId, "<this>");
        TrickStepEntity dogId2 = new TrickStepEntity(dogId.getId(), dogId.getDescription(), dogId.getImage(), dogId.getLocale(), dogId.getUpdatedAt(), str2, 0, 32, 0);
        return dogId2;
    }

    /* renamed from: J, reason: from kotlin metadata */
    public static final TrickModel.TrickStep toTrickKnowledgeRateData(TrickStepEntity dogId) {
        n.f(dogId, "<this>");
        TrickModel_TrickStep dogId2 = new TrickModel_TrickStep(dogId.getStepId(), dogId.getImage(), dogId.getDescription(), 0L, str2, dogId.getLocale(), 8, 0);
        return dogId2;
    }

    public static final TrickTagEntity K(TrickModel.TrickTag trickTag) {
        n.f(trickTag, "<this>");
        TrickTagEntity trickTag2 = new TrickTagEntity(trickTag.getId(), trickTag.getLocale(), trickTag.getName(), trickTag.getUpdatedAt(), str2, 0, 16, 0);
        return trickTag2;
    }

    public static final TrickVariationEntity L(TrickModel.TrickVariation trickVariation) {
        n.f(trickVariation, "<this>");
        TrickVariationEntity trickVariationEntity = new TrickVariationEntity(trickVariation.getTips(), trickVariation.getId(), trickVariation.getTitle(), trickVariation.getDescription(), trickVariation.getLocale(), trickVariation.getContentfulId(), trickVariation.getUpdatedAt(), str2, 0, 128, 0);
        return trickVariationEntity;
    }

    public static final TrickModel.TrickVariation M(TrickVariationEntity trickVariationEntity) {
        n.f(trickVariationEntity, "<this>");
        TrickModel_TrickVariation trickModel_TrickVariation = new TrickModel_TrickVariation(trickVariationEntity.getTips(), trickVariationEntity.getVariationId(), trickVariationEntity.getTitle(), trickVariationEntity.getDescription(), trickVariationEntity.getLocale(), trickVariationEntity.getContentfulId(), trickVariationEntity.getUpdatedAt(), obj);
        return trickModel_TrickVariation;
    }

    public static final VideoStepEntity N(TrickModel.TrickVideoStep trickVideoStep) {
        n.f(trickVideoStep, "<this>");
        VideoStepEntity videoStepEntity = new VideoStepEntity(trickVideoStep.getId(), trickVideoStep.getText(), trickVideoStep.getLocale(), trickVideoStep.getStartTime(), trickVideoStep.getUpdatedAt(), str2, 0, 32, 0);
        return videoStepEntity;
    }

    public static final TrickModel.TrickVideoStep O(VideoStepEntity videoStepEntity) {
        n.f(videoStepEntity, "<this>");
        TrickModel_TrickVideoStep trickModel_TrickVideoStep = new TrickModel_TrickVideoStep(videoStepEntity.getStepId(), videoStepEntity.getText(), videoStepEntity.getStartTime(), 0L, str2, videoStepEntity.getLocale(), 8, 0);
        return trickModel_TrickVideoStep;
    }

    public static final boolean a(DogoPremiumStatusEntity dogoPremiumStatusEntity, long j, long j2) {
        int cmp;
        boolean z = false;
        n.f(dogoPremiumStatusEntity, "<this>");
        long expirationTimeMs = dogoPremiumStatusEntity.getExpirationTimeMs();
        if (j >= expirationTimeMs) {
            l = dogoPremiumStatusEntity.getExpirationTimeMs() + j2;
            if (j < l) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public static /* synthetic */ boolean b(DogoPremiumStatusEntity dogoPremiumStatusEntity, long j, long j2, int i, Object object) {
        if (i & 2 != 0) {
            i = 1800000;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.m1.a(dogoPremiumStatusEntity, j, i);
    }

    public static final boolean c(DogoPremiumStatusEntity dogoPremiumStatusEntity, long j, long j2, long j3) {
        boolean z = false;
        int i;
        n.f(dogoPremiumStatusEntity, "<this>");
        long updatedAt = dogoPremiumStatusEntity.getUpdatedAt();
        long l = 0L;
        i = 0;
        if (updatedAt == l) {
            long expirationTimeMs = dogoPremiumStatusEntity.getExpirationTimeMs();
            if (expirationTimeMs == l) {
                return false;
            }
        }
        long l2 = dogoPremiumStatusEntity.getUpdatedAt() + j2;
        i = 1;
        j2 = i;
        long l3 = dogoPremiumStatusEntity.getExpirationTimeMs() + j3;
        j = i;
        long updatedAt3 = dogoPremiumStatusEntity.getUpdatedAt();
        long l4 = dogoPremiumStatusEntity.getExpirationTimeMs() + j3;
        dogoPremiumStatusEntity = i;
        if (i != 0 && i == 0 && i != 0) {
        }
        return z;
    }

    public static /* synthetic */ boolean d(DogoPremiumStatusEntity dogoPremiumStatusEntity, long j, long j2, long j3, int i, Object object) {
        int object62 = 1800000;
        if (i & 4 != 0) {
            object62 = 1800000;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.m1.c(dogoPremiumStatusEntity, j, j2, object62);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final Article toTrickItemWithVariations(e.a.a.a.b.d.a knowledge, boolean variationKnowledge) {
        String image;
        n.f(knowledge, "<this>");
        List list = knowledge.b();
        final ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.r((ArticleTagEntity)it.next()));
        }
        if (knowledge.component1().getImage() == null) {
            image = "";
        }
        Article article = new Article(knowledge.component1().getTitle(), knowledge.component1().getArticleId(), knowledge.component1().getText(), arrayList, knowledge.component1().getReadingTime(), image, false, knowledge.component1().getCategoryId(), knowledge.component1().getSortOrder(), variationKnowledge, null, knowledge.component1().getTextHtml(), 1024, null);
        return article;
    }

    public static /* synthetic */ Article f(e.a.a.a.b.d.a aVar, boolean z, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItemWithVariations(aVar, z);
    }

    public static final e.a.a.a.b.d.a g(ArticleModel articleModel) {
        n.f(articleModel, "<this>");
        ArticleEntity articleEntity = new ArticleEntity(articleModel.getId(), articleModel.getTitle(), articleModel.getText(), articleModel.getReadingTime(), articleModel.getSortOrder(), articleModel.getCategory(), articleModel.getImage(), articleModel.getLocale(), articleModel.getUpdatedAt(), str2, null, articleModel.getTextHtml(), 512, 0);
        List tags = articleModel.getTags();
        ArrayList arrayList = new ArrayList(p.r(tags, 10));
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.i((ArticleModel_ArticleTag)it.next()));
        }
        return new ArticleFullEntity(articleEntity, arrayList);
    }

    public static final ArticleModel h(e.a.a.a.b.d.a aVar) {
        String image;
        n.f(aVar, "<this>");
        List list = aVar.b();
        final ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            long l = 0L;
            kotlin.d0.d.g gVar = 4;
            int i2 = 0;
            ArticleModel_ArticleTag articleModel_ArticleTag = new ArticleModel_ArticleTag(item.getTagId(), item.getLocale(), l, str3, item.getName(), item.getHidden(), gVar, i2);
            arrayList.add(articleModel_ArticleTag);
        }
        if (aVar.component1().getImage() == null) {
            image = "";
        }
        ArticleModel articleModel = new ArticleModel(aVar.component1().getArticleId(), null, 0L, str2, aVar.component1().getTitle(), aVar.component1().getText(), aVar.component1().getReadingTime(), null, aVar.component1().getCategoryId(), image, arrayList, aVar.component1().getTextHtml(), 70, 0);
        return articleModel;
    }

    public static final ArticleTagEntity i(ArticleModel.ArticleTag articleTag) {
        n.f(articleTag, "<this>");
        ArticleTagEntity articleTag2 = new ArticleTagEntity(articleTag.getHidden(), articleTag.getId(), articleTag.getLocale(), articleTag.getName(), articleTag.getUpdatedAt(), str2, 0, 32, 0);
        return articleTag2;
    }

    public static final BreedEntity j(BreedModel breedModel) {
        n.f(breedModel, "<this>");
        BreedEntity breedEntity = new BreedEntity(breedModel.getId(), breedModel.getTitle(), breedModel.getLocale(), breedModel.getUpdatedAt(), str2, 0, 16, 0);
        return breedEntity;
    }

    public static final CouponEntity k(CouponModel couponModel, long j) {
        CouponEntity couponEntity = null;
        long millis;
        long value = 0;
        long value2;
        offeringId = "<this>";
        Object couponModel2 = couponModel;
        n.f(couponModel, offeringId);
        final String couponId = couponModel.getCouponId();
        if (couponId != null && couponModel.getOfferingId() != null) {
            Long offerDurationMs = couponModel.getOfferDurationMs();
            value = 0L;
            if (offerDurationMs == null) {
                Long discount = couponModel.getDiscount();
                if (discount != null) {
                    value = discount.longValue();
                }
                Long offerDurationMs2 = couponModel.getOfferDurationMs();
                if (offerDurationMs2 == null) {
                    long l = 24L;
                    millis = TimeUnit.HOURS.toMillis(l);
                } else {
                    millis = offerDurationMs2.longValue();
                }
                int i = 0;
                str = "";
                couponEntity = new CouponEntity(couponId, value, str2, couponModel.getOfferingId(), millis, str3, j, map3, str, j0.h(), j0.h(), i);
            } else {
                value2 = offerDurationMs.longValue();
                if (value2 == value) {
                    int i2 = 0;
                }
            }
        }
        return couponEntity;
    }

    public static final OnboardingAnswerEntity l(SurveyAnswerModel surveyAnswerModel) {
        n.f(surveyAnswerModel, "<this>");
        OnboardingAnswerEntity surveyAnswerModel2 = new OnboardingAnswerEntity(surveyAnswerModel.getId(), surveyAnswerModel.getText(), surveyAnswerModel.getUpdatedAt(), str2, surveyAnswerModel.getLocale(), 0, 16, 0);
        return surveyAnswerModel2;
    }

    public static final TrickCategoryEntity m(TrickModel.TrickCategory trickCategory) {
        n.f(trickCategory, "<this>");
        TrickCategoryEntity trickCategoryEntity = new TrickCategoryEntity(trickCategory.getId(), trickCategory.getLocale(), trickCategory.getName(), trickCategory.getUpdatedAt(), str2, 0, 16, 0);
        return trickCategoryEntity;
    }

    public static final d n(SurveyQuestionModel surveyQuestionModel) {
        n.f(surveyQuestionModel, "<this>");
        List answers = surveyQuestionModel.getAnswers();
        final int i6 = 10;
        final ArrayList arrayList2 = new ArrayList(p.r(answers, i6));
        Iterator it = answers.iterator();
        while (it.hasNext()) {
            arrayList2.add((SurveyAnswerModel)it.next().getId());
        }
        OnboardingQuestionEntity onboardingQuestionEntity = new OnboardingQuestionEntity(surveyQuestionModel.getId(), surveyQuestionModel.getText(), surveyQuestionModel.getUpdatedAt(), str2, surveyQuestionModel.getLocale(), arrayList2, 0, 32, 0);
        List answers2 = surveyQuestionModel.getAnswers();
        ArrayList arrayList = new ArrayList(p.r(answers2, i6));
        Iterator it2 = answers2.iterator();
        while (it2.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.l((SurveyAnswerModel)it2.next()));
        }
        return new OnboardingQuestionFullEntity(onboardingQuestionEntity, arrayList);
    }

    public static final CouponDiscount o(CouponEntity couponEntity) {
        Map offerText;
        CouponDiscount couponEntity2;
        Map couponEntity3;
        n.f(couponEntity, "<this>");
        if (couponEntity.isEmpty()) {
            String str = null;
            Long num = null;
            offerText = null;
            couponEntity2 = new CouponDiscount(null, str, null, num, false, null, offerText, null, 255, null);
        } else {
            if (couponEntity.getOfferText() == null) {
                offerText = j0.h();
            }
            if (couponEntity.getDiscountText() == null) {
                couponEntity3 = j0.h();
            }
            boolean z = false;
            int i = 16;
            kotlin.d0.d.g gVar = null;
            couponEntity2 = new CouponDiscount(String.valueOf(couponEntity.getDiscount()), couponEntity.getOfferingId(), num, Long.valueOf(couponEntity.getActivationTimeMs() + couponEntity.getOfferDurationMs()), z, offerText, couponEntity3, couponEntity.getStyle(), i, gVar);
        }
        return couponEntity2;
    }

    public static final b p(ProgramModel.LessonModel lessonModel) {
        n.f(lessonModel, "<this>");
        LessonEntity lessonEntity = new LessonEntity(lessonModel.getId(), lessonModel.getIndex(), lessonModel.getLocale(), lessonModel.getProgramId(), lessonModel.getUpdatedAt(), str2, 0, 32, 0);
        Collection values = lessonModel.getTasks().values();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(values, i3));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toEntity((TasksModel)it.next()));
        }
        Collection values2 = lessonModel.getTricks().values();
        ArrayList arrayList2 = new ArrayList(p.r(values2, i3));
        Iterator it2 = values2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toProgramTask((TrickModel)it2.next()));
        }
        return new LessonFullEntity(lessonEntity, arrayList, app.dogo.com.dogo_android.util.extensionfunction.m1.z(lessonModel.getQuestion()), arrayList2);
    }

    public static final ProgramModel.LessonModel q(b bVar) {
        o pair;
        String trickId;
        n.f(bVar, "<this>");
        List list = bVar.c();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(list, i3));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            arrayList.add(new Pair(item2.getTaskId(), app.dogo.com.dogo_android.util.extensionfunction.m1.toProgramQuestion(item2)));
        }
        List list2 = bVar.d();
        ArrayList arrayList2 = new ArrayList(p.r(list2, i3));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            arrayList2.add(new Pair(item.d().getTrickId(), app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem(item)));
        }
        ProgramModel_LessonModel bVar2 = new ProgramModel_LessonModel(bVar.component1().getLessonId(), app.dogo.com.dogo_android.util.extensionfunction.m1.toArticle(bVar.b()), j0.s(arrayList2), j0.s(arrayList), bVar.component1().getIndex(), null, bVar.component1().getProgramId(), bVar.component1().getUpdatedAt(), str2, bVar.component1().getLocale(), 32, 0);
        return bVar2;
    }

    public static final LibraryTag r(ArticleTagEntity articleTagEntity) {
        n.f(articleTagEntity, "<this>");
        return new LibraryTag(articleTagEntity.getHidden(), articleTagEntity.getName(), articleTagEntity.getTagId());
    }

    public static final SurveyAnswerModel s(OnboardingAnswerEntity onboardingAnswerEntity) {
        n.f(onboardingAnswerEntity, "<this>");
        SurveyAnswerModel onboardingAnswerEntity2 = new SurveyAnswerModel(onboardingAnswerEntity.getAnswerId(), onboardingAnswerEntity.getLocale(), onboardingAnswerEntity.getText(), onboardingAnswerEntity.getUpdatedAt(), obj);
        return onboardingAnswerEntity2;
    }

    public static final SurveyQuestionModel t(d dVar) {
        Object item2;
        boolean z;
        n.f(dVar, "<this>");
        List component1 = dVar.component1();
        final ArrayList arrayList = new ArrayList(p.r(component1, 10));
        Iterator it = component1.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.s((OnboardingAnswerEntity)it.next()));
        }
        final ArrayList arrayList2 = new ArrayList();
        Iterator it3 = dVar.b().getChildOrderList().iterator();
        while (it3.hasNext()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (n.b((String)it3.next(), (SurveyAnswerModel)item2.getId())) {
                    break loop_6;
                }
            }
            int i3 = 0;
        }
        SurveyQuestionModel dVar2 = new SurveyQuestionModel(arrayList2, dVar.b().getQuestionId(), dVar.b().getLocale(), dVar.b().getText(), dVar.b().getUpdatedAt(), obj);
        return dVar2;
    }

    public static final TrickModel.TrickCategory u(TrickCategoryEntity trickCategoryEntity) {
        n.f(trickCategoryEntity, "<this>");
        TrickModel_TrickCategory trickCategoryEntity2 = new TrickModel_TrickCategory(trickCategoryEntity.getCategoryId(), trickCategoryEntity.getName(), trickCategoryEntity.getUpdatedAt(), str2, trickCategoryEntity.getLocale());
        return trickCategoryEntity2;
    }

    public static final c v(ProgramModel.ModuleModel moduleModel) {
        n.f(moduleModel, "<this>");
        ModuleEntity moduleEntity = new ModuleEntity(moduleModel.getId(), moduleModel.getIndex(), moduleModel.getName(), moduleModel.getLocale(), moduleModel.getUpdatedAt(), str2, 0, 32, 0);
        List lessons = moduleModel.getLessons();
        int i3 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(lessons, i3));
        Iterator it = lessons.iterator();
        while (it.hasNext()) {
            arrayList2.add(app.dogo.com.dogo_android.util.extensionfunction.m1.p((ProgramModel_LessonModel)it.next()));
        }
        List exams = moduleModel.getExams();
        ArrayList arrayList = new ArrayList(p.r(exams, i3));
        Iterator it2 = exams.iterator();
        while (it2.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toProgramTask((TrickModel)it2.next()));
        }
        return new ModuleFullEntity(moduleEntity, arrayList2, arrayList);
    }

    public static final ProgramModel.ModuleModel w(c cVar) {
        n.f(cVar, "<this>");
        List list2 = cVar.b();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(list2, i3));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.q((LessonFullEntity)it.next()));
        }
        List component1 = cVar.component1();
        ArrayList arrayList2 = new ArrayList(p.r(component1, i3));
        Iterator it2 = component1.iterator();
        while (it2.hasNext()) {
            arrayList2.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem((TrickFullEntity)it2.next()));
        }
        ProgramModel_ModuleModel cVar2 = new ProgramModel_ModuleModel(cVar.c().getModuleId(), cVar.c().getIndex(), cVar.c().getName(), list, arrayList2, cVar.c().getUpdatedAt(), str2, cVar.c().getLocale());
        return cVar2;
    }

    public static final e x(ProgramModel programModel) {
        n.f(programModel, "<this>");
        ProgramEntity programEntity = new ProgramEntity(programModel.getType(), programModel.getId(), programModel.getName(), programModel.getImage(), programModel.getCenteredImage(), programModel.getDescription(), programModel.getCardBackgroundColor(), programModel.getCertificateLaurelsImage(), programModel.getCertificatePaperImage(), programModel.getCertificatePlaceholderImage(), programModel.getCertificateRequirements(), programModel.getLocale(), programModel.getUpdatedAt(), str2, null, programModel.getProgramOverviewImage(), programModel.getDogSkillsHighlights(), programModel.getDogSkillsOverview(), programModel.getUserSkillsOverview(), programModel.getAverageCompletionTimeWeeks(), programModel.getNumberOfEnrolledUsers(), programModel.getCertificatePreviewImage(), 8192, 0);
        List modules = programModel.getModules();
        ArrayList arrayList = new ArrayList(p.r(modules, 10));
        Iterator it = modules.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.v((ProgramModel_ModuleModel)it.next()));
        }
        return new ProgramFullEntity(programEntity, arrayList);
    }

    public static final ProgramModel y(e eVar) {
        n.f(eVar, "<this>");
        List component1 = eVar.component1();
        ArrayList arrayList = new ArrayList(p.r(component1, 10));
        Iterator it = component1.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.w((ModuleFullEntity)it.next()));
        }
        ProgramModel programModel = new ProgramModel(eVar.b().getProgramId(), eVar.b().getName(), p.D0(arrayList, new app.dogo.com.dogo_android.util.extensionfunction.m1.b()), eVar.b().getImage(), eVar.b().getCenteredImage(), eVar.b().getDescription(), eVar.b().getCardBackgroundColor(), eVar.b().getCertificateLaurelsImage(), eVar.b().getCertificatePaperImage(), eVar.b().getCertificatePlaceholderUrl(), eVar.b().getCertificateRequirements(), eVar.b().getUpdatedAt(), str2, eVar.b().getLocale(), eVar.b().getType(), eVar.b().getProgramOverviewImage(), eVar.b().getDogSkillsHighlights(), eVar.b().getDogSkillsOverview(), eVar.b().getUserSkillsOverview(), eVar.b().getAverageCompletionTimeWeeks(), eVar.b().getNumberOfEnrolledUsers(), eVar.b().getCertificatePreviewImage());
        return programModel;
    }

    public static final f z(QuestionModel questionModel) {
        n.f(questionModel, "<this>");
        QuestionEntity questionEntity = new QuestionEntity(questionModel.getId(), questionModel.getLocale(), questionModel.getQuestion(), questionModel.getAnswers(), questionModel.getCorrectAnswer(), questionModel.getUpdatedAt(), str2, 0, 64, 0);
        return new QuestionFullEntity(questionEntity, app.dogo.com.dogo_android.util.extensionfunction.m1.g(questionModel.getArticle()));
    }
}
