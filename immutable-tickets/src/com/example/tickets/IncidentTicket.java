package com.example.tickets;

import java.util.*;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE): - mutable fields - multiple constructors -
 * public setters - tags list can be modified from outside - validation is
 * scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public final class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;
    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;         // e.g. "CLI", "WEBHOOK", "EMAIL"

    public IncidentTicket(Builder b) {
        this.id = b.id;
        this.reporterEmail = b.reporterEmail;
        this.title = b.title;
        this.description = b.description;
        this.priority = b.priority;
         this.tags = List.copyOf(b.tags);
        this.assigneeEmail = b.assigneeEmail;
        this.customerVisible = b.customerVisible;
        this.slaMinutes = b.slaMinutes;
        this.source = b.source;

    }

    public static class Builder {

        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority = "MEDIUM";   // LOW, MEDIUM, HIGH, CRITICAL
        private List<String> tags =  new ArrayList<>();
        private String assigneeEmail;
        private boolean customerVisible =false;
        private Integer slaMinutes;    // optional
        private String source = "CLI";

      
        

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setReporterEmail(String reporterEmail) {
            this.reporterEmail = reporterEmail;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder setTags(List<String> tags) {
            this.tags = new ArrayList<>(tags);
            return this;
        } // BROKEN: retains external reference

        public Builder setAssigneeEmail(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }

        public Builder setCustomerVisible(boolean customerVisible) {
            this.customerVisible = customerVisible;
            return this;
        }

        public Builder setSlaMinutes(Integer slaMinutes) {
            this.slaMinutes = slaMinutes;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public IncidentTicket build() {
            Validation.requireTicketId(id);
            Validation.requiredTitle(title);
            return new IncidentTicket(this);
        }
        public Builder fromBuilder(IncidentTicket t){
            return new Builder().setId(t.id).
            setAssigneeEmail(t.assigneeEmail).
            setCustomerVisible(t.customerVisible)
            .setDescription(t.description)
            .setPriority(t.priority)
            .setReporterEmail(t.reporterEmail)
            .setSlaMinutes(t.slaMinutes)
            .setSource(t.source)
            .setTags(t.tags)
            .setTitle(t.title);
         
        }

    }

    // Getters
    public String getId() {
        return id;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    } // BROKEN: leaks internal list

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public boolean isCustomerVisible() {
        return customerVisible;
    }

    public Integer getSlaMinutes() {
        return slaMinutes;
    }

    public String getSource() {
        return source;
    }

    // Setters (BROKEN: should not exist after refactor)
    @Override
    public String toString() {
        return "IncidentTicket{"
                + "id='" + id + '\''
                + ", reporterEmail='" + reporterEmail + '\''
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", priority='" + priority + '\''
                + ", tags=" + tags
                + ", assigneeEmail='" + assigneeEmail + '\''
                + ", customerVisible=" + customerVisible
                + ", slaMinutes=" + slaMinutes
                + ", source='" + source + '\''
                + '}';
    }
}
