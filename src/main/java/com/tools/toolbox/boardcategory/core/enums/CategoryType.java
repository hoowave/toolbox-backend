package com.tools.toolbox.boardcategory.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {
    NOTICE(1L),

    CONTACT(2L);

    private final Long value;
}
