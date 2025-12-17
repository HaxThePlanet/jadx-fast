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
import e.a.a.a.b.d.a;
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
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u001a$\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u0014\u0010\u0008\u001a\u00020\t*\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0001\u001a\n\u0010\u000c\u001a\u00020\n*\u00020\r\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0014*\u00020\u0013\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004\u001a\n\u0010\u0016\u001a\u00020\u001a*\u00020\u001b\u001a\n\u0010\u0016\u001a\u00020\u001c*\u00020\u001d\u001a\n\u0010\u0016\u001a\u00020\u001e*\u00020\u001f\u001a\n\u0010 \u001a\u00020!*\u00020\u0017\u001a\n\u0010\"\u001a\u00020#*\u00020$\u001a\n\u0010%\u001a\u00020$*\u00020#\u001a\n\u0010&\u001a\u00020'*\u00020\u0010\u001a\n\u0010(\u001a\u00020\u001b*\u00020\u001a\u001a\n\u0010(\u001a\u00020\u001f*\u00020\u001e\u001a\n\u0010(\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010)\u001a\u00020**\u00020+\u001a\n\u0010,\u001a\u00020+*\u00020*\u001a\n\u0010-\u001a\u00020.*\u00020/\u001a\n\u00100\u001a\u00020/*\u00020.\u001a\u0012\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u000205\u001a\u0012\u00106\u001a\u000207*\u0002082\u0006\u00104\u001a\u000209\u001a\n\u0010:\u001a\u000203*\u00020;\u001a\n\u0010<\u001a\u00020;*\u000203\u001a\n\u0010=\u001a\u000208*\u00020>\u001a\n\u0010?\u001a\u00020>*\u000208\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\u001b\u0010C\u001a\u00020D*\u00020A2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F¢\u0006\u0002\u0010G\u001a3\u0010H\u001a\u00020I*\u00020A2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0016\u0008\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020F\u0018\u00010K¢\u0006\u0002\u0010M\u001a\u0012\u0010N\u001a\u00020O*\u00020P2\u0006\u0010Q\u001a\u00020L\u001a\u0012\u0010R\u001a\u00020S*\u00020P2\u0006\u0010Q\u001a\u00020L\u001a\n\u0010T\u001a\u00020B*\u00020A\u001a\n\u0010U\u001a\u00020V*\u00020W\u001a\n\u0010X\u001a\u00020W*\u00020V\u001a\n\u0010Y\u001a\u00020Z*\u00020[\u001a\n\u0010\\\u001a\u00020]*\u00020^\u001a\n\u0010_\u001a\u00020^*\u00020]\u001a\n\u0010`\u001a\u00020a*\u00020b\u001a\n\u0010c\u001a\u00020b*\u00020a¨\u0006d", d2 = {"isActive", "", "Lapp/dogo/android/persistencedb/room/entity/DogoPremiumStatusEntity;", "currentTimeMs", "", "gracePeriod", "isCacheValid", "validLengthInMs", "toArticle", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "isRead", "toArticleEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "toArticleModel", "toArticleTagEntity", "Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "toBreedEntity", "Lapp/dogo/android/persistencedb/room/entity/BreedEntity;", "Lapp/dogo/com/dogo_android/model/BreedModel;", "toBreedModel", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "Lapp/dogo/com/dogo_android/model/CouponModel;", "activationTime", "Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "Lapp/dogo/com/dogo_android/model/survey/SurveyAnswerModel;", "Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "toItem", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "toLessonEntity", "Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "toLessonModel", "toLibraryTag", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "toModel", "toModuleEntity", "Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "toModuleModel", "toProgramEntity", "Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "toProgramModel", "toProgramQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "toProgramTask", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks$Type;", "toQuestionEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "toQuestionModel", "toTaskEntity", "Lapp/dogo/com/dogo_android/model/trainingprogram/TasksModel;", "toTaskModel", "toTrickEntity", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "toTrickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "knowledge", "", "(Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;Ljava/lang/Integer;)Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "toTrickItemWithVariations", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "variationKnowledge", "", "", "(Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;Ljava/lang/Integer;Ljava/util/Map;)Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "toTrickKnowledge", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/progress/TrickAttempt;", "dogId", "toTrickKnowledgeRateData", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "toTrickModel", "toTrickStepEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "toTrickStepModel", "toTrickTagEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "toTrickVariationEntity", "Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVariation;", "toTrickVariationModel", "toTrickVideoStepEntity", "Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "toVideoStepModel", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class m1 {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf((ProgramModel.LessonModel)t.getIndex()), Integer.valueOf((ProgramModel.LessonModel)t2.getIndex()));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf((ProgramModel.ModuleModel)t.getIndex()), Integer.valueOf((ProgramModel.ModuleModel)t2.getIndex()));
        }
    }
    public static final QuestionModel A(f f) {
        n.f(f, "<this>");
        super(f.b().getQuestionId(), f.b().getQuestion(), f.a().a().getText(), f.a().a().getTextHtml(), m1.h(f.a()), f.b().getAnswers(), f.b().getCorrectAnswer(), 0, obj10, f.b().getLocale(), 128, 0);
        return obj14;
    }

    public static final TaskEntity B(TasksModel tasksModel) {
        n.f(tasksModel, "<this>");
        super(tasksModel.getId(), tasksModel.getText(), tasksModel.getLocale(), tasksModel.getUpdatedAt(), obj6, 0, 16, 0);
        return taskEntity;
    }

    public static final TasksModel C(TaskEntity taskEntity) {
        n.f(taskEntity, "<this>");
        super(taskEntity.getTaskId(), taskEntity.getText(), 0, obj5, taskEntity.getLocale(), 4, 0);
        return tasksModel;
    }

    public static final g D(TrickModel trickModel) {
        int i;
        List variations;
        int i2;
        int i4;
        int i3;
        int i5;
        n.f(trickModel, "<this>");
        List trickSteps = trickModel.getTrickSteps();
        int i6 = 10;
        ArrayList arrayList = new ArrayList(p.r(trickSteps, i6));
        Iterator iterator = trickSteps.iterator();
        for (TrickModel.TrickStep next12 : iterator) {
            arrayList.add(next12.getId());
        }
        List videoSteps = trickModel.getVideoSteps();
        ArrayList arrayList6 = new ArrayList(p.r(videoSteps, i6));
        Iterator iterator2 = videoSteps.iterator();
        for (TrickModel.TrickVideoStep next4 : iterator2) {
            arrayList6.add(next4.getId());
        }
        super(trickModel.getId(), trickModel.getName(), trickModel.getImage(), trickModel.getCategory().getName(), trickModel.getCategory().getId(), trickModel.getExamInstructions(), trickModel.getExamTimeLimit(), trickModel.getSortOrder(), trickModel.isExam(), trickModel.getHasProgress(), trickModel.getUpdatedAt(), obj14, trickModel.getVideoId(), trickModel.getVideoThumbnail(), trickModel.getDescription(), trickModel.getLocale(), 0, arrayList, arrayList6, 32768, 0);
        List videoSteps2 = trickModel.getVideoSteps();
        ArrayList arrayList2 = new ArrayList(p.r(videoSteps2, i6));
        Iterator iterator4 = videoSteps2.iterator();
        for (TrickModel.TrickVideoStep next6 : iterator4) {
            arrayList2.add(m1.N(next6));
        }
        List trickSteps2 = trickModel.getTrickSteps();
        ArrayList arrayList3 = new ArrayList(p.r(trickSteps2, i6));
        Iterator iterator5 = trickSteps2.iterator();
        for (TrickModel.TrickStep next8 : iterator5) {
            arrayList3.add(m1.I(next8));
        }
        List tags = trickModel.getTags();
        ArrayList arrayList4 = new ArrayList(p.r(tags, i6));
        Iterator iterator6 = tags.iterator();
        for (TrickModel.TrickTag next10 : iterator6) {
            arrayList4.add(m1.K(next10));
        }
        variations = trickModel.getVariations();
        ArrayList arrayList5 = new ArrayList(p.r(variations, i6));
        Iterator iterator3 = variations.iterator();
        for (TrickModel.TrickVariation next3 : iterator3) {
            arrayList5.add(m1.L(next3));
        }
        super(trickEntity, arrayList2, arrayList3, arrayList4, arrayList5);
        return gVar;
    }

    public static final TrickItem E(g g, Integer integer2) {
        Object videoId;
        String examInstructions;
        int intValue;
        int intValue2;
        int description;
        int libraryTag;
        Object arrayList;
        long long;
        int trickStep;
        int startTime;
        int startTime2;
        int i6;
        TrickItem.VideoStep videoStep;
        String text;
        int i3;
        int i2;
        int i;
        String name;
        String tagId;
        int i4;
        int i5;
        n.f(g, "<this>");
        int i8 = 10;
        if (g.d().getVideoId() != null) {
            List list = g.g();
            arrayList = new ArrayList(p.r(list, i8));
            videoId = list.iterator();
            trickStep = intValue2;
            for (Object next5 : videoId) {
                i6 = trickStep + 1;
                if (trickStep == p.i(g.g())) {
                } else {
                }
                startTime = (VideoStepEntity)g.g().get(i6).getStartTime();
                videoStep = new TrickItem.VideoStep((VideoStepEntity)next5.getText(), next5.getStartTime(), startTime);
                arrayList.add(videoStep);
                trickStep = i6;
                startTime = -1;
            }
        } else {
            arrayList = p.g();
        }
        if (g.d().getExamInstructions() == null && g.d().getDescription() == null) {
            if (g.d().getDescription() == null) {
                examInstructions = "";
            }
        }
        if (integer2 == null) {
        } else {
            intValue2 = integer2.intValue();
        }
        List list2 = g.e();
        ArrayList arrayList3 = new ArrayList(p.r(list2, i8));
        Iterator iterator = list2.iterator();
        for (TrickStepEntity next2 : iterator) {
            trickStep = new TrickItem.TrickStep(next2.getDescription(), next2.getImage());
            arrayList3.add(trickStep);
        }
        String videoId2 = g.d().getVideoId();
        if (videoId2 == null) {
            long = 0;
        } else {
            long = Long.parseLong(videoId2);
        }
        Integer sortOrder = g.d().getSortOrder();
        if (sortOrder == null) {
            intValue = Integer.MAX_VALUE;
        } else {
            intValue = sortOrder.intValue();
        }
        List list3 = g.c();
        ArrayList arrayList2 = new ArrayList(p.r(list3, i8));
        Iterator iterator2 = list3.iterator();
        for (TrickTagEntity next4 : iterator2) {
            super(0, next4.getName(), next4.getTagId(), 1, 0);
            arrayList2.add(libraryTag);
        }
        TrickItem.TrickCategory trickCategory = new TrickItem.TrickCategory(g.d().getCategoryId(), g.d().getCategoryName());
        super(g.d().getTrickId(), g.d().getName(), examInstructions, g.d().getImage(), 0, intValue2, arrayList3, arrayList, long, obj15, g.d().getHasProgress(), intValue, arrayList2, trickCategory, 0, 0, empty ^ 1, 0, 0, 0, 0, 1007616, 0);
        return trickItem;
    }

    public static final TrickItemWithVariations F(g g, Integer integer2, Map<String, Integer> map3) {
        List copy$default;
        int i3;
        int intValue;
        int i10;
        String description;
        int i12;
        int i11;
        ArrayList arrayList;
        int i5;
        int i16;
        int i18;
        int i13;
        int i4;
        int i;
        int i17;
        int i2;
        int i15;
        int i8;
        String variationId;
        List tips;
        String title;
        int i7;
        int i6;
        int i14;
        int i9;
        ArrayList list;
        Object obj = map3;
        n.f(g, "<this>");
        TrickItem trickItem = m1.E(g, integer2);
        copy$default = g.f();
        arrayList = new ArrayList(p.r(copy$default, 10));
        final Iterator iterator = copy$default.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            intValue = 0;
            if (obj != null) {
            }
            i10 = obj.get(next2.getVariationId());
            if ((Integer)i10 == null) {
            } else {
            }
            intValue = (Integer)i10.intValue();
            i3 = list;
            i3.add(TrickItem.copy$default(trickItem, 0, 0, (TrickVariationEntity)next2.getDescription(), 0, false, intValue, 0, 0, 0, obj12, 0, 0, 0, false, 0, false, 0, next2.getVariationId(), next2.getTips(), next2.getTitle(), 0, 557019));
            arrayList = i3;
        }
        TrickItemWithVariations trickItemWithVariations = new TrickItemWithVariations(trickItem, arrayList);
        return trickItemWithVariations;
    }

    public static TrickItemWithVariations G(g g, Integer integer2, Map map3, int i4, Object object5) {
        Integer obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return m1.F(g, obj1, obj2);
    }

    public static final TrickModel H(g g) {
        Object obj;
        int i5;
        int i2;
        int i6;
        int i4;
        boolean next3;
        int trickTag;
        Iterator iterator;
        boolean next;
        boolean z;
        TrickModel.TrickCategory trickCategory;
        String categoryId;
        String categoryName;
        int iterator2;
        String next2;
        String locale;
        int i;
        int i3;
        n.f(g, "<this>");
        List list = g.e();
        int i7 = 10;
        ArrayList arrayList = new ArrayList(p.r(list, i7));
        Iterator iterator3 = list.iterator();
        for (TrickStepEntity next7 : iterator3) {
            arrayList.add(m1.J(next7));
        }
        List list2 = g.g();
        ArrayList arrayList3 = new ArrayList(p.r(list2, i7));
        Iterator iterator4 = list2.iterator();
        for (VideoStepEntity next11 : iterator4) {
            arrayList3.add(m1.O(next11));
        }
        List list3 = g.f();
        ArrayList arrayList6 = new ArrayList(p.r(list3, i7));
        Iterator iterator5 = list3.iterator();
        for (TrickVariationEntity next10 : iterator5) {
            arrayList6.add(m1.M(next10));
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator iterator6 = g.d().getImageStepOrder().iterator();
        for (String next3 : iterator6) {
            iterator = arrayList.iterator();
            for (Object next : iterator) {
            }
            trickTag = 0;
            if ((TrickModel.TrickStep)trickTag != 0) {
            }
            arrayList5.add((TrickModel.TrickStep)trickTag);
            next = iterator.next();
            if (n.b((TrickModel.TrickStep)next.getId(), next3)) {
            } else {
            }
            trickTag = next;
        }
        super(g.d().getCategoryId(), g.d().getCategoryName(), 0, obj20, g.d().getLocale(), 4, 0);
        List list5 = g.c();
        ArrayList arrayList4 = new ArrayList(p.r(list5, i7));
        Iterator iterator7 = list5.iterator();
        for (TrickTagEntity next5 : iterator7) {
            super(next5.getTagId(), next5.getName(), 0, obj20, g.d().getLocale(), 4, 0);
            arrayList4.add(trickTag);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator8 = g.d().getVideoStepOder().iterator();
        for (String trickTag : iterator8) {
            iterator2 = arrayList3.iterator();
            for (Object next2 : iterator2) {
                obj = g;
            }
            next2 = 0;
            String str2 = next2;
            if ((TrickModel.TrickVideoStep)str2 != null) {
            }
            obj = g;
            arrayList2.add((TrickModel.TrickVideoStep)str2);
            if (n.b((TrickModel.TrickVideoStep)iterator2.next().getId(), trickTag)) {
            } else {
            }
            obj = g;
        }
        super(g.d().getTrickId(), g.d().getName(), g.d().getImage(), arrayList5, trickCategory2, g.d().getExamInstructions(), g.d().getExamTimeLimit(), g.d().isExam(), g.d().getSortOrder(), arrayList4, g.d().getHasProgress(), g.d().getVideoId(), g.d().getVideoThumbnail(), arrayList2, g.d().getDescription(), g.d().getUpdatedAt(), i, g.d().getLocale(), arrayList6);
        return trickModel;
    }

    public static final TrickStepEntity I(TrickModel.TrickStep trickModel$TrickStep) {
        n.f(trickStep, "<this>");
        super(trickStep.getId(), trickStep.getDescription(), trickStep.getImage(), trickStep.getLocale(), trickStep.getUpdatedAt(), obj7, 0, 32, 0);
        return obj11;
    }

    public static final TrickModel.TrickStep J(TrickStepEntity trickStepEntity) {
        n.f(trickStepEntity, "<this>");
        super(trickStepEntity.getStepId(), trickStepEntity.getImage(), trickStepEntity.getDescription(), 0, obj6, trickStepEntity.getLocale(), 8, 0);
        return obj10;
    }

    public static final TrickTagEntity K(TrickModel.TrickTag trickModel$TrickTag) {
        n.f(trickTag, "<this>");
        super(trickTag.getId(), trickTag.getLocale(), trickTag.getName(), trickTag.getUpdatedAt(), obj6, 0, 16, 0);
        return obj10;
    }

    public static final TrickVariationEntity L(TrickModel.TrickVariation trickModel$TrickVariation) {
        n.f(trickVariation, "<this>");
        super(trickVariation.getTips(), trickVariation.getId(), trickVariation.getTitle(), trickVariation.getDescription(), trickVariation.getLocale(), trickVariation.getContentfulId(), trickVariation.getUpdatedAt(), obj9, 0, 128, 0);
        return trickVariationEntity;
    }

    public static final TrickModel.TrickVariation M(TrickVariationEntity trickVariationEntity) {
        n.f(trickVariationEntity, "<this>");
        super(trickVariationEntity.getTips(), trickVariationEntity.getVariationId(), trickVariationEntity.getTitle(), trickVariationEntity.getDescription(), trickVariationEntity.getLocale(), trickVariationEntity.getContentfulId(), trickVariationEntity.getUpdatedAt(), obj9);
        return trickVariation;
    }

    public static final VideoStepEntity N(TrickModel.TrickVideoStep trickModel$TrickVideoStep) {
        n.f(trickVideoStep, "<this>");
        super(trickVideoStep.getId(), trickVideoStep.getText(), trickVideoStep.getLocale(), trickVideoStep.getStartTime(), trickVideoStep.getUpdatedAt(), obj7, 0, 32, 0);
        return videoStepEntity;
    }

    public static final TrickModel.TrickVideoStep O(VideoStepEntity videoStepEntity) {
        n.f(videoStepEntity, "<this>");
        super(videoStepEntity.getStepId(), videoStepEntity.getText(), videoStepEntity.getStartTime(), 0, obj6, videoStepEntity.getLocale(), 8, 0);
        return trickVideoStep;
    }

    public static final boolean a(DogoPremiumStatusEntity dogoPremiumStatusEntity, long l2, long l3) {
        int cmp;
        int obj2;
        n.f(dogoPremiumStatusEntity, "<this>");
        if (Long.compare(l2, expirationTimeMs) >= 0) {
            if (Long.compare(l2, cmp) < 0) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public static boolean b(DogoPremiumStatusEntity dogoPremiumStatusEntity, long l2, long l3, int i4, Object object5) {
        int obj3;
        if (obj5 &= 2 != 0) {
            obj3 = 1800000;
        }
        return m1.a(dogoPremiumStatusEntity, l2, l3);
    }

    public static final boolean c(DogoPremiumStatusEntity dogoPremiumStatusEntity, long l2, long l3, long l4) {
        int cmp;
        int i;
        long expirationTimeMs;
        int obj6;
        int obj7;
        int obj9;
        n.f(dogoPremiumStatusEntity, "<this>");
        int i2 = 0;
        i = 0;
        if (Long.compare(updatedAt, i2) == 0 && Long.compare(expirationTimeMs, i2) == 0) {
            if (Long.compare(expirationTimeMs, i2) == 0) {
                return i;
            }
        }
        final int obj10 = 1;
        obj9 = Long.compare(i3, l2) > 0 ? obj10 : i;
        obj7 = Long.compare(i4, l2) > 0 ? obj10 : i;
        obj6 = Long.compare(updatedAt3, i5) > 0 ? obj10 : i;
        if (obj9 != null) {
            if (obj7 == null) {
                if (obj6 != null) {
                    i = obj10;
                }
            } else {
            }
        }
        return i;
    }

    public static boolean d(DogoPremiumStatusEntity dogoPremiumStatusEntity, long l2, long l3, long l4, int i5, Object object6) {
        int obj12;
        if (obj14 &= 4 != 0) {
            obj12 = 1800000;
        }
        return m1.c(dogoPremiumStatusEntity, l2, obj2, l4);
    }

    public static final Article e(a a, boolean z2) {
        String image;
        int i;
        n.f(a, "<this>");
        List list = a.b();
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (ArticleTagEntity next2 : iterator) {
            arrayList.add(m1.r(next2));
        }
        if (a.a().getImage() == null) {
            image = "";
        }
        super(a.a().getTitle(), a.a().getArticleId(), a.a().getText(), arrayList, a.a().getReadingTime(), image, 0, a.a().getCategoryId(), a.a().getSortOrder(), z2, 0, a.a().getTextHtml(), 1024, 0);
        return article;
    }

    public static Article f(a a, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return m1.e(a, obj1);
    }

    public static final a g(ArticleModel articleModel) {
        int i;
        n.f(articleModel, "<this>");
        super(articleModel.getId(), articleModel.getTitle(), articleModel.getText(), articleModel.getReadingTime(), articleModel.getSortOrder(), articleModel.getCategory(), articleModel.getImage(), articleModel.getLocale(), articleModel.getUpdatedAt(), obj12, 0, articleModel.getTextHtml(), 512, 0);
        List tags = articleModel.getTags();
        ArrayList arrayList = new ArrayList(p.r(tags, 10));
        Iterator iterator = tags.iterator();
        for (ArticleModel.ArticleTag next2 : iterator) {
            arrayList.add(m1.i(next2));
        }
        a aVar = new a(articleEntity, arrayList);
        return aVar;
    }

    public static final ArticleModel h(a a) {
        String image;
        int articleTag;
        int i2;
        String tagId;
        String locale;
        int i4;
        String name;
        boolean hidden;
        int i;
        int i3;
        n.f(a, "<this>");
        List list = a.b();
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (ArticleTagEntity next2 : iterator) {
            super(next2.getTagId(), next2.getLocale(), 0, obj17, next2.getName(), next2.getHidden(), 4, 0);
            arrayList.add(articleTag);
        }
        if (a.a().getImage() == null) {
            image = "";
        }
        super(a.a().getArticleId(), 0, 0, obj5, a.a().getTitle(), a.a().getText(), a.a().getReadingTime(), 0, a.a().getCategoryId(), image, arrayList, a.a().getTextHtml(), 70, 0);
        return articleModel;
    }

    public static final ArticleTagEntity i(ArticleModel.ArticleTag articleModel$ArticleTag) {
        n.f(articleTag, "<this>");
        super(articleTag.getHidden(), articleTag.getId(), articleTag.getLocale(), articleTag.getName(), articleTag.getUpdatedAt(), obj7, 0, 32, 0);
        return obj11;
    }

    public static final BreedEntity j(BreedModel breedModel) {
        n.f(breedModel, "<this>");
        super(breedModel.getId(), breedModel.getTitle(), breedModel.getLocale(), breedModel.getUpdatedAt(), obj6, 0, 16, 0);
        return breedEntity;
    }

    public static final CouponEntity k(CouponModel couponModel, long l2) {
        CouponEntity couponEntity;
        Long offerDurationMs;
        long longValue2;
        CouponEntity couponEntity2;
        int longValue;
        String offeringId;
        long l;
        Map map3;
        String str;
        Map map;
        Map map2;
        int i;
        couponEntity2 = couponModel;
        n.f(couponModel, "<this>");
        final String couponId = couponModel.getCouponId();
        if (couponId != null && couponModel.getOfferingId() != null) {
            if (couponModel.getOfferingId() != null) {
                offerDurationMs = couponModel.getOfferDurationMs();
                if (offerDurationMs == null) {
                    Long discount = couponModel.getDiscount();
                    if (discount == null) {
                    } else {
                        longValue = discount.longValue();
                    }
                    Long offerDurationMs2 = couponModel.getOfferDurationMs();
                    if (offerDurationMs2 == null) {
                        longValue2 = TimeUnit.HOURS.toMillis(24);
                    } else {
                        longValue2 = offerDurationMs2.longValue();
                    }
                    super(couponId, longValue, obj4, couponModel.getOfferingId(), longValue2, obj7, l2, obj9, "", j0.h(), j0.h(), 0);
                } else {
                    if (Long.compare(offeringId, longValue) == 0) {
                        couponEntity = 0;
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return couponEntity;
    }

    public static final OnboardingAnswerEntity l(SurveyAnswerModel surveyAnswerModel) {
        n.f(surveyAnswerModel, "<this>");
        super(surveyAnswerModel.getId(), surveyAnswerModel.getText(), surveyAnswerModel.getUpdatedAt(), obj5, surveyAnswerModel.getLocale(), 0, 16, 0);
        return obj10;
    }

    public static final TrickCategoryEntity m(TrickModel.TrickCategory trickModel$TrickCategory) {
        n.f(trickCategory, "<this>");
        super(trickCategory.getId(), trickCategory.getLocale(), trickCategory.getName(), trickCategory.getUpdatedAt(), obj6, 0, 16, 0);
        return trickCategoryEntity;
    }

    public static final d n(SurveyQuestionModel surveyQuestionModel) {
        int i;
        int i2;
        n.f(surveyQuestionModel, "<this>");
        List answers = surveyQuestionModel.getAnswers();
        final int i6 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(answers, i6));
        Iterator iterator = answers.iterator();
        for (SurveyAnswerModel next2 : iterator) {
            arrayList2.add(next2.getId());
        }
        super(surveyQuestionModel.getId(), surveyQuestionModel.getText(), surveyQuestionModel.getUpdatedAt(), obj5, surveyQuestionModel.getLocale(), arrayList2, 0, 32, 0);
        List obj12 = surveyQuestionModel.getAnswers();
        ArrayList arrayList = new ArrayList(p.r(obj12, i6));
        obj12 = obj12.iterator();
        for (SurveyAnswerModel next4 : obj12) {
            arrayList.add(m1.l(next4));
        }
        obj12 = new d(onboardingQuestionEntity, arrayList);
        return obj12;
    }

    public static final CouponDiscount o(CouponEntity couponEntity) {
        Long valueOf2;
        long l;
        CouponDiscount couponDiscount;
        Map offerText;
        String valueOf;
        String offeringId;
        Long num;
        Long valueOf3;
        int i;
        Map map;
        Map map2;
        String style;
        int i2;
        int i3;
        CouponDiscount obj13;
        n.f(couponEntity, "<this>");
        if (couponEntity.isEmpty()) {
            super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
        } else {
            if (couponEntity.getOfferText() == null) {
                offerText = j0.h();
            }
            if (couponEntity.getDiscountText() == null) {
                obj13 = j0.h();
            }
            super(String.valueOf(couponEntity.getDiscount()), couponEntity.getOfferingId(), Long.valueOf(couponEntity.getActivationTimeMs()), Long.valueOf(activationTimeMs2 += offerDurationMs), 0, offerText, obj13, couponEntity.getStyle(), 16, 0);
        }
        return obj13;
    }

    public static final b p(ProgramModel.LessonModel programModel$LessonModel) {
        int i;
        int i2;
        n.f(lessonModel, "<this>");
        super(lessonModel.getId(), lessonModel.getIndex(), lessonModel.getLocale(), lessonModel.getProgramId(), lessonModel.getUpdatedAt(), obj7, 0, 32, 0);
        Collection values = lessonModel.getTasks().values();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(values, i3));
        Iterator iterator = values.iterator();
        for (TasksModel next4 : iterator) {
            arrayList.add(m1.B(next4));
        }
        Collection values2 = lessonModel.getTricks().values();
        ArrayList arrayList2 = new ArrayList(p.r(values2, i3));
        Iterator iterator2 = values2.iterator();
        for (TrickModel next2 : iterator2) {
            arrayList2.add(m1.D(next2));
        }
        b bVar = new b(lessonEntity, arrayList, m1.z(lessonModel.getQuestion()), arrayList2);
        return bVar;
    }

    public static final ProgramModel.LessonModel q(b b) {
        int i2;
        int i;
        o oVar;
        String trickId;
        n.f(b, "<this>");
        List list = b.c();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(list, i3));
        Iterator iterator = list.iterator();
        for (TaskEntity next4 : iterator) {
            oVar = new o(next4.getTaskId(), m1.C(next4));
            arrayList.add(oVar);
        }
        List list2 = b.d();
        ArrayList arrayList2 = new ArrayList(p.r(list2, i3));
        Iterator iterator2 = list2.iterator();
        for (g next2 : iterator2) {
            oVar = new o(next2.d().getTrickId(), m1.H(next2));
            arrayList2.add(oVar);
        }
        super(b.a().getLessonId(), m1.A(b.b()), j0.s(arrayList2), j0.s(arrayList), b.a().getIndex(), 0, b.a().getProgramId(), b.a().getUpdatedAt(), obj10, b.a().getLocale(), 32, 0);
        return obj14;
    }

    public static final LibraryTag r(ArticleTagEntity articleTagEntity) {
        n.f(articleTagEntity, "<this>");
        LibraryTag libraryTag = new LibraryTag(articleTagEntity.getHidden(), articleTagEntity.getName(), articleTagEntity.getTagId());
        return libraryTag;
    }

    public static final SurveyAnswerModel s(OnboardingAnswerEntity onboardingAnswerEntity) {
        n.f(onboardingAnswerEntity, "<this>");
        super(onboardingAnswerEntity.getAnswerId(), onboardingAnswerEntity.getLocale(), onboardingAnswerEntity.getText(), onboardingAnswerEntity.getUpdatedAt(), obj6);
        return obj7;
    }

    public static final SurveyQuestionModel t(d d) {
        OnboardingQuestionEntity next2;
        int i;
        boolean iterator;
        Object next;
        boolean z;
        n.f(d, "<this>");
        List list = d.a();
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator2 = list.iterator();
        for (OnboardingAnswerEntity next4 : iterator2) {
            arrayList.add(m1.s(next4));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator obj11 = d.b().getChildOrderList().iterator();
        for (String next2 : obj11) {
            iterator = arrayList.iterator();
            for (Object next : iterator) {
            }
            next = 0;
            if ((SurveyAnswerModel)next != null) {
            }
            arrayList2.add((SurveyAnswerModel)next);
            if (n.b(next2, (SurveyAnswerModel)iterator.next().getId())) {
            } else {
            }
        }
        super(arrayList2, d.b().getQuestionId(), d.b().getLocale(), d.b().getText(), d.b().getUpdatedAt(), obj8);
        return obj11;
    }

    public static final TrickModel.TrickCategory u(TrickCategoryEntity trickCategoryEntity) {
        n.f(trickCategoryEntity, "<this>");
        super(trickCategoryEntity.getCategoryId(), trickCategoryEntity.getName(), trickCategoryEntity.getUpdatedAt(), obj5, trickCategoryEntity.getLocale());
        return obj7;
    }

    public static final c v(ProgramModel.ModuleModel programModel$ModuleModel) {
        int i;
        int i2;
        n.f(moduleModel, "<this>");
        super(moduleModel.getId(), moduleModel.getIndex(), moduleModel.getName(), moduleModel.getLocale(), moduleModel.getUpdatedAt(), obj7, 0, 32, 0);
        List lessons = moduleModel.getLessons();
        int i3 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(lessons, i3));
        Iterator iterator = lessons.iterator();
        for (ProgramModel.LessonModel next4 : iterator) {
            arrayList2.add(m1.p(next4));
        }
        List obj11 = moduleModel.getExams();
        ArrayList arrayList = new ArrayList(p.r(obj11, i3));
        obj11 = obj11.iterator();
        for (TrickModel next2 : obj11) {
            arrayList.add(m1.D(next2));
        }
        obj11 = new c(moduleEntity, arrayList2, arrayList);
        return obj11;
    }

    public static final ProgramModel.ModuleModel w(c c) {
        int i2;
        int i;
        n.f(c, "<this>");
        List list = c.b();
        int i3 = 10;
        ArrayList arrayList = new ArrayList(p.r(list, i3));
        Iterator iterator = list.iterator();
        for (b next4 : iterator) {
            arrayList.add(m1.q(next4));
        }
        m1.a aVar = new m1.a();
        List list3 = c.a();
        ArrayList arrayList2 = new ArrayList(p.r(list3, i3));
        Iterator iterator2 = list3.iterator();
        for (g next2 : iterator2) {
            arrayList2.add(m1.H(next2));
        }
        super(c.c().getModuleId(), c.c().getIndex(), c.c().getName(), p.D0(arrayList, aVar), arrayList2, c.c().getUpdatedAt(), obj8, c.c().getLocale());
        return obj10;
    }

    public static final e x(ProgramModel programModel) {
        int i;
        n.f(programModel, "<this>");
        super(programModel.getType(), programModel.getId(), programModel.getName(), programModel.getImage(), programModel.getCenteredImage(), programModel.getDescription(), programModel.getCardBackgroundColor(), programModel.getCertificateLaurelsImage(), programModel.getCertificatePaperImage(), programModel.getCertificatePlaceholderImage(), programModel.getCertificateRequirements(), programModel.getLocale(), programModel.getUpdatedAt(), obj16, 0, programModel.getProgramOverviewImage(), programModel.getDogSkillsHighlights(), programModel.getDogSkillsOverview(), programModel.getUserSkillsOverview(), programModel.getAverageCompletionTimeWeeks(), programModel.getNumberOfEnrolledUsers(), programModel.getCertificatePreviewImage(), 8192, 0);
        List modules = programModel.getModules();
        ArrayList arrayList = new ArrayList(p.r(modules, 10));
        Iterator iterator = modules.iterator();
        for (ProgramModel.ModuleModel next2 : iterator) {
            arrayList.add(m1.v(next2));
        }
        e eVar = new e(programEntity, arrayList);
        return eVar;
    }

    public static final ProgramModel y(e e) {
        int i;
        n.f(e, "<this>");
        List list = e.a();
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (c next2 : iterator) {
            arrayList.add(m1.w(next2));
        }
        m1.b bVar = new m1.b();
        super(e.b().getProgramId(), e.b().getName(), p.D0(arrayList, bVar), e.b().getImage(), e.b().getCenteredImage(), e.b().getDescription(), e.b().getCardBackgroundColor(), e.b().getCertificateLaurelsImage(), e.b().getCertificatePaperImage(), e.b().getCertificatePlaceholderUrl(), e.b().getCertificateRequirements(), e.b().getUpdatedAt(), obj15, e.b().getLocale(), e.b().getType(), e.b().getProgramOverviewImage(), e.b().getDogSkillsHighlights(), e.b().getDogSkillsOverview(), e.b().getUserSkillsOverview(), e.b().getAverageCompletionTimeWeeks(), e.b().getNumberOfEnrolledUsers(), e.b().getCertificatePreviewImage());
        return programModel;
    }

    public static final f z(QuestionModel questionModel) {
        n.f(questionModel, "<this>");
        super(questionModel.getId(), questionModel.getLocale(), questionModel.getQuestion(), questionModel.getAnswers(), questionModel.getCorrectAnswer(), questionModel.getUpdatedAt(), obj8, 0, 64, 0);
        f fVar = new f(questionEntity, m1.g(questionModel.getArticle()));
        return fVar;
    }
}
