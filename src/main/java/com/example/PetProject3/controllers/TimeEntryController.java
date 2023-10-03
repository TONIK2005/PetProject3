package com.example.PetProject3.controllers;

import com.example.PetProject3.models.TimeEntry;
import com.example.PetProject3.services.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    @Autowired
    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @GetMapping
    public String getAllTimeEntry(Model model) {
        List<TimeEntry> timeEntries = timeEntryService.getAllTimeEntries();
        model.addAttribute("timeEntries", timeEntries);
        return "employee/timeEntry/list";
    }

    @GetMapping("/{id}")
    public String getTimeEntryById(@PathVariable int id, Model model) {
        Optional<TimeEntry> timeEntry = timeEntryService.getTimeEntryById(id);
        if (timeEntry.isPresent()) {
            model.addAttribute("timeEntry", timeEntry.get());
            return "employee/timeEntry/detalis";
        } else {
            return "employee/timeEntry/not-found";
        }
    }

    @GetMapping("/create")
    public String showCreateTimeEntryForm(Model model) {
        model.addAttribute("timeEntry", new TimeEntry());
        return "employee/timeEntry/form";
    }

    @PostMapping("/create")
    public String createTimeEntry(@ModelAttribute TimeEntry timeEntry) {
        timeEntryService.createTimeEntry(timeEntry);
        return "redirect:/time-entries";
    }

    @GetMapping("/edit/{id}")
    public String showEditTimeEntryFrom(@PathVariable int id, Model model) {
        Optional<TimeEntry> timeEntry = timeEntryService.getTimeEntryById(id);
        if (timeEntry.isPresent()) {
            model.addAttribute("timeEntry", timeEntry.get());
            return "employee/timeEntry/edit-form";
        } else {
            return "employee/timeEntry/not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTimeEntry(@PathVariable int id, @ModelAttribute TimeEntry timeEntry) {
        timeEntryService.updateTimeEntry(id, timeEntry);
        return "redirect:/time-entries";
    }

    @GetMapping("/delete/{id}")
    public String deleteTimeEntry(@PathVariable int id) {
        timeEntryService.deleteTimeEntry(id);
        return "redirect:/time-entries";
    }
}
