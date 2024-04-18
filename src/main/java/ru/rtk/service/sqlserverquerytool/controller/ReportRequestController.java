package ru.rtk.service.sqlserverquerytool.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rtk.service.sqlserverquerytool.dto.Job;
import ru.rtk.service.sqlserverquerytool.repository.TaskDescriptionRepository;
import ru.rtk.service.sqlserverquerytool.repository.TaskRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер обработки REST запросов
 *
 * @author rnikonov
 */
@RestController
@RequestMapping("/api/report")
@Slf4j
@RequiredArgsConstructor
public class ReportRequestController {

    private final TaskRepository taskRepository;

    private final TaskDescriptionRepository taskDescriptionRepository;

    /**
     * Метод получение данных для формирования журнала работ
     *
     * @param body тело запроса
     * @return Список работ
     */
    @PostMapping("/journal/manual")
    public ArrayList<Job> exportManualJournalData(@RequestBody String body) {
        var params = body.split("#");
        var result = new ArrayList<Job>();

        var objectMapper = new ObjectMapper();

        for (var entity : taskRepository.findByCodeEndDate(
                List.of(params[0].replace(" ", "").split(",")),
                params[1],
                params[2])
        ) {
            result.add(objectMapper.convertValue(entity, Job.class));
        }

        return result;
    }

    /**
     * Метод получения общих сведений по работам
     *
     * @param body тело запроса
     * @return список работ
     */
    @PostMapping("/event")
    public List<Job> exportEventData(@RequestBody String body) {
        var params = body.split("#");
        var objectMapper = new ObjectMapper();

        return taskRepository.findTaskData(
                List.of(params[0].replace(" ", "").split(",")),
                params[1]
        ).stream().map(j -> objectMapper.convertValue(j, Job.class)).collect(Collectors.toList());
    }

    /**
     * Метод удаления примечания к задаче
     *
     * @param body тело запроса
     */
    @PostMapping("/note/delete")
    public void deleteCredit(@RequestBody String body) {
        var param = body.split("#");

        var dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        taskRepository.updateTaskCreateDateByTaskId(
                Date.valueOf(LocalDate.parse(param[1], dateFormat)),
                Integer.parseInt(param[0])
        );

        taskDescriptionRepository.updateSpecialNoteByDescriptionId(
                "",
                taskRepository.findByTaskId(Integer.parseInt(param[0])).getTaskDescriptionId()
        );
    }
}
