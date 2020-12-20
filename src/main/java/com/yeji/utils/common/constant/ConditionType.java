package com.yeji.utils.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public enum ConditionType {
    eq,
    notEqual,
    like,
    notLike,
    contains,
    startsWith,
    endsWith,
    in,
    notIn,
    isNull,
    isNotNull,
    between,
    notBetween,
    ne,
    lt,
    le,
    ge,
    lessThan,
    lessOrEqual,
    greaterThan,
    greaterOrEqual,
    isTrue,
    isFalse;
}
