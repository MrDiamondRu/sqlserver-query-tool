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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "descriptionId", nullable = false)
    private int descriptionId;
    @Basic
    @Column(name = "Jobtype", length = 50)
    private String jobType;
    @Basic
    @Column(name = "Jobname", length = 50)
    private String jobName;
    @Basic
    @Column(name = "Jobnumber", length = 50)
    private String jobNumber;
    @Basic
    @Column(name = "target", length = 2048)
    private String target;
    @Basic
    @Column(name = "caseNumber", length = 50)
    private String caseNumber;
    @Basic
    @Column(name = "specialNote", length = 1024)
    private String specialNote;
    @Basic
    @Column(name = "rowVer", columnDefinition = "timestamp")
    private String rowVer;
}
