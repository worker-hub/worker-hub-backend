package com.breakingbad.workerhub.domain.component;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Embeddable
public class GroupCodeId implements Serializable {

    @JoinColumn(name = "group_code")
    private String groupCode;

    @Column(name = "code")
    private String code;

}
