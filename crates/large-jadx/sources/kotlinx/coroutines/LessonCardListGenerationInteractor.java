package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.b;
import i.b.a0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* compiled from: LessonCardListGenerationInteractor.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000c\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/Utilities;)V", "addLessonList", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "lessonItem", "buildHeaderCard", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "buildQuestionCard", "buildTaskCard", "buildTrainingCard", "calculateTrainingTime", "", "trickCount", "generateLessonCardList", "", "isTrainingAvailable", "", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "isTrainingFinished", "isTrainingInProgress", "isTrainingStarted", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e3, reason: from kotlin metadata */
public final class LessonCardListGenerationInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final v2 utilities;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramLessonItem_ProgramLessonStatus.values().length];
            iArr[ProgramLessonItem_ProgramLessonStatus.NOT_STARTED.ordinal()] = 1;
            iArr[ProgramLessonItem_ProgramLessonStatus.STARTED.ordinal()] = 2;
            iArr[ProgramLessonItem_ProgramLessonStatus.PASSED.ordinal()] = 3;
            iArr[ProgramLessonItem_ProgramLessonStatus.MASTERED.ordinal()] = 4;
            kotlinx.coroutines.e3.a.a = iArr;
        }
    }
    public e3(v2 v2Var) {
        n.f(v2Var, "utilities");
        super();
        this.utilities = v2Var;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final LessonCardItem addLessonList(ProgramLessonItem lessonItem) throws NoWhenBranchMatchedException {
        LessonCardItem.CardStatus iN_PROGRESS2;
        int i2 = kotlinx.coroutines.e3.a.a[lessonItem.getLessonStatus().ordinal()];
        int i = 1;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    i = 4;
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        iN_PROGRESS2 = LessonCardItem_CardStatus.COMPLETED;
                    }
                }
                iN_PROGRESS2 = LessonCardItem_CardStatus.COMPLETED;
            } else {
                iN_PROGRESS2 = LessonCardItem_CardStatus.IN_PROGRESS;
            }
        } else {
            iN_PROGRESS2 = LessonCardItem_CardStatus.NOT_STARTED;
        }
        LessonCardItem lessonItem2 = new LessonCardItem(iN_PROGRESS2, lessonItem.getProgramName(), null, "", lessonItem.getCurrentLessonPositionData().getLessonNumber(), lessonItem.getCurrentLessonPositionData().getModuleNumber(), LessonCardItem_CardType.HEADER, 4, null);
        return lessonItem2;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final LessonCardItem buildHeaderCard(ProgramLessonItem lessonItem) {
        LessonCardItem.CardStatus nOT_STARTED2;
        LessonCardItem.CardStatus r0 = lessonItem.getQuestion().getType() == ProgramQuestion_Type.NOT_ANSWERED ? LessonCardItem_CardStatus.NOT_STARTED : LessonCardItem_CardStatus.COMPLETED;
        LessonCardItem lessonItem2 = new LessonCardItem((lessonItem.getQuestion().getType() == ProgramQuestion_Type.NOT_ANSWERED ? LessonCardItem_CardStatus.NOT_STARTED : LessonCardItem_CardStatus.COMPLETED), lessonItem.getProgramName(), null, lessonItem.getQuestion().getQuestion(), (lessonItem.getQuestion().getType() == ProgramQuestion_Type.NOT_ANSWERED ? LessonCardItem_CardStatus.NOT_STARTED : LessonCardItem_CardStatus.COMPLETED).getLessonNumber(), (lessonItem.getQuestion().getType() == ProgramQuestion_Type.NOT_ANSWERED ? LessonCardItem_CardStatus.NOT_STARTED : LessonCardItem_CardStatus.COMPLETED).getModuleNumber(), LessonCardItem_CardType.QUESTION, 4, null);
        return lessonItem2;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final LessonCardItem buildQuestionCard(ProgramLessonItem lessonItem) {
        int i;
        LessonCardItem.CardStatus cOMPLETED2;
        List tasks;
        boolean hasNext;
        ProgramTasks.Type cOMPLETED22;
        String lessonItem2;
        Object obj;
        List tasks2 = lessonItem.getTasks();
        hasNext = tasks2 instanceof Collection;
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            cOMPLETED2 = LessonCardItem_CardStatus.COMPLETED;
        } else {
            tasks = lessonItem.getTasks();
            hasNext = tasks instanceof Collection;
            int r2 = i;
            r0 = i != 0 ? LessonCardItem_CardStatus.IN_PROGRESS : LessonCardItem_CardStatus.NOT_STARTED;
        }
        obj = p.a0(lessonItem.getTasks(), i);
        String r8 = obj == null ? "" : lessonItem2;
        LessonCardItem lessonItem3 = new LessonCardItem((i != 0 ? LessonCardItem_CardStatus.IN_PROGRESS : LessonCardItem_CardStatus.NOT_STARTED), lessonItem.getProgramName(), null, (obj == null ? "" : lessonItem2), lessonItem.getCurrentLessonPositionData().getLessonNumber(), lessonItem.getCurrentLessonPositionData().getModuleNumber(), LessonCardItem_CardType.TASK, 4, null);
        return lessonItem3;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final LessonCardItem buildTaskCard(ProgramLessonItem lessonItem) {
        String imageUrl;
        LessonCardItem.CardStatus iN_PROGRESS2;
        if (!lessonItem.getTrainingSession().getTrainingTricksList().isEmpty()) {
            int i = 0;
            imageUrl = (TrickItem)lessonItem.getTrainingSession().getTrainingTricksList().get(i).getImageUrl();
        } else {
            imageUrl = "";
        }
        if (generateLessonCardList(lessonItem.getTrainingSession())) {
            iN_PROGRESS2 = LessonCardItem_CardStatus.COMPLETED;
        } else {
            LessonCardItem.CardStatus r1 = isTrainingAvailable(lessonItem.getTrainingSession()) ? LessonCardItem_CardStatus.IN_PROGRESS : LessonCardItem_CardStatus.NOT_STARTED;
        }
        ProgramLessonItem.LessonPositionData currentLessonPositionData2 = lessonItem.getCurrentLessonPositionData();
        LessonCardItem lessonItem2 = new LessonCardItem((isTrainingAvailable(lessonItem.getTrainingSession()) ? LessonCardItem_CardStatus.IN_PROGRESS : LessonCardItem_CardStatus.NOT_STARTED), lessonItem.getProgramName(), imageUrl, this.utilities.u((long)buildTrainingCard(lessonItem.getTrainingSession().getTrainingTricksList().size()) * Utilities_TimeUnit.MINUTES.getThreshold()), lessonItem.getCurrentLessonPositionData().getLessonNumber(), currentLessonPositionData2.getModuleNumber(), LessonCardItem_CardType.TRAINING);
        return lessonItem2;
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final boolean calculateTrainingTime(TrainingSession trickCount) {
        return !trickCount.getTrainingTricksList().isEmpty();
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final boolean generateLessonCardList(TrainingSession lessonItem) {
        boolean hasNext;
        boolean z = false;
        boolean newContent;
        Iterator it;
        List trainingTricksList = lessonItem.getTrainingTricksList();
        hasNext = trainingTricksList instanceof Collection;
        final int i2 = 1;
        int r1 = i2;
        return i2;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final boolean isTrainingAvailable(TrainingSession trainingSession) {
        boolean z = false;
        trainingSession = isTrainingFinished(trainingSession) && !this.generateLessonCardList(trainingSession) ? 1 : 0;
        return (isTrainingFinished(trainingSession) && !this.generateLessonCardList(trainingSession) ? 1 : 0);
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final boolean isTrainingFinished(TrainingSession trainingSession) {
        boolean hasNext;
        boolean z = true;
        boolean newContent;
        Iterator it;
        List trainingTricksList = trainingSession.getTrainingTricksList();
        hasNext = trainingTricksList instanceof Collection;
        final int i2 = 0;
        int r1 = i2;
        return i2;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<ProgramLessonItem> isTrainingInProgress(ProgramLessonItem trainingSession) {
        ProgramLessonItem trainingSession2 = trainingSession;
        n.f(trainingSession2, "lessonItem");
        a0 just = a0.just(ProgramLessonItem.copy$default(trainingSession2, null, null, null, null, null, ProgramLessonItem$ProgramLessonStatus.NOT_STARTED, null, null, null, isTrainingStarted(trainingSession), false, false, 3583, null));
        n.e(just, "just(lessonItem.copy(cardList = generateLessonCardList(lessonItem)))");
        return just;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final List<LessonCardItem> isTrainingStarted(ProgramLessonItem trainingSession) {
        n.f(trainingSession, "lessonItem");
        final LessonCardItem headerCard = buildHeaderCard(trainingSession);
        final LessonCardItem questionCard = buildQuestionCard(trainingSession);
        final int i = 1;
        LessonCardItem[] arr = new LessonCardItem[i];
        arr[0] = addLessonList(trainingSession);
        List list = p.m(arr);
        if (l.z(headerCard.getDescription()) ^ i != 0) {
            list.add(headerCard);
        }
        if (calculateTrainingTime(trainingSession.getTrainingSession())) {
            list.add(buildTaskCard(trainingSession));
        }
        if (l.z(questionCard.getDescription()) ^ i != 0) {
            list.add(questionCard);
        }
        return list;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final int buildTrainingCard(int lessonItem) {
        int i2 = 5;
        int i = 2;
        if (lessonItem <= 2) {
            i2 = 5;
        } else {
            i = 4;
            lessonItem = lessonItem <= 4 ? 10 : 15;
        }
        return (lessonItem <= 4 ? 10 : 15);
    }
}
