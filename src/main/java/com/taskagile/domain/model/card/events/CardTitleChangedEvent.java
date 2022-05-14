package com.taskagile.domain.model.card.events;

import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.card.Card;
import lombok.Getter;

@Getter
public class CardTitleChangedEvent extends CardDomainEvent {

    private static final long serialVersionUID = 26551114425630902L;

    private final String newTitle;
    private final String oldTitle;

    public CardTitleChangedEvent(Card card, String oldTitle, TriggeredBy triggeredBy) {
        super(card.getId(), card.getTitle(), card.getBoardId(), triggeredBy);
        this.newTitle = card.getTitle();
        this.oldTitle = oldTitle;
    }

    @Override
    public String toString() {
        return "CardTitleChangedEvent{" +
                "cardId=" + getCardId() +
                ", newTitle='" + newTitle + '\'' +
                ", oldTitle='" + oldTitle + '\'' +
                '}';
    }

}
