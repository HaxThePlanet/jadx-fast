package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.model.trainingprogram.QuestionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgramQuestion.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 /2\u00020\u0001:\u0002/0BS\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u000cHÆ\u0003JW\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "Landroid/os/Parcelable;", "questionId", "", "question", "explanation", "explanationHtml", "answers", "", "correctAnswer", "", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;)V", "getAnswers", "()Ljava/util/List;", "getCorrectAnswer", "()I", "getExplanation", "()Ljava/lang/String;", "getExplanationHtml", "getQuestion", "getQuestionId", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "setType", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramQuestion implements Parcelable {

    public static final Parcelable.Creator<ProgramQuestion> CREATOR = new ProgramQuestion$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ProgramQuestion.Companion INSTANCE = new ProgramQuestion$Companion(0);
    private final List<String> answers;
    private final int correctAnswer;
    private final String explanation;
    private final String explanationHtml;
    private final String question;
    private final String questionId;
    private ProgramQuestion.Type type;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Companion;", "", "()V", "fromModel", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "model", "Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "isAnswered", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final ProgramQuestion fromModel(QuestionModel model, boolean isAnswered) {
            app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type model2;
            n.f(model, "model");
            model = isAnswered ? ProgramQuestion_Type.ANSWERED : ProgramQuestion_Type.NOT_ANSWERED;
            ProgramQuestion programQuestion = new ProgramQuestion(model.getId(), model.getQuestion(), model.getExplanation(), model.getExplanationHtml(), model.getAnswers(), model.getCorrectAnswer(), (isAnswered ? ProgramQuestion_Type.ANSWERED : ProgramQuestion_Type.NOT_ANSWERED));
            return programQuestion;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramQuestion> {
        @Override // android.os.Parcelable$Creator
        public final ProgramQuestion createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            ProgramQuestion programQuestion = new ProgramQuestion(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readInt(), ProgramQuestion_Type.valueOf(parcel.readString()));
            return programQuestion;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramQuestion[] newArray(int i) {
            return new ProgramQuestion[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "", "(Ljava/lang/String;I)V", "NOT_ANSWERED", "ANSWERED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {

        ANSWERED,
        NOT_ANSWERED;
        private static final /* synthetic */ ProgramQuestion.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type[] arr = new ProgramQuestion.Type[2];
            return new ProgramQuestion.Type[] { ProgramQuestion_Type.NOT_ANSWERED, ProgramQuestion_Type.ANSWERED };
        }
    }
    public ProgramQuestion(String str, String str2, String str3, String str4, List<String> list, int i, ProgramQuestion.Type type) {
        n.f(str, "questionId");
        n.f(str2, "question");
        n.f(str3, "explanation");
        n.f(list, "answers");
        n.f(type, "type");
        super();
        this.questionId = str;
        this.question = str2;
        this.explanation = str3;
        this.explanationHtml = str4;
        this.answers = list;
        this.correctAnswer = i;
        this.type = type;
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    public final int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final String getExplanationHtml() {
        return this.explanationHtml;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final ProgramQuestion.Type getType() {
        return this.type;
    }

    public final void setType(ProgramQuestion.Type type) {
        n.f(type, "<set-?>");
        this.type = type;
    }

    public /* synthetic */ ProgramQuestion(String str, String str2, String str3, String str4, List list, int i, ProgramQuestion.Type type, int i2, g gVar) {
        String str42;
        List list52;
        int i62 = 0;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type type72;
        str42 = "";
        gVar = i2 & 1 != 0 ? str42 : str;
        String r1 = i2 & 2 != 0 ? str42 : str2;
        String r2 = i2 & 4 != 0 ? str42 : str3;
        if (i2 & 8 == 0) {
            str42 = str4;
        }
        if (i2 & 16 != 0) {
            list52 = p.g();
        }
        i62 = i2 & 32 != 0 ? 0 : i62;
        type72 = i2 & 64 != 0 ? ProgramQuestion_Type.NOT_ANSWERED : type72;
        this(str42, str42, str42, str42, list52, i62, type72);
    }


    public ProgramQuestion() {
        this(null, null, null, null, null, 0, null, 127, null);
    }

    public static /* synthetic */ ProgramQuestion copy$default(ProgramQuestion programQuestion, String str, String str2, String str3, String str4, List list, int i, ProgramQuestion.Type type, int i2, Object object) {
        String str22;
        String object102;
        String str42;
        String str52;
        List list62;
        int i72;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type type82;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        if (i2 & 16 != 0) {
        }
        if (i2 & 32 != 0) {
        }
        if (i2 & 64 != 0) {
        }
        return programQuestion.copy(str22, object102, str42, str52, list62, i72, type82);
    }

    /* operator */ public final String component1() {
        return this.questionId;
    }

    /* operator */ public final String component2() {
        return this.question;
    }

    /* operator */ public final String component3() {
        return this.explanation;
    }

    /* operator */ public final String component4() {
        return this.explanationHtml;
    }

    /* operator */ public final List<String> component5() {
        return this.answers;
    }

    /* operator */ public final int component6() {
        return this.correctAnswer;
    }

    /* operator */ public final ProgramQuestion.Type component7() {
        return this.type;
    }

    public final ProgramQuestion copy(String questionId, String question, String explanation, String explanationHtml, List<String> answers, int correctAnswer, ProgramQuestion.Type type) {
        n.f(questionId, "questionId");
        n.f(question, "question");
        n.f(explanation, "explanation");
        n.f(answers, "answers");
        final Object type2 = type;
        n.f(type2, "type");
        ProgramQuestion programQuestion = new ProgramQuestion(questionId, question, explanation, explanationHtml, answers, correctAnswer, type2);
        return programQuestion;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z8 = false;
        if (!(other instanceof ProgramQuestion)) {
            return false;
        }
        if (!n.b(this.questionId, other.questionId)) {
            return false;
        }
        if (!n.b(this.question, other.question)) {
            return false;
        }
        if (!n.b(this.explanation, other.explanation)) {
            return false;
        }
        if (!n.b(this.explanationHtml, other.explanationHtml)) {
            return false;
        }
        if (!n.b(this.answers, other.answers)) {
            return false;
        }
        if (this.correctAnswer != other.correctAnswer) {
            return false;
        }
        return this.type != other.type ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.explanationHtml == null) {
            i = 0;
        } else {
            i = this.explanationHtml.hashCode();
        }
        return (this.questionId.hashCode() * 31) + this.question.hashCode() * 31 + this.explanation.hashCode() * 31 + i * 31 + this.answers.hashCode() * 31 + Integer.hashCode(this.correctAnswer) * 31 + this.type.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramQuestion(questionId=";
        String str3 = ", question=";
        String str4 = ", explanation=";
        String str5 = ", explanationHtml=";
        String str6 = ", answers=";
        String str7 = ", correctAnswer=";
        String str8 = ", type=";
        str = str2 + this.questionId + str3 + this.question + str4 + this.explanation + str5 + this.explanationHtml + str6 + this.answers + str7 + this.correctAnswer + str8 + this.type + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.questionId);
        parcel.writeString(this.question);
        parcel.writeString(this.explanation);
        parcel.writeString(this.explanationHtml);
        parcel.writeStringList(this.answers);
        parcel.writeInt(this.correctAnswer);
        parcel.writeString(this.type.name());
    }
}
