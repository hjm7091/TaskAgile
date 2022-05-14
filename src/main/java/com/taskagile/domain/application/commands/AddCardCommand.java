package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.cardlist.CardListId;
import lombok.Getter;

@Getter
public class AddCardCommand extends UserCommand {

    private final CardListId cardListId;
    private final String title;
    private final int position;

    public AddCardCommand(CardListId cardListId, String title, int position) {
        this.cardListId = cardListId;
        this.title = title;
        this.position = position;
    }

}
