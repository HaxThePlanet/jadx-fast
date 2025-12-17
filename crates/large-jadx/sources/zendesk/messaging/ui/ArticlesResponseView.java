package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;
import zendesk.messaging.R.string;

/* loaded from: classes3.dex */
public class ArticlesResponseView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.ArticlesResponseView.State> {

    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private View firstArticleSuggestion;
    private TextView header;
    private View labelContainer;
    private TextView labelField;
    private View secondArticleSuggestion;
    private View thirdArticleSuggestion;

    static class ArticleSuggestionViewState {

        private final zendesk.messaging.ui.OnArticleSuggestionSelectionListener onArticleSuggestionSelectionListener;
        private final String snippet;
        private final String title;
        ArticleSuggestionViewState(String string, String string2, zendesk.messaging.ui.OnArticleSuggestionSelectionListener onArticleSuggestionSelectionListener3) {
            super();
            this.title = string;
            this.snippet = string2;
            this.onArticleSuggestionSelectionListener = onArticleSuggestionSelectionListener3;
        }

        zendesk.messaging.ui.OnArticleSuggestionSelectionListener getOnArticleSuggestionSelectionListener() {
            return this.onArticleSuggestionSelectionListener;
        }

        String getSnippet() {
            return this.snippet;
        }

        String getTitle() {
            return this.title;
        }
    }

    public static class State {

        private final List<zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState> articleSuggestionViewStates;
        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean isBot;
        private final String label;
        private final zendesk.messaging.ui.MessagingCellProps props;
        public State(String string, boolean z2, zendesk.messaging.ui.MessagingCellProps messagingCellProps3, List<zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState> list4, zendesk.messaging.ui.AvatarState avatarState5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
            super();
            this.label = string;
            this.isBot = z2;
            this.props = messagingCellProps3;
            this.articleSuggestionViewStates = list4;
            this.avatarState = avatarState5;
            this.avatarStateRenderer = avatarStateRenderer6;
        }

        List<zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState> getArticleSuggestionViewStates() {
            return this.articleSuggestionViewStates;
        }

        zendesk.messaging.ui.AvatarState getAvatarState() {
            return this.avatarState;
        }

        public zendesk.messaging.ui.AvatarStateRenderer getAvatarStateRenderer() {
            return this.avatarStateRenderer;
        }

        zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState getFirstArticleSuggestionViewState() {
            Object obj;
            int i;
            if (this.articleSuggestionViewStates.size() >= 1) {
                obj = this.articleSuggestionViewStates.get(0);
            } else {
                obj = 0;
            }
            return obj;
        }

        int getHeaderText() {
            int zui_cell_text_suggested_article_header;
            zui_cell_text_suggested_article_header = this.articleSuggestionViewStates.size() == 1 ? R.string.zui_cell_text_suggested_article_header : R.string.zui_cell_text_suggested_articles_header;
            return zui_cell_text_suggested_article_header;
        }

        String getLabel() {
            return this.label;
        }

        zendesk.messaging.ui.MessagingCellProps getProps() {
            return this.props;
        }

        zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState getSecondArticleSuggestionViewState() {
            Object obj;
            int i;
            if (this.articleSuggestionViewStates.size() >= 2) {
                obj = this.articleSuggestionViewStates.get(1);
            } else {
                obj = 0;
            }
            return obj;
        }

        zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState getThirdArticleSuggestionViewState() {
            Object obj;
            int i;
            if (this.articleSuggestionViewStates.size() >= 3) {
                obj = this.articleSuggestionViewStates.get(2);
            } else {
                obj = 0;
            }
            return obj;
        }

        boolean isBot() {
            return this.isBot;
        }
    }
    public ArticlesResponseView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void bindArticleSuggestion(zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState articlesResponseView$ArticleSuggestionViewState, View view2) {
        int i;
        i = articleSuggestionViewState != null ? 0 : 8;
        view2.setVisibility(i);
        if (articleSuggestionViewState == null) {
        }
        ArticlesResponseView.1 anon = new ArticlesResponseView.1(this, articleSuggestionViewState);
        (TextView)view2.findViewById(R.id.zui_article_title).setText(articleSuggestionViewState.getTitle());
        (TextView)view2.findViewById(R.id.zui_article_snippet).setText(articleSuggestionViewState.getSnippet());
        view2.setOnClickListener(anon);
    }

    private void init() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.zui_view_articles_response_content, this);
    }

    private void setSuggestionBackgrounds(List<zendesk.messaging.ui.ArticlesResponseView.ArticleSuggestionViewState> list) {
        View thirdArticleSuggestion;
        int zui_background_cell_options_footer;
        int i;
        View[] arr = new View[3];
        int i4 = 1;
        arr[i4] = this.secondArticleSuggestion;
        arr[2] = this.thirdArticleSuggestion;
        ArrayList arrayList = new ArrayList(Arrays.asList(arr));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            thirdArticleSuggestion = iterator.next();
            if (arrayList.indexOf((View)thirdArticleSuggestion) == size -= i4) {
            } else {
            }
            thirdArticleSuggestion.setBackgroundResource(R.drawable.zui_background_cell_options_content);
            thirdArticleSuggestion.setBackgroundResource(R.drawable.zui_background_cell_options_footer);
        }
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.header = (TextView)findViewById(R.id.zui_header_article_suggestions);
        this.firstArticleSuggestion = findViewById(R.id.zui_first_article_suggestion);
        this.secondArticleSuggestion = findViewById(R.id.zui_second_article_suggestion);
        this.thirdArticleSuggestion = findViewById(R.id.zui_third_article_suggestion);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((ArticlesResponseView.State)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.ArticlesResponseView.State articlesResponseView$State) {
        int i;
        this.labelField.setText(state.getLabel());
        i = state.isBot() ? 0 : 8;
        this.botLabel.setVisibility(i);
        state.getAvatarStateRenderer().render(state.getAvatarState(), this.avatarView);
        state.getProps().apply(this, this.labelContainer, this.avatarView);
        this.header.setText(state.getHeaderText());
        bindArticleSuggestion(state.getFirstArticleSuggestionViewState(), this.firstArticleSuggestion);
        bindArticleSuggestion(state.getSecondArticleSuggestionViewState(), this.secondArticleSuggestion);
        bindArticleSuggestion(state.getThirdArticleSuggestionViewState(), this.thirdArticleSuggestion);
        setSuggestionBackgrounds(state.getArticleSuggestionViewStates());
    }
}
