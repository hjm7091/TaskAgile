package com.taskagile.web.payload;

import com.taskagile.domain.application.commands.ChangeCardPositionsCommand;
import com.taskagile.domain.model.board.BoardId;
import com.taskagile.domain.model.card.CardPosition;

import java.util.List;

public class ChangeCardPositionsPayload {

    private long boardId;
    private List<CardPosition> cardPositions;
    private CardPositionHistory cardPositionHistory;

    public ChangeCardPositionsCommand toCommand() {
        return new ChangeCardPositionsCommand(new BoardId(boardId), cardPositions, cardPositionHistory);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardPositions(List<CardPosition> cardPositions) {
        this.cardPositions = cardPositions;
    }

    public void setCardPositionHistory(CardPositionHistory cardPositionHistory) {
        this.cardPositionHistory = cardPositionHistory;
    }

    public static class CardPositionHistory {

        private long fromListId;

        private long toListId;

        private long cardId;

        public long getFromListId() {
            return fromListId;
        }

        public void setFromListId(long fromListId) {
            this.fromListId = fromListId;
        }

        public long getToListId() {
            return toListId;
        }

        public void setToListId(long toListId) {
            this.toListId = toListId;
        }

        public long getCardId() {
            return cardId;
        }

        public void setCardId(long cardId) {
            this.cardId = cardId;
        }
    }
}
