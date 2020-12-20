drop table if exists TB_PRODUCT_MASTER;
drop table if exists TB_PRODUCT_MODIFY_HIST;
drop table if exists TB_PRODUCT_TRADE;

create table TB_PRODUCT_MASTER
(
    ID                    INTEGER auto_increment comment '상품 ID'      primary key,
    GROUP_CODE            varchar(254)                                  not null comment '상품 그룹 코드',
    PRODUCT_NAME          varchar(254)                                  not null comment '상품명',
    PRODUCT_DETAIL_OPTION varchar(254)                                  not null comment '상품 상세 옵션',
    PRICE                 int default 0                                 not null comment '상품 가격',
    IMAGE                 varchar(254)                                  null comment '상품 이미지',
    STOCK                 int default 0                                 not null comment '재고수량',
    DESCRIPTION           text                                          null comment '상품상세 설명',
    IS_DELETED            tinyint(1)   default 0                        not null comment '삭제여부',
    CREATED_ID            varchar(254) default 'ADMIN'                  null comment '생성자',
    CREATED_AT            datetime     default current_timestamp()      null comment '생성일시',
    UPDATED_ID            varchar(254) default 'ADMIN'                  null comment '수정자',
    UPDATED_AT            datetime     default current_timestamp()      null comment '수정일시'
);

comment on table TB_PRODUCT_MASTER is '상품정보 메인 테이블';

create table TB_PRODUCT_MODIFY_HIST
(
    ID                 INTEGER auto_increment comment '상품 히스토리 ID'   primary key,
    PRODUCT_MASTER_ID  int                                                not null comment '상품 ID',
    PRODUCT_NAME       varchar(254)                                       null comment '수정 상품명',
    PRODUCT_DETAIL_OPTION varchar(254)                                    null comment '수정 상품 상세 옵션',
    PRICE              int                                                null comment '수정 가격',
    IMAGE              varchar(254)                                       null comment '수정 이미지',
    STOCK             int                                                 null comment '수정 재고',
    DESCRIPTION           text                                            null comment '상품상세 설명',
    CREATED_ID         varchar(254) default 'ADMIN'                       null comment '생성자',
    CREATED_AT         datetime     default current_timestamp()           null comment '생성일시'
);

comment on table TB_PRODUCT_MODIFY_HIST is '상품정보 수정 히스토리 테이블';

create table TB_PRODUCT_TRADE
(
    ID                  INTEGER auto_increment comment '상품 주문정보 ID'   primary key,
    PRODUCT_MASTER_ID   int                                                not null comment '상품 ID',
    AMOUNT              int                                                not null comment '주문 수량',
    TOTAL_PRICE         int                                                not null comment '총 주문금액',
    CUSTOMER_NAME       varchar(254)                                       not null comment '구매자명',
    CUSTOMER_PHONE_NUM  varchar(254)                                       not null comment '구매자 연락처',
    IS_DELETED          tinyint(1)   default 0                             not null comment '삭제여부',
    CREATED_ID          varchar(254) default 'ADMIN'                       null comment '생성자',
    CREATED_AT          datetime     default current_timestamp()           null comment '생성일시',
    UPDATED_ID          varchar(254) default 'ADMIN'                       null comment '수정자',
    UPDATED_AT          datetime     default current_timestamp()           null comment '수정일시'
);

comment on table TB_PRODUCT_TRADE is '상품 주문정보 테이블';