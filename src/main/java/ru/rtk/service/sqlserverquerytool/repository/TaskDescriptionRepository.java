package ru.rtk.service.sqlserverquerytool.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Интерфейс репозитория для описания задач
 *
 * @author rnikonov
 */
public interface TaskDescriptionRepository {

    /**
     * Метод обновления описания к задаче
     *
     * @param specialNote описание задачи
     * @param descriptionId идентификатор описания задачи
     */
    @Transactional
    @Modifying
    @Query("update TaskDescription j set j.specialNote = ?1 where j.descriptionId = ?2")
    void updateSpecialNoteByDescriptionId(String specialNote, int descriptionId);
}
