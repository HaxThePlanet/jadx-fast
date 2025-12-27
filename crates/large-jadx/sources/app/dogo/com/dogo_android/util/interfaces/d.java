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

/* compiled from: CommentBarManager.java */
/* loaded from: classes.dex */
public abstract class d extends g {

    public i<String> commentField;
    private boolean replyFlag;
    private String replyTag;
    private ChallengeComment replyTarget;
    private final Resources resources;
    private final v2 utilities;

    class a extends h.a {

        final /* synthetic */ d a;
        a() {
            this.a = dVar;
            super();
        }

        @Override // androidx.databinding.h$a
        public void d(h hVar, int i) {
            if (this.a.replyFlag) {
                if (!(String)this.a.commentField.d().startsWith(this.a.replyTag)) {
                    this.a.removeReplyTag();
                }
            }
            this.a.notifyPropertyChanged(42);
            this.a.notifyPropertyChanged(154);
        }
    }
    public d() {
        this(App.p(), App.onCreate().getResources());
    }

    static /* synthetic */ boolean access$000(d dVar) {
        return dVar.replyFlag;
    }

    static /* synthetic */ String access$100(d dVar) {
        return dVar.replyTag;
    }

    static /* synthetic */ void access$200(d dVar) {
        dVar.removeReplyTag();
    }

    private /* synthetic */ boolean d(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null && i == 4) {
            sendSetup(textView);
            return true;
        }
        return false;
    }

    private void removeReplyTag() {
        this.replyFlag = false;
        String str = "";
        this.replyTag = str;
        this.replyTarget = null;
        this.commentField.e(str);
    }

    private void sendSetup(TextView textView) {
        if (!isCommentBoxEmpty()) {
            onSendActionListener((String)this.commentField.d().replaceFirst(Pattern.quote(this.replyTag), ""), this.replyTarget);
            textView.onEditorAction(6);
        }
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void addReplyTag(ChallengeComment challengeComment) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "@";
        String dogName = challengeComment.getDogName();
        String str3 = " ";
        str = str2 + dogName + str3;
        this.replyTag = str;
        this.commentField.e(str);
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
    public int getBackgroundColorRes(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getColor(2131100379, null);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getCursorPosition() {
        return (String)this.commentField.d().length();
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public TextView.OnEditorActionListener getEditorActionListener() {
        return new app.dogo.com.dogo_android.util.interfaces.b(this);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getTextColorRes(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getColor(2131099697, null);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public float getTextSize() throws android.content.res.Resources.NotFoundException {
        float dimension;
        Object obj = this.commentField.d();
        if (obj != null && !obj.isEmpty()) {
            if (this.utilities.n(obj)) {
                int i = 2131165289;
                dimension = this.resources.getDimension(i);
            } else {
                i = 2131165293;
                dimension = this.resources.getDimension(i);
            }
        }
        return dimension;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentBoxEmpty() {
        return (String)this.commentField.d().replaceFirst(Pattern.quote(this.replyTag), "").isEmpty();
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void onSendClick(EditText editText) {
        if (isCommentLabelVisible()) {
            onCommentsLabelClick();
        } else {
            sendSetup(editText);
        }
    }

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

    public d(v2 v2Var, Resources resources) {
        super();
        String str = "";
        final i iVar = new i(str);
        this.commentField = iVar;
        this.replyTag = str;
        this.replyFlag = false;
        this.utilities = v2Var;
        this.resources = resources;
        iVar.addOnPropertyChangedCallback(new app.dogo.com.dogo_android.util.interfaces.d.a(this));
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public /* synthetic */ boolean e(TextView textView, int i, KeyEvent keyEvent) {
        return d(textView, i, keyEvent);
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public int getCommentCount() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public String getCommentCountString() {
        return "";
    }

    @Deprecated
    @Override // app.dogo.com.dogo_android.util.k0.g
    public String getTitle() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract Uri getUserDogIcon();

    @Deprecated
    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isBackVisible() {
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentBordersVisible() {
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public boolean isCommentLabelVisible() {
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract boolean isUserPremiumBadgeVisible();

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract void onAvatarClick();

    @Deprecated
    @Override // app.dogo.com.dogo_android.util.k0.g
    public void onBack() {
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public void onCommentsLabelClick() {
    }

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract void onSendActionListener(String str, ChallengeComment challengeComment);

    @Override // app.dogo.com.dogo_android.util.k0.g
    public abstract boolean permissionCheck();
}
