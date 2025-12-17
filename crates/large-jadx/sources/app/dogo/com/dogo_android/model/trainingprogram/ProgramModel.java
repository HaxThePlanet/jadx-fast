package app.dogo.com.dogo_android.model.trainingprogram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0002UVBï\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u0002070\u0006J\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u0002070\u0006J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010B\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0019HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0019HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000f\u0010G\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003Jó\u0001\u0010N\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010O\u001a\u00020P2\u0008\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0019HÖ\u0001J\u0006\u0010S\u001a\u00020PJ\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010 R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010 R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010 R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010 R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010 R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010)R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010 R\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010 R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010)¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "", "id", "", "name", "modules", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "image", "centeredImage", "description", "cardBackgroundColor", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderImage", "certificateRequirements", "updatedAt", "", "locale", "type", "programOverviewImage", "dogSkillsHighlights", "dogSkillsOverview", "userSkillsOverview", "averageCompletionTimeWeeks", "", "numberOfEnrolledUsers", "certificatePreviewImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/lang/String;)V", "getAverageCompletionTimeWeeks", "()I", "getCardBackgroundColor", "()Ljava/lang/String;", "getCenteredImage", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderImage", "getCertificatePreviewImage", "getCertificateRequirements", "getDescription", "getDogSkillsHighlights", "()Ljava/util/List;", "getDogSkillsOverview", "getId", "getImage", "getLocale", "getModules", "getName", "getNumberOfEnrolledUsers", "getProgramOverviewImage", "getType", "getUpdatedAt", "()J", "getUserSkillsOverview", "allExamModels", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "allTrickModels", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "isClassicProgram", "toString", "LessonModel", "ModuleModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramModel {

    private final int averageCompletionTimeWeeks;
    private final String cardBackgroundColor;
    private final String centeredImage;
    private final String certificateLaurelsImage;
    private final String certificatePaperImage;
    private final String certificatePlaceholderImage;
    private final String certificatePreviewImage;
    private final String certificateRequirements;
    private final String description;
    private final List<String> dogSkillsHighlights;
    private final List<String> dogSkillsOverview;
    private final String id;
    private final String image;
    private final String locale;
    private final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel> modules;
    private final String name;
    private final int numberOfEnrolledUsers;
    private final String programOverviewImage;
    private final String type;
    private final long updatedAt;
    private final List<String> userSkillsOverview;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001Bw\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0014\u0008\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u000cHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J{\u0010*\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u00072\u0014\u0008\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00072\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u000cHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 ¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "", "id", "", "question", "Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "tricks", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "tasks", "Lapp/dogo/com/dogo_android/model/trainingprogram/TasksModel;", "index", "", "moduleId", "programId", "updatedAt", "", "locale", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;Ljava/util/Map;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getLocale", "getModuleId", "getProgramId", "getQuestion", "()Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "getTasks", "()Ljava/util/Map;", "getTricks", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LessonModel {

        private final String id;
        private final int index;
        private final String locale;
        private final String moduleId;
        private final String programId;
        private final app.dogo.com.dogo_android.model.trainingprogram.QuestionModel question;
        private final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TasksModel> tasks;
        private final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TrickModel> tricks;
        private final long updatedAt;
        public LessonModel() {
            super(0, 0, 0, 0, 0, 0, 0, 0, obj9, 0, 511, 0);
        }

        public LessonModel(String string, app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel2, Map<String, app.dogo.com.dogo_android.model.trainingprogram.TrickModel> map3, Map<String, app.dogo.com.dogo_android.model.trainingprogram.TasksModel> map4, int i5, String string6, String string7, long l8, String string9) {
            n.f(string, "id");
            n.f(questionModel2, "question");
            n.f(map3, "tricks");
            n.f(map4, "tasks");
            n.f(string6, "moduleId");
            n.f(string7, "programId");
            n.f(obj11, "locale");
            super();
            this.id = string;
            this.question = questionModel2;
            this.tricks = map3;
            this.tasks = map4;
            this.index = i5;
            this.moduleId = string6;
            this.programId = string7;
            this.updatedAt = l8;
            this.locale = obj11;
        }

        public LessonModel(String string, app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel2, Map map3, Map map4, int i5, String string6, String string7, long l8, String string9, int i10, g g11) {
            String str3;
            String str;
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel3;
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel;
            Map map;
            int i6;
            Map map2;
            int i;
            int i9;
            int i12;
            String str2;
            int i11;
            String str4;
            int i8;
            int i3;
            int i14;
            int i2;
            int i15;
            int i4;
            int i13;
            int i7;
            int i16 = g11;
            str = "";
            str3 = i16 & 1 != 0 ? str : string;
            if (i16 & 2 != 0) {
                super(0, 0, 0, 0, 0, 0, 0, 0, obj13, 0, 511, 0);
            } else {
                questionModel3 = questionModel2;
            }
            if (i16 & 4 != 0) {
                map = j0.h();
            } else {
                map = map3;
            }
            if (i16 & 8 != 0) {
                map2 = j0.h();
            } else {
                map2 = map4;
            }
            i9 = i16 & 16 != 0 ? 0 : i5;
            str2 = i16 & 32 != 0 ? str : string6;
            str4 = i16 & 64 != 0 ? str : string7;
            i3 = i16 & 128 != 0 ? 0 : l8;
            if (i16 &= 256 != 0) {
            } else {
                str = i10;
            }
            super(str3, questionModel3, map, map2, i9, str2, str4, i3, i10, str);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel programModel$LessonModel, String string2, app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel3, Map map4, Map map5, int i6, String string7, String string8, long l9, String string10, int i11, Object object12) {
            String locale;
            String str;
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel question;
            Map tricks;
            Map tasks;
            int index;
            String moduleId;
            String programId;
            long updatedAt;
            Object obj = lessonModel;
            int i = object12;
            str = i & 1 != 0 ? obj.id : string2;
            question = i & 2 != 0 ? obj.question : questionModel3;
            tricks = i & 4 != 0 ? obj.tricks : map4;
            tasks = i & 8 != 0 ? obj.tasks : map5;
            index = i & 16 != 0 ? obj.index : i6;
            moduleId = i & 32 != 0 ? obj.moduleId : string7;
            programId = i & 64 != 0 ? obj.programId : string8;
            updatedAt = i & 128 != 0 ? obj.updatedAt : l9;
            locale = i &= 256 != 0 ? obj.locale : i11;
            return lessonModel.copy(str, question, tricks, tasks, index, moduleId, programId, updatedAt, string10);
        }

        public final String component1() {
            return this.id;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.QuestionModel component2() {
            return this.question;
        }

        public final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TrickModel> component3() {
            return this.tricks;
        }

        public final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TasksModel> component4() {
            return this.tasks;
        }

        public final int component5() {
            return this.index;
        }

        public final String component6() {
            return this.moduleId;
        }

        public final String component7() {
            return this.programId;
        }

        public final long component8() {
            return this.updatedAt;
        }

        public final String component9() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel copy(String string, app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel2, Map<String, app.dogo.com.dogo_android.model.trainingprogram.TrickModel> map3, Map<String, app.dogo.com.dogo_android.model.trainingprogram.TasksModel> map4, int i5, String string6, String string7, long l8, String string9) {
            n.f(string, "id");
            n.f(questionModel2, "question");
            n.f(map3, "tricks");
            final Object obj = map4;
            n.f(obj, "tasks");
            final Object obj2 = string6;
            n.f(obj2, "moduleId");
            final Object obj3 = string7;
            n.f(obj3, "programId");
            final Object obj4 = obj22;
            n.f(obj4, "locale");
            super(string, questionModel2, map3, obj, i5, obj2, obj3, l8, obj10, obj4);
            return lessonModel;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof ProgramModel.LessonModel) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.question, object.question)) {
                return i2;
            }
            if (!n.b(this.tricks, object.tricks)) {
                return i2;
            }
            if (!n.b(this.tasks, object.tasks)) {
                return i2;
            }
            if (this.index != object.index) {
                return i2;
            }
            if (!n.b(this.moduleId, object.moduleId)) {
                return i2;
            }
            if (!n.b(this.programId, object.programId)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final String getModuleId() {
            return this.moduleId;
        }

        public final String getProgramId() {
            return this.programId;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.QuestionModel getQuestion() {
            return this.question;
        }

        public final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TasksModel> getTasks() {
            return this.tasks;
        }

        public final Map<String, app.dogo.com.dogo_android.model.trainingprogram.TrickModel> getTricks() {
            return this.tricks;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            return i16 += i25;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LessonModel(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", question=");
            stringBuilder.append(this.question);
            stringBuilder.append(", tricks=");
            stringBuilder.append(this.tricks);
            stringBuilder.append(", tasks=");
            stringBuilder.append(this.tasks);
            stringBuilder.append(", index=");
            stringBuilder.append(this.index);
            stringBuilder.append(", moduleId=");
            stringBuilder.append(this.moduleId);
            stringBuilder.append(", programId=");
            stringBuilder.append(this.programId);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001BW\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J[\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "", "id", "", "index", "", "name", "lessons", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "exams", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "updatedAt", "", "locale", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/lang/String;)V", "getExams", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getLessons", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleModel {

        private final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> exams;
        private final String id;
        private final int index;
        private final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel> lessons;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public ModuleModel() {
            super(0, 0, 0, 0, 0, 0, obj7, 0, 127, 0);
        }

        public ModuleModel(String string, int i2, String string3, List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel> list4, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> list5, long l6, String string7) {
            n.f(string, "id");
            n.f(string3, "name");
            n.f(list4, "lessons");
            n.f(list5, "exams");
            n.f(obj9, "locale");
            super();
            this.id = string;
            this.index = i2;
            this.name = string3;
            this.lessons = list4;
            this.exams = list5;
            this.updatedAt = l6;
            this.locale = obj9;
        }

        public ModuleModel(String string, int i2, String string3, List list4, List list5, long l6, String string7, int i8, g g9) {
            String str2;
            String str;
            int i;
            String str3;
            List list;
            List list2;
            int i3;
            str = "";
            str2 = g9 & 1 != 0 ? str : string;
            i = g9 & 2 != 0 ? 0 : i2;
            str3 = g9 & 4 != 0 ? str : string3;
            if (g9 & 8 != 0) {
                list = p.g();
            } else {
                list = list4;
            }
            if (g9 & 16 != 0) {
                list2 = p.g();
            } else {
                list2 = list5;
            }
            i3 = g9 & 32 != 0 ? 0 : l6;
            if (g9 & 64 != 0) {
            } else {
                str = i8;
            }
            super(str2, i, str3, list, list2, i3, i8, str);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel programModel$ModuleModel, String string2, int i3, String string4, List list5, List list6, long l7, String string8, int i9, Object object10) {
            String str;
            int index;
            String name;
            List lessons;
            List exams;
            long updatedAt;
            String locale;
            Object obj = moduleModel;
            str = object10 & 1 != 0 ? obj.id : string2;
            index = object10 & 2 != 0 ? obj.index : i3;
            name = object10 & 4 != 0 ? obj.name : string4;
            lessons = object10 & 8 != 0 ? obj.lessons : list5;
            exams = object10 & 16 != 0 ? obj.exams : list6;
            updatedAt = object10 & 32 != 0 ? obj.updatedAt : l7;
            locale = object10 & 64 != 0 ? obj.locale : i9;
            return moduleModel.copy(str, index, name, lessons, exams, updatedAt, string8);
        }

        public final String component1() {
            return this.id;
        }

        public final int component2() {
            return this.index;
        }

        public final String component3() {
            return this.name;
        }

        public final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel> component4() {
            return this.lessons;
        }

        public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> component5() {
            return this.exams;
        }

        public final long component6() {
            return this.updatedAt;
        }

        public final String component7() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel copy(String string, int i2, String string3, List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel> list4, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> list5, long l6, String string7) {
            n.f(string, "id");
            n.f(string3, "name");
            n.f(list4, "lessons");
            n.f(list5, "exams");
            final Object obj = obj18;
            n.f(obj, "locale");
            super(string, i2, string3, list4, list5, l6, obj8, obj);
            return moduleModel;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof ProgramModel.ModuleModel) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (this.index != object.index) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (!n.b(this.lessons, object.lessons)) {
                return i2;
            }
            if (!n.b(this.exams, object.exams)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
        }

        public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> getExams() {
            return this.exams;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel> getLessons() {
            return this.lessons;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final String getName() {
            return this.name;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            return i12 += i19;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModuleModel(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", index=");
            stringBuilder.append(this.index);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", lessons=");
            stringBuilder.append(this.lessons);
            stringBuilder.append(", exams=");
            stringBuilder.append(this.exams);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public ProgramModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2097151, 0);
    }

    public ProgramModel(String string, String string2, List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel> list3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, long l12, String string13, String string14, String string15, List<String> list16, List<String> list17, List<String> list18, int i19, int i20, String string21) {
        Object obj = this;
        Object obj4 = string;
        Object obj5 = string2;
        final Object obj6 = list3;
        final Object obj7 = string4;
        final Object obj8 = string5;
        final Object obj9 = string6;
        final Object obj10 = string7;
        final Object obj11 = string8;
        final Object obj12 = string9;
        final Object obj13 = string10;
        final Object obj14 = string11;
        final Object obj15 = string14;
        final Object obj16 = string15;
        final Object obj17 = list16;
        Object obj2 = list18;
        n.f(obj4, "id");
        n.f(obj5, "name");
        n.f(obj6, "modules");
        n.f(obj7, "image");
        n.f(obj8, "centeredImage");
        n.f(obj9, "description");
        n.f(obj10, "cardBackgroundColor");
        n.f(obj11, "certificateLaurelsImage");
        n.f(obj12, "certificatePaperImage");
        n.f(obj13, "certificatePlaceholderImage");
        n.f(obj14, "certificateRequirements");
        n.f(obj15, "locale");
        n.f(obj16, "type");
        n.f(obj17, "programOverviewImage");
        n.f(list17, "dogSkillsHighlights");
        n.f(list18, "dogSkillsOverview");
        n.f(i19, "userSkillsOverview");
        n.f(obj38, "certificatePreviewImage");
        super();
        Object obj3 = this;
        obj3.id = obj4;
        obj3.name = obj5;
        obj3.modules = obj6;
        obj3.image = obj7;
        obj3.centeredImage = obj8;
        obj3.description = obj9;
        obj3.cardBackgroundColor = obj10;
        obj3.certificateLaurelsImage = obj11;
        obj3.certificatePaperImage = obj12;
        obj3.certificatePlaceholderImage = obj13;
        obj3.certificateRequirements = obj14;
        obj3.updatedAt = l12;
        obj3.locale = obj15;
        obj3.type = obj16;
        obj3.programOverviewImage = obj17;
        obj3.dogSkillsHighlights = list17;
        obj3.dogSkillsOverview = list18;
        obj3.userSkillsOverview = i19;
        obj3.averageCompletionTimeWeeks = i20;
        obj3.numberOfEnrolledUsers = string21;
        obj3.certificatePreviewImage = obj38;
    }

    public ProgramModel(String string, String string2, List list3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, long l12, String string13, String string14, String string15, List list16, List list17, List list18, int i19, int i20, String string21, int i22, g g23) {
        String str6;
        String str2;
        String str4;
        String str11;
        String str9;
        List list5;
        String str5;
        String str7;
        String str10;
        String str14;
        String str12;
        String str8;
        String str13;
        String str3;
        int i3;
        String str;
        List list;
        List list2;
        List list4;
        int i;
        int i2;
        int i4 = g23;
        String str15 = "";
        str2 = i4 & 1 != 0 ? str15 : string;
        str9 = i4 & 2 != 0 ? str15 : string2;
        if (i4 & 4 != 0) {
            list5 = p.g();
        } else {
            list5 = list3;
        }
        str5 = i4 & 8 != 0 ? str15 : string4;
        str7 = i4 & 16 != 0 ? str15 : string5;
        str10 = i4 & 32 != 0 ? str15 : string6;
        str14 = i4 & 64 != 0 ? str15 : string7;
        str12 = i4 & 128 != 0 ? str15 : string8;
        str8 = i4 & 256 != 0 ? str15 : string9;
        str13 = i4 & 512 != 0 ? str15 : string10;
        str3 = i4 & 1024 != 0 ? str15 : string11;
        i3 = i4 & 2048 != 0 ? 0 : l12;
        str = i4 & 4096 != 0 ? str15 : string14;
        final String obj47 = str15;
        str4 = i4 & 8192 != 0 ? obj47 : string15;
        str11 = i4 & 16384 != 0 ? obj47 : list16;
        if (i4 & i24 != 0) {
            list = p.g();
        } else {
            list = list17;
        }
        if (i4 & i26 != 0) {
            list2 = p.g();
        } else {
            list2 = list18;
        }
        if (i4 & i28 != 0) {
            list4 = p.g();
        } else {
            list4 = i19;
        }
        i = i4 & i30 != 0 ? i2 : i20;
        if (i4 & i32 != 0) {
        } else {
            i2 = string21;
        }
        str6 = i4 &= i34 != 0 ? obj47 : i22;
        super(str2, str9, list5, str5, str7, str10, str14, str12, str8, str13, str3, i3, string14, str, str4, str11, list, list2, list4, i, i2, str6);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.ProgramModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel, String string2, String string3, List list4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, long l13, String string14, String string15, String string16, List list17, List list18, List list19, int i20, int i21, String string22, int i23, Object object24) {
        String certificatePreviewImage;
        String str;
        String name;
        List modules;
        String image;
        String centeredImage;
        String description;
        String cardBackgroundColor;
        String certificateLaurelsImage;
        String certificatePaperImage;
        String certificatePlaceholderImage;
        String certificateRequirements;
        long updatedAt;
        String locale;
        String type;
        String programOverviewImage;
        List dogSkillsHighlights;
        List dogSkillsOverview;
        List userSkillsOverview;
        int averageCompletionTimeWeeks;
        int numberOfEnrolledUsers;
        Object obj = programModel;
        int i = object24;
        str = i & 1 != 0 ? obj.id : string2;
        name = i & 2 != 0 ? obj.name : string3;
        modules = i & 4 != 0 ? obj.modules : list4;
        image = i & 8 != 0 ? obj.image : string5;
        centeredImage = i & 16 != 0 ? obj.centeredImage : string6;
        description = i & 32 != 0 ? obj.description : string7;
        cardBackgroundColor = i & 64 != 0 ? obj.cardBackgroundColor : string8;
        certificateLaurelsImage = i & 128 != 0 ? obj.certificateLaurelsImage : string9;
        certificatePaperImage = i & 256 != 0 ? obj.certificatePaperImage : string10;
        certificatePlaceholderImage = i & 512 != 0 ? obj.certificatePlaceholderImage : string11;
        certificateRequirements = i & 1024 != 0 ? obj.certificateRequirements : string12;
        updatedAt = i & 2048 != 0 ? obj.updatedAt : l13;
        locale = i & 4096 != 0 ? obj.locale : string15;
        type = i & 8192 != 0 ? obj.type : string16;
        programOverviewImage = i & 16384 != 0 ? obj.programOverviewImage : list17;
        dogSkillsHighlights = i & i18 != 0 ? obj.dogSkillsHighlights : list18;
        dogSkillsOverview = i & i22 != 0 ? obj.dogSkillsOverview : list19;
        userSkillsOverview = i & i25 != 0 ? obj.userSkillsOverview : i20;
        averageCompletionTimeWeeks = i & i27 != 0 ? obj.averageCompletionTimeWeeks : i21;
        numberOfEnrolledUsers = i & i29 != 0 ? obj.numberOfEnrolledUsers : string22;
        certificatePreviewImage = i &= i31 != 0 ? obj.certificatePreviewImage : i23;
        return programModel.copy(str, name, modules, image, centeredImage, description, cardBackgroundColor, certificateLaurelsImage, certificatePaperImage, certificatePlaceholderImage, certificateRequirements, updatedAt, string14, locale, type, programOverviewImage, dogSkillsHighlights, dogSkillsOverview, userSkillsOverview, averageCompletionTimeWeeks, numberOfEnrolledUsers);
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> allExamModels() {
        List exams;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.modules.iterator();
        for (ProgramModel.ModuleModel next2 : iterator) {
            p.y(arrayList, next2.getExams());
        }
        return arrayList;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel> allTrickModels() {
        List lessons;
        boolean values;
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = this.modules.iterator();
        for (ProgramModel.ModuleModel next3 : iterator) {
            p.y(arrayList2, next3.getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = arrayList2.iterator();
        for (ProgramModel.LessonModel next2 : iterator2) {
            p.y(arrayList, next2.getTricks().values());
        }
        return arrayList;
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.certificatePlaceholderImage;
    }

    public final String component11() {
        return this.certificateRequirements;
    }

    public final long component12() {
        return this.updatedAt;
    }

    public final String component13() {
        return this.locale;
    }

    public final String component14() {
        return this.type;
    }

    public final String component15() {
        return this.programOverviewImage;
    }

    public final List<String> component16() {
        return this.dogSkillsHighlights;
    }

    public final List<String> component17() {
        return this.dogSkillsOverview;
    }

    public final List<String> component18() {
        return this.userSkillsOverview;
    }

    public final int component19() {
        return this.averageCompletionTimeWeeks;
    }

    public final String component2() {
        return this.name;
    }

    public final int component20() {
        return this.numberOfEnrolledUsers;
    }

    public final String component21() {
        return this.certificatePreviewImage;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel> component3() {
        return this.modules;
    }

    public final String component4() {
        return this.image;
    }

    public final String component5() {
        return this.centeredImage;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.cardBackgroundColor;
    }

    public final String component8() {
        return this.certificateLaurelsImage;
    }

    public final String component9() {
        return this.certificatePaperImage;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel copy(String string, String string2, List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel> list3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, long l12, String string13, String string14, String string15, List<String> list16, List<String> list17, List<String> list18, int i19, int i20, String string21) {
        Object obj = string;
        n.f(obj, "id");
        n.f(string2, "name");
        n.f(list3, "modules");
        n.f(string4, "image");
        n.f(string5, "centeredImage");
        n.f(string6, "description");
        n.f(string7, "cardBackgroundColor");
        n.f(string8, "certificateLaurelsImage");
        n.f(string9, "certificatePaperImage");
        n.f(string10, "certificatePlaceholderImage");
        n.f(string11, "certificateRequirements");
        n.f(string14, "locale");
        n.f(string15, "type");
        n.f(list16, "programOverviewImage");
        n.f(list17, "dogSkillsHighlights");
        n.f(list18, "dogSkillsOverview");
        n.f(i19, "userSkillsOverview");
        n.f(obj47, "certificatePreviewImage");
        super(obj, string2, list3, string4, string5, string6, string7, string8, string9, string10, string11, l12, obj13, string14, string15, list16, list17, list18, i19, i20, string21, obj47);
        return programModel2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ProgramModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.modules, object.modules)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.centeredImage, object.centeredImage)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.cardBackgroundColor, object.cardBackgroundColor)) {
            return i2;
        }
        if (!n.b(this.certificateLaurelsImage, object.certificateLaurelsImage)) {
            return i2;
        }
        if (!n.b(this.certificatePaperImage, object.certificatePaperImage)) {
            return i2;
        }
        if (!n.b(this.certificatePlaceholderImage, object.certificatePlaceholderImage)) {
            return i2;
        }
        if (!n.b(this.certificateRequirements, object.certificateRequirements)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (!n.b(this.programOverviewImage, object.programOverviewImage)) {
            return i2;
        }
        if (!n.b(this.dogSkillsHighlights, object.dogSkillsHighlights)) {
            return i2;
        }
        if (!n.b(this.dogSkillsOverview, object.dogSkillsOverview)) {
            return i2;
        }
        if (!n.b(this.userSkillsOverview, object.userSkillsOverview)) {
            return i2;
        }
        if (this.averageCompletionTimeWeeks != object.averageCompletionTimeWeeks) {
            return i2;
        }
        if (this.numberOfEnrolledUsers != object.numberOfEnrolledUsers) {
            return i2;
        }
        if (!n.b(this.certificatePreviewImage, object.certificatePreviewImage)) {
            return i2;
        }
        return i;
    }

    public final int getAverageCompletionTimeWeeks() {
        return this.averageCompletionTimeWeeks;
    }

    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final String getCenteredImage() {
        return this.centeredImage;
    }

    public final String getCertificateLaurelsImage() {
        return this.certificateLaurelsImage;
    }

    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    public final String getCertificatePlaceholderImage() {
        return this.certificatePlaceholderImage;
    }

    public final String getCertificatePreviewImage() {
        return this.certificatePreviewImage;
    }

    public final String getCertificateRequirements() {
        return this.certificateRequirements;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getDogSkillsHighlights() {
        return this.dogSkillsHighlights;
    }

    public final List<String> getDogSkillsOverview() {
        return this.dogSkillsOverview;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel> getModules() {
        return this.modules;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumberOfEnrolledUsers() {
        return this.numberOfEnrolledUsers;
    }

    public final String getProgramOverviewImage() {
        return this.programOverviewImage;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<String> getUserSkillsOverview() {
        return this.userSkillsOverview;
    }

    public int hashCode() {
        return i40 += i61;
    }

    public final boolean isClassicProgram() {
        return n.b(this.type, "classic");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", modules=");
        stringBuilder.append(this.modules);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", centeredImage=");
        stringBuilder.append(this.centeredImage);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", cardBackgroundColor=");
        stringBuilder.append(this.cardBackgroundColor);
        stringBuilder.append(", certificateLaurelsImage=");
        stringBuilder.append(this.certificateLaurelsImage);
        stringBuilder.append(", certificatePaperImage=");
        stringBuilder.append(this.certificatePaperImage);
        stringBuilder.append(", certificatePlaceholderImage=");
        stringBuilder.append(this.certificatePlaceholderImage);
        stringBuilder.append(", certificateRequirements=");
        stringBuilder.append(this.certificateRequirements);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", programOverviewImage=");
        stringBuilder.append(this.programOverviewImage);
        stringBuilder.append(", dogSkillsHighlights=");
        stringBuilder.append(this.dogSkillsHighlights);
        stringBuilder.append(", dogSkillsOverview=");
        stringBuilder.append(this.dogSkillsOverview);
        stringBuilder.append(", userSkillsOverview=");
        stringBuilder.append(this.userSkillsOverview);
        stringBuilder.append(", averageCompletionTimeWeeks=");
        stringBuilder.append(this.averageCompletionTimeWeeks);
        stringBuilder.append(", numberOfEnrolledUsers=");
        stringBuilder.append(this.numberOfEnrolledUsers);
        stringBuilder.append(", certificatePreviewImage=");
        stringBuilder.append(this.certificatePreviewImage);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
