package app.dogo.com.dogo_android.util.k0;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.databinding.a;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.i;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class d extends app.dogo.com.dogo_android.util.k0.g {

    public i<String> commentField;
    private boolean replyFlag;
    private String replyTag;
    private ChallengeComment replyTarget;
    private final Resources resources;
    private final v2 utilities;

    class a extends h.a {

        final app.dogo.com.dogo_android.util.k0.d a;
        a(app.dogo.com.dogo_android.util.k0.d d) {
            this.a = d;
            super();
        }

        @Override // androidx.databinding.h$a
        public void d(h h, int i2) {
            boolean obj1;
            String obj2;
            if (d.access$000(this.a) && !(String)obj1.commentField.d().startsWith(d.access$100(this.a))) {
                if (!(String)obj1.commentField.d().startsWith(d.access$100(this.a))) {
                    d.access$200(this.a);
                }
            }
            this.a.notifyPropertyChanged(42);
            this.a.notifyPropertyChanged(154);
        }
    }
    public d() {
        super(App.p(), App.a().getResources());
    }

    public d(v2 v2, Resources resources2) {
        super();
        String str = "";
        i iVar = new i(str);
        this.commentField = iVar;
        this.replyTag = str;
        this.replyFlag = false;
        this.utilities = v2;
        this.resources = resources2;
        d.a obj3 = new d.a(this);
        iVar.addOnPropertyChangedCallback(obj3);
    }

    static boolean access$000(app.dogo.com.dogo_android.util.k0.d d) {
        return d.replyFlag;
    }

    static String access$100(app.dogo.com.dogo_android.util.k0.d d) {
        return d.replyTag;
    }

    static void access$200(app.dogo.com.dogo_android.util.k0.d d) {
        d.removeReplyTag();
    }

    private boolean d(TextView textView, int i2, KeyEvent keyEvent3) {
        int obj3;
        if (keyEvent3 == 0 && i2 == 4) {
            if (i2 == 4) {
                sendSetup(textView);
                return 1;
            }
        }
        return 0;
    }

    private void removeReplyTag() {
        this.replyFlag = false;
        String str = "";
        this.replyTag = str;
        this.replyTarget = 0;
        this.commentField.e(str);
    }

    private void sendSetup(TextView textView) {
        String replaceFirst;
        boolean commentBoxEmpty;
        if (!isCommentBoxEmpty()) {
            onSendActionListener((String)this.commentField.d().replaceFirst(Pattern.quote(this.replyTag), ""), this.replyTarget);
            textView.onEditorAction(6);
        }
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void addReplyTag(ChallengeComment challengeComment) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(challengeComment.getDogName());
        stringBuilder.append(" ");
        String string = stringBuilder.toString();
        this.replyTag = string;
        this.commentField.e(string);
        this.replyFlag = true;
        this.replyTarget = challengeComment;
        notifyPropertyChanged(59);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void clearCommentField() {
        this.commentField.e("");
        removeReplyTag();
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean e(TextView textView, int i2, KeyEvent keyEvent3) {
        return d(textView, i2, keyEvent3);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getBackgroundColorRes(View view) {
        return view.getResources().getColor(2131100379, 0);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getCommentCount() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public String getCommentCountString() {
        return "";
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getCursorPosition() {
        return (String)this.commentField.d().length();
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public TextView.OnEditorActionListener getEditorActionListener() {
        b bVar = new b(this);
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getTextColorRes(View view) {
        return view.getResources().getColor(2131099697, 0);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public float getTextSize() {
        float dimension;
        Object obj;
        int i;
        boolean utilities;
        obj = this.commentField.d();
        if (obj != null && !(String)obj.isEmpty() && this.utilities.n(obj)) {
            if (!obj.isEmpty()) {
                if (this.utilities.n(obj)) {
                    dimension = this.resources.getDimension(2131165289);
                } else {
                    dimension = this.resources.getDimension(2131165293);
                }
            } else {
            }
        } else {
        }
        return dimension;
    }

    @Deprecated
    public String getTitle() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract Uri getUserDogIcon();

    @Deprecated
    public boolean isBackVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentBordersVisible() {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentBoxEmpty() {
        return (String)this.commentField.d().replaceFirst(Pattern.quote(this.replyTag), "").isEmpty();
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentLabelVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract boolean isUserPremiumBadgeVisible();

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract void onAvatarClick();

    @Deprecated
    public void onBack() {
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void onCommentsLabelClick() {
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract void onSendActionListener(String string, ChallengeComment challengeComment2);

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void onSendClick(EditText editText) {
        if (isCommentLabelVisible()) {
            onCommentsLabelClick();
        } else {
            sendSetup(editText);
        }
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract boolean permissionCheck();

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void updateAll() {
        notifyPropertyChanged(47);
        notifyPropertyChanged(44);
        notifyPropertyChanged(43);
        notifyPropertyChanged(172);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void updateCommentLabelView() {
        notifyPropertyChanged(47);
        notifyPropertyChanged(44);
        notifyPropertyChanged(43);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void updateDogAvatar() {
        notifyPropertyChanged(172);
    }
}
