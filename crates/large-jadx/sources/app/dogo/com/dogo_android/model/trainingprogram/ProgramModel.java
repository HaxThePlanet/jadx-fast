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

/* compiled from: ProgramModel.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0002UVBï\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u0002070\u0006J\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u0002070\u0006J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010B\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0019HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0019HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000f\u0010G\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003Jó\u0001\u0010N\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010O\u001a\u00020P2\u0008\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0019HÖ\u0001J\u0006\u0010S\u001a\u00020PJ\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010 R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010 R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010 R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010 R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010 R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010)R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010 R\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010 R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010)¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "", "id", "", "name", "modules", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "image", "centeredImage", "description", "cardBackgroundColor", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderImage", "certificateRequirements", "updatedAt", "", "locale", "type", "programOverviewImage", "dogSkillsHighlights", "dogSkillsOverview", "userSkillsOverview", "averageCompletionTimeWeeks", "", "numberOfEnrolledUsers", "certificatePreviewImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/lang/String;)V", "getAverageCompletionTimeWeeks", "()I", "getCardBackgroundColor", "()Ljava/lang/String;", "getCenteredImage", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderImage", "getCertificatePreviewImage", "getCertificateRequirements", "getDescription", "getDogSkillsHighlights", "()Ljava/util/List;", "getDogSkillsOverview", "getId", "getImage", "getLocale", "getModules", "getName", "getNumberOfEnrolledUsers", "getProgramOverviewImage", "getType", "getUpdatedAt", "()J", "getUserSkillsOverview", "allExamModels", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "allTrickModels", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "isClassicProgram", "toString", "LessonModel", "ModuleModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramModel {

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
    private final List<ProgramModel.ModuleModel> modules;
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
        private final QuestionModel question;
        private final Map<String, TasksModel> tasks;
        private final Map<String, TrickModel> tricks;
        private final long updatedAt;
        public LessonModel(String str, QuestionModel questionModel, Map<String, TrickModel> map, Map<String, TasksModel> map2, int i, String str2, String str3, long j, String str4) {
            n.f(str, "id");
            n.f(questionModel, "question");
            n.f(map, "tricks");
            n.f(map2, "tasks");
            n.f(str2, "moduleId");
            n.f(str3, "programId");
            n.f(str4, "locale");
            super();
            this.id = str;
            this.question = questionModel;
            this.tricks = map;
            this.tasks = map2;
            this.index = i;
            this.moduleId = str2;
            this.programId = str3;
            this.updatedAt = j;
            this.locale = str4;
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

        public final QuestionModel getQuestion() {
            return this.question;
        }

        public final Map<String, TasksModel> getTasks() {
            return this.tasks;
        }

        public final Map<String, TrickModel> getTricks() {
            return this.tricks;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ LessonModel(String str, QuestionModel questionModel, Map map, Map map2, int i, String str2, String str3, long j, String str4, int i2, g gVar) {
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel22;
            Map map32;
            Map map42;
            int i52 = 0;
            int j82 = 0;
            int gVar112 = i2;
            str2 = "";
            String r1 = gVar112 & 1 != 0 ? str2 : str;
            if (gVar112 & 2 != 0) {
                str3 = null;
                str4 = null;
                String str5 = null;
                String str8 = null;
                app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel = null;
                List list = null;
                i = 0;
                long l = 0L;
                i2 = 0;
                gVar = 511;
                int i3 = 0;
                super(str3, str4, str5, str8, articleModel, list, i, l, str10, i2, gVar, i3);
            } else {
                questionModel22 = questionModel;
            }
            if (gVar112 & 4 != 0) {
                map32 = j0.h();
            } else {
                map32 = map;
            }
            if (gVar112 & 8 != 0) {
                map42 = j0.h();
            } else {
                map42 = map2;
            }
            int r6 = gVar112 & 16 != 0 ? 0 : i;
            String r7 = str2;
            String r8 = gVar112 & 64 != 0 ? str2 : str3;
            int r9 = gVar112 & 128 != 0 ? 0 : j;
            if (gVar112 & 256 == 0) {
                str2 = str4;
            }
            this(str2, questionModel22, map32, map42, i52, str2, str2, j82, str4, str2);
        }

        public LessonModel() {
            this(null, null, null, null, 0, null, null, 0L, str, 0, 511, 0);
        }

        public static /* synthetic */ ProgramModel.LessonModel copy$default(ProgramModel.LessonModel lessonModel, String str, QuestionModel questionModel, Map map, Map map2, int i, String str2, String str3, long j, String str4, int i2, Object object) {
            String i112;
            String str22;
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel questionModel32;
            Map map42;
            Map map52;
            int i62;
            String str72;
            String str82;
            long j92;
            Object lessonModel2 = lessonModel;
            int object122 = i2;
            String r2 = object122 & 1 != 0 ? lessonModel2.id : str;
            app.dogo.com.dogo_android.model.trainingprogram.QuestionModel r3 = object122 & 2 != 0 ? lessonModel2.question : questionModel;
            Map r4 = object122 & 4 != 0 ? lessonModel2.tricks : map;
            Map r5 = object122 & 8 != 0 ? lessonModel2.tasks : map2;
            int r6 = object122 & 16 != 0 ? lessonModel2.index : i;
            String r7 = object122 & 32 != 0 ? lessonModel2.moduleId : str2;
            String r8 = object122 & 64 != 0 ? lessonModel2.programId : str3;
            long r9 = object122 & 128 != 0 ? lessonModel2.updatedAt : j;
            String r1 = object122 & 256 != 0 ? lessonModel2.locale : str4;
            return lessonModel.copy(str22, questionModel32, map42, map52, i62, str72, str82, j92, r20, (object122 & 256 != 0 ? lessonModel2.locale : str4));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final QuestionModel component2() {
            return this.question;
        }

        /* operator */ public final Map<String, TrickModel> component3() {
            return this.tricks;
        }

        /* operator */ public final Map<String, TasksModel> component4() {
            return this.tasks;
        }

        /* operator */ public final int component5() {
            return this.index;
        }

        /* operator */ public final String component6() {
            return this.moduleId;
        }

        /* operator */ public final String component7() {
            return this.programId;
        }

        /* operator */ public final long component8() {
            return this.updatedAt;
        }

        /* operator */ public final String component9() {
            return this.locale;
        }

        public final ProgramModel.LessonModel copy(String id, QuestionModel question, Map<String, TrickModel> tricks, Map<String, TasksModel> tasks, int index, String moduleId, String programId, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(question, "question");
            n.f(tricks, "tricks");
            final Object tasks2 = tasks;
            n.f(tasks2, "tasks");
            final Object moduleId2 = moduleId;
            n.f(moduleId2, "moduleId");
            final Object programId2 = programId;
            n.f(programId2, "programId");
            final Object obj = locale;
            n.f(obj, "locale");
            ProgramModel_LessonModel programModel_LessonModel = new ProgramModel_LessonModel(id, question, tricks, tasks2, index, moduleId2, programId2, updatedAt, str8, obj);
            return programModel_LessonModel;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z9 = false;
            if (!(other instanceof ProgramModel_LessonModel)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.question, other.question)) {
                return false;
            }
            if (!n.b(this.tricks, other.tricks)) {
                return false;
            }
            if (!n.b(this.tasks, other.tasks)) {
                return false;
            }
            if (this.index != other.index) {
                return false;
            }
            if (!n.b(this.moduleId, other.moduleId)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z9 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.question.hashCode() * 31 + this.tricks.hashCode() * 31 + this.tasks.hashCode() * 31 + Integer.hashCode(this.index) * 31 + this.moduleId.hashCode() * 31 + this.programId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LessonModel(id=";
            String str3 = ", question=";
            String str4 = ", tricks=";
            String str5 = ", tasks=";
            String str6 = ", index=";
            String str7 = ", moduleId=";
            String str8 = ", programId=";
            String str9 = ", updatedAt=";
            String str10 = ", locale=";
            str = str2 + this.id + str3 + this.question + str4 + this.tricks + str5 + this.tasks + str6 + this.index + str7 + this.moduleId + str8 + this.programId + str9 + this.updatedAt + str10 + this.locale + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001BW\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J[\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "", "id", "", "index", "", "name", "lessons", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "exams", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "updatedAt", "", "locale", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/lang/String;)V", "getExams", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getLessons", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleModel {

        private final List<TrickModel> exams;
        private final String id;
        private final int index;
        private final List<ProgramModel.LessonModel> lessons;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public ModuleModel(String str, int i, String str2, List<ProgramModel.LessonModel> list, List<TrickModel> list2, long j, String str3) {
            n.f(str, "id");
            n.f(str2, "name");
            n.f(list, "lessons");
            n.f(list2, "exams");
            n.f(str3, "locale");
            super();
            this.id = str;
            this.index = i;
            this.name = str2;
            this.lessons = list;
            this.exams = list2;
            this.updatedAt = j;
            this.locale = str3;
        }

        public final List<TrickModel> getExams() {
            return this.exams;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final List<ProgramModel.LessonModel> getLessons() {
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

        public /* synthetic */ ModuleModel(String str, int i, String str2, List list, List list2, long j, String str3, int i2, g gVar) {
            int i22 = 0;
            List list42;
            List list52;
            int j62 = 0;
            str2 = "";
            String r0 = i2 & 1 != 0 ? str2 : str;
            int r2 = i2 & 2 != 0 ? 0 : i;
            String r3 = str2;
            if (i2 & 8 != 0) {
                list42 = p.g();
            } else {
                list42 = list;
            }
            if (i2 & 16 != 0) {
                list52 = p.g();
            } else {
                list52 = list2;
            }
            int r6 = i2 & 32 != 0 ? 0 : j;
            if (i2 & 64 == 0) {
                str2 = str3;
            }
            this(str2, i22, str2, list42, list52, j62, str3, str2);
        }

        public ModuleModel() {
            this(null, 0, null, null, null, 0L, str, 0, 127, 0);
        }

        public static /* synthetic */ ProgramModel.ModuleModel copy$default(ProgramModel.ModuleModel moduleModel, String str, int i, String str2, List list, List list2, long j, String str3, int i2, Object object) {
            String str22;
            int i32;
            String str42;
            List list52;
            List list62;
            long j72;
            String i92;
            Object moduleModel2 = moduleModel;
            String r1 = i2 & 1 != 0 ? moduleModel2.id : str;
            int r2 = i2 & 2 != 0 ? moduleModel2.index : i;
            String r3 = i2 & 4 != 0 ? moduleModel2.name : str2;
            List r4 = i2 & 8 != 0 ? moduleModel2.lessons : list;
            List r5 = i2 & 16 != 0 ? moduleModel2.exams : list2;
            long r6 = i2 & 32 != 0 ? moduleModel2.updatedAt : j;
            String r8 = i2 & 64 != 0 ? moduleModel2.locale : str3;
            return moduleModel.copy(str22, i32, str42, list52, list62, j72, r16, (i2 & 64 != 0 ? moduleModel2.locale : str3));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final int component2() {
            return this.index;
        }

        /* operator */ public final String component3() {
            return this.name;
        }

        /* operator */ public final List<ProgramModel.LessonModel> component4() {
            return this.lessons;
        }

        /* operator */ public final List<TrickModel> component5() {
            return this.exams;
        }

        /* operator */ public final long component6() {
            return this.updatedAt;
        }

        /* operator */ public final String component7() {
            return this.locale;
        }

        public final ProgramModel.ModuleModel copy(String id, int index, String name, List<ProgramModel.LessonModel> lessons, List<TrickModel> exams, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(name, "name");
            n.f(lessons, "lessons");
            n.f(exams, "exams");
            final Object obj = locale;
            n.f(obj, "locale");
            ProgramModel_ModuleModel programModel_ModuleModel = new ProgramModel_ModuleModel(id, index, name, lessons, exams, updatedAt, str6, obj);
            return programModel_ModuleModel;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z7 = false;
            if (!(other instanceof ProgramModel_ModuleModel)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (this.index != other.index) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (!n.b(this.lessons, other.lessons)) {
                return false;
            }
            if (!n.b(this.exams, other.exams)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z7 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + Integer.hashCode(this.index) * 31 + this.name.hashCode() * 31 + this.lessons.hashCode() * 31 + this.exams.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ModuleModel(id=";
            String str3 = ", index=";
            String str4 = ", name=";
            String str5 = ", lessons=";
            String str6 = ", exams=";
            String str7 = ", updatedAt=";
            String str8 = ", locale=";
            str = str2 + this.id + str3 + this.index + str4 + this.name + str5 + this.lessons + str6 + this.exams + str7 + this.updatedAt + str8 + this.locale + 41;
            return str;
        }
    }
    public ProgramModel(String str, String str2, List<ProgramModel.ModuleModel> list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j, String str11, String str12, String str13, List<String> list2, List<String> list3, List<String> list4, int i, int i2, String str14) {
        Object str32 = str;
        Object str22 = str2;
        final Object list32 = list;
        final Object str42 = str3;
        final Object str52 = str4;
        final Object str62 = str5;
        final Object str72 = str6;
        final Object str82 = str7;
        final Object str92 = str8;
        final Object str102 = str9;
        final Object str112 = str10;
        final Object str142 = str11;
        final Object str152 = str12;
        final Object list162 = str13;
        n.f(str32, "id");
        n.f(str22, "name");
        n.f(list32, "modules");
        n.f(str42, "image");
        n.f(str52, "centeredImage");
        n.f(str62, "description");
        n.f(str72, "cardBackgroundColor");
        n.f(str82, "certificateLaurelsImage");
        n.f(str92, "certificatePaperImage");
        n.f(str102, "certificatePlaceholderImage");
        n.f(str112, "certificateRequirements");
        n.f(str142, "locale");
        n.f(str152, "type");
        n.f(list162, "programOverviewImage");
        n.f(list2, "dogSkillsHighlights");
        n.f(list3, "dogSkillsOverview");
        n.f(list4, "userSkillsOverview");
        n.f(str14, "certificatePreviewImage");
        super();
        Object str35 = this;
        str35.id = str32;
        str35.name = str22;
        str35.modules = list32;
        str35.image = str42;
        str35.centeredImage = str52;
        str35.description = str62;
        str35.cardBackgroundColor = str72;
        str35.certificateLaurelsImage = str82;
        str35.certificatePaperImage = str92;
        str35.certificatePlaceholderImage = str102;
        str35.certificateRequirements = str112;
        str35.updatedAt = j;
        str35.locale = str142;
        str35.type = str152;
        str35.programOverviewImage = list162;
        str35.dogSkillsHighlights = list2;
        str35.dogSkillsOverview = list3;
        str35.userSkillsOverview = list4;
        str35.averageCompletionTimeWeeks = i;
        str35.numberOfEnrolledUsers = i2;
        str35.certificatePreviewImage = str14;
    }

    public final List<TrickModel> allExamModels() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.modules.iterator();
        while (it.hasNext()) {
            p.y(arrayList, (ProgramModel_ModuleModel)it.next().getExams());
        }
        return arrayList;
    }

    public final List<TrickModel> allTrickModels() {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.modules.iterator();
        while (it.hasNext()) {
            p.y(arrayList2, (ProgramModel_ModuleModel)it.next().getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            p.y(arrayList, (ProgramModel_LessonModel)it2.next().getTricks().values());
        }
        return arrayList;
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

    public final List<ProgramModel.ModuleModel> getModules() {
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

    public final boolean isClassicProgram() {
        return n.b(this.type, "classic");
    }

    public /* synthetic */ ProgramModel(String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j, String str11, String str12, String str13, List list2, List list3, List list4, int i, int i2, String str14, int i3, g gVar) {
        String i222;
        List list32;
        int j122 = 0;
        List list172;
        List list182;
        List i192;
        int i202;
        int gVar232 = i3;
        i222 = "";
        String r1 = gVar232 & 1 != 0 ? i222 : str;
        String r3 = gVar232 & 2 != 0 ? i222 : str2;
        if (gVar232 & 4 != 0) {
            list32 = p.g();
        } else {
            list32 = list;
        }
        String r5 = gVar232 & 8 != 0 ? i222 : str3;
        String r6 = gVar232 & 16 != 0 ? i222 : str4;
        String r7 = gVar232 & 32 != 0 ? i222 : str5;
        String r8 = gVar232 & 64 != 0 ? i222 : str6;
        String r9 = gVar232 & 128 != 0 ? i222 : str7;
        String r10 = gVar232 & 256 != 0 ? i222 : str8;
        String r11 = gVar232 & 512 != 0 ? i222 : str9;
        String r12 = gVar232 & 1024 != 0 ? i222 : str10;
        int r13 = gVar232 & 2048 != 0 ? 0 : j;
        String r15 = gVar232 & 4096 != 0 ? i222 : str11;
        String r2 = gVar232 & 8192 != 0 ? i222 : str12;
        r2 = gVar232 & 16384 != 0 ? i222 : str13;
        if (gVar232 & 32768 != 0) {
            list172 = p.g();
        } else {
            list172 = list2;
        }
        if (gVar232 & 65536 != 0) {
            list182 = p.g();
        } else {
            list182 = list3;
        }
        if (gVar232 & 131072 != 0) {
            i192 = p.g();
        } else {
            i192 = list4;
        }
        i202 = 0;
        int r20 = gVar232 & 262144 != 0 ? 0 : i;
        if (gVar232 & 524288 == 0) {
            i202 = i2;
        }
        String r0 = gVar232 & 1048576 != 0 ? i222 : str14;
        this(i222, i222, list32, i222, i222, i222, i222, i222, i222, i222, i222, j122, str11, i222, (gVar232 & 8192 != 0 ? i222 : str12), i222, list172, list182, i192, i202, i202, (gVar232 & 1048576 != 0 ? i222 : str14));
    }

    public ProgramModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0L, str, null, null, null, null, null, 0, 0, null, 0, 2097151, 0);
    }

    public static /* synthetic */ ProgramModel copy$default(ProgramModel programModel, String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j, String str11, String str12, String str13, List list2, List list3, List list4, int i, int i2, String str14, int i3, Object object) {
        String i232;
        String str23;
        String str32;
        List list42;
        String str52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        String str112;
        String str122;
        long j132;
        String str152;
        String str162;
        String list172;
        List list182;
        List list192;
        List i202;
        int i212;
        int str222;
        Object programModel2 = programModel;
        int object242 = i3;
        String r2 = object242 & 1 != 0 ? programModel2.id : str;
        String r3 = object242 & 2 != 0 ? programModel2.name : str2;
        List r4 = object242 & 4 != 0 ? programModel2.modules : list;
        String r5 = object242 & 8 != 0 ? programModel2.image : str3;
        String r6 = object242 & 16 != 0 ? programModel2.centeredImage : str4;
        String r7 = object242 & 32 != 0 ? programModel2.description : str5;
        String r8 = object242 & 64 != 0 ? programModel2.cardBackgroundColor : str6;
        String r9 = object242 & 128 != 0 ? programModel2.certificateLaurelsImage : str7;
        String r10 = object242 & 256 != 0 ? programModel2.certificatePaperImage : str8;
        String r11 = object242 & 512 != 0 ? programModel2.certificatePlaceholderImage : str9;
        String r12 = object242 & 1024 != 0 ? programModel2.certificateRequirements : str10;
        long r13 = object242 & 2048 != 0 ? programModel2.updatedAt : j;
        String r15 = object242 & 4096 != 0 ? programModel2.locale : str11;
        r15 = object242 & 8192 != 0 ? programModel2.type : str12;
        r15 = object242 & 16384 != 0 ? programModel2.programOverviewImage : str13;
        r15 = object242 & 32768 != 0 ? programModel2.dogSkillsHighlights : list2;
        r15 = object242 & 65536 != 0 ? programModel2.dogSkillsOverview : list3;
        r15 = object242 & 131072 != 0 ? programModel2.userSkillsOverview : list4;
        r15 = object242 & 262144 != 0 ? programModel2.averageCompletionTimeWeeks : i;
        r15 = object242 & 524288 != 0 ? programModel2.numberOfEnrolledUsers : i2;
        String r1 = object242 & 1048576 != 0 ? programModel2.certificatePreviewImage : str14;
        return programModel.copy(str23, str32, list42, str52, str62, str72, str82, str92, str102, str112, str122, j132, r30, (object242 & 4096 != 0 ? programModel2.locale : str11), (object242 & 8192 != 0 ? programModel2.type : str12), (object242 & 16384 != 0 ? programModel2.programOverviewImage : str13), (object242 & 32768 != 0 ? programModel2.dogSkillsHighlights : list2), (object242 & 65536 != 0 ? programModel2.dogSkillsOverview : list3), (object242 & 131072 != 0 ? programModel2.userSkillsOverview : list4), (object242 & 262144 != 0 ? programModel2.averageCompletionTimeWeeks : i), str222, (object242 & 1048576 != 0 ? programModel2.certificatePreviewImage : str14));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component10() {
        return this.certificatePlaceholderImage;
    }

    /* operator */ public final String component11() {
        return this.certificateRequirements;
    }

    /* operator */ public final long component12() {
        return this.updatedAt;
    }

    /* operator */ public final String component13() {
        return this.locale;
    }

    /* operator */ public final String component14() {
        return this.type;
    }

    /* operator */ public final String component15() {
        return this.programOverviewImage;
    }

    /* operator */ public final List<String> component16() {
        return this.dogSkillsHighlights;
    }

    /* operator */ public final List<String> component17() {
        return this.dogSkillsOverview;
    }

    /* operator */ public final List<String> component18() {
        return this.userSkillsOverview;
    }

    /* operator */ public final int component19() {
        return this.averageCompletionTimeWeeks;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final int component20() {
        return this.numberOfEnrolledUsers;
    }

    /* operator */ public final String component21() {
        return this.certificatePreviewImage;
    }

    /* operator */ public final List<ProgramModel.ModuleModel> component3() {
        return this.modules;
    }

    /* operator */ public final String component4() {
        return this.image;
    }

    /* operator */ public final String component5() {
        return this.centeredImage;
    }

    /* operator */ public final String component6() {
        return this.description;
    }

    /* operator */ public final String component7() {
        return this.cardBackgroundColor;
    }

    /* operator */ public final String component8() {
        return this.certificateLaurelsImage;
    }

    /* operator */ public final String component9() {
        return this.certificatePaperImage;
    }

    public final ProgramModel copy(String id, String name, List<ProgramModel.ModuleModel> modules, String image, String centeredImage, String description, String cardBackgroundColor, String certificateLaurelsImage, String certificatePaperImage, String certificatePlaceholderImage, String certificateRequirements, long updatedAt, String locale, String type, String programOverviewImage, List<String> dogSkillsHighlights, List<String> dogSkillsOverview, List<String> userSkillsOverview, int averageCompletionTimeWeeks, int numberOfEnrolledUsers, String certificatePreviewImage) {
        Object id2 = id;
        n.f(id2, "id");
        n.f(name, "name");
        n.f(modules, "modules");
        n.f(image, "image");
        n.f(centeredImage, "centeredImage");
        n.f(description, "description");
        n.f(cardBackgroundColor, "cardBackgroundColor");
        n.f(certificateLaurelsImage, "certificateLaurelsImage");
        n.f(certificatePaperImage, "certificatePaperImage");
        n.f(certificatePlaceholderImage, "certificatePlaceholderImage");
        n.f(certificateRequirements, "certificateRequirements");
        n.f(locale, "locale");
        n.f(type, "type");
        n.f(programOverviewImage, "programOverviewImage");
        n.f(dogSkillsHighlights, "dogSkillsHighlights");
        n.f(dogSkillsOverview, "dogSkillsOverview");
        n.f(userSkillsOverview, "userSkillsOverview");
        n.f(certificatePreviewImage, "certificatePreviewImage");
        ProgramModel programModel = new ProgramModel(id2, name, modules, image, centeredImage, description, cardBackgroundColor, certificateLaurelsImage, certificatePaperImage, certificatePlaceholderImage, certificateRequirements, updatedAt, str20, locale, type, programOverviewImage, dogSkillsHighlights, dogSkillsOverview, userSkillsOverview, averageCompletionTimeWeeks, numberOfEnrolledUsers, certificatePreviewImage);
        return programModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z20 = false;
        if (!(other instanceof ProgramModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.modules, other.modules)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.centeredImage, other.centeredImage)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.cardBackgroundColor, other.cardBackgroundColor)) {
            return false;
        }
        if (!n.b(this.certificateLaurelsImage, other.certificateLaurelsImage)) {
            return false;
        }
        if (!n.b(this.certificatePaperImage, other.certificatePaperImage)) {
            return false;
        }
        if (!n.b(this.certificatePlaceholderImage, other.certificatePlaceholderImage)) {
            return false;
        }
        if (!n.b(this.certificateRequirements, other.certificateRequirements)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (!n.b(this.programOverviewImage, other.programOverviewImage)) {
            return false;
        }
        if (!n.b(this.dogSkillsHighlights, other.dogSkillsHighlights)) {
            return false;
        }
        if (!n.b(this.dogSkillsOverview, other.dogSkillsOverview)) {
            return false;
        }
        if (!n.b(this.userSkillsOverview, other.userSkillsOverview)) {
            return false;
        }
        if (this.averageCompletionTimeWeeks != other.averageCompletionTimeWeeks) {
            return false;
        }
        if (this.numberOfEnrolledUsers != other.numberOfEnrolledUsers) {
            return false;
        }
        return !n.b(this.certificatePreviewImage, other.certificatePreviewImage) ? z20 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.modules.hashCode() * 31 + this.image.hashCode() * 31 + this.centeredImage.hashCode() * 31 + this.description.hashCode() * 31 + this.cardBackgroundColor.hashCode() * 31 + this.certificateLaurelsImage.hashCode() * 31 + this.certificatePaperImage.hashCode() * 31 + this.certificatePlaceholderImage.hashCode() * 31 + this.certificateRequirements.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode() * 31 + this.type.hashCode() * 31 + this.programOverviewImage.hashCode() * 31 + this.dogSkillsHighlights.hashCode() * 31 + this.dogSkillsOverview.hashCode() * 31 + this.userSkillsOverview.hashCode() * 31 + Integer.hashCode(this.averageCompletionTimeWeeks) * 31 + Integer.hashCode(this.numberOfEnrolledUsers) * 31 + this.certificatePreviewImage.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramModel(id=";
        String str3 = ", name=";
        String str4 = ", modules=";
        String str5 = ", image=";
        String str6 = ", centeredImage=";
        String str7 = ", description=";
        String str8 = ", cardBackgroundColor=";
        String str9 = ", certificateLaurelsImage=";
        String str10 = ", certificatePaperImage=";
        String str11 = ", certificatePlaceholderImage=";
        String str12 = ", certificateRequirements=";
        String str13 = ", updatedAt=";
        String str14 = ", locale=";
        String str15 = ", type=";
        String str16 = ", programOverviewImage=";
        String str17 = ", dogSkillsHighlights=";
        String str18 = ", dogSkillsOverview=";
        String str19 = ", userSkillsOverview=";
        String str20 = ", averageCompletionTimeWeeks=";
        String str21 = ", numberOfEnrolledUsers=";
        String str22 = ", certificatePreviewImage=";
        str = str2 + this.id + str3 + this.name + str4 + this.modules + str5 + this.image + str6 + this.centeredImage + str7 + this.description + str8 + this.cardBackgroundColor + str9 + this.certificateLaurelsImage + str10 + this.certificatePaperImage + str11 + this.certificatePlaceholderImage + str12 + this.certificateRequirements + str13 + this.updatedAt + str14 + this.locale + str15 + this.type + str16 + this.programOverviewImage + str17 + this.dogSkillsHighlights + str18 + this.dogSkillsOverview + str19 + this.userSkillsOverview + str20 + this.averageCompletionTimeWeeks + str21 + this.numberOfEnrolledUsers + str22 + this.certificatePreviewImage + 41;
        return str;
    }
}
