package ru.rtk.service.sqlserverquerytool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Работы
 *
 * @author rnikonov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    /**
     * Идентификатор задания
     */
    private Integer taskId;

    /**
     * Код типа задачи
     */
    private String cipher;

    /**
     * Номер документа задачи к работам
     */
    private Integer serialNumber;

    /**
     * Срок действия задачи к работам
     */
    private Integer taskSrok;

    /**
     * Полный номер задачи к работам
     */
    private String arrangementCode;

    /**
     * Дата создания задачи к работам
     */
    private String createDate;

    /**
     * Пользователь создавший задачу к работам
     */
    private Integer creator;

}
