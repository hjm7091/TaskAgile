package com.taskagile.domain.model.card.events;

import com.taskagile.domain.common.event.DomainEvent;
import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.board.BoardId;
import com.taskagile.domain.model.card.CardId;
import lombok.Getter;

@Getter
public class CardDomainEvent extends DomainEvent {

    private static final long serialVersionUID = 8301463735426628027L;

    private final CardId cardId;
    private final String cardTitle;
    private final BoardId boardId;

    public CardDomainEvent(CardId cardId, String cardTitle, BoardId boardId, TriggeredBy triggeredBy) {
        super(triggeredBy);
        this.cardId = cardId;
        this.cardTitle = cardTitle;
        this.boardId = boardId;
    }

}
