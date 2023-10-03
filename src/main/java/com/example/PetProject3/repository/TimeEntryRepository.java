package com.example.PetProject3.repository;

import com.example.PetProject3.models.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Integer> {
}
