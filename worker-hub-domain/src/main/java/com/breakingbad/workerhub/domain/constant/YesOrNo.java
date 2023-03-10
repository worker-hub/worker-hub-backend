package com.breakingbad.workerhub.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum YesOrNo {

    Y("Y", "YES"),

    N("N", "NO");

    private final String code;

    private final String value;
}
