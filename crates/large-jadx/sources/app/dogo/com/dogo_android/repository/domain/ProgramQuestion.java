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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 /2\u00020\u0001:\u0002/0BS\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u000cHÆ\u0003JW\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "Landroid/os/Parcelable;", "questionId", "", "question", "explanation", "explanationHtml", "answers", "", "correctAnswer", "", "type", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;)V", "getAnswers", "()Ljava/util/List;", "getCorrectAnswer", "()I", "getExplanation", "()Ljava/lang/String;", "getExplanationHtml", "getQuestion", "getQuestionId", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "setType", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramQuestion implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramQuestion> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Companion Companion;
    private final List<String> answers;
    private final int correctAnswer;
    private final String explanation;
    private final String explanationHtml;
    private final String question;
    private final String questionId;
    private app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type type;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Companion;", "", "()V", "fromModel", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "model", "Lapp/dogo/com/dogo_android/model/trainingprogram/QuestionModel;", "isAnswered", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion fromModel(QuestionModel questionModel, boolean z2) {
            app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type obj10;
            n.f(questionModel, "model");
            obj10 = z2 ? ProgramQuestion.Type.ANSWERED : ProgramQuestion.Type.NOT_ANSWERED;
            super(questionModel.getId(), questionModel.getQuestion(), questionModel.getExplanation(), questionModel.getExplanationHtml(), questionModel.getAnswers(), questionModel.getCorrectAnswer(), obj10);
            return programQuestion;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramQuestion> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readInt(), ProgramQuestion.Type.valueOf(parcel.readString()));
            return programQuestion;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion[] newArray(int i) {
            return new ProgramQuestion[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion$Type;", "", "(Ljava/lang/String;I)V", "NOT_ANSWERED", "ANSWERED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Type {

        NOT_ANSWERED,
        ANSWERED;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type[] arr = new ProgramQuestion.Type[2];
            return arr;
        }
    }
    static {
        ProgramQuestion.Companion companion = new ProgramQuestion.Companion(0);
        ProgramQuestion.Companion = companion;
        ProgramQuestion.Creator creator = new ProgramQuestion.Creator();
        ProgramQuestion.CREATOR = creator;
    }

    public ProgramQuestion() {
        super(0, 0, 0, 0, 0, 0, 0, 127, 0);
    }

    public ProgramQuestion(String string, String string2, String string3, String string4, List<String> list5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type programQuestion$Type7) {
        n.f(string, "questionId");
        n.f(string2, "question");
        n.f(string3, "explanation");
        n.f(list5, "answers");
        n.f(type7, "type");
        super();
        this.questionId = string;
        this.question = string2;
        this.explanation = string3;
        this.explanationHtml = string4;
        this.answers = list5;
        this.correctAnswer = i6;
        this.type = type7;
    }

    public ProgramQuestion(String string, String string2, String string3, String string4, List list5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type programQuestion$Type7, int i8, g g9) {
        String str3;
        String str;
        String str2;
        List obj10;
        int obj11;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type obj12;
        String obj14;
        str3 = "";
        obj14 = i8 & 1 != 0 ? str3 : string;
        str = i8 & 2 != 0 ? str3 : string2;
        str2 = i8 & 4 != 0 ? str3 : string3;
        if (i8 & 8 != 0) {
        } else {
            str3 = string4;
        }
        if (i8 & 16 != 0) {
            obj10 = p.g();
        }
        obj11 = i8 & 32 != 0 ? 0 : obj11;
        obj12 = i8 & 64 != 0 ? ProgramQuestion.Type.NOT_ANSWERED : obj12;
        super(obj14, str, str2, str3, obj10, obj11, obj12);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramQuestion copy$default(app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion, String string2, String string3, String string4, String string5, List list6, int i7, app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type programQuestion$Type8, int i9, Object object10) {
        String obj6;
        String obj7;
        String obj8;
        String obj9;
        List obj10;
        int obj11;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type obj12;
        if (i9 & 1 != 0) {
            obj6 = programQuestion.questionId;
        }
        if (i9 & 2 != 0) {
            obj7 = programQuestion.question;
        }
        if (i9 & 4 != 0) {
            obj8 = programQuestion.explanation;
        }
        if (i9 & 8 != 0) {
            obj9 = programQuestion.explanationHtml;
        }
        if (i9 & 16 != 0) {
            obj10 = programQuestion.answers;
        }
        if (i9 & 32 != 0) {
            obj11 = programQuestion.correctAnswer;
        }
        if (i9 & 64 != 0) {
            obj12 = programQuestion.type;
        }
        return programQuestion.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.questionId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.question;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.explanation;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.explanationHtml;
    }

    public final List<String> component5() {
        return this.answers;
    }

    @Override // android.os.Parcelable
    public final int component6() {
        return this.correctAnswer;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type component7() {
        return this.type;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion copy(String string, String string2, String string3, String string4, List<String> list5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type programQuestion$Type7) {
        n.f(string, "questionId");
        n.f(string2, "question");
        n.f(string3, "explanation");
        n.f(list5, "answers");
        final Object obj = type7;
        n.f(obj, "type");
        super(string, string2, string3, string4, list5, i6, obj);
        return programQuestion;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ProgramQuestion) {
            return i2;
        }
        if (!n.b(this.questionId, object.questionId)) {
            return i2;
        }
        if (!n.b(this.question, object.question)) {
            return i2;
        }
        if (!n.b(this.explanation, object.explanation)) {
            return i2;
        }
        if (!n.b(this.explanationHtml, object.explanationHtml)) {
            return i2;
        }
        if (!n.b(this.answers, object.answers)) {
            return i2;
        }
        if (this.correctAnswer != object.correctAnswer) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        return i;
    }

    public final List<String> getAnswers() {
        return this.answers;
    }

    @Override // android.os.Parcelable
    public final int getCorrectAnswer() {
        return this.correctAnswer;
    }

    @Override // android.os.Parcelable
    public final String getExplanation() {
        return this.explanation;
    }

    @Override // android.os.Parcelable
    public final String getExplanationHtml() {
        return this.explanationHtml;
    }

    @Override // android.os.Parcelable
    public final String getQuestion() {
        return this.question;
    }

    @Override // android.os.Parcelable
    public final String getQuestionId() {
        return this.questionId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        String explanationHtml = this.explanationHtml;
        if (explanationHtml == null) {
            i = 0;
        } else {
            i = explanationHtml.hashCode();
        }
        return i13 += i19;
    }

    @Override // android.os.Parcelable
    public final void setType(app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type programQuestion$Type) {
        n.f(type, "<set-?>");
        this.type = type;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramQuestion(questionId=");
        stringBuilder.append(this.questionId);
        stringBuilder.append(", question=");
        stringBuilder.append(this.question);
        stringBuilder.append(", explanation=");
        stringBuilder.append(this.explanation);
        stringBuilder.append(", explanationHtml=");
        stringBuilder.append(this.explanationHtml);
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", correctAnswer=");
        stringBuilder.append(this.correctAnswer);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
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
