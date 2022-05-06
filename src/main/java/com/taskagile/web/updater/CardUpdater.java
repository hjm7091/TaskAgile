package com.taskagile.web.updater;

import com.taskagile.domain.application.commands.ChangeCardPositionsCommand;
import com.taskagile.domain.application.utils.JsonUtils;
import com.taskagile.domain.model.board.BoardId;
import com.taskagile.domain.model.card.Card;
import com.taskagile.domain.model.card.CardPosition;
import com.taskagile.web.socket.SubscriptionHub;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CardUpdater {

    public void onCardAdded(BoardId boardId, Card card) {
        Map<String, Object> cardData = new HashMap<>();
        cardData.put("id", card.getId().value());
        cardData.put("title", card.getTitle());
        cardData.put("cardListId", card.getCardListId().value());
        cardData.put("position", card.getPosition());

        Map<String, Object> update = new HashMap<>();
        update.put("type", "cardAdded");
        update.put("card", cardData);

        SubscriptionHub.send("/board/" + boardId.value(), JsonUtils.toJson(update));
    }

    public void onCardPositionChanged(ChangeCardPositionsCommand changeCardPositionsCommand) {
        Map<String, Object> update = new HashMap<>();
        update.put("type", "cardPositionChanged");
        update.put("cardPositions", changeCardPositionsCommand.getCardPositions()
                .stream().map(CardPosition::toDto).collect(Collectors.toList()));
        update.put("positionHistory", changeCardPositionsCommand.getCardPositionHistory());

        BoardId boardId = changeCardPositionsCommand.getBoardId();
        SubscriptionHub.send("/board/" + boardId.value(), JsonUtils.toJson(update));
    }

}
