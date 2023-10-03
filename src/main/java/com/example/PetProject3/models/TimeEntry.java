package com.example.PetProject3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "time_entries")
public class TimeEntry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "comment")
    private String comment;

    public TimeEntry updateFrom(TimeEntry updatedTimeEntry) {
        this.employee = updatedTimeEntry.getEmployee();
        this.entryDate = updatedTimeEntry.getEntryDate();
        this.startTime = updatedTimeEntry.getStartTime();
        this.endTime = updatedTimeEntry.getEndTime();
        this.comment = updatedTimeEntry.getComment();
        return this;
    }
}
