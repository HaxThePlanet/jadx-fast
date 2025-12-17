package zendesk.support.guide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import com.zendesk.service.a;
import com.zendesk.service.f;
import d.h.l.u;
import f.g.b.a.a;
import f.g.b.a.b;
import f.g.b.a.c;
import f.g.b.a.d;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.h;
import f.g.c.a;
import zendesk.commonui.d;
import zendesk.support.ArticleVote;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
class ArticleVotingView extends RelativeLayout {

    private Long articleId;
    private ArticleVote articleVote;
    private ArticleVoteStorage articleVoteStorage;
    private ImageButton downvoteButton;
    private ViewGroup downvoteButtonFrame;
    private HelpCenterProvider helpCenterProvider;
    private ImageButton upvoteButton;
    private ViewGroup upvoteButtonFrame;

    private static enum VoteState {

        UPVOTED,
        DOWNVOTED,
        NONE;
        static zendesk.support.guide.ArticleVotingView.VoteState fromArticleVote(ArticleVote articleVote) {
            Integer value;
            if (articleVote != null) {
                if (articleVote.getValue() == null) {
                } else {
                    int obj1 = articleVote.getValue().intValue();
                    if (obj1 > 0) {
                        return ArticleVotingView.VoteState.UPVOTED;
                    }
                    if (obj1 < 0) {
                        return ArticleVotingView.VoteState.DOWNVOTED;
                    }
                }
                return ArticleVotingView.VoteState.NONE;
            }
            return ArticleVotingView.VoteState.NONE;
        }
    }
    public ArticleVotingView(Context context) {
        super(context);
        setupViews(context);
    }

