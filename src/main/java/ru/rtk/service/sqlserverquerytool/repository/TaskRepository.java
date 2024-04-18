package ru.rtk.service.sqlserverquerytool.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.rtk.service.sqlserverquerytool.domain.Task;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Интерфейс репозитория для задачи
 *
 * @author rnikonov
 */
public interface TaskRepository {

    /**
     * Метод получения задачи по идентификатору
     *
     * @param taskId идентификатор задачи
     * @return задача
     */
    Task findByTaskId(int taskId);

    /**
     * Метод получения списка задач по типу и году создания
     *
     * @param code код типа задачи
     * @param year год задачи
     * @return список наборов номер:задача
     */
    @Query(value = "SELECT " +
            "task.taskId, " +
            "FORMAT(task.createDate, 'yyyy-MM-dd') AS createDate " +
            "FROM MOP.dob.Task as task " +
            "WHERE " +
            "task.year = :year AND task.arrangementCode IN (:code) " +
            "ORDER BY task.taskId;",
            nativeQuery = true)
    List<Map<String,Object>> findTaskData(
            @Param("code") Collection<String> code,
            @Param("year") String year);

    /**
     * Метод отбора задач по типу и дате создания
     *
     * @param code код типа задачи
     * @param dateFrom дата начала периода
     * @param dateEnd дата окончания периода
     * @return список наборов номер:задача
     */
    @Query(value = "SELECT " +
            "task.taskId, " +
            "task.cipher, " +
            "task.taskSrok, " +
            "task.arrangementCode, " +
            "FORMAT(task.createDate, 'dd.MM.yyyy') AS createDate, " +
            "FORMAT(task.setOffDate, 'dd.MM.yyyy') AS setOffDate, " +
            "REPLACE(REPLACE(oper.operatorName, ' ', ''), '0', '') AS creator " +
            "FROM MOP.dob.Task as task LEFT OUTER JOIN " +
            "MOP.dob.Operator AS oper ON task.creator = oper.operatorId " +
            "WHERE (" +
            "task.createDate BETWEEN CAST(:dateFrom AS date) AND CAST(:dateEnd AS date)) AND " +
            "task.arrangementCode IN (:code) " +
            "ORDER BY task.taskId;",
            nativeQuery = true)
    List<Map<String,Object>> findByCodeEndDate(
            @Param("code") Collection<String> code,
            @Param("dateFrom") String dateFrom,
            @Param("dateEnd") String dateEnd);

    /**
     * Метод обновления даты создания работ
     *
     * @param createDate дата создания
     * @param taskId идентификатор задачи
     */
    @Transactional
    @Modifying
    @Query("update Task t set t.createDate = ?1 where t.taskId = ?2")
    void updateTaskCreateDateByTaskId(Date createDate, int taskId);
}
