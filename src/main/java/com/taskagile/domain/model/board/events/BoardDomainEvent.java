package com.taskagile.domain.model.board.events;

import com.taskagile.domain.common.event.DomainEvent;
import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.board.BoardId;
import lombok.Getter;

@Getter
public class BoardDomainEvent extends DomainEvent {

    private static final long serialVersionUID = -147308556973863979L;

    private final BoardId boardId;

    public BoardDomainEvent(BoardId boardId, TriggeredBy triggeredBy) {
        super(triggeredBy);
        this.boardId = boardId;
    }

}
