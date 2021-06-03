package com.dharshiny.application.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.dharshiny.application.Model.LogModel;
import com.dharshiny.application.Repository.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationController {
    
    @Autowired
    private LogRepository logRepository;

    @GetMapping("/getAllLog")
    public List<LogModel> getAllLog(){
        List<LogModel> logs=new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }

    @GetMapping(value="/checkIn/name={cname}")
    public LogModel checkIn(@PathVariable(value="cname") String cname) {
        String type="IN",date,time;
        LocalDate today = LocalDate.now();
        date=today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalTime now = LocalTime.now();
        time=now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        LogModel log=new LogModel((cname+time),cname,type,date,time);
        return logRepository.save(log);
    }
    
    @GetMapping(value="/checkOut/name={cname}")
    public LogModel checkOut(@PathVariable(value="cname") String cname) {
        String type="OUT",date,time;
        LocalDate today = LocalDate.now();
        date=today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalTime now = LocalTime.now();
        time=now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        LogModel log=new LogModel((cname+time),cname,type,date,time);
        return logRepository.save(log);
    }

    @GetMapping(value="/getLog/date={year}/{month}/{date}")
    public List<LogModel> getLogByDate(@PathVariable(value="year") String year,
        @PathVariable(value="month") String month, @PathVariable(value="date") String date) {
        List<LogModel> logs=new ArrayList<>();
        String ldate=year+"/"+month+"/"+date;
        logRepository.findAll().forEach((log)-> {
            if((ldate).equals(log.getDate())) {
                logs.add(log);
            }});
        return logs;
    }

}
