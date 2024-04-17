package ru.rtk.service.sqlserverquerytool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rtk.service.sqlserverquerytool.domain.Task;

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
}
