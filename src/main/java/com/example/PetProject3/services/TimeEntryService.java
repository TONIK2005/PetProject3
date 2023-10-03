package com.example.PetProject3.services;

import com.example.PetProject3.models.TimeEntry;
import com.example.PetProject3.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryService(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryRepository.findAll();
    }

    public Optional<TimeEntry> getTimeEntryById(int id) {
        return timeEntryRepository.findById(id);
    }

    public TimeEntry createTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    public TimeEntry updateTimeEntry(int id, TimeEntry updateTimeEntry) {
        return timeEntryRepository.findById(id)
                .map(timeEntry -> timeEntry.updateFrom(updateTimeEntry))
                .orElseThrow(() -> new IllegalArgumentException("TimeEntry not found with id: " + id));
    }

    public void deleteTimeEntry(int id) {
        timeEntryRepository.deleteById(id);
    }
}