    public ArticleVotingView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        setupViews(context);
    }

    public ArticleVotingView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        setupViews(context);
    }

    static void access$000(zendesk.support.guide.ArticleVotingView articleVotingView, boolean z2) {
        articleVotingView.setVotingButtonsClickable(z2);
    }

    static ArticleVote access$100(zendesk.support.guide.ArticleVotingView articleVotingView) {
        return articleVotingView.articleVote;
    }

    static ArticleVote access$102(zendesk.support.guide.ArticleVotingView articleVotingView, ArticleVote articleVote2) {
        articleVotingView.articleVote = articleVote2;
        return articleVote2;
    }

    static void access$200(zendesk.support.guide.ArticleVotingView articleVotingView) {
        articleVotingView.removeVote();
    }

    static void access$300(zendesk.support.guide.ArticleVotingView articleVotingView) {
        articleVotingView.upvoteArticle();
    }

    static void access$400(zendesk.support.guide.ArticleVotingView articleVotingView, zendesk.support.guide.ArticleVotingView.VoteState articleVotingView$VoteState2) {
        articleVotingView.updateButtons(voteState2);
    }

    static void access$500(zendesk.support.guide.ArticleVotingView articleVotingView) {
        articleVotingView.downvoteArticle();
    }

    static Long access$600(zendesk.support.guide.ArticleVotingView articleVotingView) {
        return articleVotingView.articleId;
    }

    static ArticleVoteStorage access$700(zendesk.support.guide.ArticleVotingView articleVotingView) {
        return articleVotingView.articleVoteStorage;
    }

    private GradientDrawable buildButtonBackground(Context context, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float)dimensionPixelSize);
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(context.getResources().getDimensionPixelSize(c.b), a.d(context, b.c));
        return gradientDrawable;
    }

    private ColorStateList colorStateList(int i, int i2) {
        int i3 = 3;
        final int[][] iArr2 = new int[i3];
        final int i4 = 1;
        int[] iArr3 = new int[i4];
        final int i8 = 0;
        iArr3[i8] = 16843518;
        iArr2[i8] = iArr3;
        int[] iArr4 = new int[i4];
        iArr4[i8] = 16842919;
        iArr2[i4] = iArr4;
        int i7 = 2;
        iArr2[i7] = new int[i8];
        int[] iArr = new int[i3];
        iArr[i8] = i;
        iArr[i4] = i;
        iArr[i7] = i2;
        ColorStateList obj7 = new ColorStateList(iArr2, iArr);
        return obj7;
    }

    private void downvoteArticle() {
        int i;
        String str = "ViewArticleActivity";
        int i2 = 0;
        if (this.articleId == null) {
            a.k(str, "Cannot downvote article, articleId is null. Make sure you've called bindTo()!", new Object[i2]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hcp == null -> ");
        i = this.helpCenterProvider == null ? 1 : i2;
        stringBuilder.append(i);
        a.e(str, stringBuilder.toString(), new Object[i2]);
        ArticleVotingView.4 anon = new ArticleVotingView.4(this);
        this.helpCenterProvider.downvoteArticle(this.articleId, anon);
    }

    private StateListDrawable getVotingButtonBackground(int i) {
        GradientDrawable obj7 = buildButtonBackground(getContext(), i);
        StateListDrawable stateListDrawable = new StateListDrawable();
        int i3 = 1;
        int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 16843518;
        stateListDrawable.addState(iArr2, obj7);
        int[] iArr = new int[i3];
        iArr[i6] = 16842919;
        stateListDrawable.addState(iArr, obj7);
        stateListDrawable.addState(new int[i6], buildButtonBackground(getContext(), -1));
        return stateListDrawable;
    }

    private void removeVote() {
        Object helpCenterProvider;
        Long num;
        zendesk.support.guide.ArticleVotingView.5 anon;
        if (this.articleId == null) {
            a.k("ViewArticleActivity", "Article vote was null, could not remove vote", new Object[0]);
        }
        if (this.articleVote.getId() != null) {
            anon = new ArticleVotingView.5(this);
            this.helpCenterProvider.deleteVote(this.articleVote.getId(), anon);
        }
    }

    private void setVotingButtonsClickable(boolean z) {
        this.upvoteButton.setClickable(z);
        this.downvoteButton.setClickable(z);
    }

    private void setupViews(Context context) {
        LayoutInflater.from(context).inflate(f.m, this);
        this.upvoteButtonFrame = (ViewGroup)findViewById(e.t);
        this.upvoteButton = (ImageButton)findViewById(e.s);
        this.downvoteButtonFrame = (ViewGroup)findViewById(e.f);
        this.downvoteButton = (ImageButton)findViewById(e.e);
        int obj3 = d.e(a.a, getContext(), b.a);
        themeVotingButton(this.upvoteButton, d.d, obj3);
        themeVotingButton(this.downvoteButton, d.c, obj3);
        ArticleVotingView.1 anon = new ArticleVotingView.1(this);
        this.upvoteButton.setOnClickListener(anon);
        ArticleVotingView.2 anon2 = new ArticleVotingView.2(this);
        this.downvoteButton.setOnClickListener(anon2);
    }

    private void themeVotingButton(ImageButton imageButton, int i2, int i3) {
        u.o0(imageButton, getVotingButtonBackground(i3));
        android.graphics.drawable.Drawable obj3 = a.r(a.f(getContext(), i2));
        a.o(obj3, colorStateList(-1, i3));
        a.p(obj3, PorterDuff.Mode.SRC_IN);
        imageButton.setImageDrawable(obj3);
    }

    private void updateButtons(zendesk.support.guide.ArticleVotingView.VoteState articleVotingView$VoteState) {
        Object downvoteButtonFrame;
        int i;
        final int i2 = 0;
        if (voteState == ArticleVotingView.VoteState.NONE) {
            this.upvoteButtonFrame.setActivated(i2);
            this.downvoteButtonFrame.setActivated(i2);
        } else {
            i = 1;
            if (voteState == ArticleVotingView.VoteState.UPVOTED) {
                this.upvoteButtonFrame.setActivated(i);
                this.downvoteButtonFrame.setActivated(i2);
            } else {
                if (voteState == ArticleVotingView.VoteState.DOWNVOTED) {
                    this.upvoteButtonFrame.setActivated(i2);
                    this.downvoteButtonFrame.setActivated(i);
                }
            }
        }
        updateContentDesc(voteState);
    }

    private void updateContentDesc(zendesk.support.guide.ArticleVotingView.VoteState articleVotingView$VoteState) {
        String string;
        int str;
        ImageButton obj3;
        obj3 = ArticleVotingView.6.$SwitchMap$zendesk$support$guide$ArticleVotingView$VoteState[voteState.ordinal()];
        if (obj3 != 1) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    a.b("ViewArticleActivity", "Unhandled voteState case", new Object[0]);
                } else {
                    this.upvoteButton.setContentDescription(getResources().getString(h.r));
                    this.downvoteButton.setContentDescription(getResources().getString(h.s));
                }
            } else {
                this.upvoteButton.setContentDescription(getResources().getString(h.q));
                this.downvoteButton.setContentDescription(getResources().getString(h.p));
            }
        } else {
            this.upvoteButton.setContentDescription(getResources().getString(h.r));
            this.downvoteButton.setContentDescription(getResources().getString(h.p));
        }
    }

    private void upvoteArticle() {
        Long articleId = this.articleId;
        if (articleId == null) {
            a.k("ViewArticleActivity", "Cannot upvote article, articleId is null. Make sure you've called bindTo()!", new Object[0]);
        }
        ArticleVotingView.3 anon = new ArticleVotingView.3(this);
        this.helpCenterProvider.upvoteArticle(articleId, anon);
    }

    @Override // android.widget.RelativeLayout
    public void bindTo(Long long, ArticleVoteStorage articleVoteStorage2, HelpCenterProvider helpCenterProvider3) {
        Object obj1;
        this.articleVoteStorage = articleVoteStorage2;
        this.helpCenterProvider = helpCenterProvider3;
        this.articleId = long;
        if (long != null) {
            obj1 = articleVoteStorage2.getStoredArticleVote(long);
            this.articleVote = obj1;
            updateButtons(ArticleVotingView.VoteState.fromArticleVote(obj1));
        }
    }
}
