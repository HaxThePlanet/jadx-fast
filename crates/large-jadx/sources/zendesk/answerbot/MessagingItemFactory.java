package zendesk.answerbot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.Engine.TransferOptionDescription;
import zendesk.messaging.MessagingItem.ArticlesResponse;
import zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.MessagingItem.OptionsResponse;
import zendesk.messaging.MessagingItem.TransferResponse;

/* loaded from: classes3.dex */
class MessagingItemFactory {
    static MessagingItem.ArticlesResponse createArticlesReplyCellData(zendesk.answerbot.AnswerBotInteraction.ArticlesReply answerBotInteraction$ArticlesReply, AgentDetails agentDetails2) {
        MessagingItem.ArticlesResponse articlesResponse = new MessagingItem.ArticlesResponse(articlesReply.getDate(), articlesReply.getId(), agentDetails2, MessagingItemFactory.mapToArticleSuggestionState(articlesReply));
        return articlesResponse;
    }

    static MessagingItem.OptionsResponse createResponseOptionCellData(zendesk.answerbot.AnswerBotInteraction.ResponseOption answerBotInteraction$ResponseOption) {
        int size;
        MessagingItem.Option option;
        String str;
        List options = responseOption.getOptions();
        ArrayList arrayList = new ArrayList(options.size());
        Iterator iterator = options.iterator();
        for (String size : iterator) {
            option = new MessagingItem.Option(responseOption.getId(), size);
            arrayList.add(option);
        }
        MessagingItem.OptionsResponse optionsResponse = new MessagingItem.OptionsResponse(responseOption.getDate(), responseOption.getId(), arrayList);
        return optionsResponse;
    }

    static MessagingItem.TransferResponse createTransferOptionsCellData(zendesk.answerbot.AnswerBotInteraction.TransferOptions answerBotInteraction$TransferOptions, AgentDetails agentDetails2, List<Engine.TransferOptionDescription> list3) {
        super(transferOptions.getDate(), transferOptions.getId(), agentDetails2, transferOptions.getHeader(), list3);
        return transferResponse;
    }

    private static List<MessagingItem.ArticlesResponse.ArticleSuggestion> mapToArticleSuggestionState(zendesk.answerbot.AnswerBotInteraction.ArticlesReply answerBotInteraction$ArticlesReply) {
        int size;
        MessagingItem.ArticlesResponse.ArticleSuggestion response;
        String str;
        String htmlUrl;
        long articleId;
        String title;
        String snippet;
        MessagingItem.ArticlesResponse.ArticleSuggestion articleSuggestion;
        List deflectionArticles = articlesReply.getDeflectionArticles();
        ArrayList arrayList = new ArrayList(deflectionArticles.size());
        Iterator iterator = deflectionArticles.iterator();
        for (DeflectionArticle size : iterator) {
            super(articlesReply.getId(), size.getHtmlUrl(), size.getArticleId(), obj7, size.getTitle(), size.getSnippet());
            arrayList.add(articleSuggestion);
        }
        return arrayList;
    }
}
