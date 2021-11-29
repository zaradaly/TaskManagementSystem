package com.mazarraa.tasks_management_system.model;

// import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tasks")
public class TaskModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int t_id;
    @Column
    private String t_name;
    @Column
    private int t_time_spent;
    @Column
    private int t_group;
    @Column
    private int t_assignee;
    @Column
    private int t_parent_id;
    @Column
    // For this example, status 1 = task is running, 0 = task is done
    private int t_status;

    public TaskModel(){
        super();
    //     Random rand = new Random();
    //     this.t_id = rand.nextInt(5000)+1;
    //     // this.t_name = "noname";
    //     // this.t_time_spent = 0;
    //     // this.t_group = 0;
    //     // this.t_assignee = 0;
    //     // this.t_parent_id = 0;
    //     // this.t_status = 0;
    }

    TaskModel(int t_id, String t_name, int t_time_spent, int t_group, int t_assignee, int t_parent_id, int t_status) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_time_spent = t_time_spent;
        this.t_group = t_group;
        this.t_assignee = t_assignee;
        this.t_parent_id = t_parent_id;
        this.t_status = t_status;
    }

    public String toString(){
        return "Task : [t_id=" + t_id + ", t_name=" + t_name + ", t_time_spent=" + t_time_spent + ", t_group=" + t_group + ", t_assignee=" + t_assignee + ", t_parent_id=" + t_parent_id + ", t_status=" + t_status + "]";
    }

    public int get_t_id() {
        return t_id;
    }

    public void set_t_id(int t_id) {
        this.t_id = t_id;
    }

    public String get_t_name() {
        return t_name;
    }

    public void set_t_name(String t_name) {
        this.t_name = t_name;
    }

    public int get_t_time_spent() {
        return t_time_spent;
    }

    public void set_t_time_spent(int t_time_spent) {
        this.t_time_spent = t_time_spent;
    }

    public int get_t_group() {
        return t_group;
    }

    public void set_t_group(int t_group) {
        this.t_group = t_group;
    }

    public int get_t_assignee() {
        return t_assignee;
    }

    public void set_t_assignee(int t_assignee) {
        this.t_assignee = t_assignee;
    }

    public int get_t_parent_id() {
        return t_parent_id;
    }

    public void set_t_parent_id(int t_parent_id) {
        this.t_parent_id = t_parent_id;
    }

    public int get_t_status() {
        return t_status;
    }

    public void set_t_status(int t_status) {
        this.t_status = t_status;
    }

}
