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
    @Basic
    @Column(name = "taskId")
    private int taskId;
    @Basic
    @Column(name = "jobDescriptionId")
    private Integer taskDescriptionId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cipher")
    private String cipher;
    @Basic
    @Column(name = "arrangementCode")
    private String arrangementCode;
    @Basic
    @Column(name = "serialNumber")
    private String serialNumber;
    @Basic
    @Column(name = "year")
    private String year;
    @Basic
    @Column(name = "state")
    private int state;
    @Basic
    @Column(name = "jack")
    private Integer jack;
    @Basic
    @Column(name = "deleteDate")
    private Date deleteDate;
    @Basic
    @Column(name = "createDate")
    private Date createDate;
    @Basic
    @Column(name = "subsystem")
    private String subsystem;
    @Basic
    @Column(name = "taskSrok")
    private Integer taskSrok;
    @Basic
    @Column(name = "target")
    private String target;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "failReason")
    private String failReason;
    @Basic
    @Column(name = "arrangementView")
    private String arrangementView;
    @Basic
    @Column(name = "saveReason")
    private String saveReason;
    @Basic
    @Column(name = "saveCountDay")
    private Integer saveCountDay;
    @Basic
    @Column(name = "creator")
    private Integer creator;
    @Basic
    @Column(name = "setOffDate")
    private Date setOffDate;
    @Basic
    @Column(name = "rowVer", columnDefinition = "timestamp")
    private String rowVer;
}
