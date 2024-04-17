package ru.rtk.service.sqlserverquerytool.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import java.sql.Date;

/**
 * Задача
 *
 * @author rnikonov
 */
@Entity
@Getter
@Table(name = "Task", schema = "dob", catalog = "MOP")
public class Task {
    /**
     * идентификатор задачи
     */
    @Basic
    @Column(name = "taskId")
    private int taskId;

    /**
     * идентификатор описания задачи
     */
    @Basic
    @Column(name = "taskDescriptionId")
    private Integer taskDescriptionId;

    /**
     * Код типа задачи
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cipher")
    private String cipher;

    /**
     * Полный номер задачи
     */
    @Basic
    @Column(name = "arrangementCode")
    private String arrangementCode;

    /**
     * Номер документа к задаче
     */
    @Basic
    @Column(name = "serialNumber")
    private String serialNumber;

    /**
     * Год задачи
     */
    @Basic
    @Column(name = "year")
    private String year;

    /**
     * Идентификатор состояния задачи
     */
    @Basic
    @Column(name = "state")
    private int state;

    /**
     * Дата удаления задачи
     */
    @Basic
    @Column(name = "deleteDate")
    private Date deleteDate;

    /**
     * Дата создания задачи
     */
    @Basic
    @Column(name = "createDate")
    private Date createDate;

    /**
     * Среда выполнения задачи
     */
    @Basic
    @Column(name = "subsystem")
    private String subsystem;

    /**
     * Срок действия задачи
     */
    @Basic
    @Column(name = "taskSrok")
    private Integer taskSrok;

    /**
     * Цель задачи
     */
    @Basic
    @Column(name = "target")
    private String target;

    /**
     * Категория задачи
     */
    @Basic
    @Column(name = "category")
    private String category;

    /**
     * Примечание к задаче
     */
    @Basic
    @Column(name = "note")
    private String note;

    /**
     * Причина невыполнения задачи
     */
    @Basic
    @Column(name = "failReason")
    private String failReason;

    /**
     * Срок хранения результата задачи
     */
    @Basic
    @Column(name = "saveCountDay")
    private Integer saveCountDay;

    /**
     * Идентификатор пользователя создавшего задачу
     */
    @Basic
    @Column(name = "creator")
    private Integer creator;

    /**
     * Дата постановки задачи
     */
    @Basic
    @Column(name = "setOffDate")
    private Date setOffDate;
}
