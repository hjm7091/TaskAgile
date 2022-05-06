package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.board.BoardId;
import com.taskagile.domain.model.card.CardPosition;
import com.taskagile.web.payload.ChangeCardPositionsPayload;

import java.util.List;

import static com.taskagile.web.payload.ChangeCardPositionsPayload.*;

public class ChangeCardPositionsCommand {

    private final BoardId boardId;
    private final List<CardPosition> cardPositions;
    private final CardPositionHistory cardPositionHistory;

    public ChangeCardPositionsCommand(BoardId boardId, List<CardPosition> cardPositions, CardPositionHistory cardPositionHistory) {
        this.boardId = boardId;
        this.cardPositions = cardPositions;
        this.cardPositionHistory = cardPositionHistory;
    }

    public BoardId getBoardId() {
        return boardId;
    }

    public List<CardPosition> getCardPositions() {
        return cardPositions;
    }

    public CardPositionHistory getCardPositionHistory() {
        return cardPositionHistory;
    }
}
