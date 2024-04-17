package ru.rtk.service.sqlserverquerytool.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Описание задачи
 *
 * @author rnikonov
 */
@Entity
@Getter
@Setter
@Table(name = "TaskDescription", schema = "dob", catalog = "MOP")
public class TaskDescription {

    /**
     * Идентификатор описания задачи
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "descriptionId", nullable = false)
    private int descriptionId;

    /**
     * Описание задачи
     */
    @Basic
    @Column(name = "specialNote", length = 1024)
    private String specialNote;
}
