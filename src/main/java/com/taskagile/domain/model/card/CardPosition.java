package com.taskagile.domain.model.card;

import com.taskagile.domain.model.cardlist.CardListId;

public class CardPosition {

    private long cardListId;
    private long cardId;
    private int position;

    public CardListId getCardListId() {
        return new CardListId(cardListId);
    }

    public CardId getCardId() {
        return new CardId(cardId);
    }

    public int getPosition() {
        return position;
    }

    public void setCardListId(long cardListId) {
        this.cardListId = cardListId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public CardPositionDto toDto() {
        return new CardPositionDto(this);
    }

    public static class CardPositionDto {
        private final long cardListId;
        private final long cardId;
        private final int position;

        public CardPositionDto(CardPosition cardPosition) {
            this.cardListId = cardPosition.cardListId;
            this.cardId = cardPosition.cardId;
            this.position = cardPosition.position;
        }

        public long getCardListId() {
            return cardListId;
        }

        public long getCardId() {
            return cardId;
        }

        public int getPosition() {
            return position;
        }
    }

}
